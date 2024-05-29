grammar RequirementsXml;

questions: '<Questions>' question+ '</Questions>' EOF;

text: (TEXT | TWO_DIGIT_NUMBER | LETTER | MEMBER)+;

question: '<Question>' body possibleAnswersList minimumRequirement '</Question>';

body:
	'<Body>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</Body>';

possibleAnswersList:
	'<PossibleAnswersList>' possibleAnswers* '</PossibleAnswersList>';

possibleAnswers:
	'<PossibleAnswers>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</PossibleAnswers>';

minimumRequirement:
	'<MinimumRequirement>' text (
		('<' | '/' | '>' | '</') text (
			('<' | '/' | '>' | '</') text
		)?
	)? '</MinimumRequirement>';

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
FRACTIONAL_NUMBER:
	TWO_DIGIT_NUMBER ('.' | ',') TWO_DIGIT_NUMBER;
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
WS: [ \t\n\r]+ -> skip;