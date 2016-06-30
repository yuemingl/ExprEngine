package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

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
	public void genCode(MethodGenHelper mg) {
		mg.visitLdcInsn(init.size());
		mg.visitIntInsn(NEWARRAY, T_INT);//TODO type???
		int idx = 0;
		for(int i=init.size()-1; i>=0; i--) {
			mg.visitInsn(DUP);
			mg.visitLdcInsn(idx++);
			init.get(i).genCode(mg);
			mg.visitInsn(IASTORE);
		}
	}
	@Override
	public Type getType() {
		return Type.getType(int[].class);
	}	
}
