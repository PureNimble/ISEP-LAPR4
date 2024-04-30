package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class JobReference implements ValueObject, Comparable<JobReference> {

    private static final long serialVersionUID = 1L;

    private final String jobReference;

    protected JobReference(final String jobReference) {
        Preconditions.nonEmpty(jobReference, "JobReference should neither be null nor empty");
        this.jobReference = jobReference;
    }

    protected JobReference() {
        this.jobReference = "";
    }

    public static JobReference valueOf(final String jobReference) {
        return new JobReference(jobReference);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobReference)) {
            return false;
        }

        final JobReference that = (JobReference) o;
        return this.jobReference.equals(that.jobReference);
    }

    @Override
    public int hashCode() {
        return this.jobReference.hashCode();
    }

    @Override
    public String toString() {
        return this.jobReference;
    }

    @Override
    public int compareTo(final JobReference arg0) {
        return jobReference.compareTo(arg0.jobReference);
    }
}