package menu;

import interfaces.Validable;
import itv.Taller;
import java.util.ArrayList;
import java.util.Arrays;
import opcion.CalculoIngresos;
import opcion.CalculoPagamentosRevisados;
import opcion.MostrarBox;
import opcion.MostrarBoxes;
import opcion.Opcion;
import opcion.PasarDeFase;
import opcion.ReclamacionVehiculo;
import opcion.RegistroNuevoVehiculo;
import util.GestorIO;
import util.Interval;

/**
 *
 * @author ciclost
 */
public class Menu implements Validable{
    GestorIO teclado = new GestorIO();
    private ArrayList<Opcion> opciones;
    private int numOpciones = 0;
    private boolean salir = false;
    public Menu(){
        opciones = new ArrayList<>();
    }
    
    public void añadirOpcion(Opcion opcion){
        opciones.add(opcion);
    }
    
    public void mostrar(){
        teclado.out("\n----MENÚ OPCIONES----\n");       
        for (int i = 0; i < opciones.size(); i++) {
            opciones.get(i).mostrar(i+1);
        }
    }
    
    public Opcion getOpcion(){
        return opciones.get(validarOpcion() - 1);
    }
    
    private int validarOpcion(){
        Interval opcion = new Interval(1,opciones.size());
        teclado.out("Dame la opción que quieres: ");      
        int usuario = Validable.opcion(teclado.inInt(), opcion);
                
        return usuario;
    }
    
    public boolean getSalir(){
        return salir;
    }
    
    public void salir(){
        this.salir = true;
    }
            
            
//    teclado.out("\nMenú del Taller:\n");
//        teclado.out("1. Registrar nuevo vehículo\n");
//        teclado.out("2. Reclamar vehículo\n");
//        teclado.out("3. Pasar vehículo de fase\n");
//        teclado.out("4. Mostrar estado de un box\n");
//        teclado.out("5. Mostrar estado de todos los boxes\n");
//        teclado.out("6. Calcular y pagar vehiculo revisado\n");
//        teclado.out("7. Calcular ingresos totales\n");
//        teclado.out("8. Salir\n")
}
