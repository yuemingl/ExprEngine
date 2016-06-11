package io.lambdacloud;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.*;


public class ExprWalker extends ExprGrammarBaseListener {
	CodeGenerator gg = new CodeGenerator();
	
	public CodeGenerator getCodeGenerator() {
		return gg;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProg(ExprGrammarParser.ProgContext ctx) {
		System.out.println("enter prog:");
		gg.startClass("test");
		gg.startMethod("eval", "()D");
		gg.startCode();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProg(ExprGrammarParser.ProgContext ctx) { 
		//gg.mv.visitInsn(Opcodes.DRETURN);
		gg.mv.visitMaxs(10, 10);
		gg.endCode();
		gg.endClass();
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAsign_expr(ExprGrammarParser.Asign_exprContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAsign_expr(ExprGrammarParser.Asign_exprContext ctx) { 
		System.out.println(ctx.getChild(0).getText());
		System.out.println(ctx.getText());
		
	}

	
	/**
	 * Enter a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void enterExprLogical(ExprGrammarParser.ExprLogicalContext ctx) {}
	/**
	 * Exit a parse tree produced by the {@code ExprLogical}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void exitExprLogical(ExprGrammarParser.ExprLogicalContext ctx) {
		gg.getMV().visitInsn(Opcodes.IRETURN);
		
	}
	/**
	 * Enter a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void enterExprComparison(ExprGrammarParser.ExprComparisonContext ctx) {}
	/**
	 * Exit a parse tree produced by the {@code ExprComparison}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void exitExprComparison(ExprGrammarParser.ExprComparisonContext ctx) {
		gg.getMV().visitInsn(Opcodes.IRETURN);
	}
	/**
	 * Enter a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void enterExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) {}
	/**
	 * Exit a parse tree produced by the {@code ExprArithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	@Override public void exitExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) {
		System.out.println("Arithmetric: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DRETURN);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalEntity(ExprGrammarParser.LogicalEntityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalEntity(ExprGrammarParser.LogicalEntityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalExpressionInParen(ExprGrammarParser.LogicalExpressionInParenContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalExpressionInParen(ExprGrammarParser.LogicalExpressionInParenContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComparisonExpression(ExprGrammarParser.ComparisonExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComparisonExpression(ExprGrammarParser.ComparisonExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComparisonExpressionWithOperator(ExprGrammarParser.ComparisonExpressionWithOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComparisonExpressionWithOperator(ExprGrammarParser.ComparisonExpressionWithOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComparisonExpressionParens(ExprGrammarParser.ComparisonExpressionParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComparisonExpressionParens(ExprGrammarParser.ComparisonExpressionParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComparison_operand(ExprGrammarParser.Comparison_operandContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComparison_operand(ExprGrammarParser.Comparison_operandContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComp_operator(ExprGrammarParser.Comp_operatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComp_operator(ExprGrammarParser.Comp_operatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx) { 
		System.out.println(">*: "+ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx) {
		System.out.println("<*: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DMUL);

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionNumericEntity(ExprGrammarParser.ArithmeticExpressionNumericEntityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionNumericEntity(ExprGrammarParser.ArithmeticExpressionNumericEntityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionMinus(ExprGrammarParser.ArithmeticExpressionMinusContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionMinus(ExprGrammarParser.ArithmeticExpressionMinusContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionParens(ExprGrammarParser.ArithmeticExpressionParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionParens(ExprGrammarParser.ArithmeticExpressionParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionNegation(ExprGrammarParser.ArithmeticExpressionNegationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionNegation(ExprGrammarParser.ArithmeticExpressionNegationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx) { 
		System.out.println(">+: "+ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx) {
		System.out.println("<+: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DADD);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalConst(ExprGrammarParser.LogicalConstContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalConst(ExprGrammarParser.LogicalConstContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx) {
		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNumericConst(ExprGrammarParser.NumericConstContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNumericConst(ExprGrammarParser.NumericConstContext ctx) {
		System.out.println(ctx.getText());
		gg.getMV().visitLdcInsn(Double.parseDouble(ctx.getText()));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNumericVariable(ExprGrammarParser.NumericVariableContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNumericVariable(ExprGrammarParser.NumericVariableContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}
