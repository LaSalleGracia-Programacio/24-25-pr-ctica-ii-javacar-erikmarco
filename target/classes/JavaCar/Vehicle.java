package org.JavaCar;

public abstract class Vehicle implements Llogable {
    //Override de la interfície Llogable
    @Override
    public double calcularPreu(int dies, double preuBase) {
        return preuBase*dies;
    }

    //Declaració d'atributs
    private String matricula;
    private String marca;
    private String model;
    private double preuBase;
    private Motor motor;
    private Roda roda;
    private char distintiuAmbiental;

    //Getters i setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getPreuBase() {
        return preuBase;
    }
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }
    public char getDistintiuAmbiental() {
        return distintiuAmbiental;
    }


    //Declaració mètode per a formar el distintiu ambiental. Cal actualitzar amb override a les subclasses
    public void assignarDistintiuAmbiental(Motor motor, )

}
