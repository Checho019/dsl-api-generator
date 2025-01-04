package org.example.lexer;

import java.io.*;

public class LexerTest {
    public static void main(String[] args) throws IOException {
        String dslTest = """
            define User as ENTITY {
                name as STRING,
                age as INTEGER
            }

            define validations for User {
                name is not null,
                age is greater_than 15
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
