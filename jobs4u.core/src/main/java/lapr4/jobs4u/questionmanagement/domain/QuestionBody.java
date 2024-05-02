package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class QuestionBody implements ValueObject, Comparable<QuestionBody> {

    private static final long serialVersionUID = 1L;

    private final String text;
    
    protected QuestionBody(final String text) {
        Preconditions.nonEmpty(text, "QuestionBody should neither be null nor empty");
        this.text = text;
    }

    protected QuestionBody() {
        this.text = "";
    }

    public static QuestionBody valueOf(final String answer) {
        return new QuestionBody(answer);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuestionBody)) {
            return false;
        }

        final QuestionBody that = (QuestionBody) o;
        return this.text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public String toString() {
        return this.text;
    }

    @Override
    public int compareTo(final QuestionBody arg0) {
        return text.compareTo(arg0.text);
    }
}