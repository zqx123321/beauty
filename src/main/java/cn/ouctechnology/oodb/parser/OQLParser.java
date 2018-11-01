// Generated from D:/杂乱文件终章/oodb/src/test/java\OQL.g4 by ANTLR 4.7
package cn.ouctechnology.oodb.parser;

import cn.ouctechnology.oodb.execute.*;
import cn.ouctechnology.oodb.util.OgnlUtil;
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
            UNIQUE = 57, LIMIT = 58, DROP = 59, CASCADE = 60, ON = 61, SHOW = 62, DATABASES = 63,
            MUL = 64, DIV = 65, PLUS = 66, MINUS = 67, EQ = 68, GR = 69, LS = 70, GE = 71, LE = 72,
            NE = 73, DOT = 74, LBRACKET = 75, RBRACKET = 76, COMMA = 77, SEMI = 78, COLON = 79,
            TRIMCHARACTER = 80, STRINGLITERAL = 81, WORD = 82, NAMEDPARAMETER = 83, WS = 84,
            COMMENT = 85, LINECOMMENT = 86, ESCAPECHARACTER = 87, INTNUMERAL = 88, FLOATNUMERAL = 89;
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
            RULE_stringPrimary = 33, RULE_stringLiteralExpr = 34, RULE_schemaName = 35,
            RULE_patternValue = 36, RULE_numericLiteral = 37, RULE_literal = 38, RULE_field = 39,
            RULE_id = 40, RULE_createStat = 41, RULE_tableName = 42, RULE_columnDefinition = 43,
            RULE_columnDefinitionItem = 44, RULE_columnType = 45, RULE_columnConstraint = 46,
            RULE_extendsTable = 47, RULE_tableConstraint = 48, RULE_updateStat = 49,
            RULE_updateClause = 50, RULE_updateItem = 51, RULE_newValue = 52, RULE_insertEntityExpr = 53,
            RULE_insertEntityItem = 54, RULE_deleteStat = 55, RULE_deleteClause = 56,
            RULE_insertStat = 57, RULE_columnList = 58, RULE_insertValue = 59, RULE_dropStat = 60,
            RULE_showStat = 61;
    public static final String[] ruleNames = {
            "oqlStat", "selectStat", "selectClause", "selectExpr", "fromClause", "fromItem",
            "join", "pathExpr", "limitClause", "aggregateExpr", "aggregateExprFunctionName",
            "whereClause", "groupByClause", "havingClause", "orderByClause", "orderByItem",
            "conditionalExpr", "conditionalTerm", "conditionalFactor", "simpleCondExpr",
            "betweenExpr", "inExpr", "inExprRightPart", "inItem", "likeExpr", "comparisonExpr",
            "comparisonOperator", "arithmeticExpr", "simpleArithmeticExpr", "arithmeticTerm",
            "arithmeticFactor", "arithmeticPrimary", "stringExpr", "stringPrimary",
            "stringLiteralExpr", "schemaName", "patternValue", "numericLiteral", "literal",
            "field", "id", "createStat", "tableName", "columnDefinition", "columnDefinitionItem",
            "columnType", "columnConstraint", "extendsTable", "tableConstraint", "updateStat",
            "updateClause", "updateItem", "newValue", "insertEntityExpr", "insertEntityItem",
            "deleteStat", "deleteClause", "insertStat", "columnList", "insertValue",
            "dropStat", "showStat"
    };

    private static final String[] _LITERAL_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", "'>'", "'<'",
            "'>='", "'<='", null, "'.'", "'('", "')'", "','", "';'", "':'", "''.''"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "SELECT", "CREATE", "UPDATE", "DELETE", "INSERT", "FROM", "AS",
            "LEFT", "RIGHT", "OUTER", "JOIN", "INNER", "DISTINCT", "OBJECT", "NEW",
            "AVG", "SUM", "MAX", "MIN", "COUNT", "WHERE", "GROUP", "BY", "ORDER",
            "HAVING", "DESC", "ASC", "NOT", "BETWEEN", "IS", "NULL", "ESCAPE", "AND",
            "OR", "LIKE", "IN", "INTO", "VALUES", "PRIMARY", "KEY", "SET", "EXTENDS",
            "EMPTY", "MEMBER", "OF", "ALL", "ANY", "SOME", "INT", "FLOAT", "CHAR",
            "SETOF", "REF", "TABLE", "EXISTS", "AUTO_INCREMENT", "UNIQUE", "LIMIT",
            "DROP", "CASCADE", "ON", "SHOW", "DATABASES", "MUL", "DIV", "PLUS", "MINUS",
            "EQ", "GR", "LS", "GE", "LE", "NE", "DOT", "LBRACKET", "RBRACKET", "COMMA",
            "SEMI", "COLON", "TRIMCHARACTER", "STRINGLITERAL", "WORD", "NAMEDPARAMETER",
            "WS", "COMMENT", "LINECOMMENT", "ESCAPECHARACTER", "INTNUMERAL", "FLOATNUMERAL"
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
            setState(131);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SELECT:
                    _localctx = new SelectStatementContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(124);
                    selectStat();
                }
                break;
                case CREATE:
                    _localctx = new CreateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(125);
                    createStat();
                }
                break;
                case INSERT:
                    _localctx = new InsertStatementContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(126);
                    insertStat();
                }
                break;
                case UPDATE:
                    _localctx = new UpdateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(127);
                    updateStat();
                }
                break;
                case DELETE:
                    _localctx = new DeleteStatementContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(128);
                    deleteStat();
                }
                break;
                case DROP:
                    _localctx = new DropStatementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(129);
                    dropStat();
                }
                break;
                case SHOW:
                    _localctx = new ShowStatementContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(130);
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
                setState(133);
                match(SELECT);
                setState(134);
                selectClause();
                setState(135);
                fromClause();
                setState(137);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(136);
                        whereClause();
                    }
                }

                setState(140);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GROUP) {
                    {
                        setState(139);
                        groupByClause();
                    }
                }

                setState(143);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HAVING) {
                    {
                        setState(142);
                        havingClause();
                    }
                }

                setState(146);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ORDER) {
                    {
                        setState(145);
                        orderByClause();
                    }
                }

                setState(149);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(148);
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
                setState(151);
                selectExpr();
                setState(156);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(152);
                            match(COMMA);
                            setState(153);
                            selectExpr();
                        }
                    }
                    setState(158);
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
            setState(161);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new SelectPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(159);
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
                    setState(160);
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
                setState(163);
                match(FROM);
                setState(164);
                fromItem();
                setState(169);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(165);
                            match(COMMA);
                            setState(166);
                            fromItem();
                        }
                    }
                    setState(171);
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
                setState(172);
                schemaName();
                setState(174);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(173);
                        match(AS);
                    }
                }

                setState(176);
                id();
                setState(180);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == JOIN) {
                    {
                        {
                            setState(177);
                            join();
                        }
                    }
                    setState(182);
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
                setState(183);
                match(JOIN);
                setState(184);
                schemaName();
                setState(186);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(185);
                        match(AS);
                    }
                }

                setState(188);
                id();
                setState(189);
                match(ON);
                setState(190);
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
                setState(192);
                id();
                setState(197);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(193);
                            match(DOT);
                            setState(194);
                            field();
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
                setState(200);
                match(LIMIT);
                setState(201);
                match(INTNUMERAL);
                setState(204);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(202);
                        match(COMMA);
                        setState(203);
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
                setState(206);
                aggregateExprFunctionName();
                setState(207);
                match(LBRACKET);
                setState(208);
                pathExpr();
                setState(209);
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
                setState(211);
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
                setState(213);
                match(WHERE);
                setState(214);
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
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(216);
                match(GROUP);
                setState(217);
                match(BY);
                setState(218);
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
                setState(220);
                match(HAVING);
                setState(221);
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
                setState(223);
                match(ORDER);
                setState(224);
                match(BY);
                setState(225);
                orderByItem();
                setState(230);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(226);
                            match(COMMA);
                            setState(227);
                            orderByItem();
                        }
                    }
                    setState(232);
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
                setState(233);
                pathExpr();
                setState(238);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case EOF:
                    case ASC:
                    case LIMIT:
                    case COMMA: {
                        setState(235);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == ASC) {
                            {
                                setState(234);
                                match(ASC);
                            }
                        }

                    }
                    break;
                    case DESC: {
                        setState(237);
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
                    setState(240);
                    conditionalTerm();
                }
                setState(245);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(241);
                            match(OR);
                            setState(242);
                            conditionalTerm();
                        }
                    }
                    setState(247);
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
                    setState(248);
                    conditionalFactor();
                }
                setState(253);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(249);
                            match(AND);
                            setState(250);
                            conditionalFactor();
                        }
                    }
                    setState(255);
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
            setState(261);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                case 1:
                    _localctx = new ConditionalFactorSimpleCondExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(256);
                    simpleCondExpr();
                }
                break;
                case 2:
                    _localctx = new ConditionalFactorExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(257);
                    match(LBRACKET);
                    setState(258);
                    conditionalExpr();
                    setState(259);
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
            setState(267);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                case 1:
                    _localctx = new SimpleComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(263);
                    comparisonExpr();
                }
                break;
                case 2:
                    _localctx = new SimpleBetweenExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(264);
                    betweenExpr();
                }
                break;
                case 3:
                    _localctx = new SimpleLikeExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(265);
                    likeExpr();
                }
                break;
                case 4:
                    _localctx = new SimpleInExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(266);
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
            setState(287);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                case 1:
                    _localctx = new BetweenArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(269);
                    arithmeticExpr();
                    setState(271);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(270);
                            match(NOT);
                        }
                    }

                    setState(273);
                    match(BETWEEN);
                    setState(274);
                    arithmeticExpr();
                    setState(275);
                    match(AND);
                    setState(276);
                    arithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new BetweenStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(278);
                    stringExpr();
                    setState(280);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(279);
                            match(NOT);
                        }
                    }

                    setState(282);
                    match(BETWEEN);
                    setState(283);
                    stringExpr();
                    setState(284);
                    match(AND);
                    setState(285);
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
                setState(289);
                pathExpr();
                setState(291);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(290);
                        match(NOT);
                    }
                }

                setState(293);
                match(IN);
                setState(294);
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
                setState(296);
                match(LBRACKET);
                setState(297);
                inItem();
                setState(302);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(298);
                            match(COMMA);
                            setState(299);
                            inItem();
                        }
                    }
                    setState(304);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(305);
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
                setState(307);
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
                setState(309);
                stringExpr();
                setState(311);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(310);
                        match(NOT);
                    }
                }

                setState(313);
                match(LIKE);
                setState(314);
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
            setState(328);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
                case 1:
                    _localctx = new ComparisonStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(316);
                    stringExpr();
                    setState(317);
                    comparisonOperator();
                    setState(318);
                    stringExpr();
                }
                break;
                case 2:
                    _localctx = new ComparisonArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(320);
                    arithmeticExpr();
                    setState(321);
                    comparisonOperator();
                    setState(322);
                    arithmeticExpr();
                }
                break;
                case 3:
                    _localctx = new ComparisonAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(324);
                    aggregateExpr();
                    setState(325);
                    comparisonOperator();
                    setState(326);
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
        enterRule(_localctx, 52, RULE_comparisonOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(330);
                _la = _input.LA(1);
                if (!(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (EQ - 68)) | (1L << (GR - 68)) | (1L << (LS - 68)) | (1L << (GE - 68)) | (1L << (LE - 68)) | (1L << (NE - 68)))) != 0))) {
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
            setState(334);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ArithmeticPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(332);
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
                    setState(333);
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
                    setState(336);
                    arithmeticTerm();
                }
                setState(341);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PLUS || _la == MINUS) {
                    {
                        {
                            setState(337);
                            _la = _input.LA(1);
                            if (!(_la == PLUS || _la == MINUS)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(338);
                            arithmeticTerm();
                        }
                    }
                    setState(343);
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
                    setState(344);
                    arithmeticFactor();
                }
                setState(349);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == MUL || _la == DIV) {
                    {
                        {
                            setState(345);
                            _la = _input.LA(1);
                            if (!(_la == MUL || _la == DIV)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(346);
                            arithmeticFactor();
                        }
                    }
                    setState(351);
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
                setState(353);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PLUS || _la == MINUS) {
                    {
                        setState(352);
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

                setState(355);
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
            setState(362);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new AriPriNumericLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(357);
                    numericLiteral();
                }
                break;
                case LBRACKET:
                    _localctx = new AriPriSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(358);
                    match(LBRACKET);
                    setState(359);
                    simpleArithmeticExpr();
                    setState(360);
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
                setState(364);
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
            setState(368);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new StringPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(366);
                    pathExpr();
                }
                break;
                case STRINGLITERAL:
                    _localctx = new StringLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(367);
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
        enterRule(_localctx, 68, RULE_stringLiteralExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(370);
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
        enterRule(_localctx, 70, RULE_schemaName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(372);
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
        enterRule(_localctx, 72, RULE_patternValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(374);
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
        enterRule(_localctx, 74, RULE_numericLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(376);
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
        enterRule(_localctx, 76, RULE_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(378);
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
        enterRule(_localctx, 78, RULE_field);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(380);
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
        enterRule(_localctx, 80, RULE_id);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(382);
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
        enterRule(_localctx, 82, RULE_createStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(384);
                match(CREATE);
                setState(385);
                match(TABLE);
                setState(386);
                tableName();
                setState(388);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(387);
                        columnDefinition();
                    }
                }

                setState(391);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EXTENDS) {
                    {
                        setState(390);
                        extendsTable();
                    }
                }

                setState(394);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PRIMARY) {
                    {
                        setState(393);
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
        enterRule(_localctx, 84, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(396);
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
        enterRule(_localctx, 86, RULE_columnDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(398);
                match(LBRACKET);
                setState(399);
                columnDefinitionItem();
                setState(404);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(400);
                            match(COMMA);
                            setState(401);
                            columnDefinitionItem();
                        }
                    }
                    setState(406);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(407);
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
        enterRule(_localctx, 88, RULE_columnDefinitionItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(409);
                match(WORD);
                setState(410);
                columnType();
                setState(414);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIMARY) | (1L << AUTO_INCREMENT) | (1L << UNIQUE))) != 0)) {
                    {
                        {
                            setState(411);
                            columnConstraint();
                        }
                    }
                    setState(416);
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
        enterRule(_localctx, 90, RULE_columnType);
        try {
            setState(432);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(417);
                    match(INT);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(418);
                    match(FLOAT);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(419);
                    match(CHAR);
                    setState(420);
                    match(LBRACKET);
                    setState(421);
                    match(INTNUMERAL);
                    setState(422);
                    match(RBRACKET);
                }
                break;
                case SETOF:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(423);
                    match(SETOF);
                    setState(424);
                    match(LBRACKET);
                    setState(425);
                    columnType();
                    setState(426);
                    match(RBRACKET);
                }
                break;
                case REF:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(428);
                    match(REF);
                    setState(429);
                    match(LBRACKET);
                    setState(430);
                    match(WORD);
                    setState(431);
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
        enterRule(_localctx, 92, RULE_columnConstraint);
        try {
            setState(439);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(434);
                    match(AUTO_INCREMENT);
                }
                break;
                case PRIMARY:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(435);
                    match(PRIMARY);
                    setState(436);
                    match(KEY);
                }
                break;
                case UNIQUE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(437);
                    match(UNIQUE);
                    setState(438);
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
        enterRule(_localctx, 94, RULE_extendsTable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(441);
                match(EXTENDS);
                setState(442);
                match(WORD);
                setState(447);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(443);
                            match(COMMA);
                            setState(444);
                            match(WORD);
                        }
                    }
                    setState(449);
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
        enterRule(_localctx, 96, RULE_tableConstraint);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(450);
                match(PRIMARY);
                setState(451);
                match(KEY);
                setState(452);
                match(LBRACKET);
                setState(453);
                pathExpr();
                setState(458);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(454);
                            match(COMMA);
                            setState(455);
                            pathExpr();
                        }
                    }
                    setState(460);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(461);
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
        enterRule(_localctx, 98, RULE_updateStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(463);
                updateClause();
                setState(465);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(464);
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
        enterRule(_localctx, 100, RULE_updateClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(467);
                match(UPDATE);
                setState(468);
                schemaName();
                setState(470);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(469);
                        match(AS);
                    }
                }

                setState(472);
                id();
                setState(473);
                match(SET);
                setState(474);
                updateItem();
                setState(479);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(475);
                            match(COMMA);
                            setState(476);
                            updateItem();
                        }
                    }
                    setState(481);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(483);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 46, _ctx)) {
                    case 1: {
                        setState(482);
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
        enterRule(_localctx, 102, RULE_updateItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(485);
                pathExpr();
                setState(486);
                match(EQ);
                setState(487);
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
            throw new UnsupportedOperationException("the methon is not implemented");
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
            return getText().replaceAll("'", "");
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
        enterRule(_localctx, 104, RULE_newValue);
        try {
            setState(493);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 47, _ctx)) {
                case 1:
                    _localctx = new NewSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(489);
                    simpleArithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new NewStringPrimaryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(490);
                    stringPrimary();
                }
                break;
                case 3:
                    _localctx = new NewSimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(491);
                    insertEntityExpr();
                }
                break;
                case 4:
                    _localctx = new NewNullContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(492);
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
        enterRule(_localctx, 106, RULE_insertEntityExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(495);
                match(LBRACKET);
                setState(496);
                insertEntityItem();
                setState(501);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(497);
                            match(COMMA);
                            setState(498);
                            insertEntityItem();
                        }
                    }
                    setState(503);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(504);
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
        enterRule(_localctx, 108, RULE_insertEntityItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(506);
                pathExpr();
                setState(507);
                match(COLON);
                setState(508);
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
        enterRule(_localctx, 110, RULE_deleteStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(510);
                deleteClause();
                setState(512);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(511);
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
        enterRule(_localctx, 112, RULE_deleteClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(514);
                match(DELETE);
                setState(515);
                match(FROM);
                setState(516);
                schemaName();
                setState(518);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(517);
                        match(AS);
                    }
                }

                setState(520);
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
        enterRule(_localctx, 114, RULE_insertStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(522);
                match(INSERT);
                setState(523);
                match(INTO);
                setState(524);
                tableName();
                setState(526);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(525);
                        columnList();
                    }
                }

                setState(528);
                match(VALUES);
                setState(529);
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
        enterRule(_localctx, 116, RULE_columnList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(531);
                match(LBRACKET);
                setState(532);
                pathExpr();
                setState(537);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(533);
                            match(COMMA);
                            setState(534);
                            pathExpr();
                        }
                    }
                    setState(539);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(540);
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
        enterRule(_localctx, 118, RULE_insertValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(542);
                match(LBRACKET);
                setState(543);
                newValue();
                setState(548);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(544);
                            match(COMMA);
                            setState(545);
                            newValue();
                        }
                    }
                    setState(550);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(551);
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
        enterRule(_localctx, 120, RULE_dropStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(553);
                match(DROP);
                setState(554);
                match(TABLE);
                setState(555);
                match(WORD);
                setState(557);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CASCADE) {
                    {
                        setState(556);
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
        enterRule(_localctx, 122, RULE_showStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(559);
                match(SHOW);
                setState(560);
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
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3[\u0235\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0086\n\2\3\3\3\3\3\3\3\3" +
                    "\5\3\u008c\n\3\3\3\5\3\u008f\n\3\3\3\5\3\u0092\n\3\3\3\5\3\u0095\n\3\3" +
                    "\3\5\3\u0098\n\3\3\4\3\4\3\4\7\4\u009d\n\4\f\4\16\4\u00a0\13\4\3\5\3\5" +
                    "\5\5\u00a4\n\5\3\6\3\6\3\6\3\6\7\6\u00aa\n\6\f\6\16\6\u00ad\13\6\3\7\3" +
                    "\7\5\7\u00b1\n\7\3\7\3\7\7\7\u00b5\n\7\f\7\16\7\u00b8\13\7\3\b\3\b\3\b" +
                    "\5\b\u00bd\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00c6\n\t\f\t\16\t\u00c9" +
                    "\13\t\3\n\3\n\3\n\3\n\5\n\u00cf\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3" +
                    "\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20" +
                    "\7\20\u00e7\n\20\f\20\16\20\u00ea\13\20\3\21\3\21\5\21\u00ee\n\21\3\21" +
                    "\5\21\u00f1\n\21\3\22\3\22\3\22\7\22\u00f6\n\22\f\22\16\22\u00f9\13\22" +
                    "\3\23\3\23\3\23\7\23\u00fe\n\23\f\23\16\23\u0101\13\23\3\24\3\24\3\24" +
                    "\3\24\3\24\5\24\u0108\n\24\3\25\3\25\3\25\3\25\5\25\u010e\n\25\3\26\3" +
                    "\26\5\26\u0112\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u011b\n\26" +
                    "\3\26\3\26\3\26\3\26\3\26\5\26\u0122\n\26\3\27\3\27\5\27\u0126\n\27\3" +
                    "\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u012f\n\30\f\30\16\30\u0132\13" +
                    "\30\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u013a\n\32\3\32\3\32\3\32\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u014b\n\33" +
                    "\3\34\3\34\3\35\3\35\5\35\u0151\n\35\3\36\3\36\3\36\7\36\u0156\n\36\f" +
                    "\36\16\36\u0159\13\36\3\37\3\37\3\37\7\37\u015e\n\37\f\37\16\37\u0161" +
                    "\13\37\3 \5 \u0164\n \3 \3 \3!\3!\3!\3!\3!\5!\u016d\n!\3\"\3\"\3#\3#\5" +
                    "#\u0173\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\5+" +
                    "\u0187\n+\3+\5+\u018a\n+\3+\5+\u018d\n+\3,\3,\3-\3-\3-\3-\7-\u0195\n-" +
                    "\f-\16-\u0198\13-\3-\3-\3.\3.\3.\7.\u019f\n.\f.\16.\u01a2\13.\3/\3/\3" +
                    "/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u01b3\n/\3\60\3\60\3\60\3\60" +
                    "\3\60\5\60\u01ba\n\60\3\61\3\61\3\61\3\61\7\61\u01c0\n\61\f\61\16\61\u01c3" +
                    "\13\61\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u01cb\n\62\f\62\16\62\u01ce" +
                    "\13\62\3\62\3\62\3\63\3\63\5\63\u01d4\n\63\3\64\3\64\3\64\5\64\u01d9\n" +
                    "\64\3\64\3\64\3\64\3\64\3\64\7\64\u01e0\n\64\f\64\16\64\u01e3\13\64\3" +
                    "\64\5\64\u01e6\n\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\5\66\u01f0" +
                    "\n\66\3\67\3\67\3\67\3\67\7\67\u01f6\n\67\f\67\16\67\u01f9\13\67\3\67" +
                    "\3\67\38\38\38\38\39\39\59\u0203\n9\3:\3:\3:\3:\5:\u0209\n:\3:\3:\3;\3" +
                    ";\3;\3;\5;\u0211\n;\3;\3;\3;\3<\3<\3<\3<\7<\u021a\n<\f<\16<\u021d\13<" +
                    "\3<\3<\3=\3=\3=\3=\7=\u0225\n=\f=\16=\u0228\13=\3=\3=\3>\3>\3>\3>\5>\u0230" +
                    "\n>\3?\3?\3?\3?\2\2@\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60" +
                    "\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|\2\7\3\2\22\26\3\2FK\3\2" +
                    "DE\3\2BC\3\2Z[\2\u023b\2\u0085\3\2\2\2\4\u0087\3\2\2\2\6\u0099\3\2\2\2" +
                    "\b\u00a3\3\2\2\2\n\u00a5\3\2\2\2\f\u00ae\3\2\2\2\16\u00b9\3\2\2\2\20\u00c2" +
                    "\3\2\2\2\22\u00ca\3\2\2\2\24\u00d0\3\2\2\2\26\u00d5\3\2\2\2\30\u00d7\3" +
                    "\2\2\2\32\u00da\3\2\2\2\34\u00de\3\2\2\2\36\u00e1\3\2\2\2 \u00eb\3\2\2" +
                    "\2\"\u00f2\3\2\2\2$\u00fa\3\2\2\2&\u0107\3\2\2\2(\u010d\3\2\2\2*\u0121" +
                    "\3\2\2\2,\u0123\3\2\2\2.\u012a\3\2\2\2\60\u0135\3\2\2\2\62\u0137\3\2\2" +
                    "\2\64\u014a\3\2\2\2\66\u014c\3\2\2\28\u0150\3\2\2\2:\u0152\3\2\2\2<\u015a" +
                    "\3\2\2\2>\u0163\3\2\2\2@\u016c\3\2\2\2B\u016e\3\2\2\2D\u0172\3\2\2\2F" +
                    "\u0174\3\2\2\2H\u0176\3\2\2\2J\u0178\3\2\2\2L\u017a\3\2\2\2N\u017c\3\2" +
                    "\2\2P\u017e\3\2\2\2R\u0180\3\2\2\2T\u0182\3\2\2\2V\u018e\3\2\2\2X\u0190" +
                    "\3\2\2\2Z\u019b\3\2\2\2\\\u01b2\3\2\2\2^\u01b9\3\2\2\2`\u01bb\3\2\2\2" +
                    "b\u01c4\3\2\2\2d\u01d1\3\2\2\2f\u01d5\3\2\2\2h\u01e7\3\2\2\2j\u01ef\3" +
                    "\2\2\2l\u01f1\3\2\2\2n\u01fc\3\2\2\2p\u0200\3\2\2\2r\u0204\3\2\2\2t\u020c" +
                    "\3\2\2\2v\u0215\3\2\2\2x\u0220\3\2\2\2z\u022b\3\2\2\2|\u0231\3\2\2\2~" +
                    "\u0086\5\4\3\2\177\u0086\5T+\2\u0080\u0086\5t;\2\u0081\u0086\5d\63\2\u0082" +
                    "\u0086\5p9\2\u0083\u0086\5z>\2\u0084\u0086\5|?\2\u0085~\3\2\2\2\u0085" +
                    "\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085\u0081\3\2\2\2\u0085\u0082\3\2\2" +
                    "\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\3\3\2\2\2\u0087\u0088" +
                    "\7\3\2\2\u0088\u0089\5\6\4\2\u0089\u008b\5\n\6\2\u008a\u008c\5\30\r\2" +
                    "\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008f" +
                    "\5\32\16\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2" +
                    "\u0090\u0092\5\34\17\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094" +
                    "\3\2\2\2\u0093\u0095\5\36\20\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2" +
                    "\u0095\u0097\3\2\2\2\u0096\u0098\5\22\n\2\u0097\u0096\3\2\2\2\u0097\u0098" +
                    "\3\2\2\2\u0098\5\3\2\2\2\u0099\u009e\5\b\5\2\u009a\u009b\7O\2\2\u009b" +
                    "\u009d\5\b\5\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2" +
                    "\2\2\u009e\u009f\3\2\2\2\u009f\7\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4" +
                    "\5\20\t\2\u00a2\u00a4\5\24\13\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2" +
                    "\2\u00a4\t\3\2\2\2\u00a5\u00a6\7\b\2\2\u00a6\u00ab\5\f\7\2\u00a7\u00a8" +
                    "\7O\2\2\u00a8\u00aa\5\f\7\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab" +
                    "\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\13\3\2\2\2\u00ad\u00ab\3\2\2" +
                    "\2\u00ae\u00b0\5H%\2\u00af\u00b1\7\t\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1" +
                    "\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\5R*\2\u00b3\u00b5\5\16\b\2\u00b4" +
                    "\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2" +
                    "\2\2\u00b7\r\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\r\2\2\u00ba\u00bc" +
                    "\5H%\2\u00bb\u00bd\7\t\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd" +
                    "\u00be\3\2\2\2\u00be\u00bf\5R*\2\u00bf\u00c0\7?\2\2\u00c0\u00c1\5\"\22" +
                    "\2\u00c1\17\3\2\2\2\u00c2\u00c7\5R*\2\u00c3\u00c4\7L\2\2\u00c4\u00c6\5" +
                    "P)\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7" +
                    "\u00c8\3\2\2\2\u00c8\21\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7<\2\2" +
                    "\u00cb\u00ce\7Z\2\2\u00cc\u00cd\7O\2\2\u00cd\u00cf\7Z\2\2\u00ce\u00cc" +
                    "\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\23\3\2\2\2\u00d0\u00d1\5\26\f\2\u00d1" +
                    "\u00d2\7M\2\2\u00d2\u00d3\5\20\t\2\u00d3\u00d4\7N\2\2\u00d4\25\3\2\2\2" +
                    "\u00d5\u00d6\t\2\2\2\u00d6\27\3\2\2\2\u00d7\u00d8\7\27\2\2\u00d8\u00d9" +
                    "\5\"\22\2\u00d9\31\3\2\2\2\u00da\u00db\7\30\2\2\u00db\u00dc\7\31\2\2\u00dc" +
                    "\u00dd\5\20\t\2\u00dd\33\3\2\2\2\u00de\u00df\7\33\2\2\u00df\u00e0\5\"" +
                    "\22\2\u00e0\35\3\2\2\2\u00e1\u00e2\7\32\2\2\u00e2\u00e3\7\31\2\2\u00e3" +
                    "\u00e8\5 \21\2\u00e4\u00e5\7O\2\2\u00e5\u00e7\5 \21\2\u00e6\u00e4\3\2" +
                    "\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9" +
                    "\37\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00f0\5\20\t\2\u00ec\u00ee\7\35" +
                    "\2\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef" +
                    "\u00f1\7\34\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1!\3\2\2\2" +
                    "\u00f2\u00f7\5$\23\2\u00f3\u00f4\7$\2\2\u00f4\u00f6\5$\23\2\u00f5\u00f3" +
                    "\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8" +
                    "#\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00ff\5&\24\2\u00fb\u00fc\7#\2\2\u00fc" +
                    "\u00fe\5&\24\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2" +
                    "\2\2\u00ff\u0100\3\2\2\2\u0100%\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0108" +
                    "\5(\25\2\u0103\u0104\7M\2\2\u0104\u0105\5\"\22\2\u0105\u0106\7N\2\2\u0106" +
                    "\u0108\3\2\2\2\u0107\u0102\3\2\2\2\u0107\u0103\3\2\2\2\u0108\'\3\2\2\2" +
                    "\u0109\u010e\5\64\33\2\u010a\u010e\5*\26\2\u010b\u010e\5\62\32\2\u010c" +
                    "\u010e\5,\27\2\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2" +
                    "\2\2\u010d\u010c\3\2\2\2\u010e)\3\2\2\2\u010f\u0111\58\35\2\u0110\u0112" +
                    "\7\36\2\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2" +
                    "\u0113\u0114\7\37\2\2\u0114\u0115\58\35\2\u0115\u0116\7#\2\2\u0116\u0117" +
                    "\58\35\2\u0117\u0122\3\2\2\2\u0118\u011a\5B\"\2\u0119\u011b\7\36\2\2\u011a" +
                    "\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\37" +
                    "\2\2\u011d\u011e\5B\"\2\u011e\u011f\7#\2\2\u011f\u0120\5B\"\2\u0120\u0122" +
                    "\3\2\2\2\u0121\u010f\3\2\2\2\u0121\u0118\3\2\2\2\u0122+\3\2\2\2\u0123" +
                    "\u0125\5\20\t\2\u0124\u0126\7\36\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3" +
                    "\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\7&\2\2\u0128\u0129\5.\30\2\u0129" +
                    "-\3\2\2\2\u012a\u012b\7M\2\2\u012b\u0130\5\60\31\2\u012c\u012d\7O\2\2" +
                    "\u012d\u012f\5\60\31\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e" +
                    "\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133" +
                    "\u0134\7N\2\2\u0134/\3\2\2\2\u0135\u0136\5N(\2\u0136\61\3\2\2\2\u0137" +
                    "\u0139\5B\"\2\u0138\u013a\7\36\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2" +
                    "\2\2\u013a\u013b\3\2\2\2\u013b\u013c\7%\2\2\u013c\u013d\5J&\2\u013d\63" +
                    "\3\2\2\2\u013e\u013f\5B\"\2\u013f\u0140\5\66\34\2\u0140\u0141\5B\"\2\u0141" +
                    "\u014b\3\2\2\2\u0142\u0143\58\35\2\u0143\u0144\5\66\34\2\u0144\u0145\5" +
                    "8\35\2\u0145\u014b\3\2\2\2\u0146\u0147\5\24\13\2\u0147\u0148\5\66\34\2" +
                    "\u0148\u0149\58\35\2\u0149\u014b\3\2\2\2\u014a\u013e\3\2\2\2\u014a\u0142" +
                    "\3\2\2\2\u014a\u0146\3\2\2\2\u014b\65\3\2\2\2\u014c\u014d\t\3\2\2\u014d" +
                    "\67\3\2\2\2\u014e\u0151\5\20\t\2\u014f\u0151\5:\36\2\u0150\u014e\3\2\2" +
                    "\2\u0150\u014f\3\2\2\2\u01519\3\2\2\2\u0152\u0157\5<\37\2\u0153\u0154" +
                    "\t\4\2\2\u0154\u0156\5<\37\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157" +
                    "\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158;\3\2\2\2\u0159\u0157\3\2\2\2" +
                    "\u015a\u015f\5> \2\u015b\u015c\t\5\2\2\u015c\u015e\5> \2\u015d\u015b\3" +
                    "\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160" +
                    "=\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0164\t\4\2\2\u0163\u0162\3\2\2\2" +
                    "\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\5@!\2\u0166?\3\2" +
                    "\2\2\u0167\u016d\5L\'\2\u0168\u0169\7M\2\2\u0169\u016a\5:\36\2\u016a\u016b" +
                    "\7N\2\2\u016b\u016d\3\2\2\2\u016c\u0167\3\2\2\2\u016c\u0168\3\2\2\2\u016d" +
                    "A\3\2\2\2\u016e\u016f\5D#\2\u016fC\3\2\2\2\u0170\u0173\5\20\t\2\u0171" +
                    "\u0173\5F$\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173E\3\2\2\2\u0174" +
                    "\u0175\7S\2\2\u0175G\3\2\2\2\u0176\u0177\7T\2\2\u0177I\3\2\2\2\u0178\u0179" +
                    "\7T\2\2\u0179K\3\2\2\2\u017a\u017b\t\6\2\2\u017bM\3\2\2\2\u017c\u017d" +
                    "\7T\2\2\u017dO\3\2\2\2\u017e\u017f\7T\2\2\u017fQ\3\2\2\2\u0180\u0181\7" +
                    "T\2\2\u0181S\3\2\2\2\u0182\u0183\7\4\2\2\u0183\u0184\78\2\2\u0184\u0186" +
                    "\5V,\2\u0185\u0187\5X-\2\u0186\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187" +
                    "\u0189\3\2\2\2\u0188\u018a\5`\61\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2" +
                    "\2\2\u018a\u018c\3\2\2\2\u018b\u018d\5b\62\2\u018c\u018b\3\2\2\2\u018c" +
                    "\u018d\3\2\2\2\u018dU\3\2\2\2\u018e\u018f\7T\2\2\u018fW\3\2\2\2\u0190" +
                    "\u0191\7M\2\2\u0191\u0196\5Z.\2\u0192\u0193\7O\2\2\u0193\u0195\5Z.\2\u0194" +
                    "\u0192\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2" +
                    "\2\2\u0197\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\7N\2\2\u019a" +
                    "Y\3\2\2\2\u019b\u019c\7T\2\2\u019c\u01a0\5\\/\2\u019d\u019f\5^\60\2\u019e" +
                    "\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2" +
                    "\2\2\u01a1[\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01b3\7\63\2\2\u01a4\u01b3" +
                    "\7\64\2\2\u01a5\u01a6\7\65\2\2\u01a6\u01a7\7M\2\2\u01a7\u01a8\7Z\2\2\u01a8" +
                    "\u01b3\7N\2\2\u01a9\u01aa\7\66\2\2\u01aa\u01ab\7M\2\2\u01ab\u01ac\5\\" +
                    "/\2\u01ac\u01ad\7N\2\2\u01ad\u01b3\3\2\2\2\u01ae\u01af\7\67\2\2\u01af" +
                    "\u01b0\7M\2\2\u01b0\u01b1\7T\2\2\u01b1\u01b3\7N\2\2\u01b2\u01a3\3\2\2" +
                    "\2\u01b2\u01a4\3\2\2\2\u01b2\u01a5\3\2\2\2\u01b2\u01a9\3\2\2\2\u01b2\u01ae" +
                    "\3\2\2\2\u01b3]\3\2\2\2\u01b4\u01ba\7:\2\2\u01b5\u01b6\7)\2\2\u01b6\u01ba" +
                    "\7*\2\2\u01b7\u01b8\7;\2\2\u01b8\u01ba\7*\2\2\u01b9\u01b4\3\2\2\2\u01b9" +
                    "\u01b5\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba_\3\2\2\2\u01bb\u01bc\7,\2\2\u01bc" +
                    "\u01c1\7T\2\2\u01bd\u01be\7O\2\2\u01be\u01c0\7T\2\2\u01bf\u01bd\3\2\2" +
                    "\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2a" +
                    "\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c5\7)\2\2\u01c5\u01c6\7*\2\2\u01c6" +
                    "\u01c7\7M\2\2\u01c7\u01cc\5\20\t\2\u01c8\u01c9\7O\2\2\u01c9\u01cb\5\20" +
                    "\t\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc" +
                    "\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\7N" +
                    "\2\2\u01d0c\3\2\2\2\u01d1\u01d3\5f\64\2\u01d2\u01d4\5\30\r\2\u01d3\u01d2" +
                    "\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4e\3\2\2\2\u01d5\u01d6\7\5\2\2\u01d6" +
                    "\u01d8\5H%\2\u01d7\u01d9\7\t\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2" +
                    "\2\u01d9\u01da\3\2\2\2\u01da\u01db\5R*\2\u01db\u01dc\7+\2\2\u01dc\u01e1" +
                    "\5h\65\2\u01dd\u01de\7O\2\2\u01de\u01e0\5h\65\2\u01df\u01dd\3\2\2\2\u01e0" +
                    "\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2" +
                    "\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\5\30\r\2\u01e5\u01e4\3\2\2\2\u01e5" +
                    "\u01e6\3\2\2\2\u01e6g\3\2\2\2\u01e7\u01e8\5\20\t\2\u01e8\u01e9\7F\2\2" +
                    "\u01e9\u01ea\5j\66\2\u01eai\3\2\2\2\u01eb\u01f0\5:\36\2\u01ec\u01f0\5" +
                    "D#\2\u01ed\u01f0\5l\67\2\u01ee\u01f0\7!\2\2\u01ef\u01eb\3\2\2\2\u01ef" +
                    "\u01ec\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01ee\3\2\2\2\u01f0k\3\2\2\2" +
                    "\u01f1\u01f2\7M\2\2\u01f2\u01f7\5n8\2\u01f3\u01f4\7O\2\2\u01f4\u01f6\5" +
                    "n8\2\u01f5\u01f3\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7" +
                    "\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fb\7N" +
                    "\2\2\u01fbm\3\2\2\2\u01fc\u01fd\5\20\t\2\u01fd\u01fe\7Q\2\2\u01fe\u01ff" +
                    "\5j\66\2\u01ffo\3\2\2\2\u0200\u0202\5r:\2\u0201\u0203\5\30\r\2\u0202\u0201" +
                    "\3\2\2\2\u0202\u0203\3\2\2\2\u0203q\3\2\2\2\u0204\u0205\7\6\2\2\u0205" +
                    "\u0206\7\b\2\2\u0206\u0208\5H%\2\u0207\u0209\7\t\2\2\u0208\u0207\3\2\2" +
                    "\2\u0208\u0209\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\5R*\2\u020bs\3" +
                    "\2\2\2\u020c\u020d\7\7\2\2\u020d\u020e\7\'\2\2\u020e\u0210\5V,\2\u020f" +
                    "\u0211\5v<\2\u0210\u020f\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\3\2\2" +
                    "\2\u0212\u0213\7(\2\2\u0213\u0214\5x=\2\u0214u\3\2\2\2\u0215\u0216\7M" +
                    "\2\2\u0216\u021b\5\20\t\2\u0217\u0218\7O\2\2\u0218\u021a\5\20\t\2\u0219" +
                    "\u0217\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2" +
                    "\2\2\u021c\u021e\3\2\2\2\u021d\u021b\3\2\2\2\u021e\u021f\7N\2\2\u021f" +
                    "w\3\2\2\2\u0220\u0221\7M\2\2\u0221\u0226\5j\66\2\u0222\u0223\7O\2\2\u0223" +
                    "\u0225\5j\66\2\u0224\u0222\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2" +
                    "\2\2\u0226\u0227\3\2\2\2\u0227\u0229\3\2\2\2\u0228\u0226\3\2\2\2\u0229" +
                    "\u022a\7N\2\2\u022ay\3\2\2\2\u022b\u022c\7=\2\2\u022c\u022d\78\2\2\u022d" +
                    "\u022f\7T\2\2\u022e\u0230\7>\2\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2\2" +
                    "\2\u0230{\3\2\2\2\u0231\u0232\7@\2\2\u0232\u0233\7A\2\2\u0233}\3\2\2\2" +
                    "9\u0085\u008b\u008e\u0091\u0094\u0097\u009e\u00a3\u00ab\u00b0\u00b6\u00bc" +
                    "\u00c7\u00ce\u00e8\u00ed\u00f0\u00f7\u00ff\u0107\u010d\u0111\u011a\u0121" +
                    "\u0125\u0130\u0139\u014a\u0150\u0157\u015f\u0163\u016c\u0172\u0186\u0189" +
                    "\u018c\u0196\u01a0\u01b2\u01b9\u01c1\u01cc\u01d3\u01d8\u01e1\u01e5\u01ef" +
                    "\u01f7\u0202\u0208\u0210\u021b\u0226\u022f";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}