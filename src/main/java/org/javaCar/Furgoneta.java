package org.javaCar;

import java.time.Instant;

public class Furgoneta extends Vehicle implements Llogable{
    private int capacitatCarga;
    /**
     * Aquest mètode calcula el preu total del lloguer d'una furgoneta
     * @param dies el nombre de dies que es vol llogar la furgoneta
     * @param preuBase el preu per dia de la furgoneta sense tenir en compte cap altre sobrecàrrec
     * @param capacitatCarga la capacitat de càrrega de la furgoneta
     * @return el preu total del lloguer de la furgoneta
     */
    @Override
    public double calcularPreuFurgoneta(int dies, double preuBase, int capacitatCarga){
        if(capacitatCarga>1000){
            return dies*preuBase+ 10*dies ;
        }
        return dies*preuBase;
    }

    /**
     * Getter de la capacitat de càrrega d'una furgoneta
     * @return la capacitat de càrrega de la furgoneta
     */
    public int getCapacitatCarga(){
        return capacitatCarga;

    }

    /**
     * Setter de la capacitat de càrrega d'una furgoneta. Només s'hauria de fer servir si la furgoneta s'ha declarat incorrectament.
     * @param capacitatCarga la capacitat de càrrega de la furgoneta
     */
    public void setCapacitatCarga(int capacitatCarga){
        this.capacitatCarga = capacitatCarga;
    }

    /**
     * Constructor amb paràmetres d'una furgoneta
     * @param matricula la matricula
     * @param marca la marca
     * @param model el model
     * @param preuBase el preu base
     * @param capacitatCarga la capacitat de carrega
     * @param motor el motor
     * @param rodes les rodes
     */
    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda rodes){
        setMatricula(matricula);
        setMarca(marca);
        setModel(model);
        setPreuBase(preuBase);
        setMotor(motor);
        setRodes(rodes);
        this.capacitatCarga = capacitatCarga;
        setDataAddicio(Instant.now());
    }

    /**
     * Constructor per defecte d'una furgoneta
     */
    public Furgoneta() {
        this(null, null, null, 0, 0, new Motor(), new Roda());
    }

    @Override
    public String toString() {
        return "Furgoneta{" +
                "capacitatCarga=" + capacitatCarga +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}



