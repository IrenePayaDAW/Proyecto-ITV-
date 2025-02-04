package vehiculo;

import util.GestorIO;
import util.Interval;

/**
 * 
 * @author irene, alvaro, alejandro
 */
public abstract class TransportePersonas extends Vehiculo {
    private final int PLAZAS_GRATUITAS = 3;
    private int plazas;
    private double costePlazasAdicionales;
    protected Interval limitesPlazas;

    public TransportePersonas(int cilindros, double CC, String matricula, String modeloVehiculo, int plazas, double costePlazasAdicionales, Interval limitesPlazas) {
        super(cilindros, CC, matricula, modeloVehiculo);
        this.plazas = plazas;
        this.costePlazasAdicionales = costePlazasAdicionales;
        this.limitesPlazas = limitesPlazas;
    }

    public TransportePersonas(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }
    
    /**
     * Valida la cantidad de cilindros asegurando que esté dentro del rango permitido.
     * 
     * @return Número de cilindros válido.
     */
    public int validarCilindros() {
        int cilindros;
        boolean error;
        Interval limite = new Interval(2,6);
        do {
            error = false;
            teclado.out("Introduce los cilindros: ");
            cilindros = teclado.inInt();
            if (!limite.inclou(cilindros)) {
                error = true;
                teclado.out("Solo puede tener entre 2 y 6 cilindros.\n");
            }
        } while (error);
        return cilindros;
    }
    
    /**
     * Registra el vehículo pidiendo al usuario que introduzca las plazas.
     */
    public void registrarVehiculo(){
        this.plazas = this.validarPlazas();
    }
    
    /**
     * Método abstracto para validar la cantidad de plazas del vehículo.
     * 
     * @return Número de plazas válido.
     */
    public abstract int validarPlazas();

    /**
     * Calcula el costo adicional por plazas adicionales y potencia.
     * 
     * @return Costo adicional calculado.
     */
    protected double calcularAdicional() {
        double extra = 0;
        if (this.plazas > PLAZAS_GRATUITAS) {
            extra = (this.plazas - PLAZAS_GRATUITAS) * this.costePlazasAdicionales;
        }
        if (this.getPotencia() > 1200) {
            extra += 10;
        }
        return extra;
    }

    /**
     * Calcula el precio total de la revisión del vehículo.
     * 
     * @return Precio total de la revisión.
     */
    @Override
    public double calcularPrecio() {
        return (this.getCilindros() * PRECIO_BASE) + this.calcularAdicional();
    }

    /**
     * Obtiene el número de plazas del vehículo.
     * 
     * @return Número de plazas.
     */
    public int getPlazas() {
        return plazas;
    }
}