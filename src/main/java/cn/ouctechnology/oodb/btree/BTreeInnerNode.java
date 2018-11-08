package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.buffer.Block;

public class BTreeInnerNode<TKey extends Comparable<TKey>> extends BTreeNode<TKey> {
    protected int[] children;

    public BTreeInnerNode(BTree<TKey> bTree, int blockNo) {
        super(bTree, blockNo);
        //为什么children多一个？
        this.children = new int[size + 1];
    }

    public BTreeInnerNode(BTree<TKey> bTree, int blockNo, int keyCount, int parentNode, int leftSibling, int rightSibling) {
        super(bTree, blockNo, keyCount, parentNode, leftSibling, rightSibling);
        this.children = new int[size + 1];
    }

    @SuppressWarnings("unchecked")
    public int getChild(int index) {
        return this.children[index];
    }

    public void setChild(int index, int child) {
        dirty = true;
        this.children[index] = child;
    }

    @Override
    public TreeNodeType getNodeType() {
        return TreeNodeType.InnerNode;
    }

    @Override//todo 使用更加高效的二分查找
    public int search(TKey key) {
        int index = 0;
        for (index = 0; index < this.getKeyCount(); ++index) {
            int cmp = this.getKey(index).compareTo(key);
            if (cmp == 0) {
                return index + 1;
            } else if (cmp > 0) {
                return index;
            }
        }

        return index;
    }



    /* The codes below are used to support insertion operation */

    private void insertAt(int index, TKey key, int leftChildNo, int rightChildNo) {
        // move space for the new key
        dirty = true;
        for (int i = this.getKeyCount() + 1; i > index; --i) {
            this.setChild(i, this.getChild(i - 1));
        }
        for (int i = this.getKeyCount(); i > index; --i) {
            this.setKey(i, this.getKey(i - 1));
        }

        // insert the new key
        this.setKey(index, key);
        this.setChild(index, leftChildNo);
        getNode(leftChildNo).setParent(this.blockNo);
        this.setChild(index + 1, rightChildNo);
        getNode(rightChildNo).setParent(this.blockNo);
        this.keyCount += 1;
    }

    /**
     * When splits a internal node, the middle key is kicked out and be pushed to parent node.
     */
    @Override
    protected int split() {
        dirty = true;
        int midIndex = this.getKeyCount() / 2;

        BTreeInnerNode<TKey> newRNode = createInnerNode();
        for (int i = midIndex + 1; i < this.getKeyCount(); ++i) {
            newRNode.setKey(i - midIndex - 1, this.getKey(i));
            this.setKey(i, null);
        }
        for (int i = midIndex + 1; i <= this.getKeyCount(); ++i) {
            int child = this.getChild(i);
            newRNode.setChild(i - midIndex - 1, child);
            getNode(this.blockNo);
            getNode(child).setParent(newRNode.blockNo);
            this.setChild(i, -1);
        }
        this.setKey(midIndex, null);
        newRNode.keyCount = this.getKeyCount() - midIndex - 1;
        this.keyCount = midIndex;

        return newRNode.blockNo;
    }

    /**
     * 在父节点中添加分离后的中间节点，
     * 如果生成了新的根节点或者当前节点就是根节点
     * 则返回根节点，否则返回null
     */
    @Override
    protected int pushUpKey(TKey key, int leftChildNo, int rightNodeNo) {
        dirty = true;
        // find the target position of the new key
        int index = this.search(key);

        // insert the new key
        this.insertAt(index, key, leftChildNo, rightNodeNo);

        // check whether current node need to be split
        if (this.isOverflow()) {
            return this.dealOverflow();
        } else {
            return this.getParent() == -1 ? this.blockNo : -1;
        }
    }




    /* The codes below are used to support delete operation */

    private void deleteAt(int index) {
        dirty = true;
        int i = 0;
        for (i = index; i < this.getKeyCount() - 1; ++i) {
            this.setKey(i, this.getKey(i + 1));
            this.setChild(i + 1, this.getChild(i + 2));
        }
        this.setKey(i, null);
        this.setChild(i + 1, -1);
        --this.keyCount;
    }


    @Override
    protected void processChildrenTransfer(int borrowerNo, int lenderNo, int borrowIndex) {
        dirty = true;
        BTreeNode<TKey> borrower = getNode(blockNo);
        int borrowerChildIndex = 0;
        while (borrowerChildIndex < this.getKeyCount() + 1 && this.getChild(borrowerChildIndex) != borrowerNo)
            ++borrowerChildIndex;

        if (borrowIndex == 0) {
            // borrow a key from right sibling
            TKey upKey = borrower.transferFromSibling(this.getKey(borrowerChildIndex), lenderNo, borrowIndex);
            this.setKey(borrowerChildIndex, upKey);
        } else {
            // borrow a key from left sibling
            TKey upKey = borrower.transferFromSibling(this.getKey(borrowerChildIndex - 1), lenderNo, borrowIndex);
            this.setKey(borrowerChildIndex - 1, upKey);
        }
    }

    @Override
    protected int processChildrenFusion(int leftChildNo, int rightChildNo) {
        dirty = true;
        BTreeNode<TKey> leftChild = getNode(leftChildNo);
        int index = 0;
        while (index < this.getKeyCount() && this.getChild(index) != leftChildNo)
            ++index;
        TKey sinkKey = this.getKey(index);

        // merge two children and the sink key into the left child node
        leftChild.fusionWithSibling(sinkKey, rightChildNo);
        /**
         * 合并叶节点，一定伴随着内部节点的key的删除操作
         */
        // remove the sink key, keep the left child and abandon the right child
        this.deleteAt(index);

        // check whether need to propagate borrow or fusion to parent
        if (this.isUnderflow()) {
            if (this.getParent() == -1) {
                // current node is root, only remove keys or delete the whole root node
                if (this.getKeyCount() == 0) {
                    leftChild.setParent(-1);
                    return leftChildNo;
                } else {
                    return -1;
                }
            }

            return this.dealUnderflow();
        }

        return -1;
    }


    @Override
    protected void fusionWithSibling(TKey sinkKey, int rightSiblingNo) {
        dirty = true;
        BTreeNode<TKey> rightSibling = getNode(rightSiblingNo);
        BTreeInnerNode<TKey> rightSiblingNode = (BTreeInnerNode<TKey>) rightSibling;

        int j = this.getKeyCount();
        this.setKey(j++, sinkKey);

        for (int i = 0; i < rightSiblingNode.getKeyCount(); ++i) {
            this.setKey(j + i, rightSiblingNode.getKey(i));
        }
        for (int i = 0; i < rightSiblingNode.getKeyCount() + 1; ++i) {
            int child = rightSiblingNode.getChild(i);
            getNode(this.blockNo);
            this.setChild(j + i, child);
            getNode(child).setParent(this.blockNo);
        }
        this.keyCount += 1 + rightSiblingNode.getKeyCount();

        this.setRightSibling(rightSiblingNode.rightSibling);
        if (rightSiblingNode.rightSibling != -1)
            getNode(rightSiblingNode.rightSibling).setLeftSibling(this.blockNo);
    }

    @Override
    protected TKey transferFromSibling(TKey sinkKey, int siblingNo, int borrowIndex) {
        dirty = true;
        BTreeNode<TKey> sibling = getNode(siblingNo);
        BTreeInnerNode<TKey> siblingNode = (BTreeInnerNode<TKey>) sibling;

        TKey upKey = null;
        if (borrowIndex == 0) {
            // borrow the first key from right sibling, append it to tail
            int index = this.getKeyCount();
            this.setKey(index, sinkKey);
            int child = siblingNode.getChild(borrowIndex);
            this.setChild(index + 1, child);
            getNode(this.blockNo);
            getNode(child).setParent(this.blockNo);
            this.keyCount += 1;

            upKey = siblingNode.getKey(0);
            siblingNode.deleteAt(borrowIndex);
        } else {
            // borrow the last key from left sibling, insert it to head
            this.insertAt(0, sinkKey, siblingNode.getChild(borrowIndex + 1), this.getChild(0));
            upKey = siblingNode.getKey(borrowIndex);
            siblingNode.deleteAt(borrowIndex);
        }
        return upKey;
    }

    @Override
    public void writeToBlock(Block block) {
        block.setDataOffset(0);
        block.writeInt(0);
        super.writeToBlock(block);
        for (int i = 0; i <= this.getKeyCount(); i++) {
            block.writeInt(getChild(i));
        }
    }
}