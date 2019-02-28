package cn.ouctechnology.oodb.util;

import cn.ouctechnology.oodb.parser.OQLLexer;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.util.where.WhereNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 14:53
 * @description: TODO
 **/
public class WhereClauseUtilTest {

    @Test
    public void buildWhereTree() {
        String oql = "select a from test a where a.id=1 and (a.name=a.age or a.name='222' and a.age=11.1)";
        CodePointCharStream stream = CharStreams.fromString(oql);
        OQLLexer lexer = new OQLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OQLParser parser = new OQLParser(tokens);
        OQLParser.OqlStatContext tree = parser.oqlStat();
        OQLParser.SelectStatContext child = tree.getChild(OQLParser.SelectStatContext.class);
        OQLParser.ConditionalExprContext exprContext = child.whereClause().conditionalExpr();
        WhereNode whereNode = WhereClauseUtil.buildWhereTree(exprContext);
        System.out.println(whereNode);
    }
}