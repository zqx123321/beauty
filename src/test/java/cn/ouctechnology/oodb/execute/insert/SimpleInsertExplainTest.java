package cn.ouctechnology.oodb.execute.insert;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.execute.CreateExplain;
import cn.ouctechnology.oodb.execute.InsertExplain;
import cn.ouctechnology.oodb.execute.SelectExplain;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.parser.OQLParserTest;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 11:52
 * @description: TODO
 **/
public class SimpleInsertExplainTest extends BaseTest {

    @Test
    public void doInsert() {
        String oql = "insert into teacher(id,name,dept) values(3,'sda',(dept.id:3,dept.deptNme:'adadas'))";
        OQLParser.OqlStatContext oqlStatContext = (OQLParser.OqlStatContext) OQLParserTest.getParseTree(oql);
        OQLParser.InsertStatContext insertStatContext = oqlStatContext.getChild(OQLParser.InsertStatContext.class);

        InsertExplain.getInsertExplain(insertStatContext).doInsert();
    }

    @Test
    public void select() {
        String oql = "select a.dept.deptNme from teacher a";
        OQLParser.OqlStatContext oqlStatContext = (OQLParser.OqlStatContext) OQLParserTest.getParseTree(oql);
        OQLParser.SelectStatContext selectStatContext = oqlStatContext.getChild(OQLParser.SelectStatContext.class);

        System.out.println(SelectExplain.getSelectExplain(selectStatContext).doSelect());
    }

    @Test
    public void create() {
        String oql = "create table test (id int,name char(20),age float)";
        OQLParser.OqlStatContext oqlStatContext = (OQLParser.OqlStatContext) OQLParserTest.getParseTree(oql);
        OQLParser.CreateStatContext createStatContext = oqlStatContext.getChild(OQLParser.CreateStatContext.class);

        CreateExplain.getCreateExplain(createStatContext).doCreate();
        Catalog.showCatalog();
    }

    @Test
    public void testInsertBranch() {
        for (int i = 1; i < 3; i++) {
            String oql = "insert into test values(" + (i + 2) + ",'hhh" + (i + 2) + "'," + (i + 2) + ")";
            System.out.println(oql);
            OQLParser.OqlStatContext oqlStatContext = (OQLParser.OqlStatContext) OQLParserTest.getParseTree(oql);
            OQLParser.InsertStatContext insertStatContext = oqlStatContext.getChild(OQLParser.InsertStatContext.class);

            InsertExplain insertExplain = InsertExplain.getInsertExplain(insertStatContext);
            insertExplain.doInsert();
        }
    }

    @Test
    public void testSelectTest() {

        String oql = "select a from test a where a.id=6666 or a.name='hhh7777'";
        OQLParser.OqlStatContext oqlStatContext = (OQLParser.OqlStatContext) OQLParserTest.getParseTree(oql);
        OQLParser.SelectStatContext selectStatContext = oqlStatContext.getChild(OQLParser.SelectStatContext.class);
        long l = System.currentTimeMillis();
        System.out.println(SelectExplain.getSelectExplain(selectStatContext).doSelect());
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}