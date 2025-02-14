package org.example.lexer;
import static org.example.lexer.Tokens.*;

%%
%class LexicalAnalyzer
%type Tokens
%unicode
%line
%column

%{
    public String lexeme;
%}

%%
/*
Keywords
 */
// Definition
"AS"                      { lexeme = yytext(); return AS; }
"FOR"                     { lexeme = yytext(); return FOR; }
"IS"                      { lexeme = yytext(); return IS; }

// Definable
"ENTITY"                  { lexeme = yytext(); return ENTITY; }
"CONTROLLER"              { lexeme = yytext(); return CONTROLLER; }
"CRUD"                    { lexeme = yytext(); return CRUD; }
"VALIDATIONS"             { lexeme = yytext(); return VALIDATIONS; }
"DATASOURCE"              { lexeme = yytext(); return DATASOURCE; }

// Constrains
"NOT"                     { lexeme = yytext(); return NOT; }
"NULL"                    { lexeme = yytext(); return NULL; }
"EMPTY"                   { lexeme = yytext(); return EMPTY; }
"GREATER_THAN"            { lexeme = yytext(); return GREATER_THAN; }
"LESS_THAN"               { lexeme = yytext(); return LESS_THAN; }
"EQUALS_TO"               { lexeme = yytext(); return EQUALS_TO; }
"UNIQUE"                  { lexeme = yytext(); return UNIQUE; }

// Controller
// CRUD
"GET_BY_ID"               { lexeme = yytext(); return GET_BY_ID; }
"GET_ALL"                 { lexeme = yytext(); return GET_ALL; }
"UPDATE"                  { lexeme = yytext(); return UPDATE; }
"DELETE"                  { lexeme = yytext(); return DELETE; }
"SAVE"                    { lexeme = yytext(); return SAVE; }
// JPA
"GET_BY"                  { lexeme = yytext(); return GET_BY; }
"AND"                     { lexeme = yytext(); return AND; }

// Datasource
"DBMS"                    { lexeme = yytext(); return DBMS; }
"IP"                      { lexeme = yytext(); return IP; }
"DATABASE"                { lexeme = yytext(); return DATABASE; }
"USERNAME"                { lexeme = yytext(); return USERNAME; }
"PASSWORD"                { lexeme = yytext(); return PASSWORD; }

// DBMS
("POSTGRESQL")            { lexeme = yytext(); return DBMS_SERVER; }

// Data type
"STRING"                  { lexeme = yytext(); return STRING; }
"INTEGER"                 { lexeme = yytext(); return INTEGER; }
"LONG"                    { lexeme = yytext(); return LONG; }
"FLOAT"                   { lexeme = yytext(); return FLOAT; }
"BOOLEAN"                 { lexeme = yytext(); return BOOLEAN; }

// Identifier
[a-zA-Z_][a-zA-Z0-9_]*    { lexeme = yytext(); return IDENTIFIER; }

// Data
(-?[0-9]+)                 { lexeme = yytext(); return NUMBER; }
(-?\d+\.\d+)               { lexeme = yytext(); return NUMBER; }
[0-9][a-zA-Z_0-9]*         { lexeme = yytext(); return ERROR; }
\"([^\\\"]|\\.)*\"         { lexeme = yytext().substring(1, yytext().length() - 1); return STRING_LITERAL; }
\'([^\\\']|\\.)*\'         { lexeme = yytext().substring(1, yytext().length() - 1); return STRING_LITERAL; }

// Symbols
"{"                       { lexeme = yytext(); return LBRACE; }
"}"                       { lexeme = yytext(); return RBRACE; }

// Ignore
[ \t\r\n]+                { /* Spaces */ }
"//".*                    { /* Comment */ }

// Err
.                         { lexeme = yytext(); return ERROR; }