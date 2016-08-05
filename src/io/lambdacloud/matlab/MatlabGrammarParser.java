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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		REM=11, POW=12, SOL=13, DADD=14, DSUB=15, DMUL=16, DRDIV=17, DLDIV=18, 
		AND=19, OR=20, NOT=21, TRUE=22, FALSE=23, GT=24, GE=25, LT=26, LE=27, 
		EQ=28, NEQ=29, BAND=30, BOR=31, BXOR=32, BNOT=33, SHL=34, SHR=35, USHR=36, 
		INC=37, DESC=38, ADD_ASSIGN=39, SUB_ASSIGN=40, MUL_ASSIGN=41, DIV_ASSIGN=42, 
		REM_ASSIGN=43, ASSIGN=44, LPAREN=45, RPAREN=46, LBRK=47, RBRK=48, LCB=49, 
		RCB=50, INTEGER=51, FLOAT=52, IDENTIFIER=53, COMMA=54, COLON=55, SEMI=56, 
		PERIOD=57, SQUOTE=58, DQUOTE=59, COMMENT=60, SKIP_TOKEN=61, WS=62;
	public static final int
		RULE_prog = 0, RULE_expr_end = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_expression_with_expr_end = 4, RULE_if_cond_and_body = 5, RULE_else_body = 6, 
		RULE_expression = 7, RULE_arithmetic_expr = 8, RULE_numeric_entity = 9, 
		RULE_integer_entity = 10, RULE_float_entity = 11, RULE_variable_entity = 12, 
		RULE_array_init = 13, RULE_ai_list = 14, RULE_array_access = 15, RULE_aa_index = 16, 
		RULE_func_name_args = 17, RULE_func_def_return = 18, RULE_assign_expr = 19, 
		RULE_logical_expr = 20, RULE_comparison_expr = 21, RULE_comp_operator = 22, 
		RULE_logical_entity = 23;
	public static final String[] ruleNames = {
		"prog", "expr_end", "statements", "statement", "expression_with_expr_end", 
		"if_cond_and_body", "else_body", "expression", "arithmetic_expr", "numeric_entity", 
		"integer_entity", "float_entity", "variable_entity", "array_init", "ai_list", 
		"array_access", "aa_index", "func_name_args", "func_def_return", "assign_expr", 
		"logical_expr", "comparison_expr", "comp_operator", "logical_entity"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'if'", "'elseif'", "'else'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'**'", "'\\'", "'.+'", "'.-'", "'.*'", "'./'", 
		"'.\\'", null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", 
		"'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", "';'", 
		"'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "AND", 
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
			setState(48);
			statements();
			setState(49);
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
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(51);
						match(WS);
						}
						}
						setState(56);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(57);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(58);
							match(WS);
							}
							} 
						}
						setState(63);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(66); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStatementsContext extends StatementsContext {
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
		public ExprStatementsContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			int _alt;
			_localctx = new ExprStatementsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(68);
					statement();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(78);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << WS))) != 0)) {
				{
				setState(74);
				expression();
				setState(76);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SEMI) | (1L << WS))) != 0)) {
					{
					setState(75);
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
	public static class FuncDefContext extends StatementContext {
		public Func_name_argsContext func_name_args() {
			return getRuleContext(Func_name_argsContext.class,0);
		}
		public Func_def_returnContext func_def_return() {
			return getRuleContext(Func_def_returnContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public List<Expr_endContext> expr_end() {
			return getRuleContexts(Expr_endContext.class);
		}
		public Expr_endContext expr_end(int i) {
			return getRuleContext(Expr_endContext.class,i);
		}
		public List<Expression_with_expr_endContext> expression_with_expr_end() {
			return getRuleContexts(Expression_with_expr_endContext.class);
		}
		public Expression_with_expr_endContext expression_with_expr_end(int i) {
			return getRuleContext(Expression_with_expr_endContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public TerminalNode COMMA() { return getToken(MatlabGrammarParser.COMMA, 0); }
		public FuncDefContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitFuncDef(this);
		}
	}
	public static class ExprStatementContext extends StatementContext {
		public Expression_with_expr_endContext expression_with_expr_end() {
			return getRuleContext(Expression_with_expr_endContext.class,0);
		}
		public ExprStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(120);
			switch (_input.LA(1)) {
			case T__3:
			case SUB:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAREN:
			case LBRK:
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
				_localctx = new ExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				expression_with_expr_end();
				}
				break;
			case T__1:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(T__1);
				setState(85);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(82);
					func_def_return();
					setState(83);
					match(ASSIGN);
					}
					break;
				}
				setState(87);
				func_name_args();
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(88);
					expr_end();
					}
					break;
				case 2:
					{
					{
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(89);
						match(WS);
						}
						}
						setState(94);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(95);
					match(COMMA);
					setState(99);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(96);
							match(WS);
							}
							} 
						}
						setState(101);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					}
					}
					}
					break;
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << WS))) != 0)) {
					{
					{
					setState(104);
					expression_with_expr_end();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(T__2);
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(111);
						match(WS);
						}
						} 
					}
					setState(116);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(118);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(117);
					expr_end();
					}
					break;
				}
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

	public static class Expression_with_expr_endContext extends ParserRuleContext {
		public Expression_with_expr_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_with_expr_end; }
	 
		public Expression_with_expr_endContext() { }
		public void copyFrom(Expression_with_expr_endContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprIfContext extends Expression_with_expr_endContext {
		public List<If_cond_and_bodyContext> if_cond_and_body() {
			return getRuleContexts(If_cond_and_bodyContext.class);
		}
		public If_cond_and_bodyContext if_cond_and_body(int i) {
			return getRuleContext(If_cond_and_bodyContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Else_bodyContext else_body() {
			return getRuleContext(Else_bodyContext.class,0);
		}
		public List<Expr_endContext> expr_end() {
			return getRuleContexts(Expr_endContext.class);
		}
		public Expr_endContext expr_end(int i) {
			return getRuleContext(Expr_endContext.class,i);
		}
		public ExprIfContext(Expression_with_expr_endContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprIf(this);
		}
	}
	public static class ExprWithExprEndContext extends Expression_with_expr_endContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public ExprWithExprEndContext(Expression_with_expr_endContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprWithExprEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprWithExprEnd(this);
		}
	}

	public final Expression_with_expr_endContext expression_with_expr_end() throws RecognitionException {
		Expression_with_expr_endContext _localctx = new Expression_with_expr_endContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression_with_expr_end);
		int _la;
		try {
			int _alt;
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ExprWithExprEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				expression();
				setState(123);
				expr_end();
				}
				break;
			case 2:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(125);
					match(WS);
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(T__3);
				setState(132);
				if_cond_and_body();
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						{
						setState(136);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(133);
							match(WS);
							}
							}
							setState(138);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(139);
						match(T__4);
						}
						setState(141);
						if_cond_and_body();
						}
						} 
					}
					setState(146);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					{
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(147);
						match(WS);
						}
						}
						setState(152);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(153);
					match(T__5);
					setState(157);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(154);
							match(WS);
							}
							} 
						}
						setState(159);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
					}
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(160);
						expr_end();
						}
						break;
					}
					}
					setState(163);
					else_body();
					}
					break;
				}
				{
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(166);
					match(WS);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(172);
				match(T__2);
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(173);
						match(WS);
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(179);
					expr_end();
					}
					break;
				}
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

	public static class If_cond_and_bodyContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public List<Expression_with_expr_endContext> expression_with_expr_end() {
			return getRuleContexts(Expression_with_expr_endContext.class);
		}
		public Expression_with_expr_endContext expression_with_expr_end(int i) {
			return getRuleContext(Expression_with_expr_endContext.class,i);
		}
		public If_cond_and_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_cond_and_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterIf_cond_and_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitIf_cond_and_body(this);
		}
	}

	public final If_cond_and_bodyContext if_cond_and_body() throws RecognitionException {
		If_cond_and_bodyContext _localctx = new If_cond_and_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_cond_and_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			logical_expr(0);
			setState(185);
			expr_end();
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					expression_with_expr_end();
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class Else_bodyContext extends ParserRuleContext {
		public List<Expression_with_expr_endContext> expression_with_expr_end() {
			return getRuleContexts(Expression_with_expr_endContext.class);
		}
		public Expression_with_expr_endContext expression_with_expr_end(int i) {
			return getRuleContext(Expression_with_expr_endContext.class,i);
		}
		public Else_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterElse_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitElse_body(this);
		}
	}

	public final Else_bodyContext else_body() throws RecognitionException {
		Else_bodyContext _localctx = new Else_bodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_else_body);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					expression_with_expr_end();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
	public static class ExprAssignContext extends ExpressionContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprAssign(this);
		}
	}
	public static class ExprLogicalContext extends ExpressionContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public ExprLogicalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprLogical(this);
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				assign_expr();
				}
				break;
			case 3:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				logical_expr(0);
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
	public static class ArithmeticExpressionDLDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode DLDIV() { return getToken(MatlabGrammarParser.DLDIV, 0); }
		public ArithmeticExpressionDLDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionDLDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionDLDiv(this);
		}
	}
	public static class ArithmeticExpressionSOLContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SOL() { return getToken(MatlabGrammarParser.SOL, 0); }
		public ArithmeticExpressionSOLContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionSOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionSOL(this);
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
	public static class ArithmeticExpressionPowContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode POW() { return getToken(MatlabGrammarParser.POW, 0); }
		public ArithmeticExpressionPowContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionPow(this);
		}
	}
	public static class ArithmeticExpressionRemContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode REM() { return getToken(MatlabGrammarParser.REM, 0); }
		public ArithmeticExpressionRemContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionRem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionRem(this);
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
	public static class TransposeContext extends Arithmetic_exprContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode SQUOTE() { return getToken(MatlabGrammarParser.SQUOTE, 0); }
		public TransposeContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterTranspose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitTranspose(this);
		}
	}
	public static class ArithmeticExpressionDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(MatlabGrammarParser.DIV, 0); }
		public ArithmeticExpressionDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionDiv(this);
		}
	}
	public static class ArithmeticExpressionMulContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MatlabGrammarParser.MUL, 0); }
		public ArithmeticExpressionMulContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionMul(this);
		}
	}
	public static class ArithmeticExpressionDMulContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode DMUL() { return getToken(MatlabGrammarParser.DMUL, 0); }
		public ArithmeticExpressionDMulContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionDMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionDMul(this);
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
	public static class ArithmeticExpressionNegationEntityContext extends Arithmetic_exprContext {
		public TerminalNode SUB() { return getToken(MatlabGrammarParser.SUB, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ArithmeticExpressionNegationEntityContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionNegationEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionNegationEntity(this);
		}
	}
	public static class ArithmeticExpressionRangeContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(MatlabGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MatlabGrammarParser.COLON, i);
		}
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
	public static class ArithmeticExpressionSubContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(MatlabGrammarParser.SUB, 0); }
		public TerminalNode DSUB() { return getToken(MatlabGrammarParser.DSUB, 0); }
		public ArithmeticExpressionSubContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionSub(this);
		}
	}
	public static class ArithmeticExpressionDRDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode DRDIV() { return getToken(MatlabGrammarParser.DRDIV, 0); }
		public ArithmeticExpressionDRDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionDRDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionDRDiv(this);
		}
	}
	public static class ExprArrayInitContext extends Arithmetic_exprContext {
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ExprArrayInitContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprArrayInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprArrayInit(this);
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
		public TerminalNode DADD() { return getToken(MatlabGrammarParser.DADD, 0); }
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(204);
				match(SUB);
				setState(205);
				arithmetic_expr(15);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(LPAREN);
				setState(207);
				arithmetic_expr(0);
				setState(208);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ExprArrayInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				array_init();
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				numeric_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionSolveContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(214);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(215);
						match(SOL);
						setState(216);
						arithmetic_expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionPowContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(217);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(218);
						match(POW);
						setState(219);
						arithmetic_expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(220);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(221);
						match(MUL);
						setState(222);
						arithmetic_expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionDMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(223);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(224);
						match(DMUL);
						setState(225);
						arithmetic_expr(13);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(226);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(227);
						match(DIV);
						setState(228);
						arithmetic_expr(12);
						}
						break;
					case 6:
						{
						_localctx = new ArithmeticExpressionDLDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(229);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(230);
						match(DLDIV);
						setState(231);
						arithmetic_expr(11);
						}
						break;
					case 7:
						{
						_localctx = new ArithmeticExpressionDRDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(232);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(233);
						match(DRDIV);
						setState(234);
						arithmetic_expr(10);
						}
						break;
					case 8:
						{
						_localctx = new ArithmeticExpressionSOLContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(235);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(236);
						match(SOL);
						setState(237);
						arithmetic_expr(9);
						}
						break;
					case 9:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(238);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(239);
						match(REM);
						setState(240);
						arithmetic_expr(8);
						}
						break;
					case 10:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(241);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(242);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==DADD) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(243);
						arithmetic_expr(7);
						}
						break;
					case 11:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(244);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(245);
						_la = _input.LA(1);
						if ( !(_la==SUB || _la==DSUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(246);
						arithmetic_expr(6);
						}
						break;
					case 12:
						{
						_localctx = new ArithmeticExpressionRangeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248);
						match(COLON);
						setState(252);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
						case 1:
							{
							setState(249);
							arithmetic_expr(0);
							setState(250);
							match(COLON);
							}
							break;
						}
						setState(254);
						arithmetic_expr(5);
						}
						break;
					case 13:
						{
						_localctx = new TransposeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(255);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(256);
						match(SQUOTE);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 18, RULE_numeric_entity);
		int _la;
		try {
			int _alt;
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(262);
					match(WS);
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
				integer_entity();
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(269);
						match(WS);
						}
						} 
					}
					setState(274);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(275);
					match(WS);
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				float_entity();
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(282);
						match(WS);
						}
						} 
					}
					setState(287);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(288);
						match(WS);
						}
						} 
					}
					setState(293);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(294);
				variable_entity();
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(295);
						match(WS);
						}
						} 
					}
					setState(300);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 20, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
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
		enterRule(_localctx, 22, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
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
	public static class ArrayAccessOrFuncCallContext extends Variable_entityContext {
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public ArrayAccessOrFuncCallContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArrayAccessOrFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArrayAccessOrFuncCall(this);
		}
	}

	public final Variable_entityContext variable_entity() throws RecognitionException {
		Variable_entityContext _localctx = new Variable_entityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable_entity);
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new ArrayAccessOrFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				array_access();
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
		public List<Ai_listContext> ai_list() {
			return getRuleContexts(Ai_listContext.class);
		}
		public Ai_listContext ai_list(int i) {
			return getRuleContext(Ai_listContext.class,i);
		}
		public TerminalNode RBRK() { return getToken(MatlabGrammarParser.RBRK, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MatlabGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MatlabGrammarParser.SEMI, i);
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
		enterRule(_localctx, 26, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(311);
				match(WS);
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(LBRK);
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(318);
					match(WS);
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(324);
					ai_list();
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(325);
						match(WS);
						}
						}
						setState(330);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(331);
					match(SEMI);
					setState(335);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(332);
							match(WS);
							}
							} 
						}
						setState(337);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					}
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(343);
			ai_list();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(344);
				match(WS);
				}
				}
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(350);
			match(RBRK);
			setState(354);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(351);
					match(WS);
					}
					} 
				}
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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

	public static class Ai_listContext extends ParserRuleContext {
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
		public Ai_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ai_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAi_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAi_list(this);
		}
	}

	public final Ai_listContext ai_list() throws RecognitionException {
		Ai_listContext _localctx = new Ai_listContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ai_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(357);
					expression();
					setState(364);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(358);
						match(COMMA);
						}
						break;
					case WS:
						{
						setState(360); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(359);
								match(WS);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(362); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(371);
				expression();
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

	public static class Array_accessContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(MatlabGrammarParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(MatlabGrammarParser.PERIOD, i);
		}
		public List<Aa_indexContext> aa_index() {
			return getRuleContexts(Aa_indexContext.class);
		}
		public Aa_indexContext aa_index(int i) {
			return getRuleContext(Aa_indexContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MatlabGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MatlabGrammarParser.COMMA, i);
		}
		public Array_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArray_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArray_access(this);
		}
	}

	public final Array_accessContext array_access() throws RecognitionException {
		Array_accessContext _localctx = new Array_accessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array_access);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(374);
				match(WS);
				}
				}
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			match(IDENTIFIER);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(381);
				match(PERIOD);
				setState(382);
				match(IDENTIFIER);
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(388);
				match(WS);
				}
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(394);
			match(LPAREN);
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(395);
					match(WS);
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(401);
					aa_index();
					setState(405);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(402);
						match(WS);
						}
						}
						setState(407);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(408);
					match(COMMA);
					setState(412);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(409);
							match(WS);
							}
							} 
						}
						setState(414);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
					}
					}
					} 
				}
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(420);
				aa_index();
				}
				break;
			}
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(423);
				match(WS);
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(429);
			match(RPAREN);
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(430);
					match(WS);
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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

	public static class Aa_indexContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MatlabGrammarParser.COLON, 0); }
		public Aa_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aa_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAa_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAa_index(this);
		}
	}

	public final Aa_indexContext aa_index() throws RecognitionException {
		Aa_indexContext _localctx = new Aa_indexContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_aa_index);
		try {
			setState(438);
			switch (_input.LA(1)) {
			case SUB:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAREN:
			case LBRK:
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				expression();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(COLON);
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

	public static class Func_name_argsContext extends ParserRuleContext {
		public Func_name_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name_args; }
	 
		public Func_name_argsContext() { }
		public void copyFrom(Func_name_argsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncDefNameArgsContext extends Func_name_argsContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MatlabGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MatlabGrammarParser.COMMA, i);
		}
		public FuncDefNameArgsContext(Func_name_argsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterFuncDefNameArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitFuncDefNameArgs(this);
		}
	}

	public final Func_name_argsContext func_name_args() throws RecognitionException {
		Func_name_argsContext _localctx = new Func_name_argsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_func_name_args);
		int _la;
		try {
			int _alt;
			_localctx = new FuncDefNameArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(440);
				match(WS);
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			match(IDENTIFIER);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(447);
				match(WS);
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(453);
			match(LPAREN);
			setState(476);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(454);
						match(WS);
						}
						}
						setState(459);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(460);
					match(IDENTIFIER);
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(461);
						match(WS);
						}
						}
						setState(466);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(467);
					match(COMMA);
					setState(471);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(468);
							match(WS);
							}
							} 
						}
						setState(473);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
					}
					}
					} 
				}
				setState(478);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			setState(492);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==WS) {
				{
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(479);
					match(WS);
					}
					}
					setState(484);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(485);
				match(IDENTIFIER);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(486);
					match(WS);
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(494);
			match(RPAREN);
			setState(498);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(495);
					match(WS);
					}
					} 
				}
				setState(500);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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

	public static class Func_def_returnContext extends ParserRuleContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Func_def_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterFunc_def_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitFunc_def_return(this);
		}
	}

	public final Func_def_returnContext func_def_return() throws RecognitionException {
		Func_def_returnContext _localctx = new Func_def_returnContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_func_def_return);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(501);
					match(WS);
					}
					} 
				}
				setState(506);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			}
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(507);
				variable_entity();
				}
				break;
			case 2:
				{
				setState(508);
				array_init();
				}
				break;
			}
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(511);
				match(WS);
				}
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Assign_exprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(517);
				match(WS);
				}
				}
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(523);
			match(IDENTIFIER);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(524);
				match(WS);
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(530);
			match(ASSIGN);
			setState(531);
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
		public TerminalNode NOT() { return getToken(MatlabGrammarParser.NOT, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public LogicalExpressionNotContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionNot(this);
		}
	}
	public static class LogicalExpressionAndContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MatlabGrammarParser.AND, 0); }
		public LogicalExpressionAndContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionAnd(this);
		}
	}
	public static class LogicalExpressionOrContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(MatlabGrammarParser.OR, 0); }
		public LogicalExpressionOrContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionOr(this);
		}
	}
	public static class LogicalExpressionEntityContext extends Logical_exprContext {
		public Logical_entityContext logical_entity() {
			return getRuleContext(Logical_entityContext.class,0);
		}
		public LogicalExpressionEntityContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionEntity(this);
		}
	}
	public static class LogicalExpressionInParenContext extends Logical_exprContext {
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public LogicalExpressionInParenContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionInParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionInParen(this);
		}
	}
	public static class ComparisonExpressionContext extends Logical_exprContext {
		public Comparison_exprContext comparison_expr() {
			return getRuleContext(Comparison_exprContext.class,0);
		}
		public ComparisonExpressionContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitComparisonExpression(this);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(534);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(535);
				match(NOT);
				setState(536);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(537);
				match(LPAREN);
				setState(538);
				logical_expr(0);
				setState(539);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(541);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(550);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(544);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(545);
						match(AND);
						setState(546);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(547);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(548);
						match(OR);
						setState(549);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(554);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
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
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterComparisonArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitComparisonArithmeticExpression(this);
		}
	}

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comparison_expr);
		try {
			_localctx = new ComparisonArithmeticExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			arithmetic_expr(0);
			setState(556);
			comp_operator();
			setState(557);
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

	public static class Comp_operatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MatlabGrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(MatlabGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(MatlabGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(MatlabGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MatlabGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MatlabGrammarParser.NEQ, 0); }
		public Comp_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterComp_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitComp_operator(this);
		}
	}

	public final Comp_operatorContext comp_operator() throws RecognitionException {
		Comp_operatorContext _localctx = new Comp_operatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
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
		public TerminalNode TRUE() { return getToken(MatlabGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MatlabGrammarParser.FALSE, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public EntityLogicalConstContext(Logical_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterEntityLogicalConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitEntityLogicalConst(this);
		}
	}

	public final Logical_entityContext logical_entity() throws RecognitionException {
		Logical_entityContext _localctx = new Logical_entityContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logical_entity);
		int _la;
		try {
			int _alt;
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				{
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(561);
					match(WS);
					}
					}
					setState(566);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(567);
				match(TRUE);
				setState(571);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(568);
						match(WS);
						}
						} 
					}
					setState(573);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(577);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(574);
					match(WS);
					}
					}
					setState(579);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(580);
				match(FALSE);
				setState(584);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(581);
						match(WS);
						}
						} 
					}
					setState(586);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				}
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 20:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 17);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u0250\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3\7\3>\n\3\f\3\16\3A"+
		"\13\3\6\3C\n\3\r\3\16\3D\3\4\7\4H\n\4\f\4\16\4K\13\4\3\4\3\4\5\4O\n\4"+
		"\5\4Q\n\4\3\5\3\5\3\5\3\5\3\5\5\5X\n\5\3\5\3\5\3\5\7\5]\n\5\f\5\16\5`"+
		"\13\5\3\5\3\5\7\5d\n\5\f\5\16\5g\13\5\5\5i\n\5\3\5\7\5l\n\5\f\5\16\5o"+
		"\13\5\3\5\3\5\7\5s\n\5\f\5\16\5v\13\5\3\5\5\5y\n\5\5\5{\n\5\3\6\3\6\3"+
		"\6\3\6\7\6\u0081\n\6\f\6\16\6\u0084\13\6\3\6\3\6\3\6\7\6\u0089\n\6\f\6"+
		"\16\6\u008c\13\6\3\6\3\6\3\6\7\6\u0091\n\6\f\6\16\6\u0094\13\6\3\6\7\6"+
		"\u0097\n\6\f\6\16\6\u009a\13\6\3\6\3\6\7\6\u009e\n\6\f\6\16\6\u00a1\13"+
		"\6\3\6\5\6\u00a4\n\6\3\6\5\6\u00a7\n\6\3\6\7\6\u00aa\n\6\f\6\16\6\u00ad"+
		"\13\6\3\6\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4\13\6\3\6\5\6\u00b7\n\6\5\6"+
		"\u00b9\n\6\3\7\3\7\3\7\7\7\u00be\n\7\f\7\16\7\u00c1\13\7\3\b\7\b\u00c4"+
		"\n\b\f\b\16\b\u00c7\13\b\3\t\3\t\3\t\5\t\u00cc\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u00d7\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ff\n\n\3\n\3\n\3\n\7"+
		"\n\u0104\n\n\f\n\16\n\u0107\13\n\3\13\7\13\u010a\n\13\f\13\16\13\u010d"+
		"\13\13\3\13\3\13\7\13\u0111\n\13\f\13\16\13\u0114\13\13\3\13\7\13\u0117"+
		"\n\13\f\13\16\13\u011a\13\13\3\13\3\13\7\13\u011e\n\13\f\13\16\13\u0121"+
		"\13\13\3\13\7\13\u0124\n\13\f\13\16\13\u0127\13\13\3\13\3\13\7\13\u012b"+
		"\n\13\f\13\16\13\u012e\13\13\5\13\u0130\n\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\5\16\u0138\n\16\3\17\7\17\u013b\n\17\f\17\16\17\u013e\13\17\3\17\3\17"+
		"\7\17\u0142\n\17\f\17\16\17\u0145\13\17\3\17\3\17\7\17\u0149\n\17\f\17"+
		"\16\17\u014c\13\17\3\17\3\17\7\17\u0150\n\17\f\17\16\17\u0153\13\17\7"+
		"\17\u0155\n\17\f\17\16\17\u0158\13\17\3\17\3\17\7\17\u015c\n\17\f\17\16"+
		"\17\u015f\13\17\3\17\3\17\7\17\u0163\n\17\f\17\16\17\u0166\13\17\3\20"+
		"\3\20\3\20\6\20\u016b\n\20\r\20\16\20\u016c\5\20\u016f\n\20\7\20\u0171"+
		"\n\20\f\20\16\20\u0174\13\20\3\20\5\20\u0177\n\20\3\21\7\21\u017a\n\21"+
		"\f\21\16\21\u017d\13\21\3\21\3\21\3\21\7\21\u0182\n\21\f\21\16\21\u0185"+
		"\13\21\3\21\7\21\u0188\n\21\f\21\16\21\u018b\13\21\3\21\3\21\7\21\u018f"+
		"\n\21\f\21\16\21\u0192\13\21\3\21\3\21\7\21\u0196\n\21\f\21\16\21\u0199"+
		"\13\21\3\21\3\21\7\21\u019d\n\21\f\21\16\21\u01a0\13\21\7\21\u01a2\n\21"+
		"\f\21\16\21\u01a5\13\21\3\21\5\21\u01a8\n\21\3\21\7\21\u01ab\n\21\f\21"+
		"\16\21\u01ae\13\21\3\21\3\21\7\21\u01b2\n\21\f\21\16\21\u01b5\13\21\3"+
		"\22\3\22\5\22\u01b9\n\22\3\23\7\23\u01bc\n\23\f\23\16\23\u01bf\13\23\3"+
		"\23\3\23\7\23\u01c3\n\23\f\23\16\23\u01c6\13\23\3\23\3\23\7\23\u01ca\n"+
		"\23\f\23\16\23\u01cd\13\23\3\23\3\23\7\23\u01d1\n\23\f\23\16\23\u01d4"+
		"\13\23\3\23\3\23\7\23\u01d8\n\23\f\23\16\23\u01db\13\23\7\23\u01dd\n\23"+
		"\f\23\16\23\u01e0\13\23\3\23\7\23\u01e3\n\23\f\23\16\23\u01e6\13\23\3"+
		"\23\3\23\7\23\u01ea\n\23\f\23\16\23\u01ed\13\23\5\23\u01ef\n\23\3\23\3"+
		"\23\7\23\u01f3\n\23\f\23\16\23\u01f6\13\23\3\24\7\24\u01f9\n\24\f\24\16"+
		"\24\u01fc\13\24\3\24\3\24\5\24\u0200\n\24\3\24\7\24\u0203\n\24\f\24\16"+
		"\24\u0206\13\24\3\25\7\25\u0209\n\25\f\25\16\25\u020c\13\25\3\25\3\25"+
		"\7\25\u0210\n\25\f\25\16\25\u0213\13\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0221\n\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u0229\n\26\f\26\16\26\u022c\13\26\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\31\7\31\u0235\n\31\f\31\16\31\u0238\13\31\3\31\3\31\7\31\u023c"+
		"\n\31\f\31\16\31\u023f\13\31\3\31\7\31\u0242\n\31\f\31\16\31\u0245\13"+
		"\31\3\31\3\31\7\31\u0249\n\31\f\31\16\31\u024c\13\31\5\31\u024e\n\31\3"+
		"\31\2\4\22*\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\6"+
		"\4\2\3\3::\4\2\t\t\20\20\4\2\n\n\21\21\3\2\32\37\u029e\2\62\3\2\2\2\4"+
		"B\3\2\2\2\6I\3\2\2\2\bz\3\2\2\2\n\u00b8\3\2\2\2\f\u00ba\3\2\2\2\16\u00c5"+
		"\3\2\2\2\20\u00cb\3\2\2\2\22\u00d6\3\2\2\2\24\u012f\3\2\2\2\26\u0131\3"+
		"\2\2\2\30\u0133\3\2\2\2\32\u0137\3\2\2\2\34\u013c\3\2\2\2\36\u0172\3\2"+
		"\2\2 \u017b\3\2\2\2\"\u01b8\3\2\2\2$\u01bd\3\2\2\2&\u01fa\3\2\2\2(\u020a"+
		"\3\2\2\2*\u0220\3\2\2\2,\u022d\3\2\2\2.\u0231\3\2\2\2\60\u024d\3\2\2\2"+
		"\62\63\5\6\4\2\63\64\7\2\2\3\64\3\3\2\2\2\65\67\7@\2\2\66\65\3\2\2\2\67"+
		":\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;?\t\2\2\2<>\7@\2\2"+
		"=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@C\3\2\2\2A?\3\2\2\2B8\3\2\2\2"+
		"CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\5\3\2\2\2FH\5\b\5\2GF\3\2\2\2HK\3\2\2"+
		"\2IG\3\2\2\2IJ\3\2\2\2JP\3\2\2\2KI\3\2\2\2LN\5\20\t\2MO\5\4\3\2NM\3\2"+
		"\2\2NO\3\2\2\2OQ\3\2\2\2PL\3\2\2\2PQ\3\2\2\2Q\7\3\2\2\2R{\5\n\6\2SW\7"+
		"\4\2\2TU\5&\24\2UV\7.\2\2VX\3\2\2\2WT\3\2\2\2WX\3\2\2\2XY\3\2\2\2Yh\5"+
		"$\23\2Zi\5\4\3\2[]\7@\2\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a"+
		"\3\2\2\2`^\3\2\2\2ae\78\2\2bd\7@\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3"+
		"\2\2\2fi\3\2\2\2ge\3\2\2\2hZ\3\2\2\2h^\3\2\2\2hi\3\2\2\2im\3\2\2\2jl\5"+
		"\n\6\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pt\7"+
		"\5\2\2qs\7@\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3"+
		"\2\2\2wy\5\4\3\2xw\3\2\2\2xy\3\2\2\2y{\3\2\2\2zR\3\2\2\2zS\3\2\2\2{\t"+
		"\3\2\2\2|}\5\20\t\2}~\5\4\3\2~\u00b9\3\2\2\2\177\u0081\7@\2\2\u0080\177"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\6\2\2\u0086\u0092\5\f"+
		"\7\2\u0087\u0089\7@\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\u008e\7\7\2\2\u008e\u008f\3\2\2\2\u008f\u0091\5\f\7\2\u0090"+
		"\u008a\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u00a6\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\7@\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009f\7\b\2\2\u009c"+
		"\u009e\7@\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a4\5\4\3\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a7\5\16\b\2\u00a6\u0098\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00ab\3\2\2\2\u00a8\u00aa\7@\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00b2\7\5\2\2\u00af\u00b1\7@\2\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\5\4\3\2\u00b6\u00b5\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8|\3\2\2\2\u00b8\u0082"+
		"\3\2\2\2\u00b9\13\3\2\2\2\u00ba\u00bb\5*\26\2\u00bb\u00bf\5\4\3\2\u00bc"+
		"\u00be\5\n\6\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\r\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4"+
		"\5\n\6\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\17\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00cc\5\22\n"+
		"\2\u00c9\u00cc\5(\25\2\u00ca\u00cc\5*\26\2\u00cb\u00c8\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\21\3\2\2\2\u00cd\u00ce\b\n\1\2\u00ce"+
		"\u00cf\7\n\2\2\u00cf\u00d7\5\22\n\21\u00d0\u00d1\7/\2\2\u00d1\u00d2\5"+
		"\22\n\2\u00d2\u00d3\7\60\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d7\5\34\17\2"+
		"\u00d5\u00d7\5\24\13\2\u00d6\u00cd\3\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u0105\3\2\2\2\u00d8\u00d9\f\22\2\2"+
		"\u00d9\u00da\7\17\2\2\u00da\u0104\5\22\n\23\u00db\u00dc\f\20\2\2\u00dc"+
		"\u00dd\7\16\2\2\u00dd\u0104\5\22\n\21\u00de\u00df\f\17\2\2\u00df\u00e0"+
		"\7\13\2\2\u00e0\u0104\5\22\n\20\u00e1\u00e2\f\16\2\2\u00e2\u00e3\7\22"+
		"\2\2\u00e3\u0104\5\22\n\17\u00e4\u00e5\f\r\2\2\u00e5\u00e6\7\f\2\2\u00e6"+
		"\u0104\5\22\n\16\u00e7\u00e8\f\f\2\2\u00e8\u00e9\7\24\2\2\u00e9\u0104"+
		"\5\22\n\r\u00ea\u00eb\f\13\2\2\u00eb\u00ec\7\23\2\2\u00ec\u0104\5\22\n"+
		"\f\u00ed\u00ee\f\n\2\2\u00ee\u00ef\7\17\2\2\u00ef\u0104\5\22\n\13\u00f0"+
		"\u00f1\f\t\2\2\u00f1\u00f2\7\r\2\2\u00f2\u0104\5\22\n\n\u00f3\u00f4\f"+
		"\b\2\2\u00f4\u00f5\t\3\2\2\u00f5\u0104\5\22\n\t\u00f6\u00f7\f\7\2\2\u00f7"+
		"\u00f8\t\4\2\2\u00f8\u0104\5\22\n\b\u00f9\u00fa\f\6\2\2\u00fa\u00fe\7"+
		"9\2\2\u00fb\u00fc\5\22\n\2\u00fc\u00fd\79\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00fb\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0104\5\22"+
		"\n\7\u0101\u0102\f\23\2\2\u0102\u0104\7<\2\2\u0103\u00d8\3\2\2\2\u0103"+
		"\u00db\3\2\2\2\u0103\u00de\3\2\2\2\u0103\u00e1\3\2\2\2\u0103\u00e4\3\2"+
		"\2\2\u0103\u00e7\3\2\2\2\u0103\u00ea\3\2\2\2\u0103\u00ed\3\2\2\2\u0103"+
		"\u00f0\3\2\2\2\u0103\u00f3\3\2\2\2\u0103\u00f6\3\2\2\2\u0103\u00f9\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\23\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\7@\2\2"+
		"\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0112\5\26\f\2"+
		"\u010f\u0111\7@\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0130\3\2\2\2\u0114\u0112\3\2\2\2\u0115"+
		"\u0117\7@\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011f\5\30\r\2\u011c\u011e\7@\2\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2"+
		"\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0130\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0124\7@\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u012c\5\32\16\2\u0129\u012b\7@\2\2\u012a\u0129\3"+
		"\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u010b\3\2\2\2\u012f\u0118\3\2"+
		"\2\2\u012f\u0125\3\2\2\2\u0130\25\3\2\2\2\u0131\u0132\7\65\2\2\u0132\27"+
		"\3\2\2\2\u0133\u0134\7\66\2\2\u0134\31\3\2\2\2\u0135\u0138\7\67\2\2\u0136"+
		"\u0138\5 \21\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\33\3\2\2"+
		"\2\u0139\u013b\7@\2\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0143\7\61\2\2\u0140\u0142\7@\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0156\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u014a\5\36\20\2\u0147\u0149\7@\2\2\u0148\u0147\3"+
		"\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014d\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0151\7:\2\2\u014e\u0150\7@\2"+
		"\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0146\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0159\u015d\5\36\20\2\u015a\u015c\7@\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u0160\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0164\7\62\2\2\u0161"+
		"\u0163\7@\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2"+
		"\2\2\u0164\u0165\3\2\2\2\u0165\35\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u016e"+
		"\5\20\t\2\u0168\u016f\78\2\2\u0169\u016b\7@\2\2\u016a\u0169\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\3\2"+
		"\2\2\u016e\u0168\3\2\2\2\u016e\u016a\3\2\2\2\u016f\u0171\3\2\2\2\u0170"+
		"\u0167\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0177\5\20\t\2\u0176"+
		"\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177\37\3\2\2\2\u0178\u017a\7@\2\2"+
		"\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0183\7\67\2\2"+
		"\u017f\u0180\7;\2\2\u0180\u0182\7\67\2\2\u0181\u017f\3\2\2\2\u0182\u0185"+
		"\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0189\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0186\u0188\7@\2\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2"+
		"\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b"+
		"\u0189\3\2\2\2\u018c\u0190\7/\2\2\u018d\u018f\7@\2\2\u018e\u018d\3\2\2"+
		"\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u01a3"+
		"\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0197\5\"\22\2\u0194\u0196\7@\2\2\u0195"+
		"\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019e\78\2\2\u019b"+
		"\u019d\7@\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2"+
		"\2\2\u019e\u019f\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1"+
		"\u0193\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a8\5\"\22\2\u01a7"+
		"\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01ac\3\2\2\2\u01a9\u01ab\7@"+
		"\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b3\7\60"+
		"\2\2\u01b0\u01b2\7@\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3"+
		"\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4!\3\2\2\2\u01b5\u01b3\3\2\2\2"+
		"\u01b6\u01b9\5\20\t\2\u01b7\u01b9\79\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b7"+
		"\3\2\2\2\u01b9#\3\2\2\2\u01ba\u01bc\7@\2\2\u01bb\u01ba\3\2\2\2\u01bc\u01bf"+
		"\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf"+
		"\u01bd\3\2\2\2\u01c0\u01c4\7\67\2\2\u01c1\u01c3\7@\2\2\u01c2\u01c1\3\2"+
		"\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01de\7/\2\2\u01c8\u01ca\7@\2"+
		"\2\u01c9\u01c8\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d2\7\67\2\2"+
		"\u01cf\u01d1\7@\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0"+
		"\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5"+
		"\u01d9\78\2\2\u01d6\u01d8\7@\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2"+
		"\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9"+
		"\3\2\2\2\u01dc\u01cb\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01df\u01ee\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e3\7@"+
		"\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e5\3\2\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01eb\7\67"+
		"\2\2\u01e8\u01ea\7@\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb"+
		"\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2"+
		"\2\2\u01ee\u01e4\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f4\7\60\2\2\u01f1\u01f3\7@\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2"+
		"\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5%\3\2\2\2\u01f6\u01f4"+
		"\3\2\2\2\u01f7\u01f9\7@\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01ff\3\2\2\2\u01fc\u01fa\3\2"+
		"\2\2\u01fd\u0200\5\32\16\2\u01fe\u0200\5\34\17\2\u01ff\u01fd\3\2\2\2\u01ff"+
		"\u01fe\3\2\2\2\u0200\u0204\3\2\2\2\u0201\u0203\7@\2\2\u0202\u0201\3\2"+
		"\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\'\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u0209\7@\2\2\u0208\u0207\3\2\2\2"+
		"\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d"+
		"\3\2\2\2\u020c\u020a\3\2\2\2\u020d\u0211\7\67\2\2\u020e\u0210\7@\2\2\u020f"+
		"\u020e\3\2\2\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2"+
		"\2\2\u0212\u0214\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\7.\2\2\u0215"+
		"\u0216\5\20\t\2\u0216)\3\2\2\2\u0217\u0218\b\26\1\2\u0218\u0221\5,\27"+
		"\2\u0219\u021a\7\27\2\2\u021a\u0221\5*\26\5\u021b\u021c\7/\2\2\u021c\u021d"+
		"\5*\26\2\u021d\u021e\7\60\2\2\u021e\u0221\3\2\2\2\u021f\u0221\5\60\31"+
		"\2\u0220\u0217\3\2\2\2\u0220\u0219\3\2\2\2\u0220\u021b\3\2\2\2\u0220\u021f"+
		"\3\2\2\2\u0221\u022a\3\2\2\2\u0222\u0223\f\7\2\2\u0223\u0224\7\25\2\2"+
		"\u0224\u0229\5*\26\b\u0225\u0226\f\6\2\2\u0226\u0227\7\26\2\2\u0227\u0229"+
		"\5*\26\7\u0228\u0222\3\2\2\2\u0228\u0225\3\2\2\2\u0229\u022c\3\2\2\2\u022a"+
		"\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b+\3\2\2\2\u022c\u022a\3\2\2\2"+
		"\u022d\u022e\5\22\n\2\u022e\u022f\5.\30\2\u022f\u0230\5\22\n\2\u0230-"+
		"\3\2\2\2\u0231\u0232\t\5\2\2\u0232/\3\2\2\2\u0233\u0235\7@\2\2\u0234\u0233"+
		"\3\2\2\2\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237"+
		"\u0239\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u023d\7\30\2\2\u023a\u023c\7"+
		"@\2\2\u023b\u023a\3\2\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d"+
		"\u023e\3\2\2\2\u023e\u024e\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u0242\7@"+
		"\2\2\u0241\u0240\3\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243"+
		"\u0244\3\2\2\2\u0244\u0246\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u024a\7\31"+
		"\2\2\u0247\u0249\7@\2\2\u0248\u0247\3\2\2\2\u0249\u024c\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024e\3\2\2\2\u024c\u024a\3\2"+
		"\2\2\u024d\u0236\3\2\2\2\u024d\u0243\3\2\2\2\u024e\61\3\2\2\2W8?DINPW"+
		"^ehmtxz\u0082\u008a\u0092\u0098\u009f\u00a3\u00a6\u00ab\u00b2\u00b6\u00b8"+
		"\u00bf\u00c5\u00cb\u00d6\u00fe\u0103\u0105\u010b\u0112\u0118\u011f\u0125"+
		"\u012c\u012f\u0137\u013c\u0143\u014a\u0151\u0156\u015d\u0164\u016c\u016e"+
		"\u0172\u0176\u017b\u0183\u0189\u0190\u0197\u019e\u01a3\u01a7\u01ac\u01b3"+
		"\u01b8\u01bd\u01c4\u01cb\u01d2\u01d9\u01de\u01e4\u01eb\u01ee\u01f4\u01fa"+
		"\u01ff\u0204\u020a\u0211\u0220\u0228\u022a\u0236\u023d\u0243\u024a\u024d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}