/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import cliente.Cliente;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class Prueba {
    public static void main(String[] args){
        Prueba prueba = new Prueba();
        prueba.inicio();
    }
    
    public void inicio(){
        Cliente clienteNulo = new Cliente("11111111a", "irene", "123456788", false);
        Cliente clienteVip = new Cliente("11111112a", "alvaro", "123456787", true);
        Cliente clienteSocio = new Cliente("11111113a", "pablo", "123456786", false);
        clienteSocio.hacerSocio();
        Cliente clienteTodo = new Cliente("11111114a", "luis", "123456785", true);
        
        Vehiculo vehiculo1 = new Vehiculo(clienteNulo, "1111aaa", );
        Vehiculo vehiculo2 = new Vehiculo();
        Vehiculo vehiculo3 = new Vehiculo(); 
        Vehiculo vehiculo4 = new Vehiculo();
        Vehiculo vehiculo5 = new Vehiculo();
          
        
    }
}
