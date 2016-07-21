package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.ExprTreeBuildWalker;
import io.lambdacloud.MethodGenHelper;

public class FuncCallNode extends ExprNode {
	String fullClassName;
	String methodName;
	public List<ExprNode> args = new ArrayList<ExprNode>();
	
	public boolean isDynamicCall; //true to use invodedynamic instruction
	
	public FuncNode refFuncNode;

	public FuncCallNode(String fullClassName, String methodName, boolean isDynamicCall) {
		this.fullClassName = fullClassName;
		this.methodName = methodName;
		this.isDynamicCall = isDynamicCall;
	}

	public String getFullClassName() {
		if(null != refFuncNode)
			return this.refFuncNode.getFuncClassName();
		else
			return this.fullClassName;
	}
	
	public String getMethodName() {
		if(null != this.refFuncNode)
			return this.refFuncNode.name;
		else
			return this.methodName;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("call ").append(this.fullClassName).append(".").append(this.methodName).append("(");
		for (int i = args.size() - 1; i >= 0; i--) {
			sb.append(args.get(i)).append(", ");
		}
		sb.append(")");
		return sb.toString();
	}

	public Class<?>[] getParameterClassTypes() {
		Class<?>[] ret = new Class<?>[args.size()];
		for (int i = args.size() - 1; i >= 0; i--) {
			ret[args.size() - 1 - i] = Tools.typeToClass(args.get(i).getType());
		}
		return ret;
	}

	public Type[] getParameterTypes() {
		Type[] ret = new Type[args.size()];
		for (int i = args.size() - 1; i >= 0; i--) {
			ret[args.size() - 1 - i] = args.get(i).getType();
		}
		return ret;
	}

	public void genCode(MethodGenHelper mg) {

		if (isDynamicCall) { //ExprTreeBuildWalker.funcMap must contain the key this.methodName
			MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
					MethodType.class);

			Handle bootstrapHandle = new Handle(Opcodes.H_INVOKESTATIC, "io/lambdacloud/ExprTreeBuildWalker",
					"bootstrap", mt.toMethodDescriptorString());
			for (int i = args.size() - 1; i >= 0; i--) {
				args.get(i).genCode(mg);
			}
			mg.visitInvokeDynamicInsn(this.methodName,
					Type.getMethodDescriptor(this.getType(), this.getParameterTypes()), bootstrapHandle, new Object[0]);
		} else { // 
			FuncNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			if(fnode == null) {
				//Find return type
				Class<?> c;
				try {
					c = Class.forName(fullClassName);
					Method m = c.getMethod(methodName, this.getParameterClassTypes());
					for (int i = args.size() - 1; i >= 0; i--) {
						args.get(i).genCode(mg);
					}
					mg.visitMethodInsn(INVOKESTATIC, fullClassName.replaceAll("\\.", "/"), methodName,
							Type.getMethodDescriptor(m), false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Type retTy = fnode.getRetType();
				for (int i = args.size() - 1; i >= 0; i--) {
					args.get(i).genCode(mg);
				}
				mg.visitMethodInsn(INVOKESTATIC, fullClassName.replaceAll("\\.", "/"), methodName,
						Type.getMethodDescriptor(retTy, this.getParameterTypes()), false);
			}
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return null;
		stack.push(this);
		
		if (isDynamicCall) {
			FuncNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			fnode.setParamTypes(this.getParameterClassTypes());
			Type retType = fnode.getRetType(stack);
			stack.pop();
			return retType;
		} else {
			FuncNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			if(fnode == null) {
				Class<?> c;
				try {
					c = Class.forName(fullClassName);
					Method m = c.getMethod(methodName, this.getParameterClassTypes());
					Type retType = Type.getType(m.getReturnType());
					stack.pop();
					return retType;
				} catch (Exception e) {
					e.printStackTrace();
				}
				stack.pop();
				return null;
			} else {
				Type retType = fnode.getRetType(stack);
				stack.pop();
				return retType;
			}
		}
	}
	
	public double test(double x) {
		return Math.abs(x);
	}
}
