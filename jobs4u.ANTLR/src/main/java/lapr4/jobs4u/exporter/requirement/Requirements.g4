grammar Requirements;

start: 'TITLE:' text NEWLINE 'NAME:' NEWLINE 'EMAIL:' NEWLINE content+ EOF;

text: (TEXT | LETTER | NUMBER | MEMBER)+ ('#'+ text?)?;

content: '#' text ('#' text?)? NEWLINE 'ANSWER:' NEWLINE;

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\r\n]+ -> skip;