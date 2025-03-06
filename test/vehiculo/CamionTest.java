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
public class CamionTest {
    
    public CamionTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCalcularPrecio() {
        System.out.println("calcularPrecio");
        Camion instance = null;
        double expResult = 0.0;
        double result = instance.calcularPrecio();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Camion instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPagoTotal() {
        System.out.println("pagoTotal");
        Camion instance = null;
        double expResult = 0.0;
        double result = instance.pagoTotal();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCilindros() {
        System.out.println("validarCilindros");
        Camion instance = null;
        int expResult = 0;
        int result = instance.validarCilindros();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        Camion instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    
}
