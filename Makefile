all: ExprEngine.class

ExprParser.java: Expr.g4
	antlr4 Expr.g4

ExprEngine.class: ExprParser.java ExprEngine.java ExprWalker.java
	javac *.java
