package vehiculo;

import util.Interval;

/**
 * Classe Coche que representa un vehicle de transport de persones.
 * Aplica les tarifes específiques per a cotxes.
 */
public class Coche extends TransportePersonas {
    private static final double COSTE_PLAZA_ADICIONAL = 1.5;

    public Coche(int cilindros, int plazas, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, plazas, COSTE_PLAZA_ADICIONAL, new Interval(2, 7));
    }

    @Override
    public String getTipo() {
        return "Coche";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}
