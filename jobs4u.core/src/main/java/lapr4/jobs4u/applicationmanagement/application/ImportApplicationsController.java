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
        String test = "C:\\Users\\pinto\\Desktop\\project\\sem4pi-23-24-2di2\\jobs4u.applicationsFileBot\\resources\\output";

        try (InputStream inputStream = new FileInputStream(test + "\\report.txt")) {
            String output = eapli.framework.io.util.Files.textFrom(inputStream);

            Map<String, Set<String>> candidateJobMap = new HashMap<>();

            Pattern pattern = Pattern.compile("Candidate ID: (\\d+)Job Offer: (\\w+-\\d+)");
            Matcher matcher = pattern.matcher(output);

            while (matcher.find()) {
                String candidateId = matcher.group(1);
                String jobOffer = matcher.group(2);
                System.out.println("Candidate ID: " + candidateId + ", Job Offer: " + jobOffer);

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getCandidateInfo(String candidateId, String jobId) {
        String test = "C:\\Users\\pinto\\Desktop\\project\\sem4pi-23-24-2di2\\jobs4u.applicationsFileBot\\resources\\output";

        test += "\\" + jobId + "\\" + candidateId + "\\" + candidateId + "-candidate-data.txt";

        try (InputStream inputStream = new FileInputStream(test)) {
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
            final List<lapr4.jobs4u.applicationmanagement.domain.File> file, final Optional<JobOpening> jobOpening,
            final Candidate candidate) {
        return createaApplication(file, jobOpening, candidate);
    }

    private Application createaApplication(
            final List<lapr4.jobs4u.applicationmanagement.domain.File> file, final Optional<JobOpening> jobOpening,
            final Candidate candidate) {
        final Application application = doCreateApplication(file, jobOpening, candidate);
        return applicationRepository.save(application);
    }

    private lapr4.jobs4u.applicationmanagement.domain.Application doCreateApplication(
            final List<lapr4.jobs4u.applicationmanagement.domain.File> file, final Optional<JobOpening> jobOpening,
            final Candidate candidate) {
        String applicationNumber;

        if (jobOpening.isPresent()) {
            applicationNumber = new ImportApplicationsService(applicationRepository)
                    .nextJobOpeningReference(jobOpening.get().jobReference());
            return new ApplicationBuilder().with(applicationNumber, Date.today(), file, jobOpening.get(), candidate)
                    .build();
        } else {
            return null;
        }
    }

    public Optional<JobOpening> getJobOpennig(JobReference x) {

        return jobOpeningRepository.findJobOpeningByReference(x);
    }

    public List<File> getFiles(String folder, String candidateId,
            String jobOffer) {
        String test = "C:\\Users\\pinto\\Desktop\\project\\sem4pi-23-24-2di2\\jobs4u.applicationsFileBot\\resources\\output";

        test += "\\" + jobOffer + "\\" + candidateId;

        List<File> files = new ArrayList<File>();

        try {
            List<String> filesString = Files.list(Paths.get(test))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

            filesString.forEach(file -> {
                if (!file.contains("candidate-data"))
                    files.add(File.valueOf(file));
            });
            return files;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

}
