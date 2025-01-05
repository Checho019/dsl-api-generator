package org.example.cup;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SyntaxGenerator {
    public static void main(String[] args) {
        String flexRoute = "/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/cup/DSLCup.flex";
        String[] cupRoute = {"-parser", "Syntax", "/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/cup/Syntax.cup"};
        try {
            generateSyntax(flexRoute, cupRoute);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void generateSyntax(String flexRoute, String[] CupRoute) throws Exception {
        // DSLCup.flex Generation
        String[] args = { flexRoute };
        jflex.Main.generate(args);

        // Generate Syntax
        java_cup.Main.main(CupRoute);

        // Delete old sym and Syntax files
        Path symPath = Paths.get("/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/cup/sym.java");
        Path sinPath = Paths.get("/home/elpapucho/IdeaProjects/cienciasIII/src/main/java/org/example/cup/Syntax.java");
        if (Files.exists(symPath)){
            Files.delete(symPath);
        }
        if (Files.exists(sinPath)){
            Files.delete(sinPath);
        }

        // Move new sym and Syntax files
        Files.move(
            Paths.get("/home/elpapucho/IdeaProjects/cienciasIII/sym.java"),
            symPath
        );
        Files.move(
                Paths.get("/home/elpapucho/IdeaProjects/cienciasIII/Syntax.java"),
                sinPath
        );

    }
}