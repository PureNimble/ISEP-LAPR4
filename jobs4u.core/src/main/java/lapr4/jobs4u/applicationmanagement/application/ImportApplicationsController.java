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
import java.util.Optional;
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

@UseCaseController
public class ImportApplicationsController {

    private final ApplicationRepository applicationRepository;
    private final JobOpeningRepository jobOpeningRepository;

    public ImportApplicationsController(final ApplicationRepository applicationRepository,
            final JobOpeningRepository jobOpeningRepository) {
        this.applicationRepository = applicationRepository;
        this.jobOpeningRepository = jobOpeningRepository;

    }

    public Map<String, Set<String>> getCandidates(String folder) {

        try (InputStream inputStream = new FileInputStream(folder + "/report.txt")) {
            String output = eapli.framework.io.util.Files.textFrom(inputStream);

            Map<String, Set<String>> candidateJobMap = new HashMap<>();

            Pattern pattern = Pattern.compile("Candidate ID: (\\d+)Job Offer: (\\w+-\\d+)");
            Matcher matcher = pattern.matcher(output);

            while (matcher.find()) {
                String candidateId = matcher.group(1);
                String jobOffer = matcher.group(2);

                if (candidateJobMap.containsKey(jobOffer)) {
                    candidateJobMap.get(jobOffer).add(candidateId);
                } else {
                    Set<String> candidateSet = new HashSet<>();
                    candidateSet.add(candidateId);
                    candidateJobMap.put(jobOffer, candidateSet);
                }

            }

            return candidateJobMap;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> getCandidateInfo(String folder, String candidateId, String jobId) {

        folder += "/" + jobId + "/" + candidateId + "/" + candidateId + "-candidate-data.txt";

        try (InputStream inputStream = new FileInputStream(folder)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> output = reader.lines().collect(Collectors.toList());
            output.remove(0);
            // split index 1 to get first and last name
            String[] names = output.get(1).split(" ");
            output.remove(1);
            output.add(names[0]);
            output.add(names[1]);
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Application registerApplication(
            final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        return createaApplication(file, jobOpening, candidate);
    }

    private Application createaApplication(
            final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        final Application application = doCreateApplication(file, jobOpening, candidate);
        return applicationRepository.save(application);
    }

    private Application doCreateApplication(
            final List<File> file, final JobOpening jobOpening,
            final Candidate candidate) {
        String applicationNumber;

        applicationNumber = new ImportApplicationsService(applicationRepository)
                .nextJobOpeningReference(jobOpening.jobReference());
        return new ApplicationBuilder().with(applicationNumber, Date.today(), file, jobOpening.get(), candidate)
                .build();
    }

    public JobOpening getJobOpennig(JobReference x) {

        Optional<JobOpening> job = jobOpeningRepository.findJobOpeningByReference(x);
        if (job.isPresent()) {
            return job.get();
        }
        return null;

    }

    public List<File> getFiles(String folder, String candidateId,
            String jobOffer) {

        final String temp = folder + "/" + jobOffer + "/" + candidateId;

        List<File> files = new ArrayList<File>();

        try {
            List<String> filesString = Files.list(Paths.get(temp))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

            filesString.forEach(file -> {
                file = temp + "/" + file;
                if (!file.contains("candidate-data"))
                    files.add(File.valueOf(file));
            });
            return files;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public boolean haveReportFile(String folder) {
        return Files.exists(Paths.get(folder + "/report.txt"));
    }

}
