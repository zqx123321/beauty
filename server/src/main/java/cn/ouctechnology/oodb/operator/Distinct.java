package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-05 10:52
 * @description: 去重操作
 **/
public class Distinct extends Operator {
    private Set<Integer> hashCodeSet;
    private DbIterator child;

    public Distinct(DbIterator child) {
        this.child = child;
        this.hashCodeSet = new HashSet<>();
    }

    @Override
    protected Tuple fetchNext() {
        while (child.hasNext()) {
            Tuple next = child.next();
            int code = next.hashCode();
            if (!hashCodeSet.contains(code)) {
                hashCodeSet.add(code);
                return next;
            }
        }
        return null;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child = children[0];
    }

    @Override
    public void rewind() {
        child.rewind();
        hashCodeSet = new HashSet<>();
    }

    @Override
    public void close() {
        super.close();
        child.close();
    }

    @Override
    public void open() {
        super.open();
        child.open();
    }
}
