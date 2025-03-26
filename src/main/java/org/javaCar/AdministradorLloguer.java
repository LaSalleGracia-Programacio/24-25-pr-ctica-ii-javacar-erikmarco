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
    public static void llogarVehicle() {
        System.out.println("--- LLOGAR VEHICLE ---");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");
        int tipus = ErrorChecker.checkIntPos(3);

        System.out.print("Introdueix el nombre de dies de lloguer: ");
        int dies = ErrorChecker.checkIntPos(365); // màxim 1 any

        String nomClasse = switch (tipus) {
            case 1 -> "Cotxe";
            case 2 -> "Moto";
            case 3 -> "Furgoneta";
            default -> "";
        };

        System.out.println("Vehicles disponibles de tipus " + nomClasse + ":");
        boolean trobat = false;
        for (Vehicle v : vehicles) {
            if (v.getClass().getSimpleName().equals(nomClasse)) {
                System.out.println("- " + v.getMatricula() + " (" + v.getMarca() + " " + v.getModel() + ")");
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha vehicles disponibles d’aquest tipus.");
            return;
        }

        System.out.print("Introdueix la matrícula del vehicle a llogar: ");
        String matricula = scan.nextLine();

        Vehicle seleccionat = null;
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equalsIgnoreCase(matricula) && v.getClass().getSimpleName().equals(nomClasse)) {
                seleccionat = v;
                break;
            }
        }

        if (seleccionat == null) {
            System.out.println("Vehicle no trobat o no coincideix amb el tipus seleccionat.");
            return;
        }

        double preuFinal = 0;

        switch (nomClasse) {
            case "Cotxe" -> preuFinal = ((Cotxe) seleccionat).calcularPreuCotxe(dies, seleccionat.getPreuBase());
            case "Moto" -> preuFinal = ((Moto) seleccionat).calcularPreuMoto(dies, seleccionat.getPreuBase(), ((Moto) seleccionat).getCilindrada());
            case "Furgoneta" -> preuFinal = ((Furgoneta) seleccionat).calcularPreuFurgoneta(dies, seleccionat.getPreuBase(), ((Furgoneta) seleccionat).getCapacitatCarga());
        }

        System.out.println("Preu total del lloguer per " + dies + " dies: " + preuFinal + " €");

        // Si tens la gestió de lloguers (com a AdministradorLloguer)
        AdministradorLloguer.llogar(matricula, dies);
    }

}



