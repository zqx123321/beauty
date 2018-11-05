package cn.ouctechnology.oodb.logical;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.exception.ParseException;
import cn.ouctechnology.oodb.operator.*;
import cn.ouctechnology.oodb.operator.aggregator.Aggregator;
import cn.ouctechnology.oodb.parser.OQLParser;
import cn.ouctechnology.oodb.util.OgnlUtil;
import cn.ouctechnology.oodb.util.WhereClauseUtil;
import cn.ouctechnology.oodb.util.where.InnerNode;
import cn.ouctechnology.oodb.util.where.LeafNode;
import cn.ouctechnology.oodb.util.where.Op;
import cn.ouctechnology.oodb.util.where.WhereNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.constant.Constants.NO_GROUPING;
import static cn.ouctechnology.oodb.parser.OQLParser.INTNUMERAL;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 10:31
 * @description: TODO
 **/
public class LogicalPlan {

    private LogicalTableNode tableNode;
    private LogicalAggregateNode aggregateNode;
    private LogicalFilterNode filterNode;
    private LogicalProjectNode projectNode;
    private LogicalLimitNode logicalLimitNode;
    private List<LogicalOrderNode> logicalOrderNode;
    private boolean distinct;

    public LogicalPlan(
            LogicalTableNode tableNode,
            LogicalAggregateNode aggregateNode,
            LogicalFilterNode filterNode,
            LogicalProjectNode projectNode,
            LogicalLimitNode logicalLimitNode,
            List<LogicalOrderNode> logicalOrderNode,
            boolean distinct) {
        this.tableNode = tableNode;
        this.aggregateNode = aggregateNode;
        this.filterNode = filterNode;
        this.projectNode = projectNode;
        this.logicalLimitNode = logicalLimitNode;
        this.logicalOrderNode = logicalOrderNode;
        this.distinct = distinct;
    }

    public LogicalTableNode getTableNode() {
        return tableNode;
    }

    public LogicalAggregateNode getAggregateNode() {
        return aggregateNode;
    }

    public LogicalFilterNode getFilterNode() {
        return filterNode;
    }

    public LogicalProjectNode getProjectNode() {
        return projectNode;
    }

    public LogicalLimitNode getLogicalLimitNode() {
        return logicalLimitNode;
    }

    public List<LogicalOrderNode> getLogicalOrderNode() {
        return logicalOrderNode;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public static LogicalPlan getLogicalPlan(OQLParser.SelectStatContext selectStatContext) {
        OQLParser.WhereClauseContext whereClauseContext = selectStatContext.whereClause();
        WhereNode whereTree = WhereClauseUtil.getWhereTree(whereClauseContext);
        LogicalProjectNode projectNode = null;
        LogicalAggregateNode aggregateNode = null;
        LogicalLimitNode limitNode = null;
        List<LogicalOrderNode> orderNode = null;
        LogicalTableNode logicalTableNode = new LogicalTableNode();
        boolean distinct = false;
        if (selectStatContext.DISTINCT() != null) distinct = true;
        OQLParser.FromClauseContext fromClauseContext = selectStatContext.fromClause();
        List<OQLParser.FromItemContext> fromItemContextList = fromClauseContext.fromItem();
        for (OQLParser.FromItemContext fromItemContext : fromItemContextList) {
            String tableName = fromItemContext.schemaName().getText();
            String tableAlias = fromItemContext.id().getText();
            logicalTableNode.addTable(tableAlias, tableName);
            List<OQLParser.JoinContext> joinContextList = fromItemContext.join();
            if (joinContextList != null && joinContextList.size() > 0) {
                for (OQLParser.JoinContext joinContext : joinContextList) {
                    tableName = joinContext.schemaName().getText();
                    tableAlias = joinContext.id().getText();
                    logicalTableNode.addTable(tableAlias, tableName);
                    OQLParser.ConditionalExprContext exprContext = joinContext.conditionalExpr();
                    WhereNode whereNode = WhereClauseUtil.buildWhereTree(exprContext);
                    if (whereTree == null) whereTree = whereNode;
                    else {
                        InnerNode innerNode = new InnerNode(Op.AND);
                        innerNode.setLeft(whereTree);
                        innerNode.setRight(whereNode);
                        whereTree = innerNode;
                    }
                }
            }
        }

        OQLParser.SelectClauseContext selectClauseContext = selectStatContext.selectClause();
        List<OQLParser.SelectExprContext> selectExprContexts = selectClauseContext.selectExpr();
        for (OQLParser.SelectExprContext selectExprContext : selectExprContexts) {
            if (selectExprContext instanceof OQLParser.SelectPathExprContext) {
                String path = selectExprContext.getText();
                if (!path.contains(".")) {
                    if (projectNode == null) projectNode = new LogicalProjectNode();
                    getSelectField(projectNode, logicalTableNode, path);
                    continue;
                }
                if (projectNode == null) projectNode = new LogicalProjectNode();
                projectNode.addField(path);
            } else {
                if (aggregateNode != null) throw new ParseException("only support one aggregate");
                OQLParser.SelectAggregateExprContext exprContext = (OQLParser.SelectAggregateExprContext) selectExprContext;
                OQLParser.AggregateExprContext aggregateExprContext = exprContext.aggregateExpr();
                String functionName = aggregateExprContext.aggregateExprFunctionName().getText().toLowerCase();
                String aField = aggregateExprContext.pathExpr().getText();
                if (projectNode == null) projectNode = new LogicalProjectNode();
                aggregateNode = new LogicalAggregateNode();
                Aggregator.Op anEnum = Aggregator.Op.getEnum(functionName);
                aggregateNode.setOp(anEnum);
                aggregateNode.setAField(aField);
                aggregateNode.setGroupField(NO_GROUPING);
                projectNode.addField(aField);
            }
        }
        OQLParser.GroupByClauseContext groupByClauseContext = selectStatContext.groupByClause();
        if (groupByClauseContext != null) {
            if (aggregateNode == null) aggregateNode = new LogicalAggregateNode();
            String path = groupByClauseContext.pathExpr().getText();
            aggregateNode.setGroupField(path);
        }

        OQLParser.LimitClauseContext limitClauseContext = selectStatContext.limitClause();
        if (limitClauseContext != null) {
            List<TerminalNode> tokens = limitClauseContext.getTokens(INTNUMERAL);
            if (tokens.size() == 1) {
                limitNode = new LogicalLimitNode(0, Integer.parseInt(tokens.get(0).getText()));
            } else {
                limitNode = new LogicalLimitNode(Integer.parseInt(tokens.get(0).getText()), Integer.parseInt(tokens.get(1).getText()));
            }
        }

        OQLParser.OrderByClauseContext orderByClauseContext = selectStatContext.orderByClause();
        if (orderByClauseContext != null) {
            orderNode = new ArrayList<>();
            List<OQLParser.OrderByItemContext> orderByItemContexts = orderByClauseContext.orderByItem();
            for (OQLParser.OrderByItemContext orderByItemContext : orderByItemContexts) {
                String path = orderByItemContext.pathExpr().getText();
                TerminalNode desc = orderByItemContext.DESC();
                if (desc != null) orderNode.add(new LogicalOrderNode(path, false));
                else orderNode.add(new LogicalOrderNode(path, true));
            }

        }
        return new LogicalPlan(
                logicalTableNode
                , aggregateNode
                , new LogicalFilterNode(whereTree)
                , projectNode
                , limitNode
                , orderNode
                , distinct);
    }

    private static void getSelectField(LogicalProjectNode projectNode, LogicalTableNode logicalTableNode, String tableAlias) {
        String tableName = logicalTableNode.get(tableAlias);
        List<Attribute> attributes = Catalog.getTable(tableName).getAttributes();
        for (Attribute attribute : attributes) {
            String name = attribute.getName();
            projectNode.addField(tableAlias + "." + name);
        }
    }

    public void check() {
        LogicalPlan logicalPlan = this;
        //1、检查表名称是否均存在
        LogicalTableNode tableNode = logicalPlan.getTableNode();
        Set<String> tableAliasSet = tableNode.getTables().keySet();
        for (String alias : tableAliasSet) {
            String tableName = tableNode.get(alias);
            try {
                Catalog.getTable(tableName);
            } catch (IllegalArgumentException e) {
                throw new ParseException(e);
            }
        }

        LogicalAggregateNode aggregateNode = logicalPlan.getAggregateNode();
        //2、检查groupBy属性
        if (aggregateNode != null) {
            String groupField = aggregateNode.getGroupField();
            if (!groupField.equals(NO_GROUPING)) checkField(groupField, tableAliasSet);
            String aField = aggregateNode.getAField();
            if (aField != null) checkField(aField, tableAliasSet);
        }
        //3、检查projects别名是否均存在，属性是否符合要求
        LogicalProjectNode projectNode = logicalPlan.getProjectNode();
        Set<String> fieldList = projectNode.getFieldList();
        //检查是否符合group要求
        if (aggregateNode != null && !aggregateNode.getGroupField().equals(NO_GROUPING) && aggregateNode.getOp() != null) {
            if (fieldList.size() == 1) {
                String next = fieldList.iterator().next();
                if (!next.equals(aggregateNode.getAField()) && !next.equals(aggregateNode.getGroupField()))
                    throw new ParseException("the group by field must in the select field list");
            } else if (fieldList.size() == 2) {
                if (!(fieldList.contains(aggregateNode.getAField()) && fieldList.contains(aggregateNode.getGroupField()))) {
                    throw new ParseException("the group by field must in the select field list");
                }
            } else if (fieldList.size() > 2)
                throw new ParseException("the group by field must in the select field list");
        }
        for (String field : fieldList) {
            checkField(field, tableAliasSet);
        }
        //4、检查where涉及属性是否全部存在
        LogicalFilterNode filterNode = logicalPlan.getFilterNode();
        if (filterNode != null) {
            WhereNode whereTree = logicalPlan.getFilterNode().getWhereTree();
            List<String> whereFieldList = WhereClauseUtil.getWhereField(whereTree);
            if (whereFieldList != null) {
                for (String field : whereFieldList) {
                    checkField(field, tableAliasSet);
                }
            }
        }
        //5、检查orderBy属性
        List<LogicalOrderNode> logicalOrderNode = logicalPlan.getLogicalOrderNode();
        if (logicalOrderNode != null && logicalOrderNode.size() > 0) {
            for (LogicalOrderNode orderNode : logicalOrderNode) {
                String field = orderNode.getField();
                checkField(field, tableAliasSet);
            }
        }

    }

    private void checkField(String field, Set<String> tableAliasSet) {
        if (field.contains(".")) {
            String alias = OgnlUtil.getField(field, 0);
            if (!tableAliasSet.contains(alias))
                throw new ParseException("the field alias:" + alias + " does not exist");
            String leftField = OgnlUtil.getLeftField(field);
            String tableName = tableNode.get(alias);
            try {
                Catalog.getAttribute(tableName, leftField);
                return;
            } catch (Exception e) {
                throw new ParseException(e);
            }
        }
        throw new ParseException("the field :" + field + " is error");
    }

    public DbIterator toPhysicalPlan() {
        DbIterator physicalPlan;
        //只要查询涉及的表的数量大于1，则一定存在连接运算
        if (tableNode.getTables().size() <= 1) {
            Map<String, String> tables = tableNode.getTables();
            if (tables.size() != 1) throw new ParseException("no join the table size should be one");
            Iterator<Map.Entry<String, String>> iterator = tableNode.getTables().entrySet().iterator();
            Map.Entry<String, String> table = iterator.next();
            physicalPlan = new SeqScan(table.getValue(), table.getKey());
            if (filterNode.getWhereTree() != null) {
                physicalPlan = new Filter(physicalPlan, filterNode.getWhereTree());
            }
            return highLevelPhysicalPlan(physicalPlan);

        }
        //处理多表查询
        physicalPlan = joinToPhysicalPlan();
        return highLevelPhysicalPlan(physicalPlan);
    }

    private DbIterator highLevelPhysicalPlan(DbIterator physicalPlan) {
        ArrayList<String> fieldList = new ArrayList<>(projectNode.getFieldList());
        physicalPlan = new Project(physicalPlan, fieldList);
        if (aggregateNode != null) {
            boolean flag = false;
            String groupField = aggregateNode.getGroupField();
            String aField = aggregateNode.getAField();
            Aggregator.Op op = aggregateNode.getOp();
            //如果group字段不包含在select列表中，需要先手动再删除
            if (!groupField.equals(NO_GROUPING) && !fieldList.contains(groupField)) {
                fieldList.add(groupField);
                flag = true;
            }
            if (aField == null && op == null && !groupField.equals(NO_GROUPING)) {
                physicalPlan = new Group(physicalPlan, groupField);
            } else if (aField != null && op != null) {
                String alias = OgnlUtil.getField(aField, 0);
                String tableName = tableNode.get(alias);
                Type type = Catalog.getAttribute(tableName, OgnlUtil.getLeftField(aField)).getType();
                physicalPlan = new Aggregate(physicalPlan, aField, type, groupField, op);
                //再做一次Project去掉group字段
                if (flag)
                    physicalPlan = new Project(physicalPlan, Collections.singletonList(op.toString() + "(" + aField + ")"));
            } else throw new ParseException("unsupported operator");

        }
        if (logicalOrderNode != null) {
            for (LogicalOrderNode orderNode : logicalOrderNode) {
                physicalPlan = new OrderBy(physicalPlan, orderNode.getField(), orderNode.isAsc());
            }
        }
        if (logicalLimitNode != null) {
            physicalPlan = new Limit(physicalPlan, logicalLimitNode.getStart(), logicalLimitNode.getSize());
        }
        if (distinct) {
            physicalPlan = new Distinct(physicalPlan);
        }
        return physicalPlan;
    }

    //不断地进行一个Map-Reduce的过程
    private DbIterator joinToPhysicalPlan() {
        //初始化操作，使用插入和删除高效的LinkedList
        List<List<String>> groupList = new LinkedList<>();
        Map<Integer, DbIterator> iteratorMap = new HashMap<>();
        Set<Map.Entry<String, String>> tables = tableNode.getTables().entrySet();
        for (Map.Entry<String, String> table : tables) {
            List<String> group = new ArrayList<>();
            group.add(table.getKey());
            iteratorMap.put(groupList.size(), new SeqScan(table.getValue(), table.getKey()));
            groupList.add(group);
        }
        if (filterNode.getWhereTree() != null) {
            Map<WhereNode, List<String>> whereNodeListMap = new HashMap<>();
            optimalTree(filterNode.getWhereTree(), whereNodeListMap);
            //一趟处理，处理单个条件，即选择条件下推
            Iterator<Map.Entry<WhereNode, List<String>>> whereNodeListIterator = whereNodeListMap.entrySet().iterator();
            while (whereNodeListIterator.hasNext()) {
                Map.Entry<WhereNode, List<String>> whereNodeListEntry = whereNodeListIterator.next();
                List<String> aliasList = whereNodeListEntry.getValue();
                if (aliasList.size() == 1) {
                    String alias = aliasList.get(0);
                    int index = findInList(alias, groupList);
                    DbIterator dbIterator = iteratorMap.get(index);
                    dbIterator = new Filter(dbIterator, whereNodeListEntry.getKey());
                    iteratorMap.put(index, dbIterator);
                    whereNodeListIterator.remove();
                }
            }
            //遍历剩余的where,进行多表连接
            for (Map.Entry<WhereNode, List<String>> whereNodeListEntry : whereNodeListMap.entrySet()) {
                WhereNode whereNode = whereNodeListEntry.getKey();
                List<String> aliasList = whereNodeListEntry.getValue();
                Set<Integer> indexSet = new HashSet<>();
                for (String alias : aliasList) {
                    indexSet.add(findInList(alias, groupList));
                }
                Iterator<Integer> indexIterator = indexSet.iterator();
                //只涉及一个组，在这个组上添加Filter
                if (indexSet.size() == 1) {
                    Integer next = indexIterator.next();
                    DbIterator dbIterator = iteratorMap.get(next);
                    dbIterator  = new Filter(dbIterator, whereNode);
                    iteratorMap.put(next, dbIterator);
                } else {
                    //涉及多个组，做Join操作
                    Integer first = indexIterator.next();
                    DbIterator dbIterator = iteratorMap.get(first);
                    List<String> firstList = groupList.get(first);
                    //逐表连接
                    while (indexIterator.hasNext()) {
                        Integer next = indexIterator.next();
                        dbIterator = new Join(dbIterator, iteratorMap.get(next), null);
                        List<String> nextList = groupList.get(next);
                        //向上合并
                        groupList.remove(next.intValue());
                        iteratorMap.remove(next);
                        firstList.addAll(nextList);
                    }
                    //重新放入
                    Join join = (Join) dbIterator;
                    join.setWhereTree(whereNode);
                    iteratorMap.put(first, join);
                }
            }
        }
        //如果最后就剩一个表了，直接返回
        if (iteratorMap.size() == 1) {
            return iteratorMap.entrySet().iterator().next().getValue();
        }
        //对剩下的表进行连接操作
        Iterator<Map.Entry<Integer, DbIterator>> dbIterator = iteratorMap.entrySet().iterator();
        DbIterator resIterator = dbIterator.next().getValue();
        while (dbIterator.hasNext()) {
            DbIterator next = dbIterator.next().getValue();
            resIterator = new Join(resIterator, next, null);
        }
        return resIterator;

    }

    private int findInList(String alias, List<List<String>> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            List<String> group = groupList.get(i);
            if (group.contains(alias)) return i;
        }
        throw new ParseException("the alias is not existed");
    }

    private void optimalTree(WhereNode whereTree, Map<WhereNode, List<String>> whereNodeListMap) {
        if (whereTree instanceof LeafNode) return;
        InnerNode innerNode = (InnerNode) whereTree;
        if (innerNode.getLeft() instanceof LeafNode) {
            putIntoMap(innerNode, whereNodeListMap);
        }
        if (innerNode.getOperator() == Op.OR) {
            putIntoMap(whereTree, whereNodeListMap);
            return;
        }
        optimalTree(innerNode.getLeft(), whereNodeListMap);
        optimalTree(innerNode.getRight(), whereNodeListMap);
    }

    private void putIntoMap(WhereNode whereTree, Map<WhereNode, List<String>> whereNodeListMap) {
        List<String> fieldList = new ArrayList<>();
        WhereClauseUtil.getWhereFieldList(whereTree, fieldList);
        if (fieldList.size() > 0) {
            List<String> aliasList = fieldList
                    .stream()
                    .map(s -> OgnlUtil.getField(s, 0))
                    .distinct()
                    .collect(Collectors.toList());
            whereNodeListMap.put(whereTree, aliasList);
        }
    }
}
