package io.lambdacloud.statement;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

import static org.objectweb.asm.Opcodes.*;

/**
 * Array initialize, for example:
 * [1,2,3]
 *
 */
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
		
		Type eleType = init.get(0).getType();
		
		mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(eleType, false));
		int idx = 0;
		for(int i=init.size()-1; i>=0; i--) {
			mg.visitInsn(DUP);
			mg.visitLdcInsn(idx++);
			init.get(i).genCode(mg);
			Tools.insertConversionInsn(mg, init.get(i).getType(), eleType);
			mg.visitInsn(eleType.getOpcode(IASTORE));
		}
	}
	@Override
	public Type getType() {
		return Type.getType(int[].class);
	}	
}
