package cn.ouctechnology.oodb.transcation;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Table;
import cn.ouctechnology.oodb.exception.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-10 15:34
 * @description: TODO
 **/
public class Transaction {

    public static void start() {
        Thread currentThread = Thread.currentThread();
        List<Block> blocks = TransactionMap.getThreadMap().get(currentThread);
        List<Table> tables = TransactionMap.getTableMap().get(currentThread);
        if (blocks != null || tables != null) throw new DbException("the transaction has already started");
        blocks = new ArrayList<>();
        tables = new ArrayList<>();
        TransactionMap.getThreadMap().put(currentThread, blocks);
        TransactionMap.getTableMap().put(currentThread, tables);
    }

    public static void commit() {
        Thread currentThread = Thread.currentThread();
        List<Block> blocks = TransactionMap.getThreadMap().get(currentThread);
        List<Table> tables = TransactionMap.getTableMap().get(currentThread);
        if (blocks == null || tables == null) throw new DbException("the transaction is not start");
        for (Block block : blocks) {
            if (block.getLock().isWriteLocked()) {
                Buffer.writeToDisk(block);
                block.getLock().writeLock().unlock();
            } else {
                block.getLock().readLock().unlock();
            }
        }
        for (Table table : tables) {
            synchronized (Transaction.class) {
                Catalog.dropTable(table.getTableName());
                Catalog.createTable(table);
            }
        }
        TransactionMap.getThreadMap().remove(currentThread);
        TransactionMap.getTableMap().remove(currentThread);
    }

    public static void rollback() {
        Thread currentThread = Thread.currentThread();
        rollback(currentThread);
    }

    public static void rollback(Thread currentThread) {
        List<Block> blocks = TransactionMap.getThreadMap().get(currentThread);
        if (blocks == null) throw new DbException("the transaction is not start");
        for (Block block : blocks) {
            if (block.getLock().isWriteLocked()) {
                block.rollBackImage();
                block.getLock().writeLock().unlock();
            } else {
                block.getLock().readLock().unlock();
            }
        }
        TransactionMap.getThreadMap().remove(currentThread);
        TransactionMap.getTableMap().remove(currentThread);
    }
}
