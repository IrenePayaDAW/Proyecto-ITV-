package vehiculo;

import util.GestorIO;
import util.Interval;

/**
 * Classe abstracta per a vehicles de transport de persones.
 * Defineix les característiques comunes com el nombre de places i costos addicionals.
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
                teclado.out("Solo puede tener entre 2 y 6 cilindros.");
            }
        } while (error);

        return cilindros;
    }
     
    public abstract int validarPlazas();

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

    @Override
    public double calcularPrecio() {
        return (this.getCilindros() * PRECIO_BASE) + this.calcularAdicional();
    }

    public int getPlazas() {
        return plazas;
    }
}
