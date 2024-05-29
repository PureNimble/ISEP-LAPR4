package lapr4.jobs4u.exporter.interview.answer.generated;
// Generated from EvaluateInterviewAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EvaluateInterviewAnswersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, TRUE_FALSE_QUESTION=17, 
		SHORT_TEXT_ANSWER_QUESTION=18, SINGLE_ANSWER_CHOICE_QUESTION=19, MULTIPLE_ANSWER_CHOICE_QUESTION=20, 
		INTEGER_NUMBER_QUESTION=21, DECIMAL_NUMBER_QUESTION=22, DATE_QUESTION=23, 
		TIME_QUESTION=24, NUMERIC_SCALE_QUESTION=25, TWO_DIGIT_NUMBER=26, NUMBER=27, 
		LETTER=28, MEMBER=29, FRACTIONAL_NUMBER=30, TEXT=31, NEWLINE=32, WS=33;
	public static final int
		RULE_start = 0, RULE_content = 1, RULE_cotationType = 2, RULE_cotation = 3, 
		RULE_choice = 4, RULE_text = 5, RULE_answer = 6, RULE_option = 7, RULE_email = 8, 
		RULE_type = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "content", "cotationType", "cotation", "choice", "text", "answer", 
			"option", "email", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'FINAL GRADE:'", "'COTATION:'", 
			"'QUESTION TYPE:'", "'ANSWER:'", "'GRADE:'", "'%'", "'POINTS'", "'VALUES'", 
			"'100'", "'['", "']'", "'@'", "'QUESTION:'", "'True/False'", "'Short text answer'", 
			"'Choice, with single answer'", "'Choice, with multiple answers'", "'Integer Number'", 
			"'Decimal Number'", "'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", 
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
	public String getGrammarFileName() { return "EvaluateInterviewAnswers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EvaluateInterviewAnswersParser(TokenStream input) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateInterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateInterviewAnswersParser.NEWLINE, i);
		}
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public CotationContext cotation() {
			return getRuleContext(CotationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EvaluateInterviewAnswersParser.EOF, 0); }
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
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitStart(this);
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
			setState(29);
			match(T__3);
			setState(30);
			cotation();
			setState(31);
			match(NEWLINE);
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				content();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(37);
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
		public List<CotationContext> cotation() {
			return getRuleContexts(CotationContext.class);
		}
		public CotationContext cotation(int i) {
			return getRuleContext(CotationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateInterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateInterviewAnswersParser.NEWLINE, i);
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
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitContent(this);
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
			setState(39);
			match(T__4);
			setState(40);
			cotation();
			setState(41);
			match(NEWLINE);
			setState(42);
			match(T__5);
			setState(43);
			type();
			setState(44);
			match(T__6);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3019898880L) != 0)) {
				{
				setState(45);
				answer();
				}
			}

			setState(48);
			match(NEWLINE);
			setState(49);
			match(T__7);
			setState(50);
			cotation();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(51);
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
	public static class CotationTypeContext extends ParserRuleContext {
		public CotationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotationType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterCotationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitCotationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitCotationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationTypeContext cotationType() throws RecognitionException {
		CotationTypeContext _localctx = new CotationTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cotationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
	public static class CotationContext extends ParserRuleContext {
		public CotationTypeContext cotationType() {
			return getRuleContext(CotationTypeContext.class,0);
		}
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(EvaluateInterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(EvaluateInterviewAnswersParser.FRACTIONAL_NUMBER, 0); }
		public CotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationContext cotation() throws RecognitionException {
		CotationContext _localctx = new CotationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1140854784L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(57);
			cotationType();
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
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateInterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateInterviewAnswersParser.NEWLINE, i);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitChoice(this);
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
			setState(59);
			option();
			setState(60);
			match(NEWLINE);
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				option();
				setState(62);
				match(NEWLINE);
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
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
		public List<TerminalNode> TEXT() { return getTokens(EvaluateInterviewAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(EvaluateInterviewAnswersParser.TEXT, i);
		}
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(EvaluateInterviewAnswersParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(EvaluateInterviewAnswersParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(EvaluateInterviewAnswersParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(EvaluateInterviewAnswersParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(EvaluateInterviewAnswersParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(EvaluateInterviewAnswersParser.MEMBER, i);
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
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitText(this);
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
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3019898880L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3019898880L) != 0) );
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(73);
					match(T__12);
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3019898880L) != 0)) {
						{
						setState(74);
						text();
						}
					}

					setState(77);
					match(T__13);
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__12 );
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3019898880L) != 0)) {
					{
					setState(82);
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
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
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
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(EvaluateInterviewAnswersParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode LETTER() { return getToken(EvaluateInterviewAnswersParser.LETTER, 0); }
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitOption(this);
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
			setState(89);
			match(T__12);
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==TWO_DIGIT_NUMBER || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(91);
			match(T__13);
			setState(92);
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
		public List<TerminalNode> TEXT() { return getTokens(EvaluateInterviewAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(EvaluateInterviewAnswersParser.TEXT, i);
		}
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(TEXT);
			setState(95);
			match(T__14);
			setState(96);
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
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateInterviewAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateInterviewAnswersParser.NEWLINE, i);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(EvaluateInterviewAnswersParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(EvaluateInterviewAnswersParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(EvaluateInterviewAnswersParser.INTEGER_NUMBER_QUESTION, 0); }
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(EvaluateInterviewAnswersParser.DECIMAL_NUMBER_QUESTION, 0); }
		public TerminalNode DATE_QUESTION() { return getToken(EvaluateInterviewAnswersParser.DATE_QUESTION, 0); }
		public TerminalNode TIME_QUESTION() { return getToken(EvaluateInterviewAnswersParser.TIME_QUESTION, 0); }
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(EvaluateInterviewAnswersParser.NUMERIC_SCALE_QUESTION, 0); }
		public ChoiceContext choice() {
			return getRuleContext(ChoiceContext.class,0);
		}
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(EvaluateInterviewAnswersParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(EvaluateInterviewAnswersParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateInterviewAnswersListener ) ((EvaluateInterviewAnswersListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateInterviewAnswersVisitor ) return ((EvaluateInterviewAnswersVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			setState(111);
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
				setState(98);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65404928L) != 0)) ) {
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
				match(T__15);
				setState(101);
				text();
				setState(102);
				match(NEWLINE);
				}
				}
				break;
			case SINGLE_ANSWER_CHOICE_QUESTION:
			case MULTIPLE_ANSWER_CHOICE_QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(104);
				_la = _input.LA(1);
				if ( !(_la==SINGLE_ANSWER_CHOICE_QUESTION || _la==MULTIPLE_ANSWER_CHOICE_QUESTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(105);
				match(NEWLINE);
				setState(106);
				match(T__15);
				setState(107);
				text();
				setState(108);
				match(NEWLINE);
				setState(109);
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
		"\u0004\u0001!r\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000"+
		"#\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004A\b\u0004\u000b\u0004"+
		"\f\u0004B\u0001\u0005\u0004\u0005F\b\u0005\u000b\u0005\f\u0005G\u0001"+
		"\u0005\u0001\u0005\u0003\u0005L\b\u0005\u0001\u0005\u0004\u0005O\b\u0005"+
		"\u000b\u0005\f\u0005P\u0001\u0005\u0003\u0005T\b\u0005\u0003\u0005V\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\tp\b\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0006\u0001\u0000\t\u000b\u0003\u0000\f"+
		"\f\u001a\u001a\u001e\u001e\u0003\u0000\u001a\u001a\u001c\u001d\u001f\u001f"+
		"\u0002\u0000\u001a\u001a\u001c\u001c\u0002\u0000\u0011\u0012\u0015\u0019"+
		"\u0001\u0000\u0013\u0014q\u0000\u0014\u0001\u0000\u0000\u0000\u0002\'"+
		"\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u00068\u0001\u0000"+
		"\u0000\u0000\b;\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000\fW"+
		"\u0001\u0000\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010^\u0001\u0000"+
		"\u0000\u0000\u0012o\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0001\u0000"+
		"\u0000\u0015\u0016\u0003\n\u0005\u0000\u0016\u0017\u0005 \u0000\u0000"+
		"\u0017\u0018\u0005\u0002\u0000\u0000\u0018\u0019\u0003\n\u0005\u0000\u0019"+
		"\u001a\u0005 \u0000\u0000\u001a\u001b\u0005\u0003\u0000\u0000\u001b\u001c"+
		"\u0003\u0010\b\u0000\u001c\u001d\u0005 \u0000\u0000\u001d\u001e\u0005"+
		"\u0004\u0000\u0000\u001e\u001f\u0003\u0006\u0003\u0000\u001f!\u0005 \u0000"+
		"\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u0005\u0000\u0000()\u0003\u0006\u0003\u0000)*\u0005 \u0000"+
		"\u0000*+\u0005\u0006\u0000\u0000+,\u0003\u0012\t\u0000,.\u0005\u0007\u0000"+
		"\u0000-/\u0003\f\u0006\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000001\u0005 \u0000\u000012\u0005\b\u0000"+
		"\u000024\u0003\u0006\u0003\u000035\u0005 \u0000\u000043\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u00005\u0003\u0001\u0000\u0000\u000067\u0007"+
		"\u0000\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0007\u0001\u0000"+
		"\u00009:\u0003\u0004\u0002\u0000:\u0007\u0001\u0000\u0000\u0000;<\u0003"+
		"\u000e\u0007\u0000<@\u0005 \u0000\u0000=>\u0003\u000e\u0007\u0000>?\u0005"+
		" \u0000\u0000?A\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"C\t\u0001\u0000\u0000\u0000DF\u0007\u0002\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HU\u0001\u0000\u0000\u0000IK\u0005\r\u0000\u0000JL\u0003\n"+
		"\u0005\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MO\u0005\u000e\u0000\u0000NI\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000QS\u0001\u0000\u0000\u0000RT\u0003\n\u0005\u0000SR\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000UN\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000V\u000b\u0001\u0000\u0000\u0000"+
		"WX\u0003\n\u0005\u0000X\r\u0001\u0000\u0000\u0000YZ\u0005\r\u0000\u0000"+
		"Z[\u0007\u0003\u0000\u0000[\\\u0005\u000e\u0000\u0000\\]\u0003\n\u0005"+
		"\u0000]\u000f\u0001\u0000\u0000\u0000^_\u0005\u001f\u0000\u0000_`\u0005"+
		"\u000f\u0000\u0000`a\u0005\u001f\u0000\u0000a\u0011\u0001\u0000\u0000"+
		"\u0000bc\u0007\u0004\u0000\u0000cd\u0005 \u0000\u0000de\u0005\u0010\u0000"+
		"\u0000ef\u0003\n\u0005\u0000fg\u0005 \u0000\u0000gp\u0001\u0000\u0000"+
		"\u0000hi\u0007\u0005\u0000\u0000ij\u0005 \u0000\u0000jk\u0005\u0010\u0000"+
		"\u0000kl\u0003\n\u0005\u0000lm\u0005 \u0000\u0000mn\u0003\b\u0004\u0000"+
		"np\u0001\u0000\u0000\u0000ob\u0001\u0000\u0000\u0000oh\u0001\u0000\u0000"+
		"\u0000p\u0013\u0001\u0000\u0000\u0000\n#.4BGKPSUo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}