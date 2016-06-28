package io.lambdacloud.statement;

import static org.objectweb.asm.Opcodes.T_BOOLEAN;
import static org.objectweb.asm.Opcodes.T_BYTE;
import static org.objectweb.asm.Opcodes.T_CHAR;
import static org.objectweb.asm.Opcodes.T_DOUBLE;
import static org.objectweb.asm.Opcodes.T_FLOAT;
import static org.objectweb.asm.Opcodes.T_INT;
import static org.objectweb.asm.Opcodes.T_LONG;
import static org.objectweb.asm.Opcodes.T_SHORT;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class Tools {
	public static Type getElementType(Type arrayType) {
		return Type.getType(arrayType.getDescriptor().substring(1));
	}
	
	public static int getTypeForNEWARRAY(Type arrayType) {
		Type et = getElementType(arrayType);
		switch(et.getSort()) {
		case Type.DOUBLE:
			return T_DOUBLE;
		case Type.INT:
			return T_INT;
		case Type.LONG:
			return T_LONG;
		case Type.SHORT:
			return T_SHORT;
		case Type.BYTE:
			return T_BYTE;
		case Type.FLOAT:
			return T_FLOAT;
		case Type.CHAR:
			return T_CHAR;
		case Type.BOOLEAN:
			return T_BOOLEAN;
		}
		throw new RuntimeException();
	}
	
	public static Type typeConversion(Type type1, Type type2) {
		int t1 = type1.getSort();
		int t2 = type2.getSort();
		if(t1 == Type.OBJECT || t2 == Type.OBJECT) {
			return type1;
		}
		if(t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
			return Type.getType(double.class);
		}
		if(t1 == Type.INT || t2 == Type.INT) {
			return Type.getType(int.class);
		}
		return Type.getType(boolean.class);
	}
	
	public static void insertConversionInsn(MethodVisitor mv, Type from, Type to) {
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
	
	public static Class<?> typeToClass(Type t) {
		switch(t.getSort()) {
		case Type.DOUBLE:
			return double.class;
		case Type.INT:
			return int.class;
		case Type.LONG:
			return long.class;
		case Type.BOOLEAN:
			return boolean.class;
		case Type.CHAR:
			return char.class;
		case Type.SHORT:
			return short.class;
		case Type.BYTE:
			return byte.class;
		case Type.OBJECT:
			try {
				return Class.forName(t.getInternalName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
