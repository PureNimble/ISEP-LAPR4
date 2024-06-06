<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 3003 - Notification of application when the state of my job openings changes.

## 1. Requirements Engineering

### 1.1. User Story Description

* As Customer, I want to be notified in my application when the state (phase) of my job openings changes.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- The Backoffice app is used by admins, customer managers and operators. Both the Candidate and Customer apps follow a specifc design, as described by NFR10. They connect to a server (Follow Up Server) using a specific protocol (NFR10). Only the server is able to connect directly to the database. It is important to note that the client apps receive notifications originating from the server.

  **From the client clarifications:**

> **Date:** 04/06/2024
>
> **Question 240:** US3003 - No âmbito da visualização de notificações na app de cliente deseja que a listagem tenha algo em específico por exemplo, apenas as não lidas (consequentement terá de haver uma opção marcar como lida).
>
> **Answer:** Sim, para mim faz sentido que o conceito de notificação tenha uma opção de marcar como lida a notificação. Deve ser possível ver as notificações “já lidas” (algo como ver “todas” ou ver “todas a partir de uma data”).

### 1.3. Acceptance Criteria

**AC 1:** The system must notify the customer in the application when the state of one of the job openings changes.

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