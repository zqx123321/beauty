package cn.ouctechnology.oodb.util.compartor;

/**
 * @program: db
 * @description: 不等于
 * @author: ZQX
 * @create: 2018-09-05 17:48
 **/
public enum NotEqualComparator implements Comparator {
    INSTANCE;

    @Override
    public <T extends Comparable<T>> boolean compare(T a, T b) {
        return a.compareTo(b) != 0;
    }
}
