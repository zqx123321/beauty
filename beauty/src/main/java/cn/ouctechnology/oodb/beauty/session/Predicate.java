package cn.ouctechnology.oodb.beauty.session;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 19:25
 * @description: 查询谓词，用于Native Queries
 **/
public interface Predicate<T> {

    /**
     * 匹配方法
     *
     * @param t
     * @return
     */
    boolean match(T t);

    /**
     * 获取泛型T
     *
     * @return
     */
    Class getGenericClass();
}
