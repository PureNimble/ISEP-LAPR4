<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 2004 - Upload a text file with the data fields (requirements ) of a candidate for its verification.

## 1. Requirements Engineering

### 1.1. User Story Description

* As Operator, I want to upload a text file with the data fields (requirements ) of a candidate for its verification.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- Requirement Specifications and Interview Models The support for this functionality must follow specific technical requirements, specified in LPROG. The [ANTLR](https://www.antlr.org/) tool should be used.

- Interview Models, as the name implies, are sequences of questions that can be used to register the answers of candidates during interviews.

- A job requirement specification module should:
  * Generate a template text file with the requirements to be evaluated and the possible answers for each requirement
  * Evaluate if a text file with the requirements for a particular candidate is syntactically  correct
  * Evaluate a text file with the requirements for a particular candidate and provide the result, approved or rejected, and in case of rejection, include justification

**From the client clarifications:**

> **Date:** 2024-03-16
> **Question 15:**  É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” de verificação da candidatura neste processo?
>
> **Answer:** Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin referido entra neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se os critérios não forem atingidos a candidatura é recusada.

> **Date:** 2024-04-20
>
> **Question 102:** Quem vai preencher as respostas no ficheiro template?
>
> **Answer:** Será o Operador e, no âmbito da US2004, este submete o ficheiro já preenchido no sistema.

> **Date:** 2024-04-23
>
> **Question 119:**  We have a question about the management of the screen phase of the recruitment process. Specifically, after the applications are filtered during the screening process, I'm unsure about who manages the results and oversees this phase. Could you please clarify if the responsibility for managing the screening results falls under the customer manager, the operators, or both?
>
> ** Answer:** In US2003 and US2004 it is the Operator that “downloads” a template file to register the requirements, registers the answers for the requirements in the file, and then uploads the file. It is then the Costumer manager that executes the verification process (US1015) and executes the notification of the results (US1016)

> **Date:** 2024-04-27
> 
> **Question 132:** Is it possible to clarify the usage of ANTRL within user story 2003? You've stated in Q15, Q102 and Q119, that US2003 simply generates the file, while in US2004 the Operator defines the answers and uploads the file. Where is this file uploaded to? Given this, where is the usage of ANTRL in US2003 directed to?
> 
> **Answer:**  Regarding the first question, although difficult it is possible to generate the template text file using ANTLR. If so, there we have the usage o ANTLR. Although, unless there is some specific evaluation requirement from LPROG, it is acceptable that the template file is hardcoded in the plugin (no need for any “complex” generation process/function). Regarding the second question, the file is uploaded to the system. The last question was answered first.
### 1.3. Acceptance Criteria

* **AC1:** The system must automatically verify the uploaded text file.

### 1.4. Found out Dependencies

N/A

### 1.5 Input and Output Data

**Input Data:**

* Submited Data
  * Text file with the data fields (requirements)

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>