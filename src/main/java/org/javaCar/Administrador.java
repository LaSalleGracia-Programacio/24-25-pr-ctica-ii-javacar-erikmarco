package org.javaCar;

public class Administrador extends Persona {
    private String nivellAcces;

    public Administrador(String nom, String cognom, String dni, String email, String nivellAcces) {
        super(nom, cognom, dni, email);
        this.nivellAcces = nivellAcces;
    }

    public String obtenirNivellAcces() { return nivellAcces; }

    @Override
    public String toCSV() {
        return "Administrador," + nom + "," + cognom + "," + dni + "," + email + "," + nivellAcces;
    }
}
