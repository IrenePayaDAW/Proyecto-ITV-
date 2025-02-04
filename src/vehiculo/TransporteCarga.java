package vehiculo;

import util.GestorIO;

/**
 * 
 * @author irene, alvaro, alejandro
 */
public abstract class TransporteCarga extends Vehiculo {
    private double pma;

    public TransporteCarga(int cilindros, double CC, String matricula, String modeloVehiculo, double PMA) {
        super(cilindros, CC, matricula, modeloVehiculo);
        this.pma = PMA;
    }

    public TransporteCarga(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }

    /**
     * Registra el vehículo pidiendo al usuario que introduzca el PMA.
     */
    public void registrarVehiculo() {
        double pma;
        do {
            teclado.out("Introduce el PMA del vehículo: ");
            pma = teclado.inDouble();
        } while (pma < 0);
        this.pma = pma;
    }
    
    /**
     * Calcula el cargo adicional basado en el PMA del vehículo.
     * 
     * @return Cargo adicional calculado.
     */
    protected double calcularCargoPma() {
        return (this.getCilindros() < 10) ? (3 * this.pma) : (4 * this.pma);
    }

    /**
     * Calcula el precio total de la revisión del vehículo.
     * 
     * @return Precio total de la revisión.
     */
    @Override
    public double calcularPrecio() {
        return (this.getCilindros() * PRECIO_BASE) + this.calcularCargoPma();
    }

    /**
     * Obtiene el PMA del vehículo.
     * 
     * @return El PMA del vehículo.
     */
    public double getPMA() {
        return pma;
    }
}