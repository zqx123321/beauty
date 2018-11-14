package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.parser.OQLLexer;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.where.WhereNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 16:22
 * @description: TODO
 **/
public class JudgeUtilTest {

//    @Test
//    public void testJudge() {
//        String oql = "select a.dept.id,a.name from person a where a.id=1 and(a.name=dd or a.age>9.1)";                      //文件读取数据
//        CodePointCharStream stream = CharStreams.fromString(oql);
//        OQLLexer lexer = new OQLLexer(stream);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        OQLParser parser = new OQLParser(tokens);
//        OQLParser.OqlStatContext tree = parser.oqlStat();
//        SelectExplain selectExplain = SelectExplain.getSelectExplain(tree.getChild(OQLParser.SelectStatContext.class));
//
//        SimpleSelectExplain simpleSelectExplain = (SimpleSelectExplain) selectExplain;
//        WhereNode whereTree = simpleSelectExplain.getWhereTree();
//
//        Tuple fields = new Tuple();
//        fields.add("a.dept.id", 1);
//        fields.add("a.name", "dd");
//        fields.add("a.id", 1);
//        fields.add("a.age", 1f);
//
//        System.out.println(JudgeUtil.whereJudge(fields, whereTree));
//
//
//    }

}