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
public class TransportePersonasTest {

    public TransportePersonasTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testValidarCilindros() {
        System.out.println("validarCilindros");
        TransportePersonas instance = null;
        int expResult = 0;
        int result = instance.validarCilindros();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegistrarVehiculo() {
        System.out.println("registrarVehiculo");
        TransportePersonas instance = null;
        instance.registrarVehiculo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarPlazas() {
        System.out.println("validarPlazas");
        TransportePersonas instance = null;
        int expResult = 0;
        int result = instance.validarPlazas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularAdicional() {
        System.out.println("calcularAdicional");
        TransportePersonas instance = null;
        double expResult = 0.0;
        double result = instance.calcularAdicional();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularPrecio() {
        System.out.println("calcularPrecio");
        TransportePersonas instance = null;
        double expResult = 0.0;
        double result = instance.calcularPrecio();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPlazas() {
        System.out.println("getPlazas");
        TransportePersonas instance = null;
        int expResult = 0;
        int result = instance.getPlazas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        TransportePersonas instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    public int validarPlazas() {
        return 0;
    }
}
