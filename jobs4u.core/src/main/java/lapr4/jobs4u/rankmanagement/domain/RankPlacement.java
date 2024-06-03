package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

public class RankPlacement implements ValueObject, Comparable<RankPlacement> {
    private static final long serialVersionUID = 1L;

    private final String rankPlacement;

    protected RankPlacement(final String rankPlacement) {
        Preconditions.nonEmpty(rankPlacement, "rankPlacement should neither be null nor empty");
        this.rankPlacement = rankPlacement;
    }

    public static RankPlacement valueOf(final String rankPlacement) {
        return new RankPlacement(rankPlacement);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RankPlacement)) {
            return false;
        }

        final RankPlacement that = (RankPlacement) o;
        return this.rankPlacement.equals(that.rankPlacement);
    }

    @Override
    public int hashCode() {
        return this.rankPlacement.hashCode();
    }

    @Override
    public String toString() {
        return this.rankPlacement;
    }

    @Override
    public int compareTo(final RankPlacement arg0) {
        return rankPlacement.compareTo(arg0.rankPlacement);
    }
}
