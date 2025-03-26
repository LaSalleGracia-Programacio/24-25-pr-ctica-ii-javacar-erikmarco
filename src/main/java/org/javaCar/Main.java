package org.javaCar;

import java.text.DecimalFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.javaCar.*;

public class Main {
    public static final DecimalFormat euros = new DecimalFormat("0.00 €");
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter("persones.csv", true)) {
            System.out.println("Quin tipus de persona vols registrar? (admin/user): ");
            String tipus = scanner.nextLine();

            System.out.print("Nom: ");
            String nom = scanner.nextLine();

            System.out.print("Cognom: ");
            String cognom = scanner.nextLine();

            System.out.print("DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.println("Contrasenya: ");
            String contrasenya = scanner.nextLine();

            Persona persona;

            if (tipus.equalsIgnoreCase("admin")) {
                System.out.print("Nivell d'accés: ");
                String nivellAcces = scanner.nextLine();
                persona = new Administrador(nom, cognom, dni, email, contrasenya, nivellAcces);
            } else {
                System.out.print("Telèfon: ");
                String telefon = scanner.nextLine();
                persona = new Usuari(nom, cognom, dni, email, contrasenya, telefon);
            }

            writer.write(persona.toCSV() + "\n");
            System.out.println("Persona registrada correctament!");

        } catch (IOException e) {
            System.err.println("Error escrivint al fitxer: " + e.getMessage());
        }
    }

    }
