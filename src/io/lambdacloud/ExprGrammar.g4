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

DECIMAL : '-'?[0-9]+('.'[0-9]+)? ;

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
 : arithmetic_expr                 #ExprArithmetic
 | comparison_expr                 #ExprComparison
 | logical_expr                    #ExprLogical
 | asign_expr                      #ExprAssign
// | IDENTIFIER ('++' | '--')        #ExprUnaryPostfix
// | ('+'|'-'|'++'|'--') IDENTIFIER  #ExprUnaryPrefix
// | ('~'|'!') IDENTIFIER            #ExprUnaryNot
 ;

asign_expr : IDENTIFIER ASIGN expr ;

logical_expr
 : logical_expr AND logical_expr # LogicalExpressionAnd
 | logical_expr OR logical_expr  # LogicalExpressionOr
 | NOT logical_expr              # LogicalExpressionNot
 | comparison_expr               # ComparisonExpression
 | LPAREN logical_expr RPAREN    # LogicalExpressionInParen
 | logical_entity                # LogicalExpressionEntity
 ;

comparison_expr : comparison_operand comp_operator comparison_operand # ComparisonExpressionWithOperator
                | LPAREN comparison_expr RPAREN                       # ComparisonExpressionParens
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
 : arithmetic_expr MUL arithmetic_expr   # ArithmeticExpressionMul
 | arithmetic_expr DIV arithmetic_expr   # ArithmeticExpressionDiv
 | arithmetic_expr REM arithmetic_expr   # ArithmeticExpressionRem
 | arithmetic_expr ADD arithmetic_expr   # ArithmeticExpressionAdd
 | arithmetic_expr SUB arithmetic_expr   # ArithmeticExpressionSub
 | SUB arithmetic_expr                   # ArithmeticExpressionNegation
 | LPAREN arithmetic_expr RPAREN         # ArithmeticExpressionParens
 | numeric_entity                        # ArithmeticExpressionNumericEntity
 ;

logical_entity : (TRUE | FALSE) # LogicalConst
               | IDENTIFIER     # LogicalVariable
               ;

numeric_entity : DECIMAL              # NumericConst
               | IDENTIFIER           # NumericVariable
               ;
