package lapr4.jobs4u.importer.interview.answer.generated;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TRUE_FALSE_QUESTION=21, SHORT_TEXT_ANSWER_QUESTION=22, 
		SINGLE_ANSWER_CHOICE_QUESTION=23, MULTIPLE_ANSWER_CHOICE_QUESTION=24, 
		INTEGER_NUMBER_QUESTION=25, DECIMAL_NUMBER_QUESTION=26, DATE_QUESTION=27, 
		TIME_QUESTION=28, NUMERIC_SCALE_QUESTION=29, TWO_DIGIT_NUMBER=30, NUMBER=31, 
		LETTER=32, MEMBER=33, FRACTIONAL_NUMBER=34, NUMERIC_SCALE=35, DATE=36, 
		TIME=37, TEXT=38, NEWLINE=39, WS=40;
	public static final int
		RULE_start = 0, RULE_content = 1, RULE_cotation = 2, RULE_cotationType = 3, 
		RULE_choice = 4, RULE_text = 5, RULE_option = 6, RULE_email = 7, RULE_question = 8, 
		RULE_type = 9, RULE_true_false = 10, RULE_short_text_answer = 11, RULE_single_answer_choice = 12, 
		RULE_multiple_answer_choice = 13, RULE_integer_number = 14, RULE_decimal_number = 15, 
		RULE_date = 16, RULE_time = 17, RULE_numeric_scale = 18, RULE_true_false_answer = 19, 
		RULE_text_answer = 20, RULE_integer_answer = 21, RULE_decimal_answer = 22, 
		RULE_date_answer = 23, RULE_time_answer = 24, RULE_numeric_scale_answer = 25, 
		RULE_single_answer_choice_answer = 26, RULE_multiple_answer_choice_answer = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "content", "cotation", "cotationType", "choice", "text", "option", 
			"email", "question", "type", "true_false", "short_text_answer", "single_answer_choice", 
			"multiple_answer_choice", "integer_number", "decimal_number", "date", 
			"time", "numeric_scale", "true_false_answer", "text_answer", "integer_answer", 
			"decimal_answer", "date_answer", "time_answer", "numeric_scale_answer", 
			"single_answer_choice_answer", "multiple_answer_choice_answer"
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
			setState(56);
			match(T__0);
			setState(57);
			text();
			setState(58);
			match(NEWLINE);
			setState(59);
			match(T__1);
			setState(60);
			text();
			setState(61);
			match(NEWLINE);
			setState(62);
			match(T__2);
			setState(63);
			email();
			setState(64);
			match(NEWLINE);
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				content();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(70);
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
			setState(72);
			cotation();
			setState(73);
			cotationType();
			setState(74);
			match(NEWLINE);
			setState(75);
			match(T__3);
			setState(76);
			type();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(77);
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
			setState(80);
			match(T__4);
			setState(81);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18253611072L) != 0)) ) {
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
			setState(83);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
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
			setState(85);
			option();
			setState(86);
			match(NEWLINE);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				option();
				setState(88);
				match(NEWLINE);
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 288836550656L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 288836550656L) != 0) );
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					match(T__9);
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288836550656L) != 0)) {
						{
						setState(100);
						text();
						}
					}

					setState(103);
					match(T__10);
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 288836550656L) != 0)) {
					{
					setState(108);
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
		enterRule(_localctx, 12, RULE_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__9);
			setState(114);
			_la = _input.LA(1);
			if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(115);
			match(T__10);
			setState(116);
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
		enterRule(_localctx, 14, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TEXT);
			setState(119);
			match(T__11);
			setState(120);
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
	public static class QuestionContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__12);
			setState(123);
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
	public static class TypeContext extends ParserRuleContext {
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public Short_text_answerContext short_text_answer() {
			return getRuleContext(Short_text_answerContext.class,0);
		}
		public Integer_numberContext integer_number() {
			return getRuleContext(Integer_numberContext.class,0);
		}
		public Decimal_numberContext decimal_number() {
			return getRuleContext(Decimal_numberContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public Numeric_scaleContext numeric_scale() {
			return getRuleContext(Numeric_scaleContext.class,0);
		}
		public Single_answer_choiceContext single_answer_choice() {
			return getRuleContext(Single_answer_choiceContext.class,0);
		}
		public Multiple_answer_choiceContext multiple_answer_choice() {
			return getRuleContext(Multiple_answer_choiceContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE_FALSE_QUESTION:
				{
				setState(125);
				true_false();
				}
				break;
			case SHORT_TEXT_ANSWER_QUESTION:
				{
				setState(126);
				short_text_answer();
				}
				break;
			case INTEGER_NUMBER_QUESTION:
				{
				setState(127);
				integer_number();
				}
				break;
			case DECIMAL_NUMBER_QUESTION:
				{
				setState(128);
				decimal_number();
				}
				break;
			case DATE_QUESTION:
				{
				setState(129);
				date();
				}
				break;
			case TIME_QUESTION:
				{
				setState(130);
				time();
				}
				break;
			case NUMERIC_SCALE_QUESTION:
				{
				setState(131);
				numeric_scale();
				}
				break;
			case SINGLE_ANSWER_CHOICE_QUESTION:
				{
				setState(132);
				single_answer_choice();
				}
				break;
			case MULTIPLE_ANSWER_CHOICE_QUESTION:
				{
				setState(133);
				multiple_answer_choice();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class True_falseContext extends ParserRuleContext {
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewAnswersParser.TRUE_FALSE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public True_false_answerContext true_false_answer() {
			return getRuleContext(True_false_answerContext.class,0);
		}
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitTrue_false(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitTrue_false(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_true_false);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(TRUE_FALSE_QUESTION);
			setState(137);
			match(NEWLINE);
			setState(138);
			question();
			setState(139);
			match(NEWLINE);
			setState(140);
			true_false_answer();
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
	public static class Short_text_answerContext extends ParserRuleContext {
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(InterviewAnswersParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Text_answerContext text_answer() {
			return getRuleContext(Text_answerContext.class,0);
		}
		public Short_text_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_text_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterShort_text_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitShort_text_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitShort_text_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_text_answerContext short_text_answer() throws RecognitionException {
		Short_text_answerContext _localctx = new Short_text_answerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_short_text_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(SHORT_TEXT_ANSWER_QUESTION);
			setState(143);
			match(NEWLINE);
			setState(144);
			question();
			setState(145);
			match(NEWLINE);
			setState(146);
			text_answer();
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
	public static class Single_answer_choiceContext extends ParserRuleContext {
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewAnswersParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public Single_answer_choice_answerContext single_answer_choice_answer() {
			return getRuleContext(Single_answer_choice_answerContext.class,0);
		}
		public Single_answer_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_answer_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterSingle_answer_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitSingle_answer_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitSingle_answer_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_answer_choiceContext single_answer_choice() throws RecognitionException {
		Single_answer_choiceContext _localctx = new Single_answer_choiceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_single_answer_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(SINGLE_ANSWER_CHOICE_QUESTION);
			setState(149);
			match(NEWLINE);
			setState(150);
			question();
			setState(151);
			match(NEWLINE);
			setState(152);
			choice();
			setState(153);
			single_answer_choice_answer();
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
	public static class Multiple_answer_choiceContext extends ParserRuleContext {
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewAnswersParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public Multiple_answer_choice_answerContext multiple_answer_choice_answer() {
			return getRuleContext(Multiple_answer_choice_answerContext.class,0);
		}
		public Multiple_answer_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_answer_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterMultiple_answer_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitMultiple_answer_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitMultiple_answer_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_answer_choiceContext multiple_answer_choice() throws RecognitionException {
		Multiple_answer_choiceContext _localctx = new Multiple_answer_choiceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiple_answer_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(MULTIPLE_ANSWER_CHOICE_QUESTION);
			setState(156);
			match(NEWLINE);
			setState(157);
			question();
			setState(158);
			match(NEWLINE);
			setState(159);
			choice();
			setState(160);
			multiple_answer_choice_answer();
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
	public static class Integer_numberContext extends ParserRuleContext {
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(InterviewAnswersParser.INTEGER_NUMBER_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Integer_answerContext integer_answer() {
			return getRuleContext(Integer_answerContext.class,0);
		}
		public Integer_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterInteger_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitInteger_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitInteger_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_numberContext integer_number() throws RecognitionException {
		Integer_numberContext _localctx = new Integer_numberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_integer_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(INTEGER_NUMBER_QUESTION);
			setState(163);
			match(NEWLINE);
			setState(164);
			question();
			setState(165);
			match(NEWLINE);
			setState(166);
			integer_answer();
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
	public static class Decimal_numberContext extends ParserRuleContext {
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(InterviewAnswersParser.DECIMAL_NUMBER_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Decimal_answerContext decimal_answer() {
			return getRuleContext(Decimal_answerContext.class,0);
		}
		public Decimal_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterDecimal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitDecimal_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitDecimal_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_numberContext decimal_number() throws RecognitionException {
		Decimal_numberContext _localctx = new Decimal_numberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_decimal_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(DECIMAL_NUMBER_QUESTION);
			setState(169);
			match(NEWLINE);
			setState(170);
			question();
			setState(171);
			match(NEWLINE);
			setState(172);
			decimal_answer();
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE_QUESTION() { return getToken(InterviewAnswersParser.DATE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Date_answerContext date_answer() {
			return getRuleContext(Date_answerContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(DATE_QUESTION);
			setState(175);
			match(NEWLINE);
			setState(176);
			question();
			setState(177);
			match(NEWLINE);
			setState(178);
			date_answer();
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
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode TIME_QUESTION() { return getToken(InterviewAnswersParser.TIME_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Time_answerContext time_answer() {
			return getRuleContext(Time_answerContext.class,0);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_time);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(TIME_QUESTION);
			setState(181);
			match(NEWLINE);
			setState(182);
			question();
			setState(183);
			match(NEWLINE);
			setState(184);
			time_answer();
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
	public static class Numeric_scaleContext extends ParserRuleContext {
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewAnswersParser.NUMERIC_SCALE_QUESTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(InterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(InterviewAnswersParser.NEWLINE, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Numeric_scale_answerContext numeric_scale_answer() {
			return getRuleContext(Numeric_scale_answerContext.class,0);
		}
		public Numeric_scaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_scale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterNumeric_scale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitNumeric_scale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitNumeric_scale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_scaleContext numeric_scale() throws RecognitionException {
		Numeric_scaleContext _localctx = new Numeric_scaleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_numeric_scale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(NUMERIC_SCALE_QUESTION);
			setState(187);
			match(NEWLINE);
			setState(188);
			question();
			setState(189);
			match(NEWLINE);
			setState(190);
			numeric_scale_answer();
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
	public static class True_false_answerContext extends ParserRuleContext {
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitTrue_false_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitTrue_false_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_true_false_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__13);
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) ) {
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
	public static class Text_answerContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public Text_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterText_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitText_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitText_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Text_answerContext text_answer() throws RecognitionException {
		Text_answerContext _localctx = new Text_answerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_text_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__13);
			setState(196);
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
	public static class Integer_answerContext extends ParserRuleContext {
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public Integer_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterInteger_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitInteger_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitInteger_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_answerContext integer_answer() throws RecognitionException {
		Integer_answerContext _localctx = new Integer_answerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_integer_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__13);
			setState(199);
			match(TWO_DIGIT_NUMBER);
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
	public static class Decimal_answerContext extends ParserRuleContext {
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewAnswersParser.FRACTIONAL_NUMBER, 0); }
		public Decimal_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterDecimal_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitDecimal_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitDecimal_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_answerContext decimal_answer() throws RecognitionException {
		Decimal_answerContext _localctx = new Decimal_answerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_decimal_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__13);
			setState(202);
			match(FRACTIONAL_NUMBER);
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
	public static class Date_answerContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(InterviewAnswersParser.DATE, 0); }
		public Date_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterDate_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitDate_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitDate_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_answerContext date_answer() throws RecognitionException {
		Date_answerContext _localctx = new Date_answerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_date_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__13);
			setState(205);
			match(DATE);
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
	public static class Time_answerContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(InterviewAnswersParser.TIME, 0); }
		public Time_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterTime_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitTime_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitTime_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_answerContext time_answer() throws RecognitionException {
		Time_answerContext _localctx = new Time_answerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_time_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__13);
			setState(208);
			match(TIME);
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
	public static class Numeric_scale_answerContext extends ParserRuleContext {
		public TerminalNode NUMERIC_SCALE() { return getToken(InterviewAnswersParser.NUMERIC_SCALE, 0); }
		public Numeric_scale_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_scale_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterNumeric_scale_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitNumeric_scale_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitNumeric_scale_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_scale_answerContext numeric_scale_answer() throws RecognitionException {
		Numeric_scale_answerContext _localctx = new Numeric_scale_answerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numeric_scale_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__13);
			setState(211);
			match(NUMERIC_SCALE);
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
	public static class Single_answer_choice_answerContext extends ParserRuleContext {
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode LETTER() { return getToken(InterviewAnswersParser.LETTER, 0); }
		public Single_answer_choice_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_answer_choice_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterSingle_answer_choice_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitSingle_answer_choice_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitSingle_answer_choice_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_answer_choice_answerContext single_answer_choice_answer() throws RecognitionException {
		Single_answer_choice_answerContext _localctx = new Single_answer_choice_answerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_single_answer_choice_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__13);
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
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
	public static class Multiple_answer_choice_answerContext extends ParserRuleContext {
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(InterviewAnswersParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(InterviewAnswersParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewAnswersParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewAnswersParser.LETTER, i);
		}
		public Multiple_answer_choice_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_answer_choice_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).enterMultiple_answer_choice_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewAnswersListener ) ((InterviewAnswersListener)listener).exitMultiple_answer_choice_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewAnswersVisitor ) return ((InterviewAnswersVisitor<? extends T>)visitor).visitMultiple_answer_choice_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_answer_choice_answerContext multiple_answer_choice_answer() throws RecognitionException {
		Multiple_answer_choice_answerContext _localctx = new Multiple_answer_choice_answerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiple_answer_choice_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__13);
			setState(218); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(220); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TWO_DIGIT_NUMBER || _la==LETTER );
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
		"\u0004\u0001(\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000C\b\u0000"+
		"\u000b\u0000\f\u0000D\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001O\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004[\b\u0004"+
		"\u000b\u0004\f\u0004\\\u0001\u0005\u0004\u0005`\b\u0005\u000b\u0005\f"+
		"\u0005a\u0001\u0005\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005\u0004"+
		"\u0005i\b\u0005\u000b\u0005\f\u0005j\u0001\u0005\u0003\u0005n\b\u0005"+
		"\u0003\u0005p\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0087\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0004"+
		"\u001b\u00db\b\u001b\u000b\u001b\f\u001b\u00dc\u0001\u001b\u0000\u0000"+
		"\u001c\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.0246\u0000\u0005\u0003\u0000\u0006\u0006\u001e"+
		"\u001e\"\"\u0001\u0000\u0007\t\u0003\u0000\u001e\u001e !&&\u0002\u0000"+
		"\u001e\u001e  \u0001\u0000\u000f\u0014\u00d3\u00008\u0001\u0000\u0000"+
		"\u0000\u0002H\u0001\u0000\u0000\u0000\u0004P\u0001\u0000\u0000\u0000\u0006"+
		"S\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000"+
		"\u0000\fq\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010"+
		"z\u0001\u0000\u0000\u0000\u0012\u0086\u0001\u0000\u0000\u0000\u0014\u0088"+
		"\u0001\u0000\u0000\u0000\u0016\u008e\u0001\u0000\u0000\u0000\u0018\u0094"+
		"\u0001\u0000\u0000\u0000\u001a\u009b\u0001\u0000\u0000\u0000\u001c\u00a2"+
		"\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000 \u00ae\u0001"+
		"\u0000\u0000\u0000\"\u00b4\u0001\u0000\u0000\u0000$\u00ba\u0001\u0000"+
		"\u0000\u0000&\u00c0\u0001\u0000\u0000\u0000(\u00c3\u0001\u0000\u0000\u0000"+
		"*\u00c6\u0001\u0000\u0000\u0000,\u00c9\u0001\u0000\u0000\u0000.\u00cc"+
		"\u0001\u0000\u0000\u00000\u00cf\u0001\u0000\u0000\u00002\u00d2\u0001\u0000"+
		"\u0000\u00004\u00d5\u0001\u0000\u0000\u00006\u00d8\u0001\u0000\u0000\u0000"+
		"89\u0005\u0001\u0000\u00009:\u0003\n\u0005\u0000:;\u0005\'\u0000\u0000"+
		";<\u0005\u0002\u0000\u0000<=\u0003\n\u0005\u0000=>\u0005\'\u0000\u0000"+
		">?\u0005\u0003\u0000\u0000?@\u0003\u000e\u0007\u0000@B\u0005\'\u0000\u0000"+
		"AC\u0003\u0002\u0001\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0000\u0000\u0001G\u0001\u0001\u0000\u0000\u0000"+
		"HI\u0003\u0004\u0002\u0000IJ\u0003\u0006\u0003\u0000JK\u0005\'\u0000\u0000"+
		"KL\u0005\u0004\u0000\u0000LN\u0003\u0012\t\u0000MO\u0005\'\u0000\u0000"+
		"NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0003\u0001\u0000"+
		"\u0000\u0000PQ\u0005\u0005\u0000\u0000QR\u0007\u0000\u0000\u0000R\u0005"+
		"\u0001\u0000\u0000\u0000ST\u0007\u0001\u0000\u0000T\u0007\u0001\u0000"+
		"\u0000\u0000UV\u0003\f\u0006\u0000VZ\u0005\'\u0000\u0000WX\u0003\f\u0006"+
		"\u0000XY\u0005\'\u0000\u0000Y[\u0001\u0000\u0000\u0000ZW\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^`\u0007\u0002\u0000\u0000"+
		"_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bo\u0001\u0000\u0000\u0000ce\u0005\n\u0000"+
		"\u0000df\u0003\n\u0005\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gi\u0005\u000b\u0000\u0000hc\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000km\u0001\u0000\u0000\u0000ln\u0003\n\u0005\u0000ml\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"oh\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u000b\u0001\u0000"+
		"\u0000\u0000qr\u0005\n\u0000\u0000rs\u0007\u0003\u0000\u0000st\u0005\u000b"+
		"\u0000\u0000tu\u0003\n\u0005\u0000u\r\u0001\u0000\u0000\u0000vw\u0005"+
		"&\u0000\u0000wx\u0005\f\u0000\u0000xy\u0005&\u0000\u0000y\u000f\u0001"+
		"\u0000\u0000\u0000z{\u0005\r\u0000\u0000{|\u0003\n\u0005\u0000|\u0011"+
		"\u0001\u0000\u0000\u0000}\u0087\u0003\u0014\n\u0000~\u0087\u0003\u0016"+
		"\u000b\u0000\u007f\u0087\u0003\u001c\u000e\u0000\u0080\u0087\u0003\u001e"+
		"\u000f\u0000\u0081\u0087\u0003 \u0010\u0000\u0082\u0087\u0003\"\u0011"+
		"\u0000\u0083\u0087\u0003$\u0012\u0000\u0084\u0087\u0003\u0018\f\u0000"+
		"\u0085\u0087\u0003\u001a\r\u0000\u0086}\u0001\u0000\u0000\u0000\u0086"+
		"~\u0001\u0000\u0000\u0000\u0086\u007f\u0001\u0000\u0000\u0000\u0086\u0080"+
		"\u0001\u0000\u0000\u0000\u0086\u0081\u0001\u0000\u0000\u0000\u0086\u0082"+
		"\u0001\u0000\u0000\u0000\u0086\u0083\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0013"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0015\u0000\u0000\u0089\u008a"+
		"\u0005\'\u0000\u0000\u008a\u008b\u0003\u0010\b\u0000\u008b\u008c\u0005"+
		"\'\u0000\u0000\u008c\u008d\u0003&\u0013\u0000\u008d\u0015\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f\u0090\u0005\'\u0000"+
		"\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0092\u0005\'\u0000\u0000"+
		"\u0092\u0093\u0003(\u0014\u0000\u0093\u0017\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u0017\u0000\u0000\u0095\u0096\u0005\'\u0000\u0000\u0096\u0097"+
		"\u0003\u0010\b\u0000\u0097\u0098\u0005\'\u0000\u0000\u0098\u0099\u0003"+
		"\b\u0004\u0000\u0099\u009a\u00034\u001a\u0000\u009a\u0019\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005\u0018\u0000\u0000\u009c\u009d\u0005\'\u0000"+
		"\u0000\u009d\u009e\u0003\u0010\b\u0000\u009e\u009f\u0005\'\u0000\u0000"+
		"\u009f\u00a0\u0003\b\u0004\u0000\u00a0\u00a1\u00036\u001b\u0000\u00a1"+
		"\u001b\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0019\u0000\u0000\u00a3"+
		"\u00a4\u0005\'\u0000\u0000\u00a4\u00a5\u0003\u0010\b\u0000\u00a5\u00a6"+
		"\u0005\'\u0000\u0000\u00a6\u00a7\u0003*\u0015\u0000\u00a7\u001d\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0005\u001a\u0000\u0000\u00a9\u00aa\u0005"+
		"\'\u0000\u0000\u00aa\u00ab\u0003\u0010\b\u0000\u00ab\u00ac\u0005\'\u0000"+
		"\u0000\u00ac\u00ad\u0003,\u0016\u0000\u00ad\u001f\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005\u001b\u0000\u0000\u00af\u00b0\u0005\'\u0000\u0000\u00b0"+
		"\u00b1\u0003\u0010\b\u0000\u00b1\u00b2\u0005\'\u0000\u0000\u00b2\u00b3"+
		"\u0003.\u0017\u0000\u00b3!\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u001c"+
		"\u0000\u0000\u00b5\u00b6\u0005\'\u0000\u0000\u00b6\u00b7\u0003\u0010\b"+
		"\u0000\u00b7\u00b8\u0005\'\u0000\u0000\u00b8\u00b9\u00030\u0018\u0000"+
		"\u00b9#\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u001d\u0000\u0000\u00bb"+
		"\u00bc\u0005\'\u0000\u0000\u00bc\u00bd\u0003\u0010\b\u0000\u00bd\u00be"+
		"\u0005\'\u0000\u0000\u00be\u00bf\u00032\u0019\u0000\u00bf%\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005\u000e\u0000\u0000\u00c1\u00c2\u0007\u0004"+
		"\u0000\u0000\u00c2\'\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\u000e\u0000"+
		"\u0000\u00c4\u00c5\u0003\n\u0005\u0000\u00c5)\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\u000e\u0000\u0000\u00c7\u00c8\u0005\u001e\u0000\u0000"+
		"\u00c8+\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u000e\u0000\u0000\u00ca"+
		"\u00cb\u0005\"\u0000\u0000\u00cb-\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0005\u000e\u0000\u0000\u00cd\u00ce\u0005$\u0000\u0000\u00ce/\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0005\u000e\u0000\u0000\u00d0\u00d1\u0005%\u0000"+
		"\u0000\u00d11\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u000e\u0000\u0000"+
		"\u00d3\u00d4\u0005#\u0000\u0000\u00d43\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0005\u000e\u0000\u0000\u00d6\u00d7\u0007\u0003\u0000\u0000\u00d75\u0001"+
		"\u0000\u0000\u0000\u00d8\u00da\u0005\u000e\u0000\u0000\u00d9\u00db\u0007"+
		"\u0003\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001"+
		"\u0000\u0000\u0000\u00dd7\u0001\u0000\u0000\u0000\nDN\\aejmo\u0086\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}