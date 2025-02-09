
package opcion;

import itv.Taller;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author acarr
 */
public class CalculoPagamentosRevisados extends Opcion {
    GestorIO teclado = new GestorIO();
    Taller taller;
    public CalculoPagamentosRevisados() {
        super("Calcular y pagar vehículo revisado");
        taller = new Taller();
    }


    @Override
    public void ejecutar() {
        if (taller.hayVehiculosParaPagar()) {
            Vehiculo vehiculo = taller.procesarPagoVehiculo();
            teclado.out("El vehículo con matrícula " + vehiculo.getMatricula() + 
                        " ha abonado un total de " + vehiculo.pagoTotal() + "€ y ha salido del taller.\n");
        } else {
            teclado.out("No hay vehículos en la cola de pagos.\n");
        }
    }
}
}
