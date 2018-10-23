package cn.ouctechnology.oodb.explain.where;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:40
 * @description: TODO
 **/
public class LeafNode implements WhereNode {
    private Comparable value;

    public LeafNode(Comparable value) {
        this.value = value;
    }

    public Comparable getValue() {
        return value;
    }

    public void setValue(Comparable value) {
        this.value = value;
    }

    @Override
    public WhereNode getLeft() {
        throw new UnsupportedOperationException("the leaf node can not get left");
    }

    @Override
    public WhereNode getRight() {
        throw new UnsupportedOperationException("the leaf node can not get right");
    }
}
