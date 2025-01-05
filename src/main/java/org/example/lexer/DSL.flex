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

// Keywords
"DEFINE"                  { lexeme = yytext(); return DEFINE; }
"ENTITY"                  { lexeme = yytext(); return ENTITY; }
"CONTROLLER"              { lexeme = yytext(); return CONTROLLER; }
"DTO"                     { lexeme = yytext(); return DTO; }
"VALIDATIONS"             { lexeme = yytext(); return VALIDATIONS; }
"CONFIGURE"               { lexeme = yytext(); return CONFIGURE; }
"DATASOURCE"              { lexeme = yytext(); return DATASOURCE; }
"AS"                      { lexeme = yytext(); return AS; }
"FOR"                     { lexeme = yytext(); return FOR; }
"WITH"                    { lexeme = yytext(); return WITH; }
"IS"                      { lexeme = yytext(); return IS; }
"NOT"                     { lexeme = yytext(); return NOT; }
"NULL"                    { lexeme = yytext(); return NULL; }
"GREATER_THAN"            { lexeme = yytext(); return GREATER_THAN; }
"LESS_THAN"               { lexeme = yytext(); return LESS_THAN; }
"EQUALS_TO"               { lexeme = yytext(); return EQUALS_TO; }
"UNIQUE"                  { lexeme = yytext(); return UNIQUE; }
"PATH"                    { lexeme = yytext(); return PATH; }
"METHODS"                 { lexeme = yytext(); return METHODS; }
"GET"                     { lexeme = yytext(); return GET; }
"POST"                    { lexeme = yytext(); return POST; }
"PUT"                     { lexeme = yytext(); return PUT; }
"DELETE"                  { lexeme = yytext(); return DELETE; }
"EXCLUDE"                 { lexeme = yytext(); return EXCLUDE; }
"URL"                     { lexeme = yytext(); return URL; }
"USERNAME"                { lexeme = yytext(); return USERNAME; }
"PASSWORD"                { lexeme = yytext(); return PASSWORD; }
"DRIVER"                  { lexeme = yytext(); return DRIVER; }


// Data type
"STRING"                  { lexeme = yytext(); return STRING; }
"INTEGER"                 { lexeme = yytext(); return INTEGER; }
"LONG"                    { lexeme = yytext(); return LONG; }
"FLOAT"                   { lexeme = yytext(); return FLOAT; }
"BOOLEAN"                 { lexeme = yytext(); return BOOLEAN; }

// Identifier
[a-zA-Z_][a-zA-Z0-9_]*    { lexeme = yytext(); return IDENTIFIER; }

// Data
("-"?[0-9]+)               { lexeme = yytext(); return NUMBER; }
("-"?[0-9]+\\.[0-9]+)      { lexeme = yytext(); return NUMBER; }
\"([^\\\"]|\\.)*\"         { lexeme = yytext().substring(1, yytext().length() - 1); return STRING_LITERAL; }
\'([^\\\']|\\.)*\'         { lexeme = yytext().substring(1, yytext().length() - 1); return STRING_LITERAL; }

// Symbols
"{"                       { lexeme = yytext(); return LBRACE; }
"}"                       { lexeme = yytext(); return RBRACE; }
"("                       { lexeme = yytext(); return LPAREN; }
")"                       { lexeme = yytext(); return RPAREN; }
"["                       { lexeme = yytext(); return LBRACKET;}
"]"                       { lexeme = yytext(); return RBRACKET;}
":"                       { lexeme = yytext(); return COLON; }
","                       { lexeme = yytext(); return COMMA; }
"="                       { lexeme = yytext(); return EQUALS; }

// Ignore
[ \t\r\n]+                { /* Spaces */ }
"//".*                    { /* Comment */ }

// Err
.                         { lexeme = yytext(); return ERROR; }