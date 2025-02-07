/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import menu.Menu;

/**
 *
 * @author irene
 */
public class Salir extends Opcion{

    Menu menu;
    public Salir(Menu menu) {
        super("Salir");
        this.menu = menu;
    }

    @Override
    public void ejecutar() {
        teclado.out("\n--FIN DEL PROGRAMA--");
        menu.salir();
    }
    
}
