package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.T_BOOLEAN;
import static org.objectweb.asm.Opcodes.T_BYTE;
import static org.objectweb.asm.Opcodes.T_CHAR;
import static org.objectweb.asm.Opcodes.T_DOUBLE;
import static org.objectweb.asm.Opcodes.T_FLOAT;
import static org.objectweb.asm.Opcodes.T_INT;
import static org.objectweb.asm.Opcodes.T_LONG;
import static org.objectweb.asm.Opcodes.T_SHORT;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.MethodGenHelper;

public class Tools {
//	public static Type getElementType(Type arrayType) {
//		return Type.getType(arrayType.getDescriptor().substring(1));
//	}
	
	public static int getTypeForNEWARRAY(Type arrayType, boolean isArray) {
		Type et = null;
		if(isArray) {
			if(arrayType.getSort() != Type.ARRAY) {
				throw new RuntimeException("An array type is needed!");
			}
			et = arrayType.getElementType();
		} else {
			et = arrayType;
		}
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
		throw new RuntimeException("Type "+et+" is not a primitive type for NEWARRAY instruction. Use ANEWARRAY instead.");
	}
	
	public static void test() {
		double[][] oo = new double[100][];
	}
	
	public static Type typeConversion(Type type1, Type type2) {
		if(null == type1 && null == type2) {
			return null;
		} else if(null == type1) {
			return type2;
		} else if(null == type2) {
			return type1;
		} else {
			int t1 = type1.getSort();
			int t2 = type2.getSort();
			if(t1 == Type.OBJECT || t2 == Type.OBJECT) {
				if(t1 == Type.OBJECT) return type1;
				else return type2;
			} else if(t1 == Type.ARRAY || t2 ==Type.ARRAY) {
				if(t1 == Type.ARRAY) return type1;
				else return type2;
			} else if(t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
				return Type.DOUBLE_TYPE;
			} else if(t1 == Type.FLOAT || t2 == Type.FLOAT) {
				return Type.FLOAT_TYPE;
			} else if(t1 == Type.LONG || t2 == Type.LONG) {
				return Type.LONG_TYPE;
			} else if(t1 == Type.INT || t2 == Type.INT) {
				return Type.INT_TYPE;
			} else if(t1 == Type.BOOLEAN && t2 == Type.BOOLEAN) {
				return Type.BOOLEAN_TYPE;
			} else {
				throw new RuntimeException("Cannot convert type "+type1+" and "+type2+"!");
			}
		}
	}
	
	public static void insertConversionInsn(MethodGenHelper mg, Type from, Type to) {
		if(from.getSort() == to.getSort())
			return;
		int f = from.getSort();
		int t = to.getSort();
		if(f == Type.INT && t == Type.DOUBLE)
			mg.visitInsn(Opcodes.I2D);
		if(f == Type.LONG && t == Type.DOUBLE)
			mg.visitInsn(Opcodes.L2D);
		if(f == Type.LONG && t == Type.INT)
			mg.visitInsn(Opcodes.L2I);
		if(f == Type.DOUBLE && t == Type.INT)
			mg.visitInsn(Opcodes.D2I);
		if(f == Type.INT && t == Type.LONG)
			mg.visitInsn(Opcodes.I2L);
		if(f == Type.DOUBLE && t == Type.LONG)
			mg.visitInsn(Opcodes.D2L);
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
				return Class.forName(t.getInternalName().replaceAll("/", "\\."));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		case Type.ARRAY:
			//Type e = Tools.getElementType(t);
			Type e = t.getElementType();
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
	
	public static Type getArrayType(Type element) {
		return Type.getType("["+element.getDescriptor());
	}
	
	public static Type getElementType(Type arrayType) {
		if(arrayType.getSort() != Type.ARRAY) {
			throw new RuntimeException("An array type is needed!");
		}
		return Type.getType(arrayType.getDescriptor().substring(1));
	}
	
//	public static int getNextIndexLVT(Map<String, VariableNode> localVarMap, 
//			Map<String, VariableNode> paramMap, Type type) {
//		int idx = 0;
//		for(Entry<String, VariableNode> e : localVarMap.entrySet()) {
//			if(e.getValue().idxLVT > idx) idx = e.getValue().idxLVT;
//		}
//		for(Entry<String, VariableNode> e : paramMap.entrySet()) {
//			if(e.getValue().idxLVT > idx) idx = e.getValue().idxLVT;
//		}
//		if(type.getSort() == Type.DOUBLE)
//			return idx+2;
//		else
//			return idx+1;
//	}
	
	public static double[] listToDoubleArray(List<Double> list) {
		double[] ret = new double[list.size()];
		for(int i=0; i<ret.length; i++) {
			ret[i] = (double)list.get(i);
		}
		return ret;
	}
	public static double[][] listToDoubleArray2(List<List<Double>> list) {
		int m = list.size();
		int n = list.get(0).size();
		double[][] ret = new double[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++)
				ret[i][j] = (double)list.get(i).get(j);
		}
		return ret;
	}

	public static int[] listToIntegerArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for(int i=0; i<ret.length; i++) {
			ret[i] = (int)list.get(i);
		}
		return ret;
	}
	public static boolean[] listToBooleanArray(List<Boolean> list) {
		boolean[] ret = new boolean[list.size()];
		for(int i=0; i<ret.length; i++) {
			ret[i] = (boolean)list.get(i);
		}
		return ret;
	}
	public static Object[] listToObjectArray(List<Object> list) {
		return list.toArray();
	}
}
