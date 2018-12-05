// Generated from D:/杂乱文件终章/oodb/server/src/test/java\OQL.g4 by ANTLR 4.7
package cn.ouctechnology.oodb.parser;

import cn.ouctechnology.oodb.exception.ParseException;
import cn.ouctechnology.oodb.execute.*;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.transcation.Transaction;
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
    public static final int
            SELECT = 1, CREATE = 2, UPDATE = 3, DELETE = 4, INSERT = 5, FROM = 6, AS = 7, LEFT = 8,
            RIGHT = 9, OUTER = 10, JOIN = 11, INNER = 12, DISTINCT = 13, OBJECT = 14, NEW = 15,
            AVG = 16, SUM = 17, MAX = 18, MIN = 19, COUNT = 20, WHERE = 21, GROUP = 22, BY = 23, ORDER = 24,
            HAVING = 25, DESC = 26, ASC = 27, NOT = 28, SET = 29, BETWEEN = 30, IS = 31, NULL = 32,
            ESCAPE = 33, AND = 34, OR = 35, LIKE = 36, IN = 37, INTO = 38, VALUES = 39, PRIMARY = 40,
            KEY = 41, LISTOF = 42, EXTENDS = 43, EMPTY = 44, MEMBER = 45, OF = 46, ALL = 47, ANY = 48,
            SOME = 49, INT = 50, FLOAT = 51, CHAR = 52, SETOF = 53, REF = 54, TABLE = 55, EXISTS = 56,
            AUTO_INCREMENT = 57, UNIQUE = 58, LIMIT = 59, DROP = 60, CASCADE = 61, ON = 62, SHOW = 63,
            TABLES = 64, FINAL = 65, INDEX = 66, SYNC = 67, BEGIN = 68, TRANSACTION = 69, COMMIT = 70,
            ROLL = 71, BACK = 72, ASSIGN = 73, UUID = 74, MUL = 75, DIV = 76, PLUS = 77, MINUS = 78,
            EQ = 79, GR = 80, LS = 81, GE = 82, LE = 83, NE = 84, DOT = 85, LBRACKET = 86, RBRACKET = 87,
            LFRACKET = 88, RFRACKET = 89, COMMA = 90, SEMI = 91, COLON = 92, TRIMCHARACTER = 93,
            STRINGLITERAL = 94, WORD = 95, NAMEDPARAMETER = 96, WS = 97, COMMENT = 98, LINECOMMENT = 99,
            ESCAPECHARACTER = 100, INTNUMERAL = 101, FLOATNUMERAL = 102;
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
            RULE_dropStat = 64, RULE_showStat = 65, RULE_createIndexStat = 66, RULE_dropIndexStat = 67,
            RULE_syncStat = 68, RULE_beginTranStat = 69, RULE_commitStat = 70, RULE_rollBackStat = 71;
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
            "dropStat", "showStat", "createIndexStat", "dropIndexStat", "syncStat",
            "beginTranStat", "commitStat", "rollBackStat"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3h\u0296\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I" +
                    "\tI\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00a0\n\2" +
                    "\3\3\3\3\5\3\u00a4\n\3\3\3\3\3\3\3\5\3\u00a9\n\3\3\3\5\3\u00ac\n\3\3\3" +
                    "\5\3\u00af\n\3\3\3\5\3\u00b2\n\3\3\4\3\4\3\4\7\4\u00b7\n\4\f\4\16\4\u00ba" +
                    "\13\4\3\5\3\5\5\5\u00be\n\5\3\6\3\6\3\6\3\6\7\6\u00c4\n\6\f\6\16\6\u00c7" +
                    "\13\6\3\7\3\7\5\7\u00cb\n\7\3\7\3\7\7\7\u00cf\n\7\f\7\16\7\u00d2\13\7" +
                    "\3\b\3\b\3\b\5\b\u00d7\n\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00e0\n\t\f" +
                    "\t\16\t\u00e3\13\t\3\n\3\n\3\n\3\n\5\n\u00e9\n\n\3\13\3\13\3\13\3\13\3" +
                    "\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00f9\n\16\3\17\3\17" +
                    "\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u0103\n\20\f\20\16\20\u0106\13\20" +
                    "\3\21\3\21\5\21\u010a\n\21\3\21\5\21\u010d\n\21\3\22\3\22\3\22\7\22\u0112" +
                    "\n\22\f\22\16\22\u0115\13\22\3\23\3\23\3\23\7\23\u011a\n\23\f\23\16\23" +
                    "\u011d\13\23\3\24\3\24\3\24\3\24\3\24\5\24\u0124\n\24\3\25\3\25\3\25\3" +
                    "\25\5\25\u012a\n\25\3\26\3\26\5\26\u012e\n\26\3\26\3\26\3\26\3\26\3\26" +
                    "\3\26\3\26\5\26\u0137\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u013e\n\26\3" +
                    "\27\3\27\5\27\u0142\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u014b" +
                    "\n\30\f\30\16\30\u014e\13\30\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u0156" +
                    "\n\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33" +
                    "\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u016f\n\33\3\34" +
                    "\3\34\3\35\3\35\5\35\u0175\n\35\3\36\3\36\3\36\7\36\u017a\n\36\f\36\16" +
                    "\36\u017d\13\36\3\37\3\37\3\37\7\37\u0182\n\37\f\37\16\37\u0185\13\37" +
                    "\3 \5 \u0188\n \3 \3 \3!\3!\3!\3!\3!\5!\u0191\n!\3\"\3\"\3#\3#\5#\u0197" +
                    "\n#\3$\3$\5$\u019b\n$\3%\3%\5%\u019f\n%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3" +
                    "*\3+\3+\3,\3,\3-\3-\3-\3-\5-\u01b3\n-\3-\5-\u01b6\n-\3-\5-\u01b9\n-\3" +
                    ".\3.\3/\3/\3/\3/\7/\u01c1\n/\f/\16/\u01c4\13/\3/\3/\3\60\3\60\3\60\7\60" +
                    "\u01cb\n\60\f\60\16\60\u01ce\13\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61" +
                    "\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u01e3" +
                    "\n\61\3\62\3\62\3\62\5\62\u01e8\n\62\3\62\5\62\u01eb\n\62\3\63\3\63\3" +
                    "\63\3\63\7\63\u01f1\n\63\f\63\16\63\u01f4\13\63\3\64\3\64\3\64\3\64\3" +
                    "\64\3\64\7\64\u01fc\n\64\f\64\16\64\u01ff\13\64\3\64\3\64\5\64\u0203\n" +
                    "\64\3\65\3\65\5\65\u0207\n\65\3\66\3\66\3\66\5\66\u020c\n\66\3\66\3\66" +
                    "\3\66\3\66\3\66\7\66\u0213\n\66\f\66\16\66\u0216\13\66\3\66\5\66\u0219" +
                    "\n\66\3\67\3\67\3\67\3\67\38\38\38\38\38\58\u0224\n8\39\39\39\39\79\u022a" +
                    "\n9\f9\169\u022d\139\39\39\3:\3:\3:\3:\5:\u0235\n:\3;\3;\3;\3;\7;\u023b" +
                    "\n;\f;\16;\u023e\13;\3;\3;\3<\3<\3<\3<\3<\5<\u0247\n<\3=\3=\5=\u024b\n" +
                    "=\3>\3>\3>\3>\5>\u0251\n>\3>\3>\3?\3?\3?\3?\5?\u0259\n?\3?\3?\3?\3@\3" +
                    "@\3@\3@\7@\u0262\n@\f@\16@\u0265\13@\3@\3@\3A\3A\3A\3A\7A\u026d\nA\fA" +
                    "\16A\u0270\13A\3A\3A\3B\3B\3B\3B\5B\u0278\nB\3C\3C\3C\3D\3D\3D\3D\3D\3" +
                    "D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3G\3G\3G\3H\3H\3I\3I\3I\3I\2\2J\2\4" +
                    "\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP" +
                    "RTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e" +
                    "\u0090\2\t\3\2\22\26\3\2QV\3\2OP\3\2MN\3\2gh\4\2aagg\4\2;;KL\2\u02a3\2" +
                    "\u009f\3\2\2\2\4\u00a1\3\2\2\2\6\u00b3\3\2\2\2\b\u00bd\3\2\2\2\n\u00bf" +
                    "\3\2\2\2\f\u00c8\3\2\2\2\16\u00d3\3\2\2\2\20\u00dc\3\2\2\2\22\u00e4\3" +
                    "\2\2\2\24\u00ea\3\2\2\2\26\u00ef\3\2\2\2\30\u00f1\3\2\2\2\32\u00f4\3\2" +
                    "\2\2\34\u00fa\3\2\2\2\36\u00fd\3\2\2\2 \u0107\3\2\2\2\"\u010e\3\2\2\2" +
                    "$\u0116\3\2\2\2&\u0123\3\2\2\2(\u0129\3\2\2\2*\u013d\3\2\2\2,\u013f\3" +
                    "\2\2\2.\u0146\3\2\2\2\60\u0151\3\2\2\2\62\u0153\3\2\2\2\64\u016e\3\2\2" +
                    "\2\66\u0170\3\2\2\28\u0174\3\2\2\2:\u0176\3\2\2\2<\u017e\3\2\2\2>\u0187" +
                    "\3\2\2\2@\u0190\3\2\2\2B\u0192\3\2\2\2D\u0196\3\2\2\2F\u019a\3\2\2\2H" +
                    "\u019e\3\2\2\2J\u01a0\3\2\2\2L\u01a2\3\2\2\2N\u01a4\3\2\2\2P\u01a6\3\2" +
                    "\2\2R\u01a8\3\2\2\2T\u01aa\3\2\2\2V\u01ac\3\2\2\2X\u01ae\3\2\2\2Z\u01ba" +
                    "\3\2\2\2\\\u01bc\3\2\2\2^\u01c7\3\2\2\2`\u01e2\3\2\2\2b\u01ea\3\2\2\2" +
                    "d\u01ec\3\2\2\2f\u01f5\3\2\2\2h\u0204\3\2\2\2j\u0208\3\2\2\2l\u021a\3" +
                    "\2\2\2n\u0223\3\2\2\2p\u0225\3\2\2\2r\u0234\3\2\2\2t\u0236\3\2\2\2v\u0246" +
                    "\3\2\2\2x\u0248\3\2\2\2z\u024c\3\2\2\2|\u0254\3\2\2\2~\u025d\3\2\2\2\u0080" +
                    "\u0268\3\2\2\2\u0082\u0273\3\2\2\2\u0084\u0279\3\2\2\2\u0086\u027c\3\2" +
                    "\2\2\u0088\u0285\3\2\2\2\u008a\u028b\3\2\2\2\u008c\u028d\3\2\2\2\u008e" +
                    "\u0290\3\2\2\2\u0090\u0292\3\2\2\2\u0092\u00a0\5\4\3\2\u0093\u00a0\5X" +
                    "-\2\u0094\u00a0\5|?\2\u0095\u00a0\5h\65\2\u0096\u00a0\5x=\2\u0097\u00a0" +
                    "\5\u0082B\2\u0098\u00a0\5\u0084C\2\u0099\u00a0\5\u0086D\2\u009a\u00a0" +
                    "\5\u0088E\2\u009b\u00a0\5\u008aF\2\u009c\u00a0\5\u008cG\2\u009d\u00a0" +
                    "\5\u008eH\2\u009e\u00a0\5\u0090I\2\u009f\u0092\3\2\2\2\u009f\u0093\3\2" +
                    "\2\2\u009f\u0094\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u0096\3\2\2\2\u009f" +
                    "\u0097\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u0099\3\2\2\2\u009f\u009a\3\2" +
                    "\2\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f" +
                    "\u009e\3\2\2\2\u00a0\3\3\2\2\2\u00a1\u00a3\7\3\2\2\u00a2\u00a4\7\17\2" +
                    "\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6" +
                    "\5\6\4\2\u00a6\u00a8\5\n\6\2\u00a7\u00a9\5\30\r\2\u00a8\u00a7\3\2\2\2" +
                    "\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00ac\5\32\16\2\u00ab\u00aa" +
                    "\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00af\5\36\20\2" +
                    "\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00b2" +
                    "\5\22\n\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\5\3\2\2\2\u00b3" +
                    "\u00b8\5\b\5\2\u00b4\u00b5\7\\\2\2\u00b5\u00b7\5\b\5\2\u00b6\u00b4\3\2" +
                    "\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9" +
                    "\7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\5\20\t\2\u00bc\u00be\5\24\13" +
                    "\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\t\3\2\2\2\u00bf\u00c0" +
                    "\7\b\2\2\u00c0\u00c5\5\f\7\2\u00c1\u00c2\7\\\2\2\u00c2\u00c4\5\f\7\2\u00c3" +
                    "\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2" +
                    "\2\2\u00c6\13\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\5L\'\2\u00c9\u00cb" +
                    "\7\t\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc" +
                    "\u00d0\5V,\2\u00cd\u00cf\5\16\b\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2" +
                    "\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\r\3\2\2\2\u00d2\u00d0" +
                    "\3\2\2\2\u00d3\u00d4\7\r\2\2\u00d4\u00d6\5L\'\2\u00d5\u00d7\7\t\2\2\u00d6" +
                    "\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\5V" +
                    ",\2\u00d9\u00da\7@\2\2\u00da\u00db\5\"\22\2\u00db\17\3\2\2\2\u00dc\u00e1" +
                    "\5V,\2\u00dd\u00de\7W\2\2\u00de\u00e0\5T+\2\u00df\u00dd\3\2\2\2\u00e0" +
                    "\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\21\3\2\2" +
                    "\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7=\2\2\u00e5\u00e8\7g\2\2\u00e6\u00e7" +
                    "\7\\\2\2\u00e7\u00e9\7g\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9" +
                    "\23\3\2\2\2\u00ea\u00eb\5\26\f\2\u00eb\u00ec\7X\2\2\u00ec\u00ed\5\20\t" +
                    "\2\u00ed\u00ee\7Y\2\2\u00ee\25\3\2\2\2\u00ef\u00f0\t\2\2\2\u00f0\27\3" +
                    "\2\2\2\u00f1\u00f2\7\27\2\2\u00f2\u00f3\5\"\22\2\u00f3\31\3\2\2\2\u00f4" +
                    "\u00f5\7\30\2\2\u00f5\u00f6\7\31\2\2\u00f6\u00f8\5\20\t\2\u00f7\u00f9" +
                    "\5\34\17\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\33\3\2\2\2\u00fa" +
                    "\u00fb\7\33\2\2\u00fb\u00fc\5\"\22\2\u00fc\35\3\2\2\2\u00fd\u00fe\7\32" +
                    "\2\2\u00fe\u00ff\7\31\2\2\u00ff\u0104\5 \21\2\u0100\u0101\7\\\2\2\u0101" +
                    "\u0103\5 \21\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2" +
                    "\2\2\u0104\u0105\3\2\2\2\u0105\37\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010c" +
                    "\5\20\t\2\u0108\u010a\7\35\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2" +
                    "\u010a\u010d\3\2\2\2\u010b\u010d\7\34\2\2\u010c\u0109\3\2\2\2\u010c\u010b" +
                    "\3\2\2\2\u010d!\3\2\2\2\u010e\u0113\5$\23\2\u010f\u0110\7%\2\2\u0110\u0112" +
                    "\5$\23\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113" +
                    "\u0114\3\2\2\2\u0114#\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u011b\5&\24\2" +
                    "\u0117\u0118\7$\2\2\u0118\u011a\5&\24\2\u0119\u0117\3\2\2\2\u011a\u011d" +
                    "\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c%\3\2\2\2\u011d" +
                    "\u011b\3\2\2\2\u011e\u0124\5(\25\2\u011f\u0120\7X\2\2\u0120\u0121\5\"" +
                    "\22\2\u0121\u0122\7Y\2\2\u0122\u0124\3\2\2\2\u0123\u011e\3\2\2\2\u0123" +
                    "\u011f\3\2\2\2\u0124\'\3\2\2\2\u0125\u012a\5\64\33\2\u0126\u012a\5*\26" +
                    "\2\u0127\u012a\5\62\32\2\u0128\u012a\5,\27\2\u0129\u0125\3\2\2\2\u0129" +
                    "\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a)\3\2\2\2" +
                    "\u012b\u012d\58\35\2\u012c\u012e\7\36\2\2\u012d\u012c\3\2\2\2\u012d\u012e" +
                    "\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7 \2\2\u0130\u0131\58\35\2\u0131" +
                    "\u0132\7$\2\2\u0132\u0133\58\35\2\u0133\u013e\3\2\2\2\u0134\u0136\5B\"" +
                    "\2\u0135\u0137\7\36\2\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137" +
                    "\u0138\3\2\2\2\u0138\u0139\7 \2\2\u0139\u013a\5B\"\2\u013a\u013b\7$\2" +
                    "\2\u013b\u013c\5B\"\2\u013c\u013e\3\2\2\2\u013d\u012b\3\2\2\2\u013d\u0134" +
                    "\3\2\2\2\u013e+\3\2\2\2\u013f\u0141\5\20\t\2\u0140\u0142\7\36\2\2\u0141" +
                    "\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\7\'" +
                    "\2\2\u0144\u0145\5.\30\2\u0145-\3\2\2\2\u0146\u0147\7X\2\2\u0147\u014c" +
                    "\5\60\31\2\u0148\u0149\7\\\2\2\u0149\u014b\5\60\31\2\u014a\u0148\3\2\2" +
                    "\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f" +
                    "\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7Y\2\2\u0150/\3\2\2\2\u0151\u0152" +
                    "\5R*\2\u0152\61\3\2\2\2\u0153\u0155\5B\"\2\u0154\u0156\7\36\2\2\u0155" +
                    "\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7&" +
                    "\2\2\u0158\u0159\5N(\2\u0159\63\3\2\2\2\u015a\u015b\5B\"\2\u015b\u015c" +
                    "\5\66\34\2\u015c\u015d\5B\"\2\u015d\u016f\3\2\2\2\u015e\u015f\58\35\2" +
                    "\u015f\u0160\5\66\34\2\u0160\u0161\58\35\2\u0161\u016f\3\2\2\2\u0162\u0163" +
                    "\5\24\13\2\u0163\u0164\5\66\34\2\u0164\u0165\58\35\2\u0165\u016f\3\2\2" +
                    "\2\u0166\u0167\5F$\2\u0167\u0168\5\66\34\2\u0168\u0169\5F$\2\u0169\u016f" +
                    "\3\2\2\2\u016a\u016b\5H%\2\u016b\u016c\5\66\34\2\u016c\u016d\5H%\2\u016d" +
                    "\u016f\3\2\2\2\u016e\u015a\3\2\2\2\u016e\u015e\3\2\2\2\u016e\u0162\3\2" +
                    "\2\2\u016e\u0166\3\2\2\2\u016e\u016a\3\2\2\2\u016f\65\3\2\2\2\u0170\u0171" +
                    "\t\3\2\2\u0171\67\3\2\2\2\u0172\u0175\5\20\t\2\u0173\u0175\5:\36\2\u0174" +
                    "\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u01759\3\2\2\2\u0176\u017b\5<\37\2" +
                    "\u0177\u0178\t\4\2\2\u0178\u017a\5<\37\2\u0179\u0177\3\2\2\2\u017a\u017d" +
                    "\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c;\3\2\2\2\u017d" +
                    "\u017b\3\2\2\2\u017e\u0183\5> \2\u017f\u0180\t\5\2\2\u0180\u0182\5> \2" +
                    "\u0181\u017f\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184" +
                    "\3\2\2\2\u0184=\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0188\t\4\2\2\u0187" +
                    "\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\5@" +
                    "!\2\u018a?\3\2\2\2\u018b\u0191\5P)\2\u018c\u018d\7X\2\2\u018d\u018e\5" +
                    ":\36\2\u018e\u018f\7Y\2\2\u018f\u0191\3\2\2\2\u0190\u018b\3\2\2\2\u0190" +
                    "\u018c\3\2\2\2\u0191A\3\2\2\2\u0192\u0193\5D#\2\u0193C\3\2\2\2\u0194\u0197" +
                    "\5\20\t\2\u0195\u0197\5J&\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197" +
                    "E\3\2\2\2\u0198\u019b\5\20\t\2\u0199\u019b\5t;\2\u019a\u0198\3\2\2\2\u019a" +
                    "\u0199\3\2\2\2\u019bG\3\2\2\2\u019c\u019f\5\20\t\2\u019d\u019f\5p9\2\u019e" +
                    "\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019fI\3\2\2\2\u01a0\u01a1\7`\2\2\u01a1" +
                    "K\3\2\2\2\u01a2\u01a3\7a\2\2\u01a3M\3\2\2\2\u01a4\u01a5\7a\2\2\u01a5O" +
                    "\3\2\2\2\u01a6\u01a7\t\6\2\2\u01a7Q\3\2\2\2\u01a8\u01a9\7a\2\2\u01a9S" +
                    "\3\2\2\2\u01aa\u01ab\t\7\2\2\u01abU\3\2\2\2\u01ac\u01ad\7a\2\2\u01adW" +
                    "\3\2\2\2\u01ae\u01af\7\4\2\2\u01af\u01b0\79\2\2\u01b0\u01b2\5Z.\2\u01b1" +
                    "\u01b3\5\\/\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2" +
                    "\2\2\u01b4\u01b6\5d\63\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6" +
                    "\u01b8\3\2\2\2\u01b7\u01b9\5f\64\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2" +
                    "\2\2\u01b9Y\3\2\2\2\u01ba\u01bb\7a\2\2\u01bb[\3\2\2\2\u01bc\u01bd\7X\2" +
                    "\2\u01bd\u01c2\5^\60\2\u01be\u01bf\7\\\2\2\u01bf\u01c1\5^\60\2\u01c0\u01be" +
                    "\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3" +
                    "\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\7Y\2\2\u01c6]\3\2\2\2\u01c7" +
                    "\u01c8\7a\2\2\u01c8\u01cc\5`\61\2\u01c9\u01cb\5b\62\2\u01ca\u01c9\3\2" +
                    "\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd" +
                    "_\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01e3\7\64\2\2\u01d0\u01e3\7\65\2" +
                    "\2\u01d1\u01d2\7\66\2\2\u01d2\u01d3\7X\2\2\u01d3\u01d4\7g\2\2\u01d4\u01e3" +
                    "\7Y\2\2\u01d5\u01d6\7,\2\2\u01d6\u01d7\7X\2\2\u01d7\u01d8\5`\61\2\u01d8" +
                    "\u01d9\7\\\2\2\u01d9\u01da\7g\2\2\u01da\u01db\7Y\2\2\u01db\u01e3\3\2\2" +
                    "\2\u01dc\u01dd\78\2\2\u01dd\u01de\7X\2\2\u01de\u01df\7a\2\2\u01df\u01e3" +
                    "\7Y\2\2\u01e0\u01e1\7\20\2\2\u01e1\u01e3\5\\/\2\u01e2\u01cf\3\2\2\2\u01e2" +
                    "\u01d0\3\2\2\2\u01e2\u01d1\3\2\2\2\u01e2\u01d5\3\2\2\2\u01e2\u01dc\3\2" +
                    "\2\2\u01e2\u01e0\3\2\2\2\u01e3a\3\2\2\2\u01e4\u01e5\7*\2\2\u01e5\u01e7" +
                    "\7+\2\2\u01e6\u01e8\t\b\2\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8" +
                    "\u01eb\3\2\2\2\u01e9\u01eb\7C\2\2\u01ea\u01e4\3\2\2\2\u01ea\u01e9\3\2" +
                    "\2\2\u01ebc\3\2\2\2\u01ec\u01ed\7-\2\2\u01ed\u01f2\7a\2\2\u01ee\u01ef" +
                    "\7\\\2\2\u01ef\u01f1\7a\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2" +
                    "\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3e\3\2\2\2\u01f4\u01f2\3\2\2\2" +
                    "\u01f5\u01f6\7*\2\2\u01f6\u01f7\7+\2\2\u01f7\u01f8\7X\2\2\u01f8\u01fd" +
                    "\5\20\t\2\u01f9\u01fa\7\\\2\2\u01fa\u01fc\5\20\t\2\u01fb\u01f9\3\2\2\2" +
                    "\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200" +
                    "\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0202\7Y\2\2\u0201\u0203\t\b\2\2\u0202" +
                    "\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203g\3\2\2\2\u0204\u0206\5j\66\2" +
                    "\u0205\u0207\5\30\r\2\u0206\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207i\3" +
                    "\2\2\2\u0208\u0209\7\5\2\2\u0209\u020b\5L\'\2\u020a\u020c\7\t\2\2\u020b" +
                    "\u020a\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\5V" +
                    ",\2\u020e\u020f\7\37\2\2\u020f\u0214\5l\67\2\u0210\u0211\7\\\2\2\u0211" +
                    "\u0213\5l\67\2\u0212\u0210\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2" +
                    "\2\2\u0214\u0215\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0217" +
                    "\u0219\5\30\r\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219k\3\2\2\2" +
                    "\u021a\u021b\5\20\t\2\u021b\u021c\7Q\2\2\u021c\u021d\5n8\2\u021dm\3\2" +
                    "\2\2\u021e\u0224\5:\36\2\u021f\u0224\5D#\2\u0220\u0224\5t;\2\u0221\u0224" +
                    "\5p9\2\u0222\u0224\7\"\2\2\u0223\u021e\3\2\2\2\u0223\u021f\3\2\2\2\u0223" +
                    "\u0220\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0222\3\2\2\2\u0224o\3\2\2\2" +
                    "\u0225\u0226\7Z\2\2\u0226\u022b\5r:\2\u0227\u0228\7\\\2\2\u0228\u022a" +
                    "\5r:\2\u0229\u0227\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b" +
                    "\u022c\3\2\2\2\u022c\u022e\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u022f\7[" +
                    "\2\2\u022fq\3\2\2\2\u0230\u0231\7g\2\2\u0231\u0232\7^\2\2\u0232\u0235" +
                    "\5n8\2\u0233\u0235\5n8\2\u0234\u0230\3\2\2\2\u0234\u0233\3\2\2\2\u0235" +
                    "s\3\2\2\2\u0236\u0237\7X\2\2\u0237\u023c\5v<\2\u0238\u0239\7\\\2\2\u0239" +
                    "\u023b\5v<\2\u023a\u0238\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2\2" +
                    "\2\u023c\u023d\3\2\2\2\u023d\u023f\3\2\2\2\u023e\u023c\3\2\2\2\u023f\u0240" +
                    "\7Y\2\2\u0240u\3\2\2\2\u0241\u0242\5\20\t\2\u0242\u0243\7^\2\2\u0243\u0244" +
                    "\5n8\2\u0244\u0247\3\2\2\2\u0245\u0247\5n8\2\u0246\u0241\3\2\2\2\u0246" +
                    "\u0245\3\2\2\2\u0247w\3\2\2\2\u0248\u024a\5z>\2\u0249\u024b\5\30\r\2\u024a" +
                    "\u0249\3\2\2\2\u024a\u024b\3\2\2\2\u024by\3\2\2\2\u024c\u024d\7\6\2\2" +
                    "\u024d\u024e\7\b\2\2\u024e\u0250\5L\'\2\u024f\u0251\7\t\2\2\u0250\u024f" +
                    "\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0253\5V,\2\u0253" +
                    "{\3\2\2\2\u0254\u0255\7\7\2\2\u0255\u0256\7(\2\2\u0256\u0258\5Z.\2\u0257" +
                    "\u0259\5~@\2\u0258\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\3\2\2" +
                    "\2\u025a\u025b\7)\2\2\u025b\u025c\5\u0080A\2\u025c}\3\2\2\2\u025d\u025e" +
                    "\7X\2\2\u025e\u0263\5\20\t\2\u025f\u0260\7\\\2\2\u0260\u0262\5\20\t\2" +
                    "\u0261\u025f\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264" +
                    "\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u0267\7Y\2\2\u0267" +
                    "\177\3\2\2\2\u0268\u0269\7X\2\2\u0269\u026e\5n8\2\u026a\u026b\7\\\2\2" +
                    "\u026b\u026d\5n8\2\u026c\u026a\3\2\2\2\u026d\u0270\3\2\2\2\u026e\u026c" +
                    "\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270\u026e\3\2\2\2\u0271" +
                    "\u0272\7Y\2\2\u0272\u0081\3\2\2\2\u0273\u0274\7>\2\2\u0274\u0275\79\2" +
                    "\2\u0275\u0277\7a\2\2\u0276\u0278\7?\2\2\u0277\u0276\3\2\2\2\u0277\u0278" +
                    "\3\2\2\2\u0278\u0083\3\2\2\2\u0279\u027a\7A\2\2\u027a\u027b\7B\2\2\u027b" +
                    "\u0085\3\2\2\2\u027c\u027d\7\4\2\2\u027d\u027e\7D\2\2\u027e\u027f\7a\2" +
                    "\2\u027f\u0280\7@\2\2\u0280\u0281\7a\2\2\u0281\u0282\7X\2\2\u0282\u0283" +
                    "\5\20\t\2\u0283\u0284\7Y\2\2\u0284\u0087\3\2\2\2\u0285\u0286\7>\2\2\u0286" +
                    "\u0287\7D\2\2\u0287\u0288\7a\2\2\u0288\u0289\7@\2\2\u0289\u028a\7a\2\2" +
                    "\u028a\u0089\3\2\2\2\u028b\u028c\7E\2\2\u028c\u008b\3\2\2\2\u028d\u028e" +
                    "\7F\2\2\u028e\u028f\7G\2\2\u028f\u008d\3\2\2\2\u0290\u0291\7H\2\2\u0291" +
                    "\u008f\3\2\2\2\u0292\u0293\7I\2\2\u0293\u0294\7J\2\2\u0294\u0091\3\2\2" +
                    "\2A\u009f\u00a3\u00a8\u00ab\u00ae\u00b1\u00b8\u00bd\u00c5\u00ca\u00d0" +
                    "\u00d6\u00e1\u00e8\u00f8\u0104\u0109\u010c\u0113\u011b\u0123\u0129\u012d" +
                    "\u0136\u013d\u0141\u014c\u0155\u016e\u0174\u017b\u0183\u0187\u0190\u0196" +
                    "\u019a\u019e\u01b2\u01b5\u01b8\u01c2\u01cc\u01e2\u01e7\u01ea\u01f2\u01fd" +
                    "\u0202\u0206\u020b\u0214\u0218\u0223\u022b\u0234\u023c\u0246\u024a\u0250" +
                    "\u0258\u0263\u026e\u0277";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", "'>'", "'<'", "'>='",
            "'<='", null, "'.'", "'('", "')'", "'['", "']'", "','", "';'", "':'",
            "''.''"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "SELECT", "CREATE", "UPDATE", "DELETE", "INSERT", "FROM", "AS",
            "LEFT", "RIGHT", "OUTER", "JOIN", "INNER", "DISTINCT", "OBJECT", "NEW",
            "AVG", "SUM", "MAX", "MIN", "COUNT", "WHERE", "GROUP", "BY", "ORDER",
            "HAVING", "DESC", "ASC", "NOT", "SET", "BETWEEN", "IS", "NULL", "ESCAPE",
            "AND", "OR", "LIKE", "IN", "INTO", "VALUES", "PRIMARY", "KEY", "LISTOF",
            "EXTENDS", "EMPTY", "MEMBER", "OF", "ALL", "ANY", "SOME", "INT", "FLOAT",
            "CHAR", "SETOF", "REF", "TABLE", "EXISTS", "AUTO_INCREMENT", "UNIQUE",
            "LIMIT", "DROP", "CASCADE", "ON", "SHOW", "TABLES", "FINAL", "INDEX",
            "SYNC", "BEGIN", "TRANSACTION", "COMMIT", "ROLL", "BACK", "ASSIGN", "UUID",
            "MUL", "DIV", "PLUS", "MINUS", "EQ", "GR", "LS", "GE", "LE", "NE", "DOT",
            "LBRACKET", "RBRACKET", "LFRACKET", "RFRACKET", "COMMA", "SEMI", "COLON",
            "TRIMCHARACTER", "STRINGLITERAL", "WORD", "NAMEDPARAMETER", "WS", "COMMENT",
            "LINECOMMENT", "ESCAPECHARACTER", "INTNUMERAL", "FLOATNUMERAL"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public OQLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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

    public final OqlStatContext oqlStat() throws RecognitionException {
        OqlStatContext _localctx = new OqlStatContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_oqlStat);
        try {
            setState(157);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                    _localctx = new SelectStatementContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(144);
                    selectStat();
                }
                break;
                case 2:
                    _localctx = new CreateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(145);
                    createStat();
                }
                break;
                case 3:
                    _localctx = new InsertStatementContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(146);
                    insertStat();
                }
                break;
                case 4:
                    _localctx = new UpdateStatementContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(147);
                    updateStat();
                }
                break;
                case 5:
                    _localctx = new DeleteStatementContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(148);
                    deleteStat();
                }
                break;
                case 6:
                    _localctx = new DropStatementContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(149);
                    dropStat();
                }
                break;
                case 7:
                    _localctx = new ShowStatementContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(150);
                    showStat();
                }
                break;
                case 8:
                    _localctx = new CreateIndexStatementContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(151);
                    createIndexStat();
                }
                break;
                case 9:
                    _localctx = new DropIndexStatementContext(_localctx);
                    enterOuterAlt(_localctx, 9);
                {
                    setState(152);
                    dropIndexStat();
                }
                break;
                case 10:
                    _localctx = new SyncStatementContext(_localctx);
                    enterOuterAlt(_localctx, 10);
                {
                    setState(153);
                    syncStat();
                }
                break;
                case 11:
                    _localctx = new BeginTranStatementContext(_localctx);
                    enterOuterAlt(_localctx, 11);
                {
                    setState(154);
                    beginTranStat();
                }
                break;
                case 12:
                    _localctx = new CommitStatementContext(_localctx);
                    enterOuterAlt(_localctx, 12);
                {
                    setState(155);
                    commitStat();
                }
                break;
                case 13:
                    _localctx = new RollBackStatementContext(_localctx);
                    enterOuterAlt(_localctx, 13);
                {
                    setState(156);
                    rollBackStat();
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

    public final SelectStatContext selectStat() throws RecognitionException {
        SelectStatContext _localctx = new SelectStatContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_selectStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(159);
                match(SELECT);
                setState(161);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DISTINCT) {
                    {
                        setState(160);
                        match(DISTINCT);
                    }
                }

                setState(163);
                selectClause();
                setState(164);
                fromClause();
                setState(166);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(165);
                        whereClause();
                    }
                }

                setState(169);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == GROUP) {
                    {
                        setState(168);
                        groupByClause();
                    }
                }

                setState(172);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ORDER) {
                    {
                        setState(171);
                        orderByClause();
                    }
                }

                setState(175);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LIMIT) {
                    {
                        setState(174);
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

    public final SelectClauseContext selectClause() throws RecognitionException {
        SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_selectClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(177);
                selectExpr();
                setState(182);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(178);
                            match(COMMA);
                            setState(179);
                            selectExpr();
                        }
                    }
                    setState(184);
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

    public final SelectExprContext selectExpr() throws RecognitionException {
        SelectExprContext _localctx = new SelectExprContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_selectExpr);
        try {
            setState(187);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new SelectPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(185);
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
                    setState(186);
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

    public final FromClauseContext fromClause() throws RecognitionException {
        FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_fromClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(189);
                match(FROM);
                setState(190);
                fromItem();
                setState(195);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(191);
                            match(COMMA);
                            setState(192);
                            fromItem();
                        }
                    }
                    setState(197);
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

    public final FromItemContext fromItem() throws RecognitionException {
        FromItemContext _localctx = new FromItemContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_fromItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
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
                setState(206);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == JOIN) {
                    {
                        {
                            setState(203);
                            join();
                        }
                    }
                    setState(208);
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

    public final JoinContext join() throws RecognitionException {
        JoinContext _localctx = new JoinContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_join);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(209);
                match(JOIN);
                setState(210);
                schemaName();
                setState(212);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(211);
                        match(AS);
                    }
                }

                setState(214);
                id();
                setState(215);
                match(ON);
                setState(216);
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

    public final PathExprContext pathExpr() throws RecognitionException {
        PathExprContext _localctx = new PathExprContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_pathExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(218);
                id();
                setState(223);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(219);
                            match(DOT);
                            setState(220);
                            field();
                        }
                    }
                    setState(225);
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

    public final LimitClauseContext limitClause() throws RecognitionException {
        LimitClauseContext _localctx = new LimitClauseContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_limitClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(226);
                match(LIMIT);
                setState(227);
                match(INTNUMERAL);
                setState(230);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(228);
                        match(COMMA);
                        setState(229);
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

    public final AggregateExprContext aggregateExpr() throws RecognitionException {
        AggregateExprContext _localctx = new AggregateExprContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_aggregateExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(232);
                aggregateExprFunctionName();
                setState(233);
                match(LBRACKET);
                setState(234);
                pathExpr();
                setState(235);
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

    public final AggregateExprFunctionNameContext aggregateExprFunctionName() throws RecognitionException {
        AggregateExprFunctionNameContext _localctx = new AggregateExprFunctionNameContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_aggregateExprFunctionName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(237);
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

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(239);
                match(WHERE);
                setState(240);
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

    public final GroupByClauseContext groupByClause() throws RecognitionException {
        GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_groupByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(242);
                match(GROUP);
                setState(243);
                match(BY);
                setState(244);
                pathExpr();
                setState(246);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HAVING) {
                    {
                        setState(245);
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

    public final HavingClauseContext havingClause() throws RecognitionException {
        HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_havingClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(248);
                match(HAVING);
                setState(249);
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

    public final OrderByClauseContext orderByClause() throws RecognitionException {
        OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_orderByClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(251);
                match(ORDER);
                setState(252);
                match(BY);
                setState(253);
                orderByItem();
                setState(258);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(254);
                            match(COMMA);
                            setState(255);
                            orderByItem();
                        }
                    }
                    setState(260);
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

    public final OrderByItemContext orderByItem() throws RecognitionException {
        OrderByItemContext _localctx = new OrderByItemContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_orderByItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(261);
                pathExpr();
                setState(266);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case EOF:
                    case ASC:
                    case LIMIT:
                    case COMMA: {
                        setState(263);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == ASC) {
                            {
                                setState(262);
                                match(ASC);
                            }
                        }

                    }
                    break;
                    case DESC: {
                        setState(265);
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

    public final ConditionalExprContext conditionalExpr() throws RecognitionException {
        ConditionalExprContext _localctx = new ConditionalExprContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_conditionalExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(268);
                    conditionalTerm();
                }
                setState(273);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(269);
                            match(OR);
                            setState(270);
                            conditionalTerm();
                        }
                    }
                    setState(275);
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

    public final ConditionalTermContext conditionalTerm() throws RecognitionException {
        ConditionalTermContext _localctx = new ConditionalTermContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_conditionalTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(276);
                    conditionalFactor();
                }
                setState(281);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(277);
                            match(AND);
                            setState(278);
                            conditionalFactor();
                        }
                    }
                    setState(283);
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

    public final ConditionalFactorContext conditionalFactor() throws RecognitionException {
        ConditionalFactorContext _localctx = new ConditionalFactorContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_conditionalFactor);
        try {
            setState(289);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                case 1:
                    _localctx = new ConditionalFactorSimpleCondExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(284);
                    simpleCondExpr();
                }
                break;
                case 2:
                    _localctx = new ConditionalFactorExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(285);
                    match(LBRACKET);
                    setState(286);
                    conditionalExpr();
                    setState(287);
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

    public final SimpleCondExprContext simpleCondExpr() throws RecognitionException {
        SimpleCondExprContext _localctx = new SimpleCondExprContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_simpleCondExpr);
        try {
            setState(295);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                case 1:
                    _localctx = new SimpleComparisonExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(291);
                    comparisonExpr();
                }
                break;
                case 2:
                    _localctx = new SimpleBetweenExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(292);
                    betweenExpr();
                }
                break;
                case 3:
                    _localctx = new SimpleLikeExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(293);
                    likeExpr();
                }
                break;
                case 4:
                    _localctx = new SimpleInExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(294);
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

    public final BetweenExprContext betweenExpr() throws RecognitionException {
        BetweenExprContext _localctx = new BetweenExprContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_betweenExpr);
        int _la;
        try {
            setState(315);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    _localctx = new BetweenArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(297);
                    arithmeticExpr();
                    setState(299);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(298);
                            match(NOT);
                        }
                    }

                    setState(301);
                    match(BETWEEN);
                    setState(302);
                    arithmeticExpr();
                    setState(303);
                    match(AND);
                    setState(304);
                    arithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new BetweenStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(306);
                    stringExpr();
                    setState(308);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NOT) {
                        {
                            setState(307);
                            match(NOT);
                        }
                    }

                    setState(310);
                    match(BETWEEN);
                    setState(311);
                    stringExpr();
                    setState(312);
                    match(AND);
                    setState(313);
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

    public final InExprContext inExpr() throws RecognitionException {
        InExprContext _localctx = new InExprContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_inExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(317);
                pathExpr();
                setState(319);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NOT) {
                    {
                        setState(318);
                        match(NOT);
                    }
                }

                setState(321);
                match(IN);
                setState(322);
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

    public final InExprRightPartContext inExprRightPart() throws RecognitionException {
        InExprRightPartContext _localctx = new InExprRightPartContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_inExprRightPart);
        int _la;
        try {
            _localctx = new InExprItemContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(324);
                match(LBRACKET);
                setState(325);
                inItem();
                setState(330);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(326);
                            match(COMMA);
                            setState(327);
                            inItem();
                        }
                    }
                    setState(332);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(333);
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

    public final InItemContext inItem() throws RecognitionException {
        InItemContext _localctx = new InItemContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_inItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(335);
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

    public final LikeExprContext likeExpr() throws RecognitionException {
        LikeExprContext _localctx = new LikeExprContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_likeExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(337);
                stringExpr();
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
                match(LIKE);
                setState(342);
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

    public final ComparisonExprContext comparisonExpr() throws RecognitionException {
        ComparisonExprContext _localctx = new ComparisonExprContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_comparisonExpr);
        try {
            setState(364);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                case 1:
                    _localctx = new ComparisonStringExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(344);
                    stringExpr();
                    setState(345);
                    comparisonOperator();
                    setState(346);
                    stringExpr();
                }
                break;
                case 2:
                    _localctx = new ComparisonArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(348);
                    arithmeticExpr();
                    setState(349);
                    comparisonOperator();
                    setState(350);
                    arithmeticExpr();
                }
                break;
                case 3:
                    _localctx = new ComparisonAggregateExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(352);
                    aggregateExpr();
                    setState(353);
                    comparisonOperator();
                    setState(354);
                    arithmeticExpr();
                }
                break;
                case 4:
                    _localctx = new ComparisonEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(356);
                    entityExpr();
                    setState(357);
                    comparisonOperator();
                    setState(358);
                    entityExpr();
                }
                break;
                case 5:
                    _localctx = new ComparisonListExprContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(360);
                    listExpr();
                    setState(361);
                    comparisonOperator();
                    setState(362);
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

    public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
        ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_comparisonOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(366);
                _la = _input.LA(1);
                if (!(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (EQ - 79)) | (1L << (GR - 79)) | (1L << (LS - 79)) | (1L << (GE - 79)) | (1L << (LE - 79)) | (1L << (NE - 79)))) != 0))) {
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

    public final ArithmeticExprContext arithmeticExpr() throws RecognitionException {
        ArithmeticExprContext _localctx = new ArithmeticExprContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_arithmeticExpr);
        try {
            setState(370);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ArithmeticPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(368);
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
                    setState(369);
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

    public final SimpleArithmeticExprContext simpleArithmeticExpr() throws RecognitionException {
        SimpleArithmeticExprContext _localctx = new SimpleArithmeticExprContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_simpleArithmeticExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(372);
                    arithmeticTerm();
                }
                setState(377);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PLUS || _la == MINUS) {
                    {
                        {
                            setState(373);
                            _la = _input.LA(1);
                            if (!(_la == PLUS || _la == MINUS)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(374);
                            arithmeticTerm();
                        }
                    }
                    setState(379);
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

    public final ArithmeticTermContext arithmeticTerm() throws RecognitionException {
        ArithmeticTermContext _localctx = new ArithmeticTermContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_arithmeticTerm);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(380);
                    arithmeticFactor();
                }
                setState(385);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == MUL || _la == DIV) {
                    {
                        {
                            setState(381);
                            _la = _input.LA(1);
                            if (!(_la == MUL || _la == DIV)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(382);
                            arithmeticFactor();
                        }
                    }
                    setState(387);
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

    public final ArithmeticFactorContext arithmeticFactor() throws RecognitionException {
        ArithmeticFactorContext _localctx = new ArithmeticFactorContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_arithmeticFactor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(389);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PLUS || _la == MINUS) {
                    {
                        setState(388);
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

                setState(391);
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

    public final ArithmeticPrimaryContext arithmeticPrimary() throws RecognitionException {
        ArithmeticPrimaryContext _localctx = new ArithmeticPrimaryContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_arithmeticPrimary);
        try {
            setState(398);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INTNUMERAL:
                case FLOATNUMERAL:
                    _localctx = new AriPriNumericLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(393);
                    numericLiteral();
                }
                break;
                case LBRACKET:
                    _localctx = new AriPriSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(394);
                    match(LBRACKET);
                    setState(395);
                    simpleArithmeticExpr();
                    setState(396);
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

    public final StringExprContext stringExpr() throws RecognitionException {
        StringExprContext _localctx = new StringExprContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_stringExpr);
        try {
            _localctx = new StringPriContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(400);
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

    public final StringPrimaryContext stringPrimary() throws RecognitionException {
        StringPrimaryContext _localctx = new StringPrimaryContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_stringPrimary);
        try {
            setState(404);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new StringPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(402);
                    pathExpr();
                }
                break;
                case STRINGLITERAL:
                    _localctx = new StringLiteralContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(403);
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

    public final EntityExprContext entityExpr() throws RecognitionException {
        EntityExprContext _localctx = new EntityExprContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_entityExpr);
        try {
            setState(408);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new EntityPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(406);
                    pathExpr();
                }
                break;
                case LBRACKET:
                    _localctx = new EntityValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(407);
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

    public final ListExprContext listExpr() throws RecognitionException {
        ListExprContext _localctx = new ListExprContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_listExpr);
        try {
            setState(412);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case WORD:
                    _localctx = new ListPathExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(410);
                    pathExpr();
                }
                break;
                case LFRACKET:
                    _localctx = new ListValueExprContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(411);
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

    public final StringLiteralExprContext stringLiteralExpr() throws RecognitionException {
        StringLiteralExprContext _localctx = new StringLiteralExprContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_stringLiteralExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(414);
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

    public final SchemaNameContext schemaName() throws RecognitionException {
        SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_schemaName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(416);
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

    public final PatternValueContext patternValue() throws RecognitionException {
        PatternValueContext _localctx = new PatternValueContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_patternValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(418);
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

    public final NumericLiteralContext numericLiteral() throws RecognitionException {
        NumericLiteralContext _localctx = new NumericLiteralContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_numericLiteral);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(420);
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

    public final LiteralContext literal() throws RecognitionException {
        LiteralContext _localctx = new LiteralContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_literal);
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

    public final FieldContext field() throws RecognitionException {
        FieldContext _localctx = new FieldContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_field);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(424);
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

    public final IdContext id() throws RecognitionException {
        IdContext _localctx = new IdContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_id);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(426);
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

    public final CreateStatContext createStat() throws RecognitionException {
        CreateStatContext _localctx = new CreateStatContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_createStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(428);
                match(CREATE);
                setState(429);
                match(TABLE);
                setState(430);
                tableName();
                setState(432);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(431);
                        columnDefinition();
                    }
                }

                setState(435);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EXTENDS) {
                    {
                        setState(434);
                        extendsTable();
                    }
                }

                setState(438);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PRIMARY) {
                    {
                        setState(437);
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

    public final TableNameContext tableName() throws RecognitionException {
        TableNameContext _localctx = new TableNameContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_tableName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(440);
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

    public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
        ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_columnDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(442);
                match(LBRACKET);
                setState(443);
                columnDefinitionItem();
                setState(448);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(444);
                            match(COMMA);
                            setState(445);
                            columnDefinitionItem();
                        }
                    }
                    setState(450);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(451);
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

    public final ColumnDefinitionItemContext columnDefinitionItem() throws RecognitionException {
        ColumnDefinitionItemContext _localctx = new ColumnDefinitionItemContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_columnDefinitionItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(453);
                match(WORD);
                setState(454);
                columnType();
                setState(458);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == PRIMARY || _la == FINAL) {
                    {
                        {
                            setState(455);
                            columnConstraint();
                        }
                    }
                    setState(460);
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

    public final ColumnTypeContext columnType() throws RecognitionException {
        ColumnTypeContext _localctx = new ColumnTypeContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_columnType);
        try {
            setState(480);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case INT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(461);
                    match(INT);
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(462);
                    match(FLOAT);
                }
                break;
                case CHAR:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(463);
                    match(CHAR);
                    setState(464);
                    match(LBRACKET);
                    setState(465);
                    match(INTNUMERAL);
                    setState(466);
                    match(RBRACKET);
                }
                break;
                case LISTOF:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(467);
                    match(LISTOF);
                    setState(468);
                    match(LBRACKET);
                    setState(469);
                    columnType();
                    setState(470);
                    match(COMMA);
                    setState(471);
                    match(INTNUMERAL);
                    setState(472);
                    match(RBRACKET);
                }
                break;
                case REF:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(474);
                    match(REF);
                    setState(475);
                    match(LBRACKET);
                    setState(476);
                    match(WORD);
                    setState(477);
                    match(RBRACKET);
                }
                break;
                case OBJECT:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(478);
                    match(OBJECT);
                    setState(479);
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

    public final ColumnConstraintContext columnConstraint() throws RecognitionException {
        ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_columnConstraint);
        int _la;
        try {
            setState(488);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case PRIMARY:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(482);
                    match(PRIMARY);
                    setState(483);
                    match(KEY);
                    setState(485);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (AUTO_INCREMENT - 57)) | (1L << (ASSIGN - 57)) | (1L << (UUID - 57)))) != 0)) {
                        {
                            setState(484);
                            _la = _input.LA(1);
                            if (!(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (AUTO_INCREMENT - 57)) | (1L << (ASSIGN - 57)) | (1L << (UUID - 57)))) != 0))) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                        }
                    }

                }
                break;
                case FINAL:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(487);
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

    public final ExtendsTableContext extendsTable() throws RecognitionException {
        ExtendsTableContext _localctx = new ExtendsTableContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_extendsTable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(490);
                match(EXTENDS);
                setState(491);
                match(WORD);
                setState(496);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(492);
                            match(COMMA);
                            setState(493);
                            match(WORD);
                        }
                    }
                    setState(498);
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

    public final TableConstraintContext tableConstraint() throws RecognitionException {
        TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_tableConstraint);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(499);
                match(PRIMARY);
                setState(500);
                match(KEY);
                setState(501);
                match(LBRACKET);
                setState(502);
                pathExpr();
                setState(507);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(503);
                            match(COMMA);
                            setState(504);
                            pathExpr();
                        }
                    }
                    setState(509);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(510);
                match(RBRACKET);
                setState(512);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (AUTO_INCREMENT - 57)) | (1L << (ASSIGN - 57)) | (1L << (UUID - 57)))) != 0)) {
                    {
                        setState(511);
                        _la = _input.LA(1);
                        if (!(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (AUTO_INCREMENT - 57)) | (1L << (ASSIGN - 57)) | (1L << (UUID - 57)))) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
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

    public final UpdateStatContext updateStat() throws RecognitionException {
        UpdateStatContext _localctx = new UpdateStatContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_updateStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(514);
                updateClause();
                setState(516);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(515);
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

    public final UpdateClauseContext updateClause() throws RecognitionException {
        UpdateClauseContext _localctx = new UpdateClauseContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_updateClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(518);
                match(UPDATE);
                setState(519);
                schemaName();
                setState(521);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(520);
                        match(AS);
                    }
                }

                setState(523);
                id();
                setState(524);
                match(SET);
                setState(525);
                updateItem();
                setState(530);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(526);
                            match(COMMA);
                            setState(527);
                            updateItem();
                        }
                    }
                    setState(532);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(534);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 51, _ctx)) {
                    case 1: {
                        setState(533);
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

    public final UpdateItemContext updateItem() throws RecognitionException {
        UpdateItemContext _localctx = new UpdateItemContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_updateItem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(536);
                pathExpr();
                setState(537);
                match(EQ);
                setState(538);
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

    public final NewValueContext newValue() throws RecognitionException {
        NewValueContext _localctx = new NewValueContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_newValue);
        try {
            setState(545);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 52, _ctx)) {
                case 1:
                    _localctx = new NewSimpleArithmeticExprContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(540);
                    simpleArithmeticExpr();
                }
                break;
                case 2:
                    _localctx = new NewStringPrimaryContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(541);
                    stringPrimary();
                }
                break;
                case 3:
                    _localctx = new NewSimpleEntityExprContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(542);
                    insertEntityExpr();
                }
                break;
                case 4:
                    _localctx = new NewSimpleListExprContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(543);
                    insertListExpr();
                }
                break;
                case 5:
                    _localctx = new NewNullContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(544);
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

    public final InsertListExprContext insertListExpr() throws RecognitionException {
        InsertListExprContext _localctx = new InsertListExprContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_insertListExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(547);
                match(LFRACKET);
                setState(548);
                insertListItem();
                setState(553);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(549);
                            match(COMMA);
                            setState(550);
                            insertListItem();
                        }
                    }
                    setState(555);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(556);
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

    public final InsertListItemContext insertListItem() throws RecognitionException {
        InsertListItemContext _localctx = new InsertListItemContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_insertListItem);
        try {
            setState(562);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(558);
                    match(INTNUMERAL);
                    setState(559);
                    match(COLON);
                    setState(560);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(561);
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

    public final InsertEntityExprContext insertEntityExpr() throws RecognitionException {
        InsertEntityExprContext _localctx = new InsertEntityExprContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_insertEntityExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(564);
                match(LBRACKET);
                setState(565);
                insertEntityItem();
                setState(570);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(566);
                            match(COMMA);
                            setState(567);
                            insertEntityItem();
                        }
                    }
                    setState(572);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(573);
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

    public final InsertEntityItemContext insertEntityItem() throws RecognitionException {
        InsertEntityItemContext _localctx = new InsertEntityItemContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_insertEntityItem);
        try {
            setState(580);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 56, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(575);
                    pathExpr();
                    setState(576);
                    match(COLON);
                    setState(577);
                    newValue();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(579);
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

    public final DeleteStatContext deleteStat() throws RecognitionException {
        DeleteStatContext _localctx = new DeleteStatContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_deleteStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(582);
                deleteClause();
                setState(584);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(583);
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

    public final DeleteClauseContext deleteClause() throws RecognitionException {
        DeleteClauseContext _localctx = new DeleteClauseContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_deleteClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(586);
                match(DELETE);
                setState(587);
                match(FROM);
                setState(588);
                schemaName();
                setState(590);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AS) {
                    {
                        setState(589);
                        match(AS);
                    }
                }

                setState(592);
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

    public final InsertStatContext insertStat() throws RecognitionException {
        InsertStatContext _localctx = new InsertStatContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_insertStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(594);
                match(INSERT);
                setState(595);
                match(INTO);
                setState(596);
                tableName();
                setState(598);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LBRACKET) {
                    {
                        setState(597);
                        columnList();
                    }
                }

                setState(600);
                match(VALUES);
                setState(601);
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

    public final ColumnListContext columnList() throws RecognitionException {
        ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_columnList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(603);
                match(LBRACKET);
                setState(604);
                pathExpr();
                setState(609);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(605);
                            match(COMMA);
                            setState(606);
                            pathExpr();
                        }
                    }
                    setState(611);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(612);
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

    public final InsertValueContext insertValue() throws RecognitionException {
        InsertValueContext _localctx = new InsertValueContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_insertValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(614);
                match(LBRACKET);
                setState(615);
                newValue();
                setState(620);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(616);
                            match(COMMA);
                            setState(617);
                            newValue();
                        }
                    }
                    setState(622);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(623);
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

    public final DropStatContext dropStat() throws RecognitionException {
        DropStatContext _localctx = new DropStatContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_dropStat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(625);
                match(DROP);
                setState(626);
                match(TABLE);
                setState(627);
                match(WORD);
                setState(629);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == CASCADE) {
                    {
                        setState(628);
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

    public final ShowStatContext showStat() throws RecognitionException {
        ShowStatContext _localctx = new ShowStatContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_showStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(631);
                match(SHOW);
                setState(632);
                match(TABLES);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CreateIndexStatContext createIndexStat() throws RecognitionException {
        CreateIndexStatContext _localctx = new CreateIndexStatContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_createIndexStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(634);
                match(CREATE);
                setState(635);
                match(INDEX);
                setState(636);
                match(WORD);
                setState(637);
                match(ON);
                setState(638);
                match(WORD);
                setState(639);
                match(LBRACKET);
                setState(640);
                pathExpr();
                setState(641);
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

    public final DropIndexStatContext dropIndexStat() throws RecognitionException {
        DropIndexStatContext _localctx = new DropIndexStatContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_dropIndexStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(643);
                match(DROP);
                setState(644);
                match(INDEX);
                setState(645);
                match(WORD);
                setState(646);
                match(ON);
                setState(647);
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

    public final SyncStatContext syncStat() throws RecognitionException {
        SyncStatContext _localctx = new SyncStatContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_syncStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(649);
                match(SYNC);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BeginTranStatContext beginTranStat() throws RecognitionException {
        BeginTranStatContext _localctx = new BeginTranStatContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_beginTranStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(651);
                match(BEGIN);
                setState(652);
                match(TRANSACTION);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CommitStatContext commitStat() throws RecognitionException {
        CommitStatContext _localctx = new CommitStatContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_commitStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(654);
                match(COMMIT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RollBackStatContext rollBackStat() throws RecognitionException {
        RollBackStatContext _localctx = new RollBackStatContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_rollBackStat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(656);
                match(ROLL);
                setState(657);
                match(BACK);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OqlStatContext extends EnhancedParserRuleContext {
        public OqlStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public OqlStatContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_oqlStat;
        }

        public void copyFrom(OqlStatContext ctx) {
            super.copyFrom(ctx);
        }

        public Object doExecute() {
            throw new UnsupportedOperationException("the method is not implement");
        }
    }

    public static class RollBackStatementContext extends OqlStatContext {
        public RollBackStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public RollBackStatContext rollBackStat() {
            return getRuleContext(RollBackStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            Transaction.rollback();
            return "roll back successfully";
        }
    }

    public static class BeginTranStatementContext extends OqlStatContext {
        public BeginTranStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public BeginTranStatContext beginTranStat() {
            return getRuleContext(BeginTranStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            Transaction.start();
            return "the transaction has started";
        }
    }

    public static class CreateStatementContext extends OqlStatContext {
        public CreateStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public CreateStatContext createStat() {
            return getRuleContext(CreateStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            CreateStatContext stat = this.createStat();
            return CreateExplain.getCreateExplain(stat).doCreate();
        }

    }

    public static class DeleteStatementContext extends OqlStatContext {
        public DeleteStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public DeleteStatContext deleteStat() {
            return getRuleContext(DeleteStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            DeleteStatContext deleteStatContext = this.deleteStat();
            return DeleteExplain.getDeleteExplain(deleteStatContext).doDelete();
        }
    }

    public static class InsertStatementContext extends OqlStatContext {
        public InsertStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public InsertStatContext insertStat() {
            return getRuleContext(InsertStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            InsertStatContext insertStatContext = this.insertStat();
            return InsertExplain.getInsertExplain(insertStatContext).doInsert();
        }
    }

    public static class CreateIndexStatementContext extends OqlStatContext {
        public CreateIndexStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public CreateIndexStatContext createIndexStat() {
            return getRuleContext(CreateIndexStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            CreateIndexStatContext indexStat = this.createIndexStat();
            return CreateIndexExplain.getCreateIndexExplain(indexStat).doCreate();
        }
    }

    public static class DropIndexStatementContext extends OqlStatContext {
        public DropIndexStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public DropIndexStatContext dropIndexStat() {
            return getRuleContext(DropIndexStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            DropIndexStatContext dropIndexStatContext = this.dropIndexStat();
            return DropIndexExplain.getDropIndexExplain(dropIndexStatContext).doDrop();
        }
    }

    public static class SyncStatementContext extends OqlStatContext {
        public SyncStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public SyncStatContext syncStat() {
            return getRuleContext(SyncStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            return SyncExplain.sync();
        }
    }

    public static class UpdateStatementContext extends OqlStatContext {
        public UpdateStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public UpdateStatContext updateStat() {
            return getRuleContext(UpdateStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            UpdateStatContext updateStatContext = this.updateStat();
            return UpdateExplain.getUpdateExplain(updateStatContext).doUpdate();
        }
    }

    public static class CommitStatementContext extends OqlStatContext {
        public CommitStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public CommitStatContext commitStat() {
            return getRuleContext(CommitStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            Transaction.commit();
            return "commit successfully";
        }
    }

    public static class SelectStatementContext extends OqlStatContext {
        public SelectStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public SelectStatContext selectStat() {
            return getRuleContext(SelectStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            SelectStatContext selectStatContext = this.selectStat();
            return SelectExplain.getSelectExplain(selectStatContext).doSelect();
        }

    }

    public static class DropStatementContext extends OqlStatContext {
        public DropStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public DropStatContext dropStat() {
            return getRuleContext(DropStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            DropStatContext dropStatContext = this.dropStat();
            return DropExplain.getDropStatContext(dropStatContext).doDrop();
        }
    }

    public static class ShowStatementContext extends OqlStatContext {
        public ShowStatementContext(OqlStatContext ctx) {
            copyFrom(ctx);
        }

        public ShowStatContext showStat() {
            return getRuleContext(ShowStatContext.class, 0);
        }

        @Override
        public Object doExecute() {
            return ShowExplain.doShow();
        }
    }

    public static class SelectStatContext extends EnhancedParserRuleContext {
        public SelectStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_selectStat;
        }
    }

    public static class SelectClauseContext extends EnhancedParserRuleContext {
        public SelectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_selectClause;
        }
    }

    public static class SelectExprContext extends EnhancedParserRuleContext {
        public SelectExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SelectExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectExpr;
        }

        public void copyFrom(SelectExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SelectPathExprContext extends SelectExprContext {
        public SelectPathExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }
    }

    public static class SelectAggregateExprContext extends SelectExprContext {
        public SelectAggregateExprContext(SelectExprContext ctx) {
            copyFrom(ctx);
        }

        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }
    }

    public static class FromClauseContext extends EnhancedParserRuleContext {
        public FromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_fromClause;
        }
    }

    public static class FromItemContext extends EnhancedParserRuleContext {
        public FromItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
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

        public List<JoinContext> join() {
            return getRuleContexts(JoinContext.class);
        }

        public JoinContext join(int i) {
            return getRuleContext(JoinContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromItem;
        }
    }

    public static class JoinContext extends EnhancedParserRuleContext {
        public JoinContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_join;
        }
    }

    public static class PathExprContext extends EnhancedParserRuleContext {
        public PathExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_pathExpr;
        }
    }

    public static class LimitClauseContext extends EnhancedParserRuleContext {
        public LimitClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_limitClause;
        }
    }

    public static class AggregateExprContext extends EnhancedParserRuleContext {
        public AggregateExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_aggregateExpr;
        }
    }

    public static class AggregateExprFunctionNameContext extends EnhancedParserRuleContext {
        public AggregateExprFunctionNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_aggregateExprFunctionName;
        }
    }

    public static class WhereClauseContext extends EnhancedParserRuleContext {
        public WhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WHERE() {
            return getToken(OQLParser.WHERE, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereClause;
        }
    }

    public static class GroupByClauseContext extends EnhancedParserRuleContext {
        public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_groupByClause;
        }
    }

    public static class HavingClauseContext extends EnhancedParserRuleContext {
        public HavingClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode HAVING() {
            return getToken(OQLParser.HAVING, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_havingClause;
        }
    }

    public static class OrderByClauseContext extends EnhancedParserRuleContext {
        public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_orderByClause;
        }
    }

    public static class OrderByItemContext extends EnhancedParserRuleContext {
        public OrderByItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode DESC() {
            return getToken(OQLParser.DESC, 0);
        }

        public TerminalNode ASC() {
            return getToken(OQLParser.ASC, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_orderByItem;
        }
    }

    public static class ConditionalExprContext extends EnhancedParserRuleContext {
        public ConditionalExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_conditionalExpr;
        }
    }

    public static class ConditionalTermContext extends EnhancedParserRuleContext {
        public ConditionalTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_conditionalTerm;
        }
    }

    public static class ConditionalFactorContext extends EnhancedParserRuleContext {
        public ConditionalFactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ConditionalFactorContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionalFactor;
        }

        public void copyFrom(ConditionalFactorContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ConditionalFactorSimpleCondExprContext extends ConditionalFactorContext {
        public ConditionalFactorSimpleCondExprContext(ConditionalFactorContext ctx) {
            copyFrom(ctx);
        }

        public SimpleCondExprContext simpleCondExpr() {
            return getRuleContext(SimpleCondExprContext.class, 0);
        }
    }

    public static class ConditionalFactorExprContext extends ConditionalFactorContext {
        public ConditionalFactorExprContext(ConditionalFactorContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public ConditionalExprContext conditionalExpr() {
            return getRuleContext(ConditionalExprContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }
    }

    public static class SimpleCondExprContext extends EnhancedParserRuleContext {
        public SimpleCondExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SimpleCondExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleCondExpr;
        }

        public void copyFrom(SimpleCondExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class SimpleLikeExprContext extends SimpleCondExprContext {
        public SimpleLikeExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }

        public LikeExprContext likeExpr() {
            return getRuleContext(LikeExprContext.class, 0);
        }
    }

    public static class SimpleInExprContext extends SimpleCondExprContext {
        public SimpleInExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }

        public InExprContext inExpr() {
            return getRuleContext(InExprContext.class, 0);
        }
    }

    public static class SimpleComparisonExprContext extends SimpleCondExprContext {
        public SimpleComparisonExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }

        public ComparisonExprContext comparisonExpr() {
            return getRuleContext(ComparisonExprContext.class, 0);
        }
    }

    public static class SimpleBetweenExprContext extends SimpleCondExprContext {
        public SimpleBetweenExprContext(SimpleCondExprContext ctx) {
            copyFrom(ctx);
        }

        public BetweenExprContext betweenExpr() {
            return getRuleContext(BetweenExprContext.class, 0);
        }
    }

    public static class BetweenExprContext extends EnhancedParserRuleContext {
        public BetweenExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BetweenExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_betweenExpr;
        }

        public void copyFrom(BetweenExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class BetweenStringExprContext extends BetweenExprContext {
        public BetweenStringExprContext(BetweenExprContext ctx) {
            copyFrom(ctx);
        }

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
    }

    public static class BetweenArithmeticExprContext extends BetweenExprContext {
        public BetweenArithmeticExprContext(BetweenExprContext ctx) {
            copyFrom(ctx);
        }

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
    }

    public static class InExprContext extends EnhancedParserRuleContext {
        public InExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_inExpr;
        }
    }

    public static class InExprRightPartContext extends EnhancedParserRuleContext {
        public InExprRightPartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public InExprRightPartContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_inExprRightPart;
        }

        public void copyFrom(InExprRightPartContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class InExprItemContext extends InExprRightPartContext {
        public InExprItemContext(InExprRightPartContext ctx) {
            copyFrom(ctx);
        }

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
    }

    public static class InItemContext extends EnhancedParserRuleContext {
        public InItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LiteralContext literal() {
            return getRuleContext(LiteralContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inItem;
        }
    }

    public static class LikeExprContext extends EnhancedParserRuleContext {
        public LikeExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_likeExpr;
        }
    }

    public static class ComparisonExprContext extends EnhancedParserRuleContext {
        public ComparisonExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ComparisonExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparisonExpr;
        }

        public void copyFrom(ComparisonExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ComparisonListExprContext extends ComparisonExprContext {
        public ComparisonListExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ListExprContext> listExpr() {
            return getRuleContexts(ListExprContext.class);
        }

        public ListExprContext listExpr(int i) {
            return getRuleContext(ListExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }
    }

    public static class ComparisonAggregateExprContext extends ComparisonExprContext {
        public ComparisonAggregateExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        public AggregateExprContext aggregateExpr() {
            return getRuleContext(AggregateExprContext.class, 0);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }

        public ArithmeticExprContext arithmeticExpr() {
            return getRuleContext(ArithmeticExprContext.class, 0);
        }
    }

    public static class ComparisonEntityExprContext extends ComparisonExprContext {
        public ComparisonEntityExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        public List<EntityExprContext> entityExpr() {
            return getRuleContexts(EntityExprContext.class);
        }

        public EntityExprContext entityExpr(int i) {
            return getRuleContext(EntityExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }
    }

    public static class ComparisonArithmeticExprContext extends ComparisonExprContext {
        public ComparisonArithmeticExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ArithmeticExprContext> arithmeticExpr() {
            return getRuleContexts(ArithmeticExprContext.class);
        }

        public ArithmeticExprContext arithmeticExpr(int i) {
            return getRuleContext(ArithmeticExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }
    }

    public static class ComparisonStringExprContext extends ComparisonExprContext {
        public ComparisonStringExprContext(ComparisonExprContext ctx) {
            copyFrom(ctx);
        }

        public List<StringExprContext> stringExpr() {
            return getRuleContexts(StringExprContext.class);
        }

        public StringExprContext stringExpr(int i) {
            return getRuleContext(StringExprContext.class, i);
        }

        public ComparisonOperatorContext comparisonOperator() {
            return getRuleContext(ComparisonOperatorContext.class, 0);
        }
    }

    public static class ComparisonOperatorContext extends EnhancedParserRuleContext {
        public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_comparisonOperator;
        }
    }

    public static class ArithmeticExprContext extends EnhancedParserRuleContext {
        public ArithmeticExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArithmeticExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticExpr;
        }

        public void copyFrom(ArithmeticExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ArithmeticPathExprContext extends ArithmeticExprContext {
        public ArithmeticPathExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }
    }

    public static class ArithmeticSimpleArithmeticExprContext extends ArithmeticExprContext {
        public ArithmeticSimpleArithmeticExprContext(ArithmeticExprContext ctx) {
            copyFrom(ctx);
        }

        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }
    }

    public static class SimpleArithmeticExprContext extends EnhancedParserRuleContext {
        public SimpleArithmeticExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_simpleArithmeticExpr;
        }
    }

    public static class ArithmeticTermContext extends EnhancedParserRuleContext {
        public ArithmeticTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticTerm;
        }
    }

    public static class ArithmeticFactorContext extends EnhancedParserRuleContext {
        public ArithmeticFactorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArithmeticPrimaryContext arithmeticPrimary() {
            return getRuleContext(ArithmeticPrimaryContext.class, 0);
        }

        public TerminalNode PLUS() {
            return getToken(OQLParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(OQLParser.MINUS, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticFactor;
        }
    }

    public static class ArithmeticPrimaryContext extends EnhancedParserRuleContext {
        public ArithmeticPrimaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArithmeticPrimaryContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmeticPrimary;
        }

        public void copyFrom(ArithmeticPrimaryContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class AriPriSimpleArithmeticExprContext extends ArithmeticPrimaryContext {
        public AriPriSimpleArithmeticExprContext(ArithmeticPrimaryContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LBRACKET() {
            return getToken(OQLParser.LBRACKET, 0);
        }

        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(OQLParser.RBRACKET, 0);
        }
    }

    public static class AriPriNumericLiteralContext extends ArithmeticPrimaryContext {
        public AriPriNumericLiteralContext(ArithmeticPrimaryContext ctx) {
            copyFrom(ctx);
        }

        public NumericLiteralContext numericLiteral() {
            return getRuleContext(NumericLiteralContext.class, 0);
        }
    }

    public static class StringExprContext extends EnhancedParserRuleContext {
        public StringExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StringExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringExpr;
        }

        public void copyFrom(StringExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StringPriContext extends StringExprContext {
        public StringPriContext(StringExprContext ctx) {
            copyFrom(ctx);
        }

        public StringPrimaryContext stringPrimary() {
            return getRuleContext(StringPrimaryContext.class, 0);
        }
    }

    public static class StringPrimaryContext extends EnhancedParserRuleContext {
        public StringPrimaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StringPrimaryContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringPrimary;
        }

        public void copyFrom(StringPrimaryContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class StringPathExprContext extends StringPrimaryContext {
        public StringPathExprContext(StringPrimaryContext ctx) {
            copyFrom(ctx);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }
    }

    public static class StringLiteralContext extends StringPrimaryContext {
        public StringLiteralContext(StringPrimaryContext ctx) {
            copyFrom(ctx);
        }

        public StringLiteralExprContext stringLiteralExpr() {
            return getRuleContext(StringLiteralExprContext.class, 0);
        }
    }

    public static class EntityExprContext extends EnhancedParserRuleContext {
        public EntityExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public EntityExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_entityExpr;
        }

        public void copyFrom(EntityExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class EntityValueExprContext extends EntityExprContext {
        public EntityValueExprContext(EntityExprContext ctx) {
            copyFrom(ctx);
        }

        public InsertEntityExprContext insertEntityExpr() {
            return getRuleContext(InsertEntityExprContext.class, 0);
        }
    }

    public static class EntityPathExprContext extends EntityExprContext {
        public EntityPathExprContext(EntityExprContext ctx) {
            copyFrom(ctx);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }
    }

    public static class ListExprContext extends EnhancedParserRuleContext {
        public ListExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ListExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_listExpr;
        }

        public void copyFrom(ListExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ListValueExprContext extends ListExprContext {
        public ListValueExprContext(ListExprContext ctx) {
            copyFrom(ctx);
        }

        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
        }
    }

    public static class ListPathExprContext extends ListExprContext {
        public ListPathExprContext(ListExprContext ctx) {
            copyFrom(ctx);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }
    }

    public static class StringLiteralExprContext extends EnhancedParserRuleContext {
        public StringLiteralExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRINGLITERAL() {
            return getToken(OQLParser.STRINGLITERAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringLiteralExpr;
        }
    }

    public static class SchemaNameContext extends EnhancedParserRuleContext {
        public SchemaNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_schemaName;
        }
    }

    public static class PatternValueContext extends EnhancedParserRuleContext {
        public PatternValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_patternValue;
        }
    }

    public static class NumericLiteralContext extends EnhancedParserRuleContext {
        public NumericLiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        public TerminalNode FLOATNUMERAL() {
            return getToken(OQLParser.FLOATNUMERAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_numericLiteral;
        }
    }

    public static class LiteralContext extends EnhancedParserRuleContext {
        public LiteralContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literal;
        }
    }

    public static class FieldContext extends EnhancedParserRuleContext {
        public FieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_field;
        }
    }

    public static class IdContext extends EnhancedParserRuleContext {
        public IdContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_id;
        }
    }

    public static class CreateStatContext extends EnhancedParserRuleContext {
        public CreateStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_createStat;
        }
    }

    public static class TableNameContext extends EnhancedParserRuleContext {
        public TableNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WORD() {
            return getToken(OQLParser.WORD, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tableName;
        }
    }

    public static class ColumnDefinitionContext extends EnhancedParserRuleContext {
        public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_columnDefinition;
        }
    }

    public static class ColumnDefinitionItemContext extends EnhancedParserRuleContext {
        public ColumnDefinitionItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_columnDefinitionItem;
        }
    }

    public static class ColumnTypeContext extends EnhancedParserRuleContext {
        public ColumnTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_columnType;
        }
    }

    public static class ColumnConstraintContext extends EnhancedParserRuleContext {
        public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PRIMARY() {
            return getToken(OQLParser.PRIMARY, 0);
        }

        public TerminalNode KEY() {
            return getToken(OQLParser.KEY, 0);
        }

        public TerminalNode AUTO_INCREMENT() {
            return getToken(OQLParser.AUTO_INCREMENT, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(OQLParser.ASSIGN, 0);
        }

        public TerminalNode UUID() {
            return getToken(OQLParser.UUID, 0);
        }

        public TerminalNode FINAL() {
            return getToken(OQLParser.FINAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_columnConstraint;
        }
    }

    public static class ExtendsTableContext extends EnhancedParserRuleContext {
        public ExtendsTableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_extendsTable;
        }
    }

    public static class TableConstraintContext extends EnhancedParserRuleContext {
        public TableConstraintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        public TerminalNode AUTO_INCREMENT() {
            return getToken(OQLParser.AUTO_INCREMENT, 0);
        }

        public TerminalNode ASSIGN() {
            return getToken(OQLParser.ASSIGN, 0);
        }

        public TerminalNode UUID() {
            return getToken(OQLParser.UUID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tableConstraint;
        }
    }

    public static class UpdateStatContext extends EnhancedParserRuleContext {
        public UpdateStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public UpdateClauseContext updateClause() {
            return getRuleContext(UpdateClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateStat;
        }
    }

    public static class UpdateClauseContext extends EnhancedParserRuleContext {
        public UpdateClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_updateClause;
        }
    }

    public static class UpdateItemContext extends EnhancedParserRuleContext {
        public UpdateItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode EQ() {
            return getToken(OQLParser.EQ, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_updateItem;
        }
    }

    public static class NewValueContext extends EnhancedParserRuleContext {
        public NewValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NewValueContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_newValue;
        }

        public void copyFrom(NewValueContext ctx) {
            super.copyFrom(ctx);
        }

        public Object getValue() {
            throw new UnsupportedOperationException("the method is not implemented");
        }
    }

    public static class NewSimpleListExprContext extends NewValueContext {
        public NewSimpleListExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
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
        public NewSimpleEntityExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        public InsertEntityExprContext insertEntityExpr() {
            return getRuleContext(InsertEntityExprContext.class, 0);
        }

        public InsertListExprContext insertListExpr() {
            return getRuleContext(InsertListExprContext.class, 0);
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
        public NewSimpleArithmeticExprContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        public SimpleArithmeticExprContext simpleArithmeticExpr() {
            return getRuleContext(SimpleArithmeticExprContext.class, 0);
        }

        @Override
        public Object getValue() {
            return OgnlUtil.eval(getText());
        }
    }

    public static class NewNullContext extends NewValueContext {
        public NewNullContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode NULL() {
            return getToken(OQLParser.NULL, 0);
        }

        @Override
        public Object getValue() {
            return null;
        }
    }

    public static class NewStringPrimaryContext extends NewValueContext {
        public NewStringPrimaryContext(NewValueContext ctx) {
            copyFrom(ctx);
        }

        public StringPrimaryContext stringPrimary() {
            return getRuleContext(StringPrimaryContext.class, 0);
        }

        @Override
        public Object getValue() {
            return getText().replaceAll("'", "");
        }
    }

    public static class InsertListExprContext extends EnhancedParserRuleContext {
        public InsertListExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_insertListExpr;
        }
    }

    public static class InsertListItemContext extends EnhancedParserRuleContext {
        public InsertListItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INTNUMERAL() {
            return getToken(OQLParser.INTNUMERAL, 0);
        }

        public TerminalNode COLON() {
            return getToken(OQLParser.COLON, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertListItem;
        }
    }

    public static class InsertEntityExprContext extends EnhancedParserRuleContext {
        public InsertEntityExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_insertEntityExpr;
        }
    }

    public static class InsertEntityItemContext extends EnhancedParserRuleContext {
        public InsertEntityItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PathExprContext pathExpr() {
            return getRuleContext(PathExprContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(OQLParser.COLON, 0);
        }

        public NewValueContext newValue() {
            return getRuleContext(NewValueContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_insertEntityItem;
        }
    }

    public static class DeleteStatContext extends EnhancedParserRuleContext {
        public DeleteStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public DeleteClauseContext deleteClause() {
            return getRuleContext(DeleteClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deleteStat;
        }
    }

    public static class DeleteClauseContext extends EnhancedParserRuleContext {
        public DeleteClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_deleteClause;
        }
    }

    public static class InsertStatContext extends EnhancedParserRuleContext {
        public InsertStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_insertStat;
        }
    }

    public static class ColumnListContext extends EnhancedParserRuleContext {
        public ColumnListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
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

        @Override
        public int getRuleIndex() {
            return RULE_columnList;
        }
    }

    public static class InsertValueContext extends EnhancedParserRuleContext {
        public InsertValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_insertValue;
        }
    }

    public static class DropStatContext extends EnhancedParserRuleContext {
        public DropStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_dropStat;
        }
    }

    public static class ShowStatContext extends EnhancedParserRuleContext {
        public ShowStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SHOW() {
            return getToken(OQLParser.SHOW, 0);
        }

        public TerminalNode TABLES() {
            return getToken(OQLParser.TABLES, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_showStat;
        }
    }

    public static class CreateIndexStatContext extends EnhancedParserRuleContext {
        public CreateIndexStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_createIndexStat;
        }
    }

    public static class DropIndexStatContext extends EnhancedParserRuleContext {
        public DropIndexStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

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

        @Override
        public int getRuleIndex() {
            return RULE_dropIndexStat;
        }
    }

    public static class SyncStatContext extends EnhancedParserRuleContext {
        public SyncStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SYNC() {
            return getToken(OQLParser.SYNC, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_syncStat;
        }
    }

    public static class BeginTranStatContext extends EnhancedParserRuleContext {
        public BeginTranStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BEGIN() {
            return getToken(OQLParser.BEGIN, 0);
        }

        public TerminalNode TRANSACTION() {
            return getToken(OQLParser.TRANSACTION, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_beginTranStat;
        }
    }

    public static class CommitStatContext extends EnhancedParserRuleContext {
        public CommitStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode COMMIT() {
            return getToken(OQLParser.COMMIT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_commitStat;
        }
    }

    public static class RollBackStatContext extends EnhancedParserRuleContext {
        public RollBackStatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ROLL() {
            return getToken(OQLParser.ROLL, 0);
        }

        public TerminalNode BACK() {
            return getToken(OQLParser.BACK, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rollBackStat;
        }
    }
}