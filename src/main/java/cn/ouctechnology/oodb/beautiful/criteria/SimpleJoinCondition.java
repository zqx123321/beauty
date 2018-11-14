package cn.ouctechnology.oodb.beautiful.criteria;

import org.apache.commons.lang.StringUtils;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 14:22
 * @description: TODO
 **/
public class SimpleJoinCondition implements JoinCondition {

    private Class clz;

    private String name;

    private String alias;

    private Criterion criterion;

    SimpleJoinCondition(Class clz, String alias, Criterion criterion) {
        this.clz = clz;
        this.criterion = criterion;
        //todo 检查criteria合法性
        this.name = StringUtils.uncapitalize(clz.getSimpleName());
        this.alias = alias;
    }


    @Override
    public String toOqlString(String tableName) {
        if (criterion != null) {
            return " join " + name + " " + alias + " on(" + criterion.toOqlString(tableName) + ")";
        }
        return " ," + name + " " + alias;
    }

    public Class getClz() {
        return clz;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public Criterion getCriterion() {
        return criterion;
    }
}
