package lapr4.jobs4u.persistence.impl.inmemory;

import java.util.Calendar;
import java.util.Optional;

import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

/**
 * @author 2DI2
 */
public class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference>
        implements JobOpeningRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<JobOpening> filterByCostumerManager(final Username username) {
        return match(e -> e.customer().manager().identity().equals(username));
    }

    @Override
    public Iterable<JobOpening> filterByCostumer(final Customer customer) {
        return match(e -> e.customer().equals(customer));
    }

    @Override
    public String findHighestSequenceForCustomer(final CustomerCode customercode) {
        return findHighestSequenceForCustomer(customercode);
    }

    @Override
    public Iterable<JobOpening> hasRecruitmentProcess(final boolean hasRecruitmentProcess) {
        return hasRecruitmentProcess(hasRecruitmentProcess);
    }

    @Override
    public Iterable<JobOpening> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        return match(e -> {
            return e.registeredOn().after(initialDate) && e.registeredOn().before(finalDate);
        });
    }

    public Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference) {
        return Optional.ofNullable(matchOne(e -> e.identity().equals(jobReference)).orElse(null));
    }

    public Iterable<JobOpening> filterWithInterview() {
        return filterWithInterview();
    }

    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForInterviews(final Username username) {
        return filterWithAvailablePhaseForInterviews(username);
    }

    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForRequirements(final Username username) {
        return filterWithAvailablePhaseForRequirements(username);
    }

    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForInterviewEvaluation(final Username username) {
        return filterWithAvailablePhaseForInterviewEvaluation(username);
    }

    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForRequirementEvaluation(final Username username) {
        return filterWithAvailablePhaseForRequirementEvaluation(username);
    }

    @Override
    public Iterable<JobOpening> filterWithEvaluatedInterviews(final Username username) {
        return filterWithEvaluatedInterviews(username);
    }

    @Override
    public Iterable<JobOpening> filterWithAvailablePhaseForRanking(final Username username) {
        return filterWithAvailablePhaseForRanking(username);
    }

    @Override
    public Iterable<JobOpening> filterWithAvailableForResults(final Username username) {
        return filterWithAvailableForResults(username);
    }
}
