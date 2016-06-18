package io.lambdacloud;

import static io.lambdacloud.ExprEngine.*;

public class TestExprEngine {

	public static void assertEqual(Object o1, Object o2) {
		if(!o1.equals(o2)) {
			System.err.println(o1 + " != "+o2);
			throw new RuntimeException("Assert fail!");
		}
	}
	
	public static void main(String[] args){
		//assertEqual(parseAndEval("x[0]", new int[]{}), 0);
		//assertEqual(parseAndEval("x[0:3]", new int[]{}), 3);
		
		assertEqual(parseAndEval("while(x<y) {x=x+1} x", new int[]{1,4}), 4);
		assertEqual(parseAndEval("for(i=0;i<=3;i++) {x+=i} x", new int[]{2}), 8);
		assertEqual(parseAndEval("for(i=0;i<=n;i++) {x+=i} x", new int[]{100,0}), 5050);
		assertEqual(parseAndEval("for(i=0,j=1;i<3;i++,j++) {x+=y; x+=j; } x+y", new int[]{3,4}), 25);
		
		assertEqual(parseAndEval("a=if(x>y) {x} else {y}; a", new int[]{3,4}), 4);
		assertEqual(parseAndEval("a=if(x>y) {x} else {y}; a", new int[]{5,4}), 5);
		
		//assertEqual(parseAndEval("if(x>y) {x+y;x-y; }", new int[]{3,4}), 7);
//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else { x*y; x/y; }", new double[]{3.0,4.0}), 0.75);
//		assertEqual(parseAndEval("if(x>0) {x-1; } else {y; }", new int[]{3,4}), 2);
//		assertEqual(parseAndEval("if(x<y) {  if(x<0) {x-1;} else {y;}  } else {y+1; }", new int[]{3,4}), 4);
//		assertEqual(parseAndEval("if(x>y) {x+y; } else { if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 4);
//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else {x*2;y*3; if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 0.75);

		//		assertEqual(parseAndEval("if(x<y) {x+y;} else{x}", new int[]{3,4}), 7);
//		assertEqual(parseAndEval("if(x<y) {x+y;} x", new int[]{3,4}), 7);
		assertEqual(parseAndEval("a=x-y; if(x>y) {a=x+y;} a", new int[]{3,4}), -1);
		assertEqual(parseAndEval("a=x-y; if(x<y) {a=x+y;} a", new int[]{3,4}), 7);
		
		assertEqual(parseAndEval("x + y;", new int[]{3,4}), 7);
		//Should Error: assertEqual(parseAndEval("x + y; x - y;", new int[]{3,4}), 7);
		assertEqual(parseAndEval("2.0 >  1", new int[]{}), true);
		assertEqual(parseAndEval("a=x+y; a+1", new int[]{3,4}), 8);
		assertEqual(parseAndEval("if(x>y) {x+y; } else { x-y; }", new int[]{3,4}), -1);
		assertEqual(parseAndEval("if(x>y) {x+y; } else { x-y; } x", new int[]{3,4}), 3);
		assertEqual(parseAndEval("if(x<y) {x+y;} else{x}", new int[]{3,4}), 7);
		
		//assertEqual(parseAndEval("if(x<y) {x+y;} x", new int[]{3,4}), 7); should fail
		assertEqual(parseAndEval("if(x<y) {a=x+y;} x", new int[]{3,4}), 3);

//		assertEqual(parseAndEval("if(x>y) {x+y;x-y; } else { x*y; x/y; }", new double[]{3.0,4.0}), 0.75);
		assertEqual(parseAndEval("if(x>0) {x-1; } else {y; }", new int[]{3,4}), 2);
		assertEqual(parseAndEval("if(x<y) {  if(x<0) {x-1;} else {y;}  } else {y+1; }", new int[]{3,4}), 4);
		assertEqual(parseAndEval("if(x>y) {x+y; } else { if(x<0) {x-1;} else {y;} }", new int[]{3,4}), 4);
		assertEqual(parseAndEval("if(x>y) {a=x+y;a } else {a=x*2;b=y*3; if(x<0) {x-1} else {a+b} }", new int[]{3,4}), 18);

		
		//type conversion
		//assertEqual(parseAndEval("a=x+y; a+2;", new int[]{3,4}), 9);
		//assertEqual(parseAndEval("a=x+y; a/2.0;", new int[]{3,4}), 3.5);

		
		//line 1:1 extraneous input '-1' expecting {'+', '-', '*', '/', '%', '&', '|', '^', '<<', '>>', '>>>', END_EXPR}
		assertEqual(parseAndEval("1-1"), 0);
		assertEqual(parseAndEval("x-1.0", new double[]{2}), 1.0);

		//Type conversion test
		assertEqual(parseAndEval("2.0 >  1", new int[]{}), true);
		assertEqual(parseAndEval("2.0 >= 1", new int[]{}), true);
		assertEqual(parseAndEval("2.0 <  1", new int[]{}), false);
		assertEqual(parseAndEval("2.0 <= 1", new int[]{}), false);
		assertEqual(parseAndEval("2.0 == 1", new int[]{}), false);
		assertEqual(parseAndEval("2.0 != 1", new int[]{}), true);
		
		assertEqual(parseAndEval("2 >  1.0", new int[]{}), true);
		assertEqual(parseAndEval("2 >= 1.0", new int[]{}), true);
		assertEqual(parseAndEval("2 <  1.0", new int[]{}), false);
		assertEqual(parseAndEval("2 <= 1.0", new int[]{}), false);
		assertEqual(parseAndEval("2 == 1.0", new int[]{}), false);
		assertEqual(parseAndEval("2 != 1.0", new int[]{}), true);

		assertEqual(parseAndEval("x + 1", new double[]{2}), 3.0);
		assertEqual(parseAndEval("x - 1", new double[]{2}), 1.0);
		assertEqual(parseAndEval("x*1", new double[]{2}), 2.0);
		assertEqual(parseAndEval("x/1", new double[]{2}), 2.0);
		assertEqual(parseAndEval("x%3", new double[]{2}), 2.0);
		
		assertEqual(parseAndEval("x+=2", new int[]{3}), 5);
		assertEqual(parseAndEval("x-=2", new int[]{3}), 1);
		assertEqual(parseAndEval("x*=2", new int[]{3}), 6);
		assertEqual(parseAndEval("x/=2", new int[]{6}), 3);
		assertEqual(parseAndEval("x%=2", new int[]{3}), 1);
		
		//assertEqual(parseAndEval("y+(x+=2)", new int[]{3,1}), 6);
		
		assertEqual(parseAndEval("x++", new long[]{3}), 4L);
		assertEqual(parseAndEval("x--", new long[]{3}), 2L);
		assertEqual(parseAndEval("x++", new int[]{3}), 4);
		assertEqual(parseAndEval("x--", new int[]{3}), 2);
		
		//int x = 3;
		//System.out.println(-x--);//-3
		//System.out.println((-x)--);//error
		//System.out.println(-(x--));//-3
		assertEqual(parseAndEval("-x--", new int[]{3}), -2); //different from java
		assertEqual(parseAndEval("-x++", new int[]{3}), -4); //defferent from java

		assertEqual(parseAndEval("x++ + 2", new int[]{3}), 6);
		assertEqual(parseAndEval("x++ - 2", new int[]{3}), 2);
		assertEqual(parseAndEval("x++ * 2", new int[]{3}), 8);
		assertEqual(parseAndEval("x++ / 2", new int[]{3}), 2);
		assertEqual(parseAndEval("x++ % 2", new int[]{3}), 0);
		assertEqual(parseAndEval("x++ > 0", new int[]{3}), true);
		assertEqual(parseAndEval("x++ >= 0", new int[]{3}), true);
		assertEqual(parseAndEval("x++ < 0", new int[]{3}), false);
		assertEqual(parseAndEval("x++ <= 0", new int[]{3}), false);
		assertEqual(parseAndEval("x++ == 4", new int[]{3}), true);
		assertEqual(parseAndEval("x++ != 4", new int[]{3}), false);
		
		assertEqual(parseAndEval("7>>2"), 1);
		assertEqual(parseAndEval("1<<2"), 4);
		assertEqual(parseAndEval("-1>>>30"), 3);

		assertEqual(parseAndEval("x>>y", new int[]{7,2}), 1);
		assertEqual(parseAndEval("x<<y", new int[]{1,2}), 4);
		assertEqual(parseAndEval("x>>>y", new int[]{-1,30}), 3);

		assertEqual(parseAndEval("-x-y", new int[]{1,2}), -3);
		assertEqual(parseAndEval("-x+y", new int[]{1,2}), 1);
		assertEqual(parseAndEval("-(x-y)", new int[]{-1,7}), 8);
		
		assertEqual(parseAndEval("x&y", new int[]{-1,5}), 5);
		assertEqual(parseAndEval("-x&y", new int[]{1,5}), 5);
		assertEqual(parseAndEval("x&-y", new int[]{-1,-5}), 5);
		assertEqual(parseAndEval("-x&-y", new int[]{1,-5}), 5);

		assertEqual(parseAndEval("x^y", new int[]{4,7}), 3);
		assertEqual(parseAndEval("x|y", new int[]{3,4}), 7);
		assertEqual(parseAndEval("~x", new int[]{0}), -1);
		
		assertEqual(parseAndEval("(x+y)&2", new int[]{2,3}), 0);
		assertEqual(parseAndEval("(x^1)^(y^1)", new int[]{1,2}), 3);
		
		assertEqual(parseAndEval("0 & 0"), 0);
		assertEqual(parseAndEval("0 & 1"), 0);
		assertEqual(parseAndEval("1 & 0"), 0);
		assertEqual(parseAndEval("1 & 1"), 1);

		assertEqual(parseAndEval("0 | 0"), 0);
		assertEqual(parseAndEval("0 | 1"), 1);
		assertEqual(parseAndEval("1 | 0"), 1);
		assertEqual(parseAndEval("1 | 1"), 1);

		assertEqual(parseAndEval("0 ^ 0"), 0);
		assertEqual(parseAndEval("0 ^ 1"), 1);
		assertEqual(parseAndEval("1 ^ 0"), 1);
		assertEqual(parseAndEval("1 ^ 1"), 0);

		assertEqual(parseAndEval("~0"), -1);
		assertEqual(parseAndEval("~1"), -2);
		
		assertEqual(parseAndEval("-1^7"), parseAndEval("~7"));
		assertEqual(parseAndEval("7^-1"), parseAndEval("~7"));

		assertEqual(parseAndEval("1+2", new int[]{}), 3);
		assertEqual(parseAndEval("x+y", new int[]{3,4}), 7);
		assertEqual(parseAndEval("x+y", new double[]{3,4}), 7.0);

		assertEqual(parseAndEval("x+y", new double[]{3,4}), 7.0);
		assertEqual(parseAndEval("x-y", new double[]{3,4}), -1.0);
		assertEqual(parseAndEval("x*y", new double[]{3,4}), 12.0);
		assertEqual(parseAndEval("x/y", new double[]{3,4}), 0.75);
		assertEqual(parseAndEval("x%y", new double[]{3,4}), 3.0);

		assertEqual(parseAndEval("x+y", new int[]{3,4}), 7);
		assertEqual(parseAndEval("x-y", new int[]{3,4}), -1);
		assertEqual(parseAndEval("x*y", new int[]{3,4}), 12);
		assertEqual(parseAndEval("x/y", new int[]{3,4}), 0);
		assertEqual(parseAndEval("x%y", new int[]{3,4}), 3);

		assertEqual(parseAndEval("x >  y", new double[]{3,4}), false);
		assertEqual(parseAndEval("x >= y", new double[]{3,4}), false);
		assertEqual(parseAndEval("x <  y", new double[]{3,4}), true);
		assertEqual(parseAndEval("x <= y", new double[]{3,4}), true);
		assertEqual(parseAndEval("x == y", new double[]{3,4}), false);
		assertEqual(parseAndEval("x != y", new double[]{3,4}), true);

		assertEqual(parseAndEval("2 >  1", new double[]{}), true);
		assertEqual(parseAndEval("2 >= 1", new double[]{}), true);
		assertEqual(parseAndEval("3 >= 3", new double[]{}), true);
		assertEqual(parseAndEval("2 <  1", new double[]{}), false);
		assertEqual(parseAndEval("2 <= 1", new double[]{}), false);
		assertEqual(parseAndEval("2 == 1", new double[]{}), false);
		assertEqual(parseAndEval("2 == 2", new double[]{}), true);
		assertEqual(parseAndEval("2 != 2", new double[]{}), false);
		assertEqual(parseAndEval("1 != 2", new double[]{}), true);
		
		assertEqual(parseAndEval("2.0 >  1.0", new double[]{}), true);
		assertEqual(parseAndEval("2.0 >= 1.0", new double[]{}), true);
		assertEqual(parseAndEval("3.0 >= 3.0", new double[]{}), true);
		assertEqual(parseAndEval("2.0 <  1.0", new double[]{}), false);
		assertEqual(parseAndEval("2.0 <= 1.0", new double[]{}), false);
		assertEqual(parseAndEval("2.0 == 1.0", new double[]{}), false);
		assertEqual(parseAndEval("2.0 == 2.0", new double[]{}), true);
		assertEqual(parseAndEval("2.0 != 2.0", new double[]{}), false);
		assertEqual(parseAndEval("1.0 != 2.0", new double[]{}), true);
		
		assertEqual(parseAndEval("2 > 1 &&  3 > 2", new double[]{}), true);
		assertEqual(parseAndEval("2 > 1 and 3 > 2", new double[]{}), true);
		assertEqual(parseAndEval("2 < 1 ||  3 > 2", new double[]{}), true);
		assertEqual(parseAndEval("2 < 1 or  3 > 2", new double[]{}), true);
		assertEqual(parseAndEval("!   3 > 2", new double[]{}), false);
		assertEqual(parseAndEval("not 3 > 2", new double[]{}), false);

		assertEqual(parseAndEval("a=x+y;a", new double[]{3,4}), 7.0);
		assertEqual(parseAndEval("c=b=a=x+y;c", new double[]{3,4}), 7.0);
		//assertEqual(parseAndEval("1+(a=x+y)", new double[]{3,4}), 7.0);
		
		assertEqual(parseAndEval("2*(2+1)", new double[]{}), 6);
		assertEqual(parseAndEval("2+2*3", new double[]{}), 8);
		
		assertEqual(parseAndEval("8/4%3", new double[]{}), 2);
		assertEqual(parseAndEval("8/(4%3)", new double[]{}), 8);
		
		System.out.println("Test done!");
		
	}

}
