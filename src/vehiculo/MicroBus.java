
package vehiculo;

import util.Interval;

/**
 * @author irene, alvaro, alejandro
 */
public class MicroBus extends TransportePersonas {
    private static final double COSTE_PLAZA_ADICIONAL = 2.0;

    
    public MicroBus(int cilindros, int plazas, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, plazas, COSTE_PLAZA_ADICIONAL, new Interval(2, 20));
    }

   
    public MicroBus(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }
     
    /**
     * Valida la cantidad de plazas asegurando que esté dentro del rango permitido.
     * 
     * @return Número de plazas válido.
     */
    @Override
    public int validarPlazas() {
        int plazas;
        boolean error;
        Interval limitesPlazas = new Interval(2, 20);

        do {
            error = false;
            teclado.out("Introduce las plazas del microbús: ");
            plazas = teclado.inInt();
            if (!limitesPlazas.inclou(plazas)) {
                error = true;
                teclado.out("Solo puede tener entre 2 y 20 plazas.\n");
            }            
        } while (error);
        
        return plazas;
    }
    
    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return "MicroBus" como tipo de vehículo.
     */
    @Override
    public String getTipo() {
        return "MicroBus";
    }

    /**
     * Calcula el pago total de la revisión.
     * 
     * @return Pago total a realizar.
     */
    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}