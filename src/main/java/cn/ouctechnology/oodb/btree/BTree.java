package cn.ouctechnology.oodb.btree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @param <TKey>   必须是Comparable的子类，方便代用compare方法
 * @param <TValue>
 * @program: db
 * @description: B+树数据结构，采用类似MyIsam的非聚簇索引解决方案
 * @author: ZQX
 * @create: 2018-09-06 09:24
 **/
public class BTree<TKey extends Comparable<TKey>, TValue> {
    private BTreeNode<TKey> root;

    public BTree() {
        this.root = new BTreeLeafNode<TKey, TValue>();
    }

    /**
     * 向B+树种插入key,value
     *
     * @param key
     * @param value
     */
    public void insert(TKey key, TValue value) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
        leaf.insertKey(key, value);
        //leaf溢出
        if (leaf.isOverflow()) {
            BTreeNode<TKey> n = leaf.dealOverflow();
            //如果生成了根节点，则更新root
            if (n != null)
                this.root = n;
        }
    }

    /**
     * 在B+树种搜索key
     *
     * @param key
     * @return
     */
    public TValue search(TKey key) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        int index = leaf.search(key);
        return (index == -1) ? null : leaf.getValue(index);
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
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            BTreeNode<TKey> n = leaf.dealUnderflow();
            if (n != null)
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
    private BTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
        BTreeNode<TKey> node = this.root;
        while (node.getNodeType() == TreeNodeType.InnerNode) {
            node = ((BTreeInnerNode<TKey>) node).getChild(node.search(key));
        }

        return (BTreeLeafNode<TKey, TValue>) node;
    }

    /**
     * B+树的层序遍历，打印此B+树的结构
     */
    public void print() {
        Queue<BTreeNode> queue = new ArrayDeque<>();
        queue.offer(this.root);
        int start = 0;
        int end = queue.size();
        while (!queue.isEmpty()) {
            BTreeNode node = queue.poll();
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

}
