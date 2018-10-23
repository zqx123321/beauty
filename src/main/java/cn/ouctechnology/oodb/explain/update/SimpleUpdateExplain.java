package cn.ouctechnology.oodb.explain.update;

import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.OgnlUtil;
import cn.ouctechnology.oodb.util.WhereClauseUtil;
import lombok.Builder;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 13:48
 * @description: TODO
 **/
@Builder
public class SimpleUpdateExplain extends UpdateExplain {
    private String tableName;

    private String tableAlias;

    private OQLParser.UpdateClauseContext updateClause;

    private OQLParser.WhereClauseContext whereClause;

    @Override
    public int doUpdate() {
        Tuple tuple = buildTuple();
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClause);
        return Record.update(tableName, tuple, whereTree);
    }

    private Tuple buildTuple() {
        Tuple tuple = new Tuple();
        List<OQLParser.UpdateItemContext> updateItemList = updateClause.getChildren(OQLParser.UpdateItemContext.class);
        for (OQLParser.UpdateItemContext updateItemContext : updateItemList) {
            OQLParser.PathExprContext pathExpr = updateItemContext.getChild(OQLParser.PathExprContext.class);
            String text = pathExpr.getText();
            if (text.contains(".")) {
                String field = OgnlUtil.getField(text, 0);
                if (!field.equals(tableAlias))
                    throw new ExplainException("the field value:" + text + "does not match the alias:" + tableAlias);
                text = text.substring(text.indexOf("." + 1));
            }
            OQLParser.NewValueContext newValue = updateItemContext.getChild(OQLParser.NewValueContext.class);
            Object value = newValue.getValue();

            tuple.add(text, value);
        }
        return tuple;
    }

}
