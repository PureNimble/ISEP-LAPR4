package lapr4.jobs4u.jobopeningmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.customermanagement.domain.Customer;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.dto.JobOpeningDTO;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

/**
 * @author 2DI2
 */
class ListJobOpeningsControllerTest {

    @Mock
    JobOpeningRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    SystemUser mockSystemUser;

    @Mock
    Customer mockCustomer;

    @Mock
    JobOpeningDTO mockJobOpeningDTO;

    @Mock
    JobOpening mockJobOpening;

    JobReference jobReference;

    ListJobOpeningsController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)).thenReturn(Optional.of(mockSystemUser));
        when(mockJobOpeningDTO.getJobReference()).thenReturn("testReference");
        jobReference = JobReference.valueOf("testReference");
        when(mockRepo.ofIdentity(jobReference)).thenReturn(Optional.of(mockJobOpening));
        controller = new ListJobOpeningsController(mockRepo, mockAuthz);
    }

    @Test
    void testSelectJobOpeningNotNull() {
        JobOpening result = controller.selectedJobOpening(mockJobOpeningDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectJobOpeningReturnsExpectedJobOpening() {
        JobOpening result = controller.selectedJobOpening(mockJobOpeningDTO);
        assertEquals(mockJobOpening, result);
    }

    @Test
    void testSelectJobOpeningCallsOfIdentity() {
        controller.selectedJobOpening(mockJobOpeningDTO);
        verify(mockRepo).ofIdentity(jobReference);
    }
}
