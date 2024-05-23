package lapr4.jobs4u.importer.json.generated.interview;
// Generated from InterviewJson.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InterviewJsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, NUMBER=17, 
		LETTER=18, MEMBER=19, TWO_DIGIT_NUMBER=20, FRACTIONAL_NUMBER=21, TEXT=22, 
		WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "NUMBER", 
			"LETTER", "MEMBER", "TWO_DIGIT_NUMBER", "FRACTIONAL_NUMBER", "TEXT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'\"'", "'{'", "'\"type\"'", "':'", "'\"cotation\"'", 
			"'\"cotationType\"'", "'\"body\"'", "'\"possibleAnswers\"'", "'}'", "'100'", 
			"'%'", "'POINTS'", "'VALUES'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "NUMBER", "LETTER", "MEMBER", "TWO_DIGIT_NUMBER", 
			"FRACTIONAL_NUMBER", "TEXT", "WS"
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


	public InterviewJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InterviewJson.g4"; }

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
		"\u0004\u0000\u0017\u00a8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0003\u0012\u0091\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0095\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u009e\b\u0015\u000b\u0015"+
		"\f\u0015\u009f\u0001\u0016\u0004\u0016\u00a3\b\u0016\u000b\u0016\f\u0016"+
		"\u00a4\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001\u0000\u0005\u0001\u0000"+
		"09\u0002\u0000AZaz\t\u0000!!##\')+/:;??[[]]||\u0002\u0000,,..\u0003\u0000"+
		"\t\n\r\r  \u00ac\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0001/\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u0005"+
		"3\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t7\u0001\u0000"+
		"\u0000\u0000\u000b9\u0001\u0000\u0000\u0000\r@\u0001\u0000\u0000\u0000"+
		"\u000fB\u0001\u0000\u0000\u0000\u0011M\u0001\u0000\u0000\u0000\u0013\\"+
		"\u0001\u0000\u0000\u0000\u0015c\u0001\u0000\u0000\u0000\u0017u\u0001\u0000"+
		"\u0000\u0000\u0019w\u0001\u0000\u0000\u0000\u001b{\u0001\u0000\u0000\u0000"+
		"\u001d}\u0001\u0000\u0000\u0000\u001f\u0084\u0001\u0000\u0000\u0000!\u008b"+
		"\u0001\u0000\u0000\u0000#\u008d\u0001\u0000\u0000\u0000%\u0090\u0001\u0000"+
		"\u0000\u0000\'\u0092\u0001\u0000\u0000\u0000)\u0096\u0001\u0000\u0000"+
		"\u0000+\u009d\u0001\u0000\u0000\u0000-\u00a2\u0001\u0000\u0000\u0000/"+
		"0\u0005[\u0000\u00000\u0002\u0001\u0000\u0000\u000012\u0005,\u0000\u0000"+
		"2\u0004\u0001\u0000\u0000\u000034\u0005]\u0000\u00004\u0006\u0001\u0000"+
		"\u0000\u000056\u0005\"\u0000\u00006\b\u0001\u0000\u0000\u000078\u0005"+
		"{\u0000\u00008\n\u0001\u0000\u0000\u00009:\u0005\"\u0000\u0000:;\u0005"+
		"t\u0000\u0000;<\u0005y\u0000\u0000<=\u0005p\u0000\u0000=>\u0005e\u0000"+
		"\u0000>?\u0005\"\u0000\u0000?\f\u0001\u0000\u0000\u0000@A\u0005:\u0000"+
		"\u0000A\u000e\u0001\u0000\u0000\u0000BC\u0005\"\u0000\u0000CD\u0005c\u0000"+
		"\u0000DE\u0005o\u0000\u0000EF\u0005t\u0000\u0000FG\u0005a\u0000\u0000"+
		"GH\u0005t\u0000\u0000HI\u0005i\u0000\u0000IJ\u0005o\u0000\u0000JK\u0005"+
		"n\u0000\u0000KL\u0005\"\u0000\u0000L\u0010\u0001\u0000\u0000\u0000MN\u0005"+
		"\"\u0000\u0000NO\u0005c\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005t\u0000"+
		"\u0000QR\u0005a\u0000\u0000RS\u0005t\u0000\u0000ST\u0005i\u0000\u0000"+
		"TU\u0005o\u0000\u0000UV\u0005n\u0000\u0000VW\u0005T\u0000\u0000WX\u0005"+
		"y\u0000\u0000XY\u0005p\u0000\u0000YZ\u0005e\u0000\u0000Z[\u0005\"\u0000"+
		"\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005\"\u0000\u0000]^\u0005b"+
		"\u0000\u0000^_\u0005o\u0000\u0000_`\u0005d\u0000\u0000`a\u0005y\u0000"+
		"\u0000ab\u0005\"\u0000\u0000b\u0014\u0001\u0000\u0000\u0000cd\u0005\""+
		"\u0000\u0000de\u0005p\u0000\u0000ef\u0005o\u0000\u0000fg\u0005s\u0000"+
		"\u0000gh\u0005s\u0000\u0000hi\u0005i\u0000\u0000ij\u0005b\u0000\u0000"+
		"jk\u0005l\u0000\u0000kl\u0005e\u0000\u0000lm\u0005A\u0000\u0000mn\u0005"+
		"n\u0000\u0000no\u0005s\u0000\u0000op\u0005w\u0000\u0000pq\u0005e\u0000"+
		"\u0000qr\u0005r\u0000\u0000rs\u0005s\u0000\u0000st\u0005\"\u0000\u0000"+
		"t\u0016\u0001\u0000\u0000\u0000uv\u0005}\u0000\u0000v\u0018\u0001\u0000"+
		"\u0000\u0000wx\u00051\u0000\u0000xy\u00050\u0000\u0000yz\u00050\u0000"+
		"\u0000z\u001a\u0001\u0000\u0000\u0000{|\u0005%\u0000\u0000|\u001c\u0001"+
		"\u0000\u0000\u0000}~\u0005P\u0000\u0000~\u007f\u0005O\u0000\u0000\u007f"+
		"\u0080\u0005I\u0000\u0000\u0080\u0081\u0005N\u0000\u0000\u0081\u0082\u0005"+
		"T\u0000\u0000\u0082\u0083\u0005S\u0000\u0000\u0083\u001e\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005V\u0000\u0000\u0085\u0086\u0005A\u0000\u0000\u0086"+
		"\u0087\u0005L\u0000\u0000\u0087\u0088\u0005U\u0000\u0000\u0088\u0089\u0005"+
		"E\u0000\u0000\u0089\u008a\u0005S\u0000\u0000\u008a \u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0007\u0000\u0000\u0000\u008c\"\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0007\u0001\u0000\u0000\u008e$\u0001\u0000\u0000\u0000\u008f"+
		"\u0091\u0007\u0002\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091"+
		"&\u0001\u0000\u0000\u0000\u0092\u0094\u0003!\u0010\u0000\u0093\u0095\u0003"+
		"!\u0010\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095(\u0001\u0000\u0000\u0000\u0096\u0097\u0003\'\u0013"+
		"\u0000\u0097\u0098\u0007\u0003\u0000\u0000\u0098\u0099\u0003\'\u0013\u0000"+
		"\u0099*\u0001\u0000\u0000\u0000\u009a\u009e\u0003#\u0011\u0000\u009b\u009e"+
		"\u0003!\u0010\u0000\u009c\u009e\u0003%\u0012\u0000\u009d\u009a\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0,\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a3\u0007\u0004\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0006\u0016\u0000\u0000\u00a7.\u0001\u0000\u0000\u0000"+
		"\u0006\u0000\u0090\u0094\u009d\u009f\u00a4\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}