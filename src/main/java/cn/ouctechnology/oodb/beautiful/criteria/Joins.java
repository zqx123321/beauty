package cn.ouctechnology.oodb.beautiful.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 14:49
 * @description: TODO
 **/
public class Joins {

    public static JoinCondition eq(Class clz, String tableAlias, String field1, String field2) {
        return new SimpleJoinCondition(clz, tableAlias, Restrictions.eqProperty(field1, field2));
    }

    public static JoinCondition gt(Class clz, String tableAlias, String field1, String field2) {
        return new SimpleJoinCondition(clz, tableAlias, Restrictions.gtProperty(field1, field2));
    }

    public static JoinCondition ge(Class clz, String tableAlias, String field1, String field2) {
        return new SimpleJoinCondition(clz, tableAlias, Restrictions.geProperty(field1, field2));
    }

    public static JoinCondition le(Class clz, String tableAlias, String field1, String field2) {
        return new SimpleJoinCondition(clz, tableAlias, Restrictions.leProperty(field1, field2));
    }

    public static JoinCondition lt(Class clz, String tableAlias, String field1, String field2) {
        return new SimpleJoinCondition(clz, tableAlias, Restrictions.ltProperty(field1, field2));
    }

    public static JoinCondition none(Class clz, String tableAlias) {
        return new SimpleJoinCondition(clz, tableAlias, null);
    }

    public static JoinCondition criterion(Class clz, String tableAlias, Criterion criterion) {
        return new SimpleJoinCondition(clz, tableAlias, criterion);
    }


}
