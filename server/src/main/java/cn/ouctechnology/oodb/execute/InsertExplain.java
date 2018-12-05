package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.reocrd.Tuple;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;
import static cn.ouctechnology.oodb.parser.OQLParser.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 09:38
 * @description: TODO
 **/
@Builder
public class InsertExplain {

    private String tableName;

    private OQLParser.ColumnListContext columnListContext;

    private List<OQLParser.NewValueContext> newValueList;

    public static InsertExplain getInsertExplain(InsertStatContext insert) {
        String tableName = insert.getChild(TableNameContext.class).getText();
        ColumnListContext columnListContext = insert.getChild(ColumnListContext.class);
        InsertValueContext insertValue = insert.getChild(InsertValueContext.class);
        List<NewValueContext> newValueList = insertValue.getChildren(NewValueContext.class);
        return InsertExplain
                .builder()
                .tableName(tableName)
                .columnListContext(columnListContext)
                .newValueList(newValueList)
                .build();
    }

    public String doInsert() {
        Tuple tuple = buildTuple();
        int insert = Record.insert(tableName, tuple);
        return insert + ROWS_AFFECTED;
    }

    private List<String> getColumnList() {
        if (columnListContext == null) return null;
        List<OQLParser.PathExprContext> pathExprContextList = columnListContext.getChildren(OQLParser.PathExprContext.class);
        return pathExprContextList.stream().map(OQLParser.PathExprContext::getText).collect(Collectors.toList());
    }

    private Tuple buildTuple() {
        Tuple tuple = new Tuple();
        List<String> columnList = null;
        if (columnListContext != null) {
            columnList = getColumnList();
        } else {
            columnList = Catalog
                    .getAttributes(tableName)
                    .stream()
                    .map(Attribute::getName)
                    .collect(Collectors.toList());
        }
        if (columnList.size() != newValueList.size()) {
            throw new ExplainException("write error: value count does not match the attributes count,excepted is:" + columnList.size() + ",now is:" + newValueList.size());
        }
        for (int i = 0; i < columnList.size(); i++) {
            String column = columnList.get(i);
            OQLParser.NewValueContext newValueContext = newValueList.get(i);
            Object value = newValueContext.getValue();
            tuple.add(column, value);
        }
        return tuple;
    }
}
