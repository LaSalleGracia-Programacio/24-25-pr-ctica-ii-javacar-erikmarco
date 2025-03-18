package org.javaCar;

public class Furgoneta extends Vehicle implements Llogable{
    private int capacitatCarga;
    /**
     * Aquest mètode calcula el preu total del lloguer d'una furgoneta
     * @param dies el nombre de dies que es vol llogar la furgoneta
     * @param preuBase el preu per dia de la furgoneta sense tenir en compte cap altre sobrecàrrec
     * @param capacitatCarga la capacitat de càrrega de la furgoneta
     * @return el preu total del lloguer de la furgoneta
     */
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



