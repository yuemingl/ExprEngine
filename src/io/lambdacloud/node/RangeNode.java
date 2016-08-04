package io.lambdacloud.node;

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
	
	public RangeNode(ExprNode start, ExprNode end, boolean includeEnd) {
		this.start = start;
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
	public void genCode(MethodGenHelper mg) {
		String type2 = "(II)[I";
		String type3 = "(III)[I";
		Type retType = this.getType();
		Type myType = retType.getElementType();
		if(myType.getSort() == Type.DOUBLE) {
			type2 = "(DD)[D";
			type3 = "(DDD)[D";
		}
		try {
			if(start != null) {
				if(null == this.step) {
					start.genCode(mg);
					Tools.insertConversionInsn(mg, start.getType(), myType);
					end.genCode(mg);
					Tools.insertConversionInsn(mg, end.getType(), myType);
					if(this.includeEnd)
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range2", 
								type2, false);
					else
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
								type2, false);
				} else {
					start.genCode(mg);
					Tools.insertConversionInsn(mg, start.getType(), myType);
					step.genCode(mg);
					Tools.insertConversionInsn(mg, step.getType(), myType);
					end.genCode(mg);
					Tools.insertConversionInsn(mg, end.getType(), myType);
					//handled [s,step,e] and [s,step,e)
					if(this.includeEnd)
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range2", 
									type3, false);
					else
						mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
								type3, false);				}
			} else {
				end.genCode(mg);
				mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
						"(I)[I", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		if(null == this.end)
			return Tools.getArrayType(start.getType(stack));
		else if(null == this.step)
			return Tools.getArrayType(Tools.typeConversion(start.getType(stack), end.getType(stack)));
		else {
			Type eleType = Tools.typeConversion(start.getType(), step.getType(stack));
			eleType = Tools.typeConversion(eleType, end.getType(stack));
			return Tools.getArrayType(eleType);
		}
	}
	
	public void genStartCode(MethodGenHelper mg) {
		if(start == null)
			mg.visitInsn(Opcodes.ICONST_0);
		else
			start.genCode(mg);
	}
	
	public void genEndCode(MethodGenHelper mg) {
		end.genCode(mg);
		if(this.includeEnd) {
			mg.visitInsn(Opcodes.ICONST_1);
			mg.visitInsn(Opcodes.IADD);
		}
	}
	
	public void genStepCode(MethodGenHelper mg) {
		step.genCode(mg);
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
}
