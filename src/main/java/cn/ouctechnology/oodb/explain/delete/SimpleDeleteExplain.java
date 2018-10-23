package cn.ouctechnology.oodb.explain.delete;

import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.reocrd.Record;
import cn.ouctechnology.oodb.util.OgnlUtil;
import cn.ouctechnology.oodb.util.WhereClauseUtil;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-20 10:31
 * @description: TODO
 **/
@Builder
public class SimpleDeleteExplain extends DeleteExplain {

    private String tableName;
    private String tableAlias;

    private WhereNode whereTree;

    @Override
    public int doDelete() {
        if (whereTree != null) {
            return doDeleteWithWhere();
        }
        return doDeleteWithoutWhere();
    }

    private int doDeleteWithoutWhere() {
        return Record.delete(tableName);
    }

    private int doDeleteWithWhere() {
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

        return Record.delete(tableName, whereTree);
    }
}
