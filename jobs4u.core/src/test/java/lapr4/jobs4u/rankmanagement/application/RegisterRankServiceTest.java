package lapr4.jobs4u.rankmanagement.application;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.rankmanagement.domain.Rank;
import lapr4.jobs4u.rankmanagement.dto.RankDTO;
import lapr4.jobs4u.rankmanagement.repositories.RankRepository;

/**
 * @author 2DI2
 */
public class RegisterRankServiceTest {

    @Mock
    RankRepository mockRepo;

    @Mock
    JobOpening mockJobOpening;

    @Mock
    Rank mockRank;

    @Mock
    RankDTO mockRankDTO;

    RegisterRankService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new RegisterRankService(mockRepo);
    }

    @Test
    void testHasRank() {
        when(mockRepo.hasRank(mockJobOpening)).thenReturn(true);
        Boolean result = service.hasRank(mockJobOpening);
        assertTrue(result);
    }

    @Test
    void testFindByJobOpening() {
        when(mockRepo.findByJobOpening(mockJobOpening)).thenReturn(Arrays.asList(mockRank));
        Iterable<RankDTO> result = service.findByJobOpening(mockJobOpening);
        assertNotNull(result);
    }

    @Test
    void testSelectedRank() {
        when(mockRankDTO.getId()).thenReturn("1");
        when(mockRepo.ofIdentity(Long.valueOf(mockRankDTO.getId()))).thenReturn(Optional.of(mockRank));
        Rank result = service.selectedRank(mockRankDTO);
        assertEquals(mockRank, result);
    }
}
