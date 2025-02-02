package vehiculo;

import util.Interval;

/**
 * Classe Camion que representa un vehicle de transport de càrrega.
 * Aplica les tarifes específiques per a camions.
 */
public class Camion extends TransporteCarga {
    private static final int FIJO_ADICIONAL = 40;

    public Camion(double PMA, int cilindros, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, PMA);
    }

     public Camion(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }
     
    @Override
    public double calcularPrecio() {
        double precioBase = super.calcularPrecio();
        double incrementoPorcentaje = precioBase * 0.2;
        double incrementoPotencia = (this.getPotencia() > 2000) ? 20 : 0;
        return precioBase + FIJO_ADICIONAL + incrementoPorcentaje + incrementoPotencia;
    }

    @Override
    public String getTipo() {
        return "Camion";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
    
     @Override
    public int validarCilindros() {
       int cilindros;
        boolean error;
        Interval limite = new Interval(8,16);
        do {
            error = false;
            teclado.out("Introduce los cilindros: ");
            cilindros = teclado.inInt();
            if (!limite.inclou(cilindros)) {
                error = true;
                teclado.out("Solo puede tener entre 8 y 16 cilindros.\n");
            }
        } while (error);

        return cilindros;
    }

}

