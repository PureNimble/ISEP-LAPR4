<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1003 - List job openings.

# 4. Tests 

**Some tests of the JobOpeningController**
```java
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
```

**Some tests of the JobOpeningService**
```java
    @Test
    void testSelectJobOpeningNotNull() {
        JobOpening result = service.selectedJobOpening(mockJobOpeningDTO);
        assertNotNull(result);
    }

    @Test
    void testSelectJobOpeningReturnsExpectedJobOpening() {
        JobOpening result = service.selectedJobOpening(mockJobOpeningDTO);
        assertEquals(mockJobOpening, result);
    }

    @Test
    void testSelectJobOpeningCallsOfIdentity() {
        service.selectedJobOpening(mockJobOpeningDTO);
        verify(mockRepo).ofIdentity(jobReference);
    }
```

# 5. Construction (Implementation)

**ListJobOpeningsController**
```java
    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByCostumerManager();
    }

    public Iterable<JobOpeningDTO> filterByCustomer(final Customer customer) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByCustomer(customer);
    }

    public Iterable<JobOpeningDTO> filterByActive(final boolean active) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByActive(active);
    }

    public Iterable<JobOpeningDTO> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.filterByPeriod(initialDate, finalDate);
    }

    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER);
        return jobOpeningsService.selectedJobOpening(jobOpeningDTO);
    }

    public Iterable<JobOpeningDTO> getIntersection(Iterable<JobOpeningDTO> list1) {
        Collection<JobOpeningDTO> list2 = (Collection<JobOpeningDTO>) filterByCostumerManager();
        List<JobOpeningDTO> list1AsList = new ArrayList<>();
        list1.forEach(list1AsList::add);
        return list1AsList.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
```

**ListJobOpeningsService**
```java
    public Iterable<JobOpeningDTO> filterByCostumerManager() {
        final SystemUser manager = authz.loggedinUserWithPermissions(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWERUSER)
                .orElseThrow(IllegalStateException::new);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumerManager(manager.username());

        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterByCustomer(final Customer customer) {
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByCostumer(customer);
        
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterByActive(final boolean active) {
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByActive(active);
        
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }

    public Iterable<JobOpeningDTO> filterByPeriod(final Calendar initialDate, final Calendar finalDate) {
        finalDate.set(Calendar.DAY_OF_MONTH, finalDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        finalDate.set(Calendar.HOUR_OF_DAY, 23);
        finalDate.set(Calendar.MINUTE, 59);
        finalDate.set(Calendar.SECOND, 59);
        finalDate.set(Calendar.MILLISECOND, 999);
        final Iterable<JobOpening> jobOpenings = this.jobOpeningRepository.filterByPeriod(initialDate, finalDate);
        
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        jobOpenings.forEach(jobOpening -> jobOpeningsDTO.add(jobOpening.toDTO()));
        return jobOpeningsDTO;
    }
    
    public Optional<JobOpening> findJobOpeningByReference(JobReference jobReference) {
        Optional<JobOpening> jobOpening = jobOpeningRepository.findJobOpeningByReference(jobReference);
        return jobOpening;
    }
    
    public JobOpening selectedJobOpening(final JobOpeningDTO jobOpeningDTO) {
        JobOpening selectedJobOpening = jobOpeningRepository
                .ofIdentity(JobReference.valueOf(jobOpeningDTO.getJobReference()))
                .orElseThrow(IllegalArgumentException::new);
        return selectedJobOpening;
    }
```

# 6. Integration and Demo 

In the following images, we can see a demonstration of listing the job openings and filtering them.

<p align="center">Job Openings List</p>

![ListJobopening](resources/jobopeningslist.png)

<p align="center">Filtering Options</p>

![Filtering](resources/filtering.png)

The user can filter the job openings by the following options:
- Active job openings
- Job Openings by period
- Job Openings by customer

# 7. Observations

The implementation of listing job openings was a success.

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>