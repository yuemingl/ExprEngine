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
		T__0=1, T__1=2, ADD=3, SUB=4, MUL=5, DIV=6, REM=7, AND=8, OR=9, NOT=10, 
		TRUE=11, FALSE=12, GT=13, GE=14, LT=15, LE=16, EQ=17, NEQ=18, BAND=19, 
		BOR=20, BXOR=21, BNOT=22, SHL=23, SHR=24, USHR=25, INC=26, DESC=27, ADD_ASIGN=28, 
		SUB_ASIGN=29, MUL_ASIGN=30, DIV_ASIGN=31, REM_ASIGN=32, ASIGN=33, LPAREN=34, 
		RPAREN=35, LCB=36, RCB=37, INTEGER=38, FLOAT=39, IDENTIFIER=40, END_EXPR=41, 
		COMMENT=42, WS=43;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_expression = 4, RULE_asign_expr = 5, RULE_logical_expr = 6, RULE_comparison_expr = 7, 
		RULE_comp_operator = 8, RULE_arithmetic_expr = 9, RULE_numeric_entity = 10, 
		RULE_integer_entity = 11, RULE_float_entity = 12, RULE_variable_entity = 13, 
		RULE_logical_entity = 14;
	public static final String[] ruleNames = {
		"prog", "block", "statements", "statement", "expression", "asign_expr", 
		"logical_expr", "comparison_expr", "comp_operator", "arithmetic_expr", 
		"numeric_entity", "integer_entity", "float_entity", "variable_entity", 
		"logical_entity"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'%'", null, null, 
		null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
		"'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", "NOT", 
		"TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", 
		"BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", 
		"MUL_ASIGN", "DIV_ASIGN", "REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "LCB", 
		"RCB", "INTEGER", "FLOAT", "IDENTIFIER", "END_EXPR", "COMMENT", "WS"
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
			setState(30);
			statements();
			setState(31);
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
		enterRule(_localctx, 2, RULE_block);
		try {
			_localctx = new StatementBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(LCB);
			setState(34);
			statements();
			setState(35);
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
		public TerminalNode END_EXPR() { return getToken(ExprGrammarParser.END_EXPR, 0); }
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
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			int _alt;
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(37);
						statement();
						}
						} 
					}
					setState(42);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(47);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(43);
					expression();
					setState(45);
					_la = _input.LA(1);
					if (_la==END_EXPR) {
						{
						setState(44);
						match(END_EXPR);
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				expression();
				setState(51);
				_la = _input.LA(1);
				if (_la==END_EXPR) {
					{
					setState(50);
					match(END_EXPR);
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
	public static class ExprAsignContext extends StatementContext {
		public Asign_exprContext asign_expr() {
			return getRuleContext(Asign_exprContext.class,0);
		}
		public TerminalNode END_EXPR() { return getToken(ExprGrammarParser.END_EXPR, 0); }
		public ExprAsignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAsign(this);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(67);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new ExprAsignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				asign_expr();
				setState(56);
				match(END_EXPR);
				}
				break;
			case T__0:
				_localctx = new ExprIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__0);
				setState(59);
				match(LPAREN);
				setState(60);
				logical_expr(0);
				setState(61);
				match(RPAREN);
				setState(62);
				block();
				setState(65);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(63);
					match(T__1);
					setState(64);
					block();
					}
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
		public Asign_exprContext asign_expr() {
			return getRuleContext(Asign_exprContext.class,0);
		}
		public ExprAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAssign(this);
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
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				logical_expr(0);
				}
				break;
			case 3:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				asign_expr();
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

	public static class Asign_exprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ExprGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ASIGN() { return getToken(ExprGrammarParser.ASIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Asign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterAsign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitAsign_expr(this);
		}
	}

	public final Asign_exprContext asign_expr() throws RecognitionException {
		Asign_exprContext _localctx = new Asign_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(IDENTIFIER);
			setState(75);
			match(ASIGN);
			setState(76);
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
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(79);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(NOT);
				setState(81);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(LPAREN);
				setState(83);
				logical_expr(0);
				setState(84);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(95);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(89);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(90);
						match(AND);
						setState(91);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(92);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(93);
						match(OR);
						setState(94);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class ComparisonExpressionWithOperatorContext extends Comparison_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public Comp_operatorContext comp_operator() {
			return getRuleContext(Comp_operatorContext.class,0);
		}
		public ComparisonExpressionWithOperatorContext(Comparison_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterComparisonExpressionWithOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitComparisonExpressionWithOperator(this);
		}
	}

	public final Comparison_exprContext comparison_expr() throws RecognitionException {
		Comparison_exprContext _localctx = new Comparison_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparison_expr);
		try {
			_localctx = new ComparisonExpressionWithOperatorContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			arithmetic_expr(0);
			setState(101);
			comp_operator();
			setState(102);
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
			setState(104);
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
	public static class ExprSubAsignContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode SUB_ASIGN() { return getToken(ExprGrammarParser.SUB_ASIGN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprSubAsignContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprSubAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprSubAsign(this);
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
	public static class ExprAddAsignContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode ADD_ASIGN() { return getToken(ExprGrammarParser.ADD_ASIGN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprAddAsignContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprAddAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprAddAsign(this);
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
	public static class ExprRemAsignContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode REM_ASIGN() { return getToken(ExprGrammarParser.REM_ASIGN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprRemAsignContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprRemAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprRemAsign(this);
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
	public static class ExprMulAsignContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode MUL_ASIGN() { return getToken(ExprGrammarParser.MUL_ASIGN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprMulAsignContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprMulAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprMulAsign(this);
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
	public static class ExprDivAsignContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
		public TerminalNode DIV_ASIGN() { return getToken(ExprGrammarParser.DIV_ASIGN, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public ExprDivAsignContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).enterExprDivAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprGrammarListener ) ((ExprGrammarListener)listener).exitExprDivAsign(this);
		}
	}
	public static class ArithmeticExpressionIncDecContext extends Arithmetic_exprContext {
		public Variable_entityContext variable_entity() {
			return getRuleContext(Variable_entityContext.class,0);
		}
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionIncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(107);
				variable_entity();
				setState(108);
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
				setState(110);
				match(BNOT);
				setState(111);
				arithmetic_expr(20);
				}
				break;
			case 3:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(SUB);
				setState(113);
				arithmetic_expr(19);
				}
				break;
			case 4:
				{
				_localctx = new ExprMulAsignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				variable_entity();
				setState(115);
				match(MUL_ASIGN);
				setState(116);
				arithmetic_expr(7);
				}
				break;
			case 5:
				{
				_localctx = new ExprDivAsignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				variable_entity();
				setState(119);
				match(DIV_ASIGN);
				setState(120);
				arithmetic_expr(6);
				}
				break;
			case 6:
				{
				_localctx = new ExprRemAsignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				variable_entity();
				setState(123);
				match(REM_ASIGN);
				setState(124);
				arithmetic_expr(5);
				}
				break;
			case 7:
				{
				_localctx = new ExprAddAsignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				variable_entity();
				setState(127);
				match(ADD_ASIGN);
				setState(128);
				arithmetic_expr(4);
				}
				break;
			case 8:
				{
				_localctx = new ExprSubAsignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				variable_entity();
				setState(131);
				match(SUB_ASIGN);
				setState(132);
				arithmetic_expr(3);
				}
				break;
			case 9:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(LPAREN);
				setState(135);
				arithmetic_expr(0);
				setState(136);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				numeric_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(141);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(142);
						match(MUL);
						setState(143);
						arithmetic_expr(19);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(144);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(145);
						match(DIV);
						setState(146);
						arithmetic_expr(18);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(147);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(148);
						match(REM);
						setState(149);
						arithmetic_expr(17);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(150);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(151);
						match(ADD);
						setState(152);
						arithmetic_expr(16);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(153);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(154);
						match(SUB);
						setState(155);
						arithmetic_expr(15);
						}
						break;
					case 6:
						{
						_localctx = new BitExpressionShlContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(156);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(157);
						match(SHL);
						setState(158);
						arithmetic_expr(14);
						}
						break;
					case 7:
						{
						_localctx = new BitExpressionShrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(159);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(160);
						match(SHR);
						setState(161);
						arithmetic_expr(13);
						}
						break;
					case 8:
						{
						_localctx = new BitExpressionUshrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(162);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(163);
						match(USHR);
						setState(164);
						arithmetic_expr(12);
						}
						break;
					case 9:
						{
						_localctx = new BitExpressionAndContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(165);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(166);
						match(BAND);
						setState(167);
						arithmetic_expr(11);
						}
						break;
					case 10:
						{
						_localctx = new BitExpressionOrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(168);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(169);
						match(BOR);
						setState(170);
						arithmetic_expr(10);
						}
						break;
					case 11:
						{
						_localctx = new BitExpressionXorContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(171);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(172);
						match(BXOR);
						setState(173);
						arithmetic_expr(9);
						}
						break;
					}
					} 
				}
				setState(178);
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
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 20, RULE_numeric_entity);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				integer_entity();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				float_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
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
		enterRule(_localctx, 22, RULE_integer_entity);
		try {
			_localctx = new EntityConstIntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 24, RULE_float_entity);
		try {
			_localctx = new EntityConstFloatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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

	public final Variable_entityContext variable_entity() throws RecognitionException {
		Variable_entityContext _localctx = new Variable_entityContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable_entity);
		try {
			_localctx = new EntityVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 28, RULE_logical_entity);
		int _la;
		try {
			_localctx = new EntityLogicalConstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		case 10:
			return precpred(_ctx, 10);
		case 11:
			return precpred(_ctx, 9);
		case 12:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u00c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\5\4\60\n\4\5\4\62\n\4\3\4"+
		"\3\4\5\4\66\n\4\5\48\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D"+
		"\n\5\5\5F\n\5\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\bZ\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bb\n\b\f\b\16\be\13"+
		"\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008e\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00b1\n\13\f\13\16\13\u00b4\13\13\3\f\3\f\3"+
		"\f\5\f\u00b9\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\4\16\24"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\3\2\17\24\3\2\34\35\3\2"+
		"\r\16\u00d7\2 \3\2\2\2\4#\3\2\2\2\6\67\3\2\2\2\bE\3\2\2\2\nJ\3\2\2\2\f"+
		"L\3\2\2\2\16Y\3\2\2\2\20f\3\2\2\2\22j\3\2\2\2\24\u008d\3\2\2\2\26\u00b8"+
		"\3\2\2\2\30\u00ba\3\2\2\2\32\u00bc\3\2\2\2\34\u00be\3\2\2\2\36\u00c0\3"+
		"\2\2\2 !\5\6\4\2!\"\7\2\2\3\"\3\3\2\2\2#$\7&\2\2$%\5\6\4\2%&\7\'\2\2&"+
		"\5\3\2\2\2\')\5\b\5\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\61\3\2"+
		"\2\2,*\3\2\2\2-/\5\n\6\2.\60\7+\2\2/.\3\2\2\2/\60\3\2\2\2\60\62\3\2\2"+
		"\2\61-\3\2\2\2\61\62\3\2\2\2\628\3\2\2\2\63\65\5\n\6\2\64\66\7+\2\2\65"+
		"\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67*\3\2\2\2\67\63\3\2\2\28\7\3\2"+
		"\2\29:\5\f\7\2:;\7+\2\2;F\3\2\2\2<=\7\3\2\2=>\7$\2\2>?\5\16\b\2?@\7%\2"+
		"\2@C\5\4\3\2AB\7\4\2\2BD\5\4\3\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2E9\3\2\2"+
		"\2E<\3\2\2\2F\t\3\2\2\2GK\5\24\13\2HK\5\16\b\2IK\5\f\7\2JG\3\2\2\2JH\3"+
		"\2\2\2JI\3\2\2\2K\13\3\2\2\2LM\7*\2\2MN\7#\2\2NO\5\n\6\2O\r\3\2\2\2PQ"+
		"\b\b\1\2QZ\5\20\t\2RS\7\f\2\2SZ\5\16\b\5TU\7$\2\2UV\5\16\b\2VW\7%\2\2"+
		"WZ\3\2\2\2XZ\5\36\20\2YP\3\2\2\2YR\3\2\2\2YT\3\2\2\2YX\3\2\2\2Zc\3\2\2"+
		"\2[\\\f\7\2\2\\]\7\n\2\2]b\5\16\b\b^_\f\6\2\2_`\7\13\2\2`b\5\16\b\7a["+
		"\3\2\2\2a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\17\3\2\2\2ec\3\2\2\2"+
		"fg\5\24\13\2gh\5\22\n\2hi\5\24\13\2i\21\3\2\2\2jk\t\2\2\2k\23\3\2\2\2"+
		"lm\b\13\1\2mn\5\34\17\2no\t\3\2\2o\u008e\3\2\2\2pq\7\30\2\2q\u008e\5\24"+
		"\13\26rs\7\6\2\2s\u008e\5\24\13\25tu\5\34\17\2uv\7 \2\2vw\5\24\13\tw\u008e"+
		"\3\2\2\2xy\5\34\17\2yz\7!\2\2z{\5\24\13\b{\u008e\3\2\2\2|}\5\34\17\2}"+
		"~\7\"\2\2~\177\5\24\13\7\177\u008e\3\2\2\2\u0080\u0081\5\34\17\2\u0081"+
		"\u0082\7\36\2\2\u0082\u0083\5\24\13\6\u0083\u008e\3\2\2\2\u0084\u0085"+
		"\5\34\17\2\u0085\u0086\7\37\2\2\u0086\u0087\5\24\13\5\u0087\u008e\3\2"+
		"\2\2\u0088\u0089\7$\2\2\u0089\u008a\5\24\13\2\u008a\u008b\7%\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008e\5\26\f\2\u008dl\3\2\2\2\u008dp\3\2\2\2\u008d"+
		"r\3\2\2\2\u008dt\3\2\2\2\u008dx\3\2\2\2\u008d|\3\2\2\2\u008d\u0080\3\2"+
		"\2\2\u008d\u0084\3\2\2\2\u008d\u0088\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u00b2\3\2\2\2\u008f\u0090\f\24\2\2\u0090\u0091\7\7\2\2\u0091\u00b1\5"+
		"\24\13\25\u0092\u0093\f\23\2\2\u0093\u0094\7\b\2\2\u0094\u00b1\5\24\13"+
		"\24\u0095\u0096\f\22\2\2\u0096\u0097\7\t\2\2\u0097\u00b1\5\24\13\23\u0098"+
		"\u0099\f\21\2\2\u0099\u009a\7\5\2\2\u009a\u00b1\5\24\13\22\u009b\u009c"+
		"\f\20\2\2\u009c\u009d\7\6\2\2\u009d\u00b1\5\24\13\21\u009e\u009f\f\17"+
		"\2\2\u009f\u00a0\7\31\2\2\u00a0\u00b1\5\24\13\20\u00a1\u00a2\f\16\2\2"+
		"\u00a2\u00a3\7\32\2\2\u00a3\u00b1\5\24\13\17\u00a4\u00a5\f\r\2\2\u00a5"+
		"\u00a6\7\33\2\2\u00a6\u00b1\5\24\13\16\u00a7\u00a8\f\f\2\2\u00a8\u00a9"+
		"\7\25\2\2\u00a9\u00b1\5\24\13\r\u00aa\u00ab\f\13\2\2\u00ab\u00ac\7\26"+
		"\2\2\u00ac\u00b1\5\24\13\f\u00ad\u00ae\f\n\2\2\u00ae\u00af\7\27\2\2\u00af"+
		"\u00b1\5\24\13\13\u00b0\u008f\3\2\2\2\u00b0\u0092\3\2\2\2\u00b0\u0095"+
		"\3\2\2\2\u00b0\u0098\3\2\2\2\u00b0\u009b\3\2\2\2\u00b0\u009e\3\2\2\2\u00b0"+
		"\u00a1\3\2\2\2\u00b0\u00a4\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b0\u00aa\3\2"+
		"\2\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\25\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b9\5\30\r"+
		"\2\u00b6\u00b9\5\32\16\2\u00b7\u00b9\5\34\17\2\u00b8\u00b5\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\27\3\2\2\2\u00ba\u00bb\7(\2\2"+
		"\u00bb\31\3\2\2\2\u00bc\u00bd\7)\2\2\u00bd\33\3\2\2\2\u00be\u00bf\7*\2"+
		"\2\u00bf\35\3\2\2\2\u00c0\u00c1\t\4\2\2\u00c1\37\3\2\2\2\21*/\61\65\67"+
		"CEJYac\u008d\u00b0\u00b2\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}