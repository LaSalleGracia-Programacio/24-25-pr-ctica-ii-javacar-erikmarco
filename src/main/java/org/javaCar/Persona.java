package org.javaCar;

public abstract class Persona {

    protected String nom;
    protected String cognom;
    protected String dni;
    protected String correu;
    protected String contrasenya;

    public Persona(String nom, String cognom, String dni, String correu, String contrasenya) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.correu = correu;
        this.contrasenya = contrasenya;
    }

    public String obtenirNom() {
        return nom;
    }

    public String obtenirCognom() {
        return cognom;
    }

    public String obtenirDni() {
        return dni;
    }

    public String obtenirCorreu() {
        return correu;
    }

    public String obtenirContrasenya() {
        return contrasenya;
    }

    public abstract String toCSV();
}
