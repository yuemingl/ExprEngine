// Generated from ExprGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprGrammarLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "ADD", 
		"SUB", "MUL", "DIV", "REM", "POW", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", 
		"SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral", "Characters", 
		"Character", "EscapeSeq"
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


	public ExprGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u015b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00af\n\20\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3\22\3\22\3"+
		"\22\3\22\5\22\u00bb\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3"+
		"\60\6\60\u010e\n\60\r\60\16\60\u010f\3\61\7\61\u0113\n\61\f\61\16\61\u0116"+
		"\13\61\3\61\3\61\6\61\u011a\n\61\r\61\16\61\u011b\3\62\3\62\7\62\u0120"+
		"\n\62\f\62\16\62\u0123\13\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\39\39\39\39\69\u0135\n9\r9\169\u0136\39\59\u013a\n9\39"+
		"\39\3:\6:\u013f\n:\r:\16:\u0140\3:\3:\3;\3;\5;\u0147\n;\3;\5;\u014a\n"+
		";\3;\3;\5;\u014e\n;\3<\6<\u0151\n<\r<\16<\u0152\3=\3=\5=\u0157\n=\3>\3"+
		">\3>\3\u0136\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u<w\2y\2{\2\3\2\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aa"+
		"c|\3\3\f\f\5\2\13\13\16\17\"\"\5\2$$))^^\n\2$$))^^ddhhppttvv\u0165\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3}\3\2\2\2\5\u0080\3\2\2\2"+
		"\7\u0085\3\2\2\2\t\u008b\3\2\2\2\13\u008f\3\2\2\2\r\u0093\3\2\2\2\17\u0097"+
		"\3\2\2\2\21\u0099\3\2\2\2\23\u009c\3\2\2\2\25\u009e\3\2\2\2\27\u00a0\3"+
		"\2\2\2\31\u00a2\3\2\2\2\33\u00a4\3\2\2\2\35\u00a6\3\2\2\2\37\u00ae\3\2"+
		"\2\2!\u00b4\3\2\2\2#\u00ba\3\2\2\2%\u00bc\3\2\2\2\'\u00c1\3\2\2\2)\u00c7"+
		"\3\2\2\2+\u00c9\3\2\2\2-\u00cc\3\2\2\2/\u00ce\3\2\2\2\61\u00d1\3\2\2\2"+
		"\63\u00d4\3\2\2\2\65\u00d7\3\2\2\2\67\u00d9\3\2\2\29\u00db\3\2\2\2;\u00dd"+
		"\3\2\2\2=\u00df\3\2\2\2?\u00e2\3\2\2\2A\u00e5\3\2\2\2C\u00e9\3\2\2\2E"+
		"\u00ec\3\2\2\2G\u00ef\3\2\2\2I\u00f2\3\2\2\2K\u00f5\3\2\2\2M\u00f8\3\2"+
		"\2\2O\u00fb\3\2\2\2Q\u00fe\3\2\2\2S\u0100\3\2\2\2U\u0102\3\2\2\2W\u0104"+
		"\3\2\2\2Y\u0106\3\2\2\2[\u0108\3\2\2\2]\u010a\3\2\2\2_\u010d\3\2\2\2a"+
		"\u0114\3\2\2\2c\u011d\3\2\2\2e\u0124\3\2\2\2g\u0126\3\2\2\2i\u0128\3\2"+
		"\2\2k\u012a\3\2\2\2m\u012c\3\2\2\2o\u012e\3\2\2\2q\u0130\3\2\2\2s\u013e"+
		"\3\2\2\2u\u0146\3\2\2\2w\u0150\3\2\2\2y\u0156\3\2\2\2{\u0158\3\2\2\2}"+
		"~\7k\2\2~\177\7h\2\2\177\4\3\2\2\2\u0080\u0081\7g\2\2\u0081\u0082\7n\2"+
		"\2\u0082\u0083\7u\2\2\u0083\u0084\7g\2\2\u0084\6\3\2\2\2\u0085\u0086\7"+
		"y\2\2\u0086\u0087\7j\2\2\u0087\u0088\7k\2\2\u0088\u0089\7n\2\2\u0089\u008a"+
		"\7g\2\2\u008a\b\3\2\2\2\u008b\u008c\7h\2\2\u008c\u008d\7q\2\2\u008d\u008e"+
		"\7t\2\2\u008e\n\3\2\2\2\u008f\u0090\7f\2\2\u0090\u0091\7g\2\2\u0091\u0092"+
		"\7h\2\2\u0092\f\3\2\2\2\u0093\u0094\7u\2\2\u0094\u0095\7w\2\2\u0095\u0096"+
		"\7o\2\2\u0096\16\3\2\2\2\u0097\u0098\7\f\2\2\u0098\20\3\2\2\2\u0099\u009a"+
		"\7k\2\2\u009a\u009b\7p\2\2\u009b\22\3\2\2\2\u009c\u009d\7-\2\2\u009d\24"+
		"\3\2\2\2\u009e\u009f\7/\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1"+
		"\30\3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3\32\3\2\2\2\u00a4\u00a5\7\'\2\2"+
		"\u00a5\34\3\2\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8\7,\2\2\u00a8\36\3\2\2"+
		"\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7p\2\2\u00ab\u00af\7f\2\2\u00ac\u00ad"+
		"\7(\2\2\u00ad\u00af\7(\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		" \3\2\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b5\7t\2\2\u00b2\u00b3\7~\2\2\u00b3"+
		"\u00b5\7~\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\"\3\2\2\2"+
		"\u00b6\u00b7\7p\2\2\u00b7\u00b8\7q\2\2\u00b8\u00bb\7v\2\2\u00b9\u00bb"+
		"\7#\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb$\3\2\2\2\u00bc\u00bd"+
		"\7v\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"&\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7u\2\2\u00c5\u00c6\7g\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7@\2\2\u00c8"+
		"*\3\2\2\2\u00c9\u00ca\7@\2\2\u00ca\u00cb\7?\2\2\u00cb,\3\2\2\2\u00cc\u00cd"+
		"\7>\2\2\u00cd.\3\2\2\2\u00ce\u00cf\7>\2\2\u00cf\u00d0\7?\2\2\u00d0\60"+
		"\3\2\2\2\u00d1\u00d2\7?\2\2\u00d2\u00d3\7?\2\2\u00d3\62\3\2\2\2\u00d4"+
		"\u00d5\7#\2\2\u00d5\u00d6\7?\2\2\u00d6\64\3\2\2\2\u00d7\u00d8\7(\2\2\u00d8"+
		"\66\3\2\2\2\u00d9\u00da\7~\2\2\u00da8\3\2\2\2\u00db\u00dc\7`\2\2\u00dc"+
		":\3\2\2\2\u00dd\u00de\7\u0080\2\2\u00de<\3\2\2\2\u00df\u00e0\7>\2\2\u00e0"+
		"\u00e1\7>\2\2\u00e1>\3\2\2\2\u00e2\u00e3\7@\2\2\u00e3\u00e4\7@\2\2\u00e4"+
		"@\3\2\2\2\u00e5\u00e6\7@\2\2\u00e6\u00e7\7@\2\2\u00e7\u00e8\7@\2\2\u00e8"+
		"B\3\2\2\2\u00e9\u00ea\7-\2\2\u00ea\u00eb\7-\2\2\u00ebD\3\2\2\2\u00ec\u00ed"+
		"\7/\2\2\u00ed\u00ee\7/\2\2\u00eeF\3\2\2\2\u00ef\u00f0\7-\2\2\u00f0\u00f1"+
		"\7?\2\2\u00f1H\3\2\2\2\u00f2\u00f3\7/\2\2\u00f3\u00f4\7?\2\2\u00f4J\3"+
		"\2\2\2\u00f5\u00f6\7,\2\2\u00f6\u00f7\7?\2\2\u00f7L\3\2\2\2\u00f8\u00f9"+
		"\7\61\2\2\u00f9\u00fa\7?\2\2\u00faN\3\2\2\2\u00fb\u00fc\7\'\2\2\u00fc"+
		"\u00fd\7?\2\2\u00fdP\3\2\2\2\u00fe\u00ff\7?\2\2\u00ffR\3\2\2\2\u0100\u0101"+
		"\7*\2\2\u0101T\3\2\2\2\u0102\u0103\7+\2\2\u0103V\3\2\2\2\u0104\u0105\7"+
		"]\2\2\u0105X\3\2\2\2\u0106\u0107\7_\2\2\u0107Z\3\2\2\2\u0108\u0109\7}"+
		"\2\2\u0109\\\3\2\2\2\u010a\u010b\7\177\2\2\u010b^\3\2\2\2\u010c\u010e"+
		"\t\2\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110`\3\2\2\2\u0111\u0113\t\2\2\2\u0112\u0111\3\2\2\2"+
		"\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0119\7\60\2\2\u0118\u011a\t\2\2\2"+
		"\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011cb\3\2\2\2\u011d\u0121\t\3\2\2\u011e\u0120\t\4\2\2\u011f"+
		"\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122d\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7.\2\2\u0125f\3\2"+
		"\2\2\u0126\u0127\7<\2\2\u0127h\3\2\2\2\u0128\u0129\7=\2\2\u0129j\3\2\2"+
		"\2\u012a\u012b\7\60\2\2\u012bl\3\2\2\2\u012c\u012d\7)\2\2\u012dn\3\2\2"+
		"\2\u012e\u012f\7$\2\2\u012fp\3\2\2\2\u0130\u0131\7\61\2\2\u0131\u0132"+
		"\7\61\2\2\u0132\u0134\3\2\2\2\u0133\u0135\13\2\2\2\u0134\u0133\3\2\2\2"+
		"\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u013a\t\5\2\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\b9\2\2\u013cr\3\2\2\2\u013d\u013f\t\6\2\2\u013e\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\b:\2\2\u0143t\3\2\2\2\u0144\u0147\5o8\2\u0145\u0147\5"+
		"m\67\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u014a\5w<\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014d\3\2\2"+
		"\2\u014b\u014e\5o8\2\u014c\u014e\5m\67\2\u014d\u014b\3\2\2\2\u014d\u014c"+
		"\3\2\2\2\u014ev\3\2\2\2\u014f\u0151\5y=\2\u0150\u014f\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153x\3\2\2\2\u0154"+
		"\u0157\n\7\2\2\u0155\u0157\5{>\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2"+
		"\2\u0157z\3\2\2\2\u0158\u0159\7^\2\2\u0159\u015a\t\b\2\2\u015a|\3\2\2"+
		"\2\22\2\u00ae\u00b4\u00ba\u010f\u0114\u011b\u0121\u0136\u0139\u0140\u0146"+
		"\u0149\u014d\u0152\u0156\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}