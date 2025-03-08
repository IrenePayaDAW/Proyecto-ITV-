/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import cliente.Cliente;
import itv.Taller;
import java.util.Set;

/**
 *
 * @author irene
 */
public class ClientesPorDNI extends OpcionTaller{
    
    public ClientesPorDNI(Taller taller) {
        super("Mostrar clientes ordenados por DNI", taller);
    }

    @Override
    public void ejecutar() {
        Set<Cliente> clientes = taller.listaClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
    
}
