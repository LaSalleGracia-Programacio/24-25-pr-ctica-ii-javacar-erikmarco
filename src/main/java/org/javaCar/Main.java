package org.javaCar;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static final DecimalFormat euros = new DecimalFormat("0.00 €");

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean sortir = false;

        System.out.println("Benvingut a JavaCar!");

        while (!sortir) {
            System.out.println(" MENÚ PRINCIPAL ");
            System.out.println("1. Registrar-se");
            System.out.println("2. Iniciar sessió");
            System.out.println("3. Sortir");
            System.out.print("Opció: ");
            int opcio = ErrorChecker.checkIntPos(3);

            switch (opcio) {
                case 1:
                    Persona.registrarPersona(scanner);
                    break;

                case 2:
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
                                int opcioAdmin = ErrorChecker.checkIntPos(6);

                                switch (opcioAdmin) {
                                    case 1:
                                        LlistaVehicles.afegirVehicle();
                                    break;
                                    case 2:
                                        System.out.println("");
                                    break;
                                    case 3:
                                        System.out.println("");
                                    break;
                                    case 4:
                                        System.out.println("");
                                    break;
                                    case 5:
                                        System.out.println("Benvingut al gestor d'usuaris");
                                        System.out.println("1. Veure llista d'usuaris");
                                        System.out.println("2. Eliminar usuari");
                                        System.out.print("Opció: ");
                                        boolean opcioGestor = ErrorChecker.checkIntPos(2) == 1;
                                        if (!opcioGestor) System.out.println("Eliminar usuari");
                                        else System.out.println("Veure llista d'usuaris");
                                    break;
                                    case 6:
                                        System.out.println("Sessió tancada.");
                                        tancarSessio = true;
                                    break;
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
                                    int opcioUsuari = ErrorChecker.checkIntPos(3);

                                    switch (opcioUsuari) {
                                        case 1:
                                            System.out.println("Benvingut al buscador de vehicles disponibles.");
                                            System.out.println("1. Veure la llista de vehicles");
                                            System.out.println("2. Filtrar vehicles");
                                            System.out.print("Opció: ");
                                            boolean opcioBuscar = ErrorChecker.checkIntPos(2) == 1;
                                            if (opcioBuscar) LlistaVehicles.mostrarLlista();
                                            else {
                                                    boolean tornarFiltrar = false;
                                                    while (!tornarFiltrar) {
                                                        System.out.println("\n--- MENÚ DE FILTRATGE DE VEHICLES ---");
                                                        System.out.println("1. Filtrar per potència");
                                                        System.out.println("2. Filtrar per nombre de places");
                                                        System.out.println("3. Filtrar per tipus de vehicle");
                                                        System.out.println("4. Filtrar per distintiu ambiental");
                                                        System.out.println("5. Tornar al menú de l'usuari");
                                                        System.out.print("Opció: ");

                                                        int opcioFiltre = ErrorChecker.checkIntPos(5);

                                                        switch (opcioFiltre) {
                                                            case 1 -> LlistaVehicles.filtrarPotencia();
                                                            case 2 -> LlistaVehicles.filtrarPersones();
                                                            case 3 -> LlistaVehicles.filtrarTipusVehicle();
                                                            case 4 -> LlistaVehicles.filtrarDistintiuAmbiental();
                                                            case 5 -> tornarFiltrar = true;
                                                            default -> System.out.println("Opció no vàlida.");
                                                        }
                                                    }
                                                    break;

                                            }
                                        break;
                                        case 2:
                                            System.out.println("Funció per llogar vehicle");
                                        break;
                                        case 3:
                                            System.out.println("Sessió tancada.");
                                            tornarMenuUsuari = true;
                                            tancarSessio = true;
                                        break;
                                    }
                                }
                            }
                        }

                    } else {
                        System.out.println("Nom o contrasenya incorrectes.");
                    }
                    break;

                case 3:
                    System.out.println("Sortint del programa...");
                    sortir = true;
                    break;

                default:
                    System.out.println("Opció no vàlida. Torna-ho a intentar.");
            }
        }
        LlistaVehicles.afegirVehicle();
        AdministradorLloguer.init();
        AdministradorLloguer.llogar("sdfsdf", 3);
        scanner.close();
    }

}
