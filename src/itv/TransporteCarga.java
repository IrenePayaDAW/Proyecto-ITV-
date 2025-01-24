package itv;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public class TransporteCarga extends Vehiculo {

    private double PMA;

    public TransporteCarga(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo, TipoVehiculo tipo, boolean estadoVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, tipo, estadoVehiculo);
        this.PMA = PMA;
    }

    public boolean requiereCargaAdicVehicGran() {
        return this.cilindros >= 10;
    }

    public double calcularCargoPma() {
        if (this.cilindros < 10) {
            return 3 * this.PMA;
        } else {
            return 0;
        }
    }

    public double calcularAdicVehicGrande() {
        if (this.cilindros >= 10) {
            return 4 * this.PMA;
        } else {
            return 0;
        }
    }

}
