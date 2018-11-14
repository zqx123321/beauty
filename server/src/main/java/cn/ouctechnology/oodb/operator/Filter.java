package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.util.where.WhereNode;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.JudgeUtil;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 20:25
 * @description: TODO
 **/
public class Filter extends Operator {

    private DbIterator child;

    private WhereNode whereTre;

    public Filter(DbIterator child, WhereNode whereTre) {
        this.child = child;
        this.whereTre = whereTre;
    }

    public void open() {
        child.open();
        super.open();
    }

    public void close() {
        child.close();
        super.close();
    }

    public void rewind() {
        child.rewind();
    }


    protected Tuple fetchNext() {
        while (child.hasNext()) {
            Tuple next = child.next();
            boolean filter = JudgeUtil.whereJudge(next, whereTre);
            if (filter) return next;
        }
        return null;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        this.child = children[0];
    }
}
