package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.buffer.Block;

import java.util.Arrays;

public class BTreeLeafNode<TKey extends Comparable<TKey>> extends BTreeNode<TKey> {
    private int[] values;

    public BTreeLeafNode(BTree<TKey> bTree, int blockNo) {
        super(bTree, blockNo);
        this.values = new int[size];
    }

    public BTreeLeafNode(BTree<TKey> bTree, int blockNo, int keyCount, int parentNode, int leftSibling, int rightSibling) {
        super(bTree, blockNo, keyCount, parentNode, leftSibling, rightSibling);
        this.values = new int[size];
    }

    @SuppressWarnings("unchecked")
    public int getValue(int index) {
        return this.values[index];
    }

    public void setValue(int index, int value) {
        dirty = true;
        this.values[index] = value;
    }

    @Override
    public TreeNodeType getNodeType() {
        return TreeNodeType.LeafNode;
    }

    @Override
    public int search(TKey key) {
        int index = Arrays.binarySearch(keys, 0, getKeyCount(), key, Comparable::compareTo);
        if (index < 0) return -1;
        return index;
    }


    @Override
    public void writeToBlock(Block block) {
        block.setDataOffset(0);
        block.writeInt(1);
        super.writeToBlock(block);
        int keyCount = getKeyCount();
        for (int i = 0; i < keyCount; i++) {
            block.writeInt(getValue(i));
        }
    }


    /* The codes below are used to support insertion operation */

    public void insertKey(TKey key, int value) {
        dirty = true;
        int index = 0;
        while (index < this.getKeyCount() && this.getKey(index).compareTo(key) < 0)
            ++index;
        this.insertAt(index, key, value);
    }

    private void insertAt(int index, TKey key, int value) {
        dirty = true;
        // move space for the new key
        for (int i = this.getKeyCount() - 1; i >= index; --i) {
            this.setKey(i + 1, this.getKey(i));
            this.setValue(i + 1, this.getValue(i));
        }

        // insert new key and value
        this.setKey(index, key);
        this.setValue(index, value);
        ++this.keyCount;
    }


    /**
     * When splits a leaf node, the middle key is kept on new node and be pushed to parent node.
     * 从当前节点分裂出一个叶子节点
     */
    @Override
    protected int split() {
        dirty = true;
        int midIndex = this.getKeyCount() / 2;

        BTreeLeafNode<TKey> newRNode = createLeafNode();
        for (int i = midIndex; i < this.getKeyCount(); ++i) {
            newRNode.setKey(i - midIndex, this.getKey(i));
            newRNode.setValue(i - midIndex, this.getValue(i));
            this.setKey(i, null);
            this.setValue(i, -1);
        }
        newRNode.keyCount = this.getKeyCount() - midIndex;
        this.keyCount = midIndex;

        return newRNode.blockNo;
    }

    @Override
    protected int pushUpKey(TKey key, int leftChildNo, int rightNodeNo) {
        throw new UnsupportedOperationException();
    }




    /* The codes below are used to support deletion operation */

    public boolean delete(TKey key) {
        dirty = true;
        int index = this.search(key);
        if (index == -1)
            return false;

        this.deleteAt(index);
        return true;
    }

    public void deleteAt(int index) {
        dirty = true;
        int i = index;
        for (i = index; i < this.getKeyCount() - 1; ++i) {
            this.setKey(i, this.getKey(i + 1));
            this.setValue(i, this.getValue(i + 1));
        }
        this.setKey(i, null);
        this.setValue(i, -1);
        --this.keyCount;
    }

    @Override
    protected void processChildrenTransfer(int borrowerNo, int lenderNo, int borrowIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected int processChildrenFusion(int leftChildNo, int rightChildNo) {
        throw new UnsupportedOperationException();
    }

    /**
     * Notice that the key sunk from parent is be abandoned.
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void fusionWithSibling(TKey sinkKey, int rightSiblingNo) {
        dirty = true;
        BTreeNode<TKey> rightSibling = getNode(rightSiblingNo);
        BTreeLeafNode<TKey> siblingLeaf = (BTreeLeafNode<TKey>) rightSibling;

        int j = this.getKeyCount();
        for (int i = 0; i < siblingLeaf.getKeyCount(); ++i) {
            this.setKey(j + i, siblingLeaf.getKey(i));
            this.setValue(j + i, siblingLeaf.getValue(i));
        }
        this.keyCount += siblingLeaf.getKeyCount();

        this.setRightSibling(siblingLeaf.rightSibling);
        if (siblingLeaf.rightSibling != -1)
            getNode(siblingLeaf.rightSibling).setLeftSibling(this.blockNo);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected TKey transferFromSibling(TKey sinkKey, int siblingNo, int borrowIndex) {
        dirty = true;
        BTreeNode<TKey> sibling = getNode(siblingNo);
        BTreeLeafNode<TKey> siblingNode = (BTreeLeafNode<TKey>) sibling;

        this.insertKey(siblingNode.getKey(borrowIndex), siblingNode.getValue(borrowIndex));
        siblingNode.deleteAt(borrowIndex);

        return borrowIndex == 0 ? sibling.getKey(0) : this.getKey(0);
    }
}
