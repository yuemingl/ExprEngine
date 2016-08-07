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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ADD=9, 
		SUB=10, MUL=11, DIV=12, REM=13, POW=14, SOL=15, DADD=16, DSUB=17, DMUL=18, 
		DRDIV=19, DLDIV=20, AND=21, OR=22, NOT=23, TRUE=24, FALSE=25, GT=26, GE=27, 
		LT=28, LE=29, EQ=30, NEQ=31, BAND=32, BOR=33, BXOR=34, BNOT=35, SHL=36, 
		SHR=37, USHR=38, INC=39, DESC=40, ADD_ASSIGN=41, SUB_ASSIGN=42, MUL_ASSIGN=43, 
		DIV_ASSIGN=44, REM_ASSIGN=45, ASSIGN=46, LPAREN=47, RPAREN=48, LBRK=49, 
		RBRK=50, LCB=51, RCB=52, INTEGER=53, FLOAT=54, IDENTIFIER=55, COMMA=56, 
		COLON=57, SEMI=58, PERIOD=59, SQUOTE=60, DQUOTE=61, COMMENT=62, SKIP_TOKEN=63, 
		WS=64;
	public static final int
		RULE_prog = 0, RULE_expr_end = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_expression_with_expr_end = 4, RULE_if_cond_and_body = 5, RULE_else_body = 6, 
		RULE_expression = 7, RULE_range_expr = 8, RULE_arithmetic_expr = 9, RULE_numeric_entity = 10, 
		RULE_integer_entity = 11, RULE_float_entity = 12, RULE_variable_entity = 13, 
		RULE_array_init = 14, RULE_ai_list = 15, RULE_array_access = 16, RULE_aa_index = 17, 
		RULE_func_name_args = 18, RULE_func_def_return = 19, RULE_assign_expr = 20, 
		RULE_logical_expr = 21, RULE_comparison_expr = 22, RULE_comp_operator = 23, 
		RULE_logical_entity = 24;
	public static final String[] ruleNames = {
		"prog", "expr_end", "statements", "statement", "expression_with_expr_end", 
		"if_cond_and_body", "else_body", "expression", "range_expr", "arithmetic_expr", 
		"numeric_entity", "integer_entity", "float_entity", "variable_entity", 
		"array_init", "ai_list", "array_access", "aa_index", "func_name_args", 
		"func_def_return", "assign_expr", "logical_expr", "comparison_expr", "comp_operator", 
		"logical_entity"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'for'", "'in'", "'if'", "'elseif'", 
		"'else'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'\\'", "'.+'", "'.-'", 
		"'.*'", "'./'", "'.\\'", null, null, null, "'true'", "'false'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", 
		"'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", 
		"'='", "'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", 
		"':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "ADD", "SUB", "MUL", 
		"DIV", "REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
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
			setState(50);
			statements();
			setState(51);
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
			setState(66); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(56);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(53);
						match(WS);
						}
						}
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(59);
					_la = _input.LA(1);
					if ( !(_la==T__0 || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(63);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(60);
							match(WS);
							}
							} 
						}
						setState(65);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(68); 
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
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					statement();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(80);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (SUB - 10)) | (1L << (NOT - 10)) | (1L << (TRUE - 10)) | (1L << (FALSE - 10)) | (1L << (LPAREN - 10)) | (1L << (LBRK - 10)) | (1L << (INTEGER - 10)) | (1L << (FLOAT - 10)) | (1L << (IDENTIFIER - 10)) | (1L << (WS - 10)))) != 0)) {
				{
				setState(76);
				expression();
				setState(78);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (T__0 - 1)) | (1L << (SEMI - 1)) | (1L << (WS - 1)))) != 0)) {
					{
					setState(77);
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
	public static class ExprForContext extends StatementContext {
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public Range_exprContext range_expr() {
			return getRuleContext(Range_exprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
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
		public TerminalNode COMMA() { return getToken(MatlabGrammarParser.COMMA, 0); }
		public ExprForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprFor(this);
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
			setState(176);
			switch (_input.LA(1)) {
			case T__5:
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
				setState(82);
				expression_with_expr_end();
				}
				break;
			case T__1:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(T__1);
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(84);
					func_def_return();
					setState(85);
					match(ASSIGN);
					}
					break;
				}
				setState(89);
				func_name_args();
				setState(104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(90);
					expr_end();
					}
					break;
				case 2:
					{
					{
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(91);
						match(WS);
						}
						}
						setState(96);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(97);
					match(COMMA);
					setState(101);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(98);
							match(WS);
							}
							} 
						}
						setState(103);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					}
					}
					}
					break;
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (T__5 - 6)) | (1L << (SUB - 6)) | (1L << (NOT - 6)) | (1L << (TRUE - 6)) | (1L << (FALSE - 6)) | (1L << (LPAREN - 6)) | (1L << (LBRK - 6)) | (1L << (INTEGER - 6)) | (1L << (FLOAT - 6)) | (1L << (IDENTIFIER - 6)) | (1L << (WS - 6)))) != 0)) {
					{
					{
					setState(106);
					expression_with_expr_end();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(T__2);
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(113);
						match(WS);
						}
						} 
					}
					setState(118);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(119);
					expr_end();
					}
					break;
				}
				}
				break;
			case T__3:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(T__3);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(123);
					match(WS);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				match(IDENTIFIER);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(130);
					match(WS);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==ASSIGN) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(137);
						match(WS);
						}
						} 
					}
					setState(142);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(143);
				range_expr();
				setState(158);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(144);
					expr_end();
					}
					break;
				case 2:
					{
					{
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(145);
						match(WS);
						}
						}
						setState(150);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(151);
					match(COMMA);
					setState(155);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(152);
							match(WS);
							}
							} 
						}
						setState(157);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					}
					}
					}
					break;
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & ((1L << (T__5 - 6)) | (1L << (SUB - 6)) | (1L << (NOT - 6)) | (1L << (TRUE - 6)) | (1L << (FALSE - 6)) | (1L << (LPAREN - 6)) | (1L << (LBRK - 6)) | (1L << (INTEGER - 6)) | (1L << (FLOAT - 6)) | (1L << (IDENTIFIER - 6)) | (1L << (WS - 6)))) != 0)) {
					{
					{
					setState(160);
					expression_with_expr_end();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(T__2);
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(167);
						match(WS);
						}
						} 
					}
					setState(172);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(173);
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
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ExprWithExprEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				expression();
				setState(179);
				expr_end();
				}
				break;
			case 2:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(181);
					match(WS);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(187);
				match(T__5);
				setState(188);
				if_cond_and_body();
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						{
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(189);
							match(WS);
							}
							}
							setState(194);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(195);
						match(T__6);
						}
						setState(197);
						if_cond_and_body();
						}
						} 
					}
					setState(202);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					{
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(203);
						match(WS);
						}
						}
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(209);
					match(T__7);
					setState(213);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(210);
							match(WS);
							}
							} 
						}
						setState(215);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					}
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						setState(216);
						expr_end();
						}
						break;
					}
					}
					setState(219);
					else_body();
					}
					break;
				}
				{
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(222);
					match(WS);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(T__2);
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(229);
						match(WS);
						}
						} 
					}
					setState(234);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				setState(236);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(235);
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
			setState(240);
			logical_expr(0);
			setState(241);
			expr_end();
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(242);
					expression_with_expr_end();
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					expression_with_expr_end();
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
	public static class ExprRange1Context extends ExpressionContext {
		public Range_exprContext range_expr() {
			return getRuleContext(Range_exprContext.class,0);
		}
		public ExprRange1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprRange1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprRange1(this);
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
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				assign_expr();
				}
				break;
			case 3:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				logical_expr(0);
				}
				break;
			case 4:
				_localctx = new ExprRange1Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				range_expr();
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

	public static class Range_exprContext extends ParserRuleContext {
		public Range_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_expr; }
	 
		public Range_exprContext() { }
		public void copyFrom(Range_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprRangeContext extends Range_exprContext {
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
		public ExprRangeContext(Range_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprRange(this);
		}
	}

	public final Range_exprContext range_expr() throws RecognitionException {
		Range_exprContext _localctx = new Range_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_range_expr);
		try {
			_localctx = new ExprRangeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			arithmetic_expr(0);
			setState(261);
			match(COLON);
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(262);
				arithmetic_expr(0);
				setState(263);
				match(COLON);
				}
				break;
			}
			setState(267);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(270);
				match(SUB);
				setState(271);
				arithmetic_expr(14);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(LPAREN);
				setState(273);
				arithmetic_expr(0);
				setState(274);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ExprArrayInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				array_init();
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				numeric_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(315);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionSolveContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(280);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(281);
						match(SOL);
						setState(282);
						arithmetic_expr(16);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionPowContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(283);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(284);
						match(POW);
						setState(285);
						arithmetic_expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(286);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(287);
						match(MUL);
						setState(288);
						arithmetic_expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionDMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(289);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(290);
						match(DMUL);
						setState(291);
						arithmetic_expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(292);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(293);
						match(DIV);
						setState(294);
						arithmetic_expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ArithmeticExpressionDLDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(295);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(296);
						match(DLDIV);
						setState(297);
						arithmetic_expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ArithmeticExpressionDRDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(298);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(299);
						match(DRDIV);
						setState(300);
						arithmetic_expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ArithmeticExpressionSOLContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(301);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(302);
						match(SOL);
						setState(303);
						arithmetic_expr(8);
						}
						break;
					case 9:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(304);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(305);
						match(REM);
						setState(306);
						arithmetic_expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(307);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(308);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==DADD) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(309);
						arithmetic_expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(310);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(311);
						_la = _input.LA(1);
						if ( !(_la==SUB || _la==DSUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(312);
						arithmetic_expr(5);
						}
						break;
					case 12:
						{
						_localctx = new TransposeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(313);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(314);
						match(SQUOTE);
						}
						break;
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		enterRule(_localctx, 20, RULE_numeric_entity);
		int _la;
		try {
			int _alt;
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(320);
					match(WS);
					}
					}
					setState(325);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(326);
				integer_entity();
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(327);
						match(WS);
						}
						} 
					}
					setState(332);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(333);
					match(WS);
					}
					}
					setState(338);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(339);
				float_entity();
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(340);
						match(WS);
						}
						} 
					}
					setState(345);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(346);
						match(WS);
						}
						} 
					}
					setState(351);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(352);
				variable_entity();
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(353);
						match(WS);
						}
						} 
					}
					setState(358);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 22, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
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
		enterRule(_localctx, 24, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
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
		enterRule(_localctx, 26, RULE_variable_entity);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new ArrayAccessOrFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
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
		enterRule(_localctx, 28, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(369);
				match(WS);
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(375);
			match(LBRK);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(376);
					match(WS);
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(382);
					ai_list();
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(383);
						match(WS);
						}
						}
						setState(388);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(389);
					match(SEMI);
					setState(393);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(390);
							match(WS);
							}
							} 
						}
						setState(395);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
					}
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(401);
			ai_list();
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
			match(RBRK);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
		enterRule(_localctx, 30, RULE_ai_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(415);
					expression();
					setState(422);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(416);
						match(COMMA);
						}
						break;
					case WS:
						{
						setState(418); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(417);
								match(WS);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(420); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(429);
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
		enterRule(_localctx, 32, RULE_array_access);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(432);
				match(WS);
				}
				}
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(438);
			match(IDENTIFIER);
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(439);
				match(PERIOD);
				setState(440);
				match(IDENTIFIER);
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(446);
				match(WS);
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
			match(LPAREN);
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(453);
					match(WS);
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(459);
					aa_index();
					setState(463);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(460);
						match(WS);
						}
						}
						setState(465);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(466);
					match(COMMA);
					setState(470);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(467);
							match(WS);
							}
							} 
						}
						setState(472);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					}
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(478);
				aa_index();
				}
				break;
			}
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(481);
				match(WS);
				}
				}
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(487);
			match(RPAREN);
			setState(491);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(488);
					match(WS);
					}
					} 
				}
				setState(493);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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
		enterRule(_localctx, 34, RULE_aa_index);
		try {
			setState(496);
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
				setState(494);
				expression();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
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
		enterRule(_localctx, 36, RULE_func_name_args);
		int _la;
		try {
			int _alt;
			_localctx = new FuncDefNameArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(498);
				match(WS);
				}
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(504);
			match(IDENTIFIER);
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(505);
				match(WS);
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(511);
			match(LPAREN);
			setState(534);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(515);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(512);
						match(WS);
						}
						}
						setState(517);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(518);
					match(IDENTIFIER);
					setState(522);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(519);
						match(WS);
						}
						}
						setState(524);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(525);
					match(COMMA);
					setState(529);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(526);
							match(WS);
							}
							} 
						}
						setState(531);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
					}
					}
					} 
				}
				setState(536);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			setState(550);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==WS) {
				{
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(537);
					match(WS);
					}
					}
					setState(542);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(543);
				match(IDENTIFIER);
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(544);
					match(WS);
					}
					}
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(552);
			match(RPAREN);
			setState(556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(553);
					match(WS);
					}
					} 
				}
				setState(558);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
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
		enterRule(_localctx, 38, RULE_func_def_return);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(559);
					match(WS);
					}
					} 
				}
				setState(564);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			}
			setState(567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(565);
				variable_entity();
				}
				break;
			case 2:
				{
				setState(566);
				array_init();
				}
				break;
			}
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(569);
				match(WS);
				}
				}
				setState(574);
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
		enterRule(_localctx, 40, RULE_assign_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(575);
				match(WS);
				}
				}
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(581);
			match(IDENTIFIER);
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(582);
				match(WS);
				}
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(588);
			match(ASSIGN);
			setState(589);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(592);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(593);
				match(NOT);
				setState(594);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(595);
				match(LPAREN);
				setState(596);
				logical_expr(0);
				setState(597);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(599);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(610);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(608);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(602);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(603);
						match(AND);
						setState(604);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(605);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(606);
						match(OR);
						setState(607);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(612);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
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
		enterRule(_localctx, 44, RULE_comparison_expr);
		try {
			_localctx = new ComparisonArithmeticExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			arithmetic_expr(0);
			setState(614);
			comp_operator();
			setState(615);
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
		enterRule(_localctx, 46, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
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
		enterRule(_localctx, 48, RULE_logical_entity);
		int _la;
		try {
			int _alt;
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				{
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(619);
					match(WS);
					}
					}
					setState(624);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(625);
				match(TRUE);
				setState(629);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(626);
						match(WS);
						}
						} 
					}
					setState(631);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(632);
					match(WS);
					}
					}
					setState(637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(638);
				match(FALSE);
				setState(642);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(639);
						match(WS);
						}
						} 
					}
					setState(644);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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
		case 9:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 21:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 16);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 5);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u028a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\7\3@\n\3\f"+
		"\3\16\3C\13\3\6\3E\n\3\r\3\16\3F\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\5"+
		"\4Q\n\4\5\4S\n\4\3\5\3\5\3\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\5\7\5_\n\5\f\5"+
		"\16\5b\13\5\3\5\3\5\7\5f\n\5\f\5\16\5i\13\5\5\5k\n\5\3\5\7\5n\n\5\f\5"+
		"\16\5q\13\5\3\5\3\5\7\5u\n\5\f\5\16\5x\13\5\3\5\5\5{\n\5\3\5\3\5\7\5\177"+
		"\n\5\f\5\16\5\u0082\13\5\3\5\3\5\7\5\u0086\n\5\f\5\16\5\u0089\13\5\3\5"+
		"\3\5\7\5\u008d\n\5\f\5\16\5\u0090\13\5\3\5\3\5\3\5\7\5\u0095\n\5\f\5\16"+
		"\5\u0098\13\5\3\5\3\5\7\5\u009c\n\5\f\5\16\5\u009f\13\5\5\5\u00a1\n\5"+
		"\3\5\7\5\u00a4\n\5\f\5\16\5\u00a7\13\5\3\5\3\5\7\5\u00ab\n\5\f\5\16\5"+
		"\u00ae\13\5\3\5\5\5\u00b1\n\5\5\5\u00b3\n\5\3\6\3\6\3\6\3\6\7\6\u00b9"+
		"\n\6\f\6\16\6\u00bc\13\6\3\6\3\6\3\6\7\6\u00c1\n\6\f\6\16\6\u00c4\13\6"+
		"\3\6\3\6\3\6\7\6\u00c9\n\6\f\6\16\6\u00cc\13\6\3\6\7\6\u00cf\n\6\f\6\16"+
		"\6\u00d2\13\6\3\6\3\6\7\6\u00d6\n\6\f\6\16\6\u00d9\13\6\3\6\5\6\u00dc"+
		"\n\6\3\6\5\6\u00df\n\6\3\6\7\6\u00e2\n\6\f\6\16\6\u00e5\13\6\3\6\3\6\7"+
		"\6\u00e9\n\6\f\6\16\6\u00ec\13\6\3\6\5\6\u00ef\n\6\5\6\u00f1\n\6\3\7\3"+
		"\7\3\7\7\7\u00f6\n\7\f\7\16\7\u00f9\13\7\3\b\7\b\u00fc\n\b\f\b\16\b\u00ff"+
		"\13\b\3\t\3\t\3\t\3\t\5\t\u0105\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u010c\n\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0119\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u013e\n\13\f\13\16\13\u0141\13"+
		"\13\3\f\7\f\u0144\n\f\f\f\16\f\u0147\13\f\3\f\3\f\7\f\u014b\n\f\f\f\16"+
		"\f\u014e\13\f\3\f\7\f\u0151\n\f\f\f\16\f\u0154\13\f\3\f\3\f\7\f\u0158"+
		"\n\f\f\f\16\f\u015b\13\f\3\f\7\f\u015e\n\f\f\f\16\f\u0161\13\f\3\f\3\f"+
		"\7\f\u0165\n\f\f\f\16\f\u0168\13\f\5\f\u016a\n\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\5\17\u0172\n\17\3\20\7\20\u0175\n\20\f\20\16\20\u0178\13\20\3\20"+
		"\3\20\7\20\u017c\n\20\f\20\16\20\u017f\13\20\3\20\3\20\7\20\u0183\n\20"+
		"\f\20\16\20\u0186\13\20\3\20\3\20\7\20\u018a\n\20\f\20\16\20\u018d\13"+
		"\20\7\20\u018f\n\20\f\20\16\20\u0192\13\20\3\20\3\20\7\20\u0196\n\20\f"+
		"\20\16\20\u0199\13\20\3\20\3\20\7\20\u019d\n\20\f\20\16\20\u01a0\13\20"+
		"\3\21\3\21\3\21\6\21\u01a5\n\21\r\21\16\21\u01a6\5\21\u01a9\n\21\7\21"+
		"\u01ab\n\21\f\21\16\21\u01ae\13\21\3\21\5\21\u01b1\n\21\3\22\7\22\u01b4"+
		"\n\22\f\22\16\22\u01b7\13\22\3\22\3\22\3\22\7\22\u01bc\n\22\f\22\16\22"+
		"\u01bf\13\22\3\22\7\22\u01c2\n\22\f\22\16\22\u01c5\13\22\3\22\3\22\7\22"+
		"\u01c9\n\22\f\22\16\22\u01cc\13\22\3\22\3\22\7\22\u01d0\n\22\f\22\16\22"+
		"\u01d3\13\22\3\22\3\22\7\22\u01d7\n\22\f\22\16\22\u01da\13\22\7\22\u01dc"+
		"\n\22\f\22\16\22\u01df\13\22\3\22\5\22\u01e2\n\22\3\22\7\22\u01e5\n\22"+
		"\f\22\16\22\u01e8\13\22\3\22\3\22\7\22\u01ec\n\22\f\22\16\22\u01ef\13"+
		"\22\3\23\3\23\5\23\u01f3\n\23\3\24\7\24\u01f6\n\24\f\24\16\24\u01f9\13"+
		"\24\3\24\3\24\7\24\u01fd\n\24\f\24\16\24\u0200\13\24\3\24\3\24\7\24\u0204"+
		"\n\24\f\24\16\24\u0207\13\24\3\24\3\24\7\24\u020b\n\24\f\24\16\24\u020e"+
		"\13\24\3\24\3\24\7\24\u0212\n\24\f\24\16\24\u0215\13\24\7\24\u0217\n\24"+
		"\f\24\16\24\u021a\13\24\3\24\7\24\u021d\n\24\f\24\16\24\u0220\13\24\3"+
		"\24\3\24\7\24\u0224\n\24\f\24\16\24\u0227\13\24\5\24\u0229\n\24\3\24\3"+
		"\24\7\24\u022d\n\24\f\24\16\24\u0230\13\24\3\25\7\25\u0233\n\25\f\25\16"+
		"\25\u0236\13\25\3\25\3\25\5\25\u023a\n\25\3\25\7\25\u023d\n\25\f\25\16"+
		"\25\u0240\13\25\3\26\7\26\u0243\n\26\f\26\16\26\u0246\13\26\3\26\3\26"+
		"\7\26\u024a\n\26\f\26\16\26\u024d\13\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u025b\n\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0263\n\27\f\27\16\27\u0266\13\27\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\32\7\32\u026f\n\32\f\32\16\32\u0272\13\32\3\32\3\32\7\32\u0276"+
		"\n\32\f\32\16\32\u0279\13\32\3\32\7\32\u027c\n\32\f\32\16\32\u027f\13"+
		"\32\3\32\3\32\7\32\u0283\n\32\f\32\16\32\u0286\13\32\5\32\u0288\n\32\3"+
		"\32\2\4\24,\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2"+
		"\7\4\2\3\3<<\4\2\7\7\60\60\4\2\13\13\22\22\4\2\f\f\23\23\3\2\34!\u02e2"+
		"\2\64\3\2\2\2\4D\3\2\2\2\6K\3\2\2\2\b\u00b2\3\2\2\2\n\u00f0\3\2\2\2\f"+
		"\u00f2\3\2\2\2\16\u00fd\3\2\2\2\20\u0104\3\2\2\2\22\u0106\3\2\2\2\24\u0118"+
		"\3\2\2\2\26\u0169\3\2\2\2\30\u016b\3\2\2\2\32\u016d\3\2\2\2\34\u0171\3"+
		"\2\2\2\36\u0176\3\2\2\2 \u01ac\3\2\2\2\"\u01b5\3\2\2\2$\u01f2\3\2\2\2"+
		"&\u01f7\3\2\2\2(\u0234\3\2\2\2*\u0244\3\2\2\2,\u025a\3\2\2\2.\u0267\3"+
		"\2\2\2\60\u026b\3\2\2\2\62\u0287\3\2\2\2\64\65\5\6\4\2\65\66\7\2\2\3\66"+
		"\3\3\2\2\2\679\7B\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2"+
		"\2\2<:\3\2\2\2=A\t\2\2\2>@\7B\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2BE\3\2\2\2CA\3\2\2\2D:\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\5\3"+
		"\2\2\2HJ\5\b\5\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LR\3\2\2\2MK\3"+
		"\2\2\2NP\5\20\t\2OQ\5\4\3\2PO\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RN\3\2\2\2RS"+
		"\3\2\2\2S\7\3\2\2\2T\u00b3\5\n\6\2UY\7\4\2\2VW\5(\25\2WX\7\60\2\2XZ\3"+
		"\2\2\2YV\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[j\5&\24\2\\k\5\4\3\2]_\7B\2\2^]\3"+
		"\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cg\7:\2\2df\7"+
		"B\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2j\\\3"+
		"\2\2\2j`\3\2\2\2jk\3\2\2\2ko\3\2\2\2ln\5\n\6\2ml\3\2\2\2nq\3\2\2\2om\3"+
		"\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rv\7\5\2\2su\7B\2\2ts\3\2\2\2ux\3"+
		"\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2y{\5\4\3\2zy\3\2\2\2z{\3"+
		"\2\2\2{\u00b3\3\2\2\2|\u0080\7\6\2\2}\177\7B\2\2~}\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0087\79\2\2\u0084\u0086\7B\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008e\t\3\2\2\u008b\u008d\7B\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u00a0\5\22\n\2\u0092"+
		"\u00a1\5\4\3\2\u0093\u0095\7B\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2"+
		"\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009d\7:\2\2\u009a\u009c\7B\2\2\u009b\u009a\3\2\2"+
		"\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u0092\3\2\2\2\u00a0\u0096\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a4\5\n\6\2\u00a3\u00a2\3\2"+
		"\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ac\7\5\2\2\u00a9\u00ab\7B"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\5\4"+
		"\3\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"T\3\2\2\2\u00b2U\3\2\2\2\u00b2|\3\2\2\2\u00b3\t\3\2\2\2\u00b4\u00b5\5"+
		"\20\t\2\u00b5\u00b6\5\4\3\2\u00b6\u00f1\3\2\2\2\u00b7\u00b9\7B\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\b\2\2\u00be"+
		"\u00ca\5\f\7\2\u00bf\u00c1\7B\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\5\f"+
		"\7\2\u00c8\u00c2\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00de\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf\7B"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d7\7\n"+
		"\2\2\u00d4\u00d6\7B\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00da\u00dc\5\4\3\2\u00db\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00df\5\16\b\2\u00de\u00d0\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df\u00e3\3\2\2\2\u00e0\u00e2\7B\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00ea\7\5\2\2\u00e7\u00e9\7B\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ef\5\4\3\2\u00ee"+
		"\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00b4\3\2"+
		"\2\2\u00f0\u00ba\3\2\2\2\u00f1\13\3\2\2\2\u00f2\u00f3\5,\27\2\u00f3\u00f7"+
		"\5\4\3\2\u00f4\u00f6\5\n\6\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\r\3\2\2\2\u00f9\u00f7\3\2\2\2"+
		"\u00fa\u00fc\5\n\6\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\17\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0105\5\24\13\2\u0101\u0105\5*\26\2\u0102\u0105\5,\27\2\u0103\u0105\5"+
		"\22\n\2\u0104\u0100\3\2\2\2\u0104\u0101\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\21\3\2\2\2\u0106\u0107\5\24\13\2\u0107\u010b\7;\2"+
		"\2\u0108\u0109\5\24\13\2\u0109\u010a\7;\2\2\u010a\u010c\3\2\2\2\u010b"+
		"\u0108\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\5\24"+
		"\13\2\u010e\23\3\2\2\2\u010f\u0110\b\13\1\2\u0110\u0111\7\f\2\2\u0111"+
		"\u0119\5\24\13\20\u0112\u0113\7\61\2\2\u0113\u0114\5\24\13\2\u0114\u0115"+
		"\7\62\2\2\u0115\u0119\3\2\2\2\u0116\u0119\5\36\20\2\u0117\u0119\5\26\f"+
		"\2\u0118\u010f\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117"+
		"\3\2\2\2\u0119\u013f\3\2\2\2\u011a\u011b\f\21\2\2\u011b\u011c\7\21\2\2"+
		"\u011c\u013e\5\24\13\22\u011d\u011e\f\17\2\2\u011e\u011f\7\20\2\2\u011f"+
		"\u013e\5\24\13\20\u0120\u0121\f\16\2\2\u0121\u0122\7\r\2\2\u0122\u013e"+
		"\5\24\13\17\u0123\u0124\f\r\2\2\u0124\u0125\7\24\2\2\u0125\u013e\5\24"+
		"\13\16\u0126\u0127\f\f\2\2\u0127\u0128\7\16\2\2\u0128\u013e\5\24\13\r"+
		"\u0129\u012a\f\13\2\2\u012a\u012b\7\26\2\2\u012b\u013e\5\24\13\f\u012c"+
		"\u012d\f\n\2\2\u012d\u012e\7\25\2\2\u012e\u013e\5\24\13\13\u012f\u0130"+
		"\f\t\2\2\u0130\u0131\7\21\2\2\u0131\u013e\5\24\13\n\u0132\u0133\f\b\2"+
		"\2\u0133\u0134\7\17\2\2\u0134\u013e\5\24\13\t\u0135\u0136\f\7\2\2\u0136"+
		"\u0137\t\4\2\2\u0137\u013e\5\24\13\b\u0138\u0139\f\6\2\2\u0139\u013a\t"+
		"\5\2\2\u013a\u013e\5\24\13\7\u013b\u013c\f\22\2\2\u013c\u013e\7>\2\2\u013d"+
		"\u011a\3\2\2\2\u013d\u011d\3\2\2\2\u013d\u0120\3\2\2\2\u013d\u0123\3\2"+
		"\2\2\u013d\u0126\3\2\2\2\u013d\u0129\3\2\2\2\u013d\u012c\3\2\2\2\u013d"+
		"\u012f\3\2\2\2\u013d\u0132\3\2\2\2\u013d\u0135\3\2\2\2\u013d\u0138\3\2"+
		"\2\2\u013d\u013b\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\25\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0144\7B\2\2"+
		"\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014c\5\30\r\2"+
		"\u0149\u014b\7B\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u016a\3\2\2\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0151\7B\2\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155"+
		"\u0159\5\32\16\2\u0156\u0158\7B\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3"+
		"\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u016a\3\2\2\2\u015b"+
		"\u0159\3\2\2\2\u015c\u015e\7B\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2"+
		"\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0162\u0166\5\34\17\2\u0163\u0165\7B\2\2\u0164\u0163\3"+
		"\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u0145\3\2\2\2\u0169\u0152\3\2"+
		"\2\2\u0169\u015f\3\2\2\2\u016a\27\3\2\2\2\u016b\u016c\7\67\2\2\u016c\31"+
		"\3\2\2\2\u016d\u016e\78\2\2\u016e\33\3\2\2\2\u016f\u0172\79\2\2\u0170"+
		"\u0172\5\"\22\2\u0171\u016f\3\2\2\2\u0171\u0170\3\2\2\2\u0172\35\3\2\2"+
		"\2\u0173\u0175\7B\2\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2\2\2\u0179"+
		"\u017d\7\63\2\2\u017a\u017c\7B\2\2\u017b\u017a\3\2\2\2\u017c\u017f\3\2"+
		"\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0190\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u0180\u0184\5 \21\2\u0181\u0183\7B\2\2\u0182\u0181\3\2"+
		"\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0187\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u018b\7<\2\2\u0188\u018a\7B\2"+
		"\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0180\3\2\2\2\u018f"+
		"\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2"+
		"\2\2\u0192\u0190\3\2\2\2\u0193\u0197\5 \21\2\u0194\u0196\7B\2\2\u0195"+
		"\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019e\7\64\2\2\u019b"+
		"\u019d\7B\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2"+
		"\2\2\u019e\u019f\3\2\2\2\u019f\37\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a8"+
		"\5\20\t\2\u01a2\u01a9\7:\2\2\u01a3\u01a5\7B\2\2\u01a4\u01a3\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2"+
		"\2\2\u01a8\u01a2\3\2\2\2\u01a8\u01a4\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa"+
		"\u01a1\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b1\5\20\t\2\u01b0"+
		"\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1!\3\2\2\2\u01b2\u01b4\7B\2\2\u01b3"+
		"\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6\u01b8\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01bd\79\2\2\u01b9"+
		"\u01ba\7=\2\2\u01ba\u01bc\79\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bf\3\2\2"+
		"\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c3\3\2\2\2\u01bf\u01bd"+
		"\3\2\2\2\u01c0\u01c2\7B\2\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c6\u01ca\7\61\2\2\u01c7\u01c9\7B\2\2\u01c8\u01c7\3\2\2\2\u01c9"+
		"\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01dd\3\2"+
		"\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d1\5$\23\2\u01ce\u01d0\7B\2\2\u01cf"+
		"\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2"+
		"\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d8\7:\2\2\u01d5"+
		"\u01d7\7B\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01db"+
		"\u01cd\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01e2\5$\23\2\u01e1"+
		"\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e6\3\2\2\2\u01e3\u01e5\7B"+
		"\2\2\u01e4\u01e3\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6"+
		"\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ed\7\62"+
		"\2\2\u01ea\u01ec\7B\2\2\u01eb\u01ea\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed"+
		"\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee#\3\2\2\2\u01ef\u01ed\3\2\2\2"+
		"\u01f0\u01f3\5\20\t\2\u01f1\u01f3\7;\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f1"+
		"\3\2\2\2\u01f3%\3\2\2\2\u01f4\u01f6\7B\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9"+
		"\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9"+
		"\u01f7\3\2\2\2\u01fa\u01fe\79\2\2\u01fb\u01fd\7B\2\2\u01fc\u01fb\3\2\2"+
		"\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201"+
		"\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0218\7\61\2\2\u0202\u0204\7B\2\2\u0203"+
		"\u0202\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2"+
		"\2\2\u0206\u0208\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u020c\79\2\2\u0209"+
		"\u020b\7B\2\2\u020a\u0209\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2"+
		"\2\2\u020c\u020d\3\2\2\2\u020d\u020f\3\2\2\2\u020e\u020c\3\2\2\2\u020f"+
		"\u0213\7:\2\2\u0210\u0212\7B\2\2\u0211\u0210\3\2\2\2\u0212\u0215\3\2\2"+
		"\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213"+
		"\3\2\2\2\u0216\u0205\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0218"+
		"\u0219\3\2\2\2\u0219\u0228\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u021d\7B"+
		"\2\2\u021c\u021b\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u021c\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u021e\3\2\2\2\u0221\u0225\79"+
		"\2\2\u0222\u0224\7B\2\2\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225"+
		"\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2"+
		"\2\2\u0228\u021e\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u022a"+
		"\u022e\7\62\2\2\u022b\u022d\7B\2\2\u022c\u022b\3\2\2\2\u022d\u0230\3\2"+
		"\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\'\3\2\2\2\u0230\u022e"+
		"\3\2\2\2\u0231\u0233\7B\2\2\u0232\u0231\3\2\2\2\u0233\u0236\3\2\2\2\u0234"+
		"\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0239\3\2\2\2\u0236\u0234\3\2"+
		"\2\2\u0237\u023a\5\34\17\2\u0238\u023a\5\36\20\2\u0239\u0237\3\2\2\2\u0239"+
		"\u0238\3\2\2\2\u023a\u023e\3\2\2\2\u023b\u023d\7B\2\2\u023c\u023b\3\2"+
		"\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f"+
		")\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0243\7B\2\2\u0242\u0241\3\2\2\2\u0243"+
		"\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2"+
		"\2\2\u0246\u0244\3\2\2\2\u0247\u024b\79\2\2\u0248\u024a\7B\2\2\u0249\u0248"+
		"\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024e\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u024f\7\60\2\2\u024f\u0250\5"+
		"\20\t\2\u0250+\3\2\2\2\u0251\u0252\b\27\1\2\u0252\u025b\5.\30\2\u0253"+
		"\u0254\7\31\2\2\u0254\u025b\5,\27\5\u0255\u0256\7\61\2\2\u0256\u0257\5"+
		",\27\2\u0257\u0258\7\62\2\2\u0258\u025b\3\2\2\2\u0259\u025b\5\62\32\2"+
		"\u025a\u0251\3\2\2\2\u025a\u0253\3\2\2\2\u025a\u0255\3\2\2\2\u025a\u0259"+
		"\3\2\2\2\u025b\u0264\3\2\2\2\u025c\u025d\f\7\2\2\u025d\u025e\7\27\2\2"+
		"\u025e\u0263\5,\27\b\u025f\u0260\f\6\2\2\u0260\u0261\7\30\2\2\u0261\u0263"+
		"\5,\27\7\u0262\u025c\3\2\2\2\u0262\u025f\3\2\2\2\u0263\u0266\3\2\2\2\u0264"+
		"\u0262\3\2\2\2\u0264\u0265\3\2\2\2\u0265-\3\2\2\2\u0266\u0264\3\2\2\2"+
		"\u0267\u0268\5\24\13\2\u0268\u0269\5\60\31\2\u0269\u026a\5\24\13\2\u026a"+
		"/\3\2\2\2\u026b\u026c\t\6\2\2\u026c\61\3\2\2\2\u026d\u026f\7B\2\2\u026e"+
		"\u026d\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271\u0273\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0277\7\32\2\2\u0274"+
		"\u0276\7B\2\2\u0275\u0274\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2"+
		"\2\2\u0277\u0278\3\2\2\2\u0278\u0288\3\2\2\2\u0279\u0277\3\2\2\2\u027a"+
		"\u027c\7B\2\2\u027b\u027a\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2"+
		"\2\2\u027d\u027e\3\2\2\2\u027e\u0280\3\2\2\2\u027f\u027d\3\2\2\2\u0280"+
		"\u0284\7\33\2\2\u0281\u0283\7B\2\2\u0282\u0281\3\2\2\2\u0283\u0286\3\2"+
		"\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0288\3\2\2\2\u0286"+
		"\u0284\3\2\2\2\u0287\u0270\3\2\2\2\u0287\u027d\3\2\2\2\u0288\63\3\2\2"+
		"\2`:AFKPRY`gjovz\u0080\u0087\u008e\u0096\u009d\u00a0\u00a5\u00ac\u00b0"+
		"\u00b2\u00ba\u00c2\u00ca\u00d0\u00d7\u00db\u00de\u00e3\u00ea\u00ee\u00f0"+
		"\u00f7\u00fd\u0104\u010b\u0118\u013d\u013f\u0145\u014c\u0152\u0159\u015f"+
		"\u0166\u0169\u0171\u0176\u017d\u0184\u018b\u0190\u0197\u019e\u01a6\u01a8"+
		"\u01ac\u01b0\u01b5\u01bd\u01c3\u01ca\u01d1\u01d8\u01dd\u01e1\u01e6\u01ed"+
		"\u01f2\u01f7\u01fe\u0205\u020c\u0213\u0218\u021e\u0225\u0228\u022e\u0234"+
		"\u0239\u023e\u0244\u024b\u025a\u0262\u0264\u0270\u0277\u027d\u0284\u0287";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}