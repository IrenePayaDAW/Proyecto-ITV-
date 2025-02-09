/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

import itv.Cola;
import itv.Taller;
import util.GestorIO;

/**
 *
 * @author acarr
 */
class OpcionTaller extends Opcion {
    GestorIO teclado = new GestorIO();
    protected Taller taller;
    
    public OpcionTaller() {
        super("Opciones del Taller");
        this.taller = new  Taller();
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
        int opcion = teclado.inInt();

        switch (opcion) {
            case 1:
                new RegistrarNuevoVehiculo().ejecutar(taller);
                break;
            case 2:
                new ReclamacionVehiculo().ejecutar(taller);
                break;
            case 3:
                new PasarDeFase().ejecutar(taller);
                break;
            case 4:
                new MostrarBox().ejecutar(taller);
                break;
            case 5:
                new MostrarBoxes().ejecutar(taller);
                break;
            default:
                teclado.out("Opción no válida.\n");
                break;
        }
    }

}

