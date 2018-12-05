package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.where.Op;

import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 21:29
 * @description: 索引连接
 **/
public class IndexJoin extends Operator {

    private DbIterator child;

    private DbIterator indexScan;

    private String tableName;

    private String tableAlias;

    private String joinField1;

    private String joinField2;

    private Op op;

    private Tuple current;


    public IndexJoin(DbIterator child, String tableName, String tableAlias, String joinField1, String joinField2, Op op) {
        this.child = child;
        this.tableName = tableName;
        this.tableAlias = tableAlias;
        this.joinField1 = joinField1;
        this.joinField2 = joinField2;
        this.op = op;
    }

    @Override
    public void close() {
        child.close();
        if (indexScan != null) indexScan.close();
        super.close();
    }

    @Override
    public void open() {
        child.open();
        super.open();
    }

    @Override
    protected Tuple fetchNext() {
        if (current != null && indexScan != null) {
            while (indexScan.hasNext()) {
                Tuple next2 = indexScan.next();
                if (next2 != null) {
                    return getMergeTuple(current, next2);
                }
            }
        }
        while (child.hasNext()) {
            Tuple next1 = child.next();
            current = next1;
            Comparable value = (Comparable) next1.get(joinField1);
            indexScan = new IndexScan(tableName, tableAlias, joinField2, op, value);
            indexScan.open();
            while (indexScan.hasNext()) {
                Tuple next2 = indexScan.next();
                if (next2 != null) {
                    return getMergeTuple(next1, next2);
                }
            }
        }
        current = null;
        return null;
    }

    private Tuple getMergeTuple(Tuple next1, Tuple next2) {
        Tuple newTuple = new Tuple();
        Map<String, Object> values = next1.getValues();
        values.forEach(newTuple::add);
        values = next2.getValues();
        values.forEach(newTuple::add);
        return newTuple;
    }


    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{child, indexScan};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        child = children[0];
        indexScan = children[1];
    }

    @Override
    public void rewind() {
        child.rewind();
        if (indexScan != null) indexScan.rewind();
        current = null;
    }
}
