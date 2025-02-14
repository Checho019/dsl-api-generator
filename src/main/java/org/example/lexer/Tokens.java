
package org.example.lexer;

public enum Tokens {
    // Definition
    AS,
    FOR,
    IS,

    // Definable
    ENTITY,
    CONTROLLER,
    CRUD,
    VALIDATIONS,
    DATASOURCE,

    // Constrains
    NOT,
    NULL,
    EMPTY,
    GREATER_THAN,
    LESS_THAN,
    EQUALS_TO,
    UNIQUE,

    // Controller
    // CRUD
    GET_BY_ID,
    GET_ALL,
    UPDATE,
    DELETE,
    SAVE,
    // JPA
    GET_BY,
    AND,

    // Datasource
    DBMS,
    IP,
    DATABASE,
    USERNAME,
    PASSWORD,

    // DBMS
    DBMS_SERVER,

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

    // Err
    ERROR
}
