package itv;

import util.GestorIO;
import util.Interval;
import vehiculo.Vehiculo;

/**
 * Classe FaseRevision que representa una fase específica del procés de revisió d'un vehicle.
 */
public class FaseRevision {
    GestorIO teclado = new GestorIO();
    Interval LIMITE_POSICION = new Interval(1,4);
    private static final String[] NOMBRES_FASES = {
        "Revisión inicial de elementos de seguridad",
        "Revisión del sistema eléctrico",
        "Revisión de emisión de humos",
        "Revisión de frenos y dirección"
    }; 
    private String nombreFase;
    private Vehiculo vehiculo;

    public FaseRevision(int posicion) {
        this.nombreFase = NOMBRES_FASES[posicion];
        this.vehiculo = null;
    }

    public void asignarVehiculoFase(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNombreFase() {
        return this.nombreFase;
    }

    public void eliminarVehiculo() {
        this.vehiculo = null;
    }

    public boolean estaLibre() {
        return this.vehiculo == null;
    }

    public boolean tieneVehiculo() {
        return this.vehiculo != null;
    }

    public String getMatriculaVehiculo() {
        return (vehiculo != null) ? vehiculo.getMatricula() : "Sin vehículo";
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public boolean validarMatricula(String matricula) {
        return this.vehiculo != null && !this.vehiculo.getMatricula().equalsIgnoreCase(matricula);
    }
    
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    public int validarPosicion(int posicion){
        while(!LIMITE_POSICION.inclou(posicion)){
            teclado.out("Introduce una posición correcta");
            posicion = teclado.inInt();
        }
        return posicion;
    }//(Posiblemente hay que quitar esta mierda)
}
