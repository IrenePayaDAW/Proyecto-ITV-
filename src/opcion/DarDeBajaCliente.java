
import excepciones.NotExistsException;
import itv.Taller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opcion.OpcionTaller;
import util.GestorIO;

/**
 *
 * @author ciclost
 */
public class DarDeBajaCliente extends OpcionTaller{
    GestorIO teclado = new GestorIO();
    public DarDeBajaCliente(Taller taller) {
        super("Dar de cliente baja", taller);
    }

    @Override
    public void ejecutar() {
        try {
            teclado.out("\n-------------------------------------------------------");
            teclado.out("\n-Inserta el DNI del cliente que quieres dar de baja: ");
            taller.getClientePorDNI(validarDNI(teclado.inString().toUpperCase().trim())); //AQUÍ HACERLO CON EL REMOVE DE CLIENTE SET
        } catch (NotExistsException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    /**
     * IMPLEMENTAR EN CLIENTE SET (Cambiarlo por el metodo en taller por getClientePorDni() he implementar otro que sea remove pero que entre un Cliente "sobrecargarlo")
     * public void remove(Cliente cliente){
     *      clientes.remove(cliente);
     * }
     *
     *  
     */
   
    //IMPLEMENTAR VALIDABLE
    private String validarDNI(String dni) {
        while (!validarConPatrones(Pattern.compile("^[0-9]{8}[A-Z]$"), dni)) {
            teclado.out("\nError, el DNI debe ser 8 números y una letra: ");
            dni = teclado.inString().toUpperCase().trim();
        }
        return dni;
    }

    private boolean validarConPatrones(Pattern patron, String telefono) {
        Matcher matcher = patron.matcher(telefono);
        return matcher.matches();
    }
}
