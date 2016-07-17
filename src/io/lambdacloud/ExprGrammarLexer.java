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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ADD=10, SUB=11, MUL=12, DIV=13, REM=14, POW=15, AND=16, OR=17, NOT=18, 
		TRUE=19, FALSE=20, GT=21, GE=22, LT=23, LE=24, EQ=25, NEQ=26, BAND=27, 
		BOR=28, BXOR=29, BNOT=30, SHL=31, SHR=32, USHR=33, INC=34, DESC=35, ADD_ASSIGN=36, 
		SUB_ASSIGN=37, MUL_ASSIGN=38, DIV_ASSIGN=39, REM_ASSIGN=40, ASSIGN=41, 
		LPAREN=42, RPAREN=43, LBRK=44, RBRK=45, LCB=46, RCB=47, INTEGER=48, FLOAT=49, 
		IDENTIFIER=50, COMMA=51, COLON=52, SEMI=53, PERIOD=54, SQUOTE=55, DQUOTE=56, 
		COMMENT=57, WS=58, StringLiteral=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ADD", "SUB", "MUL", "DIV", "REM", "POW", "AND", "OR", "NOT", "TRUE", 
		"FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", 
		"SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral", "Characters", 
		"Character", "EscapeSeq"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'def'", "'return'", "'sum'", 
		"'\n'", "'in'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", null, null, 
		null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
		"'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ADD", "SUB", 
		"MUL", "DIV", "REM", "POW", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", 
		"GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0164\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00b8\n\21\3\22\3\22\3\22"+
		"\3\22\5\22\u00be\n\22\3\23\3\23\3\23\3\23\5\23\u00c4\n\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$"+
		"\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,"+
		"\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\6\61\u0117\n\61\r\61\16\61\u0118"+
		"\3\62\7\62\u011c\n\62\f\62\16\62\u011f\13\62\3\62\3\62\6\62\u0123\n\62"+
		"\r\62\16\62\u0124\3\63\3\63\7\63\u0129\n\63\f\63\16\63\u012c\13\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3:\6:\u013e\n"+
		":\r:\16:\u013f\3:\5:\u0143\n:\3:\3:\3;\6;\u0148\n;\r;\16;\u0149\3;\3;"+
		"\3<\3<\5<\u0150\n<\3<\5<\u0153\n<\3<\3<\5<\u0157\n<\3=\6=\u015a\n=\r="+
		"\16=\u015b\3>\3>\5>\u0160\n>\3?\3?\3?\3\u013f\2@\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y\2{\2}\2\3\2"+
		"\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\13\16\17\"\"\5\2$"+
		"$))^^\n\2$$))^^ddhhppttvv\u016e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\3\177\3\2\2\2\5\u0082\3\2\2\2\7\u0087\3\2\2\2\t\u008d"+
		"\3\2\2\2\13\u0091\3\2\2\2\r\u0095\3\2\2\2\17\u009c\3\2\2\2\21\u00a0\3"+
		"\2\2\2\23\u00a2\3\2\2\2\25\u00a5\3\2\2\2\27\u00a7\3\2\2\2\31\u00a9\3\2"+
		"\2\2\33\u00ab\3\2\2\2\35\u00ad\3\2\2\2\37\u00af\3\2\2\2!\u00b7\3\2\2\2"+
		"#\u00bd\3\2\2\2%\u00c3\3\2\2\2\'\u00c5\3\2\2\2)\u00ca\3\2\2\2+\u00d0\3"+
		"\2\2\2-\u00d2\3\2\2\2/\u00d5\3\2\2\2\61\u00d7\3\2\2\2\63\u00da\3\2\2\2"+
		"\65\u00dd\3\2\2\2\67\u00e0\3\2\2\29\u00e2\3\2\2\2;\u00e4\3\2\2\2=\u00e6"+
		"\3\2\2\2?\u00e8\3\2\2\2A\u00eb\3\2\2\2C\u00ee\3\2\2\2E\u00f2\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f8\3\2\2\2K\u00fb\3\2\2\2M\u00fe\3\2\2\2O\u0101\3\2"+
		"\2\2Q\u0104\3\2\2\2S\u0107\3\2\2\2U\u0109\3\2\2\2W\u010b\3\2\2\2Y\u010d"+
		"\3\2\2\2[\u010f\3\2\2\2]\u0111\3\2\2\2_\u0113\3\2\2\2a\u0116\3\2\2\2c"+
		"\u011d\3\2\2\2e\u0126\3\2\2\2g\u012d\3\2\2\2i\u012f\3\2\2\2k\u0131\3\2"+
		"\2\2m\u0133\3\2\2\2o\u0135\3\2\2\2q\u0137\3\2\2\2s\u0139\3\2\2\2u\u0147"+
		"\3\2\2\2w\u014f\3\2\2\2y\u0159\3\2\2\2{\u015f\3\2\2\2}\u0161\3\2\2\2\177"+
		"\u0080\7k\2\2\u0080\u0081\7h\2\2\u0081\4\3\2\2\2\u0082\u0083\7g\2\2\u0083"+
		"\u0084\7n\2\2\u0084\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086\6\3\2\2\2\u0087"+
		"\u0088\7y\2\2\u0088\u0089\7j\2\2\u0089\u008a\7k\2\2\u008a\u008b\7n\2\2"+
		"\u008b\u008c\7g\2\2\u008c\b\3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f\7q"+
		"\2\2\u008f\u0090\7t\2\2\u0090\n\3\2\2\2\u0091\u0092\7f\2\2\u0092\u0093"+
		"\7g\2\2\u0093\u0094\7h\2\2\u0094\f\3\2\2\2\u0095\u0096\7t\2\2\u0096\u0097"+
		"\7g\2\2\u0097\u0098\7v\2\2\u0098\u0099\7w\2\2\u0099\u009a\7t\2\2\u009a"+
		"\u009b\7p\2\2\u009b\16\3\2\2\2\u009c\u009d\7u\2\2\u009d\u009e\7w\2\2\u009e"+
		"\u009f\7o\2\2\u009f\20\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1\22\3\2\2\2\u00a2"+
		"\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6"+
		"\26\3\2\2\2\u00a7\u00a8\7/\2\2\u00a8\30\3\2\2\2\u00a9\u00aa\7,\2\2\u00aa"+
		"\32\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\34\3\2\2\2\u00ad\u00ae\7\'\2\2"+
		"\u00ae\36\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\u00b1\7,\2\2\u00b1 \3\2\2\2"+
		"\u00b2\u00b3\7c\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b8\7f\2\2\u00b5\u00b6"+
		"\7(\2\2\u00b6\u00b8\7(\2\2\u00b7\u00b2\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\"\3\2\2\2\u00b9\u00ba\7q\2\2\u00ba\u00be\7t\2\2\u00bb\u00bc\7~\2\2\u00bc"+
		"\u00be\7~\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be$\3\2\2\2\u00bf"+
		"\u00c0\7p\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c4\7v\2\2\u00c2\u00c4\7#\2\2"+
		"\u00c3\u00bf\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4&\3\2\2\2\u00c5\u00c6\7"+
		"v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7g\2\2\u00c9("+
		"\3\2\2\2\u00ca\u00cb\7h\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7n\2\2\u00cd"+
		"\u00ce\7u\2\2\u00ce\u00cf\7g\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7@\2\2\u00d1"+
		",\3\2\2\2\u00d2\u00d3\7@\2\2\u00d3\u00d4\7?\2\2\u00d4.\3\2\2\2\u00d5\u00d6"+
		"\7>\2\2\u00d6\60\3\2\2\2\u00d7\u00d8\7>\2\2\u00d8\u00d9\7?\2\2\u00d9\62"+
		"\3\2\2\2\u00da\u00db\7?\2\2\u00db\u00dc\7?\2\2\u00dc\64\3\2\2\2\u00dd"+
		"\u00de\7#\2\2\u00de\u00df\7?\2\2\u00df\66\3\2\2\2\u00e0\u00e1\7(\2\2\u00e1"+
		"8\3\2\2\2\u00e2\u00e3\7~\2\2\u00e3:\3\2\2\2\u00e4\u00e5\7`\2\2\u00e5<"+
		"\3\2\2\2\u00e6\u00e7\7\u0080\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9"+
		"\u00ea\7>\2\2\u00ea@\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec\u00ed\7@\2\2\u00ed"+
		"B\3\2\2\2\u00ee\u00ef\7@\2\2\u00ef\u00f0\7@\2\2\u00f0\u00f1\7@\2\2\u00f1"+
		"D\3\2\2\2\u00f2\u00f3\7-\2\2\u00f3\u00f4\7-\2\2\u00f4F\3\2\2\2\u00f5\u00f6"+
		"\7/\2\2\u00f6\u00f7\7/\2\2\u00f7H\3\2\2\2\u00f8\u00f9\7-\2\2\u00f9\u00fa"+
		"\7?\2\2\u00faJ\3\2\2\2\u00fb\u00fc\7/\2\2\u00fc\u00fd\7?\2\2\u00fdL\3"+
		"\2\2\2\u00fe\u00ff\7,\2\2\u00ff\u0100\7?\2\2\u0100N\3\2\2\2\u0101\u0102"+
		"\7\61\2\2\u0102\u0103\7?\2\2\u0103P\3\2\2\2\u0104\u0105\7\'\2\2\u0105"+
		"\u0106\7?\2\2\u0106R\3\2\2\2\u0107\u0108\7?\2\2\u0108T\3\2\2\2\u0109\u010a"+
		"\7*\2\2\u010aV\3\2\2\2\u010b\u010c\7+\2\2\u010cX\3\2\2\2\u010d\u010e\7"+
		"]\2\2\u010eZ\3\2\2\2\u010f\u0110\7_\2\2\u0110\\\3\2\2\2\u0111\u0112\7"+
		"}\2\2\u0112^\3\2\2\2\u0113\u0114\7\177\2\2\u0114`\3\2\2\2\u0115\u0117"+
		"\t\2\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119b\3\2\2\2\u011a\u011c\t\2\2\2\u011b\u011a\3\2\2\2"+
		"\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120"+
		"\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0122\7\60\2\2\u0121\u0123\t\2\2\2"+
		"\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125d\3\2\2\2\u0126\u012a\t\3\2\2\u0127\u0129\t\4\2\2\u0128"+
		"\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012bf\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7.\2\2\u012eh\3\2"+
		"\2\2\u012f\u0130\7<\2\2\u0130j\3\2\2\2\u0131\u0132\7=\2\2\u0132l\3\2\2"+
		"\2\u0133\u0134\7\60\2\2\u0134n\3\2\2\2\u0135\u0136\7)\2\2\u0136p\3\2\2"+
		"\2\u0137\u0138\7$\2\2\u0138r\3\2\2\2\u0139\u013a\7\61\2\2\u013a\u013b"+
		"\7\61\2\2\u013b\u013d\3\2\2\2\u013c\u013e\13\2\2\2\u013d\u013c\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0142"+
		"\3\2\2\2\u0141\u0143\t\5\2\2\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0145\b:\2\2\u0145t\3\2\2\2\u0146\u0148\t\6\2\2\u0147\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014c\b;\2\2\u014cv\3\2\2\2\u014d\u0150\5q9\2\u014e\u0150\5"+
		"o8\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u0153\5y=\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0156\3\2\2"+
		"\2\u0154\u0157\5q9\2\u0155\u0157\5o8\2\u0156\u0154\3\2\2\2\u0156\u0155"+
		"\3\2\2\2\u0157x\3\2\2\2\u0158\u015a\5{>\2\u0159\u0158\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cz\3\2\2\2\u015d"+
		"\u0160\n\7\2\2\u015e\u0160\5}?\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2"+
		"\2\u0160|\3\2\2\2\u0161\u0162\7^\2\2\u0162\u0163\t\b\2\2\u0163~\3\2\2"+
		"\2\22\2\u00b7\u00bd\u00c3\u0118\u011d\u0124\u012a\u013f\u0142\u0149\u014f"+
		"\u0152\u0156\u015b\u015f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}