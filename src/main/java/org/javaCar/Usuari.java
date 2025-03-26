package org.javaCar;

public class Usuari extends Persona {
    private String telefon;

    public Usuari(String nom, String cognom, String dni, String correu, String contrasenya, String telefon) {
        super(nom, cognom, dni, correu, contrasenya);
        this.telefon = telefon;
    }

    public String obtenirTelefon() {
        return telefon;
    }

    @Override
    public String getTipusPersona() {
        return "Usuari";
    }


    @Override
    public String toCSV() {
        return "Usuari," + nom + "," + cognom + "," + dni + "," + correu + "," + contrasenya + "," + telefon;
    }
}
