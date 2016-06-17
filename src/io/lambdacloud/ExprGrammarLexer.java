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
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, REM=8, AND=9, OR=10, 
		NOT=11, TRUE=12, FALSE=13, GT=14, GE=15, LT=16, LE=17, EQ=18, NEQ=19, 
		BAND=20, BOR=21, BXOR=22, BNOT=23, SHL=24, SHR=25, USHR=26, INC=27, DESC=28, 
		ADD_ASIGN=29, SUB_ASIGN=30, MUL_ASIGN=31, DIV_ASIGN=32, REM_ASIGN=33, 
		ASIGN=34, LPAREN=35, RPAREN=36, LCB=37, RCB=38, INTEGER=39, FLOAT=40, 
		IDENTIFIER=41, END_EXPR=42, COMMENT=43, WS=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", 
		"NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", 
		"BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", 
		"MUL_ASIGN", "DIV_ASIGN", "REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "LCB", 
		"RCB", "INTEGER", "FLOAT", "IDENTIFIER", "END_EXPR", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", 
		"'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", 
		"NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", 
		"BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", 
		"MUL_ASIGN", "DIV_ASIGN", "REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "LCB", 
		"RCB", "INTEGER", "FLOAT", "IDENTIFIER", "END_EXPR", "COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0100\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\ny\n\n\3\13"+
		"\3\13\3\13\3\13\5\13\177\n\13\3\f\3\f\3\f\3\f\5\f\u0085\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\6(\u00d4\n(\r"+
		"(\16(\u00d5\3)\5)\u00d9\n)\3)\3)\6)\u00dd\n)\r)\16)\u00de\3*\3*\7*\u00e3"+
		"\n*\f*\16*\u00e6\13*\3+\6+\u00e9\n+\r+\16+\u00ea\3,\3,\3,\3,\6,\u00f1"+
		"\n,\r,\16,\u00f2\3,\5,\u00f6\n,\3,\3,\3-\6-\u00fb\n-\r-\16-\u00fc\3-\3"+
		"-\3\u00f2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\b\3\2\62;\5\2C\\aa"+
		"c|\6\2\62;C\\aac|\4\2\f\f==\3\3\f\f\5\2\13\13\16\17\"\"\u0109\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5^\3\2\2\2\7c\3\2\2\2\ti\3\2\2\2\13"+
		"k\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21q\3\2\2\2\23x\3\2\2\2\25~\3\2\2\2\27"+
		"\u0084\3\2\2\2\31\u0086\3\2\2\2\33\u008b\3\2\2\2\35\u0091\3\2\2\2\37\u0093"+
		"\3\2\2\2!\u0096\3\2\2\2#\u0098\3\2\2\2%\u009b\3\2\2\2\'\u009e\3\2\2\2"+
		")\u00a1\3\2\2\2+\u00a3\3\2\2\2-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61\u00a9"+
		"\3\2\2\2\63\u00ac\3\2\2\2\65\u00af\3\2\2\2\67\u00b3\3\2\2\29\u00b6\3\2"+
		"\2\2;\u00b9\3\2\2\2=\u00bc\3\2\2\2?\u00bf\3\2\2\2A\u00c2\3\2\2\2C\u00c5"+
		"\3\2\2\2E\u00c8\3\2\2\2G\u00ca\3\2\2\2I\u00cc\3\2\2\2K\u00ce\3\2\2\2M"+
		"\u00d0\3\2\2\2O\u00d3\3\2\2\2Q\u00d8\3\2\2\2S\u00e0\3\2\2\2U\u00e8\3\2"+
		"\2\2W\u00ec\3\2\2\2Y\u00fa\3\2\2\2[\\\7k\2\2\\]\7h\2\2]\4\3\2\2\2^_\7"+
		"g\2\2_`\7n\2\2`a\7u\2\2ab\7g\2\2b\6\3\2\2\2cd\7y\2\2de\7j\2\2ef\7k\2\2"+
		"fg\7n\2\2gh\7g\2\2h\b\3\2\2\2ij\7-\2\2j\n\3\2\2\2kl\7/\2\2l\f\3\2\2\2"+
		"mn\7,\2\2n\16\3\2\2\2op\7\61\2\2p\20\3\2\2\2qr\7\'\2\2r\22\3\2\2\2st\7"+
		"c\2\2tu\7p\2\2uy\7f\2\2vw\7(\2\2wy\7(\2\2xs\3\2\2\2xv\3\2\2\2y\24\3\2"+
		"\2\2z{\7q\2\2{\177\7t\2\2|}\7~\2\2}\177\7~\2\2~z\3\2\2\2~|\3\2\2\2\177"+
		"\26\3\2\2\2\u0080\u0081\7p\2\2\u0081\u0082\7q\2\2\u0082\u0085\7v\2\2\u0083"+
		"\u0085\7#\2\2\u0084\u0080\3\2\2\2\u0084\u0083\3\2\2\2\u0085\30\3\2\2\2"+
		"\u0086\u0087\7v\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089\u008a"+
		"\7g\2\2\u008a\32\3\2\2\2\u008b\u008c\7h\2\2\u008c\u008d\7c\2\2\u008d\u008e"+
		"\7n\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\34\3\2\2\2\u0091\u0092"+
		"\7@\2\2\u0092\36\3\2\2\2\u0093\u0094\7@\2\2\u0094\u0095\7?\2\2\u0095 "+
		"\3\2\2\2\u0096\u0097\7>\2\2\u0097\"\3\2\2\2\u0098\u0099\7>\2\2\u0099\u009a"+
		"\7?\2\2\u009a$\3\2\2\2\u009b\u009c\7?\2\2\u009c\u009d\7?\2\2\u009d&\3"+
		"\2\2\2\u009e\u009f\7#\2\2\u009f\u00a0\7?\2\2\u00a0(\3\2\2\2\u00a1\u00a2"+
		"\7(\2\2\u00a2*\3\2\2\2\u00a3\u00a4\7~\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7"+
		"`\2\2\u00a6.\3\2\2\2\u00a7\u00a8\7\u0080\2\2\u00a8\60\3\2\2\2\u00a9\u00aa"+
		"\7>\2\2\u00aa\u00ab\7>\2\2\u00ab\62\3\2\2\2\u00ac\u00ad\7@\2\2\u00ad\u00ae"+
		"\7@\2\2\u00ae\64\3\2\2\2\u00af\u00b0\7@\2\2\u00b0\u00b1\7@\2\2\u00b1\u00b2"+
		"\7@\2\2\u00b2\66\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\u00b5\7-\2\2\u00b58"+
		"\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\u00b8\7/\2\2\u00b8:\3\2\2\2\u00b9\u00ba"+
		"\7-\2\2\u00ba\u00bb\7?\2\2\u00bb<\3\2\2\2\u00bc\u00bd\7/\2\2\u00bd\u00be"+
		"\7?\2\2\u00be>\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c1\7?\2\2\u00c1@\3"+
		"\2\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4\7?\2\2\u00c4B\3\2\2\2\u00c5\u00c6"+
		"\7\'\2\2\u00c6\u00c7\7?\2\2\u00c7D\3\2\2\2\u00c8\u00c9\7?\2\2\u00c9F\3"+
		"\2\2\2\u00ca\u00cb\7*\2\2\u00cbH\3\2\2\2\u00cc\u00cd\7+\2\2\u00cdJ\3\2"+
		"\2\2\u00ce\u00cf\7}\2\2\u00cfL\3\2\2\2\u00d0\u00d1\7\177\2\2\u00d1N\3"+
		"\2\2\2\u00d2\u00d4\t\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6P\3\2\2\2\u00d7\u00d9\t\2\2\2"+
		"\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc"+
		"\7\60\2\2\u00db\u00dd\t\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00dfR\3\2\2\2\u00e0\u00e4\t"+
		"\3\2\2\u00e1\u00e3\t\4\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5T\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e7\u00e9\t\5\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ebV\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed"+
		"\u00ee\7\61\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\13\2\2\2\u00f0\u00ef\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f6\t\6\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\b,\2\2\u00f8X\3\2\2\2\u00f9\u00fb\t\7\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\b-\2\2\u00ffZ\3\2\2\2\16\2x~\u0084\u00d5\u00d8"+
		"\u00de\u00e4\u00ea\u00f2\u00f5\u00fc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}