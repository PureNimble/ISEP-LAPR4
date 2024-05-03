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
    public Iterable<JobOpening> filterByActive(final boolean active) {
        return match(e -> e.isActive() == active);
    }

    @Override
    public Iterable<JobOpening> filterByPeriode(final Calendar date) {
        return match(e -> e.registeredOnPeriode().equals(date.toString()));
    }
    
    public Optional<JobOpening> findJobOpeningByReference(final JobReference jobReference) {
        return Optional.ofNullable(matchOne(e -> e.identity().equals(jobReference)).orElse(null));
    }
}
