package lapr4.jobs4u.importer.interview.answer.generated;
// Generated from InterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class InterviewAnswersLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TRUE_FALSE_QUESTION=21, SHORT_TEXT_ANSWER_QUESTION=22, 
		SINGLE_ANSWER_CHOICE_QUESTION=23, MULTIPLE_ANSWER_CHOICE_QUESTION=24, 
		INTEGER_NUMBER_QUESTION=25, DECIMAL_NUMBER_QUESTION=26, DATE_QUESTION=27, 
		TIME_QUESTION=28, NUMERIC_SCALE_QUESTION=29, TWO_DIGIT_NUMBER=30, NUMBER=31, 
		LETTER=32, MEMBER=33, FRACTIONAL_NUMBER=34, NUMERIC_SCALE=35, DATE=36, 
		TIME=37, TEXT=38, NEWLINE=39, WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", 
			"SINGLE_ANSWER_CHOICE_QUESTION", "MULTIPLE_ANSWER_CHOICE_QUESTION", "INTEGER_NUMBER_QUESTION", 
			"DECIMAL_NUMBER_QUESTION", "DATE_QUESTION", "TIME_QUESTION", "NUMERIC_SCALE_QUESTION", 
			"TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "FRACTIONAL_NUMBER", 
			"NUMERIC_SCALE", "DATE", "TIME", "TEXT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'QUESTION TYPE:'", "'COTATION:'", 
			"'100'", "'%'", "'POINTS'", "'VALUES'", "'['", "']'", "'@'", "'QUESTION:'", 
			"'ANSWER:'", "'True'", "'False'", "'TRUE'", "'FALSE'", "'true'", "'false'", 
			"'True/False'", "'Short text answer'", "'Choice, with single answer'", 
			"'Choice, with multiple answers'", "'Integer Number'", "'Decimal Number'", 
			"'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TRUE_FALSE_QUESTION", 
			"SHORT_TEXT_ANSWER_QUESTION", "SINGLE_ANSWER_CHOICE_QUESTION", "MULTIPLE_ANSWER_CHOICE_QUESTION", 
			"INTEGER_NUMBER_QUESTION", "DECIMAL_NUMBER_QUESTION", "DATE_QUESTION", 
			"TIME_QUESTION", "NUMERIC_SCALE_QUESTION", "TWO_DIGIT_NUMBER", "NUMBER", 
			"LETTER", "MEMBER", "FRACTIONAL_NUMBER", "NUMERIC_SCALE", "DATE", "TIME", 
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


	public InterviewAnswersLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InterviewAnswers.g4"; }

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
		"\u0004\u0000(\u01c0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u015a\b\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0003 \u0161\b"+
		" \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0003\"\u016a\b"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0174"+
		"\b#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u017b\b#\u0001#\u0001#\u0004"+
		"#\u017f\b#\u000b#\f#\u0180\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u0189\b$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u0198\b$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u01a7\b$\u0003$\u01a9\b$\u0001%\u0001%\u0001%\u0004%\u01ae\b%\u000b"+
		"%\f%\u01af\u0001&\u0003&\u01b3\b&\u0001&\u0004&\u01b6\b&\u000b&\f&\u01b7"+
		"\u0001\'\u0004\'\u01bb\b\'\u000b\'\f\'\u01bc\u0001\'\u0001\'\u0000\u0000"+
		"(\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%"+
		"K&M\'O(\u0001\u0000\t\u0001\u000009\u0002\u0000AZaz\u0007\u0000!!##\'"+
		"/:;??||\u03c0\u03c0\u0002\u0000,,..\u0001\u000019\u0001\u000001\u0001"+
		"\u000002\u0001\u000003\u0003\u0000\t\n\r\r  \u01d9\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000"+
		"\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000"+
		"M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0001Q\u0001"+
		"\u0000\u0000\u0000\u0003X\u0001\u0000\u0000\u0000\u0005^\u0001\u0000\u0000"+
		"\u0000\u0007e\u0001\u0000\u0000\u0000\tt\u0001\u0000\u0000\u0000\u000b"+
		"~\u0001\u0000\u0000\u0000\r\u0082\u0001\u0000\u0000\u0000\u000f\u0084"+
		"\u0001\u0000\u0000\u0000\u0011\u008b\u0001\u0000\u0000\u0000\u0013\u0092"+
		"\u0001\u0000\u0000\u0000\u0015\u0094\u0001\u0000\u0000\u0000\u0017\u0096"+
		"\u0001\u0000\u0000\u0000\u0019\u0098\u0001\u0000\u0000\u0000\u001b\u00a2"+
		"\u0001\u0000\u0000\u0000\u001d\u00aa\u0001\u0000\u0000\u0000\u001f\u00af"+
		"\u0001\u0000\u0000\u0000!\u00b5\u0001\u0000\u0000\u0000#\u00ba\u0001\u0000"+
		"\u0000\u0000%\u00c0\u0001\u0000\u0000\u0000\'\u00c5\u0001\u0000\u0000"+
		"\u0000)\u00cb\u0001\u0000\u0000\u0000+\u00d6\u0001\u0000\u0000\u0000-"+
		"\u00e8\u0001\u0000\u0000\u0000/\u0103\u0001\u0000\u0000\u00001\u0121\u0001"+
		"\u0000\u0000\u00003\u0130\u0001\u0000\u0000\u00005\u013f\u0001\u0000\u0000"+
		"\u00007\u0144\u0001\u0000\u0000\u00009\u0149\u0001\u0000\u0000\u0000;"+
		"\u0157\u0001\u0000\u0000\u0000=\u015b\u0001\u0000\u0000\u0000?\u015d\u0001"+
		"\u0000\u0000\u0000A\u0160\u0001\u0000\u0000\u0000C\u0162\u0001\u0000\u0000"+
		"\u0000E\u0166\u0001\u0000\u0000\u0000G\u0173\u0001\u0000\u0000\u0000I"+
		"\u0188\u0001\u0000\u0000\u0000K\u01ad\u0001\u0000\u0000\u0000M\u01b5\u0001"+
		"\u0000\u0000\u0000O\u01ba\u0001\u0000\u0000\u0000QR\u0005T\u0000\u0000"+
		"RS\u0005I\u0000\u0000ST\u0005T\u0000\u0000TU\u0005L\u0000\u0000UV\u0005"+
		"E\u0000\u0000VW\u0005:\u0000\u0000W\u0002\u0001\u0000\u0000\u0000XY\u0005"+
		"N\u0000\u0000YZ\u0005A\u0000\u0000Z[\u0005M\u0000\u0000[\\\u0005E\u0000"+
		"\u0000\\]\u0005:\u0000\u0000]\u0004\u0001\u0000\u0000\u0000^_\u0005E\u0000"+
		"\u0000_`\u0005M\u0000\u0000`a\u0005A\u0000\u0000ab\u0005I\u0000\u0000"+
		"bc\u0005L\u0000\u0000cd\u0005:\u0000\u0000d\u0006\u0001\u0000\u0000\u0000"+
		"ef\u0005Q\u0000\u0000fg\u0005U\u0000\u0000gh\u0005E\u0000\u0000hi\u0005"+
		"S\u0000\u0000ij\u0005T\u0000\u0000jk\u0005I\u0000\u0000kl\u0005O\u0000"+
		"\u0000lm\u0005N\u0000\u0000mn\u0005 \u0000\u0000no\u0005T\u0000\u0000"+
		"op\u0005Y\u0000\u0000pq\u0005P\u0000\u0000qr\u0005E\u0000\u0000rs\u0005"+
		":\u0000\u0000s\b\u0001\u0000\u0000\u0000tu\u0005C\u0000\u0000uv\u0005"+
		"O\u0000\u0000vw\u0005T\u0000\u0000wx\u0005A\u0000\u0000xy\u0005T\u0000"+
		"\u0000yz\u0005I\u0000\u0000z{\u0005O\u0000\u0000{|\u0005N\u0000\u0000"+
		"|}\u0005:\u0000\u0000}\n\u0001\u0000\u0000\u0000~\u007f\u00051\u0000\u0000"+
		"\u007f\u0080\u00050\u0000\u0000\u0080\u0081\u00050\u0000\u0000\u0081\f"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005%\u0000\u0000\u0083\u000e\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005P\u0000\u0000\u0085\u0086\u0005O\u0000"+
		"\u0000\u0086\u0087\u0005I\u0000\u0000\u0087\u0088\u0005N\u0000\u0000\u0088"+
		"\u0089\u0005T\u0000\u0000\u0089\u008a\u0005S\u0000\u0000\u008a\u0010\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005V\u0000\u0000\u008c\u008d\u0005A\u0000"+
		"\u0000\u008d\u008e\u0005L\u0000\u0000\u008e\u008f\u0005U\u0000\u0000\u008f"+
		"\u0090\u0005E\u0000\u0000\u0090\u0091\u0005S\u0000\u0000\u0091\u0012\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0005[\u0000\u0000\u0093\u0014\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0005]\u0000\u0000\u0095\u0016\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0005@\u0000\u0000\u0097\u0018\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005Q\u0000\u0000\u0099\u009a\u0005U\u0000\u0000\u009a\u009b"+
		"\u0005E\u0000\u0000\u009b\u009c\u0005S\u0000\u0000\u009c\u009d\u0005T"+
		"\u0000\u0000\u009d\u009e\u0005I\u0000\u0000\u009e\u009f\u0005O\u0000\u0000"+
		"\u009f\u00a0\u0005N\u0000\u0000\u00a0\u00a1\u0005:\u0000\u0000\u00a1\u001a"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005A\u0000\u0000\u00a3\u00a4\u0005"+
		"N\u0000\u0000\u00a4\u00a5\u0005S\u0000\u0000\u00a5\u00a6\u0005W\u0000"+
		"\u0000\u00a6\u00a7\u0005E\u0000\u0000\u00a7\u00a8\u0005R\u0000\u0000\u00a8"+
		"\u00a9\u0005:\u0000\u0000\u00a9\u001c\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0005T\u0000\u0000\u00ab\u00ac\u0005r\u0000\u0000\u00ac\u00ad\u0005u"+
		"\u0000\u0000\u00ad\u00ae\u0005e\u0000\u0000\u00ae\u001e\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005F\u0000\u0000\u00b0\u00b1\u0005a\u0000\u0000\u00b1"+
		"\u00b2\u0005l\u0000\u0000\u00b2\u00b3\u0005s\u0000\u0000\u00b3\u00b4\u0005"+
		"e\u0000\u0000\u00b4 \u0001\u0000\u0000\u0000\u00b5\u00b6\u0005T\u0000"+
		"\u0000\u00b6\u00b7\u0005R\u0000\u0000\u00b7\u00b8\u0005U\u0000\u0000\u00b8"+
		"\u00b9\u0005E\u0000\u0000\u00b9\"\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0005F\u0000\u0000\u00bb\u00bc\u0005A\u0000\u0000\u00bc\u00bd\u0005L"+
		"\u0000\u0000\u00bd\u00be\u0005S\u0000\u0000\u00be\u00bf\u0005E\u0000\u0000"+
		"\u00bf$\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005t\u0000\u0000\u00c1\u00c2"+
		"\u0005r\u0000\u0000\u00c2\u00c3\u0005u\u0000\u0000\u00c3\u00c4\u0005e"+
		"\u0000\u0000\u00c4&\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005f\u0000\u0000"+
		"\u00c6\u00c7\u0005a\u0000\u0000\u00c7\u00c8\u0005l\u0000\u0000\u00c8\u00c9"+
		"\u0005s\u0000\u0000\u00c9\u00ca\u0005e\u0000\u0000\u00ca(\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0005T\u0000\u0000\u00cc\u00cd\u0005r\u0000\u0000"+
		"\u00cd\u00ce\u0005u\u0000\u0000\u00ce\u00cf\u0005e\u0000\u0000\u00cf\u00d0"+
		"\u0005/\u0000\u0000\u00d0\u00d1\u0005F\u0000\u0000\u00d1\u00d2\u0005a"+
		"\u0000\u0000\u00d2\u00d3\u0005l\u0000\u0000\u00d3\u00d4\u0005s\u0000\u0000"+
		"\u00d4\u00d5\u0005e\u0000\u0000\u00d5*\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0005S\u0000\u0000\u00d7\u00d8\u0005h\u0000\u0000\u00d8\u00d9\u0005o"+
		"\u0000\u0000\u00d9\u00da\u0005r\u0000\u0000\u00da\u00db\u0005t\u0000\u0000"+
		"\u00db\u00dc\u0005 \u0000\u0000\u00dc\u00dd\u0005t\u0000\u0000\u00dd\u00de"+
		"\u0005e\u0000\u0000\u00de\u00df\u0005x\u0000\u0000\u00df\u00e0\u0005t"+
		"\u0000\u0000\u00e0\u00e1\u0005 \u0000\u0000\u00e1\u00e2\u0005a\u0000\u0000"+
		"\u00e2\u00e3\u0005n\u0000\u0000\u00e3\u00e4\u0005s\u0000\u0000\u00e4\u00e5"+
		"\u0005w\u0000\u0000\u00e5\u00e6\u0005e\u0000\u0000\u00e6\u00e7\u0005r"+
		"\u0000\u0000\u00e7,\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005C\u0000\u0000"+
		"\u00e9\u00ea\u0005h\u0000\u0000\u00ea\u00eb\u0005o\u0000\u0000\u00eb\u00ec"+
		"\u0005i\u0000\u0000\u00ec\u00ed\u0005c\u0000\u0000\u00ed\u00ee\u0005e"+
		"\u0000\u0000\u00ee\u00ef\u0005,\u0000\u0000\u00ef\u00f0\u0005 \u0000\u0000"+
		"\u00f0\u00f1\u0005w\u0000\u0000\u00f1\u00f2\u0005i\u0000\u0000\u00f2\u00f3"+
		"\u0005t\u0000\u0000\u00f3\u00f4\u0005h\u0000\u0000\u00f4\u00f5\u0005 "+
		"\u0000\u0000\u00f5\u00f6\u0005s\u0000\u0000\u00f6\u00f7\u0005i\u0000\u0000"+
		"\u00f7\u00f8\u0005n\u0000\u0000\u00f8\u00f9\u0005g\u0000\u0000\u00f9\u00fa"+
		"\u0005l\u0000\u0000\u00fa\u00fb\u0005e\u0000\u0000\u00fb\u00fc\u0005 "+
		"\u0000\u0000\u00fc\u00fd\u0005a\u0000\u0000\u00fd\u00fe\u0005n\u0000\u0000"+
		"\u00fe\u00ff\u0005s\u0000\u0000\u00ff\u0100\u0005w\u0000\u0000\u0100\u0101"+
		"\u0005e\u0000\u0000\u0101\u0102\u0005r\u0000\u0000\u0102.\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0005C\u0000\u0000\u0104\u0105\u0005h\u0000\u0000"+
		"\u0105\u0106\u0005o\u0000\u0000\u0106\u0107\u0005i\u0000\u0000\u0107\u0108"+
		"\u0005c\u0000\u0000\u0108\u0109\u0005e\u0000\u0000\u0109\u010a\u0005,"+
		"\u0000\u0000\u010a\u010b\u0005 \u0000\u0000\u010b\u010c\u0005w\u0000\u0000"+
		"\u010c\u010d\u0005i\u0000\u0000\u010d\u010e\u0005t\u0000\u0000\u010e\u010f"+
		"\u0005h\u0000\u0000\u010f\u0110\u0005 \u0000\u0000\u0110\u0111\u0005m"+
		"\u0000\u0000\u0111\u0112\u0005u\u0000\u0000\u0112\u0113\u0005l\u0000\u0000"+
		"\u0113\u0114\u0005t\u0000\u0000\u0114\u0115\u0005i\u0000\u0000\u0115\u0116"+
		"\u0005p\u0000\u0000\u0116\u0117\u0005l\u0000\u0000\u0117\u0118\u0005e"+
		"\u0000\u0000\u0118\u0119\u0005 \u0000\u0000\u0119\u011a\u0005a\u0000\u0000"+
		"\u011a\u011b\u0005n\u0000\u0000\u011b\u011c\u0005s\u0000\u0000\u011c\u011d"+
		"\u0005w\u0000\u0000\u011d\u011e\u0005e\u0000\u0000\u011e\u011f\u0005r"+
		"\u0000\u0000\u011f\u0120\u0005s\u0000\u0000\u01200\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0005I\u0000\u0000\u0122\u0123\u0005n\u0000\u0000\u0123\u0124"+
		"\u0005t\u0000\u0000\u0124\u0125\u0005e\u0000\u0000\u0125\u0126\u0005g"+
		"\u0000\u0000\u0126\u0127\u0005e\u0000\u0000\u0127\u0128\u0005r\u0000\u0000"+
		"\u0128\u0129\u0005 \u0000\u0000\u0129\u012a\u0005N\u0000\u0000\u012a\u012b"+
		"\u0005u\u0000\u0000\u012b\u012c\u0005m\u0000\u0000\u012c\u012d\u0005b"+
		"\u0000\u0000\u012d\u012e\u0005e\u0000\u0000\u012e\u012f\u0005r\u0000\u0000"+
		"\u012f2\u0001\u0000\u0000\u0000\u0130\u0131\u0005D\u0000\u0000\u0131\u0132"+
		"\u0005e\u0000\u0000\u0132\u0133\u0005c\u0000\u0000\u0133\u0134\u0005i"+
		"\u0000\u0000\u0134\u0135\u0005m\u0000\u0000\u0135\u0136\u0005a\u0000\u0000"+
		"\u0136\u0137\u0005l\u0000\u0000\u0137\u0138\u0005 \u0000\u0000\u0138\u0139"+
		"\u0005N\u0000\u0000\u0139\u013a\u0005u\u0000\u0000\u013a\u013b\u0005m"+
		"\u0000\u0000\u013b\u013c\u0005b\u0000\u0000\u013c\u013d\u0005e\u0000\u0000"+
		"\u013d\u013e\u0005r\u0000\u0000\u013e4\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0005D\u0000\u0000\u0140\u0141\u0005a\u0000\u0000\u0141\u0142\u0005t"+
		"\u0000\u0000\u0142\u0143\u0005e\u0000\u0000\u01436\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0005T\u0000\u0000\u0145\u0146\u0005i\u0000\u0000\u0146\u0147"+
		"\u0005m\u0000\u0000\u0147\u0148\u0005e\u0000\u0000\u01488\u0001\u0000"+
		"\u0000\u0000\u0149\u014a\u0005N\u0000\u0000\u014a\u014b\u0005u\u0000\u0000"+
		"\u014b\u014c\u0005m\u0000\u0000\u014c\u014d\u0005e\u0000\u0000\u014d\u014e"+
		"\u0005r\u0000\u0000\u014e\u014f\u0005i\u0000\u0000\u014f\u0150\u0005c"+
		"\u0000\u0000\u0150\u0151\u0005 \u0000\u0000\u0151\u0152\u0005S\u0000\u0000"+
		"\u0152\u0153\u0005c\u0000\u0000\u0153\u0154\u0005a\u0000\u0000\u0154\u0155"+
		"\u0005l\u0000\u0000\u0155\u0156\u0005e\u0000\u0000\u0156:\u0001\u0000"+
		"\u0000\u0000\u0157\u0159\u0003=\u001e\u0000\u0158\u015a\u0003=\u001e\u0000"+
		"\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000"+
		"\u015a<\u0001\u0000\u0000\u0000\u015b\u015c\u0007\u0000\u0000\u0000\u015c"+
		">\u0001\u0000\u0000\u0000\u015d\u015e\u0007\u0001\u0000\u0000\u015e@\u0001"+
		"\u0000\u0000\u0000\u015f\u0161\u0007\u0002\u0000\u0000\u0160\u015f\u0001"+
		"\u0000\u0000\u0000\u0161B\u0001\u0000\u0000\u0000\u0162\u0163\u0003;\u001d"+
		"\u0000\u0163\u0164\u0007\u0003\u0000\u0000\u0164\u0165\u0003;\u001d\u0000"+
		"\u0165D\u0001\u0000\u0000\u0000\u0166\u0169\u0003;\u001d\u0000\u0167\u0168"+
		"\u0005-\u0000\u0000\u0168\u016a\u0003;\u001d\u0000\u0169\u0167\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016aF\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u00050\u0000\u0000\u016c\u0174\u0007\u0004\u0000\u0000"+
		"\u016d\u016e\u00051\u0000\u0000\u016e\u0174\u0007\u0000\u0000\u0000\u016f"+
		"\u0170\u00052\u0000\u0000\u0170\u0174\u0007\u0000\u0000\u0000\u0171\u0172"+
		"\u00053\u0000\u0000\u0172\u0174\u0007\u0005\u0000\u0000\u0173\u016b\u0001"+
		"\u0000\u0000\u0000\u0173\u016d\u0001\u0000\u0000\u0000\u0173\u016f\u0001"+
		"\u0000\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0175\u0001"+
		"\u0000\u0000\u0000\u0175\u017a\u0005/\u0000\u0000\u0176\u0177\u00050\u0000"+
		"\u0000\u0177\u017b\u0007\u0004\u0000\u0000\u0178\u0179\u00051\u0000\u0000"+
		"\u0179\u017b\u0007\u0006\u0000\u0000\u017a\u0176\u0001\u0000\u0000\u0000"+
		"\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000"+
		"\u017c\u017e\u0005/\u0000\u0000\u017d\u017f\u0003;\u001d\u0000\u017e\u017d"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u017e"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181H\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u00050\u0000\u0000\u0183\u0189\u0007\u0000"+
		"\u0000\u0000\u0184\u0185\u00051\u0000\u0000\u0185\u0189\u0007\u0000\u0000"+
		"\u0000\u0186\u0187\u00052\u0000\u0000\u0187\u0189\u0007\u0007\u0000\u0000"+
		"\u0188\u0182\u0001\u0000\u0000\u0000\u0188\u0184\u0001\u0000\u0000\u0000"+
		"\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000"+
		"\u018a\u0197\u0005:\u0000\u0000\u018b\u018c\u00050\u0000\u0000\u018c\u0198"+
		"\u0007\u0000\u0000\u0000\u018d\u018e\u00051\u0000\u0000\u018e\u0198\u0007"+
		"\u0000\u0000\u0000\u018f\u0190\u00052\u0000\u0000\u0190\u0198\u0007\u0000"+
		"\u0000\u0000\u0191\u0192\u00053\u0000\u0000\u0192\u0198\u0007\u0000\u0000"+
		"\u0000\u0193\u0194\u00054\u0000\u0000\u0194\u0198\u0007\u0000\u0000\u0000"+
		"\u0195\u0196\u00055\u0000\u0000\u0196\u0198\u0007\u0000\u0000\u0000\u0197"+
		"\u018b\u0001\u0000\u0000\u0000\u0197\u018d\u0001\u0000\u0000\u0000\u0197"+
		"\u018f\u0001\u0000\u0000\u0000\u0197\u0191\u0001\u0000\u0000\u0000\u0197"+
		"\u0193\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198"+
		"\u01a8\u0001\u0000\u0000\u0000\u0199\u01a6\u0005:\u0000\u0000\u019a\u019b"+
		"\u00050\u0000\u0000\u019b\u01a7\u0007\u0000\u0000\u0000\u019c\u019d\u0005"+
		"1\u0000\u0000\u019d\u01a7\u0007\u0000\u0000\u0000\u019e\u019f\u00052\u0000"+
		"\u0000\u019f\u01a7\u0007\u0000\u0000\u0000\u01a0\u01a1\u00053\u0000\u0000"+
		"\u01a1\u01a7\u0007\u0000\u0000\u0000\u01a2\u01a3\u00054\u0000\u0000\u01a3"+
		"\u01a7\u0007\u0000\u0000\u0000\u01a4\u01a5\u00055\u0000\u0000\u01a5\u01a7"+
		"\u0007\u0000\u0000\u0000\u01a6\u019a\u0001\u0000\u0000\u0000\u01a6\u019c"+
		"\u0001\u0000\u0000\u0000\u01a6\u019e\u0001\u0000\u0000\u0000\u01a6\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a6\u01a2\u0001\u0000\u0000\u0000\u01a6\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000\u01a8\u0199"+
		"\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9J\u0001"+
		"\u0000\u0000\u0000\u01aa\u01ae\u0003?\u001f\u0000\u01ab\u01ae\u0003;\u001d"+
		"\u0000\u01ac\u01ae\u0003A \u0000\u01ad\u01aa\u0001\u0000\u0000\u0000\u01ad"+
		"\u01ab\u0001\u0000\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01af"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b0L\u0001\u0000\u0000\u0000\u01b1\u01b3"+
		"\u0005\r\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0005"+
		"\n\u0000\u0000\u01b5\u01b2\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b8N\u0001\u0000\u0000\u0000\u01b9\u01bb\u0007\b\u0000"+
		"\u0000\u01ba\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000"+
		"\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01bf\u0006\'\u0000\u0000"+
		"\u01bfP\u0001\u0000\u0000\u0000\u0010\u0000\u0159\u0160\u0169\u0173\u017a"+
		"\u0180\u0188\u0197\u01a6\u01a8\u01ad\u01af\u01b2\u01b7\u01bc\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}