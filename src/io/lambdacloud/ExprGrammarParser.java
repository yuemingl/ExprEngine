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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ADD=6, SUB=7, MUL=8, DIV=9, REM=10, 
		AND=11, OR=12, NOT=13, TRUE=14, FALSE=15, GT=16, GE=17, LT=18, LE=19, 
		EQ=20, NEQ=21, BAND=22, BOR=23, BXOR=24, BNOT=25, SHL=26, SHR=27, USHR=28, 
		INC=29, DESC=30, ADD_ASSIGN=31, SUB_ASSIGN=32, MUL_ASSIGN=33, DIV_ASSIGN=34, 
		REM_ASSIGN=35, ASSIGN=36, LPAREN=37, RPAREN=38, LBRK=39, RBRK=40, LCB=41, 
		RCB=42, INTEGER=43, FLOAT=44, IDENTIFIER=45, COMMA=46, COLON=47, SEMI=48, 
		SQUOTE=49, DQUOTE=50, COMMENT=51, WS=52, StringLiteral=53;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_expression = 4, RULE_assign_expr = 5, RULE_logical_expr = 6, RULE_comparison_expr = 7, 
		RULE_comp_operator = 8, RULE_arithmetic_expr = 9, RULE_string_expr = 10, 
		RULE_numeric_entity = 11, RULE_integer_entity = 12, RULE_float_entity = 13, 
		RULE_index_entity = 14, RULE_variable_entity = 15, RULE_logical_entity = 16, 
		RULE_expr_end = 17, RULE_string_entity = 18, RULE_array_init = 19;
	public static final String[] ruleNames = {
		"prog", "statements", "statement", "block", "expression", "assign_expr", 
		"logical_expr", "comparison_expr", "comp_operator", "arithmetic_expr", 
		"string_expr", "numeric_entity", "integer_entity", "float_entity", "index_entity", 
		"variable_entity", "logical_entity", "expr_end", "string_entity", "array_init"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'\n'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", 
		"'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", "';'", 
		"'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral"
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
			setState(40);
			statements();
			setState(41);
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
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					statement();
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(53);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
				{
				setState(49);
				expression();
				setState(51);
				_la = _input.LA(1);
				if (_la==T__4 || _la==SEMI) {
					{
					setState(50);
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
			setState(107);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new ExprAssign2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				assign_expr();
				setState(56);
				expr_end();
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
			case T__2:
				_localctx = new ExprWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(T__2);
				setState(68);
				match(LPAREN);
				setState(69);
				logical_expr(0);
				setState(70);
				match(RPAREN);
				setState(71);
				block();
				}
				break;
			case T__3:
				_localctx = new ExprForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(T__3);
				setState(74);
				match(LPAREN);
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(75);
						assign_expr();
						setState(76);
						match(COMMA);
						}
						} 
					}
					setState(82);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(84);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(83);
					assign_expr();
					}
				}

				setState(86);
				match(SEMI);
				setState(87);
				logical_expr(0);
				setState(88);
				match(SEMI);
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(89);
						expression();
						setState(90);
						match(COMMA);
						}
						} 
					}
					setState(96);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(98);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << BNOT) | (1L << LPAREN) | (1L << LBRK) | (1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << StringLiteral))) != 0)) {
					{
					setState(97);
					expression();
					}
				}

				setState(100);
				match(RPAREN);
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(101);
					match(SEMI);
					}
					break;
				case 2:
					{
					setState(103);
					_la = _input.LA(1);
					if (_la==LCB) {
						{
						setState(102);
						block();
						}
					}

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
			setState(109);
			match(LCB);
			setState(110);
			statements();
			setState(111);
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
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ExprArithmeticContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ExprLogicalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				logical_expr(0);
				}
				break;
			case 3:
				_localctx = new ExprStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				string_expr();
				}
				break;
			case 4:
				_localctx = new ExprAssign1Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				assign_expr();
				}
				break;
			case 5:
				_localctx = new ExprArrayInitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
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

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_expr);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ExprAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(IDENTIFIER);
				setState(121);
				match(ASSIGN);
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(122);
					expression();
					}
					break;
				case 2:
					{
					setState(123);
					statement();
					}
					break;
				case 3:
					{
					setState(124);
					array_init();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new ExprMulAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				variable_entity();
				setState(128);
				match(MUL_ASSIGN);
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(129);
					expression();
					}
					break;
				case 2:
					{
					setState(130);
					statement();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new ExprDivAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				variable_entity();
				setState(134);
				match(DIV_ASSIGN);
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(135);
					expression();
					}
					break;
				case 2:
					{
					setState(136);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ExprRemAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				variable_entity();
				setState(140);
				match(REM_ASSIGN);
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(141);
					expression();
					}
					break;
				case 2:
					{
					setState(142);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ExprAddAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				variable_entity();
				setState(146);
				match(ADD_ASSIGN);
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(147);
					expression();
					}
					break;
				case 2:
					{
					setState(148);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new ExprSubAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				variable_entity();
				setState(152);
				match(SUB_ASSIGN);
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(153);
					expression();
					}
					break;
				case 2:
					{
					setState(154);
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
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ComparisonExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(160);
				comparison_expr();
				}
				break;
			case 2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(NOT);
				setState(162);
				logical_expr(3);
				}
				break;
			case 3:
				{
				_localctx = new LogicalExpressionInParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(LPAREN);
				setState(164);
				logical_expr(0);
				setState(165);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				logical_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(170);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(171);
						match(AND);
						setState(172);
						logical_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(173);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(174);
						match(OR);
						setState(175);
						logical_expr(5);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ComparisonArithmeticExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				arithmetic_expr(0);
				setState(182);
				comp_operator();
				setState(183);
				arithmetic_expr(0);
				}
				break;
			case 2:
				_localctx = new ComparisonStringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				string_expr();
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(187);
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
			setState(191);
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
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticExpressionIncDecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(194);
				match(IDENTIFIER);
				setState(195);
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
				setState(196);
				match(BNOT);
				setState(197);
				arithmetic_expr(15);
				}
				break;
			case 3:
				{
				_localctx = new ArithmeticExpressionNegationEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(SUB);
				setState(199);
				arithmetic_expr(14);
				}
				break;
			case 4:
				{
				_localctx = new ArithmeticExpressionParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(LPAREN);
				setState(201);
				arithmetic_expr(0);
				setState(202);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ArithmeticExpressionEntityContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				numeric_entity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(240);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionMulContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(207);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(208);
						match(MUL);
						setState(209);
						arithmetic_expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(210);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(211);
						match(DIV);
						setState(212);
						arithmetic_expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionRemContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(213);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(214);
						match(REM);
						setState(215);
						arithmetic_expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionAddContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(216);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(217);
						match(ADD);
						setState(218);
						arithmetic_expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpressionSubContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(219);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(220);
						match(SUB);
						setState(221);
						arithmetic_expr(10);
						}
						break;
					case 6:
						{
						_localctx = new BitExpressionShlContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(222);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(223);
						match(SHL);
						setState(224);
						arithmetic_expr(9);
						}
						break;
					case 7:
						{
						_localctx = new BitExpressionShrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(225);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(226);
						match(SHR);
						setState(227);
						arithmetic_expr(8);
						}
						break;
					case 8:
						{
						_localctx = new BitExpressionUshrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(228);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(229);
						match(USHR);
						setState(230);
						arithmetic_expr(7);
						}
						break;
					case 9:
						{
						_localctx = new BitExpressionAndContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(231);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(232);
						match(BAND);
						setState(233);
						arithmetic_expr(6);
						}
						break;
					case 10:
						{
						_localctx = new BitExpressionOrContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(234);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(235);
						match(BOR);
						setState(236);
						arithmetic_expr(5);
						}
						break;
					case 11:
						{
						_localctx = new BitExpressionXorContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(237);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(238);
						match(BXOR);
						setState(239);
						arithmetic_expr(4);
						}
						break;
					}
					} 
				}
				setState(244);
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
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new StringConcatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				string_entity();
				setState(246);
				match(ADD);
				setState(247);
				string_entity();
				}
				break;
			case 2:
				_localctx = new StringEntityContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
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
			setState(255);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				integer_entity();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				float_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
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
			setState(257);
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
			setState(259);
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
			setState(263);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				integer_entity();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
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
		public List<Index_entityContext> index_entity() {
			return getRuleContexts(Index_entityContext.class);
		}
		public Index_entityContext index_entity(int i) {
			return getRuleContext(Index_entityContext.class,i);
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
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new EntityVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new EntityArrayAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(IDENTIFIER);
				setState(275); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(267);
						match(LBRK);
						setState(268);
						index_entity();
						setState(271);
						_la = _input.LA(1);
						if (_la==COLON) {
							{
							setState(269);
							match(COLON);
							setState(270);
							index_entity();
							}
						}

						setState(273);
						match(RBRK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(277); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
			setState(281);
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
			setState(284); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(283);
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
				setState(286); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			setState(290);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new StringConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(StringLiteral);
				}
				break;
			case IDENTIFIER:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
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
		public List<Numeric_entityContext> numeric_entity() {
			return getRuleContexts(Numeric_entityContext.class);
		}
		public Numeric_entityContext numeric_entity(int i) {
			return getRuleContext(Numeric_entityContext.class,i);
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
			setState(292);
			match(LBRK);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(293);
					numeric_entity();
					setState(294);
					match(COMMA);
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(302);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(301);
				numeric_entity();
				}
			}

			setState(304);
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
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0135\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\7\3/\n\3\f\3\16\3\62\13"+
		"\3\3\3\3\3\5\3\66\n\3\5\38\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4D\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4Q\n\4\f\4\16"+
		"\4T\13\4\3\4\5\4W\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4_\n\4\f\4\16\4b\13\4"+
		"\3\4\5\4e\n\4\3\4\3\4\3\4\5\4j\n\4\5\4l\n\4\5\4n\n\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\5\6y\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\7\3\7"+
		"\3\7\3\7\5\7\u0086\n\7\3\7\3\7\3\7\3\7\5\7\u008c\n\7\3\7\3\7\3\7\3\7\5"+
		"\7\u0092\n\7\3\7\3\7\3\7\3\7\5\7\u0098\n\7\3\7\3\7\3\7\3\7\5\7\u009e\n"+
		"\7\5\7\u00a0\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ab\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\b\u00b3\n\b\f\b\16\b\u00b6\13\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00c0\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d0\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00f3\n\13\f\13\16\13\u00f6\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u00fd"+
		"\n\f\3\r\3\r\3\r\5\r\u0102\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u010a"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0112\n\21\3\21\3\21\6\21\u0116"+
		"\n\21\r\21\16\21\u0117\5\21\u011a\n\21\3\22\3\22\3\23\6\23\u011f\n\23"+
		"\r\23\16\23\u0120\3\24\3\24\5\24\u0125\n\24\3\25\3\25\3\25\3\25\7\25\u012b"+
		"\n\25\f\25\16\25\u012e\13\25\3\25\5\25\u0131\n\25\3\25\3\25\3\25\2\4\16"+
		"\24\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\7\3\2\26\27\3\2"+
		"\22\27\3\2\37 \3\2\20\21\4\2\7\7\62\62\u015d\2*\3\2\2\2\4\60\3\2\2\2\6"+
		"m\3\2\2\2\bo\3\2\2\2\nx\3\2\2\2\f\u009f\3\2\2\2\16\u00aa\3\2\2\2\20\u00bf"+
		"\3\2\2\2\22\u00c1\3\2\2\2\24\u00cf\3\2\2\2\26\u00fc\3\2\2\2\30\u0101\3"+
		"\2\2\2\32\u0103\3\2\2\2\34\u0105\3\2\2\2\36\u0109\3\2\2\2 \u0119\3\2\2"+
		"\2\"\u011b\3\2\2\2$\u011e\3\2\2\2&\u0124\3\2\2\2(\u0126\3\2\2\2*+\5\4"+
		"\3\2+,\7\2\2\3,\3\3\2\2\2-/\5\6\4\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2"+
		"\60\61\3\2\2\2\61\67\3\2\2\2\62\60\3\2\2\2\63\65\5\n\6\2\64\66\5$\23\2"+
		"\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\63\3\2\2\2\678\3\2\2\28\5"+
		"\3\2\2\29:\5\f\7\2:;\5$\23\2;n\3\2\2\2<=\7\3\2\2=>\7\'\2\2>?\5\16\b\2"+
		"?@\7(\2\2@C\5\b\5\2AB\7\4\2\2BD\5\b\5\2CA\3\2\2\2CD\3\2\2\2Dn\3\2\2\2"+
		"EF\7\5\2\2FG\7\'\2\2GH\5\16\b\2HI\7(\2\2IJ\5\b\5\2Jn\3\2\2\2KL\7\6\2\2"+
		"LR\7\'\2\2MN\5\f\7\2NO\7\60\2\2OQ\3\2\2\2PM\3\2\2\2QT\3\2\2\2RP\3\2\2"+
		"\2RS\3\2\2\2SV\3\2\2\2TR\3\2\2\2UW\5\f\7\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2"+
		"\2XY\7\62\2\2YZ\5\16\b\2Z`\7\62\2\2[\\\5\n\6\2\\]\7\60\2\2]_\3\2\2\2^"+
		"[\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2ce\5\n\6\2"+
		"dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fk\7(\2\2gl\7\62\2\2hj\5\b\5\2ih\3\2\2\2"+
		"ij\3\2\2\2jl\3\2\2\2kg\3\2\2\2ki\3\2\2\2ln\3\2\2\2m9\3\2\2\2m<\3\2\2\2"+
		"mE\3\2\2\2mK\3\2\2\2n\7\3\2\2\2op\7+\2\2pq\5\4\3\2qr\7,\2\2r\t\3\2\2\2"+
		"sy\5\24\13\2ty\5\16\b\2uy\5\26\f\2vy\5\f\7\2wy\5(\25\2xs\3\2\2\2xt\3\2"+
		"\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\13\3\2\2\2z{\7/\2\2{\177\7&\2\2|\u0080"+
		"\5\n\6\2}\u0080\5\6\4\2~\u0080\5(\25\2\177|\3\2\2\2\177}\3\2\2\2\177~"+
		"\3\2\2\2\u0080\u00a0\3\2\2\2\u0081\u0082\5 \21\2\u0082\u0085\7#\2\2\u0083"+
		"\u0086\5\n\6\2\u0084\u0086\5\6\4\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2"+
		"\2\2\u0086\u00a0\3\2\2\2\u0087\u0088\5 \21\2\u0088\u008b\7$\2\2\u0089"+
		"\u008c\5\n\6\2\u008a\u008c\5\6\4\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2"+
		"\2\2\u008c\u00a0\3\2\2\2\u008d\u008e\5 \21\2\u008e\u0091\7%\2\2\u008f"+
		"\u0092\5\n\6\2\u0090\u0092\5\6\4\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\u00a0\3\2\2\2\u0093\u0094\5 \21\2\u0094\u0097\7!\2\2\u0095"+
		"\u0098\5\n\6\2\u0096\u0098\5\6\4\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2"+
		"\2\2\u0098\u00a0\3\2\2\2\u0099\u009a\5 \21\2\u009a\u009d\7\"\2\2\u009b"+
		"\u009e\5\n\6\2\u009c\u009e\5\6\4\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u00a0\3\2\2\2\u009fz\3\2\2\2\u009f\u0081\3\2\2\2\u009f\u0087"+
		"\3\2\2\2\u009f\u008d\3\2\2\2\u009f\u0093\3\2\2\2\u009f\u0099\3\2\2\2\u00a0"+
		"\r\3\2\2\2\u00a1\u00a2\b\b\1\2\u00a2\u00ab\5\20\t\2\u00a3\u00a4\7\17\2"+
		"\2\u00a4\u00ab\5\16\b\5\u00a5\u00a6\7\'\2\2\u00a6\u00a7\5\16\b\2\u00a7"+
		"\u00a8\7(\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a1\3\2"+
		"\2\2\u00aa\u00a3\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00b4\3\2\2\2\u00ac\u00ad\f\7\2\2\u00ad\u00ae\7\r\2\2\u00ae\u00b3\5\16"+
		"\b\b\u00af\u00b0\f\6\2\2\u00b0\u00b1\7\16\2\2\u00b1\u00b3\5\16\b\7\u00b2"+
		"\u00ac\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\17\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8"+
		"\5\24\13\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\5\24\13\2\u00ba\u00c0\3\2"+
		"\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\t\2\2\2\u00bd\u00be\5\26\f\2\u00be"+
		"\u00c0\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\21\3\2\2"+
		"\2\u00c1\u00c2\t\3\2\2\u00c2\23\3\2\2\2\u00c3\u00c4\b\13\1\2\u00c4\u00c5"+
		"\7/\2\2\u00c5\u00d0\t\4\2\2\u00c6\u00c7\7\33\2\2\u00c7\u00d0\5\24\13\21"+
		"\u00c8\u00c9\7\t\2\2\u00c9\u00d0\5\24\13\20\u00ca\u00cb\7\'\2\2\u00cb"+
		"\u00cc\5\24\13\2\u00cc\u00cd\7(\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00d0\5"+
		"\30\r\2\u00cf\u00c3\3\2\2\2\u00cf\u00c6\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf"+
		"\u00ca\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00f4\3\2\2\2\u00d1\u00d2\f\17"+
		"\2\2\u00d2\u00d3\7\n\2\2\u00d3\u00f3\5\24\13\20\u00d4\u00d5\f\16\2\2\u00d5"+
		"\u00d6\7\13\2\2\u00d6\u00f3\5\24\13\17\u00d7\u00d8\f\r\2\2\u00d8\u00d9"+
		"\7\f\2\2\u00d9\u00f3\5\24\13\16\u00da\u00db\f\f\2\2\u00db\u00dc\7\b\2"+
		"\2\u00dc\u00f3\5\24\13\r\u00dd\u00de\f\13\2\2\u00de\u00df\7\t\2\2\u00df"+
		"\u00f3\5\24\13\f\u00e0\u00e1\f\n\2\2\u00e1\u00e2\7\34\2\2\u00e2\u00f3"+
		"\5\24\13\13\u00e3\u00e4\f\t\2\2\u00e4\u00e5\7\35\2\2\u00e5\u00f3\5\24"+
		"\13\n\u00e6\u00e7\f\b\2\2\u00e7\u00e8\7\36\2\2\u00e8\u00f3\5\24\13\t\u00e9"+
		"\u00ea\f\7\2\2\u00ea\u00eb\7\30\2\2\u00eb\u00f3\5\24\13\b\u00ec\u00ed"+
		"\f\6\2\2\u00ed\u00ee\7\31\2\2\u00ee\u00f3\5\24\13\7\u00ef\u00f0\f\5\2"+
		"\2\u00f0\u00f1\7\32\2\2\u00f1\u00f3\5\24\13\6\u00f2\u00d1\3\2\2\2\u00f2"+
		"\u00d4\3\2\2\2\u00f2\u00d7\3\2\2\2\u00f2\u00da\3\2\2\2\u00f2\u00dd\3\2"+
		"\2\2\u00f2\u00e0\3\2\2\2\u00f2\u00e3\3\2\2\2\u00f2\u00e6\3\2\2\2\u00f2"+
		"\u00e9\3\2\2\2\u00f2\u00ec\3\2\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\25\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f7\u00f8\5&\24\2\u00f8\u00f9\7\b\2\2\u00f9\u00fa\5&\24\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00fd\5&\24\2\u00fc\u00f7\3\2\2\2\u00fc\u00fb\3\2"+
		"\2\2\u00fd\27\3\2\2\2\u00fe\u0102\5\32\16\2\u00ff\u0102\5\34\17\2\u0100"+
		"\u0102\5 \21\2\u0101\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2"+
		"\2\2\u0102\31\3\2\2\2\u0103\u0104\7-\2\2\u0104\33\3\2\2\2\u0105\u0106"+
		"\7.\2\2\u0106\35\3\2\2\2\u0107\u010a\5\32\16\2\u0108\u010a\5 \21\2\u0109"+
		"\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\37\3\2\2\2\u010b\u011a\7/\2\2"+
		"\u010c\u0115\7/\2\2\u010d\u010e\7)\2\2\u010e\u0111\5\36\20\2\u010f\u0110"+
		"\7\61\2\2\u0110\u0112\5\36\20\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2"+
		"\2\u0112\u0113\3\2\2\2\u0113\u0114\7*\2\2\u0114\u0116\3\2\2\2\u0115\u010d"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u011a\3\2\2\2\u0119\u010b\3\2\2\2\u0119\u010c\3\2\2\2\u011a!\3\2\2\2"+
		"\u011b\u011c\t\5\2\2\u011c#\3\2\2\2\u011d\u011f\t\6\2\2\u011e\u011d\3"+
		"\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"%\3\2\2\2\u0122\u0125\7\67\2\2\u0123\u0125\5 \21\2\u0124\u0122\3\2\2\2"+
		"\u0124\u0123\3\2\2\2\u0125\'\3\2\2\2\u0126\u012c\7)\2\2\u0127\u0128\5"+
		"\30\r\2\u0128\u0129\7\60\2\2\u0129\u012b\3\2\2\2\u012a\u0127\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0130\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012f\u0131\5\30\r\2\u0130\u012f\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7*\2\2\u0133)\3\2\2\2&"+
		"\60\65\67CRV`dikmx\177\u0085\u008b\u0091\u0097\u009d\u009f\u00aa\u00b2"+
		"\u00b4\u00bf\u00cf\u00f2\u00f4\u00fc\u0101\u0109\u0111\u0117\u0119\u0120"+
		"\u0124\u012c\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}