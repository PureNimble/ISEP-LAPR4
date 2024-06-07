<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 2000b - Enable/disable a candidate

## 3. Design - User Story Realization

### 3.1 Rationale

#### 3.1.2. Enable/Disable Users

| Interaction ID | Question: Which class is responsible for... | Answer               | Justification (with patterns)                                                                                 |
|:-------------  |:--------------------- |:---------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 |	... interacting with the actor? | EnableDisableCandidateUI          | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| Step 2  		 |	... coordinating the US? | EnableDisableCandidateController | Controller: The controller is responsible for handling the user's request and coordinating the use case.Controller       |
| Step 3		 |	... listing the active or inactive candidates?							 | ListCandidatesService		         |  Information Expert: The service knows how to find candidates based on their active status.             |
| Step 4		 |	... querying the database for candidates?						 | JpaCandidateRepository         | nformation Expert: The JpaCandidateRepository knows how to interact with the database to find candidates.     |
| Step 5		 |	... querying the database for candidate users?					 | JpaCandidateUserRepository	         | 	Information Expert: The JpaCandidateUserRepository knows how to interact with the database to find candidate users.     |
| Step 6		 |	.. converting candidates to DTOs?						 | CandidateUser		         | Information Expert: The Candidate class knows its own data and how to convert it to a DTO.    |
| Step 7		 |	... toggling the status of a candidate user?	 | CandidateUser		         | 	Information Expert: The CandidateUser class knows how to toggle its own status.       |
| Step 8		 |	... saving the updated candidate user?			 | CandidateRepository			         | Information Expert: The repository knows how to save a candidate user.       |


Systematization
According to the taken rationale, the conceptual classes promoted to software classes are:

* Candidate
* CandidateUser

Other software classes (i.e. Pure Fabrication) identified:

* EnableDisableCandidateUI
* EnableDisableCandidateController
* ListCandidatesService
* CandidateRepository
* JpaCandidateRepository
* JpaCandidateUserRepository

These classes are responsible for the user interface, controlling the use case, and interacting with the database, respectively.

## 3.2. Sequence Diagram (SD)

![SD -> Enable/Disable Candidates](svg/SD-US2000b.svg)

## 3.3. Class Diagram (CD)

![CD -> Enable/Disable Candidates](svg/EnableOrDisableCandidateUserAction.png)

**IMPORTANT NOTE: The _'UserManagementService'_ and _'SystemUser'_ classes are part of the EAPLI framework. They are used to manage and create users in the system.**

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>