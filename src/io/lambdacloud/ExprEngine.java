package io.lambdacloud;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ExprEngine {
	public static void main(String[] args) throws Exception {
		System.out.println(8/4%3);
		//ANTLRInputStream input = new ANTLRInputStream("x+y;1+2;d=a=b=c=x-y;b;");
		ANTLRInputStream input = new ANTLRInputStream("x+y;not (x <= y);");
		//ANTLRInputStream input = new ANTLRInputStream("x+y;8/4%3;");
		//ANTLRInputStream input = new ANTLRInputStream("x+y;8/(4%3);");
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
		
		Class<?> c = ew.genCode("MyClass", "eval");
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
