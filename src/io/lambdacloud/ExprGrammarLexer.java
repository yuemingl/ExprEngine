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
		T__0=1, T__1=2, ADD=3, SUB=4, MUL=5, DIV=6, REM=7, AND=8, OR=9, NOT=10, 
		TRUE=11, FALSE=12, GT=13, GE=14, LT=15, LE=16, EQ=17, NEQ=18, BAND=19, 
		BOR=20, BXOR=21, BNOT=22, SHL=23, SHR=24, USHR=25, INC=26, DESC=27, ADD_ASIGN=28, 
		SUB_ASIGN=29, MUL_ASIGN=30, DIV_ASIGN=31, REM_ASIGN=32, ASIGN=33, LPAREN=34, 
		RPAREN=35, LCB=36, RCB=37, INTEGER=38, FLOAT=39, IDENTIFIER=40, END_EXPR=41, 
		COMMENT=42, WS=43;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", "NOT", 
		"TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", 
		"BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", 
		"MUL_ASIGN", "DIV_ASIGN", "REM_ASIGN", "ASIGN", "LPAREN", "RPAREN", "LCB", 
		"RCB", "INTEGER", "FLOAT", "IDENTIFIER", "END_EXPR", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'%'", null, null, 
		null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
		"'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", "AND", "OR", "NOT", 
		"TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", 
		"BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASIGN", "SUB_ASIGN", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u00f8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tq\n\t\3\n\3\n\3\n\3\n\5\nw\n\n\3\13\3\13"+
		"\3\13\3\13\5\13}\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\6\'\u00cc\n\'\r\'\16\'\u00cd\3(\5(\u00d1\n(\3(\3(\6(\u00d5"+
		"\n(\r(\16(\u00d6\3)\3)\7)\u00db\n)\f)\16)\u00de\13)\3*\6*\u00e1\n*\r*"+
		"\16*\u00e2\3+\3+\3+\3+\6+\u00e9\n+\r+\16+\u00ea\3+\5+\u00ee\n+\3+\3+\3"+
		",\6,\u00f3\n,\r,\16,\u00f4\3,\3,\3\u00ea\2-\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f==\3\3\f\f\5\2\13"+
		"\13\16\17\"\"\u0101\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5\\\3\2\2\2\7a\3"+
		"\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21p\3\2\2\2\23v\3"+
		"\2\2\2\25|\3\2\2\2\27~\3\2\2\2\31\u0083\3\2\2\2\33\u0089\3\2\2\2\35\u008b"+
		"\3\2\2\2\37\u008e\3\2\2\2!\u0090\3\2\2\2#\u0093\3\2\2\2%\u0096\3\2\2\2"+
		"\'\u0099\3\2\2\2)\u009b\3\2\2\2+\u009d\3\2\2\2-\u009f\3\2\2\2/\u00a1\3"+
		"\2\2\2\61\u00a4\3\2\2\2\63\u00a7\3\2\2\2\65\u00ab\3\2\2\2\67\u00ae\3\2"+
		"\2\29\u00b1\3\2\2\2;\u00b4\3\2\2\2=\u00b7\3\2\2\2?\u00ba\3\2\2\2A\u00bd"+
		"\3\2\2\2C\u00c0\3\2\2\2E\u00c2\3\2\2\2G\u00c4\3\2\2\2I\u00c6\3\2\2\2K"+
		"\u00c8\3\2\2\2M\u00cb\3\2\2\2O\u00d0\3\2\2\2Q\u00d8\3\2\2\2S\u00e0\3\2"+
		"\2\2U\u00e4\3\2\2\2W\u00f2\3\2\2\2YZ\7k\2\2Z[\7h\2\2[\4\3\2\2\2\\]\7g"+
		"\2\2]^\7n\2\2^_\7u\2\2_`\7g\2\2`\6\3\2\2\2ab\7-\2\2b\b\3\2\2\2cd\7/\2"+
		"\2d\n\3\2\2\2ef\7,\2\2f\f\3\2\2\2gh\7\61\2\2h\16\3\2\2\2ij\7\'\2\2j\20"+
		"\3\2\2\2kl\7c\2\2lm\7p\2\2mq\7f\2\2no\7(\2\2oq\7(\2\2pk\3\2\2\2pn\3\2"+
		"\2\2q\22\3\2\2\2rs\7q\2\2sw\7t\2\2tu\7~\2\2uw\7~\2\2vr\3\2\2\2vt\3\2\2"+
		"\2w\24\3\2\2\2xy\7p\2\2yz\7q\2\2z}\7v\2\2{}\7#\2\2|x\3\2\2\2|{\3\2\2\2"+
		"}\26\3\2\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7w\2\2\u0081\u0082"+
		"\7g\2\2\u0082\30\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7c\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7@\2\2\u008a\34\3\2\2\2\u008b\u008c\7@\2\2\u008c\u008d\7?\2\2\u008d\36"+
		"\3\2\2\2\u008e\u008f\7>\2\2\u008f \3\2\2\2\u0090\u0091\7>\2\2\u0091\u0092"+
		"\7?\2\2\u0092\"\3\2\2\2\u0093\u0094\7?\2\2\u0094\u0095\7?\2\2\u0095$\3"+
		"\2\2\2\u0096\u0097\7#\2\2\u0097\u0098\7?\2\2\u0098&\3\2\2\2\u0099\u009a"+
		"\7(\2\2\u009a(\3\2\2\2\u009b\u009c\7~\2\2\u009c*\3\2\2\2\u009d\u009e\7"+
		"`\2\2\u009e,\3\2\2\2\u009f\u00a0\7\u0080\2\2\u00a0.\3\2\2\2\u00a1\u00a2"+
		"\7>\2\2\u00a2\u00a3\7>\2\2\u00a3\60\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\u00a6"+
		"\7@\2\2\u00a6\62\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00a9\7@\2\2\u00a9\u00aa"+
		"\7@\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac\u00ad\7-\2\2\u00ad\66"+
		"\3\2\2\2\u00ae\u00af\7/\2\2\u00af\u00b0\7/\2\2\u00b08\3\2\2\2\u00b1\u00b2"+
		"\7-\2\2\u00b2\u00b3\7?\2\2\u00b3:\3\2\2\2\u00b4\u00b5\7/\2\2\u00b5\u00b6"+
		"\7?\2\2\u00b6<\3\2\2\2\u00b7\u00b8\7,\2\2\u00b8\u00b9\7?\2\2\u00b9>\3"+
		"\2\2\2\u00ba\u00bb\7\61\2\2\u00bb\u00bc\7?\2\2\u00bc@\3\2\2\2\u00bd\u00be"+
		"\7\'\2\2\u00be\u00bf\7?\2\2\u00bfB\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1D\3"+
		"\2\2\2\u00c2\u00c3\7*\2\2\u00c3F\3\2\2\2\u00c4\u00c5\7+\2\2\u00c5H\3\2"+
		"\2\2\u00c6\u00c7\7}\2\2\u00c7J\3\2\2\2\u00c8\u00c9\7\177\2\2\u00c9L\3"+
		"\2\2\2\u00ca\u00cc\t\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ceN\3\2\2\2\u00cf\u00d1\t\2\2\2"+
		"\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4"+
		"\7\60\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2"+
		"\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7P\3\2\2\2\u00d8\u00dc\t"+
		"\3\2\2\u00d9\u00db\t\4\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00ddR\3\2\2\2\u00de\u00dc\3\2\2\2"+
		"\u00df\u00e1\t\5\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3T\3\2\2\2\u00e4\u00e5\7\61\2\2\u00e5"+
		"\u00e6\7\61\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e9\13\2\2\2\u00e8\u00e7\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00ee\t\6\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef\u00f0\b+\2\2\u00f0V\3\2\2\2\u00f1\u00f3\t\7\2\2\u00f2\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\b,\2\2\u00f7X\3\2\2\2\16\2pv|\u00cd\u00d0\u00d6"+
		"\u00dc\u00e2\u00ea\u00ed\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}