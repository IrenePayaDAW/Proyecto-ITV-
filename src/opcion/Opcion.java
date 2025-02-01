
package opcion;

import itv.Taller;
import util.GestorIO;

/**
 * Classe abstracta Opcio que defineix l'estructura bàsica de les opcions del sistema ITV.
 */
public abstract class Opcion {
    GestorIO teclado = new GestorIO();
    protected String titulo;

    public Opcion(String titulo) {
        this.titulo = titulo;
    }

    public void mostrar(int numOpcion) {
        teclado.out(numOpcion + ". " + titulo + "\n");
    }

    public abstract void ejecutar();
}
