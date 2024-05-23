package lapr4.jobs4u.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import lapr4.jobs4u.interviewmanagement.domain.Interview;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryInterviewRepository extends InMemoryDomainRepository<Interview, Long>
        implements InterviewRepository {

    static {
        InMemoryInitializer.init();
    }

}
