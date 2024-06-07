package lapr4.jobs4u.importer.interview.template.xml.generated;
// Generated from InterviewXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewXmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, TRUE_FALSE_QUESTION=27, SHORT_TEXT_ANSWER_QUESTION=28, 
		SINGLE_ANSWER_CHOICE_QUESTION=29, MULTIPLE_ANSWER_CHOICE_QUESTION=30, 
		INTEGER_NUMBER_QUESTION=31, DECIMAL_NUMBER_QUESTION=32, DATE_QUESTION=33, 
		TIME_QUESTION=34, NUMERIC_SCALE_QUESTION=35, TWO_DIGIT_NUMBER=36, NUMBER=37, 
		LETTER=38, MEMBER=39, FRACTIONAL_NUMBER=40, TEXT=41, WS=42;
	public static final int
		RULE_questions = 0, RULE_text = 1, RULE_question = 2, RULE_cotation = 3, 
		RULE_cotationType = 4, RULE_type = 5, RULE_body = 6, RULE_questionCotation = 7, 
		RULE_answerCotation = 8, RULE_possibleAnswersList = 9, RULE_possibleAnswers = 10, 
		RULE_answer = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"questions", "text", "question", "cotation", "cotationType", "type", 
			"body", "questionCotation", "answerCotation", "possibleAnswersList", 
			"possibleAnswers", "answer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<Questions>'", "'</Questions>'", "'<Question>'", "'</Question>'", 
			"'<Cotation>'", "'100'", "'</Cotation>'", "'<CotationType>'", "'%'", 
			"'POINTS'", "'VALUES'", "'</CotationType>'", "'<Type>'", "'</Type>'", 
			"'<Body>'", "'<'", "'/'", "'>'", "'</'", "'</Body>'", "'<PossibleAnswersList>'", 
			"'</PossibleAnswersList>'", "'<PossibleAnswers>'", "'</PossibleAnswers>'", 
			"'<Answer>'", "'</Answer>'", "'True/False'", "'Short text answer'", "'Choice, with single answer'", 
			"'Choice, with multiple answers'", "'Integer Number'", "'Decimal Number'", 
			"'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", 
			"SINGLE_ANSWER_CHOICE_QUESTION", "MULTIPLE_ANSWER_CHOICE_QUESTION", "INTEGER_NUMBER_QUESTION", 
			"DECIMAL_NUMBER_QUESTION", "DATE_QUESTION", "TIME_QUESTION", "NUMERIC_SCALE_QUESTION", 
			"TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "FRACTIONAL_NUMBER", 
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

	@Override
	public String getGrammarFileName() { return "InterviewXml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewXmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(InterviewXmlParser.EOF, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public QuestionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitQuestions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionsContext questions() throws RecognitionException {
		QuestionsContext _localctx = new QuestionsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				question();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(30);
			match(T__1);
			setState(31);
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
	public static class TextContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(InterviewXmlParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(InterviewXmlParser.TEXT, i);
		}
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(InterviewXmlParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(InterviewXmlParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewXmlParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewXmlParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(InterviewXmlParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(InterviewXmlParser.MEMBER, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3092376453120L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3092376453120L) != 0) );
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
		public QuestionCotationContext questionCotation() {
			return getRuleContext(QuestionCotationContext.class,0);
		}
		public CotationTypeContext cotationType() {
			return getRuleContext(CotationTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public PossibleAnswersListContext possibleAnswersList() {
			return getRuleContext(PossibleAnswersListContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__2);
			setState(39);
			questionCotation();
			setState(40);
			cotationType();
			setState(41);
			type();
			setState(42);
			body();
			setState(43);
			possibleAnswersList();
			setState(44);
			match(T__3);
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
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewXmlParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewXmlParser.FRACTIONAL_NUMBER, 0); }
		public CotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitCotation(this);
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
			setState(46);
			match(T__4);
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1168231104576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(48);
			match(T__6);
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
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterCotationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitCotationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitCotationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationTypeContext cotationType() throws RecognitionException {
		CotationTypeContext _localctx = new CotationTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cotationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__7);
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(52);
			match(T__11);
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
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewXmlParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(InterviewXmlParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewXmlParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewXmlParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(InterviewXmlParser.INTEGER_NUMBER_QUESTION, 0); }
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(InterviewXmlParser.DECIMAL_NUMBER_QUESTION, 0); }
		public TerminalNode DATE_QUESTION() { return getToken(InterviewXmlParser.DATE_QUESTION, 0); }
		public TerminalNode TIME_QUESTION() { return getToken(InterviewXmlParser.TIME_QUESTION, 0); }
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewXmlParser.NUMERIC_SCALE_QUESTION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__12);
			setState(55);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68585259008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(56);
			match(T__13);
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
	public static class BodyContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__14);
			setState(59);
			text();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) {
				{
				setState(60);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(61);
				text();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) {
					{
					setState(62);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(63);
					text();
					}
				}

				}
			}

			setState(68);
			match(T__19);
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
	public static class QuestionCotationContext extends ParserRuleContext {
		public CotationContext cotation() {
			return getRuleContext(CotationContext.class,0);
		}
		public QuestionCotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionCotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterQuestionCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitQuestionCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitQuestionCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionCotationContext questionCotation() throws RecognitionException {
		QuestionCotationContext _localctx = new QuestionCotationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_questionCotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			cotation();
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
	public static class AnswerCotationContext extends ParserRuleContext {
		public CotationContext cotation() {
			return getRuleContext(CotationContext.class,0);
		}
		public AnswerCotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerCotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterAnswerCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitAnswerCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitAnswerCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerCotationContext answerCotation() throws RecognitionException {
		AnswerCotationContext _localctx = new AnswerCotationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_answerCotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			cotation();
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
	public static class PossibleAnswersListContext extends ParserRuleContext {
		public List<PossibleAnswersContext> possibleAnswers() {
			return getRuleContexts(PossibleAnswersContext.class);
		}
		public PossibleAnswersContext possibleAnswers(int i) {
			return getRuleContext(PossibleAnswersContext.class,i);
		}
		public PossibleAnswersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleAnswersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterPossibleAnswersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitPossibleAnswersList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitPossibleAnswersList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswersListContext possibleAnswersList() throws RecognitionException {
		PossibleAnswersListContext _localctx = new PossibleAnswersListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_possibleAnswersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__20);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(75);
				possibleAnswers();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(T__21);
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
	public static class PossibleAnswersContext extends ParserRuleContext {
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public AnswerCotationContext answerCotation() {
			return getRuleContext(AnswerCotationContext.class,0);
		}
		public PossibleAnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleAnswers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterPossibleAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitPossibleAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitPossibleAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswersContext possibleAnswers() throws RecognitionException {
		PossibleAnswersContext _localctx = new PossibleAnswersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_possibleAnswers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__22);
			setState(84);
			answer();
			setState(85);
			answerCotation();
			setState(86);
			match(T__23);
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
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewXmlListener ) ((InterviewXmlListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewXmlVisitor ) return ((InterviewXmlVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__24);
			setState(89);
			text();
			setState(90);
			match(T__25);
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
		"\u0004\u0001*]\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001\u0000"+
		"\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000\u001c\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001#\b\u0001\u000b"+
		"\u0001\f\u0001$\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006A\b\u0006\u0003"+
		"\u0006C\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0005\tM\b\t\n\t\f\tP\t\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0000\u0005\u0003\u0000$$&\'))\u0003\u0000\u0006"+
		"\u0006$$((\u0001\u0000\t\u000b\u0001\u0000\u001b#\u0001\u0000\u0010\u0013"+
		"U\u0000\u0018\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000"+
		"\u0004&\u0001\u0000\u0000\u0000\u0006.\u0001\u0000\u0000\u0000\b2\u0001"+
		"\u0000\u0000\u0000\n6\u0001\u0000\u0000\u0000\f:\u0001\u0000\u0000\u0000"+
		"\u000eF\u0001\u0000\u0000\u0000\u0010H\u0001\u0000\u0000\u0000\u0012J"+
		"\u0001\u0000\u0000\u0000\u0014S\u0001\u0000\u0000\u0000\u0016X\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0005\u0001\u0000\u0000\u0019\u001b\u0003\u0004"+
		"\u0002\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0002"+
		"\u0000\u0000\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000\u0000\u0000"+
		"!#\u0007\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\u0003\u0001"+
		"\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0003\u000e\u0007\u0000"+
		"()\u0003\b\u0004\u0000)*\u0003\n\u0005\u0000*+\u0003\f\u0006\u0000+,\u0003"+
		"\u0012\t\u0000,-\u0005\u0004\u0000\u0000-\u0005\u0001\u0000\u0000\u0000"+
		"./\u0005\u0005\u0000\u0000/0\u0007\u0001\u0000\u000001\u0005\u0007\u0000"+
		"\u00001\u0007\u0001\u0000\u0000\u000023\u0005\b\u0000\u000034\u0007\u0002"+
		"\u0000\u000045\u0005\f\u0000\u00005\t\u0001\u0000\u0000\u000067\u0005"+
		"\r\u0000\u000078\u0007\u0003\u0000\u000089\u0005\u000e\u0000\u00009\u000b"+
		"\u0001\u0000\u0000\u0000:;\u0005\u000f\u0000\u0000;B\u0003\u0002\u0001"+
		"\u0000<=\u0007\u0004\u0000\u0000=@\u0003\u0002\u0001\u0000>?\u0007\u0004"+
		"\u0000\u0000?A\u0003\u0002\u0001\u0000@>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B<\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0005\u0014\u0000"+
		"\u0000E\r\u0001\u0000\u0000\u0000FG\u0003\u0006\u0003\u0000G\u000f\u0001"+
		"\u0000\u0000\u0000HI\u0003\u0006\u0003\u0000I\u0011\u0001\u0000\u0000"+
		"\u0000JN\u0005\u0015\u0000\u0000KM\u0003\u0014\n\u0000LK\u0001\u0000\u0000"+
		"\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0005"+
		"\u0016\u0000\u0000R\u0013\u0001\u0000\u0000\u0000ST\u0005\u0017\u0000"+
		"\u0000TU\u0003\u0016\u000b\u0000UV\u0003\u0010\b\u0000VW\u0005\u0018\u0000"+
		"\u0000W\u0015\u0001\u0000\u0000\u0000XY\u0005\u0019\u0000\u0000YZ\u0003"+
		"\u0002\u0001\u0000Z[\u0005\u001a\u0000\u0000[\u0017\u0001\u0000\u0000"+
		"\u0000\u0005\u001c$@BN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}