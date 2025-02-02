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
 * @author acarr
 */

public class CalculoIngresos extends Opcion {
    
    private Vehiculo[] vehiculosFinalizados;
    
    public CalculoIngresos(Taller taller) {
        super("Calculo ingresos totales",taller);
        vehiculosFinalizados = new Vehiculo[0];     
    }
    
    public void insertarVehiculo(Vehiculo vehiculo) {
        Vehiculo[] nuevaCola = Arrays.copyOf(this.vehiculosFinalizados, this.vehiculosFinalizados.length + 1);
        nuevaCola[nuevaCola.length - 1] = vehiculo;
        this.vehiculosFinalizados = nuevaCola;
    }

    @Override
    public void ejecutar() {
        double ingresosTotales = 0;
        for (int i = 0; i < vehiculosFinalizados.length; i++) {
            ingresosTotales += vehiculosFinalizados[i].calcularPrecio();
        }
        teclado.out("Han sido cobrados: "+ vehiculosFinalizados.length +" vehiculos");
        teclado.out("El total de ingresos es de: "+ ingresosTotales);
    }
}
