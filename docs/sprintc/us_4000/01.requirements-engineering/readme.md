<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 4000 - Present a top 20 list of the most frequently referenced words from files uploaded by a candidate.

## 1. Requirements Engineering

### 1.1. User Story Description

* As a Customer Manager, when displaying the candidate data, I expect the system to present a top 20 list of the most frequently referenced words from files uploaded by a candidate. Additionally, I require a comprehensive list of the files in which these words appear.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

_N/A_

**From the client clarifications:**

> **Date:** 2024-05-16
>
> **Question 170:** Gostaria de saber se na US4000, relativa há criação da lista de palavras mais comuns, presentes nos ficheiros carregados pelo candidato, pretende escolher uma candidatura desse mesmo candidato e criar a respetiva lista, ou se pretende que esta lista seja criada, tendo em conta todas as candidaturas associadas a esse candidato.
>
> **Answer:** A lista de palavras é relativa a uma candidatura em particular.

> **Date:** 2024-05-17
>
> **Question 181:** When making the Top 20 Used Words by a candidate, the files subject to word counting are all files of all the chosen candidate's applications? Or can the Customer Manager choose a candidate's specific application and from there get the top 20 words from those files?
>
> **Answer:** See Q170.

> **Date:** 2024-05-19
>
> **Question 185:** The order of the list is important? Does it need to be ordered by the number of occurrences of the words?
>
> **Answer:** Yes, the order is important. The system must present a top 20 list, from most referenced words to less referenced words.
>
> **Question 186:** For the word count, should all types of words be counted, or are there words that don't make sense to count, such as conjunctions?
>
> **Answer:** For the moment there are no restrictions like the one you mention since they depend on the language used in the text (the solution could/would be complex).
>
> **Question 185:** When displaying the candidate info is expected to show the list of words for each application of the candidate, or the customer manager needs to select a specific application to see the list of words?
>
> **Answer:** This regards all the possible applications of a candidate that the customer manager is managing.
>
> **Question 191:** I think it makes sense to ignore words with less than 3 letters, or something like this, because it makes no sense to have words like as, I, am... Can we make this assumption or should we count any word?
>
> **Answer:** If you want, you may use a configuration file to configure the minimum number of sequence of characters to be counted as a word in the process. However, this is a temporary exception, accepted, but not considered as a good solution (a good solution should be one that takes into account the used language).

> **Date:** 2024-05-25
>
> **Question 219:** Recentemente, respondeu a dúvidas sobre a funcionalidade que pretende que seja feita sobre o top 20 número de palavras em ficheiros de candidaturas de candidatos (Q170 e Q187). Quando analisamos as perguntas, ficámos na dúvida sobre qual a interpretação a levar em conta, de que a funcionalidade deve ser feita sobre todas as candidaturas do candidato (Q187), ou se o Customer Manager escolhe 1 candidatura do candidato e depois a funcionalidade faz o seu trabalho sobre apenas essa candidatura.(Q170)
>
> **Answer:** Os dados do candidato (“candidate data”) referem-se aos dados do candidato que pode ter várias candidaturas. Nesse contexto ao apresentar os dados de cada candidatura devem aparecer, para cada candidatura (application), o top 20.

> **Date:** 2024-05-26
>
> **Question 220:** Na us 4000 é referido, "Additionally, I require a comprehensive list of the files in which these words appear." Quer apenas que para a palavra "x" digamos em que ficheiros existe ou mais alguma informação?
>
> **Answer:** É como indica, para cada palavra em que ficheiros aparece.

### 1.3. Acceptance Criteria

**AC 1:** The system must present the list of words for each application of the candidate in descending order of the number of occurrences of the words.

### 1.4. Found out Dependencies

* **US 2002 - Create Application:** The system must have the applications created to be able to present the list of words for each application of the candidate.

### 1.5 Input and Output Data

**Input Data:** 

_N/A_

**Output Data:**

_N/A_

### 1.6. System Sequence Diagram (SSD)

_N/A_


<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>