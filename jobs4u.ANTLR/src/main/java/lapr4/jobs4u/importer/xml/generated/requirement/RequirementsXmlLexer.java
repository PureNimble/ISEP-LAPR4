package lapr4.jobs4u.importer.xml.generated.requirement;
// Generated from RequirementsXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RequirementsXmlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, TWO_DIGIT_NUMBER=17, 
		NUMBER=18, LETTER=19, MEMBER=20, FRACTIONAL_NUMBER=21, TEXT=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "TWO_DIGIT_NUMBER", 
			"NUMBER", "LETTER", "MEMBER", "FRACTIONAL_NUMBER", "TEXT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<Questions>'", "'</Questions>'", "'<Question>'", "'</Question>'", 
			"'<Body>'", "'<'", "'/'", "'>'", "'</'", "'</Body>'", "'<PossibleAnswersList>'", 
			"'</PossibleAnswersList>'", "'<PossibleAnswers>'", "'</PossibleAnswers>'", 
			"'<MinimumRequirement>'", "'</MinimumRequirement>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "TWO_DIGIT_NUMBER", "NUMBER", "LETTER", 
			"MEMBER", "FRACTIONAL_NUMBER", "TEXT", "WS"
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


	public RequirementsXmlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RequirementsXml.g4"; }

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
		"\u0004\u0000\u0017\u0111\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00f7\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0003\u0013\u00fe\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u0107\b\u0015"+
		"\u000b\u0015\f\u0015\u0108\u0001\u0016\u0004\u0016\u010c\b\u0016\u000b"+
		"\u0016\f\u0016\u010d\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001\u0000"+
		"\u0005\u0001\u000009\u0002\u0000AZaz\b\u0000!!##\'/:;?@[[]]||\u0002\u0000"+
		",,..\u0003\u0000\t\n\r\r  \u0115\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0001/\u0001\u0000\u0000\u0000\u0003;\u0001\u0000"+
		"\u0000\u0000\u0005H\u0001\u0000\u0000\u0000\u0007S\u0001\u0000\u0000\u0000"+
		"\t_\u0001\u0000\u0000\u0000\u000bf\u0001\u0000\u0000\u0000\rh\u0001\u0000"+
		"\u0000\u0000\u000fj\u0001\u0000\u0000\u0000\u0011l\u0001\u0000\u0000\u0000"+
		"\u0013o\u0001\u0000\u0000\u0000\u0015w\u0001\u0000\u0000\u0000\u0017\u008d"+
		"\u0001\u0000\u0000\u0000\u0019\u00a4\u0001\u0000\u0000\u0000\u001b\u00b6"+
		"\u0001\u0000\u0000\u0000\u001d\u00c9\u0001\u0000\u0000\u0000\u001f\u00de"+
		"\u0001\u0000\u0000\u0000!\u00f4\u0001\u0000\u0000\u0000#\u00f8\u0001\u0000"+
		"\u0000\u0000%\u00fa\u0001\u0000\u0000\u0000\'\u00fd\u0001\u0000\u0000"+
		"\u0000)\u00ff\u0001\u0000\u0000\u0000+\u0106\u0001\u0000\u0000\u0000-"+
		"\u010b\u0001\u0000\u0000\u0000/0\u0005<\u0000\u000001\u0005Q\u0000\u0000"+
		"12\u0005u\u0000\u000023\u0005e\u0000\u000034\u0005s\u0000\u000045\u0005"+
		"t\u0000\u000056\u0005i\u0000\u000067\u0005o\u0000\u000078\u0005n\u0000"+
		"\u000089\u0005s\u0000\u00009:\u0005>\u0000\u0000:\u0002\u0001\u0000\u0000"+
		"\u0000;<\u0005<\u0000\u0000<=\u0005/\u0000\u0000=>\u0005Q\u0000\u0000"+
		">?\u0005u\u0000\u0000?@\u0005e\u0000\u0000@A\u0005s\u0000\u0000AB\u0005"+
		"t\u0000\u0000BC\u0005i\u0000\u0000CD\u0005o\u0000\u0000DE\u0005n\u0000"+
		"\u0000EF\u0005s\u0000\u0000FG\u0005>\u0000\u0000G\u0004\u0001\u0000\u0000"+
		"\u0000HI\u0005<\u0000\u0000IJ\u0005Q\u0000\u0000JK\u0005u\u0000\u0000"+
		"KL\u0005e\u0000\u0000LM\u0005s\u0000\u0000MN\u0005t\u0000\u0000NO\u0005"+
		"i\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005n\u0000\u0000QR\u0005>\u0000"+
		"\u0000R\u0006\u0001\u0000\u0000\u0000ST\u0005<\u0000\u0000TU\u0005/\u0000"+
		"\u0000UV\u0005Q\u0000\u0000VW\u0005u\u0000\u0000WX\u0005e\u0000\u0000"+
		"XY\u0005s\u0000\u0000YZ\u0005t\u0000\u0000Z[\u0005i\u0000\u0000[\\\u0005"+
		"o\u0000\u0000\\]\u0005n\u0000\u0000]^\u0005>\u0000\u0000^\b\u0001\u0000"+
		"\u0000\u0000_`\u0005<\u0000\u0000`a\u0005B\u0000\u0000ab\u0005o\u0000"+
		"\u0000bc\u0005d\u0000\u0000cd\u0005y\u0000\u0000de\u0005>\u0000\u0000"+
		"e\n\u0001\u0000\u0000\u0000fg\u0005<\u0000\u0000g\f\u0001\u0000\u0000"+
		"\u0000hi\u0005/\u0000\u0000i\u000e\u0001\u0000\u0000\u0000jk\u0005>\u0000"+
		"\u0000k\u0010\u0001\u0000\u0000\u0000lm\u0005<\u0000\u0000mn\u0005/\u0000"+
		"\u0000n\u0012\u0001\u0000\u0000\u0000op\u0005<\u0000\u0000pq\u0005/\u0000"+
		"\u0000qr\u0005B\u0000\u0000rs\u0005o\u0000\u0000st\u0005d\u0000\u0000"+
		"tu\u0005y\u0000\u0000uv\u0005>\u0000\u0000v\u0014\u0001\u0000\u0000\u0000"+
		"wx\u0005<\u0000\u0000xy\u0005P\u0000\u0000yz\u0005o\u0000\u0000z{\u0005"+
		"s\u0000\u0000{|\u0005s\u0000\u0000|}\u0005i\u0000\u0000}~\u0005b\u0000"+
		"\u0000~\u007f\u0005l\u0000\u0000\u007f\u0080\u0005e\u0000\u0000\u0080"+
		"\u0081\u0005A\u0000\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0083\u0005"+
		"s\u0000\u0000\u0083\u0084\u0005w\u0000\u0000\u0084\u0085\u0005e\u0000"+
		"\u0000\u0085\u0086\u0005r\u0000\u0000\u0086\u0087\u0005s\u0000\u0000\u0087"+
		"\u0088\u0005L\u0000\u0000\u0088\u0089\u0005i\u0000\u0000\u0089\u008a\u0005"+
		"s\u0000\u0000\u008a\u008b\u0005t\u0000\u0000\u008b\u008c\u0005>\u0000"+
		"\u0000\u008c\u0016\u0001\u0000\u0000\u0000\u008d\u008e\u0005<\u0000\u0000"+
		"\u008e\u008f\u0005/\u0000\u0000\u008f\u0090\u0005P\u0000\u0000\u0090\u0091"+
		"\u0005o\u0000\u0000\u0091\u0092\u0005s\u0000\u0000\u0092\u0093\u0005s"+
		"\u0000\u0000\u0093\u0094\u0005i\u0000\u0000\u0094\u0095\u0005b\u0000\u0000"+
		"\u0095\u0096\u0005l\u0000\u0000\u0096\u0097\u0005e\u0000\u0000\u0097\u0098"+
		"\u0005A\u0000\u0000\u0098\u0099\u0005n\u0000\u0000\u0099\u009a\u0005s"+
		"\u0000\u0000\u009a\u009b\u0005w\u0000\u0000\u009b\u009c\u0005e\u0000\u0000"+
		"\u009c\u009d\u0005r\u0000\u0000\u009d\u009e\u0005s\u0000\u0000\u009e\u009f"+
		"\u0005L\u0000\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0\u00a1\u0005s"+
		"\u0000\u0000\u00a1\u00a2\u0005t\u0000\u0000\u00a2\u00a3\u0005>\u0000\u0000"+
		"\u00a3\u0018\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005<\u0000\u0000\u00a5"+
		"\u00a6\u0005P\u0000\u0000\u00a6\u00a7\u0005o\u0000\u0000\u00a7\u00a8\u0005"+
		"s\u0000\u0000\u00a8\u00a9\u0005s\u0000\u0000\u00a9\u00aa\u0005i\u0000"+
		"\u0000\u00aa\u00ab\u0005b\u0000\u0000\u00ab\u00ac\u0005l\u0000\u0000\u00ac"+
		"\u00ad\u0005e\u0000\u0000\u00ad\u00ae\u0005A\u0000\u0000\u00ae\u00af\u0005"+
		"n\u0000\u0000\u00af\u00b0\u0005s\u0000\u0000\u00b0\u00b1\u0005w\u0000"+
		"\u0000\u00b1\u00b2\u0005e\u0000\u0000\u00b2\u00b3\u0005r\u0000\u0000\u00b3"+
		"\u00b4\u0005s\u0000\u0000\u00b4\u00b5\u0005>\u0000\u0000\u00b5\u001a\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0005<\u0000\u0000\u00b7\u00b8\u0005/\u0000"+
		"\u0000\u00b8\u00b9\u0005P\u0000\u0000\u00b9\u00ba\u0005o\u0000\u0000\u00ba"+
		"\u00bb\u0005s\u0000\u0000\u00bb\u00bc\u0005s\u0000\u0000\u00bc\u00bd\u0005"+
		"i\u0000\u0000\u00bd\u00be\u0005b\u0000\u0000\u00be\u00bf\u0005l\u0000"+
		"\u0000\u00bf\u00c0\u0005e\u0000\u0000\u00c0\u00c1\u0005A\u0000\u0000\u00c1"+
		"\u00c2\u0005n\u0000\u0000\u00c2\u00c3\u0005s\u0000\u0000\u00c3\u00c4\u0005"+
		"w\u0000\u0000\u00c4\u00c5\u0005e\u0000\u0000\u00c5\u00c6\u0005r\u0000"+
		"\u0000\u00c6\u00c7\u0005s\u0000\u0000\u00c7\u00c8\u0005>\u0000\u0000\u00c8"+
		"\u001c\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005<\u0000\u0000\u00ca\u00cb"+
		"\u0005M\u0000\u0000\u00cb\u00cc\u0005i\u0000\u0000\u00cc\u00cd\u0005n"+
		"\u0000\u0000\u00cd\u00ce\u0005i\u0000\u0000\u00ce\u00cf\u0005m\u0000\u0000"+
		"\u00cf\u00d0\u0005u\u0000\u0000\u00d0\u00d1\u0005m\u0000\u0000\u00d1\u00d2"+
		"\u0005R\u0000\u0000\u00d2\u00d3\u0005e\u0000\u0000\u00d3\u00d4\u0005q"+
		"\u0000\u0000\u00d4\u00d5\u0005u\u0000\u0000\u00d5\u00d6\u0005i\u0000\u0000"+
		"\u00d6\u00d7\u0005r\u0000\u0000\u00d7\u00d8\u0005e\u0000\u0000\u00d8\u00d9"+
		"\u0005m\u0000\u0000\u00d9\u00da\u0005e\u0000\u0000\u00da\u00db\u0005n"+
		"\u0000\u0000\u00db\u00dc\u0005t\u0000\u0000\u00dc\u00dd\u0005>\u0000\u0000"+
		"\u00dd\u001e\u0001\u0000\u0000\u0000\u00de\u00df\u0005<\u0000\u0000\u00df"+
		"\u00e0\u0005/\u0000\u0000\u00e0\u00e1\u0005M\u0000\u0000\u00e1\u00e2\u0005"+
		"i\u0000\u0000\u00e2\u00e3\u0005n\u0000\u0000\u00e3\u00e4\u0005i\u0000"+
		"\u0000\u00e4\u00e5\u0005m\u0000\u0000\u00e5\u00e6\u0005u\u0000\u0000\u00e6"+
		"\u00e7\u0005m\u0000\u0000\u00e7\u00e8\u0005R\u0000\u0000\u00e8\u00e9\u0005"+
		"e\u0000\u0000\u00e9\u00ea\u0005q\u0000\u0000\u00ea\u00eb\u0005u\u0000"+
		"\u0000\u00eb\u00ec\u0005i\u0000\u0000\u00ec\u00ed\u0005r\u0000\u0000\u00ed"+
		"\u00ee\u0005e\u0000\u0000\u00ee\u00ef\u0005m\u0000\u0000\u00ef\u00f0\u0005"+
		"e\u0000\u0000\u00f0\u00f1\u0005n\u0000\u0000\u00f1\u00f2\u0005t\u0000"+
		"\u0000\u00f2\u00f3\u0005>\u0000\u0000\u00f3 \u0001\u0000\u0000\u0000\u00f4"+
		"\u00f6\u0003#\u0011\u0000\u00f5\u00f7\u0003#\u0011\u0000\u00f6\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\"\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0007\u0000\u0000\u0000\u00f9$\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0007\u0001\u0000\u0000\u00fb&\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fe\u0007\u0002\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fe(\u0001\u0000\u0000\u0000\u00ff\u0100\u0003!\u0010\u0000\u0100\u0101"+
		"\u0007\u0003\u0000\u0000\u0101\u0102\u0003!\u0010\u0000\u0102*\u0001\u0000"+
		"\u0000\u0000\u0103\u0107\u0003%\u0012\u0000\u0104\u0107\u0003!\u0010\u0000"+
		"\u0105\u0107\u0003\'\u0013\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0106"+
		"\u0104\u0001\u0000\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108"+
		"\u0109\u0001\u0000\u0000\u0000\u0109,\u0001\u0000\u0000\u0000\u010a\u010c"+
		"\u0007\u0004\u0000\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0006\u0016\u0000\u0000\u0110.\u0001\u0000\u0000\u0000\u0006\u0000\u00f6"+
		"\u00fd\u0106\u0108\u010d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}