package cn.ouctechnology.oodb.reocrd;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Index;
import cn.ouctechnology.oodb.catalog.Table;
import cn.ouctechnology.oodb.catalog.attribute.CharAttribute;
import cn.ouctechnology.oodb.catalog.attribute.IntAttribute;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-08 09:58
 * @description: TODO
 **/
public class RecordTest {
    @Before
    public void init() throws IOException {
        Buffer.init();
        Catalog.initialCatalog();
//        Record.create("person");
    }

    @After
    public void close() throws IOException {
        Buffer.close();
        Catalog.storeCatalog();
    }

    @Test
    public void create() {
//        Table table = new Table(
//                "person",
//                Arrays.asList("id"),
//                Arrays.asList(new IntAttribute("id", 4), new CharAttribute("name", 20)),
//                new ArrayList<Index>(), 0
//        );
//
//        Catalog.createTable(table);
//        Record.create("person");
//        Catalog.showCatalog();
    }

    @Test
    public void insert() throws IOException {
        //Catalog.initialCatalog();
        for (int i = 0; i < 10; i++) {
            Tuple tuple = new Tuple();
            tuple.add("id", i);
            tuple.add("sex", i % 2 == 0 ? "男" : "女");
            Record.insert("test", tuple);
        }
    }

    @Test
    public void select() throws IOException {
        Catalog.showCatalog();
        // System.out.println(Record.select("person"));
    }

    @Test
    public void testInsertInner() throws IOException {
        Catalog.initialCatalog();
        List<Object> dept = new ArrayList<>();
        dept.add(2);
        dept.add("信息学院2");
        List<Object> teacher = new ArrayList<>();
        teacher.add(2);
        teacher.add("张三2");
        teacher.add(dept);
        //System.out.println(Record.insert("teacher", teacher));
        // System.out.println(Record.select("teacher"));
    }

    @Test
    public void testSelectIter() throws IOException {
        Catalog.initialCatalog();
        //List<Tuple> tuples = Record.select("teacher");
//        for (Tuple tuple : tuples) {
//            System.out.println("id: " + tuple.get("id"));
//            System.out.println("name: " + tuple.get("name"));
//            System.out.println("dept.id: " + tuple.get("dept.id"));
//            System.out.println("dept.deptName: " + tuple.get("dept.deptNme"));
//            System.out.println();
//        }
    }
}