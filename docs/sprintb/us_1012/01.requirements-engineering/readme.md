<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1012 - Generate and export a template text file to help collect the candidate answers during the interviews.

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to generate and export a template text file to help collect the candidate answers during the interviews.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- Requirement Specifications and Interview Models The support for this functionality must follow specific technical requirements, specified in LPROG. The [ANTLR](https://www.antlr.org/) tool should be used.

- Interview Models, as the name implies, are sequences of questions that can be used to register the answers of candidates during interviews.

- An interview model module should:
	* Generate a template text file with the questions to be asked in the interview and the possible answers for each question
	* Evaluate if a text file with the questions and answers for a particular candidate interview is syntactically correct
	* Evaluate a text file with the questions and answers for a particular candidate interview and provide a numeric grade for that interview

- A similar approach is used for job interviews, but in this case, the goal is not to approve or reject a candidate but to evaluate the answers and calculate a grade for the interview in the range 1-100. 

- A job interview is a form with a set of questions. Each question as a value associated. The sum of the values for all the questions should be 100. At least the following type of questions should be supported:

	* **True/False** A question with only a true or false answer.
	* **Short Text Answer** A question with a short text answer. The limit of the answer should the specified by a regular expression.
	* **Choice, with Single-Answer** A question with a set of choices where only one can be selected
	* **Choice, with Multiple-Answer** A question with a set of choices where many can be selected
	* **Integer Number** A question which answer is an integer number
	* **Decimal Number** A question which answer is a decimal number
	* **Date** A question which answer is a date
	* **Time** A question which answer is a time
	* **Numeric Scale** A question which answer is one option in a range of integers (ex: 1-5)

- According to the answers given in the interview for each question the value of the question is calculate following evaluation rules. For instance, consider the following question, which value is 10:

```
	What programing language should be used for system XPTO?
	1. Java
	2. C#
	3. PHP
	4. Javascript
	5. Typescript

	For this case one could define the following rules used in the evaluation of the grade for the
	question:
	1. If the answer is 4 and 5 then 100%
	2. if the answer is 4 then 40%
	3. if the answer is 5 then 80%
```
In this case, if the answer is 1 and 2 the grade is 0% of 10, therefore 0. If the answer is 4, the grade is 40% of 10, therefore 4. The total grade of an interview is the sum of the grade of all the questions.

**From the client clarifications:**

> **Date:** 2024-03-09
>
> **Question 2:** As entrevistas são feitas presencialmente? Se sim, quem é responsável por registar essas respostas no sistema?
>
> **Answer:** O meio usado para as entrevistas está fora do âmbito do sistema. Podem ser presenciais, remotas (ex: telefone ou outro meio). Independentemente do meio, o Customer Manager é o responsável por registar as respostas no sistema, através da submissão (upload) do ficheiro de texto com as respostas do candidato.

> **Date:** 2024-03-14
>
> **Question 12:** Qual a distinção entre especificação de requisitos e de entrevistas?
>
> **Answer:** O “estilo” das perguntas e respostas é similar, mas nos requisitos o objetivo é avaliar o candidato e ver se tem os mínimos ou não, portanto o resultado será sim ou não. Nas entrevistas a ideia é classificar/pontuar cada resposta de forma a no final ter pontuações diferentes para os candidatos e assim ajudar a fazer o seu ranking.
>
> **Question 14:** Quem informa o Customer manager do tipo de entrevista/perguntas?
>
> **Answer:** Isso pode ser obtido pelo Customer manager em dialogo com o Customer. Depois disso, com a ajuda do Language engineer é elaborado o suporte para a entrevista.

> **Date:** 2024-04-04
>
> **Question 38:** Cada questão de um interview model aceita um x tipos de respostas(ex escolha múltipla) ou é a interview model que aceita um x tipos de respostas em todas as suas questões? Assumimos que uma job opening só segue um interview model?
>
> **Answer:** Sim, cada pergunta/resposta aceita um tipo de pergunta/resposta (um dos tipos que aparece no inicio da página 8). Na US1011, o Customer manager seleciona o interview model a usar nas entrevistas para um job opening. Ou seja, existirá apenas um interview model a usar nas entrevistas desse job opening.
>
> **Question 40:** Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não data final? Podem haver entrevistas em paralelo?
>
> **Answer:** Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou seja, pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas)...

> **Date:** 2024-04-11
>
> **Question 49:** Numa validação de requisitos a falha deve ser justificada. Numa entrevista também?
>
> **Answer:** Não. Nas entrevistas a ideia não é aceitar ou rejeitar um candidato mas avaliar um candidato numa escala de 0 a 100. A forma como isso é feito está descrita na secção 2.2.4.

### 1.3. Acceptance Criteria

* **AC1:** The system must generate a template text file with the questions to be asked in the interview and the possible answers for each question.

* **AC2:** The system must evaluate if a text file with the questions and answers for a particular candidate interview is syntactically correct.

* **AC3:** The system must evaluate a text file with the questions and answers for a particular candidate interview and provide a numeric grade for that interview.

* **AC4:** ANTTLR tool should be used to support the functionality.

* **AC5:** The system must generate a template to support the following types of questions:
	* **True/False**
	* **Short Text Answer**
	* **Choice, with Single-Answer**
	* **Choice, with Multiple-Answer**
	* **Integer Number**
	* **Decimal Number**
	* **Date**
	* **Time**
	* **Numeric Scale**

### 1.4. Found out Dependencies

**US 1008 - Deploy and configure a plugin:** The system must have a plugin(Interview Model) that allows the Customer Manager to generate and export a template text file to help collect the candidate answers during the interviews.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Question
	* Answer
	* Grade

**Output Data:**

* (In)Success of the operation
* Template text file.

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>