// Generated from MatlabGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud.matlab;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MatlabGrammarParser}.
 */
public interface MatlabGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MatlabGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MatlabGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block(MatlabGrammarParser.Statement_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block(MatlabGrammarParser.Statement_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#expr_end}.
	 * @param ctx the parse tree
	 */
	void enterExpr_end(MatlabGrammarParser.Expr_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#expr_end}.
	 * @param ctx the parse tree
	 */
	void exitExpr_end(MatlabGrammarParser.Expr_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#expr_end2}.
	 * @param ctx the parse tree
	 */
	void enterExpr_end2(MatlabGrammarParser.Expr_end2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#expr_end2}.
	 * @param ctx the parse tree
	 */
	void exitExpr_end2(MatlabGrammarParser.Expr_end2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprWithExprEnd1}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprWithExprEnd1(MatlabGrammarParser.ExprWithExprEnd1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprWithExprEnd1}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprWithExprEnd1(MatlabGrammarParser.ExprWithExprEnd1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code TicToc}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTicToc(MatlabGrammarParser.TicTocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TicToc}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTicToc(MatlabGrammarParser.TicTocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDef}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MatlabGrammarParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDef}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MatlabGrammarParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIf}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprIf(MatlabGrammarParser.ExprIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIf}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprIf(MatlabGrammarParser.ExprIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFor}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprFor(MatlabGrammarParser.ExprForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFor}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprFor(MatlabGrammarParser.ExprForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprWhile}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprWhile(MatlabGrammarParser.ExprWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprWhile}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprWhile(MatlabGrammarParser.ExprWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReturn}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprReturn(MatlabGrammarParser.ExprReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReturn}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprReturn(MatlabGrammarParser.ExprReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSwitch}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprSwitch(MatlabGrammarParser.ExprSwitchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSwitch}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprSwitch(MatlabGrammarParser.ExprSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewLines}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterNewLines(MatlabGrammarParser.NewLinesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewLines}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitNewLines(MatlabGrammarParser.NewLinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#tic}.
	 * @param ctx the parse tree
	 */
	void enterTic(MatlabGrammarParser.TicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#tic}.
	 * @param ctx the parse tree
	 */
	void exitTic(MatlabGrammarParser.TicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#toc}.
	 * @param ctx the parse tree
	 */
	void enterToc(MatlabGrammarParser.TocContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#toc}.
	 * @param ctx the parse tree
	 */
	void exitToc(MatlabGrammarParser.TocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprWithExprEnd}
	 * labeled alternative in {@link MatlabGrammarParser#expression_with_expr_end}.
	 * @param ctx the parse tree
	 */
	void enterExprWithExprEnd(MatlabGrammarParser.ExprWithExprEndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprWithExprEnd}
	 * labeled alternative in {@link MatlabGrammarParser#expression_with_expr_end}.
	 * @param ctx the parse tree
	 */
	void exitExprWithExprEnd(MatlabGrammarParser.ExprWithExprEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#if_cond_and_body}.
	 * @param ctx the parse tree
	 */
	void enterIf_cond_and_body(MatlabGrammarParser.If_cond_and_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#if_cond_and_body}.
	 * @param ctx the parse tree
	 */
	void exitIf_cond_and_body(MatlabGrammarParser.If_cond_and_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#else_body}.
	 * @param ctx the parse tree
	 */
	void enterElse_body(MatlabGrammarParser.Else_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#else_body}.
	 * @param ctx the parse tree
	 */
	void exitElse_body(MatlabGrammarParser.Else_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#case_expr_and_body}.
	 * @param ctx the parse tree
	 */
	void enterCase_expr_and_body(MatlabGrammarParser.Case_expr_and_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#case_expr_and_body}.
	 * @param ctx the parse tree
	 */
	void exitCase_expr_and_body(MatlabGrammarParser.Case_expr_and_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#otherwise_body}.
	 * @param ctx the parse tree
	 */
	void enterOtherwise_body(MatlabGrammarParser.Otherwise_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#otherwise_body}.
	 * @param ctx the parse tree
	 */
	void exitOtherwise_body(MatlabGrammarParser.Otherwise_bodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprArithmetic(MatlabGrammarParser.ExprArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprArithmetic(MatlabGrammarParser.ExprArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAssign1}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign1(MatlabGrammarParser.ExprAssign1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign1}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign1(MatlabGrammarParser.ExprAssign1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ForRangeColon}
	 * labeled alternative in {@link MatlabGrammarParser#for_range_expr}.
	 * @param ctx the parse tree
	 */
	void enterForRangeColon(MatlabGrammarParser.ForRangeColonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForRangeColon}
	 * labeled alternative in {@link MatlabGrammarParser#for_range_expr}.
	 * @param ctx the parse tree
	 */
	void exitForRangeColon(MatlabGrammarParser.ForRangeColonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForRangeArrayInit1}
	 * labeled alternative in {@link MatlabGrammarParser#for_range_expr}.
	 * @param ctx the parse tree
	 */
	void enterForRangeArrayInit1(MatlabGrammarParser.ForRangeArrayInit1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ForRangeArrayInit1}
	 * labeled alternative in {@link MatlabGrammarParser#for_range_expr}.
	 * @param ctx the parse tree
	 */
	void exitForRangeArrayInit1(MatlabGrammarParser.ForRangeArrayInit1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(MatlabGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(MatlabGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(MatlabGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(MatlabGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionEntity(MatlabGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionEntity(MatlabGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionPow}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionPow(MatlabGrammarParser.ArithmeticExpressionPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionPow}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionPow(MatlabGrammarParser.ArithmeticExpressionPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionParens}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionParens(MatlabGrammarParser.ArithmeticExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionParens}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionParens(MatlabGrammarParser.ArithmeticExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(MatlabGrammarParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(MatlabGrammarParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionMulDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionMulDiv(MatlabGrammarParser.ArithmeticExpressionMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionMulDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionMulDiv(MatlabGrammarParser.ArithmeticExpressionMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionBit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionBit(MatlabGrammarParser.ArithmeticExpressionBitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionBit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionBit(MatlabGrammarParser.ArithmeticExpressionBitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionAddSub}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionAddSub(MatlabGrammarParser.ArithmeticExpressionAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionAddSub}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionAddSub(MatlabGrammarParser.ArithmeticExpressionAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCellInit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCellInit(MatlabGrammarParser.ExprCellInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCellInit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCellInit(MatlabGrammarParser.ExprCellInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionNot(MatlabGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionNot(MatlabGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRange}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRange(MatlabGrammarParser.ExprRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRange}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRange(MatlabGrammarParser.ExprRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionEntity(MatlabGrammarParser.ArithmeticExpressionEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionEntity(MatlabGrammarParser.ArithmeticExpressionEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionNegationEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionNegationEntity(MatlabGrammarParser.ArithmeticExpressionNegationEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionNegationEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionNegationEntity(MatlabGrammarParser.ArithmeticExpressionNegationEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterStringEntity(MatlabGrammarParser.StringEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringEntity}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitStringEntity(MatlabGrammarParser.StringEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprArrayInit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprArrayInit(MatlabGrammarParser.ExprArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprArrayInit}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprArrayInit(MatlabGrammarParser.ExprArrayInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NArgIn}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterNArgIn(MatlabGrammarParser.NArgInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NArgIn}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitNArgIn(MatlabGrammarParser.NArgInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonArithmeticExpression}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonArithmeticExpression(MatlabGrammarParser.ComparisonArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonArithmeticExpression}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonArithmeticExpression(MatlabGrammarParser.ComparisonArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NArgOut}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterNArgOut(MatlabGrammarParser.NArgOutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NArgOut}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitNArgOut(MatlabGrammarParser.NArgOutContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndIndex}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void enterEndIndex(MatlabGrammarParser.EndIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndIndex}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void exitEndIndex(MatlabGrammarParser.EndIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MiniArithEntity}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void enterMiniArithEntity(MatlabGrammarParser.MiniArithEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MiniArithEntity}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void exitMiniArithEntity(MatlabGrammarParser.MiniArithEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MiniArithParens}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void enterMiniArithParens(MatlabGrammarParser.MiniArithParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MiniArithParens}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void exitMiniArithParens(MatlabGrammarParser.MiniArithParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MiniArithAddSub}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void enterMiniArithAddSub(MatlabGrammarParser.MiniArithAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MiniArithAddSub}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void exitMiniArithAddSub(MatlabGrammarParser.MiniArithAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MiniArithMulDiv}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void enterMiniArithMulDiv(MatlabGrammarParser.MiniArithMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MiniArithMulDiv}
	 * labeled alternative in {@link MatlabGrammarParser#mini_airth_expr}.
	 * @param ctx the parse tree
	 */
	void exitMiniArithMulDiv(MatlabGrammarParser.MiniArithMulDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#add_sub_operator}.
	 * @param ctx the parse tree
	 */
	void enterAdd_sub_operator(MatlabGrammarParser.Add_sub_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#add_sub_operator}.
	 * @param ctx the parse tree
	 */
	void exitAdd_sub_operator(MatlabGrammarParser.Add_sub_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#mul_div_operator}.
	 * @param ctx the parse tree
	 */
	void enterMul_div_operator(MatlabGrammarParser.Mul_div_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#mul_div_operator}.
	 * @param ctx the parse tree
	 */
	void exitMul_div_operator(MatlabGrammarParser.Mul_div_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#bit_operator}.
	 * @param ctx the parse tree
	 */
	void enterBit_operator(MatlabGrammarParser.Bit_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#bit_operator}.
	 * @param ctx the parse tree
	 */
	void exitBit_operator(MatlabGrammarParser.Bit_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_entity(MatlabGrammarParser.Numeric_entityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#numeric_entity}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_entity(MatlabGrammarParser.Numeric_entityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityConstInteger}
	 * labeled alternative in {@link MatlabGrammarParser#integer_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityConstInteger(MatlabGrammarParser.EntityConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityConstInteger}
	 * labeled alternative in {@link MatlabGrammarParser#integer_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityConstInteger(MatlabGrammarParser.EntityConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityConstFloat}
	 * labeled alternative in {@link MatlabGrammarParser#float_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityConstFloat(MatlabGrammarParser.EntityConstFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityConstFloat}
	 * labeled alternative in {@link MatlabGrammarParser#float_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityConstFloat(MatlabGrammarParser.EntityConstFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityVariable}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityVariable(MatlabGrammarParser.EntityVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityVariable}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityVariable(MatlabGrammarParser.EntityVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SpecialFuncCall}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterSpecialFuncCall(MatlabGrammarParser.SpecialFuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SpecialFuncCall}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitSpecialFuncCall(MatlabGrammarParser.SpecialFuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CellAccess}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterCellAccess(MatlabGrammarParser.CellAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CellAccess}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitCellAccess(MatlabGrammarParser.CellAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayAccessOrFuncCall}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessOrFuncCall(MatlabGrammarParser.ArrayAccessOrFuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayAccessOrFuncCall}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessOrFuncCall(MatlabGrammarParser.ArrayAccessOrFuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#special_name}.
	 * @param ctx the parse tree
	 */
	void enterSpecial_name(MatlabGrammarParser.Special_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#special_name}.
	 * @param ctx the parse tree
	 */
	void exitSpecial_name(MatlabGrammarParser.Special_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#array_init}.
	 * @param ctx the parse tree
	 */
	void enterArray_init(MatlabGrammarParser.Array_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#array_init}.
	 * @param ctx the parse tree
	 */
	void exitArray_init(MatlabGrammarParser.Array_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#cell_init}.
	 * @param ctx the parse tree
	 */
	void enterCell_init(MatlabGrammarParser.Cell_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#cell_init}.
	 * @param ctx the parse tree
	 */
	void exitCell_init(MatlabGrammarParser.Cell_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#ai_list}.
	 * @param ctx the parse tree
	 */
	void enterAi_list(MatlabGrammarParser.Ai_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#ai_list}.
	 * @param ctx the parse tree
	 */
	void exitAi_list(MatlabGrammarParser.Ai_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#aa_index}.
	 * @param ctx the parse tree
	 */
	void enterAa_index(MatlabGrammarParser.Aa_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#aa_index}.
	 * @param ctx the parse tree
	 */
	void exitAa_index(MatlabGrammarParser.Aa_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#aa_range}.
	 * @param ctx the parse tree
	 */
	void enterAa_range(MatlabGrammarParser.Aa_rangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#aa_range}.
	 * @param ctx the parse tree
	 */
	void exitAa_range(MatlabGrammarParser.Aa_rangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#aa_range_start}.
	 * @param ctx the parse tree
	 */
	void enterAa_range_start(MatlabGrammarParser.Aa_range_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#aa_range_start}.
	 * @param ctx the parse tree
	 */
	void exitAa_range_start(MatlabGrammarParser.Aa_range_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#aa_range_step}.
	 * @param ctx the parse tree
	 */
	void enterAa_range_step(MatlabGrammarParser.Aa_range_stepContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#aa_range_step}.
	 * @param ctx the parse tree
	 */
	void exitAa_range_step(MatlabGrammarParser.Aa_range_stepContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#aa_range_end}.
	 * @param ctx the parse tree
	 */
	void enterAa_range_end(MatlabGrammarParser.Aa_range_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#aa_range_end}.
	 * @param ctx the parse tree
	 */
	void exitAa_range_end(MatlabGrammarParser.Aa_range_endContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDefNameArgs}
	 * labeled alternative in {@link MatlabGrammarParser#func_name_args}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefNameArgs(MatlabGrammarParser.FuncDefNameArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDefNameArgs}
	 * labeled alternative in {@link MatlabGrammarParser#func_name_args}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefNameArgs(MatlabGrammarParser.FuncDefNameArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#func_def_return}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def_return(MatlabGrammarParser.Func_def_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#func_def_return}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def_return(MatlabGrammarParser.Func_def_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void enterComp_operator(MatlabGrammarParser.Comp_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void exitComp_operator(MatlabGrammarParser.Comp_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EntityLogicalConst}
	 * labeled alternative in {@link MatlabGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityLogicalConst(MatlabGrammarParser.EntityLogicalConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityLogicalConst}
	 * labeled alternative in {@link MatlabGrammarParser#logical_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityLogicalConst(MatlabGrammarParser.EntityLogicalConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(MatlabGrammarParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(MatlabGrammarParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiAssign(MatlabGrammarParser.ExprMultiAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiAssign(MatlabGrammarParser.ExprMultiAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMulAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMulAssign(MatlabGrammarParser.ExprMulAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMulAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMulAssign(MatlabGrammarParser.ExprMulAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDivAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDivAssign(MatlabGrammarParser.ExprDivAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDivAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDivAssign(MatlabGrammarParser.ExprDivAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRemAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRemAssign(MatlabGrammarParser.ExprRemAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRemAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRemAssign(MatlabGrammarParser.ExprRemAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddAssign(MatlabGrammarParser.ExprAddAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddAssign(MatlabGrammarParser.ExprAddAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSubAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSubAssign(MatlabGrammarParser.ExprSubAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSubAssign}
	 * labeled alternative in {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSubAssign(MatlabGrammarParser.ExprSubAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringConst}
	 * labeled alternative in {@link MatlabGrammarParser#string_entity}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(MatlabGrammarParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringConst}
	 * labeled alternative in {@link MatlabGrammarParser#string_entity}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(MatlabGrammarParser.StringConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringVariable1}
	 * labeled alternative in {@link MatlabGrammarParser#string_entity}.
	 * @param ctx the parse tree
	 */
	void enterStringVariable1(MatlabGrammarParser.StringVariable1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code StringVariable1}
	 * labeled alternative in {@link MatlabGrammarParser#string_entity}.
	 * @param ctx the parse tree
	 */
	void exitStringVariable1(MatlabGrammarParser.StringVariable1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncHandle}
	 * labeled alternative in {@link MatlabGrammarParser#func_handle}.
	 * @param ctx the parse tree
	 */
	void enterFuncHandle(MatlabGrammarParser.FuncHandleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncHandle}
	 * labeled alternative in {@link MatlabGrammarParser#func_handle}.
	 * @param ctx the parse tree
	 */
	void exitFuncHandle(MatlabGrammarParser.FuncHandleContext ctx);
}