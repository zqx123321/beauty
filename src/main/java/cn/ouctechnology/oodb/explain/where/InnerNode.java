package cn.ouctechnology.oodb.explain.where;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:40
 * @description: TODO
 **/
public class InnerNode implements WhereNode {
    private WhereNode left;
    private WhereNode right;
    private Operator operator;

    public InnerNode() {
    }

    public InnerNode(Operator operator) {
        this.operator = operator;
    }

    public InnerNode(WhereNode left, WhereNode right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }


    public WhereNode getLeft() {
        return left;
    }


    public WhereNode getRight() {
        return right;
    }


    public Operator getOperator() {
        return operator;
    }


    public WhereNode setLeft(WhereNode node) {
        left = node;
        return this;
    }


    public WhereNode setRight(WhereNode node) {
        right = node;
        return this;
    }


    public WhereNode setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }
}
