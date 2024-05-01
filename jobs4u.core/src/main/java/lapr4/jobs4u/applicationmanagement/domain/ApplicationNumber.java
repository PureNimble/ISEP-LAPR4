package lapr4.jobs4u.applicationmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class ApplicationNumber implements ValueObject, Comparable<ApplicationNumber> {

    private static final long serialVersionUID = 1L;
    private final String number;

    protected ApplicationNumber(final String applicationNumber) {
        Preconditions.nonEmpty(applicationNumber, "Application number should neither be null nor empty");
        this.number = applicationNumber;
    }

    protected ApplicationNumber() {
        this.number = null;
    }

    public static ApplicationNumber valueOf(final String applicationNumber) {
        return new ApplicationNumber(applicationNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationNumber)) {
            return false;
        }

        final ApplicationNumber that = (ApplicationNumber) o;
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
    public int compareTo(final ApplicationNumber arg0) {
        return number.compareTo(arg0.number);
    }
}
