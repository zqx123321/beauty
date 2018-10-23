grammar OQL;


oqlStat
    : selectStat   #selectStatement
    | createStat   #createStatement
    | insertStat   #insertStatement
    | updateStat   #updateStatement
    | deleteStat   #deleteStatement
    | dropStat     #dropStatement
    ;

selectStat
    : SELECT selectClause fromClause (whereClause)? (groupByClause)? (havingClause)? (orderByClause)? (limitClause)?
    ;

selectClause
    :  (DISTINCT)? selectExpr (COMMA selectExpr)*
    ;

selectExpr
    : pathExpr    #selectPathExpr
    | aggregateExpr   #selectAggregateExpr
    | OBJECT  LBRACKET id RBRACKET  #selectObjectExpr
    | constructorExpr #selectConstructorExpr
    ;

fromClause
    : FROM fromItem (COMMA fromItem)*
    ;

fromItem
    : schemaName (AS)? id join?
    ;

join
    : joinType pathExpr (AS id)?
   ;

joinType
    :((LEFT|RIGHT) (OUTER)? | INNER )? JOIN
    ;

pathExpr
    :  id  (DOT field)*
    ;

limitClause
    :LIMIT INTNUMERAL (COMMA INTNUMERAL)?
    ;

constructorExpr
    : NEW constructorName LBRACKET constructorItem (COMMA constructorItem)* RBRACKET;

constructorItem
    : pathExpr #conPathExpr
    | aggregateExpr #conAggregateExpr
    ;

aggregateExpr
    : aggregateExprFunctionName LBRACKET (DISTINCT)? pathExpr RBRACKET
    ;

aggregateExprFunctionName
    : AVG | MAX | MIN | SUM | COUNT;

whereClause
    : WHERE conditionalExpr
    ;

groupByClause
    : GROUP BY pathExpr (COMMA pathExpr)*
    ;

havingClause
    : HAVING conditionalExpr;

orderByClause
    : ORDER BY orderByItem (COMMA orderByItem)*
    ;

orderByItem
    : pathExpr  (ASC)? | DESC
    ;

subQuery
    : LBRACKET selectClause RBRACKET
    ;

conditionalExpr
    : (conditionalTerm) (OR conditionalTerm)*;

conditionalTerm
    : (conditionalFactor) (AND conditionalFactor)*;

conditionalFactor
    : (NOT)? simpleCondExpr #conditionalFactorSimpleCondExpr
    | LBRACKET conditionalExpr RBRACKET #conditionalFactorExpr
    ;

simpleCondExpr
    : comparisonExpr  #simpleComparisonExpr
    | betweenExpr #simpleBetweenExpr
    | likeExpr    #simpleLikeExpr
    | inExpr  #simpleInExpr
    | nullComparisonExpr  #simpleNullComparisonExpr
    | emptyCollectionComparisonExpr   #simpleEmptyCollectionExpr
    | collectionMemberExpr    #simpleCollectionMemberExpr
    | existsExpr  # simpleExistsExpr
    ;

betweenExpr
    : arithmeticExpr (NOT)? BETWEEN arithmeticExpr AND arithmeticExpr    #betweenArithmeticExpr
    | stringExpr (NOT)? BETWEEN stringExpr AND stringExpr     #betweenStringExpr
    ;

inExpr
    : pathExpr (NOT)? IN inExprRightPart;

inExprRightPart
    : LBRACKET inItem (COMMA inItem)* RBRACKET  #inExprItem
    | subQuery  #inExprsubQuery
    ;

inItem
    : literal;

likeExpr
    : stringExpr (NOT)? LIKE patternValue;

nullComparisonExpr
    : pathExpr IS (NOT)? NULL;

emptyCollectionComparisonExpr
    : pathExpr IS (NOT)? EMPTY;

collectionMemberExpr
    : entityExpr (NOT)? MEMBER (OF)? pathExpr;

existsExpr
    : (NOT)? EXISTS subQuery;

comparisonExpr
    : stringExpr comparisonOperator stringExpr  #comparisonStringExpr
    | entityExpr (EQ | NE)  entityExpr  #comparisonEntityExpr
    | arithmeticExpr comparisonOperator arithmeticExpr  #comparisonArithmeticExpr
    ;

comparisonOperator
    : EQ
    | GR
    | GE
    | LS
    | LE
    | NE;

arithmeticExpr
    : pathExpr  #arithmeticPathExpr
    | simpleArithmeticExpr   #arithmeticSimpleArithmeticExpr
    ;

simpleArithmeticExpr
    : (arithmeticTerm) (( PLUS | MINUS ) arithmeticTerm)*;

arithmeticTerm
    : (arithmeticFactor) (( MUL | DIV ) arithmeticFactor)*;

arithmeticFactor
    : ( PLUS | MINUS )? arithmeticPrimary;

arithmeticPrimary
    : numericLiteral    #ariPriNumericLiteral
    | LBRACKET simpleArithmeticExpr RBRACKET    #ariPriSimpleArithmeticExpr
    | aggregateExpr #ariPriAggregateExpr
    ;

stringExpr
    : stringPrimary #stringPri
    | subQuery  #stringSubQuery
    ;

stringPrimary
    : pathExpr  #stringPathExpr
    | stringLiteralExpr #stringLiteral
    | aggregateExpr #stringAggregateExpr
    ;

stringLiteralExpr
    :STRINGLITERAL
    ;

entityExpr
    : pathExpr  #entityPathExpr
    | simpleEntityExpr  #entitySimpleEntityExpr
    ;

simpleEntityExpr
    : WORD
    ;

schemaName
    : WORD;

//todo fix pattern value if needed
patternValue
    : WORD;

numericLiteral
    : INTNUMERAL
    | FLOATNUMERAL
    ;

literal
    : WORD;

constructorName
    : WORD;

field
    : WORD;

id
    : WORD;

createStat
    : CREATE TABLE tableName columnDefinition? extendsTable? tableConstraint?
    ;

tableName
    : WORD
    ;

columnDefinition
    : LBRACKET columnDefinitionItem (COMMA columnDefinitionItem)* RBRACKET
    ;

columnDefinitionItem
    : WORD columnType columnConstraint*
    ;

columnType
	: INT
	| FLOAT
	| CHAR LBRACKET INTNUMERAL RBRACKET
	| SETOF LBRACKET columnType RBRACKET
	| REF LBRACKET WORD RBRACKET
	;

columnConstraint
    : AUTO_INCREMENT
    | PRIMARY KEY
    | UNIQUE KEY
    ;

extendsTable
    : EXTENDS WORD(COMMA WORD)*
    ;

tableConstraint
    : PRIMARY KEY LBRACKET pathExpr(COMMA pathExpr)* RBRACKET;


updateStat
   : updateClause (whereClause)?
   ;

updateClause
   : UPDATE schemaName (AS)? id SET updateItem (COMMA updateItem)* whereClause?
   ;

updateItem
   : pathExpr EQ newValue
   ;

newValue
   : simpleArithmeticExpr   #newSimpleArithmeticExpr
   | stringPrimary  #newStringPrimary
   | insertEntityExpr   #newSimpleEntityExpr
   | NULL   #newNull
   ;

insertEntityExpr
    :LBRACKET insertEntityItem (COMMA insertEntityItem)* RBRACKET
    ;

insertEntityItem
    :pathExpr COLON newValue
    ;

deleteStat
   : deleteClause (whereClause)?
   ;

deleteClause
   : DELETE FROM schemaName (AS)? id
   ;


insertStat
    : INSERT INTO tableName columnList? VALUES insertValue
    ;

columnList
    : LBRACKET pathExpr(COMMA pathExpr)* RBRACKET
    ;

insertValue
    : LBRACKET newValue(COMMA newValue)* RBRACKET
    ;

dropStat
    : DROP TABLE WORD (CASCADE)?
    ;


fragment A:('A'|'a');
fragment B:('B'|'b');
fragment C:('C'|'c');
fragment D:('D'|'d');
fragment E:('E'|'e');
fragment F:('F'|'f');
fragment G:('G'|'g');
fragment H:('H'|'h');
fragment I:('I'|'i');
fragment J:('J'|'j');
fragment K:('K'|'k');
fragment L:('L'|'l');
fragment M:('M'|'m');
fragment N:('N'|'n');
fragment O:('O'|'o');
fragment P:('P'|'p');
fragment Q:('Q'|'q');
fragment R:('R'|'r');
fragment S:('S'|'s');
fragment T:('T'|'t');
fragment U:('U'|'u');
fragment V:('V'|'v');
fragment W:('W'|'w');
fragment X:('X'|'x');
fragment Y:('Y'|'y');
fragment Z:('Z'|'z');

SELECT:S E L E C T;
CREATE:C R E A T E;
UPDATE:U P D A T E;
DELETE:D E L E T E;
INSERT:I N S E R T;
FROM:F R O M;
AS:A S;
LEFT:L E F T;
RIGHT:R I G H T;
OUTER:O U T E R;
JOIN:J O I N;
INNER:I N N E R;
DISTINCT:D I S T I N C T;
OBJECT:O B J E C T;
NEW:N E W;
AVG:A V G;
SUM:S U M;
MAX:M A X;
MIN:M I N;
COUNT:C O U N T;
WHERE:W H E R E;
GROUP:G R O U P;
BY:B Y;
ORDER:O R D E R;
HAVING:H A V I N G;
DESC:D E S C;
ASC:A S C;
NOT:N O T;
BETWEEN:B E T W E E N;
IS:I S;
NULL: N U L L;
ESCAPE:E S C A P E;
AND:A N D;
OR:O R;
LIKE:L I K E;
IN:I N;
INTO:I N T O;
VALUES:V A L U E S;
PRIMARY:P R I M A R Y;
KEY:K E Y;
SET:S E T;
EXTENDS:E X T E N D S;
EMPTY:E M P T Y;
MEMBER:M E M B E R;
OF:O F;
ALL:A L L;
ANY:A N Y;
SOME:S O M E;
INT:I N T;
FLOAT:F L O A T;
CHAR:C H A R;
SETOF:S E T O F;
REF: R E F;
TABLE:T A B L E;
EXISTS:E X I S T S;
AUTO_INCREMENT:A U T O'_'I N C R E M E N T;
UNIQUE:U N I Q U E;
LIMIT:L I M I T;
DROP:D R O P;
CASCADE:C A S C A D E;

MUL:                                '*';
DIV:                                '/';
PLUS:                               '+';
MINUS:                              '-';

EQ:                                 '=';
GR:                                 '>';
LS:                                 '<';
GE:                                 '>=';
LE:                                 '<=';
NE:                                 '<>'|'!=';



DOT:                                 '.';
LBRACKET:                            '(';
RBRACKET:                            ')';
COMMA:                               ',';
SEMI:                                ';';
COLON:                               ':';

TRIMCHARACTER
    : '\'.\'';

STRINGLITERAL
    : '\'' (~('\'' | '"') )* '\'' ;

WORD
    : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'$')*;

NAMEDPARAMETER
    : ':'('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'$')* (('.') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'$')+)*;

WS  : (' '|'\r'|'\t'|'\u000C'|'\n')->skip
    ;

COMMENT
    : '/*' .*? '*/' ->skip
    ;

LINECOMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n'
    ;

ESCAPECHARACTER
    : '\'' (~('\''|'\\') ) '\'';

INTNUMERAL
    : ('0'..'9')+;

FLOATNUMERAL
    : ('0'..'9')+DOT('0'..'9')+;