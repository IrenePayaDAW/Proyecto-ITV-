package itv;

import util.GestorIO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alejandro Soler Cruz, Álvaro Carrión Romero e Irene Payá Hernández
 */
public abstract class Vehiculo {

    //BORRAR ANTES DE HACER PULL
    protected int cilindros;
    protected double CC;
    //BORRAR ANTES DE HACER PULL

    private final String matricula; //(4 números y 3 letras)
    private final String modeloVehiculo; //modelo del vehículo
    //private final TipoVehiculo tipo; //Tipo de vehículo (coche, microbús, furgoneta, camión)
    private final int tipo;//Tipo de Vehículo
    boolean estadoVehiculo; //(para señalar si el vehículo es válido/no válido o bien si pasa/no pasa)

    public Vehiculo(int cilindros, double CC, String matricula, String modeloVehiculo, int tipo, boolean estadoVehiculo) {
        this.cilindros = cilindros;
        this.CC = CC;
        this.matricula = matricula;
        this.modeloVehiculo = modeloVehiculo;
        this.tipo = tipo;
        this.estadoVehiculo = estadoVehiculo;
    }

    /**
     * Comprueba que la matricula no sea igual a la que el vehículo que llama al
     * método
     *
     * @param matricula
     * @return boolean
     */
    public boolean tieneEstaMatricula(String matricula) {
        return this.matricula.equalsIgnoreCase(matricula);
    }

    /**
     * Método para asignar a un vehículo el mensaje de que ha terminado todo el
     * proceso de fases
     */
    public void vehiculoTerminado() {
        GestorIO teclado = new GestorIO();
        teclado.out("El coche con la matrícula " + this.matricula + " ha abandonado el taller tras superar todas las fases.\n");
    }

    /**
     * Método para obtener la matrícula del vehículo
     *
     * @return (Matricula del vehículo)
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Método para obtener el modelo del vehículo
     *
     * @return (Modelo del vehículo)
     */
    public String getModelo() {
        return this.modeloVehiculo;
    }

    /**
     * Método para obtener el Tipo de vehículo
     *
     * @return (Tipo de Vehículo)
     */
    public String getTipo() {
        if (this.tipo == 1){
            return "Coche";
        } else if (this.tipo == 2){
            return "Microbús";
        } else if (this.tipo == 3){
            return "Furgoneta";
        }else {
            return "Camión";
        }
    }

    /**
     * Método donde se obtiene el estado en el que se encuentra el vehículo
     */
    public void getEstado() {
        GestorIO teclado = new GestorIO();
        if (this.estadoVehiculo == false) {
            teclado.out("El vehículo con la matrícula " + this.matricula + " aun no ha superado la revisión");
        } else {
            teclado.out("El vehículo con la matrícula " + this.matricula + " ha superado la revisión");
        }
    }

    /**
     * Método para mostrar todas las caraterísticas del vehículo
     */
    public void mostrarTodo() {
        GestorIO teclado = new GestorIO();
        teclado.out("Matricula: " + this.getMatricula() + "\n");
        teclado.out("Modelo: " + this.getModelo() + "\n");
        teclado.out("Tipo: " + this.getTipo() + "\n");
        this.getEstado();
    }
    
    protected int getPrecioBase(){
        return this.cilindros*15;
    }
    
    public abstract double pagoTotal();
}
