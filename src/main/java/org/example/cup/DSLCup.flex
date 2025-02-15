package org.example.cup;
import java_cup.runtime.Symbol;

%%
%class DSLCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char


%{
    private Symbol symbol(int type, String value){
      return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type){
      return new Symbol(type, yyline, yycolumn);
    }
%}

%%
/*
Keywords
 */
// Definition
"AS"                      { return symbol(sym.AS); }
"FOR"                     { return symbol(sym.FOR); }
"IS"                      { return symbol(sym.IS); }

// Definable
"ENTITY"                  { return symbol(sym.ENTITY); }
"CONTROLLER"              { return symbol(sym.CONTROLLER); }
"CRUD"                    { return symbol(sym.CRUD); }
"VALIDATIONS"             { return symbol(sym.VALIDATIONS); }
"DATASOURCE"              { return symbol(sym.DATASOURCE); }

// Constrains
"NOT"                     { return symbol(sym.NOT); }
"NULL"                    { return symbol(sym.NULL); }
"EMPTY"                   { return symbol(sym.EMPTY); }
"GREATER_THAN"            { return symbol(sym.GREATER_THAN); }
"LESS_THAN"               { return symbol(sym.LESS_THAN); }
"EQUALS_TO"               { return symbol(sym.EQUALS_TO); }
"UNIQUE"                  { return symbol(sym.UNIQUE); }

// Controller
// CRUD
"GET_BY_ID"               { return symbol(sym.GET_BY_ID); }
"GET_ALL"                 { return symbol(sym.GET_ALL); }
"UPDATE"                  { return symbol(sym.UPDATE); }
"DELETE"                  { return symbol(sym.DELETE); }
"SAVE"                    { return symbol(sym.SAVE); }
// JPA
"GET_BY"                  { return symbol(sym.GET_BY); }
"AND"                     { return symbol(sym.AND); }

// Datasource
"DBMS"                    { return symbol(sym.DBMS); }
"IP"                      { return symbol(sym.IP); }
"DATABASE"                { return symbol(sym.DATABASE); }
"USERNAME"                { return symbol(sym.USERNAME); }
"PASSWORD"                { return symbol(sym.PASSWORD); }

// DBMS
("POSTGRESQL")            { return symbol(sym.DBMS_SERVER); }

// Data type
"STRING"                  { return symbol(sym.STRING); }
"INTEGER"                 { return symbol(sym.INTEGER); }
"LONG"                    { return symbol(sym.LONG); }
"FLOAT"                   { return symbol(sym.FLOAT); }
"BOOLEAN"                 { return symbol(sym.BOOLEAN); }

// Identifier
[a-zA-Z_][a-zA-Z0-9_]*    { return symbol(sym.IDENTIFIER); }

// Data
// Identifier
\b[a-zA-Z_][a-zA-Z0-9_]*\b    {return symbol(sym.IDENTIFIER, yytext());}

// Data
("-"?[0-9]+)               { return symbol(sym.NUMBER, yytext()); }
("-"?[0-9]+\\.[0-9]+)      { return symbol(sym.NUMBER, yytext()); }
\"([^\\\"]|\\.)*\"         { return symbol(sym.STRING_LITERAL, yytext()); }
\'([^\\\']|\\.)*\'         { return symbol(sym.STRING_LITERAL, yytext()); }

// Symbols
"{"                       { return symbol(sym.LBRACE); }
"}"                       { return symbol(sym.RBRACE); }

// Ignore
[ \t\r\n]+                { /* Spaces */ }
"//".*                    { /* Comment */ }

// Err
.                         { return symbol(sym.ERROR); }