# ExprEngine
ExprEngine compiles a string of expression to java bytecode in memory at runtime. The bytecode represents a static method or a class which implements a user defined interface. The method can be called as normal Java method and returns Java object. Some simple examples are shown in following codes.  

#### 1. Quick examples: exec() -> parse, compile and run. (Note: the Java bytecode will be generated each time when using function ExprEngine.exec(). See examples in sections 2,3 and 4 below for more efficient ways.)
```Java
import static io.lambdacloud.ExprEngine.exec;
...
//Basic expressions
System.out.println(exec("-x", new int[]{3}));
System.out.println(exec("x + y", new int[]{3,4}));
System.out.println(exec("x > y", new int[]{3,4}));
System.out.println(exec("x <= y and x > 0", new int[]{3,4}));
System.out.println(exec("a=x+y; a+2", new double[]{3.0,4.0}));
System.out.println(exec("(7^3) == (1<<2)"));
System.out.println(exec(" 'abc'+'def' "));
System.out.println(exec(" \"abc\"+'def' "));
System.out.println(exec("7**2"));

//If else 
System.out.println(exec("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new double[]{3,4}));
System.out.println("max(3,4)="+exec("a=if(x>y) {x} else {y}; a", new int[]{3,4}));

//While for loops
System.out.println(exec("while(x<y) {x=x+1} x", new int[]{1,4}));
System.out.println(exec("for(i=0;i<=n;i++) {x+=i} x", new int[]{100,0}));

//Array
System.out.println(exec("a=[10,20,30,40]; sum=0; for(i=0;i<4;i++) { sum+=a[i] } sum"));
System.out.println(Arrays.toString(
		(int[])exec("[x, y, 3, 4]", new Object[]{ 1,2 })));
System.out.println(Arrays.toString(
		(String[])exec("['abc', 'def', x]", new Object[]{"ghi"})));
System.out.println(Arrays.deepToString(
		(int[][])exec("[ [x], [y] ]", new Object[]{ 1,2 })));
System.out.println(Arrays.deepToString(
		(int[][][])exec("[ [[x],[y]], [[x+y]] ]", new Object[]{ 1,2 })));
System.out.println(Arrays.toString(
		(double[])exec("x[i+1:j-1]", new Object[]{1,4,new double[]{1,2,3,4,5}})));
System.out.println(Arrays.deepToString((int[][])exec("[1:3, 5:10, 100:101]")));

//List comprehension
System.out.println(exec("[x for x in A for y in B]",
				new Object[]{ new int[]{0,1,2}, new int[]{100,101,102} }));

System.out.println(exec("[x+y for x in A for y in B if x+y>=1000]",
				new Object[]{ new int[]{1,2,3}, new int[]{10,100,1000} }));

System.out.println(exec("[ x>3 for x in A ]", new Object[] {new int[]{1,2,3,4,5,6}}));

System.out.println(exec("[ x for x in A if x>3 ]", new Object[] {new int[]{1,2,3,4,5,6}}));

System.out.println(Arrays.deepToString(
		((List<int[][][]>)exec("[ [ [[x],[y]], [[x+y]] ] for x in A for y in B]",
		new Object[]{ new int[]{1,2}, new int[]{3,4} })).toArray()));

//Memory efficient range() function (no temp list generated)
System.out.println(exec("[x+10.0 for x in range(3)]")); //0,1,2
System.out.println(exec("[x+10.0 for x in 1:3]"));      //1,2,3
System.out.println(exec("[[1 for col in range(3)] for row in range(2)]"));

//Function and Recursive Function Call
long startTime = System.currentTimeMillis();
System.out.println("Fibonacci(46)="+exec("def fib(n) { if(n<=1) {1L} else {fib(n-1)+fib(n-2)} } fib(46)"));
System.out.println("Time: "+(System.currentTimeMillis()-startTime)+"ms");
//Output:
//Fibonacci(46)=2971215073
//Time: 9022ms
```

####  2. Parse and generate bytecode once, call as many times as you want. Use reflection to invoke the generated static method

```Java
import static io.lambdacloud.ExprEngine.genStaticMethod;
...
ExprTreeBuildWalker ew = parse("x+y", double.class);
Method m = genStaticMethod(ew, "myclass", false, "myfun");
try {
	for(int i=0; i<5; i++)
		System.out.println(m.invoke(null, i, 10.0));
} catch (Exception e) {
	e.printStackTrace();
}

```
	
#### 3. Parse and generate bytecode once, call as many times you want. Use method handle to invoke the generated static method
```Java
import static io.lambdacloud.ExprEngine.genMethodHandle;
...
ExprTreeBuildWalker ew = parse("x+y");
MethodHandle mh = genMethodHandle(ew, "myclass", false, "myfun", 
		double.class,  double.class, double.class);
try {
	for(int i=0; i<5; i++)
			System.out.println(mh.invoke(i, 10.0));
} catch (Throwable e) {
	e.printStackTrace();
}
```

#### 4. Declare an interface for your function.A class which implements the interface is generated and ready to use.
```Java
//Define your interface at somewhere
public interface Fun2 {
	double apply(double x, double y);
}

//Cast the generated object to the type of the interface you defined
...
ExprTreeBuildWalker ew = parse("x+y", Fun2.class);
Fun2 f = (Fun2)ExprEngine.newInstance(ew, "myclass", true);
System.out.println(f.apply(3,4));
...

```

#### More examples
###### Test cases
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/TestExprEngine.java
###### Grammar
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/ExprGrammar.g4

#Matlab Grammar
#### Usage in Java
```java
MatlabEngine.exec("A=[1 2;3 4]; b=[3 4]'; A\\b");
```
### Command Line Tools ( MatlabEngine.main(String[] args) )
```shell
java -jar MatlabEngine.jar file.m
```
#### Example 1
In this example, it shows how the optimaztion of the compiler for function 'myfun' works. Actually, the function 'myfun' is compiled twice. The first compilation generates 'myfun' with integer type of parameters. The second compilation generated 'myfun' with double type of parameters.
```matlab
function [c d] = myfun(a, b)
	c=a+b
	d=a-b
end
myfun(10,100)
myfun(10.1,100.1)
```
#### Example 2
This example shows how fast it can be reached for computing Fibonacci sequence at n=46. It takes about 4 minutes on Matlab R2016. However, it takes only 9 seconds for us. The experiment is conducted on a 2.2 GHz i7 CPU with Mac OS X Yosemite. 
```matlab
function r=fib(n)
  if n<=1
    r=1L;
  else 
    r=fib(n-1)+fib(n-2);
  end
end

tic
fib(46)
toc
```
```shell
2971215073
Elapsed time is 9188 ms.
```
#### Example 3
Iterative version with matrix form for computing Fibonacci sequence.
```matlab
A=[1 1; 1 0];
b=[1 1]';

tic
for i=1:46
  b=A*b;
end
toc

b
```
```shell
Elapsed time is 1 ms.

 4807526976.00
 2971215073.00
```
#### Example 4
Some matrix operations.
```matlab
A=[1 2 3 4 5 6 7 8 9 10; 11 12 13 14 15 16 17 18 19 20; 21 22 23 24 25 26 27 28 29 30]
A(:, 0:2:8)
A(1, 0:2:8)
A(:, 9)
B=A(0:2,0:2)

C=[5 4 8; 4 4 7; 2 1 1]
b=A(:,3)
C\b
```
```shell
      1.00      2.00      3.00      4.00      5.00      6.00      7.00      8.00      9.00     10.00
     11.00     12.00     13.00     14.00     15.00     16.00     17.00     18.00     19.00     20.00
     21.00     22.00     23.00     24.00     25.00     26.00     27.00     28.00     29.00     30.00


      1.00      3.00      5.00      7.00      9.00
     11.00     13.00     15.00     17.00     19.00
     21.00     23.00     25.00     27.00     29.00


     11.00     13.00     15.00     17.00     19.00


     10.00
     20.00
     30.00


      1.00      2.00      3.00
     11.00     12.00     13.00
     21.00     22.00     23.00


      5.00      4.00      8.00
      4.00      4.00      7.00
      2.00      1.00      1.00


      4.00
     14.00
     24.00


      7.43
     26.57
    -17.43

```
#### Example 5
Gaussian Elimination
```matlab
function GE(A)
  [m,n]=size(A);
  U=A;
  for j=1:n-1
    U(j+1:n,j)=(1/U(j,j))*U(j+1:n,j);
    for i=j+1:n
      U(i,j+1:n)=U(i,j+1:n)-U(i,j)*U(j,j+1:n);
    end
  end
  L=U-triu(U)+eye(n)
  U=triu(U)
end

GE([1 2 3; 4 5 6; 7 8 9]);
```
```shell
      1.00      0.00      0.00
      4.00      1.00      0.00
      7.00      2.00      1.00


      1.00      2.00      3.00
      0.00     -3.00     -6.00
      0.00      0.00      0.00
```
#### More Matlab examples
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/test/TestMatlabEngine.java
https://github.com/yuemingl/ExprEngine/tree/master/test_matlab
