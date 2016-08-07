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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ADD=9, 
		SUB=10, MUL=11, DIV=12, REM=13, POW=14, SOL=15, DADD=16, DSUB=17, DMUL=18, 
		DRDIV=19, DLDIV=20, AND=21, OR=22, NOT=23, TRUE=24, FALSE=25, GT=26, GE=27, 
		LT=28, LE=29, EQ=30, NEQ=31, BAND=32, BOR=33, BXOR=34, BNOT=35, SHL=36, 
		SHR=37, USHR=38, INC=39, DESC=40, ADD_ASSIGN=41, SUB_ASSIGN=42, MUL_ASSIGN=43, 
		DIV_ASSIGN=44, REM_ASSIGN=45, ASSIGN=46, LPAREN=47, RPAREN=48, LBRK=49, 
		RBRK=50, LCB=51, RCB=52, INTEGER=53, FLOAT=54, IDENTIFIER=55, COMMA=56, 
		COLON=57, SEMI=58, PERIOD=59, SQUOTE=60, DQUOTE=61, COMMENT=62, SKIP_TOKEN=63, 
		WS=64;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "ADD", 
		"SUB", "MUL", "DIV", "REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", 
		"DLDIV", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", 
		"EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", 
		"DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"COMMENT", "SKIP_TOKEN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'for'", "'in'", "'if'", "'elseif'", 
		"'else'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'\\'", "'.+'", "'.-'", 
		"'.*'", "'./'", "'.\\'", null, null, null, "'true'", "'false'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", 
		"'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", 
		"'='", "'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", 
		"':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "ADD", "SUB", "MUL", 
		"DIV", "REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2B\u0164\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u00cc"+
		"\n\26\3\27\3\27\3\27\3\27\5\27\u00d2\n\27\3\30\3\30\3\30\3\30\5\30\u00d8"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3"+
		")\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\6\66\u012b\n\66\r\66"+
		"\16\66\u012c\3\67\7\67\u0130\n\67\f\67\16\67\u0133\13\67\3\67\3\67\7\67"+
		"\u0137\n\67\f\67\16\67\u013a\13\67\38\38\78\u013e\n8\f8\168\u0141\138"+
		"\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3?\3?\6?\u0153\n?\r?\16?\u0154"+
		"\3?\5?\u0158\n?\3?\3?\3@\6@\u015d\n@\r@\16@\u015e\3@\3@\3A\3A\3\u0154"+
		"\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac"+
		"|\3\3\f\f\3\2\16\17\4\2\13\13\"\"\u016c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u0085\3\2\2\2\7\u008e\3\2\2\2"+
		"\t\u0092\3\2\2\2\13\u0096\3\2\2\2\r\u0099\3\2\2\2\17\u009c\3\2\2\2\21"+
		"\u00a3\3\2\2\2\23\u00a8\3\2\2\2\25\u00aa\3\2\2\2\27\u00ac\3\2\2\2\31\u00ae"+
		"\3\2\2\2\33\u00b0\3\2\2\2\35\u00b2\3\2\2\2\37\u00b5\3\2\2\2!\u00b7\3\2"+
		"\2\2#\u00ba\3\2\2\2%\u00bd\3\2\2\2\'\u00c0\3\2\2\2)\u00c3\3\2\2\2+\u00cb"+
		"\3\2\2\2-\u00d1\3\2\2\2/\u00d7\3\2\2\2\61\u00d9\3\2\2\2\63\u00de\3\2\2"+
		"\2\65\u00e4\3\2\2\2\67\u00e6\3\2\2\29\u00e9\3\2\2\2;\u00eb\3\2\2\2=\u00ee"+
		"\3\2\2\2?\u00f1\3\2\2\2A\u00f4\3\2\2\2C\u00f6\3\2\2\2E\u00f8\3\2\2\2G"+
		"\u00fa\3\2\2\2I\u00fc\3\2\2\2K\u00ff\3\2\2\2M\u0102\3\2\2\2O\u0106\3\2"+
		"\2\2Q\u0109\3\2\2\2S\u010c\3\2\2\2U\u010f\3\2\2\2W\u0112\3\2\2\2Y\u0115"+
		"\3\2\2\2[\u0118\3\2\2\2]\u011b\3\2\2\2_\u011d\3\2\2\2a\u011f\3\2\2\2c"+
		"\u0121\3\2\2\2e\u0123\3\2\2\2g\u0125\3\2\2\2i\u0127\3\2\2\2k\u012a\3\2"+
		"\2\2m\u0131\3\2\2\2o\u013b\3\2\2\2q\u0142\3\2\2\2s\u0144\3\2\2\2u\u0146"+
		"\3\2\2\2w\u0148\3\2\2\2y\u014a\3\2\2\2{\u014c\3\2\2\2}\u014e\3\2\2\2\177"+
		"\u015c\3\2\2\2\u0081\u0162\3\2\2\2\u0083\u0084\7\f\2\2\u0084\4\3\2\2\2"+
		"\u0085\u0086\7h\2\2\u0086\u0087\7w\2\2\u0087\u0088\7p\2\2\u0088\u0089"+
		"\7e\2\2\u0089\u008a\7v\2\2\u008a\u008b\7k\2\2\u008b\u008c\7q\2\2\u008c"+
		"\u008d\7p\2\2\u008d\6\3\2\2\2\u008e\u008f\7g\2\2\u008f\u0090\7p\2\2\u0090"+
		"\u0091\7f\2\2\u0091\b\3\2\2\2\u0092\u0093\7h\2\2\u0093\u0094\7q\2\2\u0094"+
		"\u0095\7t\2\2\u0095\n\3\2\2\2\u0096\u0097\7k\2\2\u0097\u0098\7p\2\2\u0098"+
		"\f\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b\16\3\2\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0\u00a1\7k\2\2\u00a1\u00a2\7h\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7"+
		"g\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a7\22"+
		"\3\2\2\2\u00a8\u00a9\7-\2\2\u00a9\24\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab"+
		"\26\3\2\2\2\u00ac\u00ad\7,\2\2\u00ad\30\3\2\2\2\u00ae\u00af\7\61\2\2\u00af"+
		"\32\3\2\2\2\u00b0\u00b1\7\'\2\2\u00b1\34\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3"+
		"\u00b4\7,\2\2\u00b4\36\3\2\2\2\u00b5\u00b6\7^\2\2\u00b6 \3\2\2\2\u00b7"+
		"\u00b8\7\60\2\2\u00b8\u00b9\7-\2\2\u00b9\"\3\2\2\2\u00ba\u00bb\7\60\2"+
		"\2\u00bb\u00bc\7/\2\2\u00bc$\3\2\2\2\u00bd\u00be\7\60\2\2\u00be\u00bf"+
		"\7,\2\2\u00bf&\3\2\2\2\u00c0\u00c1\7\60\2\2\u00c1\u00c2\7\61\2\2\u00c2"+
		"(\3\2\2\2\u00c3\u00c4\7\60\2\2\u00c4\u00c5\7^\2\2\u00c5*\3\2\2\2\u00c6"+
		"\u00c7\7c\2\2\u00c7\u00c8\7p\2\2\u00c8\u00cc\7f\2\2\u00c9\u00ca\7(\2\2"+
		"\u00ca\u00cc\7(\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc,\3\2"+
		"\2\2\u00cd\u00ce\7q\2\2\u00ce\u00d2\7t\2\2\u00cf\u00d0\7~\2\2\u00d0\u00d2"+
		"\7~\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2.\3\2\2\2\u00d3\u00d4"+
		"\7p\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d8\7v\2\2\u00d6\u00d8\7#\2\2\u00d7"+
		"\u00d3\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\60\3\2\2\2\u00d9\u00da\7v\2\2"+
		"\u00da\u00db\7t\2\2\u00db\u00dc\7w\2\2\u00dc\u00dd\7g\2\2\u00dd\62\3\2"+
		"\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2"+
		"\7u\2\2\u00e2\u00e3\7g\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7@\2\2\u00e5\66"+
		"\3\2\2\2\u00e6\u00e7\7@\2\2\u00e7\u00e8\7?\2\2\u00e88\3\2\2\2\u00e9\u00ea"+
		"\7>\2\2\u00ea:\3\2\2\2\u00eb\u00ec\7>\2\2\u00ec\u00ed\7?\2\2\u00ed<\3"+
		"\2\2\2\u00ee\u00ef\7?\2\2\u00ef\u00f0\7?\2\2\u00f0>\3\2\2\2\u00f1\u00f2"+
		"\7#\2\2\u00f2\u00f3\7?\2\2\u00f3@\3\2\2\2\u00f4\u00f5\7(\2\2\u00f5B\3"+
		"\2\2\2\u00f6\u00f7\7~\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7`\2\2\u00f9F\3\2"+
		"\2\2\u00fa\u00fb\7\u0080\2\2\u00fbH\3\2\2\2\u00fc\u00fd\7>\2\2\u00fd\u00fe"+
		"\7>\2\2\u00feJ\3\2\2\2\u00ff\u0100\7@\2\2\u0100\u0101\7@\2\2\u0101L\3"+
		"\2\2\2\u0102\u0103\7@\2\2\u0103\u0104\7@\2\2\u0104\u0105\7@\2\2\u0105"+
		"N\3\2\2\2\u0106\u0107\7-\2\2\u0107\u0108\7-\2\2\u0108P\3\2\2\2\u0109\u010a"+
		"\7/\2\2\u010a\u010b\7/\2\2\u010bR\3\2\2\2\u010c\u010d\7-\2\2\u010d\u010e"+
		"\7?\2\2\u010eT\3\2\2\2\u010f\u0110\7/\2\2\u0110\u0111\7?\2\2\u0111V\3"+
		"\2\2\2\u0112\u0113\7,\2\2\u0113\u0114\7?\2\2\u0114X\3\2\2\2\u0115\u0116"+
		"\7\61\2\2\u0116\u0117\7?\2\2\u0117Z\3\2\2\2\u0118\u0119\7\'\2\2\u0119"+
		"\u011a\7?\2\2\u011a\\\3\2\2\2\u011b\u011c\7?\2\2\u011c^\3\2\2\2\u011d"+
		"\u011e\7*\2\2\u011e`\3\2\2\2\u011f\u0120\7+\2\2\u0120b\3\2\2\2\u0121\u0122"+
		"\7]\2\2\u0122d\3\2\2\2\u0123\u0124\7_\2\2\u0124f\3\2\2\2\u0125\u0126\7"+
		"}\2\2\u0126h\3\2\2\2\u0127\u0128\7\177\2\2\u0128j\3\2\2\2\u0129\u012b"+
		"\t\2\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012dl\3\2\2\2\u012e\u0130\t\2\2\2\u012f\u012e\3\2\2\2"+
		"\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0138\7\60\2\2\u0135\u0137\t\2\2\2"+
		"\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139n\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013f\t\3\2\2\u013c"+
		"\u013e\t\4\2\2\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u013f\u0140\3\2\2\2\u0140p\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143"+
		"\7.\2\2\u0143r\3\2\2\2\u0144\u0145\7<\2\2\u0145t\3\2\2\2\u0146\u0147\7"+
		"=\2\2\u0147v\3\2\2\2\u0148\u0149\7\60\2\2\u0149x\3\2\2\2\u014a\u014b\7"+
		")\2\2\u014bz\3\2\2\2\u014c\u014d\7$\2\2\u014d|\3\2\2\2\u014e\u014f\7\61"+
		"\2\2\u014f\u0150\7\61\2\2\u0150\u0152\3\2\2\2\u0151\u0153\13\2\2\2\u0152"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0154\u0152\3\2"+
		"\2\2\u0155\u0157\3\2\2\2\u0156\u0158\t\5\2\2\u0157\u0156\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015a\b?\2\2\u015a~\3\2\2\2\u015b\u015d\t\6\2\2\u015c"+
		"\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160\u0161\b@\2\2\u0161\u0080\3\2\2\2\u0162"+
		"\u0163\t\7\2\2\u0163\u0082\3\2\2\2\r\2\u00cb\u00d1\u00d7\u012c\u0131\u0138"+
		"\u013f\u0154\u0157\u015e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}