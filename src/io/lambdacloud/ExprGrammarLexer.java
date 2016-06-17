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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ADD=6, SUB=7, MUL=8, DIV=9, REM=10, 
		AND=11, OR=12, NOT=13, TRUE=14, FALSE=15, GT=16, GE=17, LT=18, LE=19, 
		EQ=20, NEQ=21, BAND=22, BOR=23, BXOR=24, BNOT=25, SHL=26, SHR=27, USHR=28, 
		INC=29, DESC=30, ADD_ASSIGN=31, SUB_ASSIGN=32, MUL_ASSIGN=33, DIV_ASSIGN=34, 
		REM_ASSIGN=35, ASSIGN=36, LPAREN=37, RPAREN=38, LCB=39, RCB=40, INTEGER=41, 
		FLOAT=42, IDENTIFIER=43, COMMA=44, SEMI=45, COMMENT=46, WS=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ADD", "SUB", "MUL", "DIV", "REM", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "SEMI", 
		"COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'\n'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", 
		"'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", 
		"')'", "'{'", "'}'", null, null, null, "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "SEMI", 
		"COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u010b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u0085\n\f\3\r\3\r\3\r\3\r\5"+
		"\r\u008b\n\r\3\16\3\16\3\16\3\16\5\16\u0091\n\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\6*\u00e0\n*\r*\16*\u00e1\3+\5+\u00e5"+
		"\n+\3+\3+\6+\u00e9\n+\r+\16+\u00ea\3,\3,\7,\u00ef\n,\f,\16,\u00f2\13,"+
		"\3-\3-\3.\3.\3/\3/\3/\3/\6/\u00fc\n/\r/\16/\u00fd\3/\5/\u0101\n/\3/\3"+
		"/\3\60\6\60\u0106\n\60\r\60\16\60\u0107\3\60\3\60\3\u00fd\2\61\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\"+
		"aac|\3\3\f\f\5\2\13\13\16\17\"\"\u0113\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5d\3\2\2\2\7i\3\2\2\2\to\3"+
		"\2\2\2\13s\3\2\2\2\ru\3\2\2\2\17w\3\2\2\2\21y\3\2\2\2\23{\3\2\2\2\25}"+
		"\3\2\2\2\27\u0084\3\2\2\2\31\u008a\3\2\2\2\33\u0090\3\2\2\2\35\u0092\3"+
		"\2\2\2\37\u0097\3\2\2\2!\u009d\3\2\2\2#\u009f\3\2\2\2%\u00a2\3\2\2\2\'"+
		"\u00a4\3\2\2\2)\u00a7\3\2\2\2+\u00aa\3\2\2\2-\u00ad\3\2\2\2/\u00af\3\2"+
		"\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2\2\2\67\u00b8\3\2\2"+
		"\29\u00bb\3\2\2\2;\u00bf\3\2\2\2=\u00c2\3\2\2\2?\u00c5\3\2\2\2A\u00c8"+
		"\3\2\2\2C\u00cb\3\2\2\2E\u00ce\3\2\2\2G\u00d1\3\2\2\2I\u00d4\3\2\2\2K"+
		"\u00d6\3\2\2\2M\u00d8\3\2\2\2O\u00da\3\2\2\2Q\u00dc\3\2\2\2S\u00df\3\2"+
		"\2\2U\u00e4\3\2\2\2W\u00ec\3\2\2\2Y\u00f3\3\2\2\2[\u00f5\3\2\2\2]\u00f7"+
		"\3\2\2\2_\u0105\3\2\2\2ab\7k\2\2bc\7h\2\2c\4\3\2\2\2de\7g\2\2ef\7n\2\2"+
		"fg\7u\2\2gh\7g\2\2h\6\3\2\2\2ij\7y\2\2jk\7j\2\2kl\7k\2\2lm\7n\2\2mn\7"+
		"g\2\2n\b\3\2\2\2op\7h\2\2pq\7q\2\2qr\7t\2\2r\n\3\2\2\2st\7\f\2\2t\f\3"+
		"\2\2\2uv\7-\2\2v\16\3\2\2\2wx\7/\2\2x\20\3\2\2\2yz\7,\2\2z\22\3\2\2\2"+
		"{|\7\61\2\2|\24\3\2\2\2}~\7\'\2\2~\26\3\2\2\2\177\u0080\7c\2\2\u0080\u0081"+
		"\7p\2\2\u0081\u0085\7f\2\2\u0082\u0083\7(\2\2\u0083\u0085\7(\2\2\u0084"+
		"\177\3\2\2\2\u0084\u0082\3\2\2\2\u0085\30\3\2\2\2\u0086\u0087\7q\2\2\u0087"+
		"\u008b\7t\2\2\u0088\u0089\7~\2\2\u0089\u008b\7~\2\2\u008a\u0086\3\2\2"+
		"\2\u008a\u0088\3\2\2\2\u008b\32\3\2\2\2\u008c\u008d\7p\2\2\u008d\u008e"+
		"\7q\2\2\u008e\u0091\7v\2\2\u008f\u0091\7#\2\2\u0090\u008c\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\34\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2"+
		"\u0094\u0095\7w\2\2\u0095\u0096\7g\2\2\u0096\36\3\2\2\2\u0097\u0098\7"+
		"h\2\2\u0098\u0099\7c\2\2\u0099\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b\u009c"+
		"\7g\2\2\u009c \3\2\2\2\u009d\u009e\7@\2\2\u009e\"\3\2\2\2\u009f\u00a0"+
		"\7@\2\2\u00a0\u00a1\7?\2\2\u00a1$\3\2\2\2\u00a2\u00a3\7>\2\2\u00a3&\3"+
		"\2\2\2\u00a4\u00a5\7>\2\2\u00a5\u00a6\7?\2\2\u00a6(\3\2\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8\u00a9\7?\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ac"+
		"\7?\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7(\2\2\u00ae.\3\2\2\2\u00af\u00b0\7"+
		"~\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7`\2\2\u00b2\62\3\2\2\2\u00b3\u00b4"+
		"\7\u0080\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6\u00b7\7>\2\2\u00b7"+
		"\66\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\u00ba\7@\2\2\u00ba8\3\2\2\2\u00bb"+
		"\u00bc\7@\2\2\u00bc\u00bd\7@\2\2\u00bd\u00be\7@\2\2\u00be:\3\2\2\2\u00bf"+
		"\u00c0\7-\2\2\u00c0\u00c1\7-\2\2\u00c1<\3\2\2\2\u00c2\u00c3\7/\2\2\u00c3"+
		"\u00c4\7/\2\2\u00c4>\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\u00c7\7?\2\2\u00c7"+
		"@\3\2\2\2\u00c8\u00c9\7/\2\2\u00c9\u00ca\7?\2\2\u00caB\3\2\2\2\u00cb\u00cc"+
		"\7,\2\2\u00cc\u00cd\7?\2\2\u00cdD\3\2\2\2\u00ce\u00cf\7\61\2\2\u00cf\u00d0"+
		"\7?\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7\'\2\2\u00d2\u00d3\7?\2\2\u00d3H\3"+
		"\2\2\2\u00d4\u00d5\7?\2\2\u00d5J\3\2\2\2\u00d6\u00d7\7*\2\2\u00d7L\3\2"+
		"\2\2\u00d8\u00d9\7+\2\2\u00d9N\3\2\2\2\u00da\u00db\7}\2\2\u00dbP\3\2\2"+
		"\2\u00dc\u00dd\7\177\2\2\u00ddR\3\2\2\2\u00de\u00e0\t\2\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"T\3\2\2\2\u00e3\u00e5\t\2\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e5\u00e6\3\2\2\2\u00e6\u00e8\7\60\2\2\u00e7\u00e9\t\2\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"V\3\2\2\2\u00ec\u00f0\t\3\2\2\u00ed\u00ef\t\4\2\2\u00ee\u00ed\3\2\2\2"+
		"\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1X\3"+
		"\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7.\2\2\u00f4Z\3\2\2\2\u00f5\u00f6"+
		"\7=\2\2\u00f6\\\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\7\61\2\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00fc\13\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u0101\t\5\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\b/"+
		"\2\2\u0103^\3\2\2\2\u0104\u0106\t\6\2\2\u0105\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\b\60\2\2\u010a`\3\2\2\2\r\2\u0084\u008a\u0090\u00e1\u00e4\u00ea"+
		"\u00f0\u00fd\u0100\u0107\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}