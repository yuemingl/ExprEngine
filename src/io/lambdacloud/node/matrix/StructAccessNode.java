package io.lambdacloud.node.matrix;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.util.Struct;

/**
 * a.b.c
 * 
 * @author yueming.liu
 *
 */
public class StructAccessNode extends ExprNode {
	public VariableNode var;
	
	//Keep the list of fields of a struct variable
	//For example the parsed variable_entity 'school.student.name' will be stored as
	//an object of VariableNode with 
	// var = VariableNode("school")
	// fields = ["student", "name"]
	public List<String> fields = new ArrayList<String>();

	@Override
	public void _genCode(MethodGenHelper mg) {
		// TODO Auto-generated method stub
		var.genCode(mg);
		if(var.getType() != null) {
			for(int i=0; i<this.fields.size(); i++) {
				mg.visitLdcInsn(fields.get(i));
				mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Tools.getClassNameForASM(Struct.class), 
						"get", "("+Type.getType(Object.class)+")"+Type.getType(Object.class), false);
				if(i <this.fields.size()-1) {
					mg.visitTypeInsn(Opcodes.CHECKCAST, Tools.getClassNameForASM(Struct.class));
					//Tools.insertConversionInsn(mg, Type.getType(Object.class), Type.getType(Struct.class));
				}
			}
			Type eleType = var.getElementType(Tools.join(fields.toArray(new String[0]), "."));
			if(eleType != null) {
				if(eleType.getSort() == Type.OBJECT)
					mg.visitTypeInsn(Opcodes.CHECKCAST, eleType.getInternalName());
				else {
					Tools.insertConversionInsn(mg, Type.getType(Object.class), eleType);
					
				}
			}

		}
		
	}

	@Override
	public Type getType(Deque<Object> stack) {
		Type ty = var.getElementType(Tools.join(fields.toArray(new String[0]), "."));
		if(ty != null) {
			return ty;
		}
		return Type.getType(Object.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
	}

	@Override
	public boolean contains(ExprNode target) {
		if(this == target)
			return true;
		if(this.var.contains(target))
			return true;
		return false;
	}

	@Override
	public void replaceChild(ExprNode oldNode, ExprNode newNode) {
		if(this.var == oldNode)
			this.var = (VariableNode)newNode;
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
	}
}
