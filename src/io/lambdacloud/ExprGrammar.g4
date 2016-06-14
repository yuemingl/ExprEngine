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

ASIGN : '=' ;

LPAREN : '(' ;
RPAREN : ')' ;

// DECIMAL, IDENTIFIER, COMMENTS, WS are set using regular expressions

INTEGER : '-'?[0-9]+ ;

FLOAT : '-'?[0-9]?'.'[0-9]+ ;

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

//SEMI : ';' ; //we can only have one lexical rule for a ';'
END_EXPR : (';' | '\n')+ ;

// COMMENT and WS are stripped from the output token stream by sending
// to a different channel 'skip'

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS : [ \r\t\u000C]+ -> skip ; //'\n' is not a WS

/* Parser rules */

prog : (expr END_EXPR)* EOF ;

expr
 : arithmetic_expr                 # ExprArithmetic
 | logical_expr                    # ExprLogical
 | asign_expr                      # ExprAssign
// | IDENTIFIER ('++' | '--')        #ExprUnaryPostfix
// | ('+'|'-'|'++'|'--') IDENTIFIER  #ExprUnaryPrefix
// | ('~'|'!') IDENTIFIER            #ExprUnaryNot
 ;

asign_expr : IDENTIFIER ASIGN expr ;

logical_expr
 : comparison_expr               # ComparisonExpression
 | logical_expr AND logical_expr # LogicalExpressionAnd
 | logical_expr OR logical_expr  # LogicalExpressionOr
 | NOT logical_expr              # LogicalExpressionNot
 | LPAREN logical_expr RPAREN    # LogicalExpressionInParen
 | logical_entity                # LogicalExpressionEntity
 ;

comparison_expr : arithmetic_expr comp_operator arithmetic_expr # ComparisonExpressionWithOperator
                ;

comp_operator : GT
              | GE
              | LT
              | LE
              | EQ
              | NEQ
              ;

arithmetic_expr
 : BNOT arithmetic_expr                  # BitExpressionNot
 | arithmetic_expr MUL arithmetic_expr   # ArithmeticExpressionMul
 | arithmetic_expr DIV arithmetic_expr   # ArithmeticExpressionDiv
 | arithmetic_expr REM arithmetic_expr   # ArithmeticExpressionRem
 | arithmetic_expr ADD arithmetic_expr   # ArithmeticExpressionAdd
 | arithmetic_expr SUB arithmetic_expr   # ArithmeticExpressionSub
 | SUB arithmetic_expr                   # ArithmeticExpressionNegationEntity
 | arithmetic_expr BAND arithmetic_expr  # BitExpressionAnd
 | arithmetic_expr BOR arithmetic_expr   # BitExpressionOr
 | arithmetic_expr BXOR arithmetic_expr  # BitExpressionXor
 | LPAREN arithmetic_expr RPAREN         # ArithmeticExpressionParens
 | numeric_entity                        # ArithmeticExpressionEntity
 ;

numeric_entity : integer_entity
               | float_entity
               | variable_entity
               ;

integer_entity  : INTEGER        # EntityConstInteger ;
float_entity    : FLOAT          # EntityConstFloat   ;
variable_entity : IDENTIFIER     # EntityVariable     ;
logical_entity  : (TRUE | FALSE) # EntityLogicalConst ;
