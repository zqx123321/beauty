package cn.ouctechnology.oodb.explain.select;

import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.util.OgnlUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 10:02
 * @description: TODO
 **/
@Builder
@Getter
public class SimpleSelectExplain extends SelectExplain {


    private List<String> selectFieldList;

    private WhereNode whereTree;

    private OQLParser.FromItemContext fromItem;


    @Override
    public Object doSelect() {
        //得到表名
        String tableName = fromItem.getChild(OQLParser.SchemaNameContext.class).getText();
        //得到表名
        String tableAlias = fromItem.getChild(OQLParser.IdContext.class).getText();
        //预处理
        boolean flag = checkOneTable(tableAlias);
        //去掉前导别名
        selectFieldList = selectFieldList.stream().map(s -> s.substring(s.indexOf(".") + 1)).collect(Collectors.toList());
        if (whereTree != null) return Record.select(tableName, whereTree, selectFieldList, flag);
        return Record.select(tableName, selectFieldList, flag);

    }

    private boolean checkOneTable(String tableAlias) {
        //不带点的全属性只能有一个
        boolean allAttributeCount = false;
        for (String field : selectFieldList) {
            if (!field.contains(".")) {
                if (allAttributeCount) throw new ExplainException("the attribute name does not match the table alias");
                allAttributeCount = true;
            }
            field = OgnlUtil.getField(field, 0);
            if (!field.equals(tableAlias))
                throw new ExplainException("the attribute name does not match the table alias");
        }
        return allAttributeCount;
    }
}
