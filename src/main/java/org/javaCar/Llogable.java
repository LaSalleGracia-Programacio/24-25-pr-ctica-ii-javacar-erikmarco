package org.javaCar;

public interface Llogable {
    public double calcularPreuCotxe(int dies, double preuBase);

    public double calcularPreuMoto(int dies, double preuBase, int cilindrada);

    public double calcularPreuFurgoneta(int dies, double preuBase, int capacitiatCarga);
}
