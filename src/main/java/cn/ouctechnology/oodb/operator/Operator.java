package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.NoSuchElementException;


public abstract class Operator implements DbIterator {

    private Tuple next = null;
    private boolean open = false;

    public boolean hasNext() {
        if (!this.open)
            throw new IllegalStateException("Operator not yet open");

        if (next == null)
            next = fetchNext();
        return next != null;
    }

    public Tuple next() {
        if (next == null) {
            next = fetchNext();
            if (next == null)
                throw new NoSuchElementException();
        }

        Tuple result = next;
        next = null;
        return result;
    }


    protected abstract Tuple fetchNext();


    public void close() {
        next = null;
        this.open = false;
    }

    public void open() {
        this.open = true;
    }


    public abstract DbIterator[] getChildren();


    public abstract void setChildren(DbIterator[] children);


}
