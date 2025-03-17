package org.JavaCar;

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

    //Getters i setters
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public void setTipus(char tipus) {
        this.tipus = tipus;
    }
    public int getPotencia() {
        return potencia;
    }
    public char getTipus() {
        return tipus;
    }

    //Constructor amb paràmetes
    public Motor(int potencia, char tipus) {
        this.potencia = potencia;
        this.tipus = tipus;
    }

    //Constructor per defecte
    public Motor() {
        this(0, (char) 0);
    }

    @Override
    public String toString() {
        return "Motor{" + "potencia = " + potencia + ", tipus = " + tipus + '}';
    }


}
