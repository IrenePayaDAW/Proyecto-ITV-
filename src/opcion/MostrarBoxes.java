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

    public void ejecutar(){
        taller.mostrarBoxes();
    }
   

}
