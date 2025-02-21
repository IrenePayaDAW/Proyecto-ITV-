package cliente;
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
            if(cliente.getDni().equals(dni))return cliente;
        }
        return null;
    }
    
    public void cleanClientes(){
        clientes.clear();
    }
    
    
    @Override
    public String toString() {
        return "ClienteSet{" + "clientes=" + clientes + '}';
    }
}
