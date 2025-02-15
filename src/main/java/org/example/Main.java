package org.example;

import java_cup.runtime.Symbol;
import org.example.cup.SyntaxFacade;
import org.example.cup.sym;
import org.example.generator.CodeGenerator;
import org.example.lexer.LexerFacade;
import org.example.lexer.Token;

import java.util.List;

public class Main {

    static LexerFacade lexerFacade = new LexerFacade();
    static SyntaxFacade syntaxFacade = new SyntaxFacade();

    public static void main(String[] args) throws Exception {

        String dslTest = """
            ENTITY User {
                user_id AS INTEGER
                name AS STRING
                age AS INTEGER
            }
            
            ENTITY User {
                user_id AS INTEGER
                name AS STRING
                age AS INTEGER
            }
            
            ENTITY User {
                user_id AS INTEGER
                name AS STRING
                age AS INTEGER
            }

            VALIDATIONS FOR User {
                user_id IS UNIQUE
                name IS NOT NULL
                age IS GREATER_THAN 15
            }

            // CRUD FOR User
            CONTROLLER FOR User {
                GET_BY_ID // Default
                GET_ALL // DEFAULT
                UPDATE // DEFAULT
                SAVE // DEFAULT
                DELETE // DEFAULT
                // JPA
                GET_BY user_id
                GET_BY name
                GET_BY user_id AND name
            }

            DATASOURCE {
                DBMS IS POSTGRESQL
                IP IS "localhost"
                DATABASE IS "mydb"
                USERNAME IS "root"
                PASSWORD IS "password"
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
            System.out.println("Syntax test failed.");
            Symbol s = syntaxFacade.syntax.getSymbol();
            System.out.println("Error in line: " + (s.right + 1) + " Column: " + (s.left + 1) + " Value: " + s.value);
            System.out.println("s.sym = " + sym.terminalNames[s.sym]);
        }

        // Generate code
        CodeGenerator cg = new CodeGenerator();
        cg.generate(dslTest);
    }
}
