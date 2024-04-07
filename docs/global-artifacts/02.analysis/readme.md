<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# Analysis

The process of building the domain model is based on the client's specifications, especially the nouns (for concepts) and verbs (for relationships) used.

## Rationale for identifying domain conceptual classes ##

To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development".

### **Rationale for identifying associations between conceptual classes** ###

An association is a relationship between instances of objects that indicates a relevant connection that is worth remembering, or is derivable from the Common Associations List:


| Concept (A)   |  Association |  Concept (B)  |
| ------------- |:------------:| ------------: |
| Admin | defines | Operator |
| Admin | registers and manages | Customer |
| Admin | manages | CustomerManager |
| Admin | is a | User |
| Application | has | ApplicationDate |
| Application | has | ApplicationNumber |
| Application | has | Rank |
| Application | has | Result |
| ApplicationsFileBot | Exports | File |
| ApplicationPhase | has | Aplicattion |
| AnalysisPhase | is a | Phase |
| AnalysisPhase | has | Rank |
| Authentication | authenticated by | Email |
| Authentication | authenticated by | Password |
| Authentication | generates | CreatedOn |
| Authentication | generates | Token |
| Candidate | is a | User |
| Candidate | provides | CandidateAnswer |
| Candidate | has | Application |
| CandidateAnswer | has | AnswerBody |
| CandidateAnswer | for an | InterviewQuestion |
| CandidateAnswer | for a | SpecificationQuestion |
| Customer | has | JobOpening |
| Customer | has | JobOpening |
| Customer | is a | User |
| Customer | has | CustomerCode |
| Customer | has | CustomerAddress |
| CustomerManager | manages | Customer |
| CustomerManager | is a | User |
| CustomerManager | setup | RecruitmentProcess |
| CustomerManager | defines | Position |
| Date | is a | QuestionModel |
| DecimalNumber | is a | QuestionModel |
| IntegerNumber | is a | QuestionModel |
| Interview | has | InterviewDate |
| Interview | uses | InterviewModel |
| InterviewPhase | has | Interview |
| InterviewModel | has | InterviewDescription |
| InterviewModel | has | InterviewQuestion |
| InterviewQuestion | has | Grade |
| InterviewQuestion | has | Quotation |
| InterviewQuestion | uses | QuestionModel |
| JobOpening | has | JobReference |
| JobOpening | has | TitleOrFunction |
| JobOpening | has | ContractType |
| JobOpening | has | Mode |
| JobOpening | has | Address |
| JobOpening | has | Company |
| JobOpening | has | NumbersOfVacancies |
| JobOpening | has | JobDescription |
| JobOpening | has | RecruitmentProcess |
| JobOpening | has | RequirementSpecification |
| LanguageEngineer | is a | User |
| LanguageEngineer | deploys and configure | InterviewModel |
| LanguageEngineer | deploys and configure | RequirementModel |
| MultipleChoiseAnswer | is a | QuestionModel |
| NumericScale | is a | QuestionModel |
| Operator | is a | User |
| Operator | may register | Candidate |
| Operator | imports | File |
| Operator | registers | Application |
| Phase | has | State |
| Phase | has | InitialPhaseDate |
| Phase | has | FinalPhaseDate |
| QuestionModel | has | QuestionBody |
| QuestionModel | has | ExpectedAnswer |
| Rank | has | PositionNumber |
| RecruitmentProcess | has | InitialDate |
| RecruitmentProcess | has | FinalDate |
| RecruitmentProcess | has | Phase |
| RequirementModel | has | RequirementDescription |
| RequirementModel | has | SpecificationQuestion |
| RequirementSpecification | uses | RequirementModel |
| Result | has | Outcome |
| Result | can have | Justification |
| ResultPhase | has | Result |
| ScreeningPhase | has | RequirementSpecification |
| ShortTextAnswer | is a | QuestionModel |
| SingleChoiseAnswer | is a | QuestionModel |
| SpecificationQuestion | uses | QuestionModel |
| Time | is a | QuestionModel |
| TrueOrFalse | is a | QuestionModel |
| User | has | FullName |
| User | has | Email |
| User | has | Password |
| User | has | TaxPayerNumber |
| User | has | BirthDate |
| User | has | IsActive |
| User | authenticated by | Authentication |


## Domain Model


![Domain Model](svg/domain-model.svg)


<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>