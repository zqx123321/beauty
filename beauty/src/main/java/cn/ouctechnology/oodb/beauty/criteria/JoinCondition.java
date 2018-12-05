package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 14:57
 * @description: TODO
 **/
public interface JoinCondition {
    String toOqlString(String tableName);
}
