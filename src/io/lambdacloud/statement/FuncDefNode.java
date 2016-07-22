package io.lambdacloud.statement;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
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
import java.util.SortedMap;
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
	public Map<String, VariableNode> funcVarMap = new TreeMap<String, VariableNode>();

	public ArrayList<ExprNode> body = new ArrayList<ExprNode>();
	
	public static AtomicInteger seq = new AtomicInteger(0);
	
	//Map between methodDescriptor => className
	public Map<String, String> generatedClasses = new HashMap<String, String>();
	//Parameter name declared
	public List<String> paramNames = new ArrayList<String>();

	public FuncDefNode(String name) {
		this.name = name;
		seq.getAndIncrement();
	}

	/**
	 * @param paramClassTypes
	 * @return old types
	 */
	public Map<String, Type> setParamTypes(Class<?>[] paramClassTypes) {
		if(this.paramNames.size() != paramClassTypes.length) {
			throw new RuntimeException("Wrong parameter types!");
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for(int i=0; i<this.paramNames.size();i ++) {
			String paramName = this.paramNames.get(i);
			VariableNode paramNode = this.funcVarMap.get(paramName);
			if(paramNode.isParameter()) {
				oldType.put(paramName, paramNode.getType());
				paramNode.setType(Type.getType(paramClassTypes[i]));
			} else {
				throw new RuntimeException(
						"Parameter "+paramNode.toString()+" of "+this.name+" is not marked as parameter type!");
			}
		}
		fixBodyExprTypes();
		return oldType;
	}
	
	public static void main(String[] args) {
		//Map<String, Type> test = new TreeMap<String, Type>();
		Map<String, Type> test = new LinkedHashMap<String, Type>();
		test.put("x", Type.DOUBLE_TYPE);
		test.put("a", Type.DOUBLE_TYPE);
		test.put("y", Type.DOUBLE_TYPE);
		for(Entry<String, Type> e : test.entrySet()) {
			System.out.println(e.getKey());
		}
	}
	
	public Map<String, Type> setParamTypes(Map<String, Type> types) {
		if(this.paramNames.size() != types.size()) {
			throw new RuntimeException("Wrong parameter types: "+types.toString());
		}
		Map<String, Type> oldType = new TreeMap<String, Type>();
		for(Entry<String, VariableNode> e : funcVarMap.entrySet()) {
			if(e.getValue().isParameter()) { //check this flag too
				oldType.put(e.getKey(), e.getValue().getType());
				e.getValue().setType(types.get(e.getKey()));
			}
		}
		fixBodyExprTypes();
		return oldType;
	}
	
	public Type inferRetType(Class<?>[] paramClassTypes) {
		Deque<Object> stack = new LinkedList<Object>();
		Type retType = inferRetType(stack, paramClassTypes);
		return retType;
	}
	
	public Type inferRetType(Deque<Object> stack, Class<?>[] paramClassTypes) {
		//circle check
		if(stack.contains(this)) 
			return null;
		stack.push(this);
		
		Map<String, Type> oldType = this.setParamTypes(paramClassTypes);
		//getAndFixParameterTypes(stack);
		
		for(int i=0; i<this.body.size(); i++) {
			ExprNode node = this.body.get(i);
			Type retType = node.getType(stack);
			if(null != retType) {
				
				stack.pop();
				
				this.setParamTypes(oldType);
				//getAndFixParameterTypes(stack);

				return retType;
			}
		}
		throw new RuntimeException("Cannot infer return type!");
	}
	
	public void fixBodyExprTypes() {
		//The type fix is based on localVarMap
		//for AssignNode
		for (int j = this.body.size()-1; j >= 0; j--) {
			this.body.get(j).fixType();
		}
	}
	
	public Type[] getParameterTypes() {
		Deque<Object> stack = new LinkedList<Object>();
		return getParameterTypes(stack);
	}
	
	//TODO Do we need stack here?
	public Type[] getParameterTypes(Deque<Object> stack) {
		List<VariableNode> pList = new ArrayList<VariableNode>();

		for (Entry<String, VariableNode> e : this.funcVarMap.entrySet()) {
			if (e.getValue().isParameter())
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
		for (VariableNode node : pList) {
			ret[i] = funcVarMap.get(node.name).getType(stack);
			i++;
		}
		
		return ret;
	}

	public String getFuncClassName() {
		String ret = "FC"+name+this.seq.get();//TODO need better naming way
		return ret;
	}
	
	public Class<?> genFuncCode(boolean writeFile) {
		//System.out.println(this.toString());
		try {
			ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
			CodeGenerator cgen = new CodeGenerator();
			
			String className = getFuncClassName();
			cgen.startClass(className, null);

			// Define method
			int access = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;

			Type[] paramTypes = getAndFixParameterTypes();
			Type retType = this.inferRetType();

			String methodDesc = Type.getMethodDescriptor(retType, paramTypes);
			cgen.startMethod(access, name, methodDesc);
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, funcVarMap);
			mg.updateLVTIndex(true);
			cgen.startCode();
			this.generatedClasses.put(methodDesc, className);
			
			// Generate code for all the expressions
			for (int i = this.body.size()-1; i >= 0; i--) {
				ExprNode expr = this.body.get(i);
				expr.genCode(mg);
			}

			mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			for (VariableNode var : funcVarMap.values()) {
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
		return Type.getMethodType(this.inferRetType(), this.getAndFixParameterTypes());
	}

	@Override
	public Type getType(Deque<Object> stack) {
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}
}
