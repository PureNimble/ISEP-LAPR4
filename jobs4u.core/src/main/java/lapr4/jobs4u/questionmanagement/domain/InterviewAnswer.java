package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.XmlAccessType;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class InterviewAnswer {
    
    @XmlValue
    private Answer answer;
    
    @XmlValue
    private Cotation cotation;

    public InterviewAnswer(final Answer answer, final Cotation cotation) {
        Preconditions.noneNull(new Object[] { answer, cotation });
        this.answer = answer;
        this.cotation = cotation;
    }

    protected InterviewAnswer() {
        // for ORM only
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + ((cotation == null) ? 0 : cotation.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        InterviewAnswer that = (InterviewAnswer) o;

        if (answer != null ? !answer.equals(that.answer) : that.answer != null)
            return false;
        if (cotation != null ? !cotation.equals(that.cotation) : that.cotation != null)
            return false;

        return true;
    }

    public boolean sameAs(final Object other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return this.answer.toString();
    }
}
