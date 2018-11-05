package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.OgnlUtil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.NOT_FOUND;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-02 11:43
 * @description: TODO
 **/
public class ListAttribute extends Attribute {

    private Attribute listAttribute;

    private int size;

    public ListAttribute(String name, int length, Attribute listAttribute) {
        super(name, length);
        super.type = Type.LIST;
        this.listAttribute = listAttribute;
        this.size = length / listAttribute.getLength();
    }

    public Attribute getListAttribute() {
        return listAttribute;
    }

    public int getSize() {
        return size;
    }

    @Override
    @SuppressWarnings("all")
    public void writeValue(Block block, Object value) {
        if (value instanceof List) {
            List<Object> valueList = (List<Object>) value;
            writeValueList(block, valueList);
        } else {
            Tuple tuple = (Tuple) value;
            writeValueTuple(block, tuple);
        }
    }

    /**
     * 只有value的顺序式写入
     */
    private void writeValueList(Block block, List<Object> valueList) {
        //没赋值的为默认值
//        if (valueList.size() != size)
//            throw new IllegalArgumentException("the value count does not match the list count,excepted is:" + size + ",now is:" + valueList.size());
        for (Object value : valueList) {
            listAttribute.writeValue(block, value);
        }
    }

    @Override
    public Object read(Block block) {
        List<Object> values = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            values.add(listAttribute.read(block));
        }
        return values;
    }

    /**
     * 有key和value的跳跃式写入
     */
    private void writeValueTuple(Block block, Tuple tuple) {
        //补偿递归产生的额外的offset
        int attributeOffset = Catalog.getAttributeOffset(block.getBlockKey().filename, this.name);
        block.setDataOffset(block.getDataOffset() - attributeOffset);
        tuple.write(block, block.getBlockKey().filename);
    }

    /**
     * 覆写获取长度
     */
    @Override
    public int getLength() {
        return listAttribute.getLength() * size;
    }

    //覆写获取偏移量
    @Override
    public int getOffset(String attributeName, int offset) {
        int superOffset = super.getOffset(attributeName, offset);
        if (superOffset != NOT_FOUND) return superOffset;
        String leftField = OgnlUtil.getLeftField(attributeName);
        try {
            int index = Integer.parseInt(leftField);
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index + "");
            offset += (index) * listAttribute.getLength();
            return offset;
        } catch (IndexOutOfBoundsException e) {
            return NOT_FOUND;
        } catch (Exception e) {
            if (!leftField.contains(".")) return NOT_FOUND;
            try {
                int index = Integer.parseInt(OgnlUtil.getField(leftField, 0));
                if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index + "");
                offset += (index) * listAttribute.getLength();
                return listAttribute.getOffset(OgnlUtil.getLeftField(leftField), offset);
            } catch (Exception ex) {
                return NOT_FOUND;
            }
        }
    }

    //覆写获取属性
    @Override
    public Attribute getAttribute(String attributeName) {
        Attribute superAttribute = super.getAttribute(attributeName);
        if (superAttribute != null) return superAttribute;
        String leftField = OgnlUtil.getLeftField(attributeName);
        try {
            int index = Integer.parseInt(leftField);
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException(index + "");
            return listAttribute;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void writeAttribute(DataOutputStream dos) throws IOException {
        super.writeAttribute(dos);
        listAttribute.writeAttribute(dos);
    }
}
