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
                System.out.println("matricula");
                String matricula = scan.nextLine();
                System.out.println("potncia");
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                System.out.println("tipus");
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                System.out.println("persones");
                int persones = ErrorChecker.checkIntPos(9);
                System.out.println("nrodes");
                int nRodes = ErrorChecker.checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                System.out.println("rodes iguals? TEST PON 1 POR FAVOR");
                boolean rodesIguals = ErrorChecker.checkIntPos(2) == 1;
                if (rodesIguals) {
                    System.out.println("marca");
                    String marca = scan.nextLine();
                    System.out.println("diametre");
                    int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda = new Roda(marca, diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                        roda = new Roda(marca, diametre);
                    }
                }
                System.out.println("preu base");
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                System.out.println("marca");
                String marca = scan.nextLine();
                System.out.println("model");
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


    public void eliminarVehicle(String matricula) {
        vehicles.removeIf(vehicle -> vehicle.getMatricula().equals(matricula));
    }
}
