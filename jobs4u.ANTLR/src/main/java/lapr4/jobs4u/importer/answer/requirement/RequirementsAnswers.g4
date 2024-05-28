grammar RequirementsAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE content+ EOF;

text: (TEXT | LETTER | TWO_DIGIT_NUMBER | MEMBER)+ ('#'+ text?)?;
email: TEXT '@' TEXT;
answer: text;
question: text;

content: '#' text NEWLINE 'ANSWER:' text NEWLINE;

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;