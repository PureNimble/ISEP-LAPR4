<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# LPROG grammars, listeners, and visitors explained

This document aims to briefly explain the grammars created and used by us in the LAPR4 integrative project. We will also present our reasons and thoughts to explain the use of Listeners or Visitors in different functionalities.

## Table of Contents

- [Chronological Timeline of the Grammars](#chronological-timeline-of-the-grammars)
- [Question Import Grammars](#question-import-grammars)
    - [InterviewCSV.g4 Grammar](#interviewcsvg4-grammar)
    - [InterviewJSON.g4 Grammar](#interviewjsong4-grammar)
    - [InterviewXML.g4 Grammar](#interviewxmlg4-grammar)
    - [RequirementsCSV.g4 Grammar](#requirementscsvg4-grammar)
    - [RequirementsJSON.g4 Grammar](#requirementsjsong4-grammar)
    - [RequirementsXML.g4 Grammar](#requirementsxmlg4-grammar)
    - [Utilization of Listeners and Visitors](#utilization-of-listeners-and-visitors)
- [Template Export Grammars](#template-export-grammars)
    - [Interview.g4 Grammar](#interviewg4-grammar)
    - [Requirements.g4 Grammar](#requirementsg4-grammar)
    - [Utilization of Listeners and Visitors](#utilization-of-listeners-and-visitors-1)
- [Answer Validation Grammars](#answer-validation-grammars)
    - [InterviewAnswer.g4 Grammar](#interviewanswersg4-grammar)
    - [RequirementsAnswer.g4 Grammar](#requirementsanswersg4-grammar)
    - [Utilization of Listeners and Visitors](#utilization-of-listeners-and-visitors-2)
- [Interview/Requirements Evaluation Validation Grammars](#interviewrequirements-evaluation-validation-grammars)
    - [EvaluateInterviewAnswer.g4 Grammar](#evaluateinterviewanswersg4-grammar)
    - [EvaluateRequirementsAnswer.g4 Grammar](#evaluaterequirementsanswersg4-grammar)
    - [Utilization of Listeners and Visitors](#utilization-of-listeners-and-visitors-3)
- [Overview](#overview)


## Chronological Timeline of the Grammars

1. Question Import Grammars: 
The first grammars used by our group were these. These grammars were designed to validate .csv, .json, and .xml files. We defined 6 grammars in total, 3 for interviews and 3 for requirements.

2. Template Export Grammars: 
Next, we have these grammars. The purpose of these grammars is to validate the creation of templates according to the defined structures for both interviews and requirements. This functionality includes 2 grammars, 1 for interviews and 1 for requirements.

3. Answer Validation Grammars: 
Following that, we have these grammars. The objective of these grammars is to validate if the files maintain the structure and, for interviews, if the answers follow the requirements of each question type (e.g., for a true or false question, only true or false options should be allowed). Similar to the previous functionality, there is one grammar for each plugin type.

4. Interview/Requirements Evaluation Validation Grammars: 
Lastly, we have these grammars. These grammars solely aim to validate the structure of an evaluated file, including the results and possible justifications, in addition to the rest of the content. Once again, we used 2 grammars, 1 for interviews and 1 for requirements.

## Question Import Grammars

### Objective and Usage of these Grammars:

- These grammars were created with the purpose of verifying if .csv, .json, or .xml files follow the correct structure defined between the team and the client.

- In the context of the Integrative Project, these grammars were important for importing questions into the plugins and dynamically loading them whenever necessary.

- For the import part, we utilized the Listeners of each grammar. After some research, we concluded that Listeners are very useful for data import and export.

- Therefore, we traversed the entire Parse Tree and obtained the necessary information through the Listeners to import the questions into the system.

- These grammars were designed for the User Stories: [US-1008](../sprintb/us_1008/readme.md), [US-1009](../sprintb/us_1009/readme.md) (Requirements), and [US-1011](../sprintb/us_1011/readme.md) (Interviews).


### InterviewCSV.g4 Grammar

**Desired Structure:**

```csv
"Question Type";"Question Weight";"Weight Type";"Question Body";"Possible Answer";"Answer Weight";"Another Possible Answer if necessary";"Answer Weight"
```

**Example:**

```csv

"Choice, with single answer";"20";"%";"What is the primary use of HTML? [1] Styling web pages [2] Structuring web pages [3] Server-side computations";"2";"100"

"Choice, with multiple answers";"20";"%";"Which of the following are sorting algorithms? [1] Bubble Sort [2] Quick Sort [3] Binary Search [4] Depth-First Search";"1";"50";"2";"50";"1 2";"100"

"True/False";"10";"%";"Is JavaScript a compiled language?";"False";"100"

"Choice, with single answer";"20";"%";"Who created the C programming language? [1] Dennis Ritchie [2] James Gosling [3] Guido van Rossum";"1";"100"

"Choice, with multiple answers";"20";"%";"Which of the following are data structures? [1] Array [2] Queue [3] Graph [4] Gradient";"1";"20";"2";"35";"4";"45";"1 2 4";"100"

"True/False";"10";"%";"Is Python an object-oriented programming language?";"True";"100"
```


**Requirements:**

- The question type must be one of the following types:
    - True or False;
    - Short Answer;
    - Integer Answer;
    - Decimal Answer;
    - Date Answer;
    - Time Answer;
    - Numeric Scale Answer;
    - Single Choice;
    - Multiple Choice;
- The question weights must be between 0 and 100, and their type must be percentage, values, or points;
- The answer weights must be between 0 and 100, and their type is predefined as percentage.

**Grammar Parser Rules:**

```antlr
grammar InterviewCsv;

questions: question+ EOF;

body:
	'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (
		'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' (
			(TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+
		)?
	)? '"';

questionBody: body;

type:'"'
	(TRUE_FALSE_QUESTION
	| SHORT_TEXT_ANSWER_QUESTION
	| SINGLE_ANSWER_CHOICE_QUESTION
	| MULTIPLE_ANSWER_CHOICE_QUESTION
	| INTEGER_NUMBER_QUESTION
	| DECIMAL_NUMBER_QUESTION
	| DATE_QUESTION
	| TIME_QUESTION
	| NUMERIC_SCALE_QUESTION)'"';

questionCotation: cotation;

answer: body;

answerCotation: cotation;

question:
	type ';' questionCotation ';' cotationType ';' questionBody (
		';' answer ';' answerCotation
	)+ (NEWLINE)?;

cotation:
	'"' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '"';

cotationType: '"' ( '%' | 'POINTS' | 'VALUES') '"';
```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the file```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/interview/template/csv/InterviewCsv.g4)

### InterviewJSON.g4 Grammar

**Desired Structure:**

```json
[
    {
        "type": "Question Type",
        "cotation": "Question Score",
        "cotationType": "Score Type",
        "body": "Question Body",
        "possibleAnswers": [
            {
                "answer": "Answer",
                "cotation": "Answer Score"
            }
        ]
    },
    {
        "type": "Question Type",
        "cotation": "Question Score",
        "cotationType": "Score Type",
        "body": "Question Body",
        "possibleAnswers": [
            {
                "answer": "Answer",
                "cotation": "Answer Score"
            },
            {
                "answer": "Another Answer if necessary",
                "cotation": "Answer Score"
            }
        ]
    }
]
```

**Example:**

```json
[
    {
        "type": "Choice, with single answer",
        "cotation": "40",
        "cotationType": "%",
        "body": "Which language is primarily used for Android app development? [1] Swift [2] Kotlin [3] JavaScript",
        "possibleAnswers": [
            {
                "answer": "2",
                "cotation": "100"
            }
        ]
    },
    {
        "type": "Choice, with multiple answers",
        "cotation": "30",
        "cotationType": "%",
        "body": "Which of the following are Python libraries for data analysis? [1] Pandas [2] NumPy [3] Matplotlib [4] Express",
        "possibleAnswers": [
            {
                "answer": "1",
                "cotation": "20"
            },
            {
                "answer": "2",
                "cotation": "30"
            }
        ]
    }
]
```	

**Requirements:**

- The question type must be one of the following types:
    - True or False;
    - Short Answer;
    - Integer Answer;
    - Decimal Answer;
    - Date Answer;
    - Time Answer;
    - Numeric Scale Answer;
    - Single Choice;
    - Multiple Choice;
- The question weights must be between 0 and 100, and their type must be percentage, values, or points;
- The answer weights must be between 0 and 100, and their type is predefined as percentage.

**Grammar Parser Rules:**

```antlr
grammar InterviewJson;

questions: '[' question (',' question)+ ']' EOF;

body: '"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ ('"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' ((TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+)?)? '"';

questionBody: body;

type:'"'
	(TRUE_FALSE_QUESTION
	| SHORT_TEXT_ANSWER_QUESTION
	| SINGLE_ANSWER_CHOICE_QUESTION
	| MULTIPLE_ANSWER_CHOICE_QUESTION
	| INTEGER_NUMBER_QUESTION
	| DECIMAL_NUMBER_QUESTION
	| DATE_QUESTION
	| TIME_QUESTION
	| NUMERIC_SCALE_QUESTION)'"';
	
questionCotation: cotation;

answer: body;

answerCotation: cotation;

question:
	'{' '"type"' ':' type ',' '"cotation"' ':' questionCotation ',' '"cotationType"' ':' cotationType ','
		'"body"' ':' questionBody ',' '"possibleAnswers"' ':' '[' '{' '"answer"' ':' answer ','
		'"cotation"' ':' answerCotation '}' (
		',' '{' '"answer"' ':' answer ',' '"cotation"' ':' answerCotation '}'
	)* ']' '}';

cotation:
	'"' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '"';

cotationType: '"' ( '%' | 'POINTS' | 'VALUES') '"';
```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/interview/template/json/InterviewJson.g4)

### InterviewXML.g4 Grammar

**Desired Structure:**

```xml
<Questions>
    <Question>
        <Cotation>Question Score</Cotation>
        <CotationType>Score Type</CotationType>
        <Type>Question Type</Type>
        <Body>Question Body</Body>
        <PossibleAnswersList>
            <PossibleAnswers>
                <Answer>A Possible Answer</Answer>
                <Cotation>Answer Score</Cotation>
            </PossibleAnswers>
        </PossibleAnswersList>
    </Question>
    <Question>
        <Cotation>Question Score</Cotation>
        <CotationType>Score Type</CotationType>
        <Type>Question Type</Type>
        <Body>Question Body</Body>
        <PossibleAnswersList>
            <PossibleAnswers>
                <Answer>A Possible Answer</Answer>
                <Cotation>Answer Score</Cotation>
            </PossibleAnswers>
            <PossibleAnswers>
                <Answer>Another Possible Answer</Answer>
                <Cotation>Answer Score</Cotation>
            </PossibleAnswers>
        </PossibleAnswersList>
    </Question>
</Questions>
```

**Example:**

```xml
<Questions>
    <Question>
        <Cotation>40</Cotation>
        <CotationType>%</CotationType>
        <Type>Choice, with single answer</Type>
        <Body>What is the time complexity of binary search? [1] O(1) [2] O(log n) [3] O(n) [4] O(n log n)</Body>
        <PossibleAnswersList>
            <PossibleAnswers>
                <Answer>4</Answer>
                <Cotation>100</Cotation>
            </PossibleAnswers>
        </PossibleAnswersList>
    </Question>
    <Question>
        <Cotation>30</Cotation>
        <CotationType>%</CotationType>
        <Type>Choice, with multiple answers</Type>
        <Body>Which of the following are not types of inheritance in C++? [1] Multiple [2] Multilevel [3] Hierarchical [4] Hybrid [5] Parallel</Body>
        <PossibleAnswersList>
            <PossibleAnswers>
                <Answer>5</Answer>
                <Cotation>100</Cotation>
            </PossibleAnswers>
        </PossibleAnswersList>
    </Question>
</Questions>
```

**Requirements:**

- The question type must be one of the following types:
    - True or False;
    - Short Answer;
    - Integer Answer;
    - Decimal Answer;
    - Date Answer;
    - Time Answer;
    - Numeric Scale Answer;
    - Single Choice;
    - Multiple Choice;
- The question weights must be between 0 and 100, and their type must be percentage, values, or points;
- The answer weights must be between 0 and 100, and their type is predefined as percentage.

**Grammar Parser Rules:**

```antlr
grammar InterviewXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+;

question:
	'<Question>' questionCotation cotationType type body possibleAnswersList '</Question>';

cotation:
	'<Cotation>' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '</Cotation>';

cotationType:
	'<CotationType>' ('%' | 'POINTS' | 'VALUES') '</CotationType>';

type:
	'<Type>' (
		TRUE_FALSE_QUESTION
		| SHORT_TEXT_ANSWER_QUESTION
		| SINGLE_ANSWER_CHOICE_QUESTION
		| MULTIPLE_ANSWER_CHOICE_QUESTION
		| INTEGER_NUMBER_QUESTION
		| DECIMAL_NUMBER_QUESTION
		| DATE_QUESTION
		| TIME_QUESTION
		| NUMERIC_SCALE_QUESTION
	) '</Type>';

body:
	'<Body>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</Body>';

questionCotation: cotation;

answerCotation: cotation;

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers:
	'<PossibleAnswers>' answer answerCotation '</PossibleAnswers>';

answer: '<Answer>' text '</Answer>';
```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/interview/template/xml/InterviewXml.g4)

### RequirementsCSV.g4 Grammar

**Desired Structure:**

```csv
"Question Body";"Possible Answer/Another Possible Answer if necessary";"Justification if minimum requirements are not met for this question"
```

**Example:**

```csv
"How long have you been involved in web development? (1 | 2 | 3 | 4 | 5+ years)";"1/2/3/4/5+ years";"Experience in web development is crucial for understanding the complexities of modern web applications."

"Can you list the programming languages you've utilized in your projects? (Ruby | PHP | TypeScript | Go)";"Ruby/PHP/TypeScript/Go";"Knowledge of multiple programming languages shows versatility and adaptability."

"Have you ever developed a mobile app? (Yes | No)";"Yes/No";"Experience in mobile app development is important for creating responsive, user-friendly applications."

"Could you tell us which databases you've worked with in your projects? (Oracle | Firebase | MariaDB | CouchDB)";"Oracle/Firebase/MariaDB/CouchDB";"Understanding different databases is key for efficient data management."

"Which version control systems are you familiar with? (Perforce | Bazaar | CVS)";"Perforce/Bazaar/CVS";"Version control systems are essential for collaborative and error-free coding."

"Have you ever administered a database? (Yes | No)";"Yes/No";"Database administration skills are important for maintaining data integrity and security."

"Could you tell us which cloud platforms you've used in your projects? (IBM Cloud | DigitalOcean | Heroku)";"IBM Cloud/DigitalOcean/Heroku";"Experience with cloud platforms is necessary for modern, scalable applications."

```

**Requirements:**

_N/A_

**Grammar Parser Rules:**

```antlr
grammar RequirementsCsv;

questions: question+ EOF;

body:
	'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (
		'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' (
			(TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+
		)?
	)? '"';

questionBody: body;

answer: body;

minimumRequirement: body;

question:
	questionBody ';' answer ';' minimumRequirement (NEWLINE)?;
```

**Grammar Lexer Rules:**

```antlr
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/requirement/template/csv/RequirementsCsv.g4)

### RequirementsJSON.g4 Grammar

**Desired Structure:**

```json
[
    {
        "body": "Question Body",
        "possibleAnswers": [
            "A possible answer",
            "Another possible answer if necessary"
        ],
        "minimumRequirement": "Justification Body"
    },
    {
        "body": "Question Body",
        "possibleAnswers": [
            "A possible answer",
            "Another possible answer if necessary"
        ],
        "minimumRequirement": "Justification Body"
    }
]
```

**Example:**

```json
[
    {
        "body": "Which of the following languages are you proficient in? (Python | JavaScript | C#)",
        "possibleAnswers": [
            "Python",
            "JavaScript",
            "C++"
        ],
        "minimumRequirement": "A minimum proficiency in Python is required for the job position."
    },
    {
        "body": "Which of the following databases have you used in your projects? (MySQL | PostgreSQL | MongoDB)",
        "possibleAnswers": [
            "MySQL",
            "PostgreSQL",
            "MongoDB"
        ],
        "minimumRequirement": "Experience with MySQL is a minimum requirement for the job position."
    }
]
```

**Requirements:**

_N/A_

**Grammar Parser Rules:**

```antlr
grammar RequirementsJson;

questions: '[' question (',' question)+ ']' EOF;

body:
	'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (
		'"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' (
			(TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+
		)?
	)? '"';

questionBody: body;

answer: body;

minimumRequirement: body;

question:
	'{' '"body"' ':' questionBody ',' '"possibleAnswers"' ':' '[' answer (
		',' answer
	)* ']' ',' '"minimumRequirement"' ':' minimumRequirement '}';

```

**Grammar Lexer Rules:**

```antlr
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)(] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/requirement/template/json/RequirementsJson.g4)

### RequirementsXML.g4 Grammar

**Desired Structure:**

```xml
<Questions>
    <Question>
        <Body>Question Body</Body>
        <PossibleAnswersList>
            <PossibleAnswers>A possible answer</PossibleAnswers>
            <PossibleAnswers>Another possible answer if necessary</PossibleAnswers>
        </PossibleAnswersList>
        <MinimumRequirement>Justification Body</MinimumRequirement>
    </Question>
    <Question>
        <Body>Question Body</Body>
        <PossibleAnswersList>
            <PossibleAnswers>A possible answer</PossibleAnswers>
            <PossibleAnswers>Another possible answer if necessary</PossibleAnswers>
        </PossibleAnswersList>
        <MinimumRequirement>Justification Body</MinimumRequirement>
    </Question>
</Questions>
```

**Example:**

```xml
<Questions>
    <Question>
        <Body>What is your proficiency level in Unix/Linux? (Beginner | Intermediate | Advanced)</Body>
        <PossibleAnswersList>
            <PossibleAnswers>Beginner</PossibleAnswers>
            <PossibleAnswers>Intermediate</PossibleAnswers>
            <PossibleAnswers>Advanced</PossibleAnswers>
        </PossibleAnswersList>
        <MinimumRequirement>A minimum proficiency level of Intermediate in Unix/Linux is required for the job position.</MinimumRequirement>
    </Question>
    <Question>
        <Body>Which of the following HTTP methods are you familiar with? (GET | POST | PUT | DELETE)</Body>
        <PossibleAnswersList>
            <PossibleAnswers>GET</PossibleAnswers>
            <PossibleAnswers>POST</PossibleAnswers>
            <PossibleAnswers>PUT</PossibleAnswers>
            <PossibleAnswers>DELETE</PossibleAnswers>
        </PossibleAnswersList>
        <MinimumRequirement>Familiarity with at least two HTTP methods is required for the job position.</MinimumRequirement>
    </Question>
</Questions>
```

**Requirements:**

_N/A_

**Grammar Parser Rules:**

```antlr
grammar RequirementsXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+;

question: '<Question>' body possibleAnswersList minimumRequirement '</Question>';

body:
	'<Body>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</Body>';

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers:
	'<PossibleAnswers>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</PossibleAnswers>';

minimumRequirement:
	'<MinimumRequirement>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</MinimumRequirement>';
```

**Grammar Lexer Rules:**

```antlr
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/requirement/template/xml/RequirementsXml.g4)

### Utilization of Listeners and Visitors

| Functionality | File | Type | Description |
| --- | --- | --- | --- |
| Question Import | [```InterviewCsvListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/interview/InterviewCsvListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |
| Question Import | [```InterviewJsonListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/interview/InterviewJsonListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |
| Question Import | [```InterviewXmlListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/interview/InterviewXmlListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |
| Question Import | [```RequirementsCsvListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/requirement/RequirementsCsvListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |
| Question Import | [```RequirementsJsonListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/requirement/RequirementsJsonListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |
| Question Import | [```RequirementsXmlListener```](../../jobs4u.integrations.plugins/src/main/java/lapr4/jobs4u/integrations/plugins/question/requirement/RequirementsXmlListener.java) | Listener | This listener is responsible for traversing the Parse Tree and obtaining the necessary information to import questions into the system. |

## Template Export Grammars

### Objective and Usage of these Grammars:

- These grammars were created with the purpose of validating whether interview or requirement files follow the defined structure.

- In the context of the Integrative Project, these grammars were used to validate that the templates generated by the program were being generated correctly and following the client's requirements.

- For these functionalities, neither Listeners nor Visitors were used, and we simply traversed the Parse Trees to check for syntax errors.

- These grammars were designed for the User Stories: [US-1012](../sprintb/us_1012/readme.md) (Interviews) and [US-2003](../sprintb/us_2003/readme.md) (Requirements).

### Interview.g4 Grammar

**Desired Structure:**

```txt
TITLE: Software Engineer Interview
NAME:
EMAIL:

COTATION: 30%
QUESTION TYPE: Choice, with single answer
QUESTION: What is the capital of France?
[1] London
[2] Paris
[3] Berlin
ANSWER:

COTATION: 30%
QUESTION TYPE: True/False
QUESTION: Python is a statically typed language.
ANSWER:

COTATION: 40%
QUESTION TYPE: Short text answer
QUESTION: What is the name of the process to find bugs in software?
ANSWER:

COTATION: 30%
QUESTION TYPE: True/False
QUESTION: Python is a statically typed language.
ANSWER:
```

**Requirements:**

- In addition to the requirements mentioned in the import grammar section, this grammar requires the presence of fields for the template title, candidate name, candidate email, and candidate's answers for each question.

- The question body may contain options depending on the type, and if it does, it should have the option identifier and the option text (e.g., [1] Option Text).

**Grammar Parser Rules:**

```antlr
grammar Interview;

start: 'TITLE:' text NEWLINE 'NAME:' NEWLINE 'EMAIL:' NEWLINE content+ EOF;

content:
	cotation cotationType NEWLINE 'QUESTION TYPE:' type 'ANSWER:' NEWLINE;

cotation:
	'COTATION:' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100');

cotationType: ( '%' | 'POINTS' | 'VALUES');

choice: option NEWLINE (option NEWLINE)+;
option: '[' (TWO_DIGIT_NUMBER | LETTER) ']' text;
text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (('[' text? ']')+ text?)?;

type: (
		(
			TRUE_FALSE_QUESTION
			| SHORT_TEXT_ANSWER_QUESTION
			| INTEGER_NUMBER_QUESTION
			| DECIMAL_NUMBER_QUESTION
			| DATE_QUESTION
			| TIME_QUESTION
			| NUMERIC_SCALE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE
	)
	| (
		(
			SINGLE_ANSWER_CHOICE_QUESTION
			| MULTIPLE_ANSWER_CHOICE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE choice
	) ;
```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)(] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/exporter/interview/template/Interview.g4)

### Requirements.g4 Grammar

**Desired Structure:**

```txt
TITLE: Data Scientist
NAME:
EMAIL:

# Enter the number of years of experience (integer)
ANSWER:

# Select one Degree (none | bachelor | master | phD)
ANSWER:

# Select one or more Programming Languages (python| java | javascript | scala | swift | ruby | r | sql)
ANSWER:
```

**Requirements:**

- In addition to the requirements mentioned in the import grammar section, this grammar requires the presence of fields for the template title, candidate name, candidate email, and candidate's answers for each requirement.

- The questions must start with a #.

- The options should be displayed within parentheses and separated by a separator "|".

**Grammar Parser Rules:**

```antlr
grammar Requirements;

start: 'TITLE:' text NEWLINE 'NAME:' NEWLINE 'EMAIL:' NEWLINE content+ EOF;

text: (TEXT | LETTER | TWO_DIGIT_NUMBER | MEMBER)+ ('#'+ text?)?;
content: '#' text NEWLINE 'ANSWER:' NEWLINE?;
```

**Grammar Lexer Rules:**

```antlr
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\r\n]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/exporter/requirement/template/Requirements.g4)

### Utilization of Listeners and Visitors

_N/A_

## Answer Validation Grammars

### Objective and Usage of these Grammars:

- These grammars were created with the purpose of validating the answers contained in the files filled out by the candidates.

- In the context of the Integrative Project, these grammars were used to validate the expected input type and the received input type, as well as to verify if the file structure was correct before loading it into the system.

- For these functionalities, Visitors were used to verify if the email in the file being loaded into the system and associated with a candidate matches the candidate's email.

- Visitors were also used to evaluate the candidates' answers by traversing the Parse Tree and collecting the answers, which will be used to calculate or determine a final result.

- These grammars were designed for the User Stories: [US-1017](../sprintc/us_1017/readme.md) (Interviews), [US-2004](../sprintc/us_2004/readme.md) (Requirements), [US-1018](../sprintc/us_1018/readme.md) (Interviews), and [US-1015](../sprintc/us_1015/readme.md) (Requirements).

### InterviewAnswers.g4 Grammar

**Desired Structure:**

```txt
TITLE: Software Engineer Interview
NAME: Paulo
EMAIL: micro@email.com

COTATION: 20%
QUESTION TYPE: Choice, with single answer
QUESTION: What is the primary use of HTML?
[1] Styling web pages
[2] Structuring web pages
[3] Server-side computations
ANSWER: 2

COTATION: 20%
QUESTION TYPE: Choice, with multiple answers
QUESTION: Which of the following are sorting algorithms?
[1] Bubble Sort
[2] Quick Sort
[3] Binary Search
[4] Depth-First Search
ANSWER: 1 2

COTATION: 10%
QUESTION TYPE: True/False
QUESTION: Is JavaScript a compiled language?
ANSWER: False
```	

**Requirements:**

- The same requirements inherited from the previous grammars;

- The question types accept the following response inputs:
  - True or False -> "True" or "False";
  - Short Answer -> Any type of text;
  - Integer Answer -> Integer numbers;
  - Decimal Answer -> Decimal numbers;
  - Date Answer -> Dates in the format dd/mm/yyyy;
  - Time Answer -> Times in the format hh:mm(:ss)*;
  - Numeric Scale Answer -> Numbers in the format n or n-n;
  - Single Choice -> A character or a number;
  - Multiple Choice -> A sequence of characters or numbers, with each number or character separated by a space;

- The email must have the format text@text.

**Grammar Parser Rules:**

```antlr
grammar InterviewAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE content+ EOF;

content:
	cotation cotationType NEWLINE 'QUESTION TYPE:' type NEWLINE?;

cotation:
	'COTATION:' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100');

cotationType: ( '%' | 'POINTS' | 'VALUES');

choice: option NEWLINE (option NEWLINE)+;
text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (('[' text? ']')+ text?)?;
option: '[' (TWO_DIGIT_NUMBER | LETTER) ']' text;
email: TEXT '@' TEXT;
question: 'QUESTION:' text;

type: (
		(
			true_false
			| short_text_answer
			| integer_number
			| decimal_number
			| date
			| time
			| numeric_scale
			| single_answer_choice
			| multiple_answer_choice
		)
);

true_false: TRUE_FALSE_QUESTION NEWLINE question NEWLINE true_false_answer;

short_text_answer: SHORT_TEXT_ANSWER_QUESTION NEWLINE question NEWLINE text_answer;

single_answer_choice: SINGLE_ANSWER_CHOICE_QUESTION NEWLINE question NEWLINE choice single_answer_choice_answer;

multiple_answer_choice: MULTIPLE_ANSWER_CHOICE_QUESTION NEWLINE question NEWLINE choice multiple_answer_choice_answer;

integer_number: INTEGER_NUMBER_QUESTION NEWLINE question NEWLINE integer_answer;

decimal_number: DECIMAL_NUMBER_QUESTION NEWLINE question NEWLINE decimal_answer;

date: DATE_QUESTION NEWLINE question NEWLINE date_answer;

time: TIME_QUESTION NEWLINE question NEWLINE time_answer;

numeric_scale: NUMERIC_SCALE_QUESTION NEWLINE question NEWLINE numeric_scale_answer;

true_false_answer: 'ANSWER:' ('True' | 'False' | 'TRUE' | 'FALSE' | 'true' | 'false');

text_answer: 'ANSWER:' text;

integer_answer: 'ANSWER:' TWO_DIGIT_NUMBER;

decimal_answer: 'ANSWER:' FRACTIONAL_NUMBER;

date_answer: 'ANSWER:' DATE;

time_answer: 'ANSWER:' TIME;

numeric_scale_answer: 'ANSWER:'  NUMERIC_SCALE;

single_answer_choice_answer: 'ANSWER:' (TWO_DIGIT_NUMBER | LETTER);

multiple_answer_choice_answer: 'ANSWER:' (TWO_DIGIT_NUMBER | LETTER) (TWO_DIGIT_NUMBER | LETTER)+;

```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#π+!?*)(] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
NUMERIC_SCALE: TWO_DIGIT_NUMBER ('-' TWO_DIGIT_NUMBER)?;
DATE: ('0' [1-9] | '1' [0-9] | '2' [0-9] | '3' [0-1]) '/' ('0' [1-9] | '1' [0-2]) '/' TWO_DIGIT_NUMBER+;
TIME: ('0' [0-9] | '1' [0-9] | '2' [0-3]) ':' ('0' [0-9] | '1' [0-9] | '2' [0-9] | '3' [0-9] | '4' [0-9] | '5' [0-9]) (':' ('0' [0-9] | '1' [0-9] | '2' [0-9] | '3' [0-9] | '4' [0-9] | '5' [0-9]))?;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/interview/answer/InterviewAnswers.g4)

### RequirementsAnswers.g4 Grammar

**Desired Structure:**

```txt
TITLE: Software Engineer Requirements
NAME: Paulo
EMAIL: micro@email.com

# How long have you been involved in web development? (1 | 2 | 3 | 4 | 5+ years)
ANSWER: 5+ years

# Can you list the programming languages you've utilized in your projects? (Ruby | PHP | TypeScript | Go)
ANSWER: RubyPlus

# Have you ever developed a mobile app? (Yes | No)
ANSWER: Yes
```

**Requirements:**

- The same requirements inherited from the previous grammars;
- The email must have the format text@text.

**Grammar Parser Rules:**

```antlr
grammar RequirementsAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE content+ EOF;

text: (TEXT | LETTER | TWO_DIGIT_NUMBER | MEMBER)+ ('#'+ text?)?;
email: TEXT '@' TEXT;
answer: text;
question: text;

content: '#' question NEWLINE 'ANSWER:' answer NEWLINE?;
```

**Grammar Lexer Rules:**

```antlr
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/importer/requirement/answer/RequirementsAnswers.g4)

### Utilization of Listeners and Visitors

| Functionality | File | Type | Description |
| --- | --- | --- | --- |
| Email Validation | [```InterviewAnswersVisitor```](../../jobs4u.core/src/main/java/lapr4/jobs4u/interviewmanagement/application/InterviewAnswersVisitor.java) | Visitor | This visitor is responsible for traversing the Parse Tree and validating if the email in the file being loaded into the system matches the candidate's email. |
| Answer Evaluation | [```EvaluateInterviewAnswersVisitor```](../../jobs4u.core/src/main/java/lapr4/jobs4u/interviewmanagement/application/EvaluateInterviewAnswersVisitor.java) | Visitor | This visitor is responsible for traversing the Parse Tree and collecting the answers, which will be used to calculate a final grade. |
| Email Validation | [```RequirementsAnswersVisitor```](../../jobs4u.core/src/main/java/lapr4/jobs4u/requirementmanagement/application/RequirementsAnswersVisitor.java) | Visitor | This visitor is responsible for traversing the Parse Tree and validating if the email in the file being loaded into the system matches the candidate's email. |
| Answer Evaluation | [```EvaluateRequirementsAnswersVisitor```](../../jobs4u.core/src/main/java/lapr4/jobs4u/requirementmanagement/application/EvaluateRequirementsAnswersVisitor.java) | Visitor | This visitor is responsible for traversing the Parse Tree and collecting the answers, which will be used to determine a final result. |


## Interview/Requirements Evaluation Validation Grammars

### Objective and Usage of these Grammars:

- These grammars were created with the purpose of validating the files evaluated with grades and final results.

- In the context of the Integrative Project, these grammars were applied to ensure that the files generated after the automatic evaluation and analysis performed by the system are being created without syntax errors.

- For these functionalities, neither Listeners nor Visitors were used, and we simply traversed the Parse Trees to check for syntax errors.

- These grammars were designed for the User Stories: [US-1018](../sprintc/us_1018/readme.md) (Interviews) and [US-1015](../sprintc/us_1015/readme.md) (Requirements).

### EvaluateInterviewAnswers.g4 Grammar

**Desired Structure:**

```txt
TITLE: Software Engineer Interview
NAME: Paulo
EMAIL: micro@email.com
FINAL GRADE: 100%

COTATION: 20%
QUESTION TYPE: Choice, with single answer
QUESTION: What is the primary use of HTML?
[1] Styling web pages
[2] Structuring web pages
[3] Server-side computations
ANSWER: 2
GRADE: 100%

COTATION: 20%
QUESTION TYPE: Choice, with multiple answers
QUESTION: Which of the following are sorting algorithms?
[1] Bubble Sort
[2] Quick Sort
[3] Binary Search
[4] Depth-First Search
ANSWER: 1 2
GRADE: 100%

COTATION: 10%
QUESTION TYPE: True/False
QUESTION: Is JavaScript a compiled language?
ANSWER: False
GRADE: 100%
```

**Requirements:**

- The same requirements inherited from the previous grammars;

- The grades must be between 0 and 100 and their type must be percentage, values, or points;


**Grammar Parser Rules:**

```antlr
grammar EvaluateInterviewAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE 'FINAL GRADE:' cotation NEWLINE
		content+ EOF;

content:
	'COTATION:' cotation NEWLINE 'QUESTION TYPE:' type 'ANSWER:' answer? NEWLINE 'GRADE:' cotation NEWLINE?;

cotationType: ( '%' | 'POINTS' | 'VALUES');

cotation:
	(TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') cotationType;

choice: option NEWLINE (option NEWLINE)+;
text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (
		('[' text? ']')+ text?
	)?;
answer: text;
option: '[' (TWO_DIGIT_NUMBER | LETTER) ']' text;
email: TEXT '@' TEXT;

type: (
		(
			TRUE_FALSE_QUESTION
			| SHORT_TEXT_ANSWER_QUESTION
			| INTEGER_NUMBER_QUESTION
			| DECIMAL_NUMBER_QUESTION
			| DATE_QUESTION
			| TIME_QUESTION
			| NUMERIC_SCALE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE
	)
	| (
		(
			SINGLE_ANSWER_CHOICE_QUESTION
			| MULTIPLE_ANSWER_CHOICE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE choice
	);
```

**Grammar Lexer Rules:**

```antlr
TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)(] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/exporter/interview/answer/EvaluateInterviewAnswers.g4)

### EvaluateRequirementsAnswers.g4 Grammar

**Desired Structure:**

```txt
TITLE: Software Engineer Requirements
NAME: Paulo
EMAIL: micro@email.com
RESULT: REJECTED

# How long have you been involved in web development? (1 | 2 | 3 | 4 | 5+ years)
ANSWER: 5+ years
REQUIREMENT RESULT: MET

# Can you list the programming languages you've utilized in your projects? (Ruby | PHP | TypeScript | Go)
ANSWER: RubyPlus
REQUIREMENT RESULT: NOT MET
JUSTIFICATION: Knowledge of multiple programming languages shows versatility and adaptability.

# Have you ever developed a mobile app? (Yes | No)
ANSWER: Yes
REQUIREMENT RESULT: MET
```

**Requirements:**

- The same requirements inherited from the previous grammars;

- The final result must be: "APPROVED" or "REJECTED";

- The result of each requirement must be: "MET" or "NOT MET";

- In case the result of each requirement is "NOT MET", a justification must be added.

**Grammar Parser Rules:**

```antlr
grammar EvaluateRequirementsAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE 'RESULT:' DECISION NEWLINE content+ EOF;

text: (TEXT | LETTER | TWO_DIGIT_NUMBER | MEMBER)+ ('#'+ text?)?;
email: TEXT '@' TEXT;
answer: text;
question: text;
result: 'REQUIREMENT RESULT:' ('MET' | 'NOT MET' NEWLINE justification);
justification: text;

content: '#' question NEWLINE 'ANSWER:' answer NEWLINE result NEWLINE?;
```

**Grammar Lexer Rules:**

```antlr
DECISION: 'APPROVED' | 'REJECTED';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;
```

**The full file:** [```Go to the File```](../../jobs4u.ANTLR/src/main/java/lapr4/jobs4u/exporter/requirement/answer/EvaluateRequirementsAnswers.g4)

### Utilization of Listeners and Visitors

_N/A_

## Overview

In summary, several grammars were defined for the Integrative Project of LAPR4 and for the LPROG subject. These grammars were used to analyze the structure of the files and validate questions and answers. As a group, we decided to use Listeners for import functionalities and Visitors for answer evaluation and email validation functionalities in the files. We believe that the use of these tools was essential for the success of the project as they allowed us to develop different functionalities more efficiently and in an organized manner.

### Positive and Not so Positive Aspects

- Positive Aspects:
    1. The wide variety of grammars
    2. Usage of both Listeners and Visitors

- Not so Positive Aspects:
    1. The organization of rules across different grammars could be improved for better clarity and maintainability.

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>