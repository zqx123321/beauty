// Generated from D:/杂乱文件终章/oodb/src/test/java\OQL.g4 by ANTLR 4.7
package cn.ouctechnology.oodb.parser;

import cn.ouctechnology.oodb.exception.ParseException;
import cn.ouctechnology.oodb.execute.*;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.OgnlUtil;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
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
            HAVING = 25, DESC = 26, ASC = 27, NOT = 28, SET = 29, BETWEEN = 30, IS = 31, NULL = 32,
            ESCAPE = 33, AND = 34, OR = 35, LIKE = 36, IN = 37, INTO = 38, VALUES = 39, PRIMARY = 40,
            KEY = 41, LISTOF = 42, EXTENDS = 43, EMPTY = 44, MEMBER = 45, OF = 46, ALL = 47, ANY = 48,
            SOME = 49, INT = 50, FLOAT = 51, CHAR = 52, SETOF = 53, REF = 54, TABLE = 55, EXISTS = 56,
            AUTO_INCREMENT = 57, UNIQUE = 58, LIMIT = 59, DROP = 60, CASCADE = 61, ON = 62, SHOW = 63,
            DATABASES = 64, FINAL = 65, MUL = 66, DIV = 67, PLUS = 68, MINUS = 69, EQ = 70, GR = 71,
            LS = 72, GE = 73, LE = 74, NE = 75, DOT = 76, LBRACKET = 77, RBRACKET = 78, LFRACKET = 79,
            RFRACKET = 80, COMMA = 81, SEMI = 82, COLON = 83, TRIMCHARACTER = 84, STRINGLITERAL = 85,
            WORD = 86, NAMEDPARAMETER = 87, WS = 88, COMMENT = 89, LINECOMMENT = 90, ESCAPECHARACTER = 91,
            INTNUMERAL = 92, FLOATNUMERAL = 93;
    public static final int
            RULE_oqlStat = 0, RULE_selectStat = 1, RULE_selectClause = 2, RULE_selectExpr = 3,
            RULE_fromClause = 4, RULE_fromItem = 5, RULE_join = 6, RULE_pathExpr = 7,
            RULE_limitClause = 8, RULE_aggregateExpr = 9, RULE_aggregateExprFunctionName = 10,
            RULE_whereClause = 11, RULE_groupByClause = 12, RULE_havingClause = 13,
            RULE_orderByClause = 14, RULE_orderByItem = 15, RULE_conditionalExpr = 16,
            RULE_conditionalTerm = 17, RULE_conditionalFactor = 18, RULE_simpleCondExpr = 19,
            RULE_betweenExpr = 20, RULE_inExpr = 21, RULE_inExprRightPart = 22, RULE_inItem = 23,
            RULE_likeExpr = 24, RULE_comparisonExpr = 25, RULE_comparisonOperator = 26,
            RULE_arithmeticExpr = 27, RULE_simpleArithmeticExpr = 28, RULE_arithmeticTerm = 29,
            RULE_arithmeticFactor = 30, RULE_arithmeticPrimary = 31, RULE_stringExpr = 32,
            RULE_stringPrimary = 33, RULE_entityExpr = 34, RULE_listExpr = 35, RULE_stringLiteralExpr = 36,
            RULE_schemaName = 37, RULE_patternValue = 38, RULE_numericLiteral = 39,
            RULE_literal = 40, RULE_field = 41, RULE_id = 42, RULE_createStat = 43,
            RULE_tableName = 44, RULE_columnDefinition = 45, RULE_columnDefinitionItem = 46,
            RULE_columnType = 47, RULE_columnConstraint = 48, RULE_extendsTable = 49,
            RULE_tableConstraint = 50, RULE_updateStat = 51, RULE_updateClause = 52,
            RULE_updateItem = 53, RULE_newValue = 54, RULE_insertListExpr = 55, RULE_insertListItem = 56,
            RULE_insertEntityExpr = 57, RULE_insertEntityItem = 58, RULE_deleteStat = 59,
            RULE_deleteClause = 60, RULE_insertStat = 61, RULE_columnList = 62, RULE_insertValue = 63,
            RULE_dropStat = 64, RULE_showStat = 65;
    public static final String[] ruleNames = {
            "oqlStat", "selectStat", "selectClause", "selectExpr", "fromClause", "fromItem",
            "join", "pathExpr", "limitClause", "aggregateExpr", "aggregateExprFunctionName",
            "whereClause", "groupByClause", "havingClause", "orderByClause", "orderByItem",
            "conditionalExpr", "conditionalTerm", "conditionalFactor", "simpleCondExpr",
            "betweenExpr", "inExpr", "inExprRightPart", "inItem", "likeExpr", "comparisonExpr",
            "comparisonOperator", "arithmeticExpr", "simpleArithmeticExpr", "arithmeticTerm",
            "arithmeticFactor", "arithmeticPrimary", "stringExpr", "stringPrimary",
            "entityExpr", "listExpr", "stringLiteralExpr", "schemaName", "patternValue",
            "numericLiteral", "literal", "field", "id", "createStat", "tableName",
            "columnDefinition", "columnDefinitionItem", "columnType", "columnConstraint",
            "extendsTable", "tableConstraint", "updateStat", "updateClause", "updateItem",
            "newValue", "insertListExpr", "insertListItem", "insertEntityExpr", "insertEntityItem",
            "deleteStat", "deleteClause", "insertStat", "columnList", "insertValue",
            "dropStat", "showStat"
    };

    private static final String[] _LITERAL_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'='",
            "'>'", "'<'", "'>='", "'<='", null, "'.'", "'('", "')'", "'['", "']'",
            "','", "';'", "':'", "''.''"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "SELECT", "CREATE", "UPDATE", "DELETE", "INSERT", "FROM", "AS",
            "LEFT", "RIGHT", "OUTER", "JOIN", "INNER", "DISTINCT", "OBJECT", "NEW",
            "AVG", "SUM", "MAX", "MIN", "COUNT", "WHERE", "GROUP", "BY", "ORDER",
            "HAVING", "DESC", "ASC", "NOT", "SET", "BETWEEN", "IS", "NULL", "ESCAPE",
            "AND", "OR", "LIKE", "IN", "INTO", "VALUES", "PRIMARY", "KEY", "LISTOF",
            "EXTENDS", "EMPTY", "MEMBER", "OF", "ALL", "ANY", "SOME", "INT", "FLOAT",
            "CHAR", "SETOF", "REF", "TABLE", "EXISTS", "AUTO_INCREMENT", "UNIQUE",
            "LIMIT", "DROP", "CASCADE", "ON", "SHOW", "DATABASES", "FINAL", "MUL",
            "DIV", "PLUS", "MINUS", "EQ", "GR", "LS", "GE", "LE", "NE", "DOT", "LBRACKET",
            "RBRACKET", "LFRACKET", "RFRACKET", "COMMA", "SEMI", "COLON", "TRIMCHARACTER",
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
            throw new UnsupportedOperationException("the method is not implement");
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
            CreateStatContext stat = this.createStat();
            return CreateExplain.getCreateExplain(stat).doCreate();
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
            DeleteStatContext deleteStatContext = this.deleteStat();
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

        @Override
        public Object doExecute() {
            InsertStatContext insertStatContext = this.insertStat();
            return InsertExplain.getInsertExplain(insertStatContext).doInsert();
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
            UpdateStatContext updateStatContext = this.updateStat();
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
            SelectStatContext selectStatContext = this.selectStat();
            return SelectExplain.getSelectExplain(selectStatContext).doSelect();
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
            DropStatContext dropStatContext = this.dropStat();
            return DropExplain.getDropStatContext(dropStatContext).doDrop();
        }
    }

    public static class ShowStatementContext extends OqlStatContext {
        public ShowStatContext showStat() {
            return getRuleContext(ShowStatContext.class, 0);
        }

        public ShowStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            return ShowExplain.doShow();
        }
    }

    public final OqlStatContext oqlStat() throws RecognitionException {
        OqlStatContext _localctx = new OqlStatContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_oqlStat);
        try {
            setState(139);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SELECT:
                    _localctx = new SelectStatementContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(132);
                    selectStat();
                }
                break;
                case CREATE:
                    _localctx = new CreateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(133);
                    createStat();
                }
                break;
                case INSERT:
                    _localctx = new InsertStatementContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(134);
                    insertStat();
                }
                break;
                case UPDATE:
                    _localctx = new UpdateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(135);
                    updateStat();
                }
                break;
                case DELETE:
                    _localctx = new DeleteStatementContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(136);
                    deleteStat();
                }
                break;
                case DROP:
                    _localctx = new DropStatementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(137);
                    dropStat();
                }
                break;
                case SHOW:
                    _localctx = new ShowStatementContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(138);
                    showStat();
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

        public TerminalNode DISTINCT() {
            return getToken(OQLParser.DISTINCT, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public GroupByClauseContext groupByClause() {
            return getRuleContext(GroupByClauseContext.class, 0);
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
                setState(141);
                match(SELECT);
                setState(143);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DISTINCT) {
                    {
                        setState(142);
                        match(DISTINCT);
                    }
                }

                setState(145);
                selectClause();
                setState(146);
                fromClause();
                setState(148);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(147);
                        whereClause();
                    }
                }

                setState(151);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GROUP) {
                    {
                        setState(150);
                        groupByClause();
                    }
                }

                setState(154);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ORDER) {
                    {
                        setState(153);
                        orderByClause();
                    }
                }

                setState(157);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(156);
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
                setState(159);
                selectExpr();
                setState(164);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(160);
                            match(COMMA);
                            setState(161);
                            selectExpr();
                        }
                    }
                    setState(166);
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

    public static class SelectPathExprContext extends SelectExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public SelectPathExprContext(SelectExprContext ctx) {
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
            setState(169);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new SelectPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(167);
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
                    setState(168);
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
                setState(171);
                match(FROM);
                setState(172);
                fromItem();
                setState(177);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(173);
                            match(COMMA);
                            setState(174);
                            fromItem();
                        }
                    }
                    setState(179);
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

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
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
                setState(180);
                schemaName();
                setState(182);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(181);
                        match(AS);
                    }
                }

                setState(184);
                id();
                setState(188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == JOIN) {
                    {
                        {
                            setState(185);
                            join();
                        }
                    }
                    setState(190);
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

    public static class JoinContext extends EnhancedParserRuleContext {
        public TerminalNode JOIN() {
            return getToken(OQLParser.JOIN, 0);
        }

        public SchemaNameContext schemaName() {
            return getRuleContext(SchemaNameContext.class, 0);
        }

        public IdContext id() {
            return getRuleContext(IdContext.class, 0);
        }

        public TerminalNode ON() {
            return getToken(OQLParser.ON, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(OQLParser.AS, 0);
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
                setState(191);
                match(JOIN);
                setState(192);
                schemaName();
                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(193);
                        match(AS);
                    }
                }

                setState(196);
                id();
                setState(197);
                match(ON);
                setState(198);
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
        enterRule(_localctx, 14, RULE_pathExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(200);
                id();
                setState(205);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(201);
                            match(DOT);
                            setState(202);
                            field();
                        }
                    }
                    setState(207);
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
        enterRule(_localctx, 16, RULE_limitClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                match(LIMIT);
                setState(209);
                match(INTNUMERAL);
                setState(212);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(210);
                        match(COMMA);
                        setState(211);
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
        enterRule(_localctx, 18, RULE_aggregateExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(214);
                aggregateExprFunctionName();
                setState(215);
                match(LBRACKET);
                setState(216);
                pathExpr();
                setState(217);
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
        enterRule(_localctx, 20, RULE_aggregateExprFunctionName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(219);
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
        enterRule(_localctx, 22, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(221);
                match(WHERE);
                setState(222);
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

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public HavingClauseContext havingClause() {
            return getRuleContext(HavingClauseContext.class, 0);
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
        enterRule(_localctx, 24, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(224);
                match(GROUP);
                setState(225);
                match(BY);
                setState(226);
                pathExpr();
                setState(228);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HAVING) {
                    {
                        setState(227);
                        havingClause();
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
        enterRule(_localctx, 26, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(230);
                match(HAVING);
                setState(231);
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
        enterRule(_localctx, 28, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(233);
                match(ORDER);
                setState(234);
                match(BY);
                setState(235);
                orderByItem();
                setState(240);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(236);
                            match(COMMA);
                            setState(237);
                            orderByItem();
                        }
                    }
                    setState(242);
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

        public TerminalNode DESC() {
            return getToken(OQLParser.DESC, 0);
        }

        public TerminalNode ASC() {
            return getToken(OQLParser.ASC, 0);
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
        enterRule(_localctx, 30, RULE_orderByItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(243);
                pathExpr();
                setState(248);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case EOF:
                    case ASC:
                    case LIMIT:
                    case COMMA: {
                        setState(245);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == ASC) {
                            {
                                setState(244);
                                match(ASC);
                            }
                        }

                    }
                    break;
                    case DESC: {
                        setState(247);
                        match(DESC);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
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
        enterRule(_localctx, 32, RULE_conditionalExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(250);
                    conditionalTerm();
                }
                setState(255);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(251);
                            match(OR);
                            setState(252);
                            conditionalTerm();
                        }
                    }
                    setState(257);
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
        enterRule(_localctx, 34, RULE_conditionalTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(258);
                    conditionalFactor();
                }
                setState(263);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(259);
                            match(AND);
                            setState(260);
                            conditionalFactor();
                        }
                    }
                    setState(265);
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
        enterRule(_localctx, 36, RULE_conditionalFactor);
        try {
            setState(271);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                case 1:
                    _localctx = new ConditionalFactorSimpleCondExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(266);
                    simpleCondExpr();
                }
                break;
                case 2:
                    _localctx = new ConditionalFactorExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(267);
                    match(LBRACKET);
                    setState(268);
                    conditionalExpr();
                    setState(269);
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

    public static class SimpleLikeExprContext extends SimpleCondExprContext {
        public LikeExprContext likeExpr() {
            return getRuleContext(LikeExprContext.class, 0);
        }

        public SimpleLikeExprContext(SimpleCondExprContext ctx) {
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
        enterRule(_localctx, 38, RULE_simpleCondExpr);
        try {
            setState(277);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                case 1:
                    _localctx = new SimpleComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(273);
                    comparisonExpr();
                }
                break;
                case 2:
                    _localctx = new SimpleBetweenExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(274);
                    betweenExpr();
                }
                break;
                case 3:
                    _localctx = new SimpleLikeExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(275);
                    likeExpr();
                }
                break;
                case 4:
                    _localctx = new SimpleInExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(276);
                    inExpr();
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
        enterRule(_localctx, 40, RULE_betweenExpr);
        int _la;
        try {
            setState(297);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    _localctx = new BetweenArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(279);
                    arithmeticExpr();
                    setState(281);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(280);
                            match(NOT);
                        }
                    }

                    setState(283);
                    match(BETWEEN);
                    setState(284);
                    arithmeticExpr();
                    setState(285);
                    match(AND);
                    setState(286);
                    arithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new BetweenStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(288);
                    stringExpr();
                    setState(290);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(289);
                            match(NOT);
                        }
                    }

                    setState(292);
                    match(BETWEEN);
                    setState(293);
                    stringExpr();
                    setState(294);
                    match(AND);
                    setState(295);
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
        enterRule(_localctx, 42, RULE_inExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(299);
                pathExpr();
                setState(301);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(300);
                        match(NOT);
                    }
                }

                setState(303);
                match(IN);
                setState(304);
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

    public final InExprRightPartContext inExprRightPart() throws RecognitionException {
        InExprRightPartContext _localctx = new InExprRightPartContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_inExprRightPart);
        int _la;
        try {
            _localctx = new InExprItemContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(306);
                match(LBRACKET);
                setState(307);
                inItem();
                setState(312);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(308);
                            match(COMMA);
                            setState(309);
                            inItem();
                        }
                    }
                    setState(314);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(315);
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
        enterRule(_localctx, 46, RULE_inItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(317);
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
        enterRule(_localctx, 48, RULE_likeExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(319);
                stringExpr();
                setState(321);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(320);
                        match(NOT);
                    }
                }

                setState(323);
                match(LIKE);
                setState(324);
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
    }

    public static class ComparisonListExprContext extends ComparisonExprContext {
        public List<ListExprContext> listExpr() {
            return getRuleContexts(ListExprContext.class);
        }

        public ListExprContext listExpr(int i) {
            return getRuleContext(ListExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public ComparisonListExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ComparisonAggregateExprContext extends ComparisonExprContext {
        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public ArithmeticExprContext arithmeticExpr() {
            return getRuleContext(ArithmeticExprContext.class, 0);
        }

        public ComparisonAggregateExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ComparisonEntityExprContext extends ComparisonExprContext {
        public List<EntityExprContext> entityExpr() {
            return getRuleContexts(EntityExprContext.class);
        }

        public EntityExprContext entityExpr(int i) {
            return getRuleContext(EntityExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
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
    }

    public final ComparisonExprContext comparisonExpr() throws RecognitionException {
        ComparisonExprContext _localctx = new ComparisonExprContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_comparisonExpr);
        try {
            setState(346);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    _localctx = new ComparisonStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(326);
                    stringExpr();
                    setState(327);
                    comparisonOperator();
                    setState(328);
                    stringExpr();
                }
                break;
                case 2:
                    _localctx = new ComparisonArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(330);
                    arithmeticExpr();
                    setState(331);
                    comparisonOperator();
                    setState(332);
                    arithmeticExpr();
                }
                break;
                case 3:
                    _localctx = new ComparisonAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(334);
                    aggregateExpr();
                    setState(335);
                    comparisonOperator();
                    setState(336);
                    arithmeticExpr();
                }
                break;
                case 4:
                    _localctx = new ComparisonEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(338);
                    entityExpr();
                    setState(339);
                    comparisonOperator();
                    setState(340);
                    entityExpr();
                }
                break;
                case 5:
                    _localctx = new ComparisonListExprContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(342);
                    listExpr();
                    setState(343);
                    comparisonOperator();
                    setState(344);
                    listExpr();
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
        enterRule(_localctx, 52, RULE_comparisonOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(348);
                _la = _input.LA(1);
                if (!(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (EQ - 70)) | (1L << (GR - 70)) | (1L << (LS - 70)) | (1L << (GE - 70)) | (1L << (LE - 70)) | (1L << (NE - 70)))) != 0))) {
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
    }

    public static class ArithmeticPathExprContext extends ArithmeticExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public ArithmeticPathExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ArithmeticSimpleArithmeticExprContext extends ArithmeticExprContext {
        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        public ArithmeticSimpleArithmeticExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final ArithmeticExprContext arithmeticExpr() throws RecognitionException {
        ArithmeticExprContext _localctx = new ArithmeticExprContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_arithmeticExpr);
        try {
            setState(352);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ArithmeticPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(350);
                    pathExpr();
                }
                break;
                case PLUS:
                case MINUS:
                case LBRACKET:
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new ArithmeticSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(351);
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
        enterRule(_localctx, 56, RULE_simpleArithmeticExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(354);
                    arithmeticTerm();
                }
                setState(359);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PLUS || _la == MINUS) {
                    {
                        {
                            setState(355);
                            _la = _input.LA(1);
                            if (!(_la == PLUS || _la == MINUS)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(356);
                            arithmeticTerm();
                        }
                    }
                    setState(361);
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
        enterRule(_localctx, 58, RULE_arithmeticTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(362);
                    arithmeticFactor();
                }
                setState(367);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == MUL || _la == DIV) {
                    {
                        {
                            setState(363);
                            _la = _input.LA(1);
                            if (!(_la == MUL || _la == DIV)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(364);
                            arithmeticFactor();
                        }
                    }
                    setState(369);
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
        enterRule(_localctx, 60, RULE_arithmeticFactor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(371);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PLUS || _la == MINUS) {
                    {
                        setState(370);
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

                setState(373);
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

    public final ArithmeticPrimaryContext arithmeticPrimary() throws RecognitionException {
        ArithmeticPrimaryContext _localctx = new ArithmeticPrimaryContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_arithmeticPrimary);
        try {
            setState(380);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new AriPriNumericLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(375);
                    numericLiteral();
                }
                break;
                case LBRACKET:
                    _localctx = new AriPriSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(376);
                    match(LBRACKET);
                    setState(377);
                    simpleArithmeticExpr();
                    setState(378);
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

    public final StringExprContext stringExpr() throws RecognitionException {
        StringExprContext _localctx = new StringExprContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_stringExpr);
        try {
            _localctx = new StringPriContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(382);
                stringPrimary();
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

    public final StringPrimaryContext stringPrimary() throws RecognitionException {
        StringPrimaryContext _localctx = new StringPrimaryContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_stringPrimary);
        try {
            setState(386);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new StringPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(384);
                    pathExpr();
                }
                break;
                case STRINGLITERAL:
                    _localctx = new StringLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(385);
                    stringLiteralExpr();
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

    public static class EntityValueExprContext extends EntityExprContext {
        public InsertEntityExprContext insertEntityExpr() {
            return getRuleContext(InsertEntityExprContext.class, 0);
        }

        public EntityValueExprContext(EntityExprContext ctx) {
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
        enterRule(_localctx, 68, RULE_entityExpr);
        try {
            setState(390);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new EntityPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(388);
                    pathExpr();
                }
                break;
                case LBRACKET:
                    _localctx = new EntityValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(389);
                    insertEntityExpr();
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

    public static class ListExprContext extends EnhancedParserRuleContext {
        public ListExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_listExpr;
        }

        public ListExprContext() {
        }

        public void copyFrom(ListExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ListValueExprContext extends ListExprContext {
        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
        }

        public ListValueExprContext(ListExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public static class ListPathExprContext extends ListExprContext {
        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public ListPathExprContext(ListExprContext ctx) {
            copyFrom(ctx);
        }
    }

    public final ListExprContext listExpr() throws RecognitionException {
        ListExprContext _localctx = new ListExprContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_listExpr);
        try {
            setState(394);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ListPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(392);
                    pathExpr();
                }
                break;
                case LFRACKET:
                    _localctx = new ListValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(393);
                    insertListExpr();
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
        enterRule(_localctx, 72, RULE_stringLiteralExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(396);
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
        enterRule(_localctx, 74, RULE_schemaName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(398);
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
        enterRule(_localctx, 76, RULE_patternValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(400);
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
        enterRule(_localctx, 78, RULE_numericLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(402);
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
        enterRule(_localctx, 80, RULE_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(404);
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

        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
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
        enterRule(_localctx, 82, RULE_field);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(406);
                _la = _input.LA(1);
                if (!(_la == WORD || _la == INTNUMERAL)) {
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
        enterRule(_localctx, 84, RULE_id);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(408);
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
        enterRule(_localctx, 86, RULE_createStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(410);
                match(CREATE);
                setState(411);
                match(TABLE);
                setState(412);
                tableName();
                setState(414);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(413);
                        columnDefinition();
                    }
                }

                setState(417);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EXTENDS) {
                    {
                        setState(416);
                        extendsTable();
                    }
                }

                setState(420);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PRIMARY) {
                    {
                        setState(419);
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
        enterRule(_localctx, 88, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(422);
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
        enterRule(_localctx, 90, RULE_columnDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(424);
                match(LBRACKET);
                setState(425);
                columnDefinitionItem();
                setState(430);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(426);
                            match(COMMA);
                            setState(427);
                            columnDefinitionItem();
                        }
                    }
                    setState(432);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(433);
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
        enterRule(_localctx, 92, RULE_columnDefinitionItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(435);
                match(WORD);
                setState(436);
                columnType();
                setState(440);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (PRIMARY - 40)) | (1L << (AUTO_INCREMENT - 40)) | (1L << (UNIQUE - 40)) | (1L << (FINAL - 40)))) != 0)) {
                    {
                        {
                            setState(437);
                            columnConstraint();
                        }
                    }
                    setState(442);
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

        public TerminalNode LISTOF() {
            return getToken(OQLParser.LISTOF, 0);
        }

        public ColumnTypeContext columnType() {
            return getRuleContext(ColumnTypeContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(OQLParser.COMMA, 0);
        }

        public TerminalNode REF() {
            return getToken(OQLParser.REF, 0);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public TerminalNode OBJECT() {
            return getToken(OQLParser.OBJECT, 0);
        }

        public ColumnDefinitionContext columnDefinition() {
            return getRuleContext(ColumnDefinitionContext.class, 0);
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
        enterRule(_localctx, 94, RULE_columnType);
        try {
            setState(462);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(443);
                    match(INT);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(444);
                    match(FLOAT);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(445);
                    match(CHAR);
                    setState(446);
                    match(LBRACKET);
                    setState(447);
                    match(INTNUMERAL);
                    setState(448);
                    match(RBRACKET);
                }
                break;
                case LISTOF:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(449);
                    match(LISTOF);
                    setState(450);
                    match(LBRACKET);
                    setState(451);
                    columnType();
                    setState(452);
                    match(COMMA);
                    setState(453);
                    match(INTNUMERAL);
                    setState(454);
                    match(RBRACKET);
                }
                break;
                case REF:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(456);
                    match(REF);
                    setState(457);
                    match(LBRACKET);
                    setState(458);
                    match(WORD);
                    setState(459);
                    match(RBRACKET);
                }
                break;
                case OBJECT:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(460);
                    match(OBJECT);
                    setState(461);
                    columnDefinition();
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

        public TerminalNode FINAL() {
            return getToken(OQLParser.FINAL, 0);
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
        enterRule(_localctx, 96, RULE_columnConstraint);
        try {
            setState(470);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(464);
                    match(AUTO_INCREMENT);
                }
                break;
                case PRIMARY:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(465);
                    match(PRIMARY);
                    setState(466);
                    match(KEY);
                }
                break;
                case UNIQUE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(467);
                    match(UNIQUE);
                    setState(468);
                    match(KEY);
                }
                break;
                case FINAL:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(469);
                    match(FINAL);
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
        enterRule(_localctx, 98, RULE_extendsTable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(472);
                match(EXTENDS);
                setState(473);
                match(WORD);
                setState(478);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(474);
                            match(COMMA);
                            setState(475);
                            match(WORD);
                        }
                    }
                    setState(480);
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
        enterRule(_localctx, 100, RULE_tableConstraint);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(481);
                match(PRIMARY);
                setState(482);
                match(KEY);
                setState(483);
                match(LBRACKET);
                setState(484);
                pathExpr();
                setState(489);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(485);
                            match(COMMA);
                            setState(486);
                            pathExpr();
                        }
                    }
                    setState(491);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(492);
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
        enterRule(_localctx, 102, RULE_updateStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(494);
                updateClause();
                setState(496);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(495);
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
        enterRule(_localctx, 104, RULE_updateClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(498);
                match(UPDATE);
                setState(499);
                schemaName();
                setState(501);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(500);
                        match(AS);
                    }
                }

                setState(503);
                id();
                setState(504);
                match(SET);
                setState(505);
                updateItem();
                setState(510);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(506);
                            match(COMMA);
                            setState(507);
                            updateItem();
                        }
                    }
                    setState(512);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(514);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 49, _ctx)) {
                    case 1: {
                        setState(513);
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
        enterRule(_localctx, 106, RULE_updateItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(516);
                pathExpr();
                setState(517);
                match(EQ);
                setState(518);
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
            throw new UnsupportedOperationException("the method is not implemented");
        }
    }

    public static class NewSimpleListExprContext extends NewValueContext {
        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
        }

        public NewSimpleListExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            boolean isTuple = false;
            List<InsertListItemContext> insertListItemContexts = insertListExpr().insertListItem();
            for (InsertListItemContext insertEntityItemContext : insertListItemContexts) {
                if (insertEntityItemContext.COLON() != null) {
                    isTuple = true;
                } else {
                    if (isTuple) throw new ParseException("the oql is error");
                }
            }
            if (isTuple) {
                Tuple tuple = new Tuple();
                for (InsertListItemContext insertEntityItemContext : insertListItemContexts) {
                    String name = insertEntityItemContext.INTNUMERAL().getText();
                    Object value = insertEntityItemContext.newValue().getValue();
                    tuple.add(name, value);
                }
                return tuple;
            }

            List<Object> valueList = new ArrayList<>();
            for (InsertListItemContext insertEntityItemContext : insertListItemContexts) {
                Object value = insertEntityItemContext.newValue().getValue();
                valueList.add(value);
            }
            return valueList;
        }
    }

    public static class NewSimpleEntityExprContext extends NewValueContext {
        public InsertEntityExprContext insertEntityExpr() {
            return getRuleContext(InsertEntityExprContext.class, 0);
        }

        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
        }

        public NewSimpleEntityExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            boolean isTuple = false;
            List<InsertEntityItemContext> insertEntityItemContexts = insertEntityExpr().insertEntityItem();
            for (InsertEntityItemContext insertEntityItemContext : insertEntityItemContexts) {
                if (insertEntityItemContext.COLON() != null) {
                    isTuple = true;
                } else {
                    if (isTuple) throw new ParseException("the oql is error");
                }
            }
            if (isTuple) {
                Tuple tuple = new Tuple();
                for (InsertEntityItemContext insertEntityItemContext : insertEntityItemContexts) {
                    String name = insertEntityItemContext.pathExpr().getText();
                    Object value = insertEntityItemContext.newValue().getValue();
                    tuple.add(name, value);
                }
                return tuple;
            }

            List<Object> valueList = new ArrayList<>();
            for (InsertEntityItemContext insertEntityItemContext : insertEntityItemContexts) {
                Object value = insertEntityItemContext.newValue().getValue();
                valueList.add(value);
            }
            return valueList;
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
            return OgnlUtil.eval(getText());
        }
    }

    public static class NewNullContext extends NewValueContext {
        public TerminalNode NULL() {
            return getToken(OQLParser.NULL, 0);
        }

        public NewNullContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object getValue() {
            return null;
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
        enterRule(_localctx, 108, RULE_newValue);
        try {
            setState(525);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 50, _ctx)) {
                case 1:
                    _localctx = new NewSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(520);
                    simpleArithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new NewStringPrimaryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(521);
                    stringPrimary();
                }
                break;
                case 3:
                    _localctx = new NewSimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(522);
                    insertEntityExpr();
                }
                break;
                case 4:
                    _localctx = new NewSimpleListExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(523);
                    insertListExpr();
                }
                break;
                case 5:
                    _localctx = new NewNullContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(524);
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

    public static class InsertListExprContext extends EnhancedParserRuleContext {
        public TerminalNode LFRACKET() {
            return getToken(OQLParser.LFRACKET, 0);
        }

        public List<InsertListItemContext> insertListItem() {
            return getRuleContexts(InsertListItemContext.class);
        }

        public InsertListItemContext insertListItem(int i) {
            return getRuleContext(InsertListItemContext.class, i);
        }

        public TerminalNode RFRACKET() {
            return getToken(OQLParser.RFRACKET, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(OQLParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(OQLParser.COMMA, i);
        }

        public InsertListExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertListExpr;
        }
    }

    public final InsertListExprContext insertListExpr() throws RecognitionException {
        InsertListExprContext _localctx = new InsertListExprContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_insertListExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(527);
                match(LFRACKET);
                setState(528);
                insertListItem();
                setState(533);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(529);
                            match(COMMA);
                            setState(530);
                            insertListItem();
                        }
                    }
                    setState(535);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(536);
                match(RFRACKET);
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

    public static class InsertListItemContext extends EnhancedParserRuleContext {
        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        public TerminalNode COLON() {
            return getToken(OQLParser.COLON, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        public InsertListItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertListItem;
        }
    }

    public final InsertListItemContext insertListItem() throws RecognitionException {
        InsertListItemContext _localctx = new InsertListItemContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_insertListItem);
        try {
            setState(542);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 52, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(538);
                    match(INTNUMERAL);
                    setState(539);
                    match(COLON);
                    setState(540);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(541);
                    newValue();
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
        enterRule(_localctx, 114, RULE_insertEntityExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(544);
                match(LBRACKET);
                setState(545);
                insertEntityItem();
                setState(550);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(546);
                            match(COMMA);
                            setState(547);
                            insertEntityItem();
                        }
                    }
                    setState(552);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(553);
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
        enterRule(_localctx, 116, RULE_insertEntityItem);
        try {
            setState(560);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(555);
                    pathExpr();
                    setState(556);
                    match(COLON);
                    setState(557);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(559);
                    newValue();
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
        enterRule(_localctx, 118, RULE_deleteStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(562);
                deleteClause();
                setState(564);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(563);
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
        enterRule(_localctx, 120, RULE_deleteClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(566);
                match(DELETE);
                setState(567);
                match(FROM);
                setState(568);
                schemaName();
                setState(570);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(569);
                        match(AS);
                    }
                }

                setState(572);
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
        enterRule(_localctx, 122, RULE_insertStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(574);
                match(INSERT);
                setState(575);
                match(INTO);
                setState(576);
                tableName();
                setState(578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(577);
                        columnList();
                    }
                }

                setState(580);
                match(VALUES);
                setState(581);
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
        enterRule(_localctx, 124, RULE_columnList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(583);
                match(LBRACKET);
                setState(584);
                pathExpr();
                setState(589);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(585);
                            match(COMMA);
                            setState(586);
                            pathExpr();
                        }
                    }
                    setState(591);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(592);
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
        enterRule(_localctx, 126, RULE_insertValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(594);
                match(LBRACKET);
                setState(595);
                newValue();
                setState(600);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(596);
                            match(COMMA);
                            setState(597);
                            newValue();
                        }
                    }
                    setState(602);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(603);
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
        enterRule(_localctx, 128, RULE_dropStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(605);
                match(DROP);
                setState(606);
                match(TABLE);
                setState(607);
                match(WORD);
                setState(609);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CASCADE) {
                    {
                        setState(608);
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

    public static class ShowStatContext extends EnhancedParserRuleContext {
        public TerminalNode SHOW() {
            return getToken(OQLParser.SHOW, 0);
        }

        public TerminalNode DATABASES() {
            return getToken(OQLParser.DATABASES, 0);
        }

        public ShowStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showStat;
        }
    }

    public final ShowStatContext showStat() throws RecognitionException {
        ShowStatContext _localctx = new ShowStatContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_showStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(611);
                match(SHOW);
                setState(612);
                match(DATABASES);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3_\u0269\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u008e" +
                    "\n\2\3\3\3\3\5\3\u0092\n\3\3\3\3\3\3\3\5\3\u0097\n\3\3\3\5\3\u009a\n\3" +
                    "\3\3\5\3\u009d\n\3\3\3\5\3\u00a0\n\3\3\4\3\4\3\4\7\4\u00a5\n\4\f\4\16" +
                    "\4\u00a8\13\4\3\5\3\5\5\5\u00ac\n\5\3\6\3\6\3\6\3\6\7\6\u00b2\n\6\f\6" +
                    "\16\6\u00b5\13\6\3\7\3\7\5\7\u00b9\n\7\3\7\3\7\7\7\u00bd\n\7\f\7\16\7" +
                    "\u00c0\13\7\3\b\3\b\3\b\5\b\u00c5\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t" +
                    "\u00ce\n\t\f\t\16\t\u00d1\13\t\3\n\3\n\3\n\3\n\5\n\u00d7\n\n\3\13\3\13" +
                    "\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00e7\n\16" +
                    "\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00f1\n\20\f\20\16\20\u00f4" +
                    "\13\20\3\21\3\21\5\21\u00f8\n\21\3\21\5\21\u00fb\n\21\3\22\3\22\3\22\7" +
                    "\22\u0100\n\22\f\22\16\22\u0103\13\22\3\23\3\23\3\23\7\23\u0108\n\23\f" +
                    "\23\16\23\u010b\13\23\3\24\3\24\3\24\3\24\3\24\5\24\u0112\n\24\3\25\3" +
                    "\25\3\25\3\25\5\25\u0118\n\25\3\26\3\26\5\26\u011c\n\26\3\26\3\26\3\26" +
                    "\3\26\3\26\3\26\3\26\5\26\u0125\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u012c" +
                    "\n\26\3\27\3\27\5\27\u0130\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30" +
                    "\u0139\n\30\f\30\16\30\u013c\13\30\3\30\3\30\3\31\3\31\3\32\3\32\5\32" +
                    "\u0144\n\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u015d\n\33" +
                    "\3\34\3\34\3\35\3\35\5\35\u0163\n\35\3\36\3\36\3\36\7\36\u0168\n\36\f" +
                    "\36\16\36\u016b\13\36\3\37\3\37\3\37\7\37\u0170\n\37\f\37\16\37\u0173" +
                    "\13\37\3 \5 \u0176\n \3 \3 \3!\3!\3!\3!\3!\5!\u017f\n!\3\"\3\"\3#\3#\5" +
                    "#\u0185\n#\3$\3$\5$\u0189\n$\3%\3%\5%\u018d\n%\3&\3&\3\'\3\'\3(\3(\3)" +
                    "\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\5-\u01a1\n-\3-\5-\u01a4\n-\3-\5-\u01a7" +
                    "\n-\3.\3.\3/\3/\3/\3/\7/\u01af\n/\f/\16/\u01b2\13/\3/\3/\3\60\3\60\3\60" +
                    "\7\60\u01b9\n\60\f\60\16\60\u01bc\13\60\3\61\3\61\3\61\3\61\3\61\3\61" +
                    "\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61" +
                    "\u01d1\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01d9\n\62\3\63\3\63\3" +
                    "\63\3\63\7\63\u01df\n\63\f\63\16\63\u01e2\13\63\3\64\3\64\3\64\3\64\3" +
                    "\64\3\64\7\64\u01ea\n\64\f\64\16\64\u01ed\13\64\3\64\3\64\3\65\3\65\5" +
                    "\65\u01f3\n\65\3\66\3\66\3\66\5\66\u01f8\n\66\3\66\3\66\3\66\3\66\3\66" +
                    "\7\66\u01ff\n\66\f\66\16\66\u0202\13\66\3\66\5\66\u0205\n\66\3\67\3\67" +
                    "\3\67\3\67\38\38\38\38\38\58\u0210\n8\39\39\39\39\79\u0216\n9\f9\169\u0219" +
                    "\139\39\39\3:\3:\3:\3:\5:\u0221\n:\3;\3;\3;\3;\7;\u0227\n;\f;\16;\u022a" +
                    "\13;\3;\3;\3<\3<\3<\3<\3<\5<\u0233\n<\3=\3=\5=\u0237\n=\3>\3>\3>\3>\5" +
                    ">\u023d\n>\3>\3>\3?\3?\3?\3?\5?\u0245\n?\3?\3?\3?\3@\3@\3@\3@\7@\u024e" +
                    "\n@\f@\16@\u0251\13@\3@\3@\3A\3A\3A\3A\7A\u0259\nA\fA\16A\u025c\13A\3" +
                    "A\3A\3B\3B\3B\3B\5B\u0264\nB\3C\3C\3C\3C\2\2D\2\4\6\b\n\f\16\20\22\24" +
                    "\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv" +
                    "xz|~\u0080\u0082\u0084\2\b\3\2\22\26\3\2HM\3\2FG\3\2DE\3\2^_\4\2XX^^\2" +
                    "\u0276\2\u008d\3\2\2\2\4\u008f\3\2\2\2\6\u00a1\3\2\2\2\b\u00ab\3\2\2\2" +
                    "\n\u00ad\3\2\2\2\f\u00b6\3\2\2\2\16\u00c1\3\2\2\2\20\u00ca\3\2\2\2\22" +
                    "\u00d2\3\2\2\2\24\u00d8\3\2\2\2\26\u00dd\3\2\2\2\30\u00df\3\2\2\2\32\u00e2" +
                    "\3\2\2\2\34\u00e8\3\2\2\2\36\u00eb\3\2\2\2 \u00f5\3\2\2\2\"\u00fc\3\2" +
                    "\2\2$\u0104\3\2\2\2&\u0111\3\2\2\2(\u0117\3\2\2\2*\u012b\3\2\2\2,\u012d" +
                    "\3\2\2\2.\u0134\3\2\2\2\60\u013f\3\2\2\2\62\u0141\3\2\2\2\64\u015c\3\2" +
                    "\2\2\66\u015e\3\2\2\28\u0162\3\2\2\2:\u0164\3\2\2\2<\u016c\3\2\2\2>\u0175" +
                    "\3\2\2\2@\u017e\3\2\2\2B\u0180\3\2\2\2D\u0184\3\2\2\2F\u0188\3\2\2\2H" +
                    "\u018c\3\2\2\2J\u018e\3\2\2\2L\u0190\3\2\2\2N\u0192\3\2\2\2P\u0194\3\2" +
                    "\2\2R\u0196\3\2\2\2T\u0198\3\2\2\2V\u019a\3\2\2\2X\u019c\3\2\2\2Z\u01a8" +
                    "\3\2\2\2\\\u01aa\3\2\2\2^\u01b5\3\2\2\2`\u01d0\3\2\2\2b\u01d8\3\2\2\2" +
                    "d\u01da\3\2\2\2f\u01e3\3\2\2\2h\u01f0\3\2\2\2j\u01f4\3\2\2\2l\u0206\3" +
                    "\2\2\2n\u020f\3\2\2\2p\u0211\3\2\2\2r\u0220\3\2\2\2t\u0222\3\2\2\2v\u0232" +
                    "\3\2\2\2x\u0234\3\2\2\2z\u0238\3\2\2\2|\u0240\3\2\2\2~\u0249\3\2\2\2\u0080" +
                    "\u0254\3\2\2\2\u0082\u025f\3\2\2\2\u0084\u0265\3\2\2\2\u0086\u008e\5\4" +
                    "\3\2\u0087\u008e\5X-\2\u0088\u008e\5|?\2\u0089\u008e\5h\65\2\u008a\u008e" +
                    "\5x=\2\u008b\u008e\5\u0082B\2\u008c\u008e\5\u0084C\2\u008d\u0086\3\2\2" +
                    "\2\u008d\u0087\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008a" +
                    "\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\3\3\2\2\2\u008f" +
                    "\u0091\7\3\2\2\u0090\u0092\7\17\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3" +
                    "\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\5\6\4\2\u0094\u0096\5\n\6\2\u0095" +
                    "\u0097\5\30\r\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3" +
                    "\2\2\2\u0098\u009a\5\32\16\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a" +
                    "\u009c\3\2\2\2\u009b\u009d\5\36\20\2\u009c\u009b\3\2\2\2\u009c\u009d\3" +
                    "\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\5\22\n\2\u009f\u009e\3\2\2\2\u009f" +
                    "\u00a0\3\2\2\2\u00a0\5\3\2\2\2\u00a1\u00a6\5\b\5\2\u00a2\u00a3\7S\2\2" +
                    "\u00a3\u00a5\5\b\5\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4" +
                    "\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\7\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9" +
                    "\u00ac\5\20\t\2\u00aa\u00ac\5\24\13\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa" +
                    "\3\2\2\2\u00ac\t\3\2\2\2\u00ad\u00ae\7\b\2\2\u00ae\u00b3\5\f\7\2\u00af" +
                    "\u00b0\7S\2\2\u00b0\u00b2\5\f\7\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2" +
                    "\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\13\3\2\2\2\u00b5\u00b3" +
                    "\3\2\2\2\u00b6\u00b8\5L\'\2\u00b7\u00b9\7\t\2\2\u00b8\u00b7\3\2\2\2\u00b8" +
                    "\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00be\5V,\2\u00bb\u00bd\5\16" +
                    "\b\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be" +
                    "\u00bf\3\2\2\2\u00bf\r\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\r\2\2" +
                    "\u00c2\u00c4\5L\'\2\u00c3\u00c5\7\t\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5" +
                    "\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\5V,\2\u00c7\u00c8\7@\2\2\u00c8" +
                    "\u00c9\5\"\22\2\u00c9\17\3\2\2\2\u00ca\u00cf\5V,\2\u00cb\u00cc\7N\2\2" +
                    "\u00cc\u00ce\5T+\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd" +
                    "\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\21\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2" +
                    "\u00d3\7=\2\2\u00d3\u00d6\7^\2\2\u00d4\u00d5\7S\2\2\u00d5\u00d7\7^\2\2" +
                    "\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\23\3\2\2\2\u00d8\u00d9" +
                    "\5\26\f\2\u00d9\u00da\7O\2\2\u00da\u00db\5\20\t\2\u00db\u00dc\7P\2\2\u00dc" +
                    "\25\3\2\2\2\u00dd\u00de\t\2\2\2\u00de\27\3\2\2\2\u00df\u00e0\7\27\2\2" +
                    "\u00e0\u00e1\5\"\22\2\u00e1\31\3\2\2\2\u00e2\u00e3\7\30\2\2\u00e3\u00e4" +
                    "\7\31\2\2\u00e4\u00e6\5\20\t\2\u00e5\u00e7\5\34\17\2\u00e6\u00e5\3\2\2" +
                    "\2\u00e6\u00e7\3\2\2\2\u00e7\33\3\2\2\2\u00e8\u00e9\7\33\2\2\u00e9\u00ea" +
                    "\5\"\22\2\u00ea\35\3\2\2\2\u00eb\u00ec\7\32\2\2\u00ec\u00ed\7\31\2\2\u00ed" +
                    "\u00f2\5 \21\2\u00ee\u00ef\7S\2\2\u00ef\u00f1\5 \21\2\u00f0\u00ee\3\2" +
                    "\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3" +
                    "\37\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00fa\5\20\t\2\u00f6\u00f8\7\35" +
                    "\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9" +
                    "\u00fb\7\34\2\2\u00fa\u00f7\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb!\3\2\2\2" +
                    "\u00fc\u0101\5$\23\2\u00fd\u00fe\7%\2\2\u00fe\u0100\5$\23\2\u00ff\u00fd" +
                    "\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102" +
                    "#\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0109\5&\24\2\u0105\u0106\7$\2\2\u0106" +
                    "\u0108\5&\24\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2" +
                    "\2\2\u0109\u010a\3\2\2\2\u010a%\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0112" +
                    "\5(\25\2\u010d\u010e\7O\2\2\u010e\u010f\5\"\22\2\u010f\u0110\7P\2\2\u0110" +
                    "\u0112\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0112\'\3\2\2\2" +
                    "\u0113\u0118\5\64\33\2\u0114\u0118\5*\26\2\u0115\u0118\5\62\32\2\u0116" +
                    "\u0118\5,\27\2\u0117\u0113\3\2\2\2\u0117\u0114\3\2\2\2\u0117\u0115\3\2" +
                    "\2\2\u0117\u0116\3\2\2\2\u0118)\3\2\2\2\u0119\u011b\58\35\2\u011a\u011c" +
                    "\7\36\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2" +
                    "\u011d\u011e\7 \2\2\u011e\u011f\58\35\2\u011f\u0120\7$\2\2\u0120\u0121" +
                    "\58\35\2\u0121\u012c\3\2\2\2\u0122\u0124\5B\"\2\u0123\u0125\7\36\2\2\u0124" +
                    "\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\7 " +
                    "\2\2\u0127\u0128\5B\"\2\u0128\u0129\7$\2\2\u0129\u012a\5B\"\2\u012a\u012c" +
                    "\3\2\2\2\u012b\u0119\3\2\2\2\u012b\u0122\3\2\2\2\u012c+\3\2\2\2\u012d" +
                    "\u012f\5\20\t\2\u012e\u0130\7\36\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3" +
                    "\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\7\'\2\2\u0132\u0133\5.\30\2\u0133" +
                    "-\3\2\2\2\u0134\u0135\7O\2\2\u0135\u013a\5\60\31\2\u0136\u0137\7S\2\2" +
                    "\u0137\u0139\5\60\31\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138" +
                    "\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d" +
                    "\u013e\7P\2\2\u013e/\3\2\2\2\u013f\u0140\5R*\2\u0140\61\3\2\2\2\u0141" +
                    "\u0143\5B\"\2\u0142\u0144\7\36\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2" +
                    "\2\2\u0144\u0145\3\2\2\2\u0145\u0146\7&\2\2\u0146\u0147\5N(\2\u0147\63" +
                    "\3\2\2\2\u0148\u0149\5B\"\2\u0149\u014a\5\66\34\2\u014a\u014b\5B\"\2\u014b" +
                    "\u015d\3\2\2\2\u014c\u014d\58\35\2\u014d\u014e\5\66\34\2\u014e\u014f\5" +
                    "8\35\2\u014f\u015d\3\2\2\2\u0150\u0151\5\24\13\2\u0151\u0152\5\66\34\2" +
                    "\u0152\u0153\58\35\2\u0153\u015d\3\2\2\2\u0154\u0155\5F$\2\u0155\u0156" +
                    "\5\66\34\2\u0156\u0157\5F$\2\u0157\u015d\3\2\2\2\u0158\u0159\5H%\2\u0159" +
                    "\u015a\5\66\34\2\u015a\u015b\5H%\2\u015b\u015d\3\2\2\2\u015c\u0148\3\2" +
                    "\2\2\u015c\u014c\3\2\2\2\u015c\u0150\3\2\2\2\u015c\u0154\3\2\2\2\u015c" +
                    "\u0158\3\2\2\2\u015d\65\3\2\2\2\u015e\u015f\t\3\2\2\u015f\67\3\2\2\2\u0160" +
                    "\u0163\5\20\t\2\u0161\u0163\5:\36\2\u0162\u0160\3\2\2\2\u0162\u0161\3" +
                    "\2\2\2\u01639\3\2\2\2\u0164\u0169\5<\37\2\u0165\u0166\t\4\2\2\u0166\u0168" +
                    "\5<\37\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169" +
                    "\u016a\3\2\2\2\u016a;\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u0171\5> \2\u016d" +
                    "\u016e\t\5\2\2\u016e\u0170\5> \2\u016f\u016d\3\2\2\2\u0170\u0173\3\2\2" +
                    "\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172=\3\2\2\2\u0173\u0171" +
                    "\3\2\2\2\u0174\u0176\t\4\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176" +
                    "\u0177\3\2\2\2\u0177\u0178\5@!\2\u0178?\3\2\2\2\u0179\u017f\5P)\2\u017a" +
                    "\u017b\7O\2\2\u017b\u017c\5:\36\2\u017c\u017d\7P\2\2\u017d\u017f\3\2\2" +
                    "\2\u017e\u0179\3\2\2\2\u017e\u017a\3\2\2\2\u017fA\3\2\2\2\u0180\u0181" +
                    "\5D#\2\u0181C\3\2\2\2\u0182\u0185\5\20\t\2\u0183\u0185\5J&\2\u0184\u0182" +
                    "\3\2\2\2\u0184\u0183\3\2\2\2\u0185E\3\2\2\2\u0186\u0189\5\20\t\2\u0187" +
                    "\u0189\5t;\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189G\3\2\2\2\u018a" +
                    "\u018d\5\20\t\2\u018b\u018d\5p9\2\u018c\u018a\3\2\2\2\u018c\u018b\3\2" +
                    "\2\2\u018dI\3\2\2\2\u018e\u018f\7W\2\2\u018fK\3\2\2\2\u0190\u0191\7X\2" +
                    "\2\u0191M\3\2\2\2\u0192\u0193\7X\2\2\u0193O\3\2\2\2\u0194\u0195\t\6\2" +
                    "\2\u0195Q\3\2\2\2\u0196\u0197\7X\2\2\u0197S\3\2\2\2\u0198\u0199\t\7\2" +
                    "\2\u0199U\3\2\2\2\u019a\u019b\7X\2\2\u019bW\3\2\2\2\u019c\u019d\7\4\2" +
                    "\2\u019d\u019e\79\2\2\u019e\u01a0\5Z.\2\u019f\u01a1\5\\/\2\u01a0\u019f" +
                    "\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a4\5d\63\2\u01a3" +
                    "\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a7\5f" +
                    "\64\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7Y\3\2\2\2\u01a8\u01a9" +
                    "\7X\2\2\u01a9[\3\2\2\2\u01aa\u01ab\7O\2\2\u01ab\u01b0\5^\60\2\u01ac\u01ad" +
                    "\7S\2\2\u01ad\u01af\5^\60\2\u01ae\u01ac\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0" +
                    "\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2" +
                    "\2\2\u01b3\u01b4\7P\2\2\u01b4]\3\2\2\2\u01b5\u01b6\7X\2\2\u01b6\u01ba" +
                    "\5`\61\2\u01b7\u01b9\5b\62\2\u01b8\u01b7\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba" +
                    "\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb_\3\2\2\2\u01bc\u01ba\3\2\2\2" +
                    "\u01bd\u01d1\7\64\2\2\u01be\u01d1\7\65\2\2\u01bf\u01c0\7\66\2\2\u01c0" +
                    "\u01c1\7O\2\2\u01c1\u01c2\7^\2\2\u01c2\u01d1\7P\2\2\u01c3\u01c4\7,\2\2" +
                    "\u01c4\u01c5\7O\2\2\u01c5\u01c6\5`\61\2\u01c6\u01c7\7S\2\2\u01c7\u01c8" +
                    "\7^\2\2\u01c8\u01c9\7P\2\2\u01c9\u01d1\3\2\2\2\u01ca\u01cb\78\2\2\u01cb" +
                    "\u01cc\7O\2\2\u01cc\u01cd\7X\2\2\u01cd\u01d1\7P\2\2\u01ce\u01cf\7\20\2" +
                    "\2\u01cf\u01d1\5\\/\2\u01d0\u01bd\3\2\2\2\u01d0\u01be\3\2\2\2\u01d0\u01bf" +
                    "\3\2\2\2\u01d0\u01c3\3\2\2\2\u01d0\u01ca\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1" +
                    "a\3\2\2\2\u01d2\u01d9\7;\2\2\u01d3\u01d4\7*\2\2\u01d4\u01d9\7+\2\2\u01d5" +
                    "\u01d6\7<\2\2\u01d6\u01d9\7+\2\2\u01d7\u01d9\7C\2\2\u01d8\u01d2\3\2\2" +
                    "\2\u01d8\u01d3\3\2\2\2\u01d8\u01d5\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9c" +
                    "\3\2\2\2\u01da\u01db\7-\2\2\u01db\u01e0\7X\2\2\u01dc\u01dd\7S\2\2\u01dd" +
                    "\u01df\7X\2\2\u01de\u01dc\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0\u01de\3\2" +
                    "\2\2\u01e0\u01e1\3\2\2\2\u01e1e\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e3\u01e4" +
                    "\7*\2\2\u01e4\u01e5\7+\2\2\u01e5\u01e6\7O\2\2\u01e6\u01eb\5\20\t\2\u01e7" +
                    "\u01e8\7S\2\2\u01e8\u01ea\5\20\t\2\u01e9\u01e7\3\2\2\2\u01ea\u01ed\3\2" +
                    "\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed" +
                    "\u01eb\3\2\2\2\u01ee\u01ef\7P\2\2\u01efg\3\2\2\2\u01f0\u01f2\5j\66\2\u01f1" +
                    "\u01f3\5\30\r\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3i\3\2\2\2" +
                    "\u01f4\u01f5\7\5\2\2\u01f5\u01f7\5L\'\2\u01f6\u01f8\7\t\2\2\u01f7\u01f6" +
                    "\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\5V,\2\u01fa" +
                    "\u01fb\7\37\2\2\u01fb\u0200\5l\67\2\u01fc\u01fd\7S\2\2\u01fd\u01ff\5l" +
                    "\67\2\u01fe\u01fc\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200" +
                    "\u0201\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0205\5\30" +
                    "\r\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205k\3\2\2\2\u0206\u0207" +
                    "\5\20\t\2\u0207\u0208\7H\2\2\u0208\u0209\5n8\2\u0209m\3\2\2\2\u020a\u0210" +
                    "\5:\36\2\u020b\u0210\5D#\2\u020c\u0210\5t;\2\u020d\u0210\5p9\2\u020e\u0210" +
                    "\7\"\2\2\u020f\u020a\3\2\2\2\u020f\u020b\3\2\2\2\u020f\u020c\3\2\2\2\u020f" +
                    "\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210o\3\2\2\2\u0211\u0212\7Q\2\2\u0212" +
                    "\u0217\5r:\2\u0213\u0214\7S\2\2\u0214\u0216\5r:\2\u0215\u0213\3\2\2\2" +
                    "\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u021a" +
                    "\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021b\7R\2\2\u021bq\3\2\2\2\u021c\u021d" +
                    "\7^\2\2\u021d\u021e\7U\2\2\u021e\u0221\5n8\2\u021f\u0221\5n8\2\u0220\u021c" +
                    "\3\2\2\2\u0220\u021f\3\2\2\2\u0221s\3\2\2\2\u0222\u0223\7O\2\2\u0223\u0228" +
                    "\5v<\2\u0224\u0225\7S\2\2\u0225\u0227\5v<\2\u0226\u0224\3\2\2\2\u0227" +
                    "\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022b\3\2" +
                    "\2\2\u022a\u0228\3\2\2\2\u022b\u022c\7P\2\2\u022cu\3\2\2\2\u022d\u022e" +
                    "\5\20\t\2\u022e\u022f\7U\2\2\u022f\u0230\5n8\2\u0230\u0233\3\2\2\2\u0231" +
                    "\u0233\5n8\2\u0232\u022d\3\2\2\2\u0232\u0231\3\2\2\2\u0233w\3\2\2\2\u0234" +
                    "\u0236\5z>\2\u0235\u0237\5\30\r\2\u0236\u0235\3\2\2\2\u0236\u0237\3\2" +
                    "\2\2\u0237y\3\2\2\2\u0238\u0239\7\6\2\2\u0239\u023a\7\b\2\2\u023a\u023c" +
                    "\5L\'\2\u023b\u023d\7\t\2\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d" +
                    "\u023e\3\2\2\2\u023e\u023f\5V,\2\u023f{\3\2\2\2\u0240\u0241\7\7\2\2\u0241" +
                    "\u0242\7(\2\2\u0242\u0244\5Z.\2\u0243\u0245\5~@\2\u0244\u0243\3\2\2\2" +
                    "\u0244\u0245\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\7)\2\2\u0247\u0248" +
                    "\5\u0080A\2\u0248}\3\2\2\2\u0249\u024a\7O\2\2\u024a\u024f\5\20\t\2\u024b" +
                    "\u024c\7S\2\2\u024c\u024e\5\20\t\2\u024d\u024b\3\2\2\2\u024e\u0251\3\2" +
                    "\2\2\u024f\u024d\3\2\2\2\u024f\u0250\3\2\2\2\u0250\u0252\3\2\2\2\u0251" +
                    "\u024f\3\2\2\2\u0252\u0253\7P\2\2\u0253\177\3\2\2\2\u0254\u0255\7O\2\2" +
                    "\u0255\u025a\5n8\2\u0256\u0257\7S\2\2\u0257\u0259\5n8\2\u0258\u0256\3" +
                    "\2\2\2\u0259\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025b" +
                    "\u025d\3\2\2\2\u025c\u025a\3\2\2\2\u025d\u025e\7P\2\2\u025e\u0081\3\2" +
                    "\2\2\u025f\u0260\7>\2\2\u0260\u0261\79\2\2\u0261\u0263\7X\2\2\u0262\u0264" +
                    "\7?\2\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0083\3\2\2\2\u0265" +
                    "\u0266\7A\2\2\u0266\u0267\7B\2\2\u0267\u0085\3\2\2\2?\u008d\u0091\u0096" +
                    "\u0099\u009c\u009f\u00a6\u00ab\u00b3\u00b8\u00be\u00c4\u00cf\u00d6\u00e6" +
                    "\u00f2\u00f7\u00fa\u0101\u0109\u0111\u0117\u011b\u0124\u012b\u012f\u013a" +
                    "\u0143\u015c\u0162\u0169\u0171\u0175\u017e\u0184\u0188\u018c\u01a0\u01a3" +
                    "\u01a6\u01b0\u01ba\u01d0\u01d8\u01e0\u01eb\u01f2\u01f7\u0200\u0204\u020f" +
                    "\u0217\u0220\u0228\u0232\u0236\u023c\u0244\u024f\u025a\u0263";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}