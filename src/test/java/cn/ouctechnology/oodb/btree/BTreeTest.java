package cn.ouctechnology.oodb.btree;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
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
        BTree<Integer> bTree = new BTree<>("person.id.index", attribute, 747, 549);
//        for (int i = 2; i < 1000; i++) {
//            bTree.insert(i, i + 10000);
//        }
        System.out.println(bTree.searchGreater(444));
        System.out.println(bTree.getRoot());
        System.out.println(bTree.getLastBlockNo());
        bTree.close();

    }
}