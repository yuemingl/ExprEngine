package io.lambdacloud;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.objectweb.asm.MethodVisitor;

public class ExprEngine {
	public static void main(String[] args) throws Exception {
		ExprGrammarLexer lexer = new ExprGrammarLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprGrammarParser parser = new ExprGrammarParser(tokens);
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		//ExprWalker ew = new ExprWalker();
		ExprTreeBuildWalker ew = new ExprTreeBuildWalker();
		walker.walk(ew, tree);
		ew.stack.size();
		
		ew.genCode();

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
