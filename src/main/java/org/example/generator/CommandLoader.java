package org.example.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandLoader {
    public void createProject(String rawData) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", "yo --data='" + rawData + "'");
        Process process = pb.start();

        BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String linea;
        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
        }

        int codigoSalida = process.waitFor();
        System.out.println(codigoSalida);
    }
}
