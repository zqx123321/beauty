package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:46
 * @description: TODO
 **/
public class Order implements Criterion {
    private boolean ascending;
    private String propertyName;

    /**
     * Ascending order
     *
     * @param propertyName The property to order on
     * @return The build Order instance
     */
    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    /**
     * Descending order.
     *
     * @param propertyName The property to order on
     * @return The build Order instance
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

    /**
     * Constructor for Order.  Order instances are generally created by factory methods.
     *
     * @see #asc
     * @see #desc
     */
    protected Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }


    public String getPropertyName() {
        return propertyName;
    }

    @SuppressWarnings("UnusedDeclaration")
    public boolean isAscending() {
        return ascending;
    }


    public String toOqlString(String tableName) {
        return tableName + "." + propertyName + " " + (isAscending() ? "" : "desc");
    }

}
