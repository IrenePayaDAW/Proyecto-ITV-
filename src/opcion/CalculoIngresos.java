package opcion;

import excepciones.NotExistsException;
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

public class CalculoIngresos extends OpcionTaller{
    
    public CalculoIngresos(Taller taller) {
        super("Calculo ingresos totales",taller);    
    }

    @Override
    /**
     * calcula los ingresos totales
     */
    public void ejecutar() {
        System.out.println("\n---"+super.titulo+"---\n");
        try {
            System.out.println("Los ingresos totales han sido un total de: "+taller.calculoFacturas());
        } catch (NotExistsException ex) {
            System.out.println(ex.getMessage());
        }
    }
}