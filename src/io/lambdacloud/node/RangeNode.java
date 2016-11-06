package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.util.Deque;

import org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class RangeNode extends ExprNode {
	public ExprNode start;
	public ExprNode end;
	public ExprNode step;
	public boolean includeEnd;
	public int INDEX_SHIFT = 0;
	
	//A range node can return a matrix or an array
	private boolean returnMatrix = true;
	
	public RangeNode(ExprNode start, ExprNode end, boolean includeEnd) {
		this.start = start;
		this.step = null;
		this.end = end;
		this.includeEnd = includeEnd;
	}
	
	public RangeNode(ExprNode start, ExprNode step, ExprNode end, boolean includeEnd) {
		this.start = start;
		this.step = step;
		this.end = end;
		this.includeEnd = includeEnd;
	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		String type2 = "(III)[I"; //start:end
		String type3 = "(IIII)[I"; //start:step:end
		
		Type retType = this.getType();
		Type eleType = null;
		if(returnMatrix) {
			eleType = Type.DOUBLE_TYPE;
			type2 = "(DDI)[D";
			type3 = "(DDDI)[D";
		} else {
			eleType = retType.getElementType();
			if(eleType.getSort() == Type.DOUBLE) {
				type2 = "(DDI)[D";
				type3 = "(DDDI)[D";
			}
		}
		
		try {
			mg.visitTypeInsn(Opcodes.NEW, "Jama/Matrix");
			mg.visitInsn(DUP);
			if(start != null) {
				if(null == this.step || null == this.step.getType()) { //range(1, 10)
					start.genCode(mg);
					Tools.insertConversionInsn(mg, start.getType(), eleType);
					end.genCode(mg);
					Tools.insertConversionInsn(mg, end.getType(), eleType);
					if(INDEX_SHIFT == 0)
						mg.visitInsn(Opcodes.ICONST_0);
					else
						mg.visitInsn(Opcodes.ICONST_1);
					//handle [s,e] or [s,e)
					if(this.includeEnd)
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range2", 
								type2, false);
					else
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
								type2, false);
				} else {//range(1, 2, 10)
					start.genCode(mg);
					Tools.insertConversionInsn(mg, start.getType(), eleType);
					step.genCode(mg);
					Tools.insertConversionInsn(mg, step.getType(), eleType);
					end.genCode(mg);
					Tools.insertConversionInsn(mg, end.getType(), eleType);
					if(INDEX_SHIFT == 0)
						mg.visitInsn(Opcodes.ICONST_0);
					else
						mg.visitInsn(Opcodes.ICONST_1);
					//handle [s,step,e] or [s,step,e)
					if(this.includeEnd)
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range2", 
									type3, false);
					else
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
								type3, false);				
				}
			} else {
				//range(3) => range(0,3)
				end.genCode(mg);
				if(INDEX_SHIFT == 0)
					mg.visitInsn(Opcodes.ICONST_0);
				else
					mg.visitInsn(Opcodes.ICONST_1);
				mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
						"(II)[I", false);
			}
			
			if(returnMatrix) {
				mg.visitInsn(DUP);
				mg.visitInsn(Opcodes.ARRAYLENGTH);
				mg.visitMethodInsn(Opcodes.INVOKESPECIAL, "Jama/Matrix", "<init>", "([DI)V", false);
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Jama/Matrix", "transpose", "()LJama/Matrix;", false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		if(returnMatrix)
			return Type.getType(Jama.Matrix.class);
		else {
			if(null == this.end)
				return Tools.getArrayType(start.getType(stack));
			else if(null == this.step) {
				if(null != start)
					return Tools.getArrayType(Tools.typeConversion(start.getType(stack), end.getType(stack)));
				else
					return Tools.getArrayType(end.getType(stack));
					
			} else {
				Type eleType = Tools.typeConversion(start.getType(), step.getType(stack));
				eleType = Tools.typeConversion(eleType, end.getType(stack));
				return Tools.getArrayType(eleType);
			}
		}
	}
	
	public void genStartCode(MethodGenHelper mg) {
		if(start == null)
			mg.visitInsn(Opcodes.ICONST_0);
		else
			start.genCode(mg);
	}
	
	public void genStepCode(MethodGenHelper mg) {
		step.genCode(mg);
	}

	public void genEndCode(MethodGenHelper mg) {
		end.genCode(mg);
		if(this.includeEnd) {
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.IADD);
		}
	}
	
	public String toString() {
		if(null == this.step) {
			if(includeEnd)
				return "["+start+", "+end+"]";
			else
				return "["+start+", "+end+")";
		} else {
			if(includeEnd)
				return "["+start+", "+step+", "+end+"]";
			else
				return "["+start+", "+step+", "+end+")";
		}
			
	}

	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;

		stack.push(this);
		if(null != this.start)
			this.start.updateType(stack);
		if(null != this.end)
			this.end.updateType(stack);
		if(null != this.step)
			this.step.updateType(stack);
		stack.pop();
	}

	public void setAsReturnMatirx() {
		this.returnMatrix = true;
	}

	public void setAsReturnArray() {
		this.returnMatrix = false;
	}

	@Override
	public boolean contains(ExprNode target) {
		if(null != this.start) {
			if(this.start.contains(target))
				return true;
		}
		if(null != this.step) {
			if(this.step.contains(target))
				return true;
		}
		if(null != this.end) {
			if(this.end.contains(target))
				return true;
		}
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.start == oldNode)
			this.start = newNode;
		if(this.step == oldNode)
			this.step = newNode;
		if(this.end == oldNode)
			this.end = newNode;
		
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
	}
}
