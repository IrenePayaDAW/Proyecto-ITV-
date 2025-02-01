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

    public CalculoPagamentosRevisados(Taller taller) {
        super("Calcular y pagar vehículo revisado", taller);

    }

    if(colaDePago.estaVacia()){
       teclado.out("Todavía no hay vehículos en la cola de pagos.\n");
    }else{
      System.out.printf("El primer vehículo de la cola de pagos ha abonado un total de %.2f€ y ha abandonado el taller.\n", colaDePago.getPrimerVehiculo().pagoTotal());
      vehiculosFinalizados = Arrays.copyOf(vehiculosFinalizados, vehiculosFinalizados.length + 1);
      vehiculosFinalizados[0] = colaDePago.getPrimerVehiculo();
      ingresosTotales += colaDePago.getPrimerVehiculo().pagoTotal();
      colaDePago.extraerVehiculo();
    }

//    @Override
//    public void ejecutar() {
//        if (taller.hayVehiculosParaPagar()) {
//            Vehiculo vehiculo = taller.procesarPagoVehiculo();
//            teclado.out("El vehículo con matrícula " + vehiculo.getMatricula()
//                    + " ha abonado un total de " + vehiculo.pagoTotal() + "€ y ha salido del taller.\n");
//        } else {
//            teclado.out("No hay vehículos en la cola de pagos.\n");
//        }
//    }
}
