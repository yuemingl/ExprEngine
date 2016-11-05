package io.lambdacloud.node.matrix;

import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.IASTORE;
import static org.objectweb.asm.Opcodes.NEWARRAY;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.util.ObjectArray;

/**
 * Initialize an matrix (actually an array) of object (different form 
 * MatrixInitNode which initializes an matrix of double)
 * 
 * @author yueming.liu
 *
 */
public class CellInitNode extends ExprNode {
	public List<ExprNode> initExprList = new ArrayList<ExprNode>();
	public List<Integer> colLenList = new ArrayList<Integer>();

	public void addInitValues(ExprNode val) {
		initExprList.add(val);
	}

	/**
	 * What if the index is a variable instead of a number?
	 * We cannot get the value of the variable, so it is not possible
	 * to obtain the type of the element.
	 * 
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public Type getElementType(int m, int n) {
		int idx = 0;
		for(int i=0; i<m-1; i++)
			idx += this.colLenList.get(i);
		idx += n;
		return this.initExprList.get(idx).getType();
	}
	public Type getElementType() {
      if(initExprList.size() == 0)
        return Type.DOUBLE_TYPE;
		
        Type eleType = null;
        for (int i = 0; i < initExprList.size(); i++) {
            Type tmp = this.initExprList.get(i).getType();
            if(null != tmp) {
                eleType = tmp;
                break;
            }
        }
        if (initExprList.size() > 1) {
            for (int i = 0; i < initExprList.size(); i++) {
                Type tmp = this.initExprList.get(i).getType();
                if(null != tmp)
                    eleType = Tools.typeConversion(eleType, initExprList.get(i).getType());
            }
        }
        return eleType;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {

		if(initExprList.size() == 0) {
			mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(ObjectArray.class));
			mg.visitInsn(DUP);
			mg.visitLdcInsn(0);
			mg.visitLdcInsn(0);
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(ObjectArray.class), "<init>", "(II)V", false);
			return;
		}
		
		//Get element type
		Type eleType = getElementType();
		//Blockwise initialization {A,B,C;D}
		if (eleType.equals(Type.getType(ObjectArray.class))) {
			
			mg.visitLdcInsn(this.initExprList.size()); //size of new array
			mg.visitTypeInsn(ANEWARRAY, eleType.getInternalName());
			int idx = 0;
			for (int i = this.initExprList.size() - 1; i >= 0; i--) {
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				initExprList.get(i).genCode(mg);
				mg.visitInsn(eleType.getOpcode(IASTORE));
			}

			mg.visitLdcInsn(this.colLenList.size()); //size of new array
			mg.visitIntInsn(NEWARRAY, Tools.getTypeForNEWARRAY(Type.INT_TYPE, false));
			idx = 0;
			for (int i=0; i<this.colLenList.size(); i++) {
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				mg.visitLdcInsn(this.colLenList.get(i));
				mg.visitInsn(IASTORE);
			}
			mg.visitMethodInsn(Opcodes.INVOKESTATIC, Tools.getClassNameForASM(ObjectArray.class), 
					"getObjectArray", 
					"("+Type.getType(ObjectArray[].class).getDescriptor()+"[I)"+Type.getType(ObjectArray.class).getDescriptor(), false);

		} else {
			mg.visitTypeInsn(Opcodes.NEW, Tools.getClassNameForASM(ObjectArray.class));
			mg.visitInsn(DUP);
			
			mg.visitLdcInsn(getValidNumberOfElement()); //size of new array
			
			mg.visitTypeInsn(ANEWARRAY, Tools.getClassNameForASM(Object.class));
			int idx = 0;
			for (int i = initExprList.size() - 1; i >= 0; i--) {
				if(null == this.initExprList.get(i).getType()) continue;
				mg.visitInsn(DUP);
				mg.visitLdcInsn(idx++);
				initExprList.get(i).genCode(mg);
				Tools.insertConversionInsn(mg, initExprList.get(i).getType(), Type.getType(Object.class));
				mg.visitInsn(Opcodes.AASTORE);
			}
			
			if(colLenList.get(0) == this.initExprList.size()) //a vector of object
				mg.visitLdcInsn(getValidNumberOfElement());
			else
				mg.visitLdcInsn(colLenList.get(0));
			
			mg.visitMethodInsn(Opcodes.INVOKESPECIAL, Tools.getClassNameForASM(ObjectArray.class), "<init>", 
					"("+Type.getType(Object[].class).getDescriptor()+"I)V", false);
		} 
	}

	public int getValidNumberOfElement() {
		int n = 0;
		for(int i=0; i<this.initExprList.size(); i++) {
			if(null != this.initExprList.get(i).getType())
				n++;
		}
		return n;
	}
	public String toString() {
		return this.initExprList.toString();
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(ObjectArray.class);
	}
	
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for (int i = initExprList.size() - 1; i >= 0; i--) {
			this.initExprList.get(i).updateType(stack);
		}
		stack.pop();
	}
	

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		for(ExprNode e : this.initExprList) {
			if(e.contains(target))
				return true;
		}
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		for(int i=0; i<this.initExprList.size(); i++) {
			if(this.initExprList.get(i) == oldNode)
				this.initExprList.set(i, newNode);
		}
	}
	
}
