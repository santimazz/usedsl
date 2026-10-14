// Generated from c:/Users/santi/OneDrive/Documentos/swt-ba/usedsl/src/main/antlr/usecase.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class usecaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		USECASE=1, DESC=2, SCOPE=3, ACTORS=4, PRE=5, POST=6, NONE=7, FLOW=8, ENT=9, 
		PROP=10, STATE=11, FOR=12, WITH=13, ISIN=14, NOTIN=15, EQUALS=16, GT=17, 
		LT=18, CONTAINS=19, USERACT=20, TRANS=21, STRING=22, INT=23, NEWLINE=24, 
		COMMA=25, LPAR=26, RPAR=27, COLON=28, WS=29, INDENT=30;
	public static final int
		RULE_usecase_spec = 0, RULE_usecase_def = 1, RULE_usecase = 2, RULE_description = 3, 
		RULE_scope = 4, RULE_actors = 5, RULE_precond = 6, RULE_flow = 7, RULE_step = 8, 
		RULE_postcond = 9, RULE_cond = 10, RULE_entity = 11, RULE_property = 12, 
		RULE_state = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"usecase_spec", "usecase_def", "usecase", "description", "scope", "actors", 
			"precond", "flow", "step", "postcond", "cond", "entity", "property", 
			"state"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'Description:'", "'Scope:'", "'Actors:'", "'Preconditions:'", 
			"'Postconditions:'", null, "'Flow'", null, null, null, "' for '", "' with '", 
			"' is in '", "' is not in '", "' equal to '", "' is greater than '", 
			"' is less than '", "' contains '", "'User performs action'", "' transitions to '", 
			null, null, "'\\n'", "','", "'('", "')'", "':'", "' '", "'\\r'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "USECASE", "DESC", "SCOPE", "ACTORS", "PRE", "POST", "NONE", "FLOW", 
			"ENT", "PROP", "STATE", "FOR", "WITH", "ISIN", "NOTIN", "EQUALS", "GT", 
			"LT", "CONTAINS", "USERACT", "TRANS", "STRING", "INT", "NEWLINE", "COMMA", 
			"LPAR", "RPAR", "COLON", "WS", "INDENT"
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
	public String getGrammarFileName() { return "usecase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public usecaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Usecase_specContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(usecaseParser.EOF, 0); }
		public List<Usecase_defContext> usecase_def() {
			return getRuleContexts(Usecase_defContext.class);
		}
		public Usecase_defContext usecase_def(int i) {
			return getRuleContext(Usecase_defContext.class,i);
		}
		public Usecase_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecase_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterUsecase_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitUsecase_spec(this);
		}
	}

	public final Usecase_specContext usecase_spec() throws RecognitionException {
		Usecase_specContext _localctx = new Usecase_specContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_usecase_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USECASE) {
				{
				{
				setState(28);
				usecase_def();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Usecase_defContext extends ParserRuleContext {
		public UsecaseContext usecase() {
			return getRuleContext(UsecaseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(usecaseParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(usecaseParser.NEWLINE, i);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ActorsContext actors() {
			return getRuleContext(ActorsContext.class,0);
		}
		public PrecondContext precond() {
			return getRuleContext(PrecondContext.class,0);
		}
		public PostcondContext postcond() {
			return getRuleContext(PostcondContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(usecaseParser.RPAR, 0); }
		public List<FlowContext> flow() {
			return getRuleContexts(FlowContext.class);
		}
		public FlowContext flow(int i) {
			return getRuleContext(FlowContext.class,i);
		}
		public Usecase_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecase_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterUsecase_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitUsecase_def(this);
		}
	}

	public final Usecase_defContext usecase_def() throws RecognitionException {
		Usecase_defContext _localctx = new Usecase_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_usecase_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			usecase();
			setState(37);
			match(NEWLINE);
			setState(38);
			description();
			setState(39);
			match(NEWLINE);
			setState(40);
			scope();
			setState(41);
			match(NEWLINE);
			setState(42);
			actors();
			setState(43);
			match(NEWLINE);
			setState(44);
			precond();
			setState(45);
			match(NEWLINE);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				flow();
				setState(47);
				match(NEWLINE);
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FLOW );
			setState(53);
			postcond();
			setState(54);
			match(NEWLINE);
			setState(55);
			match(RPAR);
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
	public static class UsecaseContext extends ParserRuleContext {
		public TerminalNode USECASE() { return getToken(usecaseParser.USECASE, 0); }
		public TerminalNode INT() { return getToken(usecaseParser.INT, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public TerminalNode LPAR() { return getToken(usecaseParser.LPAR, 0); }
		public UsecaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usecase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterUsecase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitUsecase(this);
		}
	}

	public final UsecaseContext usecase() throws RecognitionException {
		UsecaseContext _localctx = new UsecaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_usecase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(USECASE);
			setState(58);
			match(INT);
			setState(59);
			match(STRING);
			setState(60);
			match(LPAR);
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
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(usecaseParser.DESC, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(DESC);
			setState(63);
			match(STRING);
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
	public static class ScopeContext extends ParserRuleContext {
		public TerminalNode SCOPE() { return getToken(usecaseParser.SCOPE, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitScope(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(SCOPE);
			setState(66);
			match(STRING);
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
	public static class ActorsContext extends ParserRuleContext {
		public TerminalNode ACTORS() { return getToken(usecaseParser.ACTORS, 0); }
		public List<TerminalNode> STRING() { return getTokens(usecaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(usecaseParser.STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(usecaseParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(usecaseParser.COMMA, i);
		}
		public ActorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterActors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitActors(this);
		}
	}

	public final ActorsContext actors() throws RecognitionException {
		ActorsContext _localctx = new ActorsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_actors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ACTORS);
			setState(69);
			match(STRING);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(70);
				match(COMMA);
				setState(71);
				match(STRING);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class PrecondContext extends ParserRuleContext {
		public TerminalNode PRE() { return getToken(usecaseParser.PRE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(usecaseParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(usecaseParser.NEWLINE, i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public PrecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterPrecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitPrecond(this);
		}
	}

	public final PrecondContext precond() throws RecognitionException {
		PrecondContext _localctx = new PrecondContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_precond);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(PRE);
			setState(78);
			match(NEWLINE);
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(79);
				cond();
				}
				break;
			case 2:
				{
				setState(83); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(80);
						cond();
						setState(81);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(85); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(87);
				cond();
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
	public static class FlowContext extends ParserRuleContext {
		public TerminalNode FLOW() { return getToken(usecaseParser.FLOW, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public TerminalNode COLON() { return getToken(usecaseParser.COLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(usecaseParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(usecaseParser.NEWLINE, i);
		}
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public FlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitFlow(this);
		}
	}

	public final FlowContext flow() throws RecognitionException {
		FlowContext _localctx = new FlowContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_flow);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(FLOW);
			setState(92);
			match(STRING);
			setState(93);
			match(COLON);
			setState(94);
			match(NEWLINE);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(95);
				step();
				}
				break;
			case 2:
				{
				setState(99); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(96);
						step();
						setState(97);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(101); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(103);
				step();
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
	public static class StepContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(usecaseParser.INT, 0); }
		public TerminalNode RPAR() { return getToken(usecaseParser.RPAR, 0); }
		public TerminalNode USERACT() { return getToken(usecaseParser.USERACT, 0); }
		public List<TerminalNode> STRING() { return getTokens(usecaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(usecaseParser.STRING, i);
		}
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode FOR() { return getToken(usecaseParser.FOR, 0); }
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public TerminalNode TRANS() { return getToken(usecaseParser.TRANS, 0); }
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(usecaseParser.EQUALS, 0); }
		public TerminalNode GT() { return getToken(usecaseParser.GT, 0); }
		public TerminalNode LT() { return getToken(usecaseParser.LT, 0); }
		public TerminalNode CONTAINS() { return getToken(usecaseParser.CONTAINS, 0); }
		public TerminalNode WITH() { return getToken(usecaseParser.WITH, 0); }
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_step);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(INT);
			setState(108);
			match(RPAR);
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				}
				break;
			case USERACT:
				{
				setState(110);
				match(USERACT);
				setState(111);
				match(STRING);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(112);
					match(WITH);
					setState(113);
					property();
					setState(114);
					match(EQUALS);
					setState(115);
					match(STRING);
					}
				}

				}
				break;
			case PROP:
				{
				setState(119);
				property();
				setState(120);
				match(FOR);
				setState(121);
				entity();
				setState(122);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(123);
				match(STRING);
				}
				break;
			case ENT:
				{
				setState(125);
				entity();
				setState(126);
				match(TRANS);
				setState(127);
				state();
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
	public static class PostcondContext extends ParserRuleContext {
		public TerminalNode POST() { return getToken(usecaseParser.POST, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(usecaseParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(usecaseParser.NEWLINE, i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public PostcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterPostcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitPostcond(this);
		}
	}

	public final PostcondContext postcond() throws RecognitionException {
		PostcondContext _localctx = new PostcondContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_postcond);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(POST);
			setState(132);
			match(NEWLINE);
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(133);
				cond();
				}
				break;
			case 2:
				{
				setState(137); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(134);
						cond();
						setState(135);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(139); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(141);
				cond();
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
	public static class CondContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public TerminalNode ISIN() { return getToken(usecaseParser.ISIN, 0); }
		public TerminalNode NOTIN() { return getToken(usecaseParser.NOTIN, 0); }
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode FOR() { return getToken(usecaseParser.FOR, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public TerminalNode EQUALS() { return getToken(usecaseParser.EQUALS, 0); }
		public TerminalNode GT() { return getToken(usecaseParser.GT, 0); }
		public TerminalNode LT() { return getToken(usecaseParser.LT, 0); }
		public TerminalNode CONTAINS() { return getToken(usecaseParser.CONTAINS, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cond);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				entity();
				setState(147);
				_la = _input.LA(1);
				if ( !(_la==ISIN || _la==NOTIN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				state();
				}
				break;
			case PROP:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				property();
				setState(151);
				match(FOR);
				setState(152);
				entity();
				setState(153);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(154);
				match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntityContext extends ParserRuleContext {
		public TerminalNode ENT() { return getToken(usecaseParser.ENT, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_entity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(ENT);
			setState(159);
			match(STRING);
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
	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode PROP() { return getToken(usecaseParser.PROP, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(PROP);
			setState(162);
			match(STRING);
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
	public static class StateContext extends ParserRuleContext {
		public TerminalNode STATE() { return getToken(usecaseParser.STATE, 0); }
		public TerminalNode STRING() { return getToken(usecaseParser.STRING, 0); }
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof usecaseListener ) ((usecaseListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(STATE);
			setState(165);
			match(STRING);
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
		"\u0004\u0001\u001e\u00a8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000"+
		"\n\u0000\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001"+
		"2\b\u0001\u000b\u0001\f\u00013\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005I\b\u0005\n\u0005"+
		"\f\u0005L\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006T\b\u0006\u000b\u0006\f\u0006U\u0001\u0006"+
		"\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"d\b\u0007\u000b\u0007\f\u0007e\u0001\u0007\u0001\u0007\u0003\u0007j\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\bv\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0082\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u008a\b\t\u000b\t\f\t\u008b"+
		"\u0001\t\u0001\t\u0003\t\u0090\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009d\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0002\u0001\u0000\u0010\u0013"+
		"\u0001\u0000\u000e\u000f\u00a8\u0000\u001f\u0001\u0000\u0000\u0000\u0002"+
		"$\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000\u0006>\u0001"+
		"\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000\u0000"+
		"\fM\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010k\u0001"+
		"\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000\u0000\u0014\u009c\u0001"+
		"\u0000\u0000\u0000\u0016\u009e\u0001\u0000\u0000\u0000\u0018\u00a1\u0001"+
		"\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000\u001c\u001e\u0003"+
		"\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000"+
		"\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005"+
		"\u0000\u0000\u0001#\u0001\u0001\u0000\u0000\u0000$%\u0003\u0004\u0002"+
		"\u0000%&\u0005\u0018\u0000\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005\u0018"+
		"\u0000\u0000()\u0003\b\u0004\u0000)*\u0005\u0018\u0000\u0000*+\u0003\n"+
		"\u0005\u0000+,\u0005\u0018\u0000\u0000,-\u0003\f\u0006\u0000-1\u0005\u0018"+
		"\u0000\u0000./\u0003\u000e\u0007\u0000/0\u0005\u0018\u0000\u000002\u0001"+
		"\u0000\u0000\u00001.\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000056\u0003\u0012\t\u000067\u0005\u0018\u0000\u000078\u0005\u001b\u0000"+
		"\u00008\u0003\u0001\u0000\u0000\u00009:\u0005\u0001\u0000\u0000:;\u0005"+
		"\u0017\u0000\u0000;<\u0005\u0016\u0000\u0000<=\u0005\u001a\u0000\u0000"+
		"=\u0005\u0001\u0000\u0000\u0000>?\u0005\u0002\u0000\u0000?@\u0005\u0016"+
		"\u0000\u0000@\u0007\u0001\u0000\u0000\u0000AB\u0005\u0003\u0000\u0000"+
		"BC\u0005\u0016\u0000\u0000C\t\u0001\u0000\u0000\u0000DE\u0005\u0004\u0000"+
		"\u0000EJ\u0005\u0016\u0000\u0000FG\u0005\u0019\u0000\u0000GI\u0005\u0016"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u000b\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\u0005\u0000\u0000NY\u0005\u0018"+
		"\u0000\u0000OZ\u0003\u0014\n\u0000PQ\u0003\u0014\n\u0000QR\u0005\u0018"+
		"\u0000\u0000RT\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WX\u0003\u0014\n\u0000XZ\u0001\u0000\u0000\u0000"+
		"YO\u0001\u0000\u0000\u0000YS\u0001\u0000\u0000\u0000Z\r\u0001\u0000\u0000"+
		"\u0000[\\\u0005\b\u0000\u0000\\]\u0005\u0016\u0000\u0000]^\u0005\u001c"+
		"\u0000\u0000^i\u0005\u0018\u0000\u0000_j\u0003\u0010\b\u0000`a\u0003\u0010"+
		"\b\u0000ab\u0005\u0018\u0000\u0000bd\u0001\u0000\u0000\u0000c`\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0003\u0010\b\u0000hj\u0001"+
		"\u0000\u0000\u0000i_\u0001\u0000\u0000\u0000ic\u0001\u0000\u0000\u0000"+
		"j\u000f\u0001\u0000\u0000\u0000kl\u0005\u0017\u0000\u0000l\u0081\u0005"+
		"\u001b\u0000\u0000m\u0082\u0001\u0000\u0000\u0000no\u0005\u0014\u0000"+
		"\u0000ou\u0005\u0016\u0000\u0000pq\u0005\r\u0000\u0000qr\u0003\u0018\f"+
		"\u0000rs\u0005\u0010\u0000\u0000st\u0005\u0016\u0000\u0000tv\u0001\u0000"+
		"\u0000\u0000up\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0082"+
		"\u0001\u0000\u0000\u0000wx\u0003\u0018\f\u0000xy\u0005\f\u0000\u0000y"+
		"z\u0003\u0016\u000b\u0000z{\u0007\u0000\u0000\u0000{|\u0005\u0016\u0000"+
		"\u0000|\u0082\u0001\u0000\u0000\u0000}~\u0003\u0016\u000b\u0000~\u007f"+
		"\u0005\u0015\u0000\u0000\u007f\u0080\u0003\u001a\r\u0000\u0080\u0082\u0001"+
		"\u0000\u0000\u0000\u0081m\u0001\u0000\u0000\u0000\u0081n\u0001\u0000\u0000"+
		"\u0000\u0081w\u0001\u0000\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0082"+
		"\u0011\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0006\u0000\u0000\u0084"+
		"\u008f\u0005\u0018\u0000\u0000\u0085\u0090\u0003\u0014\n\u0000\u0086\u0087"+
		"\u0003\u0014\n\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088\u008a\u0001"+
		"\u0000\u0000\u0000\u0089\u0086\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0003"+
		"\u0014\n\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0085\u0001\u0000"+
		"\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u0090\u0013\u0001\u0000"+
		"\u0000\u0000\u0091\u009d\u0001\u0000\u0000\u0000\u0092\u0093\u0003\u0016"+
		"\u000b\u0000\u0093\u0094\u0007\u0001\u0000\u0000\u0094\u0095\u0003\u001a"+
		"\r\u0000\u0095\u009d\u0001\u0000\u0000\u0000\u0096\u0097\u0003\u0018\f"+
		"\u0000\u0097\u0098\u0005\f\u0000\u0000\u0098\u0099\u0003\u0016\u000b\u0000"+
		"\u0099\u009a\u0007\u0000\u0000\u0000\u009a\u009b\u0005\u0016\u0000\u0000"+
		"\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u0091\u0001\u0000\u0000\u0000"+
		"\u009c\u0092\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000"+
		"\u009d\u0015\u0001\u0000\u0000\u0000\u009e\u009f\u0005\t\u0000\u0000\u009f"+
		"\u00a0\u0005\u0016\u0000\u0000\u00a0\u0017\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005\n\u0000\u0000\u00a2\u00a3\u0005\u0016\u0000\u0000\u00a3\u0019"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\u000b\u0000\u0000\u00a5\u00a6"+
		"\u0005\u0016\u0000\u0000\u00a6\u001b\u0001\u0000\u0000\u0000\f\u001f3"+
		"JUYeiu\u0081\u008b\u008f\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}