<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1004 - Edit a Job Opening

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer Manager, I want to edit a job opening.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- A customer manager will register job offers for the entities he manages in the backoffice. The customer manager will also manage other aspects of job offers.

**From the client clarifications:**

> **Date:** 2024-05-13
>
> **Question 144:** No seguimento da US 1004 para permitir editar um job opening, estamos a assumir que é permitido alterar: Nº de vagas; Morada; Contract Type('FULL_TIME', 'PART_TIME'); Mode ('ON_SITE','REMOTE'); Description; Funcao. Estamos na linha de raciocício correta, ou é necessário alterar a lista para incluir outra informação adicional ou suprimir alguma desta lista?
>
> **Answer:** Do meu ponto de vista deve ser possível alterar “tudo” exceto o próprio job reference. Deve-se ter em conta a manutenção do estado de consistência do sistema.

> **Date:** 2024-05-14
>
> **Question 150:** Quando o Costumer Manager quer editar uma Job Opening, é suposto ele escolher qual Job Opening quer editar a partir de uma pesquisa pela referência?
>
> **Answer:** A questão refere-se um pouco a boas práticas de UI/UX. O contexto indicado na pergunta refere-se a uma situação em que o utilizador tem de identificar a entidade/objeto que deseja editar. Pode-se assumir que o utilizador sabe esse identificador. Mas, em termos de UX/UI deve ser possível obter esse identificar por outras vias (até porque é um identificar gerado pelo sistema). Penso que, para este caso particular, existe já uma US que permite fazer isso.
>
> **Question 154:** Em quais ou até que fases de recrutamento de um Job Opening em que pode-se editar as informações dela? E quais são as informações que podem ser editadas dentro de uma Job Opening?
>
> **Answer:** As alterações devem ser compatíveis com o “momento” em que estamos nessa job opening. Por exemplo, não faz sentido alterar o contrat type se já estamos a receber candidaturas. Essas candidaturas foram feitas segundo uma descrição da oferta de emprego e não faz sentido estar a alterar depois de as pessoas se candidatarem. Mas, por exemplo, deve ser possível alterar o job requirements specification (refere-se a outra US) enquanto as pessoas se candidatam, pois é um aspeto técnico, que não é do conhecimento público. Portanto, devem ter em conta este tipo de preocupações.

> **Date:** 2024-05-15
>
> **Question 156:** A cada edição feita de alguma informação numa Job Opening, é necessário registar a data e a hora da edição, tal como acontece no momento de registar a Job Opening?
>
> **Answer:** Não me recordo da indicação de registar data e hora no momento de registar um job opening. Mas sobre este tema, e em geral, é comum haver um registo do utilizador que criou ou fez a última atualização de um “registo” no sistema. Outra boa prática é as aplicações terem sistemas de log para situações deste género. Mas não me recordo de haver algum requisito não funcional que mencione um sistema de log para este nosso projeto (exceto o do application file bot).

> **Date:** 2024-05-20
>
> **Question 193:** Tendo em conta a us1004 já referiu em questões passadas que deveria ser possível editar todos os atributos de job Opening , excepto a job Reference. No entanto, pergunto se faria sentido editar a data ativa (active since) de uma job Opening uma vez que é um registo único de quando a Job Opening ficou ativa. Pergunto também se seria também possível editar o Customer associado a job Opening,uma vez que a Job Reference se baseia no Customer. Dada a impossibilidade de edição de Job Reference pergunto se faria sentido a edição de customer também.
>
> **Answer:** Penso que se refere à Q144. Estou de acordo com as suas preocupações. É isso a que me refiro quando na Q144 escrevo “Deve-se ter em conta a manutenção do estado de consistência do sistema.”

> **Date:** 2024-05-21
>
> **Question 203:** Como esclareceu na questão 154 no ficheiro de questões, mencionou que não faria sentido editar o Contract Type se estivéssemos já na fase de Candidaturas. Pergunto se também faria sentido não ser editável nesta fase o Mode, assim como a sua morada e a função (Como "Front-end Programmer"), uma vez que são atributos que um candidato tem em mente quando faz uma candidatura a uma Job Opening. Pergunto também se o Job Requirements não deveriam ser editáveis a partir da frase screening (assim como o Interview Model na fase Interviews) uma vez que esta é a fase em que estes são verificados. Por fim pergunto : O número de vagas é editável em todas as fases?
>
> **Answer:** No geral o que refere está correto. As informações públicas de uma job opening não devem ser alteradas depois de serem tornadas públicas. Quanto a informações não públicas e mais técnicas penso que é aceitável que possam ser alteradas se não resultarem em possíveis estados incoerentes do sistema.
>
> **Question 205:** Como foi esclarecido em questões previas ,é possível a edição de um Interview Model e Job Requirements de um jobOpening se estiver na fase de candidaturas (por exemplo). Pergunto-lhe se seria possível editar para cada um, a sua designação e descrição . Pergunto também se faria ou teria algum interesse de que seja editado o nome da classe que implementa a interface que faz o serviço do para cada Plugin: "ReqEvaluator" para Job Requirements no meu caso.
>
> **Answer:** A pergunta é um pouco técnica para mim. Para mim faz sentido a edição desde que mantendo a consistência do sistema. Quanto aos aspetos mais técnicos não sei responder.

> **Date:** 2024-05-26
>
> **Question 221:** Em relação à edição de uma Job Opening, uma das regras que pareceu clara no que toca ao que pode ser modificado foi: informações públicas de uma Job Opening, que estejam disponíveis para possíveis candidatos, não podem ser modificadas aquando/após a fase em que estamos a receber candidaturas. Segundo o documento de System Specification ("The recruitment process for a job opening follows a sequence of phases: application; resume screen; interviews; analysis; result.") a equipa estruturou as Job Openings de modo a que a primeira fase possível para uma Job Opening seja de de candidaturas. Assim sendo, pergunto-lhe se lhe parece correto a inclusão de uma nova fase preliminar, na qual as alterações referidas podem ser efetuadas?
>
> **Answer:** Eu diria que isso seria uma opção relacionada com a solução. Talvez seja uma solução para o “problema” que descreve mas não creio que seja a única solução.
>
> **Question 222:** Ainda relativamente à edição de uma Job Opening, foi elaborada a seguinte tabela que representa uma sugestão de quais elementos de uma Job Opening devem ser editáveis para cada uma das fases (considerando a fase preliminar previamente sugerida). Por favor diga se esta abordagem vai de encontro aos seus desejos ou se acha necessário alterar algo de modo a melhor acomodar o objetivo da funcionalidade.
> | Fase | Atributos Editáveis |
> |:-----:|:--------:|
> | Preliminar | Todos, exceto JobReference e Customer |
> | Applications | Informação não pública: Requirement Specification, Interview Model, datas de início e final das fases, exceto o início da fase atual e datas de fases anteriores |
> | Screening | Interview Model e datas de início e final das fases, exceto o início da fase atual e datas de fases anteriores |
> | Interview | Data de final da fase de Interviews e datas de início e final de fases futuras |
> | Analysis | Data de final da fase de Analysis e datas para a fase de resultados |
> | Result | Nenhum atributo |
>
> **Answer:** Parece-me adequado, mas estou a responder sem perceber como está toda a solução.

> **Date:** 2024-05-27
>
> **Question 225:** Ao "editar uma JobOpening" seria possível editar a sua fase atual nesta user story?
>
> **Answer:** A intenção desta US é permitir a edição dos dados que caracterizam a job opening do ponto de vista de conceito de negócio. A alteração das fases tem uma US especifica.

### 1.3. Acceptance Criteria

* **AC1:** The system must allow the edition of the job opening in the following phases:
	* Preliminary: All attributes except job reference and customer.
	* Applications: Non-public information: Requirement Specification, Interview Model, start and end dates of the phases, except the start of the current phase and dates of previous phases.
	* Screening: Interview Model and start and end dates of the phases, except the start of the current phase and dates of previous phases.
	* Interview: End date of the Interview phase and start and end dates of future phases.
	* Analysis: End date of the Analysis phase and dates for the results phase.
	* Result: No attribute.

### 1.4. Found out Dependencies

* **US 1002 - Register a Job Opening:** Job openings must be registered before they can be edited.

* **US 1007 - Setup the phases of the process for a job opening:** The phases and dates of the job opening must be registered before they can be edited.

* **US 1009 - Select the specification to be used for a job opening:** Job requirements must be registered before they can be edited.

* **US 1010 - Select the interview model to use for the interviews of a job opening:** The interview model must be registered before it can be edited.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* Title or function
	* Address
	* Number of vacancies
	* Description
	* Start date of the phase
	* End date of the phase

* Selected data:
	* Contract Type
	* Mode
	* Company
	* Requirements (US 1009)

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![SSD - US1004](svg/SSD-US1004.svg)

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>