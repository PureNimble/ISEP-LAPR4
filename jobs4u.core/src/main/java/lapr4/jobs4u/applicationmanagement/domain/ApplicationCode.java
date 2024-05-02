package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class ApplicationCode implements ValueObject, Comparable<ApplicationCode> {

    private static final long serialVersionUID = 1L;
    private final String number;

    protected ApplicationCode(final String applicationNumber) {
        Preconditions.nonEmpty(applicationNumber, "Application number should neither be null nor empty");
        this.number = applicationNumber;
    }

    protected ApplicationCode() {
        this.number = null;
    }

    public static ApplicationCode valueOf(final String applicationNumber) {
        return new ApplicationCode(applicationNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationCode)) {
            return false;
        }

        final ApplicationCode that = (ApplicationCode) o;
        return this.number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public int compareTo(final ApplicationCode arg0) {
        return number.compareTo(arg0.number);
    }
}
