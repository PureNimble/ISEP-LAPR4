grammar Requirements;

start: 'TITLE:' text NEWLINE 'NAME:' NEWLINE 'EMAIL:' NEWLINE content+ EOF;

text: (TEXT | LETTER | TWO_DIGIT_NUMBER | MEMBER)+ ('#'+ text?)?;
content: '#' text NEWLINE 'ANSWER:' NEWLINE?;

TWO_DIGIT_NUMBER: NUMBER NUMBER?;
NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | TWO_DIGIT_NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\r\n]+ -> skip;