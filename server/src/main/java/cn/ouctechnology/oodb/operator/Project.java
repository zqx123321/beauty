package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.reocrd.Tuple;

import java.util.List;

/**
 * 投影操作
 */
public class Project extends Operator {

    private DbIterator child;
    private List<String> selectFieldList;

    public Project(DbIterator child, List<String> selectFieldList) {
        this.child = child;
        this.selectFieldList = selectFieldList;
    }


    public void open() {
        child.open();
        super.open();
    }

    public void close() {
        super.close();
        child.close();
    }

    public void rewind() {
        child.rewind();
    }


    protected Tuple fetchNext() {
        if (child.hasNext()) {
            Tuple tuple = child.next();
            if (tuple == null) return null;
            Tuple newTuple = new Tuple();
            for (String field : selectFieldList) {
                Object value = tuple.get(field);
                if (value == null) continue;
                newTuple.add(field, value);
            }
            return newTuple;
        }
        return null;
    }

    @Override
    public DbIterator[] getChildren() {
        return new DbIterator[]{this.child};
    }

    @Override
    public void setChildren(DbIterator[] children) {
        if (this.child != children[0]) {
            this.child = children[0];
        }
    }

}
