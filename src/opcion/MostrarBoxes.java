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
public class MostrarBoxes extends OpcionTaller {

    public MostrarBoxes(Taller taller){
        super("Mostrar estado de todos los boxes", taller);
    }

    teclado.out("--Estado de todos los box--\n");
    for(int i = 0;i< boxes.length ;i++){
        teclado.out("Box " + (i + 1) + ":\n");
        boxes[i].mostrarEstado();
        teclado.out("\n");
    }

}
