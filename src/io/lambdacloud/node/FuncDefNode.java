package io.lambdacloud.node;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.CodeGenerator;
import io.lambdacloud.ExprClassLoader;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.arithmetric.AddAsignNode;
import io.lambdacloud.node.arithmetric.DescNode;
import io.lambdacloud.node.arithmetric.DivAsignNode;
import io.lambdacloud.node.arithmetric.IncNode;
import io.lambdacloud.node.arithmetric.MulAsignNode;
import io.lambdacloud.node.arithmetric.SubAsignNode;
import io.lambdacloud.util.ObjectArray;

public class FuncDefNode extends ExprNode {
	public String name;
	//public Map<String, VariableNode> funcVarMap = new TreeMap<String, VariableNode>();
	public Map<String, VariableNode> funcVarMap = new LinkedHashMap<String, VariableNode>();

	public StatementNode body = new StatementNode();
	
	/**
	 * This is used to keep the return expression declared in the definition of a function
	 * function R = fun(x)
	 * ...
	 * end
	 */
	public ExprNode retExpr; 

	public static AtomicInteger seq = new AtomicInteger(0);

	// Map between methodDescriptor => className
	public Map<String, String> generatedClasses = new HashMap<String, String>();
	// Parameter name declared
	public List<String> paramNames = new ArrayList<String>();

	public FuncDefNode(String name) {
		this.name = name;
		seq.getAndIncrement();
	}

	public boolean hasVarargin() {
		if(this.paramNames.size() > 0) {
			String lastName = this.paramNames.get(this.paramNames.size()-1);
			if(!lastName.equalsIgnoreCase("varargin")) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	public Map<String, Type> setParamTypes(Deque<Object> stack, Type[] newTypes) {
		if(this.paramNames.size() > 0) {
			String lastName = this.paramNames.get(this.paramNames.size()-1);
			if(!lastName.equalsIgnoreCase("varargin")) {
				if (this.paramNames.size() < newTypes.length) {
					throw new RuntimeException("Too many parameters for function "+this.name+"!");
				}
			}
		} else {
			if (0 < newTypes.length) {
				throw new RuntimeException("Too many parameters for function "+this.name+"!");
			}
		}
		
		//Set all to optional first
		for (String paramName : this.paramNames) {
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if (paramNode.isParameter()) {
				paramNode.setOptional(true);
			}
		}
		//Set parameters in the new types list to non-optional,
		//that is to say, others if exist beyond the list are set to optional
		Map<String, Type> mapOldTypes = new TreeMap<String, Type>();
		for (int i = 0; i < newTypes.length; i++) {
			if(this.paramNames.size() > i) {
	 			String paramName = this.paramNames.get(i);
				VariableNode paramNode = this.funcVarMap.get(paramName);
				if (paramNode.isParameter()) {
					mapOldTypes.put(paramName, paramNode.getType());
					if(paramName.equalsIgnoreCase("varargin")) //Force varargin to be type ObjectArray
						paramNode.setType(Type.getType(ObjectArray.class));
					else
						paramNode.setType(newTypes[i]);
					paramNode.setOptional(false);
				} else {
					throw new RuntimeException("Parameter " + paramNode.toString() + " of " + this.name + 
							" is not marked as parameter type!");
				}
			}
		}
		
		if(null == stack) {
			stack = new LinkedList<Object>();
		}
		fixBodyExprTypes(stack);
		
		return mapOldTypes;
	}

	/**
	 * @param paramTypes
	 * @return old types
	 */
	public Map<String, Type> setParamTypes(Deque<Object> stack, Class<?>[] paramClassTypes) {
		Type[] paramTypes = new Type[paramClassTypes.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = Type.getType(paramClassTypes[i]);
		}
		return this.setParamTypes(stack, paramTypes);
	}

	public static void main(String[] args) {
		// Map<String, Type> test = new TreeMap<String, Type>();
		Map<String, Type> test = new LinkedHashMap<String, Type>();
		test.put("x", Type.DOUBLE_TYPE);
		test.put("a", Type.DOUBLE_TYPE);
		test.put("y", Type.DOUBLE_TYPE);
		for (Entry<String, Type> e : test.entrySet()) {
			System.out.println(e.getKey());
		}
	}

	//Bugfix: add stack for 'e.getValue().getType(stack)' to 
	//prevent stack overflow
	public Map<String, Type> setParamTypes(Deque<Object> stack, Map<String, Type> types) {
		if (this.paramNames.size() < types.size()) {
			throw new RuntimeException("Too many parameters for function "+this.name+"!");
		}
		for (String paramName : this.paramNames) {
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if (paramNode.isParameter()) {
				paramNode.setOptional(true);
			}
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for(Entry<String, Type> e : types.entrySet()) {
			VariableNode var = this.funcVarMap.get(e.getKey());
			if(var.isParameter()) {
				oldType.put(e.getKey(), var.getType(stack));
				var.setType(e.getValue());
				var.setOptional(false);
			} else {
				throw new RuntimeException(e.getKey()+" is not a parameter of function "+this.name);
			}
		}
		fixBodyExprTypes(stack);
		return oldType;
	}

//	public Type inferRetType(Class<?>[] paramClassTypes) {
//		Deque<Object> stack = new LinkedList<Object>();
//		Type[] paramTypes = new Type[paramClassTypes.length];
//		for (int i = 0; i < paramTypes.length; i++) {
//			paramTypes[i] = Type.getType(paramClassTypes[i]);
//		}
//		Type retType = inferRetType(stack, paramTypes);
//		return retType;
//	}

	public Type inferRetType() {
		Deque<Object> stack = new LinkedList<Object>();
		Type retType = inferRetType(stack);
		return retType;
	}

	public Type inferRetType(Deque<Object> stack) {
		// circle check
		if (stack.contains(this))
			return null;
		stack.push(this);

		if(null != this.retExpr) {
			Type retType = this.retExpr.getType();
			if(null != retType) {
				stack.pop();
				return retType;
			}
		}
		Type retType = body.getType(stack);
		if (null != retType) {
			stack.pop();
			return retType;
		}
		//null indicate that we cannot infer return type
		//changed to void type. null indicate the type of an expression is not specified
		//
		return Type.VOID_TYPE; 
	}

	//TODO clear the comments
	//this is introduced by fixing AssignNode 
	public void fixBodyExprTypes(Deque<Object> stack) {
		// The type fix is based on localVarMap
		// for AssignNode
		this.body.updateType(stack);
		if(null != this.retExpr)
			this.retExpr.updateType(stack);
	}

	public Type[] getParameterTypes(boolean includeOptional) {
		List<Type> ret = new ArrayList<Type>();
		for (int i = 0; i < this.paramNames.size(); i++) {
			VariableNode var = this.funcVarMap.get(this.paramNames.get(i));
			if(includeOptional) {
				ret.add(var.getType());
			} else if(!var.isOptional()){
				ret.add(var.getType());
			}
		}
		return ret.toArray(new Type[0]);
	}

	public String getFuncClassName() {
		String ret = "FC" + name + seq.get();// TODO need better naming way
		return ret;
	}

	public Class<?> genFuncCode(boolean writeFile) {
		// System.out.println(this.toString());
		try {
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			CodeGenerator cgen = new CodeGenerator();

			String className = getFuncClassName();
			cgen.startClass(className, null);

			MethodGenHelper mg = new MethodGenHelper(funcVarMap);
			this.updateTree(mg);
			
			// Define method
			int access = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;

			Type retType = this.inferRetType();

			Type[] paramTypes = this.getParameterTypes(false);
			String methodDesc = Type.getMethodDescriptor(retType, paramTypes);
			cgen.startMethod(access, name, methodDesc);
			MethodVisitor mv = cgen.getMV();
			mg.setMethodVisitor(mv);
			mg.initLVTIndex(true);
			cgen.startCode();
			this.generatedClasses.put(methodDesc, className);

			//Initialize local variables
			for(VariableNode var : this.funcVarMap.values()) {
				if(var.isParameter() && !var.isOptional()) continue;
				for(String typeDesc : var.getVarTypes()) {
					Type ty = Type.getType(typeDesc);
					switch(ty.getSort()) {
					case Type.INT:
						mg.visitInsn(Opcodes.ICONST_0);
						break;
					case Type.LONG:
						mg.visitInsn(Opcodes.LCONST_0);
						break;
					case Type.DOUBLE:
						mg.visitInsn(Opcodes.DCONST_0);
						break;
					case Type.FLOAT:
						mg.visitInsn(Opcodes.FCONST_0);
						break;
					case Type.BOOLEAN:
						mv.visitInsn(Opcodes.ACONST_NULL);
						mg.visitLdcInsn(false);
						break;
					case Type.SHORT:
						mg.visitLdcInsn(0);
						break;
					case Type.ARRAY:
					case Type.OBJECT:
						mv.visitInsn(Opcodes.ACONST_NULL);
						break;
					default:
						throw new RuntimeException();
					}
					mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), var.getLVTIndex(typeDesc));
				}
			}
			//initialize varargout
			VariableNode varargout = this.funcVarMap.get("varargout");
			if(null != varargout) {
				Type ty = varargout.getType();
				mg.visitTypeInsn(Opcodes.NEW, "io/lambdacloud/util/ObjectArray");
				mg.visitInsn(Opcodes.DUP);
				mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "io/lambdacloud/util/ObjectArray", "<init>", "()V", false);
				mg.visitIntInsn(ty.getOpcode(Opcodes.ISTORE), varargout.getLVTIndex(ty));
			}

			
			// Generate code for all the expressions
			int lowBound = 0;
			if(null == this.retExpr) {
				if(this.body.exprs.size() > 0)
					this.retExpr = this.body.exprs.get(0);
				lowBound = 1;
			}
			for (int i = this.body.exprs.size() - 1; i >= lowBound; i--) {
				ExprNode expr = this.body.exprs.get(i);
				expr.genCode(mg);
			}
			
			//Generate return expression from the last expression
			if(null != this.retExpr) {
				ExprNode retExpr = this.retExpr;
				if(retExpr instanceof ReturnNode) {
					retExpr.genCode(mg);
				} else {
					if(retExpr instanceof AddAsignNode ||
							retExpr instanceof SubAsignNode ||
							retExpr instanceof MulAsignNode ||
							retExpr instanceof DivAsignNode ||
							retExpr instanceof IncNode ||
							retExpr instanceof DescNode ||
							retExpr instanceof AssignNode
							) {
						retExpr.genLoadInsn(true);
					}
					retExpr.genCode(mg);
					mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
				}
			} else {
				mg.visitInsn(Opcodes.RETURN);
			}
			
			//Generate local variable table
			List<VariableNode> nodeList = new ArrayList<VariableNode>();
			nodeList.addAll(funcVarMap.values());
			//Sort variables by LVT index
			Collections.sort(nodeList, new Comparator<VariableNode>() {
				@Override
				public int compare(VariableNode o1, VariableNode o2) {
					return o1.getLVTIndex() - o2.getLVTIndex();
				}
			});
			for(VariableNode var : nodeList) {
				ArrayList<String> varTypes = var.getVarTypes();
				for(String typeDesc : varTypes) {
					mg.visitLocalVariable(var.getName(typeDesc), typeDesc,
							null, cgen.labelStart, cgen.lableEnd, var.getLVTIndex(typeDesc));
				}
			}

			mg.visitMaxs(-1, -1); // Auto generated
			cgen.endCode();
			cgen.endClass();

			byte[] bcode = cgen.dump();
			if (writeFile) {
				FileOutputStream fos = new FileOutputStream(className + ".class");
				fos.write(bcode);
				fos.close();
			}

			Class<?> c = mcl.defineClassForName(null, bcode);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		throw new UnsupportedOperationException("Call genFuncCode() instead!");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("def ").append(name + "(");
		for (Entry<String, VariableNode> e : funcVarMap.entrySet()) {
			sb.append(e.getValue()).append(", ");
		}
		sb.append(") {\n");
		for (int i = this.body.exprs.size() - 1; i >= 0; i--)
			sb.append(this.body.exprs.get(i).toString()).append("\n");
		if(null != this.retExpr)
			sb.append(this.retExpr).append("\n");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public Type getType() {
		Type[] paramTypes = this.getParameterTypes(true);
		return Type.getMethodType(this.inferRetType(), paramTypes);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//Do nothing
	}
	
	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		if(this.body.contains(target))
			return true;
		if(null != this.retExpr)
			if(this.retExpr.contains(target))
				return true;
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		this.body.replaceChild(oldNode, newNode);
		if(null != this.retExpr)
			this.retExpr.replaceChild(oldNode, newNode);
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		this.body.updateTree(mg);
		if(null != this.retExpr) {
			this.retExpr.updateTree(mg);
		}
	}

	@Override
	public void updateParam(String name, Object value) {
		this.body.updateParam(name, value);
		if(null != this.retExpr)
			this.retExpr.updateParam(name, value);
	}
}
