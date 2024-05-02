package lapr4.jobs4u.applicationmanagement.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationCode;
import lapr4.jobs4u.applicationmanagement.dto.ApplicationDTO;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

class ListApplicationsControllerTest {

    @Mock
    ApplicationRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    SystemUser mockSystemUser;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    ApplicationDTO mockApplicationDTO;

    @Mock
    Application mockApplication;

    ApplicationCode applicationCode;

    ListApplicationsController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)).thenReturn(Optional.of(mockSystemUser));
        when(mockApplicationDTO.getApplicationCode()).thenReturn("testReference");
        applicationCode = ApplicationCode.valueOf("testReference");
        when(mockRepo.ofIdentity(applicationCode)).thenReturn(Optional.of(mockApplication));
        controller = new ListApplicationsController(mockRepo, mockAuthz);
    }

    @Test
    void testSelectApplicationNotNull() {
        Application result = controller.selectedApplication(mockApplicationDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectApplicationReturnsExpectedJobOpening() {
        Application result = controller.selectedApplication(mockApplicationDTO);
        assertEquals(mockApplication, result);
    }

    @Test
    void testSelectApplicationCallsOfIdentity() {
        controller.selectedApplication(mockApplicationDTO);
        verify(mockRepo).ofIdentity(applicationCode);
    }
}
