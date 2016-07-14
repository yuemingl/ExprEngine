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
POW : '**' ;

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
FLOAT : [0-9]*'.'[0-9]+ ;
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
WS : [ \r\t\u000C]+ -> skip ; //'\n' is not a WS

/* Parser rules */

prog : statements EOF ;

statements
 : statement* (expression expr_end?)?
 ;

statement
 : assign_expr expr_end                                       # ExprAssign2
 | 'if' LPAREN logical_expr RPAREN block ('else' block)?      # ExprIf
 | 'while' LPAREN logical_expr RPAREN block                   # ExprWhile
 | 'for' LPAREN (assign_expr COMMA)* assign_expr? SEMI  logical_expr SEMI (expression COMMA)* expression? RPAREN (SEMI | block?)   # ExprFor
 | func_call expr_end                                         # FuncCall2
 | 'def' IDENTIFIER LPAREN (IDENTIFIER COMMA)* IDENTIFIER? RPAREN block # FuncDef
 ;

block : LCB statements RCB       # StatementBlock;

expression
 : arithmetic_expr       # ExprArithmetic
 | logical_expr          # ExprLogical
 | string_expr           # ExprString
 | assign_expr           # ExprAssign1
 | array_init            # ExprArrayInit
 | list_comprehension    # ListComprehension
 | array_gen             # ExprArrayGen
 | 'sum' expression list_comp_for_if+                         # ExprSum
 ;

assign_expr
 : IDENTIFIER ASSIGN     (expression | statement | array_init)          # ExprAssign //Using 'IDENTIFIER', EntityVariable() will not be called
 | IDENTIFIER array_index+ ASSIGN (expression | statement | array_init) # ExprArrayAssign
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
 : arithmetic_expr comp_operator arithmetic_expr       # ComparisonArithmeticExpression
 | string_expr (EQ | NEQ) string_expr                  # ComparisonStringExpression
 ;

comp_operator 
 : GT | GE | LT | LE | EQ | NEQ ;

arithmetic_expr
 : IDENTIFIER (INC | DESC)                   # ArithmeticExpressionIncDec //Using 'IDENTIFIER', EntityVariable() will not be called
 | BNOT arithmetic_expr                      # BitExpressionNot
 | SUB arithmetic_expr                       # ArithmeticExpressionNegationEntity
 | arithmetic_expr POW arithmetic_expr       # ArithmeticExpressionPow
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
 | func_call                                 # FuncCall1
 ;

string_expr
 : string_entity ADD string_entity # StringConcat
 | string_entity                   # StringEntity
 ;

numeric_entity 
 : integer_entity
 | float_entity
 | variable_entity
 ;

integer_entity  : INTEGER        # EntityConstInteger ;
float_entity    : FLOAT          # EntityConstFloat   ;

index_entity
 : integer_entity
 | variable_entity
 ;

variable_entity 
 : IDENTIFIER                     # EntityVariable
 | IDENTIFIER array_index+        # EntityArrayAccess
 ;

array_index : LBRK arithmetic_expr (COLON arithmetic_expr)? RBRK ;

logical_entity  : (TRUE | FALSE) # EntityLogicalConst ;

expr_end : (SEMI | '\n')+ ;

string_entity
 : StringLiteral     # StringConst
 | variable_entity   # StringVariable
 ;

StringLiteral : (DQUOTE|SQUOTE) Characters? (DQUOTE|SQUOTE);

fragment
Characters : Character+ ;

fragment
Character
 : ~['"\\]
 | EscapeSeq
 ;

fragment
EscapeSeq
 : '\\' [btnfr"'\\]
 ;

array_init : LBRK (expression COMMA)* expression? RBRK ;
array_gen : arithmetic_expr COLON arithmetic_expr ;

func_call 
 : IDENTIFIER (PERIOD IDENTIFIER)* LPAREN (expression COMMA)* expression? RPAREN # FuncCall
 ;
 
 list_comprehension
 : LBRK expression list_comp_for_if+ RBRK
 ;

list_comp_for_if : list_comp_for list_comp_if? ;
list_comp_for : 'for' IDENTIFIER 'in' expression ;
list_comp_if : 'if' logical_expr ;
 