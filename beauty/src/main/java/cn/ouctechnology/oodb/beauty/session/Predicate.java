package cn.ouctechnology.oodb.beauty.session;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 19:25
 * @description: TODO
 **/
public interface Predicate<T> {

    boolean match(T t);

    Class getGenericClass();
}
