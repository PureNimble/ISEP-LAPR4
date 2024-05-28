package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author 2DI2
 */
@Embeddable
public class JobOpeningState implements ValueObject, Comparable<JobOpeningState> {

    private static final long serialVersionUID = 1L;

    private final String JobOpeningState;

    protected JobOpeningState(final String JobOpeningState) {
        Preconditions.nonEmpty(JobOpeningState, "JobOpeningState should neither be null nor empty");
        Preconditions.ensure(TypesOfJobOpeningStates.valueOf(JobOpeningState) != null, "The Job Opening State must be one of the valid types");
        this.JobOpeningState = JobOpeningState;
    }

    protected JobOpeningState() {
        this.JobOpeningState = "";
    }

    public static JobOpeningState valueOf(final String JobOpeningState) {
        return new JobOpeningState(JobOpeningState);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobOpeningState)) {
            return false;
        }

        final JobOpeningState that = (JobOpeningState) o;
        return this.JobOpeningState.equals(that.JobOpeningState);
    }

    @Override
    public int hashCode() {
        return this.JobOpeningState.hashCode();
    }

    @Override
    public String toString() {
        return this.JobOpeningState;
    }

    @Override
    public int compareTo(final JobOpeningState arg0) {
        return JobOpeningState.compareTo(arg0.JobOpeningState);
    }
}