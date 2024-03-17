<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US G006 -  Elaborate a Domain Model using DDD

## 1. Requirements Engineering

### 1.1. User Story Description


* As Project Manager, I want the team to elaborate a Domain Model using DDD.


### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- “The system must support and apply authentication and authorization for all its users and functionalities.”
- “The system administrator (Admin) is responsible for managing customer entities as well as the company’s employees who are customer managers (Customer Manager). This responsibility involves registering entities as well as assigning different roles to system users (i.e., customer manager, operator). It also includes the customer’s registration as a user of the system.”
- “Entities send job offers to Jobs4U. This sending can be done by various means (e.g. email, post, telephone), but the automation of this reception is outside the scope of the system. A customer manager will register job offers for the entities he manages in the Backoffice. The customer manager will also manage other aspects of job offers, namely the entire candidate selection process. However, the registration of candidates for job offers is carried out by the operators (using some bots to automate the process).”
- “The operator is a company employee whose main responsibility is to monitor the automatic process that registers applications for job offers. These applications are received by email and processed automatically by the Applications Email Bot (out of scope for this project).”
- “The applications Email Bot processes the emails and produces files adapted for integration in the system, that will be automatically processed by the Applications File Bot. The Operator should monitor this process, especially the report files that are produced. The Operator may, eventually, contact candidates if problems exist in their applications. The files produced by the Applications File Bot are used to integrate candidates and applications into the system.”.
- “Both candidates and clients have specific applications (console applications) that basically allow them to monitor applications and job offers and receive notifications about them.”
- “The selection of candidates is highly based on automated processes (such as interviews or verification of application requirements) that require the production of plugins (for the Backoffice application) by a Language Engineer. These plugins automate the processing of job interviews and application requirements by applying language processing, that maybe specific for each job opening.”


**From the client clarifications:**

> **Question:** As entrevistas são feitas presencialmente? Se sim, quem é responsável por registar essas respostas no sistema?
>
> **Answer:** O meio usado para as entrevistas está fora do âmbito do sistema. Podem ser presenciais, remotas (ex: telefone ou outro meio). Independentemente do meio, o Customer Manager é o responsável por registar as respostas no sistema, através da submissão (upload) do ficheiro de texto com as respostas do candidato.


> **Question:** Quem é responsável por analisar as candidaturas (applications)?
>
> **Answer:** Será o Customer Manager. Este analisa as candidaturas e decide o ranking dos candidatos.

### 1.3. Acceptance Criteria

* **AC1:** Domain Driven Design (DDD) must be followed.

### 1.4. Found out Dependencies

_N/A_

### 1.5 Input and Output Data

_N/A_

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>