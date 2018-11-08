package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Index;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.where.Op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.BLOCK_SIZE;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 11:30
 * @description: TODO
 **/
public class IndexScan implements DbIterator {
    private String tableName;
    private String tableAlias;
    private String columnName;
    private Op op;
    private Comparable value;
    private List<Integer> offsetList;
    private Iterator<Integer> iterator;

    public IndexScan(String tableName, String tableAlias, String columnName, Op op, Comparable value) {
        this.tableName = tableName;
        this.tableAlias = tableAlias;
        this.columnName = columnName;
        this.op = op;
        this.value = value;
        this.offsetList = new ArrayList<>();
    }

    @Override
    public void open() {
        Index index = Catalog.getIndexByColumnName(tableName, columnName);
        switch (op) {
            case Equality:
                List list1 = index.getbTree().searchList(value);
                if (list1 != null && list1.size() > 0) offsetList.addAll(list1);
                break;
            case GreaterThan:
                List list = index.getbTree().searchGreater(value);
                if (list != null && list.size() > 0)
                    offsetList.addAll(list);
                break;
            case GreaterThanOrEqual:
                list1 = index.getbTree().searchList(value);
                if (list1 != null && list1.size() > 0) offsetList.addAll(list1);
                list = index.getbTree().searchGreater(value);
                if (list != null && list.size() > 0)
                    offsetList.addAll(list);
                break;
            case LessThan:
                list = index.getbTree().searchLesser(value);
                if (list != null && list.size() > 0)
                    offsetList.addAll(list);
                break;
            case LessThanOrEqual:
                list1 = index.getbTree().searchList(value);
                if (list1 != null && list1.size() > 0) offsetList.addAll(list1);
                list = index.getbTree().searchLesser(value);
                if (list != null && list.size() > 0)
                    offsetList.addAll(list);
                break;
            default:
                throw new DbException("unsupported operator");
        }
        iterator = offsetList.iterator();
    }

    @Override
    public boolean hasNext() {
        if (iterator == null) throw new DbException("the iterator has not opened");
        return iterator.hasNext();
    }

    @Override
    public Tuple next() {
        if (iterator == null) throw new DbException("the iterator has not opened");
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == -1) continue;
            int blockNo = next / BLOCK_SIZE;
            int dataOffset = next % BLOCK_SIZE;
            Block block = Buffer.getBlock(tableName, blockNo);
            block.setDataOffset(dataOffset);
            return Record.readTuple(block, tableName, tableAlias);
        }
        return null;
    }

    @Override
    public void rewind() {
        iterator = offsetList.iterator();
    }

    @Override
    public void close() {
        offsetList = new ArrayList<>();
        iterator = null;
    }
}
