package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.transcation.Transaction;
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
        Transaction.start();
        DbIterator dbIterator = new SeqScan("person", "a");
        dbIterator.open();
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            System.out.println(next);
        }
        dbIterator.close();
        Transaction.commit();
    }

}