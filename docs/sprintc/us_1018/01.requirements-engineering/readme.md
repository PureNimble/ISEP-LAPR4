<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1018 - Execute the process that evaluates (grades) the interviews for a job opening

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to execute the process that evaluates (grades) the interviews for a job opening.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

 - The system should provide a justification, such as "A minimum Bachelor degree is required for the job position.". A similar approach is used for job interviews, but in this case, the goal is not to approve or reject a candidate but to evaluate the answers and calculate a grade for the interview in the range 1-100.
- A job interview is a form with a set of questions. Each question as a value associated. The sum of the values for all the questions should be 100.

- According to the answers given in the interview for each question the value of the question is calculate following evaluation rules.

For instance, consider the following question, which value is 10:

```
What programing language should be used for system XPTO?
1. Java
2. C#
3. PHP
4. Javascript
5. Typescript

For this case one could define the following rules used in the evaluation of the grade for the question:
1. If the answer is 4 and 5 then 100%
2. if the answer is 4 then 40%
3. if the answer is 5 then 80%
```
In this case, if the answer is 1 and 2 the grade is 0% of 10, therefore 0. If the answer is 4, the grade is 40% of 10, therefore 4. The total grade of an interview is the sum of the grade of all the questions.

**From the client clarifications:**

> **Date:** 2024-05-21
>
> **Question 199:** Relativamente à US1018, após a execução do processo de avalição de todas as entrevistas da job opening, a fase em que esta se encontra deve ser automaticamente mudado para "Result" ou deve ser mantida em "Analysis" e apenas pode ser mudada pela execução da US1010?
>
> **Answer:** A US1018 não deve alterar a fase actual. A US1010 permite fazer a mudança de fases do processo de recrutamento.

> **Date:** 2024-05-24
>
> **Question 214:** O nosso grupo tem uma dúvida em relação ao processamento dos ficheiros de respostas dos candidatos para a entrevista. No caso de upload de um ficheiro, se a pergunta que requer um número como resposta for preenchida com um formato inválido, por exemplo, uma letra, devemos considerar isso como um formato inválido na US 1017 (e pedir para o user voltar a dar upload a um ficheiro válido) ou devemos, na US1018, considerar que está incorreta e atribuir 0 pontos automaticamente para essa resposta inválida? Isto é, na US 1017, devemos apenas verificar o formato do ficheiro ou devemos verificar também se as respostas são preenchidas com o tipo de dados correto?
>
> **Answer:** O caso mencionado deve ser considerado um erro de validação do ficheiro (ou seja, o ficheiro submetido não corresponde à gramática definida).

> **Date:** 2024-06-02
>
> **Question 237:** Pontuação de questões em interviews - Todos os tipos de questões têm uma cotação associada ou uma questão do tipo Date, por exemplo, não necessita de cotação associada?
>
> **Answer:** Secção 2.2.4: “A job interview is a form with a set of questions. Each question has a value associated. The sum of the values for all the questions should be 100.“ Pela descrição parece claro que cada pergunta deve ser avaliada. No entanto, o importante é que a soma das avaliações de todas as perguntas resulte em 100 (nota máxima). Ou seja, seria possivel definir perguntas que não são avaliadas (ou são sempre avaliadas em 0). O facto da perguntas ser do tipo data não a torma particular/especial.


### 1.3. Acceptance Criteria

_N/A_

### 1.4. Found out Dependencies

* **US 1017 - Upload a text file with the candidate responses for an interview:** The system must have the candidate responses to be able to evaluate the interviews.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
	* Job Opening

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>