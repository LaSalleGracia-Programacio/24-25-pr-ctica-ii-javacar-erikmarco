package org.javaCar;

public abstract class Vehicle implements Llogable {
    //Override de la interfície Llogable
    @Override
    public double calcularPreu(int dies, double preuBase) {
        return preuBase*dies;
    }

    //Declaració d'atributs
    String matricula;
    String marca;
    String model;
    double preuBase;
    Motor motor;
    Roda roda;
    char distintiuAmbiental;

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
    public void assignarDistintiuAmbiental(Motor motor){
        switch (motor.getTipus()) {
            case 'g', 'd':
                if (Math.random() < 0.3) {
                    this.distintiuAmbiental = 'B';
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
