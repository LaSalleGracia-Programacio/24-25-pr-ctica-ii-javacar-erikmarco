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
                                System.out.println("--- MENÚ ADMINISTRADOR ---");
                                System.out.println("1. Afegir un vehicle nou");
                                System.out.println("2. Modificar un vehicle ja existent");
                                System.out.println("3. Eliminar vehicle");
                                System.out.println("4. Consultar llista de vehicles");
                                System.out.println("5. Gestió d’usuaris");
                                System.out.println("5. Consultar balanç de beneficis");
                                System.out.println("6. Tancar sessió");
                                System.out.print("Opció: ");
                                String opcioAdmin = scanner.nextLine();

                                switch (opcioAdmin) {
                                    case "1":
                                        System.out.println("");
                                        break;
                                    case "2":
                                        System.out.println("");
                                        break;
                                    case "3":
                                        System.out.println("");
                                        break;
                                    case "4":
                                        System.out.println("");
                                        break;
                                    case "5":
                                        System.out.println("Benvingut al gestor d'usuaris");
                                        System.out.println("1. Veure llista d'usuaris");
                                        System.out.println("2. Eliminar usuari");
                                        System.out.print("Opció: ");
                                        String opcioGestor = scanner.nextLine();

                                        switch (opcioGestor) {
                                            case "1":
                                                System.out.println("");
                                                break;

                                            case "2":
                                                System.out.println("");
                                                break;
                                        }
                                        break;

                                    case "6":
                                        System.out.println("Sessió tancada.");
                                        tancarSessio = true;
                                        break;
                                    default:
                                        System.out.println("Opció no vàlida.");
                                }

                            } else if (tipus.equals("Usuari")) {
                                boolean tornarMenuUsuari = false;

                                while (!tornarMenuUsuari) {
                                    System.out.println("--- MENÚ USUARI ---");
                                    System.out.println("1. Buscar vehicles disponibles per llogar");
                                    System.out.println("2. Llogar un vehicle");
                                    System.out.println("3. Mirar historial de lloguers");
                                    System.out.println("4. Tancar sessió");
                                    System.out.print("Opció: ");
                                    String opcioUsuari = scanner.nextLine();

                                    switch (opcioUsuari) {
                                        case "1":
                                            System.out.println("Benvingut al buscador de vehicles disponibles.");
                                            System.out.println("1. Veure la llista de vehicles");
                                            System.out.println("2. Ordenar/Filtrar vehicles");
                                            System.out.print("Opció: ");
                                            String opcioBuscar = scanner.nextLine();

                                            switch (opcioBuscar) {
                                                case "1":
                                                    LlistaVehicles.mostrarLlista();
                                                    break;
                                                case "2":
                                                    LlistaVehicles.ordenarVehicles();
                                                    LlistaVehicles.mostrarLlista();
                                                    break;
                                                default:
                                                    System.out.println("Opció no vàlida.");
                                            }
                                            break;

                                        case "2":
                                            System.out.println("Funció per llogar vehicle");
                                            break;
                                        case "3":
                                            System.out.println("Sessió tancada.");
                                            tornarMenuUsuari = true;
                                            tancarSessio = true;
                                            break;
                                        default:
                                            System.out.println("Opció no vàlida.");
                                    }
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

    public static void menuPrincipal() {

    }
}
