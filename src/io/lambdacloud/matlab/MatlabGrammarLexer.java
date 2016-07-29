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
		T__0=1, ADD=2, SUB=3, MUL=4, DIV=5, REM=6, POW=7, SOL=8, DADD=9, DSUB=10, 
		DMUL=11, DRDIV=12, DLDIV=13, AND=14, OR=15, NOT=16, TRUE=17, FALSE=18, 
		GT=19, GE=20, LT=21, LE=22, EQ=23, NEQ=24, BAND=25, BOR=26, BXOR=27, BNOT=28, 
		SHL=29, SHR=30, USHR=31, INC=32, DESC=33, ADD_ASSIGN=34, SUB_ASSIGN=35, 
		MUL_ASSIGN=36, DIV_ASSIGN=37, REM_ASSIGN=38, ASSIGN=39, LPAREN=40, RPAREN=41, 
		LBRK=42, RBRK=43, LCB=44, RCB=45, INTEGER=46, FLOAT=47, IDENTIFIER=48, 
		COMMA=49, COLON=50, SEMI=51, PERIOD=52, SQUOTE=53, DQUOTE=54, COMMENT=55, 
		SKIP_TOKEN=56, WS=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", 
		"DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
		"USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", 
		"INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", 
		"SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'\\'", "'.+'", 
		"'.-'", "'.*'", "'./'", "'.\\'", null, null, null, "'true'", "'false'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", 
		"'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, 
		"','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", 
		"DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
		"USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", 
		"INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", 
		"SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u0133\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u009b\n\17\3\20\3\20\3\20\3\20\5\20\u00a1\n\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00a7\n\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%"+
		"\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\6/\u00fa\n/\r/\16/\u00fb\3\60\7\60\u00ff\n\60\f\60\16\60\u0102\13"+
		"\60\3\60\3\60\7\60\u0106\n\60\f\60\16\60\u0109\13\60\3\61\3\61\7\61\u010d"+
		"\n\61\f\61\16\61\u0110\13\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\38\38\68\u0122\n8\r8\168\u0123\38\58\u0127\n"+
		"8\38\38\39\69\u012c\n9\r9\169\u012d\39\39\3:\3:\3\u0123\2;\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;\3\2\b\3"+
		"\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\3\2\16\17\4\2\13\13\"\"\u013b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5w\3\2\2\2\7y\3\2\2\2\t"+
		"{\3\2\2\2\13}\3\2\2\2\r\177\3\2\2\2\17\u0081\3\2\2\2\21\u0084\3\2\2\2"+
		"\23\u0086\3\2\2\2\25\u0089\3\2\2\2\27\u008c\3\2\2\2\31\u008f\3\2\2\2\33"+
		"\u0092\3\2\2\2\35\u009a\3\2\2\2\37\u00a0\3\2\2\2!\u00a6\3\2\2\2#\u00a8"+
		"\3\2\2\2%\u00ad\3\2\2\2\'\u00b3\3\2\2\2)\u00b5\3\2\2\2+\u00b8\3\2\2\2"+
		"-\u00ba\3\2\2\2/\u00bd\3\2\2\2\61\u00c0\3\2\2\2\63\u00c3\3\2\2\2\65\u00c5"+
		"\3\2\2\2\67\u00c7\3\2\2\29\u00c9\3\2\2\2;\u00cb\3\2\2\2=\u00ce\3\2\2\2"+
		"?\u00d1\3\2\2\2A\u00d5\3\2\2\2C\u00d8\3\2\2\2E\u00db\3\2\2\2G\u00de\3"+
		"\2\2\2I\u00e1\3\2\2\2K\u00e4\3\2\2\2M\u00e7\3\2\2\2O\u00ea\3\2\2\2Q\u00ec"+
		"\3\2\2\2S\u00ee\3\2\2\2U\u00f0\3\2\2\2W\u00f2\3\2\2\2Y\u00f4\3\2\2\2["+
		"\u00f6\3\2\2\2]\u00f9\3\2\2\2_\u0100\3\2\2\2a\u010a\3\2\2\2c\u0111\3\2"+
		"\2\2e\u0113\3\2\2\2g\u0115\3\2\2\2i\u0117\3\2\2\2k\u0119\3\2\2\2m\u011b"+
		"\3\2\2\2o\u011d\3\2\2\2q\u012b\3\2\2\2s\u0131\3\2\2\2uv\7\f\2\2v\4\3\2"+
		"\2\2wx\7-\2\2x\6\3\2\2\2yz\7/\2\2z\b\3\2\2\2{|\7,\2\2|\n\3\2\2\2}~\7\61"+
		"\2\2~\f\3\2\2\2\177\u0080\7\'\2\2\u0080\16\3\2\2\2\u0081\u0082\7,\2\2"+
		"\u0082\u0083\7,\2\2\u0083\20\3\2\2\2\u0084\u0085\7^\2\2\u0085\22\3\2\2"+
		"\2\u0086\u0087\7\60\2\2\u0087\u0088\7-\2\2\u0088\24\3\2\2\2\u0089\u008a"+
		"\7\60\2\2\u008a\u008b\7/\2\2\u008b\26\3\2\2\2\u008c\u008d\7\60\2\2\u008d"+
		"\u008e\7,\2\2\u008e\30\3\2\2\2\u008f\u0090\7\60\2\2\u0090\u0091\7\61\2"+
		"\2\u0091\32\3\2\2\2\u0092\u0093\7\60\2\2\u0093\u0094\7^\2\2\u0094\34\3"+
		"\2\2\2\u0095\u0096\7c\2\2\u0096\u0097\7p\2\2\u0097\u009b\7f\2\2\u0098"+
		"\u0099\7(\2\2\u0099\u009b\7(\2\2\u009a\u0095\3\2\2\2\u009a\u0098\3\2\2"+
		"\2\u009b\36\3\2\2\2\u009c\u009d\7q\2\2\u009d\u00a1\7t\2\2\u009e\u009f"+
		"\7~\2\2\u009f\u00a1\7~\2\2\u00a0\u009c\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		" \3\2\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a7\7v\2\2\u00a5"+
		"\u00a7\7#\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\"\3\2\2\2"+
		"\u00a8\u00a9\7v\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac"+
		"\7g\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7c\2\2\u00af\u00b0"+
		"\7n\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7g\2\2\u00b2&\3\2\2\2\u00b3\u00b4"+
		"\7@\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7@\2\2\u00b6\u00b7\7?\2\2\u00b7*\3"+
		"\2\2\2\u00b8\u00b9\7>\2\2\u00b9,\3\2\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bc"+
		"\7?\2\2\u00bc.\3\2\2\2\u00bd\u00be\7?\2\2\u00be\u00bf\7?\2\2\u00bf\60"+
		"\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\u00c2\7?\2\2\u00c2\62\3\2\2\2\u00c3"+
		"\u00c4\7(\2\2\u00c4\64\3\2\2\2\u00c5\u00c6\7~\2\2\u00c6\66\3\2\2\2\u00c7"+
		"\u00c8\7`\2\2\u00c88\3\2\2\2\u00c9\u00ca\7\u0080\2\2\u00ca:\3\2\2\2\u00cb"+
		"\u00cc\7>\2\2\u00cc\u00cd\7>\2\2\u00cd<\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf"+
		"\u00d0\7@\2\2\u00d0>\3\2\2\2\u00d1\u00d2\7@\2\2\u00d2\u00d3\7@\2\2\u00d3"+
		"\u00d4\7@\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7-\2\2\u00d6\u00d7\7-\2\2\u00d7"+
		"B\3\2\2\2\u00d8\u00d9\7/\2\2\u00d9\u00da\7/\2\2\u00daD\3\2\2\2\u00db\u00dc"+
		"\7-\2\2\u00dc\u00dd\7?\2\2\u00ddF\3\2\2\2\u00de\u00df\7/\2\2\u00df\u00e0"+
		"\7?\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7,\2\2\u00e2\u00e3\7?\2\2\u00e3J\3"+
		"\2\2\2\u00e4\u00e5\7\61\2\2\u00e5\u00e6\7?\2\2\u00e6L\3\2\2\2\u00e7\u00e8"+
		"\7\'\2\2\u00e8\u00e9\7?\2\2\u00e9N\3\2\2\2\u00ea\u00eb\7?\2\2\u00ebP\3"+
		"\2\2\2\u00ec\u00ed\7*\2\2\u00edR\3\2\2\2\u00ee\u00ef\7+\2\2\u00efT\3\2"+
		"\2\2\u00f0\u00f1\7]\2\2\u00f1V\3\2\2\2\u00f2\u00f3\7_\2\2\u00f3X\3\2\2"+
		"\2\u00f4\u00f5\7}\2\2\u00f5Z\3\2\2\2\u00f6\u00f7\7\177\2\2\u00f7\\\3\2"+
		"\2\2\u00f8\u00fa\t\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc^\3\2\2\2\u00fd\u00ff\t\2\2\2"+
		"\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0107\7\60\2\2"+
		"\u0104\u0106\t\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108`\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010e\t\3\2\2\u010b\u010d\t\4\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010fb\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0112\7.\2\2\u0112d\3\2\2\2\u0113\u0114\7<\2\2\u0114f\3"+
		"\2\2\2\u0115\u0116\7=\2\2\u0116h\3\2\2\2\u0117\u0118\7\60\2\2\u0118j\3"+
		"\2\2\2\u0119\u011a\7)\2\2\u011al\3\2\2\2\u011b\u011c\7$\2\2\u011cn\3\2"+
		"\2\2\u011d\u011e\7\61\2\2\u011e\u011f\7\61\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0122\13\2\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3"+
		"\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0127\t\5\2\2\u0126"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b8\2\2\u0129p\3\2\2\2\u012a"+
		"\u012c\t\6\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b9\2\2\u0130"+
		"r\3\2\2\2\u0131\u0132\t\7\2\2\u0132t\3\2\2\2\r\2\u009a\u00a0\u00a6\u00fb"+
		"\u0100\u0107\u010e\u0123\u0126\u012d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}