package org.example;
import static org.example.Tokens.*;
%%
%class LexicalAnalyzer
%type Tokens
Letter=[a-zA-Z_]+
Digit=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int |
if |
else |
while { lexeme=yytext(); return Reservadas; }
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"+" | "-" | "*" | "/" { lexeme = yytext(); return Operacion;}
"+" { lexeme = yytext(); return Suma; }
"-" { lexeme = yytext(); return Resta; }
"*" { lexeme = yytext(); return Multiplicacion; }
"/" { lexeme = yytext(); return Division; }
"=" { lexeme = yytext(); return Igual; }
{Letter}({Letter}|{Digit})* { lexeme=yytext(); return Identificador; }
("(-"{Digit}+")")|{Digit}+ { lexeme=yytext(); return Numero; }
 . { lexeme = yytext(); return ERROR; }
