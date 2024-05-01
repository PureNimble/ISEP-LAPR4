package lapr4.jobs4u.jobopeningmanagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

@UseCaseController
public class RegisterJobOpeningController {
    private final AuthorizationService authz;
    private final RegisterJobOpeningService registerJobOpeningService;
    private final JobOpeningRepository jobOpeningRepository;

    public RegisterJobOpeningController(final JobOpeningRepository jobOpeningRepository,
            final AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.registerJobOpeningService = new RegisterJobOpeningService(jobOpeningRepository);
        this.authz = authz;
    }

    public JobOpening SetUpJobOpening(final String titleOrFunction, final String contractType,
            final String mode, final String address, final Customer customer, final String jobDescription) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        String jobReference = registerJobOpeningService.nextJobOpeningReference(customer.identity());
        return registerJobOpening(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription);
    }

    private JobOpening registerJobOpening(final String jobReference, final String titleOrFunction,
            final String contractType,
            final String mode, final String address, final Customer customer, final String jobDescription) {
        final JobOpening jobOpening = doSetUpJobOpening(jobReference, titleOrFunction, contractType, mode, address,
                customer, jobDescription);
        return jobOpeningRepository.save(jobOpening);
    }

    private JobOpening doSetUpJobOpening(final String jobReference, final String titleOrFunction,
            final String contractType,
            final String mode, final String address, final Customer customer, final String jobDescription) {
        return new JobOpeningBuilder()
                .with(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription)
                .build();
    }
}
