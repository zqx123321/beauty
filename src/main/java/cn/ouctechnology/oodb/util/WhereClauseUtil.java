package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.explain.where.InnerNode;
import cn.ouctechnology.oodb.explain.where.LeafNode;
import cn.ouctechnology.oodb.explain.where.Operator;
import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.parser.OQLParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 10:36
 * @description: TODO
 **/
public class WhereClauseUtil {

    /**
     * 对数据进行分组，得到alias-attributes的结构
     */
    public static Map<String, List<String>> getWhereField(WhereNode root) {
        if (root == null) return null;
        List<String> whereFieldList = new ArrayList<>();
        getWhereFieldList(root, whereFieldList);
        if (whereFieldList.size() == 0) return null;
        return whereFieldList.stream().collect(Collectors.groupingBy(s -> s));
    }

    /**
     * 深度优先遍历where树，得到选择列
     * todo 此种方法加上建树会增大时间复杂度，后续可以优化
     */
    public static void getWhereFieldList(WhereNode root, List<String> whereFieldList) {
        if (root == null || root instanceof LeafNode) return;
        WhereNode left = root.getLeft();
        WhereNode right = root.getRight();
        if (left instanceof LeafNode) {
            whereFieldList.add((String) ((LeafNode) left).getValue());
        } else {
            getWhereFieldList(left, whereFieldList);
        }
        getWhereFieldList(right, whereFieldList);
    }


    /**
     * 由WhereClause得到WhereTree
     */
    public static WhereNode getWhereTree(OQLParser.WhereClauseContext whereClause) {
        if (whereClause == null) return null;
        OQLParser.ConditionalExprContext exprContext = whereClause.getChild(OQLParser.ConditionalExprContext.class);
        return buildWhereTree(exprContext);
    }

    private static WhereNode buildWhereTree(OQLParser.ConditionalExprContext expr) {
        List<OQLParser.ConditionalTermContext> termList = expr.getChildren(OQLParser.ConditionalTermContext.class);
        if (termList.size() == 1) {
            return buildFactorWhereTree(termList.get(0));
        }

        List<String> operatorList = expr
                .getTerminalNodes()
                .stream().map(ParseTree::getText)
                .collect(Collectors.toList());


        OQLParser.ConditionalTermContext first = termList.get(0);
        OQLParser.ConditionalTermContext second = termList.get(1);
        Operator operator = Operator.getEnum(operatorList.get(0).toUpperCase());
        WhereNode left = buildFactorWhereTree(first);
        WhereNode right = buildFactorWhereTree(second);
        WhereNode firstTree = new InnerNode(left, right, operator);

        for (int i = 1; i < operatorList.size(); i++) {
            operator = Operator.getEnum(operatorList.get(0).toUpperCase());
            firstTree = new InnerNode(firstTree, buildFactorWhereTree(termList.get(i + 1)), operator);
        }

        return firstTree;
    }

    private static WhereNode buildFactorWhereTree(OQLParser.ConditionalTermContext term) {
        List<OQLParser.ConditionalFactorContext> factorContextList = term.getChildren(OQLParser.ConditionalFactorContext.class);
        if (factorContextList.size() == 1) return buildWhereNode(factorContextList.get(0));
        List<String> operatorList = term
                .getTerminalNodes()
                .stream().map(ParseTree::getText)
                .collect(Collectors.toList());


        OQLParser.ConditionalFactorContext first = factorContextList.get(0);
        OQLParser.ConditionalFactorContext second = factorContextList.get(1);
        Operator operator = Operator.getEnum(operatorList.get(0).toUpperCase());
        WhereNode left = buildWhereNode(first);
        WhereNode right = buildWhereNode(second);
        WhereNode firstTree = new InnerNode(left, right, operator);

        for (int i = 1; i < operatorList.size(); i++) {
            operator = Operator.getEnum(operatorList.get(0).toUpperCase());
            firstTree = new InnerNode(firstTree, buildWhereNode(factorContextList.get(i + 1)), operator);
        }
        return firstTree;
    }

    private static WhereNode buildWhereNode(OQLParser.ConditionalFactorContext factor) {
        int childCount = factor.getChildCount();
        //处理非嵌套表达式
        if (childCount < 3) {
            OQLParser.ComparisonExprContext comparisonExpr = factor
                    .getChild(OQLParser.SimpleCondExprContext.class)
                    .getChild(OQLParser.ComparisonExprContext.class);
            return comparisonExpr.getWhereNode();
        }
        OQLParser.ConditionalExprContext exprContext = factor.getChild(OQLParser.ConditionalExprContext.class);
        return buildWhereTree(exprContext);
    }
}
