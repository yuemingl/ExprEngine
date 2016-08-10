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

INTEGER : [0-9]+'L'? ;
FLOAT : ([0-9]*'.'[0-9]+) | ([0-9]+'.'[0-9]*) ;
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

prog : statement_block EOF ;

statement_block
 : statement* (expression expr_end?)? ;

expr_end : (WS* (SEMI|'\n') WS*)+;

statement
 : WS* (tic | toc) WS* expr_end?   # TicToc
 | WS* 'nargin' WS* expr_end?   # NArgIn
 | WS* 'function' (func_def_return ASSIGN)? func_name_args (expr_end|(WS* COMMA WS*))? statement_block 'end' WS* expr_end?   # FuncDef
 | WS* 'if' if_cond_and_body ((WS* 'elseif') if_cond_and_body)* ((WS* 'else' WS* expr_end?) else_body)? (WS* 'end' WS* expr_end?)   # ExprIf
 | WS* 'for' WS* IDENTIFIER WS* (ASSIGN|'in') WS* range_expr (expr_end|(WS* COMMA WS*))? statement_block 'end' WS* expr_end?   # ExprFor
 | WS* 'while' logical_expr (expr_end|(WS* COMMA WS*))? statement_block 'end' WS* expr_end?   # ExprWhile
 | expression_with_expr_end   # ExprWithExprEnd1
 ;

tic : 'tic' ;
toc : 'toc' ;

expression_with_expr_end
 : expression expr_end   # ExprWithExprEnd
 ;

if_cond_and_body : logical_expr expr_end statement_block ;
else_body : statement_block ;

expression
 : arithmetic_expr       # ExprArithmetic
 | assign_expr           # ExprAssign1
 | logical_expr          # ExprLogical
 | range_expr            # ExprRange1
 ;

range_expr : arithmetic_expr COLON (arithmetic_expr COLON)? arithmetic_expr # ExprRange;

arithmetic_expr
 : arithmetic_expr SQUOTE                     # Transpose
 | WS* SUB arithmetic_expr                        # ArithmeticExpressionNegationEntity
 | arithmetic_expr (POW|BXOR) arithmetic_expr        # ArithmeticExpressionPow
 | arithmetic_expr mul_div_operator arithmetic_expr        # ArithmeticExpressionMulDiv
 | arithmetic_expr REM arithmetic_expr        # ArithmeticExpressionRem
 | arithmetic_expr add_sub_operator arithmetic_expr # ArithmeticExpressionAddSub
 | WS* LPAREN arithmetic_expr RPAREN WS*              # ArithmeticExpressionParens
 | array_init                                 # ExprArrayInit
 | numeric_entity                             # ArithmeticExpressionEntity
 ;

add_sub_operator : SUB | DSUB | ADD | DADD ;
mul_div_operator : SOL | DIV | DLDIV | DRDIV | MUL | DMUL ;

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

/////////////////////////

logical_expr
 : comparison_expr                   # ComparisonExpression
 | logical_expr AND logical_expr     # LogicalExpressionAnd
 | logical_expr OR logical_expr      # LogicalExpressionOr
 | WS* NOT logical_expr                  # LogicalExpressionNot
 | WS* LPAREN logical_expr RPAREN WS*       # LogicalExpressionInParen
 | logical_entity                    # LogicalExpressionEntity
 ;

 comparison_expr 
 : arithmetic_expr comp_operator arithmetic_expr                      # ComparisonArithmeticExpression
// | string_expr ( (WS* EQ WS*) | (WS* NEQ WS*) ) string_ex           # ComparisonStringExpression
 ;

comp_operator 
 : GT | GE | LT | LE | EQ | NEQ ;

logical_entity  : ( (WS* TRUE WS*) | (WS* FALSE WS*) ) # EntityLogicalConst ;

///////////////////////////
assign_expr
 : WS* IDENTIFIER WS* ASSIGN expression   # ExprAssign
 | WS* IDENTIFIER WS* LPAREN WS* ( aa_index WS* COMMA WS* )* aa_index? WS* RPAREN WS* ASSIGN expression # ExprArrayAssign
 | WS* variable_entity WS* MUL_ASSIGN expression   # ExprMulAssign
 | WS* variable_entity WS* DIV_ASSIGN expression   # ExprDivAssign
 | WS* variable_entity WS* REM_ASSIGN expression   # ExprRemAssign
 | WS* variable_entity WS* ADD_ASSIGN expression   # ExprAddAssign
 | WS* variable_entity WS* SUB_ASSIGN expression   # ExprSubAssign
 ;
