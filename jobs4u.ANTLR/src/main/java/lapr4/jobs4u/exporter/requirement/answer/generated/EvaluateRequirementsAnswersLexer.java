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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, TWO_DIGIT_NUMBER=9, 
		NUMBER=10, LETTER=11, MEMBER=12, TEXT=13, NEWLINE=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "TWO_DIGIT_NUMBER", 
			"NUMBER", "LETTER", "MEMBER", "TEXT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'RESULT:'", "'#'", "'@'", "'ANSWER:'", 
			"'JUSTIFICATION:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "TWO_DIGIT_NUMBER", 
			"NUMBER", "LETTER", "MEMBER", "TEXT", "NEWLINE", "WS"
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
		"\u0004\u0000\u000fw\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0003\bY\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0003\u000b`\b\u000b\u0001\f\u0001\f\u0001\f\u0004\fe\b\f\u000b"+
		"\f\f\ff\u0001\r\u0003\rj\b\r\u0001\r\u0004\rm\b\r\u000b\r\f\rn\u0001\u000e"+
		"\u0004\u000er\b\u000e\u000b\u000e\f\u000es\u0001\u000e\u0001\u000e\u0000"+
		"\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u0001\u0000\u0004\u0001\u000009\u0002\u0000AZaz\b\u0000"+
		"!!##\'/:;??[[]]||\u0003\u0000\t\n\r\r  }\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001"+
		"\u001f\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005,\u0001"+
		"\u0000\u0000\u0000\u00073\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000"+
		"\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001\u0000\u0000\u0000\u000f"+
		"G\u0001\u0000\u0000\u0000\u0011V\u0001\u0000\u0000\u0000\u0013Z\u0001"+
		"\u0000\u0000\u0000\u0015\\\u0001\u0000\u0000\u0000\u0017_\u0001\u0000"+
		"\u0000\u0000\u0019d\u0001\u0000\u0000\u0000\u001bl\u0001\u0000\u0000\u0000"+
		"\u001dq\u0001\u0000\u0000\u0000\u001f \u0005T\u0000\u0000 !\u0005I\u0000"+
		"\u0000!\"\u0005T\u0000\u0000\"#\u0005L\u0000\u0000#$\u0005E\u0000\u0000"+
		"$%\u0005:\u0000\u0000%\u0002\u0001\u0000\u0000\u0000&\'\u0005N\u0000\u0000"+
		"\'(\u0005A\u0000\u0000()\u0005M\u0000\u0000)*\u0005E\u0000\u0000*+\u0005"+
		":\u0000\u0000+\u0004\u0001\u0000\u0000\u0000,-\u0005E\u0000\u0000-.\u0005"+
		"M\u0000\u0000./\u0005A\u0000\u0000/0\u0005I\u0000\u000001\u0005L\u0000"+
		"\u000012\u0005:\u0000\u00002\u0006\u0001\u0000\u0000\u000034\u0005R\u0000"+
		"\u000045\u0005E\u0000\u000056\u0005S\u0000\u000067\u0005U\u0000\u0000"+
		"78\u0005L\u0000\u000089\u0005T\u0000\u00009:\u0005:\u0000\u0000:\b\u0001"+
		"\u0000\u0000\u0000;<\u0005#\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005"+
		"@\u0000\u0000>\f\u0001\u0000\u0000\u0000?@\u0005A\u0000\u0000@A\u0005"+
		"N\u0000\u0000AB\u0005S\u0000\u0000BC\u0005W\u0000\u0000CD\u0005E\u0000"+
		"\u0000DE\u0005R\u0000\u0000EF\u0005:\u0000\u0000F\u000e\u0001\u0000\u0000"+
		"\u0000GH\u0005J\u0000\u0000HI\u0005U\u0000\u0000IJ\u0005S\u0000\u0000"+
		"JK\u0005T\u0000\u0000KL\u0005I\u0000\u0000LM\u0005F\u0000\u0000MN\u0005"+
		"I\u0000\u0000NO\u0005C\u0000\u0000OP\u0005A\u0000\u0000PQ\u0005T\u0000"+
		"\u0000QR\u0005I\u0000\u0000RS\u0005O\u0000\u0000ST\u0005N\u0000\u0000"+
		"TU\u0005:\u0000\u0000U\u0010\u0001\u0000\u0000\u0000VX\u0003\u0013\t\u0000"+
		"WY\u0003\u0013\t\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"Y\u0012\u0001\u0000\u0000\u0000Z[\u0007\u0000\u0000\u0000[\u0014\u0001"+
		"\u0000\u0000\u0000\\]\u0007\u0001\u0000\u0000]\u0016\u0001\u0000\u0000"+
		"\u0000^`\u0007\u0002\u0000\u0000_^\u0001\u0000\u0000\u0000`\u0018\u0001"+
		"\u0000\u0000\u0000ae\u0003\u0015\n\u0000be\u0003\u0011\b\u0000ce\u0003"+
		"\u0017\u000b\u0000da\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000g\u001a\u0001\u0000\u0000\u0000hj\u0005"+
		"\r\u0000\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000km\u0005\n\u0000\u0000li\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"o\u001c\u0001\u0000\u0000\u0000pr\u0007\u0003\u0000\u0000qp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0006\u000e\u0000\u0000"+
		"v\u001e\u0001\u0000\u0000\u0000\b\u0000X_dfins\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}