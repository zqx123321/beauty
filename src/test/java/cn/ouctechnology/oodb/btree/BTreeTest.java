package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.util.where.Op;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-06 14:21
 * @description: TODO
 **/
public class BTreeTest extends BaseTest {


    @Test
    public void insert() {
        Attribute attribute = Catalog.getAttribute("person", "id");
        BTree<Integer> bTree = new BTree<>("person.id.index", attribute, 0, 0);
        for (int i = 2; i < 20; i++) {
            bTree.insert(i, i);
        }
        bTree.delete(9, Op.LessThanOrEqual);
        bTree.print();
        System.out.println(bTree.getRoot());
        System.out.println(bTree.getLastBlockNo());
        bTree.close();

    }

}