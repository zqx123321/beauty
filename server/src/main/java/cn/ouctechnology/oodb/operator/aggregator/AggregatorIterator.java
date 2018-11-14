package cn.ouctechnology.oodb.operator.aggregator;

import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.Iterator;
import java.util.Map;

import static cn.ouctechnology.oodb.constant.Constants.NO_GROUPING;

/**
 * @program: newdb
 * @author: ZQX
 * @create: 2018-10-25 16:08
 * @description: TODO
 **/
public class AggregatorIterator implements DbIterator {

    private Map<Object, ? extends Number> resMap;
    private String groupField;
    private String aField;
    private Aggregator.Op op;
    private Iterator<? extends Map.Entry<Object, ? extends Number>> iterator;

    public AggregatorIterator(Map<Object, ? extends Number> resMap, String aField, String groupField, Aggregator.Op op) {
        this.resMap = resMap;
        this.aField = aField;
        this.groupField = groupField;
        this.op = op;
    }

    @Override
    public void open() {
        iterator = resMap.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Tuple next() {
        Map.Entry<Object, ? extends Number> next = iterator.next();
        Tuple tuple = new Tuple();
        Number value = next.getValue();
        if (groupField.equals(NO_GROUPING)) {
            tuple.add(op.toString() + "(" + aField + ")", value);
        } else {
            tuple.add(groupField, next.getKey());
            tuple.add(op.toString() + "(" + aField + ")", value);
        }
        return tuple;
    }

    @Override
    public void rewind() {
        iterator = resMap.entrySet().iterator();
    }

    @Override
    public void close() {
        iterator = null;
    }
}
