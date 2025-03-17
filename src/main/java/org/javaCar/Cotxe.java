package org.javaCar;

public class Cotxe extends Vehicle implements Llogable{
    private int numPlaces;



    public Cotxe(String matricula, String marca, String model, double preuBase, int numPlaces, Motor motor, Roda roda) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.roda = roda;
        this.numPlaces = numPlaces;
    }

    @Override
    public double calcularPreuCotxe(int dies, double preuBase) {
        return preuBase*dies;
    }
}

