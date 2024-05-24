grammar InterviewXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | NUMBER | LETTER | MEMBER)+;

question:
	'<Question>' cotation cotationType type body possibleAnswersList '</Question>';

cotation:
	'<Cotation>' (TWO_DIGIT_NUMBER | FRACTIONAL_NUMBER | '100') '</Cotation>';

cotationType:
	'<CotationType>' ('%' | 'POINTS' | 'VALUES') '</CotationType>';

type: '<Type>' text (('<' | '/' | '>' | '</') text (('<' | '/' | '>' | '</') text)?)? '</Type>';

body: '<Body>' text (('<' | '/' | '>' | '</') text (('<' | '/' | '>' | '</') text)?)? '</Body>';

answerCotation: cotation;

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers: '<PossibleAnswers>' answer answerCotation '</PossibleAnswers>';

answer: '<Answer>' text '</Answer>';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;