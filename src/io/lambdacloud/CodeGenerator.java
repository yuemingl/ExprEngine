package io.lambdacloud;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CodeGenerator implements Opcodes {

	ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
	MethodVisitor mv;

	public CodeGenerator() {
	}
	
	public void startClass(String clsName, String[] interfaces) {
		cw.visit(Opcodes.V1_8, ACC_PUBLIC + ACC_SUPER, clsName, null, "java/lang/Object",
				interfaces);
		
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
		mv.visitLocalVariable("this", "L"+clsName+";", null, l0, l1, 0);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
	}
	
	public void endClass() {
		cw.visitEnd();
	}
	
	public void startMethod(int access, String name, String type) {
		mv = cw.visitMethod(access, name, type, null, null);
	}
	
	Label l0 = new Label();
	Label l1 = new Label();
	
	public void startCode() {
		mv.visitCode();
		mv.visitLabel(l0);
	}
	
	public MethodVisitor getMV() {
		return this.mv;
	}
	
	public void endCode() {
		mv.visitLabel(l1);
		mv.visitEnd();
	}
	
	public byte[] dump() throws Exception {
		return cw.toByteArray();
	}

	public static void main(String[] args) {
		ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
		try {
			CodeGenerator cgen = new CodeGenerator();
			String clsName = "Test";
			cgen.startClass(clsName, null);
			cgen.startMethod(Opcodes.ACC_PUBLIC, "eval","(DD)D");
			cgen.startCode();
			
			MethodVisitor mv = cgen.getMV();
			mv.visitLdcInsn(10.0);
			mv.visitLdcInsn(2.0);
			mv.visitInsn(DADD);
			mv.visitInsn(DRETURN);
			
			mv.visitLocalVariable("this", "L"+clsName+";", null, cgen.l0, cgen.l1, 0);
			mv.visitLocalVariable("a", "D", null, cgen.l0, cgen.l1, 1);
			mv.visitLocalVariable("b", "D", null, cgen.l0, cgen.l1, 3);
			mv.visitMaxs(4, 5);
			
			cgen.endCode();
			cgen.endClass();
			
			byte[] bcode = cgen.dump();
			Class<?> c = mcl.defineClassForName(null, bcode);
			for (Method m : c.getMethods()) {
				System.out.println(m.getName());
			}
			Method m1 = c.getMethod("eval", double.class, double.class);
			Object o = c.newInstance();
			System.out.println(m1.invoke(o, 1, 2));
			
			FileOutputStream fos = new FileOutputStream(clsName+".class");
			fos.write(bcode);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
