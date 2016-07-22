package io.lambdacloud;

import java.io.FileOutputStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
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

import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

import io.lambdacloud.ExprGrammarParser.Array_indexContext;
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
import io.lambdacloud.statement.FuncDefNode;
import io.lambdacloud.statement.GENode;
import io.lambdacloud.statement.GTNode;
import io.lambdacloud.statement.IfNode;
import io.lambdacloud.statement.IncNode;
import io.lambdacloud.statement.LENode;
import io.lambdacloud.statement.LTNode;
import io.lambdacloud.statement.ListComprehensionNode;
import io.lambdacloud.statement.ListComprehensionNode.LForNode;
import io.lambdacloud.statement.ListComprehensionNode.LIfNode;
import io.lambdacloud.statement.MulAsignNode;
import io.lambdacloud.statement.MultNode;
import io.lambdacloud.statement.NEQNode;
import io.lambdacloud.statement.NegateNode;
import io.lambdacloud.statement.NotNode;
import io.lambdacloud.statement.OrNode;
import io.lambdacloud.statement.RangeNode;
import io.lambdacloud.statement.RemAsignNode;
import io.lambdacloud.statement.RemNode;
import io.lambdacloud.statement.ReturnNode;
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
	public static boolean DEBUG = true;
//	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
//	
//	//Variable map which is generated after parsing
//	//Another place is the phase of code generation
//	public SortedMap<String, VariableNode> varMap = new TreeMap<String, VariableNode>();
	
	public Deque<Scope> scope = new LinkedList<Scope>();

	//Parameter types which should be passed in before parsing
	protected Class<?> defaultParameterTypeOrInterface = null;
	protected Map<String, Class<?>> mapParameterTypes = null;

	public static HashMap<String, FuncDefNode> funcMap = new HashMap<String, FuncDefNode>();
	
	public ExprTreeBuildWalker() {
		scope.push(new Scope("global"));
	}
	
	public ExprTreeBuildWalker(Class<?> defaultParameterTypeOrInterface) {
		this.defaultParameterTypeOrInterface = defaultParameterTypeOrInterface;
		scope.push(new Scope("global"));
	}
	
	public ExprTreeBuildWalker(Map<String, Class<?>> mapParameterTypes) {
		this.mapParameterTypes = mapParameterTypes;
		scope.push(new Scope("global"));
	}
	
	public Scope currentScope() {
		return this.scope.peek();
	}
	
	public void addScope(String scopeName) {
		this.scope.push(new Scope(scopeName));
	}
	
	public Scope popScope() {
		return this.scope.pop();
	}
	
	public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
		
		FuncDefNode fnode = funcMap.get(name);
		fnode.setParamTypes(type.parameterArray());
		String tt = type.toMethodDescriptorString();
		if(DEBUG)
			System.out.println("bootstrap: "+fnode.getFuncClassName()+"."+name+":"+tt);
		//tt = tt.replaceAll("\\(|\\)", "_");
		Class<?> cls = fnode.genFuncCode(true);
		
		MethodHandle mh = MethodHandles.lookup().findStatic(cls, name,
		MethodType.methodType(type.returnType(),type.parameterArray()));

		return new ConstantCallSite(mh);
	}
	
	public void printInfo() {
		System.out.println("Parameters:");
		for(VariableNode n : currentScope().varMap.values()) {
			if(n.isParameter())
				System.out.println(n.name+": "+n.getType().getDescriptor());
		}
		System.out.println("Local Variables:");
		for(VariableNode n : currentScope().varMap.values()) {
			if(n.isLocalVar())
				System.out.println(n.name+": "+n.getType().getDescriptor());
		}
	}
	
	public Type[] getAndFixParameterTypes(Map<String, Class<?>> mapParameterTypes) {
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.currentScope().varMap.entrySet()) {
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
			if(null == mapParameterTypes)
				throw new RuntimeException("Need parameter for variable: "+node.name);
			Class<?> cls = mapParameterTypes.get(node.name);
			if(null == cls)
				throw new RuntimeException("Need parameter for variable: "+node.name);
			node.setType(Type.getType(mapParameterTypes.get(node.name)));
			
			ret[i] = Type.getType(mapParameterTypes.get(node.name));
			
			i++;
		}
		return ret;
	}
	
	public Type[] getAndFixParameterTypes(Class<?>[] aryParameterTypes) {
		List<VariableNode> pList = new ArrayList<VariableNode>();
		for(Entry<String, VariableNode> e : this.currentScope().varMap.entrySet()) {
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
		for(Entry<String, VariableNode> e : this.currentScope().varMap.entrySet()) {
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
		for(Entry<String, VariableNode> e : this.currentScope().varMap.entrySet()) {
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
	 * @param writeFile
	 * @param methodName
	 * @param isStatic
	 * @return
	 */
	public Class<?> genClass(String className, boolean writeFile, 
			String methodName, boolean isStatic) {
		return genClass(className, writeFile, methodName,  isStatic, null);
	}
	
	/**
	 * Use defaultParameterTypesOrInterface to generate class
	 * @param className
	 * @param writeFile
	 * @param methodName
	 * @param isStatic
	 * @param aryParameterTypes
	 * @return
	 */
	public Class<?> genClass(String className, boolean writeFile, 
			String methodName, boolean isStatic, Class<?>[] aryParameterTypes) {
		try {
			
			if(currentScope().stack.isEmpty()) 
				return null;
			
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
						retType = currentScope().stack.peek().getType(); //return type of the last expression
						if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
						cgen.startMethod(access, m.getName(),
								Type.getMethodDescriptor(retType, paramTypes));
					} else {
						int nParam = 0;
						for(Entry<String, VariableNode> e : this.currentScope().varMap.entrySet()) {
							if(e.getValue().isParameter()) nParam++;
						}
						Class<?>[] pTypes = new Class<?>[nParam];
						for(int i=0; i<pTypes.length; i++) pTypes[i] = this.defaultParameterTypeOrInterface; 
						paramTypes = getAndFixParameterTypes(pTypes);
						retType = currentScope().stack.peek().getType(); //return type of the last expression
						if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
						cgen.startMethod(access, methodName,
								Type.getMethodDescriptor(retType, paramTypes));
					}
				} else {
					paramTypes = getAndFixParameterTypes(this.mapParameterTypes);
					retType = currentScope().stack.peek().getType(); //return type of the last expression
					if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
					cgen.startMethod(access, methodName,
							Type.getMethodDescriptor(retType, paramTypes));
				}
			} else {
				paramTypes = getAndFixParameterTypes(aryParameterTypes);
				retType = currentScope().stack.peek().getType(); //return type of the last expression
				if(null == retType) throw new RuntimeException("Return type (top element of stack) is null!");
				cgen.startMethod(access, methodName,
						Type.getMethodDescriptor(retType, paramTypes));
			}
			cgen.startCode();
			
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, currentScope().varMap);
			
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
			while(!currentScope().stack.isEmpty()) {
				ExprNode expr = currentScope().stack.pollLast();
				expr.genCode(mg);
			}
			
			mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			if(!isStatic)
				mg.visitLocalVariable("this", "L"+className+";", 
						null, cgen.labelStart, cgen.lableEnd, 0);
			for(VariableNode var : currentScope().varMap.values()) {
				mg.visitLocalVariable(var.name, var.getType().getDescriptor(),
						null, cgen.labelStart, cgen.lableEnd, var.idxLVT);
			}
			
			mg.visitMaxs(-1, -1); //Auto generated
			cgen.endCode();
			cgen.endClass();
			
			byte[] bcode = cgen.dump();
			if(writeFile) {
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
		ExprNode value = this.currentScope().stack.pop();
		VariableNode var = this.currentScope().varMap.get(varName);
		if(null == var) {
			var = VariableNode.newLocalVar(varName, value.getType());
			this.currentScope().varMap.put(varName, var);
		}
		this.currentScope().stack.push(new AssignNode(var, value));
	}
	
	@Override public void exitExprArrayAssign(ExprGrammarParser.ExprArrayAssignContext ctx) { 
		//System.out.println(ctx.getText());
		String varName = ctx.IDENTIFIER().getText();
		VariableNode var = this.currentScope().varMap.get(varName);
		if(null == var) {
			//var = VariableNode.newParameter(varName, Type.getType(int[].class)); //TODO default to double ???
			//varMap.put(varName, var);
			throw new RuntimeException("Uninitialized array "+varName);
		}
		ExprNode val = this.currentScope().stack.pop();
		
		ArrayAssignNode node = new ArrayAssignNode(var, val);
		for(int i=ctx.array_index().size()-1; i>=0; i--) {
			Array_indexContext aic = ctx.array_index(i);
			ExprNode idxS = this.currentScope().stack.pop();
			ExprNode idxE = null;
			if(aic.arithmetic_expr().size() > 1) {
				idxE = idxS;
				idxS = this.currentScope().stack.pop();
			}
			node.addIndex(idxS, idxE);
		}
		this.currentScope().stack.push(node);
	}

	@Override public void exitLogicalExpressionAnd(ExprGrammarParser.LogicalExpressionAndContext ctx) { 
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new AndNode(v1, v2));
	}

	@Override public void exitLogicalExpressionOr(ExprGrammarParser.LogicalExpressionOrContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new OrNode(v1, v2));
	}

	@Override public void exitLogicalExpressionNot(ExprGrammarParser.LogicalExpressionNotContext ctx) {
		currentScope().stack.push(new NotNode(currentScope().stack.pop()));
	}

	@Override public void exitComparisonArithmeticExpression(ExprGrammarParser.ComparisonArithmeticExpressionContext ctx) { 
		//System.out.println(ctx.getText()+"   "+ctx.comp_operator().getText());
		String op = ctx.comp_operator().getText();
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		if(op.equals(">")) {
			currentScope().stack.push(new GTNode(v1, v2));
		} else if(op.equals(">=")) {
			currentScope().stack.push(new GENode(v1, v2));
		} else if(op.equals("<")) {
			currentScope().stack.push(new LTNode(v1, v2));
		} else if(op.equals("<=")) {
			currentScope().stack.push(new LENode(v1, v2));
		} else if(op.equals("==")) {
			currentScope().stack.push(new EQNode(v1, v2));
		} else if(op.equals("!=")) {
			currentScope().stack.push(new NEQNode(v1, v2));
		}
	}

	@Override public void exitArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx) { 
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MultNode(v1, v2));
	}

	@Override public void exitArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new AddNode(v1, v2));
	}
	
	@Override public void exitArithmeticExpressionNegationEntity(ExprGrammarParser.ArithmeticExpressionNegationEntityContext ctx) {
		currentScope().stack.push(new NegateNode(currentScope().stack.pop()));
	}
//	@Override public void exitArithmeticExpressionNegationExpr(ExprGrammarParser.ArithmeticExpressionNegationExprContext ctx) {
//		stack.push(new NegateNode(stack.pop()));
//	}
	
	@Override public void exitArithmeticExpressionSub(ExprGrammarParser.ArithmeticExpressionSubContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SubNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDiv(ExprGrammarParser.ArithmeticExpressionDivContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new DivNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionRem(ExprGrammarParser.ArithmeticExpressionRemContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new RemNode(v1, v2));
	}
	@Override public void exitBitExpressionAnd(ExprGrammarParser.BitExpressionAndContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new BAndNode(v1, v2));
	}
	@Override public void exitBitExpressionOr(ExprGrammarParser.BitExpressionOrContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new BOrNode(v1, v2));
	}
	@Override public void exitBitExpressionNot(ExprGrammarParser.BitExpressionNotContext ctx) {
		currentScope().stack.push(new BNotNode(currentScope().stack.pop()));
	}
	@Override public void exitBitExpressionXor(ExprGrammarParser.BitExpressionXorContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new BXorNode(v1, v2));
	}
	@Override public void exitBitExpressionShl(ExprGrammarParser.BitExpressionShlContext ctx) { 
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SHLNode(v1, v2));
	}
	@Override public void exitBitExpressionShr(ExprGrammarParser.BitExpressionShrContext ctx) { 
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SHRNode(v1, v2));
		
	}
	@Override public void exitBitExpressionUshr(ExprGrammarParser.BitExpressionUshrContext ctx) { 
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new USHRNode(v1, v2));
	}

	@Override public void exitEntityConstInteger(ExprGrammarParser.EntityConstIntegerContext ctx) {
		//System.out.println("exitConstInteger"+ctx.getText());
		currentScope().stack.push(new ConstantNode(ctx.getText(), Type.INT_TYPE));
	}
	@Override public void exitEntityConstFloat(ExprGrammarParser.EntityConstFloatContext ctx) { 
		//System.out.println("exitEntityConstFloat:"+ctx.getText());
		currentScope().stack.push(new ConstantNode(ctx.getText(), Type.DOUBLE_TYPE));
	}

	@Override public void exitEntityVariable(ExprGrammarParser.EntityVariableContext ctx) {
		//System.out.println("exitEntityVariable: "+ctx.getText());
		String varName = ctx.getText();
		VariableNode val = currentScope().varMap.get(varName);
		if(null == val) {
			if(null != this.mapParameterTypes) {
				Class<?> varCls = this.mapParameterTypes.get(varName);
				if(null != varCls)
					val = VariableNode.newParameter(varName, Type.getType(varCls));
				else
					val = VariableNode.newLocalVar(varName, Type.getType(double.class));
					//throw new RuntimeException("No type info provied for '"+varName+"'!");
				
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
			currentScope().varMap.put(varName, val);
		}
		currentScope().stack.push(val);
	}
	@Override public void exitEntityLogicalConst(ExprGrammarParser.EntityLogicalConstContext ctx) {
		//System.out.println("exitEntityLogicalConst:"+ctx.getText());
		currentScope().stack.push(new ConstantNode(ctx.getText(),Type.BOOLEAN_TYPE));
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
		VariableNode var = currentScope().varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(this.defaultParameterTypeOrInterface)); //default to double
			currentScope().varMap.put(varName, var);
		}
		if(null != ctx.INC())
			currentScope().stack.push(new IncNode(var));
		else if(null != ctx.DESC())
			currentScope().stack.push(new DescNode(var));
	}
	@Override public void exitExprAddAssign(ExprGrammarParser.ExprAddAssignContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new AddAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprSubAssign(ExprGrammarParser.ExprSubAssignContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SubAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprMulAssign(ExprGrammarParser.ExprMulAssignContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MulAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprDivAssign(ExprGrammarParser.ExprDivAssignContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new DivAsignNode((VariableNode)v1,v2));
	}
	@Override public void exitExprRemAssign(ExprGrammarParser.ExprRemAssignContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new RemAsignNode((VariableNode)v1,v2));
	}

	@Override public void exitExprIf(ExprGrammarParser.ExprIfContext ctx) {
		IfNode ifnode = new IfNode();
		//System.out.println(ctx.getText());
		//System.out.println(ctx.logical_expr().getText());
		//System.out.println(ctx.block().get(0).getText());
		if(ctx.block().size() > 1) { //else branch
			//System.out.println(ctx.block().get(1).getText());
			while(true) {
				ExprNode n = currentScope().stack.peek();
				if(n.getTag()=="S") { n.setTag("SS"); break; }
				ifnode.elseBlockExprs.add(currentScope().stack.pop());
			}
		}
		while(true) {
			ExprNode n = currentScope().stack.peek();
			if(n.getTag()=="S") { n.setTag("SS"); break; }
			ifnode.ifBlockExprs.add(currentScope().stack.pop());
		}
		ifnode.condition = currentScope().stack.pop();
		currentScope().stack.push(ifnode);
	}
	
	@Override public void enterStatementBlock(ExprGrammarParser.StatementBlockContext ctx) {
		//System.out.println("enterStatementBlock:"+ctx.getText());
		//if(stack.size() > 0)
		currentScope().stack.peek().setTag("S");
	}
	
	@Override public void exitStatementBlock(ExprGrammarParser.StatementBlockContext ctx) { 
		//System.out.println("exitStatementBlock:"+ctx.getText());
		currentScope().stack.peek().setTag("E");
	}
	@Override public void exitExprWhile(ExprGrammarParser.ExprWhileContext ctx) { 
		WhileNode wn = new WhileNode();
		while(true) {
			ExprNode n = currentScope().stack.peek();
			if(n.getTag()=="S") { 
				n.setTag("SS"); 
				break; 
			}
			wn.block.add(currentScope().stack.pop());
		}
		wn.condition = currentScope().stack.pop();
		currentScope().stack.push(wn);
	}
	@Override public void exitExprFor(ExprGrammarParser.ExprForContext ctx) { 
		ForNode fn = new ForNode();
		while(true) {
			ExprNode n = currentScope().stack.peek();
			if(n.getTag()=="S") { 
				n.setTag("SS"); 
				break; 
			}
			fn.block.add(currentScope().stack.pop());
		}
		if(ctx.assign_expr().size() > 0) {
			for(int i=ctx.assign_expr().size()-1; i>=0; i--) {
				fn.inc.add(currentScope().stack.pop());
			}
		}
		fn.cond = currentScope().stack.pop();
		if(ctx.assign_expr().size() > 0) {
			for(int i=ctx.assign_expr().size()-1; i>=0; i--) {
				fn.init.add(currentScope().stack.pop());
			}
		}
		currentScope().stack.push(fn);
	}
	@Override public void exitStatements(ExprGrammarParser.StatementsContext ctx) {

	}
	
	@Override public void exitProg(ExprGrammarParser.ProgContext ctx) { 
		if(ctx.statements().statement().size() == 0) { //Single expression case
			//Add return value by generating load instruction
			ExprNode node = currentScope().stack.peek();
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
		VariableNode var = this.currentScope().varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(int[].class)); //default to double
			currentScope().varMap.put(varName, var);
		}
		
		ArrayAccessNode node = new ArrayAccessNode(var);
		for(int i=ctx.array_index().size()-1; i>=0; i--) {
			Array_indexContext aic = ctx.array_index(i);
			ExprNode idxS = this.currentScope().stack.pop();
			ExprNode idxE = null;
			if(aic.arithmetic_expr().size() > 1) {
				idxE = idxS;
				idxS = this.currentScope().stack.pop();
			}
			node.addIndex(idxS, idxE);
		}

		this.currentScope().stack.push(node);
	}
	public static int test(int[][] a) {
		return a[0][1];
	}
	public static int[] test1(int[][] a) {
		return a[0];
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
		currentScope().stack.push(new StringNode(s.substring(1, s.length()-1)));
		
	}

	@Override public void exitStringEntity(ExprGrammarParser.StringEntityContext ctx) { 
		//System.out.println("exitStringEntity"+ctx.getText());
	}
	
	@Override public void exitStringConcat(ExprGrammarParser.StringConcatContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new StringConcatNode(v1,v2));
	}
	
	@Override public void exitComparisonStringExpression(ExprGrammarParser.ComparisonStringExpressionContext ctx) { 
		String op = (null==ctx.EQ()) ? ctx.NEQ().getText() : ctx.EQ().getText();
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new StringCompareNode(v1, v2, op));
	}
	@Override public void exitArray_init(ExprGrammarParser.Array_initContext ctx) {
		//System.out.println(ctx.getText());
		int dim = ctx.expression().size();
		ArrayNode node = new ArrayNode();
		for(int i=0; i<dim; i++) {
			node.addInitValues(currentScope().stack.pop());
		}
		currentScope().stack.push(node);
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
		//Class name transform
		if(className.equalsIgnoreCase("math"))
			className = "java.lang.Math";
		else if( methodName.equalsIgnoreCase("print")
				|| methodName.equalsIgnoreCase("println") 
				//|| methodName.equalsIgnoreCase("range")
			  ) {
				className = "io.lambdacloud.BytecodeSupport";
		} else if(className.length() == 0){
			className = "io.lambdacloud.BytecodeSupport";
		}
		
		//Method name transform
		if(methodName.equalsIgnoreCase("range")) {
			ExprNode start = null;
			ExprNode end = currentScope().stack.pop();
			if(ctx.expression().size() > 1) {
				start = currentScope().stack.pop();
			}
			RangeNode node = new RangeNode(start, end, false);
			currentScope().stack.push(node);
		} else {
			FuncDefNode funcDef = funcMap.get(methodName);
			if(DEBUG)
				System.out.println("Call "+methodName+" in scope "+this.currentScope());
			
			List<ExprNode> args = new ArrayList<ExprNode>();
			for(int i=0; i<ctx.expression().size(); i++) {
				//System.out.println(ctx.expression(i).getText());
				ExprNode arg = currentScope().stack.pop();
				if(arg instanceof AssignNode) {
					arg.genLoadInsn(true);
				}
				args.add(arg);
			}
			
			boolean isDynamicCall = false;
			if(null != funcDef && !funcDef.name.equals(this.currentScope().toString())) {
				className = funcDef.getFuncClassName();//"global";
				isDynamicCall = true;
			} else if(null != funcDef && funcDef.name.equals(this.currentScope().toString())) {
				//This is the case that the recursively call of the function
				//The body of the function is not available here see enterFuncDef()
				className = funcDef.getFuncClassName();
				isDynamicCall = false; //TODO We are not able to determine this here! We need to determine it at code generation phase
			}
			FuncCallNode funcCall = new FuncCallNode(className, methodName, isDynamicCall);
			funcCall.args = args;
			funcCall.refFuncDefNode = funcDef;
			//Type body of funcDef has not been processed here if it is an recursive call
			//funcDef.setParamTypes(funcCall.getParameterClassTypes());
			//System.out.println(Type.getMethodDescriptor(funcCall.getType(), funcCall.getParameterTypes()));
			//System.out.println(funcDef.getType().getDescriptor());
			currentScope().stack.push(funcCall);
		}
	}
	@Override public void exitList_comprehension(ExprGrammarParser.List_comprehensionContext ctx) {
//		System.out.println(this.stack);
//		
//		System.out.print("[ "+ctx.expression().getText());
//		for(int i=0; i<ctx.list_comp_for_if().size(); i++) {
//			List_comp_for_ifContext for_if = ctx.list_comp_for_if(i);
//				System.out.print(" for "+for_if.list_comp_for().IDENTIFIER().getText());
//				System.out.print(" in "+for_if.list_comp_for().expression().getText());
//				if(null != for_if.list_comp_if())
//					System.out.print(" "+for_if.list_comp_if().getText());
//		}
//		System.out.println(" ]");
		
		ListComprehensionNode listCompNode = new ListComprehensionNode();
		for(int i=ctx.list_comp_for_if().size()-1; i>=0; i--) {
			
			List_comp_for_ifContext forIfNode = ctx.list_comp_for_if(i);
			LIfNode ifNode = null;
			if(null != forIfNode.list_comp_if()) {
				ifNode = new LIfNode(this.currentScope().stack.pop(), null);
			}
			
			//[x+y for x in setA for y in setB]
			String varName = forIfNode.list_comp_for().IDENTIFIER().getText();
			VariableNode val = this.currentScope().varMap.get(varName);
			ExprNode setA = this.currentScope().stack.pop();
			if(null == val) {
				//val = this.varMap.put(varName, VariableNode.newLocalVar(varName,setA.getType().getElementType()));
				val = VariableNode.newLocalVar(varName,Type.getType(double.class));
				this.currentScope().varMap.put(varName, val);
				//this is needed for 'y' in [ [x for x in A] for y in B ]
				//throw new RuntimeException("Should not be here since all expr has been generated if we are here");
			} else {
				//val.setType(setA.getType().getElementType());
				val.setAsLocalVar(); //Set x as local variable in expression like '[for x in setA]'
				//val.setType(Type.getType(int.class));
			}
			if(null != this.mapParameterTypes) {
				val.setType(setA.getType().getElementType());
			} else if(null != this.defaultParameterTypeOrInterface) {
				val.setType(Type.getType(this.defaultParameterTypeOrInterface.getClass()));
			}
			
			//TODO type of val, see ExprNode.fixType() for a possible alternative solution 
			if(setA instanceof RangeNode) {
				val.setType(Type.INT_TYPE);
			}
			LForNode forNode = null;
			//Build a singly linked list from tail to head
			//(TAIL) null <- forNode <- forNode <- ... <- listCompNode.forNode (HEAD)
			if(null == listCompNode.forNode) {
				//If we have ifNode, it should be processed here
				//together with The first forNode
				forNode = new LForNode(
						varName, setA,
						ifNode
						);
			} else {
				ExprNode forNodeExpr = listCompNode.forNode;
				if(null != ifNode) {
					ifNode.bodyExpr = listCompNode.forNode;
					forNodeExpr = ifNode;
				}
				forNode = new LForNode(
						varName, setA,
						forNodeExpr
						);
			}
			listCompNode.forNode = forNode;
		}

		ExprNode forNode = listCompNode.forNode;
		ExprNode forNodeExpr = listCompNode.forNode.exprNode;
		while(null != forNodeExpr) {
			if(forNodeExpr instanceof LForNode) {
				forNode = forNodeExpr;
				forNodeExpr = ((LForNode)forNodeExpr).exprNode;
			} else if(forNodeExpr instanceof LIfNode) {
				forNode = forNodeExpr;
				forNodeExpr = ((LIfNode)forNodeExpr).bodyExpr;
			} else {
				throw new RuntimeException();
			}
		}
		if(forNode instanceof LForNode)
			((LForNode)forNode).exprNode = this.currentScope().stack.pop(); //The last expression
		else if(forNode instanceof LIfNode)
			((LIfNode)forNode).bodyExpr = this.currentScope().stack.pop(); //The last expression
		else
			throw new RuntimeException();
		this.currentScope().stack.push(listCompNode);
	}
	
	@Override public void exitExprArrayGen(ExprGrammarParser.ExprArrayGenContext ctx) {
		ExprNode idxE = this.currentScope().stack.pop();
		ExprNode idxS = this.currentScope().stack.pop();
		RangeNode node = new RangeNode(idxS, idxE, true);
		currentScope().stack.push(node);
	}
	
	@Override public void exitArithmeticExpressionPow(ExprGrammarParser.ArithmeticExpressionPowContext ctx) {
		ExprNode pow = this.currentScope().stack.pop();
		ExprNode base = this.currentScope().stack.pop();
		pow.setType(Type.DOUBLE_TYPE);
		base.setType(Type.DOUBLE_TYPE);
		base.freezeType(true);
		FuncCallNode fnode = new FuncCallNode("java.lang.Math", "pow", false);
		//reverse the order
		fnode.args.add(pow);
		fnode.args.add(base);
		currentScope().stack.push(fnode);
	}
	
	@Override public void exitExprSum(ExprGrammarParser.ExprSumContext ctx) {
//		System.out.println(this.stack);
//		
//		System.out.print("[ "+ctx.expression().getText());
//		for(int i=0; i<ctx.list_comp_for_if().size(); i++) {
//			List_comp_for_ifContext for_if = ctx.list_comp_for_if(i);
//				System.out.print(" for "+for_if.list_comp_for().IDENTIFIER().getText());
//				System.out.print(" in "+for_if.list_comp_for().expression().getText());
//				if(null != for_if.list_comp_if())
//					System.out.print(" "+for_if.list_comp_if().getText());
//		}
//		System.out.println(" ]");
		
		ListComprehensionNode listCompNode = new ListComprehensionNode();
		for(int i=ctx.list_comp_for_if().size()-1; i>=0; i--) {
			
			List_comp_for_ifContext forIfNode = ctx.list_comp_for_if(i);
			LIfNode ifNode = null;
			if(null != forIfNode.list_comp_if()) {
				ifNode = new LIfNode(this.currentScope().stack.pop(), null);
			}
			
			//[x+y for x in setA for y in setB]
			String varName = forIfNode.list_comp_for().IDENTIFIER().getText();
			VariableNode val = this.currentScope().varMap.get(varName);
			ExprNode setA = this.currentScope().stack.pop();
			if(null == val) {
				//val = this.varMap.put(varName, VariableNode.newLocalVar(varName,setA.getType().getElementType()));
				val = VariableNode.newLocalVar(varName,Type.getType(double.class));
				this.currentScope().varMap.put(varName, val);
				//this is needed for 'y' in [ [x for x in A] for y in B ]
				//throw new RuntimeException("Should not be here since all expr has been generated if we are here");
			} else {
				//val.setType(setA.getType().getElementType());
				val.setAsLocalVar(); //Set x as local variable in expression like '[for x in setA]'
				//val.setType(Type.getType(int.class));
			}
			if(null != this.mapParameterTypes) {
				val.setType(setA.getType().getElementType());
			} else if(null != this.defaultParameterTypeOrInterface) {
				val.setType(Type.getType(this.defaultParameterTypeOrInterface.getClass()));
			}
			
			//TODO type of val, see ExprNode.fixType() for a possible alternative solution 
			if(setA instanceof RangeNode) {
				val.setType(Type.INT_TYPE);
			}
			LForNode forNode = null;
			//Build a singly linked list from tail to head
			//(TAIL) null <- forNode <- forNode <- ... <- listCompNode.forNode (HEAD)
			if(null == listCompNode.forNode) {
				//If we have ifNode, it should be processed here
				//together with The first forNode
				forNode = new LForNode(
						varName, setA,
						ifNode
						);
			} else {
				ExprNode forNodeExpr = listCompNode.forNode;
				if(null != ifNode) {
					ifNode.bodyExpr = listCompNode.forNode;
					forNodeExpr = ifNode;
				}
				forNode = new LForNode(
						varName, setA,
						forNodeExpr
						);
			}
			listCompNode.forNode = forNode;
		}

		ExprNode forNode = listCompNode.forNode;
		ExprNode forNodeExpr = listCompNode.forNode.exprNode;
		while(null != forNodeExpr) {
			if(forNodeExpr instanceof LForNode) {
				forNode = forNodeExpr;
				forNodeExpr = ((LForNode)forNodeExpr).exprNode;
			} else if(forNodeExpr instanceof LIfNode) {
				forNode = forNodeExpr;
				forNodeExpr = ((LIfNode)forNodeExpr).bodyExpr;
			} else {
				throw new RuntimeException();
			}
		}
		if(forNode instanceof LForNode)
			((LForNode)forNode).exprNode = this.currentScope().stack.pop(); //The last expression
		else if(forNode instanceof LIfNode)
			((LIfNode)forNode).bodyExpr = this.currentScope().stack.pop(); //The last expression
		else
			throw new RuntimeException();
		FuncCallNode fcn = new FuncCallNode("io.lambdacloud.BytecodeSupport", "sum", false);
		fcn.args.add(listCompNode);
		this.currentScope().stack.push(fcn);
	}
	
	@Override public void enterFuncDef(ExprGrammarParser.FuncDefContext ctx) { 
		//Add function level scope for stack and varMap
		String funcName = ctx.IDENTIFIER(0).getText();
		this.addScope(funcName);
		
		this.currentScope().stack.push(
				VariableNode.newLocalVar(ctx.IDENTIFIER(0).getText(), Type.VOID_TYPE).setTag("S"));
		FuncDefNode fnode = funcMap.get(funcName);
		if(null != fnode) {
			throw new RuntimeException("Function "+funcName+" already defined!");
		} else {
			funcMap.put(funcName, new FuncDefNode(funcName));
		}
	}

	@Override public void exitFuncDef(ExprGrammarParser.FuncDefContext ctx) {
		//When enterFuncDef() we need to add a new scope in function level for stack and varMap
		//see enterFuncDef()
		
		String funcName = ctx.IDENTIFIER(0).getText();
		FuncDefNode fNode = funcMap.get(funcName);
		for(int i=1; i<ctx.IDENTIFIER().size(); i++) {
			String paramName = ctx.IDENTIFIER(i).getText();
			fNode.paramNames.add(paramName);
		}
		fNode.funcVarMap.putAll(this.currentScope().varMap);
		
		ExprNode node = null;
		
		//TODO: remove stop flag, since we are using scope it is easy to determine the boundary of expressions
		while(!this.currentScope().stack.isEmpty()) {
			node = this.currentScope().stack.pop();
			if("S".equals(node.getTag())) { 
				break;
			} else {
				fNode.body.add(node);
			}
		}
		
		//Put fNode in funcMap at the function enterFuncDef
		//so recursive call of itself can be handled correctly
		//by knowing the definition of function early
		//funcMap.put(fNode.name, fNode);
		
		if(DEBUG)
			System.out.println(fNode);
		
		this.popScope();
	}
	
	@Override public void exitExprReturn(ExprGrammarParser.ExprReturnContext ctx) {
		ReturnNode node = null;
		if(null != ctx.expression()) {
			node = new ReturnNode(this.currentScope().stack.pop());
		} else {
			node = new ReturnNode();
		}
		this.currentScope().stack.push(node);
	}

}
