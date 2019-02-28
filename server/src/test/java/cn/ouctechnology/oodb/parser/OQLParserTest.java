package cn.ouctechnology.oodb.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 09:57
 * @description: TODO
 **/
public class OQLParserTest {
    //    @Test
//    public void testSelect() {
//        String oql = "select a.dept.id,a.name from person a where a.id=1 or(a.name='dd' and a.age>9)";                      //文件读取数据
//        CodePointCharStream stream = CharStreams.fromString(oql);
//        OQLLexer lexer = new OQLLexer(stream);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        OQLParser parser = new OQLParser(tokens);
//        OQLParser.OqlStatContext tree = parser.oqlStat();
//
//        SelectExplain selectExplain = SelectExplain.getSelectExplain(tree.getChild(OQLParser.SelectStatContext.class));
//        System.out.println(selectExplain.doSelect());
//    }
//
    public static ParseTree getParseTree(String oql) {
        CodePointCharStream stream = CharStreams.fromString(oql);
        OQLLexer lexer = new OQLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OQLParser parser = new OQLParser(tokens);
        OQLParser.OqlStatContext tree = parser.oqlStat();
        return tree;
    }

}