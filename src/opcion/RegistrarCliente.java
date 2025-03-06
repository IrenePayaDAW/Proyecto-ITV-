package opcion;

import cliente.Cliente;
import excepciones.AlreadyExistsException;
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
public class RegistrarCliente extends OpcionTaller {

    public RegistrarCliente(Taller taller) {
        super("Resgistrar cliente", taller);
    }

    @Override
    public void ejecutar() {
        boolean error = false;
        String dni = null;
        String nombre = null;
        String telefono = null;
        boolean vip = false;
        Matcher matcher;

        teclado.out("\n---REGISTRA AL CLIENTE---");
        teclado.out("\nIntroduce el DNI: ");
        try {
            dni = taller.estaEsteDNI(validarDNI(teclado.inString().toUpperCase().trim()));
        } catch (AlreadyExistsException ex) {
            System.out.println(ex);//HAGO UN PRINT DE LA EXCEPCIÓN Y LUEGO UTILIZO EL ATRIBUTO QUE SE HA DADO
            try {
                Cliente clienteExistente = taller.getClientePorDNI(ex.getStringExistente());//DEMUESTRO QUE EL CLIENTE ESTA EN EL TALLER YA REGISTRADO
                System.out.println("\n--Este es el cliente ya registrado.--");              //PARA QUE NO SE VUELVA A COMETER EL ERROR.
                System.out.println(clienteExistente);
            } catch (NotExistsException ex1) {
                System.out.println(ex1);
            } catch (NullPointerException ex1) {
                System.out.println(ex1);
            }
            return;
        }
        //INTRODUCCIÓN DEL NOMBRE
        do {
            error = false;
            teclado.out("\nIntroduce el nombre: ");
            try {
                nombre = esteNombreExiste(teclado.inString().toUpperCase().trim());//ESTO ES ALGO LIOSO PERO LE PREGUNTO A TALLER SI YA EXISTE EL NOMBRE CON UN MÉTODO QUE ME HE CREADO AQUÍ
            } catch (AlreadyExistsException ex) {                                  //PARA QUE SI YA EXISTE ESTE NOMBRE LE PREGUNTE SI ES CORRECTO O SE HA EQUIVOCADO
                System.out.println(ex);
                System.out.println("¿Tan conocido es " + ex.getStringExistente() + " como nombre?");
                System.out.println("¿Quieres guardar entonces este nombre?(SI / NO)");
                if (getRespuestaSiNo(teclado.inString().toUpperCase().trim()).equals("SI")) {//AQUÍ PREGUNTO SI ES EL NOMBRE EXISTENTE EL QUE QUIERE GUARDAR COMO VÁLIDO
                    nombre = ex.getStringExistente();
                } else {
                    error = true;
                }
            } finally {
                teclado.out("Ok. Sigamos.");
            }
        } while (error);
        //INTRODUCCIÓN DEL NÚMERO DEL TELÉFONO
        do {
            error = false;
            teclado.out("\nIntroduce el número de teléfono: ");
            telefono = teclado.inString();
            while (!validarConPatrones(Pattern.compile("^[0-9]{9}$"), telefono)) {
                teclado.out("Error, introduce un teléfono solo con 9 números: ");
                telefono = teclado.inString().toUpperCase().trim();
            }
            try {
                telefono = esteTelefonoExiste(telefono);
            } catch (AlreadyExistsException ex) {
                System.out.println(ex);
                error = true;
                System.out.println("Debes insertar otro teléfono");
            }
            
        }while(error);  
        
        
        teclado.out("\n¿El cliente quiere ser VIP? (Si / No):  ");
        String respuesta = teclado.inString().toUpperCase().trim();
        while (!respuesta.equals("SI") && !respuesta.equals("NO")) {
            teclado.out("Error, tiene que ser un 'SI' o un 'NO': ");
            respuesta = teclado.inString().toUpperCase().trim();
        }
        if (respuesta.equals("SI")) {
            vip = true;
        }
        teclado.out("\n---EL CLIENTE "+nombre+" HA SIDO REGISTRADO--\n");
        taller.añadirCliente(new Cliente(dni, nombre, telefono, vip));//INSERTAMOS EL CLIENTE
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

    private String esteNombreExiste(String nombre) throws AlreadyExistsException {
        return taller.esteNombreExiste(nombre);
    }
    
    private String esteTelefonoExiste(String telefono) throws AlreadyExistsException{
        return taller.esteTelefonoExiste(telefono);
    }

    private String getRespuestaSiNo(String respuestaCliente) {
        while (!respuestaCliente.equals("SI") && !respuestaCliente.equals("NO")) {
            teclado.out("\nERROR. Lo siento está no es una respuesta válida\n");
            teclado.out("La respuesta debe ser un SI o NO: ");
            respuestaCliente = teclado.inString().toUpperCase().trim();
        }
        return respuestaCliente;
    }

}
