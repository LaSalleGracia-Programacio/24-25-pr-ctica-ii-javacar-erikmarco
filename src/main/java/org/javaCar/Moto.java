package org.javaCar;

public class Moto extends Vehicle implements Llogable {
    @Override
    public double calcularPreu(int dies, double preuBase, int cilindrada) {
        if (cilindrada > 500) {
            return dies*preuBase+ 5*dies;
        }
        return dies*preuBase;
    }
}
