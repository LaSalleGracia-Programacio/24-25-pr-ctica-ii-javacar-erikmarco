package org.JavaCar;

import org.javaCar.*;
import org.junit.Test;
import static org.junit.Assert.*;

// Classe de testos per Llogable i GestorLloguers

import java.util.ArrayList;
import java.util.List;

public class LlogableGestorTest {

    @Test
    public void testLlogableImplementacio() {
        // Create a sample vehicle (Cotxe) and check if it implements Llogable
        Vehicle cotxe = new Cotxe("1234ABC", "Toyota", "Corolla", 30, 5, new Motor("Gasolina", 120), new Roda("Michelin", 17));
        assertTrue(cotxe instanceof Llogable); // Ensure Cotxe is Llogable
    }

    @Test
    public void testCalcularIngressosTotals() {
        // Create some vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle cotxe = new Cotxe("1234ABC", "Toyota", "Corolla", 30, 5, new Motor("Gasolina", 120), new Roda("Michelin", 17));
        Vehicle moto = new Moto("5678DEF", "Yamaha", "R6", 25, 600, new Motor("Gasolina", 80), new Roda("Pirelli", 16));

        // Add vehicles to the list
        vehicles.add(cotxe);
        vehicles.add(moto);

        // Test the total revenue calculation for a 3-day rental period
        assertEquals(180, AdministradorLloguer.calcularIngressosTotals(vehicles, 3), 0.01);
    }
}
