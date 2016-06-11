package io.lambdacloud;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.statement.AddNode;
import io.lambdacloud.statement.AndNode;
import io.lambdacloud.statement.AssignNode;
import io.lambdacloud.statement.ConstantNode;
import io.lambdacloud.statement.DivNode;
import io.lambdacloud.statement.EQNode;
import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.GENode;
import io.lambdacloud.statement.GTNode;
import io.lambdacloud.statement.LENode;
import io.lambdacloud.statement.LTNode;
import io.lambdacloud.statement.MultNode;
import io.lambdacloud.statement.NEQNode;
import io.lambdacloud.statement.NegateNode;
import io.lambdacloud.statement.OrNode;
import io.lambdacloud.statement.SubNode;
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
	
	public Class<?> genCode(String className, String methodName) {
		return genCode(className, methodName, true);
	}
	
	public Class<?> genCode(String className, String methodName, boolean wirteFile) {
		try {
			// Class<?> c = mcl.defineClassForName("com.openx.asm_test.Test1",
			// Test1Dump.dump());
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			
			CodeGenerator gg = new CodeGenerator();
			//Define class
			gg.startClass(className);
			//Define method
			Type retType = stack.peek().getType();
			if(null == retType) throw new RuntimeException("Stack is empty!");
			gg.startMethod(methodName,Type.getMethodDescriptor(
					retType, //return type of the last expression
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
			
			//Generate code for all the expressions
			while(!stack.isEmpty()) {
				ExprNode expr = stack.pollLast();
				expr.genCode(mv);
			}
			
			mv.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			mv.visitLocalVariable("this", "L"+className+";", null, gg.l0, gg.l1, 0);
			for(VariableNode var : paramMap.values()) {
				mv.visitLocalVariable(var.name, Type.getDescriptor(double.class), //TODO Assume all parameters are double?
						null, gg.l0, gg.l1, var.idxLVT);
			}
			for(VariableNode var : localVarMap.values()) {
				mv.visitLocalVariable(var.name, Type.getDescriptor(double.class), 
						null, gg.l0, gg.l1, var.idxLVT);
			}
			
			mv.visitMaxs(-1, -1); //Auto generated
			gg.endCode();
			gg.endClass();
			
			byte[] bcode = gg.dump();
			if(wirteFile) {
				FileOutputStream fos = new FileOutputStream(className+".class");
				fos.write(bcode);
				fos.close();
			}

			Class<?> c = mcl.defineClassForName(null, bcode);
//			for (Method m : c.getMethods()) {
//				System.out.println(m.getName());
//			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override public void exitAsign_expr(ExprGrammarParser.Asign_exprContext ctx) { 
		//System.out.println("asign: "+ctx.IDENTIFIER().getText()+"="+ctx.expr().getText());
		VariableNode var = new VariableNode(ctx.IDENTIFIER().getText(), this.stack.pop());
		this.localVarMap.put(ctx.IDENTIFIER().getText(), var);
		this.stack.push(new AssignNode(var, var.value));
	}

	@Override public void exitLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new AndNode(v1, v2));
	}

	@Override public void exitLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new OrNode(v1, v2));
	}

	@Override public void exitComparisonExpressionWithOperator(ExprGrammarParser.ComparisonExpressionWithOperatorContext ctx) {
		//System.out.println(ctx.getText()+"   "+ctx.comp_operator().getText());
		String op = ctx.comp_operator().getText();
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		if(op.equals(">")) {
			stack.push(new GTNode(v1, v2));
		} else if(op.equals(">=")) {
			stack.push(new GENode(v1, v2));
		} else if(op.equals("<")) {
			stack.push(new LTNode(v1, v2));
		} else if(op.equals("<=")) {
			stack.push(new LENode(v1, v2));
		} else if(op.equals("==")) {
			stack.push(new EQNode(v1, v2));
		} else if(op.equals("!=")) {
			stack.push(new NEQNode(v1, v2));
		}
	}
	
	@Override public void exitArithmeticExpressionMult(ExprGrammarParser.ArithmeticExpressionMultContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new MultNode(v1, v2));
	}

	@Override public void exitArithmeticExpressionPlus(ExprGrammarParser.ArithmeticExpressionPlusContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new AddNode(v1, v2));
	}

	@Override public void exitLogicalConst(ExprGrammarParser.LogicalConstContext ctx) {
		stack.push(new ConstantNode(ctx.getText(),Type.BOOLEAN_TYPE));
	}

	@Override public void exitNumericConst(ExprGrammarParser.NumericConstContext ctx) {
		stack.push(new ConstantNode(ctx.getText(), Type.DOUBLE_TYPE));
	}

	@Override public void exitNumericVariable(ExprGrammarParser.NumericVariableContext ctx) { 
		String varName = ctx.getText();
		VariableNode val = localVarMap.get(varName);
		if(null == val) {
			val = paramMap.get(varName);
			if(null == val) {
				val = new VariableNode(varName, Type.DOUBLE_TYPE);
			}
			paramMap.put(varName, val);
		}
		//TODO define a local variable?
		stack.push(val);
	}
	
	@Override public void exitArithmeticExpressionNegation(ExprGrammarParser.ArithmeticExpressionNegationContext ctx) {
		stack.push(new NegateNode(stack.pop()));
	}
	@Override public void exitArithmeticExpressionMinus(ExprGrammarParser.ArithmeticExpressionMinusContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SubNode(v1, v2));
	}
	@Override public void enterArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new DivNode(v1, v2));
	}
	
//	@Override public void exitArithmeticExpressionNumericEntity(ExprGrammarParser.ArithmeticExpressionNumericEntityContext ctx) {
//		System.out.println("ArithmeticExpressionNumericEntity:"+ctx.getText());
//	}
//	@Override public void exitLogicalEntity(ExprGrammarParser.LogicalEntityContext ctx) {
//		System.out.println("LogicalEntity:"+ctx.getText());
//	}
}
