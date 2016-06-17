grammar ExprGrammar;

@header {
package io.lambdacloud;
}

/* Lexical rules */

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
REM : '%' ;

AND : 'and' | '&&' ;
OR  : 'or' | '||' ;
NOT : 'not' | '!';

TRUE  : 'true' ;
FALSE : 'false' ;

GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
EQ : '==' ;
NEQ : '!=' ;

BAND : '&' ;
BOR  : '|' ;
BXOR : '^' ;
BNOT : '~' ;

SHL  : '<<'  ;
SHR  : '>>'  ;
USHR : '>>>' ;

INC  : '++' ;
DESC : '--' ;

ADD_ASSIGN : '+=' ;
SUB_ASSIGN : '-=' ;
MUL_ASSIGN : '*=' ;
DIV_ASSIGN : '/=' ;
REM_ASSIGN : '%=' ;

ASSIGN : '=' ;

LPAREN : '(' ;
RPAREN : ')' ;
LCB : '{' ;
RCB : '}' ;


// DECIMAL, IDENTIFIER, COMMENTS, WS are set using regular expressions

INTEGER : [0-9]+ ;

FLOAT : [0-9]?'.'[0-9]+ ;

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

COMMA : ',' ;

SEMI : ';' ; //we can only have one lexical rule for ';'

// COMMENT and WS are stripped from the output token stream by sending
// to a different channel 'skip'

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS : [ \r\t\u000C]+ -> skip ; //'\n' is not a WS

/* Parser rules */

prog : statements EOF ;

block : LCB statements RCB       # StatementBlock;

statements
 : statement* (expression expr_end?)?
 ;

statement
 : assign_expr expr_end                                       # ExprAssign2
 | 'if' LPAREN logical_expr RPAREN block ('else' block)?      # ExprIf
 | 'while' LPAREN logical_expr RPAREN block                   # ExprWhile
 | 'for' LPAREN (assign_expr COMMA)* assign_expr? SEMI  logical_expr SEMI (expression COMMA)* expression? RPAREN (SEMI | block?)   # ExprFor
 ;

expression
 : arithmetic_expr       # ExprArithmetic
 | logical_expr          # ExprLogical
 | assign_expr           # ExprAssign1
 ;

assign_expr
 : IDENTIFIER ASSIGN     (expression | statement)      # ExprAssign //Using 'IDENTIFIER', EntityVariable() will not be called
 | variable_entity MUL_ASSIGN (expression | statement) # ExprMulAssign
 | variable_entity DIV_ASSIGN (expression | statement) # ExprDivAssign
 | variable_entity REM_ASSIGN (expression | statement) # ExprRemAssign
 | variable_entity ADD_ASSIGN (expression | statement) # ExprAddAssign
 | variable_entity SUB_ASSIGN (expression | statement) # ExprSubAssign
 ;

logical_expr
 : comparison_expr                   # ComparisonExpression
 | logical_expr AND logical_expr     # LogicalExpressionAnd
 | logical_expr OR logical_expr      # LogicalExpressionOr
 | NOT logical_expr                  # LogicalExpressionNot
 | LPAREN logical_expr RPAREN        # LogicalExpressionInParen
 | logical_entity                    # LogicalExpressionEntity
 ;

comparison_expr 
 : arithmetic_expr comp_operator arithmetic_expr       # ComparisonExpressionWithOperator
 ;

comp_operator 
 : GT | GE | LT | LE | EQ | NEQ ;

arithmetic_expr
 : IDENTIFIER (INC | DESC)                   # ArithmeticExpressionIncDec //Using 'IDENTIFIER', EntityVariable() will not be called
 | BNOT arithmetic_expr                      # BitExpressionNot
 | SUB arithmetic_expr                       # ArithmeticExpressionNegationEntity
 | arithmetic_expr MUL arithmetic_expr       # ArithmeticExpressionMul
 | arithmetic_expr DIV arithmetic_expr       # ArithmeticExpressionDiv
 | arithmetic_expr REM arithmetic_expr       # ArithmeticExpressionRem
 | arithmetic_expr ADD arithmetic_expr       # ArithmeticExpressionAdd
 | arithmetic_expr SUB arithmetic_expr       # ArithmeticExpressionSub
 | arithmetic_expr SHL arithmetic_expr       # BitExpressionShl
 | arithmetic_expr SHR arithmetic_expr       # BitExpressionShr
 | arithmetic_expr USHR arithmetic_expr      # BitExpressionUshr
 | arithmetic_expr BAND arithmetic_expr      # BitExpressionAnd
 | arithmetic_expr BOR arithmetic_expr       # BitExpressionOr
 | arithmetic_expr BXOR arithmetic_expr      # BitExpressionXor
 | LPAREN arithmetic_expr RPAREN             # ArithmeticExpressionParens
 | numeric_entity                            # ArithmeticExpressionEntity
 ;

numeric_entity 
 : integer_entity
 | float_entity
 | variable_entity
 ;

integer_entity  : INTEGER        # EntityConstInteger ;
float_entity    : FLOAT          # EntityConstFloat   ;
variable_entity : IDENTIFIER     # EntityVariable     ;
logical_entity  : (TRUE | FALSE) # EntityLogicalConst ;

expr_end : (SEMI | '\n')+ ;

