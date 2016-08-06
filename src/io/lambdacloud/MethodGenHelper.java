package io.lambdacloud;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

import io.lambdacloud.node.VariableNode;

public class MethodGenHelper {
	private MethodVisitor mv;
	public Map<String, VariableNode> varMap;
	private int idxLVTGen = 0;
	
	
	public Stack<Label> labelForIncStackTag = new Stack<Label>();
	public VariableNode retNodeTag;
	

	public MethodGenHelper(MethodVisitor mv, Map<String, VariableNode> varMap) {
		this.mv = mv;
		this.varMap = varMap;
	}

	public void updateLVTIndex(boolean isStatic) {
		idxLVTGen = 1;
		if(isStatic) idxLVTGen = 0;
		for(Entry<String, VariableNode> e : varMap.entrySet()) {
			if(e.getValue().isLocalVar()) continue;
			VariableNode var = e.getValue();
			var.idxLVT = idxLVTGen;
			if(var.getType().getSort() == Type.DOUBLE)
				idxLVTGen += 2;
//			else if(var.getType().getSort() == Type.OBJECT)
//				idxLVTGen += 2; //64bit JVM
			else
				idxLVTGen++;
		}
		for(Entry<String, VariableNode> e : varMap.entrySet()) {
			if(e.getValue().isParameter()) continue;
			VariableNode var = e.getValue();
			var.idxLVT = idxLVTGen;
			if(var.getType().getSort() == Type.DOUBLE)
				idxLVTGen += 2;
//			else if(var.getType().getSort() == Type.OBJECT)
//				idxLVTGen += 2; //64bit JVM
			else
				idxLVTGen++;
		}
	}
	
	public VariableNode newLocalVariable(String varName, Type type) {
		VariableNode node = VariableNode.newLocalVar(varName, type);
		node.idxLVT = this.idxLVTGen;
		if(node.getType().getSort() == Type.DOUBLE)
			this.idxLVTGen += 2;
		else
			this.idxLVTGen++;
		if(null != this.varMap.get(varName))
			throw new RuntimeException("Local variable '"+varName+"' exist!");
		this.varMap.put(varName, node);
		return node;
	}
	
	///////////////////////////////////////////////////////////////
	
	public void visitParameter(String name, int access) {
		mv.visitParameter(name, access);
	}

	public AnnotationVisitor visitAnnotationDefault() {
		return mv.visitAnnotationDefault();
	}

	public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
		return mv.visitAnnotation(desc, visible);
	}

	public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		return mv.visitTypeAnnotation(typeRef, typePath, desc, visible);
	}

	public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
		return mv.visitParameterAnnotation(parameter, desc, visible);
	}

	public void visitAttribute(Attribute attr) {
		mv.visitAttribute(attr);
	}

	public void visitCode() {
		mv.visitCode();
	}

	public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
		mv.visitFrame(type, nLocal, local, nStack, stack);
	}

	public void visitInsn(int opcode) {
		mv.visitInsn(opcode);

	}

	public void visitIntInsn(int opcode, int operand) {

		mv.visitIntInsn(opcode, operand);

	}

	public void visitVarInsn(int opcode, int var) {

		mv.visitVarInsn(opcode, var);

	}

	public void visitTypeInsn(int opcode, String type) {
		mv.visitTypeInsn(opcode, type);
	}

	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		mv.visitFieldInsn(opcode, owner, name, desc);
	}

	@Deprecated
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		mv.visitMethodInsn(opcode, owner, name, desc);
	}

	public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
		mv.visitMethodInsn(opcode, owner, name, desc, itf);
	}

	public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
		mv.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
	}

	public void visitJumpInsn(int opcode, Label label) {
		mv.visitJumpInsn(opcode, label);
	}

	public void visitLabel(Label label) {
		mv.visitLabel(label);
	}

	public void visitLdcInsn(Object cst) {
		mv.visitLdcInsn(cst);
	}

	public void visitIincInsn(int var, int increment) {
		mv.visitIincInsn(var, increment);
	}

	public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
		mv.visitTableSwitchInsn(min, max, dflt, labels);
	}

	public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
		mv.visitLookupSwitchInsn(dflt, keys, labels);
	}

	public void visitMultiANewArrayInsn(String desc, int dims) {
		mv.visitMultiANewArrayInsn(desc, dims);
	}

	public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		return mv.visitInsnAnnotation(typeRef, typePath, desc, visible);
	}

	public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
		mv.visitTryCatchBlock(start, end, handler, type);
	}

	public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
		return mv.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
	}

	public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
		mv.visitLocalVariable(name, desc, signature, start, end, index);
	}

	public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end,
			int[] index, String desc, boolean visible) {
		return mv.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
	}

	public void visitLineNumber(int line, Label start) {
		mv.visitLineNumber(line, start);
	}

	public void visitMaxs(int maxStack, int maxLocals) {
		mv.visitMaxs(maxStack, maxLocals);
	}

	public void visitEnd() {
		mv.visitEnd();
	}
}
