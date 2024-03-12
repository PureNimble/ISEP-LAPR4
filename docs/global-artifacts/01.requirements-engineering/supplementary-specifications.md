<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

### Auditing

- N/A

### Licensing

- N/A

### Localization

- "The application must support the English language."

### Email

- N/A

### Help 

- N/A

### Printing

-	“(…) publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result.”
-	“(…) display all the data of an application.”

### Reporting

- “Jobs4U is a company specialized in talent acquisition. The company provides recruitment services for job positions in its clients. The aim of this project is to develop, in an exploratory way, a solution that allows automating the main activities of the company. Therefore, a minimum viable product should be developed in 3 months. The company’s clients are other companies or entities that need to recruit human resources. In response to requests from its clients, Jobs4U develops all activities that allow it to select a set of candidates for job offers (from its clients). At the end of the process, Jobs4U must deliver to its client an ordered list of candidates for each job offer. The final recruitment decision is the responsibility of the client.”

### Security

-	“The system must support and apply authentication and authorization for all its users and functionalities.”

### System management

-	“The system administrator (Admin) is responsible for managing customer entities as well as the company’s employees who are customer managers (Customer Manager). This responsibility involves registering entities as well as assigning different roles to system users (i.e., customer manager, operator). It also includes the customer’s registration as a user of the system.”
-	“Entities send job offers to Jobs4U. This sending can be done by various means (e.g. email, post, telephone), but the automation of this reception is outside the scope of the system. A customer manager will register job offers for the entities he manages in the Backoffice. The customer manager will also manage other aspects of job offers, namely the entire candidate selection process. However, the registration of candidates for job offers is carried out by the operators (using some bots to automate the process).”
-	“The operator is a company employee whose main responsibility is to monitor the automatic process that registers applications for job offers. These applications are received by email and processed automatically by the Applications Email Bot (out of scope for this project).”
-	“The applications Email Bot processes the emails and produces files adapted for integration in the system, that will be automatically processed by the Applications File Bot. The Operator should monitor this process, especially the report files that are produced. The Operator may, eventually, contact candidates if problems exist in their applications. The files produced by the Applications File Bot are used to integrate candidates and applications into the system.”.
-	“Both candidates and clients have specific applications (console applications) that basically allow them to monitor applications and job offers and receive notifications about them.”
-	“The selection of candidates is highly based on automated processes (such as interviews or verification of application requirements) that require the production of plugins (for the Backoffice application) by a Language Engineer. These plugins automate the processing of job interviews and application requirements by applying language processing, that maybe specific for each job opening.”


### Workflow

 The recruitment process for a job opening follows a sequence of phases: application; resume screen; interviews; analysis; result. The workflow is as follows:
-	“The customer manager is responsible to setup the process, defining the dates for the phases and if the process includes interviews.”
-	“Job openings (or job vacancies) are created in the system by a customer manager.”
-	“Candidates submit their applications for job openings by email.”
-	“The Bot processes the emails and produces (in a predefined folder) the following content/filles (using the same file prefix for files of the same application)”
-	“There is a second bot application, named Applications File Bot, that processes these files for integration in the system. The Bot should copy the files for a shared folder. The Bot should produce a text report of all the processed applications (including applications for job references and files available).”
- “The Operator of the Backoffice will import the files produced by the Applications File Bot and register the applications, creating candidates that do not exist in the system.”


## Usability 

-	The solution should be implemented using Java as the main language. Other languages can be used in accordance with more specific requirements. 
-	All those who wish to use the application must be authenticated and authorized to use all the functionalities.
- During the system development, the team must: 
	 - (i) aim to adopt a test-driven development approach. 
	 - (ii) document every US (e.g.: analysis, design, testing, etc.).
	 - (iii) only use main (master/main) branch.



## Reliability
- “The source code of the solution as well as all the documentation and related artifacts should be versioned in a GitHub repository to be provided to the students.”


## Performance
- “The system must support that data persistence is done either "in memory" or in a relational database (RDB). Although in-memory database solutions can be used during development and testing, the solution must include a final deployment where a persistent relational database is used. The system should have the ability to initialize some default data.”
-	“The GitHub repository must be configured to be able to provide night builds with publishing of results and metrics.”



## Supportability

- “The team should develop a relevant set of automated tests for every US / Class / Method.”
-	“The repository should include the necessary scripts to build and deploy the solution in a variety of systems (at least Linux and Windows). It should also include a readme.md file in the root folder explaining how to build, deploy and execute the solution.”




## +

### Design Constraints

| Subcategory | Category | Description/Example 
| --- | --- | --- |
| Programming Languages | Java | The application must be developed in Java language. |
| Programming Languages | C | The use of the C programming language must be used for shared memory and semaphores. |
| Standards-Compliance | OO software analysis and design | The implementation must adopt OO standards. |

### Implementation Constraints


| Subcategory | Category | Description/Example |
| --- | --- | --- |
| Tools | Javadoc documentation | The Java code must use Javadoc to generate useful documentation. |
| Tools | JUnit 5 testing framework | The unit tests should be implemented using the JUnit 5 framework. |
| Tools | JaCoCo test coverage plugin | The JaCoCo plugin should be used to generate the test coverage report. |
| Tools | ANTLR software | ANTLR generates a parser that can build and walk parse trees. |
| Database integrity | JPA | JPA allows us to map Java objects to tables in a relational database |

### Interface Constraints

-	The JaCoCo plugin should be used to generate the coverage report.
-	All the images/figures produced during the software development process should be recorded in SVG format.


### Physical Constraints

- "The application should use object serialization to ensure date persistence between two runs of the
application."

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>