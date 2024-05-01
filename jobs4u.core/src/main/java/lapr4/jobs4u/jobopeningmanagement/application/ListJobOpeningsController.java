package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.util.Calendar;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

@UseCaseController
public class ListJobOpeningsController {

    private final ListJobOpeningsService jobOpeningsService;
    private final AuthorizationService authz;

    public ListJobOpeningsController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningsService = new ListJobOpeningsService(jobOpeningRepository, authz);
        this.authz = authz;
    }

    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.filterByCostumerManager();
    }

    public Iterable<JobOpeningDTO> filterByCustomer(final Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.filterByCustomer(customer);
    }

    public Iterable<JobOpeningDTO> filterByActive(final boolean active) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.filterByActive(active);
    }

    public Iterable<JobOpeningDTO> filterByDate(final Calendar date) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.filterByDate(date);
    }

    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningsService.selectedJobOpening(jobOpeningDTO);
    }
}
