package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Optional;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;

/**
 * @author 2DI2
 */
public class InMemoryInterviewRepository extends InMemoryDomainRepository<Interview, Long>
        implements InterviewRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Interview> findInterviewByApplication(final Application application) {
        return matchOne(e -> e.application().equals(application));
    }

    @Override
    public Iterable<Interview> findNonGradedInterviewsByJobOpening(final JobOpening jobOpening) {
        return match(e -> e.application().jobOpening().equals(jobOpening) && e.grade() == null);
    }

    @Override
    public Iterable<Interview> sortedInterviewsByJobOpening(final JobOpening jobOpening, final boolean ascending) {
        return sortedInterviewsByJobOpening(jobOpening, ascending);
    }

    @Override
    public Iterable<Interview> findEvaluatedInterviewsByJobOpening(JobOpening jobOpening) {
        return match(e -> e.application().jobOpening().equals(jobOpening) && !e.grade().toString().isEmpty());
    }

    @Override
    public Iterable<Interview> findInterviewsByJobOpening(final JobOpening jobOpening) {
        return match(e -> e.application().jobOpening().equals(jobOpening));
    }

}
