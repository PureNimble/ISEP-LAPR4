grammar Xml;

questions: '<Questions>' question+ '</Questions>' EOF;

question:
	'<Question>' cotation? type body possibleAnswersList '</Question>';

cotation:
	'<Cotation>' (
		TWO_DIGIT_NUMBER
		| FRACTIONAL_NUMBER
		| '100'
	) ('%' | 'POINTS' | 'VALUES') '</Cotation>';

type: '<type>' TEXT+ '</type>';

body: '<body>' TEXT+ '</body>';

possibleAnswersList:
	'<possibleAnswersList>' possibleAnswers* '</possibleAnswersList>';

possibleAnswers: '<possibleAnswers>' TEXT+ '</possibleAnswers>';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?)([\]] | '\'';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;