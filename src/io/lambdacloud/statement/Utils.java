package io.lambdacloud.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

public class Utils {
	public static Type typeConversion(Type type1, Type type2) {
		int t1 = type1.getSort();
		int t2 = type2.getSort();
		if(t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
			return Type.getType(double.class);
		}
		if(t1 == Type.INT || t2 == Type.INT) {
			return Type.getType(int.class);
		}
		return Type.getType(boolean.class);
	}
	
	public static void insertConversionCode(MethodVisitor mv, Type from, Type to) {
		if(from.getSort() == to.getSort())
			return;
		int f = from.getSort();
		int t = to.getSort();
		if(f == Type.INT && t == Type.DOUBLE)
			mv.visitInsn(Opcodes.I2D);
		if(f == Type.LONG && t == Type.DOUBLE)
			mv.visitInsn(Opcodes.L2D);
		if(f == Type.LONG && t == Type.INT)
			mv.visitInsn(Opcodes.L2I);
		if(f == Type.DOUBLE && t == Type.INT)
			mv.visitInsn(Opcodes.D2I);
		if(f == Type.INT && t == Type.LONG)
			mv.visitInsn(Opcodes.I2L);
		if(f == Type.DOUBLE && t == Type.LONG)
			mv.visitInsn(Opcodes.D2L);
	}
}
