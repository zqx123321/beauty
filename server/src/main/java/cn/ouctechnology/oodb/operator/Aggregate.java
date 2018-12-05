package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.operator.aggregator.Aggregator;
import cn.ouctechnology.oodb.reocrd.Tuple;

/**
 * 聚集操作
 */
public class Aggregate extends Operator {

    private DbIterator child;

    private String afield;

    private Type type;

    private String groupField;

    private Aggregator.Op aop;

    private Aggregator aggregator;

    private DbIterator iterator;


    public Aggregate(DbIterator child, String afield, Type type, String groupField, Aggregator.Op aop) {
        this.child = child;
        this.afield = afield;
        this.type = type;
        this.groupField = groupField;
        this.aop = aop;
        this.aggregator = Aggregator.getAggregator(type, groupField, afield, aop);
    }

    public void open() {
        child.open();
        while (child.hasNext()) {
            Tuple next = child.next();
            aggregator.mergeTupleIntoGroup(next);
        }
        iterator = aggregator.iterator();
        iterator.open();
        super.open();
    }


    protected Tuple fetchNext() {
        if (iterator.hasNext())
            return iterator.next();
        return null;
    }

    public void rewind() {
        iterator.rewind();
    }

    public void close() {
        iterator = null;
        aggregator.clear();
        child.close();
        super.close();
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child = children[0];
    }

    public String getAfield() {
        return afield;
    }

    public String getGroupField() {
        return groupField;
    }

    public Aggregator.Op getAop() {
        return aop;
    }
}
