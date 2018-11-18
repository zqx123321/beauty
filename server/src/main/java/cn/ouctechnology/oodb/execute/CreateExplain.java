package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.PrimaryKey;
import cn.ouctechnology.oodb.catalog.Table;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.catalog.attribute.AttributeFactory;
import cn.ouctechnology.oodb.catalog.attribute.ListAttribute;
import cn.ouctechnology.oodb.catalog.attribute.ObjectAttribute;
import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.exception.ExplainException;
import cn.ouctechnology.oodb.exception.ParseException;
import cn.ouctechnology.oodb.reocrd.Record;
import lombok.Builder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.constant.Constants.ROWS_AFFECTED;
import static cn.ouctechnology.oodb.constant.Constants.SINGLE_AFFECTED;
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

    private List<String> refs;

    //只能存在一个主键
    private boolean primary;

    public static CreateExplain getCreateExplain(CreateStatContext create) {
        String tableName = create.getChild(TableNameContext.class).getText();
        ColumnDefinitionContext columnDefinitionContext = create.getChild(ColumnDefinitionContext.class);
        ExtendsTableContext extendsTableContext = create.getChild(ExtendsTableContext.class);
        TableConstraintContext tableConstraintContext = create.getChild(TableConstraintContext.class);
        List<String> refs = new ArrayList<>();
        return CreateExplain
                .builder()
                .tableName(tableName)
                .refs(refs)
                .columnDefinitionContext(columnDefinitionContext)
                .constraintContext(tableConstraintContext)
                .extendsTableContext(extendsTableContext)
                .primary(false)
                .build();
    }

    public String doCreate() {
        table = new Table();
        table.setTableName(tableName);
        table.setTupleNum(0);
        dealWithExtendsTable();
        List<Attribute> attributeList = dealWithColumnDefinition(columnDefinitionContext);
        if (attributeList != null) {
            int length = 0;
            for (Attribute attribute : attributeList) {
                table.addAttribute(attribute);
                length += attribute.getLength();
            }
            table.setTupleLength(length);
        }
        dealWithTableConstraint();
        table.setRefs(refs);
        try {
            Catalog.createTable(table);
            Record.create(tableName);
            //在主键上建立索引
            PrimaryKey primaryKey = table.getPrimaryKey();
            if (primaryKey != null) {
                Catalog.addIndex(tableName, "idx_" + primaryKey.getName(), primaryKey.getName());
            }
        } catch (Exception e) {
            //出错后回滚，保证一致性
            Catalog.dropTable(tableName);
            Record.drop(tableName);
            PrimaryKey primaryKey = table.getPrimaryKey();
            if (primaryKey != null) {
                Catalog.dropIndex(tableName, "idx_" + primaryKey.getName());
            }
            throw e;
        }
        return SINGLE_AFFECTED + ROWS_AFFECTED;
    }

    private void dealWithExtendsTable() {
        if (extendsTableContext != null) {
            List<TerminalNode> tokens = extendsTableContext.getTokens(WORD);
            List<String> extendsTables = tokens.stream().map(TerminalNode::getText).collect(Collectors.toList());

            for (String extendsTableName : extendsTables) {
                Table extendsTable = Catalog.getTable(extendsTableName);
                List<Attribute> attributes = extendsTable.getAttributes();
                for (Attribute attribute : attributes) {
                    if (attribute.isSee()) table.getAttributes().add(attribute);
                }
            }

            table.setExtendTables(extendsTables);
        }
    }

    private List<Attribute> dealWithColumnDefinition(ColumnDefinitionContext columnDefinition) {
        if (columnDefinition != null) {
            List<Attribute> attributeList = new ArrayList<>();
            List<ColumnDefinitionItemContext> itemContexts = columnDefinition.getChildren(ColumnDefinitionItemContext.class);
            for (ColumnDefinitionItemContext itemContext : itemContexts) {
                Attribute attribute = dealWithItemContext(itemContext);
                List<ColumnConstraintContext> constraintContexts = itemContext.columnConstraint();
                for (ColumnConstraintContext context : constraintContexts) {
                    if (context.PRIMARY() != null) {
                        if (primary) throw new ParseException("only supported one primary key");
                        primary = true;
                        String primaryName = attribute.getName();
                        PrimaryKey.PrimaryKeyPolicy policy;
                        if (context.AUTO_INCREMENT() != null) {
                            policy = PrimaryKey.PrimaryKeyPolicy.AUTO_INCREASE;
                        } else if (context.UUID() != null) {
                            if (attribute.getType() != Type.CHAR)
                                throw new ParseException("the uuid can only be applied to the char attribute");
                            policy = PrimaryKey.PrimaryKeyPolicy.UUID;
                        } else {
                            policy = PrimaryKey.PrimaryKeyPolicy.ASSIGN;
                        }
                        table.setPrimaryKey(new PrimaryKey(primaryName, policy));
                    }
                    if (context.FINAL() != null) {
                        attribute.setSee(false);
                    }
                }
                attributeList.add(attribute);
            }
            return attributeList;
        }
        return null;
    }

    private Attribute dealWithItemContext(ColumnDefinitionItemContext itemContext) {
        String name = itemContext.getToken(WORD, 0).getText();
        ColumnTypeContext columnTypeContext = itemContext.getChild(ColumnTypeContext.class);
        return columnTypeToAttribute(name, columnTypeContext);
    }

    private Attribute columnTypeToAttribute(String name, ColumnTypeContext columnTypeContext) {
        int length = 0;
        String type;
        if (columnTypeContext.columnDefinition() != null) {
            ColumnDefinitionContext columnDefinitionContext = columnTypeContext.columnDefinition();
            List<Attribute> attributeList = dealWithColumnDefinition(columnDefinitionContext);
            for (Attribute attribute : attributeList) {
                length += attribute.getLength();
            }
            return new ObjectAttribute(name, length, attributeList);
        }
        if (columnTypeContext.columnType() != null) {
            int size = Integer.parseInt(columnTypeContext.INTNUMERAL().getText());
            ColumnTypeContext newColumnType = columnTypeContext.columnType();
            Attribute listAttribute = columnTypeToAttribute(name, newColumnType);
            return new ListAttribute(name, size * listAttribute.getLength(), listAttribute);
        }
        TerminalNode num = columnTypeContext.getToken(INTNUMERAL, 0);
        if (num != null) {
            length = Integer.parseInt(num.getText());
            type = columnTypeContext.getToken(CHAR, 0).getText();
            return AttributeFactory.createAttribute(type, name, length);
        }
        TerminalNode word = columnTypeContext.getToken(WORD, 0);
        if (word != null) {
            String refTable = word.getText();
            length = Catalog.getTupleLength(refTable);
            List<Attribute> innerAttributes = Catalog.getAttributes(refTable);
            refs.add(refTable);
            return new ObjectAttribute(name, length, innerAttributes);
        }
        type = columnTypeContext.getChild(0).getText();
        return AttributeFactory.createAttribute(type, name, length);
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
            if (keys.size() > 1) throw new ParseException("only supported one primary key");
            String key = keys.get(0);
            Catalog.getAttribute(table.getAttributes(), key);
            PrimaryKey.PrimaryKeyPolicy policy;
            if (constraintContext.AUTO_INCREMENT() != null) {
                policy = PrimaryKey.PrimaryKeyPolicy.AUTO_INCREASE;
            } else if (constraintContext.UUID() != null) {
                Attribute attribute = Catalog.getAttribute(tableName, key);
                if (attribute.getType() != Type.CHAR)
                    throw new ParseException("the uuid can only be applied to the char attribute");
                policy = PrimaryKey.PrimaryKeyPolicy.UUID;
            } else {
                policy = PrimaryKey.PrimaryKeyPolicy.ASSIGN;
            }
            table.setPrimaryKey(new PrimaryKey(key, policy));
            primary = true;
        }
    }
}
