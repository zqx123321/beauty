package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 17:15
 * @description: TODO
 **/
public class GroupTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator seqScan = new SeqScan("test", "a");
        Group group = new Group(seqScan, "a.id");
        group.open();
        while (group.hasNext()) {
            Tuple next = group.next();
            System.out.println(next);
        }
        group.close();
    }
}