package cn.ouctechnology.oodb.operator.aggregator;

import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class FloatAggregator implements Aggregator {


    private String groupField;

    private String afield;

    private Op what;

    private Map<Object, Float> resMap;

    //todo 平均值的迭代运算会丢失精度，需要将所有值都存起来
    private Map<Object, Integer> countMap;

    private Map<Object, Float> sumMap;


    public FloatAggregator(String groupField, String afield, Op what) {
        this.groupField = groupField;
        this.afield = afield;
        this.what = what;
        countMap = new HashMap<>();
        resMap = new HashMap<>();
        sumMap = new HashMap<>();
    }


    public void mergeTupleIntoGroup(Tuple tuple) {
        //利用HashMap可以存储一个Null值
        Object groupValue = groupField.equals(Constants.NO_GROUPING) ? null : tuple.get(groupField);
        Float oldValue = resMap.get(groupValue);
        Float value = (Float) tuple.get(afield);
        if (oldValue == null) {
            oldValue = getDefaultValue(what);
            countMap.put(groupValue, 1);
            sumMap.put(groupValue, value);
        } else {
            Integer count = countMap.get(groupValue);
            countMap.put(groupValue, ++count);
            sumMap.put(groupValue, sumMap.get(groupValue) + value);
        }

        Float newValue = getNewValue(oldValue, value, groupValue);
        resMap.put(groupValue, newValue);
    }

    private Float getNewValue(Float oldValue, Float newValue, Object groupValue) {
        switch (what) {
            case MIN:
                return newValue < oldValue ? newValue : oldValue;
            case MAX:
                return newValue < oldValue ? oldValue : newValue;
            case SUM:
                return sumMap.get(groupValue);
            case COUNT:
                return Float.valueOf(countMap.get(groupValue));
            case AVG:
                return sumMap.get(groupValue) / countMap.get(groupValue);
            default:
                throw new IllegalArgumentException("the operator is error");
        }
    }

    private Float getDefaultValue(Op op) {
        switch (what) {
            case SUM:
            case COUNT:
            case AVG:
                return 0.0f;
            case MAX:
                return Float.MIN_VALUE;
            case MIN:
                return Float.MAX_VALUE;
            default:
                throw new IllegalArgumentException("the op is error");
        }
    }


    public DbIterator iterator() {
        return new AggregatorIterator(resMap, afield, groupField, what);
    }

    @Override
    public void clear() {
        resMap = new HashMap<>();
        countMap = new HashMap<>();
        sumMap = new HashMap<>();
    }
}
