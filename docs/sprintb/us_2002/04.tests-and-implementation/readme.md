<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 2002 - Register an application of a candidate for a job opening and import all files received

# 4. Tests

## Domain Tests

**Some tests of the Application class**
```java
    @Test
    public void ensureApplicationEqualsPassesForTheSameApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = aApplication.equals(anotherApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteApplicationValues() throws Exception {

        final Application aApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final Application anotherApplication = getNewDummyApplication(APPLICATION_NUMBER2);

        final boolean expected = aApplication.equals(anotherApplication);

        assertFalse(expected);
    }

    @Test
    public void ensureApplicationEqualsAreTheSameForTheSameInstance() throws Exception {
        final Application applicationaApplication = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = applicationaApplication.equals(applicationaApplication);

        assertTrue(expected);
    }

    @Test
    public void ensureApplicationEqualsFailsForDifferenteObjectTypes() throws Exception {
        final Application application = getNewDummyApplication(APPLICATION_NUMBER);

        final boolean expected = application.equals(getNewDummyApplication(APPLICATION_NUMBER2));

        assertFalse(expected);
    }
```

**Some tests of the ImportApplicationsController**
```java
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
        JobOpening job = controller.getJobOpennig(JobReference.valueOf(candidates.keySet().iterator().next()));

    }

    @Test
    public void testHaveReportFile() {
        assertTrue(controller.haveReportFile(folder));
    }
```

# 5. Construction (Implementation)

**ImportApplicationsController**
```java
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
        if (!Files.exists(Paths.get(candidateFolder))) {
            renameFolder(folder, jobId);
        }
        return candidateFolder + "/" + candidateId + CANDIDATE_DATA_FILE_SUFFIX;
    }

    private void renameFolder(String folder, String jobId) {
        java.io.File oldDirectory = new java.io.File(folder + "/" + jobId + "/");
        java.io.File newDirectory = new java.io.File(folder + "/" + jobId + "/");
        oldDirectory.renameTo(newDirectory);
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
        List<String> filesString = Files.list(Paths.get(candidateFolder))
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());

        filesString.forEach(file -> {
            file = candidateFolder + "/" + file;
            if (!file.contains("candidate-data"))
                files.add(File.valueOf(file));
        });
        return files;
    }

    public boolean haveReportFile(String folder) {
        return Files.exists(Paths.get(folder + REPORT_FILE_NAME));
    }
```

**ImportApplicationsService**
```java
    public String nextJobOpeningReference(final JobReference jobReference) {
        return jobReference.toString() + "-" + applicationRepository.findHighestSequenceForCustomer(jobReference);
    }
```

# 6. Integration and Demo 

In the following images, we can see a demonstration of the registeration and importation of a Application in the Jobs4U application.

<p align="center">Main menu</p>

![Jobs4UMenu](resources/menu.png)

**1.** The user can access the import Applications page by choosing the option 3 in the main menu.

<p align="center">Default Folder</p>

![Jobs4UDefaultFolder](resources/defaultFolderPath.png)

**2.1** The user can choose the default folder path where the files will be stored.

<p align="center">Insert Folder</p>

![Jobs4UInsertFolder](resources/insertFolder.png)

**2.2** The user can insert a new folder path.

# 7. Observations

The implementation of the authentication and authorization system was a success

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>