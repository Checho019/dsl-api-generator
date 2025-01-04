package org.example.lexer;

public class LexerGenerator {
    public static void main(String[] args) {
        String route = "/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/lexer/DSL.flex";
        try {
            generateLexer(route);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void generateLexer(String route) throws Exception {
        String[] args = { route };
        jflex.Main.generate(args);
    }
}