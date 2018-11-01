package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

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

    public static void main(String[] args) throws IOException {
        Catalog.initialCatalog();
        Buffer.init();
        Scanner sc = new Scanner(System.in);
        System.out.print("OODB>");
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if ("quit".equals(line)) break;
            try {
                System.out.println(OqlEngine.execute(line));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
            System.out.print("OODB>");
        }
        Buffer.close();
        Catalog.showCatalog();
    }


    @Test
    public void testInsertPush() {
        for (int i = 10000; i < 100000; i++) {
            String oql = "insert into person values(" + i + ",'hhh" + i + "')";
            OqlEngine.execute(oql);
        }
    }

    @Test
    public void testSelect() {
        long l = System.currentTimeMillis();
        String oql = "select a from person a join test b on(a.id=b.id) where a.id=22222 or a.name='hhh5555'";
        System.out.println(OqlEngine.execute(oql));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}