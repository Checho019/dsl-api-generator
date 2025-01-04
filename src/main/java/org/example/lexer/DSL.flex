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
"define"                  { lexeme = yytext(); return DEFINE; }
"entity"                  { lexeme = yytext(); return ENTITY; }
"validations"             { lexeme = yytext(); return VALIDATIONS; }
"as"                      { lexeme = yytext(); return AS; }
"for"                     { lexeme = yytext(); return FOR; }
"is"                      { lexeme = yytext(); return IS; }
"not"                     { lexeme = yytext(); return NOT; }
"null"                    { lexeme = yytext(); return NULL; }
"greater_than"            { lexeme = yytext(); return GREATER_THAN; }
"less_than"               { lexeme = yytext(); return LESS_THAN; }
"equals_to"               { lexeme = yytext(); return EQUALS_TO; }
"unique"                  { lexeme = yytext(); return UNIQUE; }

// Data type
"STRING"                  { lexeme = yytext(); return STRING; }
"INTEGER"                 { lexeme = yytext(); return INTEGER; }
"LONG"                    { lexeme = yytext(); return LONG; }
"FLOAT"                   { lexeme = yytext(); return FLOAT; }
"BOOLEAN"                 { lexeme = yytext(); return BOOLEAN; }

// Identifier
[a-zA-Z_][a-zA-Z0-9_]*    { lexeme = yytext(); return IDENTIFIER; }

// Numbers
("-"?[0-9]+)               { lexeme = yytext(); return NUMBER; }
("-"?[0-9]+\\.[0-9]+)      { lexeme = yytext(); return NUMBER; }

// Symbols
"{"                       { lexeme = yytext(); return LBRACE; }
"}"                       { lexeme = yytext(); return RBRACE; }
"("                       { lexeme = yytext(); return LPAREN; }
")"                       { lexeme = yytext(); return RPAREN; }
";"                       { lexeme = yytext(); return SEMICOLON; }
","                       { lexeme = yytext(); return COMMA; }
"="                       { lexeme = yytext(); return EQUALS; }

// Ignore
[ \t\r\n]+                { /* Spaces */ }
"//".*                    { /* Comment */ }

// Err
.                         { lexeme = yytext(); return ERROR; }