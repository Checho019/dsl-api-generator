package org.example.lexer;

public class Token {
    private String lexeme;
    private Tokens token;

    public Token(String lexeme, Tokens token) {
        this.lexeme = lexeme;
        this.token = token;
    }

    public String getLexeme() {
        return lexeme;
    }

    public Tokens getToken() {
        return token;
    }

    public String toString() {
        return "Lexeme: " + lexeme + " Token: " + token;
    }
}
