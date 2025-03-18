package org.javaCar;

import java.text.DecimalFormat;

/**
 * Aquesta classe és una superclasse de tots els tipus de vehicles oferits a carJava.
 */
public abstract class Vehicle implements Llogable {
    //Override de la interfície Llogable
    @Override
    public double calcularPreuCotxe (int dies, double preuBase) {
        return 0;
    }
    @Override
    public double calcularPreuMoto (int dies, double preuBase, int cilindrada) {
        return 0;
    }
    @Override
    public double calcularPreuFurgoneta (int dies, double preuBase, int capacitiatCarga) {
        return 0;
    }
    //Declaració d'atributs
    String matricula;
    String marca;
    String model;
    double preuBase;
    Motor motor;
    Roda[] rodes;
    char distintiuAmbiental;
    public static final DecimalFormat df = new DecimalFormat("0.00");


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


    //Declaració mètode per a formar el distintiu ambiental.

    /**
     * Aquest mètode assigna el distintiu ambiental del vehicle
     * @param motor El motor del vehicle
     * @throws InvalidMotorTypeException aquesta excepció es tira si el tipus de combustible que fa servir el motor no és vàlid
     */
    public void assignarDistintiuAmbiental(Motor motor) throws InvalidMotorTypeException {
        switch (motor.getTipus()) {
            case 'g', 'd':
                if (Math.random() < 0.2) {
                    this.distintiuAmbiental = 'B';
                } else if (Math.random() > 0.95) {
                    this.distintiuAmbiental = (char)0;
                } else {
                    this.distintiuAmbiental = 'C';
                }
                break;
            case 'h':
                if (Math.random() < 0.2) {
                    this.distintiuAmbiental = '0';
                } else {
                    this.distintiuAmbiental = 'E';
                }
                break;
            case 'p', 'e':
                this.distintiuAmbiental = '0';
                break;
            case 'n', 'l':
                this.distintiuAmbiental = 'E';
                break;
            default:
                throw new InvalidMotorTypeException("Tipus de motor invalid.");
        }
    }

}
