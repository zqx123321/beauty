package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:42
 * @description: property=value型简单表达式
 **/
public class SimpleExpression implements Criterion {

    private final String propertyName;
    private final Object value;
    private final String op;

    SimpleExpression(String propertyName, Object value, String op) {
        if (value instanceof String) value = "'" + value + "'";
        this.propertyName = propertyName;
        this.value = value;
        this.op = op;
    }


    protected final String getOp() {
        return op;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getValue() {
        return value;
    }


    @Override
    public String toOqlString(String tableName) {
        return tableName + "." + propertyName + " " + op + " " + value;
    }

}
