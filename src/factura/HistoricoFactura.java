package factura;

import static interfaces.Validable.teclado;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import vehiculo.Vehiculo;

/**
 * @author irene, alvaro, alejandro
 */
public class HistoricoFactura {
    private Map<Vehiculo, TreeSet<Factura>> historico;

    public HistoricoFactura() {
        historico = new HashMap<>();
    }
    
    public void agregarFactura(Factura factura){
        TreeSet<Factura> facturasCliente = historico.get(factura.getVehiculo());
        if (facturasCliente == null){
            facturasCliente = new TreeSet<>();
            historico.put(factura.getVehiculo(), facturasCliente);
        }
        facturasCliente.add(factura);
    }
    
    public TreeSet<Factura> obtenerFacturasPorVehiculo(Vehiculo vehiculo){
        TreeSet<Factura> facturasCliente = historico.get(vehiculo);
        if (facturasCliente == null){
            facturasCliente = new TreeSet<>();
        }
        return facturasCliente;
    }
    
    public void mostrarFacturas(){
        for (Vehiculo vehiculo : historico.keySet()) {
            this.mostrarFacturas(vehiculo);
        }
    }
    
    public void mostrarFacturas(Vehiculo vehiculo) {
        System.out.println("-- FACTURAS DEL VEHICULO --");
        for (Factura factura : historico.get(vehiculo)){
            System.out.println(factura);
        }
    }
    
    public double calculoFacturas(){
        double resultado= 0.;
        for (Vehiculo vehiculo : historico.keySet()) {
            for (Factura factura : historico.get(vehiculo)) {
                resultado += factura.getPrecioPagado();
            }
        }
        return resultado;
    }
    
    public boolean isEmpty(){
        return this.isEmpty();
    }
    
    public boolean isVehiculoIn(String matricula){
        for(Vehiculo v : historico.keySet()){
            if(v.getMatricula().equalsIgnoreCase(matricula))return true;
        }
        return false;
    }
    
    public Vehiculo getVehiculo(String matricula){
        for(Vehiculo v : historico.keySet()){
            if(v.getMatricula().equalsIgnoreCase(matricula))return v;
        }
        return null;
    }
}
