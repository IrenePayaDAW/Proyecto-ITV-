package opcion;

import excepciones.NotExistsException;
import itv.Taller;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ciclost
 */
public class AltaSocio extends OpcionTaller {

    public AltaSocio(Taller taller) {
        super("Dar de alta como socio", taller);
    }

    @Override
    public void ejecutar() {
        teclado.out("Introduce el DNI del cliente al que vas a dar de alta");
        String dni = validarDNI(teclado.inString().toUpperCase().trim());

        if (!taller.estaElDni(dni)) {
            teclado.out("\nEl DNI no está registrado, registra al cliente primero.");
            return;
        }
        
        try {
            if(taller.getClientePorDNI(dni).isSOCIO()){
                teclado.out("\nEl cliente ya es socio");
                return;
            }
        } catch (NotExistsException ex) {
            teclado.out("El cliente con el DNI señalado no se encuentra dado de alta");
        }
        
        try {
            taller.getClientePorDNI(dni).hacerSocio();
        } catch (NotExistsException ex) {
            teclado.out("El cliente con el DNI señalado no se encuentra dado de alta");
        }
        

    }

    private String validarDNI(String dni) {
        while (!validarConPatrones(Pattern.compile("^[0-9]{8}[A-Z]$"), dni)) {
            teclado.out("Error, el DNI debe ser 8 números y una letra.\n");
            dni = teclado.inString().toUpperCase().trim();
        }
        return dni;
    }

    private boolean validarConPatrones(Pattern patron, String telefono) {
        Matcher matcher = patron.matcher(telefono);
        return matcher.matches();
    }

}