package io.lambdacloud.test;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class BytecodeInspact {
	public static void test(String s) {
		switch(s) {
		case "aaa":
			System.out.println("aa");
			break;
		case "bbb":
			System.out.println("bb");
			break;
		case "abc":
			System.out.println("cc");
			break;
		default:
			System.out.println("dd");
			break;
			
		}
	}
	
	public static void test2(int n) {
		int m = 0;
		switch(n) {
		case 30:
			m = 300;
			break;
		case 20:
			m = 200;
			break;
		case 10:
			m = 100;
			break;
		default:
			m = 500;
		}
		System.out.println(m);
	}
//	public static void test3(double n) {
//		int m = 0;
//		switch(n) {
//		case 100.0:
//			m = 1;
//			break;
//		case 121:
//			m = 2;
//			break;
//		default:
//			m = 3;
//		}
//		System.out.println(m);
//	}
	
	public static void ttt() {
		MethodVisitor mv = null;
		
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitInsn(DUP);
		mv.visitVarInsn(ASTORE, 1);
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "hashCode", "()I", false);
		//Labels for each cases
		Label l1 = new Label();
		Label l2 = new Label();
		Label l3 = new Label();
		Label l4 = new Label();
		mv.visitLookupSwitchInsn(l4, new int[] { 2938417, 2971187, 3003957 }, new Label[] { l1, l2, l3 });
		
		//case "a123" (hashCode() and equals())
		mv.visitLabel(l1);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitLdcInsn("a123");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		Label l5 = new Label();
		mv.visitJumpInsn(IFNE, l5);
		mv.visitJumpInsn(GOTO, l4); //goto default
		
		// case "b456"
		mv.visitLabel(l2);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitLdcInsn("b456");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		Label l6 = new Label();
		mv.visitJumpInsn(IFNE, l6);
		mv.visitJumpInsn(GOTO, l4);
		
		//case "c789"
		mv.visitLabel(l3);
		mv.visitVarInsn(ALOAD, 1);
		mv.visitLdcInsn("c789");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
		Label l7 = new Label();
		mv.visitJumpInsn(IFNE, l7);
		mv.visitJumpInsn(GOTO, l4);
		
		//case "a123" code block
		mv.visitLabel(l5);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("aa");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		Label l8 = new Label();
		mv.visitLabel(l8);
		Label l9 = new Label();
		mv.visitJumpInsn(GOTO, l9);
		
		//case "b456" code block
		mv.visitLabel(l6);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("bb");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		Label l10 = new Label();
		mv.visitLabel(l10);
		mv.visitJumpInsn(GOTO, l9);
		
		//case "c789" code block
		mv.visitLabel(l7);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("cc");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		Label l11 = new Label();
		mv.visitLabel(l11);
		mv.visitJumpInsn(GOTO, l9);
		
		//default
		mv.visitLabel(l4);
		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("dd");
		mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		
		
		mv.visitLabel(l9);
		mv.visitInsn(RETURN);
		
		Label l12 = new Label();
		mv.visitLabel(l12);
		mv.visitLocalVariable("s", "Ljava/lang/String;", null, l0, l12, 0);
		mv.visitMaxs(2, 2);
		mv.visitEnd();
}
}
