package org.example.cup;

import java_cup.runtime.Symbol;

import java.io.StringReader;

public class SyntaxTest {
    public static void main(String[] args) {
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

        Syntax syntax = new Syntax(new DSLCup(new StringReader(dslTest)));
        try {
            syntax.parse();
            System.out.println("Syntax test passed.");
        } catch (Exception e) {
            Symbol s = syntax.getSymbol();
            System.out.println("Error in line: " + (s.right + 1) + " Column: " + (s.left + 1) + " Value: " + s.value);
            System.out.println("s.sym = " + sym.terminalNames[s.sym]);
        }

    }
}
