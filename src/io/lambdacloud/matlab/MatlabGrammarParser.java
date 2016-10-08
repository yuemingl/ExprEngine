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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ADD=15, SUB=16, MUL=17, 
		DIV=18, POW=19, SOL=20, DADD=21, DSUB=22, DMUL=23, DRDIV=24, DLDIV=25, 
		AND=26, OR=27, NOT=28, TRUE=29, FALSE=30, GT=31, GE=32, LT=33, LE=34, 
		EQ=35, NEQ=36, NEQ2=37, SHL=38, SHR=39, USHR=40, INC=41, DESC=42, ADD_ASSIGN=43, 
		SUB_ASSIGN=44, MUL_ASSIGN=45, DIV_ASSIGN=46, REM_ASSIGN=47, ASSIGN=48, 
		LPAREN=49, RPAREN=50, LBRK=51, RBRK=52, LCB=53, RCB=54, INTEGER=55, FLOAT=56, 
		IDENTIFIER=57, COMMA=58, COLON=59, SEMI=60, PERIOD=61, SQUOTE=62, DQUOTE=63, 
		DPRIME=64, COMMENT=65, SKIP_TOKEN=66, WS=67, StringLiteral=68;
	public static final int
		RULE_prog = 0, RULE_statement_block = 1, RULE_expr_end = 2, RULE_expr_end2 = 3, 
		RULE_statement = 4, RULE_tic = 5, RULE_toc = 6, RULE_expression_with_expr_end = 7, 
		RULE_if_cond_and_body = 8, RULE_else_body = 9, RULE_expression = 10, RULE_for_range_expr = 11, 
		RULE_arithmetic_expr = 12, RULE_add_sub_operator = 13, RULE_mul_div_operator = 14, 
		RULE_numeric_entity = 15, RULE_integer_entity = 16, RULE_float_entity = 17, 
		RULE_variable_entity = 18, RULE_array_init = 19, RULE_ai_list = 20, RULE_aa_index = 21, 
		RULE_aa_range = 22, RULE_aa_range_start = 23, RULE_aa_range_step = 24, 
		RULE_aa_range_end = 25, RULE_func_name_args = 26, RULE_func_def_return = 27, 
		RULE_logical_expr = 28, RULE_comparison_expr = 29, RULE_string_comp_operator = 30, 
		RULE_comp_operator = 31, RULE_logical_entity = 32, RULE_assign_expr = 33, 
		RULE_string_expr = 34, RULE_string_entity = 35, RULE_func_handle = 36;
	public static final String[] ruleNames = {
		"prog", "statement_block", "expr_end", "expr_end2", "statement", "tic", 
		"toc", "expression_with_expr_end", "if_cond_and_body", "else_body", "expression", 
		"for_range_expr", "arithmetic_expr", "add_sub_operator", "mul_div_operator", 
		"numeric_entity", "integer_entity", "float_entity", "variable_entity", 
		"array_init", "ai_list", "aa_index", "aa_range", "aa_range_start", "aa_range_step", 
		"aa_range_end", "func_name_args", "func_def_return", "logical_expr", "comparison_expr", 
		"string_comp_operator", "comp_operator", "logical_entity", "assign_expr", 
		"string_expr", "string_entity", "func_handle"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'if'", "'elseif'", "'else'", "'for'", 
		"'in'", "'while'", "'return'", "'tic'", "'toc'", "'nargin'", "'@'", "'+'", 
		"'-'", "'*'", "'/'", null, "'\\'", "'.+'", "'.-'", "'.*'", "'./'", "'.\\'", 
		null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", 
		"'!='", "'~='", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", 
		"'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'", "'.''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", "SOL", "DADD", "DSUB", 
		"DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "NEQ2", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"DPRIME", "COMMENT", "SKIP_TOKEN", "WS", "StringLiteral"
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
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
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
			setState(74);
			statement_block();
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(75);
				match(EOF);
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

	public static class Statement_blockContext extends ParserRuleContext {
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
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStatement_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStatement_block(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(78);
					statement();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(84);
				expression();
				setState(86);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(85);
					expr_end();
					}
					break;
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

	public static class Expr_endContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(MatlabGrammarParser.SEMI, 0); }
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
		enterRule(_localctx, 4, RULE_expr_end);
		int _la;
		try {
			int _alt;
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(90);
					match(WS);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(SEMI);
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(97);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(102);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(103);
							match(WS);
							}
							}
							setState(108);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(109);
						match(T__0);
						setState(113);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(110);
								match(WS);
								}
								} 
							}
							setState(115);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(118); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class Expr_end2Context extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(MatlabGrammarParser.SEMI, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public TerminalNode COMMA() { return getToken(MatlabGrammarParser.COMMA, 0); }
		public Expr_end2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_end2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExpr_end2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExpr_end2(this);
		}
	}

	public final Expr_end2Context expr_end2() throws RecognitionException {
		Expr_end2Context _localctx = new Expr_end2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr_end2);
		int _la;
		try {
			int _alt;
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(122);
					match(WS);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				match(SEMI);
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(129);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(135);
					match(WS);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(COMMA);
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(142);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(148);
							match(WS);
							}
							}
							setState(153);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(154);
						match(T__0);
						setState(158);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(155);
								match(WS);
								}
								} 
							}
							setState(160);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(163); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class TicTocContext extends StatementContext {
		public TicContext tic() {
			return getRuleContext(TicContext.class,0);
		}
		public TocContext toc() {
			return getRuleContext(TocContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public TicTocContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterTicToc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitTicToc(this);
		}
	}
	public static class ExprReturnContext extends StatementContext {
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public ExprReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprReturn(this);
		}
	}
	public static class ExprWhileContext extends StatementContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public ExprWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprWhile(this);
		}
	}
	public static class FuncDefContext extends StatementContext {
		public Func_name_argsContext func_name_args() {
			return getRuleContext(Func_name_argsContext.class,0);
		}
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Func_def_returnContext func_def_return() {
			return getRuleContext(Func_def_returnContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatlabGrammarParser.EOF, 0); }
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
	public static class ExprIfContext extends StatementContext {
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
		public ExprIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprIf(this);
		}
	}
	public static class ExprWithExprEnd1Context extends StatementContext {
		public Expression_with_expr_endContext expression_with_expr_end() {
			return getRuleContext(Expression_with_expr_endContext.class,0);
		}
		public ExprWithExprEnd1Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprWithExprEnd1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprWithExprEnd1(this);
		}
	}
	public static class ExprForContext extends StatementContext {
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public For_range_exprContext for_range_expr() {
			return getRuleContext(For_range_exprContext.class,0);
		}
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new TicTocContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(167);
					match(WS);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(173);
					tic();
					}
					break;
				case T__11:
					{
					setState(174);
					toc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(177);
						match(WS);
						}
						} 
					}
					setState(182);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(183);
					expr_end();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(186);
					match(WS);
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
				match(T__1);
				setState(196);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(193);
					func_def_return();
					setState(194);
					match(ASSIGN);
					}
					break;
				}
				setState(198);
				func_name_args();
				setState(199);
				expr_end2();
				setState(200);
				statement_block();
				setState(201);
				match(T__2);
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(202);
						match(WS);
						}
						} 
					}
					setState(207);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(208);
					expr_end();
					}
					break;
				}
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(211);
					match(EOF);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(214);
					match(WS);
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__3);
				setState(221);
				if_cond_and_body();
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						match(T__4);
						}
						setState(230);
						if_cond_and_body();
						}
						} 
					}
					setState(235);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					{
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(236);
						match(WS);
						}
						}
						setState(241);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(242);
					match(T__5);
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(243);
							match(WS);
							}
							} 
						}
						setState(248);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					}
					setState(250);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						setState(249);
						expr_end();
						}
						break;
					}
					}
					setState(252);
					else_body();
					}
					break;
				}
				{
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(255);
					match(WS);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261);
				match(T__2);
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(262);
						match(WS);
						}
						} 
					}
					setState(267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(268);
					expr_end();
					}
					break;
				}
				}
				}
				break;
			case 4:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(271);
					match(WS);
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(277);
				match(T__6);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(278);
					match(WS);
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284);
				match(IDENTIFIER);
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(285);
					match(WS);
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(291);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==ASSIGN) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(292);
						match(WS);
						}
						} 
					}
					setState(297);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				setState(298);
				for_range_expr();
				setState(299);
				expr_end2();
				setState(300);
				statement_block();
				setState(301);
				match(T__2);
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(302);
						match(WS);
						}
						} 
					}
					setState(307);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(308);
					expr_end();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ExprWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
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
				match(T__8);
				setState(318);
				logical_expr(0);
				setState(319);
				expr_end2();
				setState(320);
				statement_block();
				setState(321);
				match(T__2);
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(322);
						match(WS);
						}
						} 
					}
					setState(327);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(329);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(328);
					expr_end();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new ExprReturnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(331);
					match(WS);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337);
				match(T__9);
				setState(339);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(338);
					expression();
					}
					break;
				}
				setState(342);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(341);
					expr_end();
					}
					break;
				}
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(344);
						match(WS);
						}
						} 
					}
					setState(349);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				}
				break;
			case 7:
				_localctx = new ExprWithExprEnd1Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(350);
				expression_with_expr_end();
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

	public static class TicContext extends ParserRuleContext {
		public TicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterTic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitTic(this);
		}
	}

	public final TicContext tic() throws RecognitionException {
		TicContext _localctx = new TicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(T__10);
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

	public static class TocContext extends ParserRuleContext {
		public TocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterToc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitToc(this);
		}
	}

	public final TocContext toc() throws RecognitionException {
		TocContext _localctx = new TocContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_toc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(T__11);
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
		enterRule(_localctx, 14, RULE_expression_with_expr_end);
		try {
			_localctx = new ExprWithExprEndContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			expression();
			setState(358);
			expr_end();
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
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
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
		enterRule(_localctx, 16, RULE_if_cond_and_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			logical_expr(0);
			setState(361);
			expr_end2();
			setState(362);
			statement_block();
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
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
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
		enterRule(_localctx, 18, RULE_else_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			statement_block();
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
	public static class ExprAssign1Context extends ExpressionContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprAssign1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprAssign1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprAssign1(this);
		}
	}
	public static class ExprStringContext extends ExpressionContext {
		public String_exprContext string_expr() {
			return getRuleContext(String_exprContext.class,0);
		}
		public ExprStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprString(this);
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
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				string_expr();
				}
				break;
			case 3:
				_localctx = new ExprAssign1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
				assign_expr();
				}
				break;
			case 4:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(369);
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

	public static class For_range_exprContext extends ParserRuleContext {
		public For_range_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_range_expr; }
	 
		public For_range_exprContext() { }
		public void copyFrom(For_range_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForRangeArrayInit1Context extends For_range_exprContext {
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public ForRangeArrayInit1Context(For_range_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterForRangeArrayInit1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitForRangeArrayInit1(this);
		}
	}
	public static class ForRangeColonContext extends For_range_exprContext {
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
		public ForRangeColonContext(For_range_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterForRangeColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitForRangeColon(this);
		}
	}

	public final For_range_exprContext for_range_expr() throws RecognitionException {
		For_range_exprContext _localctx = new For_range_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_range_expr);
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new ForRangeColonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(372);
				arithmetic_expr(0);
				setState(373);
				match(COLON);
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(374);
					arithmetic_expr(0);
					setState(375);
					match(COLON);
					}
					break;
				}
				setState(379);
				arithmetic_expr(0);
				}
				}
				break;
			case 2:
				_localctx = new ForRangeArrayInit1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
				array_init();
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
	public static class ArithmeticExpressionNegationEntityContext extends Arithmetic_exprContext {
		public TerminalNode SUB() { return getToken(MatlabGrammarParser.SUB, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
	public static class ArithmeticExpressionParensContext extends Arithmetic_exprContext {
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
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
	public static class ArithmeticExpressionMulDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Mul_div_operatorContext mul_div_operator() {
			return getRuleContext(Mul_div_operatorContext.class,0);
		}
		public ArithmeticExpressionMulDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionMulDiv(this);
		}
	}
	public static class TransposeContext extends Arithmetic_exprContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode SQUOTE() { return getToken(MatlabGrammarParser.SQUOTE, 0); }
		public TerminalNode DPRIME() { return getToken(MatlabGrammarParser.DPRIME, 0); }
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
	public static class ExprRange1Context extends Arithmetic_exprContext {
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
		public ExprRange1Context(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprRange1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprRange1(this);
		}
	}
	public static class NArgInContext extends Arithmetic_exprContext {
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Expr_endContext expr_end() {
			return getRuleContext(Expr_endContext.class,0);
		}
		public NArgInContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterNArgIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitNArgIn(this);
		}
	}
	public static class ArithmeticExpressionAddSubContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Add_sub_operatorContext add_sub_operator() {
			return getRuleContext(Add_sub_operatorContext.class,0);
		}
		public ArithmeticExpressionAddSubContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionAddSub(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(385);
					match(WS);
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391);
				match(SUB);
				setState(392);
				arithmetic_expr(9);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(393);
					match(WS);
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(399);
				match(LPAREN);
				setState(400);
				arithmetic_expr(0);
				setState(401);
				match(RPAREN);
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(402);
						match(WS);
						}
						} 
					}
					setState(407);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				}
				}
				break;
			case 3:
				{
				_localctx = new ExprArrayInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(408);
				array_init();
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				numeric_entity();
				}
				break;
			case 5:
				{
				_localctx = new NArgInContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(410);
					match(WS);
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				match(T__12);
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(417);
						match(WS);
						}
						} 
					}
					setState(422);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(424);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(423);
					expr_end();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(449);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionPowContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(428);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(429);
						match(POW);
						setState(430);
						arithmetic_expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionMulDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(431);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(432);
						mul_div_operator();
						setState(433);
						arithmetic_expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionAddSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(435);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(436);
						add_sub_operator();
						setState(437);
						arithmetic_expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprRange1Context(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(439);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(440);
						match(COLON);
						setState(444);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
						case 1:
							{
							setState(441);
							arithmetic_expr(0);
							setState(442);
							match(COLON);
							}
							break;
						}
						setState(446);
						arithmetic_expr(2);
						}
						break;
					case 5:
						{
						_localctx = new TransposeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(447);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(448);
						_la = _input.LA(1);
						if ( !(_la==SQUOTE || _la==DPRIME) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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

	public static class Add_sub_operatorContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(MatlabGrammarParser.SUB, 0); }
		public TerminalNode DSUB() { return getToken(MatlabGrammarParser.DSUB, 0); }
		public TerminalNode ADD() { return getToken(MatlabGrammarParser.ADD, 0); }
		public TerminalNode DADD() { return getToken(MatlabGrammarParser.DADD, 0); }
		public Add_sub_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_sub_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAdd_sub_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAdd_sub_operator(this);
		}
	}

	public final Add_sub_operatorContext add_sub_operator() throws RecognitionException {
		Add_sub_operatorContext _localctx = new Add_sub_operatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_add_sub_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << DADD) | (1L << DSUB))) != 0)) ) {
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

	public static class Mul_div_operatorContext extends ParserRuleContext {
		public TerminalNode SOL() { return getToken(MatlabGrammarParser.SOL, 0); }
		public TerminalNode DIV() { return getToken(MatlabGrammarParser.DIV, 0); }
		public TerminalNode DLDIV() { return getToken(MatlabGrammarParser.DLDIV, 0); }
		public TerminalNode DRDIV() { return getToken(MatlabGrammarParser.DRDIV, 0); }
		public TerminalNode MUL() { return getToken(MatlabGrammarParser.MUL, 0); }
		public TerminalNode DMUL() { return getToken(MatlabGrammarParser.DMUL, 0); }
		public Mul_div_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul_div_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterMul_div_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitMul_div_operator(this);
		}
	}

	public final Mul_div_operatorContext mul_div_operator() throws RecognitionException {
		Mul_div_operatorContext _localctx = new Mul_div_operatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mul_div_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << SOL) | (1L << DMUL) | (1L << DRDIV) | (1L << DLDIV))) != 0)) ) {
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
		enterRule(_localctx, 30, RULE_numeric_entity);
		int _la;
		try {
			int _alt;
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(458);
					match(WS);
					}
					}
					setState(463);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(464);
				integer_entity();
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(465);
						match(WS);
						}
						} 
					}
					setState(470);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(471);
					match(WS);
					}
					}
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(477);
				float_entity();
				setState(481);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(478);
						match(WS);
						}
						} 
					}
					setState(483);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(484);
					match(WS);
					}
					}
					setState(489);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(490);
				variable_entity(0);
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(491);
						match(WS);
						}
						} 
					}
					setState(496);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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
		enterRule(_localctx, 32, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
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
		enterRule(_localctx, 34, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
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
	public static class CellAccessContext extends Variable_entityContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode LCB() { return getToken(MatlabGrammarParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(MatlabGrammarParser.RCB, 0); }
		public List<TerminalNode> PERIOD() { return getTokens(MatlabGrammarParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(MatlabGrammarParser.PERIOD, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
		public CellAccessContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterCellAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitCellAccess(this);
		}
	}
	public static class ArrayAccessOrFuncCallContext extends Variable_entityContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
		public List<TerminalNode> PERIOD() { return getTokens(MatlabGrammarParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(MatlabGrammarParser.PERIOD, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
		return variable_entity(0);
	}

	private Variable_entityContext variable_entity(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Variable_entityContext _localctx = new Variable_entityContext(_ctx, _parentState);
		Variable_entityContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_variable_entity, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new EntityVariableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(504);
			match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(608);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(606);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayAccessOrFuncCallContext(new Variable_entityContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_variable_entity);
						setState(506);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(511);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==PERIOD) {
							{
							{
							setState(507);
							match(PERIOD);
							setState(508);
							match(IDENTIFIER);
							}
							}
							setState(513);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(517);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(514);
							match(WS);
							}
							}
							setState(519);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(520);
						match(LPAREN);
						setState(524);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(521);
								match(WS);
								}
								} 
							}
							setState(526);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
						}
						setState(543);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(527);
								aa_index();
								setState(531);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==WS) {
									{
									{
									setState(528);
									match(WS);
									}
									}
									setState(533);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(534);
								match(COMMA);
								setState(538);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
								while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
									if ( _alt==1 ) {
										{
										{
										setState(535);
										match(WS);
										}
										} 
									}
									setState(540);
									_errHandler.sync(this);
									_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
								}
								}
								} 
							}
							setState(545);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
						}
						setState(547);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
						case 1:
							{
							setState(546);
							aa_index();
							}
							break;
						}
						setState(552);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(549);
							match(WS);
							}
							}
							setState(554);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(555);
						match(RPAREN);
						}
						break;
					case 2:
						{
						_localctx = new CellAccessContext(new Variable_entityContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_variable_entity);
						setState(556);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(561);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==PERIOD) {
							{
							{
							setState(557);
							match(PERIOD);
							setState(558);
							match(IDENTIFIER);
							}
							}
							setState(563);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(567);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(564);
							match(WS);
							}
							}
							setState(569);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(570);
						match(LCB);
						setState(574);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(571);
								match(WS);
								}
								} 
							}
							setState(576);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
						}
						setState(593);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(577);
								aa_index();
								setState(581);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==WS) {
									{
									{
									setState(578);
									match(WS);
									}
									}
									setState(583);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(584);
								match(COMMA);
								setState(588);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
								while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
									if ( _alt==1 ) {
										{
										{
										setState(585);
										match(WS);
										}
										} 
									}
									setState(590);
									_errHandler.sync(this);
									_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
								}
								}
								} 
							}
							setState(595);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
						}
						setState(597);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
						case 1:
							{
							setState(596);
							aa_index();
							}
							break;
						}
						setState(602);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(599);
							match(WS);
							}
							}
							setState(604);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(605);
						match(RCB);
						}
						break;
					}
					} 
				}
				setState(610);
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
		enterRule(_localctx, 38, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(611);
				match(WS);
				}
				}
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(617);
			match(LBRK);
			setState(621);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(618);
					match(WS);
					}
					} 
				}
				setState(623);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			}
			setState(640);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(624);
					ai_list();
					setState(628);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(625);
						match(WS);
						}
						}
						setState(630);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(631);
					match(SEMI);
					setState(635);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(632);
							match(WS);
							}
							} 
						}
						setState(637);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
					}
					}
					} 
				}
				setState(642);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			}
			setState(643);
			ai_list();
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(644);
				match(WS);
				}
				}
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(650);
			match(RBRK);
			setState(654);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(651);
					match(WS);
					}
					} 
				}
				setState(656);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
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
		enterRule(_localctx, 40, RULE_ai_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(657);
					expression();
					setState(664);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(658);
						match(COMMA);
						}
						break;
					case WS:
						{
						setState(660); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(659);
								match(WS);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(662); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			setState(672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(671);
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

	public static class Aa_indexContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MatlabGrammarParser.COLON, 0); }
		public Func_handleContext func_handle() {
			return getRuleContext(Func_handleContext.class,0);
		}
		public Aa_rangeContext aa_range() {
			return getRuleContext(Aa_rangeContext.class,0);
		}
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
		enterRule(_localctx, 42, RULE_aa_index);
		try {
			setState(678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(676);
				func_handle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(677);
				aa_range();
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

	public static class Aa_rangeContext extends ParserRuleContext {
		public Aa_range_startContext aa_range_start() {
			return getRuleContext(Aa_range_startContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(MatlabGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MatlabGrammarParser.COLON, i);
		}
		public Aa_range_endContext aa_range_end() {
			return getRuleContext(Aa_range_endContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public Aa_range_stepContext aa_range_step() {
			return getRuleContext(Aa_range_stepContext.class,0);
		}
		public Aa_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aa_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAa_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAa_range(this);
		}
	}

	public final Aa_rangeContext aa_range() throws RecognitionException {
		Aa_rangeContext _localctx = new Aa_rangeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_aa_range);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			aa_range_start();
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(681);
				match(WS);
				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(687);
			match(COLON);
			setState(691);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(688);
					match(WS);
					}
					} 
				}
				setState(693);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			}
			setState(708);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				{
				setState(694);
				aa_range_step();
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(695);
					match(WS);
					}
					}
					setState(700);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(701);
				match(COLON);
				setState(705);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(702);
						match(WS);
						}
						} 
					}
					setState(707);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
				}
				}
				break;
			}
			setState(710);
			aa_range_end();
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

	public static class Aa_range_startContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Aa_range_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aa_range_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAa_range_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAa_range_start(this);
		}
	}

	public final Aa_range_startContext aa_range_start() throws RecognitionException {
		Aa_range_startContext _localctx = new Aa_range_startContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_aa_range_start);
		try {
			setState(714);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				match(T__2);
				}
				break;
			case T__12:
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
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
				expression();
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

	public static class Aa_range_stepContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Aa_range_stepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aa_range_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAa_range_step(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAa_range_step(this);
		}
	}

	public final Aa_range_stepContext aa_range_step() throws RecognitionException {
		Aa_range_stepContext _localctx = new Aa_range_stepContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_aa_range_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
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

	public static class Aa_range_endContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Aa_range_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aa_range_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterAa_range_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitAa_range_end(this);
		}
	}

	public final Aa_range_endContext aa_range_end() throws RecognitionException {
		Aa_range_endContext _localctx = new Aa_range_endContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_aa_range_end);
		try {
			setState(720);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				match(T__2);
				}
				break;
			case T__12:
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
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(719);
				expression();
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
		enterRule(_localctx, 52, RULE_func_name_args);
		int _la;
		try {
			int _alt;
			_localctx = new FuncDefNameArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(722);
				match(WS);
				}
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(728);
			match(IDENTIFIER);
			setState(732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(729);
				match(WS);
				}
				}
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(735);
			match(LPAREN);
			setState(758);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(739);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(736);
						match(WS);
						}
						}
						setState(741);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(742);
					match(IDENTIFIER);
					setState(746);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(743);
						match(WS);
						}
						}
						setState(748);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(749);
					match(COMMA);
					setState(753);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(750);
							match(WS);
							}
							} 
						}
						setState(755);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					}
					}
					} 
				}
				setState(760);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			}
			setState(774);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==WS) {
				{
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(761);
					match(WS);
					}
					}
					setState(766);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(767);
				match(IDENTIFIER);
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(768);
					match(WS);
					}
					}
					setState(773);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(776);
			match(RPAREN);
			setState(780);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(777);
					match(WS);
					}
					} 
				}
				setState(782);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
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
		enterRule(_localctx, 54, RULE_func_def_return);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(783);
					match(WS);
					}
					} 
				}
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,118,_ctx);
			}
			setState(791);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(789);
				variable_entity(0);
				}
				break;
			case LBRK:
			case WS:
				{
				setState(790);
				array_init();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(793);
				match(WS);
				}
				}
				setState(798);
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
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
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
	public static class LogicalVariableEntity1Context extends Logical_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public LogicalVariableEntity1Context(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalVariableEntity1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalVariableEntity1(this);
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_logical_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(800);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(804);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(801);
					match(WS);
					}
					}
					setState(806);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(807);
				match(NOT);
				setState(808);
				logical_expr(4);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(809);
					match(WS);
					}
					}
					setState(814);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(815);
				match(LPAREN);
				setState(816);
				logical_expr(0);
				setState(817);
				match(RPAREN);
				setState(821);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(818);
						match(WS);
						}
						} 
					}
					setState(823);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(824);
				logical_entity();
				}
				break;
			case 5:
				{
				_localctx = new LogicalVariableEntity1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(825);
					match(WS);
					}
					}
					setState(830);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(831);
				variable_entity(0);
				setState(835);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(832);
						match(WS);
						}
						} 
					}
					setState(837);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(848);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(846);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(840);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(841);
						match(AND);
						setState(842);
						logical_expr(7);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(843);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(844);
						match(OR);
						setState(845);
						logical_expr(6);
						}
						break;
					}
					} 
				}
				setState(850);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
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
		public String_comp_operatorContext string_comp_operator() {
			return getRuleContext(String_comp_operatorContext.class,0);
		}
		public ComparisonStringExpressionContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterComparisonStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitComparisonStringExpression(this);
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
		enterRule(_localctx, 58, RULE_comparison_expr);
		try {
			setState(859);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				_localctx = new ComparisonArithmeticExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(851);
				arithmetic_expr(0);
				setState(852);
				comp_operator();
				setState(853);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ComparisonStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(855);
				string_expr();
				setState(856);
				string_comp_operator();
				setState(857);
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

	public static class String_comp_operatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(MatlabGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MatlabGrammarParser.NEQ, 0); }
		public TerminalNode NEQ2() { return getToken(MatlabGrammarParser.NEQ2, 0); }
		public String_comp_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_comp_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterString_comp_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitString_comp_operator(this);
		}
	}

	public final String_comp_operatorContext string_comp_operator() throws RecognitionException {
		String_comp_operatorContext _localctx = new String_comp_operatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_string_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << NEQ2))) != 0)) ) {
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

	public static class Comp_operatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MatlabGrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(MatlabGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(MatlabGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(MatlabGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MatlabGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MatlabGrammarParser.NEQ, 0); }
		public TerminalNode NEQ2() { return getToken(MatlabGrammarParser.NEQ2, 0); }
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
		enterRule(_localctx, 62, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ) | (1L << NEQ2))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_logical_entity);
		int _la;
		try {
			int _alt;
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				{
				{
				setState(868);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(865);
					match(WS);
					}
					}
					setState(870);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(871);
				match(TRUE);
				setState(875);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(872);
						match(WS);
						}
						} 
					}
					setState(877);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(881);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(878);
					match(WS);
					}
					}
					setState(883);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(884);
				match(FALSE);
				setState(888);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(885);
						match(WS);
						}
						} 
					}
					setState(890);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
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
	public static class ExprMultiAssignContext extends Assign_exprContext {
		public TerminalNode LBRK() { return getToken(MatlabGrammarParser.LBRK, 0); }
		public TerminalNode RBRK() { return getToken(MatlabGrammarParser.RBRK, 0); }
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MatlabGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MatlabGrammarParser.COMMA, i);
		}
		public ExprMultiAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprMultiAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprMultiAssign(this);
		}
	}
	public static class ExprDivAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode DIV_ASSIGN() { return getToken(MatlabGrammarParser.DIV_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprDivAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprDivAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprDivAssign(this);
		}
	}
	public static class ExprMulAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode MUL_ASSIGN() { return getToken(MatlabGrammarParser.MUL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprMulAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprMulAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprMulAssign(this);
		}
	}
	public static class ExprRemAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode REM_ASSIGN() { return getToken(MatlabGrammarParser.REM_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprRemAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprRemAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprRemAssign(this);
		}
	}
	public static class ExprAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MatlabGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprAssign(this);
		}
	}
	public static class ExprSubAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode SUB_ASSIGN() { return getToken(MatlabGrammarParser.SUB_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprSubAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprSubAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprSubAssign(this);
		}
	}
	public static class ExprAddAssignContext extends Assign_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode ADD_ASSIGN() { return getToken(MatlabGrammarParser.ADD_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public ExprAddAssignContext(Assign_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprAddAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprAddAssign(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_assign_expr);
		int _la;
		try {
			int _alt;
			setState(1046);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(893);
					match(WS);
					}
					}
					setState(898);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(899);
				variable_entity(0);
				setState(903);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(900);
					match(WS);
					}
					}
					setState(905);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(906);
				match(ASSIGN);
				setState(907);
				expression();
				}
				break;
			case 2:
				_localctx = new ExprMultiAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(909);
					match(WS);
					}
					}
					setState(914);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(915);
				match(LBRK);
				setState(919);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(916);
						match(WS);
						}
						} 
					}
					setState(921);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
				}
				setState(945);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(922);
						match(IDENTIFIER);
						setState(926);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(923);
								match(WS);
								}
								} 
							}
							setState(928);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
						}
						setState(935);
						switch (_input.LA(1)) {
						case COMMA:
							{
							setState(929);
							match(COMMA);
							}
							break;
						case WS:
							{
							setState(931); 
							_errHandler.sync(this);
							_alt = 1;
							do {
								switch (_alt) {
								case 1:
									{
									{
									setState(930);
									match(WS);
									}
									}
									break;
								default:
									throw new NoViableAltException(this);
								}
								setState(933); 
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
							} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(940);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(937);
								match(WS);
								}
								} 
							}
							setState(942);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
						}
						}
						} 
					}
					setState(947);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
				}
				setState(949);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(948);
					match(IDENTIFIER);
					}
				}

				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(951);
					match(WS);
					}
					}
					setState(956);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(957);
				match(RBRK);
				setState(961);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(958);
					match(WS);
					}
					}
					setState(963);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(964);
				match(ASSIGN);
				setState(965);
				expression();
				}
				break;
			case 3:
				_localctx = new ExprMulAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(969);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(966);
					match(WS);
					}
					}
					setState(971);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(972);
				variable_entity(0);
				setState(976);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(973);
					match(WS);
					}
					}
					setState(978);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(979);
				match(MUL_ASSIGN);
				setState(980);
				expression();
				}
				break;
			case 4:
				_localctx = new ExprDivAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(985);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(982);
					match(WS);
					}
					}
					setState(987);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(988);
				variable_entity(0);
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(989);
					match(WS);
					}
					}
					setState(994);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(995);
				match(DIV_ASSIGN);
				setState(996);
				expression();
				}
				break;
			case 5:
				_localctx = new ExprRemAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1001);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(998);
					match(WS);
					}
					}
					setState(1003);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1004);
				variable_entity(0);
				setState(1008);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1005);
					match(WS);
					}
					}
					setState(1010);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1011);
				match(REM_ASSIGN);
				setState(1012);
				expression();
				}
				break;
			case 6:
				_localctx = new ExprAddAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1017);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1014);
					match(WS);
					}
					}
					setState(1019);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1020);
				variable_entity(0);
				setState(1024);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1021);
					match(WS);
					}
					}
					setState(1026);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1027);
				match(ADD_ASSIGN);
				setState(1028);
				expression();
				}
				break;
			case 7:
				_localctx = new ExprSubAssignContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1030);
					match(WS);
					}
					}
					setState(1035);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1036);
				variable_entity(0);
				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1037);
					match(WS);
					}
					}
					setState(1042);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1043);
				match(SUB_ASSIGN);
				setState(1044);
				expression();
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
	public static class StringConcatContext extends String_exprContext {
		public List<String_entityContext> string_entity() {
			return getRuleContexts(String_entityContext.class);
		}
		public String_entityContext string_entity(int i) {
			return getRuleContext(String_entityContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MatlabGrammarParser.ADD, 0); }
		public StringConcatContext(String_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStringConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStringConcat(this);
		}
	}
	public static class StringEntity1Context extends String_exprContext {
		public String_entityContext string_entity() {
			return getRuleContext(String_entityContext.class,0);
		}
		public StringEntity1Context(String_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStringEntity1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStringEntity1(this);
		}
	}

	public final String_exprContext string_expr() throws RecognitionException {
		String_exprContext _localctx = new String_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_string_expr);
		try {
			setState(1053);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				_localctx = new StringConcatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1048);
				string_entity();
				setState(1049);
				match(ADD);
				setState(1050);
				string_entity();
				}
				break;
			case 2:
				_localctx = new StringEntity1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1052);
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
		public TerminalNode StringLiteral() { return getToken(MatlabGrammarParser.StringLiteral, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public StringConstContext(String_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStringConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStringConst(this);
		}
	}
	public static class StringVariable1Context extends String_entityContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public StringVariable1Context(String_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterStringVariable1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitStringVariable1(this);
		}
	}

	public final String_entityContext string_entity() throws RecognitionException {
		String_entityContext _localctx = new String_entityContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_string_entity);
		int _la;
		try {
			int _alt;
			setState(1081);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1058);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1055);
					match(WS);
					}
					}
					setState(1060);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1061);
				match(StringLiteral);
				setState(1065);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1062);
						match(WS);
						}
						} 
					}
					setState(1067);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new StringVariable1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1068);
					match(WS);
					}
					}
					setState(1073);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1074);
				variable_entity(0);
				setState(1078);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1075);
						match(WS);
						}
						} 
					}
					setState(1080);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,162,_ctx);
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

	public static class Func_handleContext extends ParserRuleContext {
		public Func_handleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_handle; }
	 
		public Func_handleContext() { }
		public void copyFrom(Func_handleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncHandleContext extends Func_handleContext {
		public TerminalNode IDENTIFIER() { return getToken(MatlabGrammarParser.IDENTIFIER, 0); }
		public FuncHandleContext(Func_handleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterFuncHandle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitFuncHandle(this);
		}
	}

	public final Func_handleContext func_handle() throws RecognitionException {
		Func_handleContext _localctx = new Func_handleContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_func_handle);
		try {
			_localctx = new FuncHandleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(1083);
			match(T__13);
			setState(1084);
			match(IDENTIFIER);
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
		case 12:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 18:
			return variable_entity_sempred((Variable_entityContext)_localctx, predIndex);
		case 28:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean variable_entity_sempred(Variable_entityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3F\u0441\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\5\2O\n\2\3\3\7\3R\n\3\f\3"+
		"\16\3U\13\3\3\3\3\3\5\3Y\n\3\5\3[\n\3\3\4\7\4^\n\4\f\4\16\4a\13\4\3\4"+
		"\3\4\7\4e\n\4\f\4\16\4h\13\4\3\4\7\4k\n\4\f\4\16\4n\13\4\3\4\3\4\7\4r"+
		"\n\4\f\4\16\4u\13\4\6\4w\n\4\r\4\16\4x\5\4{\n\4\3\5\7\5~\n\5\f\5\16\5"+
		"\u0081\13\5\3\5\3\5\7\5\u0085\n\5\f\5\16\5\u0088\13\5\3\5\7\5\u008b\n"+
		"\5\f\5\16\5\u008e\13\5\3\5\3\5\7\5\u0092\n\5\f\5\16\5\u0095\13\5\3\5\7"+
		"\5\u0098\n\5\f\5\16\5\u009b\13\5\3\5\3\5\7\5\u009f\n\5\f\5\16\5\u00a2"+
		"\13\5\6\5\u00a4\n\5\r\5\16\5\u00a5\5\5\u00a8\n\5\3\6\7\6\u00ab\n\6\f\6"+
		"\16\6\u00ae\13\6\3\6\3\6\5\6\u00b2\n\6\3\6\7\6\u00b5\n\6\f\6\16\6\u00b8"+
		"\13\6\3\6\5\6\u00bb\n\6\3\6\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\3\6\3\6"+
		"\3\6\3\6\5\6\u00c7\n\6\3\6\3\6\3\6\3\6\3\6\7\6\u00ce\n\6\f\6\16\6\u00d1"+
		"\13\6\3\6\5\6\u00d4\n\6\3\6\5\6\u00d7\n\6\3\6\7\6\u00da\n\6\f\6\16\6\u00dd"+
		"\13\6\3\6\3\6\3\6\7\6\u00e2\n\6\f\6\16\6\u00e5\13\6\3\6\3\6\3\6\7\6\u00ea"+
		"\n\6\f\6\16\6\u00ed\13\6\3\6\7\6\u00f0\n\6\f\6\16\6\u00f3\13\6\3\6\3\6"+
		"\7\6\u00f7\n\6\f\6\16\6\u00fa\13\6\3\6\5\6\u00fd\n\6\3\6\5\6\u0100\n\6"+
		"\3\6\7\6\u0103\n\6\f\6\16\6\u0106\13\6\3\6\3\6\7\6\u010a\n\6\f\6\16\6"+
		"\u010d\13\6\3\6\5\6\u0110\n\6\3\6\7\6\u0113\n\6\f\6\16\6\u0116\13\6\3"+
		"\6\3\6\7\6\u011a\n\6\f\6\16\6\u011d\13\6\3\6\3\6\7\6\u0121\n\6\f\6\16"+
		"\6\u0124\13\6\3\6\3\6\7\6\u0128\n\6\f\6\16\6\u012b\13\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6\u0132\n\6\f\6\16\6\u0135\13\6\3\6\5\6\u0138\n\6\3\6\7\6\u013b"+
		"\n\6\f\6\16\6\u013e\13\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0146\n\6\f\6\16"+
		"\6\u0149\13\6\3\6\5\6\u014c\n\6\3\6\7\6\u014f\n\6\f\6\16\6\u0152\13\6"+
		"\3\6\3\6\5\6\u0156\n\6\3\6\5\6\u0159\n\6\3\6\7\6\u015c\n\6\f\6\16\6\u015f"+
		"\13\6\3\6\5\6\u0162\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\5\f\u0175\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u017c\n"+
		"\r\3\r\3\r\3\r\5\r\u0181\n\r\3\16\3\16\7\16\u0185\n\16\f\16\16\16\u0188"+
		"\13\16\3\16\3\16\3\16\7\16\u018d\n\16\f\16\16\16\u0190\13\16\3\16\3\16"+
		"\3\16\3\16\7\16\u0196\n\16\f\16\16\16\u0199\13\16\3\16\3\16\3\16\7\16"+
		"\u019e\n\16\f\16\16\16\u01a1\13\16\3\16\3\16\7\16\u01a5\n\16\f\16\16\16"+
		"\u01a8\13\16\3\16\5\16\u01ab\n\16\5\16\u01ad\n\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u01bf"+
		"\n\16\3\16\3\16\3\16\7\16\u01c4\n\16\f\16\16\16\u01c7\13\16\3\17\3\17"+
		"\3\20\3\20\3\21\7\21\u01ce\n\21\f\21\16\21\u01d1\13\21\3\21\3\21\7\21"+
		"\u01d5\n\21\f\21\16\21\u01d8\13\21\3\21\7\21\u01db\n\21\f\21\16\21\u01de"+
		"\13\21\3\21\3\21\7\21\u01e2\n\21\f\21\16\21\u01e5\13\21\3\21\7\21\u01e8"+
		"\n\21\f\21\16\21\u01eb\13\21\3\21\3\21\7\21\u01ef\n\21\f\21\16\21\u01f2"+
		"\13\21\5\21\u01f4\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u0200\n\24\f\24\16\24\u0203\13\24\3\24\7\24\u0206\n\24\f\24\16"+
		"\24\u0209\13\24\3\24\3\24\7\24\u020d\n\24\f\24\16\24\u0210\13\24\3\24"+
		"\3\24\7\24\u0214\n\24\f\24\16\24\u0217\13\24\3\24\3\24\7\24\u021b\n\24"+
		"\f\24\16\24\u021e\13\24\7\24\u0220\n\24\f\24\16\24\u0223\13\24\3\24\5"+
		"\24\u0226\n\24\3\24\7\24\u0229\n\24\f\24\16\24\u022c\13\24\3\24\3\24\3"+
		"\24\3\24\7\24\u0232\n\24\f\24\16\24\u0235\13\24\3\24\7\24\u0238\n\24\f"+
		"\24\16\24\u023b\13\24\3\24\3\24\7\24\u023f\n\24\f\24\16\24\u0242\13\24"+
		"\3\24\3\24\7\24\u0246\n\24\f\24\16\24\u0249\13\24\3\24\3\24\7\24\u024d"+
		"\n\24\f\24\16\24\u0250\13\24\7\24\u0252\n\24\f\24\16\24\u0255\13\24\3"+
		"\24\5\24\u0258\n\24\3\24\7\24\u025b\n\24\f\24\16\24\u025e\13\24\3\24\7"+
		"\24\u0261\n\24\f\24\16\24\u0264\13\24\3\25\7\25\u0267\n\25\f\25\16\25"+
		"\u026a\13\25\3\25\3\25\7\25\u026e\n\25\f\25\16\25\u0271\13\25\3\25\3\25"+
		"\7\25\u0275\n\25\f\25\16\25\u0278\13\25\3\25\3\25\7\25\u027c\n\25\f\25"+
		"\16\25\u027f\13\25\7\25\u0281\n\25\f\25\16\25\u0284\13\25\3\25\3\25\7"+
		"\25\u0288\n\25\f\25\16\25\u028b\13\25\3\25\3\25\7\25\u028f\n\25\f\25\16"+
		"\25\u0292\13\25\3\26\3\26\3\26\6\26\u0297\n\26\r\26\16\26\u0298\5\26\u029b"+
		"\n\26\7\26\u029d\n\26\f\26\16\26\u02a0\13\26\3\26\5\26\u02a3\n\26\3\27"+
		"\3\27\3\27\3\27\5\27\u02a9\n\27\3\30\3\30\7\30\u02ad\n\30\f\30\16\30\u02b0"+
		"\13\30\3\30\3\30\7\30\u02b4\n\30\f\30\16\30\u02b7\13\30\3\30\3\30\7\30"+
		"\u02bb\n\30\f\30\16\30\u02be\13\30\3\30\3\30\7\30\u02c2\n\30\f\30\16\30"+
		"\u02c5\13\30\5\30\u02c7\n\30\3\30\3\30\3\31\3\31\5\31\u02cd\n\31\3\32"+
		"\3\32\3\33\3\33\5\33\u02d3\n\33\3\34\7\34\u02d6\n\34\f\34\16\34\u02d9"+
		"\13\34\3\34\3\34\7\34\u02dd\n\34\f\34\16\34\u02e0\13\34\3\34\3\34\7\34"+
		"\u02e4\n\34\f\34\16\34\u02e7\13\34\3\34\3\34\7\34\u02eb\n\34\f\34\16\34"+
		"\u02ee\13\34\3\34\3\34\7\34\u02f2\n\34\f\34\16\34\u02f5\13\34\7\34\u02f7"+
		"\n\34\f\34\16\34\u02fa\13\34\3\34\7\34\u02fd\n\34\f\34\16\34\u0300\13"+
		"\34\3\34\3\34\7\34\u0304\n\34\f\34\16\34\u0307\13\34\5\34\u0309\n\34\3"+
		"\34\3\34\7\34\u030d\n\34\f\34\16\34\u0310\13\34\3\35\7\35\u0313\n\35\f"+
		"\35\16\35\u0316\13\35\3\35\3\35\5\35\u031a\n\35\3\35\7\35\u031d\n\35\f"+
		"\35\16\35\u0320\13\35\3\36\3\36\3\36\7\36\u0325\n\36\f\36\16\36\u0328"+
		"\13\36\3\36\3\36\3\36\7\36\u032d\n\36\f\36\16\36\u0330\13\36\3\36\3\36"+
		"\3\36\3\36\7\36\u0336\n\36\f\36\16\36\u0339\13\36\3\36\3\36\7\36\u033d"+
		"\n\36\f\36\16\36\u0340\13\36\3\36\3\36\7\36\u0344\n\36\f\36\16\36\u0347"+
		"\13\36\5\36\u0349\n\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0351\n\36\f"+
		"\36\16\36\u0354\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u035e"+
		"\n\37\3 \3 \3!\3!\3\"\7\"\u0365\n\"\f\"\16\"\u0368\13\"\3\"\3\"\7\"\u036c"+
		"\n\"\f\"\16\"\u036f\13\"\3\"\7\"\u0372\n\"\f\"\16\"\u0375\13\"\3\"\3\""+
		"\7\"\u0379\n\"\f\"\16\"\u037c\13\"\5\"\u037e\n\"\3#\7#\u0381\n#\f#\16"+
		"#\u0384\13#\3#\3#\7#\u0388\n#\f#\16#\u038b\13#\3#\3#\3#\3#\7#\u0391\n"+
		"#\f#\16#\u0394\13#\3#\3#\7#\u0398\n#\f#\16#\u039b\13#\3#\3#\7#\u039f\n"+
		"#\f#\16#\u03a2\13#\3#\3#\6#\u03a6\n#\r#\16#\u03a7\5#\u03aa\n#\3#\7#\u03ad"+
		"\n#\f#\16#\u03b0\13#\7#\u03b2\n#\f#\16#\u03b5\13#\3#\5#\u03b8\n#\3#\7"+
		"#\u03bb\n#\f#\16#\u03be\13#\3#\3#\7#\u03c2\n#\f#\16#\u03c5\13#\3#\3#\3"+
		"#\7#\u03ca\n#\f#\16#\u03cd\13#\3#\3#\7#\u03d1\n#\f#\16#\u03d4\13#\3#\3"+
		"#\3#\3#\7#\u03da\n#\f#\16#\u03dd\13#\3#\3#\7#\u03e1\n#\f#\16#\u03e4\13"+
		"#\3#\3#\3#\3#\7#\u03ea\n#\f#\16#\u03ed\13#\3#\3#\7#\u03f1\n#\f#\16#\u03f4"+
		"\13#\3#\3#\3#\3#\7#\u03fa\n#\f#\16#\u03fd\13#\3#\3#\7#\u0401\n#\f#\16"+
		"#\u0404\13#\3#\3#\3#\3#\7#\u040a\n#\f#\16#\u040d\13#\3#\3#\7#\u0411\n"+
		"#\f#\16#\u0414\13#\3#\3#\3#\5#\u0419\n#\3$\3$\3$\3$\3$\5$\u0420\n$\3%"+
		"\7%\u0423\n%\f%\16%\u0426\13%\3%\3%\7%\u042a\n%\f%\16%\u042d\13%\3%\7"+
		"%\u0430\n%\f%\16%\u0433\13%\3%\3%\7%\u0437\n%\f%\16%\u043a\13%\5%\u043c"+
		"\n%\3&\3&\3&\3&\2\5\32&:\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJ\2\t\4\2\3\3EE\4\2\n\n\62\62\4\2@@BB\4\2\21"+
		"\22\27\30\5\2\23\24\26\26\31\33\3\2%\'\3\2!\'\u04d8\2L\3\2\2\2\4S\3\2"+
		"\2\2\6z\3\2\2\2\b\u00a7\3\2\2\2\n\u0161\3\2\2\2\f\u0163\3\2\2\2\16\u0165"+
		"\3\2\2\2\20\u0167\3\2\2\2\22\u016a\3\2\2\2\24\u016e\3\2\2\2\26\u0174\3"+
		"\2\2\2\30\u0180\3\2\2\2\32\u01ac\3\2\2\2\34\u01c8\3\2\2\2\36\u01ca\3\2"+
		"\2\2 \u01f3\3\2\2\2\"\u01f5\3\2\2\2$\u01f7\3\2\2\2&\u01f9\3\2\2\2(\u0268"+
		"\3\2\2\2*\u029e\3\2\2\2,\u02a8\3\2\2\2.\u02aa\3\2\2\2\60\u02cc\3\2\2\2"+
		"\62\u02ce\3\2\2\2\64\u02d2\3\2\2\2\66\u02d7\3\2\2\28\u0314\3\2\2\2:\u0348"+
		"\3\2\2\2<\u035d\3\2\2\2>\u035f\3\2\2\2@\u0361\3\2\2\2B\u037d\3\2\2\2D"+
		"\u0418\3\2\2\2F\u041f\3\2\2\2H\u043b\3\2\2\2J\u043d\3\2\2\2LN\5\4\3\2"+
		"MO\7\2\2\3NM\3\2\2\2NO\3\2\2\2O\3\3\2\2\2PR\5\n\6\2QP\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2ST\3\2\2\2TZ\3\2\2\2US\3\2\2\2VX\5\26\f\2WY\5\6\4\2XW\3\2"+
		"\2\2XY\3\2\2\2Y[\3\2\2\2ZV\3\2\2\2Z[\3\2\2\2[\5\3\2\2\2\\^\7E\2\2]\\\3"+
		"\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bf\7>\2\2ce\t"+
		"\2\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g{\3\2\2\2hf\3\2\2\2ik\7"+
		"E\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2os\7"+
		"\3\2\2pr\7E\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2\2us\3"+
		"\2\2\2vl\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2z_\3\2\2\2zv\3"+
		"\2\2\2{\7\3\2\2\2|~\7E\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0086\7>\2\2\u0083"+
		"\u0085\t\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u00a8\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008b\7E\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0093\7<\2\2\u0090\u0092\t\2\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u00a8\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0098\7E\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u00a0\7\3\2\2\u009d\u009f\7E\2\2\u009e\u009d\3\2"+
		"\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u0099\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7"+
		"\177\3\2\2\2\u00a7\u008c\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8\t\3\2\2\2\u00a9"+
		"\u00ab\7E\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b2\5\f\7\2\u00b0\u00b2\5\16\b\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3"+
		"\2\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\7E\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\5\6\4\2\u00ba\u00b9\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u0162\3\2\2\2\u00bc\u00be\7E\2\2\u00bd\u00bc\3\2"+
		"\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c6\7\4\2\2\u00c3\u00c4\58"+
		"\35\2\u00c4\u00c5\7\62\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\5\66\34\2\u00c9\u00ca\5"+
		"\b\5\2\u00ca\u00cb\5\4\3\2\u00cb\u00cf\7\5\2\2\u00cc\u00ce\7E\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\5\6\4\2\u00d3"+
		"\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d7\7\2"+
		"\2\3\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u0162\3\2\2\2\u00d8"+
		"\u00da\7E\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00df\7\6\2\2\u00df\u00eb\5\22\n\2\u00e0\u00e2\7E\2\2\u00e1\u00e0\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00ea\5\22\n\2\u00e9\u00e3\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ff\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00f0\7E\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00f8\7\b\2\2\u00f5\u00f7\7E\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\5\6\4\2\u00fc\u00fb\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\5\24\13\2\u00ff\u00f1\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0104\3\2\2\2\u0101\u0103\7E\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010b\7\5\2\2\u0108"+
		"\u010a\7E\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		"\u0110\5\6\4\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0162\3\2"+
		"\2\2\u0111\u0113\7E\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0117\u011b\7\t\2\2\u0118\u011a\7E\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u0122\7;\2\2\u011f\u0121\7E\2\2\u0120\u011f"+
		"\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0129\t\3\2\2\u0126\u0128\7E"+
		"\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\5\30"+
		"\r\2\u012d\u012e\5\b\5\2\u012e\u012f\5\4\3\2\u012f\u0133\7\5\2\2\u0130"+
		"\u0132\7E\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0136"+
		"\u0138\5\6\4\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0162\3\2"+
		"\2\2\u0139\u013b\7E\2\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013f\u0140\7\13\2\2\u0140\u0141\5:\36\2\u0141\u0142\5\b\5\2\u0142"+
		"\u0143\5\4\3\2\u0143\u0147\7\5\2\2\u0144\u0146\7E\2\2\u0145\u0144\3\2"+
		"\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c\5\6\4\2\u014b\u014a\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u0162\3\2\2\2\u014d\u014f\7E\2\2\u014e"+
		"\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0155\7\f\2\2\u0154"+
		"\u0156\5\26\f\2\u0155\u0154\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3"+
		"\2\2\2\u0157\u0159\5\6\4\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015d\3\2\2\2\u015a\u015c\7E\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0162\3\2\2\2\u015f"+
		"\u015d\3\2\2\2\u0160\u0162\5\20\t\2\u0161\u00ac\3\2\2\2\u0161\u00bf\3"+
		"\2\2\2\u0161\u00db\3\2\2\2\u0161\u0114\3\2\2\2\u0161\u013c\3\2\2\2\u0161"+
		"\u0150\3\2\2\2\u0161\u0160\3\2\2\2\u0162\13\3\2\2\2\u0163\u0164\7\r\2"+
		"\2\u0164\r\3\2\2\2\u0165\u0166\7\16\2\2\u0166\17\3\2\2\2\u0167\u0168\5"+
		"\26\f\2\u0168\u0169\5\6\4\2\u0169\21\3\2\2\2\u016a\u016b\5:\36\2\u016b"+
		"\u016c\5\b\5\2\u016c\u016d\5\4\3\2\u016d\23\3\2\2\2\u016e\u016f\5\4\3"+
		"\2\u016f\25\3\2\2\2\u0170\u0175\5\32\16\2\u0171\u0175\5F$\2\u0172\u0175"+
		"\5D#\2\u0173\u0175\5:\36\2\u0174\u0170\3\2\2\2\u0174\u0171\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175\27\3\2\2\2\u0176\u0177\5\32\16"+
		"\2\u0177\u017b\7=\2\2\u0178\u0179\5\32\16\2\u0179\u017a\7=\2\2\u017a\u017c"+
		"\3\2\2\2\u017b\u0178\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u017e\5\32\16\2\u017e\u0181\3\2\2\2\u017f\u0181\5(\25\2\u0180\u0176\3"+
		"\2\2\2\u0180\u017f\3\2\2\2\u0181\31\3\2\2\2\u0182\u0186\b\16\1\2\u0183"+
		"\u0185\7E\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189"+
		"\u018a\7\22\2\2\u018a\u01ad\5\32\16\13\u018b\u018d\7E\2\2\u018c\u018b"+
		"\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7\63\2\2\u0192\u0193\5"+
		"\32\16\2\u0193\u0197\7\64\2\2\u0194\u0196\7E\2\2\u0195\u0194\3\2\2\2\u0196"+
		"\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u01ad\3\2"+
		"\2\2\u0199\u0197\3\2\2\2\u019a\u01ad\5(\25\2\u019b\u01ad\5 \21\2\u019c"+
		"\u019e\7E\2\2\u019d\u019c\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2"+
		"\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2"+
		"\u01a6\7\17\2\2\u01a3\u01a5\7E\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2"+
		"\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8"+
		"\u01a6\3\2\2\2\u01a9\u01ab\5\6\4\2\u01aa\u01a9\3\2\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01ad\3\2\2\2\u01ac\u0182\3\2\2\2\u01ac\u018e\3\2\2\2\u01ac"+
		"\u019a\3\2\2\2\u01ac\u019b\3\2\2\2\u01ac\u019f\3\2\2\2\u01ad\u01c5\3\2"+
		"\2\2\u01ae\u01af\f\n\2\2\u01af\u01b0\7\25\2\2\u01b0\u01c4\5\32\16\13\u01b1"+
		"\u01b2\f\t\2\2\u01b2\u01b3\5\36\20\2\u01b3\u01b4\5\32\16\n\u01b4\u01c4"+
		"\3\2\2\2\u01b5\u01b6\f\b\2\2\u01b6\u01b7\5\34\17\2\u01b7\u01b8\5\32\16"+
		"\t\u01b8\u01c4\3\2\2\2\u01b9\u01ba\f\3\2\2\u01ba\u01be\7=\2\2\u01bb\u01bc"+
		"\5\32\16\2\u01bc\u01bd\7=\2\2\u01bd\u01bf\3\2\2\2\u01be\u01bb\3\2\2\2"+
		"\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c4\5\32\16\4\u01c1\u01c2"+
		"\f\f\2\2\u01c2\u01c4\t\4\2\2\u01c3\u01ae\3\2\2\2\u01c3\u01b1\3\2\2\2\u01c3"+
		"\u01b5\3\2\2\2\u01c3\u01b9\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c7\3\2"+
		"\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\33\3\2\2\2\u01c7\u01c5"+
		"\3\2\2\2\u01c8\u01c9\t\5\2\2\u01c9\35\3\2\2\2\u01ca\u01cb\t\6\2\2\u01cb"+
		"\37\3\2\2\2\u01cc\u01ce\7E\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01d1\3\2\2\2"+
		"\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01cf"+
		"\3\2\2\2\u01d2\u01d6\5\"\22\2\u01d3\u01d5\7E\2\2\u01d4\u01d3\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01f4\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01db\7E\2\2\u01da\u01d9\3\2\2\2\u01db"+
		"\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\3\2"+
		"\2\2\u01de\u01dc\3\2\2\2\u01df\u01e3\5$\23\2\u01e0\u01e2\7E\2\2\u01e1"+
		"\u01e0\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2"+
		"\2\2\u01e4\u01f4\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e8\7E\2\2\u01e7"+
		"\u01e6\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea\u01ec\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01f0\5&\24\2\u01ed"+
		"\u01ef\7E\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2"+
		"\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3"+
		"\u01cf\3\2\2\2\u01f3\u01dc\3\2\2\2\u01f3\u01e9\3\2\2\2\u01f4!\3\2\2\2"+
		"\u01f5\u01f6\79\2\2\u01f6#\3\2\2\2\u01f7\u01f8\7:\2\2\u01f8%\3\2\2\2\u01f9"+
		"\u01fa\b\24\1\2\u01fa\u01fb\7;\2\2\u01fb\u0262\3\2\2\2\u01fc\u0201\f\4"+
		"\2\2\u01fd\u01fe\7?\2\2\u01fe\u0200\7;\2\2\u01ff\u01fd\3\2\2\2\u0200\u0203"+
		"\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0207\3\2\2\2\u0203"+
		"\u0201\3\2\2\2\u0204\u0206\7E\2\2\u0205\u0204\3\2\2\2\u0206\u0209\3\2"+
		"\2\2\u0207\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u020a\u020e\7\63\2\2\u020b\u020d\7E\2\2\u020c\u020b\3\2"+
		"\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f"+
		"\u0221\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0215\5,\27\2\u0212\u0214\7E"+
		"\2\2\u0213\u0212\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215"+
		"\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u021c\7<"+
		"\2\2\u0219\u021b\7E\2\2\u021a\u0219\3\2\2\2\u021b\u021e\3\2\2\2\u021c"+
		"\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u021c\3\2"+
		"\2\2\u021f\u0211\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0226\5,"+
		"\27\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u022a\3\2\2\2\u0227"+
		"\u0229\7E\2\2\u0228\u0227\3\2\2\2\u0229\u022c\3\2\2\2\u022a\u0228\3\2"+
		"\2\2\u022a\u022b\3\2\2\2\u022b\u022d\3\2\2\2\u022c\u022a\3\2\2\2\u022d"+
		"\u0261\7\64\2\2\u022e\u0233\f\3\2\2\u022f\u0230\7?\2\2\u0230\u0232\7;"+
		"\2\2\u0231\u022f\3\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u0239\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u0238\7E"+
		"\2\2\u0237\u0236\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u023c\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u0240\7\67"+
		"\2\2\u023d\u023f\7E\2\2\u023e\u023d\3\2\2\2\u023f\u0242\3\2\2\2\u0240"+
		"\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0253\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0243\u0247\5,\27\2\u0244\u0246\7E\2\2\u0245\u0244\3\2\2\2\u0246"+
		"\u0249\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u024a\3\2"+
		"\2\2\u0249\u0247\3\2\2\2\u024a\u024e\7<\2\2\u024b\u024d\7E\2\2\u024c\u024b"+
		"\3\2\2\2\u024d\u0250\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f"+
		"\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0251\u0243\3\2\2\2\u0252\u0255\3\2"+
		"\2\2\u0253\u0251\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0257\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0256\u0258\5,\27\2\u0257\u0256\3\2\2\2\u0257\u0258\3\2"+
		"\2\2\u0258\u025c\3\2\2\2\u0259\u025b\7E\2\2\u025a\u0259\3\2\2\2\u025b"+
		"\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025f\3\2"+
		"\2\2\u025e\u025c\3\2\2\2\u025f\u0261\78\2\2\u0260\u01fc\3\2\2\2\u0260"+
		"\u022e\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262\u0263\3\2"+
		"\2\2\u0263\'\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\7E\2\2\u0266\u0265"+
		"\3\2\2\2\u0267\u026a\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269"+
		"\u026b\3\2\2\2\u026a\u0268\3\2\2\2\u026b\u026f\7\65\2\2\u026c\u026e\7"+
		"E\2\2\u026d\u026c\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u026f"+
		"\u0270\3\2\2\2\u0270\u0282\3\2\2\2\u0271\u026f\3\2\2\2\u0272\u0276\5*"+
		"\26\2\u0273\u0275\7E\2\2\u0274\u0273\3\2\2\2\u0275\u0278\3\2\2\2\u0276"+
		"\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276\3\2"+
		"\2\2\u0279\u027d\7>\2\2\u027a\u027c\7E\2\2\u027b\u027a\3\2\2\2\u027c\u027f"+
		"\3\2\2\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u0281\3\2\2\2\u027f"+
		"\u027d\3\2\2\2\u0280\u0272\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0280\3\2"+
		"\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284\u0282\3\2\2\2\u0285"+
		"\u0289\5*\26\2\u0286\u0288\7E\2\2\u0287\u0286\3\2\2\2\u0288\u028b\3\2"+
		"\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c\3\2\2\2\u028b"+
		"\u0289\3\2\2\2\u028c\u0290\7\66\2\2\u028d\u028f\7E\2\2\u028e\u028d\3\2"+
		"\2\2\u028f\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291"+
		")\3\2\2\2\u0292\u0290\3\2\2\2\u0293\u029a\5\26\f\2\u0294\u029b\7<\2\2"+
		"\u0295\u0297\7E\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0296"+
		"\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029b\3\2\2\2\u029a\u0294\3\2\2\2\u029a"+
		"\u0296\3\2\2\2\u029b\u029d\3\2\2\2\u029c\u0293\3\2\2\2\u029d\u02a0\3\2"+
		"\2\2\u029e\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0"+
		"\u029e\3\2\2\2\u02a1\u02a3\5\26\f\2\u02a2\u02a1\3\2\2\2\u02a2\u02a3\3"+
		"\2\2\2\u02a3+\3\2\2\2\u02a4\u02a9\5\26\f\2\u02a5\u02a9\7=\2\2\u02a6\u02a9"+
		"\5J&\2\u02a7\u02a9\5.\30\2\u02a8\u02a4\3\2\2\2\u02a8\u02a5\3\2\2\2\u02a8"+
		"\u02a6\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a9-\3\2\2\2\u02aa\u02ae\5\60\31"+
		"\2\u02ab\u02ad\7E\2\2\u02ac\u02ab\3\2\2\2\u02ad\u02b0\3\2\2\2\u02ae\u02ac"+
		"\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b1"+
		"\u02b5\7=\2\2\u02b2\u02b4\7E\2\2\u02b3\u02b2\3\2\2\2\u02b4\u02b7\3\2\2"+
		"\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02c6\3\2\2\2\u02b7\u02b5"+
		"\3\2\2\2\u02b8\u02bc\5\62\32\2\u02b9\u02bb\7E\2\2\u02ba\u02b9\3\2\2\2"+
		"\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02bf"+
		"\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02c3\7=\2\2\u02c0\u02c2\7E\2\2\u02c1"+
		"\u02c0\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3\u02c1\3\2\2\2\u02c3\u02c4\3\2"+
		"\2\2\u02c4\u02c7\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02b8\3\2\2\2\u02c6"+
		"\u02c7\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9\5\64\33\2\u02c9/\3\2\2"+
		"\2\u02ca\u02cd\7\5\2\2\u02cb\u02cd\5\26\f\2\u02cc\u02ca\3\2\2\2\u02cc"+
		"\u02cb\3\2\2\2\u02cd\61\3\2\2\2\u02ce\u02cf\5\26\f\2\u02cf\63\3\2\2\2"+
		"\u02d0\u02d3\7\5\2\2\u02d1\u02d3\5\26\f\2\u02d2\u02d0\3\2\2\2\u02d2\u02d1"+
		"\3\2\2\2\u02d3\65\3\2\2\2\u02d4\u02d6\7E\2\2\u02d5\u02d4\3\2\2\2\u02d6"+
		"\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02da\3\2"+
		"\2\2\u02d9\u02d7\3\2\2\2\u02da\u02de\7;\2\2\u02db\u02dd\7E\2\2\u02dc\u02db"+
		"\3\2\2\2\u02dd\u02e0\3\2\2\2\u02de\u02dc\3\2\2\2\u02de\u02df\3\2\2\2\u02df"+
		"\u02e1\3\2\2\2\u02e0\u02de\3\2\2\2\u02e1\u02f8\7\63\2\2\u02e2\u02e4\7"+
		"E\2\2\u02e3\u02e2\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5"+
		"\u02e6\3\2\2\2\u02e6\u02e8\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e8\u02ec\7;"+
		"\2\2\u02e9\u02eb\7E\2\2\u02ea\u02e9\3\2\2\2\u02eb\u02ee\3\2\2\2\u02ec"+
		"\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ef\3\2\2\2\u02ee\u02ec\3\2"+
		"\2\2\u02ef\u02f3\7<\2\2\u02f0\u02f2\7E\2\2\u02f1\u02f0\3\2\2\2\u02f2\u02f5"+
		"\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f7\3\2\2\2\u02f5"+
		"\u02f3\3\2\2\2\u02f6\u02e5\3\2\2\2\u02f7\u02fa\3\2\2\2\u02f8\u02f6\3\2"+
		"\2\2\u02f8\u02f9\3\2\2\2\u02f9\u0308\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fb"+
		"\u02fd\7E\2\2\u02fc\u02fb\3\2\2\2\u02fd\u0300\3\2\2\2\u02fe\u02fc\3\2"+
		"\2\2\u02fe\u02ff\3\2\2\2\u02ff\u0301\3\2\2\2\u0300\u02fe\3\2\2\2\u0301"+
		"\u0305\7;\2\2\u0302\u0304\7E\2\2\u0303\u0302\3\2\2\2\u0304\u0307\3\2\2"+
		"\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0309\3\2\2\2\u0307\u0305"+
		"\3\2\2\2\u0308\u02fe\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2\2\2\u030a"+
		"\u030e\7\64\2\2\u030b\u030d\7E\2\2\u030c\u030b\3\2\2\2\u030d\u0310\3\2"+
		"\2\2\u030e\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\67\3\2\2\2\u0310\u030e"+
		"\3\2\2\2\u0311\u0313\7E\2\2\u0312\u0311\3\2\2\2\u0313\u0316\3\2\2\2\u0314"+
		"\u0312\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0319\3\2\2\2\u0316\u0314\3\2"+
		"\2\2\u0317\u031a\5&\24\2\u0318\u031a\5(\25\2\u0319\u0317\3\2\2\2\u0319"+
		"\u0318\3\2\2\2\u031a\u031e\3\2\2\2\u031b\u031d\7E\2\2\u031c\u031b\3\2"+
		"\2\2\u031d\u0320\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f"+
		"9\3\2\2\2\u0320\u031e\3\2\2\2\u0321\u0322\b\36\1\2\u0322\u0349\5<\37\2"+
		"\u0323\u0325\7E\2\2\u0324\u0323\3\2\2\2\u0325\u0328\3\2\2\2\u0326\u0324"+
		"\3\2\2\2\u0326\u0327\3\2\2\2\u0327\u0329\3\2\2\2\u0328\u0326\3\2\2\2\u0329"+
		"\u032a\7\36\2\2\u032a\u0349\5:\36\6\u032b\u032d\7E\2\2\u032c\u032b\3\2"+
		"\2\2\u032d\u0330\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f"+
		"\u0331\3\2\2\2\u0330\u032e\3\2\2\2\u0331\u0332\7\63\2\2\u0332\u0333\5"+
		":\36\2\u0333\u0337\7\64\2\2\u0334\u0336\7E\2\2\u0335\u0334\3\2\2\2\u0336"+
		"\u0339\3\2\2\2\u0337\u0335\3\2\2\2\u0337\u0338\3\2\2\2\u0338\u0349\3\2"+
		"\2\2\u0339\u0337\3\2\2\2\u033a\u0349\5B\"\2\u033b\u033d\7E\2\2\u033c\u033b"+
		"\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f"+
		"\u0341\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u0345\5&\24\2\u0342\u0344\7E"+
		"\2\2\u0343\u0342\3\2\2\2\u0344\u0347\3\2\2\2\u0345\u0343\3\2\2\2\u0345"+
		"\u0346\3\2\2\2\u0346\u0349\3\2\2\2\u0347\u0345\3\2\2\2\u0348\u0321\3\2"+
		"\2\2\u0348\u0326\3\2\2\2\u0348\u032e\3\2\2\2\u0348\u033a\3\2\2\2\u0348"+
		"\u033e\3\2\2\2\u0349\u0352\3\2\2\2\u034a\u034b\f\b\2\2\u034b\u034c\7\34"+
		"\2\2\u034c\u0351\5:\36\t\u034d\u034e\f\7\2\2\u034e\u034f\7\35\2\2\u034f"+
		"\u0351\5:\36\b\u0350\u034a\3\2\2\2\u0350\u034d\3\2\2\2\u0351\u0354\3\2"+
		"\2\2\u0352\u0350\3\2\2\2\u0352\u0353\3\2\2\2\u0353;\3\2\2\2\u0354\u0352"+
		"\3\2\2\2\u0355\u0356\5\32\16\2\u0356\u0357\5@!\2\u0357\u0358\5\32\16\2"+
		"\u0358\u035e\3\2\2\2\u0359\u035a\5F$\2\u035a\u035b\5> \2\u035b\u035c\5"+
		"F$\2\u035c\u035e\3\2\2\2\u035d\u0355\3\2\2\2\u035d\u0359\3\2\2\2\u035e"+
		"=\3\2\2\2\u035f\u0360\t\7\2\2\u0360?\3\2\2\2\u0361\u0362\t\b\2\2\u0362"+
		"A\3\2\2\2\u0363\u0365\7E\2\2\u0364\u0363\3\2\2\2\u0365\u0368\3\2\2\2\u0366"+
		"\u0364\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u0369\3\2\2\2\u0368\u0366\3\2"+
		"\2\2\u0369\u036d\7\37\2\2\u036a\u036c\7E\2\2\u036b\u036a\3\2\2\2\u036c"+
		"\u036f\3\2\2\2\u036d\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u037e\3\2"+
		"\2\2\u036f\u036d\3\2\2\2\u0370\u0372\7E\2\2\u0371\u0370\3\2\2\2\u0372"+
		"\u0375\3\2\2\2\u0373\u0371\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u0376\3\2"+
		"\2\2\u0375\u0373\3\2\2\2\u0376\u037a\7 \2\2\u0377\u0379\7E\2\2\u0378\u0377"+
		"\3\2\2\2\u0379\u037c\3\2\2\2\u037a\u0378\3\2\2\2\u037a\u037b\3\2\2\2\u037b"+
		"\u037e\3\2\2\2\u037c\u037a\3\2\2\2\u037d\u0366\3\2\2\2\u037d\u0373\3\2"+
		"\2\2\u037eC\3\2\2\2\u037f\u0381\7E\2\2\u0380\u037f\3\2\2\2\u0381\u0384"+
		"\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383\3\2\2\2\u0383\u0385\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0385\u0389\5&\24\2\u0386\u0388\7E\2\2\u0387\u0386\3\2"+
		"\2\2\u0388\u038b\3\2\2\2\u0389\u0387\3\2\2\2\u0389\u038a\3\2\2\2\u038a"+
		"\u038c\3\2\2\2\u038b\u0389\3\2\2\2\u038c\u038d\7\62\2\2\u038d\u038e\5"+
		"\26\f\2\u038e\u0419\3\2\2\2\u038f\u0391\7E\2\2\u0390\u038f\3\2\2\2\u0391"+
		"\u0394\3\2\2\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0395\3\2"+
		"\2\2\u0394\u0392\3\2\2\2\u0395\u0399\7\65\2\2\u0396\u0398\7E\2\2\u0397"+
		"\u0396\3\2\2\2\u0398\u039b\3\2\2\2\u0399\u0397\3\2\2\2\u0399\u039a\3\2"+
		"\2\2\u039a\u03b3\3\2\2\2\u039b\u0399\3\2\2\2\u039c\u03a0\7;\2\2\u039d"+
		"\u039f\7E\2\2\u039e\u039d\3\2\2\2\u039f\u03a2\3\2\2\2\u03a0\u039e\3\2"+
		"\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a9\3\2\2\2\u03a2\u03a0\3\2\2\2\u03a3"+
		"\u03aa\7<\2\2\u03a4\u03a6\7E\2\2\u03a5\u03a4\3\2\2\2\u03a6\u03a7\3\2\2"+
		"\2\u03a7\u03a5\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03aa\3\2\2\2\u03a9\u03a3"+
		"\3\2\2\2\u03a9\u03a5\3\2\2\2\u03aa\u03ae\3\2\2\2\u03ab\u03ad\7E\2\2\u03ac"+
		"\u03ab\3\2\2\2\u03ad\u03b0\3\2\2\2\u03ae\u03ac\3\2\2\2\u03ae\u03af\3\2"+
		"\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b1\u039c\3\2\2\2\u03b2"+
		"\u03b5\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b7\3\2"+
		"\2\2\u03b5\u03b3\3\2\2\2\u03b6\u03b8\7;\2\2\u03b7\u03b6\3\2\2\2\u03b7"+
		"\u03b8\3\2\2\2\u03b8\u03bc\3\2\2\2\u03b9\u03bb\7E\2\2\u03ba\u03b9\3\2"+
		"\2\2\u03bb\u03be\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd"+
		"\u03bf\3\2\2\2\u03be\u03bc\3\2\2\2\u03bf\u03c3\7\66\2\2\u03c0\u03c2\7"+
		"E\2\2\u03c1\u03c0\3\2\2\2\u03c2\u03c5\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c3"+
		"\u03c4\3\2\2\2\u03c4\u03c6\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c6\u03c7\7\62"+
		"\2\2\u03c7\u0419\5\26\f\2\u03c8\u03ca\7E\2\2\u03c9\u03c8\3\2\2\2\u03ca"+
		"\u03cd\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03ce\3\2"+
		"\2\2\u03cd\u03cb\3\2\2\2\u03ce\u03d2\5&\24\2\u03cf\u03d1\7E\2\2\u03d0"+
		"\u03cf\3\2\2\2\u03d1\u03d4\3\2\2\2\u03d2\u03d0\3\2\2\2\u03d2\u03d3\3\2"+
		"\2\2\u03d3\u03d5\3\2\2\2\u03d4\u03d2\3\2\2\2\u03d5\u03d6\7/\2\2\u03d6"+
		"\u03d7\5\26\f\2\u03d7\u0419\3\2\2\2\u03d8\u03da\7E\2\2\u03d9\u03d8\3\2"+
		"\2\2\u03da\u03dd\3\2\2\2\u03db\u03d9\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc"+
		"\u03de\3\2\2\2\u03dd\u03db\3\2\2\2\u03de\u03e2\5&\24\2\u03df\u03e1\7E"+
		"\2\2\u03e0\u03df\3\2\2\2\u03e1\u03e4\3\2\2\2\u03e2\u03e0\3\2\2\2\u03e2"+
		"\u03e3\3\2\2\2\u03e3\u03e5\3\2\2\2\u03e4\u03e2\3\2\2\2\u03e5\u03e6\7\60"+
		"\2\2\u03e6\u03e7\5\26\f\2\u03e7\u0419\3\2\2\2\u03e8\u03ea\7E\2\2\u03e9"+
		"\u03e8\3\2\2\2\u03ea\u03ed\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb\u03ec\3\2"+
		"\2\2\u03ec\u03ee\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ee\u03f2\5&\24\2\u03ef"+
		"\u03f1\7E\2\2\u03f0\u03ef\3\2\2\2\u03f1\u03f4\3\2\2\2\u03f2\u03f0\3\2"+
		"\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f5"+
		"\u03f6\7\61\2\2\u03f6\u03f7\5\26\f\2\u03f7\u0419\3\2\2\2\u03f8\u03fa\7"+
		"E\2\2\u03f9\u03f8\3\2\2\2\u03fa\u03fd\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fb"+
		"\u03fc\3\2\2\2\u03fc\u03fe\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fe\u0402\5&"+
		"\24\2\u03ff\u0401\7E\2\2\u0400\u03ff\3\2\2\2\u0401\u0404\3\2\2\2\u0402"+
		"\u0400\3\2\2\2\u0402\u0403\3\2\2\2\u0403\u0405\3\2\2\2\u0404\u0402\3\2"+
		"\2\2\u0405\u0406\7-\2\2\u0406\u0407\5\26\f\2\u0407\u0419\3\2\2\2\u0408"+
		"\u040a\7E\2\2\u0409\u0408\3\2\2\2\u040a\u040d\3\2\2\2\u040b\u0409\3\2"+
		"\2\2\u040b\u040c\3\2\2\2\u040c\u040e\3\2\2\2\u040d\u040b\3\2\2\2\u040e"+
		"\u0412\5&\24\2\u040f\u0411\7E\2\2\u0410\u040f\3\2\2\2\u0411\u0414\3\2"+
		"\2\2\u0412\u0410\3\2\2\2\u0412\u0413\3\2\2\2\u0413\u0415\3\2\2\2\u0414"+
		"\u0412\3\2\2\2\u0415\u0416\7.\2\2\u0416\u0417\5\26\f\2\u0417\u0419\3\2"+
		"\2\2\u0418\u0382\3\2\2\2\u0418\u0392\3\2\2\2\u0418\u03cb\3\2\2\2\u0418"+
		"\u03db\3\2\2\2\u0418\u03eb\3\2\2\2\u0418\u03fb\3\2\2\2\u0418\u040b\3\2"+
		"\2\2\u0419E\3\2\2\2\u041a\u041b\5H%\2\u041b\u041c\7\21\2\2\u041c\u041d"+
		"\5H%\2\u041d\u0420\3\2\2\2\u041e\u0420\5H%\2\u041f\u041a\3\2\2\2\u041f"+
		"\u041e\3\2\2\2\u0420G\3\2\2\2\u0421\u0423\7E\2\2\u0422\u0421\3\2\2\2\u0423"+
		"\u0426\3\2\2\2\u0424\u0422\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0427\3\2"+
		"\2\2\u0426\u0424\3\2\2\2\u0427\u042b\7F\2\2\u0428\u042a\7E\2\2\u0429\u0428"+
		"\3\2\2\2\u042a\u042d\3\2\2\2\u042b\u0429\3\2\2\2\u042b\u042c\3\2\2\2\u042c"+
		"\u043c\3\2\2\2\u042d\u042b\3\2\2\2\u042e\u0430\7E\2\2\u042f\u042e\3\2"+
		"\2\2\u0430\u0433\3\2\2\2\u0431\u042f\3\2\2\2\u0431\u0432\3\2\2\2\u0432"+
		"\u0434\3\2\2\2\u0433\u0431\3\2\2\2\u0434\u0438\5&\24\2\u0435\u0437\7E"+
		"\2\2\u0436\u0435\3\2\2\2\u0437\u043a\3\2\2\2\u0438\u0436\3\2\2\2\u0438"+
		"\u0439\3\2\2\2\u0439\u043c\3\2\2\2\u043a\u0438\3\2\2\2\u043b\u0424\3\2"+
		"\2\2\u043b\u0431\3\2\2\2\u043cI\3\2\2\2\u043d\u043e\7\20\2\2\u043e\u043f"+
		"\7;\2\2\u043fK\3\2\2\2\u00a6NSXZ_flsxz\177\u0086\u008c\u0093\u0099\u00a0"+
		"\u00a5\u00a7\u00ac\u00b1\u00b6\u00ba\u00bf\u00c6\u00cf\u00d3\u00d6\u00db"+
		"\u00e3\u00eb\u00f1\u00f8\u00fc\u00ff\u0104\u010b\u010f\u0114\u011b\u0122"+
		"\u0129\u0133\u0137\u013c\u0147\u014b\u0150\u0155\u0158\u015d\u0161\u0174"+
		"\u017b\u0180\u0186\u018e\u0197\u019f\u01a6\u01aa\u01ac\u01be\u01c3\u01c5"+
		"\u01cf\u01d6\u01dc\u01e3\u01e9\u01f0\u01f3\u0201\u0207\u020e\u0215\u021c"+
		"\u0221\u0225\u022a\u0233\u0239\u0240\u0247\u024e\u0253\u0257\u025c\u0260"+
		"\u0262\u0268\u026f\u0276\u027d\u0282\u0289\u0290\u0298\u029a\u029e\u02a2"+
		"\u02a8\u02ae\u02b5\u02bc\u02c3\u02c6\u02cc\u02d2\u02d7\u02de\u02e5\u02ec"+
		"\u02f3\u02f8\u02fe\u0305\u0308\u030e\u0314\u0319\u031e\u0326\u032e\u0337"+
		"\u033e\u0345\u0348\u0350\u0352\u035d\u0366\u036d\u0373\u037a\u037d\u0382"+
		"\u0389\u0392\u0399\u03a0\u03a7\u03a9\u03ae\u03b3\u03b7\u03bc\u03c3\u03cb"+
		"\u03d2\u03db\u03e2\u03eb\u03f2\u03fb\u0402\u040b\u0412\u0418\u041f\u0424"+
		"\u042b\u0431\u0438\u043b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}