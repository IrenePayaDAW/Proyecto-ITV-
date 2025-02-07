
package factura;

import java.time.LocalDateTime;
import java.util.Objects;
import vehiculo.Vehiculo;

/**
 * @author irene, alvaro, alejandro
 */
public class Factura {
    private Vehiculo vehiculo;
    private double precioPagado;
    private LocalDateTime fecha;
    private int ID;
    private boolean VIP;
    private boolean socio;

    public Factura(Vehiculo vehiculo, double precioPagado, LocalDateTime fecha, int ID, boolean VIP, boolean socio) {
        this.vehiculo = vehiculo;
        this.precioPagado = precioPagado;
        this.fecha = LocalDateTime.now();
        this.ID = ID; //donde se encuentre el array de facturas, hacer un método que busca el código más grande de las facturas y le suma 1 para llamar a dicho método desde el constructor y así asignarle un nuevo ID
        this.VIP = VIP;
        this.socio = socio;
    }

    @Override
    public String toString() {
        String clienteVip;
        if (this.VIP){
            clienteVip = "Si";
        }
        else {
            clienteVip = "No";
        }
        
        String clienteSocio;
        if (this.socio){
            clienteSocio = "Si";
        }
        else {
            clienteSocio = "No";
        }
        
        
        return "-- Factura de vehículo--\n"
                + "ID Factura = " + ID + "\n"
                + "Matrícula de vehiculo = " + vehiculo.getMatricula() + "\n"
                + "Fecha de pago = " + fecha + "\n"
                + "Cliente VIP = " + clienteVip + "\n"
                + "Tarjeta de socio = " + clienteSocio
                + "Coste de revisión = " + precioPagado + "€\n";
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
        final Factura other = (Factura) obj;
        if (Double.doubleToLongBits(this.precioPagado) != Double.doubleToLongBits(other.precioPagado)) {
            return false;
        }
        if (this.VIP != other.VIP) {
            return false;
        }
        if (this.socio != other.socio) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return Objects.equals(this.vehiculo, other.vehiculo);
    }
    
    
    
}
