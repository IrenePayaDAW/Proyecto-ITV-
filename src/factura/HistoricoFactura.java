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
    private Map<String, TreeSet<Factura>> historico;

    public HistoricoFactura() {
        historico = new HashMap<>();
    }
    
    public void agregarFactura(Factura factura){
        TreeSet<Factura> facturasCliente = historico.get(factura.getVehiculo().getMatricula());
        if (facturasCliente == null){
            facturasCliente = new TreeSet<>();
            historico.put(factura.getVehiculo().getMatricula(), facturasCliente);
        }
        facturasCliente.add(factura);
    }
    
    public TreeSet<Factura> obtenerFacturasPorVehiculo(String matricula){
        TreeSet<Factura> facturasCliente = historico.get(matricula);
        if (facturasCliente == null){
            facturasCliente = new TreeSet<>();
        }
        return facturasCliente;
    }
    
    public void mostrarFacturas(){
        for (String matricula : historico.keySet()) {
            this.mostrarFacturas(matricula);
        }
    }
    
    public void mostrarFacturas(String matricula) {
        System.out.println("-- FACTURAS DEL VEHICULO --\n");
        for (Factura factura : historico.get(matricula)){
            System.out.println(factura);
        }
    }
    
    public double calculoFacturas(){
        double resultado= 0.;
        for (String matricula : historico.keySet()) {
            for (Factura factura : historico.get(matricula)) {
                resultado += factura.getPrecioPagado();
            }
        }
        return resultado;
    }
    
    public boolean isEmpty(){
        return historico.isEmpty();
    }
    
    public boolean isVehiculoIn(String matricula){
        return historico.containsKey(matricula);
        
    }
    
}
