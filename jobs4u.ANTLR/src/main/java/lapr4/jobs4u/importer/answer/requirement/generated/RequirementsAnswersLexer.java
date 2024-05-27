package lapr4.jobs4u.importer.answer.requirement.generated;
// Generated from RequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RequirementsAnswersLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, LETTER=8, MEMBER=9, 
		TEXT=10, NEWLINE=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUMBER", "LETTER", "MEMBER", 
			"TEXT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'#'", "'@'", "'ANSWER:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NUMBER", "LETTER", "MEMBER", 
			"TEXT", "NEWLINE", "WS"
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


	public RequirementsAnswersLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RequirementsAnswers.g4"; }

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
		"\u0004\u0000\fV\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0003\b?\b\b\u0001\t\u0001\t\u0001\t\u0004\tD\b\t"+
		"\u000b\t\f\tE\u0001\n\u0003\nI\b\n\u0001\n\u0004\nL\b\n\u000b\n\f\nM\u0001"+
		"\u000b\u0004\u000bQ\b\u000b\u000b\u000b\f\u000bR\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001"+
		"\u0000\u0004\u0001\u000009\u0002\u0000AZaz\b\u0000!!##\'/:;??[[]]||\u0003"+
		"\u0000\t\n\r\r  [\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003 \u0001\u0000\u0000\u0000"+
		"\u0005&\u0001\u0000\u0000\u0000\u0007-\u0001\u0000\u0000\u0000\t/\u0001"+
		"\u0000\u0000\u0000\u000b1\u0001\u0000\u0000\u0000\r9\u0001\u0000\u0000"+
		"\u0000\u000f;\u0001\u0000\u0000\u0000\u0011>\u0001\u0000\u0000\u0000\u0013"+
		"C\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017P\u0001"+
		"\u0000\u0000\u0000\u0019\u001a\u0005T\u0000\u0000\u001a\u001b\u0005I\u0000"+
		"\u0000\u001b\u001c\u0005T\u0000\u0000\u001c\u001d\u0005L\u0000\u0000\u001d"+
		"\u001e\u0005E\u0000\u0000\u001e\u001f\u0005:\u0000\u0000\u001f\u0002\u0001"+
		"\u0000\u0000\u0000 !\u0005N\u0000\u0000!\"\u0005A\u0000\u0000\"#\u0005"+
		"M\u0000\u0000#$\u0005E\u0000\u0000$%\u0005:\u0000\u0000%\u0004\u0001\u0000"+
		"\u0000\u0000&\'\u0005E\u0000\u0000\'(\u0005M\u0000\u0000()\u0005A\u0000"+
		"\u0000)*\u0005I\u0000\u0000*+\u0005L\u0000\u0000+,\u0005:\u0000\u0000"+
		",\u0006\u0001\u0000\u0000\u0000-.\u0005#\u0000\u0000.\b\u0001\u0000\u0000"+
		"\u0000/0\u0005@\u0000\u00000\n\u0001\u0000\u0000\u000012\u0005A\u0000"+
		"\u000023\u0005N\u0000\u000034\u0005S\u0000\u000045\u0005W\u0000\u0000"+
		"56\u0005E\u0000\u000067\u0005R\u0000\u000078\u0005:\u0000\u00008\f\u0001"+
		"\u0000\u0000\u00009:\u0007\u0000\u0000\u0000:\u000e\u0001\u0000\u0000"+
		"\u0000;<\u0007\u0001\u0000\u0000<\u0010\u0001\u0000\u0000\u0000=?\u0007"+
		"\u0002\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0012\u0001\u0000\u0000"+
		"\u0000@D\u0003\u000f\u0007\u0000AD\u0003\r\u0006\u0000BD\u0003\u0011\b"+
		"\u0000C@\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000F\u0014\u0001\u0000\u0000\u0000GI\u0005\r\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JL\u0005\n\u0000\u0000KH\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0016\u0001"+
		"\u0000\u0000\u0000OQ\u0007\u0003\u0000\u0000PO\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TU\u0006\u000b\u0000\u0000U\u0018\u0001"+
		"\u0000\u0000\u0000\u0007\u0000>CEHMR\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}