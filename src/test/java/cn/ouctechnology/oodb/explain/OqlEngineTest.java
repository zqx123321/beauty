package cn.ouctechnology.oodb.explain;

import cn.ouctechnology.oodb.BaseTest;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 15:23
 * @description: TODO
 **/
public class OqlEngineTest extends BaseTest {

    @Test
    public void execute() {
        String oql = "create table person(id int,name char(20),age float)";
        System.out.println(OqlEngine.execute(oql));
    }
}