package lapr4.jobs4u.importer.interview.template.csv.generated;
// Generated from InterviewCsv.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class InterviewCsvParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, TRUE_FALSE_QUESTION=7, 
		SHORT_TEXT_ANSWER_QUESTION=8, SINGLE_ANSWER_CHOICE_QUESTION=9, MULTIPLE_ANSWER_CHOICE_QUESTION=10, 
		INTEGER_NUMBER_QUESTION=11, DECIMAL_NUMBER_QUESTION=12, DATE_QUESTION=13, 
		TIME_QUESTION=14, NUMERIC_SCALE_QUESTION=15, TWO_DIGIT_NUMBER=16, NUMBER=17, 
		LETTER=18, MEMBER=19, FRACTIONAL_NUMBER=20, TEXT=21, NEWLINE=22, WS=23;
	public static final int
		RULE_questions = 0, RULE_body = 1, RULE_questionBody = 2, RULE_type = 3, 
		RULE_questionCotation = 4, RULE_answer = 5, RULE_answerCotation = 6, RULE_question = 7, 
		RULE_cotation = 8, RULE_cotationType = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"questions", "body", "questionBody", "type", "questionCotation", "answer", 
			"answerCotation", "question", "cotation", "cotationType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", "';'", "'100'", "'%'", "'POINTS'", "'VALUES'", "'True/False'", 
			"'Short text answer'", "'Choice, with single answer'", "'Choice, with multiple answers'", 
			"'Integer Number'", "'Decimal Number'", "'Date'", "'Time'", "'Numeric Scale'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "TRUE_FALSE_QUESTION", "SHORT_TEXT_ANSWER_QUESTION", 
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
	public String getGrammarFileName() { return "InterviewCsv.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterviewCsvParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(InterviewCsvParser.EOF, 0); }
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
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitQuestions(this);
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
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				question();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(25);
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
	public static class BodyContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(InterviewCsvParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(InterviewCsvParser.TEXT, i);
		}
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(InterviewCsvParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(InterviewCsvParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(InterviewCsvParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(InterviewCsvParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(InterviewCsvParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(InterviewCsvParser.MEMBER, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__0);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0) );
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(33);
				match(T__0);
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(34);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(37); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0) );
				setState(39);
				match(T__0);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0)) {
					{
					setState(41); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(40);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(43); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2949120L) != 0) );
					}
				}

				}
				break;
			}
			setState(49);
			match(T__0);
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
	public static class QuestionBodyContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public QuestionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterQuestionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitQuestionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitQuestionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionBodyContext questionBody() throws RecognitionException {
		QuestionBodyContext _localctx = new QuestionBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			body();
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
		public TerminalNode TRUE_FALSE_QUESTION() { return getToken(InterviewCsvParser.TRUE_FALSE_QUESTION, 0); }
		public TerminalNode SHORT_TEXT_ANSWER_QUESTION() { return getToken(InterviewCsvParser.SHORT_TEXT_ANSWER_QUESTION, 0); }
		public TerminalNode SINGLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewCsvParser.SINGLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode MULTIPLE_ANSWER_CHOICE_QUESTION() { return getToken(InterviewCsvParser.MULTIPLE_ANSWER_CHOICE_QUESTION, 0); }
		public TerminalNode INTEGER_NUMBER_QUESTION() { return getToken(InterviewCsvParser.INTEGER_NUMBER_QUESTION, 0); }
		public TerminalNode DECIMAL_NUMBER_QUESTION() { return getToken(InterviewCsvParser.DECIMAL_NUMBER_QUESTION, 0); }
		public TerminalNode DATE_QUESTION() { return getToken(InterviewCsvParser.DATE_QUESTION, 0); }
		public TerminalNode TIME_QUESTION() { return getToken(InterviewCsvParser.TIME_QUESTION, 0); }
		public TerminalNode NUMERIC_SCALE_QUESTION() { return getToken(InterviewCsvParser.NUMERIC_SCALE_QUESTION, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65408L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(55);
			match(T__0);
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
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterQuestionCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitQuestionCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitQuestionCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionCotationContext questionCotation() throws RecognitionException {
		QuestionCotationContext _localctx = new QuestionCotationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionCotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
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
	public static class AnswerContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			body();
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
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterAnswerCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitAnswerCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitAnswerCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerCotationContext answerCotation() throws RecognitionException {
		AnswerCotationContext _localctx = new AnswerCotationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_answerCotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
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
	public static class QuestionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QuestionCotationContext questionCotation() {
			return getRuleContext(QuestionCotationContext.class,0);
		}
		public CotationTypeContext cotationType() {
			return getRuleContext(CotationTypeContext.class,0);
		}
		public QuestionBodyContext questionBody() {
			return getRuleContext(QuestionBodyContext.class,0);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<AnswerCotationContext> answerCotation() {
			return getRuleContexts(AnswerCotationContext.class);
		}
		public AnswerCotationContext answerCotation(int i) {
			return getRuleContext(AnswerCotationContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(InterviewCsvParser.NEWLINE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			type();
			setState(64);
			match(T__1);
			setState(65);
			questionCotation();
			setState(66);
			match(T__1);
			setState(67);
			cotationType();
			setState(68);
			match(T__1);
			setState(69);
			questionBody();
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				match(T__1);
				setState(71);
				answer();
				setState(72);
				match(T__1);
				setState(73);
				answerCotation();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(79);
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
		public TerminalNode TWO_DIGIT_NUMBER() { return getToken(InterviewCsvParser.TWO_DIGIT_NUMBER, 0); }
		public TerminalNode FRACTIONAL_NUMBER() { return getToken(InterviewCsvParser.FRACTIONAL_NUMBER, 0); }
		public CotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterCotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitCotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitCotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationContext cotation() throws RecognitionException {
		CotationContext _localctx = new CotationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__0);
			setState(83);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1114120L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(84);
			match(T__0);
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
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).enterCotationType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterviewCsvListener ) ((InterviewCsvListener)listener).exitCotationType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterviewCsvVisitor ) return ((InterviewCsvVisitor<? extends T>)visitor).visitCotationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotationTypeContext cotationType() throws RecognitionException {
		CotationTypeContext _localctx = new CotationTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cotationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__0);
			setState(87);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(88);
			match(T__0);
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
		"\u0004\u0001\u0017[\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004"+
		"\u0001\u001e\b\u0001\u000b\u0001\f\u0001\u001f\u0001\u0001\u0001\u0001"+
		"\u0004\u0001$\b\u0001\u000b\u0001\f\u0001%\u0001\u0001\u0001\u0001\u0004"+
		"\u0001*\b\u0001\u000b\u0001\f\u0001+\u0003\u0001.\b\u0001\u0003\u0001"+
		"0\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007L\b\u0007\u000b\u0007"+
		"\f\u0007M\u0001\u0007\u0003\u0007Q\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0000\u0004\u0003\u0000\u0010\u0010\u0012"+
		"\u0013\u0015\u0015\u0001\u0000\u0007\u000f\u0003\u0000\u0003\u0003\u0010"+
		"\u0010\u0014\u0014\u0001\u0000\u0004\u0006X\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000"+
		"\u00065\u0001\u0000\u0000\u0000\b9\u0001\u0000\u0000\u0000\n;\u0001\u0000"+
		"\u0000\u0000\f=\u0001\u0000\u0000\u0000\u000e?\u0001\u0000\u0000\u0000"+
		"\u0010R\u0001\u0000\u0000\u0000\u0012V\u0001\u0000\u0000\u0000\u0014\u0016"+
		"\u0003\u000e\u0007\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001d"+
		"\u0005\u0001\u0000\u0000\u001c\u001e\u0007\u0000\u0000\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 /\u0001\u0000"+
		"\u0000\u0000!#\u0005\u0001\u0000\u0000\"$\u0007\u0000\u0000\u0000#\"\u0001"+
		"\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'-\u0005\u0001\u0000"+
		"\u0000(*\u0007\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001"+
		"\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".0\u0001\u0000\u0000\u0000/!\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u000012\u0005\u0001\u0000\u00002\u0003\u0001"+
		"\u0000\u0000\u000034\u0003\u0002\u0001\u00004\u0005\u0001\u0000\u0000"+
		"\u000056\u0005\u0001\u0000\u000067\u0007\u0001\u0000\u000078\u0005\u0001"+
		"\u0000\u00008\u0007\u0001\u0000\u0000\u00009:\u0003\u0010\b\u0000:\t\u0001"+
		"\u0000\u0000\u0000;<\u0003\u0002\u0001\u0000<\u000b\u0001\u0000\u0000"+
		"\u0000=>\u0003\u0010\b\u0000>\r\u0001\u0000\u0000\u0000?@\u0003\u0006"+
		"\u0003\u0000@A\u0005\u0002\u0000\u0000AB\u0003\b\u0004\u0000BC\u0005\u0002"+
		"\u0000\u0000CD\u0003\u0012\t\u0000DE\u0005\u0002\u0000\u0000EK\u0003\u0004"+
		"\u0002\u0000FG\u0005\u0002\u0000\u0000GH\u0003\n\u0005\u0000HI\u0005\u0002"+
		"\u0000\u0000IJ\u0003\f\u0006\u0000JL\u0001\u0000\u0000\u0000KF\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OQ\u0005\u0016\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u000f\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0001\u0000\u0000ST\u0007\u0002\u0000\u0000TU\u0005"+
		"\u0001\u0000\u0000U\u0011\u0001\u0000\u0000\u0000VW\u0005\u0001\u0000"+
		"\u0000WX\u0007\u0003\u0000\u0000XY\u0005\u0001\u0000\u0000Y\u0013\u0001"+
		"\u0000\u0000\u0000\b\u0017\u001f%+-/MP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}