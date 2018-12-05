package cn.ouctechnology.oodb.logical;

import cn.ouctechnology.oodb.util.where.WhereNode;


public class LogicalFilterNode {

    private WhereNode whereTree;

    public LogicalFilterNode(WhereNode whereTree) {
        this.whereTree = whereTree;
    }

    public WhereNode getWhereTree() {
        return whereTree;
    }
}