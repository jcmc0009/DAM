/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bolasorpresa;

import javax.naming.spi.DirStateFactory.Result;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elena
 */
public class TestAumentarPrecio {
    
    public TestAumentarPrecio() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
     /**
     * Test of aumentarPrecio1 method, of class BolaSorpresa.
     */
    @Test
    public void testAumentarPrecio1() {
        System.out.println("aumentarPrecio");
        double aumento = 2.0;
        BolaSorpresa instance = new BolaSorpresa(10,2,5);
        instance.aumentarPrecio(aumento);
        double expResult = 4.0; //Valor esperado de la ejecución (2+1=3) 
        double result = instance.getPrecio();
        assertEquals(expResult,result,0.0001);//OJO! Importante para tipo double añadir la precisición
    }
    
         /**
     * Test of aumentarPrecio2 method, of class BolaSorpresa.
     */
    @Test
    public void testAumentarPrecio2() {
        System.out.println("aumentarPrecio");
        double aumento = 3.0;
        BolaSorpresa instance = new BolaSorpresa(10,2,5);
        instance.aumentarPrecio(aumento);
        double expResult = 5.0; //Valor esperado de la ejecución (2+1=3) 
        double result = instance.getPrecio();
        assertEquals(expResult,result,0.0001);//OJO! Importante para tipo double añadir la precisición
    }
    
         /**
     * Test of aumentarPrecio3 method, of class BolaSorpresa.
     */
    @Test
    public void testAumentarPrecio3() {
        System.out.println("aumentarPrecio3");
        double aumento = 2.0;
        BolaSorpresa instance = new BolaSorpresa(10,2,3);
        instance.aumentarPrecio(aumento);
        double expResult = 2.0; //Valor esperado de la ejecución (2+1=3) 
        double result = instance.getPrecio();
        //assertEquals(expResult,result,0.0001);//OJO! Importante para tipo double añadir la precisición
    }
    
}
