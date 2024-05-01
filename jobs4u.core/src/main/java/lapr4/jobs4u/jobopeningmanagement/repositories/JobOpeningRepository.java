package lapr4.jobs4u.jobopeningmanagement.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {
        
    Iterable<JobOpening> filterByCostumerManager(final Username username);
}

