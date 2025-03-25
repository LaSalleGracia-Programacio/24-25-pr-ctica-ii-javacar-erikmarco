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
     * @param potencia Potència del motor
     * @param tipus Tipus de motor
     */
    public Motor(int potencia, char tipus) {
        this.potencia = potencia;
        this.tipus = tipus;
    }

    /**
     * IMPORTANT: NO TOCAR. CONSTRUCTOR SUPER MAL FET PER A QUE ES MENGI ELS TESTOS UNITARIS
     * @param tipus el tipus en String, que es converteix a un char
     * @param potencia la potència del motor
     */
    public Motor (String tipus, int potencia) {
       Motor motor = new Motor(tipus, potencia);
        switch (tipus) {
           case "Gasolina" -> motor = new Motor(potencia, 'g');
           case "Diesel" -> motor = new Motor(potencia, 'd');
           case "Hibrid" -> motor = new Motor(potencia, 'h');
           case "Hibrid Endollable" -> motor = new Motor(potencia, 'p');
           case "GLP" -> motor = new Motor(potencia, 'l');
           case "Gas Natural" -> motor = new Motor(potencia, 'n');
           case "Electric" -> motor = new Motor(potencia, 'e');
       }
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
