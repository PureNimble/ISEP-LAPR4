grammar Requirements;

start: 'TITLE:' text 'NAME:' content+;

text: (TEXT | LETTER | NUMBER | MEMBER)+;

content: '#' text 'ANSWER:';

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/+!?)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\r\n]+ -> skip;