// Generated from ExprGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud.exprengine;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ADD=10, SUB=11, MUL=12, DIV=13, REM=14, POW=15, DMUL=16, SOL=17, AND=18, 
		OR=19, NOT=20, TRUE=21, FALSE=22, GT=23, GE=24, LT=25, LE=26, EQ=27, NEQ=28, 
		BAND=29, BOR=30, BXOR=31, BNOT=32, SHL=33, SHR=34, USHR=35, INC=36, DESC=37, 
		ADD_ASSIGN=38, SUB_ASSIGN=39, MUL_ASSIGN=40, DIV_ASSIGN=41, REM_ASSIGN=42, 
		ASSIGN=43, LPAREN=44, RPAREN=45, LBRK=46, RBRK=47, LCB=48, RCB=49, INTEGER=50, 
		FLOAT=51, IDENTIFIER=52, COMMA=53, COLON=54, SEMI=55, PERIOD=56, SQUOTE=57, 
		DQUOTE=58, COMMENT=59, WS=60, StringLiteral=61;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ADD", "SUB", "MUL", "DIV", "REM", "POW", "DMUL", "SOL", "AND", "OR", 
		"NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", 
		"BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", 
		"MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", 
		"LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", 
		"COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral", 
		"Characters", "Character", "EscapeSeq"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'if'", "'else'", "'while'", "'for'", "'def'", "'return'", 
		"'sum'", "'in'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'.*'", "'\\'", 
		null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", "'<='", "'=='", 
		"'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", "'++'", "'--'", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", "')'", "'['", "']'", 
		"'{'", "'}'", null, null, null, "','", "':'", "';'", "'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ADD", "SUB", 
		"MUL", "DIV", "REM", "POW", "DMUL", "SOL", "AND", "OR", "NOT", "TRUE", 
		"FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", "BOR", "BXOR", "BNOT", 
		"SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
		"DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", "RPAREN", "LBRK", "RBRK", 
		"LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", "COMMA", "COLON", "SEMI", 
		"PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "WS", "StringLiteral"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2?\u0170\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00c1\n\23\3\24\3\24\3\24\3\24\5\24\u00c7\n\24\3\25\3\25"+
		"\3\25\3\25\5\25\u00cd\n\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3"+
		"*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\6\63\u0120\n\63\r\63\16\63\u0121\3\63\5\63\u0125\n\63\3\64\7\64\u0128"+
		"\n\64\f\64\16\64\u012b\13\64\3\64\3\64\6\64\u012f\n\64\r\64\16\64\u0130"+
		"\3\65\3\65\7\65\u0135\n\65\f\65\16\65\u0138\13\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3<\3<\6<\u014a\n<\r<\16<\u014b\3<\5<\u014f"+
		"\n<\3<\3<\3=\6=\u0154\n=\r=\16=\u0155\3=\3=\3>\3>\5>\u015c\n>\3>\5>\u015f"+
		"\n>\3>\3>\5>\u0163\n>\3?\6?\u0166\n?\r?\16?\u0167\3@\3@\5@\u016c\n@\3"+
		"A\3A\3A\3\u014b\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u<w=y>{?}\2\177\2\u0081\2\3\2\t\3\2\62;\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\13\16\17\"\"\5\2$$))^^\n\2$$))^^dd"+
		"hhppttvv\u017b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\3\u0083\3\2\2\2\5\u0085\3\2\2\2\7\u0088\3\2\2"+
		"\2\t\u008d\3\2\2\2\13\u0093\3\2\2\2\r\u0097\3\2\2\2\17\u009b\3\2\2\2\21"+
		"\u00a2\3\2\2\2\23\u00a6\3\2\2\2\25\u00a9\3\2\2\2\27\u00ab\3\2\2\2\31\u00ad"+
		"\3\2\2\2\33\u00af\3\2\2\2\35\u00b1\3\2\2\2\37\u00b3\3\2\2\2!\u00b6\3\2"+
		"\2\2#\u00b9\3\2\2\2%\u00c0\3\2\2\2\'\u00c6\3\2\2\2)\u00cc\3\2\2\2+\u00ce"+
		"\3\2\2\2-\u00d3\3\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2\63\u00de\3\2\2"+
		"\2\65\u00e0\3\2\2\2\67\u00e3\3\2\2\29\u00e6\3\2\2\2;\u00e9\3\2\2\2=\u00eb"+
		"\3\2\2\2?\u00ed\3\2\2\2A\u00ef\3\2\2\2C\u00f1\3\2\2\2E\u00f4\3\2\2\2G"+
		"\u00f7\3\2\2\2I\u00fb\3\2\2\2K\u00fe\3\2\2\2M\u0101\3\2\2\2O\u0104\3\2"+
		"\2\2Q\u0107\3\2\2\2S\u010a\3\2\2\2U\u010d\3\2\2\2W\u0110\3\2\2\2Y\u0112"+
		"\3\2\2\2[\u0114\3\2\2\2]\u0116\3\2\2\2_\u0118\3\2\2\2a\u011a\3\2\2\2c"+
		"\u011c\3\2\2\2e\u011f\3\2\2\2g\u0129\3\2\2\2i\u0132\3\2\2\2k\u0139\3\2"+
		"\2\2m\u013b\3\2\2\2o\u013d\3\2\2\2q\u013f\3\2\2\2s\u0141\3\2\2\2u\u0143"+
		"\3\2\2\2w\u0145\3\2\2\2y\u0153\3\2\2\2{\u015b\3\2\2\2}\u0165\3\2\2\2\177"+
		"\u016b\3\2\2\2\u0081\u016d\3\2\2\2\u0083\u0084\7\f\2\2\u0084\4\3\2\2\2"+
		"\u0085\u0086\7k\2\2\u0086\u0087\7h\2\2\u0087\6\3\2\2\2\u0088\u0089\7g"+
		"\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008c\7g\2\2\u008c\b"+
		"\3\2\2\2\u008d\u008e\7y\2\2\u008e\u008f\7j\2\2\u008f\u0090\7k\2\2\u0090"+
		"\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\n\3\2\2\2\u0093\u0094\7h\2\2\u0094"+
		"\u0095\7q\2\2\u0095\u0096\7t\2\2\u0096\f\3\2\2\2\u0097\u0098\7f\2\2\u0098"+
		"\u0099\7g\2\2\u0099\u009a\7h\2\2\u009a\16\3\2\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7v\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7t\2\2"+
		"\u00a0\u00a1\7p\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7"+
		"w\2\2\u00a4\u00a5\7o\2\2\u00a5\22\3\2\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8\24\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa\26\3\2\2\2\u00ab\u00ac"+
		"\7/\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\32\3\2\2\2\u00af\u00b0"+
		"\7\61\2\2\u00b0\34\3\2\2\2\u00b1\u00b2\7\'\2\2\u00b2\36\3\2\2\2\u00b3"+
		"\u00b4\7,\2\2\u00b4\u00b5\7,\2\2\u00b5 \3\2\2\2\u00b6\u00b7\7\60\2\2\u00b7"+
		"\u00b8\7,\2\2\u00b8\"\3\2\2\2\u00b9\u00ba\7^\2\2\u00ba$\3\2\2\2\u00bb"+
		"\u00bc\7c\2\2\u00bc\u00bd\7p\2\2\u00bd\u00c1\7f\2\2\u00be\u00bf\7(\2\2"+
		"\u00bf\u00c1\7(\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1&\3\2"+
		"\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c7\7t\2\2\u00c4\u00c5\7~\2\2\u00c5\u00c7"+
		"\7~\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7(\3\2\2\2\u00c8\u00c9"+
		"\7p\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cd\7v\2\2\u00cb\u00cd\7#\2\2\u00cc"+
		"\u00c8\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd*\3\2\2\2\u00ce\u00cf\7v\2\2\u00cf"+
		"\u00d0\7t\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\7g\2\2\u00d2,\3\2\2\2\u00d3"+
		"\u00d4\7h\2\2\u00d4\u00d5\7c\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7u\2\2"+
		"\u00d7\u00d8\7g\2\2\u00d8.\3\2\2\2\u00d9\u00da\7@\2\2\u00da\60\3\2\2\2"+
		"\u00db\u00dc\7@\2\2\u00dc\u00dd\7?\2\2\u00dd\62\3\2\2\2\u00de\u00df\7"+
		">\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e2\7?\2\2\u00e2\66"+
		"\3\2\2\2\u00e3\u00e4\7?\2\2\u00e4\u00e5\7?\2\2\u00e58\3\2\2\2\u00e6\u00e7"+
		"\7#\2\2\u00e7\u00e8\7?\2\2\u00e8:\3\2\2\2\u00e9\u00ea\7(\2\2\u00ea<\3"+
		"\2\2\2\u00eb\u00ec\7~\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7`\2\2\u00ee@\3\2"+
		"\2\2\u00ef\u00f0\7\u0080\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7>\2\2\u00f2\u00f3"+
		"\7>\2\2\u00f3D\3\2\2\2\u00f4\u00f5\7@\2\2\u00f5\u00f6\7@\2\2\u00f6F\3"+
		"\2\2\2\u00f7\u00f8\7@\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7@\2\2\u00fa"+
		"H\3\2\2\2\u00fb\u00fc\7-\2\2\u00fc\u00fd\7-\2\2\u00fdJ\3\2\2\2\u00fe\u00ff"+
		"\7/\2\2\u00ff\u0100\7/\2\2\u0100L\3\2\2\2\u0101\u0102\7-\2\2\u0102\u0103"+
		"\7?\2\2\u0103N\3\2\2\2\u0104\u0105\7/\2\2\u0105\u0106\7?\2\2\u0106P\3"+
		"\2\2\2\u0107\u0108\7,\2\2\u0108\u0109\7?\2\2\u0109R\3\2\2\2\u010a\u010b"+
		"\7\61\2\2\u010b\u010c\7?\2\2\u010cT\3\2\2\2\u010d\u010e\7\'\2\2\u010e"+
		"\u010f\7?\2\2\u010fV\3\2\2\2\u0110\u0111\7?\2\2\u0111X\3\2\2\2\u0112\u0113"+
		"\7*\2\2\u0113Z\3\2\2\2\u0114\u0115\7+\2\2\u0115\\\3\2\2\2\u0116\u0117"+
		"\7]\2\2\u0117^\3\2\2\2\u0118\u0119\7_\2\2\u0119`\3\2\2\2\u011a\u011b\7"+
		"}\2\2\u011bb\3\2\2\2\u011c\u011d\7\177\2\2\u011dd\3\2\2\2\u011e\u0120"+
		"\t\2\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0125\7N\2\2\u0124\u0123\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125f\3\2\2\2\u0126\u0128\t\2\2\2\u0127\u0126"+
		"\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\7\60\2\2\u012d\u012f\t"+
		"\2\2\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131h\3\2\2\2\u0132\u0136\t\3\2\2\u0133\u0135\t\4\2\2"+
		"\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137j\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\7.\2\2\u013al"+
		"\3\2\2\2\u013b\u013c\7<\2\2\u013cn\3\2\2\2\u013d\u013e\7=\2\2\u013ep\3"+
		"\2\2\2\u013f\u0140\7\60\2\2\u0140r\3\2\2\2\u0141\u0142\7)\2\2\u0142t\3"+
		"\2\2\2\u0143\u0144\7$\2\2\u0144v\3\2\2\2\u0145\u0146\7\61\2\2\u0146\u0147"+
		"\7\61\2\2\u0147\u0149\3\2\2\2\u0148\u014a\13\2\2\2\u0149\u0148\3\2\2\2"+
		"\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014e"+
		"\3\2\2\2\u014d\u014f\t\5\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\b<\2\2\u0151x\3\2\2\2\u0152\u0154\t\6\2\2\u0153\u0152\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\u0158\b=\2\2\u0158z\3\2\2\2\u0159\u015c\5u;\2\u015a\u015c\5"+
		"s:\2\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c\u015e\3\2\2\2\u015d"+
		"\u015f\5}?\2\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0162\3\2\2"+
		"\2\u0160\u0163\5u;\2\u0161\u0163\5s:\2\u0162\u0160\3\2\2\2\u0162\u0161"+
		"\3\2\2\2\u0163|\3\2\2\2\u0164\u0166\5\177@\2\u0165\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168~\3\2\2\2"+
		"\u0169\u016c\n\7\2\2\u016a\u016c\5\u0081A\2\u016b\u0169\3\2\2\2\u016b"+
		"\u016a\3\2\2\2\u016c\u0080\3\2\2\2\u016d\u016e\7^\2\2\u016e\u016f\t\b"+
		"\2\2\u016f\u0082\3\2\2\2\23\2\u00c0\u00c6\u00cc\u0121\u0124\u0129\u0130"+
		"\u0136\u014b\u014e\u0155\u015b\u015e\u0162\u0167\u016b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}