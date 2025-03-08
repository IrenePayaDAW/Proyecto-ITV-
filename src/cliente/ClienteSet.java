package cliente;
import excepciones.NotExistsException;
import java.util.*;
/**
 *
 * @author ciclost
 */
public class ClienteSet {
    private HashSet<Cliente> clientes;

    public ClienteSet(){
        clientes = new HashSet<>();
    }
    public ClienteSet(Cliente cliente){
        this();
        clientes.add(cliente);
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }
    
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public Cliente getCliente(String dni) {
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equalsIgnoreCase(dni))return cliente;
        }
        return null;
    }
    
    public TreeSet<Cliente> getClientesVip() throws NotExistsException{
        TreeSet<Cliente> vips = new TreeSet<>();
        for (Cliente cliente : clientes) {
            if(cliente.isVIP())vips.add(cliente);
        }
        if(vips.isEmpty())throw new NotExistsException("ERROR, NO HAY CLIENTES VIP\n");
        return vips;
    }
    
    public void remove(Cliente cliente){
        clientes.remove(cliente);
    }
    
    public void cleanClientes(){
        clientes.clear();
    }
    
    @Override
    public String toString() {
        return "CLIENTES=" + clientes ;
    }
}
