#ExprEngine
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
#### Example 1
```matlab
function [a, b] =myfun(a, b)
  a+b;
end
myfun(1,2)
```
#### Example 2
```matlab
function [c d] = myfun(a, b)
	c=a+b
	d=a-b
end
myfun(10,100)
myfun(10.1,100.1)
```
#### Example 3
```matlab
function myfun(a, b)
        c=a+b
        d=a-b
	[c d; d c]
end
myfun(10,100);
myfun(10.1,100.1);
```
#### Example 4
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
#### More Matlab examples
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/test/TestMatlabEngine.java
https://github.com/yuemingl/ExprEngine/tree/master/test_matlab
