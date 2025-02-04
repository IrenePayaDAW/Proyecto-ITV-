package vehiculo;

import util.GestorIO;
import util.Interval;

/**
 * @author irene, alvaro, alejandro
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

    /**
     * Verifica si el vehículo tiene una matrícula específica.
     * 
     * @param matricula Matrícula a verificar.
     * @return true si la matrícula coincide, false en caso contrario.
     */
    public boolean tieneEstaMatricula(String matricula) {
        return this.matricula.equalsIgnoreCase(matricula);
    }

    /**
     * Marca el vehículo como terminado en su revisión.
     */
    public void vehiculoTerminado() {
        teclado.out("El vehículo con la matrícula " + this.matricula + " ha completado la revisión.\n");
    }

    /**
     * Obtiene la matrícula del vehículo.
     * 
     * @return Matrícula del vehículo.
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return this.modeloVehiculo;
    }
    
    /**
     * Obtiene la potencia del vehículo.
     * 
     * @return Potencia en centímetros cúbicos.
     */
    public double getPotencia() {
        return this.CC;
    }
    
    /**
     * Obtiene el número de cilindros del vehículo.
     * 
     * @return Número de cilindros.
     */
    public int getCilindros() {
        return this.cilindros;
    }

    /**
     * Obtiene el estado del vehículo en la revisión.
     * 
     * @return true si el vehículo ha pasado la revisión, false en caso contrario.
     */
    public boolean getEstado() {
        return this.estadoVehiculo;
    }
    
    /**
     * Solicita e inserta la potencia del vehículo.
     */
    public void insertarCc(){
        int cc;
        do {
            teclado.out("Introduce la potencia que tiene el vehículo: ");
            cc = teclado.inInt();
        } while (cc < 0);
        this.CC = cc;
    }
    
    /**
     * Solicita e inserta el número de cilindros del vehículo.
     */
    public void insertarCilindros(){
        this.cilindros = this.validarCilindros();
    }
    
    /**
     * Cambia el estado del vehículo en la revisión.
     * 
     * @param nuevoEstado Nuevo estado del vehículo.
     */
    public void setEstado(boolean nuevoEstado) {
        this.estadoVehiculo = nuevoEstado;
    }
    
    /**
     * Muestra toda la información del vehículo.
     */
    public void mostrarTodo(){
        teclado.out("-------Datos del vehículo----------");
        teclado.out("Matrícula: "+this.matricula);
        teclado.out("Tipo de vehículo: "+this.getTipo());
        teclado.out("Centímetros cúbicos: "+this.CC);
        teclado.out("Cantidad cilindros: "+this.cilindros);
        teclado.out("Modelo: "+this.modeloVehiculo);
        teclado.out("El vehículo ha pasado la revisión: "+this.estadoVehiculo);
    }

    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return Tipo de vehículo.
     */
    public abstract String getTipo();
    
    /**
     * Calcula el precio total de la revisión del vehículo.
     * 
     * @return Precio total de la revisión.
     */
    public abstract double calcularPrecio();
    
    /**
     * Obtiene el pago total de la revisión.
     * 
     * @return Monto total a pagar.
     */
    public abstract double pagoTotal();
    
    /**
     * Valida el número de cilindros del vehículo.
     * 
     * @return Número de cilindros válido.
     */
    public abstract int validarCilindros();
    
    /**
     * Registra el vehículo en el sistema.
     */
    public abstract void registrarVehiculo();
}