/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Taller;
import util.GestorIO;

/**
 *
 * @author irene
 */
public class VehiculoMatriculaNueva extends OpcionTaller{

    public VehiculoMatriculaNueva(Taller taller) {
        super("Mostrar vehiculo con la matrícula más nueva", taller);
    }

    @Override
    public void ejecutar() {
        GestorIO teclado = new GestorIO();
       
        if(taller.listaVehiculosOrdenados().isEmpty()){
            teclado.out("NO HAY VEHICULOS EN LA COLA");
        }else{
             teclado.out("EL VEHÍCULO CON LA MATRÍCULA MÁS NUEVA ES: ");
             teclado.out(taller.listaVehiculosOrdenados().peek().getMatricula());
        }
        
        
    }
    
}
