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

DECISION: 'APPROVED' | 'REJECTED';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;