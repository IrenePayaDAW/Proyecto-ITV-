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
    private Vehiculo vehiculoError;
    private Vehiculo vehiculoCola;

    public FullQueueException(Vehiculo vehiculoFallo, Vehiculo vehiculoCola, String message) {
        super(message);
        this.vehiculoError = vehiculoFallo;
        this.vehiculoCola = vehiculoCola;
    }

    public FullQueueException(Vehiculo vehiculoFallo, Vehiculo vehiculoCola) {
        super("La cola está llena");
        this.vehiculoError = vehiculoFallo;
        this.vehiculoCola = vehiculoCola;
    }
    
    public String getMatriculaError(){
        return vehiculoError.getMatricula();
    }
    
    public String getMatriculaCola(){
        return vehiculoCola.getMatricula();
    }

    public Vehiculo getVehiculoError() {
        return vehiculoError;
    }

    public Vehiculo getVehiculoCola() {
        return vehiculoCola;
    }
    
    @Override
    public String toString() {
        return "FullQueueException{ El vehiculo con matrícula "+ getMatriculaError() + ", no puede ser añadido a la cola.\nDebe salir el vehículo con la matrícula "+getMatriculaCola()+  '}';
    }

    
}
