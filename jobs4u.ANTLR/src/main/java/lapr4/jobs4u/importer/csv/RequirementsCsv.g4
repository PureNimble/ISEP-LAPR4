grammar RequirementsCsv;

questions: question+ EOF;

body: '"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ ('"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' ((TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+)?)? '"';

questionBody: body;

answer: body;

question: questionBody ';' answer (NEWLINE)?;

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;