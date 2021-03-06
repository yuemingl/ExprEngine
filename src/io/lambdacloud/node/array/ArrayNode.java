package io.lambdacloud.node.array;

import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.IASTORE;
import static org.objectweb.asm.Opcodes.NEWARRAY;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;

/**
 * Array initialize, for example: [1,2,3]
 *
 */
public class ArrayNode extends ExprNode {
	public List<ExprNode> init = new ArrayList<ExprNode>();

	public void addInitValues(ExprNode val) {
		init.add(val);
	}

	public int[] test() {
		int[] a = { 1, 2, 3 };
		return a;
	}

	@Override
	public void _genCode(MethodGenHelper mg) {
		mg.visitLdcInsn(init.size());

		Type eleType = init.get(0).getType();
		if (init.size() > 1) {
			for (int i = 1; i < init.size(); i++)
				eleType = Tools.typeConversion(eleType, init.get(i).getType());
		}
		if (eleType.getSort() == Type.OBJECT || eleType.getSort() == Type.ARRAY) {
			mg.visitTypeInsn(ANEWARRAY, eleType.getInternalName());
		} else {
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(eleType, false));
		}
		int idx = 0;
		for (int i = init.size() - 1; i >= 0; i--) {
			mg.visitInsn(DUP);
			mg.visitLdcInsn(idx++);
			init.get(i).genCode(mg);
			Tools.insertConversionInsn(mg, init.get(i).getType(), eleType);
			mg.visitInsn(eleType.getOpcode(IASTORE));
		}
	}

	public String toString() {
		return this.init.toString();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		// circle check
		if (stack.contains(this))
			return null;
		stack.push(this);

		Type eleType = init.get(0).getType();
		if (init.size() > 1) {
			for (int i = 1; i < init.size(); i++)
				eleType = Tools.typeConversion(eleType, init.get(i).getType());
		}
		Type retType = Tools.getArrayType(eleType);
		stack.pop();

		return retType;
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for (int i = init.size() - 1; i >= 0; i--) {
			this.init.get(i).updateType(stack);
		}
		stack.pop();
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		for(ExprNode e : this.init) {
			if(e.contains(target))
				return true;
		}
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		for(int i=0; i<this.init.size(); i++) {
			if(this.init.get(i) == oldNode)
				this.init.set(i, newNode);
		}
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
		for(ExprNode e : this.init)
			e.updateTree(mg);
	}

	@Override
	public void updateParam(String name, Object value) {
		for(ExprNode e : this.init)
			e.updateParam(name, value);
	}
}
