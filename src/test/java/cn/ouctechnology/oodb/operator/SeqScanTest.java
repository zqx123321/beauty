package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 20:19
 * @description: TODO
 **/
public class SeqScanTest extends BaseTest {

    @Test
    public void next() {
        DbIterator dbIterator = new SeqScan("teacher","a");
        dbIterator.open();
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            System.out.println(next);
        }
        dbIterator.close();
    }

}