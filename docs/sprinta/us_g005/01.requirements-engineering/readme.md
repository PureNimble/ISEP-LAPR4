<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US G005 - Add to the project the necessary scripts, so that build/executions/deployments/... can be executed effortlessly

## 1. Requirements Engineering

### 1.1. User Story Description

* As Project Manager, I want the team to add to the project the necessary scripts, so that build/executions/deployments/... can be executed effortlessly.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- Include scripts for all the major tasks and execution of applications.

- The repository should include the necessary scripts to build and deploy the solution in a variety of systems (at least Linux and Windows). It should also include a readme.md in the root folder explaining how to build, deploy and execute the solution.

**From the client clarifications:**

> **Question:** Os scripts que são referidos são apenas de build e testes?
>
> **Answer:** Eu diria que nesta fase (sprint A) possivelmente os scripts remetem apenas para construir as aplicações, executar testes e executar as aplicações. No entanto, a ideia é que consigam manter um conjunto de scripts que permitam a cada momento fazer as operações mais comuns de forma simplificada e fora do IDE. Mais à frente isso torna-se mais importante quando tiverem de preparar, por exemplo, “deployments” mais complexos.

### 1.3. Acceptance Criteria


* **AC1:** Include scripts for all the major tasks and execution of applications.

* **AC2:** The repository should include the necessary scripts to build and deploy the solution in a variety of systems (at least Linux and Windows). 

* **AC3:** Include a [_`readme.md`_](../../../../readme.md) in the root folder explaining how to build, deploy and execute the solution.

### 1.4. Found out Dependencies

* This US has a dependency on [_`US G003`_](../../us_g003/), since to create a script it's necessary to setup the repository first.

### 1.5 Input and Output Data


**Input Data:**

_N/A_

**Output Data:**

* coverage logs
* .svg files

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>