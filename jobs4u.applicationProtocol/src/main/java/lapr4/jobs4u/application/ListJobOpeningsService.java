package lapr4.jobs4u.application;

import eapli.framework.general.domain.model.EmailAddress;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.customermanagement.repositories.CustomerRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * @author 2DI2
 */
@Component
public class ListJobOpeningsService {

    private final JobOpeningRepository jobOpeningRepository;
    private final CustomerRepository customerRepository;
    private final ApplicationRepository applicationRepository;

    public ListJobOpeningsService(JobOpeningRepository jobOpeningRepository,
                                  CustomerRepository customerRepository, ApplicationRepository applicationRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.customerRepository = customerRepository;
        this.applicationRepository = applicationRepository;
    }

    public Iterable<JobOpeningDTO> findJobOpeningsFromCustomer(final EmailAddress emailAddress) {
        final Optional<Customer> customer = this.customerRepository.findByEmail(emailAddress);
        if (customer.isPresent()) {
            final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumer(customer.get());
            List<JobOpeningDTO> jobOpeningDTOS = new ArrayList<>();
            jobOpenings.forEach(application -> jobOpeningDTOS.add(application.toDTO()));
            return jobOpeningDTOS;
        } else {
            return null;
        }
    }

    public Integer numApplicants(final JobOpeningDTO jobOpeningDTO) {
        final JobOpening jobOpening = jobOpeningRepository
                .ofIdentity(JobReference.valueOf(jobOpeningDTO.getJobReference()))
                .orElseThrow(IllegalArgumentException::new);

        final Iterable<Application> iterable = applicationRepository.findApplicationWithInterviewRecord(jobOpening);

        return (int) StreamSupport.stream(iterable.spliterator(), false).count();
    }

}