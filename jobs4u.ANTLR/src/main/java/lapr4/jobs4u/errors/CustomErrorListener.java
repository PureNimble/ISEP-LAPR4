package lapr4.jobs4u.errors;

import java.nio.file.Paths;

import java.util.BitSet;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class CustomErrorListener extends BaseErrorListener {

    private static final boolean REPORT_SYNTAX_ERRORS = true;
    public static final CustomErrorListener INSTANCE = new CustomErrorListener();

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol,
            final int line, final int charPositionInLine, final String msg, final RecognitionException e) {
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        final String sourceName = recognizer.getInputStream().getSourceName();
        final String fileName = Paths.get(sourceName).getFileName().toString();

        System.out.println("\nSyntax Error in File -> " + fileName + "\nError in Line -> " + line
                + "\nError in Line Char -> " + charPositionInLine + "\nType of Error -> " + msg);
    }

    @Override
    public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
            final boolean exact, final BitSet ambigAlts, final ATNConfigSet configs) {
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        final String sourceName = recognizer.getInputStream().getSourceName();
        final String fileName = Paths.get(sourceName).getFileName().toString();

        System.out.println("\nAmbiguity in File -> " + fileName + "\nStart Index -> " + startIndex + "\nStop Index -> "
                + stopIndex + "\nAmbiguity Alts -> " + ambigAlts + "\nATN Configs -> " + configs);
    }

    @Override
    public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex,
            final int stopIndex, final BitSet conflictingAlts, final ATNConfigSet configs) {
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        final String sourceName = recognizer.getInputStream().getSourceName();
        final String fileName = Paths.get(sourceName).getFileName().toString();

        System.out.println("\nAttempting Full Context in File -> " + fileName + "\nStart Index -> " + startIndex
                + "\nStop Index -> " + stopIndex + "\nConflicting Alts -> " + conflictingAlts + "\nATN Configs -> "
                + configs);
    }

    @Override
    public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex,
            final int stopIndex, final int prediction, final ATNConfigSet configs) {
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        final String sourceName = recognizer.getInputStream().getSourceName();
        final String fileName = Paths.get(sourceName).getFileName().toString();

        System.out.println("\nContext Sensitivity in File -> " + fileName + "\nStart Index -> " + startIndex
                + "\nStop Index -> " + stopIndex + "\nPrediction -> " + prediction + "\nATN Configs -> " + configs);
    }
}
