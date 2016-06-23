package io.lambdacloud;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

public class ExprEngine {
	public static ExprTreeBuildWalker parse(String str, Class<?> defaultParameterTypeOrInterface) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker(defaultParameterTypeOrInterface);
		walker.walk(ew, tree);
		return ew;
	}

	public static ExprTreeBuildWalker parse(String str, Map<String, Class<?>> mapParameterTypes) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker(mapParameterTypes);
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
	public static Object newInstance(ExprTreeBuildWalker ew, String className) {
		return newInstance(ew, className, false);
	}
	
	public static Object newInstance(ExprTreeBuildWalker ew, 
			String className, boolean wirteFile) {
		Class<?> c = ew.genClass(className, wirteFile, null, false);
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
			String className, boolean wirteFile, 
			String methodName) {
		
		Class<?> c = ew.genClass(className, wirteFile, methodName, true);
		Method m1 = null;
		try {
			m1 = c.getMethod(methodName, ew.getParameterClassTypes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}
	
	public static MethodHandle genMethodHandle(ExprTreeBuildWalker ew, 
			String className, boolean wirteFile, String methodName, Class<?> retType, Class<?> ...parameterTypes) {
		Class<?> c = ew.genClass(className, wirteFile, methodName, true, parameterTypes);
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
		ExprTreeBuildWalker ew = parse(str, void.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			return m1.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object parseAndEval(String str, int[] args) {
		ExprTreeBuildWalker ew = parse(str, int.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
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
		ExprTreeBuildWalker ew = parse(str, long.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
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
		ExprTreeBuildWalker ew = parse(str, double.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
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
	
	public static Object parseAndEval(String str, String[] args) {
		ExprTreeBuildWalker ew = parse(str, String.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
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
	
	public static Object parseAndEval(String str, Object[] args) {
		Class<?>[] aryParamTypes = new Class<?>[args.length];
		for(int i=0; i<args.length; i++) {
			aryParamTypes[i] = args[i].getClass();
		}
		//ExprTreeBuildWalker ew = parse(str, aryParamTypes);
		ExprTreeBuildWalker ew = parse(str, aryParamTypes[0]);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
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
}
