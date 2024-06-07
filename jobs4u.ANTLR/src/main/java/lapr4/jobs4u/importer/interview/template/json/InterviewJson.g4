grammar InterviewJson;

questions: '[' question (',' question)+ ']' EOF;

body: '"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ ('"' (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ '"' ((TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+)?)? '"';

questionBody: body;

type:'"'
	(TRUE_FALSE_QUESTION
	| SHORT_TEXT_ANSWER_QUESTION
	| SINGLE_ANSWER_CHOICE_QUESTION
	| MULTIPLE_ANSWER_CHOICE_QUESTION
	| INTEGER_NUMBER_QUESTION
	| DECIMAL_NUMBER_QUESTION
	| DATE_QUESTION
	| TIME_QUESTION
	| NUMERIC_SCALE_QUESTION)'"';
	
questionCotation: cotation;

answer: body;

answerCotation: cotation;

question:
	'{' '"type"' ':' type ',' '"cotation"' ':' questionCotation ',' '"cotationType"' ':' cotationType ','
		'"body"' ':' questionBody ',' '"possibleAnswers"' ':' '[' '{' '"answer"' ':' answer ','
		'"cotation"' ':' answerCotation '}' (
		',' '{' '"answer"' ':' answer ',' '"cotation"' ':' answerCotation '}'
	)* ']' '}';

cotation:
	'"' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '"';

cotationType: '"' ( '%' | 'POINTS' | 'VALUES') '"';

TRUE_FALSE_QUESTION: 'True/False';
SHORT_TEXT_ANSWER_QUESTION: 'Short text answer';
SINGLE_ANSWER_CHOICE_QUESTION: 'Choice, with single answer';
MULTIPLE_ANSWER_CHOICE_QUESTION:
	'Choice, with multiple answers';
INTEGER_NUMBER_QUESTION: 'Integer Number';
DECIMAL_NUMBER_QUESTION: 'Decimal Number';
DATE_QUESTION: 'Date';
TIME_QUESTION: 'Time';
NUMERIC_SCALE_QUESTION: 'Numeric Scale';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;