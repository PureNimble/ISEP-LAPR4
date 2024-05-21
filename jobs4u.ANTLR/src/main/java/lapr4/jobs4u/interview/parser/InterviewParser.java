package lapr4.jobs4u.interview.parser;
// Generated from Interview.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NUMBER=22, LETTER=23, MEMBER=24, 
		TWO_DIGIT_NUMBER=25, FRACTIONAL_NUMBER=26, TEXT=27, WS=28;
	public static final int
		RULE_start = 0, RULE_content = 1, RULE_choice = 2, RULE_option = 3, RULE_text = 4, 
		RULE_type = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "content", "choice", "option", "text", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'GRADE:'", "'COTATION:'", "'100'", "'%'", 
			"'POINTS'", "'VALUES'", "'QUESTION TYPE:'", "'ANSWER:'", "')'", "'True/False'", 
			"'QUESTION:'", "'Short text answer'", "'Choice, with single answer'", 
			"'Choice, with multiple answers'", "'Integer Number'", "'Decimal Number'", 
			"'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "NUMBER", 
			"LETTER", "MEMBER", "TWO_DIGIT_NUMBER", "FRACTIONAL_NUMBER", "TEXT", 
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

	@Override
	public String getGrammarFileName() { return "Interview.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(T__0);
			setState(13);
			text();
			setState(14);
			match(T__1);
			setState(15);
			match(T__2);
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				content();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewParser.FRACTIONAL_NUMBER, 0); }
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__3);
			setState(22);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 100663328L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(23);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(24);
			match(T__8);
			setState(25);
			type();
			setState(26);
			match(T__9);
			setState(27);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChoiceContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			option();
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				option();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(InterviewParser.NUMBER, 0); }
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(NUMBER);
			setState(36);
			match(T__10);
			setState(37);
			text();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(InterviewParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(InterviewParser.TEXT, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(InterviewParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(InterviewParser.NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewParser.LETTER, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(39);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 146800640L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(42); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(T__11);
				setState(45);
				match(T__12);
				setState(46);
				text();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(T__13);
				setState(48);
				match(T__12);
				setState(49);
				text();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(T__14);
				setState(51);
				match(T__12);
				setState(52);
				text();
				setState(53);
				choice();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(T__15);
				setState(56);
				match(T__12);
				setState(57);
				text();
				setState(58);
				choice();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(T__16);
				setState(61);
				match(T__12);
				setState(62);
				text();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				match(T__17);
				setState(64);
				match(T__12);
				setState(65);
				text();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				match(T__18);
				setState(67);
				match(T__12);
				setState(68);
				text();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				match(T__19);
				setState(70);
				match(T__12);
				setState(71);
				text();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
				match(T__20);
				setState(73);
				match(T__12);
				setState(74);
				text();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001cN\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0004\u0002 \b\u0002\u000b\u0002"+
		"\f\u0002!\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0004\u0004)\b\u0004\u000b\u0004\f\u0004*\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005L\b"+
		"\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000"+
		"\u0003\u0002\u0000\u0005\u0005\u0019\u001a\u0001\u0000\u0006\b\u0002\u0000"+
		"\u0016\u0017\u001b\u001bR\u0000\f\u0001\u0000\u0000\u0000\u0002\u0015"+
		"\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000\u0006#\u0001"+
		"\u0000\u0000\u0000\b(\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000\u0000"+
		"\f\r\u0005\u0001\u0000\u0000\r\u000e\u0003\b\u0004\u0000\u000e\u000f\u0005"+
		"\u0002\u0000\u0000\u000f\u0011\u0005\u0003\u0000\u0000\u0010\u0012\u0003"+
		"\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001"+
		"\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001"+
		"\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0016\u0005"+
		"\u0004\u0000\u0000\u0016\u0017\u0007\u0000\u0000\u0000\u0017\u0018\u0007"+
		"\u0001\u0000\u0000\u0018\u0019\u0005\t\u0000\u0000\u0019\u001a\u0003\n"+
		"\u0005\u0000\u001a\u001b\u0005\n\u0000\u0000\u001b\u001c\u0005\u0003\u0000"+
		"\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001f\u0003\u0006\u0003"+
		"\u0000\u001e \u0003\u0006\u0003\u0000\u001f\u001e\u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000"+
		"\u0000\u0000\"\u0005\u0001\u0000\u0000\u0000#$\u0005\u0016\u0000\u0000"+
		"$%\u0005\u000b\u0000\u0000%&\u0003\b\u0004\u0000&\u0007\u0001\u0000\u0000"+
		"\u0000\')\u0007\u0002\u0000\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+\t\u0001"+
		"\u0000\u0000\u0000,-\u0005\f\u0000\u0000-.\u0005\r\u0000\u0000.L\u0003"+
		"\b\u0004\u0000/0\u0005\u000e\u0000\u000001\u0005\r\u0000\u00001L\u0003"+
		"\b\u0004\u000023\u0005\u000f\u0000\u000034\u0005\r\u0000\u000045\u0003"+
		"\b\u0004\u000056\u0003\u0004\u0002\u00006L\u0001\u0000\u0000\u000078\u0005"+
		"\u0010\u0000\u000089\u0005\r\u0000\u00009:\u0003\b\u0004\u0000:;\u0003"+
		"\u0004\u0002\u0000;L\u0001\u0000\u0000\u0000<=\u0005\u0011\u0000\u0000"+
		"=>\u0005\r\u0000\u0000>L\u0003\b\u0004\u0000?@\u0005\u0012\u0000\u0000"+
		"@A\u0005\r\u0000\u0000AL\u0003\b\u0004\u0000BC\u0005\u0013\u0000\u0000"+
		"CD\u0005\r\u0000\u0000DL\u0003\b\u0004\u0000EF\u0005\u0014\u0000\u0000"+
		"FG\u0005\r\u0000\u0000GL\u0003\b\u0004\u0000HI\u0005\u0015\u0000\u0000"+
		"IJ\u0005\r\u0000\u0000JL\u0003\b\u0004\u0000K,\u0001\u0000\u0000\u0000"+
		"K/\u0001\u0000\u0000\u0000K2\u0001\u0000\u0000\u0000K7\u0001\u0000\u0000"+
		"\u0000K<\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000KB\u0001\u0000"+
		"\u0000\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000L\u000b"+
		"\u0001\u0000\u0000\u0000\u0004\u0013!*K";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}