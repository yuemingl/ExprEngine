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

expr_end : WS* (SEMI|'\n')+ WS*;

statements
 : statement* (expression expr_end?)?   # ExprStatements
 ;

statement
 : expression_with_expr_end   # ExprStatement
 | 'function' (func_def_return ASSIGN)? WS* IDENTIFIER WS* func_def_args ('\n'|COMMA) expression_with_expr_end* 'end' expr_end   # FuncDef
 ;

expression_with_expr_end : expression expr_end   # ExprWithExprEnd ;

expression
 : arithmetic_expr       # ExprArithmetic
 | assign_expr           # ExprAssign
 ;

arithmetic_expr
 : arithmetic_expr SQUOTE                     # Transpose
 | arithmetic_expr SOL arithmetic_expr        # ArithmeticExpressionSolve
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

integer_entity
 : INTEGER                        # EntityConstInteger 
 ;
float_entity
 : FLOAT                          # EntityConstFloat   
 ;
variable_entity
 : IDENTIFIER                     # EntityVariable
 | array_access                   # ArrayAccessOrFuncCall
 ;

array_init : WS* LBRK ( ai_list WS* SEMI WS* )* ai_list RBRK WS* ;
ai_list : ( expression (COMMA|WS+) )* expression? ;
 
array_access: WS* IDENTIFIER (PERIOD IDENTIFIER)* WS* LPAREN ( aa_index COMMA )* aa_index? RPAREN WS* ;
aa_index : expression | COLON ;

// Use array_access instead for function call
//func_call : IDENTIFIER (PERIOD IDENTIFIER)* func_args                        # FuncCall ;
//func_args : WS* LPAREN ( expression (COMMA|WS+) )* expression? RPAREN WS*;

func_def_args : WS* LPAREN ( WS* IDENTIFIER WS* COMMA WS* )* (WS* IDENTIFIER WS*)? RPAREN WS* ;
func_def_return : WS* (variable_entity|array_init) WS* ;

assign_expr : WS* IDENTIFIER WS* ASSIGN expression ;

