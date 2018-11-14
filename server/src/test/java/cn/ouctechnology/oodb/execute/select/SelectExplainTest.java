package cn.ouctechnology.oodb.execute.select;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.execute.SelectExplain;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.parser.OQLParserTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 21:04
 * @description: TODO
 **/
public class SelectExplainTest {

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
    public void doSelect() {
        OQLParser.OqlStatContext parseTree = (OQLParser.OqlStatContext) OQLParserTest.getParseTree("select a.dept.deptNme from teacher a where a.id=1 or a.dept.deptNme='信息学院2'");
        OQLParser.SelectStatContext child = parseTree.getChild(OQLParser.SelectStatContext.class);
        System.out.println(SelectExplain.getSelectExplain(child).doSelect());
    }
}