package cn.ouctechnology.oodb.explain.update;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.explain.OqlEngine;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 14:14
 * @description: TODO
 **/
public class UpdateExplainTest extends BaseTest {

    @Test
    public void TestSelect() {
        String oql = "select a.id,a.name from test a where a.id>1";
        System.out.println(OqlEngine.execute(oql));
    }

    @Test
    public void doUpdate() {
        String oql = "update test a set name='张aaa',age=20";
        System.out.println(OqlEngine.execute(oql));
    }
}