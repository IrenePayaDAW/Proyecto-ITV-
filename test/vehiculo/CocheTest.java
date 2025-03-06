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
public class CocheTest {
    
    public CocheTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidarPlazas() {
        System.out.println("validarPlazas");
        Coche instance = null;
        int expResult = 0;
        int result = instance.validarPlazas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Coche instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPagoTotal() {
        System.out.println("pagoTotal");
        Coche instance = null;
        double expResult = 0.0;
        double result = instance.pagoTotal();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        Coche instance = null;
        double expResult = 0.0;
        double result = instance.getDescuento();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    
}
