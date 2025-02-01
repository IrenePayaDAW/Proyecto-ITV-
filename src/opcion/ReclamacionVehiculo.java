/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import vehiculo.Furgoneta;
import vehiculo.Vehiculo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;

/**
 *
 * @author acarr
 */
class ReclamacionVehiculo extends OpcionTaller {

    public ReclamacionVehiculo(Taller taller) {
        super("Reclamar vehículo", taller);
    }
    int eleccionBox;

    if(this.colaPrincipal.estaVacia ()){
       teclado.out("La cola está vacía.\n");
    }else{ //TIENE QUE PEDIR EL BOX DONDE SE QUIERE ASIGNAR EL VEHÍCULO
     teclado.out("Qué box quieres selecionar (1 - 6): ");
     eleccionBox = teclado.inInt();
     while(!numBoxes.inclou(eleccionBox)){
        teclado.out("Error, los boxes están entre 1 y 6.");
        eleccionBox = teclado.inInt();
        }
    if(boxes[eleccionBox - 1].boxLibre()){
       teclado.out("Vehiculo introduccido en el box " + eleccionBox + "\n");
       boxes[eleccionBox - 1].asignarVehiculo(colaPrincipal.extraerVehiculo());
        }else{
         teclado.out("El box está ocupado");
        }
    }//(CORREGIDO)

//    @Override
//    public void ejecutar() {
//        GestorIO teclado = new GestorIO();
//        if (taller.hayVehiculosEnCola()) {
//            Vehiculo vehiculo = taller.reclamarVehiculo();
//            teclado.out("El vehículo con matrícula " + vehiculo.getMatricula() + " ha sido reclamado y está listo para entrar en el box.\n");
//        } else {
//            teclado.out("No hay vehículos en la cola para reclamar.\n");
//        }
//    }
}
