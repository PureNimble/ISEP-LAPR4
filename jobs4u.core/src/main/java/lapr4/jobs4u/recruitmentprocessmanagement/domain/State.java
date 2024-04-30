package lapr4.jobs4u.recruitmentprocessmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class State implements ValueObject, Comparable<State> {

    private static final long serialVersionUID = 1L;
    private final String stateName;

    protected State(final String stateName) {
        Preconditions.nonEmpty(stateName, "State should neither be null nor empty");
        Preconditions.ensure(ActivityState.valueOf(stateName) != null, "State must be one of the OPEN or CLOSED states");
        this.stateName = stateName;
    }

    protected State() {
        this.stateName = null;
    }

    public static State valueOf(final String stateName) {
        return new State(stateName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }

        final State that = (State) o;
        return this.stateName.equals(that.stateName);
    }

    @Override
    public int hashCode() {
        return this.stateName.hashCode();
    }

    @Override
    public String toString() {
        return this.stateName;
    }

    @Override
    public int compareTo(final State arg0) {
        return stateName.compareTo(arg0.stateName);
    }
}
