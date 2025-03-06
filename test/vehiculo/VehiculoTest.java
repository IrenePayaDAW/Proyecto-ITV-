/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vehiculo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author irene
 */
public class VehiculoTest {
    
    public VehiculoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testClienteIsVIP() {
        System.out.println("clienteIsVIP");
        Vehiculo instance = null;
        boolean expResult = false;
        boolean result = instance.clienteIsVIP();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testClienteIsSOCIO() {
        System.out.println("clienteIsSOCIO");
        Vehiculo instance = null;
        boolean expResult = false;
        boolean result = instance.clienteIsSOCIO();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTieneEstaMatricula() {
        System.out.println("tieneEstaMatricula");
        String matricula = "";
        Vehiculo instance = null;
        boolean expResult = false;
        boolean result = instance.tieneEstaMatricula(matricula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVehiculoTerminado() {
        System.out.println("vehiculoTerminado");
        Vehiculo instance = null;
        instance.vehiculoTerminado();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMatricula() {
        System.out.println("getMatricula");
        Vehiculo instance = null;
        String expResult = "";
        String result = instance.getMatricula();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetModelo() {
        System.out.println("getModelo");
        Vehiculo instance = null;
        String expResult = "";
        String result = instance.getModelo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPotencia() {
        System.out.println("getPotencia");
        Vehiculo instance = null;
        double expResult = 0.0;
        double result = instance.getPotencia();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCilindros() {
        System.out.println("getCilindros");
        Vehiculo instance = null;
        int expResult = 0;
        int result = instance.getCilindros();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Vehiculo instance = null;
        boolean expResult = false;
        boolean result = instance.getEstado();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarCc() {
        System.out.println("insertarCc");
        Vehiculo instance = null;
        instance.insertarCc();
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarCilindros() {
        System.out.println("insertarCilindros");
        Vehiculo instance = null;
        instance.insertarCilindros();
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        boolean nuevoEstado = false;
        Vehiculo instance = null;
        instance.setEstado(nuevoEstado);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMostrarTodo() {
        System.out.println("mostrarTodo");
        Vehiculo instance = null;
        instance.mostrarTodo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Vehiculo instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularPrecio() {
        System.out.println("calcularPrecio");
        Vehiculo instance = null;
        double expResult = 0.0;
        double result = instance.calcularPrecio();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPagoTotal() {
        System.out.println("pagoTotal");
        Vehiculo instance = null;
        double expResult = 0.0;
        double result = instance.pagoTotal();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCilindros() {
        System.out.println("validarCilindros");
        Vehiculo instance = null;
        int expResult = 0;
        int result = instance.validarCilindros();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarVehiculo() {
        System.out.println("registrarVehiculo");
        Vehiculo instance = null;
        instance.registrarVehiculo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        Vehiculo instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    public class VehiculoImpl extends Vehiculo {

        public VehiculoImpl() {
            super(null, "", "");
        }

        public String getTipo() {
            return "";
        }

        public double calcularPrecio() {
            return 0.0;
        }

        public double pagoTotal() {
            return 0.0;
        }

        public int validarCilindros() {
            return 0;
        }

        public void registrarVehiculo() {
        }

        public double getDescuento() {
            return 0.0;
        }
    }
    
}
