grammar InterviewCsv;

questions: question+ EOF;

body: '"' (TEXT | NUMBER | LETTER | MEMBER)+ ('"' (TEXT | NUMBER | LETTER | MEMBER)+ '"' ((TEXT | NUMBER | LETTER | MEMBER)+)?)? '"';

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

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;