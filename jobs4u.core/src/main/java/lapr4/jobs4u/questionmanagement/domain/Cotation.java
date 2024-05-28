package lapr4.jobs4u.questionmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

/**
 * @author 2DI2
 */
@Embeddable
public class Cotation implements ValueObject, Comparable<Cotation> {

    private static final long serialVersionUID = 1L;

    private final Double cotation;
    
    protected Cotation(final String cotation) {
        Preconditions.nonEmpty(cotation, "Cotation should neither be null nor empty");
        Preconditions.ensure(cotation.matches("^100([.,]0+)?|0([.,][0-9]+)?|([1-9][0-9]?([.,][0-9]+)?)$"), "Cotation should be a number between 0 and 100");
        this.cotation = Double.parseDouble(cotation.replace(',', '.'));
    }

    protected Cotation() {
        this.cotation = null;
    }

    public static Cotation valueOf(final String cotation) {
        return new Cotation(cotation);
    }

    public Double value() {
        return cotation;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cotation)) {
            return false;
        }

        final Cotation that = (Cotation) o;
        return this.cotation.equals(that.cotation);
    }

    @Override
    public int hashCode() {
        return this.cotation.hashCode();
    }

    @Override
    public String toString() {
        return this.cotation.toString();
    }

    @Override
    public int compareTo(final Cotation arg0) {
        return cotation.compareTo(arg0.cotation);
    }
}