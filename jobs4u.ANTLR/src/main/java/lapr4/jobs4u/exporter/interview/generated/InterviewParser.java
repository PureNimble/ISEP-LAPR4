package lapr4.jobs4u.exporter.interview.generated;
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
		T__9=10, T__10=11, T__11=12, T__12=13, TRUE_FALSE_QUESTION=14, SHORT_TEXT_ANSWER_QUESTION=15, 
		SINGLE_ANSWER_CHOICE_QUESTION=16, MULTIPLE_ANSWER_CHOICE_QUESTION=17, 
		INTEGER_NUMBER_QUESTION=18, DECIMAL_NUMBER_QUESTION=19, DATE_QUESTION=20, 
		TIME_QUESTION=21, NUMERIC_SCALE_QUESTION=22, TWO_DIGIT_NUMBER=23, NUMBER=24, 
		LETTER=25, MEMBER=26, FRACTIONAL_NUMBER=27, TEXT=28, NEWLINE=29, WS=30;
	public static final int
		RULE_start = 0, RULE_content = 1, RULE_cotation = 2, RULE_cotationType = 3, 
		RULE_choice = 4, RULE_option = 5, RULE_text = 6, RULE_type = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "content", "cotation", "cotationType", "choice", "option", "text", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'QUESTION TYPE:'", "'ANSWER:'", 
			"'COTATION:'", "'100'", "'%'", "'POINTS'", "'VALUES'", "'['", "']'", 
			"'QUESTION:'", "'True/False'", "'Short text answer'", "'Choice, with single answer'", 
			"'Choice, with multiple answers'", "'Integer Number'", "'Decimal Number'", 
			"'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", "SINGLE_ANSWER_CHOICE_QUESTION", 
			"MULTIPLE_ANSWER_CHOICE_QUESTION", "INTEGER_NUMBER_QUESTION", "DECIMAL_NUMBER_QUESTION", 
			"DATE_QUESTION", "TIME_QUESTION", "NUMERIC_SCALE_QUESTION", "TWO_DIGIT_NUMBER", 
			"NUMBER", "LETTER", "MEMBER", "FRACTIONAL_NUMBER", "TEXT", "NEWLINE", 
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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TerminalNode EOF() { return getToken(InterviewParser.EOF, 0); }
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
			setState(16);
			match(T__0);
			setState(17);
			text();
			setState(18);
			match(NEWLINE);
			setState(19);
			match(T__1);
			setState(20);
			match(NEWLINE);
			setState(21);
			match(T__2);
			setState(22);
			match(NEWLINE);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				content();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			setState(28);
			match(EOF);
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
		public CotationContext cotation() {
			return getRuleContext(CotationContext.class,0);
		}
		public CotationTypeContext cotationType() {
			return getRuleContext(CotationTypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			cotation();
			setState(31);
			cotationType();
			setState(32);
			match(NEWLINE);
			setState(33);
			match(T__3);
			setState(34);
			type();
			setState(35);
			match(T__4);
			setState(36);
			match(NEWLINE);
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
	public static class CotationContext extends ParserRuleContext {
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewParser.FRACTIONAL_NUMBER, 0); }
		public CotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationContext cotation() throws RecognitionException {
		CotationContext _localctx = new CotationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__5);
			setState(39);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 142606464L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
	public static class CotationTypeContext extends ParserRuleContext {
		public CotationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotationType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).enterCotationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewListener ) ((InterviewListener)listener).exitCotationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewVisitor ) return ((InterviewVisitor<? extends T>)visitor).visitCotationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationTypeContext cotationType() throws RecognitionException {
		CotationTypeContext _localctx = new CotationTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cotationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
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
		enterRule(_localctx, 8, RULE_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			option();
			setState(44);
			match(NEWLINE);
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				option();
				setState(46);
				match(NEWLINE);
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode LETTER() { return getToken(InterviewParser.LETTER, 0); }
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
		enterRule(_localctx, 10, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__10);
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(54);
			match(T__11);
			setState(55);
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
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(InterviewParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(InterviewParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(InterviewParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(InterviewParser.MEMBER, i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
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
		enterRule(_localctx, 12, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 377487360L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 377487360L) != 0) );
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(62);
					match(T__10);
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 377487360L) != 0)) {
						{
						setState(63);
						text();
						}
					}

					setState(66);
					match(T__11);
					}
					}
					setState(69); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 377487360L) != 0)) {
					{
					setState(71);
					text();
					}
				}

				}
			}

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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewParser.NEWLINE, i);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(InterviewParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(InterviewParser.INTEGER_NUMBER_QUESTION, 0); }
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(InterviewParser.DECIMAL_NUMBER_QUESTION, 0); }
		public TerminalNode DATE_QUESTION() { return getToken(InterviewParser.DATE_QUESTION, 0); }
		public TerminalNode TIME_QUESTION() { return getToken(InterviewParser.TIME_QUESTION, 0); }
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewParser.NUMERIC_SCALE_QUESTION, 0); }
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
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
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE_FALSE_QUESTION:
			case SHORT_TEXT_ANSWER_QUESTION:
			case INTEGER_NUMBER_QUESTION:
			case DECIMAL_NUMBER_QUESTION:
			case DATE_QUESTION:
			case TIME_QUESTION:
			case NUMERIC_SCALE_QUESTION:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(76);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8175616L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(77);
				match(NEWLINE);
				setState(78);
				match(T__12);
				setState(79);
				text();
				setState(80);
				match(NEWLINE);
				}
				}
				break;
			case SINGLE_ANSWER_CHOICE_QUESTION:
			case MULTIPLE_ANSWER_CHOICE_QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==SINGLE_ANSWER_CHOICE_QUESTION || _la==MULTIPLE_ANSWER_CHOICE_QUESTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				match(NEWLINE);
				setState(84);
				match(T__12);
				setState(85);
				text();
				setState(86);
				match(NEWLINE);
				setState(87);
				choice();
				}
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
		"\u0004\u0001\u001e\\\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u00041\b\u0004\u000b\u0004\f\u00042\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004"+
		"\u0006;\b\u0006\u000b\u0006\f\u0006<\u0001\u0006\u0001\u0006\u0003\u0006"+
		"A\b\u0006\u0001\u0006\u0004\u0006D\b\u0006\u000b\u0006\f\u0006E\u0001"+
		"\u0006\u0003\u0006I\b\u0006\u0003\u0006K\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"Z\b\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0000\u0006\u0003\u0000\u0007\u0007\u0017\u0017\u001b\u001b\u0001\u0000"+
		"\b\n\u0002\u0000\u0017\u0017\u0019\u0019\u0003\u0000\u0017\u0017\u0019"+
		"\u001a\u001c\u001c\u0002\u0000\u000e\u000f\u0012\u0016\u0001\u0000\u0010"+
		"\u0011[\u0000\u0010\u0001\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000"+
		"\u0000\u0004&\u0001\u0000\u0000\u0000\u0006)\u0001\u0000\u0000\u0000\b"+
		"+\u0001\u0000\u0000\u0000\n4\u0001\u0000\u0000\u0000\f:\u0001\u0000\u0000"+
		"\u0000\u000eY\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000"+
		"\u0011\u0012\u0003\f\u0006\u0000\u0012\u0013\u0005\u001d\u0000\u0000\u0013"+
		"\u0014\u0005\u0002\u0000\u0000\u0014\u0015\u0005\u001d\u0000\u0000\u0015"+
		"\u0016\u0005\u0003\u0000\u0000\u0016\u0018\u0005\u001d\u0000\u0000\u0017"+
		"\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0005\u0000\u0000\u0001\u001d\u0001\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0003\u0004\u0002\u0000\u001f \u0003\u0006\u0003\u0000 !\u0005"+
		"\u001d\u0000\u0000!\"\u0005\u0004\u0000\u0000\"#\u0003\u000e\u0007\u0000"+
		"#$\u0005\u0005\u0000\u0000$%\u0005\u001d\u0000\u0000%\u0003\u0001\u0000"+
		"\u0000\u0000&\'\u0005\u0006\u0000\u0000\'(\u0007\u0000\u0000\u0000(\u0005"+
		"\u0001\u0000\u0000\u0000)*\u0007\u0001\u0000\u0000*\u0007\u0001\u0000"+
		"\u0000\u0000+,\u0003\n\u0005\u0000,0\u0005\u001d\u0000\u0000-.\u0003\n"+
		"\u0005\u0000./\u0005\u001d\u0000\u0000/1\u0001\u0000\u0000\u00000-\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\t\u0001\u0000\u0000\u000045\u0005\u000b\u0000"+
		"\u000056\u0007\u0002\u0000\u000067\u0005\f\u0000\u000078\u0003\f\u0006"+
		"\u00008\u000b\u0001\u0000\u0000\u00009;\u0007\u0003\u0000\u0000:9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=J\u0001\u0000\u0000\u0000>@\u0005\u000b\u0000"+
		"\u0000?A\u0003\f\u0006\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000BD\u0005\f\u0000\u0000C>\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FH\u0001\u0000\u0000\u0000GI\u0003\f\u0006\u0000HG\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JC\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\r\u0001\u0000\u0000\u0000"+
		"LM\u0007\u0004\u0000\u0000MN\u0005\u001d\u0000\u0000NO\u0005\r\u0000\u0000"+
		"OP\u0003\f\u0006\u0000PQ\u0005\u001d\u0000\u0000QZ\u0001\u0000\u0000\u0000"+
		"RS\u0007\u0005\u0000\u0000ST\u0005\u001d\u0000\u0000TU\u0005\r\u0000\u0000"+
		"UV\u0003\f\u0006\u0000VW\u0005\u001d\u0000\u0000WX\u0003\b\u0004\u0000"+
		"XZ\u0001\u0000\u0000\u0000YL\u0001\u0000\u0000\u0000YR\u0001\u0000\u0000"+
		"\u0000Z\u000f\u0001\u0000\u0000\u0000\b\u001a2<@EHJY";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}