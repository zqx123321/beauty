package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-05 10:57
 * @description: TODO
 **/
public class DistinctTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator seqScan = new SeqScan("list", "a");
        Distinct distinct = new Distinct(seqScan);
        distinct.open();
        while (distinct.hasNext()) {
            System.out.println(distinct.next());
        }

        distinct.close();

    }
}