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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ADD=9, 
		SUB=10, MUL=11, DIV=12, REM=13, POW=14, AND=15, OR=16, NOT=17, TRUE=18, 
		FALSE=19, GT=20, GE=21, LT=22, LE=23, EQ=24, NEQ=25, BAND=26, BOR=27, 
		BXOR=28, BNOT=29, SHL=30, SHR=31, USHR=32, INC=33, DESC=34, ADD_ASSIGN=35, 
		SUB_ASSIGN=36, MUL_ASSIGN=37, DIV_ASSIGN=38, REM_ASSIGN=39, ASSIGN=40, 
		LPAREN=41, RPAREN=42, LBRK=43, RBRK=44, LCB=45, RCB=46, INTEGER=47, FLOAT=48, 
		IDENTIFIER=49, COMMA=50, COLON=51, SEMI=52, PERIOD=53, SQUOTE=54, DQUOTE=55, 
		COMMENT=56, WS=57, StringLiteral=58;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_expression = 4, RULE_assign_expr = 5, RULE_logical_expr = 6, RULE_comparison_expr = 7, 
		RULE_comp_operator = 8, RULE_arithmetic_expr = 9, RULE_string_expr = 10, 
		RULE_numeric_entity = 11, RULE_integer_entity = 12, RULE_float_entity = 13, 
		RULE_index_entity = 14, RULE_variable_entity = 15, RULE_array_index = 16, 
		RULE_logical_entity = 17, RULE_expr_end = 18, RULE_string_entity = 19, 
		RULE_array_init = 20, RULE_array_gen = 21, RULE_func_call = 22, RULE_list_comprehension = 23, 
		RULE_list_comp_for_if = 24, RULE_list_comp_for = 25, RULE_list_comp_if = 26;
	public static final String[] ruleNames = {
		"prog", "statements", "statement", "block", "expression", "assign_expr", 
		"logical_expr", "comparison_expr", "comp_operator", "arithmetic_expr", 
		"string_expr", "numeric_entity", "integer_entity", "float_entity", "index_entity", 
		"variable_entity", "array_index", "logical_entity", "expr_end", "string_entity", 
		"array_init", "array_gen", "func_call", "list_comprehension", "list_comp_for_if", 
		"list_comp_for", "list_comp_if"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'def'", "'sum'", "'\n'", 
		"'in'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", null, null, null, "'true'", 
		"'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", 
		"'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", 
		"'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "ADD", "SUB", "MUL", 
		"DIV", "REM", "POW", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
		"USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", 
		"INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", 
		"SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral"
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
			setState(54);
			statements();
			setState(55);
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
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57);
					statement();
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(67);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(63);
				expression();
				setState(65);
				_la = _input.LA(1);
				if (_la==T__6 || _la==SEMI) {
					{
					setState(64);
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
	public static class FuncDefContext extends StatementContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ExprGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ExprGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(ExprGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ExprGrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExprGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExprGrammarParser.COMMA, i);
		}
		public FuncDefContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitFuncDef(this);
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ExprAssign2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				assign_expr();
				setState(70);
				expr_end();
				}
				break;
			case 2:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__0);
				setState(73);
				match(LPAREN);
				setState(74);
				logical_expr(0);
				setState(75);
				match(RPAREN);
				setState(76);
				block();
				setState(79);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(77);
					match(T__1);
					setState(78);
					block();
					}
				}

				}
				break;
			case 3:
				_localctx = new ExprWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(T__2);
				setState(82);
				match(LPAREN);
				setState(83);
				logical_expr(0);
				setState(84);
				match(RPAREN);
				setState(85);
				block();
				}
				break;
			case 4:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				match(T__3);
				setState(88);
				match(LPAREN);
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(89);
						assign_expr();
						setState(90);
						match(COMMA);
						}
						} 
					}
					setState(96);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(98);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(97);
					assign_expr();
					}
				}

				setState(100);
				match(SEMI);
				setState(101);
				logical_expr(0);
				setState(102);
				match(SEMI);
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(103);
						expression();
						setState(104);
						match(COMMA);
						}
						} 
					}
					setState(110);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(112);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
					{
					setState(111);
					expression();
					}
				}

				setState(114);
				match(RPAREN);
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(115);
					match(SEMI);
					}
					break;
				case 2:
					{
					setState(117);
					_la = _input.LA(1);
					if (_la==LCB) {
						{
						setState(116);
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
				setState(121);
				func_call();
				setState(122);
				expr_end();
				}
				break;
			case 6:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(T__4);
				setState(125);
				match(IDENTIFIER);
				setState(126);
				match(LPAREN);
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(127);
						match(IDENTIFIER);
						setState(128);
						match(COMMA);
						}
						} 
					}
					setState(133);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(135);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(134);
					match(IDENTIFIER);
					}
				}

				setState(137);
				match(RPAREN);
				setState(138);
				block();
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
		public List<Expr_endContext> expr_end() {
			return getRuleContexts(Expr_endContext.class);
		}
		public Expr_endContext expr_end(int i) {
			return getRuleContext(Expr_endContext.class,i);
		}
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
			int _alt;
			_localctx = new StatementBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(LCB);
			setState(142);
			statements();
			setState(143);
			match(RCB);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					expr_end();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class ExprSumContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<List_comp_for_ifContext> list_comp_for_if() {
			return getRuleContexts(List_comp_for_ifContext.class);
		}
		public List_comp_for_ifContext list_comp_for_if(int i) {
			return getRuleContext(List_comp_for_ifContext.class,i);
		}
		public ExprSumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprSum(this);
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
			int _alt;
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				logical_expr(0);
				}
				break;
			case 3:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				string_expr();
				}
				break;
			case 4:
				_localctx = new ExprAssign1Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				assign_expr();
				}
				break;
			case 5:
				_localctx = new ExprArrayInitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				array_init();
				}
				break;
			case 6:
				_localctx = new ListComprehensionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				list_comprehension();
				}
				break;
			case 7:
				_localctx = new ExprArrayGenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				array_gen();
				}
				break;
			case 8:
				_localctx = new ExprSumContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(157);
				match(T__5);
				setState(158);
				expression();
				setState(160); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(159);
						list_comp_for_if();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(162); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public List<Array_indexContext> array_index() {
			return getRuleContexts(Array_indexContext.class);
		}
		public Array_indexContext array_index(int i) {
			return getRuleContext(Array_indexContext.class,i);
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
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(IDENTIFIER);
				setState(167);
				match(ASSIGN);
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(168);
					expression();
					}
					break;
				case 2:
					{
					setState(169);
					statement();
					}
					break;
				case 3:
					{
					setState(170);
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
				setState(173);
				match(IDENTIFIER);
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					array_index();
					}
					}
					setState(177); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRK );
				setState(179);
				match(ASSIGN);
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(180);
					expression();
					}
					break;
				case 2:
					{
					setState(181);
					statement();
					}
					break;
				case 3:
					{
					setState(182);
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
				setState(185);
				variable_entity();
				setState(186);
				match(MUL_ASSIGN);
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(187);
					expression();
					}
					break;
				case 2:
					{
					setState(188);
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
				setState(191);
				variable_entity();
				setState(192);
				match(DIV_ASSIGN);
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(193);
					expression();
					}
					break;
				case 2:
					{
					setState(194);
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
				setState(197);
				variable_entity();
				setState(198);
				match(REM_ASSIGN);
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(199);
					expression();
					}
					break;
				case 2:
					{
					setState(200);
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
				setState(203);
				variable_entity();
				setState(204);
				match(ADD_ASSIGN);
				setState(207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(205);
					expression();
					}
					break;
				case 2:
					{
					setState(206);
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
				setState(209);
				variable_entity();
				setState(210);
				match(SUB_ASSIGN);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(211);
					expression();
					}
					break;
				case 2:
					{
					setState(212);
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
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(218);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(NOT);
				setState(220);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(LPAREN);
				setState(222);
				logical_expr(0);
				setState(223);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(234);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(228);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(229);
						match(AND);
						setState(230);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(231);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(232);
						match(OR);
						setState(233);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ComparisonArithmeticExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				arithmetic_expr(0);
				setState(240);
				comp_operator();
				setState(241);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ComparisonStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				string_expr();
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(245);
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
			setState(249);
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
	public static class ArithmeticExpressionPowContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode POW() { return getToken(ExprGrammarParser.POW, 0); }
		public ArithmeticExpressionPowContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArithmeticExpressionPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArithmeticExpressionPow(this);
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
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionIncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(252);
				match(IDENTIFIER);
				setState(253);
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
				setState(254);
				match(BNOT);
				setState(255);
				arithmetic_expr(17);
				}
				break;
			case 3:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(SUB);
				setState(257);
				arithmetic_expr(16);
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(LPAREN);
				setState(259);
				arithmetic_expr(0);
				setState(260);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				numeric_entity();
				}
				break;
			case 6:
				{
				_localctx = new FuncCall1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				func_call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(302);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionPowContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(266);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(267);
						match(POW);
						setState(268);
						arithmetic_expr(16);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(269);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(270);
						match(MUL);
						setState(271);
						arithmetic_expr(15);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(272);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(273);
						match(DIV);
						setState(274);
						arithmetic_expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(275);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(276);
						match(REM);
						setState(277);
						arithmetic_expr(13);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(278);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(279);
						match(ADD);
						setState(280);
						arithmetic_expr(12);
						}
						break;
					case 6:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(281);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(282);
						match(SUB);
						setState(283);
						arithmetic_expr(11);
						}
						break;
					case 7:
						{
						_localctx = new BitExpressionShlContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(284);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(285);
						match(SHL);
						setState(286);
						arithmetic_expr(10);
						}
						break;
					case 8:
						{
						_localctx = new BitExpressionShrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(287);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(288);
						match(SHR);
						setState(289);
						arithmetic_expr(9);
						}
						break;
					case 9:
						{
						_localctx = new BitExpressionUshrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(290);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(291);
						match(USHR);
						setState(292);
						arithmetic_expr(8);
						}
						break;
					case 10:
						{
						_localctx = new BitExpressionAndContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(293);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(294);
						match(BAND);
						setState(295);
						arithmetic_expr(7);
						}
						break;
					case 11:
						{
						_localctx = new BitExpressionOrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(296);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(297);
						match(BOR);
						setState(298);
						arithmetic_expr(6);
						}
						break;
					case 12:
						{
						_localctx = new BitExpressionXorContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(299);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(300);
						match(BXOR);
						setState(301);
						arithmetic_expr(5);
						}
						break;
					}
					} 
				}
				setState(306);
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
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new StringConcatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				string_entity();
				setState(308);
				match(ADD);
				setState(309);
				string_entity();
				}
				break;
			case 2:
				_localctx = new StringEntityContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
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
			setState(317);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				integer_entity();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				float_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
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
			setState(319);
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
			setState(321);
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
			setState(325);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				integer_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
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
		public List<Array_indexContext> array_index() {
			return getRuleContexts(Array_indexContext.class);
		}
		public Array_indexContext array_index(int i) {
			return getRuleContext(Array_indexContext.class,i);
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
		try {
			int _alt;
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new EntityArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(IDENTIFIER);
				setState(330); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(329);
						array_index();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(332); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class Array_indexContext extends ParserRuleContext {
		public TerminalNode LBRK() { return getToken(ExprGrammarParser.LBRK, 0); }
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public TerminalNode RBRK() { return getToken(ExprGrammarParser.RBRK, 0); }
		public TerminalNode COLON() { return getToken(ExprGrammarParser.COLON, 0); }
		public Array_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterArray_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitArray_index(this);
		}
	}

	public final Array_indexContext array_index() throws RecognitionException {
		Array_indexContext _localctx = new Array_indexContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_index);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(LBRK);
			setState(337);
			arithmetic_expr(0);
			setState(340);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(338);
				match(COLON);
				setState(339);
				arithmetic_expr(0);
				}
			}

			setState(342);
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
		enterRule(_localctx, 34, RULE_logical_entity);
		int _la;
		try {
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
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
		enterRule(_localctx, 36, RULE_expr_end);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(346);
					_la = _input.LA(1);
					if ( !(_la==T__6 || _la==SEMI) ) {
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
				setState(349); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 38, RULE_string_entity);
		try {
			setState(353);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(StringLiteral);
				}
				break;
			case IDENTIFIER:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
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
		enterRule(_localctx, 40, RULE_array_init);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(LBRK);
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(364);
				expression();
				}
			}

			setState(367);
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
		enterRule(_localctx, 42, RULE_array_gen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			arithmetic_expr(0);
			setState(370);
			match(COLON);
			setState(371);
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
		enterRule(_localctx, 44, RULE_func_call);
		int _la;
		try {
			int _alt;
			_localctx = new FuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(IDENTIFIER);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(374);
				match(PERIOD);
				setState(375);
				match(IDENTIFIER);
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(381);
			match(LPAREN);
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(382);
					expression();
					setState(383);
					match(COMMA);
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(391);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(390);
				expression();
				}
			}

			setState(393);
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
		enterRule(_localctx, 46, RULE_list_comprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(LBRK);
			setState(396);
			expression();
			setState(398); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(397);
				list_comp_for_if();
				}
				}
				setState(400); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(402);
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
		enterRule(_localctx, 48, RULE_list_comp_for_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			list_comp_for();
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(405);
				list_comp_if();
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
		enterRule(_localctx, 50, RULE_list_comp_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(T__3);
			setState(409);
			match(IDENTIFIER);
			setState(410);
			match(T__7);
			setState(411);
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
		enterRule(_localctx, 52, RULE_list_comp_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(T__0);
			setState(414);
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
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 5);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u01a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\7\3=\n\3\f\3\16\3@\13\3"+
		"\3\3\3\3\5\3D\n\3\5\3F\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"R\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4_\n\4\f\4\16\4b\13"+
		"\4\3\4\5\4e\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\4\5"+
		"\4s\n\4\3\4\3\4\3\4\5\4x\n\4\5\4z\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4\u0084\n\4\f\4\16\4\u0087\13\4\3\4\5\4\u008a\n\4\3\4\3\4\5\4\u008e"+
		"\n\4\3\5\3\5\3\5\3\5\7\5\u0094\n\5\f\5\16\5\u0097\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00a3\n\6\r\6\16\6\u00a4\5\6\u00a7\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\5\7\u00ae\n\7\3\7\3\7\6\7\u00b2\n\7\r\7\16\7\u00b3"+
		"\3\7\3\7\3\7\3\7\5\7\u00ba\n\7\3\7\3\7\3\7\3\7\5\7\u00c0\n\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00c6\n\7\3\7\3\7\3\7\3\7\5\7\u00cc\n\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00d2\n\7\3\7\3\7\3\7\3\7\5\7\u00d8\n\7\5\7\u00da\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00e5\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00ed\n"+
		"\b\f\b\16\b\u00f0\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00fa\n\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u010b\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0131\n\13"+
		"\f\13\16\13\u0134\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u013b\n\f\3\r\3\r\3\r"+
		"\5\r\u0140\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u0148\n\20\3\21\3\21"+
		"\3\21\6\21\u014d\n\21\r\21\16\21\u014e\5\21\u0151\n\21\3\22\3\22\3\22"+
		"\3\22\5\22\u0157\n\22\3\22\3\22\3\23\3\23\3\24\6\24\u015e\n\24\r\24\16"+
		"\24\u015f\3\25\3\25\5\25\u0164\n\25\3\26\3\26\3\26\3\26\7\26\u016a\n\26"+
		"\f\26\16\26\u016d\13\26\3\26\5\26\u0170\n\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\7\30\u017b\n\30\f\30\16\30\u017e\13\30\3\30\3\30"+
		"\3\30\3\30\7\30\u0184\n\30\f\30\16\30\u0187\13\30\3\30\5\30\u018a\n\30"+
		"\3\30\3\30\3\31\3\31\3\31\6\31\u0191\n\31\r\31\16\31\u0192\3\31\3\31\3"+
		"\32\3\32\5\32\u0199\n\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\2\4\16\24\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\66\2\7\3\2\32\33\3\2\26\33\3\2#$\3\2\24\25\4\2\t\t\66\66\u01d8\28\3\2"+
		"\2\2\4>\3\2\2\2\6\u008d\3\2\2\2\b\u008f\3\2\2\2\n\u00a6\3\2\2\2\f\u00d9"+
		"\3\2\2\2\16\u00e4\3\2\2\2\20\u00f9\3\2\2\2\22\u00fb\3\2\2\2\24\u010a\3"+
		"\2\2\2\26\u013a\3\2\2\2\30\u013f\3\2\2\2\32\u0141\3\2\2\2\34\u0143\3\2"+
		"\2\2\36\u0147\3\2\2\2 \u0150\3\2\2\2\"\u0152\3\2\2\2$\u015a\3\2\2\2&\u015d"+
		"\3\2\2\2(\u0163\3\2\2\2*\u0165\3\2\2\2,\u0173\3\2\2\2.\u0177\3\2\2\2\60"+
		"\u018d\3\2\2\2\62\u0196\3\2\2\2\64\u019a\3\2\2\2\66\u019f\3\2\2\289\5"+
		"\4\3\29:\7\2\2\3:\3\3\2\2\2;=\5\6\4\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?"+
		"\3\2\2\2?E\3\2\2\2@>\3\2\2\2AC\5\n\6\2BD\5&\24\2CB\3\2\2\2CD\3\2\2\2D"+
		"F\3\2\2\2EA\3\2\2\2EF\3\2\2\2F\5\3\2\2\2GH\5\f\7\2HI\5&\24\2I\u008e\3"+
		"\2\2\2JK\7\3\2\2KL\7+\2\2LM\5\16\b\2MN\7,\2\2NQ\5\b\5\2OP\7\4\2\2PR\5"+
		"\b\5\2QO\3\2\2\2QR\3\2\2\2R\u008e\3\2\2\2ST\7\5\2\2TU\7+\2\2UV\5\16\b"+
		"\2VW\7,\2\2WX\5\b\5\2X\u008e\3\2\2\2YZ\7\6\2\2Z`\7+\2\2[\\\5\f\7\2\\]"+
		"\7\64\2\2]_\3\2\2\2^[\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2"+
		"b`\3\2\2\2ce\5\f\7\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\66\2\2gh\5\16\b"+
		"\2hn\7\66\2\2ij\5\n\6\2jk\7\64\2\2km\3\2\2\2li\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qs\5\n\6\2rq\3\2\2\2rs\3\2\2\2st\3\2"+
		"\2\2ty\7,\2\2uz\7\66\2\2vx\5\b\5\2wv\3\2\2\2wx\3\2\2\2xz\3\2\2\2yu\3\2"+
		"\2\2yw\3\2\2\2z\u008e\3\2\2\2{|\5.\30\2|}\5&\24\2}\u008e\3\2\2\2~\177"+
		"\7\7\2\2\177\u0080\7\63\2\2\u0080\u0085\7+\2\2\u0081\u0082\7\63\2\2\u0082"+
		"\u0084\7\64\2\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"\u008a\7\63\2\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u008c\7,\2\2\u008c\u008e\5\b\5\2\u008dG\3\2\2\2\u008dJ\3"+
		"\2\2\2\u008dS\3\2\2\2\u008dY\3\2\2\2\u008d{\3\2\2\2\u008d~\3\2\2\2\u008e"+
		"\7\3\2\2\2\u008f\u0090\7/\2\2\u0090\u0091\5\4\3\2\u0091\u0095\7\60\2\2"+
		"\u0092\u0094\5&\24\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\t\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u00a7\5\24\13\2\u0099\u00a7\5\16\b\2\u009a\u00a7\5\26\f\2\u009b\u00a7"+
		"\5\f\7\2\u009c\u00a7\5*\26\2\u009d\u00a7\5\60\31\2\u009e\u00a7\5,\27\2"+
		"\u009f\u00a0\7\b\2\2\u00a0\u00a2\5\n\6\2\u00a1\u00a3\5\62\32\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u0098\3\2\2\2\u00a6\u0099\3\2\2\2\u00a6\u009a\3\2"+
		"\2\2\u00a6\u009b\3\2\2\2\u00a6\u009c\3\2\2\2\u00a6\u009d\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a6\u009f\3\2\2\2\u00a7\13\3\2\2\2\u00a8\u00a9\7\63\2"+
		"\2\u00a9\u00ad\7*\2\2\u00aa\u00ae\5\n\6\2\u00ab\u00ae\5\6\4\2\u00ac\u00ae"+
		"\5*\26\2\u00ad\u00aa\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00da\3\2\2\2\u00af\u00b1\7\63\2\2\u00b0\u00b2\5\"\22\2\u00b1\u00b0\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b9\7*\2\2\u00b6\u00ba\5\n\6\2\u00b7\u00ba\5\6"+
		"\4\2\u00b8\u00ba\5*\26\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00da\3\2\2\2\u00bb\u00bc\5 \21\2\u00bc\u00bf\7\'"+
		"\2\2\u00bd\u00c0\5\n\6\2\u00be\u00c0\5\6\4\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00da\3\2\2\2\u00c1\u00c2\5 \21\2\u00c2\u00c5\7("+
		"\2\2\u00c3\u00c6\5\n\6\2\u00c4\u00c6\5\6\4\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00da\3\2\2\2\u00c7\u00c8\5 \21\2\u00c8\u00cb\7)"+
		"\2\2\u00c9\u00cc\5\n\6\2\u00ca\u00cc\5\6\4\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00da\3\2\2\2\u00cd\u00ce\5 \21\2\u00ce\u00d1\7%"+
		"\2\2\u00cf\u00d2\5\n\6\2\u00d0\u00d2\5\6\4\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d0\3\2\2\2\u00d2\u00da\3\2\2\2\u00d3\u00d4\5 \21\2\u00d4\u00d7\7&"+
		"\2\2\u00d5\u00d8\5\n\6\2\u00d6\u00d8\5\6\4\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00a8\3\2\2\2\u00d9\u00af\3\2"+
		"\2\2\u00d9\u00bb\3\2\2\2\u00d9\u00c1\3\2\2\2\u00d9\u00c7\3\2\2\2\u00d9"+
		"\u00cd\3\2\2\2\u00d9\u00d3\3\2\2\2\u00da\r\3\2\2\2\u00db\u00dc\b\b\1\2"+
		"\u00dc\u00e5\5\20\t\2\u00dd\u00de\7\23\2\2\u00de\u00e5\5\16\b\5\u00df"+
		"\u00e0\7+\2\2\u00e0\u00e1\5\16\b\2\u00e1\u00e2\7,\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e5\5$\23\2\u00e4\u00db\3\2\2\2\u00e4\u00dd\3\2\2\2\u00e4"+
		"\u00df\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00ee\3\2\2\2\u00e6\u00e7\f\7"+
		"\2\2\u00e7\u00e8\7\21\2\2\u00e8\u00ed\5\16\b\b\u00e9\u00ea\f\6\2\2\u00ea"+
		"\u00eb\7\22\2\2\u00eb\u00ed\5\16\b\7\u00ec\u00e6\3\2\2\2\u00ec\u00e9\3"+
		"\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\17\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5\24\13\2\u00f2\u00f3\5\22"+
		"\n\2\u00f3\u00f4\5\24\13\2\u00f4\u00fa\3\2\2\2\u00f5\u00f6\5\26\f\2\u00f6"+
		"\u00f7\t\2\2\2\u00f7\u00f8\5\26\f\2\u00f8\u00fa\3\2\2\2\u00f9\u00f1\3"+
		"\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\21\3\2\2\2\u00fb\u00fc\t\3\2\2\u00fc"+
		"\23\3\2\2\2\u00fd\u00fe\b\13\1\2\u00fe\u00ff\7\63\2\2\u00ff\u010b\t\4"+
		"\2\2\u0100\u0101\7\37\2\2\u0101\u010b\5\24\13\23\u0102\u0103\7\f\2\2\u0103"+
		"\u010b\5\24\13\22\u0104\u0105\7+\2\2\u0105\u0106\5\24\13\2\u0106\u0107"+
		"\7,\2\2\u0107\u010b\3\2\2\2\u0108\u010b\5\30\r\2\u0109\u010b\5.\30\2\u010a"+
		"\u00fd\3\2\2\2\u010a\u0100\3\2\2\2\u010a\u0102\3\2\2\2\u010a\u0104\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u0132\3\2\2\2\u010c"+
		"\u010d\f\21\2\2\u010d\u010e\7\20\2\2\u010e\u0131\5\24\13\22\u010f\u0110"+
		"\f\20\2\2\u0110\u0111\7\r\2\2\u0111\u0131\5\24\13\21\u0112\u0113\f\17"+
		"\2\2\u0113\u0114\7\16\2\2\u0114\u0131\5\24\13\20\u0115\u0116\f\16\2\2"+
		"\u0116\u0117\7\17\2\2\u0117\u0131\5\24\13\17\u0118\u0119\f\r\2\2\u0119"+
		"\u011a\7\13\2\2\u011a\u0131\5\24\13\16\u011b\u011c\f\f\2\2\u011c\u011d"+
		"\7\f\2\2\u011d\u0131\5\24\13\r\u011e\u011f\f\13\2\2\u011f\u0120\7 \2\2"+
		"\u0120\u0131\5\24\13\f\u0121\u0122\f\n\2\2\u0122\u0123\7!\2\2\u0123\u0131"+
		"\5\24\13\13\u0124\u0125\f\t\2\2\u0125\u0126\7\"\2\2\u0126\u0131\5\24\13"+
		"\n\u0127\u0128\f\b\2\2\u0128\u0129\7\34\2\2\u0129\u0131\5\24\13\t\u012a"+
		"\u012b\f\7\2\2\u012b\u012c\7\35\2\2\u012c\u0131\5\24\13\b\u012d\u012e"+
		"\f\6\2\2\u012e\u012f\7\36\2\2\u012f\u0131\5\24\13\7\u0130\u010c\3\2\2"+
		"\2\u0130\u010f\3\2\2\2\u0130\u0112\3\2\2\2\u0130\u0115\3\2\2\2\u0130\u0118"+
		"\3\2\2\2\u0130\u011b\3\2\2\2\u0130\u011e\3\2\2\2\u0130\u0121\3\2\2\2\u0130"+
		"\u0124\3\2\2\2\u0130\u0127\3\2\2\2\u0130\u012a\3\2\2\2\u0130\u012d\3\2"+
		"\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\25\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5(\25\2\u0136\u0137\7\13\2"+
		"\2\u0137\u0138\5(\25\2\u0138\u013b\3\2\2\2\u0139\u013b\5(\25\2\u013a\u0135"+
		"\3\2\2\2\u013a\u0139\3\2\2\2\u013b\27\3\2\2\2\u013c\u0140\5\32\16\2\u013d"+
		"\u0140\5\34\17\2\u013e\u0140\5 \21\2\u013f\u013c\3\2\2\2\u013f\u013d\3"+
		"\2\2\2\u013f\u013e\3\2\2\2\u0140\31\3\2\2\2\u0141\u0142\7\61\2\2\u0142"+
		"\33\3\2\2\2\u0143\u0144\7\62\2\2\u0144\35\3\2\2\2\u0145\u0148\5\32\16"+
		"\2\u0146\u0148\5 \21\2\u0147\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148\37"+
		"\3\2\2\2\u0149\u0151\7\63\2\2\u014a\u014c\7\63\2\2\u014b\u014d\5\"\22"+
		"\2\u014c\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0149\3\2\2\2\u0150\u014a\3\2\2\2\u0151"+
		"!\3\2\2\2\u0152\u0153\7-\2\2\u0153\u0156\5\24\13\2\u0154\u0155\7\65\2"+
		"\2\u0155\u0157\5\24\13\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0159\7.\2\2\u0159#\3\2\2\2\u015a\u015b\t\5\2\2\u015b"+
		"%\3\2\2\2\u015c\u015e\t\6\2\2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2"+
		"\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\'\3\2\2\2\u0161\u0164\7"+
		"<\2\2\u0162\u0164\5 \21\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164"+
		")\3\2\2\2\u0165\u016b\7-\2\2\u0166\u0167\5\n\6\2\u0167\u0168\7\64\2\2"+
		"\u0168\u016a\3\2\2\2\u0169\u0166\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169"+
		"\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016e"+
		"\u0170\5\n\6\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\7.\2\2\u0172+\3\2\2\2\u0173\u0174\5\24\13\2\u0174\u0175"+
		"\7\65\2\2\u0175\u0176\5\24\13\2\u0176-\3\2\2\2\u0177\u017c\7\63\2\2\u0178"+
		"\u0179\7\67\2\2\u0179\u017b\7\63\2\2\u017a\u0178\3\2\2\2\u017b\u017e\3"+
		"\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017f\u0185\7+\2\2\u0180\u0181\5\n\6\2\u0181\u0182\7\64"+
		"\2\2\u0182\u0184\3\2\2\2\u0183\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2"+
		"\2\2\u0188\u018a\5\n\6\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018c\7,\2\2\u018c/\3\2\2\2\u018d\u018e\7-\2\2\u018e"+
		"\u0190\5\n\6\2\u018f\u0191\5\62\32\2\u0190\u018f\3\2\2\2\u0191\u0192\3"+
		"\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"\u0195\7.\2\2\u0195\61\3\2\2\2\u0196\u0198\5\64\33\2\u0197\u0199\5\66"+
		"\34\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\63\3\2\2\2\u019a\u019b"+
		"\7\6\2\2\u019b\u019c\7\63\2\2\u019c\u019d\7\n\2\2\u019d\u019e\5\n\6\2"+
		"\u019e\65\3\2\2\2\u019f\u01a0\7\3\2\2\u01a0\u01a1\5\16\b\2\u01a1\67\3"+
		"\2\2\2\61>CEQ`dnrwy\u0085\u0089\u008d\u0095\u00a4\u00a6\u00ad\u00b3\u00b9"+
		"\u00bf\u00c5\u00cb\u00d1\u00d7\u00d9\u00e4\u00ec\u00ee\u00f9\u010a\u0130"+
		"\u0132\u013a\u013f\u0147\u014e\u0150\u0156\u015f\u0163\u016b\u016f\u017c"+
		"\u0185\u0189\u0192\u0198";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}