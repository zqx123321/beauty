package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.criteria.Criterion;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-17 20:15
 * @description: TODO
 **/

/**
 * Beauty总父类，继承此类之后悔自动拥有如下所有方法
 *
 * @param <T>
 */
public interface BaseBeauty<T> {

    int save(T t);

    T get(Criterion criterion);

    List<T> selectList(Criterion criterion);

    int update(T t, Criterion criterion);

    int delete(Criterion criterion);
}
