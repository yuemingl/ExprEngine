package io.lambdacloud.node;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import io.lambdacloud.ExprTreeBuildWalker;
import io.lambdacloud.MethodGenHelper;

public class FuncCallNode extends ExprNode {
	String fullClassName;
	String methodName;
	public List<ExprNode> args = new ArrayList<ExprNode>();
	
	public boolean isDynamicCall; //true to use invodedynamic instruction
	public boolean isPopReturn = false;
	
	//This is used to determine if it is a dynamic call when generating code
	public FuncDefNode refFuncDefNode;

	public FuncCallNode(String fullClassName, String methodName, boolean isDynamicCall) {
		this.fullClassName = fullClassName;
		this.methodName = methodName;
		this.isDynamicCall = isDynamicCall;
	}

	public String getFullClassName() {
		if(null != refFuncDefNode)
			return this.refFuncDefNode.getFuncClassName();
		else
			return this.fullClassName;
	}
	
	public String getMethodName() {
		if(null != this.refFuncDefNode)
			return this.refFuncDefNode.name;
		else
			return this.methodName;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("call ").append(this.fullClassName).append(".").append(this.methodName).append("(");
		for (int i = args.size() - 1; i >= 0; i--) {
			sb.append(args.get(i)).append(", ");
		}
		sb.append(")");
		return sb.toString();
	}

	public Class<?>[] getParameterClassTypes() {
		List<Class<?>> ret = new ArrayList< Class<?> >();
		for (int i = args.size() - 1; i >= 0; i--) {
			if(args.get(i).getType().getSort() != Type.VOID)
				ret.add(Tools.typeToClass(args.get(i).getType()));
		}
		return ret.toArray(new Class<?>[0]);
	}

	public Type[] getParameterTypes() {
		Type[] ret = new Type[args.size()];
		for (int i = args.size() - 1; i >= 0; i--) {
			ret[args.size() - 1 - i] = args.get(i).getType();
		}
		return ret;
	}

	public void genCode(MethodGenHelper mg) {

		if(null != this.refFuncDefNode) {
			String sFuncCall = Type.getMethodDescriptor(this.getType(), this.getParameterTypes());
			//System.out.println("FuncCallNode: genCode: "+sFuncCall);
			if(!this.refFuncDefNode.generatedClasses.containsKey(sFuncCall))
				this.isDynamicCall = true;
			else
				this.isDynamicCall = false;
		}
		
		if (isDynamicCall) { //ExprTreeBuildWalker.funcMap must contain the key this.methodName
			MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
					MethodType.class);
			
			Handle bootstrapHandle = new Handle(Opcodes.H_INVOKESTATIC, 
					Type.getType(ExprTreeBuildWalker.class).getInternalName(), //"io/lambdacloud/ExprTreeBuildWalker"
					"bootstrap", mt.toMethodDescriptorString());
			for (int i = args.size() - 1; i >= 0; i--) {
				args.get(i).genCode(mg);
			}
			Type retType = this.getType();
			mg.visitInvokeDynamicInsn(this.methodName,
					Type.getMethodDescriptor(retType, this.getParameterTypes()), bootstrapHandle, new Object[0]);
			if(retType.getSort() != Type.VOID && this.isPopReturn) {
				if(retType.getSort()==Type.DOUBLE || retType.getSort() == Type.LONG)
					mg.visitInsn(Opcodes.POP2);
				else
					mg.visitInsn(Opcodes.POP);
			}
				
		} else { // 
			FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			if(fnode == null) {
				//Find return type
				Class<?> c;
				try {
					c = Class.forName(fullClassName);
					Method m = c.getMethod(methodName, this.getParameterClassTypes());
					//Class<?>[] argTypes = m.getParameterTypes();
					for (int i = args.size() - 1; i >= 0; i--) {
						//auto type conversion
						ExprNode arg = args.get(i);
						arg.genCode(mg);
						//Tools.insertConversionInsn(mg, arg.getType(), Type.getType(argTypes[i]));
					}
					mg.visitMethodInsn(INVOKESTATIC, fullClassName.replaceAll("\\.", "/"), methodName,
							Type.getMethodDescriptor(m), false);
					Type retType = Type.getType(m.getReturnType());
					if(retType.getSort() != Type.VOID && this.isPopReturn) {
						if(retType.getSort()==Type.DOUBLE || retType.getSort() == Type.LONG)
							mg.visitInsn(Opcodes.POP2);
						else
							mg.visitInsn(Opcodes.POP);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				//We need specify parameter types before inferring return type
				fnode.setParamTypes(null, this.getParameterTypes());
				Type retType = fnode.inferRetType();
				for (int i = args.size() - 1; i >= 0; i--) {
					args.get(i).genCode(mg);
				}
				mg.visitMethodInsn(INVOKESTATIC, fullClassName.replaceAll("\\.", "/"), methodName,
						Type.getMethodDescriptor(retType, this.getParameterTypes()), false);
				if(retType.getSort() != Type.VOID && this.isPopReturn) {
					if(retType.getSort()==Type.DOUBLE || retType.getSort() == Type.LONG)
						mg.visitInsn(Opcodes.POP2);
					else
						mg.visitInsn(Opcodes.POP);
				}
			}
		}
	}

	@Override
	public Type getType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return null;
		stack.push(this);
		
		if (isDynamicCall) {
			FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			
			//We need specify parameter types before inferring return type
			fnode.setParamTypes(stack, this.getParameterTypes());
			Type retType = fnode.inferRetType(stack);
			
			stack.pop();
			return retType;
		} else {
			FuncDefNode fnode = ExprTreeBuildWalker.funcMap.get(this.methodName);
			if(fnode == null) {
//				if(this.methodName.equals("println")) {
//					//For expression which ended with ';' println(arg) is added automatically. The type of arg is returned in this case
//					if(this.args.get(0) instanceof DupNode) {
//						return this.args.get(0).getType(stack);
//					}
//					return Type.VOID_TYPE;
//				}
				Class<?> c;
				try {
					c = Class.forName(fullClassName);
					Method m = c.getMethod(methodName, this.getParameterClassTypes());
					Type retType = Type.getType(m.getReturnType());
					stack.pop();
					return retType;
				} catch (Exception e) {
					e.printStackTrace();
				}
				stack.pop();
				return null;
			} else {
				//We need specify parameter types before inferring return type
				fnode.setParamTypes(stack, this.getParameterTypes());
				Type retType = fnode.inferRetType(stack);
				stack.pop();
				return retType;
			}
		}
	}
	
	public double test(double x) {
		return Math.abs(x);
	}
	
	@Override
	public void updateType(Deque<Object> stack) {
		//circle check
		if(stack.contains(this)) 
			return;
		stack.push(this);
		for(ExprNode arg : args) {
			arg.updateType(stack);
		}
		stack.pop();
	}
}
