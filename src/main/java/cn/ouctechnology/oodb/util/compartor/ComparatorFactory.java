package cn.ouctechnology.oodb.util.compartor;

import cn.ouctechnology.oodb.util.where.Op;

/**
 * @program: db
 * @description: 比较器工厂，给出运算符，返回对应的比较器
 * @author: ZQX
 * @create: 2018-09-05 17:06
 **/
public class ComparatorFactory {

    public static Comparator getComparator(Op operator) {

        switch (operator) {
            case Equality:
                return EqualComparator.INSTANCE;
            case NotEqual:
                return NotEqualComparator.INSTANCE;
            case GreaterThan:
                return GreaterThanComparator.INSTANCE;
            case LessThan:
                return LesserThanComparator.INSTANCE;
            case GreaterThanOrEqual:
                return GreaterThanOrEqualComparator.INSTANCE;
            case LessThanOrEqual:
                return LesserThanOrEqualComparator.INSTANCE;
            default:
                throw new RuntimeException("不支持的比较类型");
        }
    }
}
