grammar MatlabGrammar;

@header {
package io.lambdacloud;
}

/* Lexical rules */

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
REM : '%' ;
POW : '**' ;
DMUL : '.*' ;
SOL : '\\' ;

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
 : (expression expr_end?)?
 ;

expression
 : arithmetic_expr       # ExprArithmetic
 | array_init            # ExprArrayInit
 | expression SQUOTE     # Transpose
 ;

arithmetic_expr
 : arithmetic_expr SOL arithmetic_expr       # ArithmeticExpressionSolve
 | arithmetic_expr ADD arithmetic_expr       # ArithmeticExpressionAdd
 | LPAREN arithmetic_expr RPAREN             # ArithmeticExpressionParens
 | numeric_entity                            # ArithmeticExpressionEntity
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
 ;

 array_init : LBRK ( expr_list WS* SEMI WS* )* expr_list RBRK ;

 expr_list : ( expression (COMMA|WS+) )* expression? ;
 
 