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

    
   

    /**
     * Calcula y cobra el precio totaln de un vehiculo
     */
    @Override
    public void ejecutar() {
        if(!this.vehiculosCobrar.estaVacia()){
            Vehiculo vehiculo = this.vehiculosCobrar.extraerVehiculo();
            teclado.out("Vehiculo con matrícula: "+ vehiculo.getMatricula() +" tiene que pagar: "+ vehiculo.calcularPrecio()+ "\n");
            ingresos.insertarVehiculo(vehiculo);
            teclado.out("Vehiculo con matrícula: "+ vehiculo.getMatricula() + " se ha añadido al historial.\n");         
        }else if(!vehiculosCobrar.estaVacia() && taller.hayVehiculosParaPagar()){
            teclado.out("No hay vehículos para pagar.\n");
        }else if(taller.hayVehiculosParaPagar()){
            this.vehiculosCobrar.insertarVehiculo(this.taller.extraerVehiculoPago());
            this.ejecutar();
        }
        
        
    }
}
