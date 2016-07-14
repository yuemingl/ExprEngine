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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ADD=8, SUB=9, 
		MUL=10, DIV=11, REM=12, POW=13, AND=14, OR=15, NOT=16, TRUE=17, FALSE=18, 
		GT=19, GE=20, LT=21, LE=22, EQ=23, NEQ=24, BAND=25, BOR=26, BXOR=27, BNOT=28, 
		SHL=29, SHR=30, USHR=31, INC=32, DESC=33, ADD_ASSIGN=34, SUB_ASSIGN=35, 
		MUL_ASSIGN=36, DIV_ASSIGN=37, REM_ASSIGN=38, ASSIGN=39, LPAREN=40, RPAREN=41, 
		LBRK=42, RBRK=43, LCB=44, RCB=45, INTEGER=46, FLOAT=47, IDENTIFIER=48, 
		COMMA=49, COLON=50, SEMI=51, PERIOD=52, SQUOTE=53, DQUOTE=54, COMMENT=55, 
		WS=56, StringLiteral=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "ADD", "SUB", 
		"MUL", "DIV", "REM", "POW", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", 
		"GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
		"USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", 
		"INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", 
		"SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral", "Characters", "Character", 
		"EscapeSeq"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'sum'", "'\n'", "'in'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'**'", null, null, null, "'true'", "'false'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", 
		"'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, 
		"','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "POW", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", 
		"EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", 
		"DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u0155\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00a9\n\17\3\20"+
		"\3\20\3\20\3\20\5\20\u00af\n\20\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\6/\u0108\n/\r/\16"+
		"/\u0109\3\60\7\60\u010d\n\60\f\60\16\60\u0110\13\60\3\60\3\60\6\60\u0114"+
		"\n\60\r\60\16\60\u0115\3\61\3\61\7\61\u011a\n\61\f\61\16\61\u011d\13\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38"+
		"\38\68\u012f\n8\r8\168\u0130\38\58\u0134\n8\38\38\39\69\u0139\n9\r9\16"+
		"9\u013a\39\39\3:\3:\5:\u0141\n:\3:\5:\u0144\n:\3:\3:\5:\u0148\n:\3;\6"+
		";\u014b\n;\r;\16;\u014c\3<\3<\5<\u0151\n<\3=\3=\3=\3\u0130\2>\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u\2"+
		"w\2y\2\3\2\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\13\16\17"+
		"\"\"\5\2$$))^^\n\2$$))^^ddhhppttvv\u015f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\3{\3\2\2\2\5~\3\2\2\2\7\u0083\3\2\2\2\t\u0089\3\2\2\2\13\u008d"+
		"\3\2\2\2\r\u0091\3\2\2\2\17\u0093\3\2\2\2\21\u0096\3\2\2\2\23\u0098\3"+
		"\2\2\2\25\u009a\3\2\2\2\27\u009c\3\2\2\2\31\u009e\3\2\2\2\33\u00a0\3\2"+
		"\2\2\35\u00a8\3\2\2\2\37\u00ae\3\2\2\2!\u00b4\3\2\2\2#\u00b6\3\2\2\2%"+
		"\u00bb\3\2\2\2\'\u00c1\3\2\2\2)\u00c3\3\2\2\2+\u00c6\3\2\2\2-\u00c8\3"+
		"\2\2\2/\u00cb\3\2\2\2\61\u00ce\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2"+
		"\2\67\u00d5\3\2\2\29\u00d7\3\2\2\2;\u00d9\3\2\2\2=\u00dc\3\2\2\2?\u00df"+
		"\3\2\2\2A\u00e3\3\2\2\2C\u00e6\3\2\2\2E\u00e9\3\2\2\2G\u00ec\3\2\2\2I"+
		"\u00ef\3\2\2\2K\u00f2\3\2\2\2M\u00f5\3\2\2\2O\u00f8\3\2\2\2Q\u00fa\3\2"+
		"\2\2S\u00fc\3\2\2\2U\u00fe\3\2\2\2W\u0100\3\2\2\2Y\u0102\3\2\2\2[\u0104"+
		"\3\2\2\2]\u0107\3\2\2\2_\u010e\3\2\2\2a\u0117\3\2\2\2c\u011e\3\2\2\2e"+
		"\u0120\3\2\2\2g\u0122\3\2\2\2i\u0124\3\2\2\2k\u0126\3\2\2\2m\u0128\3\2"+
		"\2\2o\u012a\3\2\2\2q\u0138\3\2\2\2s\u0140\3\2\2\2u\u014a\3\2\2\2w\u0150"+
		"\3\2\2\2y\u0152\3\2\2\2{|\7k\2\2|}\7h\2\2}\4\3\2\2\2~\177\7g\2\2\177\u0080"+
		"\7n\2\2\u0080\u0081\7u\2\2\u0081\u0082\7g\2\2\u0082\6\3\2\2\2\u0083\u0084"+
		"\7y\2\2\u0084\u0085\7j\2\2\u0085\u0086\7k\2\2\u0086\u0087\7n\2\2\u0087"+
		"\u0088\7g\2\2\u0088\b\3\2\2\2\u0089\u008a\7h\2\2\u008a\u008b\7q\2\2\u008b"+
		"\u008c\7t\2\2\u008c\n\3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7w\2\2\u008f"+
		"\u0090\7o\2\2\u0090\f\3\2\2\2\u0091\u0092\7\f\2\2\u0092\16\3\2\2\2\u0093"+
		"\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095\20\3\2\2\2\u0096\u0097\7-\2\2\u0097"+
		"\22\3\2\2\2\u0098\u0099\7/\2\2\u0099\24\3\2\2\2\u009a\u009b\7,\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7\61\2\2\u009d\30\3\2\2\2\u009e\u009f\7\'\2\2"+
		"\u009f\32\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\7,\2\2\u00a2\34\3\2\2"+
		"\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a9\7f\2\2\u00a6\u00a7"+
		"\7(\2\2\u00a7\u00a9\7(\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\36\3\2\2\2\u00aa\u00ab\7q\2\2\u00ab\u00af\7t\2\2\u00ac\u00ad\7~\2\2\u00ad"+
		"\u00af\7~\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af \3\2\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b5\7v\2\2\u00b3\u00b5\7#\2\2"+
		"\u00b4\u00b0\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\"\3\2\2\2\u00b6\u00b7\7"+
		"v\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7g\2\2\u00ba$"+
		"\3\2\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7n\2\2\u00be"+
		"\u00bf\7u\2\2\u00bf\u00c0\7g\2\2\u00c0&\3\2\2\2\u00c1\u00c2\7@\2\2\u00c2"+
		"(\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\u00c5\7?\2\2\u00c5*\3\2\2\2\u00c6\u00c7"+
		"\7>\2\2\u00c7,\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca\7?\2\2\u00ca.\3"+
		"\2\2\2\u00cb\u00cc\7?\2\2\u00cc\u00cd\7?\2\2\u00cd\60\3\2\2\2\u00ce\u00cf"+
		"\7#\2\2\u00cf\u00d0\7?\2\2\u00d0\62\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2\64"+
		"\3\2\2\2\u00d3\u00d4\7~\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\7`\2\2\u00d6"+
		"8\3\2\2\2\u00d7\u00d8\7\u0080\2\2\u00d8:\3\2\2\2\u00d9\u00da\7>\2\2\u00da"+
		"\u00db\7>\2\2\u00db<\3\2\2\2\u00dc\u00dd\7@\2\2\u00dd\u00de\7@\2\2\u00de"+
		">\3\2\2\2\u00df\u00e0\7@\2\2\u00e0\u00e1\7@\2\2\u00e1\u00e2\7@\2\2\u00e2"+
		"@\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4\u00e5\7-\2\2\u00e5B\3\2\2\2\u00e6\u00e7"+
		"\7/\2\2\u00e7\u00e8\7/\2\2\u00e8D\3\2\2\2\u00e9\u00ea\7-\2\2\u00ea\u00eb"+
		"\7?\2\2\u00ebF\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed\u00ee\7?\2\2\u00eeH\3"+
		"\2\2\2\u00ef\u00f0\7,\2\2\u00f0\u00f1\7?\2\2\u00f1J\3\2\2\2\u00f2\u00f3"+
		"\7\61\2\2\u00f3\u00f4\7?\2\2\u00f4L\3\2\2\2\u00f5\u00f6\7\'\2\2\u00f6"+
		"\u00f7\7?\2\2\u00f7N\3\2\2\2\u00f8\u00f9\7?\2\2\u00f9P\3\2\2\2\u00fa\u00fb"+
		"\7*\2\2\u00fbR\3\2\2\2\u00fc\u00fd\7+\2\2\u00fdT\3\2\2\2\u00fe\u00ff\7"+
		"]\2\2\u00ffV\3\2\2\2\u0100\u0101\7_\2\2\u0101X\3\2\2\2\u0102\u0103\7}"+
		"\2\2\u0103Z\3\2\2\2\u0104\u0105\7\177\2\2\u0105\\\3\2\2\2\u0106\u0108"+
		"\t\2\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a^\3\2\2\2\u010b\u010d\t\2\2\2\u010c\u010b\3\2\2\2"+
		"\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\7\60\2\2\u0112\u0114\t\2\2\2"+
		"\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116`\3\2\2\2\u0117\u011b\t\3\2\2\u0118\u011a\t\4\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011cb\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7.\2\2\u011fd\3\2"+
		"\2\2\u0120\u0121\7<\2\2\u0121f\3\2\2\2\u0122\u0123\7=\2\2\u0123h\3\2\2"+
		"\2\u0124\u0125\7\60\2\2\u0125j\3\2\2\2\u0126\u0127\7)\2\2\u0127l\3\2\2"+
		"\2\u0128\u0129\7$\2\2\u0129n\3\2\2\2\u012a\u012b\7\61\2\2\u012b\u012c"+
		"\7\61\2\2\u012c\u012e\3\2\2\2\u012d\u012f\13\2\2\2\u012e\u012d\3\2\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0133"+
		"\3\2\2\2\u0132\u0134\t\5\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\b8\2\2\u0136p\3\2\2\2\u0137\u0139\t\6\2\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013d\b9\2\2\u013dr\3\2\2\2\u013e\u0141\5m\67\2\u013f\u0141"+
		"\5k\66\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0143\3\2\2\2\u0142"+
		"\u0144\5u;\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0147\3\2\2"+
		"\2\u0145\u0148\5m\67\2\u0146\u0148\5k\66\2\u0147\u0145\3\2\2\2\u0147\u0146"+
		"\3\2\2\2\u0148t\3\2\2\2\u0149\u014b\5w<\2\u014a\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014dv\3\2\2\2\u014e"+
		"\u0151\n\7\2\2\u014f\u0151\5y=\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2\2"+
		"\2\u0151x\3\2\2\2\u0152\u0153\7^\2\2\u0153\u0154\t\b\2\2\u0154z\3\2\2"+
		"\2\22\2\u00a8\u00ae\u00b4\u0109\u010e\u0115\u011b\u0130\u0133\u013a\u0140"+
		"\u0143\u0147\u014c\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}