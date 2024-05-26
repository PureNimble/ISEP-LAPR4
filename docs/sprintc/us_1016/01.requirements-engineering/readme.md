<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1016 - Notify candidates, by email, of the result of the verification process

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want the system to notify candidates, by email, of the result of the verification process

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- **Screening:** This phase follows the application phase. In this phase, applications are verified against a set of requirements. Applications that do not meet mandatory requirements are rejected.

- The solution should be deployed using several network nodes. It is expected that, at least, the relational database server and the Follow Up Server be deployed in nodes different from localhost, preferably in the cloud. The e-mail notification tasks must be executed in background by the Follow Up Server.

**From the client clarifications:**

> **Date:** 06/04/2024
>
> **Question 48:** US1016 e US1020, relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito?
>
> **Answer:** No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo da jobs4u parece-me adequado que essa informação fique registada.

> **Date:** 16/04/2024
>
> **Question 69:** US1016 – Acerca da US 1016 - "As Customer Manager, I want the system to notify candidates, by email, of the result of the verification process" qual é o processo através do qual essa notificação é gerada? Após a avaliação do Requirement Specification module, este gera um resultado "Aprovado" ou "Rejeitado". Este resultado despoleta automaticamente uma notificação para o candidato ou é o Customer Manager que tem a responsabilidade de informar o candidato através do sistema do resultado da verificação (ex. depois de um resultado negativo ser gerado, o Customer Manager vai no sistema rejeitar o candidato para que seja enviado o email)?
>
> **Answer:** É a segunda opção que apresenta. A US1015 permite que o Customer Manager invoque o processo de verificação de requisitos. Depois disso todas as candidaturas devem estar aceites ou recusadas. É então possível ao Customer Manager invocar a notificação através da US1016.

> **Date:** 23/04/2024
>
> **Question 119:** Management of screening data - We have a question about the management of the screen phase of the recruitment process. Specifically, after the applications are filtered during the screening process, I'm unsure about who manages the results and oversees this phase. Could you please clarify if the responsibility for managing the screening results falls under the customer manager, the operators, or both?
>
> **Answer:** In US2003 and US2004 it is the Operator that “downloads” a template file to register the requirements, registers the answers for the requirements in the file, and then uploads the file. It is then the Costumer manager that executes the verification process (US1015) and executes the notification of the results (US1016)

> **Date:** 16/05/2024
>
> **Question 164:** US1016 - em relação a US1016 que diz o seguinte: "As Customer Manager, I want the system to notify candidates, by email, of the result of the verifcation process". Eu gostaria de saber qual o formato da mensagem a seguir para enviar ao cliente, poderia ser algo do genero: "Dear [Candidate's Name], I hope this email finds you well. As the Customer Manager, I wanted to inform you about the outcome of the verification process for the position you applied for. After careful consideration of your application and qualifications, I'm pleased to inform you that you have successfully passed the verification process. Congratulations! Your application has met our initial criteria, and we are impressed with your qualifications and experience. We will be proceeding to the next phase of the selection process, which may include interviews or additional assessments. We will reach out to you soon with further details regarding the next steps. Thank you for your interest in our company and for taking the time to apply for the position. We appreciate your patience throughout the process. If you have any questions or need further assistance, please don't hesitate to contact us. Best regards, [Your Name] Customer Manager [Your Company Name]" Gostaria de saber as informações mais importantes quando se notificar o candidato, deve aparecer o nome do customer manager, a job reference, o nome do candidato. E se o email deve ser em inglês ou português.
>
> **Answer:** Pode ser como apresenta. Pode ser em português ou inglês.

> **Date:** 22/05/2024
>
> **Question 209:** US1016 - About the Us1016 wich states: "As Customer Manager, I want the system to notify candidates, by email, of the result of verification process". I want to know when the client says "verification process" is the same about the screening phase.
>
> **Answer:** Yes.
>
> **Question 210:** 1016 - Notify candidates - This user story has a functional dependency with 1015. I would like to know if an error occurs, do I need to delete what happened in US 1015, as if it were a transaction?
>
> **Answer:** The process of notification (US1016) must be done after the verification (US1015) but an error in the notification does not invalidate the “results” of the verification process.

### 1.3. Acceptance Criteria

* **AC1:** The notifications must be sent by email to the candidates

* **AC2:** The email notifications can only be sent after the verification process is completed

### 1.4. Found out Dependencies

* **US1015 - Verify Job Opening Requirements** - The verification process must be completed before the notification process can be triggered.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
	* Job Opening

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>