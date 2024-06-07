<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 3001 - Notification in application when the state of one of the applications changes.

## 1. Requirements Engineering

### 1.1. User Story Description

* As Candidate, I want to be notified in my application when the state of one of my applications changes.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- The Backoffice app is used by admins, customer managers and operators. Both the Candidate and Customer apps follow a specifc design, as described by NFR10. They connect to a server (Follow Up Server) using a specific protocol (NFR10). Only the server is able to connect directly to the database. It is important to note that the client apps receive notifications originating from the server.

  **From the client clarifications:**

> **Date:** 16/05/2024
>
> **Question 174:** US3001 - Na US 3001 pretende que o candidato seja notificado na sua aplicação quando o estado de uma aplicação mudar. De que forma pretende que o candidato seja notificado? E caso o candidato não esteja a correr a aplicação, essa notificação é perdida?
>
> **Answer:** O candidato deve ser notificado quando a sua “app” está em execução. Relativamente a notificações que “acontecem” quando não está a correr a aplicação, seria interessante que as recebesse da próxima vez que executasse a aplicação.
>
> **Question 175:** US3001 - Questão âmbito notificações - O candidato será notificado, quando a sua candidatura mudar de estado. O que se entende por notificado, é receber um email, quando entra na aplicação tem uma fila de 'inbox' ? Quando a aplicação está ligada recebo email? É o candidato que faz o pedido(cliente) (Pop) inicia assim a comunicação, e recebe a resposta/notificação (servidor). E como encaixo o cenário de notificação(push)?
>
> **Answer:** Ver Q174. Neste caso as notificações são na aplicação do candidato, não são por email.

> **Date:** 19/05/2024
>
> **Question 189:** US3001 – Application State – I'd like some clarifications regarding the state that US3001 mentions. Is it the "accepted/not accepted" state, or a state regarding the phases of the recruitment process of which the application is associated to?
>
> **Answer:** This US is focused on the Candidate perspective. He/she may not be aware of the internal phases of the recruitment process. But he/she is interested in knowing the “external” state of his/her applications. For instance, as a candidate I would like to know if my application was received. Then I would like to know if my application was accepted or not and, finally, if I was selected or not.

> **Date:** 29/05/2024
>
> **Question 229:** US 3001 - Segundo a nossa perspetiva sobre esta funcionalidade, achámos melhor o utilizador ter na sua aplicação uma espécie de inbox de notificações. Quando o utilizador está na funcionalidade das notificações este recebe as notificações que tinha e que não foram enviadas porque não estava na aplicação e depois fica á espera de novas notificações que apareçam entretanto, até o utilizador pedir para sair da funcionalidade. Esta abordagem está alinhada com suas expectativas?
>
> **Answer:** Pode ser. Mas não seria possível receber as notificação mesmo não estando nessa “opção de menu”? Sendo uma aplicação “console” limita um pouco a UI, mas não seria possível receber as notificações desde que tenha a aplicação em execução mas só mostrar essas notificações quando o utilizador seleciona a opção? Em termos de UI a diferença é mínima, em termos de implementação pode ser significativa. Talvez esta seja até mais uma questão para RCOMP.

> **Date:** 30/05/2024
>
> **Question 233:** US 3001 – Notifications - Em questões anteriores sobre esta funcionalidade menciona que como candidate gostaria de saber se a sua candidatura foi recebida, aceite e escolhida. Pedimos que descreva a que se refere quando diz que uma candidatura foi aceite, e quando foi escolhida.
> 
> **Answer:** É aceite se passa o processo de verificação de requisitos. É escolhida se após o ranking está dentro dos lugares das vagas para o job opening.

### 1.3. Acceptance Criteria

**AC 1:** The system must notify the candidate in the application when the state of one of his applications changes.

### 1.4. Found out Dependencies

_N/A_

### 1.5 Input and Output Data

**Input Data:**

_N/A_

**Output Data:**

* Notifications

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>