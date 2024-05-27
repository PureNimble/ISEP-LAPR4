package lapr4.jobs4u.jobopeningmanagement.repositories;

import java.util.Calendar;
import java.util.Optional;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {

    Iterable<JobOpening> filterByCostumerManager(final Username username);

    Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference);

    String findHighestSequenceForCustomer(final CustomerCode customerCode);

    Iterable<JobOpening> filterByCostumer(final Customer customer);

    Iterable<JobOpening> hasRecruitmentProcess(final boolean hasRecruitmentProcess);

    Iterable<JobOpening> filterByPeriod(final Calendar initialDate, final Calendar finalDate);

    Iterable<JobOpening> filterWithInterview();

    Iterable<JobOpening> filterWithAvailablePhaseForInterviews(Username username);

    Iterable<JobOpening> filterWithAvailablePhaseForRequirements(Username username);

}
