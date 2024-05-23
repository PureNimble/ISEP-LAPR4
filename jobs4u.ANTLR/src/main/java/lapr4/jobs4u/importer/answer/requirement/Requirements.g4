grammar Requirements;

start: 'TITLE:' text 'NAME:' content+;

text: TEXT+;

content: '#' text ('(' option+ ')')? text ':';

option: TEXT (',')?;

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;!?-] | '\'';
TEXT: (LETTER | NUMBER | MEMBER)+;
WS: [ \t\r\n]+ -> skip;