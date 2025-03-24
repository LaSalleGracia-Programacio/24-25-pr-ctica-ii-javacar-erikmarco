package org.javaCar;

public class Usuari extends Persona {
    private String telefon;

    public Usuari(String nom, String cognom, String dni, String email, String telefon) {
        super(nom, cognom, dni, email);
        this.telefon = telefon;
    }

    public String obtenirTelefon() {
        return telefon; }

    @Override
    public String toCSV() {
        return "Usuari," + nom + "," + cognom + "," + dni + "," + email + "," + telefon;
    }
}
