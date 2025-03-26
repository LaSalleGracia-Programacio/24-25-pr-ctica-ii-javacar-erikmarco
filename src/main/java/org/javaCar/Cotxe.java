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
     * Constructor per defecte d'un cotxe.
     */
    public Cotxe() {
        this(null, null, null, 0, 0, new Motor(), new Roda[0]);
    }

    /**
     * Constructor amb paràmetres d'un cotxe
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param numPlaces
     * @param motor
     * @param rodes
     */
    public Cotxe(String matricula, String marca, String model, double preuBase, int numPlaces, Motor motor, Roda[] rodes) {
        setMatricula(matricula);
        setMarca(marca);
        setModel(model);
        setPreuBase(preuBase);
        setMotor(motor);
        setRodes(rodes);
        this.numPlaces = numPlaces;
        setDataAddicio(Instant.now());
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

