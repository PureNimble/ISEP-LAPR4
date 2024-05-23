package lapr4.jobs4u.importer.xml.generated.requirement;
// Generated from RequirementsXml.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RequirementsXmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NUMBER=11, LETTER=12, MEMBER=13, TWO_DIGIT_NUMBER=14, FRACTIONAL_NUMBER=15, 
		TEXT=16, WS=17;
	public static final int
		RULE_questions = 0, RULE_text = 1, RULE_question = 2, RULE_body = 3, RULE_possibleAnswersList = 4, 
		RULE_possibleAnswers = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"questions", "text", "question", "body", "possibleAnswersList", "possibleAnswers"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<Questions>'", "'</Questions>'", "'<Question>'", "'</Question>'", 
			"'<Body>'", "'</Body>'", "'<PossibleAnswersList>'", "'</PossibleAnswersList>'", 
			"'<PossibleAnswers>'", "'</PossibleAnswers>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	public String getGrammarFileName() { return "RequirementsXml.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RequirementsXmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RequirementsXmlParser.EOF, 0); }
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
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitQuestions(this);
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
			setState(12);
			match(T__0);
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(13);
				question();
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(18);
			match(T__1);
			setState(19);
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
		public List<TerminalNode> TEXT() { return getTokens(RequirementsXmlParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(RequirementsXmlParser.TEXT, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(RequirementsXmlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(RequirementsXmlParser.NUMBER, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(RequirementsXmlParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(RequirementsXmlParser.LETTER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(RequirementsXmlParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(RequirementsXmlParser.MEMBER, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitText(this);
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
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 79872L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 79872L) != 0) );
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
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__2);
			setState(27);
			body();
			setState(28);
			possibleAnswersList();
			setState(29);
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
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(T__4);
			setState(32);
			text();
			setState(33);
			match(T__5);
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
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterPossibleAnswersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitPossibleAnswersList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitPossibleAnswersList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswersListContext possibleAnswersList() throws RecognitionException {
		PossibleAnswersListContext _localctx = new PossibleAnswersListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_possibleAnswersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__6);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(36);
				possibleAnswers();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(T__7);
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
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public PossibleAnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleAnswers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).enterPossibleAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RequirementsXmlListener ) ((RequirementsXmlListener)listener).exitPossibleAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RequirementsXmlVisitor ) return ((RequirementsXmlVisitor<? extends T>)visitor).visitPossibleAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PossibleAnswersContext possibleAnswers() throws RecognitionException {
		PossibleAnswersContext _localctx = new PossibleAnswersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_possibleAnswers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__8);
			setState(45);
			text();
			setState(46);
			match(T__9);
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
		"\u0004\u0001\u00111\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0004\u0000\u000f\b\u0000\u000b"+
		"\u0000\f\u0000\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004"+
		"\u0001\u0017\b\u0001\u000b\u0001\f\u0001\u0018\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004&\b\u0004\n\u0004\f\u0004"+
		")\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n"+
		"\u0000\u0001\u0002\u0000\u000b\r\u0010\u0010-\u0000\f\u0001\u0000\u0000"+
		"\u0000\u0002\u0016\u0001\u0000\u0000\u0000\u0004\u001a\u0001\u0000\u0000"+
		"\u0000\u0006\u001f\u0001\u0000\u0000\u0000\b#\u0001\u0000\u0000\u0000"+
		"\n,\u0001\u0000\u0000\u0000\f\u000e\u0005\u0001\u0000\u0000\r\u000f\u0003"+
		"\u0004\u0002\u0000\u000e\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001\u0000"+
		"\u0000\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000"+
		"\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0002"+
		"\u0000\u0000\u0013\u0014\u0005\u0000\u0000\u0001\u0014\u0001\u0001\u0000"+
		"\u0000\u0000\u0015\u0017\u0007\u0000\u0000\u0000\u0016\u0015\u0001\u0000"+
		"\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u0003\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0003\u0000\u0000\u001b\u001c\u0003\u0006"+
		"\u0003\u0000\u001c\u001d\u0003\b\u0004\u0000\u001d\u001e\u0005\u0004\u0000"+
		"\u0000\u001e\u0005\u0001\u0000\u0000\u0000\u001f \u0005\u0005\u0000\u0000"+
		" !\u0003\u0002\u0001\u0000!\"\u0005\u0006\u0000\u0000\"\u0007\u0001\u0000"+
		"\u0000\u0000#\'\u0005\u0007\u0000\u0000$&\u0003\n\u0005\u0000%$\u0001"+
		"\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000"+
		"\u0000*+\u0005\b\u0000\u0000+\t\u0001\u0000\u0000\u0000,-\u0005\t\u0000"+
		"\u0000-.\u0003\u0002\u0001\u0000./\u0005\n\u0000\u0000/\u000b\u0001\u0000"+
		"\u0000\u0000\u0003\u0010\u0018\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}