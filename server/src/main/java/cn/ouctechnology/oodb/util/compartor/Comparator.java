package cn.ouctechnology.oodb.util.compartor;

/**
 * @program: db
 * @description: 字段比较器
 * @author: ZQX
 * @create: 2018-09-05 16:26
 **/
public interface Comparator {
    <T extends Comparable<T>> boolean compare(T a, T b);
}
