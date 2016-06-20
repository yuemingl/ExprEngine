package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

public class ArrayNode extends ExprNode {
	public List<ExprNode> init = new ArrayList<ExprNode>();
	
	public void addInitValues(ExprNode val) {
		init.add(val);
	}
	
	public int[] test() {
		int[] a = {1,2,3};
		return a;
	}

	@Override
	public void genCode(MethodVisitor mv) {
		mv.visitLdcInsn(init.size());
		mv.visitIntInsn(NEWARRAY, T_INT);
		int idx = 0;
		for(int i=init.size()-1; i>=0; i--) {
			mv.visitInsn(DUP);
			mv.visitLdcInsn(idx++);
			init.get(i).genCode(mv);
			mv.visitInsn(IASTORE);
		}
	}
	@Override
	public Type getType() {
		return Type.getType(int[].class);
	}	
}
