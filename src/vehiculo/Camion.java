package vehiculo;

/**
 * Classe Camion que representa un vehicle de transport de càrrega.
 * Aplica les tarifes específiques per a camions.
 */
public class Camion extends TransporteCarga {
    private static final int FIJO_ADICIONAL = 40;

    public Camion(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, PMA);
    }

    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double incrementoPorcentaje = precioBase * 0.2;
        double incrementoPotencia = (this.getPotencia() > 2000) ? 20 : 0;
        return precioBase + FIJO_ADICIONAL + incrementoPorcentaje + incrementoPotencia;
    }

    @Override
    public String getTipo() {
        return "Camion";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}
