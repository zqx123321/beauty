package cn.ouctechnology.oodb.explain.delete;

import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.util.WhereClauseUtil;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 10:29
 * @description: TODO
 **/
public abstract class DeleteExplain {

    public abstract int doDelete();

    public static DeleteExplain getDeleteExplain(OQLParser.DeleteStatContext delete) {
        OQLParser.DeleteClauseContext deleteClause = delete.getChild(OQLParser.DeleteClauseContext.class);
        String tableName = deleteClause.getChild(OQLParser.SchemaNameContext.class).getText();
        String tableAlias = deleteClause.getChild(OQLParser.IdContext.class).getText();

        OQLParser.WhereClauseContext whereClause = delete.getChild(OQLParser.WhereClauseContext.class);
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClause);

        return SimpleDeleteExplain
                .builder()
                .tableName(tableName)
                .tableAlias(tableAlias)
                .whereTree(whereTree)
                .build();

    }
}
