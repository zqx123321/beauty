package cn.ouctechnology.oodb.catalog.attribute;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.dbenum.Type;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-07 12:49
 * @description: TODO
 **/
public class FloatAttribute extends Attribute {

    public FloatAttribute(String name, int length) {
        super(name, length);
        super.type = Type.FLOAT;
    }

    @Override
    public void writeValue(Block block, Object value) {
        block.writeFloat(Float.parseFloat(String.valueOf(value)));
    }

    @Override
    public Object read(Block block) {
        return block.readFloat();
    }
}
