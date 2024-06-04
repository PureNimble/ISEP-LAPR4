package lapr4.jobs4u.applicationmanagement.repositories;

import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

/**
 * @author 2DI2
 */
public interface ApplicationRepository extends DomainRepository<ApplicationCode, Application> {

    Optional<Application> findByApplicationCode(final ApplicationCode code);

    Iterable<Application> filterByJobOpening(final JobOpening jobOpening);

    Iterable<Application> findApplicationsFromCandidate(final Candidate candidate);

    String findHighestSequenceForCustomer(final JobReference jobReference);

    Iterable<Application> findApplicationWithInterviewRecord(final JobOpening jobOpening);

    Iterable<Application> findApplicationsWithResult(final JobOpening jobOpening);

    Long numApplicationsForJobOpening(final JobOpening jobOpening);

    Iterable<Application> findApplicationsWithRanking(final JobOpening theJobOpening);

    Iterable<Application> unrankedApplicationByJobOpening(final JobOpening jobOpening);

}
