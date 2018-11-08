package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;

import java.util.*;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.constant.Constants.MAX_NUM_OF_NODE;

/**
 * @param <TKey> 必须是Comparable的子类，方便代用compare方法
 * @program: db
 * @description: B+树数据结构，采用类似MyIsam的非聚簇索引解决方案
 * @author: ZQX
 * @create: 2018-09-06 09:24
 **/
public class BTree<TKey extends Comparable<TKey>> {
    private int root;
    private String fileName;
    private Attribute attribute;
    private int lastBlockNo;
    private int current;
    private BTreeNode<TKey> head;
    private BTreeNode<TKey> tail;
    private Map<Integer, BTreeNode<TKey>> bTreeNodeMap;


    public BTree(String fileName, Attribute attribute, int lastBlockNo, int root) {
        this.fileName = fileName;
        this.lastBlockNo = lastBlockNo;
        this.attribute = attribute;
        this.current = 0;
        head = new BTreeLeafNode<>(this, -1);
        tail = new BTreeLeafNode<>(this, -1);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        bTreeNodeMap = new HashMap<>(MAX_NUM_OF_NODE);
        this.root = root;
        if (lastBlockNo == 0) createLeafNode();
    }


    public BTreeNode<TKey> getNode(int blockNo) {
        if (current >= MAX_NUM_OF_NODE) {
            deleteBlock(head.next);
        }
        BTreeNode<TKey> bTreeNode = bTreeNodeMap.get(blockNo);
        if (bTreeNode != null) {
            moveToTail(bTreeNode);
            return bTreeNode;
        }
//        System.out.println("GET FROM BUFFER:" + blockNo);
        //一级缓存中没有，去二级缓存中找
        Block block = Buffer.getBlock(fileName, blockNo);
        bTreeNode = block.readBTreeNode(this);
        putInList(bTreeNode);
        return bTreeNode;
    }

    public BTreeInnerNode<TKey> createInnerNode() {
        BTreeInnerNode<TKey> innerNode = new BTreeInnerNode<>(this, lastBlockNo);
        lastBlockNo++;
        innerNode.dirty = true;
        putInList(innerNode);
        return innerNode;
    }

    public BTreeLeafNode<TKey> createLeafNode() {
        BTreeLeafNode<TKey> leafNode = new BTreeLeafNode<>(this, lastBlockNo);
        lastBlockNo++;
        leafNode.dirty = true;
        putInList(leafNode);
        return leafNode;
    }


    private void deleteBlock(BTreeNode<TKey> bTreeNode) {
//        System.out.println("DELETE BLOCK:" + bTreeNode.blockNo);
        current--;
        //刷新到磁盘
        bTreeNode.pre.next = bTreeNode.next;
        bTreeNode.next.pre = bTreeNode.pre;
        bTreeNodeMap.remove(bTreeNode.blockNo);
        if (bTreeNode.dirty) {
            //todo 删除node，要获取buffer,是否会发生抖动？
            Block block = Buffer.getBlock(fileName, bTreeNode.blockNo);
            bTreeNode.writeToBlock(block);
        }
    }

    private void moveToTail(BTreeNode<TKey> bTreeNode) {
        bTreeNode.pre.next = bTreeNode.next;
        bTreeNode.next.pre = bTreeNode.pre;
        bTreeNode.pre = tail.pre;
        tail.pre.next = bTreeNode;
        tail.pre = bTreeNode;
        bTreeNode.next = tail;
    }

    private void putInList(BTreeNode<TKey> bTreeNode) {
        current++;
        bTreeNodeMap.put(bTreeNode.blockNo, bTreeNode);
        bTreeNode.pre = tail.pre;
        tail.pre.next = bTreeNode;
        tail.pre = bTreeNode;
        bTreeNode.next = tail;
    }

    /**
     * 关闭缓冲区，同步脏数据
     */
    public void close() {
        BTreeNode<TKey> iterator = head.next;
        while (iterator != tail) {
            if (iterator.dirty) {
                Block block = Buffer.getBlock(fileName, iterator.blockNo);
                iterator.writeToBlock(block);
                iterator.dirty = false;
            }
            iterator = iterator.next;
        }
    }

    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * 向B+树种插入key,value
     *
     * @param key
     * @param value
     */
    public void insert(TKey key, int value) {
        BTreeLeafNode<TKey> leaf = this.findLeafNodeShouldContainKey(key);
        leaf.insertKey(key, value);
        //leaf溢出
        if (leaf.isOverflow()) {
            int n = leaf.dealOverflow();
            //如果生成了根节点，则更新root
            if (n != -1)
                this.root = n;
        }
    }

    /**
     * 在B+树种搜索key
     *
     * @param key
     * @return
     */
    public int search(TKey key) {
        BTreeLeafNode<TKey> leaf = this.findLeafNodeShouldContainKey(key);

        int index = leaf.search(key);
        return (index == -1) ? -1 : leaf.getValue(index);
    }

    /**
     * 在B+树种搜索key
     *
     * @param key
     * @return
     */
    public List<Integer> searchList(TKey key) {
        BTreeLeafNode<TKey> leaf = this.findLeafNodeShouldContainKey(key);
        List<Integer> list = leaf.searchList(key);
        List<Integer> resList = new ArrayList<>();
        if (list != null) {
            resList.addAll(list.stream().map(leaf::getValue).collect(Collectors.toList()));
        }
        while (leaf.leftSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(leaf.leftSibling);
            List<Integer> leftList = node.searchList(key);
            if (leftList == null) break;
            resList.addAll(leftList.stream().map(leaf::getValue).collect(Collectors.toList()));
        }
        while (leaf.rightSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(leaf.rightSibling);
            List<Integer> rightList = node.searchList(key);
            if (rightList == null) break;
            resList.addAll(rightList.stream().map(leaf::getValue).collect(Collectors.toList()));
        }
        if (resList.size() == 0) return null;
        return resList;
    }

    public List<Integer> searchRange(TKey minKey, TKey maxKey) {
        BTreeLeafNode<TKey> maxLeaf = this.findLeafNodeShouldContainKey(maxKey);
        while (maxLeaf.rightSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(maxLeaf.rightSibling);
            int search = node.search(maxKey);
            if (search == -1) break;
            maxLeaf = node;
        }
        Integer maxIndex = Collections.max(maxLeaf.searchList(maxKey));

        BTreeLeafNode<TKey> minLeaf = this.findLeafNodeShouldContainKey(minKey);
        while (minLeaf.leftSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(minLeaf.leftSibling);
            int search = node.search(minKey);
            if (search == -1) break;
            minLeaf = node;
        }
        Integer minIndex = Collections.min(minLeaf.searchList(minKey));
        if (maxLeaf == minLeaf && minIndex > maxIndex) return null;
        List<Integer> resList = new ArrayList<>();
        if (maxLeaf == minLeaf) {
            for (int i = minIndex; i <= maxIndex; i++) {
                resList.add(minLeaf.getValue(i));
            }
            return resList;
        }
        for (int i = minIndex; i < minLeaf.getKeyCount(); i++) {
            resList.add(minLeaf.getValue(i));
        }
        for (int i = 0; i <= maxIndex; i++) {
            resList.add(maxLeaf.getValue(i));
        }
        while (minLeaf.rightSibling != -1) {
            minLeaf = (BTreeLeafNode<TKey>) getNode(minLeaf.rightSibling);
            if (minLeaf == maxLeaf) break;
            int keyCount = minLeaf.getKeyCount();
            for (int i = 0; i < keyCount; i++) {
                resList.add(minLeaf.getValue(i));
            }
        }
        return resList;
    }

    public List<Integer> searchGreater(TKey minKey) {

        BTreeLeafNode<TKey> minLeaf = this.findLeafNodeShouldContainKey(minKey);
        while (minLeaf.leftSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(minLeaf.leftSibling);
            int search = node.search(minKey);
            if (search == -1) break;
            minLeaf = node;
        }
        Integer minIndex = minLeaf.searchGreater(minKey);
        if (minIndex == -1) return null;
        List<Integer> resList = new ArrayList<>();
        for (int i = minIndex; i < minLeaf.getKeyCount(); i++) {
            resList.add(minLeaf.getValue(i));
        }
        while (minLeaf.rightSibling != -1) {
            minLeaf = (BTreeLeafNode<TKey>) getNode(minLeaf.rightSibling);
            int keyCount = minLeaf.getKeyCount();
            for (int i = 0; i < keyCount; i++) {
                resList.add(minLeaf.getValue(i));
            }
        }
        return resList;
    }

    public List<Integer> searchLesser(TKey maxKey) {

        BTreeLeafNode<TKey> maxLeaf = this.findLeafNodeShouldContainKey(maxKey);
        while (maxLeaf.rightSibling != -1) {
            BTreeLeafNode<TKey> node = (BTreeLeafNode<TKey>) getNode(maxLeaf.rightSibling);
            int search = node.search(maxKey);
            if (search == -1) break;
            maxLeaf = node;
        }
        Integer maxIndex = maxLeaf.searchLesser(maxKey);
        if (maxIndex == -1) return null;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i <= maxIndex; i++) {
            resList.add(maxLeaf.getValue(i));
        }
        while (maxLeaf.leftSibling != -1) {
            maxLeaf = (BTreeLeafNode<TKey>) getNode(maxLeaf.leftSibling);
            int keyCount = maxLeaf.getKeyCount();
            for (int i = 0; i < keyCount; i++) {
                resList.add(maxLeaf.getValue(i));
            }
        }
        return resList;
    }

    /**
     * 删除流程：
     * 1、直接在中删除相关的key
     * 2、判断当前节点是否下溢，未下溢，直接返回
     * 3、下溢之后，先尝试从左右兄弟节点借一个key（只有同一个父亲的才是兄弟节点）
     * 4、如果能借，则要借key，借key不涉及父节点中key的删除，只涉及父节点中key的修改
     * 5、在父节点中找到受到影响的keyIndex，执行子节点的借key操作，返回新的边界值skinKey
     * 6、在父节点中替换相关的值
     * 7、若果不能借key,则要执行合并操作，合并一定涉及父节点中key的删除操作
     * 8、找到需要合并的两个节点，如果是叶节点，在在父节点中找到受影响的keyIndex
     * 9、合并子节点，然后删除父节点中keyIndex位置的key
     * 10、递归判断父节点是否下溢，与叶节点不同的是，内部节点合并之后，父节点中
     * 11、keyIndex位置上的key不能删除，而是落到子节点中，因为要继续index叶节点
     */

    /**
     * 在B+树种删除key
     * 删除的时候要考虑下溢
     */
    public void delete(TKey key) {
        BTreeLeafNode<TKey> leaf = this.findLeafNodeShouldContainKey(key);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            int n = leaf.dealUnderflow();
            if (n != -1)
                this.root = n;
        }
    }

    /**
     * 在B+树种从上到下寻找包含这个key的叶节点
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    private BTreeLeafNode<TKey> findLeafNodeShouldContainKey(TKey key) {
        BTreeNode<TKey> node = getNode(this.root);
        while (node.getNodeType() == TreeNodeType.InnerNode) {
            node = getNode(((BTreeInnerNode<TKey>) node).getChild(node.search(key)));
        }

        return (BTreeLeafNode<TKey>) node;
    }

    /**
     * B+树的层序遍历，打印此B+树的结构
     */
    public void print() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(this.root);
        int start = 0;
        int end = queue.size();
        while (!queue.isEmpty()) {
            BTreeNode<TKey> node = getNode(queue.poll());
            printNode(node);
            if (node.getNodeType() == TreeNodeType.InnerNode) {
                BTreeInnerNode innerNode = (BTreeInnerNode) node;
                for (int i = 0; i <= innerNode.getKeyCount(); i++) {
                    queue.offer(innerNode.getChild(i));
                }
            }
            start++;
            if (start == end) {
                System.out.println();
                start = 0;
                end = queue.size();
            }
        }
    }

    private void printNode(BTreeNode<TKey> node) {
        for (int i = 0; i < node.getKeyCount(); i++) {
            System.out.print(node.getKey(i) + " ");
        }
        System.out.print("\t");
    }

    public int getRoot() {
        return root;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLastBlockNo() {
        return lastBlockNo;
    }
}
