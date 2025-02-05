
package main;

import itv.Taller;
import menu.Menu;
import opcion.CalculoPagamentosRevisados;
import opcion.MostrarBox;
import opcion.MostrarBoxes;
import opcion.Opcion;
import opcion.RegistroNuevoVehiculo;
import opcion.CalculoIngresos;
import opcion.PasarDeFase;
import opcion.ReclamacionVehiculo;
import opcion.OpcionTaller;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class ITV {

    private final Taller taller;
    private final Menu menu;
    
    
    public ITV() {
        this.taller = new Taller();
        this.menu = new Menu();
        //1.-Registrar Cliente
        //2.-Tarjeta de socio al cliente
        menu.añadirOpcion(new RegistroNuevoVehiculo(taller));
        menu.añadirOpcion(new ReclamacionVehiculo(taller));
        menu.añadirOpcion(new PasarDeFase(taller));
        menu.añadirOpcion(new MostrarBox(taller));
        menu.añadirOpcion(new MostrarBoxes(taller));
        menu.añadirOpcion(new CalculoPagamentosRevisados());
        menu.añadirOpcion(new CalculoIngresos());
    }
    /**
     * ejecuta el programa
     * @param args 
     */
    public static void main(String[] args) {
        ITV programa = new ITV();
        programa.inicio();
    }
    public void inicio(){
        menu.mostrar();
    }
}

