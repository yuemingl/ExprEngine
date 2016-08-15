package io.lambdacloud.test;

import static io.lambdacloud.MatlabEngine.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jama.Matrix;
import io.lambdacloud.MatlabEngine;
import io.lambdacloud.node.matrix.MatrixAccessNode;

public class TestMatlabEngine {
	public static void main(String[] args){
		exec("A = [1 2; 3 4; 5 6]; size(A)");

		
		exec("function [A B]=myfun(), A=[1 2; 3 4]; B=[5 6 7 8]; end myfun()");
		exec("function [A B]=myfun(), A=1; B=2; end myfun()");

		exec("[C D]=[2 3]; C\n D\n");
		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n [C D]=[2 3]; C\n D\n");
		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [C D]=[A B]; C\n D\n");
		
		exec("a=1; b=2; c=3; d=4; [a b; c d]");
		exec("A=[1 2; 3 4]; B=[5 6 7 8]; [A B]");
		
		Jama.Matrix[] o = (Jama.Matrix[])exec("A=[1 2; 3 4]; B=[5 6 7 8]; [A B];");
		for(Jama.Matrix m : o) m.print(8, 2);
		
		exec("% aaa\n 3%4");
		exec("mod(3.0, 0.0)");
		exec("rem(3.0, 0.0)");
		exec("floor(1.1)");
		exec("ceil(1.1)");
		exec("fix(1.1)");
		exec("round(1.1)");
		exec("floor(-1.1)");
		exec("ceil(-1.1)");
		exec("fix(-1.1)");
		exec("round(-1.1)");
	
		exec("function a=fun(x), if x<0, return end a=x*x; end fun(1)");
		exec("function a=fun(x), if x<0, return end a=x*x; end fun(-1)");
		exec("function a=fun(x), if x<0, return end a=x*[1 2; 3 4]; end fun(1)");
		exec("function a=fun(x), if x<0, return end a=x*[1 2; 3 4]; end fun(-1)");

		exec("function fun(a), b=a+2; if b>3, return 0 end return b; end fun(1)");
		exec("function fun(a), b=a+2; if b>3, return 0 end return b; end fun(6)");
		//exec("function fun(a) b=a+2; return 1; end fun(1);");
		
		test2();
		test();
//	
	}
	public static void test2(){
		exec("'aaa'");
		exec("'aaa'+'bbbb'");
		
		exec("disp('GE: A must be a square matrix');");

		exec(" 1~=2 ");
		exec("if 1~=2, 3 end");
		exec("for i in 1:3, i end");

		
		exec("a=[1 2;3 4]; a+=1; a");
		
//		exec("function myfun(n); a=n; a+=1.5; a=3; a end myfun(3)");
//		exec("function myfun(n); R=zeros(n); R end myfun(3)");
//		exec("function myfun(n); R=zeros(n); R end myfun(3.5)");
		
		//VariableNode.mapLVTIndex is set at constructor
		exec("a=1; a=2L; a=1.1; a");
		
		exec("A=[1 2; 3 4]; A*= 10; A");
		

	//	if(true) return;
		
		exec("if 1>2; 1+2; 2+2; elseif 2>3; 0+1; elseif 3>4; 1+2; else 2+3; 3/4; 5*7; end");
//		exec("if 1>2; 1; elseif 1<2; 4; end");

		exec("for i in 1:10; i end");
		exec("if n>1; 10 else -10 end", new int[]{2});
		exec("for i=1:3; for j=10:10:30; i+j end end");
		
		exec("A=[1 2; 3 4]; A(1,:)=[100 200]; A");
		exec("A=[1 2; 3 4]; A(1,1)=[100]; A");//???
		exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,1:2:5)=[100 200 300; 111 222 333]; A");
		
		exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,:)=300; A");
		exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(1,1)=300; A");
		exec("A=[1 2 3 4 5 6; 11 22 33 44 55 66]; A(:,1:2:5)=300; A");
		
		exec("while i<10; i+=1; i end", new int[]{5});
		exec("5 % 3");
		
//		exec("if (i%2)==0; a+=1; else b+=1; end a\n b\n", new int[]{4,10,0});
		exec("if mod(i,2)==0; a+=1; else b+=1; end a\n b\n", new int[]{4,10,0});
		exec("a=10; b=0; tic; while i<10; i+=1;  end toc; a\n b\n", new int[]{5});
	
//		exec("a=10; b=0; tic; while i<10; i+=1; if i%2==0; a+=1; else b+=1; end end toc; a\n b\n", new int[]{5});
		exec("a=10; b=0; tic; while i<10; i+=1; if mod(i,2)==0; a+=1; else b+=1; end end toc; a\n b\n", new int[]{5});

		exec("A=[1 2; 3 4]; A+=[10 20; 30 40]; A");
		exec("a=1; a+=1; a");
		exec("A=[1 2; 3 4]; A-=[10 20; 30 40]; A");
		
		exec("A=[1 2; 3 4]; A*= 10; A");
		exec("A=[1 2; 3 4]; A*=[1 2; 1 3]; A");
		exec("A    =    [1 2; 3 4]; A    *=     10; A");
		exec("A = [1 2; 3 4]; A *= [1 2; 1 3]; A");
		
		exec("math.sin(1.0)");
		exec("zeros(3,5)");
		exec("ones(3,5)");
		exec("eye(3,5)");
		exec("eye(5)");
		
		exec("A = [1 2; 3 4]; A(1,1)");
	
		exec(" A = [1 2; 1 -1]\n b=[5 -1]'\n A/=b; A");
		Jama.Matrix A = getMatrix(new double[][]{{1,2},{1,-1}});
		Jama.Matrix b = getMatrix(5,-1);
		A.print(8, 2);
		b.print(8, 2);
		A.solve(b).print(8, 2);
		
		exec("A = [1 2; 3 4]; A(:)");
		exec("A = [1 2; 3 4; 5 6]; size(A)");
		exec("A = [1 2; 3 4]; length(A)");

		exec("A = [1 2; 3 4]; A(1.0, 1)");

		exec("A = [1 2; 3 4; 5 6]\n reshape(A,2,3)");
		exec("A = [1 3; 4 2]\n repmat(A,2,3)");

		exec("A = [1 3; 4 2]; ones(A)");
		exec("A = [1 3; 4 2]; zeros(A)");
		
		exec("A = []; A\n length(A)\n numel(A)");
		
		exec("rand(3)");
		exec("rand(3,4)");
		
		exec("linspace(0,1,0.1)");
		
		


		exec("function H = invhilb(n)\n H = zeros(n)\n end invhilb(3)");
		exec("4^2");
		
		
		exec("r = -((n-j+1)*r*(n+j-1))/(j-1)^2; r", new double[]{1,2,3});
		

			
		exec("for i = 1:n; i end", new int[]{3});
		exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1))/(j-1)^2; end p = ((n-i)*p*(n+i))/(i^2); end", new int[]{3});
		exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1))/(j-1); end p = ((n-i)*p*(n+i))/(i^2); end", new int[]{3});
		exec("p=n; for i = 1:n; r = p*p; for j = i+1:n; r = -((n-j+1)*r*(n+j-1)); end p = ((n-i)*p*(n+i))/i end", new int[]{3});
		//exec("p=n; for i = 1:n; i^2  end", new int[]{3});
		//exec("p=n; for i = 1:n; p^2; end", new int[]{3});
		exec("if n>1; p^2 else p end", new int[]{2,3});

		exec("function H = invhilb(n); H=zeros(n); p = n; for i = 1:n; r = p*p;  p end r=0.0; p=0.0; end invhilb(3)");
//java.lang.IllegalArgumentException: wrong number of arguments
//		exec("-((n-j+1)*r*(n+j-1))/((j-1)*(j-1))",getMap("i",1,"j",2,"n",3,"r",9));
		exec("-((n-j+1)*r*(n+j-1))",getMap("j",2,"n",3,"r",9));
		exec("(n-j+1)*r*(n+j-1)",getMap("j",2,"n",3,"r",9));
		exec("r*(n+j-1)",getMap("j",2,"n",3,"r",9));
		exec("(n-j+1)*r",getMap("j",2,"n",3,"r",9));
		
		exec("n-j+1",getMap("j",2,"n",3)); //n-(j+1)???
		exec("n+j-1",getMap("j",2,"n",3)); //n-(j+1)???
		exec("n/j*2",getMap("j",2,"n",3)); //n-(j+1)???
		exec("(n/j)*2",getMap("j",2,"n",3)); //n-(j+1)???
		
		
		exec("((j-1)*(j-1))",getMap("j",2));
		//exec("-((n-j+1)*r*(n+j-1))/((j-1)*(j-1))",getMap("j",2,"n",3,"r",9));
		
		
		exec("3*[1 2;3 4]");
		exec("[1 2;3 4]*3");
		exec("[1 2;3 4]*[1 2;3 4]");
		
		exec("3+[1 2;3 4]");
		exec("[1 2;3 4]+3");
		exec("[1 2;3 4]+[1 2;3 4]");
		
		exec("3-[1 2;3 4]");
		exec("[1 2;3 4]-3");
		exec("[1 2;3 4]-[1 2;3 4]");
		
		exec("a=1; a=1.1; a");
		exec("a=1; a=a+1.1; a");
		exec("a=1; a=a+1.1; a=2; a");
		
		exec("a=[1 2;3 4]; a+=1; a");
		exec("a=1; a+=[1 2;3 4]; a");
		exec("a=1; a+=[1 2;3 4]; a=1.0; a");
		
		exec("a=[1 2;3 4]; a*=2; a");
		exec("a=2; a*=[1 2;3 4]; a");
		exec("a=2; a*=[1 2;3 4]; a=1.0; a");

		exec("a=[1 2;3 4]; a-=1; a");
		exec("a=1; a-=[1 2;3 4]; a");
		exec("a=1; a-=[1 2;3 4]; a=1.0; a");
		
		exec("a=[1 2;3 4]; a%=2; a");
		exec("a=2; a%=[1 2;3 4]; a");
		exec("a=2; a%=[1 2;3 4]; a=1.0; a");
		
		exec("a=1; a+=1.5; a");
		exec("a=1; a-=1.5; a");
		exec("a=1; a*=1.5; a");
		exec("a=1; a/=1.5; a");
		
		exec("[1 2;3 4] % 3");
		exec("[1 2;3 4]%[5 6 ;7 8]");
		exec("2%[1 2;3 4]");
		
		exec("A=[1 2; 3 4]; sz=size(A); m=sz(1,1); n=sz(1,2); m");
		
		exec("function GE(A); sz=size(A); m=sz(1,1); n=sz(1,2) end A=[1 2; 3 4]; GE(A)");
		
		exec("A=[1 2 3; 4 5 6;  7 8 9]; triu(A)");

		
		
		exec("function GE(A); sz=size(A); m=sz(1,1); n=sz(1,2); U=triu(A)\n m\n n\n end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)");
		exec("function GE(A); U=A; U end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)");
		exec("function U = GE(A); U=triu(A); end A=[1 2 3; 4 5 6; 7 8 9]; GE(A)");
		exec("A=[1 2 3; 4 5 6; 7 8 9]; for i=1:3; A(1:3,i) end");
		exec("A=[1 2 3; 4 5 6; 7 8 9]; A(1:3.0,1)");
		exec("A=[1 2 3; 4 5 6; 7 8 9]; A(1:3,1)=2*A(1:3,1)");
		
		
//		assertEqual(exec("function r=fib(n)\n  r=fib(n-1); end\n fib(42)"),433494437);
		
		exec("A=[1 2; 3 4]; S=[1 2]; S\n S=size(A)");
		exec("A=[1 2; 3 4]; S=[1 2]; S\n S(1,:)=size(A)");

		exec("A=[1 2  3; 4 5 6]; [m n]=size(A); m\n n\n");
		exec("A=[1 2  3; 4 5 6]; [m, n]=size(A); m\n n\n");
		exec("[m n]=[1 2]; m\n n\n");

	}
	
	public static void test() {
		double[][] array = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
		double[][] array2 = {{1.,2.,3},{1.,1.,1.},{2.,2.,2.}};
		double[][] array3 = {{1,2,3,4,5,6},{11,22,33,44,55,66}};
		Matrix A = new Matrix(array);
		Matrix B = new Matrix(array2);
		Matrix C = new Matrix(array3);
		Matrix b = Matrix.random(3,1); //column vector
		Matrix A1 = A.getMatrix(0,2,1,2);
		Matrix A2 = A.getMatrix(1,2,1,2);
		Matrix B1 = B.getMatrix(0,2,1,2);
		Matrix B2 = B.getMatrix(1,2,1,2);

		Matrix M = new Matrix(new double[][]{{1,2},{3,4}});
		Matrix N = new Matrix(new double[][]{{10,20},{30,40}});
		Matrix d = getMatrix(3,4); //column vector
		
		assertEqual(exec("C(   :  , :  )", getMap("C",C)), C);
		
		assertEqual(exec("A(1:3,2:3)+B(1:3,2:3)",  getMap("A",A,"B",B)), A1.plus(B1));

		
		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)"),433494437);

		assertEqual(exec("-A",    getMap("A",A)),       A.uminus());
		assertEqual(exec("A+B",   getMap("A",A,"B",B)), A.plus(B));
		assertEqual(exec("A-B",   getMap("A",A,"B",B)), A.minus(B));
		assertEqual(exec("A*B",   getMap("A",A,"B",B)), A.times(B));
//		assertEqual(exec("B/A",   getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A\\B",  getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A.*B",  getMap("A",A,"B",B)), A.arrayTimes(B));
		assertEqual(exec("A.\\B", getMap("A",A,"B",B)), A.arrayLeftDivide(B));
		assertEqual(exec("A./B",  getMap("A",A,"B",B)), A.arrayRightDivide(B));

		
//		assertEqual(exec("function r=fib(r, n); A=[1 1; 1 0]; if n<1; r=1; else r=A*r; r=fib(r, n-1); end end fib([1 1]', 5)"), 
//		new Jama.Matrix(new double[]{13,8},2));

		assertEqual(exec("tic; toc; 1"),1);
		assertEqual(exec("tic; 9+10\n toc; 1"),1);

		assertEqual(exec("[1 2; 3 4] + [11 22; 33 44]"), getMatrix(new double[][]{{12,24},{36,48}}));
		assertEqual(exec("for i=1:2:10; i\n end"), null);
		assertEqual(exec("for i=1:10; i\n end"), null);
		assertEqual(exec("for i=1:10; i; end"), null);

		//Test order of parameters in function arguments
		assertEqual(exec("function fib(r, n); A=[1 1; 1 0]; if n<1; r; else r=A*r; fib(r, n-1); end end fib([1 1]', 5)"), 
				new Jama.Matrix(new double[]{13,8},2));
		assertEqual(exec("function fib(a, n); A=[1 1; 1 0]; if n<1; a; else a=A*a; fib(a, n-1); end end fib([1 1]', 5)"),
				new Jama.Matrix(new double[]{13,8},2));
		assertEqual(exec("function myfun(b, a); a-b; end myfun(3,1)"),-2);
		assertEqual(exec("function myfun(a, b); b-a; end myfun(3,1)"),-2);
		assertEqual(exec("function s=fun(n), s=n+1\n end fun(5);"),6);
		
		//Test order of parameters in the generated function
		assertEqual(exec("b-a",   getMap("a",1,"b",3)), 2);
		assertEqual(exec("a-b",   getMap("a",1,"b",3)), -2);
		assertEqual(exec("B/A",   getMap("A",B,"B",A)), A.solve(B));

		
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 5; 6+7\n 100\n 9; 8; end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5\n else s=8\n end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 7; 9; 8\n end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("if n<=1; r=5;r;1\n else 7; 9; 8; end",new int[]{8}), 8);
		assertEqual(MatlabEngine.exec("r=0; if n<=1; r=5\n end r",new int[]{0}), 5);
		assertEqual(MatlabEngine.exec("r=0; if n<=1; r=5; end r",new int[]{0}), 5);
		System.out.println(MatlabEngine.exec("1+1; 2\n r=9"));

		assertEqual(exec("function s=fun(n), s=n+1\n end fun(5);"),6);
		
		assertEqual(exec("function fib(n), if n<=1; 1; else fib(n-1)+fib(n-2); end; end; fib(42)"),433494437);
//		assertEqual(exec("function fib(n) if n<=1; 1; else fib(n-1)+fib(n-2); end end fib(42)"),433494437);
//java.lang.RuntimeException: Cannot infer type for if statement: if(var(n:I:param:0) <= 1) {[var(r:D:local:1)=1]} else {[var(r:D:local:1)=call FCfib9.fib(var(n:I:param:0) - 1, ) + call FCfib9.fib(var(n:I:param:0) - 2, )]}
//		at io.lambdacloud.node.IfNode.getType(IfNode.java:194)

		assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2); end\n end\n fib(42)"),433494437);
		//This case is hard to fix
		//the stack frame is not balanced
		//assertEqual(exec("function r=fib(n)\n if n<=1\n r=1; else r=fib(n-1)+fib(n-2)\n end end\n fib(42)"),433494437);

		assertEqual(exec("if 1>2; 3;   \nelse\n 4\n end"),4);
		assertEqual(exec("if 1>2; 3\n else\n 4\n end"),4);
		
		assertEqual(exec("if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec(" if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec(" if 1>2; 3\n else 4\n end "),4);
		assertEqual(exec("if 1>2; 3\n else 4\n end"),4);
		assertEqual(exec("if 1<2; 3\n else 4\n end"),3);
		
		assertEqual(exec("1 > 2"), false);
		assertEqual(exec("1 >= 2"), false);
		assertEqual(exec("1 < 2"), true);
		assertEqual(exec("1 <= 2"), true);
		assertEqual(exec("1 == 2"), false);
		assertEqual(exec("1 != 2"), true);
		
		assertEqual(exec("[10.0 20.0 30.0]'"), getMatrix(10,20,30));

		Matrix D = new Matrix(
				new double[]{1,2,3,4,5,6,7,8,9,10,
						11,12,13,14,15,16,17,18,19,20,
						21,22,23,24,25,26,27,28,29,30},
				10).transpose();
		
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A=[1 2 3 4 5 6 7 8 9 10; 11 12 13 14 15 16 17 18 19 20; 21 22 23 24 25 26 27 28 29 30]; A(1, 1:2)"), 
					D.getMatrix(0, 0, 0, 1));
			assertEqual(exec("C ( 2, 2:3:6 )", getMap("C",C)), C.getMatrix(1,1, new int[]{1,4}));
			assertEqual(exec("C(1, 1:2:6)", getMap("C",C)), C.getMatrix(0,0, new int[]{0,2,4}));
			assertEqual(exec("C(:, 1:2:6)", getMap("C",C)), C.getMatrix(0,1, new int[]{0,2,4}));
		} else {
			assertEqual(exec("A=[1 2 3 4 5 6 7 8 9 10; 11 12 13 14 15 16 17 18 19 20; 21 22 23 24 25 26 27 28 29 30]; A(0, 0:1)"), 
					D.getMatrix(0, 0, 0, 1));
			assertEqual(exec("C ( 1, 1:3:5 )", getMap("C",C)), C.getMatrix(1,1, new int[]{1,4}));
			assertEqual(exec("C(0, 0:2:5)", getMap("C",C)), C.getMatrix(0,0, new int[]{0,2,4}));
			assertEqual(exec("C(:, 0:2:5)", getMap("C",C)), C.getMatrix(0,1, new int[]{0,2,4}));
		}
		
		assertEqual(exec("C(   :  , :  )", getMap("C",C)), C);
		assertEqual(exec("C(:  , :)", getMap("C",C)), C);
		assertEqual(exec("C(:, :)", getMap("C",C)), C);
		assertEqual(exec("C(:,:)", getMap("C",C)), C);

		assertEqual(exec("0.0 : 0.5 : 1.6"), new double[]{0,0.5,1,1.5});
		assertEqual(exec("0.0 : 0.5 : 1.4"), new double[]{0,0.5,1});
		assertEqual(exec("0.0 : 0.5 : 1.5"), new double[]{0,0.5,1,1.5});
		assertEqual(exec("1:2:6"), new int[]{1,3,5});
		assertEqual(exec("1:2:5"), new int[]{1,3,5});
		assertEqual(exec("1:5"), new int[]{1,2,3,4,5});

		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(:,2:3)", getMap("A",A)), A.getMatrix(0,2,1,2));
			assertEqual(exec("A=[1 2;3 4]\n A(:,1)"), getMatrix(1,3));
			assertEqual(exec("A=[1 2;3 4]\n A(2,:)"), getMatrix(3,4).transpose());
			assertEqual(exec("A=[1 2;3 4]\n A(:,:)"), M);
		} else {
			assertEqual(exec("A(:,1:2)", getMap("A",A)), A.getMatrix(0,2,1,2));
			assertEqual(exec("A=[1 2;3 4]\n A(:,0)"), getMatrix(1,3));
			assertEqual(exec("A=[1 2;3 4]\n A(1,:)"), getMatrix(3,4).transpose());
			assertEqual(exec("A=[1 2;3 4]\n A(:,:)"), M);
		}

		assertEqual(exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10,100)"), getMatrix(110,-90).transpose());
		assertEqual(exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10,100)"), getMatrix(110,-90).transpose());
		assertEqual(exec("function [c d]=myfun(a, b)\n c=a+b\n d=a-b\n end\n myfun(10.,100.)"), getMatrix(110,-90).transpose());
		assertEqual(exec("function myfun(a, b)\n c=a+b\n d=a-b\n [c d]\n end\n myfun(10.,100.)"), getMatrix(110,-90).transpose());
		
		assertEqual(exec("function myfun(a)\n a+1\n a+2; end\n myfun(1)"), 3);
		assertEqual(exec("function myfun(a)\n a+1\n a+2\n end\n myfun(1)"), 3);
		assertEqual(exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1);"), 1);
		assertEqual(exec("function a=myfun(a)\n a+1\n a+2\n end\n myfun(1)"), 1);
		
		assertEqual(exec("M=[1 2; 3 4]\n d=[3 4]'\n M\\d"), M.solve(d));
		assertEqual(exec("M=[1 2; 3 4]; d=[3 4]'; M\\d"), M.solve(d));
		
		assertEqual(exec("a=2\n a"), 2);
		assertEqual(exec("a=2; a"), 2);
		assertEqual(exec("100+1; 200+1;"), 201);
		assertEqual(exec("10+1\n 20+1"), 21);

		assertEqual(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;a;b;a+1\nend\nmyfun(10,100)"), getMatrix(110,-90).transpose());
		assertEqual(exec("function [c d] = myfun(a, b)\nc=a+b; d=a-b;\nend\nmyfun(10,100)"), getMatrix(110,-90).transpose());
		assertEqual(exec("function c = myfun(a, b)\nc=a+b\nend\nmyfun(10,100)"),110);
	
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("a=[1, 2; 3, 4];  a(2, 2)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(2, 2)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(2,2)"), 4.0);
		} else {
//			myPrint(exec("fun(1, 1)"));
			assertEqual(exec("a=[1, 2; 3, 4];  a(1, 1)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(1, 1)"), 4.0);
			assertEqual(exec("a=[1 2; 3 4];  a(1,1)"), 4.0);
		}
		
		
		//white space test
		assertEqual(exec("A=[1 2; 3 4];B=[10 20; 30 40]; A+B"), M.plus(N));
		assertEqual(exec("A=[1 2; 3 4];  B=[10 20; 30 40]; A+B"), M.plus(N));
		assertEqual(exec("A=  [1 2; 3 4]; A +  [10 20; 30 40]  ;  "), M.plus(N));

		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(1:3,2:3)+B(1:3,2:3)",  getMap("A",A,"B",B)), A1.plus(B1));
			assertEqual(exec("A(2:3,2:3)-B(2:3,2:3)",  getMap("A",A,"B",B)), A2.minus(B2));
			assertEqual(exec("A(2:3,2:3)*B(2:3,2:3)",  getMap("A",A,"B",B)), A2.times(B2));
			assertEqual(exec("A(2:3,2:3).*B(2:3,2:3)", getMap("A",A,"B",B)), A2.arrayTimes(B2));
			assertEqual(exec("A(2:3,2:3)./B(2:3,2:3)", getMap("A",A,"B",B)), A2.arrayRightDivide(B2));
		} else {
			assertEqual(exec("A(0:2,1:2)+B(0:2,1:2)",  getMap("A",A,"B",B)), A1.plus(B1));
			assertEqual(exec("A(1:2,1:2)-B(1:2,1:2)",  getMap("A",A,"B",B)), A2.minus(B2));
			assertEqual(exec("A(1:2,1:2)*B(1:2,1:2)",  getMap("A",A,"B",B)), A2.times(B2));
			assertEqual(exec("A(1:2,1:2).*B(1:2,1:2)", getMap("A",A,"B",B)), A2.arrayTimes(B2));
			assertEqual(exec("A(1:2,1:2)./B(1:2,1:2)", getMap("A",A,"B",B)), A2.arrayRightDivide(B2));
		}
		
		assertEqual(exec("-A",    getMap("A",A)),       A.uminus());
		assertEqual(exec("A+B",   getMap("A",A,"B",B)), A.plus(B));
		assertEqual(exec("A-B",   getMap("A",A,"B",B)), A.minus(B));
		assertEqual(exec("A*B",   getMap("A",A,"B",B)), A.times(B));
//		assertEqual(exec("B/A",   getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A\\B",  getMap("A",A,"B",B)), A.solve(B));
		assertEqual(exec("A.*B",  getMap("A",A,"B",B)), A.arrayTimes(B));
		assertEqual(exec("A.\\B", getMap("A",A,"B",B)), A.arrayLeftDivide(B));
		assertEqual(exec("A./B",  getMap("A",A,"B",B)), A.arrayRightDivide(B));
		
		//no longer supported for array
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		//myPrint(exec("A(1,1:2)", getMap("A",array)));
		
		if(MatrixAccessNode.INDEX_BASE == 1) {
			assertEqual(exec("A(3,2:3)", getMap("A",A)), A.getMatrix(2,2,1,2));
			assertEqual(exec("A(2:3,3)", getMap("A",A)), A.getMatrix(1,2,2,2));
		} else {
			assertEqual(exec("A(2,1:2)", getMap("A",A)), A.getMatrix(2,2,1,2));
			assertEqual(exec("A(1:2,2)", getMap("A",A)), A.getMatrix(1,2,2,2));
		}
		
		assertEqual(exec("[1. .2 3.]"), getMatrix(1,0.2,3).transpose());
		
		assertEqual(exec("A\\b", getMap("A",A,"b",b)), A.solve(b));
		
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]"), A);
		assertEqual(exec("[1 2 3; 4 5 6; 7 8 10]'"), A.transpose());
		assertEqual(exec("A'", getMap("A",M)), M.transpose());

		assertEqual(exec("a + b  ", getMap("a",M,"b",N)), M.plus(N));
		assertEqual(exec("a+b", getMap("a",2,"b",3)), 5);
		
		
		assertEqual(exec("[10.0 20.0 30.0]"), getMatrix(10,20,30).transpose());
		
		assertEqual(exec("[1 2 3]"), getMatrix(1,2,3).transpose());
		assertEqual(exec("[1,2,3]"), getMatrix(1,2,3).transpose());
		assertEqual(exec("[1, 2, 3]"), getMatrix(1,2,3).transpose());
		assertEqual(exec("[1  2   3]"), getMatrix(1,2,3).transpose());
		assertEqual(exec("[1,  2  ,  3]"), getMatrix(1,2,3).transpose());
	}
	
	public static Jama.Matrix getMatrix(double ...args) {
		return new Jama.Matrix(args, args.length);
	}
	
	public static Jama.Matrix getMatrix(double[][] args) {
		return new Jama.Matrix(args);
	}
	
	public static void assertEqual(Object o1, Object o2) {
		if(null == o1 && null == o2) return;
		if(o1 instanceof int[][] && o2 instanceof int[][]) {
			int[][] o11 = (int[][])o1;
			int[][] o22 = (int[][])o2;
			for(int i=0; i<o11.length; i++)
				assertEqual(o11[i],o22[i]);
			return;
		}
		else if(o1 instanceof int[] && o2 instanceof int[]) {
			int[] a = (int[])o1;
			int[] b = (int[])o2;
			if(a.length != b.length)
				throw new RuntimeException("Assert fail! Length: "+a.length+" != "+b.length);
			for(int i=0; i<a.length; i++) {
				if(a[i] != b[i])
					throw new RuntimeException("Assert fail!  "+a[i]+" != "+b[i]);
			}
			return;
		} else if(o1 instanceof double[] && o2 instanceof double[]) {
			double[] a = (double[])o1;
			double[] b = (double[])o2;
			if(a.length != b.length)
				throw new RuntimeException("Assert fail! Length: "+a.length+" != "+b.length);
			for(int i=0; i<a.length; i++) {
				if(a[i] != b[i])
					throw new RuntimeException("Assert fail!  "+a[i]+" != "+b[i]);
			}
			return;
		} else if(o1 instanceof List && o2 instanceof List) {
			List<?> l1 = (List<?>)o1;
			List<?> l2 = (List<?>)o2;
			if(l1.size() != l2.size())
				throw new RuntimeException("Assert fail!  Length: "+l1.size()+" != "+l2.size());
			for(int i=0; i<l1.size(); i++) {
				assertEqual(l1.get(i), l2.get(i));
			}
			return;
		} else if(o1 instanceof Jama.Matrix && o2 instanceof Jama.Matrix) {
			Jama.Matrix m1 = (Jama.Matrix)o1;
			Jama.Matrix m2 = (Jama.Matrix)o2;
			double norm = m1.minus(m2).norm2();
			if(norm <1e-8)
				return;
		}
		if(!o1.equals(o2)) {
			System.err.println(o1 + " != "+o2);
			throw new RuntimeException("Assert fail!");
		}
	}
	
	public static void myPrint(Object o) {
		if(o instanceof double[]) {
			double[] a = (double[])o;
			System.out.print("[");
			for(double d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof int[]) {
			int[] a = (int[])o;
			System.out.print("[");
			for(int d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else if(o instanceof Jama.Matrix) {
			((Jama.Matrix)o).print(8, 2);;
		}
		else {
			System.out.println(o);
		}
	}
	
	public static int arrayArgFunc(int[] arg) {
		return arg[0];
	}
	
	public static Map<String, Object> getMap(Object ...args) {
		Map<String, Object> ret = new HashMap<String, Object>();
		for(int i=0; i<args.length; i+=2) {
			ret.put(args[i].toString(), args[i+1]);
		}
		return ret;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getList(Object ...e) {
		List ret = new ArrayList();
		for(Object o : e) 
			ret.add(o);
		return ret;
	}
}
