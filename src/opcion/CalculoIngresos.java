/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import util.GestorIO;

/**
 *
 * @author acarr
 */

class CalculoIngresos extends Opcion {
    GestorIO teclado = new GestorIO();
    Taller taller;
    public CalculoIngresos() {
        super("Calcular ingresos del taller");
        taller = new Taller();
    }
     teclado.out("--HISTORIAL DE VEHÍCULOS COBRADOS--\n");
     for(int i = 0; i < vehiculosFinalizados.length; i++){
    System.out.printf("El vehículo (%s) con la matrícula %s ha abonado un total de %.2f€\n", vehiculosFinalizados[i].getTipo(), vehiculosFinalizados[i].getMatricula(), vehiculosFinalizados[i].pagoTotal());
    }
    System.out.printf("\nIngresos totales del taller: %.2f€\n", ingresosTotales);

    

//    @Override
//    public void ejecutar() {
//        
//        double ingresosTotales = taller.calcularIngresosTotales();
//        teclado.out("Los ingresos totales del taller son: " + ingresosTotales + "€\n");
//    }
}
