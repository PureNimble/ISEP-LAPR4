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
import lapr4.jobs4u.usermanagement.domain.BaseRoles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

/**
 * @author 2DI2
 */
class ListApplicationsServiceTest {

    @Mock
    ApplicationRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    SystemUser mockSystemUser;

    @Mock
    Application mockApplication;

    @Mock
    ApplicationDTO mockApplicationDTO;

    ApplicationCode applicationCode;

    ListApplicationsService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockAuthz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER)).thenReturn(Optional.of(mockSystemUser));
        when(mockApplicationDTO.getApplicationCode()).thenReturn("testReference");
        applicationCode = ApplicationCode.valueOf("testReference");
        when(mockRepo.ofIdentity(applicationCode)).thenReturn(Optional.of(mockApplication));
        service = new ListApplicationsService(mockRepo);
    }

    @Test
    void testSelectApplicationNotNull() {
        Application result = service.selectedApplication(mockApplicationDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectApplicationReturnsExpectedApplication() {
        Application result = service.selectedApplication(mockApplicationDTO);
        assertEquals(mockApplication, result);
    }

    @Test
    void testSelectApplicationCallsOfIdentity() {
        service.selectedApplication(mockApplicationDTO);
        verify(mockRepo).ofIdentity(applicationCode);
    }
}
