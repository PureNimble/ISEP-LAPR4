package lapr4.jobs4u.candidatemanagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
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

/**
 * @author 2DI2
 */
class ListCandidadesDataControllerTest {

    @Mock
    CandidateRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    SystemUser mockSystemUser;

    @Mock
    Candidate mockCandidate;

    @Mock
    CandidateDTO mockCandidateDTO;

    EmailAddress email;
    PhoneNumber phone;
    ListCandidatesDataController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)).thenReturn(Optional.of(mockSystemUser));
        when(mockCandidateDTO.getEmail()).thenReturn("test@email.local");
        when(mockCandidateDTO.getPhoneNumber()).thenReturn("912534969");
        email = EmailAddress.valueOf("test@email.local");
        phone = PhoneNumber.valueOf("912534969");
        when(mockRepo.ofIdentity(email)).thenReturn(Optional.of(mockCandidate));
        controller = new ListCandidatesDataController(mockRepo, mockAuthz);
    }

    @Test
    void testSelectCandidateNotNull() {
        Candidate result = controller.selectedCandidate(mockCandidateDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectCandidateReturnsExpectedCandidate() {
        Candidate result = controller.selectedCandidate(mockCandidateDTO);
        assertEquals(mockCandidate, result);
    }

    @Test
    void testSelectCandidateCallsOfIdentity() {
        controller.selectedCandidate(mockCandidateDTO);
        verify(mockRepo).ofIdentity(email);
    }
}