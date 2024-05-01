package lapr4.jobs4u.applicationmanagement.application;

import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;

public class ImportApplicationsService {

    private final ApplicationRepository applicationRepository;

    public ImportApplicationsService(final ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public String nextJobOpeningReference(final JobReference jobReference) {
        return jobReference.toString() + "-" + applicationRepository.findHighestSequenceForCustomer(jobReference);
    }
}
