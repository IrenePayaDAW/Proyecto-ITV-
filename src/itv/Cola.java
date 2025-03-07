package itv;

import excepciones.FullQueueException;
import java.util.ArrayList;
import vehiculo.Vehiculo;
import util.GestorIO;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author irene, alvaro, alejandro
 */
public class Cola<T> {
    private Queue<T> vehiculos;
    private int limiteCola;
   
    public Cola(int limiteCola) {
        this.vehiculos = new LinkedList<T>();
        this.limiteCola = limiteCola;
    }

    /**
     * Inserta un vehículo al final de la cola.
     * 
     * @param vehiculo el vehículo a insertar.
     */
    public void insertarVehiculo(T vehiculo)throws FullQueueException {
        if(vehiculos.size() == limiteCola)throw new FullQueueException(vehiculo, getPrimerVehiculo());
        this.vehiculos.add(vehiculo);
    }

    public T getPrimerVehiculo(){
        return this.vehiculos.peek();
    }
    
    /**
     * Extrae y devuelve el primer vehículo de la cola.
     * 
     * @return el vehículo extraído o null si la cola está vacía.
     */
    public T extraerVehiculo()throws NullPointerException {
        return this.vehiculos.poll();
    }

    /**
     * Si la matrícula ya está registrada en la cola de vehiculos devolvera false porque no es válida
     * 
     * @param matricula la matrícula a validar.
     * @return true si la matrícula es valida.
     */
    public boolean matriculaValida(String matricula) {
        
        for (T vehiculo : vehiculos) {
            if(vehiculo.tieneEstaMatricula(matricula)) return false;
        }
        return true;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si no hay vehículos en la cola, false en caso contrario.
     */
    public boolean estaVacia() {
        return this.vehiculos.size() == 0;
    }
    
    /**
     * Obtiene el array de vehículos en la cola.
     * 
     * @return un array de vehículos.
     */
    public Queue<T> getVehiculos() {
        return this.vehiculos;
    }

    /**
     * Muestra el estado de la cola de vehículos en el taller.
     */
    public void mostrarCola() {
        GestorIO teclado = new GestorIO();
        teclado.out("\n-- Cola de Vehículos --\n");
        int i=0;
        for (T vehiculo : vehiculos) {
            teclado.out("\nPosición " + (i + 1) + ":\n");
            vehiculo.toString();
            teclado.out("\n");
        }       
    }
}
