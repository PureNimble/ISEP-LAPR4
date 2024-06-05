package lapr4.jobs4u.rankmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import lapr4.jobs4u.applicationmanagement.domain.Application;

/**
 * @author 2DI2
 */
public class RankTest {

    private static final String RANK_PLACEMENT = "1";

    private Rank getDummyRank(final String rankPlacement) {
        Application mockApplication = Mockito.mock(Application.class);
        return new RankBuilder().with(rankPlacement, mockApplication).build();
    }

    @Test
    public void ensureRankEqualsPassesForTheSameRankPlacement() throws Exception {
        final Rank aRank = getDummyRank(RANK_PLACEMENT);
        final Rank anotherRank = getDummyRank(RANK_PLACEMENT);
        final boolean expected = aRank.equals(anotherRank);
        assertTrue(expected);
    }

    @Test
    public void ensureRankEqualsAreTheSameForTheSameInstance() throws Exception {
        final Rank aRank = getDummyRank(RANK_PLACEMENT);
        final boolean expected = aRank.equals(aRank);
        assertTrue(expected);
    }

    @Test
    public void ensureRankEqualsFailsForDifferentObjectTypes() throws Exception {
        final Rank aRank = getDummyRank(RANK_PLACEMENT);
        final boolean expected = aRank.equals(new Object());
        assertFalse(expected);
    }

    @Test
    public void ensureRankIsTheSameAsItsInstance() throws Exception {
        final Rank aRank = getDummyRank(RANK_PLACEMENT);
        final boolean expected = aRank.sameAs(aRank);
        assertTrue(expected);
    }

}
