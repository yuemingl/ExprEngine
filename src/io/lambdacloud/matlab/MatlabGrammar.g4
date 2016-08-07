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

expr_end : (WS* (SEMI|'\n') WS*)+;

statements
 : statement* (expression expr_end?)?   # ExprStatements
 ;

statement
 : WS* (tic | toc) WS* expr_end? # TicToc
 | 'function' (func_def_return ASSIGN)? func_name_args (expr_end|(WS* COMMA WS*))? expression_with_expr_end* 'end' WS* expr_end?   # FuncDef
 | 'for' WS* IDENTIFIER WS* (ASSIGN|'in') WS* range_expr (expr_end|(WS* COMMA WS*))? expression_with_expr_end* 'end' WS* expr_end?   # ExprFor
 | expression_with_expr_end   # ExprStatement
 ;

tic : 'tic' ;
toc : 'toc' ;

expression_with_expr_end
 : expression expr_end   # ExprWithExprEnd
 | WS* 'if' if_cond_and_body ((WS* 'elseif') if_cond_and_body)* ((WS* 'else' WS* expr_end?) else_body)? (WS* 'end' WS* expr_end?)   # ExprIf
 ;

if_cond_and_body : logical_expr expr_end expression_with_expr_end* ;
else_body : expression_with_expr_end* ;

expression
 : arithmetic_expr       # ExprArithmetic
 | assign_expr           # ExprAssign
 | logical_expr          # ExprLogical
 | range_expr            # ExprRange1
 ;

range_expr : arithmetic_expr COLON (arithmetic_expr COLON)? arithmetic_expr # ExprRange;

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

array_init : WS* LBRK WS* ( ai_list WS* SEMI WS* )* ai_list WS* RBRK WS* ;
ai_list : ( expression (COMMA|WS+) )* expression? ;

array_access: WS* IDENTIFIER (PERIOD IDENTIFIER)* WS* LPAREN WS* ( aa_index WS* COMMA WS* )* aa_index? WS* RPAREN WS* ;
aa_index : expression | COLON ;

// Use array_access instead for function call
//func_call : IDENTIFIER (PERIOD IDENTIFIER)* func_args                        # FuncCall ;
//func_args : WS* LPAREN ( expression (COMMA|WS+) )* expression? RPAREN WS*;

func_name_args : WS* IDENTIFIER WS* LPAREN ( WS* IDENTIFIER WS* COMMA WS* )* (WS* IDENTIFIER WS*)? RPAREN WS*   # FuncDefNameArgs;
func_def_return : WS* (variable_entity|array_init) WS* ;

assign_expr : WS* IDENTIFIER WS* ASSIGN expression ;

/////////////////////////

logical_expr
 : comparison_expr                   # ComparisonExpression
 | logical_expr AND logical_expr     # LogicalExpressionAnd
 | logical_expr OR logical_expr      # LogicalExpressionOr
 | NOT logical_expr                  # LogicalExpressionNot
 | LPAREN logical_expr RPAREN        # LogicalExpressionInParen
 | logical_entity                    # LogicalExpressionEntity
 ;

 comparison_expr 
 : arithmetic_expr comp_operator arithmetic_expr                      # ComparisonArithmeticExpression
// | string_expr ( (WS* EQ WS*) | (WS* NEQ WS*) ) string_ex           # ComparisonStringExpression
 ;

comp_operator 
 : GT | GE | LT | LE | EQ | NEQ ;

logical_entity  : ( (WS* TRUE WS*) | (WS* FALSE WS*) ) # EntityLogicalConst ;

