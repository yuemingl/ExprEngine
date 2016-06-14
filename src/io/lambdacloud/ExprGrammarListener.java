// Generated from ExprGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprGrammarParser}.
 */
public interface ExprGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLogical(ExprGrammarParser.ExprLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLogical(ExprGrammarParser.ExprLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(ExprGrammarParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(ExprGrammarParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#asign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAsign_expr(ExprGrammarParser.Asign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#asign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAsign_expr(ExprGrammarParser.Asign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionNot(ExprGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionNot(ExprGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionEntity(ExprGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionEntity(ExprGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionInParen(ExprGrammarParser.LogicalExpressionInParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionInParen(ExprGrammarParser.LogicalExpressionInParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(ExprGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(ExprGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpressionWithOperator}
	 * labeled alternative in {@link ExprGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionWithOperator(ExprGrammarParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpressionWithOperator}
	 * labeled alternative in {@link ExprGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionWithOperator(ExprGrammarParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void enterComp_operator(ExprGrammarParser.Comp_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void exitComp_operator(ExprGrammarParser.Comp_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionEntity(ExprGrammarParser.ArithmeticExpressionEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionEntity(ExprGrammarParser.ArithmeticExpressionEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionRem}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionRem(ExprGrammarParser.ArithmeticExpressionRemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionRem}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionRem(ExprGrammarParser.ArithmeticExpressionRemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionNegationEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionNegationEntity(ExprGrammarParser.ArithmeticExpressionNegationEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionNegationEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionNegationEntity(ExprGrammarParser.ArithmeticExpressionNegationEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionSub}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionSub(ExprGrammarParser.ArithmeticExpressionSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionSub}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionSub(ExprGrammarParser.ArithmeticExpressionSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionParens}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionParens(ExprGrammarParser.ArithmeticExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionParens}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionParens(ExprGrammarParser.ArithmeticExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionDiv}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionDiv}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionNegationExpr}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionNegationExpr(ExprGrammarParser.ArithmeticExpressionNegationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionNegationExpr}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionNegationExpr(ExprGrammarParser.ArithmeticExpressionNegationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionMul}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionMul}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpression}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpression(ExprGrammarParser.BitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpression}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpression(ExprGrammarParser.BitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionAdd}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionAdd}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionAnd}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionAnd(ExprGrammarParser.BitExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionAnd}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionAnd(ExprGrammarParser.BitExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionXor}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionXor(ExprGrammarParser.BitExpressionXorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionXor}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionXor(ExprGrammarParser.BitExpressionXorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionConst}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionConst(ExprGrammarParser.BitExpressionConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionConst}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionConst(ExprGrammarParser.BitExpressionConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionOr}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionOr(ExprGrammarParser.BitExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionOr}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionOr(ExprGrammarParser.BitExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionNot}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionNot(ExprGrammarParser.BitExpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionNot}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionNot(ExprGrammarParser.BitExpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitExpressionVariable}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpressionVariable(ExprGrammarParser.BitExpressionVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitExpressionVariable}
	 * labeled alternative in {@link ExprGrammarParser#bit_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpressionVariable(ExprGrammarParser.BitExpressionVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_entity(ExprGrammarParser.Numeric_entityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_entity(ExprGrammarParser.Numeric_entityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityConstInteger}
	 * labeled alternative in {@link ExprGrammarParser#integer_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityConstInteger(ExprGrammarParser.EntityConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityConstInteger}
	 * labeled alternative in {@link ExprGrammarParser#integer_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityConstInteger(ExprGrammarParser.EntityConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityConstFloat}
	 * labeled alternative in {@link ExprGrammarParser#float_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityConstFloat(ExprGrammarParser.EntityConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityConstFloat}
	 * labeled alternative in {@link ExprGrammarParser#float_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityConstFloat(ExprGrammarParser.EntityConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityVariable}
	 * labeled alternative in {@link ExprGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityVariable(ExprGrammarParser.EntityVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityVariable}
	 * labeled alternative in {@link ExprGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityVariable(ExprGrammarParser.EntityVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityLogicalConst}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityLogicalConst(ExprGrammarParser.EntityLogicalConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityLogicalConst}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityLogicalConst(ExprGrammarParser.EntityLogicalConstContext ctx);
}