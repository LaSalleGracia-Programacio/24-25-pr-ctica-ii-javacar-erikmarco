package org.javaCar;
import java.lang.StringBuilder;
/**
 * Aquesta classe és una superclasse de tots els tipus de vehicles oferits a carJava.
 */
public abstract class Vehicle implements Llogable {
    StringBuilder sb = new StringBuilder();
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


    //Getters i setters

    /**
     * Getter de la matrícula d'un vehicle
     * @return El String corresponent a la matrícula del vehicle
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de la matrícula d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param matricula La nova matrícula del vehicle
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter de la marca d'un vehicle.
     * @return La marca del vehicle
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter de la marca d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param marca La nova marca d'un vehicle
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter del model d'un vehicle.
     * @return El model d'un vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter del model d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param model El nou model d'un vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter del preu base d'un vehicle.
     * @return El preu base d'un vehicle.
     */
    public double getPreuBase() {
        return preuBase;
    }

    /**
     * Setter del preu base d'un vehicle..
     * @param preuBase El nou preu base d'un vehicle.
     */
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    /**
     * Getter del distintiu ambiental d'un vehicle.
     * @return El distintiu ambiental d'un vehicle.
     */
    public char getDistintiuAmbiental() {
        return distintiuAmbiental;
    }

    public String getMotor() {
        return motor.toString();
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    public String getRodes() {
        sb.append("{\n");
        for (int i = 0; i < rodes.length; i++) {
            sb.append("roda ").append(i).append(": ").append(rodes[i].toString());
            if (i != rodes.length - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n}");
        return sb.toString();
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
