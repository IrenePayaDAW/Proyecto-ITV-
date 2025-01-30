package itv;

import java.util.Arrays;
import util.GestorIO;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public class Cola {

    private Vehiculo[] vehiculos;

    public Cola() {
        this.vehiculos = new Vehiculo[0];
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        Vehiculo[] colaVehiculo = Arrays.copyOf(this.vehiculos, this.vehiculos.length + 1);
        colaVehiculo[colaVehiculo.length - 1] = vehiculo;
        vehiculos = colaVehiculo;
    }
    /**
     * EXTRAE UN VEHICULO DE LA COLA
     * @return (EL VEHICULO DE LA COLA)
     */
    public Vehiculo extraerVehiculo() {
        Vehiculo aux = this.vehiculos[0];
        this.avanzarVehiculos();
        return aux;
    }

    /**
     * método para crear un array y actualizarlo de las matrículas de aquellos vehículos que pasan por la cola para que no se pueda repetir la matrícula
     * @param matricula
     * @return boolean 
     */
    public boolean validarmMatriculasVehiculosCola(String matricula) {
        for (int i = 0; i < this.vehiculos.length; i++) {
            if (this.vehiculos[i].tieneEstaMatricula(matricula)) {
                return true;
            }
        }
        return false;

    }
    /**
     * Comprueba si la cola está vacía
     * @return boolean
     */
    public boolean estaVacia() {
        return vehiculos.length == 0;
    }
    /**
     * Devuelve un array de vehículos
     * @return 
     */
    public Vehiculo[] getVehiculos() {
        return this.vehiculos;
    } 
    /**
     * AVANZA TODOS LOS VEHÍCULOS UNA POSICIÓN EN LA COLA
     */
    private void avanzarVehiculos() {
        this.vehiculos = Arrays.copyOfRange(this.vehiculos, 1, this.vehiculos.length);
    }//(CORREGIDO)
    
    /**
     * Imprime la cola entera
     */
    public void mostrarCola() {
        GestorIO teclado = new GestorIO();
        teclado.out("\n\n--Cola de vehículos--\n");
        for (int i = 0; i < this.vehiculos.length; i++) {
            teclado.out("\nPosición " + (i + 1) + ":\n");
            this.vehiculos[i].mostrarTodo();
            teclado.out("\n");
        }
        teclado.out("\n\n");
    }
    public Vehiculo getPrimerVehiculo(){
        return this.vehiculos[0];
    }
}
