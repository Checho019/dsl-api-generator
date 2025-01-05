package org.example.lexer;

import java.io.*;

public class LexerTest {
    public static void main(String[] args) throws IOException {
        String dslTest = """
            DEFINE User AS ENTITY {
                name AS STRING,
                age AS INTEGER,
            }

            DEFINE VALIDATIONS FOR User {
                name IS NOT NULL,
                age IS GREATER_THAN 15
            }

            DEFINE CONTROLLER FOR User {
                 PATH: "/users",
                 METHODS: [GET, POST, PUT, DELETE]
            }

            DEFINE UserDTO AS DTO WITH User {
                  EXCLUDE: [age]
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
