package cn.ouctechnology.oodb.explain.insert;

import java.util.List;

import static cn.ouctechnology.oodb.parser.OQLParser.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 09:38
 * @description: TODO
 **/
public abstract class InsertExplain {

    public abstract int doInsert();

    public static InsertExplain getInsertExplain(InsertStatContext insert) {
        String tableName = insert.getChild(TableNameContext.class).getText();
        ColumnListContext columnListContext = insert.getChild(ColumnListContext.class);
        InsertValueContext insertValue = insert.getChild(InsertValueContext.class);
        List<NewValueContext> newValueList = insertValue.getChildren(NewValueContext.class);
        return SimpleInsertExplain
                .builder()
                .tableName(tableName)
                .columnListContext(columnListContext)
                .newValueList(newValueList)
                .build();
    }
}
