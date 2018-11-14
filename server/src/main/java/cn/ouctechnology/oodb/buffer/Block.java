package cn.ouctechnology.oodb.buffer;

import cn.ouctechnology.oodb.btree.BTree;
import cn.ouctechnology.oodb.btree.BTreeInnerNode;
import cn.ouctechnology.oodb.btree.BTreeLeafNode;
import cn.ouctechnology.oodb.btree.BTreeNode;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.util.ByteUtil;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static cn.ouctechnology.oodb.constant.Constants.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 13:35
 * @description: 缓冲区块，链表结构单元
 **/
public class Block implements Cloneable {
    //缓冲区块为一个byte数组
    byte[] data = new byte[BLOCK_SIZE];

    //区块索引
    BlockKey blockKey = new BlockKey();
    //标志此区块是否含有未同步的脏数据
    boolean dirty = false;

    //串接双向链表的指针
    Block next = null;
    Block pre = null;

    //块内偏移地址
    int dataOffset = 0;

    //非公平的读写锁
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    //最近引用这个block的线程
    Thread thread;
    //block包含的数据，用于事务回滚
    byte[] oldData;


    /**
     * 用于读出该区块包含的全部数据
     */
    public byte[] readData() {
        dataOffset = BLOCK_SIZE;
        return data;
    }


    /**
     * 将data数组中的数据写入到该区块offset偏移处
     *
     * @param data 待写入数据
     * @param size 待写入数据大小
     */
    public void writeData(byte data[], int size) {
        if (dataOffset + size >= BLOCK_SIZE) {
            throw new IndexOutOfBoundsException("the data size is larger than the left capacity");
        }
        if (size >= 0) System.arraycopy(data, 0, this.data, dataOffset, size);
        dirty = true;
        dataOffset += size;
    }


    /**
     * 从区块中的指定位置读出一个整数
     */
    public int readInt() {
        int res = ByteUtil.getInt(data, dataOffset);
        dataOffset += SIZE_INT;
        return res;
    }

    /**
     * 在区块指定位置处写入一个整数
     *
     * @param num 待写入整数
     */
    public void writeInt(int num) {
        dataOffset = ByteUtil.getBytes(num, data, dataOffset);
        dirty = true;
    }

    /**
     * 从区块中的指定位置读出一个浮点数
     */
    public float readFloat() {
        float res = ByteUtil.getFloat(data, dataOffset);
        dataOffset += SIZE_FLOAT;
        return res;
    }

    /**
     * 在区块指定位置处写入一个浮点数
     *
     * @param num 待写入浮点数
     */
    public void writeFloat(float num) {
        dataOffset = ByteUtil.getBytes(num, data, dataOffset);
        dirty = true;
    }


    /**
     * 从区块中的指定位置读出一个长度为length的字符串
     *
     * @param length 字符串长度
     * @return
     */
    public String readString(int length) {//用length来指定attribute的长度是几个字节。
        String res = ByteUtil.getString(data, dataOffset, length);
        //对于char类型数据，存储1个需要2字节
        dataOffset += 2 * length;
        return res;
    }


    /**
     * 在区块指定位置处写入一个字符串
     *
     * @param str    待写入字符串
     * @param length 字符串长度
     */
    public void writeString(String str, int length) {//用length来指定把string补0补到几个字节，
        dataOffset = ByteUtil.getBytes(str, data, dataOffset, length);
        dirty = true;
    }

    public int getDataOffset() {
        return dataOffset;
    }

    public void setDataOffset(int dataOffset) {
        this.dataOffset = dataOffset;
    }

    public void skipDataOffset(int skip) {
        dataOffset += skip;
    }

    public BlockKey getBlockKey() {
        return blockKey;
    }

    public <TKey extends Comparable<TKey>> BTreeNode<TKey> readBTreeNode(BTree<TKey> bTree) {
        setDataOffset(0);
        int isLeaf = readInt();
        int parent = readInt();
        int right = readInt();
        int left = readInt();
        int keyCount = readInt();
        Attribute attribute = bTree.getAttribute();
        if (isLeaf == 1) {
            BTreeLeafNode<TKey> bTreeLeafNode = new BTreeLeafNode<>(bTree, blockKey.blockOffset, keyCount, parent, left, right);
            for (int i = 0; i < keyCount; i++) {
                Object key = attribute.read(this);
                bTreeLeafNode.setKey(i, (TKey) key);
            }
            for (int i = 0; i < keyCount; i++) {
                bTreeLeafNode.setValue(i, readInt());
            }
            return bTreeLeafNode;
        }
        BTreeInnerNode<TKey> bTreeInnerNode = new BTreeInnerNode<>(bTree, blockKey.blockOffset, keyCount, parent, left, right);
        for (int i = 0; i < keyCount; i++) {
            Object key = attribute.read(this);
            bTreeInnerNode.setKey(i, (TKey) key);
        }
        for (int i = 0; i <= keyCount; i++) {
            int child = readInt();
            bTreeInnerNode.setChild(i, child);
        }
        return bTreeInnerNode;
    }

    /**
     * 保存镜像
     */
    public void setImage() {
        if (oldData == null) oldData = new byte[BLOCK_SIZE];
        System.arraycopy(data, 0, oldData, 0, BLOCK_SIZE);
    }

    /**
     * 恢复镜像
     */
    public void rollBackImage() {
        System.arraycopy(oldData, 0, data, 0, BLOCK_SIZE);
    }

    public ReentrantReadWriteLock getLock() {
        return lock;
    }

    public boolean isLocked() {
        return lock != null && (lock.isWriteLocked() || lock.getReadHoldCount() > 0);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new DbException(e);
        }
    }
}
