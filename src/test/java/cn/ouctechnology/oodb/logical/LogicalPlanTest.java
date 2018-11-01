package cn.ouctechnology.oodb.logical;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.parser.OQLParserTest;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 15:59
 * @description: TODO
 **/
public class LogicalPlanTest extends BaseTest {

    @Test
    public void getLogicalPlan() {
        String oql = "select a,c.sex from teacher a join test c on a.id=c.id group by c.sex order by a.age  desc limit 1,3";
        OQLParser.SelectStatementContext selectStatementContext = (OQLParser.SelectStatementContext) OQLParserTest.getParseTree(oql);
        OQLParser.SelectStatContext selectStatContext = selectStatementContext.selectStat();
        LogicalPlan logicalPlan = LogicalPlan.getLogicalPlan(selectStatContext);
        logicalPlan.check();

        DbIterator dbIterator = logicalPlan.toPhysicalPlan();
        dbIterator.open();
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            System.out.println(next);
        }
        dbIterator.close();
    }
}