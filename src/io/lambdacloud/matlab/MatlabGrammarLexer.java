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
		T__9=10, T__10=11, ADD=12, SUB=13, MUL=14, DIV=15, REM=16, POW=17, SOL=18, 
		DADD=19, DSUB=20, DMUL=21, DRDIV=22, DLDIV=23, AND=24, OR=25, NOT=26, 
		TRUE=27, FALSE=28, GT=29, GE=30, LT=31, LE=32, EQ=33, NEQ=34, BAND=35, 
		BOR=36, BXOR=37, BNOT=38, SHL=39, SHR=40, USHR=41, INC=42, DESC=43, ADD_ASSIGN=44, 
		SUB_ASSIGN=45, MUL_ASSIGN=46, DIV_ASSIGN=47, REM_ASSIGN=48, ASSIGN=49, 
		LPAREN=50, RPAREN=51, LBRK=52, RBRK=53, LCB=54, RCB=55, INTEGER=56, FLOAT=57, 
		IDENTIFIER=58, COMMA=59, COLON=60, SEMI=61, PERIOD=62, SQUOTE=63, DQUOTE=64, 
		COMMENT=65, SKIP_TOKEN=66, WS=67;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", 
		"DSUB", "DMUL", "DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", 
		"SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'if'", "'elseif'", "'else'", "'for'", 
		"'in'", "'while'", "'tic'", "'toc'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'**'", "'\\'", "'.+'", "'.-'", "'.*'", "'./'", "'.\\'", null, null, null, 
		"'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", 
		"'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ADD", "SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", "DMUL", 
		"DRDIV", "DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", 
		"LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", 
		"INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2E\u017b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u00e0\n\31\3\32\3\32\3\32\3\32\5\32\u00e6\n\32\3\33\3\33\3\33"+
		"\3\33\5\33\u00ec\n\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\69\u013f\n9"+
		"\r9\169\u0140\39\59\u0144\n9\3:\7:\u0147\n:\f:\16:\u014a\13:\3:\3:\7:"+
		"\u014e\n:\f:\16:\u0151\13:\3;\3;\7;\u0155\n;\f;\16;\u0158\13;\3<\3<\3"+
		"=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3B\6B\u016a\nB\rB\16B\u016b\3B\5"+
		"B\u016f\nB\3B\3B\3C\6C\u0174\nC\rC\16C\u0175\3C\3C\3D\3D\3\u016b\2E\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9"+
		"q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\3\2\b\3\2\62;\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\3\3\f\f\3\2\16\17\4\2\13\13\"\"\u0184\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2"+
		"\u0087\3\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u0094\3\2\2\2\t\u0098"+
		"\3\2\2\2\13\u009b\3\2\2\2\r\u00a2\3\2\2\2\17\u00a7\3\2\2\2\21\u00ab\3"+
		"\2\2\2\23\u00ae\3\2\2\2\25\u00b4\3\2\2\2\27\u00b8\3\2\2\2\31\u00bc\3\2"+
		"\2\2\33\u00be\3\2\2\2\35\u00c0\3\2\2\2\37\u00c2\3\2\2\2!\u00c4\3\2\2\2"+
		"#\u00c6\3\2\2\2%\u00c9\3\2\2\2\'\u00cb\3\2\2\2)\u00ce\3\2\2\2+\u00d1\3"+
		"\2\2\2-\u00d4\3\2\2\2/\u00d7\3\2\2\2\61\u00df\3\2\2\2\63\u00e5\3\2\2\2"+
		"\65\u00eb\3\2\2\2\67\u00ed\3\2\2\29\u00f2\3\2\2\2;\u00f8\3\2\2\2=\u00fa"+
		"\3\2\2\2?\u00fd\3\2\2\2A\u00ff\3\2\2\2C\u0102\3\2\2\2E\u0105\3\2\2\2G"+
		"\u0108\3\2\2\2I\u010a\3\2\2\2K\u010c\3\2\2\2M\u010e\3\2\2\2O\u0110\3\2"+
		"\2\2Q\u0113\3\2\2\2S\u0116\3\2\2\2U\u011a\3\2\2\2W\u011d\3\2\2\2Y\u0120"+
		"\3\2\2\2[\u0123\3\2\2\2]\u0126\3\2\2\2_\u0129\3\2\2\2a\u012c\3\2\2\2c"+
		"\u012f\3\2\2\2e\u0131\3\2\2\2g\u0133\3\2\2\2i\u0135\3\2\2\2k\u0137\3\2"+
		"\2\2m\u0139\3\2\2\2o\u013b\3\2\2\2q\u013e\3\2\2\2s\u0148\3\2\2\2u\u0152"+
		"\3\2\2\2w\u0159\3\2\2\2y\u015b\3\2\2\2{\u015d\3\2\2\2}\u015f\3\2\2\2\177"+
		"\u0161\3\2\2\2\u0081\u0163\3\2\2\2\u0083\u0165\3\2\2\2\u0085\u0173\3\2"+
		"\2\2\u0087\u0179\3\2\2\2\u0089\u008a\7\f\2\2\u008a\4\3\2\2\2\u008b\u008c"+
		"\7h\2\2\u008c\u008d\7w\2\2\u008d\u008e\7p\2\2\u008e\u008f\7e\2\2\u008f"+
		"\u0090\7v\2\2\u0090\u0091\7k\2\2\u0091\u0092\7q\2\2\u0092\u0093\7p\2\2"+
		"\u0093\6\3\2\2\2\u0094\u0095\7g\2\2\u0095\u0096\7p\2\2\u0096\u0097\7f"+
		"\2\2\u0097\b\3\2\2\2\u0098\u0099\7k\2\2\u0099\u009a\7h\2\2\u009a\n\3\2"+
		"\2\2\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e\u009f"+
		"\7g\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1\f\3\2\2\2\u00a2\u00a3"+
		"\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\16\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7t\2\2\u00aa"+
		"\20\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7p\2\2\u00ad\22\3\2\2\2\u00ae"+
		"\u00af\7y\2\2\u00af\u00b0\7j\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7n\2\2"+
		"\u00b2\u00b3\7g\2\2\u00b3\24\3\2\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7"+
		"k\2\2\u00b6\u00b7\7e\2\2\u00b7\26\3\2\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba"+
		"\7q\2\2\u00ba\u00bb\7e\2\2\u00bb\30\3\2\2\2\u00bc\u00bd\7-\2\2\u00bd\32"+
		"\3\2\2\2\u00be\u00bf\7/\2\2\u00bf\34\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1"+
		"\36\3\2\2\2\u00c2\u00c3\7\61\2\2\u00c3 \3\2\2\2\u00c4\u00c5\7\'\2\2\u00c5"+
		"\"\3\2\2\2\u00c6\u00c7\7,\2\2\u00c7\u00c8\7,\2\2\u00c8$\3\2\2\2\u00c9"+
		"\u00ca\7^\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7\60\2\2\u00cc\u00cd\7-\2\2\u00cd"+
		"(\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf\u00d0\7/\2\2\u00d0*\3\2\2\2\u00d1"+
		"\u00d2\7\60\2\2\u00d2\u00d3\7,\2\2\u00d3,\3\2\2\2\u00d4\u00d5\7\60\2\2"+
		"\u00d5\u00d6\7\61\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7\60\2\2\u00d8\u00d9"+
		"\7^\2\2\u00d9\60\3\2\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7p\2\2\u00dc\u00e0"+
		"\7f\2\2\u00dd\u00de\7(\2\2\u00de\u00e0\7(\2\2\u00df\u00da\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e6\7t\2\2"+
		"\u00e3\u00e4\7~\2\2\u00e4\u00e6\7~\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6\64\3\2\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7q\2\2\u00e9"+
		"\u00ec\7v\2\2\u00ea\u00ec\7#\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00ea\3\2\2"+
		"\2\u00ec\66\3\2\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0"+
		"\7w\2\2\u00f0\u00f1\7g\2\2\u00f18\3\2\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4"+
		"\7c\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7g\2\2\u00f7"+
		":\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7@\2\2\u00fb\u00fc"+
		"\7?\2\2\u00fc>\3\2\2\2\u00fd\u00fe\7>\2\2\u00fe@\3\2\2\2\u00ff\u0100\7"+
		">\2\2\u0100\u0101\7?\2\2\u0101B\3\2\2\2\u0102\u0103\7?\2\2\u0103\u0104"+
		"\7?\2\2\u0104D\3\2\2\2\u0105\u0106\7#\2\2\u0106\u0107\7?\2\2\u0107F\3"+
		"\2\2\2\u0108\u0109\7(\2\2\u0109H\3\2\2\2\u010a\u010b\7~\2\2\u010bJ\3\2"+
		"\2\2\u010c\u010d\7`\2\2\u010dL\3\2\2\2\u010e\u010f\7\u0080\2\2\u010fN"+
		"\3\2\2\2\u0110\u0111\7>\2\2\u0111\u0112\7>\2\2\u0112P\3\2\2\2\u0113\u0114"+
		"\7@\2\2\u0114\u0115\7@\2\2\u0115R\3\2\2\2\u0116\u0117\7@\2\2\u0117\u0118"+
		"\7@\2\2\u0118\u0119\7@\2\2\u0119T\3\2\2\2\u011a\u011b\7-\2\2\u011b\u011c"+
		"\7-\2\2\u011cV\3\2\2\2\u011d\u011e\7/\2\2\u011e\u011f\7/\2\2\u011fX\3"+
		"\2\2\2\u0120\u0121\7-\2\2\u0121\u0122\7?\2\2\u0122Z\3\2\2\2\u0123\u0124"+
		"\7/\2\2\u0124\u0125\7?\2\2\u0125\\\3\2\2\2\u0126\u0127\7,\2\2\u0127\u0128"+
		"\7?\2\2\u0128^\3\2\2\2\u0129\u012a\7\61\2\2\u012a\u012b\7?\2\2\u012b`"+
		"\3\2\2\2\u012c\u012d\7\'\2\2\u012d\u012e\7?\2\2\u012eb\3\2\2\2\u012f\u0130"+
		"\7?\2\2\u0130d\3\2\2\2\u0131\u0132\7*\2\2\u0132f\3\2\2\2\u0133\u0134\7"+
		"+\2\2\u0134h\3\2\2\2\u0135\u0136\7]\2\2\u0136j\3\2\2\2\u0137\u0138\7_"+
		"\2\2\u0138l\3\2\2\2\u0139\u013a\7}\2\2\u013an\3\2\2\2\u013b\u013c\7\177"+
		"\2\2\u013cp\3\2\2\2\u013d\u013f\t\2\2\2\u013e\u013d\3\2\2\2\u013f\u0140"+
		"\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142"+
		"\u0144\7N\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144r\3\2\2\2\u0145"+
		"\u0147\t\2\2\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b"+
		"\u014f\7\60\2\2\u014c\u014e\t\2\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150t\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0152\u0156\t\3\2\2\u0153\u0155\t\4\2\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157v\3\2\2\2"+
		"\u0158\u0156\3\2\2\2\u0159\u015a\7.\2\2\u015ax\3\2\2\2\u015b\u015c\7<"+
		"\2\2\u015cz\3\2\2\2\u015d\u015e\7=\2\2\u015e|\3\2\2\2\u015f\u0160\7\60"+
		"\2\2\u0160~\3\2\2\2\u0161\u0162\7)\2\2\u0162\u0080\3\2\2\2\u0163\u0164"+
		"\7$\2\2\u0164\u0082\3\2\2\2\u0165\u0166\7\61\2\2\u0166\u0167\7\61\2\2"+
		"\u0167\u0169\3\2\2\2\u0168\u016a\13\2\2\2\u0169\u0168\3\2\2\2\u016a\u016b"+
		"\3\2\2\2\u016b\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016e\3\2\2\2\u016d"+
		"\u016f\t\5\2\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\bB"+
		"\2\2\u0171\u0084\3\2\2\2\u0172\u0174\t\6\2\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0178\bC\2\2\u0178\u0086\3\2\2\2\u0179\u017a\t\7\2\2\u017a"+
		"\u0088\3\2\2\2\16\2\u00df\u00e5\u00eb\u0140\u0143\u0148\u014f\u0156\u016b"+
		"\u016e\u0175\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}