grammar RequirementsCsv;

questions: question+ EOF;

body: '"' (TEXT | NUMBER | LETTER | MEMBER)+ '"';

questionBody: body;

answer: body;

question: questionBody ';' answer;

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;