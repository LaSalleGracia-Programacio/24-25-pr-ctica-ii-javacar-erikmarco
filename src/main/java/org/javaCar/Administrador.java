package org.javaCar;

public class Administrador extends Persona {
    private String nivellAcces;

    public Administrador(String nom, String cognom, String dni, String correu, String contrasenya, String nivellAcces) {
        super(nom, cognom, dni, correu, contrasenya);
        this.nivellAcces = nivellAcces;
    }

    public String obtenirNivellAcces() {
        return nivellAcces;
    }

    @Override
    public String getTipusPersona() {
        return "Administrador";
    }

    @Override
    public String toCSV() {
        return "Administrador," + nom + "," + cognom + "," + dni + "," + correu + "," + contrasenya + "," + nivellAcces;
    }
}
