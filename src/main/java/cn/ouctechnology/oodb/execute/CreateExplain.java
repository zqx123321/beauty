package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.Table;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.catalog.attribute.AttributeFactory;
import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.reocrd.Record;
import lombok.Builder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.parser.OQLParser.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-18 14:40
 * @description: TODO
 **/
@Builder
public class CreateExplain {

    private String tableName;

    private ColumnDefinitionContext columnDefinitionContext;

    private ExtendsTableContext extendsTableContext;

    private TableConstraintContext constraintContext;

    private Table table;

    //只能存在一个主键
    private boolean primary;

    public static CreateExplain getCreateExplain(CreateStatContext create) {
        String tableName = create.getChild(TableNameContext.class).getText();
        ColumnDefinitionContext columnDefinitionContext = create.getChild(ColumnDefinitionContext.class);
        ExtendsTableContext extendsTableContext = create.getChild(ExtendsTableContext.class);
        TableConstraintContext tableConstraintContext = create.getChild(TableConstraintContext.class);
        return CreateExplain
                .builder()
                .tableName(tableName)
                .columnDefinitionContext(columnDefinitionContext)
                .constraintContext(tableConstraintContext)
                .extendsTableContext(extendsTableContext)
                .primary(false)
                .build();
    }

    public int doCreate() {
        table = new Table();
        table.setTableName(tableName);
        table.setTupleNum(0);
        dealWithExtendsTable();
        dealWithColumnDefinition();
        dealWithTableConstraint();
        Catalog.createTable(table);
        Record.create(tableName);
        return Constants.SINGLE_AFFECTED;
    }

    private void dealWithExtendsTable() {
        if (extendsTableContext != null) {
            List<TerminalNode> tokens = extendsTableContext.getTokens(WORD);
            List<String> extendsTables = tokens.stream().map(TerminalNode::getText).collect(Collectors.toList());

            for (String extendsTableName : extendsTables) {
                Table extendsTable = Catalog.getTable(extendsTableName);
                table.getAttributes().addAll(extendsTable.getAttributes());
            }
        }
    }

    private void dealWithColumnDefinition() {
        if (columnDefinitionContext != null) {
            List<ColumnDefinitionItemContext> itemContexts = columnDefinitionContext.getChildren(ColumnDefinitionItemContext.class);
            for (ColumnDefinitionItemContext itemContext : itemContexts) {
                Attribute attribute = dealWithItemContext(itemContext);
                if (dealWithColumnConstraint(itemContext)) {
                    if (primary) throw new ExplainException("primary key id duplicated");
                    table.addPrimaryKey(attribute.getName());
                    primary = true;
                }
                table.addAttribute(attribute);
            }
        }
    }

    private Attribute dealWithItemContext(ColumnDefinitionItemContext itemContext) {
        String name = itemContext.getToken(WORD, 0).getText();
        ColumnTypeContext columnTypeContext = itemContext.getChild(ColumnTypeContext.class);
        int length = 0;
        String type;
        TerminalNode num = columnTypeContext.getToken(INTNUMERAL, 0);
        if (num != null) {
            length = Integer.parseInt(num.getText());
            type = columnTypeContext.getToken(CHAR, 0).getText();
            return AttributeFactory.createAttribute(type, name, length, null);
        }
        TerminalNode word = columnTypeContext.getToken(WORD, 0);
        if (word != null) {
            String refTable = word.getText();
            length = Catalog.getTupleLength(refTable);
            type = "OBJECT";//TODO 去除魔法值
            List<Attribute> innerAttributes = Catalog.getAttributes(refTable);
            return AttributeFactory.createAttribute(type, name, length, innerAttributes);
        }
        type = columnTypeContext.getChild(0).getText();
        return AttributeFactory.createAttribute(type, name, length, null);
    }

    private boolean dealWithColumnConstraint(ColumnDefinitionItemContext itemContext) {
        List<ColumnConstraintContext> constraintContexts = itemContext.getChildren(ColumnConstraintContext.class);
        if (constraintContexts != null) {
            for (ColumnConstraintContext context : constraintContexts) {
                if (context.getTokens(PRIMARY) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dealWithTableConstraint() {
        if (constraintContext != null) {
            if (primary) throw new ExplainException("primary key id duplicated");
            List<String> keys = constraintContext
                    .getChildren(PathExprContext.class)
                    .stream()
                    .map(ParseTree::getText)
                    .collect(Collectors.toList());
            //检查语义错误
            for (String key : keys) {
                Catalog.getAttribute(table.getAttributes(), key);
            }
            table.getPrimaryKeys().addAll(keys);
            primary = true;
        }
    }
}
