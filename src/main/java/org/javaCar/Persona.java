package org.javaCar;

public abstract class  Persona {

    protected String nom;
    protected String cognom;
    protected String dni;
    protected String email;

    public Persona(String nom, String cognom, String dni, String email) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.email = email;
    }

    public String obtenirNom() {
        return nom; }

    public String obtenirCognom() {
        return cognom; }

    public String obtenirDni() {
        return dni; }

    public String obtenirEmail() {
        return email; }


    public abstract String toCSV();
}

