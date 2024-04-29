package lapr4.jobs4u.applicationmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class OutCome implements ValueObject, Comparable<OutCome> {

    private static final long serialVersionUID = 1L;
    private final String outComeValue;

    protected OutCome(final String outComeValue) {
        Preconditions.nonEmpty(outComeValue, "OutCome should neither be null nor empty");
        Preconditions.ensure(OutComeValue.valueOf(outComeValue) != null,
                "OutCome must be one of the APPROVED, REJECTED or PENDING states");
        this.outComeValue = outComeValue;
    }

    public static OutCome valueOf(final String OutComeValue) {
        return new OutCome(OutComeValue);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OutCome)) {
            return false;
        }

        final OutCome that = (OutCome) o;
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
    public int compareTo(final OutCome arg0) {
        return outComeValue.compareTo(arg0.outComeValue);
    }
}
