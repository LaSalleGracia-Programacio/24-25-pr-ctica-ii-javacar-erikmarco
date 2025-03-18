package org.javaCar;

public class Motor {
    //Declaració de variables
    private int potencia;
    private char tipus;
    /*
     * Segons el caràcter assignat:
     * h: híbrid (HEV)
     * p: híbrid endollable (PHEV)
     * e: elèctric (BEV)
     * d: dièsel
     * g: gasolina
     * n: gas natural (GNC)
     * l: gas liquat de petroli (GLP)
     */

    /**
     * Setter de la potència d'un motor. Només s'hauria de fer servir en cas que s'hagi declarat erròniament.
     * @param potencia La nova potència del motor.
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     * Setter del tipus de combustible d'un motor. Només s'hauria de fer servir en cas que s'hagi declarat erròniament.
     * @param tipus El nou tipus de combustible del motor.
     */
    public void setTipus(char tipus) {
        tipus = tipus;
    }

    /**
     * Getter de la potència d'un motor.
     * @return La potència del motor.
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Getter del tipus de combustible d'un motor.
     * @return El tipus de combustible del motor.
     */
    public char getTipus() {
        return tipus;
    }

    /**
     * Constructor amb paràmetres del motor.
     * @param potencia
     * @param tipus
     */
    public Motor(int potencia, char tipus) {
        this.potencia = potencia;
        this.tipus = tipus;
    }

    /**
     * Constructor per defecte del motor.
     */
    public Motor() {
        this(0, (char) 0);
    }

    @Override
    public String toString() {
        return "Motor{" + "potencia = " + potencia + ", tipus = " + tipus + '}';
    }


}
