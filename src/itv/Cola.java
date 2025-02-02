package itv;

import vehiculo.Vehiculo;
import util.GestorIO;
import java.util.Arrays;

/**
 * Classe que representa una cua de vehicles en el taller.
 */
public class Cola {
    private Vehiculo[] vehiculos;

    public Cola() {
        this.vehiculos = new Vehiculo[0];
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        Vehiculo[] nuevaCola = Arrays.copyOf(this.vehiculos, this.vehiculos.length + 1);
        nuevaCola[nuevaCola.length - 1] = vehiculo;
        this.vehiculos = nuevaCola;
    }

    public Vehiculo extraerVehiculo() {
        if (estaVacia()) {
            return null;
        }
        Vehiculo vehiculo = this.vehiculos[0];
        this.vehiculos = Arrays.copyOfRange(this.vehiculos, 1, this.vehiculos.length);
        return vehiculo;
    }

    public boolean validarMatricula(String matricula) {
        for (int i = 0; i < this.vehiculos.length; i++) {
            if (this.vehiculos[i].tieneEstaMatricula(matricula)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaVacia() {
        return this.vehiculos.length == 0;
    }
    
    public Vehiculo[] getVehiculos() {
        return this.vehiculos;
    }

    public void mostrarCola() {
        GestorIO teclado = new GestorIO();
        teclado.out("\n-- Cola de Vehicles --\n");
        for (int i = 0; i < this.vehiculos.length; i++) {
            teclado.out("\nPosició " + (i + 1) + ":\n");
            this.vehiculos[i].mostrarTodo();
            teclado.out("\n");
        }
        teclado.out("\n");
    }
}
