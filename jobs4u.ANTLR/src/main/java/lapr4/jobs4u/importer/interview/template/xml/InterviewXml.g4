grammar InterviewXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+;

question:
	'<Question>' questionCotation cotationType type body possibleAnswersList '</Question>';

cotation:
	'<Cotation>' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '</Cotation>';

cotationType:
	'<CotationType>' ('%' | 'POINTS' | 'VALUES') '</CotationType>';

type:
	'<Type>' (
		TRUE_FALSE_QUESTION
		| SHORT_TEXT_ANSWER_QUESTION
		| SINGLE_ANSWER_CHOICE_QUESTION
		| MULTIPLE_ANSWER_CHOICE_QUESTION
		| INTEGER_NUMBER_QUESTION
		| DECIMAL_NUMBER_QUESTION
		| DATE_QUESTION
		| TIME_QUESTION
		| NUMERIC_SCALE_QUESTION
	) '</Type>';

body:
	'<Body>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</Body>';

questionCotation: cotation;

answerCotation: cotation;

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers:
	'<PossibleAnswers>' answer answerCotation '</PossibleAnswers>';

answer: '<Answer>' text '</Answer>';

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