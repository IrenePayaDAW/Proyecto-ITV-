package itv;

import util.GestorIO;
import util.Interval;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler :)
 */
public class Box {

    private final Interval LIMITE = new Interval(0, 5);
    private FaseRevision[] fases;

    public Box() {
        fases = new FaseRevision[4];
        for (int i = 0; i < fases.length; i++) {
            fases[i] = new FaseRevision(i);
        }
    }
    /**
     * Metodo para recoger solo la primera fase del box.
     * @return Primera Fase del Box
     */
    public FaseRevision getPrimeraFase(){
        return this.fases[0];
    }
    /**
     * Imprime que un vehículo ha terminado todas las revisiones
     * @param vehiculo 
     */
    public void terminado(Vehiculo vehiculo) {
        GestorIO teclado = new GestorIO();
        teclado.out("El vehículo " + vehiculo.getModelo() + ", con matricula " + vehiculo.getMatricula() + " ha superado todas las pruebas");
        vehiculo.estadoVehiculo = true;
    }
    /**
     * Verifica que una matrícula no esté en ningún box
     * @param matricula
     * @return 
     */
    public boolean validarMatriculasVehiculosBox(String matricula) {
        for (int i = 0; i < this.fases.length; i++) {
            if (this.fases[i].getVehiculo().tieneEstaMatricula(matricula)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Inserta un vehículo en la primera fase (si esta fase está libre)
     * @param vehiculo 
     */
    public void recibirNuevoVehiculo(Vehiculo vehiculo) {
        GestorIO teclado = new GestorIO();
        if (fases[0].estaLibre()) {
            fases[0].asignarVehiculoFase(vehiculo);
            teclado.out("Se ha podido introducir el vehículo en el box \n");
        } else {
            teclado.out("Esta Fase está ocupada por el vehículo con la matrícula: " + this.fases[0].getVehiculo().getMatricula());
        }

    }
    /**
     * Avanza los vehículos de las fases en un box que llama a este método
     */
    public void avanzarVehiculos() {
        GestorIO teclado = new GestorIO();
        boolean hayVehiculos = false;
        for (FaseRevision fase : fases) {
            if (!fase.estaLibre()) {
                hayVehiculos = true;
                break;
            }
        }
        if (!hayVehiculos) {
            teclado.out("No hay vehículos en este box para avanzar.\n");
            return;
        }
        if (!fases[fases.length - 1].estaLibre()) {
            Vehiculo ultimoVehiculoFase = fases[fases.length - 1].getVehiculo();
            teclado.out("El vehículo con matrícula " + ultimoVehiculoFase.getMatricula() + " ha superado las fases de revisión y ha abandonado el taller.\n");
            fases[fases.length - 1].eliminarVehiculo();
        }
        for (int i = fases.length - 1; i > 0; i--) {
            if (!fases[i - 1].estaLibre()) { 
                fases[i].setVehiculo(fases[i - 1].getVehiculo());
                fases[i - 1].eliminarVehiculo(); 
            }
        }
        if (fases[0].estaLibre()) {
            teclado.out("La primera fase ahora está libre para recibir nuevos vehículos.\n");
        }
    }
    /**
     * Método para devolver las fases del box
     * @return (Fases del box)
     */
    public FaseRevision[] getFaseRevision() {
        return this.fases;
    }
    /**
     * Comprueba si la primera fase del box está libre
     * @return boolean
     */
    public boolean primeraFaseLibre(){
        return this.fases[0].estaLibre();
    }
    /**
     * Comprueba que la matricula que pasa por parámetro no está dentro de las fases que tiene el box que llama al método
     * @param matricula
     * @return boolean
     */
    public boolean comprobarMatriculaFases(String matricula) {
        for (int i = 0; i < fases.length; i++) {
            if (fases[i].getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Imprime si está vacia las fases del box o están ocupado por un vehículo
     */
    public void mostrarEstado() {
        GestorIO teclado = new GestorIO();
        for (int i = 0; i < this.fases.length; i++) {
            if (this.fases[i].estaLibre()) {
                teclado.out("La fase " + this.fases[i].mostrarNombreFase() + " se encuentra vacía.\n");
            } else {
                teclado.out("La fase " + this.fases[i].mostrarNombreFase() + " se encuentra ocupada por el vehículo con matrícula " + this.fases[i].getVehiculo().getMatricula() + ".\n");
            }
        }
        teclado.out("\n");
    }
    /**
     * Asigna el vehículo pasado como parámetro a la 1ª fase del box
     */
    public void asignarVehiculo(Vehiculo vehiculo){
        this.fases[0].setVehiculo(vehiculo);
    }
}
