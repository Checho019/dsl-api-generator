
package org.example.lexer;

public enum Tokens {
    // Definition
    DEFINE,
    AS,
    FOR,

    // Definable
    ENTITY,
    CONTROLLER,
    DTO,
    VALIDATIONS,
    CONFIGURE,
    RELATIONSHIP,

    // Configurable
    DATASOURCE,

    // Constrains
    IS,
    NOT,
    NULL,
    GREATER_THAN,
    LESS_THAN,
    EQUALS_TO,
    UNIQUE,
    ID,

    // Relationship
    ONE_TO_ONE,
    ONE_TO_MANY,
    MANY_TO_MANY,
    TO,

    // Controller Definition
    PATH,
    METHODS,
    GET,
    POST,
    PUT,
    DELETE,

    // DTO Definition
    WITH,
    EXCLUDE,

    // Datasource Configuration
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
    COLON,  // :
    COMMA,  // ,
    EQUALS,  // =

    // Err
    ERROR
}
