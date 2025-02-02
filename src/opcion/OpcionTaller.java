/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Cola;
import itv.Taller;
import util.GestorIO;
import util.Interval;

/**
 *
 * @author irene, alvaro, alejandro
 */
public class OpcionTaller extends Opcion {

    
    private Interval OPCIONES = new Interval(1, 8);
    private CalculoIngresos calculoIngresos; 
    private CalculoPagamentosRevisados calculoPagamentosRevisados; 
    public OpcionTaller(String titulo, Taller taller) {
        super(titulo, taller);
        this.calculoIngresos = new CalculoIngresos(taller);
        this.calculoPagamentosRevisados = new CalculoPagamentosRevisados(taller, this.calculoIngresos);
    }

    /**
     * Ejecuta las opciones 
     */
    public void ejecutar() {
        
        int opcion;
        do {
            teclado.out("Seleccione una opción: ");
            opcion = validarOpcion(teclado.inInt());

            switch (opcion) {
                case 1:
                    new RegistroNuevoVehiculo(taller).ejecutar();
                    break;
                case 2:
                    new ReclamacionVehiculo(taller).ejecutar();
                    break;
                case 3:
                    new PasarDeFase(taller).ejecutar();
                    break;
                case 4:
                    new MostrarBox(taller).ejecutar();
                    break;
                case 5:
                    new MostrarBoxes(taller).ejecutar();
                    break;
                case 6:
                    this.calculoPagamentosRevisados.ejecutar();
                    break;
                case 7:
                    this.calculoIngresos.ejecutar();
                    break;
                case 8:
                    teclado.out("Fin del programa\n");
                    break;
            }
            
            super.mostrar();
        } while (opcion != 8);

    }

    /**
     * valida que el usuario introduzca una opción válida
     * @param opcion
     * @return opción válida
     */
    public int validarOpcion(int opcion) {
        while (!OPCIONES.inclou(opcion)) {
            teclado.out("Introduce una opción válida: ");
            opcion = teclado.inInt();
        }
        return opcion;
    }

}
