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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ADD=11, SUB=12, MUL=13, DIV=14, REM=15, POW=16, SOL=17, DADD=18, 
		DSUB=19, DMUL=20, DRDIV=21, DLDIV=22, AND=23, OR=24, NOT=25, TRUE=26, 
		FALSE=27, GT=28, GE=29, LT=30, LE=31, EQ=32, NEQ=33, BAND=34, BOR=35, 
		BXOR=36, BNOT=37, SHL=38, SHR=39, USHR=40, INC=41, DESC=42, ADD_ASSIGN=43, 
		SUB_ASSIGN=44, MUL_ASSIGN=45, DIV_ASSIGN=46, REM_ASSIGN=47, ASSIGN=48, 
		LPAREN=49, RPAREN=50, LBRK=51, RBRK=52, LCB=53, RCB=54, INTEGER=55, FLOAT=56, 
		IDENTIFIER=57, COMMA=58, COLON=59, SEMI=60, PERIOD=61, SQUOTE=62, DQUOTE=63, 
		COMMENT=64, SKIP_TOKEN=65, WS=66;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", 
		"DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", 
		"USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", 
		"INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", 
		"SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'for'", "'in'", "'tic'", "'toc'", 
		"'if'", "'elseif'", "'else'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", 
		"'\\'", "'.+'", "'.-'", "'.*'", "'./'", "'.\\'", null, null, null, "'true'", 
		"'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", 
		"'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", 
		"'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ADD", 
		"SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", 
		"DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", 
		"EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", 
		"DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"COMMENT", "SKIP_TOKEN", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2D\u0173\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00d8\n\30\3\31\3\31\3\31"+
		"\3\31\5\31\u00de\n\31\3\32\3\32\3\32\3\32\5\32\u00e4\n\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3"+
		"\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3"+
		".\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\68\u0137\n8\r8\168\u0138\38\58\u013c\n8\3"+
		"9\79\u013f\n9\f9\169\u0142\139\39\39\79\u0146\n9\f9\169\u0149\139\3:\3"+
		":\7:\u014d\n:\f:\16:\u0150\13:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A"+
		"\3A\3A\3A\6A\u0162\nA\rA\16A\u0163\3A\5A\u0167\nA\3A\3A\3B\6B\u016c\n"+
		"B\rB\16B\u016d\3B\3B\3C\3C\3\u0163\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\3\2\16\17\4\2"+
		"\13\13\"\"\u017c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2\2\5\u0089\3\2\2\2\7\u0092"+
		"\3\2\2\2\t\u0096\3\2\2\2\13\u009a\3\2\2\2\r\u009d\3\2\2\2\17\u00a1\3\2"+
		"\2\2\21\u00a5\3\2\2\2\23\u00a8\3\2\2\2\25\u00af\3\2\2\2\27\u00b4\3\2\2"+
		"\2\31\u00b6\3\2\2\2\33\u00b8\3\2\2\2\35\u00ba\3\2\2\2\37\u00bc\3\2\2\2"+
		"!\u00be\3\2\2\2#\u00c1\3\2\2\2%\u00c3\3\2\2\2\'\u00c6\3\2\2\2)\u00c9\3"+
		"\2\2\2+\u00cc\3\2\2\2-\u00cf\3\2\2\2/\u00d7\3\2\2\2\61\u00dd\3\2\2\2\63"+
		"\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67\u00ea\3\2\2\29\u00f0\3\2\2\2;\u00f2"+
		"\3\2\2\2=\u00f5\3\2\2\2?\u00f7\3\2\2\2A\u00fa\3\2\2\2C\u00fd\3\2\2\2E"+
		"\u0100\3\2\2\2G\u0102\3\2\2\2I\u0104\3\2\2\2K\u0106\3\2\2\2M\u0108\3\2"+
		"\2\2O\u010b\3\2\2\2Q\u010e\3\2\2\2S\u0112\3\2\2\2U\u0115\3\2\2\2W\u0118"+
		"\3\2\2\2Y\u011b\3\2\2\2[\u011e\3\2\2\2]\u0121\3\2\2\2_\u0124\3\2\2\2a"+
		"\u0127\3\2\2\2c\u0129\3\2\2\2e\u012b\3\2\2\2g\u012d\3\2\2\2i\u012f\3\2"+
		"\2\2k\u0131\3\2\2\2m\u0133\3\2\2\2o\u0136\3\2\2\2q\u0140\3\2\2\2s\u014a"+
		"\3\2\2\2u\u0151\3\2\2\2w\u0153\3\2\2\2y\u0155\3\2\2\2{\u0157\3\2\2\2}"+
		"\u0159\3\2\2\2\177\u015b\3\2\2\2\u0081\u015d\3\2\2\2\u0083\u016b\3\2\2"+
		"\2\u0085\u0171\3\2\2\2\u0087\u0088\7\f\2\2\u0088\4\3\2\2\2\u0089\u008a"+
		"\7h\2\2\u008a\u008b\7w\2\2\u008b\u008c\7p\2\2\u008c\u008d\7e\2\2\u008d"+
		"\u008e\7v\2\2\u008e\u008f\7k\2\2\u008f\u0090\7q\2\2\u0090\u0091\7p\2\2"+
		"\u0091\6\3\2\2\2\u0092\u0093\7g\2\2\u0093\u0094\7p\2\2\u0094\u0095\7f"+
		"\2\2\u0095\b\3\2\2\2\u0096\u0097\7h\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7t\2\2\u0099\n\3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\f"+
		"\3\2\2\2\u009d\u009e\7v\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7e\2\2\u00a0"+
		"\16\3\2\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7e\2\2\u00a4"+
		"\20\3\2\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7h\2\2\u00a7\22\3\2\2\2\u00a8"+
		"\u00a9\7g\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7g\2\2"+
		"\u00ac\u00ad\7k\2\2\u00ad\u00ae\7h\2\2\u00ae\24\3\2\2\2\u00af\u00b0\7"+
		"g\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7g\2\2\u00b3\26"+
		"\3\2\2\2\u00b4\u00b5\7-\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7"+
		"\32\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9\34\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb"+
		"\36\3\2\2\2\u00bc\u00bd\7\'\2\2\u00bd \3\2\2\2\u00be\u00bf\7,\2\2\u00bf"+
		"\u00c0\7,\2\2\u00c0\"\3\2\2\2\u00c1\u00c2\7^\2\2\u00c2$\3\2\2\2\u00c3"+
		"\u00c4\7\60\2\2\u00c4\u00c5\7-\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7\60\2\2"+
		"\u00c7\u00c8\7/\2\2\u00c8(\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\u00cb\7"+
		",\2\2\u00cb*\3\2\2\2\u00cc\u00cd\7\60\2\2\u00cd\u00ce\7\61\2\2\u00ce,"+
		"\3\2\2\2\u00cf\u00d0\7\60\2\2\u00d0\u00d1\7^\2\2\u00d1.\3\2\2\2\u00d2"+
		"\u00d3\7c\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d8\7f\2\2\u00d5\u00d6\7(\2\2"+
		"\u00d6\u00d8\7(\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\60\3"+
		"\2\2\2\u00d9\u00da\7q\2\2\u00da\u00de\7t\2\2\u00db\u00dc\7~\2\2\u00dc"+
		"\u00de\7~\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\62\3\2\2\2"+
		"\u00df\u00e0\7p\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e4\7v\2\2\u00e2\u00e4"+
		"\7#\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\64\3\2\2\2\u00e5"+
		"\u00e6\7v\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7g\2\2"+
		"\u00e9\66\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7"+
		"n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00ef8\3\2\2\2\u00f0\u00f1"+
		"\7@\2\2\u00f1:\3\2\2\2\u00f2\u00f3\7@\2\2\u00f3\u00f4\7?\2\2\u00f4<\3"+
		"\2\2\2\u00f5\u00f6\7>\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8\u00f9"+
		"\7?\2\2\u00f9@\3\2\2\2\u00fa\u00fb\7?\2\2\u00fb\u00fc\7?\2\2\u00fcB\3"+
		"\2\2\2\u00fd\u00fe\7#\2\2\u00fe\u00ff\7?\2\2\u00ffD\3\2\2\2\u0100\u0101"+
		"\7(\2\2\u0101F\3\2\2\2\u0102\u0103\7~\2\2\u0103H\3\2\2\2\u0104\u0105\7"+
		"`\2\2\u0105J\3\2\2\2\u0106\u0107\7\u0080\2\2\u0107L\3\2\2\2\u0108\u0109"+
		"\7>\2\2\u0109\u010a\7>\2\2\u010aN\3\2\2\2\u010b\u010c\7@\2\2\u010c\u010d"+
		"\7@\2\2\u010dP\3\2\2\2\u010e\u010f\7@\2\2\u010f\u0110\7@\2\2\u0110\u0111"+
		"\7@\2\2\u0111R\3\2\2\2\u0112\u0113\7-\2\2\u0113\u0114\7-\2\2\u0114T\3"+
		"\2\2\2\u0115\u0116\7/\2\2\u0116\u0117\7/\2\2\u0117V\3\2\2\2\u0118\u0119"+
		"\7-\2\2\u0119\u011a\7?\2\2\u011aX\3\2\2\2\u011b\u011c\7/\2\2\u011c\u011d"+
		"\7?\2\2\u011dZ\3\2\2\2\u011e\u011f\7,\2\2\u011f\u0120\7?\2\2\u0120\\\3"+
		"\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123\7?\2\2\u0123^\3\2\2\2\u0124\u0125"+
		"\7\'\2\2\u0125\u0126\7?\2\2\u0126`\3\2\2\2\u0127\u0128\7?\2\2\u0128b\3"+
		"\2\2\2\u0129\u012a\7*\2\2\u012ad\3\2\2\2\u012b\u012c\7+\2\2\u012cf\3\2"+
		"\2\2\u012d\u012e\7]\2\2\u012eh\3\2\2\2\u012f\u0130\7_\2\2\u0130j\3\2\2"+
		"\2\u0131\u0132\7}\2\2\u0132l\3\2\2\2\u0133\u0134\7\177\2\2\u0134n\3\2"+
		"\2\2\u0135\u0137\t\2\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u013c\7N"+
		"\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013cp\3\2\2\2\u013d\u013f"+
		"\t\2\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0147\7\60"+
		"\2\2\u0144\u0146\t\2\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148r\3\2\2\2\u0149\u0147\3\2\2\2"+
		"\u014a\u014e\t\3\2\2\u014b\u014d\t\4\2\2\u014c\u014b\3\2\2\2\u014d\u0150"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014ft\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0152\7.\2\2\u0152v\3\2\2\2\u0153\u0154\7<\2\2\u0154"+
		"x\3\2\2\2\u0155\u0156\7=\2\2\u0156z\3\2\2\2\u0157\u0158\7\60\2\2\u0158"+
		"|\3\2\2\2\u0159\u015a\7)\2\2\u015a~\3\2\2\2\u015b\u015c\7$\2\2\u015c\u0080"+
		"\3\2\2\2\u015d\u015e\7\61\2\2\u015e\u015f\7\61\2\2\u015f\u0161\3\2\2\2"+
		"\u0160\u0162\13\2\2\2\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0167\t\5\2\2\u0166"+
		"\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\bA\2\2\u0169\u0082\3\2"+
		"\2\2\u016a\u016c\t\6\2\2\u016b\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\bB"+
		"\2\2\u0170\u0084\3\2\2\2\u0171\u0172\t\7\2\2\u0172\u0086\3\2\2\2\16\2"+
		"\u00d7\u00dd\u00e3\u0138\u013b\u0140\u0147\u014e\u0163\u0166\u016d\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}