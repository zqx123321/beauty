package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;

import static cn.ouctechnology.oodb.constant.Constants.BLOCK_SIZE;
import static cn.ouctechnology.oodb.constant.Constants.SIZE_INT;

enum TreeNodeType {
    InnerNode,
    LeafNode
}

public abstract class BTreeNode<TKey extends Comparable<TKey>> {
    protected TKey[] keys;
    protected int keyCount;
    protected int parentNode;
    protected int leftSibling;
    protected int rightSibling;
    protected int blockNo;
    protected int size;
    protected BTree<TKey> bTree;
    BTreeNode<TKey> pre;
    BTreeNode<TKey> next;
    boolean dirty;


    protected BTreeNode(BTree<TKey> bTree, int blockNo) {
        this.keyCount = 0;
        this.parentNode = -1;
        this.leftSibling = -1;
        this.rightSibling = -1;
        this.bTree = bTree;
        this.blockNo = blockNo;
        this.dirty = false;
        this.size = (BLOCK_SIZE - 5 * SIZE_INT) / (SIZE_INT + bTree.getAttribute().getLength()) - 1;
        this.keys = (TKey[]) new Comparable[this.size];
    }

    public BTreeNode(BTree<TKey> bTree, int blockNo, int keyCount, int parentNode, int leftSibling, int rightSibling) {
        this.keyCount = keyCount;
        this.parentNode = parentNode;
        this.leftSibling = leftSibling;
        this.rightSibling = rightSibling;
        this.blockNo = blockNo;
        this.bTree = bTree;
        this.dirty = false;
        this.size = (BLOCK_SIZE - 5 * SIZE_INT) / (SIZE_INT + bTree.getAttribute().getLength()) - 1;
        this.keys = (TKey[]) new Comparable[this.size];
    }

    protected BTreeNode<TKey> getNode(int blockNo) {
        return bTree.getNode(blockNo);
    }

    protected BTreeInnerNode<TKey> createInnerNode() {
        return bTree.createInnerNode();
    }

    protected BTreeLeafNode<TKey> createLeafNode() {
        return bTree.createLeafNode();
    }

    public int getKeyCount() {
        return this.keyCount;
    }

    @SuppressWarnings("unchecked")
    public TKey getKey(int index) {
        return (TKey) this.keys[index];
    }

    public void setKey(int index, TKey key) {
        dirty = true;
        this.keys[index] = key;
    }

    public int getParent() {
        return this.parentNode;
    }

    public void setParent(int parent) {
        dirty = true;
        this.parentNode = parent;
    }


    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public abstract TreeNodeType getNodeType();

    /**
     * Search a key on current node, if found the key then return its position,
     * otherwise return -1 for a leaf node,
     * return the child node btree which should contain the key for a internal node.
     */
    public abstract int search(TKey key);

    public void writeToBlock(Block block) {
        block.writeInt(parentNode);
        block.writeInt(rightSibling);
        block.writeInt(leftSibling);
        int keyCount = this.keyCount;
        block.writeInt(keyCount);
        Attribute attribute = bTree.getAttribute();
        for (int i = 0; i < keyCount; i++) {
            TKey key = getKey(i);
            attribute.writeValue(block, key);
        }
    }





    /* The codes below are used to support insertion operation */

    public boolean isOverflow() {
        return this.getKeyCount() == this.keys.length;
    }

    /**
     * 从下向上处理溢出，是一个递归的过程
     */
    public int dealOverflow() {
        //取中间节点
        int midIndex = this.getKeyCount() / 2;
        TKey upKey = this.getKey(midIndex);
        //分裂出右节点
        BTreeNode<TKey> newRNode = getNode(this.split());

        //如果是根节点分裂，则生成新的根节点
        if (this.getParent() == -1) {
            this.setParent(createInnerNode().blockNo);
        }
        newRNode.setParent(this.getParent());
        //串接双向链表
        // maintain links of sibling nodes
        newRNode.setLeftSibling(this.blockNo);
        newRNode.setRightSibling(this.rightSibling);
        if (rightSibling != -1)
            getNode(this.rightSibling).setLeftSibling(newRNode.blockNo);
        this.setRightSibling(newRNode.blockNo);

        // push up a key to parent internal node
        //返回生成的根节点
        return getNode(this.getParent()).pushUpKey(upKey, this.blockNo, newRNode.blockNo);
    }

    protected abstract int split();

    protected abstract int pushUpKey(TKey key, int leftChildNo, int rightNodeNo);






    /* The codes below are used to support deletion operation */
    //如果factor小于0.5，定义为下溢

    public boolean isUnderflow() {
        return this.getKeyCount() < (this.keys.length / 2);
    }

    public boolean canLendAKey() {
        return this.getKeyCount() > (this.keys.length / 2);
    }

    //是兄弟的前提是同一个父亲
    public int getLeftSibling() {
        if (this.leftSibling != -1 /*&& getNode(this.leftSibling).getParent() == this.getParent()*/)
            return this.leftSibling;
        return -1;
    }

    public void setLeftSibling(int sibling) {
        this.leftSibling = sibling;
    }

    public int getRightSibling() {
        if (this.rightSibling != -1 /*&& getNode(this.rightSibling).getParent() == this.getParent()*/)
            return this.rightSibling;
        return -1;
    }

    public void setRightSibling(int silbling) {
        this.rightSibling = silbling;
    }

    public int dealUnderflow() {
        if (this.getParent() == -1)
            return -1;

        // try to borrow a key from sibling
        if (leftSibling != -1 && getNode(leftSibling).getParent() == this.getParent() && getNode(leftSibling).canLendAKey()) {
            getNode(this.getParent()).processChildrenTransfer(this.blockNo, leftSibling, getNode(leftSibling).getKeyCount() - 1);
            return -1;
        }

        if (rightSibling != -1 && getNode(rightSibling).getParent() == this.getParent() && getNode(rightSibling).canLendAKey()) {
            getNode(this.getParent()).processChildrenTransfer(this.blockNo, rightSibling, 0);
            return -1;
        }

        // Can not borrow a key from any sibling, then do fusion with sibling
        if (leftSibling != -1) {
            return getNode(this.getParent()).processChildrenFusion(leftSibling, this.blockNo);
        } else {
            return getNode(this.getParent()).processChildrenFusion(this.blockNo, rightSibling);
        }
    }

    protected abstract void processChildrenTransfer(int borrowerNo, int lenderNo, int borrowIndex);

    protected abstract int processChildrenFusion(int leftChildNo, int rightChildNo);

    protected abstract void fusionWithSibling(TKey sinkKey, int rightSiblingNo);

    protected abstract TKey transferFromSibling(TKey sinkKey, int siblingNo, int borrowIndex);
}