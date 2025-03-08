/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import excepciones.NotExistsException;
import itv.Taller;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class VehiculoMatriculaNueva extends OpcionTaller {
    
    public VehiculoMatriculaNueva(Taller taller) {
        super("Mostrar vehiculo con la matrícula más nueva", taller);
    }
    
    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
        
        Vehiculo vehiculo;
        try {
            vehiculo = Taller.encontrarMaximo(taller.getVehiculos());
            teclado.out("EL VEHÍCULO CON LA MATRÍCULA MÁS NUEVA ES: " + vehiculo.getMatricula());
        } catch (NotExistsException ex) {
            teclado.out(ex.toString());
        }
        
    }
    
}


