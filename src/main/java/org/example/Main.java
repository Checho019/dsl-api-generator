package org.example;

import java_cup.runtime.Symbol;
import org.example.cup.SyntaxFacade;
import org.example.cup.sym;
import org.example.lexer.LexerFacade;
import org.example.lexer.Token;
import org.example.lexer.Tokens;

import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;

public class Main {

    static LexerFacade lexerFacade = new LexerFacade();
    static SyntaxFacade syntaxFacade = new SyntaxFacade();

    public static void main(String[] args) throws Exception {

        String dslTest = """
            DEFINE User AS ENTITY {
                user_id AS INTEGER,
                name AS STRING,
                age AS INTEGER
            }

            DEFINE Pet AS ENTITY {
                pet_id AS INTEGER,
                name AS STRING,
                animal AS STRING
            }

            // DEFINE RELATIONSHIP User TO Pet IS ONE_TO_MANY

            DEFINE VALIDATIONS FOR User {
                user_id IS ID,
                name IS NOT NULL,
                age IS GREATER_THAN 15
            }

            DEFINE VALIDATIONS FOR Pet {
                pet_id IS ID,
                name IS NOT NULL,
                animal IS NOT NULL
            }

            DEFINE CONTROLLER FOR User {
                 PATH: "/users",
                 METHODS: [GET, POST, PUT, DELETE]
            }

            DEFINE CONTROLLER FOR Pet {
                 PATH: "/pets",
                 METHODS: [GET, POST, DELETE]
            }

            CONFIGURE DATASOURCE {
                  URL: "jdbc:mysql://localhost:3306/mydb",
                  USERNAME: "root",
                  PASSWORD: "password",
                  DRIVER: "com.mysql.cj.jdbc.Driver"
            }
        """;

        // Lexical Analysis
        List<Token> lexerResult = lexerFacade.lex(dslTest);
        for (Token token : lexerResult) {
            System.out.println(token.toString());
        }
        System.out.println();

        // Syntactic Analysis
        try {
            syntaxFacade.parse(dslTest);
            System.out.println("Syntax test passed.");
        } catch (Exception e) {
            Symbol s = syntaxFacade.syntax.getSymbol();
            System.out.println("Error in line: " + (s.right + 1) + " Column: " + (s.left + 1) + " Value: " + s.value);
            System.out.println("s.sym = " + sym.terminalNames[s.sym]);
        }
    }
}
