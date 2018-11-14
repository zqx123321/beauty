package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.dbenum.Type;

import java.io.DataOutputStream;
import java.io.IOException;

import static cn.ouctechnology.oodb.constant.Constants.NOT_FOUND;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 19:35
 * @description: 封装字段类
 **/
public abstract class Attribute {

    protected String name;//字段名称
    protected Type type;//字段类型
    protected int length;//字段长度

    public Attribute(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    /**
     * 获取字段长度，在子类中覆写
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * 将属性信息写入文件，此类在ObjectAttribute中被覆写
     */
    public void writeAttribute(DataOutputStream dos) throws IOException {
        dos.writeInt(type.ordinal());
        dos.writeUTF(name);
        dos.writeInt(length);
    }

    /**
     * 将该属性对应的value写入block中，此方法延迟到子类中实现
     *  @param block
     * @param value
     * @param offset
     */
    public abstract void writeValue(Block block, Object value, int offset);

    /**
     * 在block中读取该属性，此方法延迟到子类中实现
     *
     * @param block
     */
    public abstract Object read(Block block);

    public int getOffset(String attributeName, int offset) {
        if (name.equals(attributeName)) return offset;
        return NOT_FOUND;
    }

    public Attribute getAttribute(String attributeName) {
        if (name.equals(attributeName)) return this;
        return null;
    }
}
