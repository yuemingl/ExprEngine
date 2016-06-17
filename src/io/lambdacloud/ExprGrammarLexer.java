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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		REM=11, AND=12, OR=13, NOT=14, TRUE=15, FALSE=16, GT=17, GE=18, LT=19, 
		LE=20, EQ=21, NEQ=22, BAND=23, BOR=24, BXOR=25, BNOT=26, SHL=27, SHR=28, 
		USHR=29, INC=30, DESC=31, ADD_ASSIGN=32, SUB_ASSIGN=33, MUL_ASSIGN=34, 
		DIV_ASSIGN=35, REM_ASSIGN=36, ASSIGN=37, LPAREN=38, RPAREN=39, LCB=40, 
		RCB=41, INTEGER=42, FLOAT=43, IDENTIFIER=44, SEMI=45, COMMENT=46, WS=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "ADD", "SUB", "MUL", "DIV", 
		"REM", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"SEMI", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "','", "'\n'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", 
		"'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", 
		"'('", "')'", "'{'", "'}'", null, null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"SEMI", "COMMENT", "WS"
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
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u0087\n\r\3\16\3\16"+
		"\3\16\3\16\5\16\u008d\n\16\3\17\3\17\3\17\3\17\5\17\u0093\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\6+\u00e2\n+\r+\16+\u00e3"+
		"\3,\5,\u00e7\n,\3,\3,\6,\u00eb\n,\r,\16,\u00ec\3-\3-\7-\u00f1\n-\f-\16"+
		"-\u00f4\13-\3.\3.\3/\3/\3/\3/\6/\u00fc\n/\r/\16/\u00fd\3/\5/\u0101\n/"+
		"\3/\3/\3\60\6\60\u0106\n\60\r\60\16\60\u0107\3\60\3\60\3\u00fd\2\61\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\7\3\2\62;\5\2C\\aac|\6\2"+
		"\62;C\\aac|\3\3\f\f\5\2\13\13\16\17\"\"\u0113\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5d\3\2\2\2\7i\3\2"+
		"\2\2\to\3\2\2\2\13s\3\2\2\2\ru\3\2\2\2\17w\3\2\2\2\21y\3\2\2\2\23{\3\2"+
		"\2\2\25}\3\2\2\2\27\177\3\2\2\2\31\u0086\3\2\2\2\33\u008c\3\2\2\2\35\u0092"+
		"\3\2\2\2\37\u0094\3\2\2\2!\u0099\3\2\2\2#\u009f\3\2\2\2%\u00a1\3\2\2\2"+
		"\'\u00a4\3\2\2\2)\u00a6\3\2\2\2+\u00a9\3\2\2\2-\u00ac\3\2\2\2/\u00af\3"+
		"\2\2\2\61\u00b1\3\2\2\2\63\u00b3\3\2\2\2\65\u00b5\3\2\2\2\67\u00b7\3\2"+
		"\2\29\u00ba\3\2\2\2;\u00bd\3\2\2\2=\u00c1\3\2\2\2?\u00c4\3\2\2\2A\u00c7"+
		"\3\2\2\2C\u00ca\3\2\2\2E\u00cd\3\2\2\2G\u00d0\3\2\2\2I\u00d3\3\2\2\2K"+
		"\u00d6\3\2\2\2M\u00d8\3\2\2\2O\u00da\3\2\2\2Q\u00dc\3\2\2\2S\u00de\3\2"+
		"\2\2U\u00e1\3\2\2\2W\u00e6\3\2\2\2Y\u00ee\3\2\2\2[\u00f5\3\2\2\2]\u00f7"+
		"\3\2\2\2_\u0105\3\2\2\2ab\7k\2\2bc\7h\2\2c\4\3\2\2\2de\7g\2\2ef\7n\2\2"+
		"fg\7u\2\2gh\7g\2\2h\6\3\2\2\2ij\7y\2\2jk\7j\2\2kl\7k\2\2lm\7n\2\2mn\7"+
		"g\2\2n\b\3\2\2\2op\7h\2\2pq\7q\2\2qr\7t\2\2r\n\3\2\2\2st\7.\2\2t\f\3\2"+
		"\2\2uv\7\f\2\2v\16\3\2\2\2wx\7-\2\2x\20\3\2\2\2yz\7/\2\2z\22\3\2\2\2{"+
		"|\7,\2\2|\24\3\2\2\2}~\7\61\2\2~\26\3\2\2\2\177\u0080\7\'\2\2\u0080\30"+
		"\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7p\2\2\u0083\u0087\7f\2\2\u0084"+
		"\u0085\7(\2\2\u0085\u0087\7(\2\2\u0086\u0081\3\2\2\2\u0086\u0084\3\2\2"+
		"\2\u0087\32\3\2\2\2\u0088\u0089\7q\2\2\u0089\u008d\7t\2\2\u008a\u008b"+
		"\7~\2\2\u008b\u008d\7~\2\2\u008c\u0088\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\34\3\2\2\2\u008e\u008f\7p\2\2\u008f\u0090\7q\2\2\u0090\u0093\7v\2\2\u0091"+
		"\u0093\7#\2\2\u0092\u008e\3\2\2\2\u0092\u0091\3\2\2\2\u0093\36\3\2\2\2"+
		"\u0094\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7w\2\2\u0097\u0098"+
		"\7g\2\2\u0098 \3\2\2\2\u0099\u009a\7h\2\2\u009a\u009b\7c\2\2\u009b\u009c"+
		"\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\"\3\2\2\2\u009f\u00a0"+
		"\7@\2\2\u00a0$\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\u00a3\7?\2\2\u00a3&\3"+
		"\2\2\2\u00a4\u00a5\7>\2\2\u00a5(\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7\u00a8"+
		"\7?\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7?\2\2\u00aa\u00ab\7?\2\2\u00ab,\3"+
		"\2\2\2\u00ac\u00ad\7#\2\2\u00ad\u00ae\7?\2\2\u00ae.\3\2\2\2\u00af\u00b0"+
		"\7(\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7~\2\2\u00b2\62\3\2\2\2\u00b3\u00b4"+
		"\7`\2\2\u00b4\64\3\2\2\2\u00b5\u00b6\7\u0080\2\2\u00b6\66\3\2\2\2\u00b7"+
		"\u00b8\7>\2\2\u00b8\u00b9\7>\2\2\u00b98\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb"+
		"\u00bc\7@\2\2\u00bc:\3\2\2\2\u00bd\u00be\7@\2\2\u00be\u00bf\7@\2\2\u00bf"+
		"\u00c0\7@\2\2\u00c0<\3\2\2\2\u00c1\u00c2\7-\2\2\u00c2\u00c3\7-\2\2\u00c3"+
		">\3\2\2\2\u00c4\u00c5\7/\2\2\u00c5\u00c6\7/\2\2\u00c6@\3\2\2\2\u00c7\u00c8"+
		"\7-\2\2\u00c8\u00c9\7?\2\2\u00c9B\3\2\2\2\u00ca\u00cb\7/\2\2\u00cb\u00cc"+
		"\7?\2\2\u00ccD\3\2\2\2\u00cd\u00ce\7,\2\2\u00ce\u00cf\7?\2\2\u00cfF\3"+
		"\2\2\2\u00d0\u00d1\7\61\2\2\u00d1\u00d2\7?\2\2\u00d2H\3\2\2\2\u00d3\u00d4"+
		"\7\'\2\2\u00d4\u00d5\7?\2\2\u00d5J\3\2\2\2\u00d6\u00d7\7?\2\2\u00d7L\3"+
		"\2\2\2\u00d8\u00d9\7*\2\2\u00d9N\3\2\2\2\u00da\u00db\7+\2\2\u00dbP\3\2"+
		"\2\2\u00dc\u00dd\7}\2\2\u00ddR\3\2\2\2\u00de\u00df\7\177\2\2\u00dfT\3"+
		"\2\2\2\u00e0\u00e2\t\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4V\3\2\2\2\u00e5\u00e7\t\2\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea"+
		"\7\60\2\2\u00e9\u00eb\t\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2"+
		"\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00edX\3\2\2\2\u00ee\u00f2\t"+
		"\3\2\2\u00ef\u00f1\t\4\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3Z\3\2\2\2\u00f4\u00f2\3\2\2\2"+
		"\u00f5\u00f6\7=\2\2\u00f6\\\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\7"+
		"\61\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00fc\13\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\3\2"+
		"\2\2\u00ff\u0101\t\5\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\b/\2\2\u0103^\3\2\2\2\u0104\u0106\t\6\2\2\u0105\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\b\60\2\2\u010a`\3\2\2\2\r\2\u0086\u008c\u0092\u00e3\u00e6"+
		"\u00ec\u00f2\u00fd\u0100\u0107\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}