package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.JudgeUtil;
import cn.ouctechnology.oodb.util.where.WhereNode;

import java.util.Map;

/**
 * 二元连接操作
 */
public class Join extends Operator {


    private DbIterator child1;

    private DbIterator child2;

    private WhereNode whereTree;

    private Tuple current;


    public Join(DbIterator child1, DbIterator child2, WhereNode whereTree) {
        this.child1 = child1;
        this.child2 = child2;
        this.whereTree = whereTree;
    }

    public void open() {
        child1.open();
        child2.open();
        super.open();
    }

    public void close() {
        child1.close();
        child2.close();
        super.close();
    }

    public void rewind() {
        child1.rewind();
        child2.rewind();
    }


    protected Tuple fetchNext() {
        //恢复上次外层循环没有遍历完引起的数据丢失
        if (current != null && child2.hasNext()) {
            while (child2.hasNext()) {
                Tuple mergeTuple = getMergeTuple(current);
                if (mergeTuple != null) return mergeTuple;
            }
        }
        child2.rewind();
        while (child1.hasNext()) {
            Tuple next1 = child1.next();
            current = next1;
            while (child2.hasNext()) {
                Tuple mergeTuple = getMergeTuple(current);
                if (mergeTuple != null) return mergeTuple;
            }
            child2.rewind();
        }
        current = null;
        return null;
    }


    private Tuple getMergeTuple(Tuple current) {
        //todo 不连接做判断
        Tuple next2 = child2.next();
        Tuple newTuple = new Tuple();
        Map<String, Object> values = current.getValues();
        values.forEach(newTuple::add);
        values = next2.getValues();
        values.forEach(newTuple::add);
        boolean res = JudgeUtil.whereJudge(newTuple, whereTree);
        if (res) {
            return newTuple;
        }
        newTuple = null;//help gc
        return null;
    }


    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child1, child2};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child1 = children[0];
        child2 = children[1];
    }

    public WhereNode getWhereTree() {
        return whereTree;
    }

    public void setWhereTree(WhereNode whereTree) {
        this.whereTree = whereTree;
    }
}
