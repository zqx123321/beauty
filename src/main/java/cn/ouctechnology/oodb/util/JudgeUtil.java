package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.explain.where.InnerNode;
import cn.ouctechnology.oodb.explain.where.LeafNode;
import cn.ouctechnology.oodb.explain.where.Operator;
import cn.ouctechnology.oodb.explain.where.WhereNode;
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
            Operator operator = ((InnerNode) whereTree).getOperator();
            String name = (String) ((LeafNode) left).getValue();
            Comparable value = ((LeafNode) right).getValue();
            return singleJudge(obj, operator, name, value);
        }
        //后续遍历左子树
        boolean isLeft = whereJudge(obj, left);
        Operator operator = ((InnerNode) whereTree).getOperator();
        //或运算,短路效应
        if (Operator.OR.getName().equals(operator.getName().toUpperCase())) {
            if (isLeft) return true;
            //后续遍历右子树
            return whereJudge(obj, right);
        }
        //与运算，短路效应
        if (Operator.AND.getName().equals(operator.getName().toUpperCase())) {
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
    @SuppressWarnings("unchecked")
    private static boolean singleJudge(Tuple obj, Operator operator, String name, Comparable value) {
        if (!name.contains(".")) throw new UnsupportedOperationException("the attribute is not valid");
        name = name.substring(name.indexOf(".") + 1);
        Object fieldValue = obj.get(name);
        if (fieldValue == null) return false;
        return ComparatorFactory.getComparator(operator).compare((Comparable) fieldValue, value);
    }

}
