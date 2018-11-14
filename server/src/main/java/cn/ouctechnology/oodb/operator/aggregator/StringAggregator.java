package cn.ouctechnology.oodb.operator.aggregator;

import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.HashMap;
import java.util.Map;


public class StringAggregator implements Aggregator {


    private String groupField;

    private String afield;

    private Op what;

    private Map<Object, Integer> resMap;


    public StringAggregator(String groupField, String afield, Op what) {
        if (what != Op.COUNT) throw new DbException("the string type only support count aggregator");
        this.groupField = groupField;
        this.afield = afield;
        this.what = what;
        resMap = new HashMap<>();
    }


    public void mergeTupleIntoGroup(Tuple tuple) {
        //利用HashMap可以存储一个Null值
        Object groupValue = groupField.equals(Constants.NO_GROUPING) ? null : tuple.get(groupField);
        Integer oldValue = resMap.get(groupValue);
        if (oldValue == null) {
            resMap.put(groupValue, 1);
            return;
        }
        resMap.put(groupValue, ++oldValue);
    }


    public DbIterator iterator() {
        return new AggregatorIterator(resMap, afield, groupField, what);
    }

    @Override
    public void clear() {
        resMap = new HashMap<>();
    }

}
