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

public class FuncDefNode extends ExprNode {
	public String name;
	//public Map<String, VariableNode> funcVarMap = new TreeMap<String, VariableNode>();
	public Map<String, VariableNode> funcVarMap = new LinkedHashMap<String, VariableNode>();

	public ArrayList<ExprNode> body = new ArrayList<ExprNode>();

	public static AtomicInteger seq = new AtomicInteger(0);

	// Map between methodDescriptor => className
	public Map<String, String> generatedClasses = new HashMap<String, String>();
	// Parameter name declared
	public List<String> paramNames = new ArrayList<String>();

	public FuncDefNode(String name) {
		this.name = name;
		seq.getAndIncrement();
	}

	public Map<String, Type> setParamTypes(Type[] paramTypes) {
		if (this.paramNames.size() != paramTypes.length) {
			throw new RuntimeException("Wrong parameter types!");
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for (int i = 0; i < this.paramNames.size(); i++) {
			String paramName = this.paramNames.get(i);
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if (paramNode.isParameter()) {
				oldType.put(paramName, paramNode.getType());
				paramNode.setType(paramTypes[i]);
			} else {
				throw new RuntimeException(
						"Parameter " + paramNode.toString() + " of " + this.name + " is not marked as parameter type!");
			}
		}
		fixBodyExprTypes();
		return oldType;

	}

	/**
	 * @param paramTypes
	 * @return old types
	 */
	public Map<String, Type> setParamTypes(Class<?>[] paramClassTypes) {
		Type[] paramTypes = new Type[paramClassTypes.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = Type.getType(paramClassTypes[i]);
		}
		return this.setParamTypes(paramTypes);
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
		if (this.paramNames.size() != types.size()) {
			throw new RuntimeException("Wrong parameter types: " + types.toString());
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for (Entry<String, VariableNode> e : funcVarMap.entrySet()) {
			if (e.getValue().isParameter()) { // check this flag too
				oldType.put(e.getKey(), e.getValue().getType(stack));
				e.getValue().setType(types.get(e.getKey()));
			}
		}
		fixBodyExprTypes();
		return oldType;
	}

	public Type inferRetType(Class<?>[] paramClassTypes) {
		Deque<Object> stack = new LinkedList<Object>();
		Type[] paramTypes = new Type[paramClassTypes.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = Type.getType(paramClassTypes[i]);
		}
		Type retType = inferRetType(stack, paramTypes);
		return retType;
	}

	public Type inferRetType(Type[] paramClassTypes) {
		Deque<Object> stack = new LinkedList<Object>();
		Type retType = inferRetType(stack, paramClassTypes);
		return retType;
	}

	public Type inferRetType(Deque<Object> stack, Type[] paramClassTypes) {
		// circle check
		if (stack.contains(this))
			return null;
		stack.push(this);

		Map<String, Type> oldType = this.setParamTypes(paramClassTypes);
		// getAndFixParameterTypes(stack);

		for (int i = 0; i < this.body.size(); i++) {
			ExprNode node = this.body.get(i);
			Type retType = node.getType(stack);
			if (null != retType) {

				stack.pop();

				this.setParamTypes(stack, oldType);
				// getAndFixParameterTypes(stack);

				return retType;
			}
		}
		return null; //null indicate that we cannot infer return type
		//throw new RuntimeException("Cannot infer return type!");
	}

	//this is introduced by fixing AssignNode 
	public void fixBodyExprTypes() {
		//
//		// The type fix is based on localVarMap
//		// for AssignNode
//		for (int j = this.body.size() - 1; j >= 0; j--) {
//			this.body.get(j).fixType();
//		}
	}

	public Type[] getParameterTypes() {
		Type[] ret = new Type[this.paramNames.size()];
		for (int i = 0; i < this.paramNames.size(); i++)
			ret[i] = this.funcVarMap.get(this.paramNames.get(i)).getType();
		return ret;
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

			Type[] paramTypes = this.getParameterTypes();
			Type retType = this.inferRetType(paramTypes);

			String methodDesc = Type.getMethodDescriptor(retType, paramTypes);
			cgen.startMethod(access, name, methodDesc);
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, funcVarMap);
			mg.updateLVTIndex(true);
			cgen.startCode();
			this.generatedClasses.put(methodDesc, className);

			// Generate code for all the expressions
			for (int i = this.body.size() - 1; i >= 0; i--) {
				ExprNode expr = this.body.get(i);
				expr.genCode(mg);
			}

			mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			List<VariableNode> nodeList = new ArrayList<VariableNode>();
			nodeList.addAll(funcVarMap.values());
			Collections.sort(nodeList, new Comparator<VariableNode>() {
				@Override
				public int compare(VariableNode o1, VariableNode o2) {
					return o1.idxLVT - o2.idxLVT;
				}
			});
			for (VariableNode var : nodeList) {
				mg.visitLocalVariable(var.name, var.getType().getDescriptor(), null, cgen.labelStart, cgen.lableEnd,
						var.idxLVT);
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
		Type[] paramTypes = this.getParameterTypes();
		return Type.getMethodType(this.inferRetType(paramTypes), paramTypes);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}

	@Override
	public void fixType(Deque<Object> stack) {
		//Do nothing
	}
}
