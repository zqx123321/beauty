package cn.ouctechnology.oodb.beautiful.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 12:25
 * @description: TODO
 **/
public class AggregateProjection implements Projection {

    protected final String propertyName;
    private final String functionName;

    protected AggregateProjection(String functionName, String propertyName) {
        this.functionName = functionName;
        this.propertyName = propertyName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getPropertyName() {
        return propertyName;
    }


    @Override
    public String toOqlString(String tableName) {
        return functionName + "(" + tableName + "." + propertyName + ")";
    }
}
