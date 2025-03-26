package org.javaCar;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;




public class Lloguer {

    public static final Scanner scan = new Scanner(System.in);


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
