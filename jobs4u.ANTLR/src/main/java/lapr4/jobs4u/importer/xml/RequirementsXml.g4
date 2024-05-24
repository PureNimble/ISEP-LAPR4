grammar RequirementsXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | NUMBER | LETTER | MEMBER)+;

question:
	'<Question>' body possibleAnswersList '</Question>';

body: '<Body>' text (('<' | '/' | '>' | '</') text (('<' | '/' | '>' | '</') text)?)? '</Body>';

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers: '<PossibleAnswers>' text (('<' | '/' | '>' | '</') text (('<' | '/' | '>' | '</') text)?)? '</PossibleAnswers>';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TWO_DIGIT_NUMBER: NUMBER NUMBER?;
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;