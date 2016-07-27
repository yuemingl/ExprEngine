package io.lambdacloud.test;

import java.io.FileOutputStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import io.lambdacloud.CodeGenerator;
import io.lambdacloud.ExprClassLoader;
import io.lambdacloud.exprengine.ExprTreeBuildWalker;

import static io.lambdacloud.ExprEngine.genStaticMethod;
import static io.lambdacloud.ExprEngine.parse;
import static org.objectweb.asm.Opcodes.*;

public class TestInvokeDynamic {
	// Method I want to dynamically invoke
	public static int plus(int a, int b) { 
		return a + b;
	}

	public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws Exception {
		System.out.println("bootstrap");
		String tt = type.toMethodDescriptorString();
		tt = tt.replaceAll("\\(|\\)", "_");
		ExprTreeBuildWalker ew = parse("x+y", type.parameterArray()[0]);
		Class<?> cls = ew.genClass("myclass"+tt, true, "plus2", true);

//		MethodHandle mh = MethodHandles.lookup().findStatic(TestInvokeDynamic.class, "plus",
//				MethodType.methodType(int.class, int.class, int.class));
		
//		MethodHandle mh = MethodHandles.lookup().findStatic(cls, "plus2",
//				MethodType.methodType(int.class, int.class, int.class));

		MethodHandle mh = MethodHandles.lookup().findStatic(cls, "plus2",
		MethodType.methodType(type.returnType(),type.parameterArray()));

		System.out.println(type.toMethodDescriptorString());
		return new ConstantCallSite(mh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExprClassLoader mcl = new ExprClassLoader(CodeGenerator.class.getClassLoader());
		try {
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
			String clsName = "MyClass3";
			cw.visit(Opcodes.V1_8, ACC_PUBLIC + ACC_SUPER, clsName, null, "java/lang/Object",
					null);
			
			MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			
			//Constructor
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


			mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

			//mv.visitMethodInsn(INVOKESTATIC, "io/lambdacloud/TestInvokeDynamic", "plus", "(II)I");

			MethodType mt = MethodType.methodType(CallSite.class, 
					MethodHandles.Lookup.class, String.class, MethodType.class);
			
			//Handle bootstrap = new Handle(Opcodes.INVOKESTATIC, "package1/Test2", "bootstrap",
			//		mt.toMethodDescriptorString());
			Handle bootstrapHandle = new Handle(Opcodes.H_INVOKESTATIC, "io/lambdacloud/TestInvokeDynamic",
			        "bootstrap", mt.toMethodDescriptorString());
			
			mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitIntInsn(BIPUSH, 42);
			mv.visitIntInsn(BIPUSH, 24);
			mv.visitInvokeDynamicInsn("plus", "(II)I", bootstrapHandle, new Object[0]);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

			mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
			mv.visitLdcInsn(10.0);
			mv.visitLdcInsn(10.0);
			mv.visitInvokeDynamicInsn("plus", "(DD)D", bootstrapHandle, new Object[0]);
			mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

			
			mv.visitMaxs(-1, -1);
			mv.visitInsn(RETURN);
			
			mv.visitEnd();
			cw.visitEnd();

			byte[] bcode = cw.toByteArray();
			FileOutputStream fos = new FileOutputStream(clsName + ".class");
			fos.write(bcode);
			fos.close();

			Class<?> c = mcl.defineClassForName(null, bcode);
			Method m1 = c.getMethod("main", String[].class);
			
			//Bootstrap will be called only once
			m1.invoke(null, new Object[]{null});
			m1.invoke(null, new Object[]{null});
			m1.invoke(null, new Object[]{null});


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) {
		System.out.println("Hello");
	}

}
