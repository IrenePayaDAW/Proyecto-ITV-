
package vehiculo;

import util.Interval;

/**
 * Classe MicroBus que representa un vehicle de transport de persones.
 * Aplica les tarifes específiques per a microbusos.
 */
public class MicroBus extends TransportePersonas {
    private static final double COSTE_PLAZA_ADICIONAL = 2.0;

    public MicroBus(int cilindros, int plazas, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, plazas, COSTE_PLAZA_ADICIONAL, new Interval(2, 20));
    }

    @Override
    public String getTipo() {
        return "MicroBus";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}

