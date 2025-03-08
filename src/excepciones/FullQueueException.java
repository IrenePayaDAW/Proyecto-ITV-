/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class FullQueueException extends Exception{
    private Object generaError;
    private Object ultimoCola;

    public FullQueueException(Object generaError, Object ultimoCola, String message) {
        super(message);
        this.generaError = generaError;
        this.ultimoCola = ultimoCola;
    }

    public FullQueueException(Object generaError, Object ultimoCola) {
        this.generaError = generaError;
        this.ultimoCola = ultimoCola;
    }


    public Object getGeneraError() {
        return generaError;
    }

    public Object getUltimoCola() {
        return ultimoCola;
    }
    
    @Override
    public String toString() {
        return "FullQueueException{\nEl elemento: "+ getGeneraError().toString() + ", no puede ser añadido a la cola.\nDebe salir el elemento: "+getUltimoCola().toString()+ '}';
    }

    
}
