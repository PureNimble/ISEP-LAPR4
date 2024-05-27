package lapr4.jobs4u.applicationmanagement.application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import eapli.framework.application.UseCaseController;
import lapr4.jobs4u.applicationmanagement.domain.Application;
import lapr4.jobs4u.applicationmanagement.domain.ApplicationBuilder;
import lapr4.jobs4u.applicationmanagement.domain.File;
import lapr4.jobs4u.applicationmanagement.repositories.ApplicationRepository;
import lapr4.jobs4u.candidatemanagement.domain.Candidate;
import lapr4.jobs4u.jobopeningmanagement.domain.JobOpening;
import lapr4.jobs4u.jobopeningmanagement.domain.JobReference;
import lapr4.jobs4u.jobopeningmanagement.repositories.JobOpeningRepository;
import lapr4.jobs4u.recruitmentprocessmanagement.domain.Date;

/**
 * @author 2DI2
 */
@UseCaseController
public class ImportApplicationsController {

    private static final String REPORT_FILE_NAME = "\\report.txt";
    private static final String CANDIDATE_DATA_FILE_SUFFIX = "-candidate-data.txt";
    private static final String CANDIDATE_ID_REGEX = "Candidate ID: (\\d+)Job Offer: (\\w+-\\d+)";

    private final ApplicationRepository applicationRepository;
    private final JobOpeningRepository jobOpeningRepository;

    public ImportApplicationsController(final ApplicationRepository applicationRepository,
            final JobOpeningRepository jobOpeningRepository) {
        this.applicationRepository = applicationRepository;
        this.jobOpeningRepository = jobOpeningRepository;
    }

    public Map<String, Set<String>> getCandidates(String folder) {
        String reportFilePath = folder + REPORT_FILE_NAME;
        try (InputStream inputStream = new FileInputStream(reportFilePath)) {
            return extractCandidatesFromReport(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, Set<String>> extractCandidatesFromReport(InputStream inputStream) throws IOException {
        String output = eapli.framework.io.util.Files.textFrom(inputStream);
        Map<String, Set<String>> candidateJobMap = new HashMap<>();
        Pattern pattern = Pattern.compile(CANDIDATE_ID_REGEX);
        Matcher matcher = pattern.matcher(output);

        while (matcher.find()) {
            String candidateId = matcher.group(1);
            String jobOffer = matcher.group(2);
            candidateJobMap.computeIfAbsent(jobOffer, k -> new HashSet<>()).add(candidateId);
        }

        return candidateJobMap;
    }

    public List<String> getCandidateInfo(String folder, String candidateId, String jobId) {
        String candidateDataFilePath = constructCandidateDataFilePath(folder, candidateId, jobId);
        try (InputStream inputStream = new FileInputStream(candidateDataFilePath)) {
            return extractCandidateInfo(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String constructCandidateDataFilePath(String folder, String candidateId, String jobId) {
        String candidateFolder = folder + "/" + jobId + "/" + candidateId;

        return candidateFolder + "/" + candidateId + CANDIDATE_DATA_FILE_SUFFIX;
    }

    private List<String> extractCandidateInfo(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> output = reader.lines().collect(Collectors.toList());
        output.remove(0);
        String[] names = output.get(1).split(" ");
        output.remove(1);
        output.add(names[0]);
        output.add(names[1]);
        return output;
    }

    public Application registerApplication(final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        return createApplication(file, jobOpening, candidate);
    }

    private Application createApplication(final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        final Application application = doCreateApplication(file, jobOpening, candidate);
        return applicationRepository.save(application);
    }

    private Application doCreateApplication(final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        String applicationNumber = new ImportApplicationsService(applicationRepository)
                .nextJobOpeningReference(jobOpening.jobReference());
        return new ApplicationBuilder().with(applicationNumber, Date.today(), file, jobOpening, candidate).build();
    }

    public JobOpening getJobOpening(JobReference x) {
        return jobOpeningRepository.findJobOpeningByReference(x).orElse(null);
    }

    public List<File> getFiles(String folder, String candidateId, String jobOffer) {
        String candidateFolder = folder + "/" + jobOffer + "/" + candidateId;
        try {
            return extractFiles(candidateFolder);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<File> extractFiles(String candidateFolder) throws IOException {
        List<File> files = new ArrayList<>();
        List<String> filesString = Files.list(Paths.get(candidateFolder)).map(Path::getFileName).map(Path::toString)
                .collect(Collectors.toList());

        filesString.forEach(file -> {
            file = candidateFolder + "/" + file;
            files.add(File.valueOf(file));
        });
        return files;
    }

    public boolean isPathValid(String folder) {
        return Files.exists(Paths.get(folder + REPORT_FILE_NAME));
    }
}