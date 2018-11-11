package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Index;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.catalog.attribute.CharAttribute;
import cn.ouctechnology.oodb.catalog.attribute.FloatAttribute;
import cn.ouctechnology.oodb.catalog.attribute.IntAttribute;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.operator.RebuildIndex;
import cn.ouctechnology.oodb.parser.OQLParser;
import lombok.Builder;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;
import static cn.ouctechnology.oodb.constant.Constants.SINGLE_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 14:54
 * @description: TODO
 **/
@Builder
public class CreateIndexExplain {
    private String tableName;
    private String indexName;
    private String columnName;

    public static CreateIndexExplain getCreateIndexExplain(OQLParser.CreateIndexStatContext context) {
        String indexName = context.WORD(0).getText();
        String tableName = context.WORD(1).getText();
        String columnName = context.pathExpr().getText();
        try {
            Attribute attribute = Catalog.getAttribute(tableName, columnName);
            if (!(attribute instanceof IntAttribute || attribute instanceof FloatAttribute || attribute instanceof CharAttribute))
                throw new ExplainException("the index attribute must be the simple attribute");
        } catch (IllegalArgumentException e) {
            throw new ExplainException(e);
        }
        return CreateIndexExplain
                .builder()
                .tableName(tableName)
                .indexName(indexName)
                .columnName(columnName)
                .build();
    }

    public String doCreate() {
        Catalog.addIndex(tableName, indexName, columnName);
        //维护索引
        Index index = Catalog.getIndexByIndexName(tableName, indexName);
        if (Catalog.getTupleNum(tableName) > 0) {
            DbIterator dbIterator = new RebuildIndex(tableName, tableName, index);
            try {
                dbIterator.open();
                //出现重复值
            } catch (DbException e) {
                Catalog.dropIndex(tableName, indexName);
                throw e;
            }
        }
        return SINGLE_AFFECTED + ROWS_AFFECTED;
    }
}
