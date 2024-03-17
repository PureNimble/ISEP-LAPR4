<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US G004 - Setup a continuous integration server

## 1. Requirements Engineering

### 1.1. User Story Description

* As Project Manager, I want the team to setup a continuous integration server.


### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

- GitHub Actions/Workflows should be used.

- The Github repository will provide night builds with publishing of results and metrics.

**From the client clarifications:**

> **Question:** Relativamente ao continuous integration server, o workflow irá ter que ser executado a cada push ou uma vez por dia, á noite?
>
> **Answer:** Tenho de considerar que essa questão é para o Product Owner, pelo que irei responder na sessão com o Product Owner (refere-se a Requisitos Funcionais, G004).Em termos meramente técnicos é simples configurar de uma forma ou de outra.


### 1.3. Acceptance Criteria

* **AC1:** GitHub Actions/Workflows should be used.

* **AC2**:** The GitHub repository will provide night builds with publishing of results and metrics.

### 1.4. Found out Dependencies

* This US has a dependency on [_`US G002`_](../../us_g002/), since to create a workflow/integration server is necessary to setup the repository first.

### 1.5 Input and Output Data

**Input Data:**

_N/A_

**Output Data:**

* coverage logs
* .svg files update

### 1.6. System Sequence Diagram (SSD)

_N/A_

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>