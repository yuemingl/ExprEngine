package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.lang.reflect.Method;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;

public class RangeNode extends ExprNode {
	ExprNode start;
	ExprNode end;
	
	public RangeNode(ExprNode start, ExprNode end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void genCode(MethodGenHelper mg) {
		try {
			if(start != null) {
				end.genCode(mg);
				start.genCode(mg);
				mg.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/BytecodeSupport", "range", 
						"(II)[I", false);
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
	public Type getType() {
		return Type.getType(int[].class);
	}
	
	public void genStartCode(MethodGenHelper mg) {
		if(start == null)
			mg.visitInsn(Opcodes.ICONST_0);
		else
			start.genCode(mg);
	}
	
	public void genEndCode(MethodGenHelper mg) {
		end.genCode(mg);
	}
}
