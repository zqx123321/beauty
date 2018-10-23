package cn.ouctechnology.oodb.explain.update;

import cn.ouctechnology.oodb.parser.OQLParser;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 13:42
 * @description: TODO
 **/
public abstract class UpdateExplain {
    public abstract int doUpdate();

    public static UpdateExplain getUpdateExplain(OQLParser.UpdateStatContext update) {
        OQLParser.UpdateClauseContext updateClause = update.getChild(OQLParser.UpdateClauseContext.class);
        String tableName = updateClause.getChild(OQLParser.SchemaNameContext.class).getText();
        String tableAlias = updateClause.getChild(OQLParser.IdContext.class).getText();
        OQLParser.WhereClauseContext whereClause = updateClause.getChild(OQLParser.WhereClauseContext.class);

        return SimpleUpdateExplain
                .builder()
                .tableName(tableName)
                .tableAlias(tableAlias)
                .updateClause(updateClause)
                .whereClause(whereClause)
                .build();
    }

}
