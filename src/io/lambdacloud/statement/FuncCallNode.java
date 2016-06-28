package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class FuncCallNode extends ExprNode {
	String fullClassName;
	String methodName;
	public List<ExprNode> args = new ArrayList<ExprNode>();
	
	public FuncCallNode(String fullClassName, String methodName) {
		this.fullClassName = fullClassName;
		this.methodName = methodName;
	}
	
	public String toString() {
		return "";
	}
	
	public Class<?>[] getParameterTypes() {
		Class<?>[] ret = new Class<?>[args.size()];
		for(int i=0; i<ret.length; i++) {
			ret[i] = Tools.typeToClass(args.get(i).getType());
		}
		return ret;
	}
	
	public void genCode(MethodVisitor mv) {
		Class<?> c;
		try {
			c = Class.forName(fullClassName);
			Method m = c.getMethod(methodName, this.getParameterTypes());
			for(int i=args.size()-1 ; i>=0; i--) {
				args.get(i).genCode(mv);
			}
			mv.visitMethodInsn(INVOKESTATIC, fullClassName.replaceAll("\\.", "/"), methodName, Type.getMethodDescriptor(m), false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Type getType() {
		return Type.getType(double.class);
	}
	
	public double test(double x) {
		return Math.abs(x);
	}
}
