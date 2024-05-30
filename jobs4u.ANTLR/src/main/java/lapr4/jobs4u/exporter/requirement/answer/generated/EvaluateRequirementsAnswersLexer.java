package lapr4.jobs4u.exporter.requirement.answer.generated;
// Generated from EvaluateRequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EvaluateRequirementsAnswersLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DECISION=11, TWO_DIGIT_NUMBER=12, NUMBER=13, LETTER=14, MEMBER=15, 
		TEXT=16, NEWLINE=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "DECISION", "TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", 
			"TEXT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'RESULT:'", "'#'", "'@'", "'REQUIREMENT RESULT:'", 
			"'MET'", "'NOT MET'", "'ANSWER:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "DECISION", 
			"TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "TEXT", "NEWLINE", 
			"WS"
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


	public EvaluateRequirementsAnswersLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EvaluateRequirementsAnswers.g4"; }

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
		"\u0004\u0000\u0012\u00a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n~\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u0082\b\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0003\u000e\u0089\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0004\u000f\u008e\b\u000f\u000b\u000f\f\u000f\u008f"+
		"\u0001\u0010\u0003\u0010\u0093\b\u0010\u0001\u0010\u0004\u0010\u0096\b"+
		"\u0010\u000b\u0010\f\u0010\u0097\u0001\u0011\u0004\u0011\u009b\b\u0011"+
		"\u000b\u0011\f\u0011\u009c\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012\u0001\u0000\u0004\u0001\u000009\u0002"+
		"\u0000AZaz\b\u0000!!##\'/:;??[[]]||\u0003\u0000\t\n\r\r  \u00a7\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000"+
		"\u0000\u0003,\u0001\u0000\u0000\u0000\u00052\u0001\u0000\u0000\u0000\u0007"+
		"9\u0001\u0000\u0000\u0000\tA\u0001\u0000\u0000\u0000\u000bC\u0001\u0000"+
		"\u0000\u0000\rE\u0001\u0000\u0000\u0000\u000fY\u0001\u0000\u0000\u0000"+
		"\u0011]\u0001\u0000\u0000\u0000\u0013e\u0001\u0000\u0000\u0000\u0015}"+
		"\u0001\u0000\u0000\u0000\u0017\u007f\u0001\u0000\u0000\u0000\u0019\u0083"+
		"\u0001\u0000\u0000\u0000\u001b\u0085\u0001\u0000\u0000\u0000\u001d\u0088"+
		"\u0001\u0000\u0000\u0000\u001f\u008d\u0001\u0000\u0000\u0000!\u0095\u0001"+
		"\u0000\u0000\u0000#\u009a\u0001\u0000\u0000\u0000%&\u0005T\u0000\u0000"+
		"&\'\u0005I\u0000\u0000\'(\u0005T\u0000\u0000()\u0005L\u0000\u0000)*\u0005"+
		"E\u0000\u0000*+\u0005:\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005"+
		"N\u0000\u0000-.\u0005A\u0000\u0000./\u0005M\u0000\u0000/0\u0005E\u0000"+
		"\u000001\u0005:\u0000\u00001\u0004\u0001\u0000\u0000\u000023\u0005E\u0000"+
		"\u000034\u0005M\u0000\u000045\u0005A\u0000\u000056\u0005I\u0000\u0000"+
		"67\u0005L\u0000\u000078\u0005:\u0000\u00008\u0006\u0001\u0000\u0000\u0000"+
		"9:\u0005R\u0000\u0000:;\u0005E\u0000\u0000;<\u0005S\u0000\u0000<=\u0005"+
		"U\u0000\u0000=>\u0005L\u0000\u0000>?\u0005T\u0000\u0000?@\u0005:\u0000"+
		"\u0000@\b\u0001\u0000\u0000\u0000AB\u0005#\u0000\u0000B\n\u0001\u0000"+
		"\u0000\u0000CD\u0005@\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005R"+
		"\u0000\u0000FG\u0005E\u0000\u0000GH\u0005Q\u0000\u0000HI\u0005U\u0000"+
		"\u0000IJ\u0005I\u0000\u0000JK\u0005R\u0000\u0000KL\u0005E\u0000\u0000"+
		"LM\u0005M\u0000\u0000MN\u0005E\u0000\u0000NO\u0005N\u0000\u0000OP\u0005"+
		"T\u0000\u0000PQ\u0005 \u0000\u0000QR\u0005R\u0000\u0000RS\u0005E\u0000"+
		"\u0000ST\u0005S\u0000\u0000TU\u0005U\u0000\u0000UV\u0005L\u0000\u0000"+
		"VW\u0005T\u0000\u0000WX\u0005:\u0000\u0000X\u000e\u0001\u0000\u0000\u0000"+
		"YZ\u0005M\u0000\u0000Z[\u0005E\u0000\u0000[\\\u0005T\u0000\u0000\\\u0010"+
		"\u0001\u0000\u0000\u0000]^\u0005N\u0000\u0000^_\u0005O\u0000\u0000_`\u0005"+
		"T\u0000\u0000`a\u0005 \u0000\u0000ab\u0005M\u0000\u0000bc\u0005E\u0000"+
		"\u0000cd\u0005T\u0000\u0000d\u0012\u0001\u0000\u0000\u0000ef\u0005A\u0000"+
		"\u0000fg\u0005N\u0000\u0000gh\u0005S\u0000\u0000hi\u0005W\u0000\u0000"+
		"ij\u0005E\u0000\u0000jk\u0005R\u0000\u0000kl\u0005:\u0000\u0000l\u0014"+
		"\u0001\u0000\u0000\u0000mn\u0005A\u0000\u0000no\u0005P\u0000\u0000op\u0005"+
		"P\u0000\u0000pq\u0005R\u0000\u0000qr\u0005O\u0000\u0000rs\u0005V\u0000"+
		"\u0000st\u0005E\u0000\u0000t~\u0005D\u0000\u0000uv\u0005R\u0000\u0000"+
		"vw\u0005E\u0000\u0000wx\u0005J\u0000\u0000xy\u0005E\u0000\u0000yz\u0005"+
		"C\u0000\u0000z{\u0005T\u0000\u0000{|\u0005E\u0000\u0000|~\u0005D\u0000"+
		"\u0000}m\u0001\u0000\u0000\u0000}u\u0001\u0000\u0000\u0000~\u0016\u0001"+
		"\u0000\u0000\u0000\u007f\u0081\u0003\u0019\f\u0000\u0080\u0082\u0003\u0019"+
		"\f\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0018\u0001\u0000\u0000\u0000\u0083\u0084\u0007\u0000\u0000"+
		"\u0000\u0084\u001a\u0001\u0000\u0000\u0000\u0085\u0086\u0007\u0001\u0000"+
		"\u0000\u0086\u001c\u0001\u0000\u0000\u0000\u0087\u0089\u0007\u0002\u0000"+
		"\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u001e\u0001\u0000\u0000"+
		"\u0000\u008a\u008e\u0003\u001b\r\u0000\u008b\u008e\u0003\u0017\u000b\u0000"+
		"\u008c\u008e\u0003\u001d\u000e\u0000\u008d\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090 \u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0005\r\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096"+
		"\u0005\n\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\"\u0001\u0000\u0000\u0000\u0099\u009b\u0007\u0003"+
		"\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000"+
		"\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0006\u0011"+
		"\u0000\u0000\u009f$\u0001\u0000\u0000\u0000\t\u0000}\u0081\u0088\u008d"+
		"\u008f\u0092\u0097\u009c\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}