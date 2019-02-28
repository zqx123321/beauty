package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-08 10:57
 * @description: TODO
 **/
public class HashJoinTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator dbIterator1 = new SeqScan("person", "a");
        DbIterator dbIterator2 = new SeqScan("teacher", "b");

        HashJoin hashJoin = new HashJoin(dbIterator1, dbIterator2, "a.id", "b.id");
        hashJoin.open();
        while (hashJoin.hasNext()) {
            System.out.println(hashJoin.next());
        }
        hashJoin.close();
    }
}