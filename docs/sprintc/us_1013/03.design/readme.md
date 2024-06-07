<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# US 1013 - Rank the candidates for a job opening

## 3. Design - User Story Realization

### 3.1 Rationale

| Interaction ID | Question: Which class is responsible for...                        | Answer                 | Justification (with patterns)                                                                                 |
|:---------------|:-------------------------------------------------------------------|:-----------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?                                   | RegisterRankUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... asking to select the job opening?						   		                  | RegisterRankUI         | Information Expert: The UI knows how to interact with the user and ask for the desired job opening.           |
| 			  		        | 	... coordinating the US?                                          | RegisterRankController | Controller: The controller is responsible for handling the user's request and coordinating the use case.      |
| 			  		        | 	... saving the rank?						                                        | RankRepository         | Information Expert: The repository knows how to save a rank.                                                  |
| 			  		        | 	... creating the rank?						                                      | RankBuilder            | Creator: The builder knows how to create a new rank                                                           |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Rank

Other software classes (i.e. Pure Fabrication) identified:

* RegisterRankUI
* RegisterRankController
* RankRepository
* RankBuilder

These classes are responsible for the user interface, controlling the use case, and interacting with the database, respectively.


## 3.2. Sequence Diagram (SD)

![SD -> Rank the candidates for a job opening](svg/SD-US1013.svg)

## 3.3. Class Diagram (CD)

N/A
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>