package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.customermanagement.domain.PhoneNumber;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DisplayCandidateApplicationsControllerTest {

    @Mock
    CandidateRepository mockCandidateRepo;

    @Mock
    ApplicationRepository mockApplicationRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    SystemUser mockSystemUser;

    @Mock
    Candidate mockCandidate;

    @Mock
    CandidateDTO mockCandidateDTO;

    @Mock
    Application mockApplication;

    @Mock
    ApplicationDTO mockApplicationDTO;

    EmailAddress email;
    PhoneNumber phone;
    ApplicationCode applicationCode;
    DisplayCandidateApplicationsController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)).thenReturn(Optional.of(mockSystemUser));
        when(mockCandidateDTO.getEmail()).thenReturn("test@email.local");
        when(mockCandidateDTO.getPhoneNumber()).thenReturn("912534969");
        when(mockApplicationDTO.getApplicationCode()).thenReturn("123");

        email = EmailAddress.valueOf("test@email.local");
        phone = PhoneNumber.valueOf("912534969");
        applicationCode = ApplicationCode.valueOf("123");
        when(mockCandidateRepo.ofIdentity(email)).thenReturn(Optional.of(mockCandidate));
        when(mockApplicationRepo.ofIdentity(applicationCode)).thenReturn(Optional.of(mockApplication));
        controller = new DisplayCandidateApplicationsController(mockApplicationRepo, mockAuthz);
    }

    @Test
    void testSelectCandidateNotNull() {
        Application result = controller.selectedApplication(mockApplicationDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectCandidateReturnsExpectedCandidate() {
        Application result = controller.selectedApplication(mockApplicationDTO);
        assertEquals(mockApplication, result);
    }

    @Test
    void testSelectCandidateCallsOfIdentity() {
        controller.selectedApplication(mockApplicationDTO);
        verify(mockApplicationRepo).ofIdentity(applicationCode);
    }
}