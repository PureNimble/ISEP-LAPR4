grammar Interview;

start: 'TITLE:' text 'NAME:' 'GRADE:' content+;

content:
	cotation cotationType 'QUESTION TYPE:' type 'ANSWER:' 'GRADE:';

cotation:
	'COTATION:' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100');

cotationType: ( '%' | 'POINTS' | 'VALUES');

choice: option option+;
option: '[' NUMBER ']' text;
text: (TEXT | NUMBER | LETTER | MEMBER)+;

type:
	'True/False' 'QUESTION:' text
	| 'Short text answer' 'QUESTION:' text
	| 'Choice, with single answer' 'QUESTION:' text choice
	| 'Choice, with multiple answers' 'QUESTION:' text choice
	| 'Integer Number' 'QUESTION:' text
	| 'Decimal Number' 'QUESTION:' text
	| 'Date' 'QUESTION:' text
	| 'Time' 'QUESTION:' text
	| 'Numeric Scale' 'QUESTION:' text;

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)(] | '\'' | '|' | '-';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;