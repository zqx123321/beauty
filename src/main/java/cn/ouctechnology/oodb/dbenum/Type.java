package cn.ouctechnology.oodb.dbenum;

import cn.ouctechnology.oodb.catalog.attribute.*;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 19:28
 * @description: 字段类型枚举
 **/
public enum Type {
    INT {
        @Override
        public Attribute readAttribute(DataInputStream dis) throws IOException {
            String name = dis.readUTF();
            int length = dis.readInt();
            return new IntAttribute(name, length);
        }
    }, FLOAT {
        @Override
        public Attribute readAttribute(DataInputStream dis) throws IOException {
            String name = dis.readUTF();
            int length = dis.readInt();
            return new FloatAttribute(name, length);
        }
    }, CHAR {
        @Override
        public Attribute readAttribute(DataInputStream dis) throws IOException {
            String name = dis.readUTF();
            int length = dis.readInt();
            return new CharAttribute(name, length);
        }
    }, OBJECT {
        @Override
        public Attribute readAttribute(DataInputStream dis) throws IOException {
            String name = dis.readUTF();
            int length = dis.readInt();
            int attributesNum = dis.readInt();
            List<Attribute> innerAttributes = new ArrayList<>();
            for (int i = 0; i < attributesNum; i++) {
                Type type = Type.values()[dis.readInt()];
                Attribute attribute = type.readAttribute(dis);
                innerAttributes.add(attribute);
            }
            return new ObjectAttribute(name, length, innerAttributes);
        }
    }, LIST {
        @Override
        public Attribute readAttribute(DataInputStream dis) throws IOException {
            String name = dis.readUTF();
            int length = dis.readInt();
            Type type = Type.values()[dis.readInt()];
            Attribute attribute = type.readAttribute(dis);
            return new ListAttribute(name, length, attribute);
        }
    };

    public abstract Attribute readAttribute(DataInputStream dis) throws IOException;
}
