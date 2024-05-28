package lapr4.jobs4u.customermanagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class PhoneNumber implements ValueObject, Comparable<PhoneNumber> {

    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_PHONENUMBER_REGEX = Pattern.compile("^9[1236]\\d{7}$");    
    private final String number;

    protected PhoneNumber(final String phoneNumber) {
        Preconditions.nonEmpty(phoneNumber, "Phone number should neither be null nor empty");
        Preconditions.matches(VALID_PHONENUMBER_REGEX, phoneNumber, "Invalid Phone number: " + phoneNumber);
        this.number = phoneNumber;
    }

    protected PhoneNumber() {
        this.number = null;
    }

    public static PhoneNumber valueOf(final String phoneNumber) {
        return new PhoneNumber(phoneNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }

        final PhoneNumber that = (PhoneNumber) o;
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
    public int compareTo(final PhoneNumber arg0) {
        return number.compareTo(arg0.number);
    }
}