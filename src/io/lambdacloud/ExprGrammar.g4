grammar ExprGrammar;

@header {
package io.lambdacloud;
}

/* Lexical rules */

AND : 'and' | '&&' ;
OR  : 'or' | '||' ;

TRUE  : 'true' ;
FALSE : 'false' ;

MULT  : '*' ;
DIV   : '/' ;
PLUS  : '+' ;
MINUS : '-' ;

GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
EQ : '==' ;
NEQ : '!=' ;

ASIGN : '=' ;

LPAREN : '(' ;
RPAREN : ')' ;

// DECIMAL, IDENTIFIER, COMMENTS, WS are set using regular expressions

DECIMAL : '-'?[0-9]+('.'[0-9]+)? ;

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

SEMI : ';' ;

// COMMENT and WS are stripped from the output token stream by sending
// to a different channel 'skip'

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS : [ \r\t\u000C]+ -> skip ;

END_EXPR : [;\n]+ ;

/* Parser rules */

prog : expr* EOF ;

expr
 : arithmetic_expr END_EXPR   #ExprArithmetic
 | comparison_expr END_EXPR   #ExprComparison
 | logical_expr    END_EXPR   #ExprLogical
 | asign_expr                 #ExprAssign
 ;

asign_expr : IDENTIFIER ASIGN expr ;

logical_expr
 : logical_expr AND logical_expr # LogicalExpressionAnd
 | logical_expr OR logical_expr  # LogicalExpressionOr
 | comparison_expr               # ComparisonExpression
 | LPAREN logical_expr RPAREN    # LogicalExpressionInParen
 | logical_entity                # LogicalEntity
 ;

comparison_expr : comparison_operand comp_operator comparison_operand
                    # ComparisonExpressionWithOperator
                | LPAREN comparison_expr RPAREN # ComparisonExpressionParens
                ;

comparison_operand : arithmetic_expr
                   ;

comp_operator : GT
              | GE
              | LT
              | LE
              | EQ
              | NEQ
              ;

arithmetic_expr
 : arithmetic_expr MULT arithmetic_expr  # ArithmeticExpressionMult
 | arithmetic_expr DIV arithmetic_expr   # ArithmeticExpressionDiv
 | arithmetic_expr PLUS arithmetic_expr  # ArithmeticExpressionPlus
 | arithmetic_expr MINUS arithmetic_expr # ArithmeticExpressionMinus
 | MINUS arithmetic_expr                 # ArithmeticExpressionNegation
 | LPAREN arithmetic_expr RPAREN         # ArithmeticExpressionParens
 | numeric_entity                        # ArithmeticExpressionNumericEntity
 ;

logical_entity : (TRUE | FALSE) # LogicalConst
               | IDENTIFIER     # LogicalVariable
               ;

numeric_entity : DECIMAL              # NumericConst
               | IDENTIFIER           # NumericVariable
               ;
