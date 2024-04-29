package lapr4.jobs4u.candidatemanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CandidateUserBuilder implements DomainFactory<CandidateUser> {

    private static final Logger LOGGER = LogManager.getLogger(CandidateUserBuilder.class);
    private Candidate candidate;
    private SystemUser systemUser;
    private SystemUser manager;

    public CandidateUserBuilder with(final Candidate candidate,
            final SystemUser systemUser, final SystemUser manager) {
        this.withCandidate(candidate);
        this.withSystemUser(systemUser);
        this.withManager(manager);
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

    public CandidateUserBuilder withManager(final SystemUser manager) {
        this.manager = manager;
        return this;
    }

    @Override
    public CandidateUser build() {
        final CandidateUser candidateUser = new CandidateUser(this.candidate, this.systemUser, this.manager);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Registering new candidateUser [{}] {} {} {} {} {} {}", candidateUser, this.candidate,
                    this.systemUser, this.manager);
        }
        return candidateUser;
    }
}