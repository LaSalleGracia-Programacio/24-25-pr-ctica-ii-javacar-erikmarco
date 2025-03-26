package org.javaCar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface ErrorLogger {
    public static void logError(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("error_log.txt", true))) {
            e.printStackTrace(writer);
            writer.println();
            System.out.println("S'ha trobat un error durant l'execució del programa! Es pot consultar el problema a error_log.txt");
        } catch (IOException ioException) {
            System.out.println("Error en l'escriptura al fitxer de logging: " + ioException.getMessage());
        }
    }
}
