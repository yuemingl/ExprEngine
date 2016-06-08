package io.lambdacloud;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.*;
import org.objectweb.asm.*;

public class CodeGenerator implements Opcodes {

	ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
	//ClassWriter cw = new ClassWriter(0);
	MethodVisitor mv;

	public CodeGenerator() {
		
	}
	
	//
	public void startClass(String clsName) {
		//"com/openx/asm_test/Test1"
		cw.visit(52, ACC_PUBLIC + ACC_SUPER, clsName, null, "java/lang/Object",
				new String[] {});
		
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		Label l0 = new Label();
		mv.visitLabel(l0);
		mv.visitLineNumber(3, l0);
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(RETURN);
		Label l1 = new Label();
		mv.visitLabel(l1);
		mv.visitLocalVariable("this", "Lcom/openx/asm_test/Test1;", null, l0, l1, 0);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
		
	}
	
	public void endClass() {
		cw.visitEnd();
	}
	
	public void startMethod(String name, String type) {
		//mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv = cw.visitMethod(ACC_PUBLIC, name, type, null, null);
		
	}
	
	Label l0 = new Label();
	Label l1 = new Label();
	
	public void startCode() {
		mv.visitCode();
		//Label l0 = new Label();
		mv.visitLabel(l0);
	}
	
	public MethodVisitor getMV() {
		return this.mv;
	}
	
	public void endCode() {
		//Label l1 = new Label();
		mv.visitLabel(l1);
		//
		//mv.visitLocalVariable("this", "Lcom/openx/asm_test/Test1;", null, l0, l1, 0);
		//mv.visitMaxs(1, 1);
		//
		mv.visitEnd();
	}
	
	
	public byte[] dump() throws Exception {
		return cw.toByteArray();
	}

	public static void main(String[] args) {
		ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
		try {
			// Class<?> c = mcl.defineClassForName("com.openx.asm_test.Test1",
			// Test1Dump.dump());
			
			CodeGenerator gg = new CodeGenerator();
			gg.startClass("myclass");
			gg.startMethod("eval","(DD)D");
			gg.startCode();
			
			MethodVisitor mv = gg.getMV();
			mv.visitLdcInsn(10.0);
			mv.visitLdcInsn(2.0);
			mv.visitInsn(DADD);
			mv.visitInsn(DRETURN);
			
			mv.visitLocalVariable("this", "Lcom/openx/asm_test/Test1;", null, gg.l0, gg.l1, 0);
			mv.visitLocalVariable("a", "D", null, gg.l0, gg.l1, 1);
			mv.visitLocalVariable("b", "D", null, gg.l0, gg.l1, 3);
			mv.visitMaxs(4, 5);
			
			
			gg.endCode();
			gg.endClass();
			
			byte[] bcode = gg.dump();
			Class<?> c = mcl.defineClassForName(null, bcode);
			for (Method m : c.getMethods()) {
				System.out.println(m.getName());
			}
			Method m1 = c.getMethod("eval", double.class, double.class);
			Object o = c.newInstance();
			System.out.println(m1.invoke(o, 1, 2));
			
			FileOutputStream fos = new FileOutputStream("test.class");
			fos.write(bcode);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
