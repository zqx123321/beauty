package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.OgnlUtil;
import cn.ouctechnology.oodb.util.WhereClauseUtil;
import cn.ouctechnology.oodb.util.where.WhereNode;
import lombok.Builder;

import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 13:42
 * @description: TODO
 **/
@Builder
public class UpdateExplain {

    private String tableName;

    private String tableAlias;

    private OQLParser.UpdateClauseContext updateClause;

    private OQLParser.WhereClauseContext whereClause;

    public String doUpdate() {
        Tuple tuple = buildTuple();
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClause);
        int update = Record.update(tableName, tableAlias, tuple, whereTree);
        return update + ROWS_AFFECTED;
    }

    public static UpdateExplain getUpdateExplain(OQLParser.UpdateStatContext update) {
        OQLParser.UpdateClauseContext updateClause = update.getChild(OQLParser.UpdateClauseContext.class);
        String tableName = updateClause.getChild(OQLParser.SchemaNameContext.class).getText();
        String tableAlias = updateClause.getChild(OQLParser.IdContext.class).getText();
        OQLParser.WhereClauseContext whereClause = updateClause.getChild(OQLParser.WhereClauseContext.class);

        return UpdateExplain
                .builder()
                .tableName(tableName)
                .tableAlias(tableAlias)
                .updateClause(updateClause)
                .whereClause(whereClause)
                .build();
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
                text = text.substring(text.indexOf(".") + 1);
            }
            OQLParser.NewValueContext newValue = updateItemContext.getChild(OQLParser.NewValueContext.class);
            Object value = newValue.getValue();

            tuple.add(text, value);
        }
        return tuple;
    }

}
