package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 21:35
 * @description: TODO
 **/
public class ProjectTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator test = new SeqScan("test","a");
        Project id = new Project(test, Arrays.asList("a.id", "a.age"));
        id.open();
        while (id.hasNext()) {
            Tuple next = id.next();
            System.out.println(next);
        }
    }
}