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
 * @author 2DI2
 */
public class InMemoryApplicationRepository extends InMemoryDomainRepository<Application, ApplicationCode>
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

    @Override
    public Iterable<Application> findApplicationWithInterviewRecord(final JobOpening jobOpening) {
        return match(e -> e.jobOpening().equals(jobOpening));
    }

    @Override
    public Iterable<Application> findApplicationsWithResult(final JobOpening jobOpening) {
        return match(e -> e.jobOpening().equals(jobOpening) && !e.result().outcome().toString().equals("PENDING"));
    }

    @Override
    public Long numApplicationsForJobOpening(final JobOpening jobOpening) {
        return numApplicationsForJobOpening(jobOpening);
    }

    @Override
    public Iterable<Application> findApplicationsWithRanking(final JobOpening theJobOpening) {
        return findApplicationsWithRanking(theJobOpening);
    }

    @Override
    public Iterable<Application> unrankedApplicationByJobOpening(final JobOpening jobOpening) {
        return unrankedApplicationByJobOpening(jobOpening);
    }
}
