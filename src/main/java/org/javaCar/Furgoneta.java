package org.javaCar;

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
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param capacitatCarga
     * @param motor
     * @param rodes
     */
    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes){
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.capacitatCarga = capacitatCarga;
        this.motor = motor;
        this.rodes = rodes;
    }

    /**
     * Constructor per defecte d'una furgoneta
     */
    public Furgoneta() {
        this(null, null, null, 0, 0, new Motor(), new Roda[0]);
    }
}



