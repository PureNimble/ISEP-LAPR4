package lapr4.jobs4u.questionmanagement.domain;

import jakarta.persistence.Embeddable;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlValue;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.xml.bind.annotation.XmlAccessType;

/**
 * @author 2DI2
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class MinimumRequirement implements ValueObject, Comparable<MinimumRequirement> {

    private static final long serialVersionUID = 1L;

    @XmlValue
    private final String requirement;

    protected MinimumRequirement(final String requirement) {
        Preconditions.nonEmpty(requirement, "Minimum Requirement should neither be null nor empty");
        this.requirement = requirement;
    }

    protected MinimumRequirement() {
        this.requirement = "";
    }

    public static MinimumRequirement valueOf(final String requirement) {
        return new MinimumRequirement(requirement);
    }

    public String requirement() {
        return this.requirement;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MinimumRequirement)) {
            return false;
        }

        final MinimumRequirement that = (MinimumRequirement) o;
        return this.requirement.equals(that.requirement);
    }

    @Override
    public int hashCode() {
        return this.requirement.hashCode();
    }

    @Override
    public String toString() {
        return this.requirement;
    }

    @Override
    public int compareTo(final MinimumRequirement arg0) {
        return requirement.compareTo(arg0.requirement);
    }
}
