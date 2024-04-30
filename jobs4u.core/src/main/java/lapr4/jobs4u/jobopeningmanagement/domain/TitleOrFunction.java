package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class TitleOrFunction implements ValueObject, Comparable<TitleOrFunction> {

    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_NUMBER_REGEX = Pattern.compile("^.{1,250}$");
    private final String titleOrFunction;

    protected TitleOrFunction(final String titleOrFunction) {
        Preconditions.nonEmpty(titleOrFunction, "Title or Function should neither be null nor empty");
        Preconditions.matches(VALID_NUMBER_REGEX, titleOrFunction, "The title or function must have at most 250 characters");
        this.titleOrFunction = titleOrFunction;
    }

    protected TitleOrFunction() {
        this.titleOrFunction = "";
    }

    public static TitleOrFunction valueOf(final String titleOrFunction) {
        return new TitleOrFunction(titleOrFunction);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TitleOrFunction)) {
            return false;
        }

        final TitleOrFunction that = (TitleOrFunction) o;
        return this.titleOrFunction.equals(that.titleOrFunction);
    }

    @Override
    public int hashCode() {
        return this.titleOrFunction.hashCode();
    }

    @Override
    public String toString() {
        return this.titleOrFunction;
    }

    @Override
    public int compareTo(final TitleOrFunction arg0) {
        return titleOrFunction.compareTo(arg0.titleOrFunction);
    }
}