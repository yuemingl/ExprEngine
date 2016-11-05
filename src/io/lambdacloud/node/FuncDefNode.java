package io.lambdacloud.node;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
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

public class FuncDefNode extends ExprNode {
	public String name;
	//public Map<String, VariableNode> funcVarMap = new TreeMap<String, VariableNode>();
	public Map<String, VariableNode> funcVarMap = new LinkedHashMap<String, VariableNode>();

	public ArrayList<ExprNode> body = new ArrayList<ExprNode>();
	/**
	 * Keep the return expression in the declaration of a function
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

	public Map<String, Type> setParamTypes(Deque<Object> stack, Type[] paramTypes) {
		if (this.paramNames.size() < paramTypes.length) {
			throw new RuntimeException("Too many parameters for function "+this.name+"!");
		}
		for (String paramName : this.paramNames) {
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if (paramNode.isParameter()) {
				paramNode.setOptional(true);
			}
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for (int i = 0; i < paramTypes.length; i++) {
			String paramName = this.paramNames.get(i);
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if (paramNode.isParameter()) {
				oldType.put(paramName, paramNode.getType());
				paramNode.setType(paramTypes[i]);
				paramNode.setOptional(false);
			} else {
				throw new RuntimeException(
						"Parameter " + paramNode.toString() + " of " + this.name + " is not marked as parameter type!");
			}
		}
		
		if(null == stack) {
			stack = new LinkedList<Object>();
		}
		fixBodyExprTypes(stack);
		return oldType;

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

		for (int i = 0; i < this.body.size(); i++) {
			ExprNode node = this.body.get(i);
			Type retType = node.getType(stack);
			if (null != retType) {
				stack.pop();
				return retType;
			}
		}
		//null indicate that we cannot infer return type
		//changed to void type. null indicate the type of an expression is not specified
		//
		return Type.VOID_TYPE; 
	}

	//this is introduced by fixing AssignNode 
	public void fixBodyExprTypes(Deque<Object> stack) {
		//
		// The type fix is based on localVarMap
		// for AssignNode
		for (int j = this.body.size() - 1; j >= 0; j--) {
			this.body.get(j).updateType(stack);
		}
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
		String ret = "FC" + name + this.seq.get();// TODO need better naming way
		return ret;
	}

	public Class<?> genFuncCode(boolean writeFile) {
		// System.out.println(this.toString());
		try {
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			CodeGenerator cgen = new CodeGenerator();

			String className = getFuncClassName();
			cgen.startClass(className, null);

			// Define method
			int access = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;

			Type retType = this.inferRetType();

			Type[] paramTypes = this.getParameterTypes(false);
			String methodDesc = Type.getMethodDescriptor(retType, paramTypes);
			cgen.startMethod(access, name, methodDesc);
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, funcVarMap);
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
			
			// Generate code for all the expressions
			for (int i = this.body.size() - 1; i >= 1; i--) {
				ExprNode expr = this.body.get(i);
				expr.genCode(mg);
			}
			if(this.body.size() > 0) {
				ExprNode lastExpr = this.body.get(0);
				if(lastExpr instanceof ReturnNode) {
					lastExpr.genCode(mg);
				} else {
					if(lastExpr instanceof AddAsignNode ||
							lastExpr instanceof SubAsignNode ||
							lastExpr instanceof MulAsignNode ||
							lastExpr instanceof DivAsignNode ||
							lastExpr instanceof IncNode ||
							lastExpr instanceof DescNode ||
							lastExpr instanceof AssignNode
							) {
						lastExpr.genLoadInsn(true);
					}
					lastExpr.genCode(mg);
					mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
				}
			} else {
				mg.visitInsn(Opcodes.RETURN);
			}
			
			//Generate local variabel table
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
	public void genCode(MethodGenHelper mg) {
		throw new UnsupportedOperationException("Call genFuncCode() instead!");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("def ").append(name + "(");
		for (Entry<String, VariableNode> e : funcVarMap.entrySet()) {
			sb.append(e.getValue()).append(", ");
		}
		sb.append(") {\n");
		for (int i = body.size() - 1; i >= 0; i--)
			sb.append(body.get(i).toString()).append("\n");
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
	
	public static void test(int a, int b) {
		Jama.Matrix m = null;
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		for(ExprNode e : this.body) {
			if(e.contains(target))
				return true;
		}
		return false;
	}
}
