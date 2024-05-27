package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.customermanagement.domain.CustomerCode;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

/**
 * @author 2DI2
 */
public class RegisterJobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;

    public RegisterJobOpeningService(JobOpeningRepository jobOpeningRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
    }

    public String nextJobOpeningReference(final CustomerCode customerCode) {
        return customerCode.toString() + "-" + jobOpeningRepository.findHighestSequenceForCustomer(customerCode);
    }
}
