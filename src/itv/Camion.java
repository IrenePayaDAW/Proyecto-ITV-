
package itv;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public class Camion extends TransporteCarga{
    
    public Camion(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo, TipoVehiculo tipo, boolean estadoVehiculo) {
        super(PMA, cilindros, CC, matricula, modeloVehiculo, tipo, estadoVehiculo);
    }
    
    @Override
    public double calcularAdicVehicGrande() {
        double base = super.calcularAdicVehicGrande();
        final int FIJO = 40;//Fijo adicional: +40€
        double porcentPrecioBase = ((this.cilindros*15)*20)/100;//Porcentaje adicional: + 20% del precio base
        return base + FIJO + porcentPrecioBase;
    }
}
