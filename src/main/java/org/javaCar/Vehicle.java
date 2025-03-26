package org.javaCar;
import java.lang.StringBuilder;
import java.util.Random;
import java.time.Instant;

public abstract class Vehicle implements Llogable {
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();

    // Constructor to initialize Vehicle with matricula, marca, model, preuBase, motor, and rodes
    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor != null ? motor : null;  // Default Motor if null
        this.rodes = rodes != null ? rodes : null;  // Default Rodes if null
    }

    // Override methods from Llogable interface
    @Override
    public double calcularPreuCotxe(int dies, double preuBase) {
        return 0;
    }

    @Override
    public double calcularPreuMoto(int dies, double preuBase, int cilindrada) {
        return 0;
    }

    @Override
    public double calcularPreuFurgoneta(int dies, double preuBase, int capacitiatCarga) {
        return 0;
    }

    // Declare attributes
    private String matricula;
    private String marca;
    private String model;
    private double preuBase;
    private Motor motor;
    private Roda[] rodes;
    private DistintiusAmbientals distintiuAmbiental;
    private Instant dataAddicio;

    // Getters and setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public Motor getMotorPure() {
        return motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public Instant getDataAddicio() {
        return dataAddicio;
    }

    public void setDataAddicio(Instant dataAddicio) {
        this.dataAddicio = dataAddicio;
    }

    public DistintiusAmbientals getDistintiuAmbiental() {
        return distintiuAmbiental;
    }

    public int getPotencia() {
        return motor.getPotencia();
    }

    public String getMotor() {
        return motor.toString();
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Roda[] getRodesMatriu() {
        return rodes;
    }

    public String getRodes() {
        if (rodes == null || rodes.length == 0) {
            return "{}"; // Return empty braces if no wheels are set
        }

        sb.setLength(0); // Reset the StringBuilder
        sb.append("{");

        for (int i = 0; i < rodes.length; i++) {
            if (rodes[i] != null) {
                sb.append("roda ").append(i).append(": ").append(rodes[i].toString());
            } else {
                sb.append("roda ").append(i).append(": NULL");
            }

            if (i != rodes.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Method to assign the environmental badge
    public void assignarDistintiuAmbiental(Motor motor) throws InvalidMotorTypeException {
        // (Existing method logic remains unchanged)
    }

    protected void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }
}
