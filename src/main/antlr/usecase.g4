grammar usecase;

//Parser Rules
usecase_spec:
    usecase_def* EOF 
    ;

usecase_def:
    usecase NEWLINE
    description NEWLINE
    scope NEWLINE
    actors NEWLINE
    precond NEWLINE
    (flow NEWLINE)+ 
    postcond NEWLINE
    RPAR
    ;
    
usecase:
    USECASE INT STRING LPAR
    ;
    
description:
    DESC STRING
    ;
    
scope:
    SCOPE STRING
    ;
    
actors:
    ACTORS STRING (COMMA STRING)*
    ;

precond:
    PRE NEWLINE
    (cond|(cond NEWLINE)+ cond)
    ;

flow:
    FLOW STRING COLON NEWLINE
    (step|(step NEWLINE)+ step)
    ;

step:
    INT RPAR (
    |USERACT STRING (WITH property EQUALS STRING)?
    |property FOR entity (EQUALS|GT|LT|CONTAINS) STRING
    |entity TRANS state
    )
    ;
    
postcond:
    POST NEWLINE
    (cond|(cond NEWLINE)+ cond)
    ;
    
cond:
    | entity (ISIN|NOTIN) state
    | property FOR entity (EQUALS|GT|LT|CONTAINS) STRING
    ;
    
entity:
    ENT STRING
    ;
property:
    PROP STRING
    ;
state:
    STATE STRING
    ;


//Lexer Rules


//Field keywords
USECASE : 'Usecase UC'
        | 'Use case UC'
        | 'Use Case UC';
        
DESC    : 'Description:';
SCOPE   : 'Scope:';
ACTORS  : 'Actors:';
        
PRE     : 'Preconditions:';
POST    : 'Postconditions:';
NONE    : 'None'
        | 'none';

FLOW    : 'Flow';

//For conditions and steps
ENT     : 'Entity '
        | 'entity '
        ;
PROP    : 'Property '
        | 'property '
        ;
STATE   : 'State '
        | 'state '
        ;

FOR     : ' for ';
WITH    : ' with ';
ISIN    : ' is in ';
NOTIN   : ' is not in ';


EQUALS  : ' equal to ';
GT      : ' is greater than ';
LT      : ' is less than ';
CONTAINS: ' contains ';


USERACT : 'User performs action';
TRANS   : ' transitions to ';

STRING  : '"' (~["\r\n] | '\\' .)* '"'
        | '\'' (~['\r\n] | '\\' .)* '\''
        ;
INT     : [0-9]+ ;
//ID    : (LETTER|' ')+ ;

NEWLINE : '\n';
COMMA   : ',';
LPAR    : '(';
RPAR    : ')';
COLON   : ':';


fragment LETTER: [a-z]|[A-Z];

WS : ' ' -> skip ;  
INDENT : '\r' -> skip;