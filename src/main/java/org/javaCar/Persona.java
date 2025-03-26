package org.javaCar;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public abstract String getTipusPersona();


    public abstract String toCSV();

    public static void registrarPersona(Scanner scanner) {
        try (FileWriter writer = new FileWriter("persones.csv", true)) {

            System.out.println("Quin tipus de persona vols registrar? (admin/user): ");
            String tipus = scanner.nextLine();

            System.out.print("Nom: ");
            String nom = scanner.nextLine();

            System.out.print("Cognom: ");
            String cognom = scanner.nextLine();

            System.out.print("DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Correu electrònic: ");
            String correu = scanner.nextLine();

            System.out.print("Contrasenya: ");
            String contrasenya = scanner.nextLine();

            Persona persona;

            if (tipus.equalsIgnoreCase("admin")) {
                System.out.print("Nivell d'accés: ");
                String nivellAcces = scanner.nextLine();
                persona = new Administrador(nom, cognom, dni, correu, contrasenya, nivellAcces);
            } else {
                System.out.print("Telèfon: ");
                String telefon = scanner.nextLine();
                persona = new Usuari(nom, cognom, dni, correu, contrasenya, telefon);
            }

            writer.write(persona.toCSV() + "\n");
            System.out.println("Persona registrada correctament!");

        } catch (IOException e) {
            System.err.println("Error escrivint al fitxer: " + e.getMessage());
        }
    }

}
