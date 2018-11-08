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
            DATABASES = 64, FINAL = 65, INDEX = 66, MUL = 67, DIV = 68, PLUS = 69, MINUS = 70, EQ = 71,
            GR = 72, LS = 73, GE = 74, LE = 75, NE = 76, DOT = 77, LBRACKET = 78, RBRACKET = 79, LFRACKET = 80,
            RFRACKET = 81, COMMA = 82, SEMI = 83, COLON = 84, TRIMCHARACTER = 85, STRINGLITERAL = 86,
            WORD = 87, NAMEDPARAMETER = 88, WS = 89, COMMENT = 90, LINECOMMENT = 91, ESCAPECHARACTER = 92,
            INTNUMERAL = 93, FLOATNUMERAL = 94;
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
            RULE_dropStat = 64, RULE_showStat = 65, RULE_createIndexStat = 66, RULE_dropIndexStat = 67;
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
            "dropStat", "showStat", "createIndexStat", "dropIndexStat"
    };

    private static final String[] _LITERAL_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "'*'", "'/'", "'+'", "'-'",
            "'='", "'>'", "'<'", "'>='", "'<='", null, "'.'", "'('", "')'", "'['",
            "']'", "','", "';'", "':'", "''.''"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "SELECT", "CREATE", "UPDATE", "DELETE", "INSERT", "FROM", "AS",
            "LEFT", "RIGHT", "OUTER", "JOIN", "INNER", "DISTINCT", "OBJECT", "NEW",
            "AVG", "SUM", "MAX", "MIN", "COUNT", "WHERE", "GROUP", "BY", "ORDER",
            "HAVING", "DESC", "ASC", "NOT", "SET", "BETWEEN", "IS", "NULL", "ESCAPE",
            "AND", "OR", "LIKE", "IN", "INTO", "VALUES", "PRIMARY", "KEY", "LISTOF",
            "EXTENDS", "EMPTY", "MEMBER", "OF", "ALL", "ANY", "SOME", "INT", "FLOAT",
            "CHAR", "SETOF", "REF", "TABLE", "EXISTS", "AUTO_INCREMENT", "UNIQUE",
            "LIMIT", "DROP", "CASCADE", "ON", "SHOW", "DATABASES", "FINAL", "INDEX",
            "MUL", "DIV", "PLUS", "MINUS", "EQ", "GR", "LS", "GE", "LE", "NE", "DOT",
            "LBRACKET", "RBRACKET", "LFRACKET", "RFRACKET", "COMMA", "SEMI", "COLON",
            "TRIMCHARACTER", "STRINGLITERAL", "WORD", "NAMEDPARAMETER", "WS", "COMMENT",
            "LINECOMMENT", "ESCAPECHARACTER", "INTNUMERAL", "FLOATNUMERAL"
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

    public static class CreateIndexStatementContext extends OqlStatContext {
        public CreateIndexStatContext createIndexStat() {
            return getRuleContext(CreateIndexStatContext.class, 0);
        }

        public CreateIndexStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            CreateIndexStatContext indexStat = this.createIndexStat();
            return CreateIndexExplain.getCreateIndexExplain(indexStat).doCreate();
        }
    }

    public static class DropIndexStatementContext extends OqlStatContext {
        public DropIndexStatContext dropIndexStat() {
            return getRuleContext(DropIndexStatContext.class, 0);
        }

        public DropIndexStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public Object doExecute() {
            DropIndexStatContext dropIndexStatContext = this.dropIndexStat();
            return DropIndexExplain.getDropIndexExplain(dropIndexStatContext).doDrop();
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
            setState(145);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                    _localctx = new SelectStatementContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(136);
                    selectStat();
                }
                break;
                case 2:
                    _localctx = new CreateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(137);
                    createStat();
                }
                break;
                case 3:
                    _localctx = new InsertStatementContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(138);
                    insertStat();
                }
                break;
                case 4:
                    _localctx = new UpdateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(139);
                    updateStat();
                }
                break;
                case 5:
                    _localctx = new DeleteStatementContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(140);
                    deleteStat();
                }
                break;
                case 6:
                    _localctx = new DropStatementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(141);
                    dropStat();
                }
                break;
                case 7:
                    _localctx = new ShowStatementContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(142);
                    showStat();
                }
                break;
                case 8:
                    _localctx = new CreateIndexStatementContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(143);
                    createIndexStat();
                }
                break;
                case 9:
                    _localctx = new DropIndexStatementContext(_localctx);
                    enterOuterAlt(_localctx, 9);
                {
                    setState(144);
                    dropIndexStat();
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
                setState(147);
                match(SELECT);
                setState(149);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DISTINCT) {
                    {
                        setState(148);
                        match(DISTINCT);
                    }
                }

                setState(151);
                selectClause();
                setState(152);
                fromClause();
                setState(154);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(153);
                        whereClause();
                    }
                }

                setState(157);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GROUP) {
                    {
                        setState(156);
                        groupByClause();
                    }
                }

                setState(160);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ORDER) {
                    {
                        setState(159);
                        orderByClause();
                    }
                }

                setState(163);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(162);
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
                setState(165);
                selectExpr();
                setState(170);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(166);
                            match(COMMA);
                            setState(167);
                            selectExpr();
                        }
                    }
                    setState(172);
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
            setState(175);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new SelectPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(173);
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
                    setState(174);
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
                setState(177);
                match(FROM);
                setState(178);
                fromItem();
                setState(183);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(179);
                            match(COMMA);
                            setState(180);
                            fromItem();
                        }
                    }
                    setState(185);
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
                setState(186);
                schemaName();
                setState(188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(187);
                        match(AS);
                    }
                }

                setState(190);
                id();
                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == JOIN) {
                    {
                        {
                            setState(191);
                            join();
                        }
                    }
                    setState(196);
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
                setState(197);
                match(JOIN);
                setState(198);
                schemaName();
                setState(200);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(199);
                        match(AS);
                    }
                }

                setState(202);
                id();
                setState(203);
                match(ON);
                setState(204);
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
                setState(206);
                id();
                setState(211);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(207);
                            match(DOT);
                            setState(208);
                            field();
                        }
                    }
                    setState(213);
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
                setState(214);
                match(LIMIT);
                setState(215);
                match(INTNUMERAL);
                setState(218);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(216);
                        match(COMMA);
                        setState(217);
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
                setState(220);
                aggregateExprFunctionName();
                setState(221);
                match(LBRACKET);
                setState(222);
                pathExpr();
                setState(223);
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
                setState(225);
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
                setState(227);
                match(WHERE);
                setState(228);
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
                setState(230);
                match(GROUP);
                setState(231);
                match(BY);
                setState(232);
                pathExpr();
                setState(234);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HAVING) {
                    {
                        setState(233);
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
                setState(236);
                match(HAVING);
                setState(237);
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
                setState(239);
                match(ORDER);
                setState(240);
                match(BY);
                setState(241);
                orderByItem();
                setState(246);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(242);
                            match(COMMA);
                            setState(243);
                            orderByItem();
                        }
                    }
                    setState(248);
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
                setState(249);
                pathExpr();
                setState(254);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case EOF:
                    case ASC:
                    case LIMIT:
                    case COMMA: {
                        setState(251);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == ASC) {
                            {
                                setState(250);
                                match(ASC);
                            }
                        }

                    }
                    break;
                    case DESC: {
                        setState(253);
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
                    setState(256);
                    conditionalTerm();
                }
                setState(261);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(257);
                            match(OR);
                            setState(258);
                            conditionalTerm();
                        }
                    }
                    setState(263);
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
                    setState(264);
                    conditionalFactor();
                }
                setState(269);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(265);
                            match(AND);
                            setState(266);
                            conditionalFactor();
                        }
                    }
                    setState(271);
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
            setState(277);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                case 1:
                    _localctx = new ConditionalFactorSimpleCondExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(272);
                    simpleCondExpr();
                }
                break;
                case 2:
                    _localctx = new ConditionalFactorExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(273);
                    match(LBRACKET);
                    setState(274);
                    conditionalExpr();
                    setState(275);
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
            setState(283);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                case 1:
                    _localctx = new SimpleComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(279);
                    comparisonExpr();
                }
                break;
                case 2:
                    _localctx = new SimpleBetweenExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(280);
                    betweenExpr();
                }
                break;
                case 3:
                    _localctx = new SimpleLikeExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(281);
                    likeExpr();
                }
                break;
                case 4:
                    _localctx = new SimpleInExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(282);
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
            setState(303);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    _localctx = new BetweenArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(285);
                    arithmeticExpr();
                    setState(287);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(286);
                            match(NOT);
                        }
                    }

                    setState(289);
                    match(BETWEEN);
                    setState(290);
                    arithmeticExpr();
                    setState(291);
                    match(AND);
                    setState(292);
                    arithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new BetweenStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(294);
                    stringExpr();
                    setState(296);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(295);
                            match(NOT);
                        }
                    }

                    setState(298);
                    match(BETWEEN);
                    setState(299);
                    stringExpr();
                    setState(300);
                    match(AND);
                    setState(301);
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
                setState(305);
                pathExpr();
                setState(307);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(306);
                        match(NOT);
                    }
                }

                setState(309);
                match(IN);
                setState(310);
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
                setState(312);
                match(LBRACKET);
                setState(313);
                inItem();
                setState(318);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(314);
                            match(COMMA);
                            setState(315);
                            inItem();
                        }
                    }
                    setState(320);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(321);
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
                setState(323);
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
                setState(325);
                stringExpr();
                setState(327);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(326);
                        match(NOT);
                    }
                }

                setState(329);
                match(LIKE);
                setState(330);
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
            setState(352);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    _localctx = new ComparisonStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(332);
                    stringExpr();
                    setState(333);
                    comparisonOperator();
                    setState(334);
                    stringExpr();
                }
                break;
                case 2:
                    _localctx = new ComparisonArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(336);
                    arithmeticExpr();
                    setState(337);
                    comparisonOperator();
                    setState(338);
                    arithmeticExpr();
                }
                break;
                case 3:
                    _localctx = new ComparisonAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(340);
                    aggregateExpr();
                    setState(341);
                    comparisonOperator();
                    setState(342);
                    arithmeticExpr();
                }
                break;
                case 4:
                    _localctx = new ComparisonEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(344);
                    entityExpr();
                    setState(345);
                    comparisonOperator();
                    setState(346);
                    entityExpr();
                }
                break;
                case 5:
                    _localctx = new ComparisonListExprContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(348);
                    listExpr();
                    setState(349);
                    comparisonOperator();
                    setState(350);
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
                setState(354);
                _la = _input.LA(1);
                if (!(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (EQ - 71)) | (1L << (GR - 71)) | (1L << (LS - 71)) | (1L << (GE - 71)) | (1L << (LE - 71)) | (1L << (NE - 71)))) != 0))) {
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
            setState(358);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ArithmeticPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(356);
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
                    setState(357);
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
                    setState(360);
                    arithmeticTerm();
                }
                setState(365);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PLUS || _la == MINUS) {
                    {
                        {
                            setState(361);
                            _la = _input.LA(1);
                            if (!(_la == PLUS || _la == MINUS)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(362);
                            arithmeticTerm();
                        }
                    }
                    setState(367);
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
                    setState(368);
                    arithmeticFactor();
                }
                setState(373);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == MUL || _la == DIV) {
                    {
                        {
                            setState(369);
                            _la = _input.LA(1);
                            if (!(_la == MUL || _la == DIV)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(370);
                            arithmeticFactor();
                        }
                    }
                    setState(375);
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
                setState(377);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PLUS || _la == MINUS) {
                    {
                        setState(376);
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

                setState(379);
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
            setState(386);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new AriPriNumericLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(381);
                    numericLiteral();
                }
                break;
                case LBRACKET:
                    _localctx = new AriPriSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(382);
                    match(LBRACKET);
                    setState(383);
                    simpleArithmeticExpr();
                    setState(384);
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
                setState(388);
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
            setState(392);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new StringPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(390);
                    pathExpr();
                }
                break;
                case STRINGLITERAL:
                    _localctx = new StringLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(391);
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
            setState(396);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new EntityPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(394);
                    pathExpr();
                }
                break;
                case LBRACKET:
                    _localctx = new EntityValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(395);
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
            setState(400);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ListPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(398);
                    pathExpr();
                }
                break;
                case LFRACKET:
                    _localctx = new ListValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(399);
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
                setState(402);
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
                setState(406);
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
                setState(408);
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
                setState(410);
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
                setState(412);
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
                setState(414);
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
                setState(416);
                match(CREATE);
                setState(417);
                match(TABLE);
                setState(418);
                tableName();
                setState(420);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(419);
                        columnDefinition();
                    }
                }

                setState(423);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EXTENDS) {
                    {
                        setState(422);
                        extendsTable();
                    }
                }

                setState(426);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PRIMARY) {
                    {
                        setState(425);
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
                setState(428);
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
                setState(430);
                match(LBRACKET);
                setState(431);
                columnDefinitionItem();
                setState(436);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(432);
                            match(COMMA);
                            setState(433);
                            columnDefinitionItem();
                        }
                    }
                    setState(438);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(439);
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
                setState(441);
                match(WORD);
                setState(442);
                columnType();
                setState(446);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (PRIMARY - 40)) | (1L << (AUTO_INCREMENT - 40)) | (1L << (UNIQUE - 40)) | (1L << (FINAL - 40)))) != 0)) {
                    {
                        {
                            setState(443);
                            columnConstraint();
                        }
                    }
                    setState(448);
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
            setState(468);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(449);
                    match(INT);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(450);
                    match(FLOAT);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(451);
                    match(CHAR);
                    setState(452);
                    match(LBRACKET);
                    setState(453);
                    match(INTNUMERAL);
                    setState(454);
                    match(RBRACKET);
                }
                break;
                case LISTOF:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(455);
                    match(LISTOF);
                    setState(456);
                    match(LBRACKET);
                    setState(457);
                    columnType();
                    setState(458);
                    match(COMMA);
                    setState(459);
                    match(INTNUMERAL);
                    setState(460);
                    match(RBRACKET);
                }
                break;
                case REF:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(462);
                    match(REF);
                    setState(463);
                    match(LBRACKET);
                    setState(464);
                    match(WORD);
                    setState(465);
                    match(RBRACKET);
                }
                break;
                case OBJECT:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(466);
                    match(OBJECT);
                    setState(467);
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
            setState(476);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AUTO_INCREMENT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(470);
                    match(AUTO_INCREMENT);
                }
                break;
                case PRIMARY:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(471);
                    match(PRIMARY);
                    setState(472);
                    match(KEY);
                }
                break;
                case UNIQUE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(473);
                    match(UNIQUE);
                    setState(474);
                    match(KEY);
                }
                break;
                case FINAL:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(475);
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
                setState(478);
                match(EXTENDS);
                setState(479);
                match(WORD);
                setState(484);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(480);
                            match(COMMA);
                            setState(481);
                            match(WORD);
                        }
                    }
                    setState(486);
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
                setState(487);
                match(PRIMARY);
                setState(488);
                match(KEY);
                setState(489);
                match(LBRACKET);
                setState(490);
                pathExpr();
                setState(495);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(491);
                            match(COMMA);
                            setState(492);
                            pathExpr();
                        }
                    }
                    setState(497);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(498);
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
                setState(500);
                updateClause();
                setState(502);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(501);
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
                setState(504);
                match(UPDATE);
                setState(505);
                schemaName();
                setState(507);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(506);
                        match(AS);
                    }
                }

                setState(509);
                id();
                setState(510);
                match(SET);
                setState(511);
                updateItem();
                setState(516);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(512);
                            match(COMMA);
                            setState(513);
                            updateItem();
                        }
                    }
                    setState(518);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(520);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 49, _ctx)) {
                    case 1: {
                        setState(519);
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
                setState(522);
                pathExpr();
                setState(523);
                match(EQ);
                setState(524);
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
            setState(531);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 50, _ctx)) {
                case 1:
                    _localctx = new NewSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(526);
                    simpleArithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new NewStringPrimaryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(527);
                    stringPrimary();
                }
                break;
                case 3:
                    _localctx = new NewSimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(528);
                    insertEntityExpr();
                }
                break;
                case 4:
                    _localctx = new NewSimpleListExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(529);
                    insertListExpr();
                }
                break;
                case 5:
                    _localctx = new NewNullContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(530);
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
                setState(533);
                match(LFRACKET);
                setState(534);
                insertListItem();
                setState(539);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(535);
                            match(COMMA);
                            setState(536);
                            insertListItem();
                        }
                    }
                    setState(541);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(542);
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
            setState(548);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 52, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(544);
                    match(INTNUMERAL);
                    setState(545);
                    match(COLON);
                    setState(546);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(547);
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
                setState(550);
                match(LBRACKET);
                setState(551);
                insertEntityItem();
                setState(556);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(552);
                            match(COMMA);
                            setState(553);
                            insertEntityItem();
                        }
                    }
                    setState(558);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(559);
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
            setState(566);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(561);
                    pathExpr();
                    setState(562);
                    match(COLON);
                    setState(563);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(565);
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
                setState(568);
                deleteClause();
                setState(570);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(569);
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
                setState(572);
                match(DELETE);
                setState(573);
                match(FROM);
                setState(574);
                schemaName();
                setState(576);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(575);
                        match(AS);
                    }
                }

                setState(578);
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
                setState(580);
                match(INSERT);
                setState(581);
                match(INTO);
                setState(582);
                tableName();
                setState(584);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(583);
                        columnList();
                    }
                }

                setState(586);
                match(VALUES);
                setState(587);
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
                setState(589);
                match(LBRACKET);
                setState(590);
                pathExpr();
                setState(595);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(591);
                            match(COMMA);
                            setState(592);
                            pathExpr();
                        }
                    }
                    setState(597);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(598);
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
                setState(600);
                match(LBRACKET);
                setState(601);
                newValue();
                setState(606);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(602);
                            match(COMMA);
                            setState(603);
                            newValue();
                        }
                    }
                    setState(608);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(609);
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
                setState(611);
                match(DROP);
                setState(612);
                match(TABLE);
                setState(613);
                match(WORD);
                setState(615);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CASCADE) {
                    {
                        setState(614);
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
                setState(617);
                match(SHOW);
                setState(618);
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

    public static class CreateIndexStatContext extends EnhancedParserRuleContext {
        public TerminalNode CREATE() {
            return getToken(OQLParser.CREATE, 0);
        }

        public TerminalNode INDEX() {
            return getToken(OQLParser.INDEX, 0);
        }

        public List<TerminalNode> WORD() {
            return getTokens(OQLParser.WORD);
        }

        public TerminalNode WORD(int i) {
            return getToken(OQLParser.WORD, i);
        }

        public TerminalNode ON() {
            return getToken(OQLParser.ON, 0);
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

        public CreateIndexStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_createIndexStat;
        }
    }

    public final CreateIndexStatContext createIndexStat() throws RecognitionException {
        CreateIndexStatContext _localctx = new CreateIndexStatContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_createIndexStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(620);
                match(CREATE);
                setState(621);
                match(INDEX);
                setState(622);
                match(WORD);
                setState(623);
                match(ON);
                setState(624);
                match(WORD);
                setState(625);
                match(LBRACKET);
                setState(626);
                pathExpr();
                setState(627);
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

    public static class DropIndexStatContext extends EnhancedParserRuleContext {
        public TerminalNode DROP() {
            return getToken(OQLParser.DROP, 0);
        }

        public TerminalNode INDEX() {
            return getToken(OQLParser.INDEX, 0);
        }

        public List<TerminalNode> WORD() {
            return getTokens(OQLParser.WORD);
        }

        public TerminalNode WORD(int i) {
            return getToken(OQLParser.WORD, i);
        }

        public TerminalNode ON() {
            return getToken(OQLParser.ON, 0);
        }

        public DropIndexStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dropIndexStat;
        }
    }

    public final DropIndexStatContext dropIndexStat() throws RecognitionException {
        DropIndexStatContext _localctx = new DropIndexStatContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_dropIndexStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(629);
                match(DROP);
                setState(630);
                match(INDEX);
                setState(631);
                match(WORD);
                setState(632);
                match(ON);
                setState(633);
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

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3`\u027e\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2\3" +
                    "\2\3\2\3\2\3\2\5\2\u0094\n\2\3\3\3\3\5\3\u0098\n\3\3\3\3\3\3\3\5\3\u009d" +
                    "\n\3\3\3\5\3\u00a0\n\3\3\3\5\3\u00a3\n\3\3\3\5\3\u00a6\n\3\3\4\3\4\3\4" +
                    "\7\4\u00ab\n\4\f\4\16\4\u00ae\13\4\3\5\3\5\5\5\u00b2\n\5\3\6\3\6\3\6\3" +
                    "\6\7\6\u00b8\n\6\f\6\16\6\u00bb\13\6\3\7\3\7\5\7\u00bf\n\7\3\7\3\7\7\7" +
                    "\u00c3\n\7\f\7\16\7\u00c6\13\7\3\b\3\b\3\b\5\b\u00cb\n\b\3\b\3\b\3\b\3" +
                    "\b\3\t\3\t\3\t\7\t\u00d4\n\t\f\t\16\t\u00d7\13\t\3\n\3\n\3\n\3\n\5\n\u00dd" +
                    "\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16" +
                    "\5\16\u00ed\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00f7\n" +
                    "\20\f\20\16\20\u00fa\13\20\3\21\3\21\5\21\u00fe\n\21\3\21\5\21\u0101\n" +
                    "\21\3\22\3\22\3\22\7\22\u0106\n\22\f\22\16\22\u0109\13\22\3\23\3\23\3" +
                    "\23\7\23\u010e\n\23\f\23\16\23\u0111\13\23\3\24\3\24\3\24\3\24\3\24\5" +
                    "\24\u0118\n\24\3\25\3\25\3\25\3\25\5\25\u011e\n\25\3\26\3\26\5\26\u0122" +
                    "\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u012b\n\26\3\26\3\26\3\26" +
                    "\3\26\3\26\5\26\u0132\n\26\3\27\3\27\5\27\u0136\n\27\3\27\3\27\3\27\3" +
                    "\30\3\30\3\30\3\30\7\30\u013f\n\30\f\30\16\30\u0142\13\30\3\30\3\30\3" +
                    "\31\3\31\3\32\3\32\5\32\u014a\n\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33" +
                    "\3\33\3\33\5\33\u0163\n\33\3\34\3\34\3\35\3\35\5\35\u0169\n\35\3\36\3" +
                    "\36\3\36\7\36\u016e\n\36\f\36\16\36\u0171\13\36\3\37\3\37\3\37\7\37\u0176" +
                    "\n\37\f\37\16\37\u0179\13\37\3 \5 \u017c\n \3 \3 \3!\3!\3!\3!\3!\5!\u0185" +
                    "\n!\3\"\3\"\3#\3#\5#\u018b\n#\3$\3$\5$\u018f\n$\3%\3%\5%\u0193\n%\3&\3" +
                    "&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\5-\u01a7\n-\3-\5-" +
                    "\u01aa\n-\3-\5-\u01ad\n-\3.\3.\3/\3/\3/\3/\7/\u01b5\n/\f/\16/\u01b8\13" +
                    "/\3/\3/\3\60\3\60\3\60\7\60\u01bf\n\60\f\60\16\60\u01c2\13\60\3\61\3\61" +
                    "\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61" +
                    "\3\61\3\61\3\61\5\61\u01d7\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01df" +
                    "\n\62\3\63\3\63\3\63\3\63\7\63\u01e5\n\63\f\63\16\63\u01e8\13\63\3\64" +
                    "\3\64\3\64\3\64\3\64\3\64\7\64\u01f0\n\64\f\64\16\64\u01f3\13\64\3\64" +
                    "\3\64\3\65\3\65\5\65\u01f9\n\65\3\66\3\66\3\66\5\66\u01fe\n\66\3\66\3" +
                    "\66\3\66\3\66\3\66\7\66\u0205\n\66\f\66\16\66\u0208\13\66\3\66\5\66\u020b" +
                    "\n\66\3\67\3\67\3\67\3\67\38\38\38\38\38\58\u0216\n8\39\39\39\39\79\u021c" +
                    "\n9\f9\169\u021f\139\39\39\3:\3:\3:\3:\5:\u0227\n:\3;\3;\3;\3;\7;\u022d" +
                    "\n;\f;\16;\u0230\13;\3;\3;\3<\3<\3<\3<\3<\5<\u0239\n<\3=\3=\5=\u023d\n" +
                    "=\3>\3>\3>\3>\5>\u0243\n>\3>\3>\3?\3?\3?\3?\5?\u024b\n?\3?\3?\3?\3@\3" +
                    "@\3@\3@\7@\u0254\n@\f@\16@\u0257\13@\3@\3@\3A\3A\3A\3A\7A\u025f\nA\fA" +
                    "\16A\u0262\13A\3A\3A\3B\3B\3B\3B\5B\u026a\nB\3C\3C\3C\3D\3D\3D\3D\3D\3" +
                    "D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\2\2F\2\4\6\b\n\f\16\20\22\24\26\30\32" +
                    "\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080" +
                    "\u0082\u0084\u0086\u0088\2\b\3\2\22\26\3\2IN\3\2GH\3\2EF\3\2_`\4\2YY_" +
                    "_\2\u028b\2\u0093\3\2\2\2\4\u0095\3\2\2\2\6\u00a7\3\2\2\2\b\u00b1\3\2" +
                    "\2\2\n\u00b3\3\2\2\2\f\u00bc\3\2\2\2\16\u00c7\3\2\2\2\20\u00d0\3\2\2\2" +
                    "\22\u00d8\3\2\2\2\24\u00de\3\2\2\2\26\u00e3\3\2\2\2\30\u00e5\3\2\2\2\32" +
                    "\u00e8\3\2\2\2\34\u00ee\3\2\2\2\36\u00f1\3\2\2\2 \u00fb\3\2\2\2\"\u0102" +
                    "\3\2\2\2$\u010a\3\2\2\2&\u0117\3\2\2\2(\u011d\3\2\2\2*\u0131\3\2\2\2," +
                    "\u0133\3\2\2\2.\u013a\3\2\2\2\60\u0145\3\2\2\2\62\u0147\3\2\2\2\64\u0162" +
                    "\3\2\2\2\66\u0164\3\2\2\28\u0168\3\2\2\2:\u016a\3\2\2\2<\u0172\3\2\2\2" +
                    ">\u017b\3\2\2\2@\u0184\3\2\2\2B\u0186\3\2\2\2D\u018a\3\2\2\2F\u018e\3" +
                    "\2\2\2H\u0192\3\2\2\2J\u0194\3\2\2\2L\u0196\3\2\2\2N\u0198\3\2\2\2P\u019a" +
                    "\3\2\2\2R\u019c\3\2\2\2T\u019e\3\2\2\2V\u01a0\3\2\2\2X\u01a2\3\2\2\2Z" +
                    "\u01ae\3\2\2\2\\\u01b0\3\2\2\2^\u01bb\3\2\2\2`\u01d6\3\2\2\2b\u01de\3" +
                    "\2\2\2d\u01e0\3\2\2\2f\u01e9\3\2\2\2h\u01f6\3\2\2\2j\u01fa\3\2\2\2l\u020c" +
                    "\3\2\2\2n\u0215\3\2\2\2p\u0217\3\2\2\2r\u0226\3\2\2\2t\u0228\3\2\2\2v" +
                    "\u0238\3\2\2\2x\u023a\3\2\2\2z\u023e\3\2\2\2|\u0246\3\2\2\2~\u024f\3\2" +
                    "\2\2\u0080\u025a\3\2\2\2\u0082\u0265\3\2\2\2\u0084\u026b\3\2\2\2\u0086" +
                    "\u026e\3\2\2\2\u0088\u0277\3\2\2\2\u008a\u0094\5\4\3\2\u008b\u0094\5X" +
                    "-\2\u008c\u0094\5|?\2\u008d\u0094\5h\65\2\u008e\u0094\5x=\2\u008f\u0094" +
                    "\5\u0082B\2\u0090\u0094\5\u0084C\2\u0091\u0094\5\u0086D\2\u0092\u0094" +
                    "\5\u0088E\2\u0093\u008a\3\2\2\2\u0093\u008b\3\2\2\2\u0093\u008c\3\2\2" +
                    "\2\u0093\u008d\3\2\2\2\u0093\u008e\3\2\2\2\u0093\u008f\3\2\2\2\u0093\u0090" +
                    "\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094\3\3\2\2\2\u0095" +
                    "\u0097\7\3\2\2\u0096\u0098\7\17\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3" +
                    "\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\5\6\4\2\u009a\u009c\5\n\6\2\u009b" +
                    "\u009d\5\30\r\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3" +
                    "\2\2\2\u009e\u00a0\5\32\16\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0" +
                    "\u00a2\3\2\2\2\u00a1\u00a3\5\36\20\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3" +
                    "\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a6\5\22\n\2\u00a5\u00a4\3\2\2\2\u00a5" +
                    "\u00a6\3\2\2\2\u00a6\5\3\2\2\2\u00a7\u00ac\5\b\5\2\u00a8\u00a9\7T\2\2" +
                    "\u00a9\u00ab\5\b\5\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa" +
                    "\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\7\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af" +
                    "\u00b2\5\20\t\2\u00b0\u00b2\5\24\13\2\u00b1\u00af\3\2\2\2\u00b1\u00b0" +
                    "\3\2\2\2\u00b2\t\3\2\2\2\u00b3\u00b4\7\b\2\2\u00b4\u00b9\5\f\7\2\u00b5" +
                    "\u00b6\7T\2\2\u00b6\u00b8\5\f\7\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2" +
                    "\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\13\3\2\2\2\u00bb\u00b9" +
                    "\3\2\2\2\u00bc\u00be\5L\'\2\u00bd\u00bf\7\t\2\2\u00be\u00bd\3\2\2\2\u00be" +
                    "\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c4\5V,\2\u00c1\u00c3\5\16" +
                    "\b\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4" +
                    "\u00c5\3\2\2\2\u00c5\r\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\r\2\2" +
                    "\u00c8\u00ca\5L\'\2\u00c9\u00cb\7\t\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb" +
                    "\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\5V,\2\u00cd\u00ce\7@\2\2\u00ce" +
                    "\u00cf\5\"\22\2\u00cf\17\3\2\2\2\u00d0\u00d5\5V,\2\u00d1\u00d2\7O\2\2" +
                    "\u00d2\u00d4\5T+\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3" +
                    "\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\21\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8" +
                    "\u00d9\7=\2\2\u00d9\u00dc\7_\2\2\u00da\u00db\7T\2\2\u00db\u00dd\7_\2\2" +
                    "\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\23\3\2\2\2\u00de\u00df" +
                    "\5\26\f\2\u00df\u00e0\7P\2\2\u00e0\u00e1\5\20\t\2\u00e1\u00e2\7Q\2\2\u00e2" +
                    "\25\3\2\2\2\u00e3\u00e4\t\2\2\2\u00e4\27\3\2\2\2\u00e5\u00e6\7\27\2\2" +
                    "\u00e6\u00e7\5\"\22\2\u00e7\31\3\2\2\2\u00e8\u00e9\7\30\2\2\u00e9\u00ea" +
                    "\7\31\2\2\u00ea\u00ec\5\20\t\2\u00eb\u00ed\5\34\17\2\u00ec\u00eb\3\2\2" +
                    "\2\u00ec\u00ed\3\2\2\2\u00ed\33\3\2\2\2\u00ee\u00ef\7\33\2\2\u00ef\u00f0" +
                    "\5\"\22\2\u00f0\35\3\2\2\2\u00f1\u00f2\7\32\2\2\u00f2\u00f3\7\31\2\2\u00f3" +
                    "\u00f8\5 \21\2\u00f4\u00f5\7T\2\2\u00f5\u00f7\5 \21\2\u00f6\u00f4\3\2" +
                    "\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9" +
                    "\37\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u0100\5\20\t\2\u00fc\u00fe\7\35" +
                    "\2\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff" +
                    "\u0101\7\34\2\2\u0100\u00fd\3\2\2\2\u0100\u00ff\3\2\2\2\u0101!\3\2\2\2" +
                    "\u0102\u0107\5$\23\2\u0103\u0104\7%\2\2\u0104\u0106\5$\23\2\u0105\u0103" +
                    "\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108" +
                    "#\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010f\5&\24\2\u010b\u010c\7$\2\2\u010c" +
                    "\u010e\5&\24\2\u010d\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2" +
                    "\2\2\u010f\u0110\3\2\2\2\u0110%\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0118" +
                    "\5(\25\2\u0113\u0114\7P\2\2\u0114\u0115\5\"\22\2\u0115\u0116\7Q\2\2\u0116" +
                    "\u0118\3\2\2\2\u0117\u0112\3\2\2\2\u0117\u0113\3\2\2\2\u0118\'\3\2\2\2" +
                    "\u0119\u011e\5\64\33\2\u011a\u011e\5*\26\2\u011b\u011e\5\62\32\2\u011c" +
                    "\u011e\5,\27\2\u011d\u0119\3\2\2\2\u011d\u011a\3\2\2\2\u011d\u011b\3\2" +
                    "\2\2\u011d\u011c\3\2\2\2\u011e)\3\2\2\2\u011f\u0121\58\35\2\u0120\u0122" +
                    "\7\36\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2" +
                    "\u0123\u0124\7 \2\2\u0124\u0125\58\35\2\u0125\u0126\7$\2\2\u0126\u0127" +
                    "\58\35\2\u0127\u0132\3\2\2\2\u0128\u012a\5B\"\2\u0129\u012b\7\36\2\2\u012a" +
                    "\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7 " +
                    "\2\2\u012d\u012e\5B\"\2\u012e\u012f\7$\2\2\u012f\u0130\5B\"\2\u0130\u0132" +
                    "\3\2\2\2\u0131\u011f\3\2\2\2\u0131\u0128\3\2\2\2\u0132+\3\2\2\2\u0133" +
                    "\u0135\5\20\t\2\u0134\u0136\7\36\2\2\u0135\u0134\3\2\2\2\u0135\u0136\3" +
                    "\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\7\'\2\2\u0138\u0139\5.\30\2\u0139" +
                    "-\3\2\2\2\u013a\u013b\7P\2\2\u013b\u0140\5\60\31\2\u013c\u013d\7T\2\2" +
                    "\u013d\u013f\5\60\31\2\u013e\u013c\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e" +
                    "\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143" +
                    "\u0144\7Q\2\2\u0144/\3\2\2\2\u0145\u0146\5R*\2\u0146\61\3\2\2\2\u0147" +
                    "\u0149\5B\"\2\u0148\u014a\7\36\2\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2" +
                    "\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7&\2\2\u014c\u014d\5N(\2\u014d\63" +
                    "\3\2\2\2\u014e\u014f\5B\"\2\u014f\u0150\5\66\34\2\u0150\u0151\5B\"\2\u0151" +
                    "\u0163\3\2\2\2\u0152\u0153\58\35\2\u0153\u0154\5\66\34\2\u0154\u0155\5" +
                    "8\35\2\u0155\u0163\3\2\2\2\u0156\u0157\5\24\13\2\u0157\u0158\5\66\34\2" +
                    "\u0158\u0159\58\35\2\u0159\u0163\3\2\2\2\u015a\u015b\5F$\2\u015b\u015c" +
                    "\5\66\34\2\u015c\u015d\5F$\2\u015d\u0163\3\2\2\2\u015e\u015f\5H%\2\u015f" +
                    "\u0160\5\66\34\2\u0160\u0161\5H%\2\u0161\u0163\3\2\2\2\u0162\u014e\3\2" +
                    "\2\2\u0162\u0152\3\2\2\2\u0162\u0156\3\2\2\2\u0162\u015a\3\2\2\2\u0162" +
                    "\u015e\3\2\2\2\u0163\65\3\2\2\2\u0164\u0165\t\3\2\2\u0165\67\3\2\2\2\u0166" +
                    "\u0169\5\20\t\2\u0167\u0169\5:\36\2\u0168\u0166\3\2\2\2\u0168\u0167\3" +
                    "\2\2\2\u01699\3\2\2\2\u016a\u016f\5<\37\2\u016b\u016c\t\4\2\2\u016c\u016e" +
                    "\5<\37\2\u016d\u016b\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f" +
                    "\u0170\3\2\2\2\u0170;\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0177\5> \2\u0173" +
                    "\u0174\t\5\2\2\u0174\u0176\5> \2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2" +
                    "\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178=\3\2\2\2\u0179\u0177" +
                    "\3\2\2\2\u017a\u017c\t\4\2\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c" +
                    "\u017d\3\2\2\2\u017d\u017e\5@!\2\u017e?\3\2\2\2\u017f\u0185\5P)\2\u0180" +
                    "\u0181\7P\2\2\u0181\u0182\5:\36\2\u0182\u0183\7Q\2\2\u0183\u0185\3\2\2" +
                    "\2\u0184\u017f\3\2\2\2\u0184\u0180\3\2\2\2\u0185A\3\2\2\2\u0186\u0187" +
                    "\5D#\2\u0187C\3\2\2\2\u0188\u018b\5\20\t\2\u0189\u018b\5J&\2\u018a\u0188" +
                    "\3\2\2\2\u018a\u0189\3\2\2\2\u018bE\3\2\2\2\u018c\u018f\5\20\t\2\u018d" +
                    "\u018f\5t;\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2\2\u018fG\3\2\2\2\u0190" +
                    "\u0193\5\20\t\2\u0191\u0193\5p9\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2" +
                    "\2\2\u0193I\3\2\2\2\u0194\u0195\7X\2\2\u0195K\3\2\2\2\u0196\u0197\7Y\2" +
                    "\2\u0197M\3\2\2\2\u0198\u0199\7Y\2\2\u0199O\3\2\2\2\u019a\u019b\t\6\2" +
                    "\2\u019bQ\3\2\2\2\u019c\u019d\7Y\2\2\u019dS\3\2\2\2\u019e\u019f\t\7\2" +
                    "\2\u019fU\3\2\2\2\u01a0\u01a1\7Y\2\2\u01a1W\3\2\2\2\u01a2\u01a3\7\4\2" +
                    "\2\u01a3\u01a4\79\2\2\u01a4\u01a6\5Z.\2\u01a5\u01a7\5\\/\2\u01a6\u01a5" +
                    "\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01aa\5d\63\2\u01a9" +
                    "\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01ad\5f" +
                    "\64\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2\u01adY\3\2\2\2\u01ae\u01af" +
                    "\7Y\2\2\u01af[\3\2\2\2\u01b0\u01b1\7P\2\2\u01b1\u01b6\5^\60\2\u01b2\u01b3" +
                    "\7T\2\2\u01b3\u01b5\5^\60\2\u01b4\u01b2\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6" +
                    "\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2" +
                    "\2\2\u01b9\u01ba\7Q\2\2\u01ba]\3\2\2\2\u01bb\u01bc\7Y\2\2\u01bc\u01c0" +
                    "\5`\61\2\u01bd\u01bf\5b\62\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0" +
                    "\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1_\3\2\2\2\u01c2\u01c0\3\2\2\2" +
                    "\u01c3\u01d7\7\64\2\2\u01c4\u01d7\7\65\2\2\u01c5\u01c6\7\66\2\2\u01c6" +
                    "\u01c7\7P\2\2\u01c7\u01c8\7_\2\2\u01c8\u01d7\7Q\2\2\u01c9\u01ca\7,\2\2" +
                    "\u01ca\u01cb\7P\2\2\u01cb\u01cc\5`\61\2\u01cc\u01cd\7T\2\2\u01cd\u01ce" +
                    "\7_\2\2\u01ce\u01cf\7Q\2\2\u01cf\u01d7\3\2\2\2\u01d0\u01d1\78\2\2\u01d1" +
                    "\u01d2\7P\2\2\u01d2\u01d3\7Y\2\2\u01d3\u01d7\7Q\2\2\u01d4\u01d5\7\20\2" +
                    "\2\u01d5\u01d7\5\\/\2\u01d6\u01c3\3\2\2\2\u01d6\u01c4\3\2\2\2\u01d6\u01c5" +
                    "\3\2\2\2\u01d6\u01c9\3\2\2\2\u01d6\u01d0\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7" +
                    "a\3\2\2\2\u01d8\u01df\7;\2\2\u01d9\u01da\7*\2\2\u01da\u01df\7+\2\2\u01db" +
                    "\u01dc\7<\2\2\u01dc\u01df\7+\2\2\u01dd\u01df\7C\2\2\u01de\u01d8\3\2\2" +
                    "\2\u01de\u01d9\3\2\2\2\u01de\u01db\3\2\2\2\u01de\u01dd\3\2\2\2\u01dfc" +
                    "\3\2\2\2\u01e0\u01e1\7-\2\2\u01e1\u01e6\7Y\2\2\u01e2\u01e3\7T\2\2\u01e3" +
                    "\u01e5\7Y\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2" +
                    "\2\2\u01e6\u01e7\3\2\2\2\u01e7e\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea" +
                    "\7*\2\2\u01ea\u01eb\7+\2\2\u01eb\u01ec\7P\2\2\u01ec\u01f1\5\20\t\2\u01ed" +
                    "\u01ee\7T\2\2\u01ee\u01f0\5\20\t\2\u01ef\u01ed\3\2\2\2\u01f0\u01f3\3\2" +
                    "\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3" +
                    "\u01f1\3\2\2\2\u01f4\u01f5\7Q\2\2\u01f5g\3\2\2\2\u01f6\u01f8\5j\66\2\u01f7" +
                    "\u01f9\5\30\r\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9i\3\2\2\2" +
                    "\u01fa\u01fb\7\5\2\2\u01fb\u01fd\5L\'\2\u01fc\u01fe\7\t\2\2\u01fd\u01fc" +
                    "\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\5V,\2\u0200" +
                    "\u0201\7\37\2\2\u0201\u0206\5l\67\2\u0202\u0203\7T\2\2\u0203\u0205\5l" +
                    "\67\2\u0204\u0202\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206" +
                    "\u0207\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020b\5\30" +
                    "\r\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020bk\3\2\2\2\u020c\u020d" +
                    "\5\20\t\2\u020d\u020e\7I\2\2\u020e\u020f\5n8\2\u020fm\3\2\2\2\u0210\u0216" +
                    "\5:\36\2\u0211\u0216\5D#\2\u0212\u0216\5t;\2\u0213\u0216\5p9\2\u0214\u0216" +
                    "\7\"\2\2\u0215\u0210\3\2\2\2\u0215\u0211\3\2\2\2\u0215\u0212\3\2\2\2\u0215" +
                    "\u0213\3\2\2\2\u0215\u0214\3\2\2\2\u0216o\3\2\2\2\u0217\u0218\7R\2\2\u0218" +
                    "\u021d\5r:\2\u0219\u021a\7T\2\2\u021a\u021c\5r:\2\u021b\u0219\3\2\2\2" +
                    "\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0220" +
                    "\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\7S\2\2\u0221q\3\2\2\2\u0222\u0223" +
                    "\7_\2\2\u0223\u0224\7V\2\2\u0224\u0227\5n8\2\u0225\u0227\5n8\2\u0226\u0222" +
                    "\3\2\2\2\u0226\u0225\3\2\2\2\u0227s\3\2\2\2\u0228\u0229\7P\2\2\u0229\u022e" +
                    "\5v<\2\u022a\u022b\7T\2\2\u022b\u022d\5v<\2\u022c\u022a\3\2\2\2\u022d" +
                    "\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0231\3\2" +
                    "\2\2\u0230\u022e\3\2\2\2\u0231\u0232\7Q\2\2\u0232u\3\2\2\2\u0233\u0234" +
                    "\5\20\t\2\u0234\u0235\7V\2\2\u0235\u0236\5n8\2\u0236\u0239\3\2\2\2\u0237" +
                    "\u0239\5n8\2\u0238\u0233\3\2\2\2\u0238\u0237\3\2\2\2\u0239w\3\2\2\2\u023a" +
                    "\u023c\5z>\2\u023b\u023d\5\30\r\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2" +
                    "\2\2\u023dy\3\2\2\2\u023e\u023f\7\6\2\2\u023f\u0240\7\b\2\2\u0240\u0242" +
                    "\5L\'\2\u0241\u0243\7\t\2\2\u0242\u0241\3\2\2\2\u0242\u0243\3\2\2\2\u0243" +
                    "\u0244\3\2\2\2\u0244\u0245\5V,\2\u0245{\3\2\2\2\u0246\u0247\7\7\2\2\u0247" +
                    "\u0248\7(\2\2\u0248\u024a\5Z.\2\u0249\u024b\5~@\2\u024a\u0249\3\2\2\2" +
                    "\u024a\u024b\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\7)\2\2\u024d\u024e" +
                    "\5\u0080A\2\u024e}\3\2\2\2\u024f\u0250\7P\2\2\u0250\u0255\5\20\t\2\u0251" +
                    "\u0252\7T\2\2\u0252\u0254\5\20\t\2\u0253\u0251\3\2\2\2\u0254\u0257\3\2" +
                    "\2\2\u0255\u0253\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u0258\3\2\2\2\u0257" +
                    "\u0255\3\2\2\2\u0258\u0259\7Q\2\2\u0259\177\3\2\2\2\u025a\u025b\7P\2\2" +
                    "\u025b\u0260\5n8\2\u025c\u025d\7T\2\2\u025d\u025f\5n8\2\u025e\u025c\3" +
                    "\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261" +
                    "\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0264\7Q\2\2\u0264\u0081\3\2" +
                    "\2\2\u0265\u0266\7>\2\2\u0266\u0267\79\2\2\u0267\u0269\7Y\2\2\u0268\u026a" +
                    "\7?\2\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u0083\3\2\2\2\u026b" +
                    "\u026c\7A\2\2\u026c\u026d\7B\2\2\u026d\u0085\3\2\2\2\u026e\u026f\7\4\2" +
                    "\2\u026f\u0270\7D\2\2\u0270\u0271\7Y\2\2\u0271\u0272\7@\2\2\u0272\u0273" +
                    "\7Y\2\2\u0273\u0274\7P\2\2\u0274\u0275\5\20\t\2\u0275\u0276\7Q\2\2\u0276" +
                    "\u0087\3\2\2\2\u0277\u0278\7>\2\2\u0278\u0279\7D\2\2\u0279\u027a\7Y\2" +
                    "\2\u027a\u027b\7@\2\2\u027b\u027c\7Y\2\2\u027c\u0089\3\2\2\2?\u0093\u0097" +
                    "\u009c\u009f\u00a2\u00a5\u00ac\u00b1\u00b9\u00be\u00c4\u00ca\u00d5\u00dc" +
                    "\u00ec\u00f8\u00fd\u0100\u0107\u010f\u0117\u011d\u0121\u012a\u0131\u0135" +
                    "\u0140\u0149\u0162\u0168\u016f\u0177\u017b\u0184\u018a\u018e\u0192\u01a6" +
                    "\u01a9\u01ac\u01b6\u01c0\u01d6\u01de\u01e6\u01f1\u01f8\u01fd\u0206\u020a" +
                    "\u0215\u021d\u0226\u022e\u0238\u023c\u0242\u024a\u0255\u0260\u0269";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}