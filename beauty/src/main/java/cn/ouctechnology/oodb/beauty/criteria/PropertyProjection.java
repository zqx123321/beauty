package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 12:32
 * @description: 投影操作
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
