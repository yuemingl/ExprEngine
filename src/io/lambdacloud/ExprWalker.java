package io.lambdacloud;
import org.objectweb.asm.Opcodes;


public class ExprWalker extends ExprGrammarBaseListener {
	CodeGenerator gg = new CodeGenerator();
	
	public CodeGenerator getCodeGenerator() {
		return gg;
	}

	@Override public void enterProg(ExprGrammarParser.ProgContext ctx) {
		System.out.println("enter prog:");
		gg.startClass("test", null);
		gg.startMethod(Opcodes.ACC_PUBLIC, "eval", "()D");
		gg.startCode();
	}
	@Override public void exitProg(ExprGrammarParser.ProgContext ctx) { 
		//gg.mv.visitInsn(Opcodes.DRETURN);
		gg.mv.visitMaxs(10, 10);
		gg.endCode();
		gg.endClass();
	}
	@Override public void exitExprAssign(ExprGrammarParser.ExprAssignContext ctx) {
		System.out.println(ctx.getChild(0).getText());
		System.out.println(ctx.getText());
	}
	@Override public void exitExprLogical(ExprGrammarParser.ExprLogicalContext ctx) {
		gg.getMV().visitInsn(Opcodes.IRETURN);
		
	}
//	@Override public void exitExprComparison(ExprGrammarParser.ExprComparisonContext ctx) {
//		gg.getMV().visitInsn(Opcodes.IRETURN);
//	}
	@Override public void exitExprArithmetic(ExprGrammarParser.ExprArithmeticContext ctx) {
		System.out.println("Arithmetric: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DRETURN);
	}
	@Override public void enterArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx) { 
		System.out.println(">*: "+ctx.getText());
	}
	@Override public void exitArithmeticExpressionMul(ExprGrammarParser.ArithmeticExpressionMulContext ctx) {
		System.out.println("<*: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DMUL);

	}
	@Override public void enterArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx) { 
		System.out.println(">+: "+ctx.getText());
	}

	@Override public void exitArithmeticExpressionAdd(ExprGrammarParser.ArithmeticExpressionAddContext ctx) {
		System.out.println("<+: "+ctx.getText());
		gg.getMV().visitInsn(Opcodes.DADD);
	}

//	@Override public void exitLogicalVariable(ExprGrammarParser.LogicalVariableContext ctx) {
//		System.out.println(ctx.getText());
//	}
//	@Override public void exitNumericConst(ExprGrammarParser.NumericConstContext ctx) {
//		System.out.println(ctx.getText());
//		gg.getMV().visitLdcInsn(Double.parseDouble(ctx.getText()));
//	}
}
