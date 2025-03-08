/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import excepciones.AlreadyExistsException;
import excepciones.NotExistsException;
import itv.Taller;
import java.util.logging.Level;
import java.util.logging.Logger;
import vehiculo.Furgoneta;
import vehiculo.Vehiculo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class ReclamacionVehiculo extends OpcionTaller {
   
    public ReclamacionVehiculo(Taller taller) {
        super("Reclamar vehículo", taller);
    }
    
    /**
     * Reclama un vehiculo para introducirlo en un box.
     */
    @Override
    public void ejecutar(){
        if(this.taller.colaEstaVacia()){
           teclado.out("No hay vehiculos en la cola principal\n");
           
        }else if(!taller.boxesVacios()){
           teclado.out("Los boxes están llenos\n");
        }else{
            teclado.out("Indica el box donde quieres introducir el vehiculo: ");
            int opcion = teclado.inInt();            
           while(!taller.NUMERO_BOXES.inclou(opcion)){
               teclado.out("Este box no existe (1-6): ");
               opcion = teclado.inInt();
           }
            try {
                taller.asignarVehiculoBox(opcion, taller.extraerVehiculoCola());
                taller.eliminarVehiculoCola();
            } catch (NotExistsException ex) {
                teclado.out("No ha sido posible realizar la operación ya que todavía no hay vehículos existentes.");
            } catch (AlreadyExistsException ex) {
                teclado.out(ex.getMessage());
            }
            
        }
    }
   
   
}
