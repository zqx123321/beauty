package cn.ouctechnology.oodb.explain.where;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:43
 * @description: TODO
 **/
public enum Operator {


    GreaterThan(">"),
    GreaterThanOrEqual(">="),
    LessThan("<"),
    LessThanOrEqual("<="),
    LessThanOrGreater("<>"),
    LIKE("LIKE"),
    NotEqual("!="),
    NotLessThan("!<"),
    NotGreaterThan("!>"),
    Equality("="),
    AND("AND"),
    OR("OR");


    private static Map<String, Operator> enumMap;

    static {
        enumMap = new HashMap<>();
        for (Operator value : values()) {
            enumMap.put(value.name, value);
        }
    }


    private String name;

    Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Operator getEnum(String name) {
        return enumMap.get(name);
    }
}
