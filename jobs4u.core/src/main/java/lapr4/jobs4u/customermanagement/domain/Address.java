package lapr4.jobs4u.customermanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class Address implements ValueObject, Comparable<Address> {

    private static final long serialVersionUID = 1L;

    private final String address;

    protected Address(final String address) {
        Preconditions.nonEmpty(address, "Address should neither be null nor empty");
        this.address = address;
    }

    protected Address() {
        this.address = "";
    }

    public static Address valueOf(final String address) {
        return new Address(address);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }

        final Address that = (Address) o;
        return this.address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public String toString() {
        return this.address;
    }

    @Override
    public int compareTo(final Address arg0) {
        return address.compareTo(arg0.address);
    }
}