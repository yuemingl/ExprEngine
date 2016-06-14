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
		ADD=1, SUB=2, MUL=3, DIV=4, REM=5, AND=6, OR=7, NOT=8, TRUE=9, FALSE=10, 
		GT=11, GE=12, LT=13, LE=14, EQ=15, NEQ=16, BAND=17, BOR=18, BXOR=19, BNOT=20, 
		SHL=21, SHR=22, USHR=23, INC=24, DESC=25, ADD_ASIGN=26, SUB_ASIGN=27, 
		MUL_ASIGN=28, DIV_ASIGN=29, REM_ASIGN=30, ASIGN=31, LPAREN=32, RPAREN=33, 
		INTEGER=34, FLOAT=35, IDENTIFIER=36, END_EXPR=37, COMMENT=38, WS=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", 
		"SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", "MUL_ASIGN", "DIV_ASIGN", 
		"REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "INTEGER", "FLOAT", "IDENTIFIER", 
		"END_EXPR", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", 
		"'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", 
		"SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", "MUL_ASIGN", "DIV_ASIGN", 
		"REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "INTEGER", "FLOAT", "IDENTIFIER", 
		"END_EXPR", "COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u00e4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\b\3\b\3\b\3\b\5\b"+
		"g\n\b\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\6#\u00b8\n#\r#\16#\u00b9\3$\5$\u00bd\n$\3$\3$"+
		"\6$\u00c1\n$\r$\16$\u00c2\3%\3%\7%\u00c7\n%\f%\16%\u00ca\13%\3&\6&\u00cd"+
		"\n&\r&\16&\u00ce\3\'\3\'\3\'\3\'\6\'\u00d5\n\'\r\'\16\'\u00d6\3\'\5\'"+
		"\u00da\n\'\3\'\3\'\3(\6(\u00df\n(\r(\16(\u00e0\3(\3(\3\u00d6\2)\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f==\3"+
		"\3\f\f\5\2\13\13\16\17\"\"\u00ed\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13Y\3\2\2\2\r`\3"+
		"\2\2\2\17f\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25s\3\2\2\2\27y\3\2\2\2\31"+
		"{\3\2\2\2\33~\3\2\2\2\35\u0080\3\2\2\2\37\u0083\3\2\2\2!\u0086\3\2\2\2"+
		"#\u0089\3\2\2\2%\u008b\3\2\2\2\'\u008d\3\2\2\2)\u008f\3\2\2\2+\u0091\3"+
		"\2\2\2-\u0094\3\2\2\2/\u0097\3\2\2\2\61\u009b\3\2\2\2\63\u009e\3\2\2\2"+
		"\65\u00a1\3\2\2\2\67\u00a4\3\2\2\29\u00a7\3\2\2\2;\u00aa\3\2\2\2=\u00ad"+
		"\3\2\2\2?\u00b0\3\2\2\2A\u00b2\3\2\2\2C\u00b4\3\2\2\2E\u00b7\3\2\2\2G"+
		"\u00bc\3\2\2\2I\u00c4\3\2\2\2K\u00cc\3\2\2\2M\u00d0\3\2\2\2O\u00de\3\2"+
		"\2\2QR\7-\2\2R\4\3\2\2\2ST\7/\2\2T\6\3\2\2\2UV\7,\2\2V\b\3\2\2\2WX\7\61"+
		"\2\2X\n\3\2\2\2YZ\7\'\2\2Z\f\3\2\2\2[\\\7c\2\2\\]\7p\2\2]a\7f\2\2^_\7"+
		"(\2\2_a\7(\2\2`[\3\2\2\2`^\3\2\2\2a\16\3\2\2\2bc\7q\2\2cg\7t\2\2de\7~"+
		"\2\2eg\7~\2\2fb\3\2\2\2fd\3\2\2\2g\20\3\2\2\2hi\7p\2\2ij\7q\2\2jm\7v\2"+
		"\2km\7#\2\2lh\3\2\2\2lk\3\2\2\2m\22\3\2\2\2no\7v\2\2op\7t\2\2pq\7w\2\2"+
		"qr\7g\2\2r\24\3\2\2\2st\7h\2\2tu\7c\2\2uv\7n\2\2vw\7u\2\2wx\7g\2\2x\26"+
		"\3\2\2\2yz\7@\2\2z\30\3\2\2\2{|\7@\2\2|}\7?\2\2}\32\3\2\2\2~\177\7>\2"+
		"\2\177\34\3\2\2\2\u0080\u0081\7>\2\2\u0081\u0082\7?\2\2\u0082\36\3\2\2"+
		"\2\u0083\u0084\7?\2\2\u0084\u0085\7?\2\2\u0085 \3\2\2\2\u0086\u0087\7"+
		"#\2\2\u0087\u0088\7?\2\2\u0088\"\3\2\2\2\u0089\u008a\7(\2\2\u008a$\3\2"+
		"\2\2\u008b\u008c\7~\2\2\u008c&\3\2\2\2\u008d\u008e\7`\2\2\u008e(\3\2\2"+
		"\2\u008f\u0090\7\u0080\2\2\u0090*\3\2\2\2\u0091\u0092\7>\2\2\u0092\u0093"+
		"\7>\2\2\u0093,\3\2\2\2\u0094\u0095\7@\2\2\u0095\u0096\7@\2\2\u0096.\3"+
		"\2\2\2\u0097\u0098\7@\2\2\u0098\u0099\7@\2\2\u0099\u009a\7@\2\2\u009a"+
		"\60\3\2\2\2\u009b\u009c\7-\2\2\u009c\u009d\7-\2\2\u009d\62\3\2\2\2\u009e"+
		"\u009f\7/\2\2\u009f\u00a0\7/\2\2\u00a0\64\3\2\2\2\u00a1\u00a2\7-\2\2\u00a2"+
		"\u00a3\7?\2\2\u00a3\66\3\2\2\2\u00a4\u00a5\7/\2\2\u00a5\u00a6\7?\2\2\u00a6"+
		"8\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7?\2\2\u00a9:\3\2\2\2\u00aa\u00ab"+
		"\7\61\2\2\u00ab\u00ac\7?\2\2\u00ac<\3\2\2\2\u00ad\u00ae\7\'\2\2\u00ae"+
		"\u00af\7?\2\2\u00af>\3\2\2\2\u00b0\u00b1\7?\2\2\u00b1@\3\2\2\2\u00b2\u00b3"+
		"\7*\2\2\u00b3B\3\2\2\2\u00b4\u00b5\7+\2\2\u00b5D\3\2\2\2\u00b6\u00b8\t"+
		"\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00baF\3\2\2\2\u00bb\u00bd\t\2\2\2\u00bc\u00bb\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\7\60\2\2\u00bf\u00c1"+
		"\t\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3H\3\2\2\2\u00c4\u00c8\t\3\2\2\u00c5\u00c7\t\4\2\2"+
		"\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9J\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\t\5\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cfL\3\2\2\2\u00d0\u00d1\7\61\2\2\u00d1\u00d2\7\61\2\2\u00d2\u00d4"+
		"\3\2\2\2\u00d3\u00d5\13\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2"+
		"\u00d6\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00da"+
		"\t\6\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\'\2\2\u00dc"+
		"N\3\2\2\2\u00dd\u00df\t\7\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2"+
		"\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3"+
		"\b(\2\2\u00e3P\3\2\2\2\16\2`fl\u00b9\u00bc\u00c2\u00c8\u00ce\u00d6\u00d9"+
		"\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}