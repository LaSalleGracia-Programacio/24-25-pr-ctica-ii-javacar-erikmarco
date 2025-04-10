package org.javaCar;
import java.lang.StringBuilder;
import java.util.Random;
import java.time.Instant;

public abstract class Vehicle implements Llogable {
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();

    // Constructor to initialize Vehicle with matricula, marca, model, preuBase, motor, and rodes
    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda roda) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.dataAddicio = Instant.now();
        try {
            this.motor = motor;
        } catch (Exception e) {
            motor = null;
        }
        try {
            this.roda = roda;
        } catch (Exception e) {
            this.roda = null;
        }
    }

    public Vehicle(String matricula, String marca, String model, double preuBase) {
        this(matricula, marca, model, preuBase, null, null);
    }
    public Vehicle() {
        this(null, null, null, 0, null, null);
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
    protected String matricula;
    protected String marca;
    protected String model;
    private double preuBase;
    private Motor motor;
    private Roda roda;
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

    public Roda getRodaPure() {
        return roda;
    }

    public String getRoda() {
        return roda.toString();
    }

    // Method to assign the environmental badge
    public void assignarDistintiuAmbiental(Motor motor) throws InvalidMotorTypeException {
        motor.setEmissionsCO(rand.nextDouble(3.5));
        motor.setEmissionsTHC(rand.nextDouble(0.3));
        motor.setEmissionsNMHC(rand.nextDouble(0.1));
        motor.setEmissionsNOx(rand.nextDouble(0.75));
        motor.setEmissionsHC_NOx(rand.nextDouble(1.5));
        motor.setEmissionsPM(rand.nextDouble(0.25));
        motor.setEmissionsPN((byte) rand.nextInt(9));
        switch (motor.getTipus()) {
            case 'g':
                motor.setAnyConstruccio(rand.nextInt(1900, 2025));
                if (motor.getAnyConstruccio() < 2001) this.distintiuAmbiental = DistintiusAmbientals.NULL;
                else {
                    if (motor.getAnyConstruccio() < 2006) {
                        if (motor.getEmissionsCO() > 2.3 || motor.getEmissionsTHC() > 0.2 || motor.getEmissionsNOx() > 0.15)
                            this.distintiuAmbiental = DistintiusAmbientals.NULL;
                        else distintiuAmbiental = DistintiusAmbientals.B;
                    } else {
                        if (motor.getEmissionsCO() > 1.0 || motor.getEmissionsTHC() > 0.1 || motor.getEmissionsNOx() > 0.08) this.distintiuAmbiental = DistintiusAmbientals.B;
                        else distintiuAmbiental = DistintiusAmbientals.C;
                    }
                }
                break;
            case 'd':
                motor.setAnyConstruccio(rand.nextInt(1900, 2025));
                if (motor.getAnyConstruccio() < 2006) this.distintiuAmbiental = DistintiusAmbientals.NULL;
                else {
                    if (motor.getAnyConstruccio() < 2014) {
                        if (motor.getEmissionsCO() > 0.5 || motor.getEmissionsNOx() > 0.25 || motor.getEmissionsHC_NOx() > 0.3 || motor.getEmissionsPM() > 0.025)
                            this.distintiuAmbiental = DistintiusAmbientals.NULL;
                        else distintiuAmbiental = DistintiusAmbientals.B;
                    } else {
                        if (motor.getEmissionsCO() > 0.5 || motor.getEmissionsNOx() > 0.08 || motor.getEmissionsHC_NOx() > 0.17 || motor.getEmissionsPM() > 0.0045 || motor.getEmissionsPN() > 6) this.distintiuAmbiental = DistintiusAmbientals.B;
                        else distintiuAmbiental = DistintiusAmbientals.C;
                    }
                }
                break;
            case 'p':
                motor.setRangHibrid((byte) rand.nextInt(127));
                if (motor.getRangHibrid() > 40) {
                    this.distintiuAmbiental = DistintiusAmbientals.ZERO;
                } else {
                    this.distintiuAmbiental = DistintiusAmbientals.ECO;
                }
                break;
            case 'e':
                this.distintiuAmbiental = DistintiusAmbientals.ZERO;
                break;
            case 'h', 'n', 'l':
                this.distintiuAmbiental = DistintiusAmbientals.ECO;
                break;
            default:
                throw new InvalidMotorTypeException("Tipus de motor invalid.");
        }

    }

    protected void setRodes(Roda roda) {
        this.roda = roda;
    }
}
