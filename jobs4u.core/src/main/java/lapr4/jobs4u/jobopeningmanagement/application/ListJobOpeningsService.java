package lapr4.jobs4u.jobopeningmanagement.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * @author 2DI2
 */
@Component
public class ListJobOpeningsService {

    private final JobOpeningRepository jobOpeningRepository;
    private final AuthorizationService authz;

    public ListJobOpeningsService(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumerManager(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterByCustomer(final Customer customer) {
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumer(customer);

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> hasRecruitmentProcess(final boolean hasRecruitmentProcess) {
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.hasRecruitmentProcess(hasRecruitmentProcess);

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        finalDate.set(Calendar.DAY_OF_MONTH, finalDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        finalDate.set(Calendar.HOUR_OF_DAY, 23);
        finalDate.set(Calendar.MINUTE, 59);
        finalDate.set(Calendar.SECOND, 59);
        finalDate.set(Calendar.MILLISECOND, 999);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByPeriod(initialDate, finalDate);

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Optional<JobOpening> findJobOpeningByReference(JobReference jobReference) {
        Optional<JobOpening> jobOpening = jobOpeningRepository.findJobOpeningByReference(jobReference);
        return jobOpening;
    }

    public Iterable<JobOpeningDTO> filterWithInterview() {
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithInterview();

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        JobOpening selectedJobOpening = jobOpeningRepository
                .ofIdentity(JobReference.valueOf(jobOpeningDTO.getJobReference()))
                .orElseThrow(IllegalArgumentException::new);
        return selectedJobOpening;
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForInterviews() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithAvailablePhaseForInterviews(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;

    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForRequirements() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.OPERATOR, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithAvailablePhaseForRequirements(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForInterviewEvaluation() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.OPERATOR, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithAvailablePhaseForInterviewEvaluation(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForRequirementsEvaluation() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.OPERATOR, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithAvailablePhaseForRequirementEvaluation(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterWithEvaluatedInterviews() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithEvaluatedInterviews(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterWithAvailablePhaseForRanking() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.OPERATOR, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterWithAvailablePhaseForRanking(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

}
