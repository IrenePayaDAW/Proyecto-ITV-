
package opcion;

import cliente.ClienteSet;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ciclost
 */
public class BuscarClientesPorDni extends Opcion{
    private ClienteSet clientes;
    public BuscarClientesPorDni(ClienteSet clientes) {
        super("Buscar cliente por dni");
        this.clientes = clientes;
    }
    
    @Override
    public void ejecutar() {
        mostrarCliente();
    }
    
    public void mostrarCliente(){
        System.out.println(clientes.getCliente(validarDNI(teclado.inString())));
    }
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
