grammar InterviewAnswers;

start: 'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email content+ EOF;

content:
	cotation cotationType NEWLINE 'QUESTION TYPE:' type 'ANSWER:' text NEWLINE;

cotation:
	'COTATION:' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100');

cotationType: ( '%' | 'POINTS' | 'VALUES');

choice: option NEWLINE (option NEWLINE)+;
option: '[' NUMBER ']' text ('[' text ']' text?)?;
text: (TEXT | NUMBER | LETTER | MEMBER)+;
email: TEXT '@' TEXT '.' TEXT ('.' TEXT)?;

type: (
		(
			TRUE_FALSE_QUESTION
			| SHORT_TEXT_ANSWER_QUESTION
			| INTEGER_NUMBER_QUESTION
			| DECIMAL_NUMBER_QUESTION
			| DATE_QUESTION
			| TIME_QUESTION
			| NUMERIC_SCALE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE
	)
	| (
		(
			SINGLE_ANSWER_CHOICE_QUESTION
			| MULTIPLE_ANSWER_CHOICE_QUESTION
		) NEWLINE 'QUESTION:' text NEWLINE choice
	) ;

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

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!@?*)(] | '\'' | '|' | '-';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;