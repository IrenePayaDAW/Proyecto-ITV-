/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import vehiculo.Furgoneta;
import vehiculo.Vehiculo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;

/**
 *
 * @author acarr
 */
class ReclamacionVehiculo extends OpcionTaller {
    public ReclamacionVehiculo(Taller taller) {
        super("Reclamar vehículo", taller);
    }

    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        if (taller.hayVehiculosEnCola()) {
            Vehiculo vehiculo = taller.reclamarVehiculo();
            teclado.out("El vehículo con matrícula " + vehiculo.getMatricula() + " ha sido reclamado y está listo para entrar en el box.\n");
        } else {
            teclado.out("No hay vehículos en la cola para reclamar.\n");
        }
    }
}

