package cn.ouctechnology.oodb.beauty.criteria;

import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:49
 * @description: 条件操作工厂
 **/
public class Restrictions {


    protected Restrictions() {
        // cannot be instantiated, but needs to be protected so Expression can extend it
    }

    /**
     * Apply an "equal" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return SimpleExpression
     * @see SimpleExpression
     */
    public static SimpleExpression eq(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, "=");
    }

    /**
     * Apply a "not equal" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return The Criterion
     * @see SimpleExpression
     */
    public static SimpleExpression ne(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, "!=");
    }

    /**
     * Apply a "greater than" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return The Criterion
     * @see SimpleExpression
     */
    public static SimpleExpression gt(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, ">");
    }

    /**
     * Apply a "less than" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return The Criterion
     * @see SimpleExpression
     */
    public static SimpleExpression lt(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, "<");
    }

    /**
     * Apply a "less than or equal" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return The Criterion
     * @see SimpleExpression
     */
    public static SimpleExpression le(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, "<=");
    }

    /**
     * Apply a "greater than or equal" constraint to the named property
     *
     * @param propertyName The name of the property
     * @param value        The value to use in comparison
     * @return The Criterion
     * @see SimpleExpression
     */
    public static SimpleExpression ge(String propertyName, Object value) {
        return new SimpleExpression(propertyName, value, ">=");
    }

    /**
     * Return the conjuction of two expressions
     *
     * @param lhs One expression
     * @param rhs The other expression
     * @return The Criterion
     */
    public static LogicalExpression and(Criterion lhs, Criterion rhs) {
        return new LogicalExpression(lhs, rhs, "and");
    }

    /**
     * Return the conjuction of multiple expressions
     *
     * @param predicates The predicates making up the initial junction
     * @return The conjunction
     */
    public static Conjunction and(Criterion... predicates) {
        return conjunction(predicates);
    }

    /**
     * Return the disjuction of two expressions
     *
     * @param lhs One expression
     * @param rhs The other expression
     * @return The Criterion
     */
    public static LogicalExpression or(Criterion lhs, Criterion rhs) {
        return new LogicalExpression(lhs, rhs, "or");
    }

    /**
     * Return the disjuction of multiple expressions
     *
     * @param predicates The predicates making up the initial junction
     * @return The conjunction
     */
    public static Disjunction or(Criterion... predicates) {
        return disjunction(predicates);
    }

    /**
     * Group expressions together in a single conjunction (A and B and C...).
     * <p>
     * This form creates an empty conjunction.  See {@link Conjunction#add(Criterion)}
     *
     * @return Conjunction
     */
    public static Conjunction conjunction() {
        return new Conjunction();
    }

    /**
     * Group expressions together in a single conjunction (A and B and C...).
     *
     * @param conditions The initial set of conditions to put into the Conjunction
     * @return Conjunction
     */
    public static Conjunction conjunction(Criterion... conditions) {
        return new Conjunction(conditions);
    }

    /**
     * Group expressions together in a single disjunction (A or B or C...).
     * <p>
     * This form creates an empty disjunction.  See {@link Disjunction#add(Criterion)}
     *
     * @return Conjunction
     */
    public static Disjunction disjunction() {
        return new Disjunction();
    }

    /**
     * Group expressions together in a single disjunction (A or B or C...).
     *
     * @param conditions The initial set of conditions to put into the Disjunction
     * @return Conjunction
     */
    public static Disjunction disjunction(Criterion... conditions) {
        return new Disjunction(conditions);
    }

    /**
     * Apply an "equals" constraint to each property in the key set of a <tt>Map</tt>
     *
     * @param propertyNameValues a map from property names to values
     * @return Criterion
     * @see Conjunction
     */
    @SuppressWarnings("UnusedDeclaration")
    public static Criterion allEq(Map<String, ?> propertyNameValues) {
        final Conjunction conj = conjunction();

        for (Map.Entry<String, ?> entry : propertyNameValues.entrySet()) {
            conj.add(eq(entry.getKey(), entry.getValue()));
        }
        return conj;
    }

    /**
     * Apply an "equal" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression eqProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, "=");
    }

    /**
     * Apply a "not equal" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression neProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, "<>");
    }

    /**
     * Apply a "less than" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression ltProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, "<");
    }

    /**
     * Apply a "less than or equal" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression leProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, "<=");
    }

    /**
     * Apply a "greater than" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression gtProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, ">");
    }

    /**
     * Apply a "greater than or equal" constraint to two properties
     *
     * @param propertyName      One property name
     * @param otherPropertyName The other property name
     * @return The Criterion
     * @see PropertyExpression
     */
    public static PropertyExpression geProperty(String propertyName, String otherPropertyName) {
        return new PropertyExpression(propertyName, otherPropertyName, ">=");
    }
}
