
package cliente;

import java.util.Objects;
import java.util.UUID;
import vehiculo.Vehiculo;

/**
 *
 * @author Irene, Álvaro, Alejandro
 */
public class Cliente {
    private  final String DNI;
    private String nombre;
    private  String telefono;
    private  boolean vip;
    private  boolean socio; 
    private int contVecesAqui;
    private int cochesTiene;
    
    public Cliente(String dni,String nombre,String telefono, boolean VIP) {
        this.DNI = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vip = VIP;
        this.contVecesAqui = 0;
    }
    
    public double descuentoPrimeraVez(){
        if(contVecesAqui == 0){
            return 0.7; //Es un 30% de descuento
        }
        return 0;
    }
    
    public double descuentoSocio(){
        return 0;
    }
    
    public double descuentoVip(){
        return 0;
    }
    
    public String getDni() {
        return DNI;
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
        return Objects.equals(this.DNI, other.DNI);
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", telefono=" + telefono + ", VIP=" + vip + ", SOCIO=" + socio + ", contVecesAqui=" + contVecesAqui + '}';
    }
    
}