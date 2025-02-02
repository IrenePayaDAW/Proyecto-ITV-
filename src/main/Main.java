/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import itv.Taller;
import opcion.CalculoPagamentosRevisados;
import opcion.MostrarBox;
import opcion.MostrarBoxes;
import opcion.Opcion;
import opcion.RegistroNuevoVehiculo;
import opcion.CalculoIngresos;
import opcion.PasarDeFase;
import opcion.ReclamacionVehiculo;
import opcion.OpcionTaller;

/**
 *
 * @author irene
 */
public class Main {

    Taller taller;
    Opcion menu;
    
    public Main() {
        this.taller = new Taller();
        this.menu = new OpcionTaller("Opciones", taller);
          
    }
    
    public static void main(String[] args) {
        Taller taller = new Taller();
        Opcion menu = new OpcionTaller("Opciones", taller);
        menu.mostrar();       
        menu.ejecutar();
    }
}

