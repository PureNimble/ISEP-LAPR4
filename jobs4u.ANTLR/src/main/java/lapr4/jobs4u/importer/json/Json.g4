grammar Json;

questions: '[' question (',' question)+ ']' EOF;

body: '"' (TEXT | NUMBER | LETTER)+ '"';

questionBody: body;

type: body;

answer: body;

question:
	'{' '"type"' ':' type ',' (
		'"cotation"' ':' cotation ',' '"cotationType"' ':' cotationType ','
	)? '"body"' ':' questionBody ',' '"possibleAnswers"' ':' '[' answer (
		',' answer
	)* ']' '}';

cotation:
	'"' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '"';

cotationType: '"' ( '%' | 'POINTS' | 'VALUES') '"';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)([\]] | '\'';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;