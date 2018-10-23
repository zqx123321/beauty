package cn.ouctechnology.oodb.util.compartor;

/**
 * @program: db
 * @description: 等于的比较器
 * @author: ZQX
 * @create: 2018-09-05 17:02
 **/
public enum EqualComparator implements Comparator {
    //枚举的单例？
    INSTANCE;

    @Override
    public <T extends Comparable<T>> boolean compare(T a, T b) {
        return a.compareTo(b) == 0;
    }
}
