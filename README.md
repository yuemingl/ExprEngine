#ExprEngine
ExprEngine compiles a string of expression to java bytecode in memory at runtime. The bytecode represents a static method or a class which implements a user defined interface. The method can be called as normal Java method and returns Java object. Some simple examples are shown in following codes.  

#### A quick example: parse and evaluate. (Note: the bytecode will be generated each time when using function parseAndEval.)
```Java
import static io.lambdacloud.ExprEngine.parseAndEval;
...
//Basic expressions
System.out.println(parseAndEval("-x", new int[]{3}));
System.out.println(parseAndEval("x + y", new int[]{3,4}));
System.out.println(parseAndEval("x > y", new int[]{3,4}));
System.out.println(parseAndEval("x <= y and x > 0", new int[]{3,4}));
System.out.println(parseAndEval("a=x+y; a+2", new double[]{3.0,4.0}));
System.out.println(parseAndEval("(7^3) == (1<<2)"));
System.out.println(parseAndEval(" 'abc'+'def' "));
System.out.println(parseAndEval(" \"abc\"+'def' "));
System.out.println(parseAndEval("7**2"));

//If else 
System.out.println(parseAndEval("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new double[]{3,4}));
System.out.println("max(3,4)="+parseAndEval("a=if(x>y) {x} else {y}; a", new int[]{3,4}));

//While for loops
System.out.println(parseAndEval("while(x<y) {x=x+1} x", new int[]{1,4}));
System.out.println(parseAndEval("for(i=0;i<=n;i++) {x+=i} x", new int[]{100,0}));

//Array
System.out.println(parseAndEval("a=[10,20,30,40]; sum=0; for(i=0;i<4;i++) { sum+=a[i] } sum"));
System.out.println(Arrays.toString(
		(int[])parseAndEval("[x, y, 3, 4]", new Object[]{ 1,2 })));
System.out.println(Arrays.toString(
		(String[])parseAndEval("['abc', 'def', x]", new Object[]{"ghi"})));
System.out.println(Arrays.deepToString(
		(int[][])parseAndEval("[ [x], [y] ]", new Object[]{ 1,2 })));
System.out.println(Arrays.deepToString(
		(int[][][])parseAndEval("[ [[x],[y]], [[x+y]] ]", new Object[]{ 1,2 })));
System.out.println(Arrays.toString(
		(double[])parseAndEval("x[i+1:j-1]", new Object[]{1,4,new double[]{1,2,3,4,5}})));

//List comprehension
System.out.println(parseAndEval("[x for x in A for y in B]",
				new Object[]{ new int[]{0,1,2}, new int[]{100,101,102} }));

System.out.println(parseAndEval("[x+y for x in A for y in B if x+y>=1000]",
				new Object[]{ new int[]{1,2,3}, new int[]{10,100,1000} }));

System.out.println(parseAndEval("[ x>3 for x in A ]", new Object[] {new int[]{1,2,3,4,5,6}}));

System.out.println(parseAndEval("[ x for x in A if x>3 ]", new Object[] {new int[]{1,2,3,4,5,6}}));

System.out.println(Arrays.deepToString(
		((List<int[][][]>)parseAndEval("[ [ [[x],[y]], [[x+y]] ] for x in A for y in B]",
		new Object[]{ new int[]{1,2}, new int[]{3,4} })).toArray()));

//Memory efficient range() function (no temp list generated)
System.out.println(parseAndEval("[x+10.0 for x in range(3)]")); //0,1,2
System.out.println(parseAndEval("[x+10.0 for x in 1:3]"));      //1,2,3
System.out.println(parseAndEval("[[1 for col in range(3)] for row in range(2)]"));
System.out.println(Arrays.deepToString((int[][])parseAndEval("[1:3, 5:10, 100:101]")));

```

####  Parse and generate bytecode once, call many times. Use reflection to invoke the generated static method

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
	
#### Parse and generate bytecode once, call many times. Use method handle to invoke the generated static method
```Java
import static io.lambdacloud.ExprEngine.genMethodHandle;
...
ExprTreeBuildWalker ew = parse("x*y");
MethodHandle mh = genMethodHandle(ew, "myclass", false, "myfun", 
		double.class,  double.class, double.class);
try {
	for(int i=0; i<5; i++)
			System.out.println(mh.invoke(i, 10.0));
} catch (Throwable e) {
	e.printStackTrace();
}
```

#### Declare an interface for your function.A class which implements the interface is generated and ready to use.
```Java
public interface Fun2 {
	double apply(double x, double y);
}
...
ExprTreeBuildWalker ew = parse("x*y", Fun2.class);
Fun2 f = (Fun2)ExprEngine.newInstance(ew, "myclass", true);
System.out.println(f.apply(3,4));
...

```

#### More examples
###### Test cases
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/TestExprEngine.java
###### Grammar
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/ExprGrammar.g4

