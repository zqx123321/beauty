package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Index;
import cn.ouctechnology.oodb.reocrd.Field;
import cn.ouctechnology.oodb.util.where.InnerNode;
import cn.ouctechnology.oodb.util.where.LeafNode;
import cn.ouctechnology.oodb.util.where.Op;
import cn.ouctechnology.oodb.util.where.WhereNode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.parser.OQLParser.*;

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
    public static List<String> getWhereField(WhereNode root) {
        if (root == null) return null;
        List<String> whereFieldList = new ArrayList<>();
        getWhereFieldList(root, whereFieldList);
        if (whereFieldList.size() == 0) return null;
        return whereFieldList;
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
            Object value = ((LeafNode) left).getValue();
            if (value instanceof Field) {
                Field field = (Field) value;
                whereFieldList.add(field.getName());
            }
            value = ((LeafNode) right).getValue();
            if (value instanceof Field) {
                Field field = (Field) value;
                whereFieldList.add(field.getName());
            }
        } else {
            getWhereFieldList(left, whereFieldList);
        }
        getWhereFieldList(right, whereFieldList);
    }


    /**
     * 由WhereClause得到WhereTree
     */
    public static WhereNode getWhereTree(WhereClauseContext whereClause) {
        if (whereClause == null) return null;
        ConditionalExprContext exprContext = whereClause.getChild(ConditionalExprContext.class);
        return buildWhereTree(exprContext);
    }

    public static WhereNode buildWhereTree(ConditionalExprContext expr) {
        List<ConditionalTermContext> termList = expr.getChildren(ConditionalTermContext.class);
        if (termList.size() == 1) {
            return buildFactorWhereTree(termList.get(0));
        }

        List<String> operatorList = expr
                .getTerminalNodes()
                .stream().map(ParseTree::getText)
                .collect(Collectors.toList());


        ConditionalTermContext first = termList.get(0);
        ConditionalTermContext second = termList.get(1);
        Op operator = Op.getEnum(operatorList.get(0).toUpperCase());
        WhereNode left = buildFactorWhereTree(first);
        WhereNode right = buildFactorWhereTree(second);
        WhereNode firstTree = new InnerNode(left, right, operator);

        for (int i = 1; i < operatorList.size(); i++) {
            operator = Op.getEnum(operatorList.get(0).toUpperCase());
            firstTree = new InnerNode(firstTree, buildFactorWhereTree(termList.get(i + 1)), operator);
        }

        return firstTree;
    }

    private static WhereNode buildFactorWhereTree(ConditionalTermContext term) {
        List<ConditionalFactorContext> factorContextList = term.getChildren(ConditionalFactorContext.class);
        if (factorContextList.size() == 1) return buildWhereNode(factorContextList.get(0));
        List<String> operatorList = term
                .getTerminalNodes()
                .stream().map(ParseTree::getText)
                .collect(Collectors.toList());


        ConditionalFactorContext first = factorContextList.get(0);
        ConditionalFactorContext second = factorContextList.get(1);
        Op operator = Op.getEnum(operatorList.get(0).toUpperCase());
        WhereNode left = buildWhereNode(first);
        WhereNode right = buildWhereNode(second);
        WhereNode firstTree = new InnerNode(left, right, operator);

        for (int i = 1; i < operatorList.size(); i++) {
            operator = Op.getEnum(operatorList.get(0).toUpperCase());
            firstTree = new InnerNode(firstTree, buildWhereNode(factorContextList.get(i + 1)), operator);
        }
        return firstTree;
    }

    private static WhereNode buildWhereNode(ConditionalFactorContext factor) {
        int childCount = factor.getChildCount();
        //处理非嵌套表达式
        if (childCount < 3) {
            ComparisonExprContext comparisonExpr = factor
                    .getChild(SimpleCondExprContext.class)
                    .getChild(ComparisonExprContext.class);
            InnerNode innerNode = new InnerNode();
            if (comparisonExpr instanceof ComparisonStringExprContext) {
                ComparisonStringExprContext comparisonStringExprContext = (ComparisonStringExprContext) comparisonExpr;
                String operator = comparisonStringExprContext.comparisonOperator().getText();
                Op anEnum = Op.getEnum(operator);
                innerNode.setOperator(anEnum);
                StringPriContext stringPriContext1 = (StringPriContext) comparisonStringExprContext.stringExpr(0);
                StringPrimaryContext stringPrimaryContext1 = stringPriContext1.stringPrimary();
                if (stringPrimaryContext1 instanceof StringPathExprContext) {
                    Field field = new Field(stringPrimaryContext1.getText());
                    LeafNode leafNode = new LeafNode(field);
                    innerNode.setLeft(leafNode);
                } else {
                    String text = stringPrimaryContext1.getText();
                    LeafNode leafNode = new LeafNode(text.replaceAll("'", ""));
                    innerNode.setLeft(leafNode);
                }

                StringPriContext stringPriContext2 = (StringPriContext) comparisonStringExprContext.stringExpr(1);
                StringPrimaryContext stringPrimaryContext2 = stringPriContext2.stringPrimary();

                if (stringPrimaryContext2 instanceof StringPathExprContext) {
                    Field field = new Field(stringPrimaryContext2.getText());
                    LeafNode leafNode = new LeafNode(field);
                    innerNode.setRight(leafNode);
                } else {
                    String text = stringPrimaryContext2.getText();
                    LeafNode leafNode = new LeafNode(text.replaceAll("'", ""));
                    innerNode.setRight(leafNode);
                }

            } else if (comparisonExpr instanceof ComparisonArithmeticExprContext) {
                ComparisonArithmeticExprContext comparisonArithmeticExprContext = (ComparisonArithmeticExprContext) comparisonExpr;
                String operator = comparisonArithmeticExprContext.comparisonOperator().getText();
                Op anEnum = Op.getEnum(operator);
                innerNode.setOperator(anEnum);
                ArithmeticExprContext arithmeticExprContext1 = comparisonArithmeticExprContext.arithmeticExpr(0);
                if (arithmeticExprContext1 instanceof ArithmeticPathExprContext) {
                    ArithmeticPathExprContext arithmeticPathExprContext = (ArithmeticPathExprContext) arithmeticExprContext1;
                    LeafNode leafNode = new LeafNode(new Field(arithmeticPathExprContext.getText()));
                    innerNode.setLeft(leafNode);
                } else {
                    ArithmeticSimpleArithmeticExprContext simpleArithmeticExprContext = (ArithmeticSimpleArithmeticExprContext) arithmeticExprContext1;
                    String text = simpleArithmeticExprContext.getText();
                    Object eval = OgnlUtil.eval(text);
                    LeafNode leafNode = new LeafNode(eval);
                    innerNode.setLeft(leafNode);
                }

                ArithmeticExprContext arithmeticExprContext2 = comparisonArithmeticExprContext.arithmeticExpr(1);
                if (arithmeticExprContext2 instanceof ArithmeticPathExprContext) {
                    ArithmeticPathExprContext arithmeticPathExprContext = (ArithmeticPathExprContext) arithmeticExprContext2;
                    LeafNode leafNode = new LeafNode(new Field(arithmeticPathExprContext.getText()));
                    innerNode.setRight(leafNode);
                } else {
                    ArithmeticSimpleArithmeticExprContext simpleArithmeticExprContext = (ArithmeticSimpleArithmeticExprContext) arithmeticExprContext2;
                    String text = simpleArithmeticExprContext.getText();
                    Object eval = OgnlUtil.eval(text);
                    LeafNode leafNode = new LeafNode(eval);
                    innerNode.setRight(leafNode);
                }

            } else throw new UnsupportedOperationException("not support now");

            return innerNode;
        }
        ConditionalExprContext exprContext = factor.getChild(ConditionalExprContext.class);
        return buildWhereTree(exprContext);
    }

    public static IndexStruct getIndex(String tableName, WhereNode whereTree) {
        if (!(whereTree instanceof InnerNode)) return null;
        InnerNode node = (InnerNode) whereTree;
        if (!(node.getLeft() instanceof LeafNode && node.getRight() instanceof LeafNode)) return null;
        LeafNode left = (LeafNode) node.getLeft();
        LeafNode right = (LeafNode) node.getRight();
        Field field = null;
        Object value = null;
        if (left.getValue() instanceof Field) field = (Field) left.getValue();
        else value = left.getValue();
        if (right.getValue() instanceof Field) {
            if (field != null) return null;
            field = (Field) right.getValue();
        } else {
            if (value != null) return null;
            value = right.getValue();
        }
        if (field == null || value == null) return null;
        String columnName = OgnlUtil.getLeftField(field.getName());
        Index index = Catalog.getIndexByColumnName(tableName, columnName);
        if (index == null) return null;
        return new IndexStruct(index, columnName, (Comparable) value, node.getOperator());
    }

    public static class IndexStruct {
        public Index index;
        public String column;
        public Comparable value;
        public Op op;

        public IndexStruct(Index index, String column, Comparable value, Op op) {
            this.index = index;
            this.column = column;
            this.value = value;
            this.op = op;
        }
    }
}
