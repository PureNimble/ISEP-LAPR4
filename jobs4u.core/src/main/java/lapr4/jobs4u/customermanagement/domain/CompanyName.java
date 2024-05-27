package lapr4.jobs4u.customermanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class CompanyName implements ValueObject, Comparable<CompanyName> {

    private static final long serialVersionUID = 1L;

    private final String name;

    protected CompanyName(final String CompanyName) {
        Preconditions.nonEmpty(CompanyName, "Company Name should neither be null nor empty");
        this.name = CompanyName;
    }

    protected CompanyName() {
        this.name = "";
    }

    public static CompanyName valueOf(final String CompanyName) {
        return new CompanyName(CompanyName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompanyName)) {
            return false;
        }

        final CompanyName that = (CompanyName) o;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(final CompanyName arg0) {
        return name.compareTo(arg0.name);
    }
}