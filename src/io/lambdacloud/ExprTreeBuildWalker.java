package io.lambdacloud;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.statement.AddNode;
import io.lambdacloud.statement.AssignNode;
import io.lambdacloud.statement.ConstantNode;
import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.MultNode;
import io.lambdacloud.statement.VariableNode;

public class ExprTreeBuildWalker extends ExprGrammarBaseListener {
	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
	public SortedMap<String, VariableNode> paramMap = new TreeMap<String, VariableNode>();
	public SortedMap<String, VariableNode> localVarMap = new TreeMap<String, VariableNode>();
	
	Type[] getArgumentTypes() {
		List<VariableNode> list = new ArrayList<VariableNode>();
		list.addAll(paramMap.values());
		Collections.sort(list, new Comparator<VariableNode>() {
			@Override
			public int compare(VariableNode o1, VariableNode o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		Type[] retTypes = new Type[list.size()];
		for(int i=0; i<list.size(); i++) {
			retTypes[i] = Type.getType(double.class);//TODO different types
		}
		return retTypes;
	}
	
	public void genCode() {
		try {
			// Class<?> c = mcl.defineClassForName("com.openx.asm_test.Test1",
			// Test1Dump.dump());
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			
			CodeGenerator gg = new CodeGenerator();
			gg.startClass("myclass");
			
			gg.startMethod("eval",Type.getMethodDescriptor(
					Type.DOUBLE_TYPE, //return type TODO
					getArgumentTypes()
				));
			gg.startCode();
			
			MethodVisitor mv = gg.getMV();
			
			int index = 1;
			for(String key : paramMap.keySet()) {
				paramMap.get(key).idxLVT = index;
				index += 2;
			}
			for(String key : localVarMap.keySet()) {
				localVarMap.get(key).idxLVT = index;
				index += 2;
			}
			
			while(!stack.isEmpty()) {
				ExprNode expr = stack.pollLast();
				expr.genCode(mv);
			}
			
			
			mv.visitInsn(Opcodes.DRETURN);
			mv.visitLocalVariable("this", "Lcom/openx/asm_test/Test1;", null, gg.l0, gg.l1, 0);
			for(VariableNode var : paramMap.values()) {
				mv.visitLocalVariable(var.name, Type.getDescriptor(double.class), null, gg.l0, gg.l1, var.idxLVT);
			}
			for(VariableNode var : localVarMap.values()) {
				mv.visitLocalVariable(var.name, Type.getDescriptor(double.class), null, gg.l0, gg.l1, var.idxLVT);
			}
			
			mv.visitMaxs(-1, -1);
			gg.endCode();
			gg.endClass();
			
			byte[] bcode = gg.dump();
			FileOutputStream fos = new FileOutputStream("test.class");
			fos.write(bcode);
			fos.close();

			Class<?> c = mcl.defineClassForName(null, bcode);
//			for (Method m : c.getMethods()) {
//				System.out.println(m.getName());
//			}
			Method m1 = c.getMethod("eval",double.class, double.class);//TODO types
			Object o = c.newInstance();
			System.out.println(m1.invoke(o,3,4));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProg(ExprGrammarParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProg(ExprGrammarParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAsign(ExprGrammarParser.AsignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAsign(ExprGrammarParser.AsignContext ctx) { 
		System.out.println("asign: "+ctx.IDENTIFIER().getText()+"="+ctx.expr().getText());
		VariableNode var = new VariableNode(ctx.IDENTIFIER().getText());
		var.value = this.stack.pop();
		this.localVarMap.put(ctx.IDENTIFIER().getText(), var);
		this.stack.push(new AssignNode(var, var.value));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExprLogical(ExprGrammarParser.ExprLogicalContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExprLogical(ExprGrammarParser.ExprLogicalContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExprComparison(ExprGrammarParser.ExprComparisonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExprComparison(ExprGrammarParser.ExprComparisonContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) { }
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
	@Override public void enterArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx) { 
		stack.push(new MultNode(stack.pop(), stack.pop()));

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
	@Override public void enterArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx) { 
		stack.push(new AddNode(stack.pop(), stack.pop()));
		
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
	@Override public void exitLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx) { }
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
		stack.push(new ConstantNode(ctx.getText()));
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
	@Override public void exitNumericVariable(ExprGrammarParser.NumericVariableContext ctx) { 
		String varName = ctx.getText();
		VariableNode val = localVarMap.get(varName);
		if(null == val) {
			val = paramMap.get(varName);
			if(null == val) {
				val = new VariableNode(varName);
			}
			paramMap.put(varName, val);
		}
		//TODO define a local variable?
		stack.push(val);
	}

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
