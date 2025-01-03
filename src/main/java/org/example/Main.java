package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String ruta = "/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/Lexer.flex";
        try {
            generarLexer(ruta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void generarLexer(String ruta) throws Exception {
        String[] args = { ruta };
        jflex.Main.generate(args);
    }
}