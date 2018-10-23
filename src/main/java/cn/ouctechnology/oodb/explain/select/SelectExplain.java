package cn.ouctechnology.oodb.explain.select;

import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.util.WhereClauseUtil;

import java.util.ArrayList;
import java.util.List;

import static cn.ouctechnology.oodb.parser.OQLParser.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 09:30
 * @description: TODO
 **/
public abstract class SelectExplain {


    public abstract Object doSelect();

    /**
     * 静态工厂方法，返回处理该条select的explain
     *
     * @param tree
     */
    public static SelectExplain getSelectExplain(SelectStatContext tree) {
        FromClauseContext fromClause = tree.getChild(FromClauseContext.class);
        GroupByClauseContext groupClause = tree.getChild(GroupByClauseContext.class);
        HavingClauseContext havingClause = tree.getChild(HavingClauseContext.class);
        LimitClauseContext limitClause = tree.getChild(LimitClauseContext.class);
        OrderByClauseContext orderByClause = tree.getChild(OrderByClauseContext.class);

        List<String> selectFieldList = getSelectFieldList(tree);
        OQLParser.WhereClauseContext whereClause = tree.getChild(OQLParser.WhereClauseContext.class);
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClause);
        List<FromItemContext> fromItemContextList = fromClause.getChildren(FromItemContext.class);
        //先检查是否单表
        //TODO 不能这样做，肯定无法穷举所有的情况
        if (groupClause == null && havingClause == null && limitClause == null
                && orderByClause == null && judgeOneTable(fromItemContextList))
            return SimpleSelectExplain
                    .builder()
                    .fromItem(fromItemContextList.get(0))
                    .selectFieldList(selectFieldList)
                    .whereTree(whereTree)
                    .build();
        return null;
    }

    private static boolean judgeOneTable(List<FromItemContext> fromItemContextList) {
        if (fromItemContextList.size() > 1) return false;
        FromItemContext fromItemContext = fromItemContextList.get(0);
        return fromItemContext.getChild(JoinContext.class) == null;
    }

    private static List<String> getSelectFieldList(SelectStatContext tree) {
        List<SelectExprContext> selectExprList = tree
                .getChild(SelectClauseContext.class)
                .getChildren(SelectExprContext.class);
        //todo 暂时不考虑函数
        //得到select选择列
        List<String> selectFieldList = new ArrayList<>();

        for (SelectExprContext exprContext : selectExprList) {
            PathExprContext path = exprContext.getChild(PathExprContext.class);
            if (path != null) {
                selectFieldList.add(path.getText());
            }
        }
        return selectFieldList;
    }
}
