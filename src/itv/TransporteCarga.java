package itv;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public abstract class TransporteCarga extends Vehiculo {

    private double PMA;

    public TransporteCarga(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo, TipoVehiculo tipo, boolean estadoVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, tipo, estadoVehiculo);
        this.PMA = PMA;
    }

    protected boolean requiereCargaAdicVehicGran() {
        return this.cilindros >= 10;
    }

    protected double calcularCargoPma() {
        if (this.cilindros < 10) {
            return 3 * this.PMA;
        } else {
            return 0;
        }
    }

    protected double calcularAdicVehicGrande() {
        if (this.cilindros >= 10) {
            return 4 * this.PMA;
        } else {
            return 0;
        }
    }

}
