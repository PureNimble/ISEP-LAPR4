<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1002 - Register a job opening.

## 3. Design - User Story Realization

### 3.1. Rationale

| Interaction ID | Question: Which class is responsible for... | Answer               | Justification (with patterns)                                                                                 |
|:-------------  |:--------------------- |:---------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 |	... interacting with the actor? | RegisterJobOpeningUI          | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 |	... coordinating the US? | RegisterJobOpeningController | Controller: The controller is responsible for handling the user's request and coordinating the use case. |
| 			  		 |	... creating the job opening?						 | JobOpening         | Information Expert: The JobOpening class knows how to create a new job opening. |
| 			  		 |	... saving the job opening?						 | JobOpeningRepository         | Information Expert: The repository knows how to save a job opening. |
| 			  		 |	... querying the database for job opening?						 | JpaJobOpeningRepository         | Information Expert: The JpaJobOpeningRepository knows how to interact with the database. |

### Systematization

According to the taken rationale, the conceptual classes promoted to software classes are:

* JobOpening

Other software classes (i.e. Pure Fabrication) identified:

* RegisterJobOpeningUI
* RegisterJobOpeningController
* JobOpeningService
* JobOpeningRepository
* JpaJobOpeningRepository

These classes are responsible for the user interface, controlling the use cases, creating and saving the job opening, and interacting with the database, respectively.

## 3.2. Sequence Diagram (SD)

![SD - 1002](svg/SD-US1002.svg)

## 3.3. Class Diagram (CD)

![CD - 1002](svg/CD-US1002.svg)

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>