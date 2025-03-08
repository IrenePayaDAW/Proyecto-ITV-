package interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;
import util.Interval;

/**
 *ME HE TOMADO LA LIBERTAD DE CREAR UNA INTERFAZ QUE SEA UTIL
 * 
 * @author ÁLVARO CARRIÓN ROMERO 
 */
public interface Validable {
    GestorIO teclado = new GestorIO();
    
    public static String withPattern(String elemento, String tipoPatron){ 
        while(!validarConPatrones(Patron.getPattern(tipoPatron.toUpperCase()) ,elemento.toUpperCase().trim())){
                teclado.out(Patron.getCaracteristica(tipoPatron));
                elemento = teclado.inString();
            }
        return elemento;
    }
    private static boolean validarConPatrones(Pattern patron, String telefono){
        Matcher matcher = patron.matcher(telefono);
        return matcher.matches();
    }
    
    public static String respuestaSiNo(String respuestaCliente) {
        while (!respuestaCliente.equalsIgnoreCase("SI") && !respuestaCliente.equalsIgnoreCase("NO")) {
            teclado.out("\nERROR. Lo siento está no es una respuesta válida\n");
            teclado.out("La respuesta debe ser un SI o NO: ");
            respuestaCliente = teclado.inString().trim();
        }
        return respuestaCliente;
    }
    
    public static int opcion(int opcion, Interval opciones){
        while (!opciones.inclou(opcion)) {
            teclado.out("Introduce una opción válida: ");
            opcion = teclado.inInt();
        }
        return opcion;
        
    }
    
    public static void main(String[] args){
        System.out.println(Validable.withPattern("12341", "telefono"));
    }
}
