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
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.exprengine.ExprGrammarParser;
import io.lambdacloud.matlab.MatlabGrammarBaseListener;
import io.lambdacloud.matlab.MatlabGrammarParser;
import io.lambdacloud.matlab.MatlabGrammarParser.ExpressionContext;
import io.lambdacloud.node.AssignNode;
import io.lambdacloud.node.ConstantNode;
import io.lambdacloud.node.DupNode;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.FuncCallNode;
import io.lambdacloud.node.FuncDefNode;
import io.lambdacloud.node.RangeNode;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.node.arithmetric.AddNode;
import io.lambdacloud.node.arithmetric.DivNode;
import io.lambdacloud.node.arithmetric.MultNode;
import io.lambdacloud.node.arithmetric.NegateNode;
import io.lambdacloud.node.arithmetric.SubNode;
import io.lambdacloud.node.matrix.MatrixAccessNode;
import io.lambdacloud.node.matrix.MatrixDLDivNode;
import io.lambdacloud.node.matrix.MatrixDMulNode;
import io.lambdacloud.node.matrix.MatrixDRDivNode;
import io.lambdacloud.node.matrix.MatrixInitNode;
import io.lambdacloud.node.matrix.SolveNode;
import io.lambdacloud.node.matrix.TransposeNode;

public class MatlabTreeBuildWalker extends MatlabGrammarBaseListener {
	public static boolean DEBUG = false;
//	public Deque<ExprNode> stack = new LinkedList<ExprNode>();
//	
//	//Variable map which is generated after parsing
//	//Another place is the phase of code generation
//	public SortedMap<String, VariableNode> varMap = new TreeMap<String, VariableNode>();
	
	public Deque<Scope> scope = new LinkedList<Scope>();

	//Parameter types which should be passed in before parsing
	protected Class<?> defaultParameterTypeOrInterface = null;
	protected Map<String, Class<?>> mapParameterTypes = null;

	//public static HashMap<String, FuncDefNode> funcMap = new HashMap<String, FuncDefNode>();
	public MatlabTreeBuildWalker() {
		scope.push(new Scope("global"));
	}
	
	public MatlabTreeBuildWalker(Class<?> defaultParameterTypeOrInterface) {
		this.defaultParameterTypeOrInterface = defaultParameterTypeOrInterface;
		scope.push(new Scope("global"));
	}
	
	public MatlabTreeBuildWalker(Map<String, Class<?>> mapParameterTypes) {
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
	
//	public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
//		
//		FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(name);
//		fnode.setParamTypes(type.parameterArray());
//		String tt = type.toMethodDescriptorString();
//		//if(DEBUG)
//			System.out.println("bootstrap11: "+fnode.getFuncClassName()+"."+name+":"+tt);
//		
//		//tt = tt.replaceAll("\\(|\\)", "_");
//		Class<?> cls = fnode.genFuncCode(true);
//		
//		MethodHandle mh = MethodHandles.lookup().findStatic(cls, name,
//		MethodType.methodType(type.returnType(),type.parameterArray()));
//
//		return new ConstantCallSite(mh);
//	}
	
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
	@Override public void exitEntityVariable(MatlabGrammarParser.EntityVariableContext ctx) {
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
	
	@Override public void exitProg(MatlabGrammarParser.ProgContext ctx) { 
	}
	
	@Override public void exitEntityConstInteger(MatlabGrammarParser.EntityConstIntegerContext ctx) {
		//System.out.println("exitConstInteger"+ctx.getText());
		currentScope().stack.push(new ConstantNode(ctx.getText(), Type.INT_TYPE));
	}
	@Override public void exitEntityConstFloat(MatlabGrammarParser.EntityConstFloatContext ctx) { 
		//System.out.println("exitEntityConstFloat:"+ctx.getText());
		currentScope().stack.push(new ConstantNode(ctx.getText(), Type.DOUBLE_TYPE));
	}
	@Override public void exitArray_init(MatlabGrammarParser.Array_initContext ctx) {
		//System.out.println(ctx.getText());
		
		if(null == ctx.ai_list()) {
			//empty matrix
			throw new RuntimeException("empty matrix is not supported so far.");
		}
		int cols = ctx.ai_list(0).expression().size();
		int rows = ctx.ai_list().size();
		MatrixInitNode node = new MatrixInitNode(cols);
		for(int i=0; i<cols; i++) {
			for(int j=0; j<rows; j++) {
				node.addInitValues(currentScope().stack.pop());
			}
		}
		currentScope().stack.push(node);

	}
	@Override public void exitTranspose(MatlabGrammarParser.TransposeContext ctx) { 
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new TransposeNode(v1));
	}

//	@Override public void exitArithmeticExpressionDMul(MatlabGrammarParser.Arithmetic_exprContext.ArithmeticExpressionDMulContext ctx) { 
//		System.out.println(ctx.getText());
//	}
	
	@Override public void exitArithmeticExpressionSolve(MatlabGrammarParser.ArithmeticExpressionSolveContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SolveNode(v1, v2));
	}
	
	@Override public void exitArithmeticExpressionRange(MatlabGrammarParser.ArithmeticExpressionRangeContext ctx) {
		//System.out.println("exitArithmeticExpressionRange "+ctx.getText());
		RangeNode node = null;
		if(ctx.arithmetic_expr().size() == 2) {
			ExprNode idxE = this.currentScope().stack.pop();
			ExprNode idxS = this.currentScope().stack.pop();
			node = new RangeNode(idxS, idxE, true);
		} else if(ctx.arithmetic_expr().size() == 3) {
			ExprNode idxE = this.currentScope().stack.pop();
			ExprNode idxStep = this.currentScope().stack.pop();
			ExprNode idxS = this.currentScope().stack.pop();
			node = new RangeNode(idxS, idxStep, idxE, true);
		} else {
			throw new RuntimeException("Range node error: "+ ctx.getText());
		}
		currentScope().stack.push(node);
	}
	
	@Override public void exitArrayAccessOrFuncCall(MatlabGrammarParser.ArrayAccessOrFuncCallContext ctx) { 
		//System.out.println("exitArrayAccessOrFuncCall: "+ctx.getText());
		String varName = ctx.array_access().IDENTIFIER(ctx.array_access().IDENTIFIER().size()-1).getText();
		FuncDefNode func = ExprTreeBuildWalker.funcMap.get(varName);
		//Function call
		if(null != func) {
			String methodName = varName;
			
			StringBuilder sb = new StringBuilder();
			//for(int i= ctx.IDENTIFIER().size()-1; i>0; i--) {
			for(int i=0; i<ctx.array_access().IDENTIFIER().size()-1; i++) {
				TerminalNode node = ctx.array_access().IDENTIFIER(i);
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
//				ExprNode start = null;
//				ExprNode end = currentScope().stack.pop();
//				if(ctx.expression().size() > 1) {
//					start = currentScope().stack.pop();
//				}
//				RangeNode node = new RangeNode(start, end, false);
//				currentScope().stack.push(node);
			} else {
				FuncDefNode funcDef = ExprTreeBuildWalker.funcMap.get(methodName);
				if(DEBUG)
					System.out.println("Call "+methodName+" in scope "+this.currentScope());
				
				List<ExprNode> args = new ArrayList<ExprNode>();
				for(int i=0; i<ctx.array_access().aa_index().size(); i++) {
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
			
			
			return;
		}
		
		//------Array Access------
		VariableNode var = this.currentScope().varMap.get(varName);
		if(null == var) {
			var = VariableNode.newParameter(varName, Type.getType(int[].class)); //default to double
			currentScope().varMap.put(varName, var);
		}
		
//		ArrayAccessNode node = new ArrayAccessNode(var);
//		for(int i=ctx.func_args().expr_list().expression().size()-1; i>=0; i--) {
//			//ExpressionContext aic = ctx.func_args().expr_list().expression(i);
//			ExprNode idxS = this.currentScope().stack.pop();
//			ExprNode idxE = null;
//			if(idxS instanceof RangeNode) {
//				RangeNode range = (RangeNode)idxS;
//				idxS = range.start;
//				idxE = range.end; //end+1 =>new AddNode(end, 1)
//			}
//			node.addIndex(idxS, idxE);
//		}
		
		MatrixAccessNode node = new MatrixAccessNode(var);
		for(int i=ctx.array_access().aa_index().size()-1; i>=0; i--) {
			if(null != ctx.array_access().aa_index(i).COLON()) {
				//Access all rows or columns
				node.addIndex(null, null);
			} else {
				ExprNode idxS = this.currentScope().stack.pop();
				ExprNode idxE = null;
				if(idxS instanceof RangeNode) {
					//Pass start and end index directly into MatrixAccessNode for optimization purpose
					//(no array is generated for the range)
					RangeNode range = (RangeNode)idxS;
					if(range.step == null) {
						idxS = range.start;
						idxE = range.end; //end+1 =>new AddNode(end, 1)
					} else {
						//do nothing, let indS be the range node
					}
				}
				node.addIndex(idxS, idxE);
			}
		}

		this.currentScope().stack.push(node);
	}
	
	@Override public void exitArithmeticExpressionAdd(MatlabGrammarParser.ArithmeticExpressionAddContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new AddNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionSub(MatlabGrammarParser.ArithmeticExpressionSubContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new SubNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionMul(MatlabGrammarParser.ArithmeticExpressionMulContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MultNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDiv(MatlabGrammarParser.ArithmeticExpressionDivContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new DivNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDMul(MatlabGrammarParser.ArithmeticExpressionDMulContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MatrixDMulNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDLDiv(MatlabGrammarParser.ArithmeticExpressionDLDivContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MatrixDLDivNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionDRDiv(MatlabGrammarParser.ArithmeticExpressionDRDivContext ctx) {
		ExprNode v2 = currentScope().stack.pop();
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new MatrixDRDivNode(v1, v2));
	}
	@Override public void exitArithmeticExpressionNegationEntity(MatlabGrammarParser.ArithmeticExpressionNegationEntityContext ctx) {
		ExprNode v1 = currentScope().stack.pop();
		currentScope().stack.push(new NegateNode(v1));
		
	}
	
	@Override public void exitArithmeticExpressionEntity(MatlabGrammarParser.ArithmeticExpressionEntityContext ctx) {
		//System.out.println("exitArithmeticExpressionEntity:"+ctx.getText());
		//Do nothing
	}
	@Override public void exitExprAssign(MatlabGrammarParser.ExprAssignContext ctx) {
		String varName = ctx.assign_expr().IDENTIFIER().getText();
		ExprNode value = this.currentScope().stack.pop();
		VariableNode var = this.currentScope().varMap.get(varName);
		if(null == var) {
			var = VariableNode.newLocalVar(varName, value.getType());
			this.currentScope().varMap.put(varName, var);
		}
		this.currentScope().stack.push(new AssignNode(var, value));
	}
	
	@Override public void exitFuncDef(MatlabGrammarParser.FuncDefContext ctx) {
		//When enterFuncDef() we need to add a new scope in function level for stack and varMap
		//see enterFuncDef()
		
		String funcName = ctx.IDENTIFIER().getText();
		FuncDefNode fNode = ExprTreeBuildWalker.funcMap.get(funcName);
		for(int i=0; i<ctx.func_def_args().IDENTIFIER().size(); i++) {
			String paramName = ctx.func_def_args().IDENTIFIER(i).getText();
			fNode.paramNames.add(paramName);
		}
		fNode.funcVarMap.putAll(this.currentScope().varMap);
		
		ExprNode node = null;
		
		
		while(!this.currentScope().stack.isEmpty()) {
			node = this.currentScope().stack.pop();
			fNode.body.add(node);
		}
		
		//Determine the return expression
		if(null != ctx.func_def_return()) { //It has return variable specified
			ExprNode retNode = fNode.body.remove(fNode.body.size()-1);
			fNode.body.add(0, retNode);
		} else { //The last expression is the return value
			ExprNode lastExpr = fNode.body.get(0);
			if(lastExpr instanceof FuncCallNode) {
				FuncCallNode funcCallNode = (FuncCallNode)lastExpr;
				//this is handled in exitExprWithExprEnd()
//				if(funcCallNode.getMethodName().equals("println")) {
//					//TODO use DupNode?
//					DupNode dupNode = new DupNode(funcCallNode.args.get(0));
//					funcCallNode.args.set(0, dupNode);
//					//fNode.body.add(0, funcCallNode.args.get(0));
//					//System.out.println(funcCallNode);
//				}
			}
		}
		
		//Put fNode in funcMap at the function enterFuncDef()
		//so recursive call of itself can be handled correctly
		//by knowing the definition of function early
		//funcMap.put(fNode.name, fNode);
		
		if(DEBUG)
			System.out.println(fNode);
		
		this.popScope();
	}
	@Override public void enterFuncDef(MatlabGrammarParser.FuncDefContext ctx) {
		//Add function level scope for stack and varMap
		String funcName = ctx.IDENTIFIER().getText();
		this.addScope(funcName);
		
		FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(funcName);
		if(null != fnode) {
			throw new RuntimeException("Function "+funcName+" already defined!");
		} else {
			ExprTreeBuildWalker.funcMap.put(funcName, new FuncDefNode(funcName));
		}
	}
	@Override public void exitExprStatement(MatlabGrammarParser.ExprStatementContext ctx) {
		//System.out.println("exitExprStatement>>>>----"+ctx.getText()+"----<<<<");
	}
	
	@Override public void exitExprArithmetic(MatlabGrammarParser.ExprArithmeticContext ctx) { 
		//System.out.println("exitExprArithmetic>>>>"+ctx.getText()+"<<<<");
	}
	
	@Override public void exitExprStatements(MatlabGrammarParser.ExprStatementsContext ctx) {
		//System.out.println("exitExprStatements>>>>"+ctx.getText()+"<<<<");
		ExpressionContext lastExpr = ctx.expression();
		if(null != lastExpr) {
			if(null != ctx.expr_end() && ctx.expr_end().SEMI().size()>0)
				return;
			//print the LAST expression
			ExprNode expr = this.currentScope().stack.pop();
			expr.genLoadInsn(true);
			FuncCallNode funcCall = new FuncCallNode(BytecodeSupport.class.getName(), "println", false);
			DupNode dupNode = new DupNode(expr);
			funcCall.args.add(dupNode);
			this.currentScope().stack.push(funcCall);
		}
	}
	
	@Override public void exitExprWithExprEnd(MatlabGrammarParser.ExprWithExprEndContext ctx) {
		//System.out.println("exitExprWithExprEnd>>>>"+ctx.getText()+"<<<<");
		if(null != ctx.expr_end() && ctx.expr_end().SEMI().size()>0)
			return;
		//print the expression
		ExprNode expr = this.currentScope().stack.pop();
		expr.genLoadInsn(true);
		//TODO change 'println' to an internal name to indicate that it returns the type the same as the argument
		FuncCallNode funcCall = new FuncCallNode(BytecodeSupport.class.getName(), "println", false);
		DupNode dupNode = new DupNode(expr);
		funcCall.args.add(dupNode);
		this.currentScope().stack.push(funcCall);
	}

}
