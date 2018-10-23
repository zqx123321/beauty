// Generated from D:/杂乱文件终章/oodb/src/test/java\OQL.g4 by ANTLR 4.7
package cn.ouctechnology.oodb.parser;

import cn.ouctechnology.oodb.explain.create.CreateExplain;
import cn.ouctechnology.oodb.explain.delete.DeleteExplain;
import cn.ouctechnology.oodb.explain.drop.DropExplain;
import cn.ouctechnology.oodb.explain.select.SelectExplain;
import cn.ouctechnology.oodb.explain.update.UpdateExplain;
import cn.ouctechnology.oodb.explain.where.InnerNode;
import cn.ouctechnology.oodb.explain.where.LeafNode;
import cn.ouctechnology.oodb.explain.where.Operator;
import cn.ouctechnology.oodb.explain.where.WhereNode;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OQLParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            SELECT = 1, CREATE = 2, UPDATE = 3, DELETE = 4, INSERT = 5, FROM = 6, AS = 7, LEFT = 8,
            RIGHT = 9, OUTER = 10, JOIN = 11, INNER = 12, DISTINCT = 13, OBJECT = 14, NEW = 15,
            AVG = 16, SUM = 17, MAX = 18, MIN = 19, COUNT = 20, WHERE = 21, GROUP = 22, BY = 23, ORDER = 24,
            HAVING = 25, DESC = 26, ASC = 27, NOT = 28, BETWEEN = 29, IS = 30, NULL = 31, ESCAPE = 32,
            AND = 33, OR = 34, LIKE = 35, IN = 36, INTO = 37, VALUES = 38, PRIMARY = 39, KEY = 40,
            SET = 41, EXTENDS = 42, EMPTY = 43, MEMBER = 44, OF = 45, ALL = 46, ANY = 47, SOME = 48,
            INT = 49, FLOAT = 50, CHAR = 51, SETOF = 52, REF = 53, TABLE = 54, EXISTS = 55, AUTO_INCREMENT = 56,
            UNIQUE = 57, LIMIT = 58, DROP = 59, CASCADE = 60, MUL = 61, DIV = 62, PLUS = 63, MINUS = 64,
            EQ = 65, GR = 66, LS = 67, GE = 68, LE = 69, NE = 70, DOT = 71, LBRACKET = 72, RBRACKET = 73,
            COMMA = 74, SEMI = 75, COLON = 76, TRIMCHARACTER = 77, STRINGLITERAL = 78, WORD = 79,
            NAMEDPARAMETER = 80, WS = 81, COMMENT = 82, LINECOMMENT = 83, ESCAPECHARACTER = 84,
            INTNUMERAL = 85, FLOATNUMERAL = 86;
    public static final int
            RULE_oqlStat = 0, RULE_selectStat = 1, RULE_selectClause = 2, RULE_selectExpr = 3,
            RULE_fromClause = 4, RULE_fromItem = 5, RULE_join = 6, RULE_joinType = 7,
            RULE_pathExpr = 8, RULE_limitClause = 9, RULE_constructorExpr = 10, RULE_constructorItem = 11,
            RULE_aggregateExpr = 12, RULE_aggregateExprFunctionName = 13, RULE_whereClause = 14,
            RULE_groupByClause = 15, RULE_havingClause = 16, RULE_orderByClause = 17,
            RULE_orderByItem = 18, RULE_subQuery = 19, RULE_conditionalExpr = 20,
            RULE_conditionalTerm = 21, RULE_conditionalFactor = 22, RULE_simpleCondExpr = 23,
            RULE_betweenExpr = 24, RULE_inExpr = 25, RULE_inExprRightPart = 26, RULE_inItem = 27,
            RULE_likeExpr = 28, RULE_nullComparisonExpr = 29, RULE_emptyCollectionComparisonExpr = 30,
            RULE_collectionMemberExpr = 31, RULE_existsExpr = 32, RULE_comparisonExpr = 33,
            RULE_comparisonOperator = 34, RULE_arithmeticExpr = 35, RULE_simpleArithmeticExpr = 36,
            RULE_arithmeticTerm = 37, RULE_arithmeticFactor = 38, RULE_arithmeticPrimary = 39,
            RULE_stringExpr = 40, RULE_stringPrimary = 41, RULE_stringLiteralExpr = 42,
            RULE_entityExpr = 43, RULE_simpleEntityExpr = 44, RULE_schemaName = 45,
            RULE_patternValue = 46, RULE_numericLiteral = 47, RULE_literal = 48, RULE_constructorName = 49,
            RULE_field = 50, RULE_id = 51, RULE_createStat = 52, RULE_tableName = 53,
            RULE_columnDefinition = 54, RULE_columnDefinitionItem = 55, RULE_columnType = 56,
            RULE_columnConstraint = 57, RULE_extendsTable = 58, RULE_tableConstraint = 59,
            RULE_updateStat = 60, RULE_updateClause = 61, RULE_updateItem = 62, RULE_newValue = 63,
            RULE_insertEntityExpr = 64, RULE_insertEntityItem = 65, RULE_deleteStat = 66,
            RULE_deleteClause = 67, RULE_insertStat = 68, RULE_columnList = 69, RULE_insertValue = 70,
            RULE_dropStat = 71;
    public static final String[] ruleNames = {
            "oqlStat", "selectStat", "selectClause", "selectExpr", "fromClause", "fromItem",
            "join", "joinType", "pathExpr", "limitClause", "constructorExpr", "constructorItem",
            "aggregateExpr", "aggregateExprFunctionName", "whereClause", "groupByClause",
            "havingClause", "orderByClause", "orderByItem", "subQuery", "conditionalExpr",
            "conditionalTerm", "conditionalFactor", "simpleCondExpr", "betweenExpr",
            "inExpr", "inExprRightPart", "inItem", "likeExpr", "nullComparisonExpr",
            "emptyCollectionComparisonExpr", "collectionMemberExpr", "existsExpr",
            "comparisonExpr", "comparisonOperator", "arithmeticExpr", "simpleArithmeticExpr",
            "arithmeticTerm", "arithmeticFactor", "arithmeticPrimary", "stringExpr",
            "stringPrimary", "stringLiteralExpr", "entityExpr", "simpleEntityExpr",
            "schemaName", "patternValue", "numericLiteral", "literal", "constructorName",
            "field", "id", "createStat", "tableName", "columnDefinition", "columnDefinitionItem",
            "columnType", "columnConstraint", "extendsTable", "tableConstraint", "updateStat",
            "updateClause", "updateItem", "newValue", "insertEntityExpr", "insertEntityItem",
            "deleteStat", "deleteClause", "insertStat", "columnList", "insertValue",
            "dropStat"
    };

    private static final String[] _LITERAL_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, "'*'", "'/'", "'+'", "'-'", "'='", "'>'", "'<'", "'>='", "'<='",
            null, "'.'", "'('", "')'", "','", "';'", "':'", "''.''"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "SELECT", "CREATE", "UPDATE", "DELETE", "INSERT", "FROM", "AS",
            "LEFT", "RIGHT", "OUTER", "JOIN", "INNER", "DISTINCT", "OBJECT", "NEW",
            "AVG", "SUM", "MAX", "MIN", "COUNT", "WHERE", "GROUP", "BY", "ORDER",
            "HAVING", "DESC", "ASC", "NOT", "BETWEEN", "IS", "NULL", "ESCAPE", "AND",
            "OR", "LIKE", "IN", "INTO", "VALUES", "PRIMARY", "KEY", "SET", "EXTENDS",
            "EMPTY", "MEMBER", "OF", "ALL", "ANY", "SOME", "INT", "FLOAT", "CHAR",
            "SETOF", "REF", "TABLE", "EXISTS", "AUTO_INCREMENT", "UNIQUE", "LIMIT",
            "DROP", "CASCADE", "MUL", "DIV", "PLUS", "MINUS", "EQ", "GR", "LS", "GE",
            "LE", "NE", "DOT", "LBRACKET", "RBRACKET", "COMMA", "SEMI", "COLON", "TRIMCHARACTER",
            "STRINGLITERAL", "WORD", "NAMEDPARAMETER", "WS", "COMMENT", "LINECOMMENT",
            "ESCAPECHARACTER", "INTNUMERAL", "FLOATNUMERAL"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "OQL.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public OQLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class OqlStatContext extends EnhancedParserRuleContext {
        public OqlStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_oqlStat;
        }

        public OqlStatContext() {
        }

        public void copyFrom(OqlStatContext ctx) {
            super.copyFrom(ctx);
        }

        public Object doExecute() {
            return null;
        }
    }

    public static class CreateStatementContext extends OqlStatContext {
        public CreateStatContext createStat() {
            return getRuleContext(CreateStatContext.class, 0);
        }

        public CreateStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            CreateStatContext context = getChild(CreateStatContext.class);
            if (context == null) return null;
            return CreateExplain.getCreateExplain(context).doCreate();
        }
    }

    public static class DeleteStatementContext extends OqlStatContext {
        public DeleteStatContext deleteStat() {
            return getRuleContext(DeleteStatContext.class, 0);
        }

        public DeleteStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            DeleteStatContext deleteStatContext = getChild(DeleteStatContext.class);
            return DeleteExplain.getDeleteExplain(deleteStatContext).doDelete();
        }
    }

    public static class InsertStatementContext extends OqlStatContext {
        public InsertStatContext insertStat() {
            return getRuleContext(InsertStatContext.class, 0);
        }

        public InsertStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class UpdateStatementContext extends OqlStatContext {
        public UpdateStatContext updateStat() {
            return getRuleContext(UpdateStatContext.class, 0);
        }

        public UpdateStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            UpdateStatContext updateStatContext = getChild(UpdateStatContext.class);
            return UpdateExplain.getUpdateExplain(updateStatContext).doUpdate();
        }
    }

    public static class SelectStatementContext extends OqlStatContext {
        public SelectStatContext selectStat() {
            return getRuleContext(SelectStatContext.class, 0);
        }

        public SelectStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            SelectStatContext context = getChild(SelectStatContext.class);
            if (context == null) return null;
            return SelectExplain.getSelectExplain(context).doSelect();
        }
    }

    public static class DropStatementContext extends OqlStatContext {
        public DropStatContext dropStat() {
            return getRuleContext(DropStatContext.class, 0);
        }

        public DropStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            DropStatContext context = getChild(DropStatContext.class);
            if (context == null) return null;
            return DropExplain.getDropStatContext(context).doDrop();
        }
    }

    public final OqlStatContext oqlStat() throws RecognitionException {
        OqlStatContext _localctx = new OqlStatContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_oqlStat);
        try {
            setState(150);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SELECT:
                    _localctx = new SelectStatementContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(144);
                    selectStat();
                }
                break;
                case CREATE:
                    _localctx = new CreateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(145);
                    createStat();
                }
                break;
                case INSERT:
                    _localctx = new InsertStatementContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(146);
                    insertStat();
                }
                break;
                case UPDATE:
                    _localctx = new UpdateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(147);
                    updateStat();
                }
                break;
                case DELETE:
                    _localctx = new DeleteStatementContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(148);
                    deleteStat();
                }
                break;
                case DROP:
                    _localctx = new DropStatementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(149);
                    dropStat();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectStatContext extends EnhancedParserRuleContext {
        public TerminalNode SELECT() {
            return getToken(OQLParser.SELECT, 0);
        }

        public SelectClauseContext selectClause() {
            return getRuleContext(SelectClauseContext.class, 0);
        }

        public FromClauseContext fromClause() {
            return getRuleContext(FromClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public GroupByClauseContext groupByClause() {
            return getRuleContext(GroupByClauseContext.class, 0);
        }

        public HavingClauseContext havingClause() {
            return getRuleContext(HavingClauseContext.class, 0);
        }

        public OrderByClauseContext orderByClause() {
            return getRuleContext(OrderByClauseContext.class, 0);
        }

        public LimitClauseContext limitClause() {
            return getRuleContext(LimitClauseContext.class, 0);
        }

        public SelectStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectStat;
        }
    }

    public final SelectStatContext selectStat() throws RecognitionException {
        SelectStatContext _localctx = new SelectStatContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_selectStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(152);
                match(SELECT);
                setState(153);
                selectClause();
                setState(154);
                fromClause();
                setState(156);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(155);
                        whereClause();
                    }
                }

                setState(159);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GROUP) {
                    {
                        setState(158);
                        groupByClause();
                    }
                }

                setState(162);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HAVING) {
                    {
                        setState(161);
                        havingClause();
                    }
                }

                setState(165);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ORDER) {
                    {
                        setState(164);
                        orderByClause();
                    }
                }

                setState(168);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(167);
                        limitClause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectClauseContext extends EnhancedParserRuleContext {
        public List<SelectExprContext> selectExpr() {
            return getRuleContexts(SelectExprContext.class);
        }

        public SelectExprContext selectExpr(int i) {
            return getRuleContext(SelectExprContext.class, i);
        }

        public TerminalNode DISTINCT() {
            return getToken(OQLParser.DISTINCT, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public SelectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectClause;
        }
    }

    public final SelectClauseContext selectClause() throws RecognitionException {
        SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_selectClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(171);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DISTINCT) {
                    {
                        setState(170);
                        match(DISTINCT);
                    }
                }

                setState(173);
                selectExpr();
                setState(178);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(174);
                            match(COMMA);
                            setState(175);
                            selectExpr();
                        }
                    }
                    setState(180);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectExprContext extends EnhancedParserRuleContext {
        public SelectExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectExpr;
        }

        public SelectExprContext() {
        }

        public void copyFrom(SelectExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SelectObjectExprContext extends SelectExprContext {
        public TerminalNode OBJECT() {
            return getToken(OQLParser.OBJECT, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public SelectObjectExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SelectPathExprContext extends SelectExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public SelectPathExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SelectConstructorExprContext extends SelectExprContext {
        public ConstructorExprContext constructorExpr() {
            return getRuleContext(ConstructorExprContext.class, 0);
        }

        public SelectConstructorExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SelectAggregateExprContext extends SelectExprContext {
        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public SelectAggregateExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final SelectExprContext selectExpr() throws RecognitionException {
        SelectExprContext _localctx = new SelectExprContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_selectExpr);
        try {
            setState(189);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new SelectPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(181);
                    pathExpr();
                }
                break;
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                    _localctx = new SelectAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(182);
                    aggregateExpr();
                }
                break;
                case OBJECT:
                    _localctx = new SelectObjectExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(183);
                    match(OBJECT);
                    setState(184);
                    match(LBRACKET);
                    setState(185);
                    id();
                    setState(186);
                    match(RBRACKET);
                }
                break;
                case NEW:
                    _localctx = new SelectConstructorExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(188);
                    constructorExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromClauseContext extends EnhancedParserRuleContext {
        public TerminalNode FROM() {
            return getToken(OQLParser.FROM, 0);
        }

        public List<FromItemContext> fromItem() {
            return getRuleContexts(FromItemContext.class);
        }

        public FromItemContext fromItem(int i) {
            return getRuleContext(FromItemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public FromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromClause;
        }
    }

    public final FromClauseContext fromClause() throws RecognitionException {
        FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_fromClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(191);
                match(FROM);
                setState(192);
                fromItem();
                setState(197);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(193);
                            match(COMMA);
                            setState(194);
                            fromItem();
                        }
                    }
                    setState(199);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FromItemContext extends EnhancedParserRuleContext {
        public SchemaNameContext schemaName() {
            return getRuleContext(SchemaNameContext.class, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(OQLParser.AS, 0);
        }

        public JoinContext join() {
            return getRuleContext(JoinContext.class, 0);
        }

        public FromItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromItem;
        }
    }

    public final FromItemContext fromItem() throws RecognitionException {
        FromItemContext _localctx = new FromItemContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_fromItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(200);
                schemaName();
                setState(202);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(201);
                        match(AS);
                    }
                }

                setState(204);
                id();
                setState(206);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << RIGHT) | (1L << JOIN) | (1L << INNER))) != 0)) {
                    {
                        setState(205);
                        join();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class JoinContext extends EnhancedParserRuleContext {
        public JoinTypeContext joinType() {
            return getRuleContext(JoinTypeContext.class, 0);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(OQLParser.AS, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public JoinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_join;
        }
    }

    public final JoinContext join() throws RecognitionException {
        JoinContext _localctx = new JoinContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_join);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                joinType();
                setState(209);
                pathExpr();
                setState(212);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(210);
                        match(AS);
                        setState(211);
                        id();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class JoinTypeContext extends EnhancedParserRuleContext {
        public TerminalNode JOIN() {
            return getToken(OQLParser.JOIN, 0);
        }

        public TerminalNode INNER() {
            return getToken(OQLParser.INNER, 0);
        }

        public TerminalNode LEFT() {
            return getToken(OQLParser.LEFT, 0);
        }

        public TerminalNode RIGHT() {
            return getToken(OQLParser.RIGHT, 0);
        }

        public TerminalNode OUTER() {
            return getToken(OQLParser.OUTER, 0);
        }

        public JoinTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_joinType;
        }
    }

    public final JoinTypeContext joinType() throws RecognitionException {
        JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_joinType);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(219);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case LEFT:
                    case RIGHT: {
                        setState(214);
                        _la = _input.LA(1);
                        if (!(_la == LEFT || _la == RIGHT)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(216);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == OUTER) {
                            {
                                setState(215);
                                match(OUTER);
                            }
                        }

                    }
                    break;
                    case INNER: {
                        setState(218);
                        match(INNER);
                    }
                    break;
                    case JOIN:
                        break;
                    default:
                        break;
                }
                setState(221);
                match(JOIN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PathExprContext extends EnhancedParserRuleContext {
        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public List<TerminalNode> DOT() {
            return getTokens(OQLParser.DOT);
        }

        public TerminalNode DOT(int i) {
            return getToken(OQLParser.DOT, i);
        }

        public List<FieldContext> field() {
            return getRuleContexts(FieldContext.class);
        }

        public FieldContext field(int i) {
            return getRuleContext(FieldContext.class, i);
        }

        public PathExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pathExpr;
        }
    }

    public final PathExprContext pathExpr() throws RecognitionException {
        PathExprContext _localctx = new PathExprContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_pathExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(223);
                id();
                setState(228);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(224);
                            match(DOT);
                            setState(225);
                            field();
                        }
                    }
                    setState(230);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LimitClauseContext extends EnhancedParserRuleContext {
        public TerminalNode LIMIT() {
            return getToken(OQLParser.LIMIT, 0);
        }

        public List<TerminalNode> INTNUMERAL() {
            return getTokens(OQLParser.INTNUMERAL);
        }

        public TerminalNode INTNUMERAL(int i) {
            return getToken(OQLParser.INTNUMERAL, i);
        }

        public TerminalNode COMMA() {
            return getToken(OQLParser.COMMA, 0);
        }

        public LimitClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_limitClause;
        }
    }

    public final LimitClauseContext limitClause() throws RecognitionException {
        LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_limitClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(231);
                match(LIMIT);
                setState(232);
                match(INTNUMERAL);
                setState(235);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(233);
                        match(COMMA);
                        setState(234);
                        match(INTNUMERAL);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConstructorExprContext extends EnhancedParserRuleContext {
        public TerminalNode NEW() {
            return getToken(OQLParser.NEW, 0);
        }

        public ConstructorNameContext constructorName() {
            return getRuleContext(ConstructorNameContext.class, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<ConstructorItemContext> constructorItem() {
            return getRuleContexts(ConstructorItemContext.class);
        }

        public ConstructorItemContext constructorItem(int i) {
            return getRuleContext(ConstructorItemContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public ConstructorExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constructorExpr;
        }
    }

    public final ConstructorExprContext constructorExpr() throws RecognitionException {
        ConstructorExprContext _localctx = new ConstructorExprContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_constructorExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(237);
                match(NEW);
                setState(238);
                constructorName();
                setState(239);
                match(LBRACKET);
                setState(240);
                constructorItem();
                setState(245);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(241);
                            match(COMMA);
                            setState(242);
                            constructorItem();
                        }
                    }
                    setState(247);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(248);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConstructorItemContext extends EnhancedParserRuleContext {
        public ConstructorItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constructorItem;
        }

        public ConstructorItemContext() {
        }

        public void copyFrom(ConstructorItemContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ConPathExprContext extends ConstructorItemContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public ConPathExprContext(ConstructorItemContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ConAggregateExprContext extends ConstructorItemContext {
        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public ConAggregateExprContext(ConstructorItemContext ctx) {
            copyFrom(ctx);
        }
    }

    public final ConstructorItemContext constructorItem() throws RecognitionException {
        ConstructorItemContext _localctx = new ConstructorItemContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_constructorItem);
        try {
            setState(252);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ConPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(250);
                    pathExpr();
                }
                break;
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                    _localctx = new ConAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(251);
                    aggregateExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AggregateExprContext extends EnhancedParserRuleContext {
        public AggregateExprFunctionNameContext aggregateExprFunctionName() {
            return getRuleContext(AggregateExprFunctionNameContext.class, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public TerminalNode DISTINCT() {
            return getToken(OQLParser.DISTINCT, 0);
        }

        public AggregateExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aggregateExpr;
        }
    }

    public final AggregateExprContext aggregateExpr() throws RecognitionException {
        AggregateExprContext _localctx = new AggregateExprContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_aggregateExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(254);
                aggregateExprFunctionName();
                setState(255);
                match(LBRACKET);
                setState(257);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DISTINCT) {
                    {
                        setState(256);
                        match(DISTINCT);
                    }
                }

                setState(259);
                pathExpr();
                setState(260);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AggregateExprFunctionNameContext extends EnhancedParserRuleContext {
        public TerminalNode AVG() {
            return getToken(OQLParser.AVG, 0);
        }

        public TerminalNode MAX() {
            return getToken(OQLParser.MAX, 0);
        }

        public TerminalNode MIN() {
            return getToken(OQLParser.MIN, 0);
        }

        public TerminalNode SUM() {
            return getToken(OQLParser.SUM, 0);
        }

        public TerminalNode COUNT() {
            return getToken(OQLParser.COUNT, 0);
        }

        public AggregateExprFunctionNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aggregateExprFunctionName;
        }
    }

    public final AggregateExprFunctionNameContext aggregateExprFunctionName() throws RecognitionException {
        AggregateExprFunctionNameContext _localctx = new AggregateExprFunctionNameContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_aggregateExprFunctionName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(262);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AVG) | (1L << SUM) | (1L << MAX) | (1L << MIN) | (1L << COUNT))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereClauseContext extends EnhancedParserRuleContext {
        public TerminalNode WHERE() {
            return getToken(OQLParser.WHERE, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        public WhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereClause;
        }
    }

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(264);
                match(WHERE);
                setState(265);
                conditionalExpr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class GroupByClauseContext extends EnhancedParserRuleContext {
        public TerminalNode GROUP() {
            return getToken(OQLParser.GROUP, 0);
        }

        public TerminalNode BY() {
            return getToken(OQLParser.BY, 0);
        }

        public List<PathExprContext> pathExpr() {
            return getRuleContexts(PathExprContext.class);
        }

        public PathExprContext pathExpr(int i) {
            return getRuleContext(PathExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_groupByClause;
        }
    }

    public final GroupByClauseContext groupByClause() throws RecognitionException {
        GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(267);
                match(GROUP);
                setState(268);
                match(BY);
                setState(269);
                pathExpr();
                setState(274);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(270);
                            match(COMMA);
                            setState(271);
                            pathExpr();
                        }
                    }
                    setState(276);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class HavingClauseContext extends EnhancedParserRuleContext {
        public TerminalNode HAVING() {
            return getToken(OQLParser.HAVING, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        public HavingClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_havingClause;
        }
    }

    public final HavingClauseContext havingClause() throws RecognitionException {
        HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(277);
                match(HAVING);
                setState(278);
                conditionalExpr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OrderByClauseContext extends EnhancedParserRuleContext {
        public TerminalNode ORDER() {
            return getToken(OQLParser.ORDER, 0);
        }

        public TerminalNode BY() {
            return getToken(OQLParser.BY, 0);
        }

        public List<OrderByItemContext> orderByItem() {
            return getRuleContexts(OrderByItemContext.class);
        }

        public OrderByItemContext orderByItem(int i) {
            return getRuleContext(OrderByItemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_orderByClause;
        }
    }

    public final OrderByClauseContext orderByClause() throws RecognitionException {
        OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(280);
                match(ORDER);
                setState(281);
                match(BY);
                setState(282);
                orderByItem();
                setState(287);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(283);
                            match(COMMA);
                            setState(284);
                            orderByItem();
                        }
                    }
                    setState(289);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OrderByItemContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode ASC() {
            return getToken(OQLParser.ASC, 0);
        }

        public TerminalNode DESC() {
            return getToken(OQLParser.DESC, 0);
        }

        public OrderByItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_orderByItem;
        }
    }

    public final OrderByItemContext orderByItem() throws RecognitionException {
        OrderByItemContext _localctx = new OrderByItemContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_orderByItem);
        int _la;
        try {
            setState(295);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(290);
                    pathExpr();
                    setState(292);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == ASC) {
                        {
                            setState(291);
                            match(ASC);
                        }
                    }

                }
                break;
                case DESC:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(294);
                    match(DESC);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SubQueryContext extends EnhancedParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public SelectClauseContext selectClause() {
            return getRuleContext(SelectClauseContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public SubQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_subQuery;
        }
    }

    public final SubQueryContext subQuery() throws RecognitionException {
        SubQueryContext _localctx = new SubQueryContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_subQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(297);
                match(LBRACKET);
                setState(298);
                selectClause();
                setState(299);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConditionalExprContext extends EnhancedParserRuleContext {
        public List<ConditionalTermContext> conditionalTerm() {
            return getRuleContexts(ConditionalTermContext.class);
        }

        public ConditionalTermContext conditionalTerm(int i) {
            return getRuleContext(ConditionalTermContext.class, i);
        }

        public List<TerminalNode> OR() {
            return getTokens(OQLParser.OR);
        }

        public TerminalNode OR(int i) {
            return getToken(OQLParser.OR, i);
        }

        public ConditionalExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionalExpr;
        }
    }

    public final ConditionalExprContext conditionalExpr() throws RecognitionException {
        ConditionalExprContext _localctx = new ConditionalExprContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_conditionalExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(301);
                    conditionalTerm();
                }
                setState(306);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(302);
                            match(OR);
                            setState(303);
                            conditionalTerm();
                        }
                    }
                    setState(308);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConditionalTermContext extends EnhancedParserRuleContext {
        public List<ConditionalFactorContext> conditionalFactor() {
            return getRuleContexts(ConditionalFactorContext.class);
        }

        public ConditionalFactorContext conditionalFactor(int i) {
            return getRuleContext(ConditionalFactorContext.class, i);
        }

        public List<TerminalNode> AND() {
            return getTokens(OQLParser.AND);
        }

        public TerminalNode AND(int i) {
            return getToken(OQLParser.AND, i);
        }

        public ConditionalTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionalTerm;
        }
    }

    public final ConditionalTermContext conditionalTerm() throws RecognitionException {
        ConditionalTermContext _localctx = new ConditionalTermContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_conditionalTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(309);
                    conditionalFactor();
                }
                setState(314);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(310);
                            match(AND);
                            setState(311);
                            conditionalFactor();
                        }
                    }
                    setState(316);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConditionalFactorContext extends EnhancedParserRuleContext {
        public ConditionalFactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionalFactor;
        }

        public ConditionalFactorContext() {
        }

        public void copyFrom(ConditionalFactorContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ConditionalFactorSimpleCondExprContext extends ConditionalFactorContext {
        public SimpleCondExprContext simpleCondExpr() {
            return getRuleContext(SimpleCondExprContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public ConditionalFactorSimpleCondExprContext(ConditionalFactorContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ConditionalFactorExprContext extends ConditionalFactorContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public ConditionalFactorExprContext(ConditionalFactorContext ctx) {
            copyFrom(ctx);
        }
    }

    public final ConditionalFactorContext conditionalFactor() throws RecognitionException {
        ConditionalFactorContext _localctx = new ConditionalFactorContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_conditionalFactor);
        try {
            setState(325);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
                case 1:
                    _localctx = new ConditionalFactorSimpleCondExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(318);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
                        case 1: {
                            setState(317);
                            match(NOT);
                        }
                        break;
                    }
                    setState(320);
                    simpleCondExpr();
                }
                break;
                case 2:
                    _localctx = new ConditionalFactorExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(321);
                    match(LBRACKET);
                    setState(322);
                    conditionalExpr();
                    setState(323);
                    match(RBRACKET);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SimpleCondExprContext extends EnhancedParserRuleContext {
        public SimpleCondExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleCondExpr;
        }

        public SimpleCondExprContext() {
        }

        public void copyFrom(SimpleCondExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SimpleExistsExprContext extends SimpleCondExprContext {
        public ExistsExprContext existsExpr() {
            return getRuleContext(ExistsExprContext.class, 0);
        }

        public SimpleExistsExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleLikeExprContext extends SimpleCondExprContext {
        public LikeExprContext likeExpr() {
            return getRuleContext(LikeExprContext.class, 0);
        }

        public SimpleLikeExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleCollectionMemberExprContext extends SimpleCondExprContext {
        public CollectionMemberExprContext collectionMemberExpr() {
            return getRuleContext(CollectionMemberExprContext.class, 0);
        }

        public SimpleCollectionMemberExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleNullComparisonExprContext extends SimpleCondExprContext {
        public NullComparisonExprContext nullComparisonExpr() {
            return getRuleContext(NullComparisonExprContext.class, 0);
        }

        public SimpleNullComparisonExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleEmptyCollectionExprContext extends SimpleCondExprContext {
        public EmptyCollectionComparisonExprContext emptyCollectionComparisonExpr() {
            return getRuleContext(EmptyCollectionComparisonExprContext.class, 0);
        }

        public SimpleEmptyCollectionExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleInExprContext extends SimpleCondExprContext {
        public InExprContext inExpr() {
            return getRuleContext(InExprContext.class, 0);
        }

        public SimpleInExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleComparisonExprContext extends SimpleCondExprContext {
        public ComparisonExprContext comparisonExpr() {
            return getRuleContext(ComparisonExprContext.class, 0);
        }

        public SimpleComparisonExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class SimpleBetweenExprContext extends SimpleCondExprContext {
        public BetweenExprContext betweenExpr() {
            return getRuleContext(BetweenExprContext.class, 0);
        }

        public SimpleBetweenExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final SimpleCondExprContext simpleCondExpr() throws RecognitionException {
        SimpleCondExprContext _localctx = new SimpleCondExprContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_simpleCondExpr);
        try {
            setState(335);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    _localctx = new SimpleComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(327);
                    comparisonExpr();
                }
                break;
                case 2:
                    _localctx = new SimpleBetweenExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(328);
                    betweenExpr();
                }
                break;
                case 3:
                    _localctx = new SimpleLikeExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(329);
                    likeExpr();
                }
                break;
                case 4:
                    _localctx = new SimpleInExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(330);
                    inExpr();
                }
                break;
                case 5:
                    _localctx = new SimpleNullComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(331);
                    nullComparisonExpr();
                }
                break;
                case 6:
                    _localctx = new SimpleEmptyCollectionExprContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(332);
                    emptyCollectionComparisonExpr();
                }
                break;
                case 7:
                    _localctx = new SimpleCollectionMemberExprContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(333);
                    collectionMemberExpr();
                }
                break;
                case 8:
                    _localctx = new SimpleExistsExprContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(334);
                    existsExpr();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BetweenExprContext extends EnhancedParserRuleContext {
        public BetweenExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_betweenExpr;
        }

        public BetweenExprContext() {
        }

        public void copyFrom(BetweenExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class BetweenStringExprContext extends BetweenExprContext {
        public List<StringExprContext> stringExpr() {
            return getRuleContexts(StringExprContext.class);
        }

        public StringExprContext stringExpr(int i) {
            return getRuleContext(StringExprContext.class, i);
        }

        public TerminalNode BETWEEN() {
            return getToken(OQLParser.BETWEEN, 0);
        }

        public TerminalNode AND() {
            return getToken(OQLParser.AND, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public BetweenStringExprContext(BetweenExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class BetweenArithmeticExprContext extends BetweenExprContext {
        public List<ArithmeticExprContext> arithmeticExpr() {
            return getRuleContexts(ArithmeticExprContext.class);
        }

        public ArithmeticExprContext arithmeticExpr(int i) {
            return getRuleContext(ArithmeticExprContext.class, i);
        }

        public TerminalNode BETWEEN() {
            return getToken(OQLParser.BETWEEN, 0);
        }

        public TerminalNode AND() {
            return getToken(OQLParser.AND, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public BetweenArithmeticExprContext(BetweenExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final BetweenExprContext betweenExpr() throws RecognitionException {
        BetweenExprContext _localctx = new BetweenExprContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_betweenExpr);
        int _la;
        try {
            setState(355);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 31, _ctx)) {
                case 1:
                    _localctx = new BetweenArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(337);
                    arithmeticExpr();
                    setState(339);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(338);
                            match(NOT);
                        }
                    }

                    setState(341);
                    match(BETWEEN);
                    setState(342);
                    arithmeticExpr();
                    setState(343);
                    match(AND);
                    setState(344);
                    arithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new BetweenStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(346);
                    stringExpr();
                    setState(348);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(347);
                            match(NOT);
                        }
                    }

                    setState(350);
                    match(BETWEEN);
                    setState(351);
                    stringExpr();
                    setState(352);
                    match(AND);
                    setState(353);
                    stringExpr();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InExprContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode IN() {
            return getToken(OQLParser.IN, 0);
        }

        public InExprRightPartContext inExprRightPart() {
            return getRuleContext(InExprRightPartContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public InExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inExpr;
        }
    }

    public final InExprContext inExpr() throws RecognitionException {
        InExprContext _localctx = new InExprContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_inExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(357);
                pathExpr();
                setState(359);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(358);
                        match(NOT);
                    }
                }

                setState(361);
                match(IN);
                setState(362);
                inExprRightPart();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InExprRightPartContext extends EnhancedParserRuleContext {
        public InExprRightPartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inExprRightPart;
        }

        public InExprRightPartContext() {
        }

        public void copyFrom(InExprRightPartContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class InExprItemContext extends InExprRightPartContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<InItemContext> inItem() {
            return getRuleContexts(InItemContext.class);
        }

        public InItemContext inItem(int i) {
            return getRuleContext(InItemContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public InExprItemContext(InExprRightPartContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class InExprsubQueryContext extends InExprRightPartContext {
        public SubQueryContext subQuery() {
            return getRuleContext(SubQueryContext.class, 0);
        }

        public InExprsubQueryContext(InExprRightPartContext ctx) {
            copyFrom(ctx);
        }
    }

    public final InExprRightPartContext inExprRightPart() throws RecognitionException {
        InExprRightPartContext _localctx = new InExprRightPartContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_inExprRightPart);
        int _la;
        try {
            setState(376);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
                case 1:
                    _localctx = new InExprItemContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(364);
                    match(LBRACKET);
                    setState(365);
                    inItem();
                    setState(370);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(366);
                                match(COMMA);
                                setState(367);
                                inItem();
                            }
                        }
                        setState(372);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(373);
                    match(RBRACKET);
                }
                break;
                case 2:
                    _localctx = new InExprsubQueryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(375);
                    subQuery();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InItemContext extends EnhancedParserRuleContext {
        public LiteralContext literal() {
            return getRuleContext(LiteralContext.class, 0);
        }

        public InItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inItem;
        }
    }

    public final InItemContext inItem() throws RecognitionException {
        InItemContext _localctx = new InItemContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_inItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(378);
                literal();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LikeExprContext extends EnhancedParserRuleContext {
        public StringExprContext stringExpr() {
            return getRuleContext(StringExprContext.class, 0);
        }

        public TerminalNode LIKE() {
            return getToken(OQLParser.LIKE, 0);
        }

        public PatternValueContext patternValue() {
            return getRuleContext(PatternValueContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public LikeExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_likeExpr;
        }
    }

    public final LikeExprContext likeExpr() throws RecognitionException {
        LikeExprContext _localctx = new LikeExprContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_likeExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(380);
                stringExpr();
                setState(382);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(381);
                        match(NOT);
                    }
                }

                setState(384);
                match(LIKE);
                setState(385);
                patternValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NullComparisonExprContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode IS() {
            return getToken(OQLParser.IS, 0);
        }

        public TerminalNode NULL() {
            return getToken(OQLParser.NULL, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public NullComparisonExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nullComparisonExpr;
        }
    }

    public final NullComparisonExprContext nullComparisonExpr() throws RecognitionException {
        NullComparisonExprContext _localctx = new NullComparisonExprContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_nullComparisonExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(387);
                pathExpr();
                setState(388);
                match(IS);
                setState(390);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(389);
                        match(NOT);
                    }
                }

                setState(392);
                match(NULL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EmptyCollectionComparisonExprContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode IS() {
            return getToken(OQLParser.IS, 0);
        }

        public TerminalNode EMPTY() {
            return getToken(OQLParser.EMPTY, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public EmptyCollectionComparisonExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_emptyCollectionComparisonExpr;
        }
    }

    public final EmptyCollectionComparisonExprContext emptyCollectionComparisonExpr() throws RecognitionException {
        EmptyCollectionComparisonExprContext _localctx = new EmptyCollectionComparisonExprContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_emptyCollectionComparisonExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(394);
                pathExpr();
                setState(395);
                match(IS);
                setState(397);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(396);
                        match(NOT);
                    }
                }

                setState(399);
                match(EMPTY);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CollectionMemberExprContext extends EnhancedParserRuleContext {
        public EntityExprContext entityExpr() {
            return getRuleContext(EntityExprContext.class, 0);
        }

        public TerminalNode MEMBER() {
            return getToken(OQLParser.MEMBER, 0);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public TerminalNode OF() {
            return getToken(OQLParser.OF, 0);
        }

        public CollectionMemberExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_collectionMemberExpr;
        }
    }

    public final CollectionMemberExprContext collectionMemberExpr() throws RecognitionException {
        CollectionMemberExprContext _localctx = new CollectionMemberExprContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_collectionMemberExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(401);
                entityExpr();
                setState(403);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(402);
                        match(NOT);
                    }
                }

                setState(405);
                match(MEMBER);
                setState(407);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OF) {
                    {
                        setState(406);
                        match(OF);
                    }
                }

                setState(409);
                pathExpr();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExistsExprContext extends EnhancedParserRuleContext {
        public TerminalNode EXISTS() {
            return getToken(OQLParser.EXISTS, 0);
        }

        public SubQueryContext subQuery() {
            return getRuleContext(SubQueryContext.class, 0);
        }

        public TerminalNode NOT() {
            return getToken(OQLParser.NOT, 0);
        }

        public ExistsExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_existsExpr;
        }
    }

    public final ExistsExprContext existsExpr() throws RecognitionException {
        ExistsExprContext _localctx = new ExistsExprContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_existsExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(412);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(411);
                        match(NOT);
                    }
                }

                setState(414);
                match(EXISTS);
                setState(415);
                subQuery();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ComparisonExprContext extends EnhancedParserRuleContext {
        public ComparisonExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparisonExpr;
        }

        public ComparisonExprContext() {
        }

        public void copyFrom(ComparisonExprContext ctx) {
            super.copyFrom(ctx);
        }

        public WhereNode getWhereNode() {
            return null;
        }
    }

    public static class ComparisonEntityExprContext extends ComparisonExprContext {
        public List<EntityExprContext> entityExpr() {
            return getRuleContexts(EntityExprContext.class);
        }

        public EntityExprContext entityExpr(int i) {
            return getRuleContext(EntityExprContext.class, i);
        }

        public TerminalNode EQ() {
            return getToken(OQLParser.EQ, 0);
        }

        public TerminalNode NE() {
            return getToken(OQLParser.NE, 0);
        }

        public ComparisonEntityExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ComparisonArithmeticExprContext extends ComparisonExprContext {
        public List<ArithmeticExprContext> arithmeticExpr() {
            return getRuleContexts(ArithmeticExprContext.class);
        }

        public ArithmeticExprContext arithmeticExpr(int i) {
            return getRuleContext(ArithmeticExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public ComparisonArithmeticExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public WhereNode getWhereNode() {
            List<ArithmeticExprContext> arithmeticExprContexts = arithmeticExpr();
            ArithmeticExprContext frist = arithmeticExprContexts.get(0);
            ArithmeticExprContext second = arithmeticExprContexts.get(1);
            InnerNode innerNode = new InnerNode(Operator.getEnum(comparisonOperator().getText()));
            innerNode.setLeft(new LeafNode(frist.getContent()));
            innerNode.setRight(new LeafNode(second.getContent()));
            return innerNode;
        }


    }

    public static class ComparisonStringExprContext extends ComparisonExprContext {
        public List<StringExprContext> stringExpr() {
            return getRuleContexts(StringExprContext.class);
        }

        public StringExprContext stringExpr(int i) {
            return getRuleContext(StringExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public ComparisonStringExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public WhereNode getWhereNode() {
            List<StringExprContext> stringExprContexts = stringExpr();
            StringExprContext frist = stringExprContexts.get(0);
            StringExprContext second = stringExprContexts.get(1);
            InnerNode innerNode = new InnerNode(Operator.getEnum(comparisonOperator().getText()));
            innerNode.setLeft(new LeafNode(frist.getText()));
            innerNode.setRight(new LeafNode(second.getText()));
            return innerNode;
        }
    }

    public final ComparisonExprContext comparisonExpr() throws RecognitionException {
        ComparisonExprContext _localctx = new ComparisonExprContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_comparisonExpr);
        int _la;
        try {
            setState(429);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 41, _ctx)) {
                case 1:
                    _localctx = new ComparisonStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(417);
                    stringExpr();
                    setState(418);
                    comparisonOperator();
                    setState(419);
                    stringExpr();
                }
                break;
                case 2:
                    _localctx = new ComparisonEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(421);
                    entityExpr();
                    setState(422);
                    _la = _input.LA(1);
                    if (!(_la == EQ || _la == NE)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(423);
                    entityExpr();
                }
                break;
                case 3:
                    _localctx = new ComparisonArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(425);
                    arithmeticExpr();
                    setState(426);
                    comparisonOperator();
                    setState(427);
                    arithmeticExpr();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ComparisonOperatorContext extends EnhancedParserRuleContext {
        public TerminalNode EQ() {
            return getToken(OQLParser.EQ, 0);
        }

        public TerminalNode GR() {
            return getToken(OQLParser.GR, 0);
        }

        public TerminalNode GE() {
            return getToken(OQLParser.GE, 0);
        }

        public TerminalNode LS() {
            return getToken(OQLParser.LS, 0);
        }

        public TerminalNode LE() {
            return getToken(OQLParser.LE, 0);
        }

        public TerminalNode NE() {
            return getToken(OQLParser.NE, 0);
        }

        public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparisonOperator;
        }
    }

    public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
        ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_comparisonOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(431);
                _la = _input.LA(1);
                if (!(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (EQ - 65)) | (1L << (GR - 65)) | (1L << (LS - 65)) | (1L << (GE - 65)) | (1L << (LE - 65)) | (1L << (NE - 65)))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArithmeticExprContext extends EnhancedParserRuleContext {
        public ArithmeticExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticExpr;
        }

        public ArithmeticExprContext() {
        }

        public void copyFrom(ArithmeticExprContext ctx) {
            super.copyFrom(ctx);
        }

        public Comparable getContent() {
            return null;
        }
    }

    public static class ArithmeticPathExprContext extends ArithmeticExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public ArithmeticPathExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Comparable getContent() {
            return getText();
        }
    }

    public static class ArithmeticSimpleArithmeticExprContext extends ArithmeticExprContext {
        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        public ArithmeticSimpleArithmeticExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Comparable getContent() {
            String text = getText();
            if (text.contains(".")) {
                return Float.parseFloat(text);
            }
            return Integer.parseInt(text);
        }
    }

    public final ArithmeticExprContext arithmeticExpr() throws RecognitionException {
        ArithmeticExprContext _localctx = new ArithmeticExprContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_arithmeticExpr);
        try {
            setState(435);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ArithmeticPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(433);
                    pathExpr();
                }
                break;
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                case PLUS:
                case MINUS:
                case LBRACKET:
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new ArithmeticSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(434);
                    simpleArithmeticExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SimpleArithmeticExprContext extends EnhancedParserRuleContext {
        public List<ArithmeticTermContext> arithmeticTerm() {
            return getRuleContexts(ArithmeticTermContext.class);
        }

        public ArithmeticTermContext arithmeticTerm(int i) {
            return getRuleContext(ArithmeticTermContext.class, i);
        }

        public List<TerminalNode> PLUS() {
            return getTokens(OQLParser.PLUS);
        }

        public TerminalNode PLUS(int i) {
            return getToken(OQLParser.PLUS, i);
        }

        public List<TerminalNode> MINUS() {
            return getTokens(OQLParser.MINUS);
        }

        public TerminalNode MINUS(int i) {
            return getToken(OQLParser.MINUS, i);
        }

        public SimpleArithmeticExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleArithmeticExpr;
        }
    }

    public final SimpleArithmeticExprContext simpleArithmeticExpr() throws RecognitionException {
        SimpleArithmeticExprContext _localctx = new SimpleArithmeticExprContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_simpleArithmeticExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(437);
                    arithmeticTerm();
                }
                setState(442);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PLUS || _la == MINUS) {
                    {
                        {
                            setState(438);
                            _la = _input.LA(1);
                            if (!(_la == PLUS || _la == MINUS)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(439);
                            arithmeticTerm();
                        }
                    }
                    setState(444);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArithmeticTermContext extends EnhancedParserRuleContext {
        public List<ArithmeticFactorContext> arithmeticFactor() {
            return getRuleContexts(ArithmeticFactorContext.class);
        }

        public ArithmeticFactorContext arithmeticFactor(int i) {
            return getRuleContext(ArithmeticFactorContext.class, i);
        }

        public List<TerminalNode> MUL() {
            return getTokens(OQLParser.MUL);
        }

        public TerminalNode MUL(int i) {
            return getToken(OQLParser.MUL, i);
        }

        public List<TerminalNode> DIV() {
            return getTokens(OQLParser.DIV);
        }

        public TerminalNode DIV(int i) {
            return getToken(OQLParser.DIV, i);
        }

        public ArithmeticTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticTerm;
        }
    }

    public final ArithmeticTermContext arithmeticTerm() throws RecognitionException {
        ArithmeticTermContext _localctx = new ArithmeticTermContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_arithmeticTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(445);
                    arithmeticFactor();
                }
                setState(450);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == MUL || _la == DIV) {
                    {
                        {
                            setState(446);
                            _la = _input.LA(1);
                            if (!(_la == MUL || _la == DIV)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(447);
                            arithmeticFactor();
                        }
                    }
                    setState(452);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArithmeticFactorContext extends EnhancedParserRuleContext {
        public ArithmeticPrimaryContext arithmeticPrimary() {
            return getRuleContext(ArithmeticPrimaryContext.class, 0);
        }

        public TerminalNode PLUS() {
            return getToken(OQLParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(OQLParser.MINUS, 0);
        }

        public ArithmeticFactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticFactor;
        }
    }

    public final ArithmeticFactorContext arithmeticFactor() throws RecognitionException {
        ArithmeticFactorContext _localctx = new ArithmeticFactorContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_arithmeticFactor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(454);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PLUS || _la == MINUS) {
                    {
                        setState(453);
                        _la = _input.LA(1);
                        if (!(_la == PLUS || _la == MINUS)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(456);
                arithmeticPrimary();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArithmeticPrimaryContext extends EnhancedParserRuleContext {
        public ArithmeticPrimaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticPrimary;
        }

        public ArithmeticPrimaryContext() {
        }

        public void copyFrom(ArithmeticPrimaryContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class AriPriSimpleArithmeticExprContext extends ArithmeticPrimaryContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public AriPriSimpleArithmeticExprContext(ArithmeticPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class AriPriNumericLiteralContext extends ArithmeticPrimaryContext {
        public NumericLiteralContext numericLiteral() {
            return getRuleContext(NumericLiteralContext.class, 0);
        }

        public AriPriNumericLiteralContext(ArithmeticPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class AriPriAggregateExprContext extends ArithmeticPrimaryContext {
        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public AriPriAggregateExprContext(ArithmeticPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public final ArithmeticPrimaryContext arithmeticPrimary() throws RecognitionException {
        ArithmeticPrimaryContext _localctx = new ArithmeticPrimaryContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_arithmeticPrimary);
        try {
            setState(464);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new AriPriNumericLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(458);
                    numericLiteral();
                }
                break;
                case LBRACKET:
                    _localctx = new AriPriSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(459);
                    match(LBRACKET);
                    setState(460);
                    simpleArithmeticExpr();
                    setState(461);
                    match(RBRACKET);
                }
                break;
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                    _localctx = new AriPriAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(463);
                    aggregateExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringExprContext extends EnhancedParserRuleContext {
        public StringExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringExpr;
        }

        public StringExprContext() {
        }

        public void copyFrom(StringExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StringPriContext extends StringExprContext {
        public StringPrimaryContext stringPrimary() {
            return getRuleContext(StringPrimaryContext.class, 0);
        }

        public StringPriContext(StringExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StringSubQueryContext extends StringExprContext {
        public SubQueryContext subQuery() {
            return getRuleContext(SubQueryContext.class, 0);
        }

        public StringSubQueryContext(StringExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final StringExprContext stringExpr() throws RecognitionException {
        StringExprContext _localctx = new StringExprContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_stringExpr);
        try {
            setState(468);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                case STRINGLITERAL:
                case WORD:
                    _localctx = new StringPriContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(466);
                    stringPrimary();
                }
                break;
                case LBRACKET:
                    _localctx = new StringSubQueryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(467);
                    subQuery();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringPrimaryContext extends EnhancedParserRuleContext {
        public StringPrimaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringPrimary;
        }

        public StringPrimaryContext() {
        }

        public void copyFrom(StringPrimaryContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StringPathExprContext extends StringPrimaryContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public StringPathExprContext(StringPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StringLiteralContext extends StringPrimaryContext {
        public StringLiteralExprContext stringLiteralExpr() {
            return getRuleContext(StringLiteralExprContext.class, 0);
        }

        public StringLiteralContext(StringPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class StringAggregateExprContext extends StringPrimaryContext {
        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public StringAggregateExprContext(StringPrimaryContext ctx) {
            copyFrom(ctx);
        }
    }

    public final StringPrimaryContext stringPrimary() throws RecognitionException {
        StringPrimaryContext _localctx = new StringPrimaryContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_stringPrimary);
        try {
            setState(473);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new StringPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(470);
                    pathExpr();
                }
                break;
                case STRINGLITERAL:
                    _localctx = new StringLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(471);
                    stringLiteralExpr();
                }
                break;
                case AVG:
                case SUM:
                case MAX:
                case MIN:
                case COUNT:
                    _localctx = new StringAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(472);
                    aggregateExpr();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringLiteralExprContext extends EnhancedParserRuleContext {
        public TerminalNode STRINGLITERAL() {
            return getToken(OQLParser.STRINGLITERAL, 0);
        }

        public StringLiteralExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringLiteralExpr;
        }
    }

    public final StringLiteralExprContext stringLiteralExpr() throws RecognitionException {
        StringLiteralExprContext _localctx = new StringLiteralExprContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_stringLiteralExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(475);
                match(STRINGLITERAL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EntityExprContext extends EnhancedParserRuleContext {
        public EntityExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_entityExpr;
        }

        public EntityExprContext() {
        }

        public void copyFrom(EntityExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class EntitySimpleEntityExprContext extends EntityExprContext {
        public SimpleEntityExprContext simpleEntityExpr() {
            return getRuleContext(SimpleEntityExprContext.class, 0);
        }

        public EntitySimpleEntityExprContext(EntityExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class EntityPathExprContext extends EntityExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public EntityPathExprContext(EntityExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final EntityExprContext entityExpr() throws RecognitionException {
        EntityExprContext _localctx = new EntityExprContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_entityExpr);
        try {
            setState(479);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 49, _ctx)) {
                case 1:
                    _localctx = new EntityPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(477);
                    pathExpr();
                }
                break;
                case 2:
                    _localctx = new EntitySimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(478);
                    simpleEntityExpr();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SimpleEntityExprContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public SimpleEntityExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleEntityExpr;
        }
    }

    public final SimpleEntityExprContext simpleEntityExpr() throws RecognitionException {
        SimpleEntityExprContext _localctx = new SimpleEntityExprContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_simpleEntityExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(481);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SchemaNameContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public SchemaNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_schemaName;
        }
    }

    public final SchemaNameContext schemaName() throws RecognitionException {
        SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_schemaName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(483);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PatternValueContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public PatternValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_patternValue;
        }
    }

    public final PatternValueContext patternValue() throws RecognitionException {
        PatternValueContext _localctx = new PatternValueContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_patternValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(485);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NumericLiteralContext extends EnhancedParserRuleContext {
        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        public TerminalNode FLOATNUMERAL() {
            return getToken(OQLParser.FLOATNUMERAL, 0);
        }

        public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_numericLiteral;
        }
    }

    public final NumericLiteralContext numericLiteral() throws RecognitionException {
        NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_numericLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(487);
                _la = _input.LA(1);
                if (!(_la == INTNUMERAL || _la == FLOATNUMERAL)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LiteralContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public LiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literal;
        }
    }

    public final LiteralContext literal() throws RecognitionException {
        LiteralContext _localctx = new LiteralContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(489);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConstructorNameContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public ConstructorNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constructorName;
        }
    }

    public final ConstructorNameContext constructorName() throws RecognitionException {
        ConstructorNameContext _localctx = new ConstructorNameContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_constructorName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(491);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public FieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_field;
        }
    }

    public final FieldContext field() throws RecognitionException {
        FieldContext _localctx = new FieldContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_field);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(493);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IdContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public IdContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_id;
        }
    }

    public final IdContext id() throws RecognitionException {
        IdContext _localctx = new IdContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_id);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(495);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CreateStatContext extends EnhancedParserRuleContext {
        public TerminalNode CREATE() {
            return getToken(OQLParser.CREATE, 0);
        }

        public TerminalNode TABLE() {
            return getToken(OQLParser.TABLE, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public ColumnDefinitionContext columnDefinition() {
            return getRuleContext(ColumnDefinitionContext.class, 0);
        }

        public ExtendsTableContext extendsTable() {
            return getRuleContext(ExtendsTableContext.class, 0);
        }

        public TableConstraintContext tableConstraint() {
            return getRuleContext(TableConstraintContext.class, 0);
        }

        public CreateStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createStat;
        }
    }

    public final CreateStatContext createStat() throws RecognitionException {
        CreateStatContext _localctx = new CreateStatContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_createStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(497);
                match(CREATE);
                setState(498);
                match(TABLE);
                setState(499);
                tableName();
                setState(501);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(500);
                        columnDefinition();
                    }
                }

                setState(504);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EXTENDS) {
                    {
                        setState(503);
                        extendsTable();
                    }
                }

                setState(507);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PRIMARY) {
                    {
                        setState(506);
                        tableConstraint();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TableNameContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public TableNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tableName;
        }
    }

    public final TableNameContext tableName() throws RecognitionException {
        TableNameContext _localctx = new TableNameContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(509);
                match(WORD);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ColumnDefinitionContext extends EnhancedParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<ColumnDefinitionItemContext> columnDefinitionItem() {
            return getRuleContexts(ColumnDefinitionItemContext.class);
        }

        public ColumnDefinitionItemContext columnDefinitionItem(int i) {
            return getRuleContext(ColumnDefinitionItemContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnDefinition;
        }
    }

    public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
        ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_columnDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(511);
                match(LBRACKET);
                setState(512);
                columnDefinitionItem();
                setState(517);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(513);
                            match(COMMA);
                            setState(514);
                            columnDefinitionItem();
                        }
                    }
                    setState(519);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(520);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ColumnDefinitionItemContext extends EnhancedParserRuleContext {
        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public ColumnTypeContext columnType() {
            return getRuleContext(ColumnTypeContext.class, 0);
        }

        public List<ColumnConstraintContext> columnConstraint() {
            return getRuleContexts(ColumnConstraintContext.class);
        }

        public ColumnConstraintContext columnConstraint(int i) {
            return getRuleContext(ColumnConstraintContext.class, i);
        }

        public ColumnDefinitionItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnDefinitionItem;
        }
    }

    public final ColumnDefinitionItemContext columnDefinitionItem() throws RecognitionException {
        ColumnDefinitionItemContext _localctx = new ColumnDefinitionItemContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_columnDefinitionItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(522);
                match(WORD);
                setState(523);
                columnType();
                setState(527);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIMARY) | (1L << AUTO_INCREMENT) | (1L << UNIQUE))) != 0)) {
                    {
                        {
                            setState(524);
                            columnConstraint();
                        }
                    }
                    setState(529);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ColumnTypeContext extends EnhancedParserRuleContext {
        public TerminalNode INT() {
            return getToken(OQLParser.INT, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(OQLParser.FLOAT, 0);
        }

        public TerminalNode CHAR() {
            return getToken(OQLParser.CHAR, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public TerminalNode SETOF() {
            return getToken(OQLParser.SETOF, 0);
        }

        public ColumnTypeContext columnType() {
            return getRuleContext(ColumnTypeContext.class, 0);
        }

        public TerminalNode REF() {
            return getToken(OQLParser.REF, 0);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public ColumnTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnType;
        }
    }

    public final ColumnTypeContext columnType() throws RecognitionException {
        ColumnTypeContext _localctx = new ColumnTypeContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_columnType);
        try {
            setState(545);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(530);
                    match(INT);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(531);
                    match(FLOAT);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(532);
                    match(CHAR);
                    setState(533);
                    match(LBRACKET);
                    setState(534);
                    match(INTNUMERAL);
                    setState(535);
                    match(RBRACKET);
                }
                break;
                case SETOF:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(536);
                    match(SETOF);
                    setState(537);
                    match(LBRACKET);
                    setState(538);
                    columnType();
                    setState(539);
                    match(RBRACKET);
                }
                break;
                case REF:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(541);
                    match(REF);
                    setState(542);
                    match(LBRACKET);
                    setState(543);
                    match(WORD);
                    setState(544);
                    match(RBRACKET);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ColumnConstraintContext extends EnhancedParserRuleContext {
        public TerminalNode AUTO_INCREMENT() {
            return getToken(OQLParser.AUTO_INCREMENT, 0);
        }

        public TerminalNode PRIMARY() {
            return getToken(OQLParser.PRIMARY, 0);
        }

        public TerminalNode KEY() {
            return getToken(OQLParser.KEY, 0);
        }

        public TerminalNode UNIQUE() {
            return getToken(OQLParser.UNIQUE, 0);
        }

        public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnConstraint;
        }
    }

    public final ColumnConstraintContext columnConstraint() throws RecognitionException {
        ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_columnConstraint);
        try {
            setState(552);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(547);
                    match(AUTO_INCREMENT);
                }
                break;
                case PRIMARY:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(548);
                    match(PRIMARY);
                    setState(549);
                    match(KEY);
                }
                break;
                case UNIQUE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(550);
                    match(UNIQUE);
                    setState(551);
                    match(KEY);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExtendsTableContext extends EnhancedParserRuleContext {
        public TerminalNode EXTENDS() {
            return getToken(OQLParser.EXTENDS, 0);
        }

        public List<TerminalNode> WORD() {
            return getTokens(OQLParser.WORD);
        }

        public TerminalNode WORD(int i) {
            return getToken(OQLParser.WORD, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public ExtendsTableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_extendsTable;
        }
    }

    public final ExtendsTableContext extendsTable() throws RecognitionException {
        ExtendsTableContext _localctx = new ExtendsTableContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_extendsTable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(554);
                match(EXTENDS);
                setState(555);
                match(WORD);
                setState(560);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(556);
                            match(COMMA);
                            setState(557);
                            match(WORD);
                        }
                    }
                    setState(562);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TableConstraintContext extends EnhancedParserRuleContext {
        public TerminalNode PRIMARY() {
            return getToken(OQLParser.PRIMARY, 0);
        }

        public TerminalNode KEY() {
            return getToken(OQLParser.KEY, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<PathExprContext> pathExpr() {
            return getRuleContexts(PathExprContext.class);
        }

        public PathExprContext pathExpr(int i) {
            return getRuleContext(PathExprContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public TableConstraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tableConstraint;
        }
    }

    public final TableConstraintContext tableConstraint() throws RecognitionException {
        TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_tableConstraint);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(563);
                match(PRIMARY);
                setState(564);
                match(KEY);
                setState(565);
                match(LBRACKET);
                setState(566);
                pathExpr();
                setState(571);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(567);
                            match(COMMA);
                            setState(568);
                            pathExpr();
                        }
                    }
                    setState(573);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(574);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateStatContext extends EnhancedParserRuleContext {
        public UpdateClauseContext updateClause() {
            return getRuleContext(UpdateClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public UpdateStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateStat;
        }
    }

    public final UpdateStatContext updateStat() throws RecognitionException {
        UpdateStatContext _localctx = new UpdateStatContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_updateStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(576);
                updateClause();
                setState(578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(577);
                        whereClause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateClauseContext extends EnhancedParserRuleContext {
        public TerminalNode UPDATE() {
            return getToken(OQLParser.UPDATE, 0);
        }

        public SchemaNameContext schemaName() {
            return getRuleContext(SchemaNameContext.class, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public TerminalNode SET() {
            return getToken(OQLParser.SET, 0);
        }

        public List<UpdateItemContext> updateItem() {
            return getRuleContexts(UpdateItemContext.class);
        }

        public UpdateItemContext updateItem(int i) {
            return getRuleContext(UpdateItemContext.class, i);
        }

        public TerminalNode AS() {
            return getToken(OQLParser.AS, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public UpdateClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateClause;
        }
    }

    public final UpdateClauseContext updateClause() throws RecognitionException {
        UpdateClauseContext _localctx = new UpdateClauseContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_updateClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(580);
                match(UPDATE);
                setState(581);
                schemaName();
                setState(583);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(582);
                        match(AS);
                    }
                }

                setState(585);
                id();
                setState(586);
                match(SET);
                setState(587);
                updateItem();
                setState(592);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(588);
                            match(COMMA);
                            setState(589);
                            updateItem();
                        }
                    }
                    setState(594);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(596);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 62, _ctx)) {
                    case 1: {
                        setState(595);
                        whereClause();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UpdateItemContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode EQ() {
            return getToken(OQLParser.EQ, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        public UpdateItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateItem;
        }
    }

    public final UpdateItemContext updateItem() throws RecognitionException {
        UpdateItemContext _localctx = new UpdateItemContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_updateItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(598);
                pathExpr();
                setState(599);
                match(EQ);
                setState(600);
                newValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NewValueContext extends EnhancedParserRuleContext {
        public NewValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_newValue;
        }

        public NewValueContext() {
        }

        public void copyFrom(NewValueContext ctx) {
            super.copyFrom(ctx);
        }

        public Object getValue() {
            return null;
        }
    }

    public static class NewSimpleEntityExprContext extends NewValueContext {
        public InsertEntityExprContext insertEntityExpr() {
            return getRuleContext(InsertEntityExprContext.class, 0);
        }

        public NewSimpleEntityExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            Tuple tuple = new Tuple();
            List<InsertEntityItemContext> insertEntityItemList = getChild(InsertEntityExprContext.class).getChildren(InsertEntityItemContext.class);
            for (InsertEntityItemContext insertEntityItem : insertEntityItemList) {
                String name = insertEntityItem.getChild(PathExprContext.class).getText();
                NewValueContext newValueContext = insertEntityItem.getChild(NewValueContext.class);
                Object value = newValueContext.getValue();
                tuple.add(name, value);
            }
            return tuple;
        }
    }

    public static class NewSimpleArithmeticExprContext extends NewValueContext {
        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        public NewSimpleArithmeticExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            String text = getText();
            if (text.contains(".")) {
                return Float.parseFloat(text);
            }
            return Integer.parseInt(text);
        }
    }

    public static class NewNullContext extends NewValueContext {
        public TerminalNode NULL() {
            return getToken(OQLParser.NULL, 0);
        }

        public NewNullContext(NewValueContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class NewStringPrimaryContext extends NewValueContext {
        public StringPrimaryContext stringPrimary() {
            return getRuleContext(StringPrimaryContext.class, 0);
        }

        public NewStringPrimaryContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            return getText().replaceAll("'", "");
        }
    }

    public final NewValueContext newValue() throws RecognitionException {
        NewValueContext _localctx = new NewValueContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_newValue);
        try {
            setState(606);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 63, _ctx)) {
                case 1:
                    _localctx = new NewSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(602);
                    simpleArithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new NewStringPrimaryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(603);
                    stringPrimary();
                }
                break;
                case 3:
                    _localctx = new NewSimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(604);
                    insertEntityExpr();
                }
                break;
                case 4:
                    _localctx = new NewNullContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(605);
                    match(NULL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertEntityExprContext extends EnhancedParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<InsertEntityItemContext> insertEntityItem() {
            return getRuleContexts(InsertEntityItemContext.class);
        }

        public InsertEntityItemContext insertEntityItem(int i) {
            return getRuleContext(InsertEntityItemContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public InsertEntityExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertEntityExpr;
        }
    }

    public final InsertEntityExprContext insertEntityExpr() throws RecognitionException {
        InsertEntityExprContext _localctx = new InsertEntityExprContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_insertEntityExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(608);
                match(LBRACKET);
                setState(609);
                insertEntityItem();
                setState(614);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(610);
                            match(COMMA);
                            setState(611);
                            insertEntityItem();
                        }
                    }
                    setState(616);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(617);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertEntityItemContext extends EnhancedParserRuleContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(OQLParser.COLON, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        public InsertEntityItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertEntityItem;
        }
    }

    public final InsertEntityItemContext insertEntityItem() throws RecognitionException {
        InsertEntityItemContext _localctx = new InsertEntityItemContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_insertEntityItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(619);
                pathExpr();
                setState(620);
                match(COLON);
                setState(621);
                newValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeleteStatContext extends EnhancedParserRuleContext {
        public DeleteClauseContext deleteClause() {
            return getRuleContext(DeleteClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public DeleteStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deleteStat;
        }
    }

    public final DeleteStatContext deleteStat() throws RecognitionException {
        DeleteStatContext _localctx = new DeleteStatContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_deleteStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(623);
                deleteClause();
                setState(625);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(624);
                        whereClause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DeleteClauseContext extends EnhancedParserRuleContext {
        public TerminalNode DELETE() {
            return getToken(OQLParser.DELETE, 0);
        }

        public TerminalNode FROM() {
            return getToken(OQLParser.FROM, 0);
        }

        public SchemaNameContext schemaName() {
            return getRuleContext(SchemaNameContext.class, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(OQLParser.AS, 0);
        }

        public DeleteClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deleteClause;
        }
    }

    public final DeleteClauseContext deleteClause() throws RecognitionException {
        DeleteClauseContext _localctx = new DeleteClauseContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_deleteClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(627);
                match(DELETE);
                setState(628);
                match(FROM);
                setState(629);
                schemaName();
                setState(631);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(630);
                        match(AS);
                    }
                }

                setState(633);
                id();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertStatContext extends EnhancedParserRuleContext {
        public TerminalNode INSERT() {
            return getToken(OQLParser.INSERT, 0);
        }

        public TerminalNode INTO() {
            return getToken(OQLParser.INTO, 0);
        }

        public TableNameContext tableName() {
            return getRuleContext(TableNameContext.class, 0);
        }

        public TerminalNode VALUES() {
            return getToken(OQLParser.VALUES, 0);
        }

        public InsertValueContext insertValue() {
            return getRuleContext(InsertValueContext.class, 0);
        }

        public ColumnListContext columnList() {
            return getRuleContext(ColumnListContext.class, 0);
        }

        public InsertStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertStat;
        }
    }

    public final InsertStatContext insertStat() throws RecognitionException {
        InsertStatContext _localctx = new InsertStatContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_insertStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(635);
                match(INSERT);
                setState(636);
                match(INTO);
                setState(637);
                tableName();
                setState(639);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(638);
                        columnList();
                    }
                }

                setState(641);
                match(VALUES);
                setState(642);
                insertValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ColumnListContext extends EnhancedParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<PathExprContext> pathExpr() {
            return getRuleContexts(PathExprContext.class);
        }

        public PathExprContext pathExpr(int i) {
            return getRuleContext(PathExprContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public ColumnListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnList;
        }
    }

    public final ColumnListContext columnList() throws RecognitionException {
        ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_columnList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(644);
                match(LBRACKET);
                setState(645);
                pathExpr();
                setState(650);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(646);
                            match(COMMA);
                            setState(647);
                            pathExpr();
                        }
                    }
                    setState(652);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(653);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InsertValueContext extends EnhancedParserRuleContext {
        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public List<NewValueContext> newValue() {
            return getRuleContexts(NewValueContext.class);
        }

        public NewValueContext newValue(int i) {
            return getRuleContext(NewValueContext.class, i);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public InsertValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertValue;
        }
    }

    public final InsertValueContext insertValue() throws RecognitionException {
        InsertValueContext _localctx = new InsertValueContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_insertValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(655);
                match(LBRACKET);
                setState(656);
                newValue();
                setState(661);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(657);
                            match(COMMA);
                            setState(658);
                            newValue();
                        }
                    }
                    setState(663);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(664);
                match(RBRACKET);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DropStatContext extends EnhancedParserRuleContext {
        public TerminalNode DROP() {
            return getToken(OQLParser.DROP, 0);
        }

        public TerminalNode TABLE() {
            return getToken(OQLParser.TABLE, 0);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public TerminalNode CASCADE() {
            return getToken(OQLParser.CASCADE, 0);
        }

        public DropStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropStat;
        }
    }

    public final DropStatContext dropStat() throws RecognitionException {
        DropStatContext _localctx = new DropStatContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_dropStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(666);
                match(DROP);
                setState(667);
                match(TABLE);
                setState(668);
                match(WORD);
                setState(670);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CASCADE) {
                    {
                        setState(669);
                        match(CASCADE);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3X\u02a3\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I" +
                    "\tI\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0099\n\2\3\3\3\3\3\3\3\3\5\3\u009f\n" +
                    "\3\3\3\5\3\u00a2\n\3\3\3\5\3\u00a5\n\3\3\3\5\3\u00a8\n\3\3\3\5\3\u00ab" +
                    "\n\3\3\4\5\4\u00ae\n\4\3\4\3\4\3\4\7\4\u00b3\n\4\f\4\16\4\u00b6\13\4\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c0\n\5\3\6\3\6\3\6\3\6\7\6\u00c6" +
                    "\n\6\f\6\16\6\u00c9\13\6\3\7\3\7\5\7\u00cd\n\7\3\7\3\7\5\7\u00d1\n\7\3" +
                    "\b\3\b\3\b\3\b\5\b\u00d7\n\b\3\t\3\t\5\t\u00db\n\t\3\t\5\t\u00de\n\t\3" +
                    "\t\3\t\3\n\3\n\3\n\7\n\u00e5\n\n\f\n\16\n\u00e8\13\n\3\13\3\13\3\13\3" +
                    "\13\5\13\u00ee\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f6\n\f\f\f\16\f\u00f9" +
                    "\13\f\3\f\3\f\3\r\3\r\5\r\u00ff\n\r\3\16\3\16\3\16\5\16\u0104\n\16\3\16" +
                    "\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u0113" +
                    "\n\21\f\21\16\21\u0116\13\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\7" +
                    "\23\u0120\n\23\f\23\16\23\u0123\13\23\3\24\3\24\5\24\u0127\n\24\3\24\5" +
                    "\24\u012a\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u0133\n\26\f\26" +
                    "\16\26\u0136\13\26\3\27\3\27\3\27\7\27\u013b\n\27\f\27\16\27\u013e\13" +
                    "\27\3\30\5\30\u0141\n\30\3\30\3\30\3\30\3\30\3\30\5\30\u0148\n\30\3\31" +
                    "\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0152\n\31\3\32\3\32\5\32\u0156" +
                    "\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u015f\n\32\3\32\3\32\3\32" +
                    "\3\32\3\32\5\32\u0166\n\32\3\33\3\33\5\33\u016a\n\33\3\33\3\33\3\33\3" +
                    "\34\3\34\3\34\3\34\7\34\u0173\n\34\f\34\16\34\u0176\13\34\3\34\3\34\3" +
                    "\34\5\34\u017b\n\34\3\35\3\35\3\36\3\36\5\36\u0181\n\36\3\36\3\36\3\36" +
                    "\3\37\3\37\3\37\5\37\u0189\n\37\3\37\3\37\3 \3 \3 \5 \u0190\n \3 \3 \3" +
                    "!\3!\5!\u0196\n!\3!\3!\5!\u019a\n!\3!\3!\3\"\5\"\u019f\n\"\3\"\3\"\3\"" +
                    "\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01b0\n#\3$\3$\3%\3%\5%\u01b6" +
                    "\n%\3&\3&\3&\7&\u01bb\n&\f&\16&\u01be\13&\3\'\3\'\3\'\7\'\u01c3\n\'\f" +
                    "\'\16\'\u01c6\13\'\3(\5(\u01c9\n(\3(\3(\3)\3)\3)\3)\3)\3)\5)\u01d3\n)" +
                    "\3*\3*\5*\u01d7\n*\3+\3+\3+\5+\u01dc\n+\3,\3,\3-\3-\5-\u01e2\n-\3.\3." +
                    "\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66" +
                    "\3\66\3\66\3\66\5\66\u01f8\n\66\3\66\5\66\u01fb\n\66\3\66\5\66\u01fe\n" +
                    "\66\3\67\3\67\38\38\38\38\78\u0206\n8\f8\168\u0209\138\38\38\39\39\39" +
                    "\79\u0210\n9\f9\169\u0213\139\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3:\3" +
                    ":\3:\5:\u0224\n:\3;\3;\3;\3;\3;\5;\u022b\n;\3<\3<\3<\3<\7<\u0231\n<\f" +
                    "<\16<\u0234\13<\3=\3=\3=\3=\3=\3=\7=\u023c\n=\f=\16=\u023f\13=\3=\3=\3" +
                    ">\3>\5>\u0245\n>\3?\3?\3?\5?\u024a\n?\3?\3?\3?\3?\3?\7?\u0251\n?\f?\16" +
                    "?\u0254\13?\3?\5?\u0257\n?\3@\3@\3@\3@\3A\3A\3A\3A\5A\u0261\nA\3B\3B\3" +
                    "B\3B\7B\u0267\nB\fB\16B\u026a\13B\3B\3B\3C\3C\3C\3C\3D\3D\5D\u0274\nD" +
                    "\3E\3E\3E\3E\5E\u027a\nE\3E\3E\3F\3F\3F\3F\5F\u0282\nF\3F\3F\3F\3G\3G" +
                    "\3G\3G\7G\u028b\nG\fG\16G\u028e\13G\3G\3G\3H\3H\3H\3H\7H\u0296\nH\fH\16" +
                    "H\u0299\13H\3H\3H\3I\3I\3I\3I\5I\u02a1\nI\3I\2\2J\2\4\6\b\n\f\16\20\22" +
                    "\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp" +
                    "rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\2\t\3\2" +
                    "\n\13\3\2\22\26\4\2CCHH\3\2CH\3\2AB\3\2?@\3\2WX\2\u02b7\2\u0098\3\2\2" +
                    "\2\4\u009a\3\2\2\2\6\u00ad\3\2\2\2\b\u00bf\3\2\2\2\n\u00c1\3\2\2\2\f\u00ca" +
                    "\3\2\2\2\16\u00d2\3\2\2\2\20\u00dd\3\2\2\2\22\u00e1\3\2\2\2\24\u00e9\3" +
                    "\2\2\2\26\u00ef\3\2\2\2\30\u00fe\3\2\2\2\32\u0100\3\2\2\2\34\u0108\3\2" +
                    "\2\2\36\u010a\3\2\2\2 \u010d\3\2\2\2\"\u0117\3\2\2\2$\u011a\3\2\2\2&\u0129" +
                    "\3\2\2\2(\u012b\3\2\2\2*\u012f\3\2\2\2,\u0137\3\2\2\2.\u0147\3\2\2\2\60" +
                    "\u0151\3\2\2\2\62\u0165\3\2\2\2\64\u0167\3\2\2\2\66\u017a\3\2\2\28\u017c" +
                    "\3\2\2\2:\u017e\3\2\2\2<\u0185\3\2\2\2>\u018c\3\2\2\2@\u0193\3\2\2\2B" +
                    "\u019e\3\2\2\2D\u01af\3\2\2\2F\u01b1\3\2\2\2H\u01b5\3\2\2\2J\u01b7\3\2" +
                    "\2\2L\u01bf\3\2\2\2N\u01c8\3\2\2\2P\u01d2\3\2\2\2R\u01d6\3\2\2\2T\u01db" +
                    "\3\2\2\2V\u01dd\3\2\2\2X\u01e1\3\2\2\2Z\u01e3\3\2\2\2\\\u01e5\3\2\2\2" +
                    "^\u01e7\3\2\2\2`\u01e9\3\2\2\2b\u01eb\3\2\2\2d\u01ed\3\2\2\2f\u01ef\3" +
                    "\2\2\2h\u01f1\3\2\2\2j\u01f3\3\2\2\2l\u01ff\3\2\2\2n\u0201\3\2\2\2p\u020c" +
                    "\3\2\2\2r\u0223\3\2\2\2t\u022a\3\2\2\2v\u022c\3\2\2\2x\u0235\3\2\2\2z" +
                    "\u0242\3\2\2\2|\u0246\3\2\2\2~\u0258\3\2\2\2\u0080\u0260\3\2\2\2\u0082" +
                    "\u0262\3\2\2\2\u0084\u026d\3\2\2\2\u0086\u0271\3\2\2\2\u0088\u0275\3\2" +
                    "\2\2\u008a\u027d\3\2\2\2\u008c\u0286\3\2\2\2\u008e\u0291\3\2\2\2\u0090" +
                    "\u029c\3\2\2\2\u0092\u0099\5\4\3\2\u0093\u0099\5j\66\2\u0094\u0099\5\u008a" +
                    "F\2\u0095\u0099\5z>\2\u0096\u0099\5\u0086D\2\u0097\u0099\5\u0090I\2\u0098" +
                    "\u0092\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2" +
                    "\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\3\3\2\2\2\u009a\u009b" +
                    "\7\3\2\2\u009b\u009c\5\6\4\2\u009c\u009e\5\n\6\2\u009d\u009f\5\36\20\2" +
                    "\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2" +
                    "\5 \21\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3" +
                    "\u00a5\5\"\22\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3" +
                    "\2\2\2\u00a6\u00a8\5$\23\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8" +
                    "\u00aa\3\2\2\2\u00a9\u00ab\5\24\13\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3" +
                    "\2\2\2\u00ab\5\3\2\2\2\u00ac\u00ae\7\17\2\2\u00ad\u00ac\3\2\2\2\u00ad" +
                    "\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b4\5\b\5\2\u00b0\u00b1\7L" +
                    "\2\2\u00b1\u00b3\5\b\5\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4" +
                    "\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\7\3\2\2\2\u00b6\u00b4\3\2\2\2" +
                    "\u00b7\u00c0\5\22\n\2\u00b8\u00c0\5\32\16\2\u00b9\u00ba\7\20\2\2\u00ba" +
                    "\u00bb\7J\2\2\u00bb\u00bc\5h\65\2\u00bc\u00bd\7K\2\2\u00bd\u00c0\3\2\2" +
                    "\2\u00be\u00c0\5\26\f\2\u00bf\u00b7\3\2\2\2\u00bf\u00b8\3\2\2\2\u00bf" +
                    "\u00b9\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\t\3\2\2\2\u00c1\u00c2\7\b\2\2" +
                    "\u00c2\u00c7\5\f\7\2\u00c3\u00c4\7L\2\2\u00c4\u00c6\5\f\7\2\u00c5\u00c3" +
                    "\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8" +
                    "\13\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\5\\/\2\u00cb\u00cd\7\t\2\2" +
                    "\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0" +
                    "\5h\65\2\u00cf\u00d1\5\16\b\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2" +
                    "\u00d1\r\3\2\2\2\u00d2\u00d3\5\20\t\2\u00d3\u00d6\5\22\n\2\u00d4\u00d5" +
                    "\7\t\2\2\u00d5\u00d7\5h\65\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7" +
                    "\17\3\2\2\2\u00d8\u00da\t\2\2\2\u00d9\u00db\7\f\2\2\u00da\u00d9\3\2\2" +
                    "\2\u00da\u00db\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00de\7\16\2\2\u00dd" +
                    "\u00d8\3\2\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2" +
                    "\2\2\u00df\u00e0\7\r\2\2\u00e0\21\3\2\2\2\u00e1\u00e6\5h\65\2\u00e2\u00e3" +
                    "\7I\2\2\u00e3\u00e5\5f\64\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6" +
                    "\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\23\3\2\2\2\u00e8\u00e6\3\2\2" +
                    "\2\u00e9\u00ea\7<\2\2\u00ea\u00ed\7W\2\2\u00eb\u00ec\7L\2\2\u00ec\u00ee" +
                    "\7W\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\25\3\2\2\2\u00ef" +
                    "\u00f0\7\21\2\2\u00f0\u00f1\5d\63\2\u00f1\u00f2\7J\2\2\u00f2\u00f7\5\30" +
                    "\r\2\u00f3\u00f4\7L\2\2\u00f4\u00f6\5\30\r\2\u00f5\u00f3\3\2\2\2\u00f6" +
                    "\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2" +
                    "\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7K\2\2\u00fb\27\3\2\2\2\u00fc\u00ff" +
                    "\5\22\n\2\u00fd\u00ff\5\32\16\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2" +
                    "\2\u00ff\31\3\2\2\2\u0100\u0101\5\34\17\2\u0101\u0103\7J\2\2\u0102\u0104" +
                    "\7\17\2\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2" +
                    "\u0105\u0106\5\22\n\2\u0106\u0107\7K\2\2\u0107\33\3\2\2\2\u0108\u0109" +
                    "\t\3\2\2\u0109\35\3\2\2\2\u010a\u010b\7\27\2\2\u010b\u010c\5*\26\2\u010c" +
                    "\37\3\2\2\2\u010d\u010e\7\30\2\2\u010e\u010f\7\31\2\2\u010f\u0114\5\22" +
                    "\n\2\u0110\u0111\7L\2\2\u0111\u0113\5\22\n\2\u0112\u0110\3\2\2\2\u0113" +
                    "\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115!\3\2\2\2" +
                    "\u0116\u0114\3\2\2\2\u0117\u0118\7\33\2\2\u0118\u0119\5*\26\2\u0119#\3" +
                    "\2\2\2\u011a\u011b\7\32\2\2\u011b\u011c\7\31\2\2\u011c\u0121\5&\24\2\u011d" +
                    "\u011e\7L\2\2\u011e\u0120\5&\24\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2" +
                    "\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122%\3\2\2\2\u0123\u0121" +
                    "\3\2\2\2\u0124\u0126\5\22\n\2\u0125\u0127\7\35\2\2\u0126\u0125\3\2\2\2" +
                    "\u0126\u0127\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u012a\7\34\2\2\u0129\u0124" +
                    "\3\2\2\2\u0129\u0128\3\2\2\2\u012a\'\3\2\2\2\u012b\u012c\7J\2\2\u012c" +
                    "\u012d\5\6\4\2\u012d\u012e\7K\2\2\u012e)\3\2\2\2\u012f\u0134\5,\27\2\u0130" +
                    "\u0131\7$\2\2\u0131\u0133\5,\27\2\u0132\u0130\3\2\2\2\u0133\u0136\3\2" +
                    "\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135+\3\2\2\2\u0136\u0134" +
                    "\3\2\2\2\u0137\u013c\5.\30\2\u0138\u0139\7#\2\2\u0139\u013b\5.\30\2\u013a" +
                    "\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2" +
                    "\2\2\u013d-\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\7\36\2\2\u0140\u013f" +
                    "\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0148\5\60\31\2" +
                    "\u0143\u0144\7J\2\2\u0144\u0145\5*\26\2\u0145\u0146\7K\2\2\u0146\u0148" +
                    "\3\2\2\2\u0147\u0140\3\2\2\2\u0147\u0143\3\2\2\2\u0148/\3\2\2\2\u0149" +
                    "\u0152\5D#\2\u014a\u0152\5\62\32\2\u014b\u0152\5:\36\2\u014c\u0152\5\64" +
                    "\33\2\u014d\u0152\5<\37\2\u014e\u0152\5> \2\u014f\u0152\5@!\2\u0150\u0152" +
                    "\5B\"\2\u0151\u0149\3\2\2\2\u0151\u014a\3\2\2\2\u0151\u014b\3\2\2\2\u0151" +
                    "\u014c\3\2\2\2\u0151\u014d\3\2\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2" +
                    "\2\2\u0151\u0150\3\2\2\2\u0152\61\3\2\2\2\u0153\u0155\5H%\2\u0154\u0156" +
                    "\7\36\2\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2" +
                    "\u0157\u0158\7\37\2\2\u0158\u0159\5H%\2\u0159\u015a\7#\2\2\u015a\u015b" +
                    "\5H%\2\u015b\u0166\3\2\2\2\u015c\u015e\5R*\2\u015d\u015f\7\36\2\2\u015e" +
                    "\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7\37" +
                    "\2\2\u0161\u0162\5R*\2\u0162\u0163\7#\2\2\u0163\u0164\5R*\2\u0164\u0166" +
                    "\3\2\2\2\u0165\u0153\3\2\2\2\u0165\u015c\3\2\2\2\u0166\63\3\2\2\2\u0167" +
                    "\u0169\5\22\n\2\u0168\u016a\7\36\2\2\u0169\u0168\3\2\2\2\u0169\u016a\3" +
                    "\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7&\2\2\u016c\u016d\5\66\34\2\u016d" +
                    "\65\3\2\2\2\u016e\u016f\7J\2\2\u016f\u0174\58\35\2\u0170\u0171\7L\2\2" +
                    "\u0171\u0173\58\35\2\u0172\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172" +
                    "\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177" +
                    "\u0178\7K\2\2\u0178\u017b\3\2\2\2\u0179\u017b\5(\25\2\u017a\u016e\3\2" +
                    "\2\2\u017a\u0179\3\2\2\2\u017b\67\3\2\2\2\u017c\u017d\5b\62\2\u017d9\3" +
                    "\2\2\2\u017e\u0180\5R*\2\u017f\u0181\7\36\2\2\u0180\u017f\3\2\2\2\u0180" +
                    "\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\7%\2\2\u0183\u0184\5^\60" +
                    "\2\u0184;\3\2\2\2\u0185\u0186\5\22\n\2\u0186\u0188\7 \2\2\u0187\u0189" +
                    "\7\36\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2" +
                    "\u018a\u018b\7!\2\2\u018b=\3\2\2\2\u018c\u018d\5\22\n\2\u018d\u018f\7" +
                    " \2\2\u018e\u0190\7\36\2\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190" +
                    "\u0191\3\2\2\2\u0191\u0192\7-\2\2\u0192?\3\2\2\2\u0193\u0195\5X-\2\u0194" +
                    "\u0196\7\36\2\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3" +
                    "\2\2\2\u0197\u0199\7.\2\2\u0198\u019a\7/\2\2\u0199\u0198\3\2\2\2\u0199" +
                    "\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\5\22\n\2\u019cA\3\2\2\2" +
                    "\u019d\u019f\7\36\2\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0" +
                    "\3\2\2\2\u01a0\u01a1\79\2\2\u01a1\u01a2\5(\25\2\u01a2C\3\2\2\2\u01a3\u01a4" +
                    "\5R*\2\u01a4\u01a5\5F$\2\u01a5\u01a6\5R*\2\u01a6\u01b0\3\2\2\2\u01a7\u01a8" +
                    "\5X-\2\u01a8\u01a9\t\4\2\2\u01a9\u01aa\5X-\2\u01aa\u01b0\3\2\2\2\u01ab" +
                    "\u01ac\5H%\2\u01ac\u01ad\5F$\2\u01ad\u01ae\5H%\2\u01ae\u01b0\3\2\2\2\u01af" +
                    "\u01a3\3\2\2\2\u01af\u01a7\3\2\2\2\u01af\u01ab\3\2\2\2\u01b0E\3\2\2\2" +
                    "\u01b1\u01b2\t\5\2\2\u01b2G\3\2\2\2\u01b3\u01b6\5\22\n\2\u01b4\u01b6\5" +
                    "J&\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6I\3\2\2\2\u01b7\u01bc" +
                    "\5L\'\2\u01b8\u01b9\t\6\2\2\u01b9\u01bb\5L\'\2\u01ba\u01b8\3\2\2\2\u01bb" +
                    "\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bdK\3\2\2\2" +
                    "\u01be\u01bc\3\2\2\2\u01bf\u01c4\5N(\2\u01c0\u01c1\t\7\2\2\u01c1\u01c3" +
                    "\5N(\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4" +
                    "\u01c5\3\2\2\2\u01c5M\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c9\t\6\2\2" +
                    "\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb" +
                    "\5P)\2\u01cbO\3\2\2\2\u01cc\u01d3\5`\61\2\u01cd\u01ce\7J\2\2\u01ce\u01cf" +
                    "\5J&\2\u01cf\u01d0\7K\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01d3\5\32\16\2\u01d2" +
                    "\u01cc\3\2\2\2\u01d2\u01cd\3\2\2\2\u01d2\u01d1\3\2\2\2\u01d3Q\3\2\2\2" +
                    "\u01d4\u01d7\5T+\2\u01d5\u01d7\5(\25\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5" +
                    "\3\2\2\2\u01d7S\3\2\2\2\u01d8\u01dc\5\22\n\2\u01d9\u01dc\5V,\2\u01da\u01dc" +
                    "\5\32\16\2\u01db\u01d8\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01da\3\2\2\2" +
                    "\u01dcU\3\2\2\2\u01dd\u01de\7P\2\2\u01deW\3\2\2\2\u01df\u01e2\5\22\n\2" +
                    "\u01e0\u01e2\5Z.\2\u01e1\u01df\3\2\2\2\u01e1\u01e0\3\2\2\2\u01e2Y\3\2" +
                    "\2\2\u01e3\u01e4\7Q\2\2\u01e4[\3\2\2\2\u01e5\u01e6\7Q\2\2\u01e6]\3\2\2" +
                    "\2\u01e7\u01e8\7Q\2\2\u01e8_\3\2\2\2\u01e9\u01ea\t\b\2\2\u01eaa\3\2\2" +
                    "\2\u01eb\u01ec\7Q\2\2\u01ecc\3\2\2\2\u01ed\u01ee\7Q\2\2\u01eee\3\2\2\2" +
                    "\u01ef\u01f0\7Q\2\2\u01f0g\3\2\2\2\u01f1\u01f2\7Q\2\2\u01f2i\3\2\2\2\u01f3" +
                    "\u01f4\7\4\2\2\u01f4\u01f5\78\2\2\u01f5\u01f7\5l\67\2\u01f6\u01f8\5n8" +
                    "\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01fb" +
                    "\5v<\2\u01fa\u01f9\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc" +
                    "\u01fe\5x=\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fek\3\2\2\2\u01ff" +
                    "\u0200\7Q\2\2\u0200m\3\2\2\2\u0201\u0202\7J\2\2\u0202\u0207\5p9\2\u0203" +
                    "\u0204\7L\2\2\u0204\u0206\5p9\2\u0205\u0203\3\2\2\2\u0206\u0209\3\2\2" +
                    "\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209\u0207" +
                    "\3\2\2\2\u020a\u020b\7K\2\2\u020bo\3\2\2\2\u020c\u020d\7Q\2\2\u020d\u0211" +
                    "\5r:\2\u020e\u0210\5t;\2\u020f\u020e\3\2\2\2\u0210\u0213\3\2\2\2\u0211" +
                    "\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212q\3\2\2\2\u0213\u0211\3\2\2\2" +
                    "\u0214\u0224\7\63\2\2\u0215\u0224\7\64\2\2\u0216\u0217\7\65\2\2\u0217" +
                    "\u0218\7J\2\2\u0218\u0219\7W\2\2\u0219\u0224\7K\2\2\u021a\u021b\7\66\2" +
                    "\2\u021b\u021c\7J\2\2\u021c\u021d\5r:\2\u021d\u021e\7K\2\2\u021e\u0224" +
                    "\3\2\2\2\u021f\u0220\7\67\2\2\u0220\u0221\7J\2\2\u0221\u0222\7Q\2\2\u0222" +
                    "\u0224\7K\2\2\u0223\u0214\3\2\2\2\u0223\u0215\3\2\2\2\u0223\u0216\3\2" +
                    "\2\2\u0223\u021a\3\2\2\2\u0223\u021f\3\2\2\2\u0224s\3\2\2\2\u0225\u022b" +
                    "\7:\2\2\u0226\u0227\7)\2\2\u0227\u022b\7*\2\2\u0228\u0229\7;\2\2\u0229" +
                    "\u022b\7*\2\2\u022a\u0225\3\2\2\2\u022a\u0226\3\2\2\2\u022a\u0228\3\2" +
                    "\2\2\u022bu\3\2\2\2\u022c\u022d\7,\2\2\u022d\u0232\7Q\2\2\u022e\u022f" +
                    "\7L\2\2\u022f\u0231\7Q\2\2\u0230\u022e\3\2\2\2\u0231\u0234\3\2\2\2\u0232" +
                    "\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233w\3\2\2\2\u0234\u0232\3\2\2\2" +
                    "\u0235\u0236\7)\2\2\u0236\u0237\7*\2\2\u0237\u0238\7J\2\2\u0238\u023d" +
                    "\5\22\n\2\u0239\u023a\7L\2\2\u023a\u023c\5\22\n\2\u023b\u0239\3\2\2\2" +
                    "\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240" +
                    "\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u0241\7K\2\2\u0241y\3\2\2\2\u0242\u0244" +
                    "\5|?\2\u0243\u0245\5\36\20\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245" +
                    "{\3\2\2\2\u0246\u0247\7\5\2\2\u0247\u0249\5\\/\2\u0248\u024a\7\t\2\2\u0249" +
                    "\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\5h" +
                    "\65\2\u024c\u024d\7+\2\2\u024d\u0252\5~@\2\u024e\u024f\7L\2\2\u024f\u0251" +
                    "\5~@\2\u0250\u024e\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0252" +
                    "\u0253\3\2\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0255\u0257\5\36" +
                    "\20\2\u0256\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257}\3\2\2\2\u0258\u0259" +
                    "\5\22\n\2\u0259\u025a\7C\2\2\u025a\u025b\5\u0080A\2\u025b\177\3\2\2\2" +
                    "\u025c\u0261\5J&\2\u025d\u0261\5T+\2\u025e\u0261\5\u0082B\2\u025f\u0261" +
                    "\7!\2\2\u0260\u025c\3\2\2\2\u0260\u025d\3\2\2\2\u0260\u025e\3\2\2\2\u0260" +
                    "\u025f\3\2\2\2\u0261\u0081\3\2\2\2\u0262\u0263\7J\2\2\u0263\u0268\5\u0084" +
                    "C\2\u0264\u0265\7L\2\2\u0265\u0267\5\u0084C\2\u0266\u0264\3\2\2\2\u0267" +
                    "\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026b\3\2" +
                    "\2\2\u026a\u0268\3\2\2\2\u026b\u026c\7K\2\2\u026c\u0083\3\2\2\2\u026d" +
                    "\u026e\5\22\n\2\u026e\u026f\7N\2\2\u026f\u0270\5\u0080A\2\u0270\u0085" +
                    "\3\2\2\2\u0271\u0273\5\u0088E\2\u0272\u0274\5\36\20\2\u0273\u0272\3\2" +
                    "\2\2\u0273\u0274\3\2\2\2\u0274\u0087\3\2\2\2\u0275\u0276\7\6\2\2\u0276" +
                    "\u0277\7\b\2\2\u0277\u0279\5\\/\2\u0278\u027a\7\t\2\2\u0279\u0278\3\2" +
                    "\2\2\u0279\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\5h\65\2\u027c" +
                    "\u0089\3\2\2\2\u027d\u027e\7\7\2\2\u027e\u027f\7\'\2\2\u027f\u0281\5l" +
                    "\67\2\u0280\u0282\5\u008cG\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282" +
                    "\u0283\3\2\2\2\u0283\u0284\7(\2\2\u0284\u0285\5\u008eH\2\u0285\u008b\3" +
                    "\2\2\2\u0286\u0287\7J\2\2\u0287\u028c\5\22\n\2\u0288\u0289\7L\2\2\u0289" +
                    "\u028b\5\22\n\2\u028a\u0288\3\2\2\2\u028b\u028e\3\2\2\2\u028c\u028a\3" +
                    "\2\2\2\u028c\u028d\3\2\2\2\u028d\u028f\3\2\2\2\u028e\u028c\3\2\2\2\u028f" +
                    "\u0290\7K\2\2\u0290\u008d\3\2\2\2\u0291\u0292\7J\2\2\u0292\u0297\5\u0080" +
                    "A\2\u0293\u0294\7L\2\2\u0294\u0296\5\u0080A\2\u0295\u0293\3\2\2\2\u0296" +
                    "\u0299\3\2\2\2\u0297\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029a\3\2" +
                    "\2\2\u0299\u0297\3\2\2\2\u029a\u029b\7K\2\2\u029b\u008f\3\2\2\2\u029c" +
                    "\u029d\7=\2\2\u029d\u029e\78\2\2\u029e\u02a0\7Q\2\2\u029f\u02a1\7>\2\2" +
                    "\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u0091\3\2\2\2I\u0098\u009e" +
                    "\u00a1\u00a4\u00a7\u00aa\u00ad\u00b4\u00bf\u00c7\u00cc\u00d0\u00d6\u00da" +
                    "\u00dd\u00e6\u00ed\u00f7\u00fe\u0103\u0114\u0121\u0126\u0129\u0134\u013c" +
                    "\u0140\u0147\u0151\u0155\u015e\u0165\u0169\u0174\u017a\u0180\u0188\u018f" +
                    "\u0195\u0199\u019e\u01af\u01b5\u01bc\u01c4\u01c8\u01d2\u01d6\u01db\u01e1" +
                    "\u01f7\u01fa\u01fd\u0207\u0211\u0223\u022a\u0232\u023d\u0244\u0249\u0252" +
                    "\u0256\u0260\u0268\u0273\u0279\u0281\u028c\u0297\u02a0";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}