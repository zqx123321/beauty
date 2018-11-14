package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:37
 * @description: TODO
 **/
public interface Criterion {
    String toOqlString(String tableName);
}
