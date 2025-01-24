package itv;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.GestorIO;
import util.Interval;

/**
 * @author Irene Payá, Álvaro Carrión, Alejando Soler
 */
public class Taller {

    private Box[] boxes;
    private Cola colaPrincipal;
    private String[] matriculasCochesEnTaller;//incluido ahora por mi
    private Interval numBoxes = new Interval(1, 6);

    public Taller() {
        boxes = new Box[6];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
        colaPrincipal = new Cola();
        matriculasCochesEnTaller = new String[1];//incluido ahora por mi
    }

    /**
     * Recoge todos los datos del vehículo
     *
     * @return vehículo
     */
    public static Vehiculo registrarVehiculo() {
        GestorIO teclado = new GestorIO();
        String matricula;
        Pattern patron = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
        boolean esValida;
        TipoVehiculo tipo;
        int cilindros = 0;
        double CC = 0.;

        do {
            teclado.out("Introduce la matrícula del coche (formato 1234ABC): ");
            matricula = teclado.inString().toUpperCase().trim();

            Matcher matcher = patron.matcher(matricula);
            esValida = matcher.matches();

            if (!esValida) {
                teclado.out("Matrícula inválida. Debe contener 4 números seguidos de 3 letras.");
            }
        } while (!esValida);

        String modeloVehiculo;

        teclado.out("Introduce el modelo de vehículo: ");
        modeloVehiculo = teclado.inString().trim();

        tipo = TipoVehiculo.menuEnum();

        boolean estadoVehiculo = false;

        while (cilindros < 0){
        teclado.out("Introduce el número de cilindros que tiene el vehículo: ");
        cilindros = teclado.inInt();
        }

        while (CC < 0){
        teclado.out("Introduce los centimetro cúbicos que tiene el vehículo: ");
        CC = teclado.inInt();
        }
        
        return new Vehiculo(cilindros, CC, matricula, modeloVehiculo, tipo, estadoVehiculo);

    }

    /**
     * Método para comprobar que los boxes están vacios
     *
     * @return
     */
    public boolean boxesVacios() {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (boxes[i].boxLibre()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para comprobar que la matrícula no se encuentra en ninguno de los
     * boxes.
     *
     * @param matricula
     * @return (boolean)
     */
    public boolean comprobarMatriculaBoxes(String matricula) {
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].comprobarMatriculaFases(matricula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para mostrar el menu.
     */
    public void mostrarMenu() {
        GestorIO teclado = new GestorIO();

        teclado.out("\n--- TALLER ITV ---\n");
        teclado.out("1. Alta y recepción de vehículos\n");
        teclado.out("2. Reclamar vehículo para entrar en el box\n");
        teclado.out("3. Mover todos los vehículos de fase dentro de un box\n");
        teclado.out("4. Información del estado de un box concreto\n");
        teclado.out("5. Información general de todos los boxes\n");
        teclado.out("6. Salir del programa\n\n");
    }

    /**
     * Método para comprobar que el valor int introducido por el usuario está
     * entre 1 y 6 (ambos números incluidos).
     *
     * @param opcion
     * @return (boolean)
     */
    public boolean opcion1A6(int opcion) {
        Interval opcionesMenu = new Interval(1, 6);
        return opcionesMenu.inclou(opcion);
    }

    public static void main(String[] args) {
        Taller programa = new Taller();
        programa.inicio();
    }

    /**
     * Método para inicializar el programa.
     */
    public void inicio() {
        int opcion = 0;
        Interval opcionesMenu = new Interval(1, 6);
        GestorIO teclado = new GestorIO();

        this.mostrarMenu();

        while (!this.opcion1A6(opcion)) {

            while (!opcionesMenu.inclou(opcion)) {
                teclado.out("Selecciona una opción: ");
                opcion = teclado.inInt();
                if (!this.opcion1A6(opcion)) {
                    teclado.out("Error: Debes introducir un valor entre 1 y 6\n");
                }

                switch (opcion) {
                    case 1:
                        boolean matriculaRepetida = true;
                        Vehiculo vehiculo1 = null;

                        while (matriculaRepetida) {
                            vehiculo1 = registrarVehiculo();
                            matriculaRepetida = false;

                            for (String matricula : matriculasCochesEnTaller) {
                                if (vehiculo1.getMatricula().equals(matricula)) {
                                    teclado.out("Error: Esta matrícula ya pertenece a un vehículo dentro del taller.\n");
                                    matriculaRepetida = true;
                                    break;
                                }
                            }
                        }
                        colaPrincipal.insertarVehiculo(vehiculo1);

                        matriculasCochesEnTaller = Arrays.copyOf(matriculasCochesEnTaller, matriculasCochesEnTaller.length + 1);
                        matriculasCochesEnTaller[matriculasCochesEnTaller.length - 1] = vehiculo1.getMatricula();
                        inicio();
                        break;
                    case 2:
                        int eleccionBox;
                        if (this.colaPrincipal.estaVacia()) {
                            teclado.out("La cola está vacía.\n");

                        } else { //TIENE QUE PEDIR EL BOX DONDE SE QUIERE ASIGNAR EL VEHÍCULO
                            teclado.out("Cual box quieres selecionar (1 - 6)");
                            eleccionBox = teclado.inInt();
                            while (!numBoxes.inclou(eleccionBox)) {
                                teclado.out("Error, los boxes están entre 1 y 6.");
                                eleccionBox = teclado.inInt();
                            };
                            if (boxes[eleccionBox - 1].boxLibre()) {
                                teclado.out("Vehiculo introduccido en el box " + eleccionBox);
                                boxes[eleccionBox - 1].asignarVehiculo(colaPrincipal.extraerVehiculo());
                            } else {
                                teclado.out("El box está ocupado");
                            }
                        }//(CORREGIDO)

                        inicio();
                        break;
                    case 3:
                        int boxSeleccionado = 0;
                        teclado.out("Introduce el box en el que quieras mover de fase a todos sus vehículos: ");
                        boxSeleccionado = teclado.inInt();
                        boxes[boxSeleccionado - 1].avanzarVehiculos();
                        teclado.out("Los vehículos del box " + (boxSeleccionado) + " Han avanzado a la siguiente fase.\n");

                        inicio();
                        break;
                    case 4:
                        int numeroBox = 0;
                        teclado.out("Dime un número de box para consultar su estado (1 - 6): ");
                        numeroBox = teclado.inInt();
                        while (!this.opcion1A6(numeroBox)) {
                            teclado.out("Número de box inválido. Debe estar entre 1 y 6.\n");
                            teclado.out("Volver a insertar: ");
                            numeroBox = teclado.inInt();
                            teclado.out("\n");
                        }
                        if (this.boxes[numeroBox - 1] == null) {
                            teclado.out("El box se encuentra vacío.\n");
                        } else {
                            teclado.out("Estado del box " + numeroBox + ":\n");
                            this.boxes[numeroBox - 1].mostrarEstado();
                        }
                        inicio();
                        break;
                    case 5:
                        teclado.out("--Estado de todos los box--\n");
                        for (int i = 0; i < boxes.length; i++) {
                            teclado.out("Box " + (i + 1) + ":\n");
                            boxes[i].mostrarEstado();
                            teclado.out("\n");
                        }
                        inicio();
                        break;
                    case 6:
                        teclado.out("Fin del programa.\n");
                }
            }

        }

    }

}
