package org.javaCar;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static final DecimalFormat euros = new DecimalFormat("0.00 €");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sortir = false;

        System.out.println("Benvingut a JavaCar!");

        while (!sortir) {
            System.out.println(" MENÚ PRINCIPAL ");
            System.out.println("1. Registrar-se");
            System.out.println("2. Iniciar sessió");
            System.out.println("3. Sortir");
            System.out.print("Opció: ");
            String opcio = scanner.nextLine();

            switch (opcio) {
                case "1":
                    Persona.registrarPersona(scanner);
                    break;

                case "2":
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();

                    System.out.print("Contrasenya: ");
                    String contrasenya = scanner.nextLine();

                    Persona persona = Login.iniciarSessio(nom, contrasenya);

                    if (persona != null) {
                        System.out.println("\nSessió iniciada correctament. Benvingut/da, " + persona.obtenirNom() + "!");

                        if (persona instanceof Administrador) {
                            System.out.println("Ets un administrador amb nivell d'accés: " + ((Administrador) persona).obtenirNivellAcces());
                        } else if (persona instanceof Usuari) {
                            System.out.println("Ets un usuari amb telèfon: " + ((Usuari) persona).obtenirTelefon());
                        }

                    } else {
                        System.out.println("Nom o contrasenya incorrectes.");
                    }
                    break;

                case "3":
                    System.out.println("Sortint del programa...");
                    sortir = true;
                    break;

                default:
                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
            }
        }

        scanner.close();
    }
}
