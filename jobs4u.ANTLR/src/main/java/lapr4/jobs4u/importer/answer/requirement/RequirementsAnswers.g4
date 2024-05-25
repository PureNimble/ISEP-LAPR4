grammar RequirementsAnswers;

start: 'TITLE:' text NEWLINE 'NAME:' NEWLINE 'EMAIL:' email NEWLINE content+ EOF;

text: (TEXT | LETTER | NUMBER | MEMBER)+;
email: TEXT '@' TEXT '.' TEXT ('.' TEXT)?;

content: '#' text ('#' text?)? NEWLINE 'ANSWER:' NEWLINE;

NUMBER: [0-9];
LETTER: [a-zA-Z];
MEMBER: [.,;:/#+!?@*)([\]] | '\'' | '|' | '-';
TEXT: (LETTER | NUMBER | MEMBER)+;
NEWLINE: ('\r'? '\n')+;
WS: [ \t\r\n]+ -> skip;