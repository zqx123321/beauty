package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.btree.BTree;
import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Index;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.where.Op;

import java.util.ArrayList;
import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-09 09:41
 * @description: TODO
 **/
public class RebuildIndex implements DbIterator {

    private String tableName;

    private String tableAlias;

    private int tupleNum;

    private int tupleOffset;

    private int tupleScan;

    private int tupleLength;

    private boolean open;

    private Index index;

    private String field;

    private List<String> selectFieldList;


    public RebuildIndex(String tableName, String tableAlias, Index index) {
        this.tableAlias = tableAlias;
        this.tableName = tableName;
        this.tupleNum = Catalog.getTupleNum(tableName);
        this.tupleOffset = 0;
        this.tupleScan = 0;
        this.tupleLength = Catalog.getTupleLength(tableName);
        this.open = false;
        this.index = index;
        selectFieldList = new ArrayList<>();
        selectFieldList.add(index.getColumnName());
        field = tableAlias + "." + index.getColumnName();
    }

    public RebuildIndex(String tableName, Index index) {
        this(tableName, tableName, index);
    }

    @Override
    public void open() {
        open = true;
        rewind();
        BTree bTree = index.getbTree();
        while (hasNext()) {
            Block block = Record.getBlock(tableName, tupleOffset, READ);
            int isAvailable = block.readInt();
            int dataOffset = block.getDataOffset();
            if (isAvailable == TUPLE_AVAILABLE) {
                int offset = block.getBlockKey().blockOffset * BLOCK_SIZE + dataOffset;
                Tuple tuple = Record.readTuple(block, tableName, tableAlias, selectFieldList);
                Comparable key = (Comparable) tuple.get(field);
                List res = bTree.search(key, Op.Equality);
                if (res != null && res.size() > 0) throw new DbException("the index key can not have duplicate value");
                index.getbTree().insert(key, offset);
                tupleScan++;
                tupleOffset++;
                block.setDataOffset(dataOffset + tupleLength);
            } else {
                tupleOffset++;
                block.setDataOffset(dataOffset + tupleLength);
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (!open) throw new DbException("the iterator has not opened");
        return tupleScan < tupleNum;
    }

    @Override
    public Tuple next() {
        if (!open) throw new DbException("the iterator has not opened");
        return null;
    }

    @Override
    public void rewind() {
        if (!open) throw new DbException("the iterator has not opened");
        tupleScan = 0;
        tupleOffset = 0;
    }

    @Override
    public void close() {
        open = false;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableAlias() {
        return tableAlias;
    }
}
