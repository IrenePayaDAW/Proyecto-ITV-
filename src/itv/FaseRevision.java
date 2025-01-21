package itv;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public class FaseRevision {

    private final static String[] fases = {"Revisión inicial de elementos de seguridad", "Revisión del sistema eléctrico", "Revisión de emisión de humos", "Revisión de frenos y dirección"};
    private String nombreFase;
    private Vehiculo vehiculo;

    public FaseRevision(int posicion) {
        this.nombreFase = fases[posicion];
        this.vehiculo = null;
    }
    /**
     * Incluye un vehículo a la fase que usa este método.
     * @param vehiculo 
     */
    public void asignarVehiculoFase(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    /**
     * Muestra el nombre correspondiente de esta fase que usa el método.
     * @return String (nombre de la fase)
     */
    public String mostrarNombreFase() {
        return this.nombreFase;
    }
    /**
     * Elimina el vehículo de la fase que llama al método
     */
    public void eliminarVehiculo() {
        this.vehiculo = null;
    }
    /**
     * Comprueba si la fase está libre de vehículos
     * @return boolean
     */
    public boolean estaLibre() {
        return this.vehiculo == null;
    }
    /**
     * Recoge la matrícula que tiene el vehículo que está en la fase que llama al método
     * @return String (Matricula del coche)
     */
    public String getMatricula() {
        return this.vehiculo.getMatricula();
    }
    /**
     * Recoge le vehículo que está en la fase que llama al método
     * @return Vehículo (De la fase)
     */
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    /**
     * Inserta un vehículo en la fase que llama al método
     * @param vehiculo 
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
