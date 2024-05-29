package lapr4.jobs4u.exporter.requirement.template.generated;
// Generated from Requirements.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RequirementsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, TWO_DIGIT_NUMBER=6, NUMBER=7, 
		LETTER=8, MEMBER=9, TEXT=10, NEWLINE=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "TWO_DIGIT_NUMBER", "NUMBER", 
			"LETTER", "MEMBER", "TEXT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'#'", "'ANSWER:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "TWO_DIGIT_NUMBER", "NUMBER", "LETTER", 
			"MEMBER", "TEXT", "NEWLINE", "WS"
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


	public RequirementsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Requirements.g4"; }

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
		"\u0004\u0000\fX\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005:\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0003\bA\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0004\tF\b\t\u000b\t\f\tG\u0001\n\u0003\nK\b\n\u0001\n\u0004"+
		"\nN\b\n\u000b\n\f\nO\u0001\u000b\u0004\u000bS\b\u000b\u000b\u000b\f\u000b"+
		"T\u0001\u000b\u0001\u000b\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0001\u0000\u0004\u0001\u000009\u0002\u0000AZaz\u0007"+
		"\u0000!!\'/:;??[[]]||\u0003\u0000\t\n\r\r  ^\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003"+
		" \u0001\u0000\u0000\u0000\u0005&\u0001\u0000\u0000\u0000\u0007-\u0001"+
		"\u0000\u0000\u0000\t/\u0001\u0000\u0000\u0000\u000b7\u0001\u0000\u0000"+
		"\u0000\r;\u0001\u0000\u0000\u0000\u000f=\u0001\u0000\u0000\u0000\u0011"+
		"@\u0001\u0000\u0000\u0000\u0013E\u0001\u0000\u0000\u0000\u0015M\u0001"+
		"\u0000\u0000\u0000\u0017R\u0001\u0000\u0000\u0000\u0019\u001a\u0005T\u0000"+
		"\u0000\u001a\u001b\u0005I\u0000\u0000\u001b\u001c\u0005T\u0000\u0000\u001c"+
		"\u001d\u0005L\u0000\u0000\u001d\u001e\u0005E\u0000\u0000\u001e\u001f\u0005"+
		":\u0000\u0000\u001f\u0002\u0001\u0000\u0000\u0000 !\u0005N\u0000\u0000"+
		"!\"\u0005A\u0000\u0000\"#\u0005M\u0000\u0000#$\u0005E\u0000\u0000$%\u0005"+
		":\u0000\u0000%\u0004\u0001\u0000\u0000\u0000&\'\u0005E\u0000\u0000\'("+
		"\u0005M\u0000\u0000()\u0005A\u0000\u0000)*\u0005I\u0000\u0000*+\u0005"+
		"L\u0000\u0000+,\u0005:\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005"+
		"#\u0000\u0000.\b\u0001\u0000\u0000\u0000/0\u0005A\u0000\u000001\u0005"+
		"N\u0000\u000012\u0005S\u0000\u000023\u0005W\u0000\u000034\u0005E\u0000"+
		"\u000045\u0005R\u0000\u000056\u0005:\u0000\u00006\n\u0001\u0000\u0000"+
		"\u000079\u0003\r\u0006\u00008:\u0003\r\u0006\u000098\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:\f\u0001\u0000\u0000\u0000;<\u0007\u0000"+
		"\u0000\u0000<\u000e\u0001\u0000\u0000\u0000=>\u0007\u0001\u0000\u0000"+
		">\u0010\u0001\u0000\u0000\u0000?A\u0007\u0002\u0000\u0000@?\u0001\u0000"+
		"\u0000\u0000A\u0012\u0001\u0000\u0000\u0000BF\u0003\u000f\u0007\u0000"+
		"CF\u0003\u000b\u0005\u0000DF\u0003\u0011\b\u0000EB\u0001\u0000\u0000\u0000"+
		"EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0014\u0001"+
		"\u0000\u0000\u0000IK\u0005\r\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0005\n\u0000\u0000MJ\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QS\u0007\u0003"+
		"\u0000\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VW\u0006\u000b\u0000\u0000W\u0018\u0001\u0000\u0000\u0000\b\u00009@EG"+
		"JOT\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}