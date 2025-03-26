package org.javaCar;

import java.util.ArrayList;
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
}
