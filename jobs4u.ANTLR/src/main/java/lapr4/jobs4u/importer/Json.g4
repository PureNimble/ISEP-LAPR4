grammar Json;

questions: '[' question (',' question)* ']' EOF;

body: '"' (TEXT | NUMBER | LETTER)+ '"';

question:
	'{' '"type"' ':' body ',' (
		'"cotation"' ':' '"' (
			TWO_DIGIT_NUMBER
			| FRACTIONAL_NUMBER
			| '100'
		) ('%' | 'POINTS' | 'VALUES') '"' ','
	)? '"body"' ':' body ',' '"possibleAnswers"' ':' '[' body (
		',' body
	)* ']' '}';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)([\]] | '\'';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;