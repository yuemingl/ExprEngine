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

import io.lambdacloud.statement.AddAsignNode;
import io.lambdacloud.statement.AddNode;
import io.lambdacloud.statement.AndNode;
import io.lambdacloud.statement.AssignNode;
import io.lambdacloud.statement.BAndNode;
import io.lambdacloud.statement.BNotNode;
import io.lambdacloud.statement.BOrNode;
import io.lambdacloud.statement.BXorNode;
import io.lambdacloud.statement.ConstantNode;
import io.lambdacloud.statement.DescNode;
import io.lambdacloud.statement.DivAsignNode;
import io.lambdacloud.statement.DivNode;
import io.lambdacloud.statement.EQNode;
import io.lambdacloud.statement.ExprNode;
import io.lambdacloud.statement.GENode;
import io.lambdacloud.statement.GTNode;
import io.lambdacloud.statement.IncNode;
import io.lambdacloud.statement.LENode;
import io.lambdacloud.statement.LTNode;
import io.lambdacloud.statement.MulAsignNode;
import io.lambdacloud.statement.MultNode;
import io.lambdacloud.statement.NEQNode;
import io.lambdacloud.statement.NegateNode;
import io.lambdacloud.statement.NotNode;
import io.lambdacloud.statement.OrNode;
import io.lambdacloud.statement.RemAsignNode;
import io.lambdacloud.statement.RemNode;
import io.lambdacloud.statement.SHLNode;
import io.lambdacloud.statement.SHRNode;
import io.lambdacloud.statement.SubAsignNode;
import io.lambdacloud.statement.SubNode;
import io.lambdacloud.statement.USHRNode;
import io.lambdacloud.statement.VariableNode;

public class ExprTreeBuildWalker extends ExprGrammarBaseListener {
	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
	public SortedMap<String, VariableNode> paramMap = new TreeMap<String, VariableNode>();
	public SortedMap<String, VariableNode> localVarMap = new TreeMap<String, VariableNode>();
	
	Type[] getAndFixArgumentTypes(Class<?> ...parameterTypes) {
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
			list.get(i).setType(Type.getType(parameterTypes[i])); //Fix types
			retTypes[i] = Type.getType(parameterTypes[i]);
		}
		return retTypes;
	}
	
	public Class<?> genClass(String className, String[] interfaces, boolean wirteFile, 
			String methodName, boolean isStatic, Class<?> ...parameterTypes) {
		try {
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			CodeGenerator cgen = new CodeGenerator();
			
			//Define class
			cgen.startClass(className, interfaces);
			
			//Define method
			Type[] argTypes = getAndFixArgumentTypes(parameterTypes);
			
			Type retType = stack.peek().getType();
			if(null == retType) throw new RuntimeException("Stack is empty!");
			int access =  Opcodes.ACC_PUBLIC;
			if(isStatic) access |= Opcodes.ACC_STATIC;
			cgen.startMethod(access,
					methodName,Type.getMethodDescriptor(
							retType, //return type of the last expression
							argTypes
				));
			cgen.startCode();
			
			MethodVisitor mv = cgen.getMV();
			
			int index = 1;
			if(isStatic) index = 0;
			for(String key : paramMap.keySet()) {
				VariableNode var = paramMap.get(key);
				var.idxLVT = index;
				if(var.getType().getSort() == Type.DOUBLE)
					index += 2;
				else
					index++;
			}
			for(String key : localVarMap.keySet()) {
				VariableNode var = localVarMap.get(key);
				var.idxLVT = index;
				if(var.getType().getSort() == Type.DOUBLE)
					index += 2;
				else
					index++;
			}
			
			//Generate code for all the expressions
			while(!stack.isEmpty()) {
				ExprNode expr = stack.pollLast();
				expr.genCode(mv);
			}
			
			mv.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			if(!isStatic)
				mv.visitLocalVariable("this", "L"+className+";", null, cgen.l0, cgen.l1, 0);
			for(VariableNode var : paramMap.values()) {
				mv.visitLocalVariable(var.name, var.getType().getDescriptor(),
						null, cgen.l0, cgen.l1, var.idxLVT);
			}
			for(VariableNode var : localVarMap.values()) {
				mv.visitLocalVariable(var.name, var.getType().getDescriptor(), 
						null, cgen.l0, cgen.l1, var.idxLVT);
			}
			
			mv.visitMaxs(-1, -1); //Auto generated
			cgen.endCode();
			cgen.endClass();
			
			byte[] bcode = cgen.dump();
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

	@Override public void exitLogicalExpressionNot(ExprGrammarParser.LogicalExpressionNotContext ctx) {
		stack.push(new NotNode(stack.pop()));
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
	
	@Override public void exitArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new MultNode(v1, v2));
	}

	@Override public void exitArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new AddNode(v1, v2));
	}
	
	@Override public void exitArithmeticExpressionNegationEntity(ExprGrammarParser.ArithmeticExpressionNegationEntityContext ctx) {
		stack.push(new NegateNode(stack.pop()));
	}
//	@Override public void exitArithmeticExpressionNegationExpr(ExprGrammarParser.ArithmeticExpressionNegationExprContext ctx) {
//		stack.push(new NegateNode(stack.pop()));
//	}
	
	@Override public void exitArithmeticExpressionSub(ExprGrammarParser.ArithmeticExpressionSubContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SubNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new DivNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionRem(ExprGrammarParser.ArithmeticExpressionRemContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new RemNode(v1, v2));
	}
	@Override public void exitBitExpressionAnd(ExprGrammarParser.BitExpressionAndContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new BAndNode(v1, v2));
	}
	@Override public void exitBitExpressionOr(ExprGrammarParser.BitExpressionOrContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new BOrNode(v1, v2));
	}
	@Override public void exitBitExpressionNot(ExprGrammarParser.BitExpressionNotContext ctx) {
		stack.push(new BNotNode(stack.pop()));
	}
	@Override public void exitBitExpressionXor(ExprGrammarParser.BitExpressionXorContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new BXorNode(v1, v2));
	}
	@Override public void exitBitExpressionShl(ExprGrammarParser.BitExpressionShlContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SHLNode(v1, v2));
	}
	@Override public void exitBitExpressionShr(ExprGrammarParser.BitExpressionShrContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SHRNode(v1, v2));
		
	}
	@Override public void exitBitExpressionUshr(ExprGrammarParser.BitExpressionUshrContext ctx) { 
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new USHRNode(v1, v2));
	}

	@Override public void exitEntityConstInteger(ExprGrammarParser.EntityConstIntegerContext ctx) {
		//System.out.println("exitConstInteger"+ctx.getText());
		stack.push(new ConstantNode(ctx.getText(), Type.INT_TYPE));
	}
	@Override public void exitEntityConstFloat(ExprGrammarParser.EntityConstFloatContext ctx) { 
		//System.out.println("exitEntityConstFloat:"+ctx.getText());
		stack.push(new ConstantNode(ctx.getText(), Type.DOUBLE_TYPE));
	}
	@Override public void exitEntityVariable(ExprGrammarParser.EntityVariableContext ctx) {
		//System.out.println("enterEntityVariable:"+ctx.getText());
		String varName = ctx.getText();
		VariableNode val = localVarMap.get(varName);
		if(null == val) {
			val = paramMap.get(varName);
			if(null == val) {
				val = new VariableNode(varName, Type.DOUBLE_TYPE); //default to double
			}
			paramMap.put(varName, val);
		}
		stack.push(val);
	}
	@Override public void exitEntityLogicalConst(ExprGrammarParser.EntityLogicalConstContext ctx) {
		//System.out.println("exitEntityLogicalConst:"+ctx.getText());
		stack.push(new ConstantNode(ctx.getText(),Type.BOOLEAN_TYPE));
	}
	
	@Override public void exitLogicalExpressionEntity(ExprGrammarParser.LogicalExpressionEntityContext ctx) {
		//System.out.println("exitLogicalExpressionEntity:"+ctx.getText());
		//Do nothing
	}

	@Override public void exitArithmeticExpressionEntity(ExprGrammarParser.ArithmeticExpressionEntityContext ctx) {
		//System.out.println("exitArithmeticExpressionEntity:"+ctx.getText());
		//Do nothing
	}

//	@Override public void exitBitExpressionVariable(ExprGrammarParser.BitExpressionVariableContext ctx) {
//		//Change type from double to int
//		System.out.println("exitBitExpressionVariable:"+ctx.getText());
//		String varName = ctx.getText();
//		VariableNode val = localVarMap.get(varName);
//		if(null == val) {
//			val = paramMap.get(varName);
//		}
//		if(null != val) val.setType(Type.INT_TYPE);
//	}
//
//	@Override public void exitBitExpressionConst(ExprGrammarParser.BitExpressionConstContext ctx) {
//		System.out.println("enterBitExpressionConst:"+ctx.getText());
//		//Do nothing
//	}
	@Override public void exitArithmeticExpressionIncDec(ExprGrammarParser.ArithmeticExpressionIncDecContext ctx) {
		if(null != ctx.INC())
			stack.push(new IncNode((VariableNode)stack.pop()));
		else if(null != ctx.DESC())
			stack.push(new DescNode((VariableNode)stack.pop()));
	}
	@Override public void exitExprAddAsign(ExprGrammarParser.ExprAddAsignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new AddAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprSubAsign(ExprGrammarParser.ExprSubAsignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SubAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprMulAsign(ExprGrammarParser.ExprMulAsignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new MulAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprDivAsign(ExprGrammarParser.ExprDivAsignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new DivAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprRemAsign(ExprGrammarParser.ExprRemAsignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new RemAsignNode((VariableNode)v1,v2));
	}

}
