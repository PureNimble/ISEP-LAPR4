<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1011 -  Select the interview model to use for the interviews of a job opening .

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to select the interview model to use for the interviews of a job opening (for their evaluation/grading).

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- Requirement Specifications and Interview Models The support for this functionality must follow specific technical requirements, specified in LPROG. The [ANTLR](https://www.antlr.org/) tool should be used.

- Interview Models, as the name implies, are sequences of questions that can be used to register the answers of candidates during interviews.

- Both job requirement specifications and interview models follow the same usage. A software engineer, with great competences in language engineering, following directions from customer managers, designs and implements modules that are dynamically added to the system. These modules contain the implementation of job requirements specification or interview models. These modules should be able to implement the necessary functionalities from processing job requirements or interviews.

- An interview model module should:
	* Generate a template text file with the questions to be asked in the interview and the possible answers for each question
	* Evaluate if a text file with the questions and answers for a particular candidate interview is syntactically correct
	* Evaluate a text file with the questions and answers for a particular candidate interview and provide a numeric grade for that interview


**From the client clarifications:**

> **Date:** 2024-03-16
>
> **Question 18:** Na US 1011 como é que o Customer Manager seleciona o modelo a usar para as entrevistas?
>
> **Answer:** A18 Admite-se que os modelos quando são registados no sistema (os tais “plugins”) ficam identificados com um nome ou descrição. Por exemplo “Modelo de Entrevista para Operador de Caixa de Supermercado” ou “Modelo de Entrevista para Programador Junior Backend Java”. Na US 1011 é suposto o Customer manager selecionar um modelo de uma possível lista de modelos.

> **Date:** 2024-04-04
>
> **Question 39:** O recruitment process é como está definido ou pode haver alterações no futuro?
>
> **Answer:** A39. O processo é o que está descrito na secção 2.2.1. Neste momento a única fase opcional é a das entrevistas.

> **Date:** 2024-04-11
>
> **Question 52:** Um job opening só tem um customer manager?
>
> **Answer:** A52. Sim, um customer manager em principio gere todas as ofertas de emprego de um cliente (customer). E, consequentemente, existe só um customer manager para cada job opening.
>
> **Question 55:** No seguimento do ponto "2.2.1 Recruitment Process", O customer manager é o responsável por fazer o setup do processo, definindo as fases e indicar se inclui a entrevista. Vimos por este meio solicitar, que nos indique se está previsto que as fases do processo de recrutamento vão ser sempre as mesmas fixas\estanques "candidatura; triagem; entrevistas; análise; resultado;" (entrevista não é obrigatório), ou se as fases podem ser dinâmicas (serem mais, menos, por ordem distinta). No caso de existir entrevista, só vai haver uma para um JobOpening ? Aguardamos esclarecimentos, para adaptar o modelo de domínio se for caso disso.
>
> **Answer:** A55. Sobre a primeira questão remete-se para a pergunta Q39, já respondida. Sobre as entrevistas, a 1011 indica que o customer manager seleciona o “interview model” a usar para as entrevistas de um “job opening”. Assim, estamos a admitir que será sempre o mesmo interview model para todas as entrevistas, ou seja, todas as entrevistas terão as mesmas perguntas. Ou seja, é adequado admitir que só vai haver uma entrevista para um “job opening”.

> **Date:** 2024-04-19
>
> **Question 92:** Processo de Setup de uma Job Opening – Tendo em conta a US1007, de setup das diferentes fases do processo de recrutamento, gostaríamos que nos fosse esclarecido se, caso seja selecionada uma fase de Interview, é necessário haver uma ligação direta com a US1011, seleção de um interview model, ou serão funcionalidades separadas? Na eventualidade de serem separadas, passa então um recruitment process a ser válido apenas após a seleção de um interview model?
>
> **Answer:** A92. Suponho que a minha reposta seja similar à da pergunta anterior (Q91). Posso adiantar que podemos considerar que a empresa para já pretende usar sempre um processo de avaliaçao de entrevistas “automático”, pelo que este deve estar definido para se poderem “executar/processar” as entrevistas.

> **Date:** 2024-05-02
>
> **Question 138/139:** Interview model e Requirements specification – Os nomes a usar nestes “conceitos” têm restrições?
>
> **Answer:** A138 Ver Q41. O nome dado aos interview models ou requirements specifications é uma string que descreve o “objetivo” desse plugin. Um exemplo já dado é “5 anos experiência java” para um plugin de requirements specification que valida as candidaturas a um job opening para um trabalho que necessita de 5 anos de experiência em java

### 1.3. Acceptance Criteria

* **AC1:** The system must display the list of interview model to use for the interviews of a job opening.

* **AC2:** The system must display the selected option .

* **AC3:** ANTTLR tool should be used to support the functionality.

### 1.4. Found out Dependencies

**US 1002 - Register a job opening:** To select the interview modelto a job opening there must be an already existing job opening.

**US 1008 - Deploy and configure a plugin:** The system must have a plugin(Interview Model) that allows the Customer Manager to generate and export a template text file to help collect the candidate answers during the interviews.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Selection of interview format

**Output Data:**
* Interview models list
* Interview model selected

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>