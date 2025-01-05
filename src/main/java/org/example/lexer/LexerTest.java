package org.example.lexer;

import java.io.*;

public class LexerTest {
    public static void main(String[] args) throws IOException {
        String dslTest = """
            DEFINE User AS ENTITY {
                user_id AS INTEGER,
                name AS STRING,
                age AS INTEGER,
            }

            DEFINE Pet AS ENTITY {
                pet_id AS INTEGER,
                name AS STRING,
                animal AS STRING,
            }

            DEFINE RELATIONSHIP User TO Pet IS ONE_TO_MANY

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

        Reader r = new BufferedReader(new StringReader(dslTest));
        LexicalAnalyzer lexer = new LexicalAnalyzer(r);
        Tokens token;
        StringBuilder sb = new StringBuilder();
        while ((token = lexer.yylex()) != null) {
            sb.append("Token: ");
            sb.append(token);
            sb.append(" --> ");
            sb.append(lexer.lexeme);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
