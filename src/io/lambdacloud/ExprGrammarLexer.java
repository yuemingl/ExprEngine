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
		LT=11, LE=12, EQ=13, ASIGN=14, LPAREN=15, RPAREN=16, DECIMAL=17, IDENTIFIER=18, 
		SEMI=19, COMMENT=20, WS=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", "GE", 
		"LT", "LE", "EQ", "ASIGN", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", 
		"SEMI", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'true'", "'false'", "'*'", "'/'", "'+'", "'-'", "'>'", 
		"'>='", "'<'", "'<='", "'=='", "'='", "'('", "')'", null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "GT", 
		"GE", "LT", "LE", "EQ", "ASIGN", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\5\2"+
		"\63\n\2\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\5\22b\n"+
		"\22\3\22\6\22e\n\22\r\22\16\22f\3\22\3\22\6\22k\n\22\r\22\16\22l\5\22"+
		"o\n\22\3\23\3\23\7\23s\n\23\f\23\16\23v\13\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\6\25~\n\25\r\25\16\25\177\3\25\5\25\u0083\n\25\3\25\3\25\3\26\6"+
		"\26\u0088\n\26\r\26\16\26\u0089\3\26\3\26\3\177\2\27\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\f\16"+
		"\17\"\"\u0095\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3\62\3\2"+
		"\2\2\58\3\2\2\2\7:\3\2\2\2\t?\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2"+
		"\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33W\3\2"+
		"\2\2\35Z\3\2\2\2\37\\\3\2\2\2!^\3\2\2\2#a\3\2\2\2%p\3\2\2\2\'w\3\2\2\2"+
		")y\3\2\2\2+\u0087\3\2\2\2-.\7c\2\2./\7p\2\2/\63\7f\2\2\60\61\7(\2\2\61"+
		"\63\7(\2\2\62-\3\2\2\2\62\60\3\2\2\2\63\4\3\2\2\2\64\65\7q\2\2\659\7t"+
		"\2\2\66\67\7~\2\2\679\7~\2\28\64\3\2\2\28\66\3\2\2\29\6\3\2\2\2:;\7v\2"+
		"\2;<\7t\2\2<=\7w\2\2=>\7g\2\2>\b\3\2\2\2?@\7h\2\2@A\7c\2\2AB\7n\2\2BC"+
		"\7u\2\2CD\7g\2\2D\n\3\2\2\2EF\7,\2\2F\f\3\2\2\2GH\7\61\2\2H\16\3\2\2\2"+
		"IJ\7-\2\2J\20\3\2\2\2KL\7/\2\2L\22\3\2\2\2MN\7@\2\2N\24\3\2\2\2OP\7@\2"+
		"\2PQ\7?\2\2Q\26\3\2\2\2RS\7>\2\2S\30\3\2\2\2TU\7>\2\2UV\7?\2\2V\32\3\2"+
		"\2\2WX\7?\2\2XY\7?\2\2Y\34\3\2\2\2Z[\7?\2\2[\36\3\2\2\2\\]\7*\2\2] \3"+
		"\2\2\2^_\7+\2\2_\"\3\2\2\2`b\7/\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\t"+
		"\2\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gn\3\2\2\2hj\7\60\2\2ik"+
		"\t\2\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nh\3\2\2\2n"+
		"o\3\2\2\2o$\3\2\2\2pt\t\3\2\2qs\t\4\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2"+
		"tu\3\2\2\2u&\3\2\2\2vt\3\2\2\2wx\7=\2\2x(\3\2\2\2yz\7\61\2\2z{\7\61\2"+
		"\2{}\3\2\2\2|~\13\2\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\177}"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\u0083\t\5\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\b\25\2\2\u0085*\3\2\2\2\u0086\u0088\t\6\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\26\2\2\u008c,\3\2\2\2\r\2\62"+
		"8aflnt\177\u0082\u0089\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}