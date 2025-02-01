package itv;

import util.GestorIO;
import util.Interval;
import vehiculo.*;
import java.util.regex.*;

/**
 * Taller ITV - Gestión de vehículos y revisiones.
 * Autor: Irene Payá, Álvaro Carrión, Alejandro Soler
 */
public class Taller {
    private Box[] boxes;
    private Vehiculo[] colaPrincipal;
    private Vehiculo[] colaDePago;
    private String[] matriculasEnTaller;
    private Vehiculo[] vehiculosFinalizados;
    private double ingresosTotales;

    public Taller() {
        boxes = new Box[6];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
        colaPrincipal = new Vehiculo[0];
        colaDePago = new Vehiculo[0];
        matriculasEnTaller = new String[0];
        vehiculosFinalizados = new Vehiculo[0];
        ingresosTotales = 0;
    }

    public static Vehiculo registrarVehiculo() {
        GestorIO teclado = new GestorIO();
        String matricula;
        Pattern patron = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
        boolean esValida;
        int tipo, cilindros;
        double CC, PMA;

        do {
            teclado.out("Introduce la matrícula del coche (formato 1234ABC): ");
            matricula = teclado.inString().toUpperCase().trim();
            Matcher matcher = patron.matcher(matricula);
            esValida = matcher.matches();
            if (!esValida) {
                teclado.out("Matrícula inválida. Debe contener 4 números seguidos de 3 letras.\n");
            }
        } while (!esValida);

        teclado.out("Introduce el modelo de vehículo: ");
        String modeloVehiculo = teclado.inString().trim();

        do {
            teclado.out("Tipos de vehículo:\n1. Coche\n2. Microbus\n3. Furgoneta\n4. Camión\nTipo seleccionado: ");
            tipo = teclado.inInt();
        } while (tipo < 1 || tipo > 4);

        teclado.out("Introduce el número de cilindros: ");
        cilindros = teclado.inInt();

        teclado.out("Introduce la cilindrada en cm³: ");
        CC = teclado.inDouble();

        switch (tipo) {
            case 1:
                teclado.out("Introduce el número de plazas: ");
                int plazasCoche = teclado.inInt();
                return new Coche(cilindros, plazasCoche, CC, matricula, modeloVehiculo);
            case 2:
                teclado.out("Introduce el número de plazas: ");
                int plazasMicrobus = teclado.inInt();
                return new MicroBus(cilindros, plazasMicrobus, CC, matricula, modeloVehiculo);
            case 3:
                teclado.out("Introduce el PMA en toneladas: ");
                PMA = teclado.inDouble();
                return new Furgoneta(PMA, cilindros, CC, matricula, modeloVehiculo);
            case 4:
                teclado.out("Introduce el PMA en toneladas: ");
                PMA = teclado.inDouble();
                return new Camion(PMA, cilindros, CC, matricula, modeloVehiculo);
            default:
                return null;
        }
    }
}
