package vehiculo;

import util.GestorIO;
import util.Interval;

/**
 * Classe base Vehiculo que representa les característiques generals d'un vehicle.
 * Implementa mètodes comuns i defineix estructura per a herència en subclasses.
 */
public abstract class Vehiculo {
    GestorIO teclado = new GestorIO();
    protected int cilindros;
    protected double CC;
    private final String matricula;
    private final String modeloVehiculo;
    private boolean estadoVehiculo;
    public static final int PRECIO_BASE = 15;

    public Vehiculo(int cilindros, double CC, String matricula, String modeloVehiculo) {
        this.cilindros = cilindros;
        this.CC = CC;
        this.matricula = matricula;
        this.modeloVehiculo = modeloVehiculo;
        this.estadoVehiculo = false;
    }
    
     public Vehiculo(String matricula, String modeloVehiculo){
        this.matricula = matricula;
        this.modeloVehiculo = modeloVehiculo;
    }

    public boolean tieneEstaMatricula(String matricula) {
        return this.matricula.equalsIgnoreCase(matricula);
    }

    public void vehiculoTerminado() {
        teclado.out("El vehiculo con la matrícula " + this.matricula + " ha completado la revisión.\n");
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modeloVehiculo;
    }
    
    public double getPotencia() {
        return this.CC;
    }
    
    public int getCilindros() {
        return this.cilindros;
    }

    public boolean getEstado() {
        return this.estadoVehiculo;
    }
    
    public void insertarCc(){
        int cc;
        do {
            teclado.out("Introduce la potencia que tiene el vehículo: ");
            cc = teclado.inInt();
        } while (cc < 0);
        this.CC = cc;
    }
    
    public void insertarCilindros(){
        this.cilindros = this.validarCilindros();
    }
    public void setEstado(boolean nuevoEstado) {
        this.estadoVehiculo = nuevoEstado;
    }
    
    public void mostrarTodo(){
        teclado.out("-------Datos del vehículo----------");
        teclado.out("Matrícula: "+this.matricula);
        teclado.out("Tipo de vehiculo: "+this.getTipo());
        teclado.out("Centímetros cúbicos: "+this.CC);
        teclado.out("Cantidad cilindros: "+this.cilindros);
        teclado.out("Modelo: "+this.modeloVehiculo);
        teclado.out("El vehiculo ha pasado la revision: "+this.estadoVehiculo);
    }

    public abstract String getTipo();
    
    public abstract double calcularPrecio();
    
    public abstract double pagoTotal();
    
    public abstract int validarCilindros();
    
    public abstract void registrarVehiculo();
}




