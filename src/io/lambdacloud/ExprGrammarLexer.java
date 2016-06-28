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
		REM_ASSIGN=35, ASSIGN=36, LPAREN=37, RPAREN=38, LBRK=39, RBRK=40, LCB=41, 
		RCB=42, INTEGER=43, FLOAT=44, IDENTIFIER=45, COMMA=46, COLON=47, SEMI=48, 
		PERIOD=49, SQUOTE=50, DQUOTE=51, COMMENT=52, WS=53, StringLiteral=54;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ADD", "SUB", "MUL", "DIV", "REM", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", 
		"StringLiteral", "Characters", "Character", "EscapeSeq"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'\n'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", 
		"'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", "';'", 
		"'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", "REM", 
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", 
		"BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", 
		"StringLiteral"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\28\u0142\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u0099\n\f\3"+
		"\r\3\r\3\r\3\r\5\r\u009f\n\r\3\16\3\16\3\16\3\16\5\16\u00a5\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\""+
		"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\6,\u00f8"+
		"\n,\r,\16,\u00f9\3-\5-\u00fd\n-\3-\3-\6-\u0101\n-\r-\16-\u0102\3.\3.\7"+
		".\u0107\n.\f.\16.\u010a\13.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\64\3\64\3\65\3\65\3\65\3\65\6\65\u011c\n\65\r\65\16\65\u011d\3\65"+
		"\5\65\u0121\n\65\3\65\3\65\3\66\6\66\u0126\n\66\r\66\16\66\u0127\3\66"+
		"\3\66\3\67\3\67\5\67\u012e\n\67\3\67\5\67\u0131\n\67\3\67\3\67\5\67\u0135"+
		"\n\67\38\68\u0138\n8\r8\168\u0139\39\39\59\u013e\n9\3:\3:\3:\3\u011d\2"+
		";\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o"+
		"\2q\2s\2\3\2\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\13\16"+
		"\17\"\"\4\2$$^^\n\2$$))^^ddhhppttvv\u014c\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3u\3\2\2\2\5x\3\2\2\2\7}"+
		"\3\2\2\2\t\u0083\3\2\2\2\13\u0087\3\2\2\2\r\u0089\3\2\2\2\17\u008b\3\2"+
		"\2\2\21\u008d\3\2\2\2\23\u008f\3\2\2\2\25\u0091\3\2\2\2\27\u0098\3\2\2"+
		"\2\31\u009e\3\2\2\2\33\u00a4\3\2\2\2\35\u00a6\3\2\2\2\37\u00ab\3\2\2\2"+
		"!\u00b1\3\2\2\2#\u00b3\3\2\2\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00bb\3"+
		"\2\2\2+\u00be\3\2\2\2-\u00c1\3\2\2\2/\u00c3\3\2\2\2\61\u00c5\3\2\2\2\63"+
		"\u00c7\3\2\2\2\65\u00c9\3\2\2\2\67\u00cc\3\2\2\29\u00cf\3\2\2\2;\u00d3"+
		"\3\2\2\2=\u00d6\3\2\2\2?\u00d9\3\2\2\2A\u00dc\3\2\2\2C\u00df\3\2\2\2E"+
		"\u00e2\3\2\2\2G\u00e5\3\2\2\2I\u00e8\3\2\2\2K\u00ea\3\2\2\2M\u00ec\3\2"+
		"\2\2O\u00ee\3\2\2\2Q\u00f0\3\2\2\2S\u00f2\3\2\2\2U\u00f4\3\2\2\2W\u00f7"+
		"\3\2\2\2Y\u00fc\3\2\2\2[\u0104\3\2\2\2]\u010b\3\2\2\2_\u010d\3\2\2\2a"+
		"\u010f\3\2\2\2c\u0111\3\2\2\2e\u0113\3\2\2\2g\u0115\3\2\2\2i\u0117\3\2"+
		"\2\2k\u0125\3\2\2\2m\u012d\3\2\2\2o\u0137\3\2\2\2q\u013d\3\2\2\2s\u013f"+
		"\3\2\2\2uv\7k\2\2vw\7h\2\2w\4\3\2\2\2xy\7g\2\2yz\7n\2\2z{\7u\2\2{|\7g"+
		"\2\2|\6\3\2\2\2}~\7y\2\2~\177\7j\2\2\177\u0080\7k\2\2\u0080\u0081\7n\2"+
		"\2\u0081\u0082\7g\2\2\u0082\b\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7"+
		"q\2\2\u0085\u0086\7t\2\2\u0086\n\3\2\2\2\u0087\u0088\7\f\2\2\u0088\f\3"+
		"\2\2\2\u0089\u008a\7-\2\2\u008a\16\3\2\2\2\u008b\u008c\7/\2\2\u008c\20"+
		"\3\2\2\2\u008d\u008e\7,\2\2\u008e\22\3\2\2\2\u008f\u0090\7\61\2\2\u0090"+
		"\24\3\2\2\2\u0091\u0092\7\'\2\2\u0092\26\3\2\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0099\7f\2\2\u0096\u0097\7(\2\2\u0097\u0099\7(\2\2"+
		"\u0098\u0093\3\2\2\2\u0098\u0096\3\2\2\2\u0099\30\3\2\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009f\7t\2\2\u009c\u009d\7~\2\2\u009d\u009f\7~\2\2\u009e"+
		"\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f\32\3\2\2\2\u00a0\u00a1\7p\2\2"+
		"\u00a1\u00a2\7q\2\2\u00a2\u00a5\7v\2\2\u00a3\u00a5\7#\2\2\u00a4\u00a0"+
		"\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\34\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7g\2\2\u00aa\36\3\2\2\2\u00ab"+
		"\u00ac\7h\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7u\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0 \3\2\2\2\u00b1\u00b2\7@\2\2\u00b2\"\3\2\2\2"+
		"\u00b3\u00b4\7@\2\2\u00b4\u00b5\7?\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7>\2"+
		"\2\u00b7&\3\2\2\2\u00b8\u00b9\7>\2\2\u00b9\u00ba\7?\2\2\u00ba(\3\2\2\2"+
		"\u00bb\u00bc\7?\2\2\u00bc\u00bd\7?\2\2\u00bd*\3\2\2\2\u00be\u00bf\7#\2"+
		"\2\u00bf\u00c0\7?\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7(\2\2\u00c2.\3\2\2\2"+
		"\u00c3\u00c4\7~\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\7`\2\2\u00c6\62\3\2\2"+
		"\2\u00c7\u00c8\7\u0080\2\2\u00c8\64\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb"+
		"\7>\2\2\u00cb\66\3\2\2\2\u00cc\u00cd\7@\2\2\u00cd\u00ce\7@\2\2\u00ce8"+
		"\3\2\2\2\u00cf\u00d0\7@\2\2\u00d0\u00d1\7@\2\2\u00d1\u00d2\7@\2\2\u00d2"+
		":\3\2\2\2\u00d3\u00d4\7-\2\2\u00d4\u00d5\7-\2\2\u00d5<\3\2\2\2\u00d6\u00d7"+
		"\7/\2\2\u00d7\u00d8\7/\2\2\u00d8>\3\2\2\2\u00d9\u00da\7-\2\2\u00da\u00db"+
		"\7?\2\2\u00db@\3\2\2\2\u00dc\u00dd\7/\2\2\u00dd\u00de\7?\2\2\u00deB\3"+
		"\2\2\2\u00df\u00e0\7,\2\2\u00e0\u00e1\7?\2\2\u00e1D\3\2\2\2\u00e2\u00e3"+
		"\7\61\2\2\u00e3\u00e4\7?\2\2\u00e4F\3\2\2\2\u00e5\u00e6\7\'\2\2\u00e6"+
		"\u00e7\7?\2\2\u00e7H\3\2\2\2\u00e8\u00e9\7?\2\2\u00e9J\3\2\2\2\u00ea\u00eb"+
		"\7*\2\2\u00ebL\3\2\2\2\u00ec\u00ed\7+\2\2\u00edN\3\2\2\2\u00ee\u00ef\7"+
		"]\2\2\u00efP\3\2\2\2\u00f0\u00f1\7_\2\2\u00f1R\3\2\2\2\u00f2\u00f3\7}"+
		"\2\2\u00f3T\3\2\2\2\u00f4\u00f5\7\177\2\2\u00f5V\3\2\2\2\u00f6\u00f8\t"+
		"\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00faX\3\2\2\2\u00fb\u00fd\t\2\2\2\u00fc\u00fb\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\7\60\2\2\u00ff\u0101"+
		"\t\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103Z\3\2\2\2\u0104\u0108\t\3\2\2\u0105\u0107\t\4\2\2"+
		"\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\\\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7.\2\2\u010c"+
		"^\3\2\2\2\u010d\u010e\7<\2\2\u010e`\3\2\2\2\u010f\u0110\7=\2\2\u0110b"+
		"\3\2\2\2\u0111\u0112\7\60\2\2\u0112d\3\2\2\2\u0113\u0114\7)\2\2\u0114"+
		"f\3\2\2\2\u0115\u0116\7$\2\2\u0116h\3\2\2\2\u0117\u0118\7\61\2\2\u0118"+
		"\u0119\7\61\2\2\u0119\u011b\3\2\2\2\u011a\u011c\13\2\2\2\u011b\u011a\3"+
		"\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e"+
		"\u0120\3\2\2\2\u011f\u0121\t\5\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\b\65\2\2\u0123j\3\2\2\2\u0124\u0126\t\6\2\2\u0125\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\b\66\2\2\u012al\3\2\2\2\u012b\u012e\5g\64\2"+
		"\u012c\u012e\5e\63\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0130"+
		"\3\2\2\2\u012f\u0131\5o8\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0135\5g\64\2\u0133\u0135\5e\63\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0133\3\2\2\2\u0135n\3\2\2\2\u0136\u0138\5q9\2\u0137\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"p\3\2\2\2\u013b\u013e\n\7\2\2\u013c\u013e\5s:\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013c\3\2\2\2\u013er\3\2\2\2\u013f\u0140\7^\2\2\u0140\u0141\t\b\2\2\u0141"+
		"t\3\2\2\2\22\2\u0098\u009e\u00a4\u00f9\u00fc\u0102\u0108\u011d\u0120\u0127"+
		"\u012d\u0130\u0134\u0139\u013d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}