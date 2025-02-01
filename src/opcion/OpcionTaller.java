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
 * @author acarr
 */
class OpcionTaller extends Opcion {
    GestorIO teclado = new GestorIO();
    protected Taller taller;
    Interval OPCIONES = new Interval(1,5);
    
    public OpcionTaller(String titulo, Taller taller) {
        super(titulo);
        this.taller = taller;
    }
    
    @Override
    public void ejecutar() {
        teclado.out("Menú del Taller:\n");
        teclado.out("1. Registrar nuevo vehículo\n");
        teclado.out("2. Reclamar vehículo\n");
        teclado.out("3. Pasar vehículo de fase\n");
        teclado.out("4. Mostrar estado de un box\n");
        teclado.out("5. Mostrar estado de todos los boxes\n");
        teclado.out("Seleccione una opción: ");
        int opcion = validarOpcion(teclado.inInt());

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
        }
    }
    
    public int validarOpcion(int opcion){
        while(!OPCIONES.inclou(opcion)){
            teclado.out("Introduce una opción válida: ");
            opcion = teclado.inInt();
        }
        return opcion;
    }

}
