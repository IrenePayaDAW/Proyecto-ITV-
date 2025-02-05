/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import java.util.Arrays;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene, alvaro, alejandro
 */

public class CalculoIngresos extends Opcion {
    
    private Vehiculo[] vehiculosFinalizados;
    
    public CalculoIngresos() {
        super("Calculo ingresos totales");
        vehiculosFinalizados = new Vehiculo[0];     
    }
    
    /**
     * Inserta un vehiculo a la cola
     * @param vehiculo 
     */
    public void insertarVehiculo(Vehiculo vehiculo) {
        Vehiculo[] nuevaCola = Arrays.copyOf(this.vehiculosFinalizados, this.vehiculosFinalizados.length + 1);
        nuevaCola[nuevaCola.length - 1] = vehiculo;
        this.vehiculosFinalizados = nuevaCola;
    }

    @Override
    /**
     * calcula los ingresos totales
     */
    public void ejecutar() {
        double ingresosTotales = 0;
        for (int i = 0; i < vehiculosFinalizados.length; i++) {
            ingresosTotales += vehiculosFinalizados[i].calcularPrecio();
        }
        teclado.out("Han sido cobrados: "+ vehiculosFinalizados.length +" vehiculos\n");
        teclado.out("El total de ingresos es de: "+ ingresosTotales + "\n");
    }
}
