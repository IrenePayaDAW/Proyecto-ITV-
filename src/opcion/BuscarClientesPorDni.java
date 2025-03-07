
package opcion;

import excepciones.NotExistsException;
import interfaces.Validable;
import itv.Taller;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ciclost
 */
public class BuscarClientesPorDni extends OpcionTaller{

    public BuscarClientesPorDni(Taller taller) {
        super("Buscar cliente por dni", taller);
    }
    
    @Override
    public void ejecutar() {
        try {
            teclado.out("\nInserte el DNI del Cliente: ");
            System.out.println(taller.getClientePorDNI(Validable.withPattern(teclado.inString(), "DNI")));
        } catch (NotExistsException ex) {
            System.out.println(ex);
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
    }

}
