grammar RequirementsJson;

questions: '[' question (',' question)+ ']' EOF;

body: '"' (TEXT | NUMBER | LETTER | MEMBER)+ '"';

questionBody: body;

answer: body;

question:
	'{' '"body"' ':' questionBody ',' '"possibleAnswers"' ':' '[' answer (
		',' answer
	)* ']' '}';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;