package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 16:59
 * @description: TODO
 **/
public class Group extends Operator {
    private DbIterator child;
    private String groupField;
    private Map<Object, List<Tuple>> tupleMap;
    private Iterator<Map.Entry<Object, List<Tuple>>> mapIterator;
    private Iterator<Tuple> listIterator;


    public Group(DbIterator child, String groupField) {
        this.child = child;
        this.groupField = groupField;
        tupleMap = new HashMap<>();
    }

    @Override
    public void open() {
        child.open();
        super.open();
        while (child.hasNext()) {
            Tuple next = child.next();
            Object field = next.get(groupField);
            List<Tuple> tuples = tupleMap.computeIfAbsent(field, k -> new ArrayList<>());
            tuples.add(next);
        }
        mapIterator = tupleMap.entrySet().iterator();
        if (mapIterator.hasNext()) {
            listIterator = mapIterator.next().getValue().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        if (listIterator == null) return false;
        if (listIterator.hasNext()) return true;
        if (mapIterator.hasNext()) {
            listIterator = mapIterator.next().getValue().iterator();
            return listIterator.hasNext();
        }
        return false;
    }

    @Override
    public void close() {
        super.close();
        child.close();
    }

    @Override
    protected Tuple fetchNext() {
        if (listIterator.hasNext()) {
            return listIterator.next();
        }
        while (mapIterator.hasNext()) {
            listIterator = mapIterator.next().getValue().iterator();
            if (listIterator.hasNext())
                return listIterator.next();
        }
        return null;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child = children[0];
    }

    @Override
    public void rewind() {
        mapIterator = tupleMap.entrySet().iterator();
        if (mapIterator.hasNext()) {
            listIterator = mapIterator.next().getValue().iterator();
        }
    }
}
