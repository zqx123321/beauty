package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 12:20
 * @description: 投影操作工厂
 **/
public class Projections {

    private Projections() {
        //cannot be instantiated
    }

    /**
     * A grouping property value projection
     *
     * @param propertyName The name of the property to group
     * @return The grouped projection
     */
    public static PropertyProjection property(String propertyName) {
        return new PropertyProjection(propertyName);
    }

    /**
     * A grouping property value projection
     *
     * @param propertyName The name of the property to group
     * @return The grouped projection
     */
    public static GroupByProjection groupProperty(String propertyName) {
        return new GroupByProjection(propertyName);
    }

    /**
     * Create a new projection list.
     *
     * @return The projection list
     */
    public static ProjectionList projectionList() {
        return new ProjectionList();
    }

    /**
     * A property value count projection
     *
     * @param propertyName The name of the property to count over
     * @return The count projection
     */
    public static AggregateProjection count(String propertyName) {
        return new AggregateProjection("count", propertyName);
    }

    /**
     * A property maximum value projection
     *
     * @param propertyName The property for which to find the max
     * @return the max projection
     * @see AggregateProjection
     */
    public static AggregateProjection max(String propertyName) {
        return new AggregateProjection("max", propertyName);
    }

    /**
     * A property minimum value projection
     *
     * @param propertyName The property for which to find the min
     * @return the min projection
     * @see AggregateProjection
     */
    public static AggregateProjection min(String propertyName) {
        return new AggregateProjection("min", propertyName);
    }

    /**
     * A property average value projection
     *
     * @param propertyName The property over which to find the average
     * @return the avg projection
     */
    public static AggregateProjection avg(String propertyName) {
        return new AggregateProjection("avg", propertyName);
    }

    /**
     * A property value sum projection
     *
     * @param propertyName The property over which to sum
     * @return the sum projection
     * @see AggregateProjection
     */
    public static AggregateProjection sum(String propertyName) {
        return new AggregateProjection("sum", propertyName);
    }

}
