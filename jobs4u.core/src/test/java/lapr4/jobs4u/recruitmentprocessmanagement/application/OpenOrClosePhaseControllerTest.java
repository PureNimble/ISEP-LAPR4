package lapr4.jobs4u.recruitmentprocessmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.interviewmanagement.repositories.InterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningInterviewRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRequirementRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ActivityState;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.ApplicationPhase;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.RecruitmentProcess;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.State;
import lapr4.jobs4u.recruitmentprocessmanagement.repositories.RecruitmentProcessRepository;
import lapr4.jobs4u.requirementmanagement.repositories.RequirementRepository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class OpenOrClosePhaseControllerTest {

    @Mock
    private RecruitmentProcessRepository recruitmentProcessRepository;
    @Mock
    private JobOpeningRepository jobOpeningRepository;
    @Mock
    private JobOpeningRequirementRepository jobOpeningRequirementRepository;
    @Mock
    private JobOpeningInterviewRepository jobOpeningInterviewRepository;
    @Mock
    private ApplicationRepository applicationRepository;
    @Mock
    private RequirementRepository requirementRepository;
    @Mock
    private InterviewRepository interviewRepository;
    @Mock
    private AuthorizationService authz;
    @Mock
    private TransactionalContext txCtx;

    private OpenOrClosePhaseController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new OpenOrClosePhaseController(recruitmentProcessRepository, jobOpeningRepository,
                jobOpeningRequirementRepository, jobOpeningInterviewRepository, applicationRepository,
                requirementRepository, interviewRepository, authz, txCtx);
    }

    @Test
    public void testNullPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.empty());
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals(null, phase);
    }

    @Test
    public void testApplicationPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ApplicationPhase"));
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals("ApplicationPhase", phase);
    }

    @Test
    public void testScreeningPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ScreeningPhase"));
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals("ScreeningPhase", phase);
    }

    @Test
    public void testInterviewPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("InterviewPhase"));
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals("InterviewPhase", phase);
    }

    @Test
    public void testAnalysisPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("AnalysisPhase"));
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals("AnalysisPhase", phase);
    }

    @Test
    public void testResultPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ResultPhase"));
        String phase = controller.currentPhase(jobOpening);
        verify(recruitmentProcessRepository).currentPhase(jobOpening);
        assertEquals("ResultPhase", phase);
    }

    @Test
    public void testErrorApplicationNextPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        RecruitmentProcess recruitmentProcess = mock(RecruitmentProcess.class);
        ApplicationPhase applicationPhase = mock(ApplicationPhase.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ApplicationPhase"));
        when(recruitmentProcessRepository.findByJobOpening(jobOpening)).thenReturn(Optional.of(recruitmentProcess));
        when(recruitmentProcess.applicationPhase()).thenReturn(applicationPhase);
        when(applicationPhase.state()).thenReturn(State.valueOf(ActivityState.OPEN.toString()));

        assertThrows(Exception.class, () -> {
            controller.changePhase("ApplicationPhase", jobOpening, true);
        });
    }

    @Test
    public void testErrorScreeningNextPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        RecruitmentProcess recruitmentProcess = mock(RecruitmentProcess.class);
        ApplicationPhase applicationPhase = mock(ApplicationPhase.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ScreeningPhase"));
        when(recruitmentProcessRepository.findByJobOpening(jobOpening)).thenReturn(Optional.of(recruitmentProcess));
        when(recruitmentProcess.applicationPhase()).thenReturn(applicationPhase);
        when(applicationPhase.state()).thenReturn(State.valueOf(ActivityState.OPEN.toString()));

        assertThrows(Exception.class, () -> {
            controller.changePhase("ScreeningPhase", jobOpening, true);
        });
    }

    @Test
    public void testErrorInterviewNextPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        RecruitmentProcess recruitmentProcess = mock(RecruitmentProcess.class);
        ApplicationPhase applicationPhase = mock(ApplicationPhase.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("InterviewPhase"));
        when(recruitmentProcessRepository.findByJobOpening(jobOpening)).thenReturn(Optional.of(recruitmentProcess));
        when(recruitmentProcess.applicationPhase()).thenReturn(applicationPhase);
        when(applicationPhase.state()).thenReturn(State.valueOf(ActivityState.OPEN.toString()));

        assertThrows(Exception.class, () -> {
            controller.changePhase("InterviewPhase", jobOpening, true);
        });
    }

    @Test
    public void testErrorAnalysisNextPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        RecruitmentProcess recruitmentProcess = mock(RecruitmentProcess.class);
        ApplicationPhase applicationPhase = mock(ApplicationPhase.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("AnalysisPhase"));
        when(recruitmentProcessRepository.findByJobOpening(jobOpening)).thenReturn(Optional.of(recruitmentProcess));
        when(recruitmentProcess.applicationPhase()).thenReturn(applicationPhase);
        when(applicationPhase.state()).thenReturn(State.valueOf(ActivityState.OPEN.toString()));

        assertThrows(Exception.class, () -> {
            controller.changePhase("AnalysisPhase", jobOpening, true);
        });
    }

    @Test
    public void testErrorResultNextPhase() {
        JobOpening jobOpening = mock(JobOpening.class);
        RecruitmentProcess recruitmentProcess = mock(RecruitmentProcess.class);
        ApplicationPhase applicationPhase = mock(ApplicationPhase.class);
        when(recruitmentProcessRepository.currentPhase(jobOpening)).thenReturn(Optional.of("ResultPhase"));
        when(recruitmentProcessRepository.findByJobOpening(jobOpening)).thenReturn(Optional.of(recruitmentProcess));
        when(recruitmentProcess.applicationPhase()).thenReturn(applicationPhase);
        when(applicationPhase.state()).thenReturn(State.valueOf(ActivityState.OPEN.toString()));

        assertThrows(Exception.class, () -> {
            controller.changePhase("ResultPhase", jobOpening, true);
        });
    }
}
