package org.javaCar;

public class Moto extends Vehicle implements Llogable {
    private int cilindrada;
    /**
     * Aquest mètode calcula el preu total del lloguer d'una moto
     * @param dies el nombre de dies que es vol llogar la moto
     * @param preuBase el preu per dia de la moto sense tenir en compte cap altre sobrecàrrec
     * @param cilindrada la cilindrada de la moto
     * @return el preu total del lloguer de la moto
     */
    @Override
    public double calcularPreuMoto(int dies, double preuBase, int cilindrada) {
        if (cilindrada > 500) {
            return dies*preuBase+ 5*dies ;
        }
        return dies*preuBase;
    }

    /**
     * Getter de la cilindrada d'una moto
     * @return La cilindrada de la moto
     */
    public int getCilindrada(){
        return cilindrada;
    }

    /**
     * Setter de la cilindrada d'una moto. Només s'hauria de fer servir si la moto s'ha declarat incorrectament
     * @param cilindrada La nova cilindrada de la moto
     */
    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }

    /**
     * Constructor amb paràmetres d'una moto
     * @param matricula
     * @param marca
     * @param model
     * @param preuBase
     * @param cilindrada
     * @param motor
     * @param rodes
     */
    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes){
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.cilindrada = cilindrada;
        this.motor = motor;
        this.rodes = rodes;
    }

    /**
     * Constructor per defecte d'una moto
     */
    public Moto() {
        this(null, null, null, 0, 0, new Motor(), new Roda[0]);
    }


}
