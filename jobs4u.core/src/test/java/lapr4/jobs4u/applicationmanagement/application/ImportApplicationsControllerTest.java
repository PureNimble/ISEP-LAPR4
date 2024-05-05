package lapr4.jobs4u.applicationmanagement.application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eapli.framework.io.util.Files;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;

public class ImportApplicationsControllerTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private JobOpeningRepository jobOpeningRepository;

    private ImportApplicationsController controller;

    private String folder;

    private Map<String, Set<String>> candidates;

    @BeforeEach
    public void setUp() {
        folder = "jobs4u.applicationsFileBot/resources/output";

        if (Files.currentDirectory().contains("jobs4u.core")) {
            folder = "../" + folder;
        }
        MockitoAnnotations.openMocks(this);
        controller = new ImportApplicationsController(applicationRepository, jobOpeningRepository);
    }

    @Test
    public void testGetCandidates() {
        candidates = controller.getCandidates(folder);

        assertNotNull(candidates);
    }

    @Test
    public void testGetCandidateInfo() {
        List<String> values = new ArrayList<>();
        testGetCandidates();
        candidates.forEach((jobOffer, candidateSet) -> {
            candidateSet.forEach(candidateId -> {
                values.addAll(controller.getCandidateInfo(folder, candidateId, jobOffer));
            });
        });
        assertNotNull(values);
    }

    @Test
    public void testGetJobOpennig() {
        testGetCandidates();
        controller.getJobOpennig(JobReference.valueOf(candidates.keySet().iterator().next()));

    }

    @Test
    public void testHaveReportFile() {
        assertTrue(controller.haveReportFile(folder));
    }
}