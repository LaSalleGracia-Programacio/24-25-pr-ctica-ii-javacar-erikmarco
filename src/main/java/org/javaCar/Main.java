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

                        boolean tancarSessio = false;

                        while (!tancarSessio) {
                            String tipus = persona.getTipusPersona();

                            if (tipus.equals("Administrador")) {
                                System.out.println("\n--- MENÚ ADMINISTRADOR ---");
                                System.out.println("1. Afegir un vehicle nou");
                                System.out.println("2. Veure llista d’usuaris");
                                System.out.println("3. Consultar llista de vehicles");
                                System.out.println("4. Tancar sessió");
                                System.out.print("Opció: ");
                                String opcioAdmin = scanner.nextLine();

                                switch (opcioAdmin) {
                                    case "1":
                                        System.out.println("Funció per afegir vehicle (pendent d'implementar)");
                                        break;
                                    case "2":
                                        System.out.println("Funció per veure usuaris (pendent d'implementar)");
                                        break;
                                    case "3":
                                        System.out.println("Sessió tancada.");
                                        tancarSessio = true;
                                        break;
                                    default:
                                        System.out.println("Opció no vàlida.");
                                }

                            } else if (tipus.equals("Usuari")) {
                                System.out.println("\n--- MENÚ USUARI ---");
                                System.out.println("1. Veure vehicles disponibles");
                                System.out.println("2. Llogar un vehicle");
                                System.out.println("3. Tancar sessió");
                                System.out.print("Opció: ");
                                String opcioUsuari = scanner.nextLine();

                                switch (opcioUsuari) {
                                    case "1":
                                        System.out.println("Funció per veure vehicles (pendent d'implementar)");
                                        break;
                                    case "2":
                                        System.out.println("Funció per llogar vehicle (pendent d'implementar)");
                                        break;
                                    case "3":
                                        System.out.println("Sessió tancada.");
                                        tancarSessio = true;
                                        break;
                                    default:
                                        System.out.println("Opció no vàlida.");
                                }
                            }
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
