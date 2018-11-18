package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Table;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import lombok.Builder;

import java.util.List;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 15:46
 * @description: TODO
 **/
@Builder
public class DropExplain {

    private String tableName;

    private boolean cascade;

    public String doDrop() {
        Table table = Catalog.getTable(tableName);
        List<String> refs = Catalog.checkRef(tableName);
        List<String> extendTables = Catalog.checkExtend(tableName);
        if (!cascade) {
            if (refs.size() > 0 || extendTables.size() > 0) {
                throw new DbException("the table is refed or extended,please user cascade to delete the relationship");
            }
        }
        //todo 原子性的保证
        Buffer.writeToDisk(tableName);
        Catalog.dropIndex(tableName);
        Catalog.dropTable(tableName);
        Record.drop(tableName);
        //级联删除
        if (cascade) {
            for (String ref : refs) {
                DropExplain.builder().tableName(ref).cascade(true).build().doDrop();
            }
            for (String ref : extendTables) {
                DropExplain.builder().tableName(ref).cascade(true).build().doDrop();
            }
        }
        return 1 + refs.size() + extendTables.size() + ROWS_AFFECTED;
    }

    public static DropExplain getDropStatContext(OQLParser.DropStatContext drop) {
        String tableName = drop.WORD().getText();
        boolean cascade = drop.CASCADE() != null;
        return DropExplain.builder().tableName(tableName).cascade(cascade).build();
    }

}
