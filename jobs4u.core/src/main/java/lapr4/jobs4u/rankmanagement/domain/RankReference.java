package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public class RankReference implements ValueObject, Comparable<RankReference> {
    private static final long serialVersionUID = 1L;

    private final String rankReference;

    protected RankReference(String rankReference) {
        Preconditions.nonEmpty(rankReference, "rankReference should neither be null nor empty");
        this.rankReference = rankReference;
    }

    public static RankReference of(String rankReference) {
        return new RankReference(rankReference);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RankReference)) {
            return false;
        }

        final RankReference that = (RankReference) o;
        return this.rankReference.equals(that.rankReference);
    }

    @Override
    public int hashCode() {
        return this.rankReference.hashCode();
    }

    @Override
    public String toString() {
        return this.rankReference;
    }

    @Override
    public int compareTo(final RankReference arg0) {
        return rankReference.compareTo(arg0.rankReference);
    }
}
