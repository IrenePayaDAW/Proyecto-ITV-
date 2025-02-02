package opcion;

import itv.Cola;
import itv.Taller;
import java.util.Arrays;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author acarr
 */
public class CalculoPagamentosRevisados extends Opcion {

   
    
    private Cola vehiculosCobrar;
    private CalculoIngresos ingresos;
    public CalculoPagamentosRevisados(Taller taller, CalculoIngresos ingresos) {
        super("Calcular y pagar vehículo revisado", taller);
        this.ingresos = ingresos;
        this.vehiculosCobrar = new Cola();
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

    @Override
    public void ejecutar() {
        if(!this.vehiculosCobrar.estaVacia()){
            Vehiculo vehiculo = this.vehiculosCobrar.extraerVehiculo();
            teclado.out("Vehiculo con matrícula: "+ vehiculo.getMatricula() +" tiene que pagar: "+ vehiculo.calcularPrecio()+ "\n");
            ingresos.insertarVehiculo(vehiculo);
            teclado.out("Vehiculo con matrícula: "+ vehiculo.getMatricula() + " se ha añadido al historial.");         
        }else if(vehiculosCobrar.estaVacia() && !taller.hayVehiculosParaPagar()){
            teclado.out("No hay vehículos para pagar.");
        }else if(taller.hayVehiculosParaPagar()){
            this.vehiculosCobrar.insertarVehiculo(this.taller.extraerVehiculoPago());
            this.ejecutar();
        }
        
        
    }
}
