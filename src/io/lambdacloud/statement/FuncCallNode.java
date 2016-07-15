package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
	public boolean isDynamicCall;

	public FuncCallNode(String fullClassName, String methodName, boolean isDynamicCall) {
		this.fullClassName = fullClassName;
		this.methodName = methodName;
		this.isDynamicCall = isDynamicCall;
	}

	public String toString() {
		return "";
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

		if (isDynamicCall) {
			MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
					MethodType.class);

			Handle bootstrapHandle = new Handle(Opcodes.H_INVOKESTATIC, "io/lambdacloud/ExprTreeBuildWalker",
					"bootstrap", mt.toMethodDescriptorString());
			for (int i = args.size() - 1; i >= 0; i--) {
				args.get(i).genCode(mg);
			}
			mg.visitInvokeDynamicInsn(this.methodName,
					Type.getMethodDescriptor(this.getType(), this.getParameterTypes()), bootstrapHandle, new Object[0]);
		} else {
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
		}
	}

	@Override
	public Type getType() {
		if (isDynamicCall) {
			FuncNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			fnode.setParamTypes(this.getParameterClassTypes());
			return fnode.getRetType();
		} else {
			Class<?> c;
			try {
				c = Class.forName(fullClassName);
				Method m = c.getMethod(methodName, this.getParameterClassTypes());
				return Type.getType(m.getReturnType());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public double test(double x) {
		return Math.abs(x);
	}
}
