package lapr4.jobs4u.jobopeningmanagement.application;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

/**
 * @author 2DI2
 */
@UseCaseController
public class ListJobOpeningsController {

    private final ListJobOpeningsService jobOpeningsService;
    private final AuthorizationService authz;

    public ListJobOpeningsController(final JobOpeningRepository jobOpeningRepository, final AuthorizationService authz) {
        this.jobOpeningsService = new ListJobOpeningsService(jobOpeningRepository, authz);
        this.authz = authz;
    }

    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByCostumerManager();
    }

    public Iterable<JobOpeningDTO> filterByCustomer(final Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByCustomer(customer);
    }

    public Iterable<JobOpeningDTO> hasRecruitmentProcess(final boolean hasRecruitmentProcess) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.hasRecruitmentProcess(hasRecruitmentProcess);
    }

    public Iterable<JobOpeningDTO> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByPeriod(initialDate, finalDate);
    }

    public Iterable<JobOpeningDTO> filterWithInterview() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterWithInterview();
    }

    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.selectedJobOpening(jobOpeningDTO);
    }

    public Iterable<JobOpeningDTO> getIntersection(Iterable<JobOpeningDTO> list1) {
        Collection<JobOpeningDTO> list2 = (Collection<JobOpeningDTO>) filterByCostumerManager();
        List<JobOpeningDTO> list1AsList = new ArrayList<>();
        list1.forEach(list1AsList::add);
        return list1AsList.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForInterviews() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);

        return jobOpeningsService.filterWithAvailablePhaseForInterviews();
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForRequirements() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        return jobOpeningsService.filterWithAvailablePhaseForRequirements();
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForInterviewEvaluation() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        return jobOpeningsService.filterWithAvailablePhaseForInterviewEvaluation();
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForRequirementsEvaluation() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.POWERUSER);

        return jobOpeningsService.filterWithAvailablePhaseForRequirementsEvaluation();
    }

    public Iterable<JobOpeningDTO> filterWithEvaluatedInterviews() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);

        return jobOpeningsService.filterWithEvaluatedInterviews();
    }

}
