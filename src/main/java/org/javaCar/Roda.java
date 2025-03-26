package org.javaCar;

public class Roda {
    //Declaració de variables
    private String marca;
    private int diametre;

    //Getters i setters

    /**
     * Getter de la marca d'una roda
     * @return La marca de la roda
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Setter de la marca d'una roda. Només s'hauria de fer servir en cas que s'hagi declarat erròniament.
     * @param marca La nova marca de la roda.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter del diàmetre d'una roda.
     * @return El diàmetre de la roda.
     */
    public int getDiametre() {
        return diametre;
    }

    /**
     * Setter del diàmetre d'una roda. Només s'hauria de fer servir en cas que s'hagi declarat erròniament.
     * @param diametre El nou diàmetre de la roda.
     */
    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    @Override
    public String toString() {
        return "Roda{" + "marca = " + marca + "| diametre = " + diametre + '}';
    }

    /**
     * Constructor per paràmetres d'una roda
     * @param marca
     * @param diametre
     */
    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    /**
     * Constructor per defecte d'una roda
     */
    public Roda() {
        this(null, 0);
    }
}
