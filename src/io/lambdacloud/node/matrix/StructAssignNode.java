package io.lambdacloud.node.matrix;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.tools.Tool;

import org.objectweb.asm.Type;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import io.lambdacloud.MethodGenHelper;
import io.lambdacloud.node.ExprNode;
import io.lambdacloud.node.Tools;
import io.lambdacloud.node.VariableNode;
import io.lambdacloud.util.Struct;

public class StructAssignNode extends ExprNode {
	public VariableNode var;
	public ExprNode value;
	
	//Keep the list of fields of a struct variable
	//For example the parsed variable_entity 'school.student.name' will be stored as
	//an object of VariableNode with 
	// var = VariableNode("school")
	// fields = ["student", "name"]
	public List<String> fields = new ArrayList<String>();

	public StructAssignNode(VariableNode var, ExprNode value) {
		this.var = var;
		this.value = value;

	}
	
	@Override
	public void _genCode(MethodGenHelper mg) {
		// TODO Auto-generated method stub
		var.genCode(mg);
		if(var.getType() != null) {
			
			String keys = Tools.join(this.fields.toArray(new String[0]),".");
			mg.visitLdcInsn(keys);
			value.genCode(mg);
			Tools.insertConversionInsn(mg, value.getType(), Type.getType(Object.class));
			mg.visitMethodInsn(Opcodes.INVOKEVIRTUAL, Tools.getClassNameForASM(Struct.class), 
					"putAll", "("+Type.getType(String.class)+Type.getType(Object.class)+")"+Type.getType(Struct.class), false);
		}
		if(genLoadInsn) {
			var.genCode(mg);
		}
	}
	
	public static void test() {
		Object o = new Struct();
		Struct s = (Struct)o;
	}

	@Override
	public Type getType(Deque<Object> stack) {
		return Type.getType(Struct.class);
	}

	@Override
	public void updateType(Deque<Object> stack) {
		if(this.fields.size() == 1) {
			var.setElementType(var.getType(), this.fields.get(0), value.getType());
		} else if(this.fields.size() > 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(fields.get(0));
			var.setElementType(var.getType(), sb.toString(), Type.getType(Struct.class));
			for(int i=1; i<this.fields.size()-1; i++) {
				sb.append(".").append(this.fields.get(i));
				var.setElementType(var.getType(), sb.toString(), Type.getType(Struct.class));
			}
			sb.append(".").append(this.fields.get(this.fields.size()-1));
			var.setElementType(var.getType(), sb.toString(), value.getType());
		}
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
		if(this.value == oldNode)
			this.value = newNode;
	}

	@Override
	public void updateTree(MethodGenHelper mg) {
	}

}
