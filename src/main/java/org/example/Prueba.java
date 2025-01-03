package org.example;

import java.io.*;

public class Prueba {
    public static void main(String[] args) throws IOException {

        Reader r = new BufferedReader(new StringReader("2 + 3 Variable % x ifS"));
        Lexer lexer = new Lexer(r);

        Tokens token = lexer.yylex();
        while (token != null) {
            System.out.println(lexer.lexeme + " is a " + token);
            token = lexer.yylex();
        }
    }
}
