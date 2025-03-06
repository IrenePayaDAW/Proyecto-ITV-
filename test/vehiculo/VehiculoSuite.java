/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package vehiculo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author irene
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({vehiculo.CamionTest.class, vehiculo.CocheTest.class, vehiculo.TransportePersonasTest.class, vehiculo.FurgonetaTest.class, vehiculo.MicroBusTest.class, vehiculo.TransporteCargaTest.class, vehiculo.VehiculoTest.class})
public class VehiculoSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
