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
		LT=11, LE=12, EQ=13, LPAREN=14, RPAREN=15, DECIMAL=16, IDENTIFIER=17, 
		SEMI=18, COMMENT=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", "GE", 
		"LT", "LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SEMI", 
		"COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'true'", "'false'", "'*'", "'/'", "'+'", "'-'", "'>'", 
		"'>='", "'<'", "'<='", "'='", "'('", "')'", null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", 
		"GE", "LT", "LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SEMI", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u0088\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\5\2\61\n\2\3\3"+
		"\3\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\5\21]\n\21\3\21\6\21`\n\21\r\21"+
		"\16\21a\3\21\3\21\6\21f\n\21\r\21\16\21g\5\21j\n\21\3\22\3\22\7\22n\n"+
		"\22\f\22\16\22q\13\22\3\23\3\23\3\24\3\24\3\24\3\24\6\24y\n\24\r\24\16"+
		"\24z\3\24\5\24~\n\24\3\24\3\24\3\25\6\25\u0083\n\25\r\25\16\25\u0084\3"+
		"\25\3\25\3z\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\7\3\2\62;\5\2C\\aac|\6"+
		"\2\62;C\\aac|\3\3\f\f\5\2\13\f\16\17\"\"\u0090\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\3\60\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\t=\3\2\2\2\13C\3"+
		"\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27P"+
		"\3\2\2\2\31R\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3\2\2\2!\\\3\2\2\2#k"+
		"\3\2\2\2%r\3\2\2\2\'t\3\2\2\2)\u0082\3\2\2\2+,\7c\2\2,-\7p\2\2-\61\7f"+
		"\2\2./\7(\2\2/\61\7(\2\2\60+\3\2\2\2\60.\3\2\2\2\61\4\3\2\2\2\62\63\7"+
		"q\2\2\63\67\7t\2\2\64\65\7~\2\2\65\67\7~\2\2\66\62\3\2\2\2\66\64\3\2\2"+
		"\2\67\6\3\2\2\289\7v\2\29:\7t\2\2:;\7w\2\2;<\7g\2\2<\b\3\2\2\2=>\7h\2"+
		"\2>?\7c\2\2?@\7n\2\2@A\7u\2\2AB\7g\2\2B\n\3\2\2\2CD\7,\2\2D\f\3\2\2\2"+
		"EF\7\61\2\2F\16\3\2\2\2GH\7-\2\2H\20\3\2\2\2IJ\7/\2\2J\22\3\2\2\2KL\7"+
		"@\2\2L\24\3\2\2\2MN\7@\2\2NO\7?\2\2O\26\3\2\2\2PQ\7>\2\2Q\30\3\2\2\2R"+
		"S\7>\2\2ST\7?\2\2T\32\3\2\2\2UV\7?\2\2V\34\3\2\2\2WX\7*\2\2X\36\3\2\2"+
		"\2YZ\7+\2\2Z \3\2\2\2[]\7/\2\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\t\2\2"+
		"\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bi\3\2\2\2ce\7\60\2\2df\t\2"+
		"\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ic\3\2\2\2ij\3\2"+
		"\2\2j\"\3\2\2\2ko\t\3\2\2ln\t\4\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3"+
		"\2\2\2p$\3\2\2\2qo\3\2\2\2rs\7=\2\2s&\3\2\2\2tu\7\61\2\2uv\7\61\2\2vx"+
		"\3\2\2\2wy\13\2\2\2xw\3\2\2\2yz\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2"+
		"|~\t\5\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\b\24\2\2\u0080(\3\2\2\2\u0081"+
		"\u0083\t\6\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\25\2\2\u0087"+
		"*\3\2\2\2\r\2\60\66\\agioz}\u0084\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}