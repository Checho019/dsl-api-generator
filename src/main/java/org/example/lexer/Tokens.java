
package org.example.lexer;

public enum Tokens {
    // KeyWords
    DEFINE,
    ENTITY,
    VALIDATIONS,
    AS,
    FOR,
    IS,
    NOT,
    NULL,
    GREATER_THAN,
    LESS_THAN,
    EQUALS_TO,
    UNIQUE,

    // Data types
    STRING,
    INTEGER,
    LONG,
    BOOLEAN,
    FLOAT,

    // Identifiers
    IDENTIFIER,

    // Number
    NUMBER,

    // Symbols
    LBRACE,  // {
    RBRACE,  // }
    LPAREN,  // (
    RPAREN,  // )
    SEMICOLON,  // ;
    COMMA,  // ,
    EQUALS,  // =

    // Err
    ERROR
}
