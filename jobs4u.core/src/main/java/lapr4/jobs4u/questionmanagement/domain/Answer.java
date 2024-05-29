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
    private final String answer;

    protected Answer(final String answer) {
        Preconditions.nonEmpty(answer, "Answer should neither be null nor empty");
        this.answer = answer;
    }

    protected Answer() {
        this.answer = "";
    }

    public static Answer valueOf(final String answer) {
        return new Answer(answer);
    }

    public String answer() {
        return this.answer;
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
        return this.answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return this.answer.hashCode();
    }

    @Override
    public String toString() {
        return this.answer;
    }

    @Override
    public int compareTo(final Answer arg0) {
        return answer.compareTo(arg0.answer);
    }
}