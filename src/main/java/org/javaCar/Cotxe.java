package org.javaCar;

import java.time.Instant;

public class Cotxe extends Vehicle implements Llogable{
    private int numPlaces;
    /**
     * Getter del nombre de places d'un cotxe
     * @return El nombre de places d'un cotxe
     */
    public int getNumPlaces() {
        return numPlaces;
    }

    /**
     * Setter del nombre de places d'un cotxe. Només s'hauria de fer servir si s'ha declarat erròniament.
     * @param numPlaces El nou nombre de places del cotxe.
     */
    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }



    /**
     * Constructor amb paràmetres d'un cotxe
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param places
     * @param motor
     * @param rodes
     */
    public Cotxe(String matricula, String marca, String model, double preuBase, int places, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.numPlaces = places;
        this.setMotor(motor); // motor can be null
        this.setRodes(rodes); // rodes can be null
    }
    public Cotxe(String matricula, String marca, String model, double preuBase, int numPlaces) {
        super(matricula, marca, model, preuBase);
        this.numPlaces = numPlaces;
    }

    public Cotxe() {
        super();
        this.numPlaces = 0;
    }

    /**
     * Aquest mètode calcula el preu total del lloguer d'un cotxe
     * @param dies el nombre de dies que es vol llogar el cotxe
     * @param preuBase el preu per dia del cotxe sense tenir en compte cap altre sobrecàrrec
     * @return el preu total del lloguer del cotxe
     */
    @Override
    public double calcularPreuCotxe(int dies, double preuBase) {
        return preuBase*dies;
    }
}

