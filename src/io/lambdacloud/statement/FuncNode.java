package io.lambdacloud.statement;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
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

public class FuncNode extends ExprNode {
	public String name;
	public Map<String, VariableNode> localVarMap = new TreeMap<String, VariableNode>();

	public ArrayList<ExprNode> body = new ArrayList<ExprNode>();
	
	public static AtomicInteger seq = new AtomicInteger(0);
	
	public FuncNode(String name) {
		this.name = name;
		seq.getAndIncrement();
	}

	public void setParamTypes(Class<?>[] cls) {
		int i=0;
		for(Entry<String, VariableNode> e : localVarMap.entrySet()) {
			if(e.getValue().isParameter())
				e.getValue().setType(Type.getType(cls[i++]));
		}
	}
	public Type getRetType() {
		Deque<Object> stack = new LinkedList<Object>();
		return getRetType(stack);
	}
	
	public Type getRetType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) return null;
		stack.push(this);
		
		getAndFixParameterTypes(stack);
		for(int i=0; i<this.body.size(); i++) {
			ExprNode node = this.body.get(i);
			Type retType = node.getType(stack);
			if(null != retType) {
				stack.pop();
				return retType;
			}
		}
		throw new RuntimeException("Cannot infer return type!");
	}
	
	public Type[] getAndFixParameterTypes() {
		Deque<Object> stack = new LinkedList<Object>();
		return getAndFixParameterTypes(stack);
	}
	
	public Type[] getAndFixParameterTypes(Deque<Object> stack) {
		List<VariableNode> pList = new ArrayList<VariableNode>();

		for (Entry<String, VariableNode> e : this.localVarMap.entrySet()) {
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
			ret[i] = localVarMap.get(node.name).getType(stack);
			i++;
		}
		
		for (int j = this.body.size()-1; j >= 0; j--) {
			this.body.get(j).fixType();
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
			Type retType = this.getRetType();

			cgen.startMethod(access, name, Type.getMethodDescriptor(retType, paramTypes));
			MethodVisitor mv = cgen.getMV();
			MethodGenHelper mg = new MethodGenHelper(mv, localVarMap);
			mg.updateLVTIndex(true);
			cgen.startCode();
			
			// Generate code for all the expressions
			for (int i = this.body.size()-1; i >= 0; i--) {
				ExprNode expr = this.body.get(i);
				expr.genCode(mg);
			}

			mg.visitInsn(retType.getOpcode(Opcodes.IRETURN));
			for (VariableNode var : localVarMap.values()) {
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

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("def ").append(name + "(");
		for (Entry<String, VariableNode> e : localVarMap.entrySet()) {
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
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}

	@Override
	public Type getType(Deque<Object> stack) {
		throw new UnsupportedOperationException("Call getRetType() instead!");
	}
}
