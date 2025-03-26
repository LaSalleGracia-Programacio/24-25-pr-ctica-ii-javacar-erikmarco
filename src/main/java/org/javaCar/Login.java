package org.javaCar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {

    public static Persona iniciarSessio(String nom, String contrasenya) {
        String fitxer = "persones.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(fitxer))) {
            String linia;

            while ((linia = lector.readLine()) != null) {
                String[] camp = linia.split(",");

                String tipus = camp[0];
                String nomCSV = camp[1];
                String cognom = camp[2];
                String dni = camp[3];
                String email = camp[4];
                String contrasenyaCSV = camp[5];

                if (nomCSV.equals(nom) && contrasenyaCSV.equals(contrasenya)) {
                    if (tipus.equals("Usuari")) {
                        String telefon = camp[6];
                        return new Usuari(nomCSV, cognom, dni, email, contrasenyaCSV, telefon);
                    } else if (tipus.equals("Administrador")) {
                        String nivellAcces = camp[6];
                        return new Administrador(nomCSV, cognom, dni, email, contrasenyaCSV, nivellAcces);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer: " + e.getMessage());
        }

        return null;
    }
}


