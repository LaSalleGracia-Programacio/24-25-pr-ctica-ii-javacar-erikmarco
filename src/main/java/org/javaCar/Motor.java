package org.javaCar;

import java.util.Random;

public class Motor {
    //Declaració de variables
    private int potencia;
    Random rand = new Random();
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

    private double emissionsCO = 0.0;
    private double emissionsTHC = 0.0;
    private double emissionsNMHC = 0.0;
    private double emissionsNOx = 0.0;
    private double emissionsHC_NOx = 0.0;
    private double emissionsPM = 0.0;
    private byte emissionsPN = 0;
    private byte rangHibrid = 0;
    private int anyConstruccio = 0;

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
        this.tipus = tipus;
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
        switch (tipus) {
           case "Gasolina" -> this.tipus = 'g';
           case "Diesel" -> this.tipus='d';
           case "Hibrid" -> this.tipus='h';
           case "Hibrid Endollable" -> this.tipus= 'p';
           case "GLP" -> this.tipus ='l';
           case "Gas Natural" -> this.tipus ='n';
           case "Electric" -> this.tipus='e';
       }
       this.potencia = potencia;
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


    public double getEmissionsCO() {
        return emissionsCO;
    }

    public void setEmissionsCO(double emissionsCO) {
        this.emissionsCO = emissionsCO;
    }

    public double getEmissionsTHC() {
        return emissionsTHC;
    }

    public void setEmissionsTHC(double emissionsTHC) {
        this.emissionsTHC = emissionsTHC;
    }

    public double getEmissionsNMHC() {
        return emissionsNMHC;
    }

    public void setEmissionsNMHC(double emissionsNMHC) {
        this.emissionsNMHC = emissionsNMHC;
    }

    public double getEmissionsNOx() {
        return emissionsNOx;
    }

    public void setEmissionsNOx(double emissionsNOx) {
        this.emissionsNOx = emissionsNOx;
    }

    public double getEmissionsHC_NOx() {
        return emissionsHC_NOx;
    }

    public void setEmissionsHC_NOx(double emissionsHC_NOx) {
        this.emissionsHC_NOx = emissionsHC_NOx;
    }

    public double getEmissionsPM() {
        return emissionsPM;
    }

    public void setEmissionsPM(double emissionsPM) {
        this.emissionsPM = emissionsPM;
    }

    public byte getEmissionsPN() {
        return emissionsPN;
    }

    public void setEmissionsPN(byte emissionsPN) {
        this.emissionsPN = emissionsPN;
    }

    public byte getRangHibrid() {
        return rangHibrid;
    }

    public void setRangHibrid(byte rangHibrid) {
        this.rangHibrid = rangHibrid;
    }

    public int getAnyConstruccio() {
        return anyConstruccio;
    }

    public void setAnyConstruccio(int anyConstruccio) {
        this.anyConstruccio = anyConstruccio;
    }
}
