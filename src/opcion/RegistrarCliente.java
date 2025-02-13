package opcion;

import cliente.Cliente;
import itv.Taller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ciclost
 */
public class RegistrarCliente extends OpcionTaller{

    public RegistrarCliente(Taller taller) {
        super("Resgistrar cliente", taller);
    }

    @Override
    public void ejecutar() {
        boolean error = false;
        String dni;
        String nombre;
        String telefono;
        boolean vip = false;
        Matcher matcher;
        
        teclado.out("\n---REGISTRA CLIENTE---");
            error = false;
            teclado.out("\nIntroduce el DNI: ");
            dni = validarDNI(teclado.inString().toUpperCase().trim());
        
        if(taller.estaElDni(dni)){
            teclado.out("\n Error, el DNI ya está registrado.");
            return;
        }
        
        teclado.out("\nIntroduce el nombre: ");
        nombre = teclado.inString().toUpperCase().trim();
        
        teclado.out("\nIntroduce el número de teléfono: ");
        telefono = teclado.inString();
        while(!validarConPatrones(Pattern.compile("^[0-9]{9}$"), telefono)){
            teclado.out("Error, introduce un teléfono solo con 9 números: ");
            telefono = teclado.inString().toUpperCase().trim();
        }
        
        teclado.out("\n¿El cliente quiere ser VIP? (Si / No):  ");
        String respuesta = teclado.inString().toUpperCase().trim();
        while(!respuesta.equals("SI")&&!respuesta.equals("NO")){
            teclado.out("Error, tiene que ser un 'SI' o un 'NO': ");
            respuesta = teclado.inString().toUpperCase().trim();
        }
        if(respuesta.equals("SI")){
            vip = true;
        }
        
        taller.añadirCliente(new Cliente(dni, nombre, telefono, vip));
    }
    
    private String validarDNI(String dni){
        while(!validarConPatrones(Pattern.compile("^[0-9]{8}[A-Z]$"),dni)){
                teclado.out("Error, el DNI debe ser 8 números y una letra.\n");
                dni = teclado.inString().toUpperCase().trim();
            }
        return dni;
    }
    
    private boolean validarConPatrones(Pattern patron, String telefono){
        Matcher matcher = patron.matcher(telefono);
        return matcher.matches();
    }
     
}