package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.dbenum.Type;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-07 12:45
 * @description: TODO
 **/
public class IntAttribute extends Attribute {

    public IntAttribute(String name, int length) {
        super(name, length);
        super.type = Type.INT;
    }

    @Override
    public void writeValue(Block block, Object value, int offset) {
        block.writeInt(Integer.parseInt(value.toString()));
    }

    @Override
    public Object read(Block block) {
        return block.readInt();
    }
}
