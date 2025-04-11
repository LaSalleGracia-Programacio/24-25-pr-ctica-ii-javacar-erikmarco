package org.javaCar;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LlistaVehicles implements ErrorChecker {
    public static List<Vehicle> vehicles = new ArrayList<>();

    public static void init(String filePath) {
        vehicles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String vehicleType = parts[0];
                String matricula = parts[1];
                boolean esLlogat = Boolean.parseBoolean(parts[2]);
                int diesLlogats = Integer.parseInt(parts[3]);
                Instant dataAddicio = Instant.parse(parts[4]);
                String marca = parts[5];
                String model = parts[6];
                int potencia = Integer.parseInt(parts[7]);
                String tipusMotor = parts[8];
                String marcaRoda = parts[9];
                int diametreRoda = Integer.parseInt(parts[10]);
                DistintiusAmbientals distintiuAmbiental = DistintiusAmbientals.valueOf(parts[11]);
                double preuBase = Double.parseDouble(parts[12]);

                Motor motor = new Motor(tipusMotor, potencia);
                Roda rodes = new Roda(); // Assuming 4 wheels for simplicity

                switch (vehicleType) {
                    case "Cotxe" -> vehicles.add(new Cotxe(matricula, marca, model, preuBase, diesLlogats, motor, rodes));
                    case "Moto" -> vehicles.add(new Moto(matricula, marca, model, preuBase, diesLlogats, motor, rodes));
                    case "Furgoneta" -> vehicles.add(new Furgoneta(matricula, marca, model, preuBase, diesLlogats, motor, rodes));
                }

                Vehicle vehicle = vehicles.get(vehicles.size() - 1);
                vehicle.setDataAddicio(dataAddicio);
                vehicle.assignarDistintiuAmbiental(motor);
            }
        } catch (Exception e) {
            System.out.println("Error llegint el fitxer: " + e.getMessage());
            ErrorLogger.logError(e);
        }
    }



    public static void ordenarVehicles() {
        System.out.println("""
                1. Preu Base
                2. Potencia
                3. Distintiu Ambiental
                """);
        int opcio = ErrorChecker.checkIntPos(3);
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
        init("vehiclesLlogats.csv");
        AdministradorLloguer.generarFitxer("vehiclesLlogats.csv");
        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

    public static void afegirVehicle() {
        System.out.println("""
                Tipus de vehicle:
                1 - Cotxe
                2 - Moto
                3 - Furgoneta
                """);
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
                System.out.println("Introdueix la marca de les rodes: ");
                String marcaRoda = scan.nextLine();
                System.out.println("Introdueix el diametre de les rodes: ");
                int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                Roda roda = new Roda(marcaRoda, diametre);
                System.out.print("Introdueix el preu base: ");
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                System.out.print("Introdueix la marca: ");
                String marca = scan.nextLine();
                System.out.println("Introdueix el model: ");
                String model = scan.nextLine();
                vehicles.add(new Cotxe(matricula, marca, model, preuBase, persones, motor, roda));
                try {
                    vehicles.get(vehicles.size()-1).assignarDistintiuAmbiental(vehicles.get(vehicles.size()-1).getMotorPure());
                } catch (Exception e) {
                    System.out.println("Error assignant distintiu ambiental. Motor invalid.");
                    ErrorLogger.logError(e);
                }
            }
            case 2 -> {
                System.out.println("matricula");
                String matricula = scan.nextLine();
                System.out.println("potencia");
                int potencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
                System.out.println("tipus motor");
                String combustible = scan.nextLine();
                Motor motor = new Motor(combustible, potencia);
                System.out.println("cilindrada");
                int cilindrada = ErrorChecker.checkIntPos(2000);
                System.out.println("mdoe roda");
                String rodaMod = scan.nextLine();
                System.out.println("diametre");
                int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                Roda roda = new Roda(rodaMod, diametre);
                double preuBase = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
                String marca = scan.nextLine();
                String model = scan.nextLine();
                vehicles.add(new Moto(matricula, marca, model, preuBase, cilindrada, motor, roda));
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
                System.out.println("marca rodes");
                String marcaRoda = scan.nextLine();
                System.out.println("diametre rodes");
                int diametre = ErrorChecker.checkIntPos(Byte.MAX_VALUE);
                Roda rodes = new Roda(marcaRoda, diametre);
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
                System.out.println("Minima: 1. Maxima: 2.");
                boolean minMax = ErrorChecker.checkIntPos(2) == 1;
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
            if (v instanceof Cotxe cotxe) {
                int places = cotxe.getNumPlaces();

                if (minMax && places >= persones) {
                    System.out.println(cotxe);
                } else if (!minMax && places < persones) {
                    System.out.println(cotxe);
                }
            }
        }
    }

    public static void filtrarCilindrada() {
        System.out.println("Filtrar per cilindrada:");
        System.out.println("1. Igual o més");
        System.out.println("2. Menys");
        boolean minMax = ErrorChecker.checkIntPos(2) == 1;

        System.out.print("Introdueix la cilindrada: ");
        int persones = ErrorChecker.checkIntPos(Integer.MAX_VALUE);

        for (Vehicle v : vehicles) {
            if (v instanceof Moto moto) {
                int places = moto.getCilindrada();

                if (minMax && places >= persones) {
                    System.out.println(moto.toString());
                } else if (!minMax && places < persones) {
                    System.out.println(moto.toString());
                }
            }
        }
    }
    public static void filtrarCarrega() {
        System.out.println("Filtrar per capacitat de càrrega:");
        System.out.println("1. Igual o més");
        System.out.println("2. Menys");
        boolean minMax = ErrorChecker.checkIntPos(2) == 1;

        System.out.print("Introdueix la cilindrada: ");
        int persones = ErrorChecker.checkIntPos(Integer.MAX_VALUE);

        for (Vehicle v : vehicles) {
            if (v instanceof Furgoneta furgo) {
                int places = furgo.getCapacitatCarga();

                if (minMax && places >= persones) {
                    System.out.println(furgo.toString());
                } else if (!minMax && places < persones) {
                    System.out.println(furgo.toString());
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

    public static void modificarVehicle() {
        System.out.print("Introdueix la matrícula del vehicle a modificar: ");
        String matricula = scan.nextLine();

        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle no trobat.");
            return;
        }

        System.out.println("Vehicle trobat: " + vehicle);

        // Modificar potència
        System.out.print("Introdueix nova potència (actual: " + vehicle.getPotencia() + "): ");
        int novaPotencia = ErrorChecker.checkIntPos(Integer.MAX_VALUE);
        vehicle.getMotorPure().setPotencia(novaPotencia);

        // Modificar preu base
        System.out.print("Introdueix nou preu base (actual: " + vehicle.getPreuBase() + "): ");
        double nouPreu = ErrorChecker.checkDoublePos(Double.MAX_VALUE);
        vehicle.setPreuBase(nouPreu);

        // Modificar marca
        System.out.print("Introdueix nova marca (actual: " + vehicle.getMarca() + "): ");
        String novaMarca = scan.nextLine();
        vehicle.setMarca(novaMarca);

        // Modificar model
        System.out.print("Introdueix nou model (actual: " + vehicle.getModel() + "): ");
        String nouModel = scan.nextLine();
        vehicle.setModel(nouModel);

        // Reassignar distintiu ambiental
        try {
            vehicle.assignarDistintiuAmbiental(vehicle.getMotorPure());
        } catch (Exception e) {
            System.out.println("Error en reassignar distintiu ambiental.");
            ErrorLogger.logError(e);
        }

        System.out.println("Vehicle modificat correctament.");
    }



    public static void eliminarVehicle(String matricula) {
        vehicles.removeIf(vehicle -> vehicle.getMatricula().equals(matricula));
    }
}
