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
	 * Enter a parse tree produced by the {@code ExprStatements}
	 * labeled alternative in {@link MatlabGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterExprStatements(MatlabGrammarParser.ExprStatementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStatements}
	 * labeled alternative in {@link MatlabGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitExprStatements(MatlabGrammarParser.ExprStatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MatlabGrammarParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStatement}
	 * labeled alternative in {@link MatlabGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MatlabGrammarParser.ExprStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprIf}
	 * labeled alternative in {@link MatlabGrammarParser#expression_with_expr_end}.
	 * @param ctx the parse tree
	 */
	void enterExprIf(MatlabGrammarParser.ExprIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIf}
	 * labeled alternative in {@link MatlabGrammarParser#expression_with_expr_end}.
	 * @param ctx the parse tree
	 */
	void exitExprIf(MatlabGrammarParser.ExprIfContext ctx);
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
	 * Enter a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAssign(MatlabGrammarParser.ExprAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAssign}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAssign(MatlabGrammarParser.ExprAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLogical(MatlabGrammarParser.ExprLogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLogical(MatlabGrammarParser.ExprLogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionDLDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionDLDiv(MatlabGrammarParser.ArithmeticExpressionDLDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionDLDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionDLDiv(MatlabGrammarParser.ArithmeticExpressionDLDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionSOL}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionSOL(MatlabGrammarParser.ArithmeticExpressionSOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionSOL}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionSOL(MatlabGrammarParser.ArithmeticExpressionSOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionSolve}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionSolve(MatlabGrammarParser.ArithmeticExpressionSolveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionSolve}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionSolve(MatlabGrammarParser.ArithmeticExpressionSolveContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionRem}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionRem(MatlabGrammarParser.ArithmeticExpressionRemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionRem}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionRem(MatlabGrammarParser.ArithmeticExpressionRemContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionDiv(MatlabGrammarParser.ArithmeticExpressionDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionDiv(MatlabGrammarParser.ArithmeticExpressionDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionMul}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionMul(MatlabGrammarParser.ArithmeticExpressionMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionMul}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionMul(MatlabGrammarParser.ArithmeticExpressionMulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionDMul}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionDMul(MatlabGrammarParser.ArithmeticExpressionDMulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionDMul}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionDMul(MatlabGrammarParser.ArithmeticExpressionDMulContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionRange}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionRange(MatlabGrammarParser.ArithmeticExpressionRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionRange}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionRange(MatlabGrammarParser.ArithmeticExpressionRangeContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionSub}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionSub(MatlabGrammarParser.ArithmeticExpressionSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionSub}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionSub(MatlabGrammarParser.ArithmeticExpressionSubContext ctx);
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
	 * Enter a parse tree produced by the {@code ArithmeticExpressionDRDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionDRDiv(MatlabGrammarParser.ArithmeticExpressionDRDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionDRDiv}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionDRDiv(MatlabGrammarParser.ArithmeticExpressionDRDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticExpressionAdd}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpressionAdd(MatlabGrammarParser.ArithmeticExpressionAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticExpressionAdd}
	 * labeled alternative in {@link MatlabGrammarParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpressionAdd(MatlabGrammarParser.ArithmeticExpressionAddContext ctx);
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
	 * Enter a parse tree produced by {@link MatlabGrammarParser#array_access}.
	 * @param ctx the parse tree
	 */
	void enterArray_access(MatlabGrammarParser.Array_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#array_access}.
	 * @param ctx the parse tree
	 */
	void exitArray_access(MatlabGrammarParser.Array_accessContext ctx);
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
	 * Enter a parse tree produced by {@link MatlabGrammarParser#func_def_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def_args(MatlabGrammarParser.Func_def_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#func_def_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def_args(MatlabGrammarParser.Func_def_argsContext ctx);
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
	 * Enter a parse tree produced by {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(MatlabGrammarParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(MatlabGrammarParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionNot(MatlabGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionNot(MatlabGrammarParser.LogicalExpressionNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(MatlabGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(MatlabGrammarParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(MatlabGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(MatlabGrammarParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionEntity(MatlabGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionEntity}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionEntity(MatlabGrammarParser.LogicalExpressionEntityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionInParen(MatlabGrammarParser.LogicalExpressionInParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionInParen(MatlabGrammarParser.LogicalExpressionInParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(MatlabGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link MatlabGrammarParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(MatlabGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonArithmeticExpression}
	 * labeled alternative in {@link MatlabGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonArithmeticExpression(MatlabGrammarParser.ComparisonArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonArithmeticExpression}
	 * labeled alternative in {@link MatlabGrammarParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonArithmeticExpression(MatlabGrammarParser.ComparisonArithmeticExpressionContext ctx);
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
}