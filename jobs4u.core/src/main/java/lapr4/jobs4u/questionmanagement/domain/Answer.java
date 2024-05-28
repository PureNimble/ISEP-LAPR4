package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.xml.bind.annotation.XmlAccessType;

/**
 * @author 2DI2
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer implements ValueObject, Comparable<Answer> {

    private static final long serialVersionUID = 1L;

    @XmlValue
    private final String text;

    protected Answer(final String text) {
        Preconditions.nonEmpty(text, "Answer should neither be null nor empty");
        this.text = text;
    }

    protected Answer() {
        this.text = "";
    }

    public static Answer valueOf(final String answer) {
        return new Answer(answer);
    }

    public Answer answer() {
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Answer)) {
            return false;
        }

        final Answer that = (Answer) o;
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
    public int compareTo(final Answer arg0) {
        return text.compareTo(arg0.text);
    }
}