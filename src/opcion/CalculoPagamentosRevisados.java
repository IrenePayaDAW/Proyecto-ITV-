package opcion;

import itv.Cola;
import java.util.Arrays;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class CalculoPagamentosRevisados extends Opcion {

    private Cola vehiculosCobrar;

    public CalculoPagamentosRevisados() {
        super("Calcular y pagar vehículo revisado");
        this.vehiculosCobrar = new Cola();
    }

    /**
     * Calcula y cobra el precio totaln de un vehiculo
     */
    @Override
    public void ejecutar() {
        /*
        if (!this.vehiculosCobrar.estaVacia()) {
            Vehiculo vehiculo = this.vehiculosCobrar.extraerVehiculo();
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " tiene que pagar: " + vehiculo.calcularPrecio()((!!!!*vehiculo.getDescuento()!!!!!(NUEVO A AÑADIR))) + "\n");
            ingresos.insertarVehiculo(vehiculo);
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " se ha añadido al historial.\n");
        } else if (!vehiculosCobrar.estaVacia() && taller.hayVehiculosParaPagar()) {
            teclado.out("No hay vehículos para pagar.\n");
        } else if (taller.hayVehiculosParaPagar()) {
            this.vehiculosCobrar.insertarVehiculo(super.taller.extraerVehiculoPago());
            this.ejecutar();
        }
         */

    }
}
//en ejecutar() Factura facturaVehiculo = new Factura(vehiculo);
// el array de facturas debe volcarse sobre uno nuev con mayor longitud y 
// facturaVehiculo debe guardarse en el array de facturas incrementandose la longitud del mismo
// taller.agregarFactura(facturaVehiculo);

