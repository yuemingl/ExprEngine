// Generated from MatlabGrammar.g4 by ANTLR 4.5.3

package io.lambdacloud.matlab;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatlabGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		REM=11, POW=12, SOL=13, DADD=14, DSUB=15, DMUL=16, DRDIV=17, DLDIV=18, 
		AND=19, OR=20, NOT=21, TRUE=22, FALSE=23, GT=24, GE=25, LT=26, LE=27, 
		EQ=28, NEQ=29, BAND=30, BOR=31, BXOR=32, BNOT=33, SHL=34, SHR=35, USHR=36, 
		INC=37, DESC=38, ADD_ASSIGN=39, SUB_ASSIGN=40, MUL_ASSIGN=41, DIV_ASSIGN=42, 
		REM_ASSIGN=43, ASSIGN=44, LPAREN=45, RPAREN=46, LBRK=47, RBRK=48, LCB=49, 
		RCB=50, INTEGER=51, FLOAT=52, IDENTIFIER=53, COMMA=54, COLON=55, SEMI=56, 
		PERIOD=57, SQUOTE=58, DQUOTE=59, COMMENT=60, SKIP_TOKEN=61, WS=62;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "ADD", "SUB", "MUL", "DIV", 
		"REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "AND", 
		"OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", 
		"BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "'function'", "'end'", "'if'", "'elseif'", "'else'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'**'", "'\\'", "'.+'", "'.-'", "'.*'", "'./'", 
		"'.\\'", null, null, null, "'true'", "'false'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'>>>'", 
		"'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'='", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", null, null, null, "','", "':'", "';'", 
		"'.'", "'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ADD", "SUB", "MUL", "DIV", 
		"REM", "POW", "SOL", "DADD", "DSUB", "DMUL", "DRDIV", "DLDIV", "AND", 
		"OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NEQ", "BAND", 
		"BOR", "BXOR", "BNOT", "SHL", "SHR", "USHR", "INC", "DESC", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "REM_ASSIGN", "ASSIGN", "LPAREN", 
		"RPAREN", "LBRK", "RBRK", "LCB", "RCB", "INTEGER", "FLOAT", "IDENTIFIER", 
		"COMMA", "COLON", "SEMI", "PERIOD", "SQUOTE", "DQUOTE", "COMMENT", "SKIP_TOKEN", 
		"WS"
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


	public MatlabGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MatlabGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2@\u0159\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00c1\n\24\3\25\3\25\3\25\3\25\5\25\u00c7\n\25\3"+
		"\26\3\26\3\26\3\26\5\26\u00cd\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#"+
		"\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*"+
		"\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\64\6\64\u0120\n\64\r\64\16\64\u0121\3\65\7\65\u0125\n\65\f\65"+
		"\16\65\u0128\13\65\3\65\3\65\7\65\u012c\n\65\f\65\16\65\u012f\13\65\3"+
		"\66\3\66\7\66\u0133\n\66\f\66\16\66\u0136\13\66\3\67\3\67\38\38\39\39"+
		"\3:\3:\3;\3;\3<\3<\3=\3=\3=\3=\6=\u0148\n=\r=\16=\u0149\3=\5=\u014d\n"+
		"=\3=\3=\3>\6>\u0152\n>\r>\16>\u0153\3>\3>\3?\3?\3\u0149\2@\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"?}@\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\3\2\16\17\4\2\13\13"+
		"\"\"\u0161\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0081\3\2\2\2\7\u008a\3"+
		"\2\2\2\t\u008e\3\2\2\2\13\u0091\3\2\2\2\r\u0098\3\2\2\2\17\u009d\3\2\2"+
		"\2\21\u009f\3\2\2\2\23\u00a1\3\2\2\2\25\u00a3\3\2\2\2\27\u00a5\3\2\2\2"+
		"\31\u00a7\3\2\2\2\33\u00aa\3\2\2\2\35\u00ac\3\2\2\2\37\u00af\3\2\2\2!"+
		"\u00b2\3\2\2\2#\u00b5\3\2\2\2%\u00b8\3\2\2\2\'\u00c0\3\2\2\2)\u00c6\3"+
		"\2\2\2+\u00cc\3\2\2\2-\u00ce\3\2\2\2/\u00d3\3\2\2\2\61\u00d9\3\2\2\2\63"+
		"\u00db\3\2\2\2\65\u00de\3\2\2\2\67\u00e0\3\2\2\29\u00e3\3\2\2\2;\u00e6"+
		"\3\2\2\2=\u00e9\3\2\2\2?\u00eb\3\2\2\2A\u00ed\3\2\2\2C\u00ef\3\2\2\2E"+
		"\u00f1\3\2\2\2G\u00f4\3\2\2\2I\u00f7\3\2\2\2K\u00fb\3\2\2\2M\u00fe\3\2"+
		"\2\2O\u0101\3\2\2\2Q\u0104\3\2\2\2S\u0107\3\2\2\2U\u010a\3\2\2\2W\u010d"+
		"\3\2\2\2Y\u0110\3\2\2\2[\u0112\3\2\2\2]\u0114\3\2\2\2_\u0116\3\2\2\2a"+
		"\u0118\3\2\2\2c\u011a\3\2\2\2e\u011c\3\2\2\2g\u011f\3\2\2\2i\u0126\3\2"+
		"\2\2k\u0130\3\2\2\2m\u0137\3\2\2\2o\u0139\3\2\2\2q\u013b\3\2\2\2s\u013d"+
		"\3\2\2\2u\u013f\3\2\2\2w\u0141\3\2\2\2y\u0143\3\2\2\2{\u0151\3\2\2\2}"+
		"\u0157\3\2\2\2\177\u0080\7\f\2\2\u0080\4\3\2\2\2\u0081\u0082\7h\2\2\u0082"+
		"\u0083\7w\2\2\u0083\u0084\7p\2\2\u0084\u0085\7e\2\2\u0085\u0086\7v\2\2"+
		"\u0086\u0087\7k\2\2\u0087\u0088\7q\2\2\u0088\u0089\7p\2\2\u0089\6\3\2"+
		"\2\2\u008a\u008b\7g\2\2\u008b\u008c\7p\2\2\u008c\u008d\7f\2\2\u008d\b"+
		"\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0090\7h\2\2\u0090\n\3\2\2\2\u0091\u0092"+
		"\7g\2\2\u0092\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7h\2\2\u0097\f\3\2\2\2\u0098\u0099\7g\2\2\u0099"+
		"\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\16\3\2\2\2\u009d"+
		"\u009e\7-\2\2\u009e\20\3\2\2\2\u009f\u00a0\7/\2\2\u00a0\22\3\2\2\2\u00a1"+
		"\u00a2\7,\2\2\u00a2\24\3\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\26\3\2\2\2\u00a5"+
		"\u00a6\7\'\2\2\u00a6\30\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7,\2\2"+
		"\u00a9\32\3\2\2\2\u00aa\u00ab\7^\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7\60"+
		"\2\2\u00ad\u00ae\7-\2\2\u00ae\36\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0\u00b1"+
		"\7/\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7\60\2\2\u00b3\u00b4\7,\2\2\u00b4\""+
		"\3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6\u00b7\7\61\2\2\u00b7$\3\2\2\2\u00b8"+
		"\u00b9\7\60\2\2\u00b9\u00ba\7^\2\2\u00ba&\3\2\2\2\u00bb\u00bc\7c\2\2\u00bc"+
		"\u00bd\7p\2\2\u00bd\u00c1\7f\2\2\u00be\u00bf\7(\2\2\u00bf\u00c1\7(\2\2"+
		"\u00c0\u00bb\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1(\3\2\2\2\u00c2\u00c3\7"+
		"q\2\2\u00c3\u00c7\7t\2\2\u00c4\u00c5\7~\2\2\u00c5\u00c7\7~\2\2\u00c6\u00c2"+
		"\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7*\3\2\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca"+
		"\7q\2\2\u00ca\u00cd\7v\2\2\u00cb\u00cd\7#\2\2\u00cc\u00c8\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd,\3\2\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7t\2\2\u00d0"+
		"\u00d1\7w\2\2\u00d1\u00d2\7g\2\2\u00d2.\3\2\2\2\u00d3\u00d4\7h\2\2\u00d4"+
		"\u00d5\7c\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7g\2\2"+
		"\u00d8\60\3\2\2\2\u00d9\u00da\7@\2\2\u00da\62\3\2\2\2\u00db\u00dc\7@\2"+
		"\2\u00dc\u00dd\7?\2\2\u00dd\64\3\2\2\2\u00de\u00df\7>\2\2\u00df\66\3\2"+
		"\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e2\7?\2\2\u00e28\3\2\2\2\u00e3\u00e4"+
		"\7?\2\2\u00e4\u00e5\7?\2\2\u00e5:\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7\u00e8"+
		"\7?\2\2\u00e8<\3\2\2\2\u00e9\u00ea\7(\2\2\u00ea>\3\2\2\2\u00eb\u00ec\7"+
		"~\2\2\u00ec@\3\2\2\2\u00ed\u00ee\7`\2\2\u00eeB\3\2\2\2\u00ef\u00f0\7\u0080"+
		"\2\2\u00f0D\3\2\2\2\u00f1\u00f2\7>\2\2\u00f2\u00f3\7>\2\2\u00f3F\3\2\2"+
		"\2\u00f4\u00f5\7@\2\2\u00f5\u00f6\7@\2\2\u00f6H\3\2\2\2\u00f7\u00f8\7"+
		"@\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7@\2\2\u00faJ\3\2\2\2\u00fb\u00fc"+
		"\7-\2\2\u00fc\u00fd\7-\2\2\u00fdL\3\2\2\2\u00fe\u00ff\7/\2\2\u00ff\u0100"+
		"\7/\2\2\u0100N\3\2\2\2\u0101\u0102\7-\2\2\u0102\u0103\7?\2\2\u0103P\3"+
		"\2\2\2\u0104\u0105\7/\2\2\u0105\u0106\7?\2\2\u0106R\3\2\2\2\u0107\u0108"+
		"\7,\2\2\u0108\u0109\7?\2\2\u0109T\3\2\2\2\u010a\u010b\7\61\2\2\u010b\u010c"+
		"\7?\2\2\u010cV\3\2\2\2\u010d\u010e\7\'\2\2\u010e\u010f\7?\2\2\u010fX\3"+
		"\2\2\2\u0110\u0111\7?\2\2\u0111Z\3\2\2\2\u0112\u0113\7*\2\2\u0113\\\3"+
		"\2\2\2\u0114\u0115\7+\2\2\u0115^\3\2\2\2\u0116\u0117\7]\2\2\u0117`\3\2"+
		"\2\2\u0118\u0119\7_\2\2\u0119b\3\2\2\2\u011a\u011b\7}\2\2\u011bd\3\2\2"+
		"\2\u011c\u011d\7\177\2\2\u011df\3\2\2\2\u011e\u0120\t\2\2\2\u011f\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"h\3\2\2\2\u0123\u0125\t\2\2\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2"+
		"\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126"+
		"\3\2\2\2\u0129\u012d\7\60\2\2\u012a\u012c\t\2\2\2\u012b\u012a\3\2\2\2"+
		"\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012ej\3"+
		"\2\2\2\u012f\u012d\3\2\2\2\u0130\u0134\t\3\2\2\u0131\u0133\t\4\2\2\u0132"+
		"\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135l\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7.\2\2\u0138n\3\2"+
		"\2\2\u0139\u013a\7<\2\2\u013ap\3\2\2\2\u013b\u013c\7=\2\2\u013cr\3\2\2"+
		"\2\u013d\u013e\7\60\2\2\u013et\3\2\2\2\u013f\u0140\7)\2\2\u0140v\3\2\2"+
		"\2\u0141\u0142\7$\2\2\u0142x\3\2\2\2\u0143\u0144\7\61\2\2\u0144\u0145"+
		"\7\61\2\2\u0145\u0147\3\2\2\2\u0146\u0148\13\2\2\2\u0147\u0146\3\2\2\2"+
		"\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c"+
		"\3\2\2\2\u014b\u014d\t\5\2\2\u014c\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\b=\2\2\u014fz\3\2\2\2\u0150\u0152\t\6\2\2\u0151\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0156\b>\2\2\u0156|\3\2\2\2\u0157\u0158\t\7\2\2\u0158~\3\2"+
		"\2\2\r\2\u00c0\u00c6\u00cc\u0121\u0126\u012d\u0134\u0149\u014c\u0153\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}