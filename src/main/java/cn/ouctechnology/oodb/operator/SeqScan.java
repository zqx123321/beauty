package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;

import static cn.ouctechnology.oodb.constant.Constants.READ;
import static cn.ouctechnology.oodb.constant.Constants.TUPLE_AVAILABLE;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 20:01
 * @description: TODO
 **/
public class SeqScan implements DbIterator {


    private String tableName;

    private String tableAlias;

    private int tupleNum;

    private int tupleOffset;

    private int tupleScan;

    private int tupleLength;

    private boolean open;


    public SeqScan(String tableName, String tableAlias) {
        this.tableAlias = tableAlias;
        this.tableName = tableName;
        this.tupleNum = Catalog.getTupleNum(tableName);
        this.tupleOffset = 0;
        this.tupleScan = 0;
        this.tupleLength = Catalog.getTupleLength(tableName);
        this.open = false;
    }

    public SeqScan(String tableName) {
        this(tableName, tableName);
    }

    @Override
    public void open() {
        open = true;
        rewind();
    }

    @Override
    public boolean hasNext() {
        if (!open) throw new DbException("the iterator has not opened");
        return tupleScan < tupleNum;
    }

    @Override
    public Tuple next() {
        if (!open) throw new DbException("the iterator has not opened");
        while (hasNext()) {
            Block block = Record.getBlock(tableName, tupleOffset, READ);
            int isAvailable = block.readInt();
            int dataOffset = block.getDataOffset();
            if (isAvailable == TUPLE_AVAILABLE) {
                Tuple tuple = Record.readTuple(block, tableName, tableAlias);
                tupleScan++;
                tupleOffset++;
                block.setDataOffset(dataOffset + tupleLength);
                return tuple;
            }
            tupleOffset++;
            block.setDataOffset(dataOffset + tupleLength);
        }
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
