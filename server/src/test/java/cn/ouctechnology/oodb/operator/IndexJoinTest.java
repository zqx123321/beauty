package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.util.where.Op;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-08 09:48
 * @description: TODO
 **/
public class IndexJoinTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator seqScan = new SeqScan("person", "a");
        IndexJoin indexJoin = new IndexJoin(seqScan, "person", "b", "a.id", "id", Op.LessThan);
        indexJoin.open();
        while (indexJoin.hasNext()) {
            System.out.println(indexJoin.next());
        }
        indexJoin.close();
    }
}