<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1009 - Select the requirements specification to be used for a job opening.

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to select the requirements specification to be used for a job opening.

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

> **Date:** 2024-04-04
>
> **Question 41:** Como é que o Language Engineer faz o interview model e os job requirements? É texto? Ou ele seleciona perguntas para a interview e requirements para a job opening? E isso é quando se está a criar uma entrevista ou uma job opening ou para-se a meio para fazer isso e depois continua se?
>
> **Answer:** O language enginner com informação passada pelo customer manager (que obteve do customer) vai desenvolver em java um jar correspondente ao modulo/plugin. Para esse desenvolvimento terá de utilizar técnicas de desenvolvimento de gramáticas/linguagens como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista” na aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”). A aplicação com essa informação carrega dinamicamente esse jar. Na gramátca usada no jar é que vão estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas atividades têm de ser feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora” dos sistema, apenas se registando o modelo (quando está pronto) na US1008. A US 1009 e US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no sistema).

> **Date:** 2024-04-16 
> **Question 70:**  Acerca da User Story da seleção do Job Requirement Specification para o Job Opening, será que o Customer Manager poderá escolher um Job Opening que já tenha um Job Requirement Specification?
>
> **Answer:** Admito que essa situação seja possível para qualquer user story similar. Ou seja, a situação que descreve é equivalente a qualquer situação em que seja necessário fazer uma seleção mas que o utilizador se tenha enganado e deseje optar por outra opção. Deve-se, no entanto, garantir que o sistema se mantenha num estado consistente.

> **Date:** 2024-04-18
>
> **Question 85:** Depois de definir os estados de recrutamento para uma JobOpening, o Customer Manager poderá selecionar o Job Requirement Specification para esse mesmo Job Opening? Se sim, até que fase de recrutamento poderá executar a ação?
>
> **Answer:** O Customer Manager define as fases do processo de recrutamento, não define os estados. A avaliação de requisitos é feita na fase de Screening. Assim, não percebo bem a questão colocada.

> **Date:** 2024-04-19
>
> **Question 91:**  A nossa questão principal seria: quando é que uma job opening é considerada válida? Tendo em conta as funcionalidades 1002, 1007, 1009, surgiu-nos uma duvida relativamente às job openings e à sua constituiçao. Na US1002, é suposto resgistar uma job opening e apenas depois, na US1009, devemos selecionar os requirements specifications para a dada job opening. Posto isto, aquando o registo da job opening, esta não iria possuir toda a informaçao obrigatória como requerido. Assim sendo, deveria haver uma ligação direta entre estas user stories de forma a que, aquando o registo, passamos automaticamente a selecionar os requirements obtendo assim uma job opening válida? Adicionalmente, queremos esclarecer se o recruitment process é algo obrigatório para a validez de um job opening.
> 
> ** Answer:** O product owner não é especialista do dominio da solução (apenas têm conhecimentos do problema) mas, quanto à primeira questão, sugere que talvez user stories não sejam (podem não ser) opções de menu “distintas”. Quanto à segunda questão (recruitment process) julgo que também está mais ligada à solução que ao problema, pelo que não vou sugerir nada que possa até complicar mais do que esclarecer.
### 1.3. Acceptance Criteria

* **AC1:** The system must list all available requirements specifications.

### 1.4. Found out Dependencies

**US 1008 - Deploy and configure a plugin:** The system must have a plugin(Requirement specification) to select it in the first place. 

### 1.5 Input and Output Data

**Input Data:**

* Requested Data:
  * Requirements

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>