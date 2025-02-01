/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;

/**
 *
 * @author irene
 */
public class MostrarBox extends OpcionTaller {

    public MostrarBox(Taller taller) {
        super("Mostrar estado de un box", taller);
    }

    int numeroBox = 0;

    teclado.out("Dime un número de box para consultar su estado (1 - 6): ");
     numeroBox = teclado.inInt();

    while (!this.opcion1A6(numeroBox)){
       teclado.out("Número de box inválido. Debe estar entre 1 y 6.\n");
        teclado.out("Volver a insertar: ");
        numeroBox = teclado.inInt();
        teclado.out("\n");
    }
    if(this.boxes[numeroBox - 1] == null){
        teclado.out("El box se encuentra vacío.\n");
    }else{
        teclado.out("Estado del box " + numeroBox + ":\n");
        this.boxes[numeroBox - 1].mostrarEstado();
    }

}
