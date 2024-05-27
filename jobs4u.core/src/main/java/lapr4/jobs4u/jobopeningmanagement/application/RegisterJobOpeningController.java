package lapr4.jobs4u.jobopeningmanagement.application;

import java.util.Calendar;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.time.util.CurrentTimeCalendars;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningBuilder;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
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
            final String mode, final String address, final Customer customer, final String jobDescription,
            final String numberOfVacancies) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        String jobReference = registerJobOpeningService.nextJobOpeningReference(customer.identity());
        return registerJobOpening(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription,
                numberOfVacancies);
    }

    private JobOpening registerJobOpening(final String jobReference, final String titleOrFunction,
            final String contractType, final String mode, final String address, final Customer customer,
            final String jobDescription, final String numberOfVacancies) {
        final JobOpening jobOpening = doSetUpJobOpening(jobReference, titleOrFunction, contractType, mode, address,
                customer, jobDescription, CurrentTimeCalendars.now(), numberOfVacancies);
        return jobOpeningRepository.save(jobOpening);
    }

    private JobOpening doSetUpJobOpening(final String jobReference, final String titleOrFunction,
            final String contractType, final String mode, final String address, final Customer customer,
            final String jobDescription, Calendar createdOn, final String numberOfVacancies) {
        return new JobOpeningBuilder()
                .with(jobReference, titleOrFunction, contractType, mode, address, customer, jobDescription, createdOn,
                        numberOfVacancies)
                .build();
    }
}
