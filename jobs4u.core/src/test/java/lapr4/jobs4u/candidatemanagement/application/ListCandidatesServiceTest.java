package lapr4.jobs4u.candidatemanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.candidatemanagement.dto.CandidateDTO;
import lapr4.jobs4u.candidatemanagement.repositories.CandidateRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

/**
 * @author 2DI2
 */
public class ListCandidatesServiceTest {

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
    ListCandidatesService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.OPERATOR)).thenReturn(Optional.of(mockSystemUser));
        when(mockCandidateDTO.getEmail()).thenReturn("test@email.local");
        email = EmailAddress.valueOf("test@email.local");
        when(mockRepo.ofIdentity(email)).thenReturn(Optional.of(mockCandidate));
        service = new ListCandidatesService(mockRepo);
    }

    @Test
    void testSelectCandidateNotNull() {
        Candidate result = service.selectedCandidate(mockCandidateDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectCandidateReturnsExpectedCandidate() {
        Candidate result = service.selectedCandidate(mockCandidateDTO);
        assertEquals(mockCandidate, result);
    }

    @Test
    void testSelectCandidateCallsOfIdentity() {
        service.selectedCandidate(mockCandidateDTO);
        verify(mockRepo).ofIdentity(email);
    }
}