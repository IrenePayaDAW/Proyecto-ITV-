package itv;

import cliente.Cliente;
import cliente.ClienteSet;
import excepciones.AlreadyExistsException;
import excepciones.NotExistsException;
import vehiculo.Vehiculo;
import excepciones.AlreadyExistsException;
import excepciones.FullQueueException;
import factura.Factura;
import java.util.Arrays;
import util.GestorIO;
import util.Interval;


/**
 * @author irene, alvaro, alejandro
 *
 *
 */
public class Taller {

    private GestorIO teclado = new GestorIO();
    private Box[] boxes;
    private Cola colaPrincipal;
    private Cola colaDePago;
    private String[] matriculasEnTaller;
    private double ingresosTotales;
    public final Interval NUMERO_BOXES = new Interval(1, 6);
    private ClienteSet clientes;
    private Factura[] facturas;
    private static int contadorID = 0;

    public Taller() {
        boxes = new Box[6];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
        colaPrincipal = new Cola(20);
        colaDePago = new Cola(4);
        matriculasEnTaller = new String[0];
        ingresosTotales = 0;
        clientes = new ClienteSet();
        facturas = new Factura[0];
    }
    
    
    
    /**
     * HACE EL CÁLCULO DE LAS FACTURAS ACUMULADAS 
     * @return RESULTADO
     * @throws NotExistsException 
     */
    public double calculoFacturas() throws NotExistsException{
        if(facturas.length == 0)throw new NotExistsException("ERROR: Aun no hay facturas");
        double resultado= 0.;
        for(Factura f: facturas){
            resultado += f.getPrecioPagado();
        }
        return resultado;
    }
    
    public void agregarFactura(Factura factura) {
        factura.setID(contadorID);
        contadorID++;
        Factura[] arrayFacturas = new Factura[facturas.length + 1];

        for (int i = 0; i < facturas.length; i++) {
            arrayFacturas[i] = facturas[i];
        }

        arrayFacturas[facturas.length] = factura;
        facturas = arrayFacturas;
    }

    public void mostrarFacturas() throws NotExistsException {
        if(facturas.length == 0)
            throw new NotExistsException("ERROR: Aun no hay facturas registradas.");
        
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }

    /**
     * Busca a un cliente dentro del array de clientes
     *
     * @param dni
     * @return cliente (NULL SI NO ESTÁ)
     * @throws NotExistsException
     * @throws NullPointerException
     */
    public Cliente getClientePorDNI(String dni) throws NotExistsException, NullPointerException{
        try{
            estaEsteDNI(dni);//ESTE MÉTODO LLAMA AL DE ABAJO Y SI SALTA LA EXCEPTION HACE EL FOR
            throw new NotExistsException("ERROR: El cliente con el DNI: " + dni + " no existe.");//SI NO ESTÁ LANZA ESTA EXCEPTION
        }catch(AlreadyExistsException ex){
            return clientes.getCliente(dni);
        }
    }

    /**
     * Verifica si está el dni
     *
     * @param dni
     * @return dni
     * @throws excepciones.AlreadyExistsException
     */
    public String estaEsteDNI(String dni)throws AlreadyExistsException {
        if(clientes.getCliente(dni)!=null)throw new AlreadyExistsException(dni,"ERROR. El DNI que quiere insertar está registrado.");
        return dni;
    }

    /**
     * Añade un Cliente al array de los clientes
     *
     * @param cliente
     */
    public void añadirCliente(Cliente cliente){
        clientes.addCliente(cliente);
    }


    public boolean estaElDni(String dni) {
        if(clientes.getCliente(dni)!=null)return true;
        return false;
    }
    /**
     * Registra un vehículo en el sistema.
     *
     * @param vehiculo el vehículo a registrar.
     */
    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculo.insertarCilindros();
        vehiculo.insertarCc();
        vehiculo.registrarVehiculo();
    }

    /**
     * Verifica si hay vehículos en la cola de pago.
     *
     * @return true si hay vehículos para pagar, false en caso contrario.
     */
    public boolean hayVehiculosParaPagar() {
        return !this.colaDePago.estaVacia();
    }

    /**
     * Extrae un vehículo de la cola de pago.
     *
     * @return el vehículo extraído.
     */
    public Vehiculo extraerVehiculoPago() throws NotExistsException {
        if(this.colaDePago.estaVacia())
            throw new NotExistsException("ERROR: No hay vehículos en la cola de pagos.");
        return this.colaDePago.extraerVehiculo();
    }

    /**
     * Extrae un vehículo de la cola principal.
     *
     * @return el vehículo extraído.
     */
    public Vehiculo extraerVehiculoCola() throws NotExistsException {
        if(this.colaPrincipal.estaVacia())
            throw new NotExistsException("ERROR: No hay vehículos en la cola principal.");
        return this.colaPrincipal.extraerVehiculo();
    }

    /**
     * Si la matrícula ya está registrada en el taller NO será válida.
     * @param matricula la matrícula a validar.
     * @return true si la matrícula es válida.
     */
    public boolean matriculaValida(String matricula) {
        if (colaPrincipal.matriculaValida(matricula)) {
            for (Box box : boxes) {
                if (!box.matriculaValida(matricula)) {
                    return false;
                }
            }
            return true;
        }    
        return false;
    }

    /**
     * Avanza los vehículos en un box específico.
     *
     * @param numeroBox el número del box.
     */
    public void avanzarVehiculos(int numeroBox) {
        boxes[numeroBox - 1].avanzarVehiculos();
    }

    /**
     * Verifica si la cola principal está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean colaEstaVacia() {
        return this.colaPrincipal.estaVacia();
    }

    /**
     * Verifica si hay boxes vacíos.
     *
     * @return true si hay algún box libre, false en caso contrario.
     */
    public boolean boxesVacios() {
        for (Box box : boxes) {
            if (box.boxLibre()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Inserta un vehículo en la cola principal.
     *
     * @param vehiculo el vehículo a insertar.
     */
    public void insertarVehiculo(Vehiculo vehiculo) throws FullQueueException {
        this.colaPrincipal.insertarVehiculo(vehiculo);
    }

    /**
     * Asigna un vehículo a un box específico.
     *
     * @param numeroBox el número del box.
     * @param vehiculo el vehículo a asignar.
     */
    public void asignarVehiculoBox(int numeroBox, Vehiculo vehiculo) {
        boxes[numeroBox - 1].asignarVehiculo(vehiculo);
    }

    /**
     * Muestra el estado de un box específico.
     *
     * @param box el número del box.
     */
    public void mostrarBox(int box) {
        this.boxes[box - 1].mostrarEstado();
    }

    /**
     * Muestra el estado de todos los boxes.
     */
    public void mostrarBoxes() {
        int i = 1;
        for (Box box : boxes) {
            teclado.out("\nBOX " + i++ + "\n");
            box.mostrarEstado();
            teclado.out("\n");
        }
    }

    /**
     * Extrae el último vehículo que pasó por un box específico.
     *
     * @param numeroBox el número del box.
     * @return el vehículo extraído.
     */
    public Vehiculo extraerVehiculoBox(int numeroBox) throws NotExistsException {
        return boxes[numeroBox - 1].copiarUltimoVehiculo();
    }

    /**
     * Verifica si la última fase de un box está ocupada.
     *
     * @param numeroBox el número del box.
     * @return true si la última fase está ocupada, false en caso contrario.
     */
    public boolean ultimaFaseOcupada(int numeroBox) {
        return boxes[numeroBox - 1].ultimaFaseOcupada();
    }

    /**
     * Mueve un vehículo a la cola de pago.
     *
     * @param vehiculo el vehículo a mover.
     */
    public void meterColaPago(Vehiculo vehiculo)throws FullQueueException {
        this.colaDePago.insertarVehiculo(vehiculo);
    }
    /**
     * COMPRUEBA SI EXISTE EL NOMBRE, SI NO EXISTE LO RETORNA SI EXISTE LANZA UNA EXCEPCION
     * @param nombre
     * @return EL NOMBRE
     * @throws AlreadyExistsException 
     */
    public String esteNombreExiste(String nombre) throws AlreadyExistsException{
        for(Cliente c: clientes.getClientes()){
            if(c.getNombre().equalsIgnoreCase(nombre))throw new AlreadyExistsException(nombre, "QUE CASUALIDAD!! Ya existe este nombre!");
        }
        return nombre;
    }
    /**
     * COMPRUEBA SI EXISTE EL TELEFONO, SI NO EXISTE LO RETORNA Y SI EXISTE LANZA UNA EXCEPCION
     * @param telefono
     * @return EL TELEFONO
     * @throws AlreadyExistsException 
     */
    public String esteTelefonoExiste(String telefono) throws AlreadyExistsException{
        for(Cliente c: clientes.getClientes()){
            if(c.getTelefono().equals(telefono))throw new AlreadyExistsException(telefono,"Este teléfono ya existe."+telefono);
        }
        return telefono;
    }
}
