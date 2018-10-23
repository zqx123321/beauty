package cn.ouctechnology.oodb.util.compartor;

/**
 * @program: db
 * @description: 大于等于
 * @author: ZQX
 * @create: 2018-09-05 17:45
 **/
public enum GreaterThanOrEqualComparator implements Comparator {
    INSTANCE;

    @Override
    public <T extends Comparable<T>> boolean compare(T a, T b) {
        return a.compareTo(b) > 0 || a.compareTo(b) == 0;
    }
}
