package cn.ouctechnology.oodb.util.where;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:43
 * @description: TODO
 **/
public enum Op {


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


    private static Map<String, Op> enumMap;

    static {
        enumMap = new HashMap<>();
        for (Op value : values()) {
            enumMap.put(value.name, value);
        }
    }


    private String name;

    Op(String name) {
        this.name = name;
    }

    public static Op getEnum(String name) {
        return enumMap.get(name);
    }

    public String getName() {
        return name;
    }
}
