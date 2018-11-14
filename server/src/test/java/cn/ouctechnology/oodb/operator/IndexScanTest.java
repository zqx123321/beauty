package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.execute.OqlEngine;
import cn.ouctechnology.oodb.util.where.Op;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 16:41
 * @description: TODO
 **/
public class IndexScanTest extends BaseTest {

    @Test
    public void insert() {
        for (int i = 2; i < 1000; i++) {
            String oql = "insert into person values(" + i + ",'hhh" + i + "')";
            System.out.println(OqlEngine.execute(oql));
        }
    }

    @Test
    public void seqScan() {
        SeqScan seqScan = new SeqScan("person", "a");
        seqScan.open();
        while (seqScan.hasNext()) {
            System.out.println(seqScan.next());
        }
        seqScan.close();
    }

    @Test
    public void indexScan() {
        IndexScan indexScan = new IndexScan("person", "a", "id", Op.GreaterThan, 444);
        indexScan.open();
        while (indexScan.hasNext()) {
            System.out.println(indexScan.next());
        }
        indexScan.close();
    }
}