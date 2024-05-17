grammar interview;

start: 'TITLE:' text+ 'NAME:' 'GRADE:' content+;

content: 'COTATION:' (NUMBER NUMBER? | '100') ('%' | 'POINTS' | 'VALUES') 'QUESTION TYPE:' type;

text: (WORD | NUMBER | MEMBER);

type: 'True/False' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Short text answer' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Choice, with single answer' 'QUESTION:' text+ choice 'ANSWER:' 'GRADE:'
    | 'Choice, with multiple answers' 'QUESTION:' text+ choice 'ANSWER:' 'GRADE:'
    | 'Integer Number' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Decimal Number' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Date' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Time' 'QUESTION:' text+ 'ANSWER:' 'GRADE:'
    | 'Numeric Scale' 'QUESTION:' text+ 'ANSWER:' 'GRADE:';

choice: option option+;

option: NUMBER '.' text+;

NUMBER: [0-9]+;
WORD: [a-zA-Z.]+;
MEMBER: [.,;:!?)(-] | '\'';
WS: [ \t\r\n]+ -> skip;