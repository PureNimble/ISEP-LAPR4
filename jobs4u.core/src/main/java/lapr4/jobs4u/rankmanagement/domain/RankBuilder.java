package lapr4.jobs4u.rankmanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 2DI2
 */
public class RankBuilder implements DomainFactory<Rank> {

    private static final Logger LOGGER = LogManager.getLogger(JobOpeningBuilder.class);

    private RankPlacement rankPlacement;
    private Application application;

    public RankBuilder with(final String rankPlacement, final Application application) {
        this.withRankPlacement(rankPlacement);
        this.withapplication(application);
        return this;
    }

    public RankBuilder withRankPlacement(final String rankPlacement) {
        this.rankPlacement = RankPlacement.valueOf(rankPlacement);
        return this;
    }

    public RankBuilder withapplication(final Application application) {
        this.application = application;
        return this;
    }

    @Override
    public Rank build() {
        final Rank rank = new Rank(this.rankPlacement, this.application);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Rank [{}] {}", rank, this.rankPlacement);

        }
        return rank;
    }
}
