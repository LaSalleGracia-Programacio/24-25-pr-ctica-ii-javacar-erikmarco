package org.javaCar;

public class Furgoneta extends Vehicle implements Llogable{
    private int capacitatCarga;

    @Override
    public double calcularPreuFurgoneta(int dies, double preuBase, int capacitatCarga){
        if(capacitatCarga>1000){
            return dies*preuBase+ 10*dies ;
        }
        return dies*preuBase;
    }

    public int getCapacitatCarga(){
        return capacitatCarga;

    }
    public void setCapacitatCarga(int capacitatCarga){
        this.capacitatCarga = capacitatCarga;
    }

}



