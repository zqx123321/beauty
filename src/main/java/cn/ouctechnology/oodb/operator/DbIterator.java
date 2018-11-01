package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;


public interface DbIterator {

    void open();


    boolean hasNext();


    Tuple next();


    void rewind();


    void close();

}
