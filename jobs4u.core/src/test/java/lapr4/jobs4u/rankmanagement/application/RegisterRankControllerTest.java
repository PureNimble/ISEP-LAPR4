package lapr4.jobs4u.rankmanagement.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class RegisterRankControllerTest {

    @Mock
    RankRepository mockRepo;

    @Mock
    AuthorizationService mockAuthz;

    @Mock
    Application mockApplication;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    Rank mockRank;

    @Mock
    RankDTO mockRankDTO;

    RegisterRankController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new RegisterRankController(mockAuthz, mockRepo);
    }

    @Test
    void testSetupRank() {
        when(controller.setupRank("1", mockApplication)).thenReturn(mockRank);
        Rank result = controller.setupRank("1", mockApplication);
        assertEquals(mockRank, result);
    }

    @Test
    void testHasRank() {
        when(controller.hasRank(mockJobOpening)).thenReturn(true);
        Boolean result = controller.hasRank(mockJobOpening);
        assertTrue(result);
    }

    @Test
    void testEditRank() {
        when(controller.editRank(mockRank, "1")).thenReturn(mockRank);
        Rank result = controller.editRank(mockRank, "1");
        assertEquals(mockRank, result);
    }
}
