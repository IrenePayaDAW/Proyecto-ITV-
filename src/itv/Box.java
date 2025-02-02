package itv;

import itv.FaseRevision;
import util.GestorIO;
import vehiculo.Vehiculo;

/**
 * Classe Box que representa un espai on es realitzen les fases de revisió d'un
 * vehicle.
 */
public class Box {

    GestorIO teclado = new GestorIO();
    private static final int NUM_FASES = 4;
    private FaseRevision[] fases;

    public Box() {
        fases = new FaseRevision[NUM_FASES];
        for (int i = 0; i < NUM_FASES; i++) {
            fases[i] = new FaseRevision(i);
        }
    }

    public boolean estaLibre() {
        return fases[0].estaLibre();
    }

    public void asignarVehiculo(Vehiculo vehiculo) {
        if (estaLibre()) {
            fases[0].asignarVehiculoFase(vehiculo);
            teclado.out("Vehículo con matrícula " + vehiculo.getMatricula() + " asignado al box.");
        } else {
            teclado.out("El box está ocupado.");
        }
    }
    
    public Vehiculo copiarUltimoVehiculo(){
        return this.fases[3].getVehiculo();
    }

    /**
     * Avanza los vehículos de las fases en un box que llama a este método
     */
    public void avanzarVehiculos() {
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

    public void mostrarEstado() {
        for (int i = 0; i < NUM_FASES; i++) {
            String estado = fases[i].estaLibre() ? "vacía" : "ocupada por " + fases[i].getVehiculo().getMatricula();
            teclado.out("\nFase " + (i+1) + " está " + estado + ".");
        }
    }

    public boolean validarMatricula(String matricula) {
        for (int i = 0; i < fases.length; i++) {
            if (!fases[i].validarMatricula(matricula)) {
                return false;
            }
        }
        return true;

    }

    public boolean boxLibre() {
        return this.fases[0].estaLibre();
    }
    
    public boolean ultimaFaseOcupada(){
        return !this.fases[fases.length-1].estaLibre();
    }

}
