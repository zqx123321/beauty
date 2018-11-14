package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.parser.OQLParser;
import lombok.Builder;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;
import static cn.ouctechnology.oodb.constant.Constants.SINGLE_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 15:02
 * @description: TODO
 **/
@Builder
public class DropIndexExplain {
    private String tableName;
    private String indexName;

    public static DropIndexExplain getDropIndexExplain(OQLParser.DropIndexStatContext context) {
        String indexName = context.WORD(0).getText();
        String tableName = context.WORD(1).getText();
        try {
            Catalog.getIndexByIndexName(tableName, indexName);
        } catch (Exception e) {
            throw new ExplainException("the index is not found");
        }

        return DropIndexExplain
                .builder()
                .tableName(tableName)
                .indexName(indexName)
                .build();
    }

    public String doDrop() {
        Catalog.dropIndex(tableName, indexName);
        return SINGLE_AFFECTED + ROWS_AFFECTED;
    }
}
