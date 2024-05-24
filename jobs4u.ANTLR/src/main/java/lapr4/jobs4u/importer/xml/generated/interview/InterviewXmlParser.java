package lapr4.jobs4u.importer.xml.generated.interview;
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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, NUMBER=23, LETTER=24, 
		MEMBER=25, TWO_DIGIT_NUMBER=26, FRACTIONAL_NUMBER=27, TEXT=28, WS=29;
	public static final int
		RULE_questions = 0, RULE_text = 1, RULE_question = 2, RULE_cotation = 3, 
		RULE_cotationType = 4, RULE_type = 5, RULE_body = 6, RULE_answerCotation = 7, 
		RULE_possibleAnswersList = 8, RULE_possibleAnswers = 9, RULE_answer = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"questions", "text", "question", "cotation", "cotationType", "type", 
			"body", "answerCotation", "possibleAnswersList", "possibleAnswers", "answer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<Questions>'", "'</Questions>'", "'<Question>'", "'</Question>'", 
			"'<Cotation>'", "'100'", "'</Cotation>'", "'<CotationType>'", "'%'", 
			"'POINTS'", "'VALUES'", "'</CotationType>'", "'<Type>'", "'</Type>'", 
			"'<Body>'", "'</Body>'", "'<PossibleAnswersList>'", "'</PossibleAnswersList>'", 
			"'<PossibleAnswers>'", "'</PossibleAnswers>'", "'<Answer>'", "'</Answer>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "NUMBER", 
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
			setState(22);
			match(T__0);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				question();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(28);
			match(T__1);
			setState(29);
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
		public List<TerminalNode> NUMBER() { return getTokens(InterviewXmlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(InterviewXmlParser.NUMBER, i);
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
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 327155712L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 327155712L) != 0) );
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
		public CotationContext cotation() {
			return getRuleContext(CotationContext.class,0);
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
			setState(36);
			match(T__2);
			setState(37);
			cotation();
			setState(38);
			cotationType();
			setState(39);
			type();
			setState(40);
			body();
			setState(41);
			possibleAnswersList();
			setState(42);
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
			setState(44);
			match(T__4);
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 201326656L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(46);
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
			setState(48);
			match(T__7);
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__12);
			setState(53);
			text();
			setState(54);
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__14);
			setState(57);
			text();
			setState(58);
			match(T__15);
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
		enterRule(_localctx, 14, RULE_answerCotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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
		enterRule(_localctx, 16, RULE_possibleAnswersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__16);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(63);
				possibleAnswers();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(T__17);
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
		enterRule(_localctx, 18, RULE_possibleAnswers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__18);
			setState(72);
			answer();
			setState(73);
			answerCotation();
			setState(74);
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
		enterRule(_localctx, 20, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__20);
			setState(77);
			text();
			setState(78);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001dQ\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u0001!\b\u0001\u000b\u0001\f\u0001\"\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bA\b\b\n\b\f\bD\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0000\u0003\u0002\u0000\u0017\u0019\u001c\u001c\u0002\u0000"+
		"\u0006\u0006\u001a\u001b\u0001\u0000\t\u000bH\u0000\u0016\u0001\u0000"+
		"\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000"+
		"\u0006,\u0001\u0000\u0000\u0000\b0\u0001\u0000\u0000\u0000\n4\u0001\u0000"+
		"\u0000\u0000\f8\u0001\u0000\u0000\u0000\u000e<\u0001\u0000\u0000\u0000"+
		"\u0010>\u0001\u0000\u0000\u0000\u0012G\u0001\u0000\u0000\u0000\u0014L"+
		"\u0001\u0000\u0000\u0000\u0016\u0018\u0005\u0001\u0000\u0000\u0017\u0019"+
		"\u0003\u0004\u0002\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0005\u0002\u0000\u0000\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001"+
		"\u0001\u0000\u0000\u0000\u001f!\u0007\u0000\u0000\u0000 \u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#"+
		"\u0001\u0000\u0000\u0000#\u0003\u0001\u0000\u0000\u0000$%\u0005\u0003"+
		"\u0000\u0000%&\u0003\u0006\u0003\u0000&\'\u0003\b\u0004\u0000\'(\u0003"+
		"\n\u0005\u0000()\u0003\f\u0006\u0000)*\u0003\u0010\b\u0000*+\u0005\u0004"+
		"\u0000\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0005\u0005\u0000\u0000"+
		"-.\u0007\u0001\u0000\u0000./\u0005\u0007\u0000\u0000/\u0007\u0001\u0000"+
		"\u0000\u000001\u0005\b\u0000\u000012\u0007\u0002\u0000\u000023\u0005\f"+
		"\u0000\u00003\t\u0001\u0000\u0000\u000045\u0005\r\u0000\u000056\u0003"+
		"\u0002\u0001\u000067\u0005\u000e\u0000\u00007\u000b\u0001\u0000\u0000"+
		"\u000089\u0005\u000f\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0005\u0010"+
		"\u0000\u0000;\r\u0001\u0000\u0000\u0000<=\u0003\u0006\u0003\u0000=\u000f"+
		"\u0001\u0000\u0000\u0000>B\u0005\u0011\u0000\u0000?A\u0003\u0012\t\u0000"+
		"@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000DB\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0012\u0000\u0000F\u0011\u0001\u0000\u0000\u0000"+
		"GH\u0005\u0013\u0000\u0000HI\u0003\u0014\n\u0000IJ\u0003\u000e\u0007\u0000"+
		"JK\u0005\u0014\u0000\u0000K\u0013\u0001\u0000\u0000\u0000LM\u0005\u0015"+
		"\u0000\u0000MN\u0003\u0002\u0001\u0000NO\u0005\u0016\u0000\u0000O\u0015"+
		"\u0001\u0000\u0000\u0000\u0003\u001a\"B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}