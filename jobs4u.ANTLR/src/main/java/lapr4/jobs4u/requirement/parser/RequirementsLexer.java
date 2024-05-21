package lapr4.jobs4u.requirement.parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMBER=8, LETTER=9, 
		MEMBER=10, TEXT=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "NUMBER", "LETTER", 
			"MEMBER", "TEXT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'#'", "'('", "')'", "':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "NUMBER", "LETTER", "MEMBER", 
			"TEXT", "WS"
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
		"\u0004\u0000\fE\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0003\t6\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0004\n;\b\n\u000b\n\f\n<\u0001\u000b\u0004\u000b@\b"+
		"\u000b\u000b\u000b\f\u000bA\u0001\u000b\u0001\u000b\u0000\u0000\f\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000\u0004\u0001\u0000"+
		"09\u0002\u0000AZaz\u0005\u0000!!\'\',.;;??\u0003\u0000\t\n\r\r  H\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019"+
		"\u0001\u0000\u0000\u0000\u0003 \u0001\u0000\u0000\u0000\u0005&\u0001\u0000"+
		"\u0000\u0000\u0007(\u0001\u0000\u0000\u0000\t*\u0001\u0000\u0000\u0000"+
		"\u000b,\u0001\u0000\u0000\u0000\r.\u0001\u0000\u0000\u0000\u000f0\u0001"+
		"\u0000\u0000\u0000\u00112\u0001\u0000\u0000\u0000\u00135\u0001\u0000\u0000"+
		"\u0000\u0015:\u0001\u0000\u0000\u0000\u0017?\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0005T\u0000\u0000\u001a\u001b\u0005I\u0000\u0000\u001b\u001c\u0005"+
		"T\u0000\u0000\u001c\u001d\u0005L\u0000\u0000\u001d\u001e\u0005E\u0000"+
		"\u0000\u001e\u001f\u0005:\u0000\u0000\u001f\u0002\u0001\u0000\u0000\u0000"+
		" !\u0005N\u0000\u0000!\"\u0005A\u0000\u0000\"#\u0005M\u0000\u0000#$\u0005"+
		"E\u0000\u0000$%\u0005:\u0000\u0000%\u0004\u0001\u0000\u0000\u0000&\'\u0005"+
		"#\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000()\u0005(\u0000\u0000)\b"+
		"\u0001\u0000\u0000\u0000*+\u0005)\u0000\u0000+\n\u0001\u0000\u0000\u0000"+
		",-\u0005:\u0000\u0000-\f\u0001\u0000\u0000\u0000./\u0005,\u0000\u0000"+
		"/\u000e\u0001\u0000\u0000\u000001\u0007\u0000\u0000\u00001\u0010\u0001"+
		"\u0000\u0000\u000023\u0007\u0001\u0000\u00003\u0012\u0001\u0000\u0000"+
		"\u000046\u0007\u0002\u0000\u000054\u0001\u0000\u0000\u00006\u0014\u0001"+
		"\u0000\u0000\u00007;\u0003\u0011\b\u00008;\u0003\u000f\u0007\u00009;\u0003"+
		"\u0013\t\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=\u0016\u0001\u0000\u0000\u0000>@\u0007\u0003"+
		"\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CD\u0006\u000b\u0000\u0000D\u0018\u0001\u0000\u0000\u0000\u0005\u0000"+
		"5:<A\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}