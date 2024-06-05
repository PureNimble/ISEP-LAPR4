package lapr4.jobs4u.jobopeningmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.customermanagement.domain.Address;
import lapr4.jobs4u.jobopeningmanagement.domain.ContractType;
import lapr4.jobs4u.jobopeningmanagement.domain.JobDescription;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningInterview;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpeningRequirement;
import lapr4.jobs4u.jobopeningmanagement.domain.Mode;
import lapr4.jobs4u.jobopeningmanagement.domain.ModeTypes;
import lapr4.jobs4u.jobopeningmanagement.domain.NumberOfVacancies;
import lapr4.jobs4u.jobopeningmanagement.domain.TitleOrFunction;
import lapr4.jobs4u.jobopeningmanagement.domain.TypesOfContract;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author 2DI2
 */
public class EditJobOpeningControllerTest {

    @Mock
    JobOpeningRepository mockJobOpeningRepo;

    @Mock
    JobOpeningInterviewRepository mockJobOpeningInterviewRepo;

    @Mock
    JobOpeningRequirementRepository mockJobOpeningRequirementRepo;

    @Mock
    RecruitmentProcessRepository mockRecruitmentProcessRepository;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    JobOpeningInterview mockJobOpeningInterview;

    @Mock
    JobOpeningRequirement mockJobOpeningRequirement;

    EditJobOpeningController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockJobOpening.titleOrFunction()).thenReturn(TitleOrFunction.valueOf("someTitleOrFunction"));
        when(mockJobOpening.contractType()).thenReturn(ContractType.valueOf(TypesOfContract.FULL_TIME.toString()));
        when(mockJobOpening.mode()).thenReturn(Mode.valueOf(ModeTypes.PRESENTIAL.toString()));
        when(mockJobOpening.address()).thenReturn(Address.valueOf("someAddress"));
        when(mockJobOpening.jobDescription()).thenReturn(JobDescription.valueOf("someJobDescription"));
        when(mockJobOpening.numberOfVacancies()).thenReturn(NumberOfVacancies.valueOf("123"));
        controller = new EditJobOpeningController(mockJobOpeningRepo, mockJobOpeningInterviewRepo,
                mockJobOpeningRequirementRepo, mockRecruitmentProcessRepository, mockAuthz);
    }

    @Test
    void testEditJobOpening() {
        when(mockJobOpeningRepo.save(any(JobOpening.class))).thenReturn(mockJobOpening);
        JobOpening result = controller.editJobOpening("newTitleOrFunction", TypesOfContract.FREELANCE.toString(),
                ModeTypes.HYBRID.toString(), "newAddress", "newJobDescription", "321", mockJobOpening);
        assertEquals(mockJobOpening, result);
        verify(mockJobOpeningRepo).save(any(JobOpening.class));
    }

    @Test
    void testEditJobOpeningInterview() {
        when(mockJobOpeningInterviewRepo.save(any(JobOpeningInterview.class))).thenReturn(mockJobOpeningInterview);
        JobOpeningInterview result = controller.editJobOpeningInterview(mockJobOpeningInterview, null);
        assertEquals(mockJobOpeningInterview, result);
        verify(mockJobOpeningInterviewRepo).save(any(JobOpeningInterview.class));
    }

    @Test
    void testEditJobOpeningRequirement() {
        when(mockJobOpeningRequirementRepo.save(any(JobOpeningRequirement.class)))
                .thenReturn(mockJobOpeningRequirement);
        JobOpeningRequirement result = controller.editJobOpeningRequirement(mockJobOpeningRequirement, null);
        assertEquals(mockJobOpeningRequirement, result);
        verify(mockJobOpeningRequirementRepo).save(any(JobOpeningRequirement.class));
    }

    @Test
    void testInterviewModel() {
        when(mockJobOpeningInterviewRepo.findJobOpeningInterviewsByJobOpening(any(JobOpening.class)))
                .thenReturn(Optional.of(mockJobOpeningInterview));
        Optional<JobOpeningInterview> result = controller.interviewModel(mockJobOpening);
        assertEquals(Optional.of(mockJobOpeningInterview), result);
    }

    @Test
    void testRequirementModel() {
        when(mockJobOpeningRequirementRepo.findJobOpeningRequirementsByJobOpening(any(JobOpening.class)))
                .thenReturn(Optional.of(mockJobOpeningRequirement));
        Optional<JobOpeningRequirement> result = controller.requirementModel(mockJobOpening);
        assertEquals(Optional.of(mockJobOpeningRequirement), result);
    }
}