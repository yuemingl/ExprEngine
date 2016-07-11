package io.lambdacloud;

import static io.lambdacloud.ExprEngine.*;
import io.lambdacloud.ExprEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExprEngine {
	
	public static void testExprs() {
		
		assertEqual(exec("a=[[1 for col in range(3)] for row in range(2)]; a[0]"), getList(1,1,1));
		assertEqual(exec("a=[[col+row*10 for col in range(3)] for row in range(5)]; a[0:2]"), getList(
				getList(0,1,2),getList(10,11,12),getList(20,21,22)));
		assertEqual(exec("a=[[1,2],[3,4,5]]; b=a[0]; b[0]"),1);
		assertEqual(exec("a=[[1,2],[3,4,5],[6,7,8]]; a[1:2][1][1]"),7);
		assertEqual(exec("a=[ [10*x+y for x in 1:5] for y in 6:10]; a[1:3][1:2][1][2:4]"),getList(39,49,59));
		assertEqual(exec("[ [10*x+y for x in 1:3] for y in 4:6]"),getList(
				getList(14, 24, 34),getList(15, 25, 35),getList(16, 26, 36)));
		assertEqual(exec("a=[ [10*x+y for x in 1:3] for y in 4:6]; a[2][1]"),26);
		//Wrong grammar: System.out.println(exec("[ x+y for x in range(1:3) for y in range(3:6)]"));
		assertEqual(exec("a=[[1,2],[3,4,5]]; a[1][2]"),5);
		assertEqual(exec("a=[[1,2],[3,4,5]]; b=a[0]; b[1]"),2);

		//Exp
		assertEqual(exec("10+2**3"), 18.0);
		assertEqual(exec("2**3"), 8.0);
		
		//Semi-colon
		assertEqual(exec("1:3"), new int[]{1,2,3});
		assertEqual(exec("[x for x in 1:3]"), getList(1,2,3));
		

		//Test for variable types
		assertEqual(exec("[x for x in y]",new Object[]{ new int[]{3,4,5} }), getList(3,4,5));
		assertEqual(exec("x",new Object[]{ new Integer(3)} ), 3);
		assertEqual(exec("x",new Object[]{ new Double(3)} ), 3.0);
		
		//Test for range
		assertEqual(exec("range(1+2,2*x)",new int[]{3}), new int[]{3,4,5});

		assertEqual(exec("x+1.1",new int[]{1}), 2.1);
		assertEqual(exec("x+10.0",new int[]{1}), 11.0);
		
		assertEqual(exec("[x+10 for x in range(3)]"), getList(10, 11, 12));
		assertEqual(exec("[x+10.0 for x in range(3)]"), getList(10.0, 11.0, 12.0));
		
		assertEqual(exec("range(3,5)"), new int[]{3,4});
		
		assertEqual(exec("range(3)"), new int[]{0,1,2});
		
		//Test for list comprehension
		assertEqual(exec("[ [x,x+1] for x in A]",
				new Object[]{ new double[]{1,2,3} }), 
				getList(new double[]{1.0,2.0}, new double[]{2.0,3.0}, new double[]{3.0,4.0}));

		assertEqual(exec("[x,x+1,x+2]", new int[]{10}), new int[]{10,11,12});
		
		assertEqual(exec("[1+2,2*3]"), new int[]{3,6});
		
		assertEqual(exec("[ [1,x] for x in A]",
				new Object[]{ new double[]{1,2,3} }), 
				getList(new double[]{1.0,1.0}, new double[]{1.0,2.0}, new double[]{1.0,3.0}));
		
		assertEqual(exec("[ [x,1] for x in A]",
				new Object[]{ new double[]{1,2,3} }), 
				getList(new double[]{1.0,1.0}, new double[]{2.0,1.0}, new double[]{3.0,1.0}));
		
		assertEqual(exec("[ [x,1.0] for x in A]",
				new Object[]{ new double[]{1,2,3} }), 
				getList(new double[]{1.0,1.0}, new double[]{2.0,1.0}, new double[]{3.0,1.0}));
		
		//Loop for B first and the loop for A (The same as Python language)
		assertEqual(exec("[x for x in A for y in B]",
				new Object[]{ new int[]{0,1,2}, new int[]{100,101,102} }), 
				getList(0, 0, 0, 1, 1, 1, 2, 2, 2));
		
		assertEqual(exec("[x+y for x in A if x>=2 for y in B if y>=100]",
				new Object[]{ new int[]{1,2,3}, new int[]{10,100,1000} }), getList(102, 1002, 103, 1003));

		assertEqual(exec("[x+y for x in A for y in B if x+y>=1000]",
				new Object[]{ new int[]{1,2,3}, new int[]{10,100,1000} }), getList(1001, 1002, 1003));
		
		assertEqual(exec("[x+1 for x in A if x>=4]",
				new Object[]{ new int[]{3,4,5} }), getList(5, 6) );

		//test map for list comprehension
		assertEqual(exec("[ [x+y for x in A] for y in B ]",
				getMap("A", new int[]{3, 4, 5}, "B", new int[]{3, 4, 5})), 
				getList(getList(6, 7, 8), getList(7, 8, 9), getList(8, 9, 10)));
		
		assertEqual(exec("[ [x+y for x in A] for y in B ]",
				getMap("A", new double[]{3.0 ,4.0 ,5.0}, "B", new int[]{3, 4, 5})), 
				getList(getList(6.0, 7.0, 8.0), getList(7.0, 8.0, 9.0), getList(8.0, 9.0, 10.0)));
		
//		assertEqual(parseAndEval("[ [x+y for x in A] for y in B ]",
//				getMap("A", new int[]{3,4,5}, "B", new int[]{3,4,5}, "x", 0, "y", 0)), 
//				getList(getList(6.0, 7.0, 8.0), getList(7.0, 8.0, 9.0), getList(8.0, 9.0, 10.0)));

		
		//Test three layer of loops: this works
		assertEqual(exec("[ [ [x+y+z for x in A] for y in B] for z in C]",
				new Object[]{ new int[]{1,2}, new int[]{3,4}, new int[]{5,6} }), 
				getList(
						getList(getList(9, 10), getList(10, 11)),
						getList(getList(10, 11), getList(11, 12))
				)
				);
		
		assertEqual(exec("[ [x+y for x in A] for y in B ]",
				new Object[]{ new int[]{3,4,5}, new int[]{3,4,5} }), 
				getList(getList(6, 7, 8), getList(7, 8, 9), getList(8, 9, 10)));

		//assertEqual(parseAndEval("[x+1.0 for x in [3,4,5]]"), new double[]{4.0, 5.0, 6.0});
		assertEqual(exec("[x+1.0 for x in [3,4,5]]"), getList(4.0, 5.0, 6.0));
		
//		assertEqual(parseAndEval("[[[x for x in A] for y in B] for z in C]",
//				new Object[]{ new int[]{3,4,5}, new int[]{3,4,5}, new int[]{3,4,5} }), new int[]{4,5,6});

		//type???
		assertEqual(exec("[x+y for x in A for y in B]", new Object[]{ new int[]{3,4,5}, new int[]{1,2,3} }), 
				getList( 4, 5, 6, 5, 6, 7, 6, 7, 8 ));
		assertEqual(exec("[x+1.0 for x in y]",new Object[]{ new int[]{3,4,5} }), getList(4.0, 5.0, 6.0));
		assertEqual(exec("[x+1 for x in y]",new Object[]{ new int[]{3,4,5} }), getList(4 ,5, 6));
		
		exec("println('Begin test:'); print(1); print(2.0); println(true)");
		exec("println(\"hello world!\")");
		
		assertEqual(exec("i+io.lambdacloud.TestExprEngine.arrayArgFunc(ary)", 
				getMap(
						"i",10, 
						"ary",new int[]{3,4,5}
					)), 13);
		
		assertEqual(exec("io.lambdacloud.TestExprEngine.arrayArgFunc(ary)",new Object[]{ new int[]{3,4,5} }), 3);

		assertEqual(exec("Math.abs(i+j)",new Object[]{-0.5,-0.7}), 1.2);
		assertEqual(exec("Math.max(i,j)",new double[]{5.0,5.1}), 5.1);
		assertEqual(exec("Math.round(i)",new double[]{5.4}), 5L);
		
		//Test array
		assertEqual(exec("a=[10,20,30]; a[i]=j; a",new Object[]{0,1}), new int[]{1,20,30});
		
		assertEqual(exec("a=[10,20,30]; a[0]=1; a"), new int[]{1,20,30});

		assertEqual(exec("a=[10,20,30]; i=1; a[i*2]"), 30);
		assertEqual(exec("a=[10,20,30,40]; sum=0; for(i=0;i<4;i++) { sum+=a[i] } sum"), 100);
	
		assertEqual(exec("x[i+1:j]", new Object[]{1,4,new double[]{1,2,3,4,5}}), new double[]{3.0,4.0,5.0});
		assertEqual(exec("x[i]", new Object[]{1,new double[]{1,2,3}}), 2.0);
		assertEqual(exec("x[2]", new Object[]{new int[]{1,2,3}}), 3);
		
		assertEqual(exec("a=[10,20,30]; a[2]"), 30);
		assertEqual(exec("a=[10,20,30]; a[1:2]"), new int[]{20,30});

		assertEqual(exec("[10,20,30]"), new int[]{10,20,30});
		
		assertEqual(exec("a=[10,20,30]"), new int[]{10,20,30});
		assertEqual(exec("a=[10,20,30]; a"), new int[]{10,20,30});
		
		//Test string
		assertEqual(exec("x + y", new String[]{"abc","def"}), "abcdef");
		assertEqual(exec("a= \"abc\"; a != str", new String[]{"def"}), true);
		assertEqual(exec("a= \"abc\"; a == str", new String[]{"abc"}), true);

		assertEqual(exec("\"\""), "");
		assertEqual(exec("\"abc\""), "abc");
		assertEqual(exec("\"abc\" + \"def\""), "abcdef");
		assertEqual(exec("\"\\\"\""), "\\\"");
		assertEqual(exec("\"abc\" + str", new String[]{"def"}), "abcdef");
		assertEqual(exec("str + \"abc\"", new String[]{"def"}), "defabc");
		//AddNode? StringConcatNode?
		assertEqual(exec("\"def\" == \"abc\"", new String[]{}), false);
		assertEqual(exec("\"def\" != \"abc\"", new String[]{}), true);
		assertEqual(exec("\"abc\" == str", new String[]{"def"}), false);
		assertEqual(exec("str == \"abc\"", new String[]{"def"}), false);
		assertEqual(exec("str != \"abc\"", new String[]{"def"}), true);
		assertEqual(exec("\"abc\" != str", new String[]{"def"}), true);
		
		//assertEqual(parseAndEval("x[0]", new int[]{}), 0);
		//assertEqual(parseAndEval("x[0:3]", new int[]{}), 3);
		
		//
		assertEqual(exec("while (x<y) {x=x+1;} x", new int[]{1,4}), 4);
		assertEqual(exec("for(i=0;i<=3;i++) {x+=i} x", new int[]{2}), 8);
		assertEqual(exec("for(i=0;i<=n;i++) {x+=i} x", new int[]{100,0}), 5050);
		assertEqual(exec("for(i=0,j=1;i<3;i++,j++) {x+=y; x+=j; } x+y", new int[]{3,4}), 25);
		
		assertEqual(exec("a=if(x>y) {x} else {y}; a", new int[]{3,4}), 4);
		assertEqual(exec("a=if(x>y) {x} else {y}; a", new int[]{5,4}), 5);
		
		//assertEqual(parseAndEval("if(x>y) {x+y;x-y; }", new int[]{3,4}), 7);
//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else { x*y; x/y; }", new double[]{3.0,4.0}), 0.75);
//		assertEqual(parseAndEval("if(x>0) {x-1; } else {y; }", new int[]{3,4}), 2);
//		assertEqual(parseAndEval("if(x<y) {  if(x<0) {x-1;} else {y;}  } else {y+1; }", new int[]{3,4}), 4);
//		assertEqual(parseAndEval("if(x>y) {x+y; } else { if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 4);
//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else {x*2;y*3; if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 0.75);

		//		assertEqual(parseAndEval("if(x<y) {x+y;} else{x}", new int[]{3,4}), 7);
//		assertEqual(parseAndEval("if(x<y) {x+y;} x", new int[]{3,4}), 7);
		assertEqual(exec("a=x-y; if(x>y) {a=x+y;} a", new int[]{3,4}), -1);
		assertEqual(exec("a=x-y; if(x<y) {a=x+y;} a", new int[]{3,4}), 7);
		
		assertEqual(exec("x + y;", new int[]{3,4}), 7);
		//Should Error: assertEqual(parseAndEval("x + y; x - y;", new int[]{3,4}), 7);
		assertEqual(exec("2.0 >  1", new int[]{}), true);
		assertEqual(exec("a=x+y; a+1", new int[]{3,4}), 8);
		assertEqual(exec("if(x>y) {x+y; } else { x-y; }", new int[]{3,4}), -1);
		assertEqual(exec("if(x>y) {x+y; } else { x-y; } x", new int[]{3,4}), 3);
		assertEqual(exec("if(x<y) {x+y;} else{x}", new int[]{3,4}), 7);
		
		//assertEqual(parseAndEval("if(x<y) {x+y;} x", new int[]{3,4}), 7); should fail
		assertEqual(exec("if(x<y) {a=x+y;} x", new int[]{3,4}), 3);

//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else { x*y; x/y; }", new double[]{3.0,4.0}), 0.75);
		assertEqual(exec("if(x>0) {x-1; } else {y; }", new int[]{3,4}), 2);
		assertEqual(exec("if(x<y) {  if(x<0) {x-1;} else {y;}  } else {y+1; }", new int[]{3,4}), 4);
		assertEqual(exec("if(x>y) {x+y; } else { if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 4);
		assertEqual(exec("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new int[]{3,4}), 18);

		
		//type conversion
		//assertEqual(parseAndEval("a=x+y; a+2;", new int[]{3,4}), 9);
		//assertEqual(parseAndEval("a=x+y; a/2.0;", new int[]{3,4}), 3.5);

		
		//line 1:1 extraneous input '-1' expecting {'+', '-', '*', '/', '%', '&', '|', '^', '<<', '>>', '>>>', END_EXPR}
		assertEqual(exec("1-1"), 0);
		assertEqual(exec("x-1.0", new double[]{2}), 1.0);

		//Type conversion test
		assertEqual(exec("2.0 >  1", new int[]{}), true);
		assertEqual(exec("2.0 >= 1", new int[]{}), true);
		assertEqual(exec("2.0 <  1", new int[]{}), false);
		assertEqual(exec("2.0 <= 1", new int[]{}), false);
		assertEqual(exec("2.0 == 1", new int[]{}), false);
		assertEqual(exec("2.0 != 1", new int[]{}), true);
		
		assertEqual(exec("2 >  1.0", new int[]{}), true);
		assertEqual(exec("2 >= 1.0", new int[]{}), true);
		assertEqual(exec("2 <  1.0", new int[]{}), false);
		assertEqual(exec("2 <= 1.0", new int[]{}), false);
		assertEqual(exec("2 == 1.0", new int[]{}), false);
		assertEqual(exec("2 != 1.0", new int[]{}), true);

		assertEqual(exec("x + 1", new double[]{2}), 3.0);
		assertEqual(exec("x - 1", new double[]{2}), 1.0);
		assertEqual(exec("x*1", new double[]{2}), 2.0);
		assertEqual(exec("x/1", new double[]{2}), 2.0);
		assertEqual(exec("x%3", new double[]{2}), 2.0);
		
		assertEqual(exec("x+=2", new int[]{3}), 5);
		assertEqual(exec("x-=2", new int[]{3}), 1);
		assertEqual(exec("x*=2", new int[]{3}), 6);
		assertEqual(exec("x/=2", new int[]{6}), 3);
		assertEqual(exec("x%=2", new int[]{3}), 1);
		
		//assertEqual(parseAndEval("y+(x+=2)", new int[]{3,1}), 6);
		
		assertEqual(exec("x++", new long[]{3}), 4L);
		assertEqual(exec("x--", new long[]{3}), 2L);
		assertEqual(exec("x++", new int[]{3}), 4);
		assertEqual(exec("x--", new int[]{3}), 2);
		
		//int x = 3;
		//System.out.println(-x--);//-3
		//System.out.println((-x)--);//error
		//System.out.println(-(x--));//-3
		assertEqual(exec("-x--", new int[]{3}), -2); //different from java
		assertEqual(exec("-x++", new int[]{3}), -4); //defferent from java

		assertEqual(exec("x++ + 2", new int[]{3}), 6);
		assertEqual(exec("x++ - 2", new int[]{3}), 2);
		assertEqual(exec("x++ * 2", new int[]{3}), 8);
		assertEqual(exec("x++ / 2", new int[]{3}), 2);
		assertEqual(exec("x++ % 2", new int[]{3}), 0);
		assertEqual(exec("x++ > 0", new int[]{3}), true);
		assertEqual(exec("x++ >= 0", new int[]{3}), true);
		assertEqual(exec("x++ < 0", new int[]{3}), false);
		assertEqual(exec("x++ <= 0", new int[]{3}), false);
		assertEqual(exec("x++ == 4", new int[]{3}), true);
		assertEqual(exec("x++ != 4", new int[]{3}), false);
		
		assertEqual(exec("7>>2"), 1);
		assertEqual(exec("1<<2"), 4);
		assertEqual(exec("-1>>>30"), 3);

		assertEqual(exec("x>>y", new int[]{7,2}), 1);
		assertEqual(exec("x<<y", new int[]{1,2}), 4);
		assertEqual(exec("x>>>y", new int[]{-1,30}), 3);

		assertEqual(exec("-x-y", new int[]{1,2}), -3);
		assertEqual(exec("-x+y", new int[]{1,2}), 1);
		assertEqual(exec("-(x-y)", new int[]{-1,7}), 8);
		
		assertEqual(exec("x&y", new int[]{-1,5}), 5);
		assertEqual(exec("-x&y", new int[]{1,5}), 5);
		assertEqual(exec("x&-y", new int[]{-1,-5}), 5);
		assertEqual(exec("-x&-y", new int[]{1,-5}), 5);

		assertEqual(exec("x^y", new int[]{4,7}), 3);
		assertEqual(exec("x|y", new int[]{3,4}), 7);
		assertEqual(exec("~x", new int[]{0}), -1);
		
		assertEqual(exec("(x+y)&2", new int[]{2,3}), 0);
		assertEqual(exec("(x^1)^(y^1)", new int[]{1,2}), 3);
		
		assertEqual(exec("0 & 0"), 0);
		assertEqual(exec("0 & 1"), 0);
		assertEqual(exec("1 & 0"), 0);
		assertEqual(exec("1 & 1"), 1);

		assertEqual(exec("0 | 0"), 0);
		assertEqual(exec("0 | 1"), 1);
		assertEqual(exec("1 | 0"), 1);
		assertEqual(exec("1 | 1"), 1);

		assertEqual(exec("0 ^ 0"), 0);
		assertEqual(exec("0 ^ 1"), 1);
		assertEqual(exec("1 ^ 0"), 1);
		assertEqual(exec("1 ^ 1"), 0);

		assertEqual(exec("~0"), -1);
		assertEqual(exec("~1"), -2);
		
		assertEqual(exec("-1^7"), exec("~7"));
		assertEqual(exec("7^-1"), exec("~7"));

		assertEqual(exec("1+2", new int[]{}), 3);
		assertEqual(exec("x+y", new int[]{3,4}), 7);
		assertEqual(exec("x+y", new double[]{3,4}), 7.0);

		assertEqual(exec("x+y", new double[]{3,4}), 7.0);
		assertEqual(exec("x-y", new double[]{3,4}), -1.0);
		assertEqual(exec("x*y", new double[]{3,4}), 12.0);
		assertEqual(exec("x/y", new double[]{3,4}), 0.75);
		assertEqual(exec("x%y", new double[]{3,4}), 3.0);

		assertEqual(exec("x+y", new int[]{3,4}), 7);
		assertEqual(exec("x-y", new int[]{3,4}), -1);
		assertEqual(exec("x*y", new int[]{3,4}), 12);
		assertEqual(exec("x/y", new int[]{3,4}), 0);
		assertEqual(exec("x%y", new int[]{3,4}), 3);

		assertEqual(exec("x >  y", new double[]{3,4}), false);
		assertEqual(exec("x >= y", new double[]{3,4}), false);
		assertEqual(exec("x <  y", new double[]{3,4}), true);
		assertEqual(exec("x <= y", new double[]{3,4}), true);
		assertEqual(exec("x == y", new double[]{3,4}), false);
		assertEqual(exec("x != y", new double[]{3,4}), true);

		assertEqual(exec("2 >  1", new double[]{}), true);
		assertEqual(exec("2 >= 1", new double[]{}), true);
		assertEqual(exec("3 >= 3", new double[]{}), true);
		assertEqual(exec("2 <  1", new double[]{}), false);
		assertEqual(exec("2 <= 1", new double[]{}), false);
		assertEqual(exec("2 == 1", new double[]{}), false);
		assertEqual(exec("2 == 2", new double[]{}), true);
		assertEqual(exec("2 != 2", new double[]{}), false);
		assertEqual(exec("1 != 2", new double[]{}), true);
		
		assertEqual(exec("2.0 >  1.0", new double[]{}), true);
		assertEqual(exec("2.0 >= 1.0", new double[]{}), true);
		assertEqual(exec("3.0 >= 3.0", new double[]{}), true);
		assertEqual(exec("2.0 <  1.0", new double[]{}), false);
		assertEqual(exec("2.0 <= 1.0", new double[]{}), false);
		assertEqual(exec("2.0 == 1.0", new double[]{}), false);
		assertEqual(exec("2.0 == 2.0", new double[]{}), true);
		assertEqual(exec("2.0 != 2.0", new double[]{}), false);
		assertEqual(exec("1.0 != 2.0", new double[]{}), true);
		
		assertEqual(exec("2 > 1 &&  3 > 2", new double[]{}), true);
		assertEqual(exec("2 > 1 and 3 > 2", new double[]{}), true);
		assertEqual(exec("2 < 1 ||  3 > 2", new double[]{}), true);
		assertEqual(exec("2 < 1 or  3 > 2", new double[]{}), true);
		assertEqual(exec("!   3 > 2", new double[]{}), false);
		assertEqual(exec("not 3 > 2", new double[]{}), false);

		assertEqual(exec("a=x+y;a", new double[]{3,4}), 7.0);
		assertEqual(exec("c=b=a=x+y;c", new double[]{3,4}), 7.0);
		//assertEqual(parseAndEval("1+(a=x+y)", new double[]{3,4}), 7.0);
		
		assertEqual(exec("2*(2+1)", new double[]{}), 6);
		assertEqual(exec("2+2*3", new double[]{}), 8);
		
		assertEqual(exec("8/4%3", new double[]{}), 2);
		assertEqual(exec("8/(4%3)", new double[]{}), 8);
		
		System.out.println("Test done!");
		
	}

	public static void assertEqual(Object o1, Object o2) {
		if(o1 instanceof int[] && o2 instanceof int[]) {
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
		}
		if(!o1.equals(o2)) {
			System.err.println(o1 + " != "+o2);
			throw new RuntimeException("Assert fail!");
		}
	}
	
	public static void main(String[] args){
		testExprs();
		test();
	}
	
	public static void myPrint(Object o) {
		if(o instanceof double[]) {
			double[] a = (double[])o;
			System.out.print("[");
			for(double d : a)
				System.out.print(d+", ");
			System.out.println("]");
		} else {
			System.out.println(o);
		}
	}
	
	public static void test() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("x", double[].class);
		param.put("i", int.class);
		param.put("j", int.class);
		
		//ExprTreeBuildWalker ew = parse("x[i]", param);
		ExprTreeBuildWalker ew = parse("x[i+1]", param);
//		ExprTreeBuildWalker ew = parse("x[1:3]", param);
//		ExprTreeBuildWalker ew = parse("x[i:3]", param);
//		ExprTreeBuildWalker ew = parse("x[1:j]", param);
//		ExprTreeBuildWalker ew = parse("x[i:j]", param);
//		ExprTreeBuildWalker ew = parse("x[i+1:j+1]", param);
		Method m = ExprEngine.genStaticMethod(ew, "myclass", true, "myfun");
		try {
			double[] ary = new double[]{1,2,3,4,5};
			for(int i=0; i<3; i++)
				myPrint(m.invoke(null, i, ary)); //parameters order: i, x
				//myPrint(m.invoke(null, i, 3, ary)); //parameters order: i, x
		} catch (Exception e) {
			e.printStackTrace();
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
