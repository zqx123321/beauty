package cn.ouctechnology.oodb.catalog.attribute;

import static cn.ouctechnology.oodb.constant.Constants.SIZE_FLOAT;
import static cn.ouctechnology.oodb.constant.Constants.SIZE_INT;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-08 09:35
 * @description: 属性工厂
 **/
public class AttributeFactory {

    public static Attribute createAttribute(String type, String name, int length) {
        type = type.toLowerCase();
        switch (type) {
            case "int": {
                return new IntAttribute(name, SIZE_INT);
            }
            case "float": {
                return new FloatAttribute(name, SIZE_FLOAT);
            }
            case "char": {
                return new CharAttribute(name, length);
            }
            default:
                throw new IllegalArgumentException("the type:" + type + "is incorrect!");
        }
    }
}
