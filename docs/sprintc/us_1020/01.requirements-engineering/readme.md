<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1020 - Publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- Result In this phase, candidates as well as customers are notified of the final result.

- The solution should be deployed using several network nodes. It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the cloud. The e-mail notification tasks must be executed in background by the Follow Up Server.

**From the client clarifications:**

> **Date:** 2024-04-06
>
> **Question 48:** Relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito?
>
> **Answer:** No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo da jobs4u parece-me adequado que essa informação fique registada.
>
> **Question 51:** Qual é o formato para essa publicação?
>
> **Answer:** A publicação refere-se a informar os candidatos e o cliente, por email. Os candidatos que são selecionados devem receber um email a indicar que para a sua candidatura ao job opening foram selecionados e irão ser contactados pela empresa. No que se refere à empresa, esta deve receber um email com a lista dos candidatos selecionados que deve incluir o nome e dados de contacto do candidato.

> **Date:** 2024-05-18
>
> **Question 190:** Regarding the selection of candidates, should we assume that the first N candidates in the ranking (where N is the number of job vacancies) are chosen, or should we allow the customer manager to select the N candidates?
>
> **Answer:** The first option (using the results from US1013).

> **Date:** 2024-05-27
>
> **Question 224:** Esta US pede que seja publicado os resultados das candidaturas, a minha pergunta seria se este processo só pode acontecer quando a job opening estiver encerrada ou se executar esta operação terminaria a job opening.
>
> **Answer:** Esta US é relativa à última fase do processo. Se as notificações executarem todas com sucesso em princípio já não existe mais nada a fazer neste processo.

### 1.3. Acceptance Criteria

* **AC1:** The system must be deployed using several network nodes. It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the cloud. The e-mail notification tasks must be executed in background by the Follow Up Server.

* **AC2:** The approved candidates are the top N candidates in the ranking, where N is the number of job vacancies.

* **AC3:** The system must send an email to the approved candidates informing them that they were selected for the job opening and that they will be contacted by the company.

* **AC4:** The system must send an email to the customer with the list of approved candidates, including the name and contact details of each candidate.

* **AC5:** The system must terminate the job opening after the execution of this operation.

### 1.4. Found out Dependencies

* **US 1018 - Execute the process that evaluates the interviews for a job opening:** The system must have the job opening evaluation process executed to be able to publish the results.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
	* Job Opening

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>