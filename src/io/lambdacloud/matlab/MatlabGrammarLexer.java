// Generated from MatlabGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud.matlab;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatlabGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, REM=8, POW=9, SOL=10, 
		DADD=11, DSUB=12, DMUL=13, DRDIV=14, DLDIV=15, AND=16, OR=17, NOT=18, 
		TRUE=19, FALSE=20, GT=21, GE=22, LT=23, LE=24, EQ=25, NEQ=26, BAND=27, 
		BOR=28, BXOR=29, BNOT=30, SHL=31, SHR=32, USHR=33, INC=34, DESC=35, ADD_ASSIGN=36, 
		SUB_ASSIGN=37, MUL_ASSIGN=38, DIV_ASSIGN=39, REM_ASSIGN=40, ASSIGN=41, 
		LPAREN=42, RPAREN=43, LBRK=44, RBRK=45, LCB=46, RCB=47, INTEGER=48, FLOAT=49, 
		IDENTIFIER=50, COMMA=51, COLON=52, SEMI=53, PERIOD=54, SQUOTE=55, DQUOTE=56, 
		COMMENT=57, SKIP_TOKEN=58, WS=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", 
		"DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", 
		"FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", 
		"SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'**'", "'\\'", "'.+'", "'.-'", "'.*'", "'./'", "'.\\'", null, null, null, 
		"'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", 
		"'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", 
		"DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", 
		"FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", 
		"SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
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


	public MatlabGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MatlabGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0144\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00ac\n\21\3\22\3\22\3\22\3\22\5\22\u00b2\n\22\3\23\3\23\3\23\3"+
		"\23\5\23\u00b8\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3"+
		"(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\6"+
		"\61\u010b\n\61\r\61\16\61\u010c\3\62\7\62\u0110\n\62\f\62\16\62\u0113"+
		"\13\62\3\62\3\62\7\62\u0117\n\62\f\62\16\62\u011a\13\62\3\63\3\63\7\63"+
		"\u011e\n\63\f\63\16\63\u0121\13\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3:\3:\6:\u0133\n:\r:\16:\u0134\3:\5:\u0138\n:"+
		"\3:\3:\3;\6;\u013d\n;\r;\16;\u013e\3;\3;\3<\3<\3\u0134\2=\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=\3\2"+
		"\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\3\2\16\17\4\2\13\13\"\"\u014c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y\3\2\2\2\5"+
		"{\3\2\2\2\7\u0084\3\2\2\2\t\u0088\3\2\2\2\13\u008a\3\2\2\2\r\u008c\3\2"+
		"\2\2\17\u008e\3\2\2\2\21\u0090\3\2\2\2\23\u0092\3\2\2\2\25\u0095\3\2\2"+
		"\2\27\u0097\3\2\2\2\31\u009a\3\2\2\2\33\u009d\3\2\2\2\35\u00a0\3\2\2\2"+
		"\37\u00a3\3\2\2\2!\u00ab\3\2\2\2#\u00b1\3\2\2\2%\u00b7\3\2\2\2\'\u00b9"+
		"\3\2\2\2)\u00be\3\2\2\2+\u00c4\3\2\2\2-\u00c6\3\2\2\2/\u00c9\3\2\2\2\61"+
		"\u00cb\3\2\2\2\63\u00ce\3\2\2\2\65\u00d1\3\2\2\2\67\u00d4\3\2\2\29\u00d6"+
		"\3\2\2\2;\u00d8\3\2\2\2=\u00da\3\2\2\2?\u00dc\3\2\2\2A\u00df\3\2\2\2C"+
		"\u00e2\3\2\2\2E\u00e6\3\2\2\2G\u00e9\3\2\2\2I\u00ec\3\2\2\2K\u00ef\3\2"+
		"\2\2M\u00f2\3\2\2\2O\u00f5\3\2\2\2Q\u00f8\3\2\2\2S\u00fb\3\2\2\2U\u00fd"+
		"\3\2\2\2W\u00ff\3\2\2\2Y\u0101\3\2\2\2[\u0103\3\2\2\2]\u0105\3\2\2\2_"+
		"\u0107\3\2\2\2a\u010a\3\2\2\2c\u0111\3\2\2\2e\u011b\3\2\2\2g\u0122\3\2"+
		"\2\2i\u0124\3\2\2\2k\u0126\3\2\2\2m\u0128\3\2\2\2o\u012a\3\2\2\2q\u012c"+
		"\3\2\2\2s\u012e\3\2\2\2u\u013c\3\2\2\2w\u0142\3\2\2\2yz\7\f\2\2z\4\3\2"+
		"\2\2{|\7h\2\2|}\7w\2\2}~\7p\2\2~\177\7e\2\2\177\u0080\7v\2\2\u0080\u0081"+
		"\7k\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083\6\3\2\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7p\2\2\u0086\u0087\7f\2\2\u0087\b\3\2\2\2\u0088\u0089"+
		"\7-\2\2\u0089\n\3\2\2\2\u008a\u008b\7/\2\2\u008b\f\3\2\2\2\u008c\u008d"+
		"\7,\2\2\u008d\16\3\2\2\2\u008e\u008f\7\61\2\2\u008f\20\3\2\2\2\u0090\u0091"+
		"\7\'\2\2\u0091\22\3\2\2\2\u0092\u0093\7,\2\2\u0093\u0094\7,\2\2\u0094"+
		"\24\3\2\2\2\u0095\u0096\7^\2\2\u0096\26\3\2\2\2\u0097\u0098\7\60\2\2\u0098"+
		"\u0099\7-\2\2\u0099\30\3\2\2\2\u009a\u009b\7\60\2\2\u009b\u009c\7/\2\2"+
		"\u009c\32\3\2\2\2\u009d\u009e\7\60\2\2\u009e\u009f\7,\2\2\u009f\34\3\2"+
		"\2\2\u00a0\u00a1\7\60\2\2\u00a1\u00a2\7\61\2\2\u00a2\36\3\2\2\2\u00a3"+
		"\u00a4\7\60\2\2\u00a4\u00a5\7^\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8\u00ac\7f\2\2\u00a9\u00aa\7(\2\2\u00aa\u00ac\7(\2\2"+
		"\u00ab\u00a6\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7"+
		"q\2\2\u00ae\u00b2\7t\2\2\u00af\u00b0\7~\2\2\u00b0\u00b2\7~\2\2\u00b1\u00ad"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2$\3\2\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5"+
		"\7q\2\2\u00b5\u00b8\7v\2\2\u00b6\u00b8\7#\2\2\u00b7\u00b3\3\2\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7t\2\2\u00bb"+
		"\u00bc\7w\2\2\u00bc\u00bd\7g\2\2\u00bd(\3\2\2\2\u00be\u00bf\7h\2\2\u00bf"+
		"\u00c0\7c\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3*\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7@\2\2\u00c7"+
		"\u00c8\7?\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\60\3\2\2\2\u00cb"+
		"\u00cc\7>\2\2\u00cc\u00cd\7?\2\2\u00cd\62\3\2\2\2\u00ce\u00cf\7?\2\2\u00cf"+
		"\u00d0\7?\2\2\u00d0\64\3\2\2\2\u00d1\u00d2\7#\2\2\u00d2\u00d3\7?\2\2\u00d3"+
		"\66\3\2\2\2\u00d4\u00d5\7(\2\2\u00d58\3\2\2\2\u00d6\u00d7\7~\2\2\u00d7"+
		":\3\2\2\2\u00d8\u00d9\7`\2\2\u00d9<\3\2\2\2\u00da\u00db\7\u0080\2\2\u00db"+
		">\3\2\2\2\u00dc\u00dd\7>\2\2\u00dd\u00de\7>\2\2\u00de@\3\2\2\2\u00df\u00e0"+
		"\7@\2\2\u00e0\u00e1\7@\2\2\u00e1B\3\2\2\2\u00e2\u00e3\7@\2\2\u00e3\u00e4"+
		"\7@\2\2\u00e4\u00e5\7@\2\2\u00e5D\3\2\2\2\u00e6\u00e7\7-\2\2\u00e7\u00e8"+
		"\7-\2\2\u00e8F\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea\u00eb\7/\2\2\u00ebH\3"+
		"\2\2\2\u00ec\u00ed\7-\2\2\u00ed\u00ee\7?\2\2\u00eeJ\3\2\2\2\u00ef\u00f0"+
		"\7/\2\2\u00f0\u00f1\7?\2\2\u00f1L\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3\u00f4"+
		"\7?\2\2\u00f4N\3\2\2\2\u00f5\u00f6\7\61\2\2\u00f6\u00f7\7?\2\2\u00f7P"+
		"\3\2\2\2\u00f8\u00f9\7\'\2\2\u00f9\u00fa\7?\2\2\u00faR\3\2\2\2\u00fb\u00fc"+
		"\7?\2\2\u00fcT\3\2\2\2\u00fd\u00fe\7*\2\2\u00feV\3\2\2\2\u00ff\u0100\7"+
		"+\2\2\u0100X\3\2\2\2\u0101\u0102\7]\2\2\u0102Z\3\2\2\2\u0103\u0104\7_"+
		"\2\2\u0104\\\3\2\2\2\u0105\u0106\7}\2\2\u0106^\3\2\2\2\u0107\u0108\7\177"+
		"\2\2\u0108`\3\2\2\2\u0109\u010b\t\2\2\2\u010a\u0109\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010db\3\2\2\2\u010e"+
		"\u0110\t\2\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0118\7\60\2\2\u0115\u0117\t\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119d\3\2\2\2\u011a\u0118"+
		"\3\2\2\2\u011b\u011f\t\3\2\2\u011c\u011e\t\4\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120f\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0122\u0123\7.\2\2\u0123h\3\2\2\2\u0124\u0125\7<"+
		"\2\2\u0125j\3\2\2\2\u0126\u0127\7=\2\2\u0127l\3\2\2\2\u0128\u0129\7\60"+
		"\2\2\u0129n\3\2\2\2\u012a\u012b\7)\2\2\u012bp\3\2\2\2\u012c\u012d\7$\2"+
		"\2\u012dr\3\2\2\2\u012e\u012f\7\61\2\2\u012f\u0130\7\61\2\2\u0130\u0132"+
		"\3\2\2\2\u0131\u0133\13\2\2\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0138"+
		"\t\5\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\b:\2\2\u013a"+
		"t\3\2\2\2\u013b\u013d\t\6\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141"+
		"\b;\2\2\u0141v\3\2\2\2\u0142\u0143\t\7\2\2\u0143x\3\2\2\2\r\2\u00ab\u00b1"+
		"\u00b7\u010c\u0111\u0118\u011f\u0134\u0137\u013e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}