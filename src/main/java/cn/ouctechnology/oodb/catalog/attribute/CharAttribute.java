package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.dbenum.Type;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-07 12:49
 * @description: TODO
 **/
public class CharAttribute extends Attribute {

    public CharAttribute(String name, int length) {
        super(name, length);
        super.type = Type.CHAR;
    }

    @Override
    public void writeValue(Block block, Object value) {
        block.writeString((String) value, length);
    }

    @Override
    public Object read(Block block) {
        return block.readString(length);
    }

    /**
     * 覆写获取长度
     */
    @Override
    public int getLength() {
        return length * 2;
    }


}
