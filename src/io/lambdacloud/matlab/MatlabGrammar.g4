grammar MatlabGrammar;

@header {
package io.lambdacloud.matlab;
}

/* Lexical rules */

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
REM : '%' ;
POW : '**' ;
SOL : '\\' ;

DADD : '.+' ;
DSUB : '.-' ;
DMUL : '.*' ;
DRDIV : './' ;
DLDIV : '.\\' ;

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
LBRK : '[' ;
RBRK : ']' ;
LCB : '{' ;
RCB : '}' ;


// DECIMAL, IDENTIFIER, COMMENTS, WS are set using regular expressions

INTEGER : [0-9]+ ;
FLOAT : [0-9]*'.'[0-9]* ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

COMMA : ',' ;
COLON : ':' ;
SEMI : ';' ; //we can only have one lexical rule for ';'
PERIOD : '.' ;

SQUOTE : '\'' ;
DQUOTE : '"' ; 

// COMMENT and WS are stripped from the output token stream by sending
// to a different channel 'skip'
COMMENT : '//' .+? ('\n'|EOF) -> skip ;
SKIP_TOKEN : [\r\u000C]+ -> skip ; //'\n' is not a WS

WS : [ \t] ;

/* Parser rules */

prog : statements EOF ;

expr_end : (SEMI | '\n')+ ;

statements
 : statement* (expression expr_end?)?
 ;

statement
 : assign_expr expr_end                                       # ExprAssign2
 ;

expression
 : arithmetic_expr       # ExprArithmetic
 | assign_expr           # ExprAssign1
 ;

arithmetic_expr
 : arithmetic_expr SOL arithmetic_expr        # ArithmeticExpressionSolve
 | arithmetic_expr SQUOTE                     # Transpose
 | SUB arithmetic_expr                        # ArithmeticExpressionNegationEntity
 | arithmetic_expr POW arithmetic_expr        # ArithmeticExpressionPow
 | arithmetic_expr MUL arithmetic_expr        # ArithmeticExpressionMul
 | arithmetic_expr DMUL arithmetic_expr       # ArithmeticExpressionDMul
 | arithmetic_expr DIV arithmetic_expr        # ArithmeticExpressionDiv
 | arithmetic_expr DLDIV arithmetic_expr       # ArithmeticExpressionDLDiv
 | arithmetic_expr DRDIV arithmetic_expr       # ArithmeticExpressionDRDiv
 | arithmetic_expr SOL arithmetic_expr        # ArithmeticExpressionSOL
 | arithmetic_expr REM arithmetic_expr        # ArithmeticExpressionRem
 | arithmetic_expr (ADD|DADD) arithmetic_expr # ArithmeticExpressionAdd
 | arithmetic_expr (SUB|DSUB) arithmetic_expr # ArithmeticExpressionSub
 | arithmetic_expr COLON arithmetic_expr      # ArithmeticExpressionRange
 | LPAREN arithmetic_expr RPAREN              # ArithmeticExpressionParens
 | array_init                                 # ExprArrayInit
 | numeric_entity                             # ArithmeticExpressionEntity
 ;

numeric_entity 
 : WS* integer_entity WS*
 | WS* float_entity WS*
 | WS* variable_entity WS*
 ;

integer_entity  : INTEGER        # EntityConstInteger ;

float_entity    : FLOAT          # EntityConstFloat   ;

variable_entity 
 : IDENTIFIER                     # EntityVariable
 | IDENTIFIER func_args           # EntityArrayAccess
 ;

array_init : LBRK ( expr_list WS* SEMI WS* )* expr_list RBRK ;

expr_list : ( expression (COMMA|WS+) )* expression? ;

func_args : LPAREN expr_list RPAREN ;

assign_expr
 : IDENTIFIER ASSIGN expression # ExprAssign //Using 'IDENTIFIER', EntityVariable() will not be called
 ;

