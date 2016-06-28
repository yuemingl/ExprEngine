package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class FuncCallNode extends ExprNode {
	String owner;
	String name;
	public List<ExprNode> args = new ArrayList<ExprNode>();
	public FuncCallNode(String className, String methodName) {
		this.owner = className;
		this.name = methodName;
	}
	
	public String toString() {
		return "";
	}
	
	public void genCode(MethodVisitor mv) {
		for(int i=args.size()-1 ; i>=0; i--) {
			args.get(i).genCode(mv);
		}
		mv.visitMethodInsn(INVOKESTATIC, "java/lang/Math", "abs", "(D)D", false);
	}
	
	@Override
	public Type getType() {
		return Type.getType(double.class);
	}
	
	public double test(double x) {
		return Math.abs(x);
	}
}
