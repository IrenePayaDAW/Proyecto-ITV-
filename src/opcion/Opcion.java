
package opcion;

import itv.Taller;
import util.GestorIO;
import util.Interval;

/**
 * Classe abstracta Opcio que defineix l'estructura bàsica de les opcions del sistema ITV.
 */
public abstract class Opcion {
    GestorIO teclado = new GestorIO();
    protected String titulo;   
    protected Taller taller;
    
    
    public Opcion(String titulo, Taller taller) {
        this.titulo = titulo;
        this.taller = taller;
        
    }

    public void mostrar() {
        GestorIO teclado = new GestorIO();
        teclado.out("Menú del Taller:\n");
        teclado.out("1. Registrar nuevo vehículo\n");
        teclado.out("2. Reclamar vehículo\n");
        teclado.out("3. Pasar vehículo de fase\n");
        teclado.out("4. Mostrar estado de un box\n");
        teclado.out("5. Mostrar estado de todos los boxes\n");
        teclado.out("6. Calcular y pagar vehiculo revisado\n");
        teclado.out("7. Calcular ingresos totales\n");
        teclado.out("8. Salir\n");
                
    }

    
    public abstract void ejecutar();
}
