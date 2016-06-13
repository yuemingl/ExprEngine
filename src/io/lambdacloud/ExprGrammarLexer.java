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
		AND=1, OR=2, TRUE=3, FALSE=4, MULT=5, DIV=6, PLUS=7, MINUS=8, GT=9, GE=10, 
		LT=11, LE=12, EQ=13, NEQ=14, ASIGN=15, LPAREN=16, RPAREN=17, DECIMAL=18, 
		IDENTIFIER=19, END_EXPR=20, COMMENT=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", "GE", 
		"LT", "LE", "EQ", "NEQ", "ASIGN", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", 
		"END_EXPR", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'true'", "'false'", "'*'", "'/'", "'+'", "'-'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'!='", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", 
		"GE", "LT", "LE", "EQ", "NEQ", "ASIGN", "LPAREN", "RPAREN", "DECIMAL", 
		"IDENTIFIER", "END_EXPR", "COMMENT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\5\2\65\n\2\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\5\23g\n\23\3\23\6\23j\n\23\r\23\16\23k\3\23\3\23\6\23"+
		"p\n\23\r\23\16\23q\5\23t\n\23\3\24\3\24\7\24x\n\24\f\24\16\24{\13\24\3"+
		"\25\6\25~\n\25\r\25\16\25\177\3\26\3\26\3\26\3\26\6\26\u0086\n\26\r\26"+
		"\16\26\u0087\3\26\5\26\u008b\n\26\3\26\3\26\3\27\6\27\u0090\n\27\r\27"+
		"\16\27\u0091\3\27\3\27\3\u0087\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f==\3\3\f\f\5\2\13\13\16"+
		"\17\"\"\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\3\64\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2\tA\3\2\2\2\13G\3\2\2\2\rI\3\2\2"+
		"\2\17K\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27T\3\2\2\2\31V\3\2"+
		"\2\2\33Y\3\2\2\2\35\\\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#c\3\2\2\2%f\3\2\2"+
		"\2\'u\3\2\2\2)}\3\2\2\2+\u0081\3\2\2\2-\u008f\3\2\2\2/\60\7c\2\2\60\61"+
		"\7p\2\2\61\65\7f\2\2\62\63\7(\2\2\63\65\7(\2\2\64/\3\2\2\2\64\62\3\2\2"+
		"\2\65\4\3\2\2\2\66\67\7q\2\2\67;\7t\2\289\7~\2\29;\7~\2\2:\66\3\2\2\2"+
		":8\3\2\2\2;\6\3\2\2\2<=\7v\2\2=>\7t\2\2>?\7w\2\2?@\7g\2\2@\b\3\2\2\2A"+
		"B\7h\2\2BC\7c\2\2CD\7n\2\2DE\7u\2\2EF\7g\2\2F\n\3\2\2\2GH\7,\2\2H\f\3"+
		"\2\2\2IJ\7\61\2\2J\16\3\2\2\2KL\7-\2\2L\20\3\2\2\2MN\7/\2\2N\22\3\2\2"+
		"\2OP\7@\2\2P\24\3\2\2\2QR\7@\2\2RS\7?\2\2S\26\3\2\2\2TU\7>\2\2U\30\3\2"+
		"\2\2VW\7>\2\2WX\7?\2\2X\32\3\2\2\2YZ\7?\2\2Z[\7?\2\2[\34\3\2\2\2\\]\7"+
		"#\2\2]^\7?\2\2^\36\3\2\2\2_`\7?\2\2` \3\2\2\2ab\7*\2\2b\"\3\2\2\2cd\7"+
		"+\2\2d$\3\2\2\2eg\7/\2\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hj\t\2\2\2ih\3\2"+
		"\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ls\3\2\2\2mo\7\60\2\2np\t\2\2\2on\3"+
		"\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sm\3\2\2\2st\3\2\2\2t&\3"+
		"\2\2\2uy\t\3\2\2vx\t\4\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z(\3"+
		"\2\2\2{y\3\2\2\2|~\t\5\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080*\3\2\2\2\u0081\u0082\7\61\2\2\u0082\u0083\7\61\2\2\u0083"+
		"\u0085\3\2\2\2\u0084\u0086\13\2\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u008b\t\6\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\26"+
		"\2\2\u008d,\3\2\2\2\u008e\u0090\t\7\2\2\u008f\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\b\27\2\2\u0094.\3\2\2\2\16\2\64:fkqsy\177\u0087\u008a\u0091\3\b"+
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