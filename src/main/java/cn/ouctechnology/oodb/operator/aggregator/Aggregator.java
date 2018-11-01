package cn.ouctechnology.oodb.operator.aggregator;

import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.reocrd.Tuple;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public interface Aggregator {

    void mergeTupleIntoGroup(Tuple tup);

    DbIterator iterator();

    void clear();

    enum Op implements Serializable {
        MIN("min"), MAX("max"), SUM("sum"), AVG("avg"), COUNT("count");

        private String name;

        Op(String name) {
            this.name = name;
        }

        private static Map<String, Op> enumMap;

        static {
            enumMap = new HashMap<>();
            for (Op value : values()) {
                enumMap.put(value.name, value);
            }
        }

        public static Op getEnum(String name) {
            return enumMap.get(name);
        }


        public static Op getOp(String s) {
            return getOp(Integer.parseInt(s));
        }


        public static Op getOp(int i) {
            return values()[i];
        }

        public String toString() {
            if (this == MIN)
                return "min";
            if (this == MAX)
                return "max";
            if (this == SUM)
                return "sum";
            if (this == AVG)
                return "avg";
            if (this == COUNT)
                return "count";
            throw new IllegalStateException("impossible to reach here");
        }
    }

    static Aggregator getAggregator(Type type, String groupField, String afield, Op what) {
        switch (type) {
            case INT:
                return new IntegerAggregator(groupField, afield, what);
            case FLOAT:
                return new FloatAggregator(groupField, afield, what);
            case CHAR:
                return new StringAggregator(groupField, afield, what);
            default:
                throw new DbException("the operator is not supported");
        }
    }

}
