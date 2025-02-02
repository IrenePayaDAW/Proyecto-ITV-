/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import util.Interval;

/**
 *
 * @author irene
 */
public class MostrarBox extends OpcionTaller {

    public MostrarBox(Taller taller) {
        super("Mostrar estado de un box", taller);
    }
    
    /**
     * muestra el estado del box que se solicita
     */
    public void ejecutar(){
        teclado.out("Introduce el box que quieres consultar (1-6): ");
        int opcion = validarOpcion(teclado.inInt(), 1, 6);
        taller.mostrarBox(opcion);
    }
    
    /**
     * valida que el usuario introduzca una opcion valida
     * @param opcion
     * @param min
     * @param max
     * @return opcion válida
     */
    public int validarOpcion(int opcion, int min, int max){
        Interval opciones = new Interval(min,max);
         while (!opciones.inclou(opcion)) {
            teclado.out("Introduce una opción válida: ");
            opcion = teclado.inInt();
        }
        return opcion;
    }

    

}
