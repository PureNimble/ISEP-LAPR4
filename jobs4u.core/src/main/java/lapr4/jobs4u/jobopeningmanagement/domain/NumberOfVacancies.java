package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class NumberOfVacancies implements ValueObject, Comparable<NumberOfVacancies> {

    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_NUMBER_REGEX = Pattern.compile("^\\d+$");
    private final Integer numberOfVacancies;

    protected NumberOfVacancies(final String numberOfVacancies) {
        Preconditions.nonEmpty(numberOfVacancies, "Number of Vacancies should neither be null nor empty");
        Preconditions.matches(VALID_NUMBER_REGEX, numberOfVacancies, "Invalid Number of Vacancies: " + numberOfVacancies);
        this.numberOfVacancies = Integer.parseInt(numberOfVacancies);
    }

    protected NumberOfVacancies() {
        this.numberOfVacancies = 0;
    }

    public static NumberOfVacancies valueOf(final String numberOfVacancies) {
        return new NumberOfVacancies(numberOfVacancies);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NumberOfVacancies)) {
            return false;
        }

        final NumberOfVacancies that = (NumberOfVacancies) o;
        return this.numberOfVacancies.equals(that.numberOfVacancies);
    }

    @Override
    public int hashCode() {
        return this.numberOfVacancies.hashCode();
    }

    @Override
    public String toString() {
        return this.numberOfVacancies.toString();
    }

    public Integer toInt() {
        return this.numberOfVacancies;
    }

    @Override
    public int compareTo(final NumberOfVacancies arg0) {
        return numberOfVacancies.compareTo(arg0.numberOfVacancies);
    }
}