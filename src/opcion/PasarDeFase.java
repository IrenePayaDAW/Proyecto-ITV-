/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opcion;

/**
 *
 * @author acarr
 */
class PasarDeFase extends OpcionTaller {
    public PasarDeFase() {
        super(null);
    }

    @Override
    public void ejecutar(Taller taller) {
        GestorIO teclado = new GestorIO();
        teclado.out("Ingrese el número de box donde desea pasar los vehículos de fase: ");
        int numeroBox = teclado.inInt();

        if (taller.existeBox(numeroBox)) {
            taller.pasarVehiculosDeFase(numeroBox);
            teclado.out("Los vehículos del box " + numeroBox + " han avanzado a la siguiente fase.\n");
        } else {
            teclado.out("El box ingresado no existe.\n");
        }
    }
}