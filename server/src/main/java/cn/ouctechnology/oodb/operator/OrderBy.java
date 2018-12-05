package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 排序
 */
public class OrderBy extends Operator {

    private DbIterator child;
    private ArrayList<Tuple> childTupleList = new ArrayList<>();
    private String orderByFieldName;
    private Iterator<Tuple> it;
    private boolean asc;


    public OrderBy(DbIterator child, String orderByFieldName, boolean asc) {
        this.child = child;
        this.orderByFieldName = orderByFieldName;
        this.asc = asc;
    }

    //todo 不是全部加载进入内存，而是使用文件外排序
    public void open() {
        child.open();
        while (child.hasNext())
            childTupleList.add(child.next());
        childTupleList.sort(new TupleComparator(orderByFieldName, asc));
        it = childTupleList.iterator();
        super.open();
    }

    public void close() {
        super.close();
        childTupleList = new ArrayList<>();
        it = null;
    }

    public void rewind() {
        it = childTupleList.iterator();
    }


    protected Tuple fetchNext() {
        if (it != null && it.hasNext()) {
            return it.next();
        } else
            return null;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{this.child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        this.child = children[0];
    }

}

class TupleComparator implements Comparator<Tuple> {
    private String orderByFieldName;
    private boolean asc;

    public TupleComparator(String orderByFieldName, boolean asc) {
        this.orderByFieldName = orderByFieldName;
        this.asc = asc;
    }

    public int compare(Tuple o1, Tuple o2) {
        Comparable t1 = (Comparable) o1.get(orderByFieldName);
        Comparable t2 = (Comparable) o2.get(orderByFieldName);
        int res = t1.compareTo(t2);
        if (res == 0)
            return 0;
        return asc ? res : -res;
    }

}
