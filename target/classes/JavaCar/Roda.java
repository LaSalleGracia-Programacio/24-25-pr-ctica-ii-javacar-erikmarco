package org.JavaCar;

public class Roda {
    //Declaració de variables
    private String marca;
    private int diametre;

    //Getters i setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getDiametre() {
        return diametre;
    }
    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    //Constructor amb paràmetres
    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    //Constructor per defecte
    public Roda() {
        this(null, 0);
    }
}
