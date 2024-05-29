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

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)(] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;