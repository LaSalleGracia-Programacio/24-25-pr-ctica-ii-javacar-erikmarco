package org.javaCar;

public class Moto extends Vehicle implements Llogable {
    private int cilindrada;
    @Override
    public double calcularPreuMoto(int dies, double preuBase, int cilindrada) {
        if (cilindrada > 500) {
            return dies*preuBase+ 5*dies ;
        }
        return dies*preuBase;
    }
    public int getCilindrada(){
        return cilindrada;
    }
    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }


}
