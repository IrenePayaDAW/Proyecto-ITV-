
package cliente;

import java.util.Objects;
import java.util.UUID;
import vehiculo.Vehiculo;

/**
 *
 * @author Irene, Álvaro, Alejandro
 */
public class Cliente {
    private  String ID;
    private String nombre;
    private  String telefono;
    private  boolean vip;
    private  boolean socio; 
    private int contVecesAqui;
    private int cochesTiene;
    
    public Cliente(String nombre,String telefono, boolean VIP) {
        this.ID = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.telefono = telefono;
        this.vip = VIP;
    }
    
    public double descuentoPrimeraVez(){
        return 0.7; //Es un 30% de descuento
    }
    
    public double descuentoSocio(){
        return 0;
    }
    
    public double descuentoVip(){
        return 0;
    }
    
    public String getID() {
        return ID;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isVIP() {
        return vip;
    }

    public boolean isSOCIO() {
        return socio;
    }

    public int getContVecesAqui() {
        return contVecesAqui;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.ID, other.ID);
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "ID=" + ID + ", telefono=" + telefono + ", VIP=" + vip + ", SOCIO=" + socio + ", contVecesAqui=" + contVecesAqui + '}';
    }
    
}