package vehiculo;

import util.GestorIO;

/**
 * Classe abstracta per a vehicles de transport de càrrega.
 * Defineix les característiques comunes com el PMA i costos addicionals.
 */
public abstract class TransporteCarga extends Vehiculo {
    private double PMA;

    public TransporteCarga(int cilindros, double CC, String matricula, String modeloVehiculo, double PMA) {
        super(cilindros, CC, matricula, modeloVehiculo);
        this.PMA = validarPMA(PMA);
    }

     public TransporteCarga(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }

    public void registrarVehiculo() {
        double pma;
        do {
            teclado.out("Introduce el PMA del vehículo: ");
            pma = teclado.inDouble();
        } while (pma < 0);
        this.pma = pma;
    }
    
    private double validarPMA(double PMA) {
        if (PMA <= 0) {
            throw new IllegalArgumentException("El PMA ha de ser un valor positiu.");
        }
        return PMA;
    }

    protected double calcularCargoPma() {
        return (this.getCilindros() < 10) ? (3 * this.PMA) : (4 * this.PMA);
    }

    @Override
    public double calcularPrecio() {
        return (this.getCilindros() * PRECIO_BASE) + this.calcularCargoPma();
    }

    public double getPMA() {
        return PMA;
    }
}

