/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;


import itv.Cola;
import itv.Taller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;
import util.Interval;
import vehiculo.Camion;
import vehiculo.Coche;
import vehiculo.Furgoneta;
import vehiculo.MicroBus;
import vehiculo.Vehiculo;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class RegistroNuevoVehiculo extends OpcionTaller {

    
    Interval OPCIONES_COCHE = new Interval(1, 4);

    public RegistroNuevoVehiculo(Taller taller) {
        super("Registrar nuevo vehículo", taller);
    }

    /**
     * Registra un nuevo vehiculo
     */
    @Override
    public void ejecutar() {
        Vehiculo vehiculo = null;
        String matricula;
        boolean esValida;
        Pattern patron = Pattern.compile("^[0-9]{4}[A-Z]{3}$");

        teclado.out("Selecciona el tipo de vehículo: \n");
        teclado.out("1. Coche\n");
        teclado.out("2. Microbús\n");
        teclado.out("3. Furgoneta\n");
        teclado.out("4. Camión\n");
        teclado.out("Selecciona una opción: ");
        int opcion = validarOpcion(teclado.inInt());

        do {
            teclado.out("Introduce la matrícula del coche (formato 1234ABC): ");
            matricula = teclado.inString().toUpperCase().trim();

            Matcher matcher = patron.matcher(matricula);
            esValida = (matcher.matches() && !taller.validarMatricula(matricula));

            if (!esValida) {
                teclado.out("Matrícula inválida.");
            }
        } while (!esValida);
        
        teclado.out("Introduce el modelo del vehículo: ");
        String modelo = teclado.inString();

        switch (opcion) {
            
            case 1:
                vehiculo = new Coche(matricula, modelo); //He usado constructores con estos dos atributos porque son finales y necesito inicializar los tipos de vehiculo para usar el polimorfismo
                break;
            case 2:
                vehiculo = new MicroBus(matricula, modelo);
                break;
            case 3:
                vehiculo = new Furgoneta(matricula, modelo);
                break;
            case 4:
                vehiculo = new Camion(matricula, modelo);
                break;
            
        }
        
        
        taller.registrarVehiculo(vehiculo);
        taller.insertarVehiculo(vehiculo);
        teclado.out("Vehiculo " + vehiculo.getMatricula() + " registrado\n");
        
    }

    /**
     * valida que el usuario haya introducido una opción válida
     * @param opcion
     * @return opción valida
     */
    @Override
    public int validarOpcion(int opcion) {
        while (!OPCIONES_COCHE.inclou(opcion)) {
            teclado.out("Introduce una opción válida: ");
            opcion = teclado.inInt();
        }
        return opcion;
    }

}

