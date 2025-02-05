package menu;

import itv.Taller;
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
public class Menu {
    GestorIO teclado = new GestorIO();
    private Opcion[] opciones;
    private int numOpciones = 0;
    public Menu(){
        opciones = new Opcion[0];
    }
    
    public void añadirOpcion(Opcion opcion){
        opciones = Arrays.copyOf(opciones, opciones.length +1);
        opciones[opciones.length -1] = opcion;
        numOpciones++;
    }
    
    public void mostrar(){
        for (int i = 0; i < opciones.length; i++) {
            opciones[i].mostrar(i+1);
        }
    }
    
    public Opcion getOpcion(){
        return opciones[validarOpcion()-1];
    }
    
    private int validarOpcion(){
        Interval opcion = new Interval(1,opciones.length);
        teclado.out("Dame la opción que quieres: ");
        int usuario = teclado.inInt();
        while (!opcion.inclou(usuario)){
            teclado.out("Es una opcion entre "+ opcion.getInferior()+ " y "+opcion.getSuperior()+".");
            usuario = teclado.inInt();
        }
        return usuario;
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
