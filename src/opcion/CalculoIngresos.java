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

    @Override
    public void ejecutar() {
        
        double ingresosTotales = taller.calcularIngresosTotales();
        teclado.out("Los ingresos totales del taller son: " + ingresosTotales + "€\n");
    }
}
