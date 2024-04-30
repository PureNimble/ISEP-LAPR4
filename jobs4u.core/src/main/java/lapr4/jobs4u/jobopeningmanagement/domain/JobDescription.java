package lapr4.jobs4u.jobopeningmanagement.domain;

import jakarta.persistence.Embeddable;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

@Embeddable
public class JobDescription implements ValueObject, Comparable<JobDescription> {

    private static final long serialVersionUID = 1L;

    private final String jobDescription;

    protected JobDescription(final String jobDescription) {
        Preconditions.nonEmpty(jobDescription, "JobDescription should neither be null nor empty");
        this.jobDescription = jobDescription;
    }

    protected JobDescription() {
        this.jobDescription = "";
    }

    public static JobDescription valueOf(final String jobDescription) {
        return new JobDescription(jobDescription);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JobDescription)) {
            return false;
        }

        final JobDescription that = (JobDescription) o;
        return this.jobDescription.equals(that.jobDescription);
    }

    @Override
    public int hashCode() {
        return this.jobDescription.hashCode();
    }

    @Override
    public String toString() {
        return this.jobDescription;
    }

    @Override
    public int compareTo(final JobDescription arg0) {
        return jobDescription.compareTo(arg0.jobDescription);
    }
}