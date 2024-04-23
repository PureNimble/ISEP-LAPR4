<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1008 - Deploy and configure a plugin to be used by the system

## 1. Requirements Engineering

### 1.1. User Story Description


* As Language Engineer, I want to deploy and configure a plugin (i.e., Job Requirement Specification or Interview Model) to be used by the system.


### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- The selection of candidates is highly based on automated processes (such as interviews
or verification of application requirements) that require the production of plugins (for the
Backoffce application) by a Language Engineer. These plugins automate the processing of job
interviews and application requirements by applying language processing, that may be specific 
to each job opening.

- Job vacancies (job openings) must include a Job Requirement Specification. This represents
a set of application requirements that the applicants must achieve. For instance, we could 
define a job requirement specification named "front end junior programmer", where candidates
must have at least 2 years of experience, a degree in computer science or similar program, and
knowledge in, at least, one of the following programming languages: java, javascript, typescript. 
Usually, this information can be collected from the curriculum vitae of the candidate.

- Interviews are a very important tool for the evaluation of candidates. Interviews should be
based on a set of pre-defined questions. Interview Models, as the name implies, are sequences
of questions that can be used to register the answers of candidates during interviews.

- Both job requirement specifications and interview models follow the same usage. A software
engineer, with great competencies in language engineering, following directions from customer
managers, designs and implements modules that are dynamically added to the system. These
modules contain the implementation of job requirements specification or interview models.
These modules should be able to implement the necessary functionalities for processing job
requirements or interviews.


- **Figure 2.2** illustrates an example of a template text file with requirements for a job opening.
In this example, the evaluation of this requirements (with the existing values) could result in a
rejection since the candidate has no degree. The system should provide a justification, such as
"A minimum Bachelor degree is required for the job position.". A similar approach is used for
job interviews, but in this case, the goal is not to approve or reject a candidate but to evaluate
the answers and calculate a grade for the interview in the range 1-100.
A job interview is a form with a set of questions. Each question as a value associated. The
sum of the values for all the questions should be 100. At least the following type of questions
should be supported:

    * **True/False** A question with only a true or false answer.
    * **Short Text Answer** A question with a short text answer. The limit of the answer should the specified by a regular expression.
    * **Choice, with Single-Answer** A question with a set of choices where only one can be selected
    * **Choice, with Multiple-Answer** A question with a set of choices where many can be selected
    * **Integer Number** A question which answer is an integer number
    * **Decimal Number** A question which answer is a decimal number
    * **Date** A question which answer is a date
    * **Time** A question which answer is a time
    * **Numeric Scale** A question which answer is one option in a range of integers (ex: 1-5)

<p align="center">
  <strong>Figure 2.2: User Input Example</strong>
</p>

```
- #Enter the number of years of experience (integer)
  - Experience-years: 2

- #Select one degree (None; Bachelor; Master; PhD)
  - Academic-degree: None

- #Select one or more programming languages you are proficient in    (java; javascript; python)
  - Programming-languages: java, javascript
```

- Requirement Specifications and Interview Models The support for this functionality must follow specific technical requirements, specified in LPROG. The [ANTLR](https://www.antlr.org/) tool should be used.

**From the client clarifications:**

> **Date:** 2024-03-14
>
> **Question 12:** Qual a distinção entre especificação de requisitos e de entrevistas?
>
> **Answer:** O “estilo” das perguntas e respostas é similar, mas nos requisitos o objetivo é avaliar o candidato e ver se tem os mínimos ou não, portanto o resultado será sim ou não. Nas entrevistas a ideia é classificar/pontuar cada resposta de forma a no final ter pontuações diferentes para os candidatos e assim ajudar a fazer o seu ranking.
>
> **Question 13:** Quem informa o Customer manager do tipo de entrevista/perguntas?
>
> **Answer:** Isso pode ser obtido pelo Customer manager em dialogo com o Customer. Depois disso, com a ajuda do Language engineer é elaborado o suporte para a entrevista.

> **Date:** 2024-03-21
>
> **Question 25:** No job opening é tudo de preenchimento obrigatório ou existem opcionais?
>
> **Answer:** (...) Os requirements vão ser dinâmicos uma vez que dependem do requirements specification selecionado para aquele job opening (que se baseia numa linguagem).

> **Date:** 2024-03-23
>
> **Question 31:** Sobre a job specification, deve ser o cliente a enviar os requisitos ou é a responsabilidade do customer manager? Qual o conceito de uma job specification?
>
> **Answer:** (alguma referência a Q25). Tipicamente será o customer que informa o customer manager dos requisitos mínimos para uma oferta de emprego. O Customer manager verifica se existe já um requirements specification adequado. Caso não existe, com a ajuda do Language Engineer é criado um novo.

> **Date:** 2024-04-04
>
> **Question 38:** Cada questão de um interview model aceita um x tipos de respostas(ex escolha múltipla) ou é a interview model que aceita um x tipos de respostas em todas as suas questões? Assumimos que uma job opening só segue um interview model?
>
> **Answer:** Sim, cada pergunta/resposta aceita um tipo de pergunta/resposta (um dos tipos que aparece no inicio da página 8). Na US1011, o Customer manager seleciona o interview model a usar nas entrevistas para um job opening. Ou seja, existirá apenas um interview model a usar nas entrevistas desse job opening
>
> **Question 40:** Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não data final? Podem haver entrevistas em paralelo?
>
> **Answer:** Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou seja, pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas)...
>
> **Question 41:** Como é que o Language Engineer faz o interview model e os job requirements? É texto? Ou ele seleciona perguntas para a interview e requirements para a job opening? E isso é quando se está a criar uma entrevista ou uma job opening ou para-se a meio para fazer isso e depois continua se?
>
> **Answer:** O language enginner com informação passada pelo customer manager (que obteve do customer) vai desenvolver em java um jar correspondente ao modulo/plugin. Para esse desenvolvimento terá de utilizar técnicas de desenvolvimento de gramáticas/linguagens como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista” na aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”). A aplicação com essa informação carrega dinamicamente esse jar. Na gramátca usada no jar é que vão estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas atividades têm de ser feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora” dos sistema, apenas se registando o modelo (quando está pronto) na US1008. A US 1009 e US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no sistema).

> **Date:** 2024-04-06
>
> **Question 47:** US1008, relativamente aos módulos das entrevistas e dos requisitos, os seus identificadores podem ser automáticos ou específicos (i.e., manuais)?
>
> **Answer:** A Q41 refere a mesma US. Lá refere-se que cada modulo será registado no sistema através de 2 dados, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”. Ou seja, assume-se que cada modulo terá um nome/designação (que suponho que deverá ser única) e a este nome ficará associado o nome do ficheiro jar (provavelmente um path completo) que implementa esse módulo. Ou seja, esse nome/designação pode ser considerado como um identificador especifico/manual.

### 1.3. Acceptance Criteria

* **AC 1:** The generated plugin must be a jar file.

* **AC 2:** The name of the jar file must be unique.

* **AC 3:** The plugin must be created with the auxiliary use of the ANTLR tool.

* **AC 4:** There must be at least one question in the models.

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

_N/A_

### 1.5 Input and Output Data

**Input Data:**

* Inserted Data:
  - Plugin name.

* Selected Data:
  - Plugin type (Job Requirement Specification or Interview Model).

**Output Data:**

- (In)Success or failure message.
- Plugin jar file.

### 1.6. System Sequence Diagram (SSD)

_N/A_


<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>