grammar Requirements;

start: 'TITLE:' text+ 'NAME:' content+;

text: (WORD | NUMBER | MEMBER);

content:'#' (text MEMBER?)*
        text+':' (text MEMBER?)*;

NUMBER: [0-9]+;
WORD: [a-zA-Z.]+;
MEMBER: [.,;:!?)(-] | '\'';
WS: [ \t\r\n]+ -> skip;