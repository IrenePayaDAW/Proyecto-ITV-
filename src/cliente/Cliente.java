package cliente;

import java.util.Objects;
import java.util.UUID;
import vehiculo.Vehiculo;

/**
 *
 * @author Irene, Álvaro, Alejandro
 */
public class Cliente implements Comparable<Cliente> {

    private final String DNI;
    private String nombre;
    private String telefono;
    private boolean vip = false;
    private boolean socio = false;
    private int contSiendoSocio;
    private int contVecesAqui;
    private int vehiculosTiene = 0;
    private double descuentoSocio = 0.97;

    public Cliente(String dni, String nombre, String telefono, boolean VIP) {
        this.DNI = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vip = VIP;
        this.contVecesAqui = 0;
        this.contSiendoSocio = 0;
    }

    public boolean esSuPrimeraVez() {
        return contVecesAqui == 0;
    }

    public double descuentoPrimeraVez() {
        contVecesAqui++;
        return 0.7; //Es un 30% de descuento

    }

    public double descuentoSocio() {
        if (this.contSiendoSocio() == 0) {
            return descuentoSocio;
        }
        contSiendoSocio++;
        if (this.contSiendoSocio() % 2 == 0 && descuentoSocio != 0.90) {
            descuentoSocio -= (contSiendoSocio / 2);
        }
        return descuentoSocio;
    }

    public String getDni() {
        return DNI;
    }
    
    public String getNombre(){
        return nombre;
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

    public void hacerSocio() {
        socio = true;
    }

    public int contSiendoSocio() {
        return contSiendoSocio;
    }
    
    public void unVehiculoMas(){
        vehiculosTiene++;
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
        return "Cliente{" + "DNI=" + DNI + ", telefono=" + telefono + ", VIP=" + vip + ", SOCIO=" + socio + ", Veces Aquí=" + (contVecesAqui==0?" Nunca":contVecesAqui) + '}';
    }

    @Override
    public int compareTo(Cliente t) {
        return this.DNI.compareTo(t.getDni());
    }

    

   
}
