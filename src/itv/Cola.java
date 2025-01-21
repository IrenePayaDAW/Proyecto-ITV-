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

    public Vehiculo extraerVehiculo() {
        Vehiculo aux = this.vehiculos[0];
        this.avanzarVehiculos();
        return aux;

        //return aux;
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
     * Avanza todos los vehículos una posición
     */
    private void avanzarVehiculos() {
        for (int i = 0; i < this.vehiculos.length - 1; i++) {
            this.vehiculos[i] = this.vehiculos[i + 1];
        }
    }
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
}
