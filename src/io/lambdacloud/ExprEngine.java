package io.lambdacloud;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExprEngine {
	public static Object eval(String str) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);

		Class<?> c = ew.genCode("MyClass", true, "eval");
		Method m1;
		try {
			m1 = c.getMethod("eval");
			Object o = c.newInstance();
			return m1.invoke(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static Object eval(String str, int[] args) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);

		Class<?>[] cls = new Class[args.length];
		for(int i=0; i<args.length; i++)
			cls[i] = int.class;
		Class<?> c = ew.genCode("MyClass", true, "eval", cls);
		Method m1;
		try {
			m1 = c.getMethod("eval",cls);
			Object o = c.newInstance();
			Object[] params = new Object[args.length];
			for(int i=0; i<args.length; i++)
				params[i] = args[i];
			return m1.invoke(o, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public static Object eval(String str, double[] args) {
		ANTLRInputStream input = new ANTLRInputStream(str);
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);
		Class<?>[] cls = new Class[args.length];
		for(int i=0; i<args.length; i++)
			cls[i] = double.class;
		Class<?> c = ew.genCode("MyClass", true, "eval", cls);
		Method m1;
		try {
			m1 = c.getMethod("eval",cls);
			Object o = c.newInstance();
			Object[] params = new Object[args.length];
			for(int i=0; i<args.length; i++)
				params[i] = args[i];
			return m1.invoke(o, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void assertEqual(Object o1, Object o2) {
		if(!o1.equals(o2)) {
			System.err.println(o1 + " != "+o2);
			throw new RuntimeException("Assert fail!");
		}
	}
	
	public static void main(String[] args){
		//assertEqual(eval("2.0 > 1;", new int[]{}), true); //TODO auto type conversion
		int a = -1;
		int b = 7;
		System.out.println(-1^7);
		System.out.println(-a&b);
	//	assertEqual(eval("-x&y;", new int[]{-1,7}), -8);
	//	assertEqual(eval("(x+y)^1;", new int[]{-1,7}), -8);
	//	assertEqual(eval("(x^1)^(y^1);", new int[]{-1,7}), -8);
		assertEqual(eval("x^1;", new int[]{2}), 3);
		
//		assertEqual(eval("0 & 0;"), 0);
//		assertEqual(eval("0 & 1;"), 0);
//		assertEqual(eval("1 & 0;"), 0);
//		assertEqual(eval("1 & 1;"), 1);
//
//		assertEqual(eval("0 | 0;"), 0);
//		assertEqual(eval("0 | 1;"), 1);
//		assertEqual(eval("1 | 0;"), 1);
//		assertEqual(eval("1 | 1;"), 1);
//
//		assertEqual(eval("0 ^ 0;"), 0);
//		assertEqual(eval("0 ^ 1;"), 1);
//		assertEqual(eval("1 ^ 0;"), 1);
//		assertEqual(eval("1 ^ 1;"), 0);
//
//		assertEqual(eval("~0;"), -1);
//		assertEqual(eval("~1;"), -2);
//		
//		assertEqual(eval("-1^7;"), eval("~7;"));
//		assertEqual(eval("7^-1;"), eval("~7;"));

//		assertEqual(eval("1+2;", new int[]{}), 3);
//		assertEqual(eval("x+y;", new int[]{3,4}), 7);
//		assertEqual(eval("x+y;", new double[]{3,4}), 7.0);
//
//		assertEqual(eval("x+y;", new double[]{3,4}), 7.0);
//		assertEqual(eval("x-y;", new double[]{3,4}), -1.0);
//		assertEqual(eval("x*y;", new double[]{3,4}), 12.0);
//		assertEqual(eval("x/y;", new double[]{3,4}), 0.75);
//		assertEqual(eval("x%y;", new double[]{3,4}), 3.0);
//
//		assertEqual(eval("x+y;", new int[]{3,4}), 7);
//		assertEqual(eval("x-y;", new int[]{3,4}), -1);
//		assertEqual(eval("x*y;", new int[]{3,4}), 12);
//		assertEqual(eval("x/y;", new int[]{3,4}), 0);
//		assertEqual(eval("x%y;", new int[]{3,4}), 3);
//
//		assertEqual(eval("x > y;", new double[]{3,4}), false);
//		assertEqual(eval("x >= y;", new double[]{3,4}), false);
//		assertEqual(eval("x < y;", new double[]{3,4}), true);
//		assertEqual(eval("x <= y;", new double[]{3,4}), true);
//		assertEqual(eval("x == y;", new double[]{3,4}), false);
//		assertEqual(eval("x != y;", new double[]{3,4}), true);
//
//		assertEqual(eval("2 > 1;", new double[]{}), true);
//		assertEqual(eval("2 >= 1;", new double[]{}), true);
//		assertEqual(eval("3 >= 3;", new double[]{}), true);
//		assertEqual(eval("2 < 1;", new double[]{}), false);
//		assertEqual(eval("2 <= 1;", new double[]{}), false);
//		assertEqual(eval("2 == 1;", new double[]{}), false);
//		assertEqual(eval("2 == 2;", new double[]{}), true);
//		assertEqual(eval("2 != 2;", new double[]{}), false);
//		assertEqual(eval("1 != 2;", new double[]{}), true);
//		
//		assertEqual(eval("2.0 > 1.0;", new double[]{}), true);
//		assertEqual(eval("2.0 >= 1.0;", new double[]{}), true);
//		assertEqual(eval("3.0 >= 3.0;", new double[]{}), true);
//		assertEqual(eval("2.0 < 1.0;", new double[]{}), false);
//		assertEqual(eval("2.0 <= 1.0;", new double[]{}), false);
//		assertEqual(eval("2.0 == 1.0;", new double[]{}), false);
//		assertEqual(eval("2.0 == 2.0;", new double[]{}), true);
//		assertEqual(eval("2.0 != 2.0;", new double[]{}), false);
//		assertEqual(eval("1.0 != 2.0;", new double[]{}), true);
//		
//		assertEqual(eval("2 > 1 &&  3 > 2;", new double[]{}), true);
//		assertEqual(eval("2 > 1 and 3 > 2;", new double[]{}), true);
//		assertEqual(eval("2 < 1 ||  3 > 2;", new double[]{}), true);
//		assertEqual(eval("2 < 1 or  3 > 2;", new double[]{}), true);
//		assertEqual(eval("!   3 > 2;", new double[]{}), false);
//		assertEqual(eval("not 3 > 2;", new double[]{}), false);
//
//		assertEqual(eval("a=x+y;a;", new double[]{3,4}), 7.0);
//		assertEqual(eval("c=b=a=x+y;c;", new double[]{3,4}), 7.0);
//		
//		assertEqual(eval("2*(2+1);", new double[]{}), 6);
//		assertEqual(eval("2+2*3;", new double[]{}), 8);
//		
//		assertEqual(eval("8/4%3;", new double[]{}), 2);
//		assertEqual(eval("8/(4%3);", new double[]{}), 8);
		
		System.out.println("Test done!");
		
	}
	
	public static void test(String file) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream("x+y;1+2;d=a=b=c=x-y;b;");
		ExprGrammarLexer lexer = new ExprGrammarLexer(input);
		//ExprGrammarLexer lexer = new ExprGrammarLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		//ExprWalker ew = new ExprWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);
		ew.stack.size();
		
		Class<?> c = ew.genCode("MyClass", true, "eval", new Class<?>[]{double.class, double.class});
		Method m1 = c.getMethod("eval",double.class, double.class);//TODO types
		Object o = c.newInstance();
		System.out.println(m1.invoke(o,3,4));
		
//		Method m1 = c.getMethod("eval");//TODO types
//		Object o = c.newInstance();
//		System.out.println(m1.invoke(o));
		
		
//		CodeGenerator cg = ew.getCodeGenerator();
//
//		ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
//		try {
//			// Class<?> c = mcl.defineClassForName("com.openx.asm_test.Test1",
//			// Test1Dump.dump());
//
//			byte[] bcode = cg.dump();
//			FileOutputStream fos = new FileOutputStream("test2.class");
//			fos.write(bcode);
//			fos.close();
//
//			Class<?> c = mcl.defineClassForName(null, bcode);
//			for (Method m : c.getMethods()) {
//				System.out.println(m.getName());
//			}
//			Method m1 = c.getMethod("eval");
//			Object o = c.newInstance();
//			System.out.println(m1.invoke(o));

//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
