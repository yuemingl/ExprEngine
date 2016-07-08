// Generated from ExprGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		REM=11, AND=12, OR=13, NOT=14, TRUE=15, FALSE=16, GT=17, GE=18, LT=19, 
		LE=20, EQ=21, NEQ=22, BAND=23, BOR=24, BXOR=25, BNOT=26, SHL=27, SHR=28, 
		USHR=29, INC=30, DESC=31, ADD_ASSIGN=32, SUB_ASSIGN=33, MUL_ASSIGN=34, 
		DIV_ASSIGN=35, REM_ASSIGN=36, ASSIGN=37, LPAREN=38, RPAREN=39, LBRK=40, 
		RBRK=41, LCB=42, RCB=43, INTEGER=44, FLOAT=45, IDENTIFIER=46, COMMA=47, 
		COLON=48, SEMI=49, PERIOD=50, SQUOTE=51, DQUOTE=52, COMMENT=53, WS=54, 
		StringLiteral=55;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_expression = 4, RULE_assign_expr = 5, RULE_logical_expr = 6, RULE_comparison_expr = 7, 
		RULE_comp_operator = 8, RULE_arithmetic_expr = 9, RULE_string_expr = 10, 
		RULE_numeric_entity = 11, RULE_integer_entity = 12, RULE_float_entity = 13, 
		RULE_index_entity = 14, RULE_variable_entity = 15, RULE_logical_entity = 16, 
		RULE_expr_end = 17, RULE_string_entity = 18, RULE_array_init = 19, RULE_array_gen = 20, 
		RULE_func_call = 21, RULE_list_comprehension = 22, RULE_list_comp_for_if = 23, 
		RULE_list_comp_for = 24, RULE_list_comp_if = 25;
	public static final String[] ruleNames = {
		"prog", "statements", "statement", "block", "expression", "assign_expr", 
		"logical_expr", "comparison_expr", "comp_operator", "arithmetic_expr", 
		"string_expr", "numeric_entity", "integer_entity", "float_entity", "index_entity", 
		"variable_entity", "logical_entity", "expr_end", "string_entity", "array_init", 
		"array_gen", "func_call", "list_comprehension", "list_comp_for_if", "list_comp_for", 
		"list_comp_if"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'\n'", "'in'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", 
		"'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", 
		"';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"COMMENT", "WS", "StringLiteral"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExprGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExprGrammarParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			statements();
			setState(53);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(55);
					statement();
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(65);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(61);
				expression();
				setState(63);
				_la = _input.LA(1);
				if (_la==T__4 || _la==SEMI) {
					{
					setState(62);
					expr_end();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprWhileContext extends StatementContext {
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprWhile(this);
		}
	}
	public static class FuncCall2Context extends StatementContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public FuncCall2Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterFuncCall2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitFuncCall2(this);
		}
	}
	public static class ExprAssign2Context extends StatementContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public ExprAssign2Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAssign2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAssign2(this);
		}
	}
	public static class ExprIfContext extends StatementContext {
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExprIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprIf(this);
		}
	}
	public static class ExprForContext extends StatementContext {
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(ExprGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ExprGrammarParser.SEMI, i);
		}
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public List<Assign_exprContext> assign_expr() {
			return getRuleContexts(Assign_exprContext.class);
		}
		public Assign_exprContext assign_expr(int i) {
			return getRuleContext(Assign_exprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprGrammarParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprFor(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ExprAssign2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				assign_expr();
				setState(68);
				expr_end();
				}
				break;
			case 2:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(T__0);
				setState(71);
				match(LPAREN);
				setState(72);
				logical_expr(0);
				setState(73);
				match(RPAREN);
				setState(74);
				block();
				setState(77);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(75);
					match(T__1);
					setState(76);
					block();
					}
				}

				}
				break;
			case 3:
				_localctx = new ExprWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(T__2);
				setState(80);
				match(LPAREN);
				setState(81);
				logical_expr(0);
				setState(82);
				match(RPAREN);
				setState(83);
				block();
				}
				break;
			case 4:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(T__3);
				setState(86);
				match(LPAREN);
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						assign_expr();
						setState(88);
						match(COMMA);
						}
						} 
					}
					setState(94);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(96);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(95);
					assign_expr();
					}
				}

				setState(98);
				match(SEMI);
				setState(99);
				logical_expr(0);
				setState(100);
				match(SEMI);
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(101);
						expression();
						setState(102);
						match(COMMA);
						}
						} 
					}
					setState(108);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(110);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
					{
					setState(109);
					expression();
					}
				}

				setState(112);
				match(RPAREN);
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(113);
					match(SEMI);
					}
					break;
				case 2:
					{
					setState(115);
					_la = _input.LA(1);
					if (_la==LCB) {
						{
						setState(114);
						block();
						}
					}

					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new FuncCall2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				func_call();
				setState(120);
				expr_end();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementBlockContext extends BlockContext {
		public TerminalNode LCB() { return getToken(ExprGrammarParser.LCB, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCB() { return getToken(ExprGrammarParser.RCB, 0); }
		public StatementBlockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStatementBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			_localctx = new StatementBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(LCB);
			setState(125);
			statements();
			setState(126);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprArrayInitContext extends ExpressionContext {
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ExprArrayInitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprArrayInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprArrayInit(this);
		}
	}
	public static class ExprAssign1Context extends ExpressionContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprAssign1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAssign1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAssign1(this);
		}
	}
	public static class ExprLogicalContext extends ExpressionContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public ExprLogicalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprLogical(this);
		}
	}
	public static class ExprArrayGenContext extends ExpressionContext {
		public Array_genContext array_gen() {
			return getRuleContext(Array_genContext.class,0);
		}
		public ExprArrayGenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprArrayGen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprArrayGen(this);
		}
	}
	public static class ListComprehensionContext extends ExpressionContext {
		public List_comprehensionContext list_comprehension() {
			return getRuleContext(List_comprehensionContext.class,0);
		}
		public ListComprehensionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterListComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitListComprehension(this);
		}
	}
	public static class ExprStringContext extends ExpressionContext {
		public String_exprContext string_expr() {
			return getRuleContext(String_exprContext.class,0);
		}
		public ExprStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprString(this);
		}
	}
	public static class ExprArithmeticContext extends ExpressionContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprArithmeticContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprArithmetic(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				logical_expr(0);
				}
				break;
			case 3:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				string_expr();
				}
				break;
			case 4:
				_localctx = new ExprAssign1Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				assign_expr();
				}
				break;
			case 5:
				_localctx = new ExprArrayInitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				array_init();
				}
				break;
			case 6:
				_localctx = new ListComprehensionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				list_comprehension();
				}
				break;
			case 7:
				_localctx = new ExprArrayGenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				array_gen();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
	 
		public Assign_exprContext() { }
		public void copyFrom(Assign_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprDivAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode DIV_ASSIGN() { return getToken(ExprGrammarParser.DIV_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprDivAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprDivAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprDivAssign(this);
		}
	}
	public static class ExprMulAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode MUL_ASSIGN() { return getToken(ExprGrammarParser.MUL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprMulAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprMulAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprMulAssign(this);
		}
	}
	public static class ExprRemAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode REM_ASSIGN() { return getToken(ExprGrammarParser.REM_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprRemAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprRemAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprRemAssign(this);
		}
	}
	public static class ExprAssignContext extends Assign_exprContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(ExprGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ExprAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAssign(this);
		}
	}
	public static class ExprSubAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode SUB_ASSIGN() { return getToken(ExprGrammarParser.SUB_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprSubAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprSubAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprSubAssign(this);
		}
	}
	public static class ExprAddAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode ADD_ASSIGN() { return getToken(ExprGrammarParser.ADD_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprAddAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAddAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAddAssign(this);
		}
	}
	public static class ExprArrayAssignContext extends Assign_exprContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(ExprGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public List<TerminalNode> LBRK() { return getTokens(ExprGrammarParser.LBRK); }
		public TerminalNode LBRK(int i) {
			return getToken(ExprGrammarParser.LBRK, i);
		}
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public List<TerminalNode> RBRK() { return getTokens(ExprGrammarParser.RBRK); }
		public TerminalNode RBRK(int i) {
			return getToken(ExprGrammarParser.RBRK, i);
		}
		public List<TerminalNode> COLON() { return getTokens(ExprGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ExprGrammarParser.COLON, i);
		}
		public ExprArrayAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprArrayAssign(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_expr);
		int _la;
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(IDENTIFIER);
				setState(138);
				match(ASSIGN);
				setState(142);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(139);
					expression();
					}
					break;
				case 2:
					{
					setState(140);
					statement();
					}
					break;
				case 3:
					{
					setState(141);
					array_init();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new ExprArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(IDENTIFIER);
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					match(LBRK);
					setState(146);
					arithmetic_expr(0);
					setState(149);
					_la = _input.LA(1);
					if (_la==COLON) {
						{
						setState(147);
						match(COLON);
						setState(148);
						arithmetic_expr(0);
						}
					}

					setState(151);
					match(RBRK);
					}
					}
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRK );
				setState(157);
				match(ASSIGN);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(158);
					expression();
					}
					break;
				case 2:
					{
					setState(159);
					statement();
					}
					break;
				case 3:
					{
					setState(160);
					array_init();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new ExprMulAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				variable_entity();
				setState(164);
				match(MUL_ASSIGN);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(165);
					expression();
					}
					break;
				case 2:
					{
					setState(166);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ExprDivAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				variable_entity();
				setState(170);
				match(DIV_ASSIGN);
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(171);
					expression();
					}
					break;
				case 2:
					{
					setState(172);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ExprRemAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				variable_entity();
				setState(176);
				match(REM_ASSIGN);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(177);
					expression();
					}
					break;
				case 2:
					{
					setState(178);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new ExprAddAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				variable_entity();
				setState(182);
				match(ADD_ASSIGN);
				setState(185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(183);
					expression();
					}
					break;
				case 2:
					{
					setState(184);
					statement();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new ExprSubAssignContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				variable_entity();
				setState(188);
				match(SUB_ASSIGN);
				setState(191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(189);
					expression();
					}
					break;
				case 2:
					{
					setState(190);
					statement();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_exprContext extends ParserRuleContext {
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
	 
		public Logical_exprContext() { }
		public void copyFrom(Logical_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalExpressionNotContext extends Logical_exprContext {
		public TerminalNode NOT() { return getToken(ExprGrammarParser.NOT, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public LogicalExpressionNotContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterLogicalExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitLogicalExpressionNot(this);
		}
	}
	public static class LogicalExpressionAndContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExprGrammarParser.AND, 0); }
		public LogicalExpressionAndContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterLogicalExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitLogicalExpressionAnd(this);
		}
	}
	public static class LogicalExpressionOrContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ExprGrammarParser.OR, 0); }
		public LogicalExpressionOrContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterLogicalExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitLogicalExpressionOr(this);
		}
	}
	public static class LogicalExpressionEntityContext extends Logical_exprContext {
		public Logical_entityContext logical_entity() {
			return getRuleContext(Logical_entityContext.class,0);
		}
		public LogicalExpressionEntityContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterLogicalExpressionEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitLogicalExpressionEntity(this);
		}
	}
	public static class LogicalExpressionInParenContext extends Logical_exprContext {
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public LogicalExpressionInParenContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterLogicalExpressionInParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitLogicalExpressionInParen(this);
		}
	}
	public static class ComparisonExpressionContext extends Logical_exprContext {
		public Comparison_exprContext comparison_expr() {
			return getRuleContext(Comparison_exprContext.class,0);
		}
		public ComparisonExpressionContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitComparisonExpression(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		return logical_expr(0);
	}

	private Logical_exprContext logical_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, _parentState);
		Logical_exprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(196);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(NOT);
				setState(198);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(LPAREN);
				setState(200);
				logical_expr(0);
				setState(201);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(212);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(206);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(207);
						match(AND);
						setState(208);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(209);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(210);
						match(OR);
						setState(211);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Comparison_exprContext extends ParserRuleContext {
		public Comparison_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_expr; }
	 
		public Comparison_exprContext() { }
		public void copyFrom(Comparison_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparisonStringExpressionContext extends Comparison_exprContext {
		public List<String_exprContext> string_expr() {
			return getRuleContexts(String_exprContext.class);
		}
		public String_exprContext string_expr(int i) {
			return getRuleContext(String_exprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ExprGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExprGrammarParser.NEQ, 0); }
		public ComparisonStringExpressionContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterComparisonStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitComparisonStringExpression(this);
		}
	}
	public static class ComparisonArithmeticExpressionContext extends Comparison_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Comp_operatorContext comp_operator() {
			return getRuleContext(Comp_operatorContext.class,0);
		}
		public ComparisonArithmeticExpressionContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterComparisonArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitComparisonArithmeticExpression(this);
		}
	}

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparison_expr);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ComparisonArithmeticExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				arithmetic_expr(0);
				setState(218);
				comp_operator();
				setState(219);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ComparisonStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				string_expr();
				setState(222);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(223);
				string_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_operatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(ExprGrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(ExprGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(ExprGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(ExprGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(ExprGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExprGrammarParser.NEQ, 0); }
		public Comp_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterComp_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitComp_operator(this);
		}
	}

	public final Comp_operatorContext comp_operator() throws RecognitionException {
		Comp_operatorContext _localctx = new Comp_operatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arithmetic_exprContext extends ParserRuleContext {
		public Arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr; }
	 
		public Arithmetic_exprContext() { }
		public void copyFrom(Arithmetic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BitExpressionAndContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode BAND() { return getToken(ExprGrammarParser.BAND, 0); }
		public BitExpressionAndContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionAnd(this);
		}
	}
	public static class BitExpressionUshrContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode USHR() { return getToken(ExprGrammarParser.USHR, 0); }
		public BitExpressionUshrContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionUshr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionUshr(this);
		}
	}
	public static class ArithmeticExpressionRemContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode REM() { return getToken(ExprGrammarParser.REM, 0); }
		public ArithmeticExpressionRemContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionRem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionRem(this);
		}
	}
	public static class ArithmeticExpressionParensContext extends Arithmetic_exprContext {
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public ArithmeticExpressionParensContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionParens(this);
		}
	}
	public static class BitExpressionOrContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode BOR() { return getToken(ExprGrammarParser.BOR, 0); }
		public BitExpressionOrContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionOr(this);
		}
	}
	public static class ArithmeticExpressionDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(ExprGrammarParser.DIV, 0); }
		public ArithmeticExpressionDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionDiv(this);
		}
	}
	public static class BitExpressionNotContext extends Arithmetic_exprContext {
		public TerminalNode BNOT() { return getToken(ExprGrammarParser.BNOT, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public BitExpressionNotContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionNot(this);
		}
	}
	public static class ArithmeticExpressionMulContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ExprGrammarParser.MUL, 0); }
		public ArithmeticExpressionMulContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionMul(this);
		}
	}
	public static class BitExpressionShlContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SHL() { return getToken(ExprGrammarParser.SHL, 0); }
		public BitExpressionShlContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionShl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionShl(this);
		}
	}
	public static class ArithmeticExpressionEntityContext extends Arithmetic_exprContext {
		public Numeric_entityContext numeric_entity() {
			return getRuleContext(Numeric_entityContext.class,0);
		}
		public ArithmeticExpressionEntityContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionEntity(this);
		}
	}
	public static class ArithmeticExpressionNegationEntityContext extends Arithmetic_exprContext {
		public TerminalNode SUB() { return getToken(ExprGrammarParser.SUB, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ArithmeticExpressionNegationEntityContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionNegationEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionNegationEntity(this);
		}
	}
	public static class ArithmeticExpressionSubContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(ExprGrammarParser.SUB, 0); }
		public ArithmeticExpressionSubContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionSub(this);
		}
	}
	public static class BitExpressionXorContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode BXOR() { return getToken(ExprGrammarParser.BXOR, 0); }
		public BitExpressionXorContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionXor(this);
		}
	}
	public static class FuncCall1Context extends Arithmetic_exprContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public FuncCall1Context(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterFuncCall1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitFuncCall1(this);
		}
	}
	public static class BitExpressionShrContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SHR() { return getToken(ExprGrammarParser.SHR, 0); }
		public BitExpressionShrContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterBitExpressionShr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitBitExpressionShr(this);
		}
	}
	public static class ArithmeticExpressionIncDecContext extends Arithmetic_exprContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public TerminalNode INC() { return getToken(ExprGrammarParser.INC, 0); }
		public TerminalNode DESC() { return getToken(ExprGrammarParser.DESC, 0); }
		public ArithmeticExpressionIncDecContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionIncDec(this);
		}
	}
	public static class ArithmeticExpressionAddContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ExprGrammarParser.ADD, 0); }
		public ArithmeticExpressionAddContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionAdd(this);
		}
	}

	public final Arithmetic_exprContext arithmetic_expr() throws RecognitionException {
		return arithmetic_expr(0);
	}

	private Arithmetic_exprContext arithmetic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_exprContext _localctx = new Arithmetic_exprContext(_ctx, _parentState);
		Arithmetic_exprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionIncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(230);
				match(IDENTIFIER);
				setState(231);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new BitExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(BNOT);
				setState(233);
				arithmetic_expr(16);
				}
				break;
			case 3:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(SUB);
				setState(235);
				arithmetic_expr(15);
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(LPAREN);
				setState(237);
				arithmetic_expr(0);
				setState(238);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				numeric_entity();
				}
				break;
			case 6:
				{
				_localctx = new FuncCall1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				func_call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(244);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(245);
						match(MUL);
						setState(246);
						arithmetic_expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(247);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(248);
						match(DIV);
						setState(249);
						arithmetic_expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(250);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(251);
						match(REM);
						setState(252);
						arithmetic_expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(253);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(254);
						match(ADD);
						setState(255);
						arithmetic_expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(256);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(257);
						match(SUB);
						setState(258);
						arithmetic_expr(11);
						}
						break;
					case 6:
						{
						_localctx = new BitExpressionShlContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(259);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(260);
						match(SHL);
						setState(261);
						arithmetic_expr(10);
						}
						break;
					case 7:
						{
						_localctx = new BitExpressionShrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(262);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(263);
						match(SHR);
						setState(264);
						arithmetic_expr(9);
						}
						break;
					case 8:
						{
						_localctx = new BitExpressionUshrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(265);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(266);
						match(USHR);
						setState(267);
						arithmetic_expr(8);
						}
						break;
					case 9:
						{
						_localctx = new BitExpressionAndContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(268);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(269);
						match(BAND);
						setState(270);
						arithmetic_expr(7);
						}
						break;
					case 10:
						{
						_localctx = new BitExpressionOrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(271);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(272);
						match(BOR);
						setState(273);
						arithmetic_expr(6);
						}
						break;
					case 11:
						{
						_localctx = new BitExpressionXorContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(274);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(275);
						match(BXOR);
						setState(276);
						arithmetic_expr(5);
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class String_exprContext extends ParserRuleContext {
		public String_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_expr; }
	 
		public String_exprContext() { }
		public void copyFrom(String_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringEntityContext extends String_exprContext {
		public String_entityContext string_entity() {
			return getRuleContext(String_entityContext.class,0);
		}
		public StringEntityContext(String_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStringEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStringEntity(this);
		}
	}
	public static class StringConcatContext extends String_exprContext {
		public List<String_entityContext> string_entity() {
			return getRuleContexts(String_entityContext.class);
		}
		public String_entityContext string_entity(int i) {
			return getRuleContext(String_entityContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ExprGrammarParser.ADD, 0); }
		public StringConcatContext(String_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStringConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStringConcat(this);
		}
	}

	public final String_exprContext string_expr() throws RecognitionException {
		String_exprContext _localctx = new String_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string_expr);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new StringConcatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				string_entity();
				setState(283);
				match(ADD);
				setState(284);
				string_entity();
				}
				break;
			case 2:
				_localctx = new StringEntityContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				string_entity();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_entityContext extends ParserRuleContext {
		public Integer_entityContext integer_entity() {
			return getRuleContext(Integer_entityContext.class,0);
		}
		public Float_entityContext float_entity() {
			return getRuleContext(Float_entityContext.class,0);
		}
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public Numeric_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterNumeric_entity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitNumeric_entity(this);
		}
	}

	public final Numeric_entityContext numeric_entity() throws RecognitionException {
		Numeric_entityContext _localctx = new Numeric_entityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numeric_entity);
		try {
			setState(292);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				integer_entity();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				float_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				variable_entity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Integer_entityContext extends ParserRuleContext {
		public Integer_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_entity; }
	 
		public Integer_entityContext() { }
		public void copyFrom(Integer_entityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntityConstIntegerContext extends Integer_entityContext {
		public TerminalNode INTEGER() { return getToken(ExprGrammarParser.INTEGER, 0); }
		public EntityConstIntegerContext(Integer_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterEntityConstInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitEntityConstInteger(this);
		}
	}

	public final Integer_entityContext integer_entity() throws RecognitionException {
		Integer_entityContext _localctx = new Integer_entityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Float_entityContext extends ParserRuleContext {
		public Float_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_entity; }
	 
		public Float_entityContext() { }
		public void copyFrom(Float_entityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntityConstFloatContext extends Float_entityContext {
		public TerminalNode FLOAT() { return getToken(ExprGrammarParser.FLOAT, 0); }
		public EntityConstFloatContext(Float_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterEntityConstFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitEntityConstFloat(this);
		}
	}

	public final Float_entityContext float_entity() throws RecognitionException {
		Float_entityContext _localctx = new Float_entityContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_entityContext extends ParserRuleContext {
		public Integer_entityContext integer_entity() {
			return getRuleContext(Integer_entityContext.class,0);
		}
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public Index_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterIndex_entity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitIndex_entity(this);
		}
	}

	public final Index_entityContext index_entity() throws RecognitionException {
		Index_entityContext _localctx = new Index_entityContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_index_entity);
		try {
			setState(300);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				integer_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				variable_entity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_entityContext extends ParserRuleContext {
		public Variable_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_entity; }
	 
		public Variable_entityContext() { }
		public void copyFrom(Variable_entityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntityVariableContext extends Variable_entityContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public EntityVariableContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterEntityVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitEntityVariable(this);
		}
	}
	public static class EntityArrayAccessContext extends Variable_entityContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public List<TerminalNode> LBRK() { return getTokens(ExprGrammarParser.LBRK); }
		public TerminalNode LBRK(int i) {
			return getToken(ExprGrammarParser.LBRK, i);
		}
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public List<TerminalNode> RBRK() { return getTokens(ExprGrammarParser.RBRK); }
		public TerminalNode RBRK(int i) {
			return getToken(ExprGrammarParser.RBRK, i);
		}
		public List<TerminalNode> COLON() { return getTokens(ExprGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ExprGrammarParser.COLON, i);
		}
		public EntityArrayAccessContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterEntityArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitEntityArrayAccess(this);
		}
	}

	public final Variable_entityContext variable_entity() throws RecognitionException {
		Variable_entityContext _localctx = new Variable_entityContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable_entity);
		int _la;
		try {
			int _alt;
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new EntityArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(IDENTIFIER);
				setState(312); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(304);
						match(LBRK);
						setState(305);
						arithmetic_expr(0);
						setState(308);
						_la = _input.LA(1);
						if (_la==COLON) {
							{
							setState(306);
							match(COLON);
							setState(307);
							arithmetic_expr(0);
							}
						}

						setState(310);
						match(RBRK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(314); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_entityContext extends ParserRuleContext {
		public Logical_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_entity; }
	 
		public Logical_entityContext() { }
		public void copyFrom(Logical_entityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntityLogicalConstContext extends Logical_entityContext {
		public TerminalNode TRUE() { return getToken(ExprGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ExprGrammarParser.FALSE, 0); }
		public EntityLogicalConstContext(Logical_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterEntityLogicalConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitEntityLogicalConst(this);
		}
	}

	public final Logical_entityContext logical_entity() throws RecognitionException {
		Logical_entityContext _localctx = new Logical_entityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logical_entity);
		int _la;
		try {
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_endContext extends ParserRuleContext {
		public List<TerminalNode> SEMI() { return getTokens(ExprGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ExprGrammarParser.SEMI, i);
		}
		public Expr_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExpr_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExpr_end(this);
		}
	}

	public final Expr_endContext expr_end() throws RecognitionException {
		Expr_endContext _localctx = new Expr_endContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr_end);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(320);
					_la = _input.LA(1);
					if ( !(_la==T__4 || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(323); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_entityContext extends ParserRuleContext {
		public String_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_entity; }
	 
		public String_entityContext() { }
		public void copyFrom(String_entityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringConstContext extends String_entityContext {
		public TerminalNode StringLiteral() { return getToken(ExprGrammarParser.StringLiteral, 0); }
		public StringConstContext(String_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStringConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStringConst(this);
		}
	}
	public static class StringVariableContext extends String_entityContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public StringVariableContext(String_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterStringVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitStringVariable(this);
		}
	}

	public final String_entityContext string_entity() throws RecognitionException {
		String_entityContext _localctx = new String_entityContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_string_entity);
		try {
			setState(327);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				match(StringLiteral);
				}
				break;
			case IDENTIFIER:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				variable_entity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_initContext extends ParserRuleContext {
		public TerminalNode LBRK() { return getToken(ExprGrammarParser.LBRK, 0); }
		public TerminalNode RBRK() { return getToken(ExprGrammarParser.RBRK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprGrammarParser.COMMA, i);
		}
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArray_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArray_init(this);
		}
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(LBRK);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(330);
					expression();
					setState(331);
					match(COMMA);
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(339);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(338);
				expression();
				}
			}

			setState(341);
			match(RBRK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_genContext extends ParserRuleContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode COLON() { return getToken(ExprGrammarParser.COLON, 0); }
		public Array_genContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_gen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArray_gen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArray_gen(this);
		}
	}

	public final Array_genContext array_gen() throws RecognitionException {
		Array_genContext _localctx = new Array_genContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_array_gen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			arithmetic_expr(0);
			setState(344);
			match(COLON);
			setState(345);
			arithmetic_expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
	 
		public Func_callContext() { }
		public void copyFrom(Func_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncCallContext extends Func_callContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ExprGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ExprGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public List<TerminalNode> PERIOD() { return getTokens(ExprGrammarParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(ExprGrammarParser.PERIOD, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprGrammarParser.COMMA, i);
		}
		public FuncCallContext(Func_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitFuncCall(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func_call);
		int _la;
		try {
			int _alt;
			_localctx = new FuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(IDENTIFIER);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(348);
				match(PERIOD);
				setState(349);
				match(IDENTIFIER);
				}
				}
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(355);
			match(LPAREN);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(356);
					expression();
					setState(357);
					match(COMMA);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(365);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(364);
				expression();
				}
			}

			setState(367);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_comprehensionContext extends ParserRuleContext {
		public TerminalNode LBRK() { return getToken(ExprGrammarParser.LBRK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRK() { return getToken(ExprGrammarParser.RBRK, 0); }
		public List<List_comp_for_ifContext> list_comp_for_if() {
			return getRuleContexts(List_comp_for_ifContext.class);
		}
		public List_comp_for_ifContext list_comp_for_if(int i) {
			return getRuleContext(List_comp_for_ifContext.class,i);
		}
		public List_comprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_comprehension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterList_comprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitList_comprehension(this);
		}
	}

	public final List_comprehensionContext list_comprehension() throws RecognitionException {
		List_comprehensionContext _localctx = new List_comprehensionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_list_comprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(LBRK);
			setState(370);
			expression();
			setState(372); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(371);
				list_comp_for_if();
				}
				}
				setState(374); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(376);
			match(RBRK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_comp_for_ifContext extends ParserRuleContext {
		public List_comp_forContext list_comp_for() {
			return getRuleContext(List_comp_forContext.class,0);
		}
		public List_comp_ifContext list_comp_if() {
			return getRuleContext(List_comp_ifContext.class,0);
		}
		public List_comp_for_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_comp_for_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterList_comp_for_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitList_comp_for_if(this);
		}
	}

	public final List_comp_for_ifContext list_comp_for_if() throws RecognitionException {
		List_comp_for_ifContext _localctx = new List_comp_for_ifContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_list_comp_for_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			list_comp_for();
			setState(380);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(379);
				list_comp_if();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_comp_forContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List_comp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_comp_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterList_comp_for(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitList_comp_for(this);
		}
	}

	public final List_comp_forContext list_comp_for() throws RecognitionException {
		List_comp_forContext _localctx = new List_comp_forContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_list_comp_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__3);
			setState(383);
			match(IDENTIFIER);
			setState(384);
			match(T__5);
			setState(385);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_comp_ifContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public List_comp_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_comp_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterList_comp_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitList_comp_if(this);
		}
	}

	public final List_comp_ifContext list_comp_if() throws RecognitionException {
		List_comp_ifContext _localctx = new List_comp_ifContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_list_comp_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__0);
			setState(388);
			logical_expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		case 9:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0189\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\7\3;\n\3\f\3\16\3>\13\3\3\3\3\3\5"+
		"\3B\n\3\5\3D\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3\4\5"+
		"\4c\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4k\n\4\f\4\16\4n\13\4\3\4\5\4q\n\4\3"+
		"\4\3\4\3\4\5\4v\n\4\5\4x\n\4\3\4\3\4\3\4\5\4}\n\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008a\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u0091\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u0098\n\7\3\7\3\7\6\7\u009c\n\7\r\7\16\7\u009d"+
		"\3\7\3\7\3\7\3\7\5\7\u00a4\n\7\3\7\3\7\3\7\3\7\5\7\u00aa\n\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00b0\n\7\3\7\3\7\3\7\3\7\5\7\u00b6\n\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00bc\n\7\3\7\3\7\3\7\3\7\5\7\u00c2\n\7\5\7\u00c4\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00cf\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00d7\n"+
		"\b\f\b\16\b\u00da\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e4\n\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00f5\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0118\n\13\f\13\16\13\u011b"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u0122\n\f\3\r\3\r\3\r\5\r\u0127\n\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\5\20\u012f\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0137\n\21\3\21\3\21\6\21\u013b\n\21\r\21\16\21\u013c\5\21\u013f"+
		"\n\21\3\22\3\22\3\23\6\23\u0144\n\23\r\23\16\23\u0145\3\24\3\24\5\24\u014a"+
		"\n\24\3\25\3\25\3\25\3\25\7\25\u0150\n\25\f\25\16\25\u0153\13\25\3\25"+
		"\5\25\u0156\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u0161"+
		"\n\27\f\27\16\27\u0164\13\27\3\27\3\27\3\27\3\27\7\27\u016a\n\27\f\27"+
		"\16\27\u016d\13\27\3\27\5\27\u0170\n\27\3\27\3\27\3\30\3\30\3\30\6\30"+
		"\u0177\n\30\r\30\16\30\u0178\3\30\3\30\3\31\3\31\5\31\u017f\n\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\2\4\16\24\34\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\7\3\2\27\30\3\2\23\30\3\2 !"+
		"\3\2\21\22\4\2\7\7\63\63\u01b9\2\66\3\2\2\2\4<\3\2\2\2\6|\3\2\2\2\b~\3"+
		"\2\2\2\n\u0089\3\2\2\2\f\u00c3\3\2\2\2\16\u00ce\3\2\2\2\20\u00e3\3\2\2"+
		"\2\22\u00e5\3\2\2\2\24\u00f4\3\2\2\2\26\u0121\3\2\2\2\30\u0126\3\2\2\2"+
		"\32\u0128\3\2\2\2\34\u012a\3\2\2\2\36\u012e\3\2\2\2 \u013e\3\2\2\2\"\u0140"+
		"\3\2\2\2$\u0143\3\2\2\2&\u0149\3\2\2\2(\u014b\3\2\2\2*\u0159\3\2\2\2,"+
		"\u015d\3\2\2\2.\u0173\3\2\2\2\60\u017c\3\2\2\2\62\u0180\3\2\2\2\64\u0185"+
		"\3\2\2\2\66\67\5\4\3\2\678\7\2\2\38\3\3\2\2\29;\5\6\4\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=C\3\2\2\2><\3\2\2\2?A\5\n\6\2@B\5$\23\2A@\3"+
		"\2\2\2AB\3\2\2\2BD\3\2\2\2C?\3\2\2\2CD\3\2\2\2D\5\3\2\2\2EF\5\f\7\2FG"+
		"\5$\23\2G}\3\2\2\2HI\7\3\2\2IJ\7(\2\2JK\5\16\b\2KL\7)\2\2LO\5\b\5\2MN"+
		"\7\4\2\2NP\5\b\5\2OM\3\2\2\2OP\3\2\2\2P}\3\2\2\2QR\7\5\2\2RS\7(\2\2ST"+
		"\5\16\b\2TU\7)\2\2UV\5\b\5\2V}\3\2\2\2WX\7\6\2\2X^\7(\2\2YZ\5\f\7\2Z["+
		"\7\61\2\2[]\3\2\2\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2"+
		"\2`^\3\2\2\2ac\5\f\7\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\63\2\2ef\5\16"+
		"\b\2fl\7\63\2\2gh\5\n\6\2hi\7\61\2\2ik\3\2\2\2jg\3\2\2\2kn\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2oq\5\n\6\2po\3\2\2\2pq\3\2\2\2qr\3"+
		"\2\2\2rw\7)\2\2sx\7\63\2\2tv\5\b\5\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2ws\3"+
		"\2\2\2wu\3\2\2\2x}\3\2\2\2yz\5,\27\2z{\5$\23\2{}\3\2\2\2|E\3\2\2\2|H\3"+
		"\2\2\2|Q\3\2\2\2|W\3\2\2\2|y\3\2\2\2}\7\3\2\2\2~\177\7,\2\2\177\u0080"+
		"\5\4\3\2\u0080\u0081\7-\2\2\u0081\t\3\2\2\2\u0082\u008a\5\24\13\2\u0083"+
		"\u008a\5\16\b\2\u0084\u008a\5\26\f\2\u0085\u008a\5\f\7\2\u0086\u008a\5"+
		"(\25\2\u0087\u008a\5.\30\2\u0088\u008a\5*\26\2\u0089\u0082\3\2\2\2\u0089"+
		"\u0083\3\2\2\2\u0089\u0084\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0086\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\13\3\2\2\2\u008b\u008c"+
		"\7\60\2\2\u008c\u0090\7\'\2\2\u008d\u0091\5\n\6\2\u008e\u0091\5\6\4\2"+
		"\u008f\u0091\5(\25\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u00c4\3\2\2\2\u0092\u009b\7\60\2\2\u0093\u0094\7*\2\2\u0094"+
		"\u0097\5\24\13\2\u0095\u0096\7\62\2\2\u0096\u0098\5\24\13\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7+\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0093\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\7\'\2\2\u00a0"+
		"\u00a4\5\n\6\2\u00a1\u00a4\5\6\4\2\u00a2\u00a4\5(\25\2\u00a3\u00a0\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00c4\3\2\2\2\u00a5"+
		"\u00a6\5 \21\2\u00a6\u00a9\7$\2\2\u00a7\u00aa\5\n\6\2\u00a8\u00aa\5\6"+
		"\4\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00c4\3\2\2\2\u00ab"+
		"\u00ac\5 \21\2\u00ac\u00af\7%\2\2\u00ad\u00b0\5\n\6\2\u00ae\u00b0\5\6"+
		"\4\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00c4\3\2\2\2\u00b1"+
		"\u00b2\5 \21\2\u00b2\u00b5\7&\2\2\u00b3\u00b6\5\n\6\2\u00b4\u00b6\5\6"+
		"\4\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00c4\3\2\2\2\u00b7"+
		"\u00b8\5 \21\2\u00b8\u00bb\7\"\2\2\u00b9\u00bc\5\n\6\2\u00ba\u00bc\5\6"+
		"\4\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00c4\3\2\2\2\u00bd"+
		"\u00be\5 \21\2\u00be\u00c1\7#\2\2\u00bf\u00c2\5\n\6\2\u00c0\u00c2\5\6"+
		"\4\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u008b\3\2\2\2\u00c3\u0092\3\2\2\2\u00c3\u00a5\3\2\2\2\u00c3\u00ab\3\2"+
		"\2\2\u00c3\u00b1\3\2\2\2\u00c3\u00b7\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c4"+
		"\r\3\2\2\2\u00c5\u00c6\b\b\1\2\u00c6\u00cf\5\20\t\2\u00c7\u00c8\7\20\2"+
		"\2\u00c8\u00cf\5\16\b\5\u00c9\u00ca\7(\2\2\u00ca\u00cb\5\16\b\2\u00cb"+
		"\u00cc\7)\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\5\"\22\2\u00ce\u00c5\3\2"+
		"\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c9\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d8\3\2\2\2\u00d0\u00d1\f\7\2\2\u00d1\u00d2\7\16\2\2\u00d2\u00d7\5"+
		"\16\b\b\u00d3\u00d4\f\6\2\2\u00d4\u00d5\7\17\2\2\u00d5\u00d7\5\16\b\7"+
		"\u00d6\u00d0\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\17\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00dc\5\24\13\2\u00dc\u00dd\5\22\n\2\u00dd\u00de\5\24\13\2\u00de\u00e4"+
		"\3\2\2\2\u00df\u00e0\5\26\f\2\u00e0\u00e1\t\2\2\2\u00e1\u00e2\5\26\f\2"+
		"\u00e2\u00e4\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4\21"+
		"\3\2\2\2\u00e5\u00e6\t\3\2\2\u00e6\23\3\2\2\2\u00e7\u00e8\b\13\1\2\u00e8"+
		"\u00e9\7\60\2\2\u00e9\u00f5\t\4\2\2\u00ea\u00eb\7\34\2\2\u00eb\u00f5\5"+
		"\24\13\22\u00ec\u00ed\7\n\2\2\u00ed\u00f5\5\24\13\21\u00ee\u00ef\7(\2"+
		"\2\u00ef\u00f0\5\24\13\2\u00f0\u00f1\7)\2\2\u00f1\u00f5\3\2\2\2\u00f2"+
		"\u00f5\5\30\r\2\u00f3\u00f5\5,\27\2\u00f4\u00e7\3\2\2\2\u00f4\u00ea\3"+
		"\2\2\2\u00f4\u00ec\3\2\2\2\u00f4\u00ee\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5\u0119\3\2\2\2\u00f6\u00f7\f\20\2\2\u00f7\u00f8\7"+
		"\13\2\2\u00f8\u0118\5\24\13\21\u00f9\u00fa\f\17\2\2\u00fa\u00fb\7\f\2"+
		"\2\u00fb\u0118\5\24\13\20\u00fc\u00fd\f\16\2\2\u00fd\u00fe\7\r\2\2\u00fe"+
		"\u0118\5\24\13\17\u00ff\u0100\f\r\2\2\u0100\u0101\7\t\2\2\u0101\u0118"+
		"\5\24\13\16\u0102\u0103\f\f\2\2\u0103\u0104\7\n\2\2\u0104\u0118\5\24\13"+
		"\r\u0105\u0106\f\13\2\2\u0106\u0107\7\35\2\2\u0107\u0118\5\24\13\f\u0108"+
		"\u0109\f\n\2\2\u0109\u010a\7\36\2\2\u010a\u0118\5\24\13\13\u010b\u010c"+
		"\f\t\2\2\u010c\u010d\7\37\2\2\u010d\u0118\5\24\13\n\u010e\u010f\f\b\2"+
		"\2\u010f\u0110\7\31\2\2\u0110\u0118\5\24\13\t\u0111\u0112\f\7\2\2\u0112"+
		"\u0113\7\32\2\2\u0113\u0118\5\24\13\b\u0114\u0115\f\6\2\2\u0115\u0116"+
		"\7\33\2\2\u0116\u0118\5\24\13\7\u0117\u00f6\3\2\2\2\u0117\u00f9\3\2\2"+
		"\2\u0117\u00fc\3\2\2\2\u0117\u00ff\3\2\2\2\u0117\u0102\3\2\2\2\u0117\u0105"+
		"\3\2\2\2\u0117\u0108\3\2\2\2\u0117\u010b\3\2\2\2\u0117\u010e\3\2\2\2\u0117"+
		"\u0111\3\2\2\2\u0117\u0114\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a\25\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d"+
		"\5&\24\2\u011d\u011e\7\t\2\2\u011e\u011f\5&\24\2\u011f\u0122\3\2\2\2\u0120"+
		"\u0122\5&\24\2\u0121\u011c\3\2\2\2\u0121\u0120\3\2\2\2\u0122\27\3\2\2"+
		"\2\u0123\u0127\5\32\16\2\u0124\u0127\5\34\17\2\u0125\u0127\5 \21\2\u0126"+
		"\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127\31\3\2\2"+
		"\2\u0128\u0129\7.\2\2\u0129\33\3\2\2\2\u012a\u012b\7/\2\2\u012b\35\3\2"+
		"\2\2\u012c\u012f\5\32\16\2\u012d\u012f\5 \21\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012d\3\2\2\2\u012f\37\3\2\2\2\u0130\u013f\7\60\2\2\u0131\u013a\7\60"+
		"\2\2\u0132\u0133\7*\2\2\u0133\u0136\5\24\13\2\u0134\u0135\7\62\2\2\u0135"+
		"\u0137\5\24\13\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3"+
		"\2\2\2\u0138\u0139\7+\2\2\u0139\u013b\3\2\2\2\u013a\u0132\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2"+
		"\2\2\u013e\u0130\3\2\2\2\u013e\u0131\3\2\2\2\u013f!\3\2\2\2\u0140\u0141"+
		"\t\5\2\2\u0141#\3\2\2\2\u0142\u0144\t\6\2\2\u0143\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146%\3\2\2\2"+
		"\u0147\u014a\79\2\2\u0148\u014a\5 \21\2\u0149\u0147\3\2\2\2\u0149\u0148"+
		"\3\2\2\2\u014a\'\3\2\2\2\u014b\u0151\7*\2\2\u014c\u014d\5\n\6\2\u014d"+
		"\u014e\7\61\2\2\u014e\u0150\3\2\2\2\u014f\u014c\3\2\2\2\u0150\u0153\3"+
		"\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0156\5\n\6\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7+\2\2\u0158)\3\2\2\2\u0159\u015a"+
		"\5\24\13\2\u015a\u015b\7\62\2\2\u015b\u015c\5\24\13\2\u015c+\3\2\2\2\u015d"+
		"\u0162\7\60\2\2\u015e\u015f\7\64\2\2\u015f\u0161\7\60\2\2\u0160\u015e"+
		"\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u016b\7(\2\2\u0166\u0167\5\n"+
		"\6\2\u0167\u0168\7\61\2\2\u0168\u016a\3\2\2\2\u0169\u0166\3\2\2\2\u016a"+
		"\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2"+
		"\2\2\u016d\u016b\3\2\2\2\u016e\u0170\5\n\6\2\u016f\u016e\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7)\2\2\u0172-\3\2\2\2\u0173"+
		"\u0174\7*\2\2\u0174\u0176\5\n\6\2\u0175\u0177\5\60\31\2\u0176\u0175\3"+
		"\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\7+\2\2\u017b/\3\2\2\2\u017c\u017e\5\62\32\2"+
		"\u017d\u017f\5\64\33\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\61"+
		"\3\2\2\2\u0180\u0181\7\6\2\2\u0181\u0182\7\60\2\2\u0182\u0183\7\b\2\2"+
		"\u0183\u0184\5\n\6\2\u0184\63\3\2\2\2\u0185\u0186\7\3\2\2\u0186\u0187"+
		"\5\16\b\2\u0187\65\3\2\2\2.<ACO^blpuw|\u0089\u0090\u0097\u009d\u00a3\u00a9"+
		"\u00af\u00b5\u00bb\u00c1\u00c3\u00ce\u00d6\u00d8\u00e3\u00f4\u0117\u0119"+
		"\u0121\u0126\u012e\u0136\u013c\u013e\u0145\u0149\u0151\u0155\u0162\u016b"+
		"\u016f\u0178\u017e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}