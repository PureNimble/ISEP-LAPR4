package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Justification implements ValueObject, Comparable<Justification> {

    private static final long serialVersionUID = 1L;

    private final String text;

    protected Justification(final String justification) {
        Preconditions.nonEmpty(justification, "Justification should neither be null nor empty");
        this.text = justification;
    }

    protected Justification() {
        this.text = "";
    }

    public static Justification valueOf(final String justification) {
        return new Justification(justification);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Justification)) {
            return false;
        }

        final Justification that = (Justification) o;
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
    public int compareTo(final Justification arg0) {
        return text.compareTo(arg0.text);
    }
}