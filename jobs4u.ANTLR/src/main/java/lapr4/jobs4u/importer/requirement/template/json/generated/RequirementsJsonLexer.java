package lapr4.jobs4u.importer.requirement.template.json.generated;
// Generated from RequirementsJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RequirementsJsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TWO_DIGIT_NUMBER=11, NUMBER=12, LETTER=13, MEMBER=14, TEXT=15, 
		WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "TEXT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'\"'", "'{'", "'\"body\"'", "':'", "'\"possibleAnswers\"'", 
			"'\"minimumRequirement\"'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TWO_DIGIT_NUMBER", 
			"NUMBER", "LETTER", "MEMBER", "TEXT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public RequirementsJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RequirementsJson.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010v\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0003\n`\b\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0003\rg\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e"+
		"l\b\u000e\u000b\u000e\f\u000em\u0001\u000f\u0004\u000fq\b\u000f\u000b"+
		"\u000f\f\u000fr\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010\u0001\u0000\u0004\u0001\u000009\u0002\u0000AZaz\u0006\u0000"+
		"!!##\'/:;?@||\u0003\u0000\t\n\r\r  z\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003#\u0001\u0000"+
		"\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007\'\u0001\u0000\u0000"+
		"\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000\u0000\r2\u0001"+
		"\u0000\u0000\u0000\u000f4\u0001\u0000\u0000\u0000\u0011F\u0001\u0000\u0000"+
		"\u0000\u0013[\u0001\u0000\u0000\u0000\u0015]\u0001\u0000\u0000\u0000\u0017"+
		"a\u0001\u0000\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001bf\u0001"+
		"\u0000\u0000\u0000\u001dk\u0001\u0000\u0000\u0000\u001fp\u0001\u0000\u0000"+
		"\u0000!\"\u0005[\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005,"+
		"\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005]\u0000\u0000&\u0006"+
		"\u0001\u0000\u0000\u0000\'(\u0005\"\u0000\u0000(\b\u0001\u0000\u0000\u0000"+
		")*\u0005{\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005\"\u0000\u0000"+
		",-\u0005b\u0000\u0000-.\u0005o\u0000\u0000./\u0005d\u0000\u0000/0\u0005"+
		"y\u0000\u000001\u0005\"\u0000\u00001\f\u0001\u0000\u0000\u000023\u0005"+
		":\u0000\u00003\u000e\u0001\u0000\u0000\u000045\u0005\"\u0000\u000056\u0005"+
		"p\u0000\u000067\u0005o\u0000\u000078\u0005s\u0000\u000089\u0005s\u0000"+
		"\u00009:\u0005i\u0000\u0000:;\u0005b\u0000\u0000;<\u0005l\u0000\u0000"+
		"<=\u0005e\u0000\u0000=>\u0005A\u0000\u0000>?\u0005n\u0000\u0000?@\u0005"+
		"s\u0000\u0000@A\u0005w\u0000\u0000AB\u0005e\u0000\u0000BC\u0005r\u0000"+
		"\u0000CD\u0005s\u0000\u0000DE\u0005\"\u0000\u0000E\u0010\u0001\u0000\u0000"+
		"\u0000FG\u0005\"\u0000\u0000GH\u0005m\u0000\u0000HI\u0005i\u0000\u0000"+
		"IJ\u0005n\u0000\u0000JK\u0005i\u0000\u0000KL\u0005m\u0000\u0000LM\u0005"+
		"u\u0000\u0000MN\u0005m\u0000\u0000NO\u0005R\u0000\u0000OP\u0005e\u0000"+
		"\u0000PQ\u0005q\u0000\u0000QR\u0005u\u0000\u0000RS\u0005i\u0000\u0000"+
		"ST\u0005r\u0000\u0000TU\u0005e\u0000\u0000UV\u0005m\u0000\u0000VW\u0005"+
		"e\u0000\u0000WX\u0005n\u0000\u0000XY\u0005t\u0000\u0000YZ\u0005\"\u0000"+
		"\u0000Z\u0012\u0001\u0000\u0000\u0000[\\\u0005}\u0000\u0000\\\u0014\u0001"+
		"\u0000\u0000\u0000]_\u0003\u0017\u000b\u0000^`\u0003\u0017\u000b\u0000"+
		"_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0016\u0001\u0000"+
		"\u0000\u0000ab\u0007\u0000\u0000\u0000b\u0018\u0001\u0000\u0000\u0000"+
		"cd\u0007\u0001\u0000\u0000d\u001a\u0001\u0000\u0000\u0000eg\u0007\u0002"+
		"\u0000\u0000fe\u0001\u0000\u0000\u0000g\u001c\u0001\u0000\u0000\u0000"+
		"hl\u0003\u0019\f\u0000il\u0003\u0015\n\u0000jl\u0003\u001b\r\u0000kh\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000n\u001e\u0001\u0000\u0000\u0000oq\u0007\u0003\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0006\u000f\u0000"+
		"\u0000u \u0001\u0000\u0000\u0000\u0006\u0000_fkmr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}