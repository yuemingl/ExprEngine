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
	
	public static Class<?> getIntClass(int dim) {
		if(dim == 0) return int.class;
		else if(dim == 1) return int[].class;
		else if(dim == 2) return int[][].class;
		else if(dim == 3) return int[][][].class;
		return null;
	}
	public static Class<?> getLongClass(int dim) {
		if(dim == 0) return long.class;
		else if(dim == 1) return long[].class;
		else if(dim == 2) return long[][].class;
		else if(dim == 3) return long[][][].class;
		return null;
	}
	public static Class<?> getDoubleClass(int dim) {
		if(dim == 0) return double.class;
		else if(dim == 1) return double[].class;
		else if(dim == 2) return double[][].class;
		else if(dim == 3) return double[][][].class;
		return null;
	}
	public static Class<?> getBooleanClass(int dim) {
		if(dim == 0) return boolean.class;
		else if(dim == 1) return boolean[].class;
		else if(dim == 2) return boolean[][].class;
		else if(dim == 3) return boolean[][][].class;
		return null;
	}
	
	public static Class<?> typeToClass(Type t) {
		return typeToClass(t, 0);
	}

	public static Class<?> typeToClass(Type t, int dim) {
		switch(t.getSort()) {
		case Type.DOUBLE:
			return getDoubleClass(dim);
		case Type.INT:
			return getIntClass(dim);
		case Type.LONG:
			return getLongClass(dim);
		case Type.BOOLEAN:
			return getBooleanClass(dim);
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
		case Type.ARRAY:
			Type e = Tools.getElementType(t);
			return typeToClass(e, dim+1);
		}
		return null;
	}
	
	public static Class<?> getPrimitiveClass(Class<?> c) {
		if(c == Double.class)
			return double.class;
		else if(c == Integer.class)
			return int.class;
		else if(c == Float.class)
			return float.class;
		else if(c == Short.class)
			return short.class;
		else if(c == Character.class)
			return char.class;
		else if(c == Long.class)
			return long.class;
		else if(c == Boolean.class)
			return boolean.class;
		
		return c;
	}	
}
