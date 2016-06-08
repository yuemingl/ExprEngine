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
	 * Enter a parse tree produced by {@link ExprGrammarParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(ExprGrammarParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(ExprGrammarParser.AsignContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprComparison(ExprGrammarParser.ExprComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprComparison(ExprGrammarParser.ExprComparisonContext ctx);
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
	 * Enter a parse tree produced by the {@code LogicalEntity}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalEntity(ExprGrammarParser.LogicalEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalEntity}
	 * labeled alternative in {@link ExprGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalEntity(ExprGrammarParser.LogicalEntityContext ctx);
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
	 * Enter a parse tree produced by the {@code ComparisonExpressionParens}
	 * labeled alternative in {@link ExprGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionParens(ExprGrammarParser.ComparisonExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpressionParens}
	 * labeled alternative in {@link ExprGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionParens(ExprGrammarParser.ComparisonExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operand(ExprGrammarParser.Comparison_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operand(ExprGrammarParser.Comparison_operandContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionMult}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionMult}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionNumericEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionNumericEntity(ExprGrammarParser.ArithmeticExpressionNumericEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionNumericEntity}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionNumericEntity(ExprGrammarParser.ArithmeticExpressionNumericEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionMinus}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionMinus(ExprGrammarParser.ArithmeticExpressionMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionMinus}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionMinus(ExprGrammarParser.ArithmeticExpressionMinusContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionNegation}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionNegation(ExprGrammarParser.ArithmeticExpressionNegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionNegation}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionNegation(ExprGrammarParser.ArithmeticExpressionNegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionPlus}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionPlus}
	 * labeled alternative in {@link ExprGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx);
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
	 * Enter a parse tree produced by the {@code LogicalConst}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConst(ExprGrammarParser.LogicalConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalConst}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConst(ExprGrammarParser.LogicalConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void enterLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalVariable}
	 * labeled alternative in {@link ExprGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void exitLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericConst}
	 * labeled alternative in {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void enterNumericConst(ExprGrammarParser.NumericConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericConst}
	 * labeled alternative in {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void exitNumericConst(ExprGrammarParser.NumericConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericVariable}
	 * labeled alternative in {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void enterNumericVariable(ExprGrammarParser.NumericVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericVariable}
	 * labeled alternative in {@link ExprGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void exitNumericVariable(ExprGrammarParser.NumericVariableContext ctx);
}