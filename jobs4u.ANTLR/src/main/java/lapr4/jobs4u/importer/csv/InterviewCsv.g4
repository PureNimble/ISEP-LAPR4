grammar InterviewCsv;

questions: question+ EOF;

body: '"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ ('"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' ((TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+)?)? '"';

questionBody: body;

type: body;

questionCotation: cotation;

answer: body;

answerCotation: cotation;

question:
	type ';' questionCotation ';' cotationType ';' questionBody (';' answer ';' answerCotation)+ (NEWLINE)?;

cotation:
	'"' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '"';

cotationType: '"' ( '%' | 'POINTS' | 'VALUES') '"';

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;