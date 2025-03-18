package org.javaCar;

/**
 * La interfície Llogable compta amb tots els mètodes necessaris per a calcular el preu del lloguer d'un vehicle.
 */
public interface Llogable {
    public double calcularPreuCotxe(int dies, double preuBase);

    public double calcularPreuMoto(int dies, double preuBase, int cilindrada);

    public double calcularPreuFurgoneta(int dies, double preuBase, int capacitiatCarga);
}
