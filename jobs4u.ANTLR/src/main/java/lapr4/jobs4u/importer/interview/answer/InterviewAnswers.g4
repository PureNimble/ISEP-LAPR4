grammar InterviewAnswers;

start:
	'TITLE:' text NEWLINE 'NAME:' text NEWLINE 'EMAIL:' email NEWLINE content+ EOF;

content:
	cotation cotationType NEWLINE 'QUESTION TYPE:' type NEWLINE?;

cotation:
	'COTATION:' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100');

cotationType: ( '%' | 'POINTS' | 'VALUES');

choice: option NEWLINE (option NEWLINE)+;
text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+ (('[' text? ']')+ text?)?;
option: '[' (TWO_DIGIT_NUMBER | LETTER) ']' text;
email: TEXT '@' TEXT;
question: 'QUESTION:' text;

type: (
		(
			true_false
			| short_text_answer
			| integer_number
			| decimal_number
			| date
			| time
			| numeric_scale
			| single_answer_choice
			| multiple_answer_choice
		)
);

true_false: TRUE_FALSE_QUESTION NEWLINE question NEWLINE true_false_answer;

short_text_answer: SHORT_TEXT_ANSWER_QUESTION NEWLINE question NEWLINE text_answer;

single_answer_choice: SINGLE_ANSWER_CHOICE_QUESTION NEWLINE question NEWLINE choice single_answer_choice_answer;

multiple_answer_choice: MULTIPLE_ANSWER_CHOICE_QUESTION NEWLINE question NEWLINE choice multiple_answer_choice_answer;

integer_number: INTEGER_NUMBER_QUESTION NEWLINE question NEWLINE integer_answer;

decimal_number: DECIMAL_NUMBER_QUESTION NEWLINE question NEWLINE decimal_answer;

date: DATE_QUESTION NEWLINE question NEWLINE date_answer;

time: TIME_QUESTION NEWLINE question NEWLINE time_answer;

numeric_scale: NUMERIC_SCALE_QUESTION NEWLINE question NEWLINE numeric_scale_answer;

true_false_answer: 'ANSWER:' ('True' | 'False' | 'TRUE' | 'FALSE' | 'true' | 'false');

text_answer: 'ANSWER:' text;

integer_answer: 'ANSWER:' TWO_DIGIT_NUMBER;

decimal_answer: 'ANSWER:' FRACTIONAL_NUMBER;

date_answer: 'ANSWER:' DATE;

time_answer: 'ANSWER:' TIME;

numeric_scale_answer: 'ANSWER:'  NUMERIC_SCALE;

single_answer_choice_answer: 'ANSWER:' (TWO_DIGIT_NUMBER | LETTER);

multiple_answer_choice_answer: 'ANSWER:' (TWO_DIGIT_NUMBER | LETTER) (TWO_DIGIT_NUMBER | LETTER)+;

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
MEMBER: [.,;:/#π+!?*)(] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
NUMERIC_SCALE: TWO_DIGIT_NUMBER ('-' TWO_DIGIT_NUMBER)?;
DATE: ('0' [1-9] | '1' [0-9] | '2' [0-9] | '3' [0-1]) '/' ('0' [1-9] | '1' [0-2]) '/' TWO_DIGIT_NUMBER+;
TIME: ('0' [0-9] | '1' [0-9] | '2' [0-3]) ':' ('0' [0-9] | '1' [0-9] | '2' [0-9] | '3' [0-9] | '4' [0-9] | '5' [0-9]) (':' ('0' [0-9] | '1' [0-9] | '2' [0-9] | '3' [0-9] | '4' [0-9] | '5' [0-9]))?;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\n\r]+ -> skip;