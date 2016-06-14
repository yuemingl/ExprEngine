package io.lambdacloud;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

public class ExprEngine {
	public static ExprTreeBuildWalker parse(String str) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);
		return ew;
	}
	
	/**
	 * Create an instance in memory (without writing bytecode to a class file)
	 * @param ew
	 * @param className
	 * @param _interface
	 * @return
	 */
	public static Object newInstance(ExprTreeBuildWalker ew, 
			String className, Class<?> _interface) {
		return newInstance(ew, className, _interface, false);
	}
	
	public static Object newInstance(ExprTreeBuildWalker ew, 
			String className, Class<?> _interface, boolean wirteFile) {
		Method m = _interface.getDeclaredMethods()[0];
		//m.getReturnType();
		Class<?> c = ew.genClass(className, new String[]{Type.getInternalName(_interface)}, wirteFile, 
				m.getName(), false, m.getParameterTypes());
		Object o = null;
		try {
			o = c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
		
	public static Method genStaticMethod(ExprTreeBuildWalker ew, 
			String className, boolean wirteFile, String methodName, Class<?> ...parameterTypes) {
		Class<?> c = ew.genClass(className, null, wirteFile, methodName, true, parameterTypes);
		Method m1 = null;
		try {
			m1 = c.getMethod(methodName,parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}
	
	public static MethodHandle genMethodHandle(ExprTreeBuildWalker ew, 
			String className, boolean wirteFile, String methodName, Class<?> retType, Class<?> ...parameterTypes) {
		Class<?> c = ew.genClass(className, null, wirteFile, methodName, true, parameterTypes);
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = null;
		try {
			mh = lookup.findStatic(c, methodName, java.lang.invoke.MethodType.methodType(retType, parameterTypes));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return mh;
	}
	
	public static Object parseAndEval(String str) {
		ExprTreeBuildWalker ew = parse(str);
		Method m1 = genStaticMethod(ew, "MyClass", true, "eval");
		try {
			return m1.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object parseAndEval(String str, int[] args) {
		ExprTreeBuildWalker ew = parse(str);
		Class<?>[] cls = new Class[args.length];
		for(int i=0; i<args.length; i++)
			cls[i] = int.class;
		Method m1 = genStaticMethod(ew, "MyClass", true, "eval", cls);
		try {
			Object[] params = new Object[args.length];
			for(int i=0; i<args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object parseAndEval(String str, long[] args) {
		ExprTreeBuildWalker ew = parse(str);
		Class<?>[] cls = new Class[args.length];
		for(int i=0; i<args.length; i++)
			cls[i] = long.class;
		Method m1 = genStaticMethod(ew, "MyClass", true, "eval", cls);
		try {
			Object[] params = new Object[args.length];
			for(int i=0; i<args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object parseAndEval(String str, double[] args) {
		ExprTreeBuildWalker ew = parse(str);
		Class<?>[] cls = new Class[args.length];
		for(int i=0; i<args.length; i++)
			cls[i] = double.class;
		Method m1 = genStaticMethod(ew, "MyClass", true, "eval", cls);
		try {
			Object[] params = new Object[args.length];
			for(int i=0; i<args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static class A implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
