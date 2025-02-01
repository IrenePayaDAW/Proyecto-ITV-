/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import util.GestorIO;

/**
 *
 * @author acarr
 */
class PasarDeFase extends OpcionTaller {

    public PasarDeFase(Taller taller) {
        super("Pasar vehículo de fase", taller);
    }

    public void ejecutar(Taller taller) {
        int boxSeleccionado = 0;
        teclado.out("Introduce el box en el que quieras mover de fase a todos sus vehículos: ");
        boxSeleccionado = teclado.inInt();
        boxes[boxSeleccionado - 1].avanzarVehiculos();

        if (boxes[boxSeleccionado - 1].boxLleno()) {
            colaDePago.insertarVehiculo(boxes[boxSeleccionado - 1].getUltimoVehiculo());
        }

        teclado.out("Los vehículos del box " + (boxSeleccionado) + " Han avanzado a la siguiente fase.\n");

//        GestorIO teclado = new GestorIO();
//        teclado.out("Ingrese el número de box donde desea pasar los vehículos de fase: ");
//        int numeroBox = teclado.inInt();
//
//        if (taller.existeBox(numeroBox)) {
//            taller.pasarVehiculosDeFase(numeroBox);
//            teclado.out("Los vehículos del box " + numeroBox + " han avanzado a la siguiente fase.\n");
//        } else {
//            teclado.out("El box ingresado no existe.\n");
//        }
    }
}
