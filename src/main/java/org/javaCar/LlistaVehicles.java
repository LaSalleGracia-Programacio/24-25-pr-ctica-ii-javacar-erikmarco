package org.javaCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LlistaVehicles implements ErrorChecker {
    public List<Vehicle> vehicles = new ArrayList<>();

    public void ordenarVehicles() {
        int opcio = checkIntPos(4);
        System.out.print("Ordenant vehicles per");
        boolean asc = checkIntPos(2) == 1;
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
    public void mostrarLlista() {
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    public void afegirVehicle() {
        int opcio = checkIntPos(3);
        switch (opcio) {
            case 1 -> {
                String matricula = scan.nextLine();
                int potencia = checkIntPos(Integer.MAX_VALUE);
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                int persones = checkIntPos(9);
                int nRodes = checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                boolean rodesIguals = checkIntPos(2) == 1;
                if (rodesIguals) {
                    String marca = scan.nextLine();
                    int diametre = checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = checkIntPos(Byte.MAX_VALUE);
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                }
                double preuBase = checkDoublePos(Double.MAX_VALUE);
                String marca = scan.nextLine();
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
                int potencia = checkIntPos(Integer.MAX_VALUE);
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                int cilindrada = checkIntPos(2000);
                int nRodes = checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                boolean rodesIguals = checkIntPos(2) == 1;
                if (rodesIguals) {
                    String marca = scan.nextLine();
                    int diametre = checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = checkIntPos(Byte.MAX_VALUE);
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                }
                double preuBase = checkDoublePos(Double.MAX_VALUE);
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
                int potencia = checkIntPos(Integer.MAX_VALUE);
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                int capacitatCarrega = checkIntPos(3500);
                int nRodes = checkIntPos(10);
                Roda[] rodes = new Roda[nRodes];
                boolean rodesIguals = checkIntPos(2) == 1;
                if (rodesIguals) {
                    String marca = scan.nextLine();
                    int diametre = checkIntPos(Byte.MAX_VALUE);
                    for (Roda roda : rodes) {
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                } else {
                    for (Roda roda : rodes) {
                        String marca = scan.nextLine();
                        int diametre = checkIntPos(Byte.MAX_VALUE);
                        roda.setMarca(marca);
                        roda.setDiametre(diametre);
                    }
                }
                double preuBase = checkDoublePos(Double.MAX_VALUE);
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
