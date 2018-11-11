package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import lombok.Builder;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;
import static cn.ouctechnology.oodb.constant.Constants.SINGLE_AFFECTED;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 15:46
 * @description: TODO
 **/
@Builder
public class DropExplain {

    private String tableName;

    public String doDrop() {
        //todo 原子性的保证
        Buffer.writeToDisk(tableName);
        Catalog.dropIndex(tableName);
        Catalog.dropTable(tableName);
        Record.drop(tableName);
        return SINGLE_AFFECTED + ROWS_AFFECTED;
    }

    public static DropExplain getDropStatContext(OQLParser.DropStatContext drop) {
        String tableName = drop.WORD().getText();
        return DropExplain.builder().tableName(tableName).build();
    }
}
