package io.lambdacloud.node.matrix;

import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import java.util.Deque;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.BytecodeSupport;
import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.tool.IndexPair;
import io.lambdacloud.util.ObjectArray;

public class EndIndexNode extends ExprNode {
	int dim;
	
	public void setDim(int dim) {
		this.dim = dim;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		System.out.println(this.parent.getParent());
		System.out.println(this.dim);
		ExprNode p = this.getParent();
		while(p != null) {
			if(p instanceof MatrixAccessNode) {
				MatrixAccessNode man = (MatrixAccessNode)p;
				man.var.genCode(mg);
				if(dim == 1) {
					mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getRowDimension", "()I", false);
//					mg.visitInsn(Opcodes.ICONST_1);
//					mg.visitInsn(Opcodes.ISUB);
				} else if(dim == 2) {
					mg.visitMethodInsn(INVOKEVIRTUAL, "Jama/Matrix", "getColumnDimension", "()I", false);
//					mg.visitInsn(Opcodes.ICONST_1);
//					mg.visitInsn(Opcodes.ISUB);
				} else if(dim == -1) {
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, Tools.getClassNameForASM(BytecodeSupport.class), 
							"numel", "("+Type.getType(Jama.Matrix.class)+")I", false);
				} else {
					throw new RuntimeException("dim="+dim);
				}
				break;
			} else if(p instanceof CellAccessNode) {
				CellAccessNode can = (CellAccessNode)p;
				can.var.genCode(mg);
				if(dim == 1) {
					mg.visitMethodInsn(INVOKEVIRTUAL, Tools.getClassNameForASM(ObjectArray.class), 
							"getRowDimension", "()I", false);
//					mg.visitInsn(Opcodes.ICONST_1);
//					mg.visitInsn(Opcodes.ISUB);
				} else if(dim == 2) {
					mg.visitMethodInsn(INVOKEVIRTUAL,  Tools.getClassNameForASM(ObjectArray.class), 
							"getColumnDimension", "()I", false);
//					mg.visitInsn(Opcodes.ICONST_1);
//					mg.visitInsn(Opcodes.ISUB);
				} else if(dim == -1) {
					mg.visitMethodInsn(Opcodes.INVOKESTATIC, Tools.getClassNameForASM(BytecodeSupport.class), 
							"numel", "("+Type.getType(ObjectArray.class)+")I", false);
				} else {
					throw new RuntimeException("dim="+dim);
				}
				break;
			}
			p = p.getParent();
		}
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.INT_TYPE;
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
		if("end_dim".equalsIgnoreCase(name)) {
			this.setDim(((Integer)value).intValue());
		}
	}

}
