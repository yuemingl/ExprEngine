grammar MatlabGrammar;

@header {
package io.lambdacloud.matlab;
}

/* Lexical rules */

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
//REM : '%' ;
POW : '**' | '^';
SOL : '\\' ;

DADD : '.+' ;
DSUB : '.-' ;
DMUL : '.*' ;
DRDIV : './' ;
DLDIV : '.\\' ;
DPOW : '.**' | '.^';

AND : 'and' | '&&' ;
OR  : 'or' | '||' ;
NOT : 'not' | '!' | '~';

TRUE  : 'true' ;
FALSE : 'false' ;

GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
EQ : '==' ;
NEQ : '!=' ;
NEQ2 : '~=' ;

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

END : 'end' ;
NARGIN : 'nargin' ;
NARGOUT : 'nargout' ;
CLASS : 'class' ;

BAND : '&' ;
BOR  : '|' ;
BXOR : '^' ; //conflict with pow???
BNOT : '~' ;

// DECIMAL, IDENTIFIER, COMMENTS, WS are set using regular expressions

INTEGER : [0-9]+'L'? ;
FLOAT : ([0-9]*'.'[0-9]+) | ([0-9]+'.'[0-9]*) ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

COMMA : ',' ;
COLON : ':' ;
SEMI : ';' ; //we can only have one lexical rule for ';'
PERIOD : '.' ;

SQUOTE : '`'  ; //SPIKE: use ` instead of ' in order to support matrix transpose
DQUOTE : '"'   ;
DPRIME : '.\'' ;

// COMMENT and WS are stripped from the output token stream by sending
// to a different channel 'skip'
COMMENT : ('//'|'%') ~[\r\n]* EOF? -> skip ;
SKIP_TOKEN : (([\t\r\u000C]+)|('...'[ ]*[\r\n]+)) -> skip ; //'\n' is not a WS

WS : [ \t] ;

/* Parser rules */

prog : statement_block EOF? ;

statement_block
 : statement* (expression expr_end?)? ;

expr_end : (WS* SEMI ('\n'|WS)*) | ( WS* '\n' WS*)+;
expr_end2 : (WS* SEMI ('\n'|WS)*) | (WS* COMMA ('\n'|WS)*) | ( WS* '\n' WS*)+;

statement
 : expression_with_expr_end   # ExprWithExprEnd1
 | WS* (tic | toc) WS* expr_end?   # TicToc
 | WS* 'function' (func_def_return ASSIGN)? func_name_args expr_end2 statement_block (('end' WS* expr_end?)|EOF)   # FuncDef
 | WS* 'if' if_cond_and_body ((WS* 'elseif') if_cond_and_body)* ((WS* 'else' WS* expr_end?) else_body)? (WS* 'end' WS* expr_end?)   # ExprIf
 | WS* 'for' WS* IDENTIFIER WS* (ASSIGN|'in') WS* for_range_expr expr_end2 statement_block 'end' WS* expr_end?   # ExprFor
 | WS* 'while' arithmetic_expr expr_end2 statement_block 'end' WS* expr_end?   # ExprWhile
 | WS* 'return' expression? expr_end? WS*   # ExprReturn
 | WS* 'switch' expression expr_end2 ((WS* 'case') case_expr_and_body)* ((WS* 'otherwise' WS* expr_end?) otherwise_body)? (WS* 'end' WS* expr_end?)   # ExprSwitch
 | ( WS* '\n' WS*)+   # NewLines
 ;

tic : 'tic' ;
toc : 'toc' ;

expression_with_expr_end
 : expression expr_end   # ExprWithExprEnd
 ;

if_cond_and_body : arithmetic_expr expr_end2 statement_block ;
else_body : statement_block ;

case_expr_and_body : expression expr_end2 statement_block ;
otherwise_body : statement_block ;

expression
 : arithmetic_expr       # ExprArithmetic
 | assign_expr           # ExprAssign1
 ;

for_range_expr
 : (arithmetic_expr COLON (arithmetic_expr COLON)? arithmetic_expr)   # ForRangeColon
 | array_init                                                         # ForRangeArrayInit1
;

arithmetic_expr
 : arithmetic_expr ('\''|DPRIME)                      # Transpose
 | WS* SUB arithmetic_expr                            # ArithmeticExpressionNegationEntity

 | arithmetic_expr (POW|DPOW) arithmetic_expr         # ArithmeticExpressionPow
 | arithmetic_expr mul_div_operator arithmetic_expr   # ArithmeticExpressionMulDiv
 | arithmetic_expr add_sub_operator arithmetic_expr   # ArithmeticExpressionAddSub

 | arithmetic_expr COLON (arithmetic_expr COLON)? arithmetic_expr   # ExprRange

 | arithmetic_expr comp_operator arithmetic_expr      # ComparisonArithmeticExpression
 
 | arithmetic_expr AND arithmetic_expr                # LogicalExpressionAnd
 | arithmetic_expr OR arithmetic_expr                 # LogicalExpressionOr
 | WS* NOT arithmetic_expr                            # LogicalExpressionNot
 | arithmetic_expr bit_operator arithmetic_expr       # ArithmeticExpressionBit
 
 | WS* LPAREN arithmetic_expr RPAREN WS*              # ArithmeticExpressionParens
 | array_init                                         # ExprArrayInit
 | cell_init                                          # ExprCellInit
 | numeric_entity                                     # ArithmeticExpressionEntity
 | logical_entity                                     # LogicalExpressionEntity
 | string_entity                                      # StringEntity
 | WS* NARGIN WS* expr_end?                           # NArgIn
 | WS* NARGOUT WS* expr_end?                          # NArgOut
 ;

mini_airth_expr 
 : mini_airth_expr mul_div_operator mini_airth_expr   # MiniArithMulDiv
 | mini_airth_expr add_sub_operator mini_airth_expr   # MiniArithAddSub
 | WS* LPAREN mini_airth_expr RPAREN WS*              # MiniArithParens
 | numeric_entity                                     # MiniArithEntity
 | END                                                # EndIndex
 ;
 
add_sub_operator : SUB | DSUB | ADD | DADD ;
mul_div_operator : SOL | DIV | DLDIV | DRDIV | MUL | DMUL ;
bit_operator     : BAND | BOR | BXOR | BNOT ;

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
 : IDENTIFIER (PERIOD IDENTIFIER)*   # EntityVariable
 | variable_entity WS* LPAREN WS* ( aa_index WS* COMMA WS* )* aa_index? WS* RPAREN # ArrayAccessOrFuncCall
 | variable_entity WS* LCB WS* ( aa_index WS* COMMA WS* )* aa_index? WS* RCB       # CellAccess
 | WS* special_name WS* LPAREN WS* ( aa_index WS* COMMA WS* )* aa_index? WS* RPAREN # SpecialFuncCall
 ;

special_name : FALSE | TRUE | NARGIN | NARGOUT | CLASS;

array_init : WS* LBRK WS* ( ai_list WS* SEMI WS* ('\n')* WS* )* ai_list WS* RBRK WS* ;
cell_init : WS* LCB WS* ( ai_list WS* SEMI WS* )* ai_list WS* RCB WS* ;
ai_list : ( expression (COMMA|WS|'\n')+ )* expression? ;

//array access (aa_xxx) index
aa_index 
 : expression
 | COLON
 | func_handle
 | aa_range
 | mini_airth_expr 
 ;
aa_range : aa_range_start WS* COLON WS* (aa_range_step WS* COLON WS*)? aa_range_end;
aa_range_start : mini_airth_expr | expression;
aa_range_step : expression ;
aa_range_end : mini_airth_expr | expression;

func_name_args : WS* IDENTIFIER WS* LPAREN ( WS* IDENTIFIER WS* COMMA WS* )* (WS* IDENTIFIER WS*)? RPAREN WS*   # FuncDefNameArgs;
func_def_return : WS* (variable_entity|array_init) WS* ;

/////////////////////////

comp_operator : GT | GE | LT | LE | EQ | NEQ | NEQ2;

logical_entity  : ( (WS* TRUE WS*) | (WS* FALSE WS*) ) # EntityLogicalConst ;

///////////////////////////

assign_expr
 : WS* variable_entity WS* ASSIGN expression       # ExprAssign
// | WS* LBRK WS* ( IDENTIFIER WS* (COMMA|WS+) WS* )* IDENTIFIER? WS* RBRK WS* ASSIGN expression # ExprMultiAssign
 | WS* LBRK WS* ( variable_entity WS* (COMMA|WS+) WS* )* variable_entity? WS* RBRK WS* ASSIGN expression # ExprMultiAssign
 | WS* variable_entity WS* MUL_ASSIGN expression   # ExprMulAssign
 | WS* variable_entity WS* DIV_ASSIGN expression   # ExprDivAssign
 | WS* variable_entity WS* REM_ASSIGN expression   # ExprRemAssign
 | WS* variable_entity WS* ADD_ASSIGN expression   # ExprAddAssign
 | WS* variable_entity WS* SUB_ASSIGN expression   # ExprSubAssign
 ;

 /////////////////////////

 string_entity
 : WS* StringLiteral WS*       # StringConst
 | WS* variable_entity WS*     # StringVariable1
 ;

StringLiteral : (SQUOTE Characters? SQUOTE) | (DQUOTE Characters? DQUOTE);

fragment
Characters : Character+ ;

fragment
Character
 : ~[`"\\\n]
 | EscapeSeq
 ;

fragment
EscapeSeq
 : '\\' [btnfr"`\\]
 ;

//////////////////////////////
func_handle : '@' IDENTIFIER  # FuncHandle ;
 
 