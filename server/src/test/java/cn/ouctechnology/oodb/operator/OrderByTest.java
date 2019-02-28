package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-30 16:49
 * @description: TODO
 **/
public class OrderByTest extends BaseTest {

    @Test
    public void testOrderBy() {
        DbIterator seqScan = new SeqScan("test", "a");
        OrderBy orderBy = new OrderBy(seqScan, "a.id", false);
        orderBy.open();

        while (orderBy.hasNext()) {
            Tuple next = orderBy.next();
            System.out.println(next);
        }
        orderBy.close();
    }

}