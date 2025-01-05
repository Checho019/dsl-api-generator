
package org.example.lexer;

public enum Tokens {
    // KeyWords
    DEFINE,
    ENTITY,
    CONTROLLER,
    DTO,
    VALIDATIONS,
    CONFIGURE,
    DATASOURCE,
    AS,
    FOR,
    WITH,
    IS,
    NOT,
    NULL,
    GREATER_THAN,
    LESS_THAN,
    EQUALS_TO,
    UNIQUE,
    PATH,
    METHODS,
    GET,
    POST,
    PUT,
    DELETE,
    EXCLUDE,
    URL,
    USERNAME,
    PASSWORD,
    DRIVER,

    // Data types
    STRING,
    INTEGER,
    LONG,
    BOOLEAN,
    FLOAT,

    // Identifiers
    IDENTIFIER,

    // Data
    NUMBER,
    STRING_LITERAL,

    // Symbols
    LBRACE,  // {
    RBRACE,  // }
    LPAREN,  // (
    RPAREN,  // )
    LBRACKET, // [
    RBRACKET, // ]
    SINGLE_QUOTE, // '
    DOUBLE_QUOTE, // "
    COLON,  // :
    COMMA,  // ,
    EQUALS,  // =

    // Err
    ERROR
}
