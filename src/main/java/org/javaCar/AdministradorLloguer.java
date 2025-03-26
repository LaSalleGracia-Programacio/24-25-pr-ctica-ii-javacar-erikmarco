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

                // Get the type of the vehicle (subclass name)
                String vehicleType = v.getClass().getSimpleName(); // "Cotxe", "Moto", or "Furgoneta"

                // Write vehicle data to the CSV
                writer.println(vehicleType + "," + matricula + "," + (diesLlogats > 0) + "," + diesLlogats + "," + dataLloguer + "," +
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

    public static void llogarVehicle() {
        System.out.println("--- LLOGAR VEHICLE ---");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");
        int tipus = ErrorChecker.checkIntPos(3);

        System.out.print("Introdueix el nombre de dies de lloguer: ");
        int dies = ErrorChecker.checkIntPos(365); // máx. 1 any

        String nomClasse = switch (tipus) {
            case 1 -> "Cotxe";
            case 2 -> "Moto";
            case 3 -> "Furgoneta";
            default -> "";
        };

        System.out.println("Vehicles disponibles de tipus " + nomClasse + ":");
        boolean trobat = false;
        for (Vehicle v : vehicles) {
            // Check the actual class of the vehicle and its type
            if (v.getClass().getSimpleName().equals(nomClasse) && vehiclesLlogats.get(v.getMatricula()) == 0) {
                System.out.println("- " + v.getMatricula() + " (" + v.getMarca() + " " + v.getModel() + ")");
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha vehicles disponibles d’aquest tipus o tots estan llogats.");
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

        // Calculate price based on vehicle subclass
        double preuFinal = 0;
        switch (nomClasse) {
            case "Cotxe" -> preuFinal = ((Cotxe) seleccionat).calcularPreuCotxe(dies, seleccionat.getPreuBase());
            case "Moto" -> preuFinal = ((Moto) seleccionat).calcularPreuMoto(dies, seleccionat.getPreuBase(), ((Moto) seleccionat).getCilindrada());
            case "Furgoneta" -> preuFinal = ((Furgoneta) seleccionat).calcularPreuFurgoneta(dies, seleccionat.getPreuBase(), ((Furgoneta) seleccionat).getCapacitatCarga());
        }

        System.out.println("Preu total del lloguer per " + dies + " dies: " + preuFinal + " €");

        // Perform the actual rental
        AdministradorLloguer.llogar(matricula, dies);
    }


}



