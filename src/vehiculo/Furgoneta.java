package vehiculo;

import util.Interval;
/**
 * 
 * @author irene, alvaro, alejandro
 */
public class Furgoneta extends TransporteCarga {

    public Furgoneta(double pma, int cilindros, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, pma);
    }

    
    public Furgoneta(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }

    /**
     * Valida la cantidad de cilindros asegurando que esté dentro del rango permitido.
     * 
     * @return Número de cilindros válido.
     */
    @Override
    public int validarCilindros() {
        int cilindros;
        boolean error;
        Interval limite = new Interval(4, 10);
        do {
            error = false;
            teclado.out("Introduce los cilindros: ");
            cilindros = teclado.inInt();
            if (!limite.inclou(cilindros)) {
                error = true;
                teclado.out("Solo puede tener entre 4 y 10 cilindros.\n");
            }
        } while (error);

        return cilindros;
    }
    
    /**
     * Obtiene el tipo de vehículo.
     * 
     * @return "Furgoneta" como tipo de vehículo.
     */
    @Override
    public String getTipo() {
        return "Furgoneta";
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