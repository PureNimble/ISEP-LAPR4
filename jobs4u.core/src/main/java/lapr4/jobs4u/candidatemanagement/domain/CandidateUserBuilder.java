package lapr4.jobs4u.candidatemanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandidateUserBuilder implements DomainFactory<CandidateUser> {

    private static final Logger LOGGER = LogManager.getLogger(CandidateUserBuilder.class);
    private Candidate candidate;
    private SystemUser systemUser;

    public CandidateUserBuilder with(final Candidate candidate, final SystemUser systemUser) {
        this.withCandidate(candidate);
        this.withSystemUser(systemUser);
        return this;
    }

    public CandidateUserBuilder withCandidate(final Candidate candidate) {
        this.candidate = candidate;
        return this;
    }

    public CandidateUserBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public CandidateUser build() {
        final CandidateUser candidateUser = new CandidateUser(this.candidate, this.systemUser);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Registering new Candidate User [{}] {} {}", candidateUser, this.candidate,
                    this.systemUser);
        }
        return candidateUser;
    }
}