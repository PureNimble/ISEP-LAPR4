package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class ContractType implements ValueObject, Comparable<ContractType> {

    private static final long serialVersionUID = 1L;

    private final String contractType;

    protected ContractType(final String contractType) {
        Preconditions.nonEmpty(contractType, "ContractType should neither be null nor empty");
        Preconditions.ensure(TypesOfContract.valueOf(contractType) != null, "Contract Type must be one of the valid types");
        this.contractType = contractType;
    }

    protected ContractType() {
        this.contractType = "";
    }

    public static ContractType valueOf(final String contractType) {
        return new ContractType(contractType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContractType)) {
            return false;
        }

        final ContractType that = (ContractType) o;
        return this.contractType.equals(that.contractType);
    }

    @Override
    public int hashCode() {
        return this.contractType.hashCode();
    }

    @Override
    public String toString() {
        return this.contractType;
    }

    @Override
    public int compareTo(final ContractType arg0) {
        return contractType.compareTo(arg0.contractType);
    }
}