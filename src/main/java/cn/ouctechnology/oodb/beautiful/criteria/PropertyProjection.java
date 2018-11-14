package cn.ouctechnology.oodb.beautiful.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 12:32
 * @description: TODO
 **/
public class PropertyProjection implements Projection {
    private String propertyName;

    PropertyProjection(String propertyName) {
        this.propertyName = propertyName;
    }


    public String getPropertyName() {
        return propertyName;
    }


    @Override
    public String toOqlString(String tableName) {
        return tableName + "." + propertyName;
    }

}
