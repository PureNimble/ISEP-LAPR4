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


> **Question:** Qual a distinção entre Company e Entity?
>
> **Answer:** Quando no enunciado aparece a referência a entity é no sentido de podermos ter clientes da Jobs4u que podem não ser empresas, podem ser outro tipo de organizações.


> **Question:** Por cada Customer, apenas existe um “representante” que acede à conta (i.e., Customer App)?
>
> **Answer:** Sim, parece-me suficiente.


> **Question:** No contexto em que o Customer Manager regista uma oferta de emprego, como são selecionados/definidos os requisitos para essa job offer?
>
> **Answer:** O Customer manager regista a job opening (US 1002) e de seguida (normalmente) seleciona qual o requirements specification que é adequado a esse job opening. O requirements specification será um dos que foi “criado” pelo language engineer e registado no sistema.


> **Question:** Alfredo – O email bot é referido como estando “out of scope”. Isso é referente ao sistema ou ao modelo de negócio?
>
> **Answer:** Do ponto de vista do processo de receção de candidaturas é importante termos a noção de como são rececionadas as candidaturas e como são processadas. Dito isto, o processo automático descrito como “email bot” está fora do âmbito da solução a desenvolver, tal como ilustrado na figura 4.1.


> **Question:** O Admin é responsável por gerir apenas Customer managers ou outros, como por exemplo Operators? E qual o significado dessa responsabilidade?
>
> **Answer:** A ideia é que o Admin fará a gestão desses utilizadores (e no limite também dos Operators). Na prática, as US que remetem para essas funcionalidades, podem ser “substituidas” por um processo de “bootstrap” que faça inicializações na base de dados para suportar esses utilizadores/papeis (tal como mencionado no texto das US).


> **Question:** No enunciado não está explicita a informação a recolher para os Customers? Qual a informação necessária? E quando aos funcionários da empresa?
>
> **Answer:** De facto isso não está explicito. No entanto, são referidos no nome da empresa e o seu endereço no âmbito de um job opening. Quanto aos utilizadores (representante da empresa que acede à Customer App) eu diria que serão dados similares ao do Candidate. Quando aos funcionários da empresa, eu diria que é importante garantir que é usado o email para identificar qualquer utilizador do sistema. Penso que será importante para cada utilizador termos o nome completo assim como um short user name (que deverá ser único). **Actualização em 2024-03-21: O Product Owner reconsiderou e decidiu que o short user name é dispensável uma vez que para autenticação dos utilizadores se deve usar apenas o email e a password.**


> **Question:** Qual a distinção entre especificação de requisitos e de entrevistas?
>
> **Answer:** O “estilo” das perguntas e respostas é similar, mas nos requisitos o objetivo é avaliar o candidato e ver se tem os mínimos ou não, portanto o resultado será sim ou não. Nas entrevistas a ideia é classificar/pontuar cada resposta de forma a no final ter pontuações diferentes para os candidatos e assim ajudar a fazer o seu ranking.


> **Question:** Um customer manager pode gerir vários clientes?
>
> **Answer:** Sim.


> **Question:** Quem informa o Customer manager do tipo de entrevista/perguntas?
>
> **Answer:** Isso pode ser obtido pelo Customer manager em dialogo com o Customer. Depois disso, com a ajuda do Language engineer é elaborado o suporte para a entrevista.


> **Question:** É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” de verificação da candidatura neste processo?
>
> **Answer:** Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin referido entre neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se os critérios não forem atingidos a candidatura é recusada.


> **Question:** Relativamente à secção 2.2.1 e às fases do processo de recrutamento, para passarmos para a fase seguinte a anterior tem de fechar ou podemos avançar sem ter a anterior fechada?
>
> **Answer:** A resposta curta é que as fases devem ser sequencias e não sobreposta. Quando fecha uma fase abre a próxima. A US 1007 prevê a definição das fases. A US 1010 prevê a abertura e fecho de fases do processo. A decisão do Customer Manager de fechar uma fase deve assumir que o processo avança para a próxima fase automaticamente (independentemente das datas definidas para as fases).


> **Question:** Relativamente à secção 2.2.1, é na fase de Analysis que as entrevistas são avaliadas e é esse resultado que define o ranking dos candidatos? Além disso, para que serve o CV nesta fase? Visto que as entrevistas não são obrigatórias, o que acontece quando estas não se realizam?
>
> **Answer:** A pontuação das entrevistas é efetuada/calculada na fase das entrevistas. O CV e outros dados (como o resultado das entrevistas) é usado pelo Customer manager na fase de analise para ordenar os candidatos. Mas a ordenação é da responsabilidade do Customer Manager (por exemplo, não tem de seguir a ordem da pontuação nas entrevistas). A US 1013 corresponde à ordenação manual dos candidatos feita pelo Customer Manager. O facto de não haver entrevistas não tem implicações na ordenação dos candidatos pois esta não depende explicitamente das entrevistas.



> **Question:** Na US 1011 como é que o Customer Manager seleciona o modelo a usar para as entrevistas?
>
> **Answer:** Admite-se que os modelos quando são registados no sistema (os tais “plugins”) ficam identificados com um nome ou descrição. Por exemplo “Modelo de Entrevista para Operador de Caixa de Supermercado” ou “Modelo de Entrevista para Programador Junior Backend Java”. Na US 1011 é suposto o Customer manager selecionar um modelo de uma possível lista de modelos.


> **Question:** Na criação de um utilizador no sistema o nome é definido pelo utilizador ou é o nome da pessoa (primeiro e último) e se a password é definida pelo utilizador ou gerada pelo sistema ?
>
> **Answer:** No âmbito da US 2000a o Operator cria utilizadores do sistema para candidatos que ainda não estejam no sistema. Tem de fazer isso com base nos dados recebidos na candidatura (que incluem email e nome). O email servirá para identificar a pessoa. Neste contexto é necessário ter uma password para esse novo utilizador. Uma vez que essa informação não é transmitida pelo candidato, suponho que a solução mais “aconselhada” será o sistema gerar uma password para esse utilizador. Como o utilizador/candidato irá receber essa informação (a forma de autenticação na app) está out of scope, no sentido em que não existe nenhuma US que remete para isso. As US 1000 e 1001 também remetem para criação de utilizadores. Aqui, eventualmente poderia-se pensar em introduzir manualmente as passwords, mas pode ser pelo mesmo mecanismo de definição automática de password, descrito anteriormente. Relativamente ao nome ver novamente a Q11.


> **Question:** Uma pessoa poderá ter vários papeis no sistema?
>
> **Answer:** Será muito difícil controlar que uma pessoa não consegue ter mais do que uma forma de acesso ao sistema (por exemplo, uma pessoa que é Customer Manager poderá ser, no limite, também uma candidato a uma oferta de emprego). Relativamente aos papéis “internos” eu diria que devemos considerar uma hierarquia de acessos. O Admin pode fazer “tudo” o que os outros fazem. Segue-se o Customer Manager e por último o Operator.


> **Question:** Relativamente às Empresas, e relacionado com a Q11, o que é que significava o endereço mencionado na resposta?
>
> **Answer:** Estava a referir-me ao endereço postal da empresa (não ao endereço email).


> **Question:** Relativamente ao Job Opening (secção 2.2.2), o job reference refere que deve ser gerado pelo sistema a partir de um customer code. O que é este customer code e se existe alguma regra para a sua criação?
>
> **Answer:** Eu dira que qualquer customer terá de ter um código identificativo (único) que poderá ser uma espécie de abreviatura do seu nome. Com um número limitado de caracteres. Por exemplo, para o cliente Instituto Superior de Engenharia do Porto, o customer code poderia ser ISEP e não poderia haver mais nenhum customer com este customer code. Um limite razoável seria talvez 8 a 10 carateres. Podemos definir 10. Este código é introduzido manualmente na criação do customer no sistema.


> **Question:** A mudança de estado é referente ao candidato ou à candidatura individual e como se relaciona com o enable/disable dos utilizadores?
>
> **Answer:** O enable/disable dos users é apenas para controlar os acessos ao sistema. O estado, no processo de candidatura, é o estado da candidatura de um candidato a um job opening, não está diretamente relacionado com o enable/disable dos users.


> **Question:** Para identificar uma candidatura usa-se o id do candidato e o id do job opening?
>
> **Answer:** Não é bem assim. As candidaturas vão entrar no sistema através dos ficheiros gerados pelo Application Email Bot. Esses ficheiros vêm identificados pelo Job Reference seguido de um “número” que identifica a candidatura a esse job reference. Será tipicamente um número sequencial. No conteúdo desses ficheiros vai aparecer os dados do candidato. Repare-se que pode até o candidato ainda não existir (não ter registo no sistema).


> **Question:** No job opening é tudo de preenchimento obrigatório ou existem opcionais?
>
> **Answer:** Os campos referidos na secção 2.2.2 são de preenchimento obrigatório. Os requirements vão ser dinâmicos uma vez que dependem do requirements specification selecionado para aquele job opening (que se baseia numa linguagem).


> **Question:** Do ponto de vista do app file bot deve representar um serviço no sistema?
>
> **Answer:** Eu diria que sim, uma vez que é um processo que é necessário no sistema para transformar dados rececionados em formato que seja “reconhecido” pelo processo de recrutamento.


> **Question:** US2000b, o que é o enable/disable do candidato?
>
> **Answer:** (alguma referencia a Q23). Refere-se a desativar o acesso do candidato ao sistema (i.e., Candidate App).


> **Question:** Sobre a job specification, deve ser o cliente a enviar os requisitos ou é a responsabilidade do customer manager? Qual o conceito de uma job specification?
>
> **Answer:** (alguma referência a Q25). Tipicamente será o customer que informa o custerm manager dos requisitos mínimos para uma oferta de emprego. O Customer manager verifica se existe já um requirements specification adequado. Caso não existe, com a ajuda do Language Engineer é criado um novo.


> **Question:** Os candidatos também têm estados associados? À medida que o processo avança, o estado do candidato também é atualizado?
>
> **Answer:** O estado é da candidatura. O avanço no processo pode não levar a “avanço” numa candidatura pois, por exemplo, no final do screening a candidatura pode ser rejeitada e, nesse caso, essa candidatura termina ai. Outras candidatura seguem o processo.


> **Question:** O candidato tem um código identificativo ou é o email que o identifica?
>
> **Answer:** A identificação do candidato é por email. Não haverá necessidade de um código.


> **Question:** US3002, lista job openings, position o que é?
>
> **Answer:** Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.


> **Question:** Customer tem que ter morada e nome da empresa ou se basta essa informação estar no job opening?
>
> **Answer:** Devemos registar nome e morada do customer. Para cada job opening a morada pode ser especifica (e diferente da morada do customer).


> **Question:** US1021, o que é “all data of an application”? O que é uma job application?
>
> **Answer:** Uma job application é uma candidatura (de um candidato) a uma job opening. Relativamente ao “all data of na application” refere-se a todos os dados de uma candidatura, nomeadamente, os ficheiros submetidos pelos candidato assim como dados recolhidos ou gerados durante o processo (como as entrevistas e processamento de requisitos).


> **Question:** No job opening (secção 2.2.2), no campo company, deve ser o customer name ou o customer code, uma vez que o customer code é único e introduzido manualmente?
>
> **Answer:** A informação relativa ao job opening que aparece no final da página 5 deve ser vista como algo a ser usado na divulgação de uma oferta de emprego. Nesse contexto, para a Company faz mais sentido divulgar o nome da company e não o seu código. Dito isto, em termos de armazenamento numa base de dados poderá ficar o código.


> **Question:** Cada questão de um interview model aceita um x tipos de respostas(ex escolha múltipla) ou é a interview model que aceita um x tipos de respostas em todas as suas questões? Assumimos que uma job opening só segue um interview model?
>
> **Answer:** Sim, cada pergunta/resposta aceita um tipo de pergunta/resposta (um dos tipos que aparece no inicio da página 8). Na US1011, o Customer manager seleciona o interview model a usar nas entrevistas para um job opening. Ou seja, existirá apenas um interview model a usar nas entrevistas desse job opening.


> **Question:** O recruitment process é como está definido ou pode haver alterações no futuro?
>
> **Answer:** O processo é o que está descrito na secção 2.2.1. Neste momento a única fase opcional é a das entrevistas.


> **Question:** Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não data final? Podem haver entrevistas em paralelo?
>
> **Answer:** Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou seja, pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas). A US1014 refere-se à marcação da data de uma entrevista com um candidato. Algo como indicar o dia e a hora (ex: 23 de abril pelas 14:00). Em relação à marcação de entrevistas “sobrepostas” (com a mesma data de inicio), neste momento, seria algo a permitir (pode, por exemplo, o customer manager delegar noutra pessoa a condução da entrevista). Isso não invalida que devam validar se as entrevistas ocorrem dentro da fase das entrevistas.


> **Question:** Como é que o Language Engineer faz o interview model e os job requirements? É texto? Ou ele seleciona perguntas para a interview e requirements para a job opening? E isso é quando se está a criar uma entrevista ou uma job opening ou para-se a meio para fazer isso e depois continua se?
>
> **Answer:** O language enginner com informação passada pelo customer manager (que obteve do customer) vai desenvolver em java um jar correspondente ao modulo/plugin. Para esse desenvolvimento terá de utilizar técnicas de desenvolvimento de gramáticas/linguagens como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista” na aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”). A aplicação com essa informação carrega dinamicamente esse jar. Na gramátca usada no jar é que vão estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas atividades têm de ser feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora” dos sistema, apenas se registando o modelo (quando está pronto) na US1008. A US 1009 e US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no sistema).


> **Question:** US1006, Qual a informação do nome do candidato deve aparecer (nome completo, primeiro e ultimo nome , etc)?
>
> **Answer:** À partida diria que seria o nome, tal como foi recebido na application que fez (página 6, “name of the candidate”)

> **Question:** Para os candidato e para os utilizadores do sistema que informações são necessárias?
>
> **Answer:** Alguma informação anterior é referida na Q11. Para além disso a secção 2.2.3 refere que relativamente aos candidatos temos a seguinte informação: email of the candidate, name of teh candidate, phone number of the candidate.


> **Question:** Relativamente à secção 2.2.3 e ao facto de o application email bot estar fora do scope mas produzir a informação descrita nessa secção, será disponibilizado exemplos dessa informação?
>
> **Answer:** Sim. Será disponibilizado um exemplo da informação produzida pelo application email bot.


> **Question:** Relativamente aos estados possíveis de uma candidatura, quais são os estados possíveis?
>
> **Answer:** O estado deve refletir em que estado do processo se encontra e o possível resultado final. Do ponto do vista do cliente, deve ser algo que faça sentido para ele. Ou seja, não sei se faz sentido o candidato saber detalhes que podem não fazer sentido para ele, pois este pode não conhecer todos os detalhes internos da gestão de um processo de candidatura.


> **Question:** US1007, o identificar do processo de recrutamento pode ser um numero automático ou seja mais especifico?
>
> **Answer:** O job opening tem um identificar. O processo de recrutamento de um job opening é um “tributo” desse job opening. À partida não vejo necessidade de ter um identificador “especial” para o processo de recrutamento (i.e., fases do processo de recrutamento desse job opening).


> **Question:** Beatriz – US1008, relativamente aos módulos das entrevistas e dos requisitos, os seus identificadores podem ser automáticos ou específicos (i.e., manuais)?
>
> **Answer:** A Q41 refere a mesma US. Lá refere-se que cada modulo será registado no sistema através de 2 dados, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”. Ou seja, assume-se que cada modulo terá um nome/designação (que suponho que deverá ser única) e a este nome ficará associado o nome do ficheiro jar (provavelmente um path completo) que implementa esse módulo. Ou seja, esse nome/designação pode ser considerado como um identificador especifico/manual.


### 1.3. Acceptance Criteria

* **AC1:** Domain Driven Design (DDD) must be followed.

### 1.4. Found out Dependencies

_N/A_

### 1.5 Input and Output Data

_N/A_

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>