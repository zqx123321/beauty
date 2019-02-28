package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 16:49
 * @description: TODO
 **/
public class LimitTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator seqScan = new SeqScan("test", "a");
        Limit limit = new Limit(seqScan, 1, 1);
        limit.open();
        while (limit.hasNext()) {
            Tuple next = limit.next();
            System.out.println(next);
        }
        limit.close();
    }
}