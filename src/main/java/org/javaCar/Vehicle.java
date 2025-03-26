package org.javaCar;
import java.lang.StringBuilder;
import java.util.Random;
import java.time.Instant;
/**
 * Aquesta classe és una superclasse de tots els tipus de vehicles oferits a carJava.
 */
public abstract class Vehicle implements Llogable {
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    //Override de la interfície Llogable
    @Override
    public double calcularPreuCotxe (int dies, double preuBase) {
        return 0;
    }
    @Override
    public double calcularPreuMoto (int dies, double preuBase, int cilindrada) {
        return 0;
    }
    @Override
    public double calcularPreuFurgoneta (int dies, double preuBase, int capacitiatCarga) {
        return 0;
    }
    //Declaració d'atributs
    private String matricula;
    private String marca;
    private String model;
    private double preuBase;
    private Motor motor;
    private Roda[] rodes;
    private DistintiusAmbientals distintiuAmbiental;
    private Instant dataAddicio;

    //Getters i setters

    /**
     * Getter de la matrícula d'un vehicle
     * @return El String corresponent a la matrícula del vehicle
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de la matrícula d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param matricula La nova matrícula del vehicle
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Getter de la marca d'un vehicle.
     * @return La marca del vehicle
     */
    public String getMarca() {
        return marca;
    }

    public Motor getMotorPure() {
        return motor;
    }

    /**
     * Setter de la marca d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param marca La nova marca d'un vehicle
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Getter del model d'un vehicle.
     * @return El model d'un vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter del model d'un vehicle. Només s'hauria de fer servir en cas que s'hagi declarat el vehicle malament.
     * @param model El nou model d'un vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter del preu base d'un vehicle.
     * @return El preu base d'un vehicle.
     */
    public double getPreuBase() {
        return preuBase;
    }

    /**
     * Setter del preu base d'un vehicle..
     * @param preuBase El nou preu base d'un vehicle.
     */
    public void setPreuBase(double preuBase) {
        this.preuBase = preuBase;
    }

    public Instant getDataAddicio() {
        return dataAddicio;
    }

    public void setDataAddicio(Instant dataAddicio) {
        this.dataAddicio = dataAddicio;
    }

    /**
     * Getter del distintiu ambiental d'un vehicle.
     * @return El distintiu ambiental d'un vehicle.
     */
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

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }


    //Declaració mètode per a formar el distintiu ambiental.

    /**
     * Aquest mètode assigna el distintiu ambiental del vehicle
     * @param motor El motor del vehicle
     * @throws InvalidMotorTypeException aquesta excepció es tira si el tipus de combustible que fa servir el motor no és vàlid
     */
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

    protected void setRodes(Roda[] rodes) {
        this.rodes = rodes;
    }
}
