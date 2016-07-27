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
	 * Enter a parse tree produced by {@link MatlabGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MatlabGrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MatlabGrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTranspose(MatlabGrammarParser.TransposeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Transpose}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTranspose(MatlabGrammarParser.TransposeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprArrayInit}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprArrayInit(MatlabGrammarParser.ExprArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprArrayInit}
	 * labeled alternative in {@link MatlabGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprArrayInit(MatlabGrammarParser.ExprArrayInitContext ctx);
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
	 * Enter a parse tree produced by the {@code EntityArrayAccess}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void enterEntityArrayAccess(MatlabGrammarParser.EntityArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EntityArrayAccess}
	 * labeled alternative in {@link MatlabGrammarParser#variable_entity}.
	 * @param ctx the parse tree
	 */
	void exitEntityArrayAccess(MatlabGrammarParser.EntityArrayAccessContext ctx);
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
	 * Enter a parse tree produced by {@link MatlabGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(MatlabGrammarParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(MatlabGrammarParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MatlabGrammarParser#func_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_args(MatlabGrammarParser.Func_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MatlabGrammarParser#func_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_args(MatlabGrammarParser.Func_argsContext ctx);
}