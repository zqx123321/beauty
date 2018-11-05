package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.reocrd.Tuple;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.ouctechnology.oodb.constant.Constants.NOT_FOUND;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 22:57
 * @description: Attribute子类，用于OBJECT类型的属性
 **/
public class ObjectAttribute extends Attribute {
    List<Attribute> innerAttributes;

    public ObjectAttribute(String name, int length, List<Attribute> innerAttributes) {
        super(name, length);
        super.type = Type.OBJECT;
        this.innerAttributes = innerAttributes;
    }

    public List<Attribute> getInnerAttributes() {
        return innerAttributes;
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
        if (valueList.size() != innerAttributes.size())
            throw new IllegalArgumentException("the value count does not match the attributes count,excepted is:" + innerAttributes.size() + ",now is:" + valueList.size());
        for (int i = 0; i < innerAttributes.size(); i++) {
            Object value = valueList.get(i);
            Attribute attribute = innerAttributes.get(i);
            attribute.writeValue(block, value);
        }
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

    @Override
    public Object read(Block block) {
        Map<String, Object> values = new HashMap<>();
        for (Attribute innerAttribute : innerAttributes) {
            values.put(innerAttribute.getName(), innerAttribute.read(block));
        }
        return values;
    }

    @Override
    public void writeAttribute(DataOutputStream dos) throws IOException {
        super.writeAttribute(dos);
        //递归写入innerAttributes
        Catalog.writeAttributes(innerAttributes, dos);
    }

    /**
     * 覆写获取长度
     */
    @Override
    public int getLength() {
        int length = 0;
        for (Attribute innerAttribute : innerAttributes) {
            length += innerAttribute.getLength();
        }
        return length;
    }

    //覆写获取偏移量
    @Override
    public int getOffset(String attributeName, int offset) {
        int superOffset = super.getOffset(attributeName, offset);
        if (superOffset != NOT_FOUND) return superOffset;
        for (Attribute innerAttribute : innerAttributes) {
            int res = innerAttribute.getOffset(attributeName.substring(attributeName.indexOf(".") + 1), offset);
            if (res != NOT_FOUND) return res;
            offset += innerAttribute.getLength();
        }
        return NOT_FOUND;
    }


    //覆写获取偏移量
    @Override
    public Attribute getAttribute(String attributeName) {
        Attribute superAttribute = super.getAttribute(attributeName);
        if (superAttribute != null) return superAttribute;
        for (Attribute innerAttribute : innerAttributes) {
            Attribute resAttribute = innerAttribute.getAttribute(attributeName.substring(attributeName.indexOf(".") + 1));
            if (resAttribute != null) return resAttribute;
        }
        return null;
    }
}
