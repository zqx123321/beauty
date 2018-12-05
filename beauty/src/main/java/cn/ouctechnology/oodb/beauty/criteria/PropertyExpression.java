package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 14:34
 * @description: property=property型表达式
 **/
public class PropertyExpression implements Criterion {

    private final String propertyName;
    private final String otherPropertyName;
    private final String op;

    PropertyExpression(String propertyName, String otherPropertyName, String op) {
        this.propertyName = propertyName;
        this.otherPropertyName = otherPropertyName;
        this.op = op;
    }

    public String getOp() {
        return op;
    }

    @Override
    public String toOqlString(String tableName) {
        return propertyName + op + otherPropertyName;
    }

}
