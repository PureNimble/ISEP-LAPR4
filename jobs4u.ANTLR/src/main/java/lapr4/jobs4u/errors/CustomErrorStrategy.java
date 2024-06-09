package lapr4.jobs4u.errors;

import org.antlr.v4.runtime.*;

public class CustomErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void recover(final Parser recognizer, final RecognitionException e) {

        if (e instanceof InputMismatchException) {
            final TokenStream tokens = recognizer.getInputStream();
            tokens.consume();
        } else if (e instanceof NoViableAltException) {
            final TokenStream tokens = recognizer.getInputStream();
            tokens.consume();
        } else if (e instanceof FailedPredicateException) {
            final TokenStream tokens = recognizer.getInputStream();
            tokens.consume();
        } else if (e instanceof LexerNoViableAltException) {
            final TokenStream tokens = recognizer.getInputStream();
            tokens.consume();
        } else {
            super.recover(recognizer, e);
        }
    }
}
