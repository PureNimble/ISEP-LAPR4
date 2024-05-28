package lapr4.jobs4u.importer.answer.interview.generated;
// Generated from InterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewAnswersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, TRUE_FALSE_QUESTION=15, 
		SHORT_TEXT_ANSWER_QUESTION=16, SINGLE_ANSWER_CHOICE_QUESTION=17, MULTIPLE_ANSWER_CHOICE_QUESTION=18, 
		INTEGER_NUMBER_QUESTION=19, DECIMAL_NUMBER_QUESTION=20, DATE_QUESTION=21, 
		TIME_QUESTION=22, NUMERIC_SCALE_QUESTION=23, TWO_DIGIT_NUMBER=24, NUMBER=25, 
		LETTER=26, MEMBER=27, FRACTIONAL_NUMBER=28, TEXT=29, NEWLINE=30, WS=31;
	public static final int
		RULE_start = 0, RULE_content = 1, RULE_cotation = 2, RULE_cotationType = 3, 
		RULE_choice = 4, RULE_text = 5, RULE_answer = 6, RULE_option = 7, RULE_email = 8, 
		RULE_type = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "content", "cotation", "cotationType", "choice", "text", "answer", 
			"option", "email", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'QUESTION TYPE:'", "'ANSWER:'", 
			"'COTATION:'", "'100'", "'%'", "'POINTS'", "'VALUES'", "'['", "']'", 
			"'@'", "'QUESTION:'", "'True/False'", "'Short text answer'", "'Choice, with single answer'", 
			"'Choice, with multiple answers'", "'Integer Number'", "'Decimal Number'", 
			"'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", 
			"SINGLE_ANSWER_CHOICE_QUESTION", "MULTIPLE_ANSWER_CHOICE_QUESTION", "INTEGER_NUMBER_QUESTION", 
			"DECIMAL_NUMBER_QUESTION", "DATE_QUESTION", "TIME_QUESTION", "NUMERIC_SCALE_QUESTION", 
			"TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "FRACTIONAL_NUMBER", 
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

	@Override
	public String getGrammarFileName() { return "InterviewAnswers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewAnswersParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public TerminalNode EOF() { return getToken(InterviewAnswersParser.EOF, 0); }
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
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitStart(this);
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
			setState(20);
			match(T__0);
			setState(21);
			text();
			setState(22);
			match(NEWLINE);
			setState(23);
			match(T__1);
			setState(24);
			text();
			setState(25);
			match(NEWLINE);
			setState(26);
			match(T__2);
			setState(27);
			email();
			setState(28);
			match(NEWLINE);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				content();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			setState(34);
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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitContent(this);
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
			setState(36);
			cotation();
			setState(37);
			cotationType();
			setState(38);
			match(NEWLINE);
			setState(39);
			match(T__3);
			setState(40);
			type();
			setState(41);
			match(T__4);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 754974720L) != 0)) {
				{
				setState(42);
				answer();
				}
			}

			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(45);
				match(NEWLINE);
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
	public static class CotationContext extends ParserRuleContext {
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewAnswersParser.FRACTIONAL_NUMBER, 0); }
		public CotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitCotation(this);
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
			setState(48);
			match(T__5);
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 285212800L) != 0)) ) {
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
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterCotationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitCotationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitCotationType(this);
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
			setState(51);
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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitChoice(this);
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
			setState(53);
			option();
			setState(54);
			match(NEWLINE);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				option();
				setState(56);
				match(NEWLINE);
				}
				}
				setState(60); 
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
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(InterviewAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(InterviewAnswersParser.TEXT, i);
		}
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(InterviewAnswersParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewAnswersParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewAnswersParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(InterviewAnswersParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(InterviewAnswersParser.MEMBER, i);
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
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 754974720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 754974720L) != 0) );
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					match(T__10);
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 754974720L) != 0)) {
						{
						setState(68);
						text();
						}
					}

					setState(71);
					match(T__11);
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__10 );
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 754974720L) != 0)) {
					{
					setState(76);
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
	public static class AnswerContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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
	public static class OptionContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode LETTER() { return getToken(InterviewAnswersParser.LETTER, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__10);
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(85);
			match(T__11);
			setState(86);
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
	public static class EmailContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(InterviewAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(InterviewAnswersParser.TEXT, i);
		}
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TEXT);
			setState(89);
			match(T__12);
			setState(90);
			match(TEXT);
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
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewAnswersParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(InterviewAnswersParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(InterviewAnswersParser.INTEGER_NUMBER_QUESTION, 0); }
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(InterviewAnswersParser.DECIMAL_NUMBER_QUESTION, 0); }
		public TerminalNode DATE_QUESTION() { return getToken(InterviewAnswersParser.DATE_QUESTION, 0); }
		public TerminalNode TIME_QUESTION() { return getToken(InterviewAnswersParser.TIME_QUESTION, 0); }
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewAnswersParser.NUMERIC_SCALE_QUESTION, 0); }
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewAnswersParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewAnswersParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			setState(105);
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
				setState(92);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16351232L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(93);
				match(NEWLINE);
				setState(94);
				match(T__13);
				setState(95);
				text();
				setState(96);
				match(NEWLINE);
				}
				}
				break;
			case SINGLE_ANSWER_CHOICE_QUESTION:
			case MULTIPLE_ANSWER_CHOICE_QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==SINGLE_ANSWER_CHOICE_QUESTION || _la==MULTIPLE_ANSWER_CHOICE_QUESTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				match(NEWLINE);
				setState(100);
				match(T__13);
				setState(101);
				text();
				setState(102);
				match(NEWLINE);
				setState(103);
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
		"\u0004\u0001\u001fl\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004;\b\u0004\u000b"+
		"\u0004\f\u0004<\u0001\u0005\u0004\u0005@\b\u0005\u000b\u0005\f\u0005A"+
		"\u0001\u0005\u0001\u0005\u0003\u0005F\b\u0005\u0001\u0005\u0004\u0005"+
		"I\b\u0005\u000b\u0005\f\u0005J\u0001\u0005\u0003\u0005N\b\u0005\u0003"+
		"\u0005P\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\tj\b\t\u0001\t\u0000\u0000\n\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0006\u0003\u0000\u0007\u0007"+
		"\u0018\u0018\u001c\u001c\u0001\u0000\b\n\u0003\u0000\u0018\u0018\u001a"+
		"\u001b\u001d\u001d\u0002\u0000\u0018\u0018\u001a\u001a\u0002\u0000\u000f"+
		"\u0010\u0013\u0017\u0001\u0000\u0011\u0012k\u0000\u0014\u0001\u0000\u0000"+
		"\u0000\u0002$\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u0006"+
		"3\u0001\u0000\u0000\u0000\b5\u0001\u0000\u0000\u0000\n?\u0001\u0000\u0000"+
		"\u0000\fQ\u0001\u0000\u0000\u0000\u000eS\u0001\u0000\u0000\u0000\u0010"+
		"X\u0001\u0000\u0000\u0000\u0012i\u0001\u0000\u0000\u0000\u0014\u0015\u0005"+
		"\u0001\u0000\u0000\u0015\u0016\u0003\n\u0005\u0000\u0016\u0017\u0005\u001e"+
		"\u0000\u0000\u0017\u0018\u0005\u0002\u0000\u0000\u0018\u0019\u0003\n\u0005"+
		"\u0000\u0019\u001a\u0005\u001e\u0000\u0000\u001a\u001b\u0005\u0003\u0000"+
		"\u0000\u001b\u001c\u0003\u0010\b\u0000\u001c\u001e\u0005\u001e\u0000\u0000"+
		"\u001d\u001f\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000\u0000\u0000"+
		"\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0000\u0000\u0001"+
		"#\u0001\u0001\u0000\u0000\u0000$%\u0003\u0004\u0002\u0000%&\u0003\u0006"+
		"\u0003\u0000&\'\u0005\u001e\u0000\u0000\'(\u0005\u0004\u0000\u0000()\u0003"+
		"\u0012\t\u0000)+\u0005\u0005\u0000\u0000*,\u0003\f\u0006\u0000+*\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-/\u0005\u001e\u0000\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/\u0003\u0001\u0000\u0000\u000001\u0005\u0006\u0000\u000012\u0007"+
		"\u0000\u0000\u00002\u0005\u0001\u0000\u0000\u000034\u0007\u0001\u0000"+
		"\u00004\u0007\u0001\u0000\u0000\u000056\u0003\u000e\u0007\u00006:\u0005"+
		"\u001e\u0000\u000078\u0003\u000e\u0007\u000089\u0005\u001e\u0000\u0000"+
		"9;\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\t\u0001\u0000"+
		"\u0000\u0000>@\u0007\u0002\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000"+
		"BO\u0001\u0000\u0000\u0000CE\u0005\u000b\u0000\u0000DF\u0003\n\u0005\u0000"+
		"ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0005\f\u0000\u0000HC\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000"+
		"\u0000\u0000LN\u0003\n\u0005\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000NP\u0001\u0000\u0000\u0000OH\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000P\u000b\u0001\u0000\u0000\u0000QR\u0003\n\u0005\u0000"+
		"R\r\u0001\u0000\u0000\u0000ST\u0005\u000b\u0000\u0000TU\u0007\u0003\u0000"+
		"\u0000UV\u0005\f\u0000\u0000VW\u0003\n\u0005\u0000W\u000f\u0001\u0000"+
		"\u0000\u0000XY\u0005\u001d\u0000\u0000YZ\u0005\r\u0000\u0000Z[\u0005\u001d"+
		"\u0000\u0000[\u0011\u0001\u0000\u0000\u0000\\]\u0007\u0004\u0000\u0000"+
		"]^\u0005\u001e\u0000\u0000^_\u0005\u000e\u0000\u0000_`\u0003\n\u0005\u0000"+
		"`a\u0005\u001e\u0000\u0000aj\u0001\u0000\u0000\u0000bc\u0007\u0005\u0000"+
		"\u0000cd\u0005\u001e\u0000\u0000de\u0005\u000e\u0000\u0000ef\u0003\n\u0005"+
		"\u0000fg\u0005\u001e\u0000\u0000gh\u0003\b\u0004\u0000hj\u0001\u0000\u0000"+
		"\u0000i\\\u0001\u0000\u0000\u0000ib\u0001\u0000\u0000\u0000j\u0013\u0001"+
		"\u0000\u0000\u0000\n +.<AEJMOi";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}