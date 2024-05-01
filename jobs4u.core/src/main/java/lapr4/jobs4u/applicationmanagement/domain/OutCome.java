package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class Outcome implements ValueObject, Comparable<Outcome> {

    private static final long serialVersionUID = 1L;
    private final String outComeValue;

    protected Outcome(final String outComeValue) {
        Preconditions.nonEmpty(outComeValue, "OutCome should neither be null nor empty");
        Preconditions.ensure(OutcomeValue.valueOf(outComeValue) != null,
                "OutCome must be one of the APPROVED, REJECTED or PENDING states");
        this.outComeValue = outComeValue;
    }

    public static Outcome valueOf(final String OutComeValue) {
        return new Outcome(OutComeValue);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Outcome)) {
            return false;
        }

        final Outcome that = (Outcome) o;
        return this.outComeValue.equals(that.outComeValue);
    }

    @Override
    public int hashCode() {
        return this.outComeValue.hashCode();
    }

    @Override
    public String toString() {
        return this.outComeValue;
    }

    @Override
    public int compareTo(final Outcome arg0) {
        return outComeValue.compareTo(arg0.outComeValue);
    }
}