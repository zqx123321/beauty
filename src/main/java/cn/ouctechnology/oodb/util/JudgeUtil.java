package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.util.where.InnerNode;
import cn.ouctechnology.oodb.util.where.LeafNode;
import cn.ouctechnology.oodb.util.where.Op;
import cn.ouctechnology.oodb.util.where.WhereNode;
import cn.ouctechnology.oodb.reocrd.Field;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.compartor.ComparatorFactory;

/**
 * @program: db
 * @description: 判断对象是否满足条件的工具类
 * @author: ZQX
 * @create: 2018-09-05 18:12
 **/
public class JudgeUtil {
    /**
     * 判断对象是否满足逻辑表达式树的条件
     * 核心思想为二叉树的后续遍历，由下到上带出判断结果
     *
     * @param obj       待判断逻辑对象
     * @param whereTree 逻辑表达式树
     * @return 判断结果
     */
    public static boolean whereJudge(Tuple obj, WhereNode whereTree) {
        if (whereTree == null) return true;
        WhereNode left = whereTree.getLeft();
        WhereNode right = whereTree.getRight();
        //如果到达为叶节点,执行单条件判断
        if (left instanceof LeafNode) {
            Op operator = ((InnerNode) whereTree).getOperator();
            Object leftObj = ((LeafNode) left).getValue();
            Object rightObj = ((LeafNode) right).getValue();
            if (leftObj instanceof Field && rightObj instanceof Field)
                return singleJudge(obj, operator, (Field) leftObj, (Field) rightObj);
            if (leftObj instanceof Field && rightObj instanceof Comparable)
                return singleJudge(obj, operator, (Field) leftObj, (Comparable) rightObj);
            if (leftObj instanceof Comparable && rightObj instanceof Field)
                return singleJudge(obj, operator, (Comparable) leftObj, (Field) rightObj);
            if (leftObj instanceof Comparable && rightObj instanceof Comparable)
                return singleJudge(operator, (Comparable) leftObj, (Comparable) rightObj);
            return false;

        }
        //后续遍历左子树
        boolean isLeft = whereJudge(obj, left);
        Op operator = ((InnerNode) whereTree).getOperator();
        //或运算,短路效应
        if (Op.OR.getName().equals(operator.getName().toUpperCase())) {
            if (isLeft) return true;
            //后续遍历右子树
            return whereJudge(obj, right);
        }
        //与运算，短路效应
        if (Op.AND.getName().equals(operator.getName().toUpperCase())) {
            if (!isLeft) return false;
            //后续遍历右子树
            return whereJudge(obj, right);
        }

        throw new UnsupportedOperationException("type error");
    }

    /**
     * 内部方法，做形如id=1的单条件判断
     *
     * @param obj      待判断对象
     * @param operator 运算符，支持=、!=、>、<、>=、<=六种运算符
     * @param name     左值名称
     * @param value    右值
     * @return 判断结果
     */
    @SuppressWarnings("all")
    private static boolean singleJudge(Tuple obj, Op operator, Field field, Comparable value) {
        Object fieldValue = getValue(obj, field);
        if (fieldValue == null) return false;
        return ComparatorFactory.getComparator(operator).compare((Comparable) fieldValue, value);
    }

    @SuppressWarnings("all")
    private static boolean singleJudge(Tuple obj, Op operator, Comparable value, Field field) {
        Object fieldValue = getValue(obj, field);
        if (fieldValue == null) return false;
        return ComparatorFactory.getComparator(operator).compare(value, (Comparable) fieldValue);
    }

    @SuppressWarnings("all")
    private static boolean singleJudge(Tuple obj, Op operator, Field field1, Field field2) {
        Object fieldValue1 = getValue(obj, field1);
        if (fieldValue1 == null) return false;
        Object fieldValue2 = getValue(obj, field2);
        if (fieldValue2 == null) return false;
        return ComparatorFactory.getComparator(operator).compare((Comparable) fieldValue1, (Comparable) fieldValue2);
    }

    @SuppressWarnings("unchecked")
    private static boolean singleJudge(Op operator, Comparable fieldValue1, Comparable fieldValue2) {
        return ComparatorFactory.getComparator(operator).compare(fieldValue1, fieldValue2);
    }

    @SuppressWarnings("all")
    public static boolean singleJudge(Tuple obj1, Tuple obj2, Op operator, Field field1, Field field2) {
        Object fieldValue1 = getValue(obj1, field1);
        if (fieldValue1 == null) return false;
        Object fieldValue2 = getValue(obj2, field2);
        if (fieldValue2 == null) return false;
        if (fieldValue2 == null) return false;
        return ComparatorFactory.getComparator(operator).compare((Comparable) fieldValue1, (Comparable) fieldValue2);
    }

    private static Object getValue(Tuple tuple, Field field) {
        String name = field.getName();
        if (!name.contains(".")) throw new UnsupportedOperationException("the attribute is not valid");
        Object fieldValue = tuple.get(name);
        return fieldValue;
    }

}
