package cn.ouctechnology.oodb.buffer;

import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.transcation.TransactionMap;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.ouctechnology.oodb.constant.Constants.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 13:35
 * @description: 缓冲区，采用LRU置换算法，数据结构为双向链表+HashSet
 **/
public class Buffer {
    private static Logger logger = LoggerFactory.getLogger(Buffer.class);

    //存储区块的HashMap，key为文件名称和区块在文件中偏移量的组合
    private static Map<BlockKey, Block> blockMap = new HashMap<>(MAX_NUM_OF_BLOCKS);
    //缓冲区中当前区块的数目
    private static int size = 0;
    //头区块
    private static Block head;
    //尾区块
    private static Block tail;


    /**
     * 初始化头尾结点
     */
    public static void init() {
        head = new Block();
        tail = new Block();
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
    }


    /**
     * 关闭缓冲区，同步脏数据
     */
    public static void close() {
        Block iterator = head.next;
        while (iterator != tail) {
            if (iterator.dirty) writeToDisk(iterator);
            iterator = iterator.next;
        }
    }

    /**
     * 将tableName涉及的buffer全部写入磁盘
     *
     * @param tableName
     */
    public static void writeToDisk(String tableName) {
        Block iterator = head.next;
        while (iterator != tail) {
            if (iterator.blockKey.filename.equals(tableName)) {
                Block next = iterator.next;
                deleteBlock(iterator.blockKey);
                iterator = next;
            } else {
                iterator = iterator.next;
            }
        }
    }

    /**
     * 向缓存中添加区块
     *
     * @param blockKey 区块索引
     */
    private static Block addBlocks(BlockKey blockKey) {
        size++;
        Block block = new Block();
        block.blockKey = blockKey;
        block.dirty = false;
        readFromDisk(blockKey.filename, blockKey.blockOffset, block);
        block.pre = tail.pre;
        tail.pre.next = block;
        tail.pre = block;
        block.next = tail;
        blockMap.put(blockKey, block);
        return block;
    }

    /**
     * 将指定区块移到链表的尾部，用于LRU置换
     *
     * @param block 区块
     */
    private static void moveToTail(Block block) {
        block.pre.next = block.next;
        block.next.pre = block.pre;
        block.pre = tail.pre;
        tail.pre.next = block;
        tail.pre = block;
        block.next = tail;
    }

    /**
     * 将指定区块从缓冲区中删除
     *
     * @param blockKey 区块索引
     */
    private static void deleteBlock(BlockKey blockKey) {
        size--;
        Block block = blockMap.get(blockKey);
        //刷新到磁盘
        if (block.dirty) writeToDisk(block);
        block.pre.next = block.next;
        block.next.pre = block.pre;
        blockMap.remove(blockKey);
        //级联删除
        if (size >= MAX_NUM_OF_BLOCKS) {
            Block firstBlock = getFirstBlockCanBeDeleted();
            if (firstBlock != null) deleteBlock(firstBlock.blockKey);
        }
    }


    /**
     * 根据文件名和块编号查找相应的区块
     *
     * @param filename 文件名
     * @param offset   块编号
     * @return 相应区块
     */
    private static Block getBlock(String filename, int offset) {
        //先查询这个区块是否已经调入内存
        BlockKey blockKey = new BlockKey(filename, offset);
        if (blockMap.containsKey(blockKey)) {
            //TODO 是在此处moveToTail还是在Block中的每次操作都moveToTail
            Block block = blockMap.get(blockKey);
            moveToTail(block);
            return block;
        }
        //没有调入内存,并且缓冲区大小未满，直接添加该区块
        if (size < MAX_NUM_OF_BLOCKS) {
            return addBlocks(blockKey);
        }
        //缓冲区满了，执行LRU替换算法
        //删除最近最久未使用的区块
        Block firstBlock = getFirstBlockCanBeDeleted();
        if (firstBlock != null)
            deleteBlock(firstBlock.blockKey);
        //重新添加区块
        return addBlocks(blockKey);
    }

    /**
     * 从头寻找第一个没有被加锁的block
     */
    private static Block getFirstBlockCanBeDeleted() {
        Block next = head.next;
        while (next.isLocked() && next != tail) {
            next = next.next;
        }
        if (next == tail) return null;
        return next;
    }

    /**
     * 根据文件名和块编号查找相应的区块
     *
     * @param filename 文件名
     * @param offset   块编号
     * @param mode     读写标志
     * @return 相应区块
     */
    public static Block getBlock(String filename, int offset, int mode) {
        Thread thread = Thread.currentThread();
        //存在与当前线程关联的事务
        if (TransactionMap.getThreadMap().containsKey(thread)) {
            return getBlockTransaction(filename, offset, mode);
        }
        return getBlock(filename, offset);
    }

    private static Block getBlockTransaction(String filename, int offset, int mode) {
        Block block = getBlock(filename, offset);
        Thread thread = Thread.currentThread();
        List<Block> blocks = TransactionMap.getThreadMap().get(thread);
        //不管什么模式，只要获取过，就给他
        if (blocks.contains(block)) {
            if (mode == WRITE) {
                if (!block.lock.isWriteLockedByCurrentThread()) {
                    block.lock.readLock().unlock();
                    block.lock.writeLock().lock();
                }
                if (block.thread != thread) {
                    block.setImage();
                    block.thread = thread;
                }
            }
            return block;
        }
        if (mode == Constants.READ) {
            block.lock.readLock().lock();
            //获取锁后，添加进与线程相关的map中
            blocks.add(block);
            return (Block) block.clone();
        }
        block.lock.writeLock().lock();
        //如果线程变了，则保存镜像
        if (block.thread != thread) {
            block.setImage();
            block.thread = thread;
        }
        //获取锁后，添加进与线程相关的map中
        blocks.add(block);
        return block;
    }

    /**
     * 从文件中调入该区块到指定区块
     *
     * @param filename 文件名
     * @param offset   偏移量
     * @param block    指定区块
     */
    private static void readFromDisk(String filename, int offset, Block block) {
        RandomAccessFile raf = null;
        try {
            //raf会自动创建父级目录
            raf = new RandomAccessFile(DB_PATH + filename + RECORD_SUFFIX, "rw");
            //读取内容，检查是否越界
            if (raf.length() >= offset * BLOCK_SIZE + BLOCK_SIZE) {
                raf.seek(offset * BLOCK_SIZE);
                raf.read(block.data, 0, BLOCK_SIZE);
            }
        } catch (Exception e) {
            logger.error("read from disk to block error:" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(raf);
        }
    }

    /**
     * 将block区块中的内容写回到文件
     *
     * @param block
     */
    public static void writeToDisk(Block block) {
        if (!block.dirty) {
            return;
        }
        File file = null;
        RandomAccessFile raf = null;
        try {
            file = new File(DB_PATH + block.blockKey.filename + RECORD_SUFFIX);
            //创建父目录
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) parentFile.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }
            raf = new RandomAccessFile(file, "rw");
            raf.seek(block.blockKey.blockOffset * BLOCK_SIZE);
            raf.write(block.data);
        } catch (IOException e) {
            logger.error("write to disk error:" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(raf);
        }
    }
}
