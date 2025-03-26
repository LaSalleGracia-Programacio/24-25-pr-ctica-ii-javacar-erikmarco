package org.javaCar;

import java.io.*;
import java.util.*;

public class GestorUsuaris {
    private static final String FITXER_PERSONES = "persones.csv";

    public static void mostrarUsuaris() {
        try (BufferedReader br = new BufferedReader(new FileReader(FITXER_PERSONES))) {
            String linia;
            System.out.println("Llista d'usuaris:");
            while ((linia = br.readLine()) != null) {
                String[] dades = linia.split(",");
                System.out.println("Usuari: " + dades[1] + " " + dades[2] + " (DNI: " + dades[3] + ")");
            }
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer: " + e.getMessage());
        }
    }

    public static void eliminarUsuari(String dni) {
        File fitxerOriginal = new File(FITXER_PERSONES);
        File fitxerTemporal = new File("temp_persones.csv");
        boolean eliminat = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fitxerOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fitxerTemporal))) {

            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dades = linia.split(",");
                if (dades.length > 3 && dades[3].equals(dni)) {
                    if (dades[0].equalsIgnoreCase("Administrador")) {
                        System.out.println("No pots eliminar un administrador!");
                        bw.write(linia + "\n"); // Manté admins
                    } else {
                        eliminat = true;
                        System.out.println("Usuari amb DNI " + dni + " eliminat.");
                    }
                } else {
                    bw.write(linia + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error processant el fitxer: " + e.getMessage());
        }

        if (eliminat) {
            if (!fitxerOriginal.delete() || !fitxerTemporal.renameTo(fitxerOriginal)) {
                System.err.println("Error actualitzant el fitxer.");
            }
        } else {
            fitxerTemporal.delete();
            System.out.println("No s'ha trobat cap usuari amb DNI " + dni);
        }
    }

    public static void menuGestorUsuaris() {
        while (true) {
            System.out.println("\n--- Gestor d'Usuaris ---");
            System.out.println("1. Mostrar usuaris");
            System.out.println("2. Eliminar usuari");
            System.out.println("3. Sortir");
            System.out.print("Opció: ");

            int opcio = ErrorChecker.checkIntPos(3);
            Scanner scan  = new Scanner(System.in);
            switch (opcio) {
                case 1:
                    mostrarUsuaris();
                    break;
                case 2:
                    System.out.print("Introdueix el DNI de l'usuari a eliminar: ");
                    String dni = scan.nextLine();
                    eliminarUsuari(dni);
                    break;
                case 3:
                    System.out.println("Sortint del gestor d'usuaris.");
                    return;
                default:
                    System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }
    }
}
