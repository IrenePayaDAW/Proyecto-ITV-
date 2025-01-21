package itv;

import util.GestorIO;
import util.Interval;

/**
 * @author Alejandro Soler Cruz, Álvaro Carrión Romero e Irene Payá Hernández
 */
public enum TipoVehiculo {

    COCHE("Coche"), MICROBUS("Microbús"), FURGONETA("Furgoneta"), CAMION("Camión");

    private String tipo;

    private TipoVehiculo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.valueOf(tipo);
    }
    /**
     * Método para escoger el tipò de vehículo que se tiene, solamente estos tipos
     * @return TipoVehiculo (Un tipo vehículo Enum) 
     */
    public static TipoVehiculo menuEnum() {
        GestorIO teclado = new GestorIO();
        teclado.out("\n--Selecciona el tipo de vehículo--\n");
        teclado.out("1. Coche\n");
        teclado.out("2. Microbús\n");
        teclado.out("3. Furgoneta\n");
        teclado.out("4. Camión\n\n");
        teclado.out("Opcion: ");
        
        int opcion;
        opcion = menuEnum(teclado.inInt());
        teclado.out("\n");
        return TipoVehiculo.values()[opcion -1];
    }

    private static int menuEnum(int opcion) {
        Interval intervalo = new Interval(1, 4);
        GestorIO teclado = new GestorIO();
        while (!intervalo.inclou(opcion)) {
            teclado.out("Introduce una opción: ");
            opcion = teclado.inInt();
            if (opcion < 1 || opcion > 4) {
                teclado.out("Error: Debes introducir un valor entre 1 y 4\n");
            }
        }
        return opcion;
    }

}
