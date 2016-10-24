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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		ADD=18, SUB=19, MUL=20, DIV=21, POW=22, SOL=23, DADD=24, DSUB=25, DMUL=26, 
		DRDIV=27, DLDIV=28, DPOW=29, AND=30, OR=31, NOT=32, TRUE=33, FALSE=34, 
		GT=35, GE=36, LT=37, LE=38, EQ=39, NEQ=40, NEQ2=41, SHL=42, SHR=43, USHR=44, 
		INC=45, DESC=46, ADD_ASSIGN=47, SUB_ASSIGN=48, MUL_ASSIGN=49, DIV_ASSIGN=50, 
		REM_ASSIGN=51, ASSIGN=52, LPAREN=53, RPAREN=54, LBRK=55, RBRK=56, LCB=57, 
		RCB=58, END=59, BAND=60, BOR=61, BXOR=62, BNOT=63, INTEGER=64, FLOAT=65, 
		IDENTIFIER=66, COMMA=67, COLON=68, SEMI=69, PERIOD=70, SQUOTE=71, DQUOTE=72, 
		DPRIME=73, COMMENT=74, SKIP_TOKEN=75, WS=76, StringLiteral=77;
	public static final int
		RULE_prog = 0, RULE_statement_block = 1, RULE_expr_end = 2, RULE_expr_end2 = 3, 
		RULE_statement = 4, RULE_tic = 5, RULE_toc = 6, RULE_expression_with_expr_end = 7, 
		RULE_if_cond_and_body = 8, RULE_else_body = 9, RULE_case_expr_and_body = 10, 
		RULE_otherwise_body = 11, RULE_expression = 12, RULE_for_range_expr = 13, 
		RULE_arithmetic_expr = 14, RULE_add_sub_operator = 15, RULE_mul_div_operator = 16, 
		RULE_bit_operator = 17, RULE_numeric_entity = 18, RULE_integer_entity = 19, 
		RULE_float_entity = 20, RULE_variable_entity = 21, RULE_array_init = 22, 
		RULE_cell_init = 23, RULE_ai_list = 24, RULE_aa_index = 25, RULE_aa_range = 26, 
		RULE_aa_range_start = 27, RULE_aa_range_step = 28, RULE_aa_range_end = 29, 
		RULE_func_name_args = 30, RULE_func_def_return = 31, RULE_logical_expr = 32, 
		RULE_comparison_expr = 33, RULE_string_comp_operator = 34, RULE_comp_operator = 35, 
		RULE_logical_entity = 36, RULE_assign_expr = 37, RULE_string_expr = 38, 
		RULE_string_entity = 39, RULE_func_handle = 40;
	public static final String[] ruleNames = {
		"prog", "statement_block", "expr_end", "expr_end2", "statement", "tic", 
		"toc", "expression_with_expr_end", "if_cond_and_body", "else_body", "case_expr_and_body", 
		"otherwise_body", "expression", "for_range_expr", "arithmetic_expr", "add_sub_operator", 
		"mul_div_operator", "bit_operator", "numeric_entity", "integer_entity", 
		"float_entity", "variable_entity", "array_init", "cell_init", "ai_list", 
		"aa_index", "aa_range", "aa_range_start", "aa_range_step", "aa_range_end", 
		"func_name_args", "func_def_return", "logical_expr", "comparison_expr", 
		"string_comp_operator", "comp_operator", "logical_entity", "assign_expr", 
		"string_expr", "string_entity", "func_handle"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'if'", "'elseif'", "'else'", "'for'", "'in'", 
		"'while'", "'return'", "'switch'", "'case'", "'otherwise'", "'tic'", "'toc'", 
		"'''", "'nargin'", "'@'", "'+'", "'-'", "'*'", "'/'", null, "'\\'", "'.+'", 
		"'.-'", "'.*'", "'./'", "'.\\'", null, null, null, null, "'true'", "'false'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'~='", "'<<'", "'>>'", 
		"'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", "'end'", "'&'", "'|'", "'^'", 
		"'~'", null, null, null, "','", "':'", "';'", "'.'", "'`'", "'\"'", "'.''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", "POW", 
		"SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "DPOW", "AND", "OR", 
		"NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "NEQ2", "SHL", 
		"SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "END", "BAND", "BOR", "BXOR", "BNOT", "INTEGER", "FLOAT", 
		"IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
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
			setState(82);
			statement_block();
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(83);
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
			setState(89);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					statement();
					}
					} 
				}
				setState(91);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(92);
				expression();
				setState(94);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(93);
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
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
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
				match(SEMI);
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(114);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(111);
							match(WS);
							}
							}
							setState(116);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(117);
						match(T__0);
						setState(121);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(118);
								match(WS);
								}
								} 
							}
							setState(123);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(126); 
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
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
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
				match(SEMI);
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(137);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(142);
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
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(143);
					match(WS);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(COMMA);
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(150);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==WS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						} 
					}
					setState(155);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(156);
							match(WS);
							}
							}
							setState(161);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(162);
						match(T__0);
						setState(166);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(163);
								match(WS);
								}
								} 
							}
							setState(168);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(171); 
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
		public TerminalNode EOF() { return getToken(MatlabGrammarParser.EOF, 0); }
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
	public static class ExprSwitchContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<Case_expr_and_bodyContext> case_expr_and_body() {
			return getRuleContexts(Case_expr_and_bodyContext.class);
		}
		public Case_expr_and_bodyContext case_expr_and_body(int i) {
			return getRuleContext(Case_expr_and_bodyContext.class,i);
		}
		public Otherwise_bodyContext otherwise_body() {
			return getRuleContext(Otherwise_bodyContext.class,0);
		}
		public List<Expr_endContext> expr_end() {
			return getRuleContexts(Expr_endContext.class);
		}
		public Expr_endContext expr_end(int i) {
			return getRuleContext(Expr_endContext.class,i);
		}
		public ExprSwitchContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprSwitch(this);
		}
	}
	public static class NewLinesContext extends StatementContext {
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public NewLinesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterNewLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitNewLines(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				_localctx = new ExprWithExprEnd1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				expression_with_expr_end();
				}
				break;
			case 2:
				_localctx = new TicTocContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(176);
					match(WS);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				switch (_input.LA(1)) {
				case T__12:
					{
					setState(182);
					tic();
					}
					break;
				case T__13:
					{
					setState(183);
					toc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(186);
						match(WS);
						}
						} 
					}
					setState(191);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(192);
					expr_end();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(195);
					match(WS);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(T__1);
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(202);
					func_def_return();
					setState(203);
					match(ASSIGN);
					}
					break;
				}
				setState(207);
				func_name_args();
				setState(208);
				expr_end2();
				setState(209);
				statement_block();
				setState(221);
				switch (_input.LA(1)) {
				case END:
					{
					{
					setState(210);
					match(END);
					setState(214);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(211);
							match(WS);
							}
							} 
						}
						setState(216);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					}
					setState(218);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						setState(217);
						expr_end();
						}
						break;
					}
					}
					}
					break;
				case EOF:
					{
					setState(220);
					match(EOF);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(223);
					match(WS);
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
				match(T__2);
				setState(230);
				if_cond_and_body();
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						{
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(231);
							match(WS);
							}
							}
							setState(236);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(237);
						match(T__3);
						}
						setState(239);
						if_cond_and_body();
						}
						} 
					}
					setState(244);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					{
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(245);
						match(WS);
						}
						}
						setState(250);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(251);
					match(T__4);
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(252);
							match(WS);
							}
							} 
						}
						setState(257);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
					}
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						setState(258);
						expr_end();
						}
						break;
					}
					}
					setState(261);
					else_body();
					}
					break;
				}
				{
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(264);
					match(WS);
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270);
				match(END);
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(271);
						match(WS);
						}
						} 
					}
					setState(276);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(277);
					expr_end();
					}
					break;
				}
				}
				}
				break;
			case 5:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(280);
					match(WS);
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
				match(T__5);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(287);
					match(WS);
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(293);
				match(IDENTIFIER);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(294);
					match(WS);
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(300);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==ASSIGN) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(301);
						match(WS);
						}
						} 
					}
					setState(306);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				setState(307);
				for_range_expr();
				setState(308);
				expr_end2();
				setState(309);
				statement_block();
				setState(310);
				match(END);
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(311);
						match(WS);
						}
						} 
					}
					setState(316);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				setState(318);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(317);
					expr_end();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new ExprWhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
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
				match(T__7);
				setState(327);
				logical_expr(0);
				setState(328);
				expr_end2();
				setState(329);
				statement_block();
				setState(330);
				match(END);
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(331);
						match(WS);
						}
						} 
					}
					setState(336);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(337);
					expr_end();
					}
					break;
				}
				}
				break;
			case 7:
				_localctx = new ExprReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(340);
					match(WS);
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(346);
				match(T__8);
				setState(348);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(347);
					expression();
					}
					break;
				}
				setState(351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(350);
					expr_end();
					}
					break;
				}
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				}
				break;
			case 8:
				_localctx = new ExprSwitchContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(359);
					match(WS);
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(365);
				match(T__9);
				setState(366);
				expression();
				setState(367);
				expr_end2();
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						{
						setState(371);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(368);
							match(WS);
							}
							}
							setState(373);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(374);
						match(T__10);
						}
						setState(376);
						case_expr_and_body();
						}
						} 
					}
					setState(381);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				setState(399);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					{
					setState(385);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(382);
						match(WS);
						}
						}
						setState(387);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(388);
					match(T__11);
					setState(392);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(389);
							match(WS);
							}
							} 
						}
						setState(394);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
					}
					setState(396);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						setState(395);
						expr_end();
						}
						break;
					}
					}
					setState(398);
					otherwise_body();
					}
					break;
				}
				{
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(401);
					match(WS);
					}
					}
					setState(406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(407);
				match(END);
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(408);
						match(WS);
						}
						} 
					}
					setState(413);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(415);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(414);
					expr_end();
					}
					break;
				}
				}
				}
				break;
			case 9:
				_localctx = new NewLinesContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(430); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(420);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(417);
							match(WS);
							}
							}
							setState(422);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(423);
						match(T__0);
						setState(427);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(424);
								match(WS);
								}
								} 
							}
							setState(429);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(432); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
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
			setState(436);
			match(T__12);
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
			setState(438);
			match(T__13);
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
			setState(440);
			expression();
			setState(441);
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
			setState(443);
			logical_expr(0);
			setState(444);
			expr_end2();
			setState(445);
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
			setState(447);
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

	public static class Case_expr_and_bodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_end2Context expr_end2() {
			return getRuleContext(Expr_end2Context.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Case_expr_and_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expr_and_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterCase_expr_and_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitCase_expr_and_body(this);
		}
	}

	public final Case_expr_and_bodyContext case_expr_and_body() throws RecognitionException {
		Case_expr_and_bodyContext _localctx = new Case_expr_and_bodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_case_expr_and_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			expression();
			setState(450);
			expr_end2();
			setState(451);
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

	public static class Otherwise_bodyContext extends ParserRuleContext {
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Otherwise_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherwise_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterOtherwise_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitOtherwise_body(this);
		}
	}

	public final Otherwise_bodyContext otherwise_body() throws RecognitionException {
		Otherwise_bodyContext _localctx = new Otherwise_bodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_otherwise_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
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
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
				string_expr();
				}
				break;
			case 3:
				_localctx = new ExprAssign1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(457);
				assign_expr();
				}
				break;
			case 4:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(458);
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
		enterRule(_localctx, 26, RULE_for_range_expr);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				_localctx = new ForRangeColonContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(461);
				arithmetic_expr(0);
				setState(462);
				match(COLON);
				setState(466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(463);
					arithmetic_expr(0);
					setState(464);
					match(COLON);
					}
					break;
				}
				setState(468);
				arithmetic_expr(0);
				}
				}
				break;
			case 2:
				_localctx = new ForRangeArrayInit1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
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
		public TerminalNode DPOW() { return getToken(MatlabGrammarParser.DPOW, 0); }
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
	public static class ArithmeticExpressionBitContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Bit_operatorContext bit_operator() {
			return getRuleContext(Bit_operatorContext.class,0);
		}
		public ArithmeticExpressionBitContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterArithmeticExpressionBit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitArithmeticExpressionBit(this);
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
	public static class ExprCellInitContext extends Arithmetic_exprContext {
		public Cell_initContext cell_init() {
			return getRuleContext(Cell_initContext.class,0);
		}
		public ExprCellInitContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterExprCellInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitExprCellInit(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(474);
					match(WS);
					}
					}
					setState(479);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(480);
				match(SUB);
				setState(481);
				arithmetic_expr(11);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(482);
					match(WS);
					}
					}
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(488);
				match(LPAREN);
				setState(489);
				arithmetic_expr(0);
				setState(490);
				match(RPAREN);
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
			case 3:
				{
				_localctx = new ExprArrayInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				array_init();
				}
				break;
			case 4:
				{
				_localctx = new ExprCellInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498);
				cell_init();
				}
				break;
			case 5:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499);
				numeric_entity();
				}
				break;
			case 6:
				{
				_localctx = new NArgInContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(500);
					match(WS);
					}
					}
					setState(505);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(506);
				match(T__15);
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(507);
						match(WS);
						}
						} 
					}
					setState(512);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(514);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(513);
					expr_end();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(545);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(543);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionPowContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(518);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(519);
						_la = _input.LA(1);
						if ( !(_la==POW || _la==DPOW) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(520);
						arithmetic_expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionMulDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(521);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(522);
						mul_div_operator();
						setState(523);
						arithmetic_expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionAddSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(525);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(526);
						add_sub_operator();
						setState(527);
						arithmetic_expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionBitContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(529);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(530);
						bit_operator();
						setState(531);
						arithmetic_expr(8);
						}
						break;
					case 5:
						{
						_localctx = new ExprRange1Context(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(533);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(534);
						match(COLON);
						setState(538);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
						case 1:
							{
							setState(535);
							arithmetic_expr(0);
							setState(536);
							match(COLON);
							}
							break;
						}
						setState(540);
						arithmetic_expr(2);
						}
						break;
					case 6:
						{
						_localctx = new TransposeContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(541);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(542);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==DPRIME) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(547);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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
		enterRule(_localctx, 30, RULE_add_sub_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
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
		enterRule(_localctx, 32, RULE_mul_div_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
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

	public static class Bit_operatorContext extends ParserRuleContext {
		public TerminalNode BAND() { return getToken(MatlabGrammarParser.BAND, 0); }
		public TerminalNode BOR() { return getToken(MatlabGrammarParser.BOR, 0); }
		public TerminalNode BXOR() { return getToken(MatlabGrammarParser.BXOR, 0); }
		public TerminalNode BNOT() { return getToken(MatlabGrammarParser.BNOT, 0); }
		public Bit_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterBit_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitBit_operator(this);
		}
	}

	public final Bit_operatorContext bit_operator() throws RecognitionException {
		Bit_operatorContext _localctx = new Bit_operatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bit_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BAND) | (1L << BOR) | (1L << BXOR) | (1L << BNOT))) != 0)) ) {
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
		enterRule(_localctx, 36, RULE_numeric_entity);
		int _la;
		try {
			int _alt;
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(554);
					match(WS);
					}
					}
					setState(559);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(560);
				integer_entity();
				setState(564);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(561);
						match(WS);
						}
						} 
					}
					setState(566);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(567);
					match(WS);
					}
					}
					setState(572);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(573);
				float_entity();
				setState(577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(574);
						match(WS);
						}
						} 
					}
					setState(579);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(580);
					match(WS);
					}
					}
					setState(585);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(586);
				variable_entity(0);
				setState(590);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(587);
						match(WS);
						}
						} 
					}
					setState(592);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
		enterRule(_localctx, 38, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
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
		enterRule(_localctx, 40, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(MatlabGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MatlabGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(MatlabGrammarParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(MatlabGrammarParser.PERIOD, i);
		}
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
	public static class SpecialFuncCallContext extends Variable_entityContext {
		public TerminalNode LPAREN() { return getToken(MatlabGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MatlabGrammarParser.RPAREN, 0); }
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
		public SpecialFuncCallContext(Variable_entityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterSpecialFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitSpecialFuncCall(this);
		}
	}
	public static class CellAccessContext extends Variable_entityContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode LCB() { return getToken(MatlabGrammarParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(MatlabGrammarParser.RCB, 0); }
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_variable_entity, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new EntityVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(600);
				match(IDENTIFIER);
				setState(605);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(601);
						match(PERIOD);
						setState(602);
						match(IDENTIFIER);
						}
						} 
					}
					setState(607);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				}
				}
				break;
			case T__15:
			case TRUE:
			case FALSE:
				{
				_localctx = new SpecialFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(608);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << TRUE) | (1L << FALSE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(609);
					match(WS);
					}
					}
					setState(614);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(615);
				match(LPAREN);
				setState(619);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(616);
						match(WS);
						}
						} 
					}
					setState(621);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
				}
				setState(638);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(622);
						aa_index();
						setState(626);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(623);
							match(WS);
							}
							}
							setState(628);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(629);
						match(COMMA);
						setState(633);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(630);
								match(WS);
								}
								} 
							}
							setState(635);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
						}
						}
						} 
					}
					setState(640);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				}
				setState(642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(641);
					aa_index();
					}
					break;
				}
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
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(741);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(739);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayAccessOrFuncCallContext(new Variable_entityContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_variable_entity);
						setState(653);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(657);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(654);
							match(WS);
							}
							}
							setState(659);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(660);
						match(LPAREN);
						setState(664);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(661);
								match(WS);
								}
								} 
							}
							setState(666);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
						}
						setState(683);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(667);
								aa_index();
								setState(671);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==WS) {
									{
									{
									setState(668);
									match(WS);
									}
									}
									setState(673);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(674);
								match(COMMA);
								setState(678);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
								while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
									if ( _alt==1 ) {
										{
										{
										setState(675);
										match(WS);
										}
										} 
									}
									setState(680);
									_errHandler.sync(this);
									_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
								}
								}
								} 
							}
							setState(685);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
						}
						setState(687);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
						case 1:
							{
							setState(686);
							aa_index();
							}
							break;
						}
						setState(692);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(689);
							match(WS);
							}
							}
							setState(694);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(695);
						match(RPAREN);
						}
						break;
					case 2:
						{
						_localctx = new CellAccessContext(new Variable_entityContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_variable_entity);
						setState(696);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(700);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(697);
							match(WS);
							}
							}
							setState(702);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(703);
						match(LCB);
						setState(707);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(704);
								match(WS);
								}
								} 
							}
							setState(709);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
						}
						setState(726);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(710);
								aa_index();
								setState(714);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==WS) {
									{
									{
									setState(711);
									match(WS);
									}
									}
									setState(716);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(717);
								match(COMMA);
								setState(721);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
								while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
									if ( _alt==1 ) {
										{
										{
										setState(718);
										match(WS);
										}
										} 
									}
									setState(723);
									_errHandler.sync(this);
									_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
								}
								}
								} 
							}
							setState(728);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
						}
						setState(730);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
						case 1:
							{
							setState(729);
							aa_index();
							}
							break;
						}
						setState(735);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WS) {
							{
							{
							setState(732);
							match(WS);
							}
							}
							setState(737);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(738);
						match(RCB);
						}
						break;
					}
					} 
				}
				setState(743);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
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
		enterRule(_localctx, 44, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(744);
				match(WS);
				}
				}
				setState(749);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(750);
			match(LBRK);
			setState(754);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(751);
					match(WS);
					}
					} 
				}
				setState(756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			}
			setState(785);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(757);
					ai_list();
					setState(761);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(758);
						match(WS);
						}
						}
						setState(763);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(764);
					match(SEMI);
					setState(768);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(765);
							match(WS);
							}
							} 
						}
						setState(770);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					}
					setState(774);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(771);
						match(T__0);
						}
						}
						setState(776);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(780);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
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
						_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
					}
					}
					} 
				}
				setState(787);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			setState(788);
			ai_list();
			setState(792);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(789);
				match(WS);
				}
				}
				setState(794);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(795);
			match(RBRK);
			setState(799);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(796);
					match(WS);
					}
					} 
				}
				setState(801);
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

	public static class Cell_initContext extends ParserRuleContext {
		public TerminalNode LCB() { return getToken(MatlabGrammarParser.LCB, 0); }
		public List<Ai_listContext> ai_list() {
			return getRuleContexts(Ai_listContext.class);
		}
		public Ai_listContext ai_list(int i) {
			return getRuleContext(Ai_listContext.class,i);
		}
		public TerminalNode RCB() { return getToken(MatlabGrammarParser.RCB, 0); }
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MatlabGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MatlabGrammarParser.SEMI, i);
		}
		public Cell_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cell_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterCell_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitCell_init(this);
		}
	}

	public final Cell_initContext cell_init() throws RecognitionException {
		Cell_initContext _localctx = new Cell_initContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cell_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(802);
				match(WS);
				}
				}
				setState(807);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(808);
			match(LCB);
			setState(812);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(809);
					match(WS);
					}
					} 
				}
				setState(814);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			}
			setState(831);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(815);
					ai_list();
					setState(819);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(816);
						match(WS);
						}
						}
						setState(821);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(822);
					match(SEMI);
					setState(826);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(823);
							match(WS);
							}
							} 
						}
						setState(828);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,121,_ctx);
					}
					}
					} 
				}
				setState(833);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			}
			setState(834);
			ai_list();
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(835);
				match(WS);
				}
				}
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(841);
			match(RCB);
			setState(845);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(842);
					match(WS);
					}
					} 
				}
				setState(847);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
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
		enterRule(_localctx, 48, RULE_ai_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(848);
					expression();
					setState(850); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(849);
							_la = _input.LA(1);
							if ( !(_la==T__0 || _la==COMMA || _la==WS) ) {
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
						setState(852); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(858);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			setState(860);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(859);
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
		public TerminalNode END() { return getToken(MatlabGrammarParser.END, 0); }
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
		enterRule(_localctx, 50, RULE_aa_index);
		try {
			setState(867);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(862);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(863);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(864);
				func_handle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(865);
				aa_range();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(866);
				match(END);
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
		enterRule(_localctx, 52, RULE_aa_range);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			aa_range_start();
			setState(873);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(870);
				match(WS);
				}
				}
				setState(875);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(876);
			match(COLON);
			setState(880);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(877);
					match(WS);
					}
					} 
				}
				setState(882);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
			}
			setState(897);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(883);
				aa_range_step();
				setState(887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(884);
					match(WS);
					}
					}
					setState(889);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(890);
				match(COLON);
				setState(894);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(891);
						match(WS);
						}
						} 
					}
					setState(896);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				}
				}
				break;
			}
			setState(899);
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
		enterRule(_localctx, 54, RULE_aa_range_start);
		try {
			setState(903);
			switch (_input.LA(1)) {
			case END:
				enterOuterAlt(_localctx, 1);
				{
				setState(901);
				match(END);
				}
				break;
			case T__15:
			case SUB:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAREN:
			case LBRK:
			case LCB:
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(902);
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
		enterRule(_localctx, 56, RULE_aa_range_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
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
		enterRule(_localctx, 58, RULE_aa_range_end);
		try {
			setState(909);
			switch (_input.LA(1)) {
			case END:
				enterOuterAlt(_localctx, 1);
				{
				setState(907);
				match(END);
				}
				break;
			case T__15:
			case SUB:
			case NOT:
			case TRUE:
			case FALSE:
			case LPAREN:
			case LBRK:
			case LCB:
			case INTEGER:
			case FLOAT:
			case IDENTIFIER:
			case WS:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(908);
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
		enterRule(_localctx, 60, RULE_func_name_args);
		int _la;
		try {
			int _alt;
			_localctx = new FuncDefNameArgsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(911);
				match(WS);
				}
				}
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(917);
			match(IDENTIFIER);
			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(918);
				match(WS);
				}
				}
				setState(923);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(924);
			match(LPAREN);
			setState(947);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(928);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(925);
						match(WS);
						}
						}
						setState(930);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(931);
					match(IDENTIFIER);
					setState(935);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(932);
						match(WS);
						}
						}
						setState(937);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(938);
					match(COMMA);
					setState(942);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(939);
							match(WS);
							}
							} 
						}
						setState(944);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
					}
					}
					} 
				}
				setState(949);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			}
			setState(963);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==WS) {
				{
				setState(953);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(950);
					match(WS);
					}
					}
					setState(955);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(956);
				match(IDENTIFIER);
				setState(960);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(957);
					match(WS);
					}
					}
					setState(962);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(965);
			match(RPAREN);
			setState(969);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(966);
					match(WS);
					}
					} 
				}
				setState(971);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
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
		enterRule(_localctx, 62, RULE_func_def_return);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(975);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(972);
					match(WS);
					}
					} 
				}
				setState(977);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			}
			setState(980);
			switch (_input.LA(1)) {
			case T__15:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
				{
				setState(978);
				variable_entity(0);
				}
				break;
			case LBRK:
			case WS:
				{
				setState(979);
				array_init();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
	public static class LogicalExpressionBitContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public Bit_operatorContext bit_operator() {
			return getRuleContext(Bit_operatorContext.class,0);
		}
		public LogicalExpressionBitContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).enterLogicalExpressionBit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatlabGrammarListener ) ((MatlabGrammarListener)listener).exitLogicalExpressionBit(this);
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
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_logical_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1027);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(989);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(993);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(990);
					match(WS);
					}
					}
					setState(995);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(996);
				match(NOT);
				setState(997);
				logical_expr(4);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
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
				match(LPAREN);
				setState(1005);
				logical_expr(0);
				setState(1006);
				match(RPAREN);
				setState(1010);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1007);
						match(WS);
						}
						} 
					}
					setState(1012);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1013);
				logical_entity();
				}
				break;
			case 5:
				{
				_localctx = new LogicalVariableEntity1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
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
				_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1021);
						match(WS);
						}
						} 
					}
					setState(1026);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1041);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1039);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(1029);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1030);
						match(AND);
						setState(1031);
						logical_expr(8);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(1032);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1033);
						match(OR);
						setState(1034);
						logical_expr(7);
						}
						break;
					case 3:
						{
						_localctx = new LogicalExpressionBitContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(1035);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1036);
						bit_operator();
						setState(1037);
						logical_expr(6);
						}
						break;
					}
					} 
				}
				setState(1043);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
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
		enterRule(_localctx, 66, RULE_comparison_expr);
		try {
			setState(1052);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				_localctx = new ComparisonArithmeticExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1044);
				arithmetic_expr(0);
				setState(1045);
				comp_operator();
				setState(1046);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ComparisonStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1048);
				string_expr();
				setState(1049);
				string_comp_operator();
				setState(1050);
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
		enterRule(_localctx, 68, RULE_string_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
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
		enterRule(_localctx, 70, RULE_comp_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
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
		enterRule(_localctx, 72, RULE_logical_entity);
		int _la;
		try {
			int _alt;
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				{
				{
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1058);
					match(WS);
					}
					}
					setState(1063);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1064);
				match(TRUE);
				setState(1068);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1065);
						match(WS);
						}
						} 
					}
					setState(1070);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(1074);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1071);
					match(WS);
					}
					}
					setState(1076);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1077);
				match(FALSE);
				setState(1081);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1078);
						match(WS);
						}
						} 
					}
					setState(1083);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
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
		public List<Variable_entityContext> variable_entity() {
			return getRuleContexts(Variable_entityContext.class);
		}
		public Variable_entityContext variable_entity(int i) {
			return getRuleContext(Variable_entityContext.class,i);
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
		enterRule(_localctx, 74, RULE_assign_expr);
		int _la;
		try {
			int _alt;
			setState(1239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1089);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1086);
					match(WS);
					}
					}
					setState(1091);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1092);
				variable_entity(0);
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1093);
					match(WS);
					}
					}
					setState(1098);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1099);
				match(ASSIGN);
				setState(1100);
				expression();
				}
				break;
			case 2:
				_localctx = new ExprMultiAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1102);
					match(WS);
					}
					}
					setState(1107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1108);
				match(LBRK);
				setState(1112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1109);
						match(WS);
						}
						} 
					}
					setState(1114);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,166,_ctx);
				}
				setState(1138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1115);
						variable_entity(0);
						setState(1119);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1116);
								match(WS);
								}
								} 
							}
							setState(1121);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
						}
						setState(1128);
						switch (_input.LA(1)) {
						case COMMA:
							{
							setState(1122);
							match(COMMA);
							}
							break;
						case WS:
							{
							setState(1124); 
							_errHandler.sync(this);
							_alt = 1;
							do {
								switch (_alt) {
								case 1:
									{
									{
									setState(1123);
									match(WS);
									}
									}
									break;
								default:
									throw new NoViableAltException(this);
								}
								setState(1126); 
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
							} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1133);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1130);
								match(WS);
								}
								} 
							}
							setState(1135);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,170,_ctx);
						}
						}
						} 
					}
					setState(1140);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
				}
				setState(1142);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & ((1L << (T__15 - 16)) | (1L << (TRUE - 16)) | (1L << (FALSE - 16)) | (1L << (IDENTIFIER - 16)))) != 0)) {
					{
					setState(1141);
					variable_entity(0);
					}
				}

				setState(1147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1144);
					match(WS);
					}
					}
					setState(1149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1150);
				match(RBRK);
				setState(1154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1151);
					match(WS);
					}
					}
					setState(1156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1157);
				match(ASSIGN);
				setState(1158);
				expression();
				}
				break;
			case 3:
				_localctx = new ExprMulAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1159);
					match(WS);
					}
					}
					setState(1164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1165);
				variable_entity(0);
				setState(1169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1166);
					match(WS);
					}
					}
					setState(1171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1172);
				match(MUL_ASSIGN);
				setState(1173);
				expression();
				}
				break;
			case 4:
				_localctx = new ExprDivAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1175);
					match(WS);
					}
					}
					setState(1180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1181);
				variable_entity(0);
				setState(1185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1182);
					match(WS);
					}
					}
					setState(1187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1188);
				match(DIV_ASSIGN);
				setState(1189);
				expression();
				}
				break;
			case 5:
				_localctx = new ExprRemAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1191);
					match(WS);
					}
					}
					setState(1196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1197);
				variable_entity(0);
				setState(1201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1198);
					match(WS);
					}
					}
					setState(1203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1204);
				match(REM_ASSIGN);
				setState(1205);
				expression();
				}
				break;
			case 6:
				_localctx = new ExprAddAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1207);
					match(WS);
					}
					}
					setState(1212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1213);
				variable_entity(0);
				setState(1217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1214);
					match(WS);
					}
					}
					setState(1219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1220);
				match(ADD_ASSIGN);
				setState(1221);
				expression();
				}
				break;
			case 7:
				_localctx = new ExprSubAssignContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1223);
					match(WS);
					}
					}
					setState(1228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1229);
				variable_entity(0);
				setState(1233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1230);
					match(WS);
					}
					}
					setState(1235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1236);
				match(SUB_ASSIGN);
				setState(1237);
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
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
		}
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
		public List<TerminalNode> WS() { return getTokens(MatlabGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MatlabGrammarParser.WS, i);
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
		enterRule(_localctx, 76, RULE_string_expr);
		int _la;
		try {
			int _alt;
			setState(1281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				_localctx = new StringConcatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1241);
						match(WS);
						}
						} 
					}
					setState(1246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,186,_ctx);
				}
				setState(1247);
				string_entity();
				setState(1251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1248);
					match(WS);
					}
					}
					setState(1253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1254);
				match(ADD);
				setState(1258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1255);
						match(WS);
						}
						} 
					}
					setState(1260);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				}
				setState(1261);
				string_entity();
				setState(1265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1262);
						match(WS);
						}
						} 
					}
					setState(1267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new StringEntity1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1268);
						match(WS);
						}
						} 
					}
					setState(1273);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
				}
				setState(1274);
				string_entity();
				setState(1278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1275);
						match(WS);
						}
						} 
					}
					setState(1280);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
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
		enterRule(_localctx, 78, RULE_string_entity);
		int _la;
		try {
			int _alt;
			setState(1297);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1283);
				match(StringLiteral);
				}
				break;
			case T__15:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case WS:
				_localctx = new StringVariable1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(1284);
					match(WS);
					}
					}
					setState(1289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1290);
				variable_entity(0);
				setState(1294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1291);
						match(WS);
						}
						} 
					}
					setState(1296);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
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
		enterRule(_localctx, 80, RULE_func_handle);
		try {
			_localctx = new FuncHandleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(1299);
			match(T__16);
			setState(1300);
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
		case 14:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 21:
			return variable_entity_sempred((Variable_entityContext)_localctx, predIndex);
		case 32:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 1);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean variable_entity_sempred(Variable_entityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u0519\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\5\2W\n\2\3\3\7\3Z\n\3\f\3\16\3]\13\3\3\3\3\3\5\3a\n\3\5\3c\n\3\3\4\7"+
		"\4f\n\4\f\4\16\4i\13\4\3\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\4\7\4s\n\4\f"+
		"\4\16\4v\13\4\3\4\3\4\7\4z\n\4\f\4\16\4}\13\4\6\4\177\n\4\r\4\16\4\u0080"+
		"\5\4\u0083\n\4\3\5\7\5\u0086\n\5\f\5\16\5\u0089\13\5\3\5\3\5\7\5\u008d"+
		"\n\5\f\5\16\5\u0090\13\5\3\5\7\5\u0093\n\5\f\5\16\5\u0096\13\5\3\5\3\5"+
		"\7\5\u009a\n\5\f\5\16\5\u009d\13\5\3\5\7\5\u00a0\n\5\f\5\16\5\u00a3\13"+
		"\5\3\5\3\5\7\5\u00a7\n\5\f\5\16\5\u00aa\13\5\6\5\u00ac\n\5\r\5\16\5\u00ad"+
		"\5\5\u00b0\n\5\3\6\3\6\7\6\u00b4\n\6\f\6\16\6\u00b7\13\6\3\6\3\6\5\6\u00bb"+
		"\n\6\3\6\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\3\6\5\6\u00c4\n\6\3\6\7\6\u00c7"+
		"\n\6\f\6\16\6\u00ca\13\6\3\6\3\6\3\6\3\6\5\6\u00d0\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6\u00d7\n\6\f\6\16\6\u00da\13\6\3\6\5\6\u00dd\n\6\3\6\5\6\u00e0"+
		"\n\6\3\6\7\6\u00e3\n\6\f\6\16\6\u00e6\13\6\3\6\3\6\3\6\7\6\u00eb\n\6\f"+
		"\6\16\6\u00ee\13\6\3\6\3\6\3\6\7\6\u00f3\n\6\f\6\16\6\u00f6\13\6\3\6\7"+
		"\6\u00f9\n\6\f\6\16\6\u00fc\13\6\3\6\3\6\7\6\u0100\n\6\f\6\16\6\u0103"+
		"\13\6\3\6\5\6\u0106\n\6\3\6\5\6\u0109\n\6\3\6\7\6\u010c\n\6\f\6\16\6\u010f"+
		"\13\6\3\6\3\6\7\6\u0113\n\6\f\6\16\6\u0116\13\6\3\6\5\6\u0119\n\6\3\6"+
		"\7\6\u011c\n\6\f\6\16\6\u011f\13\6\3\6\3\6\7\6\u0123\n\6\f\6\16\6\u0126"+
		"\13\6\3\6\3\6\7\6\u012a\n\6\f\6\16\6\u012d\13\6\3\6\3\6\7\6\u0131\n\6"+
		"\f\6\16\6\u0134\13\6\3\6\3\6\3\6\3\6\3\6\7\6\u013b\n\6\f\6\16\6\u013e"+
		"\13\6\3\6\5\6\u0141\n\6\3\6\7\6\u0144\n\6\f\6\16\6\u0147\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\u014f\n\6\f\6\16\6\u0152\13\6\3\6\5\6\u0155\n\6\3"+
		"\6\7\6\u0158\n\6\f\6\16\6\u015b\13\6\3\6\3\6\5\6\u015f\n\6\3\6\5\6\u0162"+
		"\n\6\3\6\7\6\u0165\n\6\f\6\16\6\u0168\13\6\3\6\7\6\u016b\n\6\f\6\16\6"+
		"\u016e\13\6\3\6\3\6\3\6\3\6\7\6\u0174\n\6\f\6\16\6\u0177\13\6\3\6\3\6"+
		"\3\6\7\6\u017c\n\6\f\6\16\6\u017f\13\6\3\6\7\6\u0182\n\6\f\6\16\6\u0185"+
		"\13\6\3\6\3\6\7\6\u0189\n\6\f\6\16\6\u018c\13\6\3\6\5\6\u018f\n\6\3\6"+
		"\5\6\u0192\n\6\3\6\7\6\u0195\n\6\f\6\16\6\u0198\13\6\3\6\3\6\7\6\u019c"+
		"\n\6\f\6\16\6\u019f\13\6\3\6\5\6\u01a2\n\6\3\6\7\6\u01a5\n\6\f\6\16\6"+
		"\u01a8\13\6\3\6\3\6\7\6\u01ac\n\6\f\6\16\6\u01af\13\6\6\6\u01b1\n\6\r"+
		"\6\16\6\u01b2\5\6\u01b5\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u01ce\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\5\17\u01d5\n\17\3\17\3\17\3\17\5\17\u01da"+
		"\n\17\3\20\3\20\7\20\u01de\n\20\f\20\16\20\u01e1\13\20\3\20\3\20\3\20"+
		"\7\20\u01e6\n\20\f\20\16\20\u01e9\13\20\3\20\3\20\3\20\3\20\7\20\u01ef"+
		"\n\20\f\20\16\20\u01f2\13\20\3\20\3\20\3\20\3\20\7\20\u01f8\n\20\f\20"+
		"\16\20\u01fb\13\20\3\20\3\20\7\20\u01ff\n\20\f\20\16\20\u0202\13\20\3"+
		"\20\5\20\u0205\n\20\5\20\u0207\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u021d\n\20\3\20\3\20\3\20\7\20\u0222\n\20\f\20\16\20\u0225\13\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\7\24\u022e\n\24\f\24\16\24\u0231\13\24"+
		"\3\24\3\24\7\24\u0235\n\24\f\24\16\24\u0238\13\24\3\24\7\24\u023b\n\24"+
		"\f\24\16\24\u023e\13\24\3\24\3\24\7\24\u0242\n\24\f\24\16\24\u0245\13"+
		"\24\3\24\7\24\u0248\n\24\f\24\16\24\u024b\13\24\3\24\3\24\7\24\u024f\n"+
		"\24\f\24\16\24\u0252\13\24\5\24\u0254\n\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\7\27\u025e\n\27\f\27\16\27\u0261\13\27\3\27\3\27\7\27\u0265"+
		"\n\27\f\27\16\27\u0268\13\27\3\27\3\27\7\27\u026c\n\27\f\27\16\27\u026f"+
		"\13\27\3\27\3\27\7\27\u0273\n\27\f\27\16\27\u0276\13\27\3\27\3\27\7\27"+
		"\u027a\n\27\f\27\16\27\u027d\13\27\7\27\u027f\n\27\f\27\16\27\u0282\13"+
		"\27\3\27\5\27\u0285\n\27\3\27\7\27\u0288\n\27\f\27\16\27\u028b\13\27\3"+
		"\27\5\27\u028e\n\27\3\27\3\27\7\27\u0292\n\27\f\27\16\27\u0295\13\27\3"+
		"\27\3\27\7\27\u0299\n\27\f\27\16\27\u029c\13\27\3\27\3\27\7\27\u02a0\n"+
		"\27\f\27\16\27\u02a3\13\27\3\27\3\27\7\27\u02a7\n\27\f\27\16\27\u02aa"+
		"\13\27\7\27\u02ac\n\27\f\27\16\27\u02af\13\27\3\27\5\27\u02b2\n\27\3\27"+
		"\7\27\u02b5\n\27\f\27\16\27\u02b8\13\27\3\27\3\27\3\27\7\27\u02bd\n\27"+
		"\f\27\16\27\u02c0\13\27\3\27\3\27\7\27\u02c4\n\27\f\27\16\27\u02c7\13"+
		"\27\3\27\3\27\7\27\u02cb\n\27\f\27\16\27\u02ce\13\27\3\27\3\27\7\27\u02d2"+
		"\n\27\f\27\16\27\u02d5\13\27\7\27\u02d7\n\27\f\27\16\27\u02da\13\27\3"+
		"\27\5\27\u02dd\n\27\3\27\7\27\u02e0\n\27\f\27\16\27\u02e3\13\27\3\27\7"+
		"\27\u02e6\n\27\f\27\16\27\u02e9\13\27\3\30\7\30\u02ec\n\30\f\30\16\30"+
		"\u02ef\13\30\3\30\3\30\7\30\u02f3\n\30\f\30\16\30\u02f6\13\30\3\30\3\30"+
		"\7\30\u02fa\n\30\f\30\16\30\u02fd\13\30\3\30\3\30\7\30\u0301\n\30\f\30"+
		"\16\30\u0304\13\30\3\30\7\30\u0307\n\30\f\30\16\30\u030a\13\30\3\30\7"+
		"\30\u030d\n\30\f\30\16\30\u0310\13\30\7\30\u0312\n\30\f\30\16\30\u0315"+
		"\13\30\3\30\3\30\7\30\u0319\n\30\f\30\16\30\u031c\13\30\3\30\3\30\7\30"+
		"\u0320\n\30\f\30\16\30\u0323\13\30\3\31\7\31\u0326\n\31\f\31\16\31\u0329"+
		"\13\31\3\31\3\31\7\31\u032d\n\31\f\31\16\31\u0330\13\31\3\31\3\31\7\31"+
		"\u0334\n\31\f\31\16\31\u0337\13\31\3\31\3\31\7\31\u033b\n\31\f\31\16\31"+
		"\u033e\13\31\7\31\u0340\n\31\f\31\16\31\u0343\13\31\3\31\3\31\7\31\u0347"+
		"\n\31\f\31\16\31\u034a\13\31\3\31\3\31\7\31\u034e\n\31\f\31\16\31\u0351"+
		"\13\31\3\32\3\32\6\32\u0355\n\32\r\32\16\32\u0356\7\32\u0359\n\32\f\32"+
		"\16\32\u035c\13\32\3\32\5\32\u035f\n\32\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u0366\n\33\3\34\3\34\7\34\u036a\n\34\f\34\16\34\u036d\13\34\3\34\3\34"+
		"\7\34\u0371\n\34\f\34\16\34\u0374\13\34\3\34\3\34\7\34\u0378\n\34\f\34"+
		"\16\34\u037b\13\34\3\34\3\34\7\34\u037f\n\34\f\34\16\34\u0382\13\34\5"+
		"\34\u0384\n\34\3\34\3\34\3\35\3\35\5\35\u038a\n\35\3\36\3\36\3\37\3\37"+
		"\5\37\u0390\n\37\3 \7 \u0393\n \f \16 \u0396\13 \3 \3 \7 \u039a\n \f "+
		"\16 \u039d\13 \3 \3 \7 \u03a1\n \f \16 \u03a4\13 \3 \3 \7 \u03a8\n \f"+
		" \16 \u03ab\13 \3 \3 \7 \u03af\n \f \16 \u03b2\13 \7 \u03b4\n \f \16 "+
		"\u03b7\13 \3 \7 \u03ba\n \f \16 \u03bd\13 \3 \3 \7 \u03c1\n \f \16 \u03c4"+
		"\13 \5 \u03c6\n \3 \3 \7 \u03ca\n \f \16 \u03cd\13 \3!\7!\u03d0\n!\f!"+
		"\16!\u03d3\13!\3!\3!\5!\u03d7\n!\3!\7!\u03da\n!\f!\16!\u03dd\13!\3\"\3"+
		"\"\3\"\7\"\u03e2\n\"\f\"\16\"\u03e5\13\"\3\"\3\"\3\"\7\"\u03ea\n\"\f\""+
		"\16\"\u03ed\13\"\3\"\3\"\3\"\3\"\7\"\u03f3\n\"\f\"\16\"\u03f6\13\"\3\""+
		"\3\"\7\"\u03fa\n\"\f\"\16\"\u03fd\13\"\3\"\3\"\7\"\u0401\n\"\f\"\16\""+
		"\u0404\13\"\5\"\u0406\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\""+
		"\u0412\n\"\f\"\16\"\u0415\13\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u041f\n#\3$"+
		"\3$\3%\3%\3&\7&\u0426\n&\f&\16&\u0429\13&\3&\3&\7&\u042d\n&\f&\16&\u0430"+
		"\13&\3&\7&\u0433\n&\f&\16&\u0436\13&\3&\3&\7&\u043a\n&\f&\16&\u043d\13"+
		"&\5&\u043f\n&\3\'\7\'\u0442\n\'\f\'\16\'\u0445\13\'\3\'\3\'\7\'\u0449"+
		"\n\'\f\'\16\'\u044c\13\'\3\'\3\'\3\'\3\'\7\'\u0452\n\'\f\'\16\'\u0455"+
		"\13\'\3\'\3\'\7\'\u0459\n\'\f\'\16\'\u045c\13\'\3\'\3\'\7\'\u0460\n\'"+
		"\f\'\16\'\u0463\13\'\3\'\3\'\6\'\u0467\n\'\r\'\16\'\u0468\5\'\u046b\n"+
		"\'\3\'\7\'\u046e\n\'\f\'\16\'\u0471\13\'\7\'\u0473\n\'\f\'\16\'\u0476"+
		"\13\'\3\'\5\'\u0479\n\'\3\'\7\'\u047c\n\'\f\'\16\'\u047f\13\'\3\'\3\'"+
		"\7\'\u0483\n\'\f\'\16\'\u0486\13\'\3\'\3\'\3\'\7\'\u048b\n\'\f\'\16\'"+
		"\u048e\13\'\3\'\3\'\7\'\u0492\n\'\f\'\16\'\u0495\13\'\3\'\3\'\3\'\3\'"+
		"\7\'\u049b\n\'\f\'\16\'\u049e\13\'\3\'\3\'\7\'\u04a2\n\'\f\'\16\'\u04a5"+
		"\13\'\3\'\3\'\3\'\3\'\7\'\u04ab\n\'\f\'\16\'\u04ae\13\'\3\'\3\'\7\'\u04b2"+
		"\n\'\f\'\16\'\u04b5\13\'\3\'\3\'\3\'\3\'\7\'\u04bb\n\'\f\'\16\'\u04be"+
		"\13\'\3\'\3\'\7\'\u04c2\n\'\f\'\16\'\u04c5\13\'\3\'\3\'\3\'\3\'\7\'\u04cb"+
		"\n\'\f\'\16\'\u04ce\13\'\3\'\3\'\7\'\u04d2\n\'\f\'\16\'\u04d5\13\'\3\'"+
		"\3\'\3\'\5\'\u04da\n\'\3(\7(\u04dd\n(\f(\16(\u04e0\13(\3(\3(\7(\u04e4"+
		"\n(\f(\16(\u04e7\13(\3(\3(\7(\u04eb\n(\f(\16(\u04ee\13(\3(\3(\7(\u04f2"+
		"\n(\f(\16(\u04f5\13(\3(\7(\u04f8\n(\f(\16(\u04fb\13(\3(\3(\7(\u04ff\n"+
		"(\f(\16(\u0502\13(\5(\u0504\n(\3)\3)\7)\u0508\n)\f)\16)\u050b\13)\3)\3"+
		")\7)\u050f\n)\f)\16)\u0512\13)\5)\u0514\n)\3*\3*\3*\3*\2\5\36,B+\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2"+
		"\r\4\2\3\3NN\4\2\t\t\66\66\4\2\30\30\37\37\4\2\21\21KK\4\2\24\25\32\33"+
		"\5\2\26\27\31\31\34\36\3\2>A\4\2\22\22#$\5\2\3\3EENN\3\2)+\3\2%+\u05d2"+
		"\2T\3\2\2\2\4[\3\2\2\2\6\u0082\3\2\2\2\b\u00af\3\2\2\2\n\u01b4\3\2\2\2"+
		"\f\u01b6\3\2\2\2\16\u01b8\3\2\2\2\20\u01ba\3\2\2\2\22\u01bd\3\2\2\2\24"+
		"\u01c1\3\2\2\2\26\u01c3\3\2\2\2\30\u01c7\3\2\2\2\32\u01cd\3\2\2\2\34\u01d9"+
		"\3\2\2\2\36\u0206\3\2\2\2 \u0226\3\2\2\2\"\u0228\3\2\2\2$\u022a\3\2\2"+
		"\2&\u0253\3\2\2\2(\u0255\3\2\2\2*\u0257\3\2\2\2,\u028d\3\2\2\2.\u02ed"+
		"\3\2\2\2\60\u0327\3\2\2\2\62\u035a\3\2\2\2\64\u0365\3\2\2\2\66\u0367\3"+
		"\2\2\28\u0389\3\2\2\2:\u038b\3\2\2\2<\u038f\3\2\2\2>\u0394\3\2\2\2@\u03d1"+
		"\3\2\2\2B\u0405\3\2\2\2D\u041e\3\2\2\2F\u0420\3\2\2\2H\u0422\3\2\2\2J"+
		"\u043e\3\2\2\2L\u04d9\3\2\2\2N\u0503\3\2\2\2P\u0513\3\2\2\2R\u0515\3\2"+
		"\2\2TV\5\4\3\2UW\7\2\2\3VU\3\2\2\2VW\3\2\2\2W\3\3\2\2\2XZ\5\n\6\2YX\3"+
		"\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\b\3\2\2\2][\3\2\2\2^`\5\32\16\2"+
		"_a\5\6\4\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2b^\3\2\2\2bc\3\2\2\2c\5\3\2\2"+
		"\2df\7N\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2"+
		"\2jn\7G\2\2km\t\2\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\u0083\3"+
		"\2\2\2pn\3\2\2\2qs\7N\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3"+
		"\2\2\2vt\3\2\2\2w{\7\3\2\2xz\7N\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3"+
		"\2\2\2|\177\3\2\2\2}{\3\2\2\2~t\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082g\3\2\2\2\u0082~\3\2\2"+
		"\2\u0083\7\3\2\2\2\u0084\u0086\7N\2\2\u0085\u0084\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008e\7G\2\2\u008b\u008d\t\2\2\2\u008c\u008b\3\2"+
		"\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u00b0\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\7N\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009b\7E\2\2\u0098\u009a\t\2"+
		"\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00b0\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\7N"+
		"\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a8\7\3"+
		"\2\2\u00a5\u00a7\7N\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00a1\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u0087\3\2\2\2\u00af\u0094\3\2"+
		"\2\2\u00af\u00ab\3\2\2\2\u00b0\t\3\2\2\2\u00b1\u01b5\5\20\t\2\u00b2\u00b4"+
		"\7N\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00ba\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\5\f"+
		"\7\2\u00b9\u00bb\5\16\b\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00bf\3\2\2\2\u00bc\u00be\7N\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c4\5\6\4\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u01b5\3\2\2\2\u00c5\u00c7\7N\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cf\7\4\2\2\u00cc\u00cd\5@!\2\u00cd\u00ce"+
		"\7\66\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00d0\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d1\u00d2\5> \2\u00d2\u00d3\5\b\5\2\u00d3\u00df"+
		"\5\4\3\2\u00d4\u00d8\7=\2\2\u00d5\u00d7\7N\2\2\u00d6\u00d5\3\2\2\2\u00d7"+
		"\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\5\6\4\2\u00dc\u00db\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00e0\7\2\2\3\u00df\u00d4\3\2"+
		"\2\2\u00df\u00de\3\2\2\2\u00e0\u01b5\3\2\2\2\u00e1\u00e3\7N\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\5\2\2\u00e8"+
		"\u00f4\5\22\n\2\u00e9\u00eb\7N\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00f0\7\6\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\5\22"+
		"\n\2\u00f2\u00ec\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u0108\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\7N"+
		"\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0101\7\7"+
		"\2\2\u00fe\u0100\7N\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u0106\5\6\4\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0109\5\24\13\2\u0108\u00fa\3\2\2\2\u0108\u0109\3"+
		"\2\2\2\u0109\u010d\3\2\2\2\u010a\u010c\7N\2\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u0110\u0114\7=\2\2\u0111\u0113\7N\2\2\u0112\u0111"+
		"\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0119\5\6\4\2\u0118\u0117\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u01b5\3\2\2\2\u011a\u011c\7N\2\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0124\7\b\2\2\u0121"+
		"\u0123\7N\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u012b\7D\2\2\u0128\u012a\7N\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2"+
		"\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012e\u0132\t\3\2\2\u012f\u0131\7N\2\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5\34\17\2\u0136\u0137\5\b\5\2\u0137"+
		"\u0138\5\4\3\2\u0138\u013c\7=\2\2\u0139\u013b\7N\2\2\u013a\u0139\3\2\2"+
		"\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140"+
		"\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\5\6\4\2\u0140\u013f\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u01b5\3\2\2\2\u0142\u0144\7N\2\2\u0143\u0142\3\2"+
		"\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7\n\2\2\u0149\u014a\5B"+
		"\"\2\u014a\u014b\5\b\5\2\u014b\u014c\5\4\3\2\u014c\u0150\7=\2\2\u014d"+
		"\u014f\7N\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u0155\5\6\4\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u01b5\3\2"+
		"\2\2\u0156\u0158\7N\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015c\u015e\7\13\2\2\u015d\u015f\5\32\16\2\u015e\u015d\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u0162\5\6\4\2\u0161\u0160\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\u0166\3\2\2\2\u0163\u0165\7N\2\2\u0164"+
		"\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u01b5\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016b\7N\2\2\u016a"+
		"\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\f\2\2\u0170"+
		"\u0171\5\32\16\2\u0171\u017d\5\b\5\2\u0172\u0174\7N\2\2\u0173\u0172\3"+
		"\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7\r\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017c\5\26\f\2\u017b\u0175\3\2\2\2\u017c\u017f\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0191\3\2\2\2\u017f\u017d\3\2"+
		"\2\2\u0180\u0182\7N\2\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2"+
		"\2\2\u0186\u018a\7\16\2\2\u0187\u0189\7N\2\2\u0188\u0187\3\2\2\2\u0189"+
		"\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018e\3\2"+
		"\2\2\u018c\u018a\3\2\2\2\u018d\u018f\5\6\4\2\u018e\u018d\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\5\30\r\2\u0191\u0183\3"+
		"\2\2\2\u0191\u0192\3\2\2\2\u0192\u0196\3\2\2\2\u0193\u0195\7N\2\2\u0194"+
		"\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019d\7=\2\2\u019a"+
		"\u019c\7N\2\2\u019b\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2"+
		"\2\2\u019d\u019e\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u01a0"+
		"\u01a2\5\6\4\2\u01a1\u01a0\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01b5\3\2"+
		"\2\2\u01a3\u01a5\7N\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a9\u01ad\7\3\2\2\u01aa\u01ac\7N\2\2\u01ab\u01aa\3\2\2\2\u01ac"+
		"\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b1\3\2"+
		"\2\2\u01af\u01ad\3\2\2\2\u01b0\u01a6\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u00b1\3\2"+
		"\2\2\u01b4\u00b5\3\2\2\2\u01b4\u00c8\3\2\2\2\u01b4\u00e4\3\2\2\2\u01b4"+
		"\u011d\3\2\2\2\u01b4\u0145\3\2\2\2\u01b4\u0159\3\2\2\2\u01b4\u016c\3\2"+
		"\2\2\u01b4\u01b0\3\2\2\2\u01b5\13\3\2\2\2\u01b6\u01b7\7\17\2\2\u01b7\r"+
		"\3\2\2\2\u01b8\u01b9\7\20\2\2\u01b9\17\3\2\2\2\u01ba\u01bb\5\32\16\2\u01bb"+
		"\u01bc\5\6\4\2\u01bc\21\3\2\2\2\u01bd\u01be\5B\"\2\u01be\u01bf\5\b\5\2"+
		"\u01bf\u01c0\5\4\3\2\u01c0\23\3\2\2\2\u01c1\u01c2\5\4\3\2\u01c2\25\3\2"+
		"\2\2\u01c3\u01c4\5\32\16\2\u01c4\u01c5\5\b\5\2\u01c5\u01c6\5\4\3\2\u01c6"+
		"\27\3\2\2\2\u01c7\u01c8\5\4\3\2\u01c8\31\3\2\2\2\u01c9\u01ce\5\36\20\2"+
		"\u01ca\u01ce\5N(\2\u01cb\u01ce\5L\'\2\u01cc\u01ce\5B\"\2\u01cd\u01c9\3"+
		"\2\2\2\u01cd\u01ca\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce"+
		"\33\3\2\2\2\u01cf\u01d0\5\36\20\2\u01d0\u01d4\7F\2\2\u01d1\u01d2\5\36"+
		"\20\2\u01d2\u01d3\7F\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\5\36\20\2\u01d7\u01da\3"+
		"\2\2\2\u01d8\u01da\5.\30\2\u01d9\u01cf\3\2\2\2\u01d9\u01d8\3\2\2\2\u01da"+
		"\35\3\2\2\2\u01db\u01df\b\20\1\2\u01dc\u01de\7N\2\2\u01dd\u01dc\3\2\2"+
		"\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2"+
		"\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01e3\7\25\2\2\u01e3\u0207\5\36\20"+
		"\r\u01e4\u01e6\7N\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5"+
		"\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea"+
		"\u01eb\7\67\2\2\u01eb\u01ec\5\36\20\2\u01ec\u01f0\78\2\2\u01ed\u01ef\7"+
		"N\2\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0"+
		"\u01f1\3\2\2\2\u01f1\u0207\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u0207\5."+
		"\30\2\u01f4\u0207\5\60\31\2\u01f5\u0207\5&\24\2\u01f6\u01f8\7N\2\2\u01f7"+
		"\u01f6\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2\2\2\u01f9\u01fa\3\2"+
		"\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u0200\7\22\2\2\u01fd"+
		"\u01ff\7N\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2"+
		"\2\2\u0200\u0201\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0203"+
		"\u0205\5\6\4\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2"+
		"\2\2\u0206\u01db\3\2\2\2\u0206\u01e7\3\2\2\2\u0206\u01f3\3\2\2\2\u0206"+
		"\u01f4\3\2\2\2\u0206\u01f5\3\2\2\2\u0206\u01f9\3\2\2\2\u0207\u0223\3\2"+
		"\2\2\u0208\u0209\f\f\2\2\u0209\u020a\t\4\2\2\u020a\u0222\5\36\20\r\u020b"+
		"\u020c\f\13\2\2\u020c\u020d\5\"\22\2\u020d\u020e\5\36\20\f\u020e\u0222"+
		"\3\2\2\2\u020f\u0210\f\n\2\2\u0210\u0211\5 \21\2\u0211\u0212\5\36\20\13"+
		"\u0212\u0222\3\2\2\2\u0213\u0214\f\t\2\2\u0214\u0215\5$\23\2\u0215\u0216"+
		"\5\36\20\n\u0216\u0222\3\2\2\2\u0217\u0218\f\3\2\2\u0218\u021c\7F\2\2"+
		"\u0219\u021a\5\36\20\2\u021a\u021b\7F\2\2\u021b\u021d\3\2\2\2\u021c\u0219"+
		"\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u0222\5\36\20\4"+
		"\u021f\u0220\f\16\2\2\u0220\u0222\t\5\2\2\u0221\u0208\3\2\2\2\u0221\u020b"+
		"\3\2\2\2\u0221\u020f\3\2\2\2\u0221\u0213\3\2\2\2\u0221\u0217\3\2\2\2\u0221"+
		"\u021f\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224\37\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0227\t\6\2\2\u0227!\3"+
		"\2\2\2\u0228\u0229\t\7\2\2\u0229#\3\2\2\2\u022a\u022b\t\b\2\2\u022b%\3"+
		"\2\2\2\u022c\u022e\7N\2\2\u022d\u022c\3\2\2\2\u022e\u0231\3\2\2\2\u022f"+
		"\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0232\3\2\2\2\u0231\u022f\3\2"+
		"\2\2\u0232\u0236\5(\25\2\u0233\u0235\7N\2\2\u0234\u0233\3\2\2\2\u0235"+
		"\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0254\3\2"+
		"\2\2\u0238\u0236\3\2\2\2\u0239\u023b\7N\2\2\u023a\u0239\3\2\2\2\u023b"+
		"\u023e\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023f\3\2"+
		"\2\2\u023e\u023c\3\2\2\2\u023f\u0243\5*\26\2\u0240\u0242\7N\2\2\u0241"+
		"\u0240\3\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2"+
		"\2\2\u0244\u0254\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0248\7N\2\2\u0247"+
		"\u0246\3\2\2\2\u0248\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2"+
		"\2\2\u024a\u024c\3\2\2\2\u024b\u0249\3\2\2\2\u024c\u0250\5,\27\2\u024d"+
		"\u024f\7N\2\2\u024e\u024d\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2"+
		"\2\2\u0250\u0251\3\2\2\2\u0251\u0254\3\2\2\2\u0252\u0250\3\2\2\2\u0253"+
		"\u022f\3\2\2\2\u0253\u023c\3\2\2\2\u0253\u0249\3\2\2\2\u0254\'\3\2\2\2"+
		"\u0255\u0256\7B\2\2\u0256)\3\2\2\2\u0257\u0258\7C\2\2\u0258+\3\2\2\2\u0259"+
		"\u025a\b\27\1\2\u025a\u025f\7D\2\2\u025b\u025c\7H\2\2\u025c\u025e\7D\2"+
		"\2\u025d\u025b\3\2\2\2\u025e\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260"+
		"\3\2\2\2\u0260\u028e\3\2\2\2\u0261\u025f\3\2\2\2\u0262\u0266\t\t\2\2\u0263"+
		"\u0265\7N\2\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264\3\2"+
		"\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026d\7\67\2\2\u026a\u026c\7N\2\2\u026b\u026a\3\2\2\2\u026c\u026f\3\2"+
		"\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0280\3\2\2\2\u026f"+
		"\u026d\3\2\2\2\u0270\u0274\5\64\33\2\u0271\u0273\7N\2\2\u0272\u0271\3"+
		"\2\2\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0277\3\2\2\2\u0276\u0274\3\2\2\2\u0277\u027b\7E\2\2\u0278\u027a\7N\2"+
		"\2\u0279\u0278\3\2\2\2\u027a\u027d\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027c"+
		"\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027e\u0270\3\2\2\2\u027f"+
		"\u0282\3\2\2\2\u0280\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0284\3\2"+
		"\2\2\u0282\u0280\3\2\2\2\u0283\u0285\5\64\33\2\u0284\u0283\3\2\2\2\u0284"+
		"\u0285\3\2\2\2\u0285\u0289\3\2\2\2\u0286\u0288\7N\2\2\u0287\u0286\3\2"+
		"\2\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u028c\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u028e\78\2\2\u028d\u0259\3\2"+
		"\2\2\u028d\u0262\3\2\2\2\u028e\u02e7\3\2\2\2\u028f\u0293\f\5\2\2\u0290"+
		"\u0292\7N\2\2\u0291\u0290\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2"+
		"\2\2\u0293\u0294\3\2\2\2\u0294\u0296\3\2\2\2\u0295\u0293\3\2\2\2\u0296"+
		"\u029a\7\67\2\2\u0297\u0299\7N\2\2\u0298\u0297\3\2\2\2\u0299\u029c\3\2"+
		"\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u02ad\3\2\2\2\u029c"+
		"\u029a\3\2\2\2\u029d\u02a1\5\64\33\2\u029e\u02a0\7N\2\2\u029f\u029e\3"+
		"\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2"+
		"\u02a4\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a8\7E\2\2\u02a5\u02a7\7N\2"+
		"\2\u02a6\u02a5\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9"+
		"\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u029d\3\2\2\2\u02ac"+
		"\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b1\3\2"+
		"\2\2\u02af\u02ad\3\2\2\2\u02b0\u02b2\5\64\33\2\u02b1\u02b0\3\2\2\2\u02b1"+
		"\u02b2\3\2\2\2\u02b2\u02b6\3\2\2\2\u02b3\u02b5\7N\2\2\u02b4\u02b3\3\2"+
		"\2\2\u02b5\u02b8\3\2\2\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7"+
		"\u02b9\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b9\u02e6\78\2\2\u02ba\u02be\f\4"+
		"\2\2\u02bb\u02bd\7N\2\2\u02bc\u02bb\3\2\2\2\u02bd\u02c0\3\2\2\2\u02be"+
		"\u02bc\3\2\2\2\u02be\u02bf\3\2\2\2\u02bf\u02c1\3\2\2\2\u02c0\u02be\3\2"+
		"\2\2\u02c1\u02c5\7;\2\2\u02c2\u02c4\7N\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c7"+
		"\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02d8\3\2\2\2\u02c7"+
		"\u02c5\3\2\2\2\u02c8\u02cc\5\64\33\2\u02c9\u02cb\7N\2\2\u02ca\u02c9\3"+
		"\2\2\2\u02cb\u02ce\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd"+
		"\u02cf\3\2\2\2\u02ce\u02cc\3\2\2\2\u02cf\u02d3\7E\2\2\u02d0\u02d2\7N\2"+
		"\2\u02d1\u02d0\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d3\u02d4"+
		"\3\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d6\u02c8\3\2\2\2\u02d7"+
		"\u02da\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02dc\3\2"+
		"\2\2\u02da\u02d8\3\2\2\2\u02db\u02dd\5\64\33\2\u02dc\u02db\3\2\2\2\u02dc"+
		"\u02dd\3\2\2\2\u02dd\u02e1\3\2\2\2\u02de\u02e0\7N\2\2\u02df\u02de\3\2"+
		"\2\2\u02e0\u02e3\3\2\2\2\u02e1\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2"+
		"\u02e4\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e4\u02e6\7<\2\2\u02e5\u028f\3\2"+
		"\2\2\u02e5\u02ba\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7"+
		"\u02e8\3\2\2\2\u02e8-\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02ec\7N\2\2\u02eb"+
		"\u02ea\3\2\2\2\u02ec\u02ef\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2"+
		"\2\2\u02ee\u02f0\3\2\2\2\u02ef\u02ed\3\2\2\2\u02f0\u02f4\79\2\2\u02f1"+
		"\u02f3\7N\2\2\u02f2\u02f1\3\2\2\2\u02f3\u02f6\3\2\2\2\u02f4\u02f2\3\2"+
		"\2\2\u02f4\u02f5\3\2\2\2\u02f5\u0313\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f7"+
		"\u02fb\5\62\32\2\u02f8\u02fa\7N\2\2\u02f9\u02f8\3\2\2\2\u02fa\u02fd\3"+
		"\2\2\2\u02fb\u02f9\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fe\3\2\2\2\u02fd"+
		"\u02fb\3\2\2\2\u02fe\u0302\7G\2\2\u02ff\u0301\7N\2\2\u0300\u02ff\3\2\2"+
		"\2\u0301\u0304\3\2\2\2\u0302\u0300\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0308"+
		"\3\2\2\2\u0304\u0302\3\2\2\2\u0305\u0307\7\3\2\2\u0306\u0305\3\2\2\2\u0307"+
		"\u030a\3\2\2\2\u0308\u0306\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030e\3\2"+
		"\2\2\u030a\u0308\3\2\2\2\u030b\u030d\7N\2\2\u030c\u030b\3\2\2\2\u030d"+
		"\u0310\3\2\2\2\u030e\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0312\3\2"+
		"\2\2\u0310\u030e\3\2\2\2\u0311\u02f7\3\2\2\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0311\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0316\3\2\2\2\u0315\u0313\3\2"+
		"\2\2\u0316\u031a\5\62\32\2\u0317\u0319\7N\2\2\u0318\u0317\3\2\2\2\u0319"+
		"\u031c\3\2\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031b\u031d\3\2"+
		"\2\2\u031c\u031a\3\2\2\2\u031d\u0321\7:\2\2\u031e\u0320\7N\2\2\u031f\u031e"+
		"\3\2\2\2\u0320\u0323\3\2\2\2\u0321\u031f\3\2\2\2\u0321\u0322\3\2\2\2\u0322"+
		"/\3\2\2\2\u0323\u0321\3\2\2\2\u0324\u0326\7N\2\2\u0325\u0324\3\2\2\2\u0326"+
		"\u0329\3\2\2\2\u0327\u0325\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u032a\3\2"+
		"\2\2\u0329\u0327\3\2\2\2\u032a\u032e\7;\2\2\u032b\u032d\7N\2\2\u032c\u032b"+
		"\3\2\2\2\u032d\u0330\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2\2\2\u032f"+
		"\u0341\3\2\2\2\u0330\u032e\3\2\2\2\u0331\u0335\5\62\32\2\u0332\u0334\7"+
		"N\2\2\u0333\u0332\3\2\2\2\u0334\u0337\3\2\2\2\u0335\u0333\3\2\2\2\u0335"+
		"\u0336\3\2\2\2\u0336\u0338\3\2\2\2\u0337\u0335\3\2\2\2\u0338\u033c\7G"+
		"\2\2\u0339\u033b\7N\2\2\u033a\u0339\3\2\2\2\u033b\u033e\3\2\2\2\u033c"+
		"\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2"+
		"\2\2\u033f\u0331\3\2\2\2\u0340\u0343\3\2\2\2\u0341\u033f\3\2\2\2\u0341"+
		"\u0342\3\2\2\2\u0342\u0344\3\2\2\2\u0343\u0341\3\2\2\2\u0344\u0348\5\62"+
		"\32\2\u0345\u0347\7N\2\2\u0346\u0345\3\2\2\2\u0347\u034a\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034b\3\2\2\2\u034a\u0348\3\2"+
		"\2\2\u034b\u034f\7<\2\2\u034c\u034e\7N\2\2\u034d\u034c\3\2\2\2\u034e\u0351"+
		"\3\2\2\2\u034f\u034d\3\2\2\2\u034f\u0350\3\2\2\2\u0350\61\3\2\2\2\u0351"+
		"\u034f\3\2\2\2\u0352\u0354\5\32\16\2\u0353\u0355\t\n\2\2\u0354\u0353\3"+
		"\2\2\2\u0355\u0356\3\2\2\2\u0356\u0354\3\2\2\2\u0356\u0357\3\2\2\2\u0357"+
		"\u0359\3\2\2\2\u0358\u0352\3\2\2\2\u0359\u035c\3\2\2\2\u035a\u0358\3\2"+
		"\2\2\u035a\u035b\3\2\2\2\u035b\u035e\3\2\2\2\u035c\u035a\3\2\2\2\u035d"+
		"\u035f\5\32\16\2\u035e\u035d\3\2\2\2\u035e\u035f\3\2\2\2\u035f\63\3\2"+
		"\2\2\u0360\u0366\5\32\16\2\u0361\u0366\7F\2\2\u0362\u0366\5R*\2\u0363"+
		"\u0366\5\66\34\2\u0364\u0366\7=\2\2\u0365\u0360\3\2\2\2\u0365\u0361\3"+
		"\2\2\2\u0365\u0362\3\2\2\2\u0365\u0363\3\2\2\2\u0365\u0364\3\2\2\2\u0366"+
		"\65\3\2\2\2\u0367\u036b\58\35\2\u0368\u036a\7N\2\2\u0369\u0368\3\2\2\2"+
		"\u036a\u036d\3\2\2\2\u036b\u0369\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036e"+
		"\3\2\2\2\u036d\u036b\3\2\2\2\u036e\u0372\7F\2\2\u036f\u0371\7N\2\2\u0370"+
		"\u036f\3\2\2\2\u0371\u0374\3\2\2\2\u0372\u0370\3\2\2\2\u0372\u0373\3\2"+
		"\2\2\u0373\u0383\3\2\2\2\u0374\u0372\3\2\2\2\u0375\u0379\5:\36\2\u0376"+
		"\u0378\7N\2\2\u0377\u0376\3\2\2\2\u0378\u037b\3\2\2\2\u0379\u0377\3\2"+
		"\2\2\u0379\u037a\3\2\2\2\u037a\u037c\3\2\2\2\u037b\u0379\3\2\2\2\u037c"+
		"\u0380\7F\2\2\u037d\u037f\7N\2\2\u037e\u037d\3\2\2\2\u037f\u0382\3\2\2"+
		"\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381\u0384\3\2\2\2\u0382\u0380"+
		"\3\2\2\2\u0383\u0375\3\2\2\2\u0383\u0384\3\2\2\2\u0384\u0385\3\2\2\2\u0385"+
		"\u0386\5<\37\2\u0386\67\3\2\2\2\u0387\u038a\7=\2\2\u0388\u038a\5\32\16"+
		"\2\u0389\u0387\3\2\2\2\u0389\u0388\3\2\2\2\u038a9\3\2\2\2\u038b\u038c"+
		"\5\32\16\2\u038c;\3\2\2\2\u038d\u0390\7=\2\2\u038e\u0390\5\32\16\2\u038f"+
		"\u038d\3\2\2\2\u038f\u038e\3\2\2\2\u0390=\3\2\2\2\u0391\u0393\7N\2\2\u0392"+
		"\u0391\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2\2\u0394\u0395\3\2"+
		"\2\2\u0395\u0397\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u039b\7D\2\2\u0398"+
		"\u039a\7N\2\2\u0399\u0398\3\2\2\2\u039a\u039d\3\2\2\2\u039b\u0399\3\2"+
		"\2\2\u039b\u039c\3\2\2\2\u039c\u039e\3\2\2\2\u039d\u039b\3\2\2\2\u039e"+
		"\u03b5\7\67\2\2\u039f\u03a1\7N\2\2\u03a0\u039f\3\2\2\2\u03a1\u03a4\3\2"+
		"\2\2\u03a2\u03a0\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a5\3\2\2\2\u03a4"+
		"\u03a2\3\2\2\2\u03a5\u03a9\7D\2\2\u03a6\u03a8\7N\2\2\u03a7\u03a6\3\2\2"+
		"\2\u03a8\u03ab\3\2\2\2\u03a9\u03a7\3\2\2\2\u03a9\u03aa\3\2\2\2\u03aa\u03ac"+
		"\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ac\u03b0\7E\2\2\u03ad\u03af\7N\2\2\u03ae"+
		"\u03ad\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b0\u03b1\3\2"+
		"\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3\u03a2\3\2\2\2\u03b4"+
		"\u03b7\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03c5\3\2"+
		"\2\2\u03b7\u03b5\3\2\2\2\u03b8\u03ba\7N\2\2\u03b9\u03b8\3\2\2\2\u03ba"+
		"\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03be\3\2"+
		"\2\2\u03bd\u03bb\3\2\2\2\u03be\u03c2\7D\2\2\u03bf\u03c1\7N\2\2\u03c0\u03bf"+
		"\3\2\2\2\u03c1\u03c4\3\2\2\2\u03c2\u03c0\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3"+
		"\u03c6\3\2\2\2\u03c4\u03c2\3\2\2\2\u03c5\u03bb\3\2\2\2\u03c5\u03c6\3\2"+
		"\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03cb\78\2\2\u03c8\u03ca\7N\2\2\u03c9\u03c8"+
		"\3\2\2\2\u03ca\u03cd\3\2\2\2\u03cb\u03c9\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc"+
		"?\3\2\2\2\u03cd\u03cb\3\2\2\2\u03ce\u03d0\7N\2\2\u03cf\u03ce\3\2\2\2\u03d0"+
		"\u03d3\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d6\3\2"+
		"\2\2\u03d3\u03d1\3\2\2\2\u03d4\u03d7\5,\27\2\u03d5\u03d7\5.\30\2\u03d6"+
		"\u03d4\3\2\2\2\u03d6\u03d5\3\2\2\2\u03d7\u03db\3\2\2\2\u03d8\u03da\7N"+
		"\2\2\u03d9\u03d8\3\2\2\2\u03da\u03dd\3\2\2\2\u03db\u03d9\3\2\2\2\u03db"+
		"\u03dc\3\2\2\2\u03dcA\3\2\2\2\u03dd\u03db\3\2\2\2\u03de\u03df\b\"\1\2"+
		"\u03df\u0406\5D#\2\u03e0\u03e2\7N\2\2\u03e1\u03e0\3\2\2\2\u03e2\u03e5"+
		"\3\2\2\2\u03e3\u03e1\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e6\3\2\2\2\u03e5"+
		"\u03e3\3\2\2\2\u03e6\u03e7\7\"\2\2\u03e7\u0406\5B\"\6\u03e8\u03ea\7N\2"+
		"\2\u03e9\u03e8\3\2\2\2\u03ea\u03ed\3\2\2\2\u03eb\u03e9\3\2\2\2\u03eb\u03ec"+
		"\3\2\2\2\u03ec\u03ee\3\2\2\2\u03ed\u03eb\3\2\2\2\u03ee\u03ef\7\67\2\2"+
		"\u03ef\u03f0\5B\"\2\u03f0\u03f4\78\2\2\u03f1\u03f3\7N\2\2\u03f2\u03f1"+
		"\3\2\2\2\u03f3\u03f6\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5"+
		"\u0406\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f7\u0406\5J&\2\u03f8\u03fa\7N\2"+
		"\2\u03f9\u03f8\3\2\2\2\u03fa\u03fd\3\2\2\2\u03fb\u03f9\3\2\2\2\u03fb\u03fc"+
		"\3\2\2\2\u03fc\u03fe\3\2\2\2\u03fd\u03fb\3\2\2\2\u03fe\u0402\5,\27\2\u03ff"+
		"\u0401\7N\2\2\u0400\u03ff\3\2\2\2\u0401\u0404\3\2\2\2\u0402\u0400\3\2"+
		"\2\2\u0402\u0403\3\2\2\2\u0403\u0406\3\2\2\2\u0404\u0402\3\2\2\2\u0405"+
		"\u03de\3\2\2\2\u0405\u03e3\3\2\2\2\u0405\u03eb\3\2\2\2\u0405\u03f7\3\2"+
		"\2\2\u0405\u03fb\3\2\2\2\u0406\u0413\3\2\2\2\u0407\u0408\f\t\2\2\u0408"+
		"\u0409\7 \2\2\u0409\u0412\5B\"\n\u040a\u040b\f\b\2\2\u040b\u040c\7!\2"+
		"\2\u040c\u0412\5B\"\t\u040d\u040e\f\7\2\2\u040e\u040f\5$\23\2\u040f\u0410"+
		"\5B\"\b\u0410\u0412\3\2\2\2\u0411\u0407\3\2\2\2\u0411\u040a\3\2\2\2\u0411"+
		"\u040d\3\2\2\2\u0412\u0415\3\2\2\2\u0413\u0411\3\2\2\2\u0413\u0414\3\2"+
		"\2\2\u0414C\3\2\2\2\u0415\u0413\3\2\2\2\u0416\u0417\5\36\20\2\u0417\u0418"+
		"\5H%\2\u0418\u0419\5\36\20\2\u0419\u041f\3\2\2\2\u041a\u041b\5N(\2\u041b"+
		"\u041c\5F$\2\u041c\u041d\5N(\2\u041d\u041f\3\2\2\2\u041e\u0416\3\2\2\2"+
		"\u041e\u041a\3\2\2\2\u041fE\3\2\2\2\u0420\u0421\t\13\2\2\u0421G\3\2\2"+
		"\2\u0422\u0423\t\f\2\2\u0423I\3\2\2\2\u0424\u0426\7N\2\2\u0425\u0424\3"+
		"\2\2\2\u0426\u0429\3\2\2\2\u0427\u0425\3\2\2\2\u0427\u0428\3\2\2\2\u0428"+
		"\u042a\3\2\2\2\u0429\u0427\3\2\2\2\u042a\u042e\7#\2\2\u042b\u042d\7N\2"+
		"\2\u042c\u042b\3\2\2\2\u042d\u0430\3\2\2\2\u042e\u042c\3\2\2\2\u042e\u042f"+
		"\3\2\2\2\u042f\u043f\3\2\2\2\u0430\u042e\3\2\2\2\u0431\u0433\7N\2\2\u0432"+
		"\u0431\3\2\2\2\u0433\u0436\3\2\2\2\u0434\u0432\3\2\2\2\u0434\u0435\3\2"+
		"\2\2\u0435\u0437\3\2\2\2\u0436\u0434\3\2\2\2\u0437\u043b\7$\2\2\u0438"+
		"\u043a\7N\2\2\u0439\u0438\3\2\2\2\u043a\u043d\3\2\2\2\u043b\u0439\3\2"+
		"\2\2\u043b\u043c\3\2\2\2\u043c\u043f\3\2\2\2\u043d\u043b\3\2\2\2\u043e"+
		"\u0427\3\2\2\2\u043e\u0434\3\2\2\2\u043fK\3\2\2\2\u0440\u0442\7N\2\2\u0441"+
		"\u0440\3\2\2\2\u0442\u0445\3\2\2\2\u0443\u0441\3\2\2\2\u0443\u0444\3\2"+
		"\2\2\u0444\u0446\3\2\2\2\u0445\u0443\3\2\2\2\u0446\u044a\5,\27\2\u0447"+
		"\u0449\7N\2\2\u0448\u0447\3\2\2\2\u0449\u044c\3\2\2\2\u044a\u0448\3\2"+
		"\2\2\u044a\u044b\3\2\2\2\u044b\u044d\3\2\2\2\u044c\u044a\3\2\2\2\u044d"+
		"\u044e\7\66\2\2\u044e\u044f\5\32\16\2\u044f\u04da\3\2\2\2\u0450\u0452"+
		"\7N\2\2\u0451\u0450\3\2\2\2\u0452\u0455\3\2\2\2\u0453\u0451\3\2\2\2\u0453"+
		"\u0454\3\2\2\2\u0454\u0456\3\2\2\2\u0455\u0453\3\2\2\2\u0456\u045a\79"+
		"\2\2\u0457\u0459\7N\2\2\u0458\u0457\3\2\2\2\u0459\u045c\3\2\2\2\u045a"+
		"\u0458\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u0474\3\2\2\2\u045c\u045a\3\2"+
		"\2\2\u045d\u0461\5,\27\2\u045e\u0460\7N\2\2\u045f\u045e\3\2\2\2\u0460"+
		"\u0463\3\2\2\2\u0461\u045f\3\2\2\2\u0461\u0462\3\2\2\2\u0462\u046a\3\2"+
		"\2\2\u0463\u0461\3\2\2\2\u0464\u046b\7E\2\2\u0465\u0467\7N\2\2\u0466\u0465"+
		"\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0466\3\2\2\2\u0468\u0469\3\2\2\2\u0469"+
		"\u046b\3\2\2\2\u046a\u0464\3\2\2\2\u046a\u0466\3\2\2\2\u046b\u046f\3\2"+
		"\2\2\u046c\u046e\7N\2\2\u046d\u046c\3\2\2\2\u046e\u0471\3\2\2\2\u046f"+
		"\u046d\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0473\3\2\2\2\u0471\u046f\3\2"+
		"\2\2\u0472\u045d\3\2\2\2\u0473\u0476\3\2\2\2\u0474\u0472\3\2\2\2\u0474"+
		"\u0475\3\2\2\2\u0475\u0478\3\2\2\2\u0476\u0474\3\2\2\2\u0477\u0479\5,"+
		"\27\2\u0478\u0477\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047d\3\2\2\2\u047a"+
		"\u047c\7N\2\2\u047b\u047a\3\2\2\2\u047c\u047f\3\2\2\2\u047d\u047b\3\2"+
		"\2\2\u047d\u047e\3\2\2\2\u047e\u0480\3\2\2\2\u047f\u047d\3\2\2\2\u0480"+
		"\u0484\7:\2\2\u0481\u0483\7N\2\2\u0482\u0481\3\2\2\2\u0483\u0486\3\2\2"+
		"\2\u0484\u0482\3\2\2\2\u0484\u0485\3\2\2\2\u0485\u0487\3\2\2\2\u0486\u0484"+
		"\3\2\2\2\u0487\u0488\7\66\2\2\u0488\u04da\5\32\16\2\u0489\u048b\7N\2\2"+
		"\u048a\u0489\3\2\2\2\u048b\u048e\3\2\2\2\u048c\u048a\3\2\2\2\u048c\u048d"+
		"\3\2\2\2\u048d\u048f\3\2\2\2\u048e\u048c\3\2\2\2\u048f\u0493\5,\27\2\u0490"+
		"\u0492\7N\2\2\u0491\u0490\3\2\2\2\u0492\u0495\3\2\2\2\u0493\u0491\3\2"+
		"\2\2\u0493\u0494\3\2\2\2\u0494\u0496\3\2\2\2\u0495\u0493\3\2\2\2\u0496"+
		"\u0497\7\63\2\2\u0497\u0498\5\32\16\2\u0498\u04da\3\2\2\2\u0499\u049b"+
		"\7N\2\2\u049a\u0499\3\2\2\2\u049b\u049e\3\2\2\2\u049c\u049a\3\2\2\2\u049c"+
		"\u049d\3\2\2\2\u049d\u049f\3\2\2\2\u049e\u049c\3\2\2\2\u049f\u04a3\5,"+
		"\27\2\u04a0\u04a2\7N\2\2\u04a1\u04a0\3\2\2\2\u04a2\u04a5\3\2\2\2\u04a3"+
		"\u04a1\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a6\3\2\2\2\u04a5\u04a3\3\2"+
		"\2\2\u04a6\u04a7\7\64\2\2\u04a7\u04a8\5\32\16\2\u04a8\u04da\3\2\2\2\u04a9"+
		"\u04ab\7N\2\2\u04aa\u04a9\3\2\2\2\u04ab\u04ae\3\2\2\2\u04ac\u04aa\3\2"+
		"\2\2\u04ac\u04ad\3\2\2\2\u04ad\u04af\3\2\2\2\u04ae\u04ac\3\2\2\2\u04af"+
		"\u04b3\5,\27\2\u04b0\u04b2\7N\2\2\u04b1\u04b0\3\2\2\2\u04b2\u04b5\3\2"+
		"\2\2\u04b3\u04b1\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b6\3\2\2\2\u04b5"+
		"\u04b3\3\2\2\2\u04b6\u04b7\7\65\2\2\u04b7\u04b8\5\32\16\2\u04b8\u04da"+
		"\3\2\2\2\u04b9\u04bb\7N\2\2\u04ba\u04b9\3\2\2\2\u04bb\u04be\3\2\2\2\u04bc"+
		"\u04ba\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u04bf\3\2\2\2\u04be\u04bc\3\2"+
		"\2\2\u04bf\u04c3\5,\27\2\u04c0\u04c2\7N\2\2\u04c1\u04c0\3\2\2\2\u04c2"+
		"\u04c5\3\2\2\2\u04c3\u04c1\3\2\2\2\u04c3\u04c4\3\2\2\2\u04c4\u04c6\3\2"+
		"\2\2\u04c5\u04c3\3\2\2\2\u04c6\u04c7\7\61\2\2\u04c7\u04c8\5\32\16\2\u04c8"+
		"\u04da\3\2\2\2\u04c9\u04cb\7N\2\2\u04ca\u04c9\3\2\2\2\u04cb\u04ce\3\2"+
		"\2\2\u04cc\u04ca\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04cf\3\2\2\2\u04ce"+
		"\u04cc\3\2\2\2\u04cf\u04d3\5,\27\2\u04d0\u04d2\7N\2\2\u04d1\u04d0\3\2"+
		"\2\2\u04d2\u04d5\3\2\2\2\u04d3\u04d1\3\2\2\2\u04d3\u04d4\3\2\2\2\u04d4"+
		"\u04d6\3\2\2\2\u04d5\u04d3\3\2\2\2\u04d6\u04d7\7\62\2\2\u04d7\u04d8\5"+
		"\32\16\2\u04d8\u04da\3\2\2\2\u04d9\u0443\3\2\2\2\u04d9\u0453\3\2\2\2\u04d9"+
		"\u048c\3\2\2\2\u04d9\u049c\3\2\2\2\u04d9\u04ac\3\2\2\2\u04d9\u04bc\3\2"+
		"\2\2\u04d9\u04cc\3\2\2\2\u04daM\3\2\2\2\u04db\u04dd\7N\2\2\u04dc\u04db"+
		"\3\2\2\2\u04dd\u04e0\3\2\2\2\u04de\u04dc\3\2\2\2\u04de\u04df\3\2\2\2\u04df"+
		"\u04e1\3\2\2\2\u04e0\u04de\3\2\2\2\u04e1\u04e5\5P)\2\u04e2\u04e4\7N\2"+
		"\2\u04e3\u04e2\3\2\2\2\u04e4\u04e7\3\2\2\2\u04e5\u04e3\3\2\2\2\u04e5\u04e6"+
		"\3\2\2\2\u04e6\u04e8\3\2\2\2\u04e7\u04e5\3\2\2\2\u04e8\u04ec\7\24\2\2"+
		"\u04e9\u04eb\7N\2\2\u04ea\u04e9\3\2\2\2\u04eb\u04ee\3\2\2\2\u04ec\u04ea"+
		"\3\2\2\2\u04ec\u04ed\3\2\2\2\u04ed\u04ef\3\2\2\2\u04ee\u04ec\3\2\2\2\u04ef"+
		"\u04f3\5P)\2\u04f0\u04f2\7N\2\2\u04f1\u04f0\3\2\2\2\u04f2\u04f5\3\2\2"+
		"\2\u04f3\u04f1\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u0504\3\2\2\2\u04f5\u04f3"+
		"\3\2\2\2\u04f6\u04f8\7N\2\2\u04f7\u04f6\3\2\2\2\u04f8\u04fb\3\2\2\2\u04f9"+
		"\u04f7\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa\u04fc\3\2\2\2\u04fb\u04f9\3\2"+
		"\2\2\u04fc\u0500\5P)\2\u04fd\u04ff\7N\2\2\u04fe\u04fd\3\2\2\2\u04ff\u0502"+
		"\3\2\2\2\u0500\u04fe\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u0504\3\2\2\2\u0502"+
		"\u0500\3\2\2\2\u0503\u04de\3\2\2\2\u0503\u04f9\3\2\2\2\u0504O\3\2\2\2"+
		"\u0505\u0514\7O\2\2\u0506\u0508\7N\2\2\u0507\u0506\3\2\2\2\u0508\u050b"+
		"\3\2\2\2\u0509\u0507\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050c\3\2\2\2\u050b"+
		"\u0509\3\2\2\2\u050c\u0510\5,\27\2\u050d\u050f\7N\2\2\u050e\u050d\3\2"+
		"\2\2\u050f\u0512\3\2\2\2\u0510\u050e\3\2\2\2\u0510\u0511\3\2\2\2\u0511"+
		"\u0514\3\2\2\2\u0512\u0510\3\2\2\2\u0513\u0505\3\2\2\2\u0513\u0509\3\2"+
		"\2\2\u0514Q\3\2\2\2\u0515\u0516\7\23\2\2\u0516\u0517\7D\2\2\u0517S\3\2"+
		"\2\2\u00c6V[`bgnt{\u0080\u0082\u0087\u008e\u0094\u009b\u00a1\u00a8\u00ad"+
		"\u00af\u00b5\u00ba\u00bf\u00c3\u00c8\u00cf\u00d8\u00dc\u00df\u00e4\u00ec"+
		"\u00f4\u00fa\u0101\u0105\u0108\u010d\u0114\u0118\u011d\u0124\u012b\u0132"+
		"\u013c\u0140\u0145\u0150\u0154\u0159\u015e\u0161\u0166\u016c\u0175\u017d"+
		"\u0183\u018a\u018e\u0191\u0196\u019d\u01a1\u01a6\u01ad\u01b2\u01b4\u01cd"+
		"\u01d4\u01d9\u01df\u01e7\u01f0\u01f9\u0200\u0204\u0206\u021c\u0221\u0223"+
		"\u022f\u0236\u023c\u0243\u0249\u0250\u0253\u025f\u0266\u026d\u0274\u027b"+
		"\u0280\u0284\u0289\u028d\u0293\u029a\u02a1\u02a8\u02ad\u02b1\u02b6\u02be"+
		"\u02c5\u02cc\u02d3\u02d8\u02dc\u02e1\u02e5\u02e7\u02ed\u02f4\u02fb\u0302"+
		"\u0308\u030e\u0313\u031a\u0321\u0327\u032e\u0335\u033c\u0341\u0348\u034f"+
		"\u0356\u035a\u035e\u0365\u036b\u0372\u0379\u0380\u0383\u0389\u038f\u0394"+
		"\u039b\u03a2\u03a9\u03b0\u03b5\u03bb\u03c2\u03c5\u03cb\u03d1\u03d6\u03db"+
		"\u03e3\u03eb\u03f4\u03fb\u0402\u0405\u0411\u0413\u041e\u0427\u042e\u0434"+
		"\u043b\u043e\u0443\u044a\u0453\u045a\u0461\u0468\u046a\u046f\u0474\u0478"+
		"\u047d\u0484\u048c\u0493\u049c\u04a3\u04ac\u04b3\u04bc\u04c3\u04cc\u04d3"+
		"\u04d9\u04de\u04e5\u04ec\u04f3\u04f9\u0500\u0503\u0509\u0510\u0513";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}