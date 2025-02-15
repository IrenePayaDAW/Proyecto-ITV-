package opcion;

import excepciones.NotExistsException;
import factura.Factura;
import itv.Cola;
import itv.Taller;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class CalculoPagamentosRevisados extends OpcionTaller {

    private Cola vehiculosCobrar;

    public CalculoPagamentosRevisados(Taller taller) {
        super("Calcular y pagar vehículo revisado",taller);
        this.vehiculosCobrar = new Cola();
    }

    /**
     * Calcula y cobra el precio totaln de un vehiculo
     */
    @Override
    public void ejecutar() {
       
        if (!this.vehiculosCobrar.estaVacia()) {
            Vehiculo vehiculo = this.vehiculosCobrar.extraerVehiculo();
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " tiene que pagar: " + vehiculo.calcularPrecio() + "\n");
            taller.agregarFactura(new Factura(vehiculo));
            teclado.out("Vehiculo con matrícula: " + vehiculo.getMatricula() + " se ha añadido al historial.\n");
        } else if (!vehiculosCobrar.estaVacia() && taller.hayVehiculosParaPagar()) {
            teclado.out("No hay vehículos para pagar.\n");
        } else if (taller.hayVehiculosParaPagar()) {
            try {
                this.vehiculosCobrar.insertarVehiculo(super.taller.extraerVehiculoPago());
            } catch (NotExistsException ex) {
                System.out.println(ex.getMessage());
            }
            this.ejecutar();
        }

    }
}


