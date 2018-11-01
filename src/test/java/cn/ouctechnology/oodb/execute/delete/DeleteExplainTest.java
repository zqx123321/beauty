package cn.ouctechnology.oodb.execute.delete;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.execute.OqlEngine;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 11:37
 * @description: TODO
 **/
public class DeleteExplainTest extends BaseTest {

    @Test
    public void testSelect() {
        String oql = "select a from test a";
        System.out.println(OqlEngine.execute(oql));
    }

    @Test
    public void doDelete() {
        String oql = "delete from test a where a.id>12";
        System.out.println(OqlEngine.execute(oql));
    }
}