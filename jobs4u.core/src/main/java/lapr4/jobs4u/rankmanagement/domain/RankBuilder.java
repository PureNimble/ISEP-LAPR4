package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RankBuilder implements DomainFactory<Rank> {
    private static final Logger LOGGER = LogManager.getLogger(JobOpeningBuilder.class);
    private RankReference rankReference;
    private RankPlacement rankPlacement;
    private Application candidate;
    private JobOpening jobOpening;

    public RankBuilder with(final String rankReference, final String rankPlacement, final Application candidate, final JobOpening jobOpening) {
        this.withRankReference(rankReference);
        this.withRankPlacement(rankPlacement);
        this.withCandidate(candidate);
        this.withJobOpening(jobOpening);
        return this;
    }

    public RankBuilder withRankReference(final String rankReference) {
        this.rankReference = RankReference.of(rankReference);
        return this;
    }

    public RankBuilder withRankPlacement(final String rankPlacement) {
        this.rankPlacement = RankPlacement.valueOf(rankPlacement);
        return this;
    }

    public RankBuilder withCandidate(final Application candidate) {
        this.candidate = candidate;
        return this;
    }

    public RankBuilder withJobOpening(final JobOpening jobOpening) {
        this.jobOpening = jobOpening;
        return this;
    }

    @Override
    public Rank build() {
        final Rank rank = new Rank(this.rankReference,this.rankPlacement, this.jobOpening, this.candidate);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Rank [{}] {} {} {} {}", rank, this.rankReference, this.rankPlacement, this.jobOpening, this.candidate);

        }
        return rank;
    }
}
