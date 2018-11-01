package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.util.OgnlUtil;
import cn.ouctechnology.oodb.util.WhereClauseUtil;
import cn.ouctechnology.oodb.util.where.WhereNode;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 10:29
 * @description: TODO
 **/
@Builder
public class DeleteExplain {

    private String tableName;
    private String tableAlias;

    private WhereNode whereTree;

    public String doDelete() {
        if (whereTree != null) {
            return doDeleteWithWhere();
        }
        return doDeleteWithoutWhere();
    }

    public static DeleteExplain getDeleteExplain(OQLParser.DeleteStatContext delete) {
        OQLParser.DeleteClauseContext deleteClause = delete.getChild(OQLParser.DeleteClauseContext.class);
        String tableName = deleteClause.getChild(OQLParser.SchemaNameContext.class).getText();
        String tableAlias = deleteClause.getChild(OQLParser.IdContext.class).getText();

        OQLParser.WhereClauseContext whereClause = delete.getChild(OQLParser.WhereClauseContext.class);
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClause);

        return DeleteExplain
                .builder()
                .tableName(tableName)
                .tableAlias(tableAlias)
                .whereTree(whereTree)
                .build();

    }

    private String doDeleteWithoutWhere() {
        int delete = Record.delete(tableName);
        return delete + ROWS_AFFECTED;
    }

    private String doDeleteWithWhere() {
        List<String> whereFieldList = new ArrayList<>();
        WhereClauseUtil.getWhereFieldList(whereTree, whereFieldList);
        //检查语义错误
        for (String field : whereFieldList) {
            if (field.contains(".")) {
                String first = OgnlUtil.getField(field, 0);
                if (!first.equals(tableAlias))
                    throw new ExplainException("the tableAlias:" + tableAlias + " does not match the where field:" + field);
            }
        }

        int delete = Record.delete(tableName, tableAlias, whereTree);
        return delete + ROWS_AFFECTED;
    }
}
