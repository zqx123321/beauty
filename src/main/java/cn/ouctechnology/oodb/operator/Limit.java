package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 16:26
 * @description: TODO
 **/
public class Limit extends Operator {
    private DbIterator child;

    private int start;

    private int size;

    private int current;

    public Limit(DbIterator child, int start, int size) {
        this.child = child;
        this.start = start;
        this.size = size;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return child.hasNext() && current < start + size;
    }

    public void open() {
        super.open();
        child.open();
        while (child.hasNext()) {
            if (current == start) break;
            child.next();
            current++;
        }
        super.open();
    }

    @Override
    protected Tuple fetchNext() {
        if (hasNext()) {
            current++;
            return child.next();
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
    public void close() {
        super.close();
        child.close();
    }

    @Override
    public void rewind() {
        child.rewind();
        current = 0;
    }
}
