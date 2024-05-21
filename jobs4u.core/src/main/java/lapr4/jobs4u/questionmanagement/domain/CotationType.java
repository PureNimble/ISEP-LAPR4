package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class CotationType implements ValueObject, Comparable<CotationType> {

    private final String cotationType;

    protected CotationType(final String cotationType) {
        Preconditions.nonEmpty(cotationType, "Cotation type should neither be null nor empty");
        Preconditions.ensure(cotationType.matches("POINTS|VALUES|%"), "Cotation type should be POINTS, VALUES, or %");
        this.cotationType = cotationType;
    }

    protected CotationType() {
        this.cotationType = null;
    }

    public static CotationType valueOf(final String cotationType) {
        return new CotationType(cotationType);
    }

    public String value() {
        return cotationType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CotationType)) {
            return false;
        }

        final CotationType that = (CotationType) o;
        return this.cotationType.equals(that.cotationType);
    }

    @Override
    public int hashCode() {
        return this.cotationType.hashCode();
    }

    @Override
    public String toString() {
        return this.cotationType.toString();
    }

    @Override
    public int compareTo(final CotationType arg0) {
        return cotationType.compareTo(arg0.cotationType);
    }
}
