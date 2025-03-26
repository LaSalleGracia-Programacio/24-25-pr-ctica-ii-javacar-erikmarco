package org.javaCar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class AdministradorLloguer extends LlistaVehicles {
    private static final HashMap<String, Integer> vehiclesLlogats = new HashMap<>();

    public static void init() {
        vehiclesLlogats.clear();
        for (Vehicle v : LlistaVehicles.vehicles) {
            vehiclesLlogats.put(v.getMatricula(), 0); // 0 means not rented
        }
        generarFitxer("vehiclesLlogats.csv");
    }

    public static void toggleLlogat(String matricula, int dies) {
        if (vehiclesLlogats.containsKey(matricula)) {
            vehiclesLlogats.put(matricula, dies); // Set rental days (0 = not rented)
            generarFitxer("vehiclesLlogats.csv"); // Update CSV immediately
        } else {
            System.out.println("Error: No s'ha trobat cap vehicle amb matrícula " + matricula);
        }
    }

    public static void generarFitxer(String fitxer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fitxer, false))) {
            for (Vehicle v : LlistaVehicles.vehicles) {
                String matricula = v.getMatricula();
                int diesLlogats = vehiclesLlogats.getOrDefault(matricula, 0); // Get rental days
                String dataLloguer = diesLlogats > 0 ? LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : v.getDataAddicio().toString();

                writer.println(matricula + "," + (diesLlogats > 0) + "," + diesLlogats + "," + dataLloguer + "," +
                        v.getMarca() + "," + v.getModel() + "," + v.getMotor() + "," + v.getRodes() + "," +
                        v.getDistintiuAmbiental() + "," + v.getPreuBase());
            }
            System.out.println("Llista de vehicles llogats actualitzada correctament.");
        } catch (IOException ioException) {
            System.out.println("Error en l'escriptura al fitxer de vehicles llogats: " + ioException.getMessage());
            ErrorLogger.logError(ioException);
            System.out.println("S'ha enviat l'error al fitxer de logging d'errors.");
        }
    }

    public static void llogar(String matricula, int dies) {
        if (!vehiclesLlogats.containsKey(matricula)) {
            System.out.println("Error: El vehicle amb matrícula " + matricula + " no existeix.");
            return;
        }

        if (vehiclesLlogats.get(matricula) > 0) {
            System.out.println("El vehicle ja està llogat.");
            return;
        }

        // Update rental status and CSV immediately
        toggleLlogat(matricula, dies);
        System.out.println("Vehicle " + matricula + " llogat per " + dies + " dies.");
    }

    public static void retornarVehicle(String matricula) {
        if (vehiclesLlogats.containsKey(matricula) && vehiclesLlogats.get(matricula) > 0) {
            toggleLlogat(matricula, 0);
            System.out.println("Vehicle " + matricula + " retornat.");
        } else {
            System.out.println("Error: El vehicle no està llogat o no existeix.");
        }
    }
}
