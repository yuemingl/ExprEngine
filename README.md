#ExprEngine
ExprEngine converts a string of expression(s) to java bytecode in runtime. A static method or a class which implements a user provided interface is generted in memory (which can also be written to file). Some simple examples are shown in following codes.  

#### A quick example: parse and evaluate. (Warning: the bytecode will be generated each time of the call of parseAndEval().)
```Java
System.out.println(parseAndEval("-x", new int[]{3}));
System.out.println(parseAndEval("x + y", new int[]{3,4}));
System.out.println(parseAndEval("x > y", new int[]{3,4}));
System.out.println(parseAndEval("x <= y and x > 0", new int[]{3,4}));
System.out.println(parseAndEval("a=x+y; a+2", new double[]{3.0,4.0}));
System.out.println(parseAndEval("(7^3) == (1<<2)"));
System.out.println(parseAndEval("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new double[]{3,4}));
System.out.println("max(3,4)="+parseAndEval("a=if(x>y) {x} else {y}; a", new int[]{3,4}));

```

####  Parse and generate bytecode once, call many times. Use reflection to invoke the generated statis method

```Java
ExprTreeBuildWalker ew = parse("x+y");
Method m = genStaticMethod(ew, "myclass", false, "myfun", 
		double.class, double.class);
try {
	for(int i=0; i<5; i++)
		System.out.println(m.invoke(null, i, 10.0));
} catch (Exception e) {
	e.printStackTrace();
}
```
	
#### Parse and generate bytecode once, call many times. Use method handle to invoke the generated static method
```Java
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
ExprTreeBuildWalker ew = parse("x*y");
Fun2 f = (Fun2)ExprEngine.newInstance(ew, "myclass", Fun2.class);
System.out.println(f.apply(3,4));

...

```

#### More examples
###### Test cases
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/TestExprEngine.java
###### Grammar
https://github.com/yuemingl/ExprEngine/blob/master/src/io/lambdacloud/ExprGrammar.g4

