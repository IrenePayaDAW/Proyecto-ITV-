package factura;

import cliente.Cliente;
import java.time.LocalDateTime;
import java.util.Objects;
import vehiculo.Vehiculo;

/**
 * @author irene, alvaro, alejandro
 */
public class Factura implements Comparable<Factura>{
    private Vehiculo vehiculo;
    private double precioPagado;
    private LocalDateTime fecha;
    private int ID;
    private boolean VIP;
    private boolean socio;

    public Factura(Vehiculo vehiculo, Double precio) {
        this.vehiculo = vehiculo;
        this.precioPagado = precio;
        this.fecha = LocalDateTime.now();
        this.VIP = vehiculo.clienteIsVIP();
        this.socio = vehiculo.clienteIsSOCIO();
        this.ID = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrecioPagado() {
        return precioPagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isVIP() {
        return VIP;
    }

    public boolean isSocio() {
        return socio;
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


    public void mostrar() {
        System.out.println(this.toString());
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

    @Override
    public int compareTo(Factura o) {
        return this.getFecha().compareTo(o.getFecha());
    }
    
}