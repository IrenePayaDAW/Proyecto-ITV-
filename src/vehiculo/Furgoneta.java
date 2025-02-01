package vehiculo;

import util.Interval;

/**
 * Classe Furgoneta que representa un vehicle de transport de càrrega.
 * Aplica les tarifes específiques per a furgonetes.
 */
public class Furgoneta extends TransporteCarga {
    public Furgoneta(double pma, int cilindros, double CC, String matricula, String modeloVehiculo) {
        super(cilindros, CC, matricula, modeloVehiculo, pma);
    }

     public Furgoneta(String matricula, String modeloVehiculo) {
        super(matricula, modeloVehiculo);
    }

    @Override
    public int validarCilindros() {
       int cilindros;
        boolean error;
        Interval limite = new Interval(4,10);
        do {
            error = false;
            teclado.out("Introduce los cilindros: ");
            cilindros = teclado.inInt();
            if (!limite.inclou(cilindros)) {
                error = true;
                teclado.out("Solo puede tener entre 4 y 10 cilindros.");
            }
        } while (error);

        return cilindros;
    }
    
    @Override
    public String getTipo() {
        return "Furgoneta";
    }

    @Override
    public double pagoTotal() {
        return this.calcularPrecio();
    }
}

