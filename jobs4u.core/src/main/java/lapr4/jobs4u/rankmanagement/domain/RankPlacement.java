package lapr4.jobs4u.rankmanagement.domain;

import java.util.regex.Pattern;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

/**
 * @author 2DI2
 */
@Embeddable
public class RankPlacement implements ValueObject, Comparable<RankPlacement> {

    private static final long serialVersionUID = 1L;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    private final Integer rankPlacement;

    protected RankPlacement(final String rankPlacement) {
        Preconditions.nonEmpty(rankPlacement, "Rank Placement should neither be null nor empty");
        Preconditions.matches(NUMBER_PATTERN, rankPlacement, "Rank Placement must be a positive number");
        this.rankPlacement = Integer.parseInt(rankPlacement);
    }

    protected RankPlacement() {
        this.rankPlacement = null;
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
        return this.rankPlacement.toString();
    }

    @Override
    public int compareTo(final RankPlacement arg0) {
        return rankPlacement.compareTo(arg0.rankPlacement);
    }
}
