package io.lambdacloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.lambdacloud.matlab.MatlabGrammarLexer;
import io.lambdacloud.matlab.MatlabGrammarParser;
import io.lambdacloud.node.Tools;

public class MatlabEngine {
	public static MatlabTreeBuildWalker parse(String str) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		MatlabGrammarLexer lexer = new MatlabGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MatlabGrammarParser parser = new MatlabGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		MatlabTreeBuildWalker ew = new MatlabTreeBuildWalker();
		walker.walk(ew, tree);
		return ew;
	}

	public static MatlabTreeBuildWalker parse(String str, Class<?> defaultParameterTypeOrInterface) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		MatlabGrammarLexer lexer = new MatlabGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MatlabGrammarParser parser = new MatlabGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		MatlabTreeBuildWalker ew = new MatlabTreeBuildWalker(defaultParameterTypeOrInterface);
		walker.walk(ew, tree);
		return ew;
	}

	public static MatlabTreeBuildWalker parse(String str, Map<String, Class<?>> mapParameterTypes) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		MatlabGrammarLexer lexer = new MatlabGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MatlabGrammarParser parser = new MatlabGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		MatlabTreeBuildWalker ew = new MatlabTreeBuildWalker(mapParameterTypes);
		walker.walk(ew, tree);
		return ew;
	}

	/**
	 * Create an instance in memory (without writing bytecode to a class file)
	 * 
	 * @param ew
	 * @param className
	 * @param _interface
	 * @return
	 */
	public static Object newInstance(MatlabTreeBuildWalker ew, String className) {
		return newInstance(ew, className, false);
	}

	public static Object newInstance(MatlabTreeBuildWalker ew, String className, boolean wirteFile) {
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

	public static Method genStaticMethod(MatlabTreeBuildWalker ew, String className, boolean wirteFile,
			String methodName) {

		Class<?> c = ew.genClass(className, wirteFile, methodName, true);
		Method m1 = null;
		try {
			if(null != c) {
				m1 = c.getMethod(methodName, ew.getParameterClassTypes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}

	public static Method genStaticMethod(MatlabTreeBuildWalker ew, String className, boolean wirteFile, String methodName,
			Class<?>[] aryParameterTypes) {

		Class<?> c = ew.genClass(className, wirteFile, methodName, true, aryParameterTypes);
		Method m1 = null;
		try {
			m1 = c.getMethod(methodName, ew.getParameterClassTypes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m1;
	}

	public static MethodHandle genMethodHandle(MatlabTreeBuildWalker ew, String className, boolean wirteFile,
			String methodName, Class<?> retType, Class<?>... parameterTypes) {
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

	/**
	 * Parse without parameters
	 * 
	 * @param str
	 * @return
	 */
	public static Object exec(String str) {
		ExprTreeBuildWalker.funcMap.clear();
		MatlabTreeBuildWalker ew = parse(str);
		try {
			Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
			if(null != m1)
				return m1.invoke(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse with all int type parameters
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, int[] args) {
		MatlabTreeBuildWalker ew = parse(str, int.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			Object[] params = new Object[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse with all long type parameters
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, long[] args) {
		MatlabTreeBuildWalker ew = parse(str, long.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			Object[] params = new Object[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse with all double type parameters
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, double[] args) {
		MatlabTreeBuildWalker ew = parse(str, double.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			Object[] params = new Object[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse with all String type parameters
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, String[] args) {
		MatlabTreeBuildWalker ew = parse(str, String.class);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			Object[] params = new Object[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse without type info
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, Object[] args) {
		Class<?>[] aryParamTypes = new Class<?>[args.length];
		for (int i = 0; i < args.length; i++) {
			aryParamTypes[i] = Tools.getPrimitiveClass(args[i].getClass());
		}
		MatlabTreeBuildWalker ew = parse(str);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply", aryParamTypes);
		try {
			Object[] params = new Object[args.length];
			for (int i = 0; i < args.length; i++)
				params[i] = args[i];
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse with type info by passing a name->object map
	 * 
	 * @param str
	 * @param args
	 * @return
	 */
	public static Object exec(String str, Map<String, Object> args) {
		Map<String, Class<?>> argTypes = new HashMap<String, Class<?>>();
		for (Entry<String, Object> e : args.entrySet()) {
			argTypes.put(e.getKey(), Tools.getPrimitiveClass(e.getValue().getClass()));
		}
		MatlabTreeBuildWalker ew = parse(str, argTypes);
		Method m1 = genStaticMethod(ew, "GenClass1", true, "apply");
		try {
			List<String> argNames = new ArrayList<String>();
			argNames.addAll(args.keySet());
			Collections.sort(argNames);
			Object[] params = new Object[argNames.size()];
			for (int i = 0; i < params.length; i++)
				params[i] = args.get(argNames.get(i));
			return m1.invoke(null, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		BufferedReader br = null;
		if (args.length != 1) {
			System.out.println("MatlabEngine 1.0");
			System.out.print(">>");
			
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.print(">>");
					if(line.trim().length() != 0) {
						Object rlt = exec(line);
						if(null != rlt)
							myPrint(rlt);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			return;
		}
		try {
			StringBuilder sb = new StringBuilder();
			br = new BufferedReader(new FileReader(args[0]));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			exec(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void myPrint(Object o) {
		if(o instanceof double[]) {
			double[] a = (double[])o;
			System.out.print("[");
			for(double d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof int[]) {
			int[] a = (int[])o;
			System.out.print("[");
			for(int d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof Jama.Matrix) {
			((Jama.Matrix)o).print(8, 2);;
		}
		else {
			System.out.println(o);
		}
	}
}
