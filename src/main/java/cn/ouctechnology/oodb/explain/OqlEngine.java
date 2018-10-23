package cn.ouctechnology.oodb.explain;

import cn.ouctechnology.oodb.parser.OQLLexer;
import cn.ouctechnology.oodb.parser.OQLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 15:14
 * @description: TODO
 **/
public class OqlEngine {

    public static Object execute(String oql) {
        if (oql == null) return null;
        CodePointCharStream stream = CharStreams.fromString(oql);
        OQLLexer lexer = new OQLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OQLParser parser = new OQLParser(tokens);
        OQLParser.OqlStatContext tree = parser.oqlStat();
        return tree.doExecute();
    }
}
