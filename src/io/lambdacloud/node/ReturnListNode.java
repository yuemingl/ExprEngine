package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.util.CSList;
import io.lambdacloud.util.ObjectArray;
import io.lambdacloud.util.ObjectArrayConstructor;

public class ReturnListNode extends ExprNode {
	public List<ExprNode> initExprList = new ArrayList<ExprNode>();

	public static void test() {
		Integer a = 1;
		Double b = 1.0;
		ObjectArray c = new ObjectArray();
		ObjectArrayConstructor ct = new ObjectArrayConstructor();
		ct.add(a);
		ct.add(b);
		ct.add(c);
		ct.getCSList();
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(ObjectArrayConstructor.class));
		mg.visitInsn(DUP);
		mg.visitMethodInsn(INVOKESPECIAL, "io/lambdacloud/util/ObjectArrayConstructor", "<init>", "()V", false);
		mg.visitInsn(DUP);

		for (int i = initExprList.size() - 1; i >= 0; i--) {
			if(null == this.initExprList.get(i).getType()) continue;
			initExprList.get(i).genCode(mg);
			Type eleType = initExprList.get(i).getType();
			if(eleType.equals(Type.getType(ObjectArray.class))) {
				mg.visitMethodInsn(INVOKEVIRTUAL, "io/lambdacloud/util/ObjectArrayConstructor", 
						"add", "("+eleType.getDescriptor()+")Lio/lambdacloud/util/ObjectArrayConstructor;", false);
			} else {
				Tools.insertConversionInsn(mg, eleType, Type.getType(Object.class));
				mg.visitMethodInsn(INVOKEVIRTUAL, "io/lambdacloud/util/ObjectArrayConstructor", 
						"add", "("+Type.getType(Object.class)+")Lio/lambdacloud/util/ObjectArrayConstructor;", false);
			}
		}
		mg.visitInsn(POP);
		mg.visitMethodInsn(INVOKEVIRTUAL, "io/lambdacloud/util/ObjectArrayConstructor", 
				"getCSList", "()Lio/lambdacloud/util/CSList;", false);
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//return Type.getType(Object[].class);
		return Type.getType(CSList.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(ExprNode target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateParam(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

}
