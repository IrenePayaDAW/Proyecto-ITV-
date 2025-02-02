package itv;

import util.GestorIO;
import util.Interval;
import vehiculo.*;
import java.util.regex.*;

/**
 * Taller ITV - Gestión de vehículos y revisiones. Autor: Irene Payá, Álvaro
 * Carrión, Alejandro Soler
 */
public class Taller {

    private Box[] boxes;
    private Cola colaPrincipal;
    private Cola colaDePago;
    private String[] matriculasEnTaller;
    private double ingresosTotales;
    public final Interval NUMERO_BOXES = new Interval(1,6);
    
    public Taller() {
        boxes = new Box[6];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
        colaPrincipal = new Cola();
        colaDePago = new Cola();
        matriculasEnTaller = new String[0];
        ingresosTotales = 0;
    }

    public static void registrarVehiculo(Vehiculo vehiculo) {
        GestorIO teclado = new GestorIO();
        int cc;
        boolean estadoVehiculo = false;        
        vehiculo.insertarCilindros();       
        vehiculo.insertarCc();
        vehiculo.registrarVehiculo();

    }

    public boolean hayVehiculosParaPagar() {
        if (this.colaDePago.estaVacia()) {
            return false;
        } else {
            return true;
        }
    }

    public Vehiculo extraerVehiculoPago() {

        return this.colaDePago.extraerVehiculo();

    }
    
    public Vehiculo extraerVehiculoCola(){
        return this.colaPrincipal.extraerVehiculo();
    }

    public boolean validarMatricula(String matricula) {
        if (colaPrincipal.validarMatricula(matricula)) {
            for (int i = 0; i < boxes.length; i++) {
                if (!boxes[i].validarMatricula(matricula)) {
                    return false;

                }
            }
        } else {
            return false;
        }
        return true;
       
    }

    public void avanzarVehiculos(int numeroBox){
        boxes[numeroBox].avanzarVehiculos();
    }
    
    public boolean colaEstaVacia(){
        return this.colaPrincipal.estaVacia();
    }
    
    public boolean boxesVacios() {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (boxes[i].boxLibre()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void asignarVehiculoBox(int numeroBox, Vehiculo vehiculo){
        boxes[numeroBox].asignarVehiculo(vehiculo);
    }
}
