package vehiculo;

/**
 * Classe Furgoneta que representa un vehicle de transport de càrrega.
 * Aplica les tarifes específiques per a furgonetes.
 */
public class Furgoneta extends TransporteCarga {
    public Furgoneta(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, PMA);
    }

    @Override
    public String getTipo() {
        return "Furgoneta";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}

