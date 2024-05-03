package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryApplicationRepository
        extends InMemoryDomainRepository<Application, ApplicationCode>
        implements ApplicationRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Application> findByApplicationCode(final ApplicationCode number) {
        return Optional.of(data().get(number));
    }

    @Override
    public String findHighestSequenceForCustomer(final JobReference jobReference) {
        return findHighestSequenceForCustomer(jobReference);
    }

    @Override
    public Iterable<Application> filterByJobOpening(final JobOpening jobOpening) {
        return match(e -> e.jobOpening().equals(jobOpening));
    }

    @Override
    public Iterable<Application> findApplicationsFromCandidate(final Candidate candidate) {
        return match(e -> e.candidate().equals(candidate));
    }
}
