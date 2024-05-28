package lapr4.jobs4u.customermanagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class CustomerCode implements ValueObject, Comparable<CustomerCode> {

    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_CODE_REGEX = Pattern.compile("^[A-Z][A-Z0-9]{0,9}$");    
    private final String code;

    protected CustomerCode(final String customerCode) {
        Preconditions.nonEmpty(customerCode, "Customer code should neither be null nor empty");
        Preconditions.matches(VALID_CODE_REGEX, customerCode, "Invalid Customer Code: " + customerCode);
        this.code = customerCode;
    }

    protected CustomerCode() {
        this.code = null;
    }

    public static CustomerCode valueOf(final String customerCode) {
        return new CustomerCode(customerCode);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerCode)) {
            return false;
        }

        final CustomerCode that = (CustomerCode) o;
        return this.code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int compareTo(final CustomerCode arg0) {
        return code.compareTo(arg0.code);
    }
}
