package org.example.cup;
import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%unicode
%cup
%line
%char
%column

%{
    private Symbol symbol(int type, Object value){
      return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){
      return new Symbol(type, yyline, yycolumn);
    }
%}

%%

// Keywords
"DEFINE"                  { return symbol(sym.DEFINE); }
"ENTITY"                  { return symbol(sym.ENTITY); }
"CONTROLLER"              { return symbol(sym.CONTROLLER); }
"DTO"                     { return symbol(sym.DTO); }
"VALIDATIONS"             { return symbol(sym.VALIDATIONS); }
"CONFIGURE"               { return symbol(sym.CONFIGURE); }
"DATASOURCE"              { return symbol(sym.DATASOURCE); }
"AS"                      { return symbol(sym.AS); }
"FOR"                     { return symbol(sym.FOR); }
"WITH"                    { return symbol(sym.WITH); }
"IS"                      { return symbol(sym.IS); }
"NOT"                     { return symbol(sym.NOT); }
"NULL"                    { return symbol(sym.NULL); }
"GREATER_THAN"            { return symbol(sym.GREATER_THAN); }
"LESS_THAN"               { return symbol(sym.LESS_THAN); }
"EQUALS_TO"               { return symbol(sym.EQUALS_TO); }
"UNIQUE"                  { return symbol(sym.UNIQUE); }
"ID"                      { return symbol(sym.ID); }
"RELATIONSHIP"            { return symbol(sym.RELATIONSHIP); }
"TO"                      { return symbol(sym.TO); }
"ONE_TO_ONE"              { return symbol(sym.ONE_TO_ONE); }
"ONE_TO_MANY"             { return symbol(sym.ONE_TO_MANY); }
"MANY_TO_MANY"            { return symbol(sym.MANY_TO_MANY); }
"PATH"                    { return symbol(sym.PATH); }
"METHODS"                 { return symbol(sym.METHODS); }
"GET"                     { return symbol(sym.GET); }
"POST"                    { return symbol(sym.POST); }
"PUT"                     { return symbol(sym.PUT); }
"DELETE"                  { return symbol(sym.DELETE); }
"EXCLUDE"                 { return symbol(sym.EXCLUDE); }
"URL"                     { return symbol(sym.URL); }
"USERNAME"                { return symbol(sym.USERNAME); }
"PASSWORD"                { return symbol(sym.PASSWORD); }
"DRIVER"                  { return symbol(sym.DRIVER); }


// Data type
"STRING"                  { return symbol(sym.STRING); }
"INTEGER"                 { return symbol(sym.INTEGER); }
"LONG"                    { return symbol(sym.LONG); }
"FLOAT"                   { return symbol(sym.FLOAT); }
"BOOLEAN"                 { return symbol(sym.BOOLEAN); }

// Identifier
[a-zA-Z_][a-zA-Z0-9_]*    { return symbol(sym.IDENTIFIER, yytext()); }

// Data
("-"?[0-9]+)               { return symbol(sym.NUMBER, yytext()); }
("-"?[0-9]+\\.[0-9]+)      { return symbol(sym.NUMBER, yytext()); }
\"([^\\\"]|\\.)*\"         { return symbol(sym.STRING_LITERAL, yytext()); }
\'([^\\\']|\\.)*\'         { return symbol(sym.STRING_LITERAL, yytext()); }

// Symbols
"{"                       { return symbol(sym.LBRACE); }
"}"                       { return symbol(sym.RBRACE); }
"("                       { return symbol(sym.LPAREN); }
")"                       { return symbol(sym.RPAREN); }
"["                       { return symbol(sym.LBRACKET); }
"]"                       { return symbol(sym.RBRACKET); }
":"                       { return symbol(sym.COLON); }
","                       { return symbol(sym.COMMA); }
"="                       { return symbol(sym.EQUALS); }

// Ignore
[ \t\r\n]+                { /* Spaces */ }
"//".*                    { /* Comment */ }

// Err
.                         { return symbol(sym.ERROR, yytext()); }