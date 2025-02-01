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

    public static void registrarVehiculo(Vehiculo vehiculo) {
        GestorIO teclado = new GestorIO();
        int cc;

        boolean estadoVehiculo = false;
        vehiculo.setCilindros(vehiculo.validarCilindros());
        
        do{
        teclado.out("Introduce la potencia que tiene el vehículo: ");
        cc = teclado.inInt();
        }while (cc < 0);
        vehiculo.setCc(cc);
        vehiculo.registrarVehiculo();

    }

    public Cola getColaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
