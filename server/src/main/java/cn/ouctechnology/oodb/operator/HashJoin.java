package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-08 10:37
 * @description: 哈希连接
 **/
public class HashJoin extends Operator {
    private DbIterator child1;

    private DbIterator child2;

    private String field1;

    private String field2;

    private Map<Object, List<Tuple>> hashMap;

    private Iterator<Tuple> iterator;

    private Tuple current;


    public HashJoin(DbIterator child1, DbIterator child2, String field1, String field2) {
        this.child1 = child1;
        this.child2 = child2;
        this.field1 = field1;
        this.field2 = field2;
        this.hashMap = new HashMap<>();
    }

    @Override
    public void close() {
        super.close();
        hashMap = new HashMap<>();
        child2.close();
    }

    @Override
    public void open() {
        super.open();
        child1.open();
        child2.open();
        while (child1.hasNext()) {
            Tuple next = child1.next();
            List<Tuple> tupleList = hashMap.computeIfAbsent(next.get(field1), k -> new ArrayList<>());
            tupleList.add(next);
        }
        child1.close();
    }

    @Override
    protected Tuple fetchNext() {
        if (iterator != null) {
            if (iterator.hasNext()) {
                Tuple next = iterator.next();
                return getMergeTuple(current, next);
            }
        }
        while (child2.hasNext()) {
            Tuple next1 = child2.next();
            current = next1;
            Object value = next1.get(field2);
            List<Tuple> tupleList = hashMap.get(value);
            if (tupleList != null) {
                iterator = tupleList.iterator();
                if (iterator.hasNext()) {
                    Tuple next2 = iterator.next();
                    return getMergeTuple(next1, next2);
                }
            }
        }
        return null;
    }

    private Tuple getMergeTuple(Tuple next1, Tuple next2) {
        Tuple newTuple = new Tuple();
        Map<String, Object> values = next1.getValues();
        values.forEach(newTuple::add);
        values = next2.getValues();
        values.forEach(newTuple::add);
        return newTuple;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child1, child2};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child1 = children[0];
        child2 = children[1];
    }

    @Override
    public void rewind() {
        child2.rewind();
        iterator = null;
    }
}
