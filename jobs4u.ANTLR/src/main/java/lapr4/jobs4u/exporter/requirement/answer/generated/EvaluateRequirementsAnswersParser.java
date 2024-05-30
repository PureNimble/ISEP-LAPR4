package lapr4.jobs4u.exporter.requirement.answer.generated;
// Generated from EvaluateRequirementsAnswers.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EvaluateRequirementsAnswersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DECISION=11, TWO_DIGIT_NUMBER=12, NUMBER=13, LETTER=14, MEMBER=15, 
		TEXT=16, NEWLINE=17, WS=18;
	public static final int
		RULE_start = 0, RULE_text = 1, RULE_email = 2, RULE_answer = 3, RULE_question = 4, 
		RULE_result = 5, RULE_justification = 6, RULE_content = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "text", "email", "answer", "question", "result", "justification", 
			"content"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TITLE:'", "'NAME:'", "'EMAIL:'", "'RESULT:'", "'#'", "'@'", "'REQUIREMENT RESULT:'", 
			"'MET'", "'NOT MET'", "'ANSWER:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "DECISION", 
			"TWO_DIGIT_NUMBER", "NUMBER", "LETTER", "MEMBER", "TEXT", "NEWLINE", 
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
	public String getGrammarFileName() { return "EvaluateRequirementsAnswers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EvaluateRequirementsAnswersParser(TokenStream input) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateRequirementsAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateRequirementsAnswersParser.NEWLINE, i);
		}
		public EmailContext email() {
			return getRuleContext(EmailContext.class,0);
		}
		public TerminalNode DECISION() { return getToken(EvaluateRequirementsAnswersParser.DECISION, 0); }
		public TerminalNode EOF() { return getToken(EvaluateRequirementsAnswersParser.EOF, 0); }
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
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitStart(this);
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
			text();
			setState(21);
			match(NEWLINE);
			setState(22);
			match(T__2);
			setState(23);
			email();
			setState(24);
			match(NEWLINE);
			setState(25);
			match(T__3);
			setState(26);
			match(DECISION);
			setState(27);
			match(NEWLINE);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				content();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(33);
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
		public List<TerminalNode> TEXT() { return getTokens(EvaluateRequirementsAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(EvaluateRequirementsAnswersParser.TEXT, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(EvaluateRequirementsAnswersParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(EvaluateRequirementsAnswersParser.LETTER, i);
		}
		public List<TerminalNode> TWO_DIGIT_NUMBER() { return getTokens(EvaluateRequirementsAnswersParser.TWO_DIGIT_NUMBER); }
		public TerminalNode TWO_DIGIT_NUMBER(int i) {
			return getToken(EvaluateRequirementsAnswersParser.TWO_DIGIT_NUMBER, i);
		}
		public List<TerminalNode> MEMBER() { return getTokens(EvaluateRequirementsAnswersParser.MEMBER); }
		public TerminalNode MEMBER(int i) {
			return getToken(EvaluateRequirementsAnswersParser.MEMBER, i);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 118784L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 118784L) != 0) );
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(41); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(40);
						match(T__4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(43); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 118784L) != 0)) {
					{
					setState(45);
					text();
					}
				}

				}
				break;
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
	public static class EmailContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(EvaluateRequirementsAnswersParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(EvaluateRequirementsAnswersParser.TEXT, i);
		}
		public EmailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmailContext email() throws RecognitionException {
		EmailContext _localctx = new EmailContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(TEXT);
			setState(51);
			match(T__5);
			setState(52);
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
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
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
	public static class ResultContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(EvaluateRequirementsAnswersParser.NEWLINE, 0); }
		public JustificationContext justification() {
			return getRuleContext(JustificationContext.class,0);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__6);
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(59);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(60);
				match(T__8);
				setState(61);
				match(NEWLINE);
				setState(62);
				justification();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class JustificationContext extends ParserRuleContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public JustificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterJustification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitJustification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitJustification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_justification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
	public static class ContentContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(EvaluateRequirementsAnswersParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(EvaluateRequirementsAnswersParser.NEWLINE, i);
		}
		public AnswerContext answer() {
			return getRuleContext(AnswerContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EvaluateRequirementsAnswersListener ) ((EvaluateRequirementsAnswersListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EvaluateRequirementsAnswersVisitor ) return ((EvaluateRequirementsAnswersVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__4);
			setState(68);
			question();
			setState(69);
			match(NEWLINE);
			setState(70);
			match(T__9);
			setState(71);
			answer();
			setState(72);
			match(NEWLINE);
			setState(73);
			result();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(74);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012N\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\u001e\b\u0000\u000b\u0000\f\u0000\u001f\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0004\u0001%\b\u0001\u000b\u0001\f\u0001&\u0001"+
		"\u0001\u0004\u0001*\b\u0001\u000b\u0001\f\u0001+\u0001\u0001\u0003\u0001"+
		"/\b\u0001\u0003\u00011\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005@\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007L\b\u0007\u0001"+
		"\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001\u0002"+
		"\u0000\f\f\u000e\u0010L\u0000\u0010\u0001\u0000\u0000\u0000\u0002$\u0001"+
		"\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u00066\u0001\u0000\u0000"+
		"\u0000\b8\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000\u0000\fA\u0001"+
		"\u0000\u0000\u0000\u000eC\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001"+
		"\u0000\u0000\u0011\u0012\u0003\u0002\u0001\u0000\u0012\u0013\u0005\u0011"+
		"\u0000\u0000\u0013\u0014\u0005\u0002\u0000\u0000\u0014\u0015\u0003\u0002"+
		"\u0001\u0000\u0015\u0016\u0005\u0011\u0000\u0000\u0016\u0017\u0005\u0003"+
		"\u0000\u0000\u0017\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0005\u0011"+
		"\u0000\u0000\u0019\u001a\u0005\u0004\u0000\u0000\u001a\u001b\u0005\u000b"+
		"\u0000\u0000\u001b\u001d\u0005\u0011\u0000\u0000\u001c\u001e\u0003\u000e"+
		"\u0007\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001"+
		"\u0000\u0000\u0000#%\u0007\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\'0\u0001\u0000\u0000\u0000(*\u0005\u0005\u0000\u0000)(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-/\u0003\u0002\u0001\u0000"+
		".-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000"+
		"\u00000)\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0003\u0001"+
		"\u0000\u0000\u000023\u0005\u0010\u0000\u000034\u0005\u0006\u0000\u0000"+
		"45\u0005\u0010\u0000\u00005\u0005\u0001\u0000\u0000\u000067\u0003\u0002"+
		"\u0001\u00007\u0007\u0001\u0000\u0000\u000089\u0003\u0002\u0001\u0000"+
		"9\t\u0001\u0000\u0000\u0000:?\u0005\u0007\u0000\u0000;@\u0005\b\u0000"+
		"\u0000<=\u0005\t\u0000\u0000=>\u0005\u0011\u0000\u0000>@\u0003\f\u0006"+
		"\u0000?;\u0001\u0000\u0000\u0000?<\u0001\u0000\u0000\u0000@\u000b\u0001"+
		"\u0000\u0000\u0000AB\u0003\u0002\u0001\u0000B\r\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0005\u0000\u0000DE\u0003\b\u0004\u0000EF\u0005\u0011\u0000\u0000"+
		"FG\u0005\n\u0000\u0000GH\u0003\u0006\u0003\u0000HI\u0005\u0011\u0000\u0000"+
		"IK\u0003\n\u0005\u0000JL\u0005\u0011\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000L\u000f\u0001\u0000\u0000\u0000\u0007\u001f"+
		"&+.0?K";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}