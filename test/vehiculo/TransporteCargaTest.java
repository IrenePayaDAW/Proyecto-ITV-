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
public class TransporteCargaTest {
    
    public TransporteCargaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRegistrarVehiculo() {
        System.out.println("registrarVehiculo");
        TransporteCarga instance = null;
        instance.registrarVehiculo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularCargoPma() {
        System.out.println("calcularCargoPma");
        TransporteCarga instance = null;
        double expResult = 0.0;
        double result = instance.calcularCargoPma();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalcularPrecio() {
        System.out.println("calcularPrecio");
        TransporteCarga instance = null;
        double expResult = 0.0;
        double result = instance.calcularPrecio();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPMA() {
        System.out.println("getPMA");
        TransporteCarga instance = null;
        double expResult = 0.0;
        double result = instance.getPMA();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    
    
}
