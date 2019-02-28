package cn.ouctechnology.oodb.execute.create;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.execute.CreateExplain;
import cn.ouctechnology.oodb.parser.OQLParserTest;
import cn.ouctechnology.oodb.reocrd.Record;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static cn.ouctechnology.oodb.parser.OQLParser.CreateStatContext;
import static cn.ouctechnology.oodb.parser.OQLParser.OqlStatContext;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-18 15:37
 * @description: TODO
 **/
public class CreateExplainTest {
    @Before
    public void init() throws IOException {
        Catalog.initialCatalog();
        Buffer.init();
    }

    @After
    public void after() throws IOException {
        Buffer.close();
        Catalog.storeCatalog();
    }

    @Test
    public void doCreate() {
        String sql = "create table person(id int primary key, name char(20))";
        OqlStatContext statContext = (OqlStatContext) OQLParserTest.getParseTree(sql);
        CreateStatContext createStatContext = statContext.getChild(CreateStatContext.class);
        CreateExplain.getCreateExplain(createStatContext).doCreate();
        Catalog.showCatalog();
    }

    @Test
    public void testExtends() {
        String sql = "create table student(score float,id int) primary key(id)";
        OqlStatContext statContext = (OqlStatContext) OQLParserTest.getParseTree(sql);
        CreateStatContext createStatContext = statContext.getChild(CreateStatContext.class);
        CreateExplain.getCreateExplain(createStatContext).doCreate();
        Catalog.showCatalog();
    }

    @Test
    public void testRef() {
        String sql = "create table dept6(deptName char(10),stu ref(student)) primary key(stu.i)";
        OqlStatContext statContext = (OqlStatContext) OQLParserTest.getParseTree(sql);
        CreateStatContext createStatContext = statContext.getChild(CreateStatContext.class);
        CreateExplain.getCreateExplain(createStatContext).doCreate();
        Catalog.showCatalog();
    }

    @Test
    public void testDrop() {
        Catalog.dropTable("dept");
        Record.drop("dept");
        Catalog.showCatalog();
    }
}