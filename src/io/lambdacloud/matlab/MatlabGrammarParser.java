// Generated from MatlabGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud.matlab;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatlabGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ADD=2, SUB=3, MUL=4, DIV=5, REM=6, POW=7, DMUL=8, SOL=9, AND=10, 
		OR=11, NOT=12, TRUE=13, FALSE=14, GT=15, GE=16, LT=17, LE=18, EQ=19, NEQ=20, 
		BAND=21, BOR=22, BXOR=23, BNOT=24, SHL=25, SHR=26, USHR=27, INC=28, DESC=29, 
		ADD_ASSIGN=30, SUB_ASSIGN=31, MUL_ASSIGN=32, DIV_ASSIGN=33, REM_ASSIGN=34, 
		ASSIGN=35, LPAREN=36, RPAREN=37, LBRK=38, RBRK=39, LCB=40, RCB=41, INTEGER=42, 
		FLOAT=43, IDENTIFIER=44, COMMA=45, COLON=46, SEMI=47, PERIOD=48, SQUOTE=49, 
		DQUOTE=50, COMMENT=51, SKIP_TOKEN=52, WS=53;
	public static final int
		RULE_prog = 0, RULE_expr_end = 1, RULE_statements = 2, RULE_expression = 3, 
		RULE_arithmetic_expr = 4, RULE_numeric_entity = 5, RULE_integer_entity = 6, 
		RULE_float_entity = 7, RULE_variable_entity = 8, RULE_array_init = 9, 
		RULE_expr_list = 10, RULE_func_args = 11;
	public static final String[] ruleNames = {
		"prog", "expr_end", "statements", "expression", "arithmetic_expr", "numeric_entity", 
		"integer_entity", "float_entity", "variable_entity", "array_init", "expr_list", 
		"func_args"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'.*'", "'\\'", 
		null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", 
		"'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", 
		"'{'", "'}'", null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ADD", "SUB", "MUL", "DIV", "REM", "POW", "DMUL", "SOL", "AND", 
		"OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", 
		"BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", 
		"WS"
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
	public String getGrammarFileName() { return "MatlabGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MatlabGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatlabGrammarParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			statements();
			setState(25);
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

	public static class Expr_endContext extends ParserRuleContext {
		public List<TerminalNode> SEMI() { return getTokens(MatlabGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MatlabGrammarParser.SEMI, i);
		}
		public Expr_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExpr_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExpr_end(this);
		}
	}

	public final Expr_endContext expr_end() throws RecognitionException {
		Expr_endContext _localctx = new Expr_endContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==SEMI );
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
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << WS))) != 0)) {
				{
				setState(32);
				expression(0);
				setState(34);
				_la = _input.LA(1);
				if (_la==T__0 || _la==SEMI) {
					{
					setState(33);
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
	public static class TransposeContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SQUOTE() { return getToken(MatlabGrammarParser.SQUOTE, 0); }
		public TransposeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitTranspose(this);
		}
	}
	public static class ExprArrayInitContext extends ExpressionContext {
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ExprArrayInitContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprArrayInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprArrayInit(this);
		}
	}
	public static class ExprArithmeticContext extends ExpressionContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprArithmeticContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprArithmetic(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			switch (_input.LA(1)) {
			case LPAREN:
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
				{
				_localctx = new ExprArithmeticContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(39);
				arithmetic_expr(0);
				}
				break;
			case LBRK:
				{
				_localctx = new ExprArrayInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				array_init();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TransposeContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(43);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(44);
					match(SQUOTE);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class ArithmeticExpressionSolveContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SOL() { return getToken(MatlabGrammarParser.SOL, 0); }
		public ArithmeticExpressionSolveContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionSolve(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionSolve(this);
		}
	}
	public static class ArithmeticExpressionEntityContext extends Arithmetic_exprContext {
		public Numeric_entityContext numeric_entity() {
			return getRuleContext(Numeric_entityContext.class,0);
		}
		public ArithmeticExpressionEntityContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionEntity(this);
		}
	}
	public static class ArithmeticExpressionRangeContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode COLON() { return getToken(MatlabGrammarParser.COLON, 0); }
		public ArithmeticExpressionRangeContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionRange(this);
		}
	}
	public static class ArithmeticExpressionParensContext extends Arithmetic_exprContext {
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public ArithmeticExpressionParensContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionParens(this);
		}
	}
	public static class ArithmeticExpressionAddContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MatlabGrammarParser.ADD, 0); }
		public ArithmeticExpressionAddContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionAdd(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_arithmetic_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(51);
				match(LPAREN);
				setState(52);
				arithmetic_expr(0);
				setState(53);
				match(RPAREN);
				}
				break;
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				numeric_entity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionSolveContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(58);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(59);
						match(SOL);
						setState(60);
						arithmetic_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(61);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(62);
						match(ADD);
						setState(63);
						arithmetic_expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionRangeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(64);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(65);
						match(COLON);
						setState(66);
						arithmetic_expr(4);
						}
						break;
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class Numeric_entityContext extends ParserRuleContext {
		public Integer_entityContext integer_entity() {
			return getRuleContext(Integer_entityContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterNumeric_entity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitNumeric_entity(this);
		}
	}

	public final Numeric_entityContext numeric_entity() throws RecognitionException {
		Numeric_entityContext _localctx = new Numeric_entityContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_numeric_entity);
		int _la;
		try {
			int _alt;
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(72);
					match(WS);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				integer_entity();
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(79);
						match(WS);
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(85);
					match(WS);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				float_entity();
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(92);
						match(WS);
						}
						} 
					}
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(98);
					match(WS);
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				variable_entity();
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(105);
						match(WS);
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public TerminalNode INTEGER() { return getToken(MatlabGrammarParser.INTEGER, 0); }
		public EntityConstIntegerContext(Integer_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterEntityConstInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitEntityConstInteger(this);
		}
	}

	public final Integer_entityContext integer_entity() throws RecognitionException {
		Integer_entityContext _localctx = new Integer_entityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		public TerminalNode FLOAT() { return getToken(MatlabGrammarParser.FLOAT, 0); }
		public EntityConstFloatContext(Float_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterEntityConstFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitEntityConstFloat(this);
		}
	}

	public final Float_entityContext float_entity() throws RecognitionException {
		Float_entityContext _localctx = new Float_entityContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
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
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public EntityVariableContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterEntityVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitEntityVariable(this);
		}
	}
	public static class EntityArrayAccessContext extends Variable_entityContext {
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public Func_argsContext func_args() {
			return getRuleContext(Func_argsContext.class,0);
		}
		public EntityArrayAccessContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterEntityArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitEntityArrayAccess(this);
		}
	}

	public final Variable_entityContext variable_entity() throws RecognitionException {
		Variable_entityContext _localctx = new Variable_entityContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable_entity);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new EntityArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(IDENTIFIER);
				setState(119);
				func_args();
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

	public static class Array_initContext extends ParserRuleContext {
		public TerminalNode LBRK() { return getToken(MatlabGrammarParser.LBRK, 0); }
		public List<Expr_listContext> expr_list() {
			return getRuleContexts(Expr_listContext.class);
		}
		public Expr_listContext expr_list(int i) {
			return getRuleContext(Expr_listContext.class,i);
		}
		public TerminalNode RBRK() { return getToken(MatlabGrammarParser.RBRK, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MatlabGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MatlabGrammarParser.SEMI, i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArray_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArray_init(this);
		}
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(LBRK);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					expr_list();
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(124);
						match(WS);
						}
						}
						setState(129);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(130);
					match(SEMI);
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(131);
							match(WS);
							}
							} 
						}
						setState(136);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					}
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(142);
			expr_list();
			setState(143);
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MatlabGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MatlabGrammarParser.COMMA, i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					expression(0);
					setState(152);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(146);
						match(COMMA);
						}
						break;
					case WS:
						{
						setState(148); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(147);
								match(WS);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(150); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(159);
				expression(0);
				}
				break;
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

	public static class Func_argsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public Func_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterFunc_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitFunc_args(this);
		}
	}

	public final Func_argsContext func_args() throws RecognitionException {
		Func_argsContext _localctx = new Func_argsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_args);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LPAREN);
			setState(163);
			expr_list();
			setState(164);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 4:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\6\3\37\n\3\r\3\16\3 \3\4\3\4\5\4"+
		"%\n\4\5\4\'\n\4\3\5\3\5\3\5\5\5,\n\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\7\6F\n\6\f\6\16\6I\13\6\3\7\7\7L\n\7\f\7\16\7O\13\7\3\7\3\7\7\7S\n"+
		"\7\f\7\16\7V\13\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\3\7\7\7`\n\7\f\7\16"+
		"\7c\13\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\5"+
		"\7r\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\5\n{\n\n\3\13\3\13\3\13\7\13\u0080"+
		"\n\13\f\13\16\13\u0083\13\13\3\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a"+
		"\13\13\7\13\u008c\n\13\f\13\16\13\u008f\13\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\6\f\u0097\n\f\r\f\16\f\u0098\5\f\u009b\n\f\7\f\u009d\n\f\f\f\16\f\u00a0"+
		"\13\f\3\f\5\f\u00a3\n\f\3\r\3\r\3\r\3\r\3\r\2\4\b\n\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\3\4\2\3\3\61\61\u00b5\2\32\3\2\2\2\4\36\3\2\2\2\6&\3"+
		"\2\2\2\b+\3\2\2\2\n:\3\2\2\2\fq\3\2\2\2\16s\3\2\2\2\20u\3\2\2\2\22z\3"+
		"\2\2\2\24|\3\2\2\2\26\u009e\3\2\2\2\30\u00a4\3\2\2\2\32\33\5\6\4\2\33"+
		"\34\7\2\2\3\34\3\3\2\2\2\35\37\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3"+
		"\2\2\2 !\3\2\2\2!\5\3\2\2\2\"$\5\b\5\2#%\5\4\3\2$#\3\2\2\2$%\3\2\2\2%"+
		"\'\3\2\2\2&\"\3\2\2\2&\'\3\2\2\2\'\7\3\2\2\2()\b\5\1\2),\5\n\6\2*,\5\24"+
		"\13\2+(\3\2\2\2+*\3\2\2\2,\61\3\2\2\2-.\f\3\2\2.\60\7\63\2\2/-\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\t\3\2\2\2\63\61\3\2\2\2\64"+
		"\65\b\6\1\2\65\66\7&\2\2\66\67\5\n\6\2\678\7\'\2\28;\3\2\2\29;\5\f\7\2"+
		":\64\3\2\2\2:9\3\2\2\2;G\3\2\2\2<=\f\7\2\2=>\7\13\2\2>F\5\n\6\b?@\f\6"+
		"\2\2@A\7\4\2\2AF\5\n\6\7BC\f\5\2\2CD\7\60\2\2DF\5\n\6\6E<\3\2\2\2E?\3"+
		"\2\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IG\3\2\2\2J"+
		"L\7\67\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2"+
		"PT\5\16\b\2QS\7\67\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2Ur\3\2\2"+
		"\2VT\3\2\2\2WY\7\67\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2"+
		"\2\2\\Z\3\2\2\2]a\5\20\t\2^`\7\67\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab"+
		"\3\2\2\2br\3\2\2\2ca\3\2\2\2df\7\67\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jn\5\22\n\2km\7\67\2\2lk\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qM\3\2\2\2qZ\3\2\2\2qg\3\2\2"+
		"\2r\r\3\2\2\2st\7,\2\2t\17\3\2\2\2uv\7-\2\2v\21\3\2\2\2w{\7.\2\2xy\7."+
		"\2\2y{\5\30\r\2zw\3\2\2\2zx\3\2\2\2{\23\3\2\2\2|\u008d\7(\2\2}\u0081\5"+
		"\26\f\2~\u0080\7\67\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0088\7\61\2\2\u0085\u0087\7\67\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b}\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2"+
		"\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091"+
		"\5\26\f\2\u0091\u0092\7)\2\2\u0092\25\3\2\2\2\u0093\u009a\5\b\5\2\u0094"+
		"\u009b\7/\2\2\u0095\u0097\7\67\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0094\3\2\2\2\u009a\u0096\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u0093\3\2"+
		"\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5\b\5\2\u00a2\u00a1\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\27\3\2\2\2\u00a4\u00a5\7&\2\2\u00a5\u00a6"+
		"\5\26\f\2\u00a6\u00a7\7\'\2\2\u00a7\31\3\2\2\2\31 $&+\61:EGMTZagnqz\u0081"+
		"\u0088\u008d\u0098\u009a\u009e\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}