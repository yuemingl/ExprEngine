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
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.ExprGrammarParser.ExpressionContext;
import io.lambdacloud.ExprGrammarParser.List_comp_for_ifContext;
import io.lambdacloud.statement.AddAsignNode;
import io.lambdacloud.statement.AddNode;
import io.lambdacloud.statement.AndNode;
import io.lambdacloud.statement.ArrayAccessNode;
import io.lambdacloud.statement.ArrayAssignNode;
import io.lambdacloud.statement.ArrayNode;
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
import io.lambdacloud.statement.ForNode;
import io.lambdacloud.statement.FuncCallNode;
import io.lambdacloud.statement.GENode;
import io.lambdacloud.statement.GTNode;
import io.lambdacloud.statement.IfNode;
import io.lambdacloud.statement.IncNode;
import io.lambdacloud.statement.LENode;
import io.lambdacloud.statement.LTNode;
import io.lambdacloud.statement.ListComprehensionNode;
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
import io.lambdacloud.statement.StringCompareNode;
import io.lambdacloud.statement.StringConcatNode;
import io.lambdacloud.statement.StringNode;
import io.lambdacloud.statement.SubAsignNode;
import io.lambdacloud.statement.SubNode;
import io.lambdacloud.statement.USHRNode;
import io.lambdacloud.statement.VariableNode;
import io.lambdacloud.statement.WhileNode;

public class ExprTreeBuildWalker extends ExprGrammarBaseListener {
	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
	
	//Variable map which is generated after parsing
	//Another place is the phase of code generation
	public SortedMap<String, VariableNode> varMap = new TreeMap<String, VariableNode>();
	
	//Parameter types which should be passed in before parsing
	protected Class<?> defaultParameterTypeOrInterface = null;
	protected Map<String, Class<?>> mapParameterTypes = null;
	
	public ExprTreeBuildWalker() {
	}
	
	public ExprTreeBuildWalker(Class<?> defaultParameterTypeOrInterface) {
		this.defaultParameterTypeOrInterface = defaultParameterTypeOrInterface;
	}
	
	public ExprTreeBuildWalker(Map<String, Class<?>> mapParameterTypes) {
		this.mapParameterTypes = mapParameterTypes;
	}
	
	public void printInfo() {
		System.out.println("Parameters:");
		for(VariableNode n : varMap.values()) {
			if(n.isParameter())
				System.out.println(n.name+": "+n.getType().getDescriptor());
		}
		System.out.println("Local Variables:");
		for(VariableNode n : varMap.values()) {
			if(n.isLocalVar())
				System.out.println(n.name+": "+n.getType().getDescriptor());
		}
	}
	
	public Type[] getAndFixParameterTypes(Map<String, Class<?>> mapParameterTypes) {
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.varMap.entrySet()) {
			if(e.getValue().isParameter())
				pList.add(e.getValue());
		}
		Collections.sort(pList, new Comparator<VariableNode>() {
			@Override
			public int compare(VariableNode o1, VariableNode o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		Type[] ret = new Type[pList.size()];
		int i = 0;
		for(VariableNode node : pList) {
			
			//Fix parameter types according the passed in types
			node.setType(Type.getType(mapParameterTypes.get(node.name)));
			
			ret[i] = Type.getType(mapParameterTypes.get(node.name));
			
			i++;
		}
		return ret;
	}
	
	public Type[] getAndFixParameterTypes(Class<?>[] aryParameterTypes) {
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.varMap.entrySet()) {
			if(e.getValue().isParameter())
				pList.add(e.getValue());
		}
		Collections.sort(pList, new Comparator<VariableNode>() {
			@Override
			public int compare(VariableNode o1, VariableNode o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		Type[] ret = new Type[pList.size()];
		this.mapParameterTypes = new HashMap<String, Class<?>>();
		int i = 0;
		for(VariableNode node : pList) {
			
			//Fix parameter types according the passed in types
			node.setType(Type.getType(aryParameterTypes[i]));
			
			ret[i] = Type.getType(aryParameterTypes[i]);
			
			this.mapParameterTypes.put(node.name, aryParameterTypes[i]);
			
			i++;
		}
		return ret;
	}
	
	public Type[] getAndFixParameterTypes(Class<?> defaultParameterType) {
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.varMap.entrySet()) {
			if(e.getValue().isParameter())
				pList.add(e.getValue());
		}
		Collections.sort(pList, new Comparator<VariableNode>() {
			@Override
			public int compare(VariableNode o1, VariableNode o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		Type[] ret = new Type[pList.size()];
		int i = 0;
		for(VariableNode node : pList) {
			
			//Fix parameter types according the passed in types
			node.setType(Type.getType(defaultParameterType));
			
			ret[i] = Type.getType(defaultParameterType);
			
			i++;
		}
		return ret;
	}

	public Class<?>[] getParameterClassTypes() {
		if(null != this.defaultParameterTypeOrInterface && this.defaultParameterTypeOrInterface.isInterface()) {
			return this.defaultParameterTypeOrInterface.getMethods()[0].getParameterTypes();
		}
		
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.varMap.entrySet()) {
			if(e.getValue().isParameter())
				pList.add(e.getValue());
		}
		Collections.sort(pList, new Comparator<VariableNode>() {
			@Override
			public int compare(VariableNode o1, VariableNode o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		Class<?>[] ret = new Class<?>[pList.size()];
		if(null != this.defaultParameterTypeOrInterface) {
			for(int i=0; i<pList.size(); i++) {
				ret[i] = this.defaultParameterTypeOrInterface;
			}
		} else {
			int i = 0;
			for(VariableNode node : pList) {
				ret[i] = mapParameterTypes.get(node.name);
				
				i++;
			}
		}
		return ret;
	}
	
	/**
	 * Use mapParameterTypes to generate class
	 * @param className
	 * @param interfaces
	 * @param wirteFile
	 * @param methodName
	 * @param isStatic
	 * @return
	 */
	public Class<?> genClass(String className, boolean wirteFile, 
			String methodName, boolean isStatic) {
		return genClass(className, wirteFile, methodName,  isStatic, null);
	}
	
	/**
	 * Use defaultParameterTypesOrInterface to generate class
	 * @param className
	 * @param wirteFile
	 * @param methodName
	 * @param isStatic
	 * @param aryParameterTypes
	 * @return
	 */
	public Class<?> genClass(String className, boolean wirteFile, 
			String methodName, boolean isStatic, Class<?>[] aryParameterTypes) {
		try {
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			CodeGenerator cgen = new CodeGenerator();
			
			//Define class
			if(null != this.defaultParameterTypeOrInterface && this.defaultParameterTypeOrInterface.isInterface()) {
				cgen.startClass(className, new String[]{Type.getInternalName(this.defaultParameterTypeOrInterface)});
			} else {
				cgen.startClass(className, null);
			}
			
			//Define method
			Type retType = null;
			Type[] paramTypes = null;
			int access =  Opcodes.ACC_PUBLIC;
			if(isStatic) access |= Opcodes.ACC_STATIC;
			
			//There are two ways to specify parameter types of the generated method
			if(null == aryParameterTypes) {
				if(null != this.defaultParameterTypeOrInterface) {
					if(this.defaultParameterTypeOrInterface.isInterface()) {
						Method m = this.defaultParameterTypeOrInterface.getDeclaredMethods()[0];
						paramTypes = getAndFixParameterTypes(m.getParameterTypes());
						//Check m.getReturnType() == retType ? 
						retType = stack.peek().getType(); //return type of the last expression
						if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
						cgen.startMethod(access, m.getName(),
								Type.getMethodDescriptor(retType, paramTypes));
					} else {
						int nParam = 0;
						for(Entry<String, VariableNode> e : this.varMap.entrySet()) {
							if(e.getValue().isParameter()) nParam++;
						}
						Class<?>[] pTypes = new Class<?>[nParam];
						for(int i=0; i<pTypes.length; i++) pTypes[i] = this.defaultParameterTypeOrInterface; 
						paramTypes = getAndFixParameterTypes(pTypes);
						retType = stack.peek().getType(); //return type of the last expression
						if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
						cgen.startMethod(access, methodName,
								Type.getMethodDescriptor(retType, paramTypes));
					}
				} else {
					paramTypes = getAndFixParameterTypes(this.mapParameterTypes);
					retType = stack.peek().getType(); //return type of the last expression
					if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
					cgen.startMethod(access, methodName,
							Type.getMethodDescriptor(retType, paramTypes));
				}
			} else {
				paramTypes = getAndFixParameterTypes(aryParameterTypes);
				retType = stack.peek().getType(); //return type of the last expression
				if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
				cgen.startMethod(access, methodName,
						Type.getMethodDescriptor(retType, paramTypes));
			}
			cgen.startCode();
			
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, varMap);
			
//			int index = 1;
//			if(isStatic) index = 0;
//			for(Entry<String, VariableNode> e : varMap.entrySet()) {
//				if(e.getValue().isLocalVar()) continue;
//				VariableNode var = e.getValue();
//				var.idxLVT = index;
//				if(var.getType().getSort() == Type.DOUBLE)
//					index += 2;
//				else
//					index++;
//			}
//			for(Entry<String, VariableNode> e : varMap.entrySet()) {
//				if(e.getValue().isParameter()) continue;
//				VariableNode var = e.getValue();
//				var.idxLVT = index;
//				if(var.getType().getSort() == Type.DOUBLE)
//					index += 2;
//				else
//					index++;
//			}
			mg.updateLVTIndex(isStatic);

			
			//Generate code for all the expressions
			while(!stack.isEmpty()) {
				ExprNode expr = stack.pollLast();
				expr.genCode(mg);
			}
			
			mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			if(!isStatic)
				mg.visitLocalVariable("this", "L"+className+";", null, cgen.l0, cgen.l1, 0);
			for(VariableNode var : varMap.values()) {
				mg.visitLocalVariable(var.name, var.getType().getDescriptor(),
						null, cgen.l0, cgen.l1, var.idxLVT);
			}
			
			mg.visitMaxs(-1, -1); //Auto generated
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

	@Override public void exitExprAssign(ExprGrammarParser.ExprAssignContext ctx) {
		//System.out.println("asign: "+ctx.IDENTIFIER().getText()+"="+ctx.statement().getText());
		String varName = ctx.IDENTIFIER().getText();
		ExprNode value = this.stack.pop();
		VariableNode var = this.varMap.get(varName);
		if(null == var) {
			var = VariableNode.newLocalVar(varName, value.getType());
			this.varMap.put(varName, var);
		}
		this.stack.push(new AssignNode(var, value));
	}
	@Override public void exitExprArrayAssign(ExprGrammarParser.ExprArrayAssignContext ctx) { 
		//System.out.println(ctx.getText());
		ExprNode val = this.stack.pop();
		
		String varName = ctx.IDENTIFIER().getText();
		ExprNode idxS = this.stack.pop();
		ExprNode idxE = null;
		if(ctx.arithmetic_expr().size() > 1) {
			idxE = idxS;
			idxS = this.stack.pop();
		}
		
		VariableNode var = this.varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(int[].class)); //TODO default to double ???
			varMap.put(varName, var);
		}
		
		VariableNode retAry = null;
		if(ctx.arithmetic_expr().size() > 1) {
			retAry = VariableNode.newLocalVar(varName+"_ret", Type.getType(int[].class));
			this.varMap.put(varName+"_ret", retAry);
		}
		this.stack.push(new ArrayAssignNode(var, idxS, idxE, retAry, val));
		
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

	@Override public void exitComparisonArithmeticExpression(ExprGrammarParser.ComparisonArithmeticExpressionContext ctx) { 
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
		//System.out.println("exitEntityVariable: "+ctx.getText());
		String varName = ctx.getText();
		VariableNode val = varMap.get(varName);
		if(null == val) {
			if(null != this.mapParameterTypes) {
				val = VariableNode.newParameter(varName, Type.getType(this.mapParameterTypes.get(varName)));
				if(null == val) throw new RuntimeException("No type info provied for '"+varName+"'!");
			} else if(null != this.defaultParameterTypeOrInterface) {
				//default to double
				if(this.defaultParameterTypeOrInterface.isInterface()) {
					//call getAndFixParameterTypes(Class<?>[] aryParameterTypes) before generate code
					//TODO need better solution
					val = VariableNode.newParameter(varName, Type.getType(double.class));
				} else {
					val = VariableNode.newParameter(varName, Type.getType(this.defaultParameterTypeOrInterface));
				}
			} else {
				//call getAndFixParameterTypes(Class<?>[] aryParameterTypes) before generate code
				//TODO need better solution
				val = VariableNode.newParameter(varName, Type.getType(double.class));
			}
			varMap.put(varName, val);
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
		String varName = ctx.IDENTIFIER().getText();
		VariableNode var = varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(this.defaultParameterTypeOrInterface)); //default to double
			varMap.put(varName, var);
		}
		if(null != ctx.INC())
			stack.push(new IncNode(var));
		else if(null != ctx.DESC())
			stack.push(new DescNode(var));
	}
	@Override public void exitExprAddAssign(ExprGrammarParser.ExprAddAssignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new AddAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprSubAssign(ExprGrammarParser.ExprSubAssignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new SubAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprMulAssign(ExprGrammarParser.ExprMulAssignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new MulAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprDivAssign(ExprGrammarParser.ExprDivAssignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new DivAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprRemAssign(ExprGrammarParser.ExprRemAssignContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new RemAsignNode((VariableNode)v1,v2));
	}

	@Override public void exitExprIf(ExprGrammarParser.ExprIfContext ctx) {
		IfNode ifnode = new IfNode();
		//System.out.println(ctx.getText());
		//System.out.println(ctx.logical_expr().getText());
		//System.out.println(ctx.block().get(0).getText());
		if(ctx.block().size() > 1) { //else branch
			//System.out.println(ctx.block().get(1).getText());
			while(true) {
				ExprNode n = stack.peek();
				if(n.getTag()=="S") { n.setTag("SS"); break; }
				ifnode.elseBlockExprs.add(stack.pop());
			}
		}
		while(true) {
			ExprNode n = stack.peek();
			if(n.getTag()=="S") { n.setTag("SS"); break; }
			ifnode.ifBlockExprs.add(stack.pop());
		}
		ifnode.condition = stack.pop();
		stack.push(ifnode);
	}
	@Override public void enterStatementBlock(ExprGrammarParser.StatementBlockContext ctx) {
		//System.out.println("enterStatementBlock:"+ctx.getText());
		stack.peek().setTag("S");
	}
	
	@Override public void exitStatementBlock(ExprGrammarParser.StatementBlockContext ctx) { 
		//System.out.println("exitStatementBlock:"+ctx.getText());
		stack.peek().setTag("E");
	}
	@Override public void exitExprWhile(ExprGrammarParser.ExprWhileContext ctx) { 
		WhileNode wn = new WhileNode();
		while(true) {
			ExprNode n = stack.peek();
			if(n.getTag()=="S") { 
				n.setTag("SS"); 
				break; 
			}
			wn.block.add(stack.pop());
		}
		wn.condition = stack.pop();
		stack.push(wn);
	}
	@Override public void exitExprFor(ExprGrammarParser.ExprForContext ctx) { 
		ForNode fn = new ForNode();
		while(true) {
			ExprNode n = stack.peek();
			if(n.getTag()=="S") { 
				n.setTag("SS"); 
				break; 
			}
			fn.block.add(stack.pop());
		}
		if(ctx.assign_expr().size() > 0) {
			for(int i=ctx.assign_expr().size()-1; i>=0; i--) {
				fn.inc.add(stack.pop());
			}
		}
		fn.cond = stack.pop();
		if(ctx.assign_expr().size() > 0) {
			for(int i=ctx.assign_expr().size()-1; i>=0; i--) {
				fn.init.add(stack.pop());
			}
		}
		stack.push(fn);
	}
	@Override public void exitStatements(ExprGrammarParser.StatementsContext ctx) {

	}
	
	@Override public void exitProg(ExprGrammarParser.ProgContext ctx) { 
		if(ctx.statements().statement().size() == 0) { //Single expression case
			//Add return value by generating load instruction
			ExprNode node = stack.peek();
			node.genLoadInsn(true);
//			if(node instanceof AddAsignNode ||
//			   node instanceof SubAsignNode ||
//			   node instanceof MulAsignNode ||
//			   node instanceof DivAsignNode ||
//			   node instanceof RemAsignNode ||
//			   node instanceof IncNode ||
//			   node instanceof DescNode ||
//			   node instanceof AssignNode
//			   ) {
//				node.genLoadInsn(true);
//			}
		}
	}
	
	@Override public void exitEntityArrayAccess(ExprGrammarParser.EntityArrayAccessContext ctx) {
		//System.out.println(ctx.getText());
		String varName = ctx.IDENTIFIER().getText();
		ExprNode idxS = this.stack.pop();
		ExprNode idxE = null;
		if(ctx.arithmetic_expr().size() > 1) {
			idxE = idxS;
			idxS = this.stack.pop();
		}
		
		VariableNode var = this.varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(int[].class)); //default to double
			varMap.put(varName, var);
		}
		
		VariableNode retAry = null;
		if(ctx.arithmetic_expr().size() > 1) {
			retAry = VariableNode.newLocalVar(varName+"_ret", Type.getType(int[].class));
			this.varMap.put(varName+"_ret", retAry);
		}
		this.stack.push(new ArrayAccessNode(var, idxS, idxE, retAry));
	}
	
	//Set genLoadInsn here? (No, so far we set genLoadInsn(true) in each XXXNode calss instead)
	@Override public void exitExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) {
		//System.out.println(ctx.getText());
		//System.out.println(ctx.arithmetic_expr().getText());
	}
	
	@Override public void exitExprString(ExprGrammarParser.ExprStringContext ctx) {
		//System.out.println(ctx.getText());
	}
	
	@Override public void exitStringConst(ExprGrammarParser.StringConstContext ctx) {
		//System.out.println("exitStringConst"+ctx.getText());
		String s = ctx.getText();
		//System.out.println(s);
		stack.push(new StringNode(s.substring(1, s.length()-1)));
		
	}

	@Override public void exitStringEntity(ExprGrammarParser.StringEntityContext ctx) { 
		//System.out.println("exitStringEntity"+ctx.getText());
	}
	
	@Override public void exitStringConcat(ExprGrammarParser.StringConcatContext ctx) {
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new StringConcatNode(v1,v2));
	}
	
	@Override public void exitComparisonStringExpression(ExprGrammarParser.ComparisonStringExpressionContext ctx) { 
		String op = (null==ctx.EQ()) ? ctx.NEQ().getText() : ctx.EQ().getText();
		ExprNode v2 = stack.pop();
		ExprNode v1 = stack.pop();
		stack.push(new StringCompareNode(v1, v2, op));
	}
	@Override public void exitArray_init(ExprGrammarParser.Array_initContext ctx) {
		//System.out.println(ctx.getText());
		int dim = ctx.numeric_entity().size();
		ArrayNode node = new ArrayNode();
		for(int i=0; i<dim; i++) {
			node.addInitValues(stack.pop());
		}
		stack.push(node);
	}
	
	@Override public void exitFuncCall(ExprGrammarParser.FuncCallContext ctx) {
		String methodName = ctx.IDENTIFIER(ctx.IDENTIFIER().size()-1).getText();
		StringBuilder sb = new StringBuilder();
		//for(int i= ctx.IDENTIFIER().size()-1; i>0; i--) {
		for(int i=0; i<ctx.IDENTIFIER().size()-1; i++) {
			TerminalNode node = ctx.IDENTIFIER(i);
			sb.append(".").append(node.getText());
		}
		String className = sb.length()>0?sb.delete(0, 1).toString():"";
		if(className.equalsIgnoreCase("math"))
			className = "java.lang.Math";
		if(methodName.equalsIgnoreCase("print"))
			className = "io.lambdacloud.BytecodeSupport";
		if(methodName.equalsIgnoreCase("println"))
			className = "io.lambdacloud.BytecodeSupport";
		FuncCallNode fnode = new FuncCallNode(className, methodName);
		for(ExpressionContext expr : ctx.expression()) {
			//System.out.println(expr.getText());
			fnode.args.add(stack.pop());
		}
		stack.push(fnode);
		
	}
	@Override public void exitList_comprehension(ExprGrammarParser.List_comprehensionContext ctx) {
		System.out.println(this.stack);
		System.out.println(ctx.expression().getText());
		for(int i=0; i<ctx.list_comp_for_if().size(); i++) {
			List_comp_for_ifContext for_if = ctx.list_comp_for_if(i);
			if(null != for_if.list_comp_if())
				System.out.println(for_if.list_comp_if().getText());
			for(int j=0; j<for_if.list_comp_for().size(); j++) {
				System.out.println(for_if.list_comp_for(j).IDENTIFIER().getText());
				System.out.println(for_if.list_comp_for(j).expression().getText());
			}
		}
		ListComprehensionNode node = new ListComprehensionNode();
		for(int i=ctx.list_comp_for_if().size()-1; i>=0; i--) {
			
			List_comp_for_ifContext for_if = ctx.list_comp_for_if(i);
			if(null != for_if.list_comp_if()) {
				System.out.println(for_if.list_comp_if().getText());
			}
			
			//[x+y for x in setA for y in setB]
			for(int j=0; j<for_if.list_comp_for().size(); j++) {
				String varName = for_if.list_comp_for(j).IDENTIFIER().getText();
				VariableNode val = this.varMap.get(varName);
				ExprNode setA = this.stack.pop();
				if(null == val) {
					//val = this.varMap.put(varName, VariableNode.newLocalVar(varName,setA.getType().getElementType()));
					val = this.varMap.put(varName, VariableNode.newLocalVar(varName,Type.getType(double.class)));
					//this is needed for 'y' in [ [x for x in A] for y in B ]
					//throw new RuntimeException("Should not be here since all expr has been generated if we are here");
				} else {
					//val.setType(setA.getType().getElementType());
					val.setAsLocalVar(); //Set x as local variable in expression like '[for x in setA]'
				}
				
				
				ListComprehensionNode.LForNode fNode = new ListComprehensionNode.LForNode(
						varName, setA,
						node.forIf
						);
				node.forIf = fNode;
			}
		}

		ListComprehensionNode.LForNode fi = node.forIf;
		ExprNode expression = node.forIf.exprBody;
		while(expression != null) {
			fi = (ListComprehensionNode.LForNode)expression;
			expression = fi.exprBody;
		}
		fi.exprBody = this.stack.pop(); //The last expression
		this.stack.push(node);
	}

}
