package org.javaCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LlistaVehicles implements ErrorChecker {
    public static List<Vehicle> vehicles = new ArrayList<>();

    public static void ordenarVehicles() {
        int opcio = ErrorChecker.checkIntPos(4);
        System.out.print("Ordenant vehicles per");
        boolean asc = ErrorChecker.checkIntPos(2) == 1;
        Comparator<Vehicle> ordenar = Comparator.comparing(Vehicle::getMatricula);
        switch (opcio) {
            case 1 -> {
                System.out.print(" preu base");
                ordenar = Comparator.comparing(Vehicle::getPreuBase).thenComparing(Vehicle::getMatricula);
            }
            case 2 -> {
                System.out.print(" potència");
                ordenar = Comparator.comparingInt(Vehicle::getPotencia).thenComparing(Vehicle::getMatricula);
            }
            case 3 -> {
                System.out.print(" distintiu ambiental");
                ordenar = Comparator.comparing(Vehicle::getDistintiuAmbiental).thenComparing(Vehicle::getMatricula);
            }
            case 4 -> {
                System.out.print(" distintiu ambiental");

                List<DistintiusAmbientals> sortOrder = Arrays.asList(
                        DistintiusAmbientals.NULL,
                        DistintiusAmbientals.B,
                        DistintiusAmbientals.C,
                        DistintiusAmbientals.ECO,
                        DistintiusAmbientals.ZERO
                );
                ordenar = Comparator.comparing(vehicle -> sortOrder.indexOf(vehicle.getDistintiuAmbiental()));
            }
        }
        System.out.print(" de manera");
        if (asc) {
            System.out.println(" ascendent...");
            vehicles.sort(ordenar.reversed());
        } else {
            System.out.println(" descendent...");
            vehicles.sort(ordenar);
        }
    }
    public static void mostrarLlista() {
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    public static void afegirVehicle() {
        int opcio = ErrorChecker.checkIntPos(3);
        switch (opcio) {
            case 1 -> {
                System.out.print("Introdueix la matricula del vehicle: ");
                String matricula = scan.nextLine();
                System.out.print("Introdueix la potencia: ");
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                System.out.print("Introdueix el tipus de vehicle: ");
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                System.out.print("Introdueix el numero de persones: ");
                int persones = ErrorChecker.checkIntPos(9);
                System.out.print("Introdueix el numero de rodes: ");
                int nRodes = ErrorChecker.checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                System.out.println("Són totes les rodes iguals?");
                boolean rodesIguals = ErrorChecker.checkIntPos(2) == 1;
                if (rodesIguals) {
                    System.out.println("Introdueix la marca de roda");
                    String marca = scan.nextLine();
                    System.out.println("Introdueix el diametre de la roda");
                    int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                    for (int i = 0; i < rodes.length; i++) {
                        rodes[i] = new Roda(marca, diametre);
                    }
                } else {
                    for (int i = 0; i < rodes.length; i++) {
                        System.out.println("Marca de la roda " + (i + 1) + ": ");
                        String marca = scan.nextLine();
                        System.out.println("Diàmetre de la roda " + (i + 1) + ": ");
                        int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                        rodes[i] = new Roda(marca, diametre);
                    }

                }
                System.out.print("Introdueix el preu base: ");
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                System.out.print("Introdueix la marca: ");
                String marca = scan.nextLine();
                System.out.println("Introdueix el model: ");
                String model = scan.nextLine();
                vehicles.add(new Cotxe(matricula, marca, model, preuBase, persones, motor, rodes));
                try {
                    vehicles.get(vehicles.size()-1).assignarDistintiuAmbiental(vehicles.get(vehicles.size()-1).getMotorPure());
                } catch (Exception e) {
                    System.out.println("Error assignant distintiu ambiental. Motor invalid.");
                    ErrorLogger.logError(e);
                }
            }
            case 2 -> {
                String matricula = scan.nextLine();
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                int cilindrada = ErrorChecker.checkIntPos(2000);
                int nRodes = ErrorChecker.checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                boolean rodesIguals = ErrorChecker.checkIntPos(2) == 1;
                if (rodesIguals) {
                    String marca = scan.nextLine();
                    int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                }
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                String marca = scan.nextLine();
                String model = scan.nextLine();
                vehicles.add(new Moto(matricula, marca, model, preuBase, cilindrada, motor, rodes));
                try {
                    vehicles.get(vehicles.size()-1).assignarDistintiuAmbiental(vehicles.get(vehicles.size()-1).getMotorPure());
                } catch (Exception e) {
                    System.out.println("Error assignant distintiu ambiental. Motor invalid.");
                    ErrorLogger.logError(e);
                }
            }
            default -> {
                String matricula = scan.nextLine();
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                int capacitatCarrega = ErrorChecker.checkIntPos(3500);
                int nRodes = ErrorChecker.checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                boolean rodesIguals = ErrorChecker.checkIntPos(2) == 1;
                if (rodesIguals) {
                    String marca = scan.nextLine();
                    int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                }
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                String marca = scan.nextLine();
                String model = scan.nextLine();
                vehicles.add(new Furgoneta(matricula, marca, model, preuBase, capacitatCarrega, motor, rodes));
                try {
                    vehicles.get(vehicles.size()-1).assignarDistintiuAmbiental(vehicles.get(vehicles.size()-1).getMotorPure());
                } catch (Exception e) {
                    System.out.println("Error assignant distintiu ambiental. Motor invalid.");
                    ErrorLogger.logError(e);
                }
            }
        }
    }


    public static void filtrarPotencia() {
        System.out.println("Potencia - 1");
        byte opt = 1;
        switch (opt) {
            case 1 -> {
                boolean minMax = ErrorChecker.checkIntPos(1) == 1;
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                if (minMax) {
                    for (Vehicle v : vehicles) {
                        if (v.getPotencia() >= potencia) {
                            System.out.println(v.toString());
                        }
                    }
                } else {
                    for (Vehicle v : vehicles) {
                        if (v.getPotencia() < potencia) {
                            System.out.println(v.toString());
                        }
                    }
                }
            }
        }
    }

    public static void filtrarPersones() {
        System.out.println("Filtrar per nombre de places:");
        System.out.println("1. Igual o més");
        System.out.println("2. Menys");
        boolean minMax = ErrorChecker.checkIntPos(2) == 1;

        System.out.print("Introdueix el nombre de places: ");
        int persones = ErrorChecker.checkIntPos(Integer.MAX_VALUE);

        for (Vehicle v : vehicles) {
            int places = v.getNumPlaces();

            if (places != -1) {
                if (minMax && places >= persones) {
                    System.out.println(v);
                } else if (!minMax && places < persones) {
                    System.out.println(v);
                }
            }
        }
    }

    public static void filtrarTipusVehicle() {
        System.out.println("Filtrar per tipus de vehicle:");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");
        int opcio = ErrorChecker.checkIntPos(3);

        String tipus = switch (opcio) {
            case 1 -> "Cotxe";
            case 2 -> "Moto";
            case 3 -> "Furgoneta";
            default -> "";
        };

        System.out.println("Mostrant vehicles de tipus: " + tipus);

        for (Vehicle v : vehicles) {
            if (v.getClass().getSimpleName().equals(tipus)) {
                System.out.println(v);
            }
        }
    }

    public static void filtrarDistintiuAmbiental() {
        System.out.println("Filtrar per distintiu ambiental:");
        System.out.println("1. NULL");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. ECO");
        System.out.println("5. ZERO");
        System.out.print("Opció: ");

        int opcio = ErrorChecker.checkIntPos(5);
        DistintiusAmbientals distintiuSeleccionat;

        switch (opcio) {
            case 1 -> distintiuSeleccionat = DistintiusAmbientals.NULL;
            case 2 -> distintiuSeleccionat = DistintiusAmbientals.B;
            case 3 -> distintiuSeleccionat = DistintiusAmbientals.C;
            case 4 -> distintiuSeleccionat = DistintiusAmbientals.ECO;
            case 5 -> distintiuSeleccionat = DistintiusAmbientals.ZERO;
            default -> {
                System.out.println("Opció no vàlida.");
                return;
            }
        }

        System.out.println("Vehicles amb distintiu " + distintiuSeleccionat + ":");
        int comptador = 0;

        for (Vehicle v : vehicles) {
            if (v.getDistintiuAmbiental() == distintiuSeleccionat) {
                System.out.println(v);
                comptador++;
            }
        }

        if (comptador == 0) {
            System.out.println("No s'han trobat vehicles amb aquest distintiu.");
        }
    }


    public void eliminarVehicle(String matricula) {
        vehicles.removeIf(vehicle -> vehicle.getMatricula().equals(matricula));
    }
}
