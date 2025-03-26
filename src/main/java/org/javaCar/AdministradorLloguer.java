package org.javaCar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AdministradorLloguer extends LlistaVehicles {
    private static final HashMap<String, Boolean> vehiclesLlogats = new HashMap<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void init() {
        vehiclesLlogats.clear();
        for (Vehicle v : LlistaVehicles.vehicles) {
            vehiclesLlogats.put(v.getMatricula(), false);
        }
        generarFitxer("vehiclesLlogats.csv");
    }

    public static void toggleLlogat(String matricula) {
        if (vehiclesLlogats.containsKey(matricula)) {
            vehiclesLlogats.put(matricula, !vehiclesLlogats.get(matricula));
        } else {
            System.out.println("Error: No s'ha trobat cap vehicle amb matrícula " + matricula);
        }
    }

    public static void generarFitxer(String fitxer) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fitxer, false))) {
            for (Vehicle v : LlistaVehicles.vehicles) {
                String matricula = v.getMatricula();
                boolean llogat = vehiclesLlogats.getOrDefault(matricula, false);
                String dataAddicio = v.getDataAddicio().toString();

                writer.println(matricula + "," + llogat + "," + dataAddicio + "," + v.getMarca() + "," + v.getModel() + ","
                        + v.getMotor() + "," + v.getRodes() + "," + v.getDistintiuAmbiental() + "," + v.getPreuBase());
            }
            System.out.println("Llista de vehicles llogats generada correctament.");
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

        if (vehiclesLlogats.get(matricula)) {
            System.out.println("El vehicle ja està llogat.");
            return;
        }

        toggleLlogat(matricula);
        System.out.println("Vehicle " + matricula + " llogat per " + dies + " dies.");
        generarFitxer("vehiclesLlogats.csv");

        scheduler.schedule(() -> {
            toggleLlogat(matricula);
            System.out.println("Vehicle " + matricula + " ha finalitzat el seu lloguer.");
            generarFitxer("vehiclesLlogats.csv");
        }, dies, TimeUnit.DAYS);
    }
}
