package itv;

import util.GestorIO;
import vehiculo.Vehiculo;

/**
 * Classe Box que representa un espai on es realitzen les fases de revisió d'un vehicle.
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

    public void avanzarVehiculos() {
        if (fases[NUM_FASES - 1].tieneVehiculo()) {
            Vehiculo vehiculo = fases[NUM_FASES - 1].getVehiculo();
            fases[NUM_FASES - 1].eliminarVehiculo();
            teclado.out("Vehículo con matrícula " + vehiculo.getMatricula() + " ha completado la revisión y ha salido del box.");
        }
        for (int i = NUM_FASES - 1; i > 0; i--) {
            if (!fases[i - 1].estaLibre()) {
                fases[i].asignarVehiculoFase(fases[i - 1].getVehiculo());
                fases[i - 1].eliminarVehiculo();
            }
        }
    }

    public void mostrarEstado() {
        for (int i = 0; i < NUM_FASES; i++) {
            String estado = fases[i].estaLibre() ? "vacía" : "ocupada por " + fases[i].getVehiculo().getMatricula();
            teclado.out("Fase " + i + " está " + estado + ".");
        }
        teclado.out("\n");
    }
 
     /** COMPRUEBA SI LA FASE 0 DEL BOX ESTÁ LIBRE
     * @return boolean (Está o no la fase libre)
     */
    public boolean boxLibre() {
        return this.fases[0].estaLibre();
    }
    
    public boolean boxLleno(){
        return !this.fases[fases.length-1].estaLibre();
    }
    
    public Vehiculo getUltimoVehiculo(){
        return this.fases[fases.length-1].getVehiculo();
    }
    
    /**
     * ASIGNA UN VEHICULO AL BOX (LA PRIMERA FASE DE UN BOX)
     * @param vehiculo (DE LA COLA)
     */
    public void asignarVehiculo(Vehiculo vehiculo){
        this.fases[0].asignarVehiculoFase(vehiculo);


    }
}
