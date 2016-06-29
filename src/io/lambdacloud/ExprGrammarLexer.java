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
		DIV_ASSIGN=35, REM_ASSIGN=36, ASSIGN=37, LPAREN=38, RPAREN=39, LBRK=40, 
		RBRK=41, LCB=42, RCB=43, INTEGER=44, FLOAT=45, IDENTIFIER=46, COMMA=47, 
		COLON=48, SEMI=49, PERIOD=50, SQUOTE=51, DQUOTE=52, COMMENT=53, WS=54, 
		StringLiteral=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "ADD", "SUB", "MUL", "DIV", 
		"REM", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"COMMENT", "WS", "StringLiteral", "Characters", "Character", "EscapeSeq"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'\n'", "'in'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", null, null, null, "'true'", "'false'", "'>'", "'>='", 
		"'<'", "'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", 
		"'>>>'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", 
		"';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"NEQ", "BAND", "BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", 
		"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", 
		"ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", 
		"FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", 
		"COMMENT", "WS", "StringLiteral"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\29\u0147\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u009e\n\r\3\16\3\16\3\16\3\16\5\16\u00a4\n\16\3\17\3\17\3\17\3"+
		"\17\5\17\u00aa\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*"+
		"\3+\3+\3,\3,\3-\6-\u00fd\n-\r-\16-\u00fe\3.\5.\u0102\n.\3.\3.\6.\u0106"+
		"\n.\r.\16.\u0107\3/\3/\7/\u010c\n/\f/\16/\u010f\13/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\6\66\u0121"+
		"\n\66\r\66\16\66\u0122\3\66\5\66\u0126\n\66\3\66\3\66\3\67\6\67\u012b"+
		"\n\67\r\67\16\67\u012c\3\67\3\67\38\38\58\u0133\n8\38\58\u0136\n8\38\3"+
		"8\58\u013a\n8\39\69\u013d\n9\r9\169\u013e\3:\3:\5:\u0143\n:\3;\3;\3;\3"+
		"\u0122\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q\2s\2u\2\3\2\t\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f"+
		"\5\2\13\13\16\17\"\"\4\2$$^^\n\2$$))^^ddhhppttvv\u0151\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3w"+
		"\3\2\2\2\5z\3\2\2\2\7\177\3\2\2\2\t\u0085\3\2\2\2\13\u0089\3\2\2\2\r\u008b"+
		"\3\2\2\2\17\u008e\3\2\2\2\21\u0090\3\2\2\2\23\u0092\3\2\2\2\25\u0094\3"+
		"\2\2\2\27\u0096\3\2\2\2\31\u009d\3\2\2\2\33\u00a3\3\2\2\2\35\u00a9\3\2"+
		"\2\2\37\u00ab\3\2\2\2!\u00b0\3\2\2\2#\u00b6\3\2\2\2%\u00b8\3\2\2\2\'\u00bb"+
		"\3\2\2\2)\u00bd\3\2\2\2+\u00c0\3\2\2\2-\u00c3\3\2\2\2/\u00c6\3\2\2\2\61"+
		"\u00c8\3\2\2\2\63\u00ca\3\2\2\2\65\u00cc\3\2\2\2\67\u00ce\3\2\2\29\u00d1"+
		"\3\2\2\2;\u00d4\3\2\2\2=\u00d8\3\2\2\2?\u00db\3\2\2\2A\u00de\3\2\2\2C"+
		"\u00e1\3\2\2\2E\u00e4\3\2\2\2G\u00e7\3\2\2\2I\u00ea\3\2\2\2K\u00ed\3\2"+
		"\2\2M\u00ef\3\2\2\2O\u00f1\3\2\2\2Q\u00f3\3\2\2\2S\u00f5\3\2\2\2U\u00f7"+
		"\3\2\2\2W\u00f9\3\2\2\2Y\u00fc\3\2\2\2[\u0101\3\2\2\2]\u0109\3\2\2\2_"+
		"\u0110\3\2\2\2a\u0112\3\2\2\2c\u0114\3\2\2\2e\u0116\3\2\2\2g\u0118\3\2"+
		"\2\2i\u011a\3\2\2\2k\u011c\3\2\2\2m\u012a\3\2\2\2o\u0132\3\2\2\2q\u013c"+
		"\3\2\2\2s\u0142\3\2\2\2u\u0144\3\2\2\2wx\7k\2\2xy\7h\2\2y\4\3\2\2\2z{"+
		"\7g\2\2{|\7n\2\2|}\7u\2\2}~\7g\2\2~\6\3\2\2\2\177\u0080\7y\2\2\u0080\u0081"+
		"\7j\2\2\u0081\u0082\7k\2\2\u0082\u0083\7n\2\2\u0083\u0084\7g\2\2\u0084"+
		"\b\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7q\2\2\u0087\u0088\7t\2\2\u0088"+
		"\n\3\2\2\2\u0089\u008a\7\f\2\2\u008a\f\3\2\2\2\u008b\u008c\7k\2\2\u008c"+
		"\u008d\7p\2\2\u008d\16\3\2\2\2\u008e\u008f\7-\2\2\u008f\20\3\2\2\2\u0090"+
		"\u0091\7/\2\2\u0091\22\3\2\2\2\u0092\u0093\7,\2\2\u0093\24\3\2\2\2\u0094"+
		"\u0095\7\61\2\2\u0095\26\3\2\2\2\u0096\u0097\7\'\2\2\u0097\30\3\2\2\2"+
		"\u0098\u0099\7c\2\2\u0099\u009a\7p\2\2\u009a\u009e\7f\2\2\u009b\u009c"+
		"\7(\2\2\u009c\u009e\7(\2\2\u009d\u0098\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\32\3\2\2\2\u009f\u00a0\7q\2\2\u00a0\u00a4\7t\2\2\u00a1\u00a2\7~\2\2\u00a2"+
		"\u00a4\7~\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\34\3\2\2\2"+
		"\u00a5\u00a6\7p\2\2\u00a6\u00a7\7q\2\2\u00a7\u00aa\7v\2\2\u00a8\u00aa"+
		"\7#\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\36\3\2\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7g\2\2"+
		"\u00af \3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7n\2"+
		"\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7g\2\2\u00b5\"\3\2\2\2\u00b6\u00b7\7"+
		"@\2\2\u00b7$\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\u00ba\7?\2\2\u00ba&\3\2"+
		"\2\2\u00bb\u00bc\7>\2\2\u00bc(\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf"+
		"\7?\2\2\u00bf*\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7?\2\2\u00c2,\3"+
		"\2\2\2\u00c3\u00c4\7#\2\2\u00c4\u00c5\7?\2\2\u00c5.\3\2\2\2\u00c6\u00c7"+
		"\7(\2\2\u00c7\60\3\2\2\2\u00c8\u00c9\7~\2\2\u00c9\62\3\2\2\2\u00ca\u00cb"+
		"\7`\2\2\u00cb\64\3\2\2\2\u00cc\u00cd\7\u0080\2\2\u00cd\66\3\2\2\2\u00ce"+
		"\u00cf\7>\2\2\u00cf\u00d0\7>\2\2\u00d08\3\2\2\2\u00d1\u00d2\7@\2\2\u00d2"+
		"\u00d3\7@\2\2\u00d3:\3\2\2\2\u00d4\u00d5\7@\2\2\u00d5\u00d6\7@\2\2\u00d6"+
		"\u00d7\7@\2\2\u00d7<\3\2\2\2\u00d8\u00d9\7-\2\2\u00d9\u00da\7-\2\2\u00da"+
		">\3\2\2\2\u00db\u00dc\7/\2\2\u00dc\u00dd\7/\2\2\u00dd@\3\2\2\2\u00de\u00df"+
		"\7-\2\2\u00df\u00e0\7?\2\2\u00e0B\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2\u00e3"+
		"\7?\2\2\u00e3D\3\2\2\2\u00e4\u00e5\7,\2\2\u00e5\u00e6\7?\2\2\u00e6F\3"+
		"\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\7?\2\2\u00e9H\3\2\2\2\u00ea\u00eb"+
		"\7\'\2\2\u00eb\u00ec\7?\2\2\u00ecJ\3\2\2\2\u00ed\u00ee\7?\2\2\u00eeL\3"+
		"\2\2\2\u00ef\u00f0\7*\2\2\u00f0N\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2P\3\2"+
		"\2\2\u00f3\u00f4\7]\2\2\u00f4R\3\2\2\2\u00f5\u00f6\7_\2\2\u00f6T\3\2\2"+
		"\2\u00f7\u00f8\7}\2\2\u00f8V\3\2\2\2\u00f9\u00fa\7\177\2\2\u00faX\3\2"+
		"\2\2\u00fb\u00fd\t\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ffZ\3\2\2\2\u0100\u0102\t\2\2\2"+
		"\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105"+
		"\7\60\2\2\u0104\u0106\t\2\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\\\3\2\2\2\u0109\u010d\t"+
		"\3\2\2\u010a\u010c\t\4\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e^\3\2\2\2\u010f\u010d\3\2\2\2"+
		"\u0110\u0111\7.\2\2\u0111`\3\2\2\2\u0112\u0113\7<\2\2\u0113b\3\2\2\2\u0114"+
		"\u0115\7=\2\2\u0115d\3\2\2\2\u0116\u0117\7\60\2\2\u0117f\3\2\2\2\u0118"+
		"\u0119\7)\2\2\u0119h\3\2\2\2\u011a\u011b\7$\2\2\u011bj\3\2\2\2\u011c\u011d"+
		"\7\61\2\2\u011d\u011e\7\61\2\2\u011e\u0120\3\2\2\2\u011f\u0121\13\2\2"+
		"\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0126\t\5\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\b\66\2\2\u0128l\3\2\2\2\u0129\u012b\t\6\2\2"+
		"\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\b\67\2\2\u012fn\3\2\2\2\u0130"+
		"\u0133\5i\65\2\u0131\u0133\5g\64\2\u0132\u0130\3\2\2\2\u0132\u0131\3\2"+
		"\2\2\u0133\u0135\3\2\2\2\u0134\u0136\5q9\2\u0135\u0134\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u013a\5i\65\2\u0138\u013a\5g\64\2\u0139"+
		"\u0137\3\2\2\2\u0139\u0138\3\2\2\2\u013ap\3\2\2\2\u013b\u013d\5s:\2\u013c"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013fr\3\2\2\2\u0140\u0143\n\7\2\2\u0141\u0143\5u;\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0141\3\2\2\2\u0143t\3\2\2\2\u0144\u0145\7^\2\2\u0145\u0146"+
		"\t\b\2\2\u0146v\3\2\2\2\22\2\u009d\u00a3\u00a9\u00fe\u0101\u0107\u010d"+
		"\u0122\u0125\u012c\u0132\u0135\u0139\u013e\u0142\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}