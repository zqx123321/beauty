package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Field;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.where.InnerNode;
import cn.ouctechnology.oodb.util.where.LeafNode;
import cn.ouctechnology.oodb.util.where.Op;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 20:36
 * @description: TODO
 **/
public class FilterTest extends BaseTest {

    @Test
    public void testFilter() {
        InnerNode innerNode2 = new InnerNode();
        //id=12
        innerNode2.setOperator(Op.Equality);
        innerNode2.setLeft(new LeafNode(12));
        innerNode2.setRight(new LeafNode(12));

        InnerNode innerNode1 = new InnerNode();
        //age=20
        innerNode1.setOperator(Op.GreaterThan);
        innerNode1.setLeft(new LeafNode(new Field("a.age")));
        innerNode1.setRight(new LeafNode((float) 20.0));

        InnerNode innerNode = new InnerNode();
        innerNode.setOperator(Op.AND);
        innerNode.setLeft(innerNode1);
        innerNode.setRight(innerNode2);

        DbIterator test = new SeqScan("test", "a");

        Filter filter = new Filter(test, innerNode);
        filter.open();
        while (filter.hasNext()) {
            Tuple next = filter.next();
            System.out.println(next);

        }
        filter.close();


    }
}